package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f7261b;

    i(l lVar, int i3) {
        this.f7261b = lVar;
        this.f7260a = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7261b.l(this.f7260a);
    }
}
