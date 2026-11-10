package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class r extends AbstractC0439k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final AbstractC0439k f7490f = new r(new Object[0], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient Object[] f7491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient int f7492e;

    r(Object[] objArr, int i3) {
        this.f7491d = objArr;
        this.f7492e = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        AbstractC0404b.a(i3, this.f7492e, "index");
        Object obj = this.f7491d[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0439k, com.google.android.gms.internal.play_billing.AbstractC0428h
    final int j(Object[] objArr, int i3) {
        System.arraycopy(this.f7491d, 0, objArr, 0, this.f7492e);
        return this.f7492e;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int k() {
        return this.f7492e;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int l() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final boolean n() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final Object[] o() {
        return this.f7491d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7492e;
    }
}
