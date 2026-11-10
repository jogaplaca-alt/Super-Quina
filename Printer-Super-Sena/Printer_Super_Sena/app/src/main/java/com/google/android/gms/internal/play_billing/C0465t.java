package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0465t extends AbstractC0451o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient AbstractC0448n f7501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient Object[] f7502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient int f7503e;

    C0465t(AbstractC0448n abstractC0448n, Object[] objArr, int i3, int i4) {
        this.f7501c = abstractC0448n;
        this.f7502d = objArr;
        this.f7503e = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f7501c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return m().listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int j(Object[] objArr, int i3) {
        return m().j(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0451o
    final AbstractC0439k p() {
        return new C0462s(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f7503e;
    }
}
