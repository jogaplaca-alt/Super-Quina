package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0436j extends AbstractC0439k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient int f7452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient int f7453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractC0439k f7454f;

    C0436j(AbstractC0439k abstractC0439k, int i3, int i4) {
        this.f7454f = abstractC0439k;
        this.f7452d = i3;
        this.f7453e = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        AbstractC0404b.a(i3, this.f7453e, "index");
        return this.f7454f.get(i3 + this.f7452d);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int k() {
        return this.f7454f.l() + this.f7452d + this.f7453e;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final int l() {
        return this.f7454f.l() + this.f7452d;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final boolean n() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    final Object[] o() {
        return this.f7454f.o();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0439k
    /* JADX INFO: renamed from: p */
    public final AbstractC0439k subList(int i3, int i4) {
        AbstractC0404b.c(i3, i4, this.f7453e);
        int i5 = this.f7452d;
        return this.f7454f.subList(i3 + i5, i4 + i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7453e;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0439k, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }
}
