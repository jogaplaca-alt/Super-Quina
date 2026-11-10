package rawbt.sdk.transport;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.util.Log;
import com.hoho.android.usbserial.driver.CdcAcmSerialDriver;
import com.hoho.android.usbserial.driver.Ch34xSerialDriver;
import com.hoho.android.usbserial.driver.Cp21xxSerialDriver;
import com.hoho.android.usbserial.driver.FtdiSerialDriver;
import com.hoho.android.usbserial.driver.ProbeTable;
import com.hoho.android.usbserial.driver.ProlificSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import java.io.IOException;
import java.util.List;
import rawbt.api.RawbtResponse;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class SerialCom implements Transport {
    private int _productId;
    private int _vendorId;
    Transport.CallBack driver = null;
    private int baud = 115200;
    private String usbSerialDriver = Constant.COM_CdcAcm;
    private boolean isConnect = false;
    UsbSerialPort port = null;
    private final Object _locker = new Object();
    private Thread _readingThread = null;
    boolean isReadCancel = true;
    private final Runnable readerReceiver = new Runnable() { // from class: rawbt.sdk.transport.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f11225a.lambda$new$0();
        }
    };

    private void Sleep(int i3) {
        try {
            Thread.sleep(i3);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    private String _connect() {
        byte b3;
        Class<? extends UsbSerialDriver> cls;
        UsbManager usbManager = (UsbManager) this.driver.getContext().getSystemService("usb");
        ProbeTable probeTable = new ProbeTable();
        switch (this.usbSerialDriver) {
            case "Prolific":
                b3 = 3;
                break;
            case "Ch34":
                b3 = 1;
                break;
            case "Cp21":
                b3 = 0;
                break;
            case "Ftdi":
                b3 = 2;
                break;
            case "CdcAcm":
                b3 = 4;
                break;
            default:
                b3 = -1;
                break;
        }
        if (b3 == 0) {
            cls = Cp21xxSerialDriver.class;
        } else if (b3 == 1) {
            cls = Ch34xSerialDriver.class;
        } else if (b3 != 2) {
            cls = b3 != 3 ? CdcAcmSerialDriver.class : ProlificSerialDriver.class;
        } else {
            cls = FtdiSerialDriver.class;
        }
        probeTable.addProduct(this._vendorId, this._productId, cls);
        List<UsbSerialDriver> listFindAllDrivers = new UsbSerialProber(probeTable).findAllDrivers(usbManager);
        if (listFindAllDrivers.isEmpty()) {
            return "not connected";
        }
        UsbSerialDriver usbSerialDriver = listFindAllDrivers.get(0);
        UsbDeviceConnection usbDeviceConnectionOpenDevice = usbManager.openDevice(usbSerialDriver.getDevice());
        if (usbDeviceConnectionOpenDevice == null) {
            return RawbtResponse.RESPONSE_ERROR;
        }
        try {
            UsbSerialPort usbSerialPort = usbSerialDriver.getPorts().get(0);
            this.port = usbSerialPort;
            usbSerialPort.open(usbDeviceConnectionOpenDevice);
            this.port.setParameters(this.baud, 8, 1, 0);
            if (this.port.isOpen()) {
                Log.w("aaa", "port is open");
            }
            StartReadingThread();
            return RawbtConstants.OK;
        } catch (IOException e3) {
            e3.printStackTrace();
            return e3.getLocalizedMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (this.port == null) {
            return;
        }
        while (!this.isReadCancel) {
            try {
                synchronized (this._locker) {
                    try {
                        byte[] bArr = new byte[1024];
                        int i3 = this.port.read(bArr, 50);
                        if (i3 > 0) {
                            byte[] bArr2 = new byte[i3];
                            System.arraycopy(bArr, 0, bArr2, 0, i3);
                            this.driver.receiveFromDevice(bArr2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Sleep(10);
            } catch (Exception e3) {
                e3.printStackTrace();
                this.isReadCancel = true;
                return;
            }
        }
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
        UsbSerialPort usbSerialPort = this.port;
        if (usbSerialPort != null) {
            try {
                usbSerialPort.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    public void setConnectParam(String str, String str2, int i3, String str3) {
        this._vendorId = Integer.parseInt(str);
        this._productId = Integer.parseInt(str2);
        this.baud = i3;
        this.usbSerialDriver = str3;
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        try {
            if (!this.isConnect) {
                String str_connect = _connect();
                if (!RawbtConstants.OK.equals(str_connect)) {
                    return str_connect;
                }
            }
            try {
                this.port.setDTR(false);
                this.port.setRTS(true);
            } catch (Exception unused) {
            }
            this.port.write(bArr, 5000);
            this.driver.sentToDevice(bArr);
            if (!this.isConnect) {
                disconnect();
            }
            return RawbtConstants.OK;
        } catch (Exception e3) {
            e3.printStackTrace();
            return e3.getLocalizedMessage();
        }
    }
}
