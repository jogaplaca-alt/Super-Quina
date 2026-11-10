package rawbt.sdk.transport;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
class HidBridge {
    private final String ACTION_USB_PERMISSION;
    private final Context _context;
    private final int _productId;
    private UsbDevice _usbDevice;
    private final int _vendorId;
    private Transport.CallBack callback = null;
    private int BUF_SIZE = 4096;
    private final Object _locker = new Object();
    private Thread _readingThread = null;
    private String errMess = "";
    UsbDeviceConnection uConnection = null;
    UsbEndpoint writeEp = null;
    UsbEndpoint readEp = null;
    UsbInterface dataInterface = null;
    boolean isReadCancel = true;
    private final Runnable readerReceiver = new Runnable() { // from class: rawbt.sdk.transport.HidBridge.1
        @Override // java.lang.Runnable
        public void run() {
            if (HidBridge.this._usbDevice == null) {
                HidBridge.this.Log("No device to read from");
                return;
            }
            boolean z3 = false;
            while (true) {
                HidBridge hidBridge = HidBridge.this;
                if (hidBridge.isReadCancel) {
                    return;
                }
                synchronized (hidBridge._locker) {
                    try {
                        HidBridge hidBridge2 = HidBridge.this;
                        UsbDeviceConnection usbDeviceConnection = hidBridge2.uConnection;
                        if (usbDeviceConnection == null) {
                            hidBridge2.isReadCancel = true;
                            return;
                        }
                        if (hidBridge2.readEp == null) {
                            hidBridge2.isReadCancel = true;
                            return;
                        }
                        usbDeviceConnection.claimInterface(hidBridge2.dataInterface, true);
                        if (!z3) {
                            HidBridge.this.Log("!!! Reader was started !!!");
                            z3 = true;
                        }
                        int maxPacketSize = HidBridge.this.readEp.getMaxPacketSize();
                        byte[] bArr = new byte[maxPacketSize];
                        HidBridge hidBridge3 = HidBridge.this;
                        int iBulkTransfer = hidBridge3.uConnection.bulkTransfer(hidBridge3.readEp, bArr, maxPacketSize, 50);
                        if (iBulkTransfer > 0) {
                            byte[] bArr2 = new byte[iBulkTransfer];
                            System.arraycopy(bArr, 0, bArr2, 0, iBulkTransfer);
                            if (HidBridge.this.callback != null) {
                                HidBridge.this.callback.receiveFromDevice(bArr2);
                            } else {
                                HidBridge.this._receivedQueue.add(bArr2);
                            }
                        }
                        HidBridge hidBridge4 = HidBridge.this;
                        hidBridge4.uConnection.releaseInterface(hidBridge4.dataInterface);
                    } catch (NullPointerException unused) {
                        HidBridge.this.Log("Error happened while reading. No device or the connection is busy");
                    } catch (ThreadDeath e3) {
                        HidBridge hidBridge5 = HidBridge.this;
                        UsbDeviceConnection usbDeviceConnection2 = hidBridge5.uConnection;
                        if (usbDeviceConnection2 != null) {
                            usbDeviceConnection2.releaseInterface(hidBridge5.dataInterface);
                        }
                        throw e3;
                    }
                }
                HidBridge.this.Sleep(10);
            }
        }
    };
    private final Queue<byte[]> _receivedQueue = new LinkedList();

    HidBridge(Context context, int i3, int i4) {
        this.ACTION_USB_PERMISSION = context.getPackageName() + ".USB_PERMISSION";
        this._context = context;
        this._productId = i3;
        this._vendorId = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Log(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sleep(int i3) {
        try {
            Thread.sleep(i3);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    private void StopReadingThread() {
        this.isReadCancel = true;
    }

    void CloseTheDevice() {
        StopReadingThread();
        UsbDeviceConnection usbDeviceConnection = this.uConnection;
        if (usbDeviceConnection != null) {
            usbDeviceConnection.close();
            this.uConnection = null;
        }
    }

    public byte[] GetReceivedDataFromQueue() {
        byte[] bArr;
        synchronized (this._locker) {
            try {
                int size = this._receivedQueue.size();
                Iterator<byte[]> it = this._receivedQueue.iterator();
                int length = 0;
                while (it.hasNext()) {
                    length += it.next().length;
                }
                bArr = new byte[length];
                int length2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    byte[] bArrPoll = this._receivedQueue.poll();
                    if (bArrPoll != null) {
                        System.arraycopy(bArrPoll, 0, bArr, length2, bArrPoll.length);
                        length2 += bArrPoll.length;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    public boolean IsThereAnyReceivedData() {
        boolean z3;
        synchronized (this._locker) {
            z3 = !this._receivedQueue.isEmpty();
        }
        return z3;
    }

    boolean OpenDevice() {
        UsbManager usbManager = (UsbManager) this._context.getSystemService("usb");
        if (usbManager == null) {
            this.errMess = "Can't find the USB Manager";
            return false;
        }
        this._usbDevice = null;
        for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
            if (usbDevice.getProductId() == this._productId && usbDevice.getVendorId() == this._vendorId) {
                this._usbDevice = usbDevice;
                break;
            }
        }
        UsbDevice usbDevice2 = this._usbDevice;
        if (usbDevice2 == null) {
            this.errMess = "Cannot find the device. Did you forgot to plug it?";
            return false;
        }
        if (!usbManager.hasPermission(usbDevice2)) {
            usbManager.requestPermission(this._usbDevice, PendingIntent.getBroadcast(this._context, 0, new Intent(this.ACTION_USB_PERMISSION), Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            this.errMess = "perm";
            return false;
        }
        this.uConnection = usbManager.openDevice(this._usbDevice);
        int interfaceCount = this._usbDevice.getInterfaceCount();
        if (interfaceCount > 1) {
            for (int i3 = 0; i3 < interfaceCount; i3++) {
                UsbInterface usbInterface = this._usbDevice.getInterface(i3);
                if (usbInterface.getInterfaceClass() == 7) {
                    this.dataInterface = usbInterface;
                }
            }
        }
        if (this.dataInterface == null) {
            this.dataInterface = this._usbDevice.getInterface(0);
        }
        for (int i4 = 0; i4 < this.dataInterface.getEndpointCount(); i4++) {
            UsbEndpoint endpoint = this.dataInterface.getEndpoint(i4);
            if (endpoint.getType() == 2 && endpoint.getDirection() == 0) {
                this.writeEp = endpoint;
                this.BUF_SIZE = endpoint.getMaxPacketSize();
            }
            if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                this.readEp = endpoint;
            }
        }
        return true;
    }

    public void StartReadingThread() {
        if (this._readingThread != null) {
            Log("Reading thread already started");
            return;
        }
        this.isReadCancel = false;
        Thread thread = new Thread(this.readerReceiver);
        this._readingThread = thread;
        thread.start();
    }

    boolean WriteData(byte[] bArr) {
        boolean z3;
        int length = bArr.length;
        byte[] bArr2 = new byte[this.BUF_SIZE];
        try {
            synchronized (this._locker) {
                try {
                    z3 = true;
                    this.uConnection.claimInterface(this.dataInterface, true);
                    int i3 = 0;
                    int iBulkTransfer = 0;
                    while (length > 0 && i3 < length && iBulkTransfer != -1) {
                        int iMin = Math.min(this.BUF_SIZE, length - i3);
                        System.arraycopy(bArr, i3, bArr2, 0, iMin);
                        iBulkTransfer = this.uConnection.bulkTransfer(this.writeEp, bArr2, iMin, 0);
                        i3 += iBulkTransfer;
                        if (iBulkTransfer > 0) {
                            byte[] bArr3 = new byte[iBulkTransfer];
                            System.arraycopy(bArr2, 0, bArr3, 0, iBulkTransfer);
                            this.callback.sentToDevice(bArr3);
                        }
                    }
                    if (iBulkTransfer == -1) {
                        Log("Error happened while writing data. No ACK");
                        this.errMess = "Error happened while writing data. No ACK";
                        z3 = false;
                    }
                    this.uConnection.releaseInterface(this.dataInterface);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z3;
        } catch (NullPointerException e3) {
            this.errMess = e3.getLocalizedMessage();
            Log("Error happend while writing. Could not connect to the device or interface is busy?");
            return false;
        }
    }

    String getErrMess() {
        return this.errMess;
    }

    public void injectDriver(Transport.CallBack callBack) {
        this.callback = callBack;
    }
}
