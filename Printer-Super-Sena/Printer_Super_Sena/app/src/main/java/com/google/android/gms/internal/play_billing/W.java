package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class W extends Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7379a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractC0421f0 f7381c;

    W(AbstractC0421f0 abstractC0421f0) {
        this.f7381c = abstractC0421f0;
        this.f7380b = abstractC0421f0.l();
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0401a0
    public final byte c() {
        int i3 = this.f7379a;
        if (i3 >= this.f7380b) {
            throw new NoSuchElementException();
        }
        this.f7379a = i3 + 1;
        return this.f7381c.k(i3);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7379a < this.f7380b;
    }
}
