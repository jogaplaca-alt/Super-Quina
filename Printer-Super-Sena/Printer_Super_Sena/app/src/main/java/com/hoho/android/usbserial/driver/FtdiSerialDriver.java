package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FtdiSerialDriver implements UsbSerialDriver {
    private static final String TAG = FtdiSerialPort.class.getSimpleName();
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts = new ArrayList();

    public class FtdiSerialPort extends CommonUsbSerialPort {
        private static final int GET_LATENCY_TIMER_REQUEST = 10;
        private static final int GET_MODEM_STATUS_REQUEST = 5;
        private static final int MODEM_CONTROL_DTR_DISABLE = 256;
        private static final int MODEM_CONTROL_DTR_ENABLE = 257;
        private static final int MODEM_CONTROL_REQUEST = 1;
        private static final int MODEM_CONTROL_RTS_DISABLE = 512;
        private static final int MODEM_CONTROL_RTS_ENABLE = 514;
        private static final int MODEM_STATUS_CD = 128;
        private static final int MODEM_STATUS_CTS = 16;
        private static final int MODEM_STATUS_DSR = 32;
        private static final int MODEM_STATUS_RI = 64;
        private static final int READ_HEADER_LENGTH = 2;
        private static final int REQTYPE_DEVICE_TO_HOST = 192;
        private static final int REQTYPE_HOST_TO_DEVICE = 64;
        private static final int RESET_ALL = 0;
        private static final int RESET_PURGE_RX = 1;
        private static final int RESET_PURGE_TX = 2;
        private static final int RESET_REQUEST = 0;
        private static final int SET_BAUD_RATE_REQUEST = 3;
        private static final int SET_DATA_REQUEST = 4;
        private static final int SET_LATENCY_TIMER_REQUEST = 9;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private boolean baudRateWithPort;
        private int breakConfig;
        private boolean dtr;
        private boolean rts;

        public FtdiSerialPort(UsbDevice usbDevice, int i3) {
            super(usbDevice, i3);
            this.baudRateWithPort = false;
            this.dtr = false;
            this.rts = false;
            this.breakConfig = 0;
        }

        private int getStatus() throws IOException {
            byte[] bArr = new byte[2];
            int iControlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 5, 0, this.mPortNumber + 1, bArr, 2, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 2) {
                return bArr[0];
            }
            throw new IOException("Get modem status failed: result=" + iControlTransfer);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0052  */
        /* JADX WARN: Code duplicated, block: B:18:0x005b  */
        /* JADX WARN: Code duplicated, block: B:20:0x005f  */
        /* JADX WARN: Code duplicated, block: B:23:0x0065  */
        /* JADX WARN: Code duplicated, block: B:24:0x0067  */
        /* JADX WARN: Code duplicated, block: B:25:0x006a  */
        /* JADX WARN: Code duplicated, block: B:27:0x006f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0072  */
        /* JADX WARN: Code duplicated, block: B:29:0x0074  */
        /* JADX WARN: Code duplicated, block: B:32:0x007b  */
        /* JADX WARN: Code duplicated, block: B:35:0x00d5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
        /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0058. Please report as an issue. */
        /* JADX WARN: Instruction removed from duplicated block: B:36:0x00d6, please report this as an issue */
        private void setBaudrate(int i3) throws IOException {
            int i4;
            int i5;
            int i6;
            double dAbs;
            int i7;
            int i8;
            int i9;
            int i10;
            int iControlTransfer;
            if (i3 > 3500000) {
                throw new UnsupportedOperationException("Baud rate to high");
            }
            if (i3 < 2500000) {
                if (i3 >= 1750000) {
                    i6 = 2000000;
                    i5 = 1;
                } else {
                    int i11 = (48000000 / i3) + 1;
                    i4 = (i11 >> 1) & 7;
                    i5 = i11 >> 4;
                    if (i5 > 16383) {
                        throw new UnsupportedOperationException("Baud rate to low");
                    }
                    i6 = ((48000000 / ((i5 << 3) + i4)) + 1) >> 1;
                }
                double d3 = i6;
                double d4 = i3;
                Double.isNaN(d3);
                Double.isNaN(d4);
                dAbs = Math.abs(1.0d - (d3 / d4));
                if (dAbs < 0.031d) {
                    throw new UnsupportedOperationException(String.format("Baud rate deviation %.1f%% is higher than allowed 3%%", Double.valueOf(dAbs * 100.0d)));
                }
                switch (i4) {
                    case 1:
                        i7 = i5 | 49152;
                        i8 = i7;
                        i10 = 0;
                        break;
                    case 2:
                        i7 = 32768 | i5;
                        i8 = i7;
                        i10 = 0;
                        break;
                    case 3:
                        i8 = i5;
                        i10 = 1;
                        break;
                    case 4:
                        i7 = i5 | 16384;
                        i8 = i7;
                        i10 = 0;
                        break;
                    case 5:
                        i9 = i5 | 16384;
                        i8 = i9;
                        i10 = 1;
                        break;
                    case 6:
                        i9 = 32768 | i5;
                        i8 = i9;
                        i10 = 1;
                        break;
                    case 7:
                        i9 = i5 | 49152;
                        i8 = i9;
                        i10 = 1;
                        break;
                    default:
                        i8 = i5;
                        i10 = 0;
                        break;
                }
                if (this.baudRateWithPort) {
                    i10 = (i10 << 8) | (this.mPortNumber + 1);
                }
                int i12 = i10;
                Log.d(FtdiSerialDriver.TAG, String.format("baud rate=%d, effective=%d, error=%.1f%%, value=0x%04x, index=0x%04x, divisor=%d, subdivisor=%d", Integer.valueOf(i3), Integer.valueOf(i6), Double.valueOf(dAbs * 100.0d), Integer.valueOf(i8), Integer.valueOf(i12), Integer.valueOf(i5), Integer.valueOf(i4)));
                iControlTransfer = this.mConnection.controlTransfer(64, 3, i8, i12, null, 0, USB_WRITE_TIMEOUT_MILLIS);
                if (iControlTransfer == 0) {
                    return;
                }
                throw new IOException("Setting baudrate failed: result=" + iControlTransfer);
            }
            i6 = 3000000;
            i5 = 0;
            i4 = 0;
            double d5 = i6;
            double d6 = i3;
            Double.isNaN(d5);
            Double.isNaN(d6);
            dAbs = Math.abs(1.0d - (d5 / d6));
            if (dAbs < 0.031d) {
                throw new UnsupportedOperationException(String.format("Baud rate deviation %.1f%% is higher than allowed 3%%", Double.valueOf(dAbs * 100.0d)));
            }
            switch (i4) {
                case 1:
                    i7 = i5 | 49152;
                    i8 = i7;
                    i10 = 0;
                    break;
                case 2:
                    i7 = 32768 | i5;
                    i8 = i7;
                    i10 = 0;
                    break;
                case 3:
                    i8 = i5;
                    i10 = 1;
                    break;
                case 4:
                    i7 = i5 | 16384;
                    i8 = i7;
                    i10 = 0;
                    break;
                case 5:
                    i9 = i5 | 16384;
                    i8 = i9;
                    i10 = 1;
                    break;
                case 6:
                    i9 = 32768 | i5;
                    i8 = i9;
                    i10 = 1;
                    break;
                case 7:
                    i9 = i5 | 49152;
                    i8 = i9;
                    i10 = 1;
                    break;
                default:
                    i8 = i5;
                    i10 = 0;
                    break;
            }
            if (this.baudRateWithPort) {
                i10 = (i10 << 8) | (this.mPortNumber + 1);
            }
            int i13 = i10;
            Log.d(FtdiSerialDriver.TAG, String.format("baud rate=%d, effective=%d, error=%.1f%%, value=0x%04x, index=0x%04x, divisor=%d, subdivisor=%d", Integer.valueOf(i3), Integer.valueOf(i6), Double.valueOf(dAbs * 100.0d), Integer.valueOf(i8), Integer.valueOf(i13), Integer.valueOf(i5), Integer.valueOf(i4)));
            iControlTransfer = this.mConnection.controlTransfer(64, 3, i8, i13, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                return;
            }
            throw new IOException("Setting baudrate failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void closeInt() {
            try {
                this.mConnection.releaseInterface(this.mDevice.getInterface(this.mPortNumber));
            } catch (Exception unused) {
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCD() {
            return (getStatus() & MODEM_STATUS_CD) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCTS() {
            return (getStatus() & 16) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            int status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> enumSetNoneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.rts) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 16) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.dtr) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 32) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & MODEM_STATUS_CD) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 64) != 0) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return enumSetNoneOf;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDSR() {
            return (getStatus() & 32) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDTR() {
            return this.dtr;
        }

        @Override // com.hoho.android.usbserial.driver.UsbSerialPort
        public UsbSerialDriver getDriver() {
            return FtdiSerialDriver.this;
        }

        public int getLatencyTimer() throws IOException {
            byte[] bArr = new byte[1];
            int iControlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 10, 0, this.mPortNumber + 1, bArr, 1, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 1) {
                return bArr[0];
            }
            throw new IOException("Get latency timer failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRI() {
            return (getStatus() & 64) != 0;
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
            boolean z3 = true;
            if (!usbDeviceConnection.claimInterface(this.mDevice.getInterface(this.mPortNumber), true)) {
                throw new IOException("Could not claim interface " + this.mPortNumber);
            }
            if (this.mDevice.getInterface(this.mPortNumber).getEndpointCount() < 2) {
                throw new IOException("Not enough endpoints");
            }
            this.mReadEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(0);
            this.mWriteEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(1);
            int iControlTransfer = this.mConnection.controlTransfer(64, 0, 0, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer != 0) {
                throw new IOException("Reset failed: result=" + iControlTransfer);
            }
            int iControlTransfer2 = this.mConnection.controlTransfer(64, 1, (this.dtr ? MODEM_CONTROL_DTR_ENABLE : MODEM_CONTROL_DTR_DISABLE) | (this.rts ? MODEM_CONTROL_RTS_ENABLE : MODEM_CONTROL_RTS_DISABLE), this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer2 != 0) {
                throw new IOException("Init RTS,DTR failed: result=" + iControlTransfer2);
            }
            byte[] rawDescriptors = usbDeviceConnection.getRawDescriptors();
            if (rawDescriptors == null || rawDescriptors.length < 14) {
                throw new IOException("Could not get device descriptors");
            }
            byte b3 = rawDescriptors[13];
            if (b3 != 7 && b3 != 8 && b3 != 9 && this.mDevice.getInterfaceCount() <= 1) {
                z3 = false;
            }
            this.baudRateWithPort = z3;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void purgeHwBuffers(boolean z3, boolean z4) throws IOException {
            int iControlTransfer;
            int iControlTransfer2;
            if (z3 && (iControlTransfer2 = this.mConnection.controlTransfer(64, 0, 1, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS)) != 0) {
                throw new IOException("Purge write buffer failed: result=" + iControlTransfer2);
            }
            if (!z4 || (iControlTransfer = this.mConnection.controlTransfer(64, 0, 2, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS)) == 0) {
                return;
            }
            throw new IOException("Purge read buffer failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public int read(byte[] bArr, int i3) throws IOException {
            int i4;
            int i5;
            if (bArr.length <= 2) {
                throw new IllegalArgumentException("Read buffer to small");
            }
            if (i3 != 0) {
                long jA = G1.a.a() + ((long) i3);
                do {
                    i5 = super.read(bArr, Math.max(1, (int) (jA - G1.a.a())), false);
                    if (i5 != 2) {
                        break;
                    }
                } while (G1.a.a() < jA);
                if (i5 <= 0 && G1.a.a() < jA) {
                    testConnection();
                }
            } else {
                do {
                    i4 = super.read(bArr, i3, false);
                } while (i4 == 2);
                i5 = i4;
            }
            return readFilter(bArr, i5);
        }

        protected int readFilter(byte[] bArr, int i3) throws IOException {
            int maxPacketSize = this.mReadEndpoint.getMaxPacketSize();
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                int i6 = i4 + maxPacketSize;
                int i7 = i4 + 2;
                int iMin = Math.min(i6, i3) - i7;
                if (iMin < 0) {
                    throw new IOException("Expected at least 2 bytes");
                }
                System.arraycopy(bArr, i7, bArr, i5, iMin);
                i5 += iMin;
                i4 = i6;
            }
            return i5;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z3) throws IOException {
            int i3 = this.breakConfig;
            if (z3) {
                i3 |= 16384;
            }
            int iControlTransfer = this.mConnection.controlTransfer(64, 4, i3, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                return;
            }
            throw new IOException("Setting BREAK failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z3) throws IOException {
            int iControlTransfer = this.mConnection.controlTransfer(64, 1, z3 ? MODEM_CONTROL_DTR_ENABLE : MODEM_CONTROL_DTR_DISABLE, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                this.dtr = z3;
                return;
            }
            throw new IOException("Set DTR failed: result=" + iControlTransfer);
        }

        public void setLatencyTimer(int i3) throws IOException {
            int iControlTransfer = this.mConnection.controlTransfer(64, 9, i3, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                return;
            }
            throw new IOException("Set latency timer failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i3, int i4, int i5, int i6) throws IOException {
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i3);
            }
            setBaudrate(i3);
            if (i4 == 5 || i4 == 6) {
                throw new UnsupportedOperationException("Unsupported data bits: " + i4);
            }
            if (i4 != 7 && i4 != 8) {
                throw new IllegalArgumentException("Invalid data bits: " + i4);
            }
            if (i6 != 0) {
                if (i6 == 1) {
                    i4 |= MODEM_CONTROL_DTR_DISABLE;
                } else if (i6 == 2) {
                    i4 |= MODEM_CONTROL_RTS_DISABLE;
                } else if (i6 == 3) {
                    i4 |= 768;
                } else {
                    if (i6 != 4) {
                        throw new IllegalArgumentException("Invalid parity: " + i6);
                    }
                    i4 |= 1024;
                }
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                    throw new IllegalArgumentException("Invalid stop bits: " + i5);
                }
                i4 |= 4096;
            }
            int iControlTransfer = this.mConnection.controlTransfer(64, 4, i4, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                this.breakConfig = i4;
                return;
            }
            throw new IOException("Setting parameters failed: result=" + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z3) throws IOException {
            int iControlTransfer = this.mConnection.controlTransfer(64, 1, z3 ? MODEM_CONTROL_RTS_ENABLE : MODEM_CONTROL_RTS_DISABLE, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                this.rts = z3;
                return;
            }
            throw new IOException("Set DTR failed: result=" + iControlTransfer);
        }
    }

    public FtdiSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        for (int i3 = 0; i3 < usbDevice.getInterfaceCount(); i3++) {
            this.mPorts.add(new FtdiSerialPort(this.mDevice, i3));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_FTDI), new int[]{UsbId.FTDI_FT232R, UsbId.FTDI_FT232H, UsbId.FTDI_FT2232H, UsbId.FTDI_FT4232H, UsbId.FTDI_FT231X});
        return linkedHashMap;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public List<UsbSerialPort> getPorts() {
        return this.mPorts;
    }
}
