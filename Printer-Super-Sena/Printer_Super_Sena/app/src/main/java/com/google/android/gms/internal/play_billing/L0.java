package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class L0 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0418e1 f7344a;

    public L0(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f7344a = null;
    }

    static K0 a() {
        return new K0("Protocol message tag had invalid wire type.");
    }

    static L0 b() {
        return new L0("Protocol message contained an invalid tag (zero).");
    }

    static L0 c() {
        return new L0("Protocol message had invalid UTF-8.");
    }

    static L0 d() {
        return new L0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static L0 e() {
        return new L0("Failed to parse the message.");
    }

    static L0 g() {
        return new L0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final L0 f(InterfaceC0418e1 interfaceC0418e1) {
        this.f7344a = interfaceC0418e1;
        return this;
    }

    public L0(String str) {
        super(str);
        this.f7344a = null;
    }
}
