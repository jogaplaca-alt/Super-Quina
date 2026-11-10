package com.hoho.android.usbserial.driver;

import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public class SerialTimeoutException extends InterruptedIOException {
    public SerialTimeoutException(String str) {
        super(str);
    }
}
