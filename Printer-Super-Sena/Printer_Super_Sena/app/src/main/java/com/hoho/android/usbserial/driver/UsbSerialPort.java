package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public interface UsbSerialPort extends Closeable {
    public static final int DATABITS_5 = 5;
    public static final int DATABITS_6 = 6;
    public static final int DATABITS_7 = 7;
    public static final int DATABITS_8 = 8;
    public static final int PARITY_EVEN = 2;
    public static final int PARITY_MARK = 3;
    public static final int PARITY_NONE = 0;
    public static final int PARITY_ODD = 1;
    public static final int PARITY_SPACE = 4;
    public static final int STOPBITS_1 = 1;
    public static final int STOPBITS_1_5 = 3;
    public static final int STOPBITS_2 = 2;

    public enum ControlLine {
        RTS,
        CTS,
        DTR,
        DSR,
        CD,
        RI
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Parity {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean getCD();

    boolean getCTS();

    EnumSet<ControlLine> getControlLines();

    boolean getDSR();

    boolean getDTR();

    UsbDevice getDevice();

    UsbSerialDriver getDriver();

    int getPortNumber();

    boolean getRI();

    boolean getRTS();

    UsbEndpoint getReadEndpoint();

    String getSerial();

    EnumSet<ControlLine> getSupportedControlLines();

    UsbEndpoint getWriteEndpoint();

    boolean isOpen();

    void open(UsbDeviceConnection usbDeviceConnection);

    void purgeHwBuffers(boolean z3, boolean z4);

    int read(byte[] bArr, int i3);

    void setBreak(boolean z3);

    void setDTR(boolean z3);

    void setParameters(int i3, int i4, int i5, int i6);

    void setRTS(boolean z3);

    void write(byte[] bArr, int i3);
}
