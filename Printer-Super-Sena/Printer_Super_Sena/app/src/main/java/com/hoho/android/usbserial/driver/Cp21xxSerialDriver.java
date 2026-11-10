package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Cp21xxSerialDriver implements UsbSerialDriver {
    private static final String TAG = "Cp21xxSerialDriver";
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts = new ArrayList();

    public class Cp21xxSerialPort extends CommonUsbSerialPort {
        private static final int DTR_DISABLE = 256;
        private static final int DTR_ENABLE = 257;
        private static final int FLUSH_READ_CODE = 10;
        private static final int FLUSH_WRITE_CODE = 5;
        private static final int REQTYPE_DEVICE_TO_HOST = 193;
        private static final int REQTYPE_HOST_TO_DEVICE = 65;
        private static final int RTS_DISABLE = 512;
        private static final int RTS_ENABLE = 514;
        private static final int SILABSER_FLUSH_REQUEST_CODE = 18;
        private static final int SILABSER_GET_MDMSTS_REQUEST_CODE = 8;
        private static final int SILABSER_IFC_ENABLE_REQUEST_CODE = 0;
        private static final int SILABSER_SET_BAUDRATE = 30;
        private static final int SILABSER_SET_BREAK_REQUEST_CODE = 5;
        private static final int SILABSER_SET_LINE_CTL_REQUEST_CODE = 3;
        private static final int SILABSER_SET_MHS_REQUEST_CODE = 7;
        private static final int STATUS_CD = 128;
        private static final int STATUS_CTS = 16;
        private static final int STATUS_DSR = 32;
        private static final int STATUS_RI = 64;
        private static final int UART_DISABLE = 0;
        private static final int UART_ENABLE = 1;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private boolean dtr;
        private boolean mIsRestrictedPort;
        private boolean rts;

        public Cp21xxSerialPort(UsbDevice usbDevice, int i3) {
            super(usbDevice, i3);
            this.dtr = false;
            this.rts = false;
        }

        private byte getStatus() throws IOException {
            byte[] bArr = new byte[1];
            int iControlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 8, 0, this.mPortNumber, bArr, 1, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 1) {
                return bArr[0];
            }
            throw new IOException("Control transfer failed: 8 / 0 -> " + iControlTransfer);
        }

        private void setBaudRate(int i3) throws IOException {
            if (this.mConnection.controlTransfer(65, 30, 0, this.mPortNumber, new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)}, 4, USB_WRITE_TIMEOUT_MILLIS) < 0) {
                throw new IOException("Error setting baud rate");
            }
        }

        private void setConfigSingle(int i3, int i4) throws IOException {
            int iControlTransfer = this.mConnection.controlTransfer(65, i3, i4, this.mPortNumber, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (iControlTransfer == 0) {
                return;
            }
            throw new IOException("Control transfer failed: " + i3 + " / " + i4 + " -> " + iControlTransfer);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void closeInt() {
            try {
                setConfigSingle(0, 0);
            } catch (Exception unused) {
            }
            try {
                this.mConnection.releaseInterface(this.mDevice.getInterface(this.mPortNumber));
            } catch (Exception unused2) {
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCD() {
            return (getStatus() & 128) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getCTS() {
            return (getStatus() & 16) != 0;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            byte status = getStatus();
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
            if ((status & 128) != 0) {
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
            return Cp21xxSerialDriver.this;
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
            this.mIsRestrictedPort = this.mDevice.getInterfaceCount() == 2 && this.mPortNumber == 1;
            if (this.mPortNumber >= this.mDevice.getInterfaceCount()) {
                throw new IOException("Unknown port number");
            }
            UsbInterface usbInterface = this.mDevice.getInterface(this.mPortNumber);
            if (!this.mConnection.claimInterface(usbInterface, true)) {
                throw new IOException("Could not claim interface " + this.mPortNumber);
            }
            for (int i3 = 0; i3 < usbInterface.getEndpointCount(); i3++) {
                UsbEndpoint endpoint = usbInterface.getEndpoint(i3);
                if (endpoint.getType() == 2) {
                    if (endpoint.getDirection() == STATUS_CD) {
                        this.mReadEndpoint = endpoint;
                    } else {
                        this.mWriteEndpoint = endpoint;
                    }
                }
            }
            setConfigSingle(0, 1);
            setConfigSingle(7, (this.dtr ? DTR_ENABLE : DTR_DISABLE) | (this.rts ? RTS_ENABLE : RTS_DISABLE));
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void purgeHwBuffers(boolean z3, boolean z4) throws IOException {
            int i3 = (z4 ? 10 : 0) | (z3 ? 5 : 0);
            if (i3 != 0) {
                setConfigSingle(18, i3);
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z3) throws IOException {
            setConfigSingle(5, z3 ? 1 : 0);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z3) throws IOException {
            this.dtr = z3;
            setConfigSingle(7, z3 ? DTR_ENABLE : DTR_DISABLE);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i3, int i4, int i5, int i6) throws IOException {
            int i7;
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i3);
            }
            setBaudRate(i3);
            if (i4 != 5) {
                if (i4 != 6) {
                    if (i4 != 7) {
                        if (i4 != 8) {
                            throw new IllegalArgumentException("Invalid data bits: " + i4);
                        }
                        i7 = 2048;
                    } else {
                        if (this.mIsRestrictedPort) {
                            throw new UnsupportedOperationException("Unsupported data bits: " + i4);
                        }
                        i7 = 1792;
                    }
                } else {
                    if (this.mIsRestrictedPort) {
                        throw new UnsupportedOperationException("Unsupported data bits: " + i4);
                    }
                    i7 = 1536;
                }
            } else {
                if (this.mIsRestrictedPort) {
                    throw new UnsupportedOperationException("Unsupported data bits: " + i4);
                }
                i7 = 1280;
            }
            if (i6 != 0) {
                if (i6 == 1) {
                    i7 |= 16;
                } else if (i6 == 2) {
                    i7 |= 32;
                } else if (i6 != 3) {
                    if (i6 != 4) {
                        throw new IllegalArgumentException("Invalid parity: " + i6);
                    }
                    if (this.mIsRestrictedPort) {
                        throw new UnsupportedOperationException("Unsupported parity: space");
                    }
                    i7 |= 64;
                } else {
                    if (this.mIsRestrictedPort) {
                        throw new UnsupportedOperationException("Unsupported parity: mark");
                    }
                    i7 |= 48;
                }
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                    throw new IllegalArgumentException("Invalid stop bits: " + i5);
                }
                if (this.mIsRestrictedPort) {
                    throw new UnsupportedOperationException("Unsupported stop bits: 2");
                }
                i7 |= 2;
            }
            setConfigSingle(3, i7);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z3) throws IOException {
            this.rts = z3;
            setConfigSingle(7, z3 ? RTS_ENABLE : RTS_DISABLE);
        }
    }

    public Cp21xxSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        for (int i3 = 0; i3 < usbDevice.getInterfaceCount(); i3++) {
            this.mPorts.add(new Cp21xxSerialPort(this.mDevice, i3));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_SILABS), new int[]{UsbId.SILABS_CP2102, UsbId.SILABS_CP2105, UsbId.SILABS_CP2108});
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
