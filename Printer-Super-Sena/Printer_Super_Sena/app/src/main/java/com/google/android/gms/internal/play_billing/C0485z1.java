package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.z1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0485z1 extends AbstractList implements RandomAccess, O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final O0 f7586a;

    public C0485z1(O0 o3) {
        this.f7586a = o3;
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final O0 c() {
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final List f() {
        return this.f7586a.f();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        return ((N0) this.f7586a).get(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final Object h(int i3) {
        return this.f7586a.h(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.O0
    public final void i(AbstractC0421f0 abstractC0421f0) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C0482y1(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        return new C0479x1(this, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7586a.size();
    }
}
