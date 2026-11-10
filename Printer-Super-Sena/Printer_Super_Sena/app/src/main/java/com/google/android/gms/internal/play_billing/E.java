package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class E extends F implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f7318c;

    E(byte[] bArr) {
        bArr.getClass();
        this.f7318c = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.F
    public final int a() {
        byte[] bArr = this.f7318c;
        int length = bArr.length;
        if (length >= 4) {
            return ((bArr[1] & 255) << 8) | (bArr[0] & 255) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24);
        }
        throw new IllegalStateException(AbstractC0408c.a("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }

    @Override // com.google.android.gms.internal.play_billing.F
    public final int b() {
        return this.f7318c.length * 8;
    }

    @Override // com.google.android.gms.internal.play_billing.F
    final boolean c(F f3) {
        if (this.f7318c.length != f3.d().length) {
            return false;
        }
        int i3 = 0;
        boolean z3 = true;
        while (true) {
            byte[] bArr = this.f7318c;
            if (i3 >= bArr.length) {
                return z3;
            }
            z3 &= bArr[i3] == f3.d()[i3];
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.F
    final byte[] d() {
        return this.f7318c;
    }
}
