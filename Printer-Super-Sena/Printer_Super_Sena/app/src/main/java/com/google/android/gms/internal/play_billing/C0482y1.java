package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0482y1 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator f7582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0485z1 f7583b;

    C0482y1(C0485z1 c0485z1) {
        this.f7583b = c0485z1;
        this.f7582a = c0485z1.f7586a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7582a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f7582a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
