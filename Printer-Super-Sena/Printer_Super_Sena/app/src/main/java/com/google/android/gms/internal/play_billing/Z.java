package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class Z extends C0409c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7388f;

    Z(byte[] bArr, int i3, int i4) {
        super(bArr);
        AbstractC0421f0.r(0, i4, bArr.length);
        this.f7388f = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.C0409c0, com.google.android.gms.internal.play_billing.AbstractC0421f0
    public final byte j(int i3) {
        int i4 = this.f7388f;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.f7417e[i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.gms.internal.play_billing.C0409c0, com.google.android.gms.internal.play_billing.AbstractC0421f0
    final byte k(int i3) {
        return this.f7417e[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.C0409c0, com.google.android.gms.internal.play_billing.AbstractC0421f0
    public final int l() {
        return this.f7388f;
    }

    @Override // com.google.android.gms.internal.play_billing.C0409c0
    protected final int v() {
        return 0;
    }
}
