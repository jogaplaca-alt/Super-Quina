package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0421f0 implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0421f0 f7421b = new C0409c0(J0.f7336d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator f7422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0417e0 f7423d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7424a = 0;

    static {
        int i3 = S.f7371a;
        f7423d = new C0417e0(null);
        f7422c = new X();
    }

    AbstractC0421f0() {
    }

    static int r(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i4);
        }
        throw new IndexOutOfBoundsException("End index: " + i4 + " >= " + i5);
    }

    public static AbstractC0421f0 t(byte[] bArr, int i3, int i4) {
        r(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new C0409c0(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iM = this.f7424a;
        if (iM == 0) {
            int iL = l();
            iM = m(iL, 0, iL);
            if (iM == 0) {
                iM = 1;
            }
            this.f7424a = iM;
        }
        return iM;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new W(this);
    }

    public abstract byte j(int i3);

    abstract byte k(int i3);

    public abstract int l();

    protected abstract int m(int i3, int i4, int i5);

    public abstract AbstractC0421f0 n(int i3, int i4);

    protected abstract String o(Charset charset);

    abstract void p(V v3);

    public abstract boolean q();

    protected final int s() {
        return this.f7424a;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(l()), l() <= 50 ? AbstractC0464s1.a(this) : AbstractC0464s1.a(n(0, 47)).concat("..."));
    }

    public final String u(Charset charset) {
        return l() == 0 ? "" : o(charset);
    }
}
