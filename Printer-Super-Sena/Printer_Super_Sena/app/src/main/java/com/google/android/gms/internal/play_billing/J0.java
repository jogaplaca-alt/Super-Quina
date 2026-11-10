package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f7333a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f7334b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Charset f7335c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f7336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f7337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0437j0 f7338f;

    static {
        byte[] bArr = new byte[0];
        f7336d = bArr;
        f7337e = ByteBuffer.wrap(bArr);
        int i3 = AbstractC0437j0.f7455a;
        C0429h0 c0429h0 = new C0429h0(bArr, 0, 0, false, null);
        try {
            c0429h0.c(0);
            f7338f = c0429h0;
        } catch (L0 e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int a(boolean z3) {
        return z3 ? 1231 : 1237;
    }

    static int b(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }

    static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static String d(byte[] bArr) {
        return new String(bArr, f7334b);
    }
}
