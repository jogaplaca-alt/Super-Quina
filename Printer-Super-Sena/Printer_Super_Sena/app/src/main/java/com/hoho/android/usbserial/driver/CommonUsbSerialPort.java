package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class CommonUsbSerialPort implements UsbSerialPort {
    private static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
    private static final int MAX_READ_SIZE = 16384;
    private static final String TAG = "CommonUsbSerialPort";
    protected final UsbDevice mDevice;
    protected final int mPortNumber;
    protected UsbEndpoint mReadEndpoint;
    protected UsbRequest mUsbRequest;
    protected UsbEndpoint mWriteEndpoint;
    protected UsbDeviceConnection mConnection = null;
    protected final Object mWriteBufferLock = new Object();
    protected byte[] mWriteBuffer = new byte[16384];

    public CommonUsbSerialPort(UsbDevice usbDevice, int i3) {
        this.mDevice = usbDevice;
        this.mPortNumber = i3;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mConnection == null) {
            throw new IOException("Already closed");
        }
        try {
            this.mUsbRequest.cancel();
        } catch (Exception unused) {
        }
        this.mUsbRequest = null;
        try {
            closeInt();
        } catch (Exception unused2) {
        }
        try {
            this.mConnection.close();
        } catch (Exception unused3) {
        }
        this.mConnection = null;
    }

    protected abstract void closeInt();

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getCD() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getCTS() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public abstract EnumSet<UsbSerialPort.ControlLine> getControlLines();

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getDSR() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getDTR() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public int getPortNumber() {
        return this.mPortNumber;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getRI() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean getRTS() {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public UsbEndpoint getReadEndpoint() {
        return this.mReadEndpoint;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public String getSerial() {
        return this.mConnection.getSerial();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public abstract EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines();

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public UsbEndpoint getWriteEndpoint() {
        return this.mWriteEndpoint;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public boolean isOpen() {
        return this.mConnection != null;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void open(UsbDeviceConnection usbDeviceConnection) throws Exception {
        if (this.mConnection != null) {
            throw new IOException("Already open");
        }
        if (usbDeviceConnection == null) {
            throw new IllegalArgumentException("Connection is null");
        }
        this.mConnection = usbDeviceConnection;
        try {
            openInt(usbDeviceConnection);
            if (this.mReadEndpoint == null || this.mWriteEndpoint == null) {
                throw new IOException("Could not get read & write endpoints");
            }
            UsbRequest usbRequest = new UsbRequest();
            this.mUsbRequest = usbRequest;
            usbRequest.initialize(this.mConnection, this.mReadEndpoint);
        } catch (Exception e3) {
            try {
                close();
            } catch (Exception unused) {
            }
            throw e3;
        }
    }

    protected abstract void openInt(UsbDeviceConnection usbDeviceConnection);

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void purgeHwBuffers(boolean z3, boolean z4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public int read(byte[] bArr, int i3) {
        return read(bArr, i3, true);
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void setBreak(boolean z3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void setDTR(boolean z3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public abstract void setParameters(int i3, int i4, int i5, int i6);

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void setRTS(boolean z3) {
        throw new UnsupportedOperationException();
    }

    public final void setWriteBufferSize(int i3) {
        synchronized (this.mWriteBufferLock) {
            try {
                if (i3 == this.mWriteBuffer.length) {
                    return;
                }
                this.mWriteBuffer = new byte[i3];
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void testConnection() throws IOException {
        if (this.mConnection.controlTransfer(128, 0, 0, 0, new byte[2], 2, 200) < 0) {
            throw new IOException("USB get_status request failed");
        }
    }

    public String toString() {
        return String.format("<%s device_name=%s device_id=%s port_number=%s>", getClass().getSimpleName(), this.mDevice.getDeviceName(), Integer.valueOf(this.mDevice.getDeviceId()), Integer.valueOf(this.mPortNumber));
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialPort
    public void write(byte[] bArr, int i3) throws IOException {
        int iMin;
        byte[] bArr2;
        int iA;
        int iBulkTransfer;
        long jA = i3 == 0 ? 0L : G1.a.a() + ((long) i3);
        if (this.mConnection == null) {
            throw new IOException("Connection closed");
        }
        int i4 = 0;
        while (i4 < bArr.length) {
            synchronized (this.mWriteBufferLock) {
                try {
                    iMin = Math.min(bArr.length - i4, this.mWriteBuffer.length);
                    if (i4 == 0) {
                        bArr2 = bArr;
                    } else {
                        System.arraycopy(bArr, i4, this.mWriteBuffer, 0, iMin);
                        bArr2 = this.mWriteBuffer;
                    }
                    if (i3 == 0 || i4 == 0) {
                        iA = i3;
                    } else {
                        iA = (int) (jA - G1.a.a());
                        if (iA == 0) {
                            iA = -1;
                        }
                    }
                    iBulkTransfer = iA < 0 ? -2 : this.mConnection.bulkTransfer(this.mWriteEndpoint, bArr2, iMin, iA);
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.d(TAG, "Wrote " + iBulkTransfer + "/" + iMin + " offset " + i4 + "/" + bArr.length + " timeout " + iA);
            if (iBulkTransfer <= 0) {
                if (i3 == 0 || G1.a.a() < jA) {
                    throw new IOException("Error writing " + iMin + " bytes at offset " + i4 + " of total " + bArr.length);
                }
                SerialTimeoutException serialTimeoutException = new SerialTimeoutException("Error writing " + iMin + " bytes at offset " + i4 + " of total " + bArr.length + ", rc=" + iBulkTransfer);
                ((InterruptedIOException) serialTimeoutException).bytesTransferred = i4;
                throw serialTimeoutException;
            }
            i4 += iBulkTransfer;
        }
    }

    protected int read(byte[] bArr, int i3, boolean z3) throws IOException {
        int iPosition;
        if (this.mConnection == null) {
            throw new IOException("Connection closed");
        }
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("Read buffer to small");
        }
        if (i3 != 0) {
            long jA = z3 ? G1.a.a() + ((long) i3) : 0L;
            iPosition = this.mConnection.bulkTransfer(this.mReadEndpoint, bArr, Math.min(bArr.length, 16384), i3);
            if (iPosition == -1 && z3 && G1.a.a() < jA) {
                testConnection();
            }
        } else {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            if (!this.mUsbRequest.queue(byteBufferWrap, bArr.length)) {
                throw new IOException("Queueing USB request failed");
            }
            if (this.mConnection.requestWait() == null) {
                throw new IOException("Waiting for USB request failed");
            }
            iPosition = byteBufferWrap.position();
            if (iPosition == 0) {
                testConnection();
            }
        }
        return Math.max(iPosition, 0);
    }
}
