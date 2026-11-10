package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0468u extends AbstractC0451o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient AbstractC0448n f7504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient AbstractC0439k f7505d;

    C0468u(AbstractC0448n abstractC0448n, AbstractC0439k abstractC0439k) {
        this.f7504c = abstractC0448n;
        this.f7505d = abstractC0439k;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f7504c.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f7505d.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int j(Object[] objArr, int i3) {
        return this.f7505d.j(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0451o, com.google.android.gms.internal.play_billing.AbstractC0428h
    public final AbstractC0439k m() {
        return this.f7505d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f7504c.size();
    }
}
