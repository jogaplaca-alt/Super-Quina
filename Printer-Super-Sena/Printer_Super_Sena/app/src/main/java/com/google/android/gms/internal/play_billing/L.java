package com.google.android.gms.internal.play_billing;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class L extends A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MessageDigest f7341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7343d;

    /* synthetic */ L(MessageDigest messageDigest, int i3, K k3) {
        this.f7341b = messageDigest;
        this.f7342c = i3;
    }

    private final void d() {
        if (this.f7343d) {
            throw new IllegalStateException("Cannot re-use a Hasher after calling hash() on it");
        }
    }

    @Override // com.google.android.gms.internal.play_billing.H
    public final F b() {
        d();
        this.f7343d = true;
        int i3 = this.f7342c;
        if (i3 == this.f7341b.getDigestLength()) {
            byte[] bArrDigest = this.f7341b.digest();
            int i4 = F.f7330b;
            return new E(bArrDigest);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.f7341b.digest(), i3);
        int i5 = F.f7330b;
        return new E(bArrCopyOf);
    }

    @Override // com.google.android.gms.internal.play_billing.A
    protected final void c(byte[] bArr, int i3, int i4) {
        d();
        this.f7341b.update(bArr, 0, 2);
    }
}
