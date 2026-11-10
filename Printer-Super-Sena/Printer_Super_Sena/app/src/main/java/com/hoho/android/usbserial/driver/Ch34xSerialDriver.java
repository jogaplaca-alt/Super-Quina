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
public class Ch34xSerialDriver implements UsbSerialDriver {
    private static final int GCL_CD = 8;
    private static final int GCL_CTS = 1;
    private static final int GCL_DSR = 2;
    private static final int GCL_RI = 4;
    private static final int LCR_CS5 = 0;
    private static final int LCR_CS6 = 1;
    private static final int LCR_CS7 = 2;
    private static final int LCR_CS8 = 3;
    private static final int LCR_ENABLE_PAR = 8;
    private static final int LCR_ENABLE_RX = 128;
    private static final int LCR_ENABLE_TX = 64;
    private static final int LCR_MARK_SPACE = 32;
    private static final int LCR_PAR_EVEN = 16;
    private static final int LCR_STOP_BITS_2 = 4;
    private static final int SCL_DTR = 32;
    private static final int SCL_RTS = 64;
    private static final String TAG = "Ch34xSerialDriver";
    private final UsbDevice mDevice;
    private final UsbSerialPort mPort;

    public class Ch340SerialPort extends CommonUsbSerialPort {
        private static final int USB_TIMEOUT_MILLIS = 5000;
        private final int DEFAULT_BAUD_RATE;
        private boolean dtr;
        private boolean rts;

        public Ch340SerialPort(UsbDevice usbDevice, int i3) {
            super(usbDevice, i3);
            this.DEFAULT_BAUD_RATE = 9600;
            this.dtr = false;
            this.rts = false;
        }

        private void checkState(String str, int i3, int i4, int[] iArr) throws IOException {
            int i5;
            byte[] bArr = new byte[iArr.length];
            int iControlIn = controlIn(i3, i4, 0, bArr);
            if (iControlIn < 0) {
                throw new IOException("Failed send cmd [" + str + "]");
            }
            if (iControlIn != iArr.length) {
                throw new IOException("Expected " + iArr.length + " bytes, but get " + iControlIn + " [" + str + "]");
            }
            for (int i6 = 0; i6 < iArr.length; i6++) {
                int i7 = iArr[i6];
                if (i7 != -1 && i7 != (i5 = bArr[i6] & 255)) {
                    throw new IOException("Expected 0x" + Integer.toHexString(iArr[i6]) + " byte, but get 0x" + Integer.toHexString(i5) + " [" + str + "]");
                }
            }
        }

        private int controlIn(int i3, int i4, int i5, byte[] bArr) {
            return this.mConnection.controlTransfer(192, i3, i4, i5, bArr, bArr.length, USB_TIMEOUT_MILLIS);
        }

        private int controlOut(int i3, int i4, int i5) {
            return this.mConnection.controlTransfer(64, i3, i4, i5, null, 0, USB_TIMEOUT_MILLIS);
        }

        private byte getStatus() throws IOException {
            byte[] bArr = new byte[2];
            if (controlIn(149, 1798, 0, bArr) >= 0) {
                return bArr[0];
            }
            throw new IOException("Error getting control lines");
        }

        private void initialize() throws IOException {
            checkState("init #1", 95, 0, new int[]{-1, 0});
            if (controlOut(161, 0, 0) < 0) {
                throw new IOException("Init failed: #2");
            }
            setBaudRate(9600);
            checkState("init #4", 149, 9496, new int[]{-1, 0});
            if (controlOut(154, 9496, 195) < 0) {
                throw new IOException("Init failed: #5");
            }
            checkState("init #6", 149, 1798, new int[]{-1, -1});
            if (controlOut(161, 20511, 55562) < 0) {
                throw new IOException("Init failed: #7");
            }
            setBaudRate(9600);
            setControlLines();
            checkState("init #10", 149, 1798, new int[]{-1, -1});
        }

        private void setBaudRate(int i3) throws IOException {
            long j3;
            long j4;
            if (i3 == 921600) {
                j3 = 7;
                j4 = 62208;
            } else {
                long j5 = 1532620800 / ((long) i3);
                long j6 = 3;
                while (j5 > 65520 && j6 > 0) {
                    j5 >>= 3;
                    j6--;
                }
                if (j5 > 65520) {
                    throw new UnsupportedOperationException("Unsupported baud rate: " + i3);
                }
                long j7 = 65536 - j5;
                j3 = j6;
                j4 = j7;
            }
            int i4 = (int) (j3 | 128 | (65280 & j4));
            int i5 = (int) (j4 & 255);
            Log.d(Ch34xSerialDriver.TAG, String.format("baud rate=%d, 0x1312=0x%04x, 0x0f2c=0x%04x", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
            if (controlOut(154, 4882, i4) < 0) {
                throw new IOException("Error setting baud rate: #1)");
            }
            if (controlOut(154, 3884, i5) < 0) {
                throw new IOException("Error setting baud rate: #2");
            }
        }

        private void setControlLines() throws IOException {
            if (controlOut(164, ((this.dtr ? 32 : 0) | (this.rts ? 64 : 0)) ^ (-1), 0) < 0) {
                throw new IOException("Failed to set control lines");
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void closeInt() {
            for (int i3 = 0; i3 < this.mDevice.getInterfaceCount(); i3++) {
                try {
                    this.mConnection.releaseInterface(this.mDevice.getInterface(i3));
                } catch (Exception unused) {
                    return;
                }
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCD() {
            return (getStatus() & 8) == 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCTS() {
            return (getStatus() & 1) == 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            byte status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> enumSetNoneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.rts) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 1) == 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.dtr) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 2) == 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 8) == 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 4) == 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return enumSetNoneOf;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDSR() {
            return (getStatus() & 2) == 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDTR() {
            return this.dtr;
        }

        @Override // com.hoho.android.usbserial.driver.UsbSerialPort
        public UsbSerialDriver getDriver() {
            return Ch34xSerialDriver.this;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRI() {
            return (getStatus() & 4) == 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRTS() {
            return this.rts;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            for (int i3 = 0; i3 < this.mDevice.getInterfaceCount(); i3++) {
                if (!this.mConnection.claimInterface(this.mDevice.getInterface(i3), true)) {
                    throw new IOException("Could not claim data interface");
                }
            }
            UsbDevice usbDevice = this.mDevice;
            UsbInterface usbInterface = usbDevice.getInterface(usbDevice.getInterfaceCount() - 1);
            for (int i4 = 0; i4 < usbInterface.getEndpointCount(); i4++) {
                UsbEndpoint endpoint = usbInterface.getEndpoint(i4);
                if (endpoint.getType() == 2) {
                    if (endpoint.getDirection() == Ch34xSerialDriver.LCR_ENABLE_RX) {
                        this.mReadEndpoint = endpoint;
                    } else {
                        this.mWriteEndpoint = endpoint;
                    }
                }
            }
            initialize();
            setBaudRate(9600);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z3) throws IOException {
            byte[] bArr = new byte[2];
            if (controlIn(149, 6149, 0, bArr) < 0) {
                throw new IOException("Error getting BREAK condition");
            }
            if (z3) {
                bArr[0] = (byte) (bArr[0] & (-2));
                bArr[1] = (byte) (bArr[1] & (-65));
            } else {
                bArr[0] = (byte) (bArr[0] | 1);
                bArr[1] = (byte) (bArr[1] | 64);
            }
            if (controlOut(154, 6149, ((bArr[1] & 255) << 8) | (bArr[0] & 255)) < 0) {
                throw new IOException("Error setting BREAK condition");
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z3) throws IOException {
            this.dtr = z3;
            setControlLines();
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i3, int i4, int i5, int i6) throws IOException {
            int i7;
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i3);
            }
            setBaudRate(i3);
            if (i4 == 5) {
                i7 = 192;
            } else if (i4 == 6) {
                i7 = 193;
            } else if (i4 == 7) {
                i7 = 194;
            } else {
                if (i4 != 8) {
                    throw new IllegalArgumentException("Invalid data bits: " + i4);
                }
                i7 = 195;
            }
            if (i6 != 0) {
                if (i6 == 1) {
                    i7 |= 8;
                } else if (i6 == 2) {
                    i7 |= 24;
                } else if (i6 == 3) {
                    i7 |= 40;
                } else {
                    if (i6 != 4) {
                        throw new IllegalArgumentException("Invalid parity: " + i6);
                    }
                    i7 |= 56;
                }
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                    throw new IllegalArgumentException("Invalid stop bits: " + i5);
                }
                i7 |= 4;
            }
            if (controlOut(154, 9496, i7) < 0) {
                throw new IOException("Error setting control byte");
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z3) throws IOException {
            this.rts = z3;
            setControlLines();
        }
    }

    public Ch34xSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        this.mPort = new Ch340SerialPort(usbDevice, 0);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_QINHENG), new int[]{UsbId.QINHENG_CH340, UsbId.QINHENG_CH341A});
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
