package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
abstract class F1 {
    static /* bridge */ /* synthetic */ void a(byte b3, byte b4, byte b5, byte b6, char[] cArr, int i3) throws L0 {
        if (e(b4) || (((b3 << 28) + (b4 + 112)) >> 30) != 0 || e(b5) || e(b6)) {
            throw L0.c();
        }
        int i4 = ((b3 & 7) << 18) | ((b4 & 63) << 12) | ((b5 & 63) << 6) | (b6 & 63);
        cArr[i3] = (char) ((i4 >>> 10) + 55232);
        cArr[i3 + 1] = (char) ((i4 & 1023) + 56320);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0014 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    /* JADX WARN: Code duplicated, block: B:12:0x0018 A[PHI: r2
      0x0018: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0012, B:11:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x001e  */
    static /* bridge */ /* synthetic */ void b(byte b3, byte b4, byte b5, char[] cArr, int i3) throws L0 {
        if (!e(b4)) {
            if (b3 != -32) {
                if (b3 != -19) {
                    if (!e(b5)) {
                        cArr[i3] = (char) (((b3 & 15) << 12) | ((b4 & 63) << 6) | (b5 & 63));
                        return;
                    }
                } else if (b4 < -96) {
                    b3 = -19;
                    if (!e(b5)) {
                        cArr[i3] = (char) (((b3 & 15) << 12) | ((b4 & 63) << 6) | (b5 & 63));
                        return;
                    }
                }
            } else if (b4 >= -96) {
                b3 = -32;
                if (b3 != -19) {
                    if (!e(b5)) {
                        cArr[i3] = (char) (((b3 & 15) << 12) | ((b4 & 63) << 6) | (b5 & 63));
                        return;
                    }
                } else if (b4 < -96) {
                    b3 = -19;
                    if (!e(b5)) {
                        cArr[i3] = (char) (((b3 & 15) << 12) | ((b4 & 63) << 6) | (b5 & 63));
                        return;
                    }
                }
            }
        }
        throw L0.c();
    }

    static /* bridge */ /* synthetic */ void c(byte b3, byte b4, char[] cArr, int i3) throws L0 {
        if (b3 < -62 || e(b4)) {
            throw L0.c();
        }
        cArr[i3] = (char) (((b3 & 31) << 6) | (b4 & 63));
    }

    static /* bridge */ /* synthetic */ boolean d(byte b3) {
        return b3 >= 0;
    }

    private static boolean e(byte b3) {
        return b3 > -65;
    }
}
