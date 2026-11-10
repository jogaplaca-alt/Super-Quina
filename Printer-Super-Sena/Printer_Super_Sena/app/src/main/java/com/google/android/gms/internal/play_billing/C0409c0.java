package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0409c0 extends AbstractC0405b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final byte[] f7417e;

    C0409c0(byte[] bArr) {
        bArr.getClass();
        this.f7417e = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0421f0) || l() != ((AbstractC0421f0) obj).l()) {
            return false;
        }
        if (l() == 0) {
            return true;
        }
        if (!(obj instanceof C0409c0)) {
            return obj.equals(this);
        }
        C0409c0 c0409c0 = (C0409c0) obj;
        int iS = s();
        int iS2 = c0409c0.s();
        if (iS != 0 && iS2 != 0 && iS != iS2) {
            return false;
        }
        int iL = l();
        if (iL > c0409c0.l()) {
            throw new IllegalArgumentException("Length too large: " + iL + l());
        }
        if (iL > c0409c0.l()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iL + ", " + c0409c0.l());
        }
        byte[] bArr = this.f7417e;
        byte[] bArr2 = c0409c0.f7417e;
        c0409c0.v();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iL) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    public byte j(int i3) {
        return this.f7417e[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    byte k(int i3) {
        return this.f7417e[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    public int l() {
        return this.f7417e.length;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    protected final int m(int i3, int i4, int i5) {
        return J0.b(i3, this.f7417e, 0, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    public final AbstractC0421f0 n(int i3, int i4) {
        int iR = AbstractC0421f0.r(0, i4, l());
        return iR == 0 ? AbstractC0421f0.f7421b : new Z(this.f7417e, 0, iR);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    protected final String o(Charset charset) {
        return new String(this.f7417e, 0, l(), charset);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    final void p(V v3) {
        ((C0440k0) v3).A(this.f7417e, 0, l());
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0421f0
    public final boolean q() {
        return J1.e(this.f7417e, 0, l());
    }

    protected int v() {
        return 0;
    }
}
