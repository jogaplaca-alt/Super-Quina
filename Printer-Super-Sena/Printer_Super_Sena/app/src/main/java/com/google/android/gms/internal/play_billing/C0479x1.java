package com.google.android.gms.internal.play_billing;

import java.util.ListIterator;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.x1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0479x1 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ListIterator f7577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f7578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0485z1 f7579c;

    C0479x1(C0485z1 c0485z1, int i3) {
        this.f7578b = i3;
        this.f7579c = c0485z1;
        this.f7577a = c0485z1.f7586a.listIterator(i3);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f7577a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7577a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f7577a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7577a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f7577a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7577a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
