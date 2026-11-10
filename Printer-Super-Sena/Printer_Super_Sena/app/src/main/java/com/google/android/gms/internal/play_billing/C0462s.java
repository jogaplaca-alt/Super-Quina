package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0462s extends AbstractC0439k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0465t f7500d;

    C0462s(C0465t c0465t) {
        this.f7500d = c0465t;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        AbstractC0404b.a(i3, this.f7500d.f7503e, "index");
        int i4 = i3 + i3;
        Object obj = this.f7500d.f7502d[i4];
        Objects.requireNonNull(obj);
        Object obj2 = this.f7500d.f7502d[i4 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    public final boolean n() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7500d.f7503e;
    }
}
