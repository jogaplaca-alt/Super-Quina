package com.google.android.gms.common.api.internal;

import C0.C0179a;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0179a f7279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f7280b;

    n(o oVar, C0179a c0179a) {
        this.f7280b = oVar;
        this.f7279a = c0179a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.f7280b;
        l lVar = (l) oVar.f7286f.f7239j.get(oVar.f7282b);
        if (lVar == null) {
            return;
        }
        if (!this.f7279a.g()) {
            lVar.H(this.f7279a, null);
            return;
        }
        this.f7280b.f7285e = true;
        if (this.f7280b.f7281a.j()) {
            this.f7280b.i();
            return;
        }
        try {
            o oVar2 = this.f7280b;
            oVar2.f7281a.m(null, oVar2.f7281a.f());
        } catch (SecurityException e3) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e3);
            this.f7280b.f7281a.g("Failed to get service from broker.");
            lVar.H(new C0179a(10), null);
        }
    }
}
