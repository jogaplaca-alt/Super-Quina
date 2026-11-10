package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0429h0 extends AbstractC0437j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f7427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7430e;

    /* synthetic */ C0429h0(byte[] bArr, int i3, int i4, boolean z3, AbstractC0425g0 abstractC0425g0) {
        super(null);
        this.f7430e = Integer.MAX_VALUE;
        this.f7427b = bArr;
        this.f7428c = 0;
    }

    public final int c(int i3) {
        int i4 = this.f7430e;
        this.f7430e = 0;
        int i5 = this.f7428c + this.f7429d;
        this.f7428c = i5;
        if (i5 > 0) {
            this.f7429d = i5;
            this.f7428c = 0;
        } else {
            this.f7429d = 0;
        }
        return i4;
    }
}
