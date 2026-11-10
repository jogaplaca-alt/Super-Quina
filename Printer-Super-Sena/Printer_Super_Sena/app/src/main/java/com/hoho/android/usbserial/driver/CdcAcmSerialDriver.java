package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CdcAcmSerialDriver implements UsbSerialDriver {
    private final UsbDevice mDevice;
    private final String TAG = CdcAcmSerialDriver.class.getSimpleName();
    private final List<UsbSerialPort> mPorts = new ArrayList();

    public class CdcAcmSerialPort extends CommonUsbSerialPort {
        private static final int GET_LINE_CODING = 33;
        private static final int SEND_BREAK = 35;
        private static final int SET_CONTROL_LINE_STATE = 34;
        private static final int SET_LINE_CODING = 32;
        private static final int USB_RECIP_INTERFACE = 1;
        private static final int USB_RT_ACM = 33;
        private UsbEndpoint mControlEndpoint;
        private int mControlIndex;
        private UsbInterface mControlInterface;
        private UsbInterface mDataInterface;
        private boolean mDtr;
        private boolean mRts;

        public CdcAcmSerialPort(UsbDevice usbDevice, int i3) {
            super(usbDevice, i3);
            this.mRts = false;
            this.mDtr = false;
        }

        private void openInterface() throws IOException {
            Log.d(CdcAcmSerialDriver.this.TAG, "claiming interfaces, count=" + this.mDevice.getInterfaceCount());
            this.mControlInterface = null;
            this.mDataInterface = null;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.mDevice.getInterfaceCount(); i5++) {
                UsbInterface usbInterface = this.mDevice.getInterface(i5);
                if (usbInterface.getInterfaceClass() == 2) {
                    if (i3 == this.mPortNumber) {
                        this.mControlIndex = i5;
                        this.mControlInterface = usbInterface;
                    }
                    i3++;
                }
                if (usbInterface.getInterfaceClass() == 10) {
                    if (i4 == this.mPortNumber) {
                        this.mDataInterface = usbInterface;
                    }
                    i4++;
                }
            }
            if (this.mControlInterface == null) {
                throw new IOException("No control interface");
            }
            Log.d(CdcAcmSerialDriver.this.TAG, "Control iface=" + this.mControlInterface);
            if (!this.mConnection.claimInterface(this.mControlInterface, true)) {
                throw new IOException("Could not claim control interface");
            }
            UsbEndpoint endpoint = this.mControlInterface.getEndpoint(0);
            this.mControlEndpoint = endpoint;
            if (endpoint.getDirection() != 128 || this.mControlEndpoint.getType() != 3) {
                throw new IOException("Invalid control endpoint");
            }
            if (this.mDataInterface == null) {
                throw new IOException("No data interface");
            }
            Log.d(CdcAcmSerialDriver.this.TAG, "data iface=" + this.mDataInterface);
            if (!this.mConnection.claimInterface(this.mDataInterface, true)) {
                throw new IOException("Could not claim data interface");
            }
            for (int i6 = 0; i6 < this.mDataInterface.getEndpointCount(); i6++) {
                UsbEndpoint endpoint2 = this.mDataInterface.getEndpoint(i6);
                if (endpoint2.getDirection() == 128 && endpoint2.getType() == 2) {
                    this.mReadEndpoint = endpoint2;
                }
                if (endpoint2.getDirection() == 0 && endpoint2.getType() == 2) {
                    this.mWriteEndpoint = endpoint2;
                }
            }
        }

        private void openSingleInterface() throws IOException {
            this.mControlIndex = 0;
            this.mControlInterface = this.mDevice.getInterface(0);
            this.mDataInterface = this.mDevice.getInterface(0);
            if (!this.mConnection.claimInterface(this.mControlInterface, true)) {
                throw new IOException("Could not claim shared control/data interface");
            }
            for (int i3 = 0; i3 < this.mControlInterface.getEndpointCount(); i3++) {
                UsbEndpoint endpoint = this.mControlInterface.getEndpoint(i3);
                if (endpoint.getDirection() == 128 && endpoint.getType() == 3) {
                    this.mControlEndpoint = endpoint;
                } else if (endpoint.getDirection() == 128 && endpoint.getType() == 2) {
                    this.mReadEndpoint = endpoint;
                } else if (endpoint.getDirection() == 0 && endpoint.getType() == 2) {
                    this.mWriteEndpoint = endpoint;
                }
            }
            if (this.mControlEndpoint == null) {
                throw new IOException("No control endpoint");
            }
        }

        private int sendAcmControlMessage(int i3, int i4, byte[] bArr) throws IOException {
            int iControlTransfer = this.mConnection.controlTransfer(33, i3, i4, this.mControlIndex, bArr, bArr != null ? bArr.length : 0, 5000);
            if (iControlTransfer >= 0) {
                return iControlTransfer;
            }
            throw new IOException("controlTransfer failed");
        }

        private void setDtrRts() throws IOException {
            sendAcmControlMessage(34, (this.mRts ? 2 : 0) | (this.mDtr ? 1 : 0), null);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void closeInt() {
            try {
                this.mConnection.releaseInterface(this.mControlInterface);
                this.mConnection.releaseInterface(this.mDataInterface);
            } catch (Exception unused) {
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() {
            EnumSet<UsbSerialPort.ControlLine> enumSetNoneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.mRts) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if (this.mDtr) {
                enumSetNoneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            return enumSetNoneOf;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getDTR() {
            return this.mDtr;
        }

        @Override // com.hoho.android.usbserial.driver.UsbSerialPort
        public UsbSerialDriver getDriver() {
            return CdcAcmSerialDriver.this;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public boolean getRTS() {
            return this.mRts;
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() {
            return EnumSet.of(UsbSerialPort.ControlLine.RTS, UsbSerialPort.ControlLine.DTR);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort
        protected void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            if (this.mPortNumber == -1) {
                Log.d(CdcAcmSerialDriver.this.TAG, "device might be castrated ACM device, trying single interface logic");
                openSingleInterface();
            } else {
                Log.d(CdcAcmSerialDriver.this.TAG, "trying default interface logic");
                openInterface();
            }
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z3) throws IOException {
            sendAcmControlMessage(35, z3 ? 65535 : 0, null);
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z3) throws IOException {
            this.mDtr = z3;
            setDtrRts();
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i3, int i4, int i5, int i6) throws IOException {
            byte b3;
            byte b4;
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i3);
            }
            if (i4 < 5 || i4 > 8) {
                throw new IllegalArgumentException("Invalid data bits: " + i4);
            }
            if (i5 == 1) {
                b3 = 0;
            } else if (i5 == 2) {
                b3 = 2;
            } else {
                if (i5 != 3) {
                    throw new IllegalArgumentException("Invalid stop bits: " + i5);
                }
                b3 = 1;
            }
            if (i6 == 0) {
                b4 = 0;
            } else if (i6 == 1) {
                b4 = 1;
            } else if (i6 == 2) {
                b4 = 2;
            } else if (i6 == 3) {
                b4 = 3;
            } else {
                if (i6 != 4) {
                    throw new IllegalArgumentException("Invalid parity: " + i6);
                }
                b4 = 4;
            }
            sendAcmControlMessage(32, 0, new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255), b3, b4, (byte) i4});
        }

        @Override // com.hoho.android.usbserial.driver.CommonUsbSerialPort, com.hoho.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z3) throws IOException {
            this.mRts = z3;
            setDtrRts();
        }
    }

    public CdcAcmSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < usbDevice.getInterfaceCount(); i5++) {
            i3 = usbDevice.getInterface(i5).getInterfaceClass() == 2 ? i3 + 1 : i3;
            if (usbDevice.getInterface(i5).getInterfaceClass() == 10) {
                i4++;
            }
        }
        for (int i6 = 0; i6 < Math.min(i3, i4); i6++) {
            this.mPorts.add(new CdcAcmSerialPort(this.mDevice, i6));
        }
        if (this.mPorts.size() == 0) {
            this.mPorts.add(new CdcAcmSerialPort(this.mDevice, -1));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_ARDUINO), new int[]{1, 67, 16, 66, 59, 68, 63, 68, UsbId.ARDUINO_LEONARDO, UsbId.ARDUINO_MICRO});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_VAN_OOIJEN_TECH), new int[]{1155});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_ATMEL), new int[]{UsbId.ATMEL_LUFA_CDC_DEMO_APP});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_LEAFLABS), new int[]{4});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_ARM), new int[]{UsbId.ARM_MBED});
        linkedHashMap.put(1155, new int[]{UsbId.ST_CDC});
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
