package rawbt.sdk.transport;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import rawbt.sdk.R;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class BLE implements Transport {
    private BluetoothGatt mBluetoothGatt;
    private String macAddress;
    BluetoothDevice remoteDevice;
    private final Object _locker = new Object();
    private final String N_A = "n/a";
    final String UUID_COMMON_PROFILE_SERVICE = "00001800-0000-1000-8000-00805f9b34fb";
    private final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
    Transport.CallBack driver = null;
    BluetoothGattCharacteristic wGatt = null;
    volatile int BUF_SIZE = 20;
    boolean isCommonProfileFound = false;
    final String UUID_DEVICE_NAME = "00002a00-0000-1000-8000-00805f9b34fb";
    private String deviceName = null;
    final String UUID_MANUFACTURER = "00002a29-0000-1000-8000-00805f9b34fb";
    private String deviceManufacturer = null;
    final String UUID_MODEL = "00002a24-0000-1000-8000-00805f9b34fb";
    private String deviceModel = null;
    final String UUID_SERIAL_NUMBER = "00002a25-0000-1000-8000-00805f9b34fb";
    private String deviceSerialNumber = null;
    final String UUID_FIRMWARE = "00002a26-0000-1000-8000-00805f9b34fb";
    private String deviceFirmware = null;
    final String UUID_HARDWARE = "00002a27-0000-1000-8000-00805f9b34fb";
    private String deviceHardware = null;
    final String UUID_SOFTWARE = "00002a28-0000-1000-8000-00805f9b34fb";
    private String deviceSoftware = null;
    private boolean isConnect = false;
    private List<BluetoothGattService> services = null;
    private final HashMap<String, BluetoothGattCharacteristic> readCharacteristics = new HashMap<>();
    private final HashMap<String, BluetoothGattCharacteristic> writeCharacteristics = new HashMap<>();
    private final HashMap<String, BluetoothGattCharacteristic> notifyCharacteristics = new HashMap<>();
    volatile boolean mtuWaitEnd = false;
    private volatile boolean isReadDone = false;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: rawbt.sdk.transport.BLE.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            BLE.this.onRead(bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i3);
            if (i3 == 0) {
                BLE.this.onRead(bluetoothGattCharacteristic);
            } else {
                BLE.this.driver.transportMessage("onCharacteristicRead FAIL");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i4) {
            super.onConnectionStateChange(bluetoothGatt, i3, i4);
            if (i4 == 2) {
                BLE.this.isConnect = true;
            } else if (i4 == 0) {
                BLE.this.isConnect = false;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i3, int i4) {
            super.onMtuChanged(bluetoothGatt, i3, i4);
            if (i4 == 0) {
                BLE.this.driver.transportMessage("onMtuChanged " + i3);
                BLE.this.BUF_SIZE = i3 + (-3);
            } else {
                BLE.this.driver.transportMessage("onMtuChanged FAIL");
            }
            BLE.this.mtuWaitEnd = true;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i3, int i4, int i5) {
            super.onPhyRead(bluetoothGatt, i3, i4, i5);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i3, int i4, int i5) {
            super.onPhyUpdate(bluetoothGatt, i3, i4, i5);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i3, int i4) {
            super.onReadRemoteRssi(bluetoothGatt, i3, i4);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i3) {
            super.onReliableWriteCompleted(bluetoothGatt, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServiceChanged(BluetoothGatt bluetoothGatt) {
            super.onServiceChanged(bluetoothGatt);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
            super.onServicesDiscovered(bluetoothGatt, i3);
            if (i3 != 0) {
                BLE.this.driver.transportMessage("onServicesDiscovered FAIL");
                return;
            }
            BLE ble = BLE.this;
            ble.services = ble.mBluetoothGatt.getServices();
            BLE.this.fillCharacteristic();
        }
    };

    private void btOn() {
        this.driver.transportMessage("request bt on");
        this.defaultAdapter.enable();
        int i3 = 0;
        do {
            SystemClock.sleep(10L);
            i3++;
            if (this.defaultAdapter.getState() == 12) {
                return;
            }
        } while (i3 < 500);
    }

    private boolean checkNeed(String str, UUID[] uuidArr) {
        if (uuidArr.length < 1) {
            return false;
        }
        UUID uuidFromString = UUID.fromString(str);
        for (UUID uuid : uuidArr) {
            if (uuidFromString.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    private void listenerNotify(boolean z3) {
        Transport.CallBack callBack = this.driver;
        UUID[] notifyUuid = callBack instanceof BlePrinterInterface ? ((BlePrinterInterface) callBack).getNotifyUuid() : new UUID[0];
        if (this.notifyCharacteristics.isEmpty()) {
            return;
        }
        for (Map.Entry<String, BluetoothGattCharacteristic> entry : this.notifyCharacteristics.entrySet()) {
            if (checkNeed(entry.getKey(), notifyUuid)) {
                StringBuilder sb = new StringBuilder();
                sb.append("notify from ");
                sb.append(entry.getKey());
                sb.append(z3 ? " ON" : " OFF");
                Log.i("BLE", sb.toString());
                BluetoothGattCharacteristic value = entry.getValue();
                this.mBluetoothGatt.setCharacteristicNotification(value, z3);
                for (BluetoothGattDescriptor bluetoothGattDescriptor : value.getDescriptors()) {
                    if ((value.getProperties() & 32) == 32) {
                        bluetoothGattDescriptor.setValue(z3 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    } else {
                        bluetoothGattDescriptor.setValue(z3 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    }
                    this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0017  */
    public void onRead(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte b3 = 1;
        this.isReadDone = true;
        String string = bluetoothGattCharacteristic.getUuid().toString();
        string.hashCode();
        switch (string.hashCode()) {
            case -1574446325:
                if (!string.equals("00002a28-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 0;
                }
                break;
            case -881344628:
                if (!string.equals("00002a29-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                }
                break;
            case -51885817:
                if (!string.equals("00002a24-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 2;
                }
                break;
            case 641215880:
                if (!string.equals("00002a25-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 3;
                }
                break;
            case 1334317577:
                if (!string.equals("00002a26-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 4;
                }
                break;
            case 1448042437:
                if (!string.equals("00002a00-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 5;
                }
                break;
            case 2027419274:
                if (!string.equals("00002a27-0000-1000-8000-00805f9b34fb")) {
                    b3 = -1;
                } else {
                    b3 = 6;
                }
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                this.deviceSoftware = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 1:
                this.deviceManufacturer = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 2:
                this.deviceModel = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 3:
                this.deviceSerialNumber = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 4:
                this.deviceFirmware = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 5:
                this.deviceName = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
            case 6:
                this.deviceHardware = str_from_bytes(bluetoothGattCharacteristic.getValue());
                break;
        }
        int length = bluetoothGattCharacteristic.getValue().length;
        if (length > 0) {
            byte[] bArr = new byte[length];
            System.arraycopy(bluetoothGattCharacteristic.getValue(), 0, bArr, 0, length);
            this.driver.receiveFromDevice(bArr);
        }
    }

    private void requestReadStringCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.defaultAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null || !bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {
            return;
        }
        waitRead();
    }

    private void sleep(int i3) {
        try {
            Thread.sleep(i3);
        } catch (InterruptedException unused) {
        }
    }

    private String str_from_bytes(byte[] bArr) {
        try {
            return new String(bArr, Charset.defaultCharset());
        } catch (Exception unused) {
            return null;
        }
    }

    private void waitRead() {
        this.isReadDone = false;
        for (int i3 = 0; !this.isReadDone && i3 < 400; i3++) {
            sleep(5);
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        boolean z3;
        List<BluetoothGattService> list;
        try {
            this.driver.transportMessage("BLE connect is start");
            BluetoothAdapter bluetoothAdapter = this.defaultAdapter;
            if (bluetoothAdapter == null) {
                Context context = this.driver.getContext();
                Objects.requireNonNull(context);
                return context.getString(R.string.error_no_bluetooth);
            }
            if (bluetoothAdapter.getState() != 12) {
                btOn();
            }
            if (this.defaultAdapter.getState() != 12) {
                Context context2 = this.driver.getContext();
                Objects.requireNonNull(context2);
                return context2.getString(R.string.error_bluetooth_off);
            }
            try {
                BluetoothDevice remoteDevice = this.defaultAdapter.getRemoteDevice(getMacAddress());
                this.remoteDevice = remoteDevice;
                if (remoteDevice == null) {
                    return "Device not found.  Unable to connect.";
                }
                if (remoteDevice.getType() == 1) {
                    return "Device is classic bluetooth";
                }
                int i3 = 0;
                if (Build.VERSION.SDK_INT < 31 && this.defaultAdapter.isDiscovering()) {
                    this.defaultAdapter.cancelDiscovery();
                    int i4 = 0;
                    do {
                        sleep(5);
                        i4++;
                        if (this.defaultAdapter.getState() == 12) {
                            break;
                        }
                    } while (i4 < 100);
                }
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 23) {
                    this.mBluetoothGatt = this.remoteDevice.connectGatt(this.driver.getContext(), false, this.mGattCallback, 2);
                } else {
                    this.mBluetoothGatt = this.remoteDevice.connectGatt(this.driver.getContext(), false, this.mGattCallback);
                }
                if (i5 >= 21) {
                    this.mBluetoothGatt.requestConnectionPriority(1);
                }
                int i6 = 0;
                while (true) {
                    z3 = this.isConnect;
                    if (z3 || i6 >= 1500) {
                        break;
                    }
                    sleep(10);
                    i6++;
                }
                if (!z3) {
                    return "not connected";
                }
                this.mBluetoothGatt.discoverServices();
                while (true) {
                    list = this.services;
                    if (list != null || i3 >= 1000) {
                        break;
                    }
                    sleep(5);
                    i3++;
                }
                if (list == null) {
                    return "no gatt services";
                }
                if (!(this.driver instanceof BlePrinterInterface)) {
                    return "BLE not implemented";
                }
                if (!findOutputGatt()) {
                    return "output gatt not found";
                }
                sleep(100);
                listenerNotify(true);
                this.driver.transportMessage("BLE connect done");
                sleep(400);
                return RawbtConstants.OK;
            } catch (Exception e3) {
                return e3.getLocalizedMessage();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return "exception";
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        if (this.defaultAdapter == null || this.mBluetoothGatt == null) {
            return;
        }
        listenerNotify(false);
        this.mBluetoothGatt.close();
        this.mBluetoothGatt.disconnect();
    }

    synchronized void fillCharacteristic() {
        try {
            for (BluetoothGattService bluetoothGattService : this.services) {
                if ("00001800-0000-1000-8000-00805f9b34fb".equalsIgnoreCase(bluetoothGattService.getUuid().toString())) {
                    this.isCommonProfileFound = true;
                }
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    int properties = bluetoothGattCharacteristic.getProperties();
                    if ((properties & 2) == 2) {
                        this.readCharacteristics.put(bluetoothGattCharacteristic.getUuid().toString().toLowerCase(), bluetoothGattCharacteristic);
                    }
                    if ((properties & 8) == 8 || (properties & 4) == 4) {
                        this.writeCharacteristics.put(bluetoothGattCharacteristic.getUuid().toString().toLowerCase(), bluetoothGattCharacteristic);
                    }
                    if ((properties & 16) == 16 || (properties & 32) == 32) {
                        this.notifyCharacteristics.put(bluetoothGattCharacteristic.getUuid().toString().toLowerCase(), bluetoothGattCharacteristic);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    boolean findOutputGatt() {
        if (!(this.driver instanceof BlePrinterInterface)) {
            return false;
        }
        SystemClock.sleep(250L);
        List listAsList = Arrays.asList(((BlePrinterInterface) this.driver).getWriteUuid());
        for (Map.Entry<String, BluetoothGattCharacteristic> entry : this.writeCharacteristics.entrySet()) {
            if (listAsList.contains(UUID.fromString(entry.getKey()))) {
                Log.i("BLE", "output to " + entry.getKey());
                BluetoothGattCharacteristic value = entry.getValue();
                this.wGatt = value;
                value.setWriteType(1);
                return true;
            }
        }
        return false;
    }

    public String getDeviceFirmware() {
        if (this.deviceFirmware == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a26-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceFirmware == null) {
                this.deviceFirmware = "n/a";
            }
        }
        return this.deviceFirmware;
    }

    public String getDeviceHardware() {
        if (this.deviceHardware == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a27-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceHardware == null) {
                this.deviceHardware = "n/a";
            }
        }
        return this.deviceHardware;
    }

    public String getDeviceManufacturer() {
        if (this.deviceManufacturer == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a29-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceManufacturer == null) {
                this.deviceManufacturer = "n/a";
            }
        }
        return this.deviceManufacturer;
    }

    public String getDeviceModel() {
        if (this.deviceModel == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a24-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceModel == null) {
                this.deviceModel = "n/a";
            }
        }
        return this.deviceModel;
    }

    public String getDeviceName() {
        if (this.deviceName == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a00-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceName == null) {
                this.deviceName = this.remoteDevice.getName();
            }
        }
        return this.deviceName;
    }

    public String getDeviceSerialNumber() {
        if (this.deviceSerialNumber == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a25-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceSerialNumber == null) {
                this.deviceSerialNumber = "n/a";
            }
        }
        return this.deviceSerialNumber;
    }

    public String getDeviceSoftware() {
        if (this.deviceSoftware == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.readCharacteristics.get("00002a28-0000-1000-8000-00805f9b34fb");
            if (bluetoothGattCharacteristic != null) {
                requestReadStringCharacteristic(bluetoothGattCharacteristic);
            }
            if (this.deviceSoftware == null) {
                this.deviceSoftware = "n/a";
            }
        }
        return this.deviceSoftware;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public HashMap<String, BluetoothGattCharacteristic> getNotifyCharacteristics() {
        return this.notifyCharacteristics;
    }

    public HashMap<String, BluetoothGattCharacteristic> getReadCharacteristics() {
        return this.readCharacteristics;
    }

    public HashMap<String, BluetoothGattCharacteristic> getWriteCharacteristics() {
        return this.writeCharacteristics;
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    public boolean isCommonProfileFound() {
        return this.isCommonProfileFound;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    public void setConnectParam(String str) {
        this.macAddress = str;
    }

    public void setMtu(int i3) {
        if (Build.VERSION.SDK_INT < 21 || i3 <= 22) {
            return;
        }
        this.mBluetoothGatt.requestMtu(i3);
        waitMtu();
    }

    void waitMtu() {
        this.mtuWaitEnd = false;
        for (int i3 = 0; !this.mtuWaitEnd && i3 < 100; i3++) {
            sleep(10);
        }
        Log.d("BLE", "mtuWait ended");
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        if (this.wGatt == null) {
            Log.d("BLE", "output gatt not found");
            return "output gatt not found";
        }
        synchronized (this._locker) {
            try {
                int length = bArr.length;
                byte[] bArr2 = new byte[this.BUF_SIZE];
                int i3 = 0;
                int i4 = 0;
                int length2 = 0;
                while (length > 0 && i3 < length) {
                    try {
                        int iMin = Math.min(this.BUF_SIZE, length - i3);
                        if (iMin < this.BUF_SIZE) {
                            bArr2 = new byte[iMin];
                        }
                        System.arraycopy(bArr, i3, bArr2, 0, bArr2.length);
                        this.wGatt.setValue(bArr2);
                        if (this.mBluetoothGatt.writeCharacteristic(this.wGatt)) {
                            length2 = bArr2.length;
                            i3 += length2;
                            i4 = 0;
                        } else {
                            if (i4 % 10 == 0) {
                                Log.e("BLE", "werr");
                            }
                            if (i4 > 50) {
                                Log.d("BLE", "wrc error");
                                disconnect();
                                return "wrc error";
                            }
                            sleep(100);
                            i4++;
                        }
                        if (length2 > 0) {
                            this.driver.sentToDevice(bArr2);
                            sleep(2);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        String localizedMessage = e3.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = e3.getClass().getSimpleName();
                        }
                        return localizedMessage;
                    }
                }
                sleep(4);
                return RawbtConstants.OK;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
