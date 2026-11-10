package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProlificSerialDriver implements UsbSerialDriver {
    private static final int[] standardBaudRates = {75, 150, 300, 600, 1200, 1800, 2400, 3600, 4800, 7200, 9600, 14400, 19200, 28800, 38400, 57600, 115200, 128000, 134400, 161280, 201600, 230400, 268800, 403200, 460800, 614400, 806400, 921600, 1228800, 2457600, 3000000, 6000000};
    private final String TAG = ProlificSerialDriver.class.getSimpleName();
    private final UsbDevice mDevice;
    private final UsbSerialPort mPort;

    protected enum DeviceType {
        DEVICE_TYPE_01,
        DEVICE_TYPE_T,
        DEVICE_TYPE_HX,
        DEVICE_TYPE_HXN
    }

    class ProlificSerialPort extends CommonUsbSerialPort {
        private static final int CONTROL_DTR = 1;
        private static final int CONTROL_RTS = 2;
        private static final int CTRL_OUT_REQTYPE = 33;
        private static final int FLUSH_RX_REQUEST = 8;
        private static final int FLUSH_TX_REQUEST = 9;
        private static final int GET_CONTROL_FLAG_CD = 2;
        private static final int GET_CONTROL_FLAG_CTS = 8;
        private static final int GET_CONTROL_FLAG_DSR = 4;
        private static final int GET_CONTROL_FLAG_RI = 1;
        private static final int GET_CONTROL_HXN_FLAG_CD = 64;
        private static final int GET_CONTROL_HXN_FLAG_CTS = 8;
        private static final int GET_CONTROL_HXN_FLAG_DSR = 32;
        private static final int GET_CONTROL_HXN_FLAG_RI = 128;
        private static final int GET_CONTROL_HXN_REQUEST = 128;
        private static final int GET_CONTROL_REQUEST = 135;
        private static final int INTERRUPT_ENDPOINT = 129;
        private static final int READ_ENDPOINT = 131;
        private static final int RESET_HXN_REQUEST = 7;
        private static final int RESET_HXN_RX_PIPE = 1;
        private static final int RESET_HXN_TX_PIPE = 2;
        private static final int SEND_BREAK_REQUEST = 35;
        private static final int SET_CONTROL_REQUEST = 34;
        private static final int SET_LINE_REQUEST = 32;
        private static final int STATUS_BUFFER_SIZE = 10;
        private static final int STATUS_BYTE_IDX = 8;
        private static final int STATUS_FLAG_CD = 1;
        private static final int STATUS_FLAG_CTS = 128;
        private static final int STATUS_FLAG_DSR = 2;
        private static final int STATUS_FLAG_RI = 8;
        private static final int STATUS_NOTIFICATION = 161;
        private static final int USB_READ_TIMEOUT_MILLIS = 1000;
        private static final int USB_RECIP_INTERFACE = 1;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private static final int VENDOR_IN_REQTYPE = 192;
        private static final int VENDOR_OUT_REQTYPE = 64;
        private static final int VENDOR_READ_HXN_REQUEST = 129;
        private static final int VENDOR_READ_REQUEST = 1;
        private static final int VENDOR_WRITE_HXN_REQUEST = 128;
        private static final int VENDOR_WRITE_REQUEST = 1;
        private static final int WRITE_ENDPOINT = 2;
        private int mBaudRate;
        private int mControlLinesValue;
        private int mDataBits;
        protected DeviceType mDeviceType;
        private UsbEndpoint mInterruptEndpoint;
        private int mParity;
        private IOException mReadStatusException;
        private volatile Thread mReadStatusThread;
        private final Object mReadStatusThreadLock;
        private int mStatus;
        private int mStopBits;
        private boolean mStopReadStatusThread;

        public ProlificSerialPort(UsbDevice usbDevice, int i3) {
            super(usbDevice, i3);
            this.mDeviceType = DeviceType.DEVICE_TYPE_HX;
            this.mControlLinesValue = 0;
            this.mBaudRate = -1;
            this.mDataBits = -1;
            this.mStopBits = -1;
            this.mParity = -1;
            this.mStatus = 0;
            this.mReadStatusThread = null;
            this.mReadStatusThreadLock = new Object();
            this.mStopReadStatusThread = false;
            this.mReadStatusException = null;
        }

        private void ctrlOut(int i3, int i4, int i5, byte[] bArr) throws IOException {
            outControlTransfer(33, i3, i4, i5, bArr);
        }

        private void doBlackMagic() throws IOException {
            if (this.mDeviceType == DeviceType.DEVICE_TYPE_HXN) {
                return;
            }
            vendorIn(33924, 0, 1);
            vendorOut(1028, 0, null);
            vendorIn(33924, 0, 1);
            vendorIn(33667, 0, 1);
            vendorIn(33924, 0, 1);
            vendorOut(1028, 1, null);
            vendorIn(33924, 0, 1);
            vendorIn(33667, 0, 1);
            vendorOut(0, 1, null);
            vendorOut(1, 0, null);
            vendorOut(2, this.mDeviceType == DeviceType.DEVICE_TYPE_01 ? 36 : 68, null);
        }

        private int filterBaudRate(int i3) {
            int i4;
            int i5;
            int i6;
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i3);
            }
            if (this.mDeviceType == DeviceType.DEVICE_TYPE_HXN) {
                return i3;
            }
            for (int i7 : ProlificSerialDriver.standardBaudRates) {
                if (i7 == i3) {
                    return i3;
                }
            }
            int i8 = 384000000 / i3;
            if (i8 == 0) {
                throw new UnsupportedOperationException("Baud rate to high");
            }
            if (this.mDeviceType == DeviceType.DEVICE_TYPE_T) {
                i4 = 0;
                while (i8 >= 2048) {
                    if (i4 >= 15) {
                        throw new UnsupportedOperationException("Baud rate to low");
                    }
                    i8 >>= 1;
                    i4++;
                }
                i5 = ((((i4 & (-2)) << 12) + i8) + ((i4 & 1) << 16)) - Integer.MIN_VALUE;
                i6 = (384000000 / i8) >> i4;
            } else {
                i4 = 0;
                while (i8 >= 512) {
                    if (i4 >= 7) {
                        throw new UnsupportedOperationException("Baud rate to low");
                    }
                    i8 >>= 2;
                    i4++;
                }
                i5 = ((i4 << 9) + i8) - Integer.MIN_VALUE;
                i6 = (384000000 / i8) >> (i4 << 1);
            }
            double d3 = i6;
            double d4 = i3;
            Double.isNaN(d3);
            Double.isNaN(d4);
            double dAbs = Math.abs(1.0d - (d3 / d4));
            if (dAbs >= 0.031d) {
                throw new UnsupportedOperationException(String.format("Baud rate deviation %.1f%% is higher than allowed 3%%", Double.valueOf(dAbs * 100.0d)));
            }
            Log.d(ProlificSerialDriver.this.TAG, String.format("baud rate=%d, effective=%d, error=%.1f%%, value=0x%08x, mantissa=%d, exponent=%d", Integer.valueOf(i3), Integer.valueOf(i6), Double.valueOf(dAbs * 100.0d), Integer.valueOf(i5), Integer.valueOf(i8), Integer.valueOf(i4)));
            return i5;
        }

        private int getStatus() throws IOException {
            if (this.mReadStatusThread == null && this.mReadStatusException == null) {
                synchronized (this.mReadStatusThreadLock) {
                    try {
                        if (this.mReadStatusThread == null) {
                            this.mStatus = 0;
                            if (this.mDeviceType == DeviceType.DEVICE_TYPE_HXN) {
                                byte b3 = vendorIn(128, 0, 1)[0];
                                if ((b3 & 8) == 0) {
                                    this.mStatus |= 128;
                                }
                                if ((b3 & 32) == 0) {
                                    this.mStatus |= 2;
                                }
                                if ((b3 & 64) == 0) {
                                    this.mStatus |= 1;
                                }
                                if ((b3 & 128) == 0) {
                                    this.mStatus |= 8;
                                }
                            } else {
                                byte b4 = vendorIn(GET_CONTROL_REQUEST, 0, 1)[0];
                                if ((b4 & 8) == 0) {
                                    this.mStatus |= 128;
                                }
                                if ((b4 & 4) == 0) {
                                    this.mStatus |= 2;
                                }
                                if ((b4 & 2) == 0) {
                                    this.mStatus |= 1;
                                }
                                if ((b4 & 1) == 0) {
                                    this.mStatus |= 8;
                                }
                            }
                            this.mReadStatusThread = new Thread(new Runnable() { // from class: com.hoho.android.usbserial.driver.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f8833a.readStatusThreadFunction();
                                }
                            });
                            this.mReadStatusThread.setDaemon(true);
                            this.mReadStatusThread.start();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            IOException iOException = this.mReadStatusException;
            if (iOException == null) {
                return this.mStatus;
            }
            this.mReadStatusException = null;
            throw new IOException(iOException);
        }

        private byte[] inControlTransfer(int i3, int i4, int i5, int i6, int i7) throws IOException {
            byte[] bArr = new byte[i7];
            int iControlTransfer = this.mConnection.controlTransfer(i3, i4, i5, i6, bArr, i7, USB_READ_TIMEOUT_MILLIS);
            if (iControlTransfer == i7) {
                return bArr;
            }
            throw new IOException(String.format("ControlTransfer 0x%x failed: %d", Integer.valueOf(i5), Integer.valueOf(iControlTransfer)));
        }

        private void outControlTransfer(int i3, int i4, int i5, int i6, byte[] bArr) throws IOException {
            int length = bArr == null ? 0 : bArr.length;
            int iControlTransfer = this.mConnection.controlTransfer(i3, i4, i5, i6, bArr, length, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer != length) {
                throw new IOException(String.format("ControlTransfer 0x%x failed: %d", Integer.valueOf(i5), Integer.valueOf(iControlTransfer)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void readStatusThreadFunction() {
            while (!this.mStopReadStatusThread) {
                try {
                    byte[] bArr = new byte[10];
                    long jA = G1.a.a() + 500;
                    int iBulkTransfer = this.mConnection.bulkTransfer(this.mInterruptEndpoint, bArr, 10, 500);
                    if (iBulkTransfer == -1 && G1.a.a() < jA) {
                        testConnection();
                    }
                    if (iBulkTransfer > 0) {
                        if (iBulkTransfer != 10) {
                            throw new IOException("Invalid status notification, expected 10 bytes, got " + iBulkTransfer);
                        }
                        if (bArr[0] != -95) {
                            throw new IOException("Invalid status notification, expected 161 request, got " + ((int) bArr[0]));
                        }
                        this.mStatus = bArr[8] & 255;
                    }
                } catch (IOException e3) {
                    this.mReadStatusException = e3;
                    return;
                }
            }
        }

        private void resetDevice() throws IOException {
            purgeHwBuffers(true, true);
        }

        private void setControlLines(int i3) throws IOException {
            ctrlOut(34, i3, 0, null);
            this.mControlLinesValue = i3;
        }

        private boolean testHxStatus() {
            try {
                inControlTransfer(VENDOR_IN_REQTYPE, 1, 32896, 0, 1);
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        private boolean testStatusFlag(int i3) {
            return (getStatus() & i3) == i3;
        }

        private byte[] vendorIn(int i3, int i4, int i5) {
            return inControlTransfer(VENDOR_IN_REQTYPE, this.mDeviceType == DeviceType.DEVICE_TYPE_HXN ? 129 : 1, i3, i4, i5);
        }

        private void vendorOut(int i3, int i4, byte[] bArr) throws IOException {
            outControlTransfer(64, this.mDeviceType == DeviceType.DEVICE_TYPE_HXN ? 128 : 1, i3, i4, bArr);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        public void closeInt() {
            try {
                synchronized (this.mReadStatusThreadLock) {
                    if (this.mReadStatusThread != null) {
                        try {
                            this.mStopReadStatusThread = true;
                            this.mReadStatusThread.join();
                        } catch (Exception e3) {
                            Log.w(ProlificSerialDriver.this.TAG, "An error occured while waiting for status read thread", e3);
                        }
                        this.mStopReadStatusThread = false;
                        this.mReadStatusThread = null;
                        this.mReadStatusException = null;
                    }
                }
                resetDevice();
            } catch (Exception unused) {
            }
            try {
                this.mConnection.releaseInterface(this.mDevice.getInterface(0));
            } catch (Exception unused2) {
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCD() {
            return testStatusFlag(1);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCTS() {
            return testStatusFlag(128);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            int status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> enumSetNoneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if ((this.mControlLinesValue & 2) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 128) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if ((this.mControlLinesValue & 1) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 2) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 1) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 8) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return enumSetNoneOf;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDSR() {
            return testStatusFlag(2);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDTR() {
            return (this.mControlLinesValue & 1) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.UsbSerialPort
        public UsbSerialDriver getDriver() {
            return ProlificSerialDriver.this;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRI() {
            return testStatusFlag(8);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRTS() {
            return (this.mControlLinesValue & 2) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            UsbInterface usbInterface = this.mDevice.getInterface(0);
            if (!usbDeviceConnection.claimInterface(usbInterface, true)) {
                throw new IOException("Error claiming Prolific interface 0");
            }
            for (int i3 = 0; i3 < usbInterface.getEndpointCount(); i3++) {
                UsbEndpoint endpoint = usbInterface.getEndpoint(i3);
                int address = endpoint.getAddress();
                if (address == 2) {
                    this.mWriteEndpoint = endpoint;
                } else if (address == 129) {
                    this.mInterruptEndpoint = endpoint;
                } else if (address == READ_ENDPOINT) {
                    this.mReadEndpoint = endpoint;
                }
            }
            byte[] rawDescriptors = usbDeviceConnection.getRawDescriptors();
            if (rawDescriptors == null || rawDescriptors.length < 14) {
                throw new IOException("Could not get device descriptors");
            }
            int i4 = (rawDescriptors[3] << 8) + rawDescriptors[2];
            int i5 = (rawDescriptors[13] << 8) + rawDescriptors[12];
            byte b3 = rawDescriptors[7];
            if (this.mDevice.getDeviceClass() == 2 || b3 != 64) {
                this.mDeviceType = DeviceType.DEVICE_TYPE_01;
            } else if ((i5 == 768 && i4 == 512) || i5 == 1280) {
                this.mDeviceType = DeviceType.DEVICE_TYPE_T;
            } else if (i4 != 512 || testHxStatus()) {
                this.mDeviceType = DeviceType.DEVICE_TYPE_HX;
            } else {
                this.mDeviceType = DeviceType.DEVICE_TYPE_HXN;
            }
            resetDevice();
            doBlackMagic();
            setControlLines(this.mControlLinesValue);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.hoho.android.usbserial.driver.ProlificSerialDriver$ProlificSerialPort] */
        /* JADX WARN: Type inference failed for: r4v3, types: [int] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void purgeHwBuffers(boolean z3, boolean z4) throws IOException {
            int i3;
            ?? r4 = z3;
            if (this.mDeviceType != DeviceType.DEVICE_TYPE_HXN) {
                if (z3) {
                    vendorOut(8, 0, null);
                }
                if (z4) {
                    vendorOut(9, 0, null);
                    return;
                }
                return;
            }
            if (z4) {
                i3 = (z3 ? 1 : 0) | 2;
            }
            if (r4 == 0) {
                r4 = i3;
                return;
            } else {
                r4 = i3;
                vendorOut(7, r4, null);
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z3) throws IOException {
            ctrlOut(35, z3 ? 65535 : 0, 0, null);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z3) throws IOException {
            setControlLines(z3 ? this.mControlLinesValue | 1 : this.mControlLinesValue & (-2));
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i3, int i4, int i5, int i6) throws IOException {
            int iFilterBaudRate = filterBaudRate(i3);
            if (this.mBaudRate == iFilterBaudRate && this.mDataBits == i4 && this.mStopBits == i5 && this.mParity == i6) {
                return;
            }
            byte[] bArr = new byte[7];
            bArr[0] = (byte) (iFilterBaudRate & 255);
            bArr[1] = (byte) ((iFilterBaudRate >> 8) & 255);
            bArr[2] = (byte) ((iFilterBaudRate >> 16) & 255);
            bArr[3] = (byte) ((iFilterBaudRate >> 24) & 255);
            if (i5 == 1) {
                bArr[4] = 0;
            } else if (i5 == 2) {
                bArr[4] = 2;
            } else {
                if (i5 != 3) {
                    throw new IllegalArgumentException("Invalid stop bits: " + i5);
                }
                bArr[4] = 1;
            }
            if (i6 == 0) {
                bArr[5] = 0;
            } else if (i6 == 1) {
                bArr[5] = 1;
            } else if (i6 == 2) {
                bArr[5] = 2;
            } else if (i6 == 3) {
                bArr[5] = 3;
            } else {
                if (i6 != 4) {
                    throw new IllegalArgumentException("Invalid parity: " + i6);
                }
                bArr[5] = 4;
            }
            if (i4 < 5 || i4 > 8) {
                throw new IllegalArgumentException("Invalid data bits: " + i4);
            }
            bArr[6] = (byte) i4;
            ctrlOut(32, 0, 0, bArr);
            resetDevice();
            this.mBaudRate = iFilterBaudRate;
            this.mDataBits = i4;
            this.mStopBits = i5;
            this.mParity = i6;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z3) throws IOException {
            setControlLines(z3 ? this.mControlLinesValue | 2 : this.mControlLinesValue & (-3));
        }
    }

    public ProlificSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        this.mPort = new ProlificSerialPort(usbDevice, 0);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_PROLIFIC), new int[]{UsbId.PROLIFIC_PL2303, UsbId.PROLIFIC_PL2303GC, UsbId.PROLIFIC_PL2303GB, UsbId.PROLIFIC_PL2303GT, UsbId.PROLIFIC_PL2303GL, UsbId.PROLIFIC_PL2303GE, UsbId.PROLIFIC_PL2303GS});
        return linkedHashMap;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public List<UsbSerialPort> getPorts() {
        return Collections.singletonList(this.mPort);
    }
}
