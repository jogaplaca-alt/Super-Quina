package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0471v extends AbstractC0439k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient Object[] f7508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient int f7509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f7510f;

    C0471v(Object[] objArr, int i3, int i4) {
        this.f7508d = objArr;
        this.f7509e = i3;
        this.f7510f = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        AbstractC0404b.a(i3, this.f7510f, "index");
        Object obj = this.f7508d[i3 + i3 + this.f7509e];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final boolean n() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7510f;
    }
}
