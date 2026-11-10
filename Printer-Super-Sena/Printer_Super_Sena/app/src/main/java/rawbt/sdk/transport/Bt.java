package rawbt.sdk.transport;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.net.LocalSocket;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.UUID;
import rawbt.sdk.R;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class Bt implements Transport {
    private static final int BUF_SIZE = 32375;
    private static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private BluetoothSocket createRfcommSocketToServiceRecord;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String macAddress;
    private final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
    Transport.CallBack driver = null;
    private boolean isConnect = false;
    private long totalCounter = 0;
    private final Object _locker = new Object();
    private Thread _readingThread = null;
    boolean isReadCancel = true;
    private final Runnable readerReceiver = new Runnable() { // from class: rawbt.sdk.transport.Bt.1
        @Override // java.lang.Runnable
        public void run() {
            if (Bt.this.dataInputStream == null) {
                return;
            }
            while (true) {
                try {
                    Bt bt = Bt.this;
                    if (bt.isReadCancel) {
                        return;
                    }
                    synchronized (bt._locker) {
                        try {
                            byte[] bArr = new byte[1024];
                            int inputStreamWithTimeout = P910nd.readInputStreamWithTimeout(Bt.this.dataInputStream, bArr, 50);
                            if (inputStreamWithTimeout > 0) {
                                byte[] bArr2 = new byte[inputStreamWithTimeout];
                                System.arraycopy(bArr, 0, bArr2, 0, inputStreamWithTimeout);
                                Bt.this.driver.receiveFromDevice(bArr2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Bt.this.Sleep(10);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Bt.this.isReadCancel = true;
                    return;
                }
            }
        }
    };

    /* JADX WARN: Code duplicated, block: B:67:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static synchronized void FixClose(BluetoothSocket bluetoothSocket) {
        Field declaredField;
        LocalSocket localSocket;
        Field declaredField2;
        ParcelFileDescriptor parcelFileDescriptor;
        try {
            declaredField = bluetoothSocket.getClass().getDeclaredField("mSocket");
            try {
                declaredField.setAccessible(true);
                localSocket = (LocalSocket) declaredField.get(bluetoothSocket);
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                localSocket = null;
            }
        } catch (Exception e4) {
            e = e4;
            declaredField = null;
        }
        if (localSocket != null) {
            try {
                localSocket.shutdownInput();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                localSocket.shutdownOutput();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                localSocket.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                declaredField.set(bluetoothSocket, null);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                declaredField2 = bluetoothSocket.getClass().getDeclaredField("mPfd");
                try {
                    declaredField2.setAccessible(true);
                    parcelFileDescriptor = (ParcelFileDescriptor) declaredField2.get(bluetoothSocket);
                } catch (Exception unused) {
                    parcelFileDescriptor = null;
                }
            } catch (Exception unused2) {
                declaredField2 = null;
            }
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
                try {
                    declaredField2.set(bluetoothSocket, null);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        } else {
            declaredField2 = bluetoothSocket.getClass().getDeclaredField("mPfd");
            declaredField2.setAccessible(true);
            parcelFileDescriptor = (ParcelFileDescriptor) declaredField2.get(bluetoothSocket);
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
                declaredField2.set(bluetoothSocket, null);
            }
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sleep(int i3) {
        try {
            Thread.sleep(i3);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    private String _connect() {
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
        if (Build.VERSION.SDK_INT < 31 && this.defaultAdapter.isDiscovering()) {
            this.defaultAdapter.cancelDiscovery();
        }
        try {
            BluetoothDevice remoteDevice = this.defaultAdapter.getRemoteDevice(getMacAddress());
            if (remoteDevice == null) {
                Context context3 = this.driver.getContext();
                Objects.requireNonNull(context3);
                return context3.getString(R.string.device_not_found);
            }
            try {
                try {
                    this.createRfcommSocketToServiceRecord = remoteDevice.createRfcommSocketToServiceRecord(myUUID);
                } catch (Exception unused) {
                    Context context4 = this.driver.getContext();
                    Objects.requireNonNull(context4);
                    return context4.getString(R.string.error_check_connect);
                }
            } catch (Exception unused2) {
                this.createRfcommSocketToServiceRecord = remoteDevice.createInsecureRfcommSocketToServiceRecord(myUUID);
            }
            if (remoteDevice.getBondState() != 12) {
                Context context5 = this.driver.getContext();
                Objects.requireNonNull(context5);
                showToast(context5.getString(R.string.pairing_required_for_connect));
            } else {
                Context context6 = this.driver.getContext();
                Objects.requireNonNull(context6);
                showToast(context6.getString(R.string.connecting_to_socket));
            }
            try {
                this.createRfcommSocketToServiceRecord.connect();
            } catch (IOException unused3) {
                close(null, null, this.createRfcommSocketToServiceRecord);
                if (this.driver.isCancelled()) {
                    return "Cancelled";
                }
                if (remoteDevice.getBondState() != 12) {
                    Context context7 = this.driver.getContext();
                    Objects.requireNonNull(context7);
                    return context7.getString(R.string.device_not_paired);
                }
                try {
                    showToast("alternative connect ");
                    BluetoothSocket bluetoothSocket = (BluetoothSocket) remoteDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(remoteDevice, 1);
                    this.createRfcommSocketToServiceRecord = bluetoothSocket;
                    Objects.requireNonNull(bluetoothSocket);
                    bluetoothSocket.connect();
                } catch (Exception unused4) {
                    Context context8 = this.driver.getContext();
                    Objects.requireNonNull(context8);
                    return context8.getString(R.string.error_connect);
                }
            }
            try {
                this.dataOutputStream = new DataOutputStream(this.createRfcommSocketToServiceRecord.getOutputStream());
                try {
                    this.dataInputStream = new DataInputStream(this.createRfcommSocketToServiceRecord.getInputStream());
                    StartReadingThread();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                Context context9 = this.driver.getContext();
                Objects.requireNonNull(context9);
                showToast(context9.getString(R.string.connected));
                return RawbtConstants.OK;
            } catch (Exception unused5) {
                close(null, null, this.createRfcommSocketToServiceRecord);
                Context context10 = this.driver.getContext();
                Objects.requireNonNull(context10);
                return context10.getString(R.string.error_output);
            }
        } catch (Exception e4) {
            return e4.getLocalizedMessage();
        }
    }

    private void btOn() {
        Context context = this.driver.getContext();
        Objects.requireNonNull(context);
        showToast(context.getString(R.string.request_bt_on));
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

    private static void close(DataOutputStream dataOutputStream, DataInputStream dataInputStream, BluetoothSocket bluetoothSocket) {
        try {
            Thread.sleep(1400L);
        } catch (Exception unused) {
        }
        if (dataOutputStream != null) {
            try {
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (Exception unused2) {
            }
        }
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (Exception unused3) {
            }
        }
        if (bluetoothSocket != null) {
            if (Build.VERSION.SDK_INT <= 20) {
                FixClose(bluetoothSocket);
            }
            try {
                bluetoothSocket.close();
            } catch (Exception unused4) {
            }
        }
    }

    private String getMacAddress() {
        return this.macAddress;
    }

    public void StartReadingThread() {
        if (this._readingThread == null) {
            this.isReadCancel = false;
            Thread thread = new Thread(this.readerReceiver);
            this._readingThread = thread;
            thread.start();
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return _connect();
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isReadCancel = true;
        Sleep(200);
        DataOutputStream dataOutputStream = this.dataOutputStream;
        if (dataOutputStream == null && this.dataInputStream == null) {
            return;
        }
        close(dataOutputStream, this.dataInputStream, this.createRfcommSocketToServiceRecord);
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    public void setConnectParam(String str) {
        this.macAddress = str;
    }

    void showToast(String str) {
        Transport.CallBack callBack = this.driver;
        if (callBack != null) {
            callBack.transportMessage(str);
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        if (!this.isConnect) {
            String str_connect = _connect();
            if (!RawbtConstants.OK.equals(str_connect)) {
                return str_connect;
            }
        }
        if (this.dataOutputStream != null) {
            synchronized (this._locker) {
                try {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[BUF_SIZE];
                    int i3 = 0;
                    int i4 = 0;
                    while (length > 0 && i3 < length) {
                        int iMin = Math.min(BUF_SIZE, length - i3);
                        System.arraycopy(bArr, i3, bArr2, 0, iMin);
                        try {
                            long size = this.dataOutputStream.size();
                            this.dataOutputStream.write(bArr2, 0, iMin);
                            long size2 = ((long) this.dataOutputStream.size()) - size;
                            this.totalCounter += size2;
                            int i5 = (int) size2;
                            i3 += i5;
                            if (size2 > 0) {
                                byte[] bArr3 = new byte[i5];
                                System.arraycopy(bArr2, 0, bArr3, 0, i5);
                                this.driver.sentToDevice(bArr3);
                            } else {
                                if (i4 > 25) {
                                    disconnect();
                                    Context context = this.driver.getContext();
                                    Objects.requireNonNull(context);
                                    return context.getString(R.string.output_error);
                                }
                                Thread.sleep(10L);
                                i4++;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            disconnect();
                            return e3.getLocalizedMessage();
                        }
                    }
                    try {
                        this.dataOutputStream.flush();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.isConnect) {
            return RawbtConstants.OK;
        }
        disconnect();
        return RawbtConstants.OK;
    }
}
