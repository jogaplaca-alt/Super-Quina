package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f7262a;

    j(k kVar) {
        this.f7262a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f7262a.f7263a;
        lVar.f7265d.g(lVar.f7265d.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
