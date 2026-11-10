package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7329a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7330b = 0;

    F() {
    }

    public abstract int a();

    public abstract int b();

    abstract boolean c(F f3);

    abstract byte[] d();

    public final boolean equals(Object obj) {
        if (obj instanceof F) {
            F f3 = (F) obj;
            if (b() == f3.b() && c(f3)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (b() >= 32) {
            return a();
        }
        byte[] bArrD = d();
        int i3 = bArrD[0] & 255;
        for (int i4 = 1; i4 < bArrD.length; i4++) {
            i3 |= (bArrD[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    public final String toString() {
        byte[] bArrD = d();
        int length = bArrD.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b3 : bArrD) {
            char[] cArr = f7329a;
            sb.append(cArr[(b3 >> 4) & 15]);
            sb.append(cArr[b3 & 15]);
        }
        return sb.toString();
    }
}
