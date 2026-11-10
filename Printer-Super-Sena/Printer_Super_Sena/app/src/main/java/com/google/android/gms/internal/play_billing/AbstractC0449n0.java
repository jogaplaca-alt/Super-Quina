package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0449n0 extends V {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f7475b = Logger.getLogger(AbstractC0449n0.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f7476c = E1.C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    C0452o0 f7477a;

    /* synthetic */ AbstractC0449n0(AbstractC0446m0 abstractC0446m0) {
    }

    static int t(int i3, InterfaceC0418e1 interfaceC0418e1, InterfaceC0456p1 interfaceC0456p1) {
        int iW = w(i3 << 3);
        return iW + iW + ((P) interfaceC0418e1).f(interfaceC0456p1);
    }

    static int u(InterfaceC0418e1 interfaceC0418e1, InterfaceC0456p1 interfaceC0456p1) {
        int iF = ((P) interfaceC0418e1).f(interfaceC0456p1);
        return w(iF) + iF;
    }

    public static int v(String str) {
        int length;
        try {
            length = J1.c(str);
        } catch (I1 unused) {
            length = str.getBytes(J0.f7334b).length;
        }
        return w(length) + length;
    }

    public static int w(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int x(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public static AbstractC0449n0 y(byte[] bArr, int i3, int i4) {
        return new C0440k0(bArr, 0, i4);
    }

    final void a(String str, I1 i3) throws C0443l0 {
        f7475b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) i3);
        byte[] bytes = str.getBytes(J0.f7334b);
        try {
            int length = bytes.length;
            q(length);
            m(bytes, 0, length);
        } catch (IndexOutOfBoundsException e3) {
            throw new C0443l0(e3);
        }
    }

    public abstract int c();

    public abstract void d(byte b3);

    public abstract void e(int i3, boolean z3);

    public abstract void f(int i3, AbstractC0421f0 abstractC0421f0);

    public abstract void g(int i3, int i4);

    public abstract void h(int i3);

    public abstract void i(int i3, long j3);

    public abstract void j(long j3);

    public abstract void k(int i3, int i4);

    public abstract void l(int i3);

    public abstract void m(byte[] bArr, int i3, int i4);

    public abstract void n(int i3, String str);

    public abstract void o(int i3, int i4);

    public abstract void p(int i3, int i4);

    public abstract void q(int i3);

    public abstract void r(int i3, long j3);

    public abstract void s(long j3);

    public final void z() {
        if (c() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
