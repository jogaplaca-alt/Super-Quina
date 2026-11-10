package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import p038k0.InterfaceC0512c;

/* JADX INFO: loaded from: classes.dex */
final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p038k0.h f6995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f6996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final A f6997d = new A(this, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final A f6998e = new A(this, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6999f;

    B(Context context, p038k0.h hVar, p038k0.v vVar, InterfaceC0512c interfaceC0512c, p038k0.k kVar, p pVar) {
        this.f6994a = context;
        this.f6995b = hVar;
        this.f6996c = pVar;
    }

    static /* bridge */ /* synthetic */ InterfaceC0512c a(B b3) {
        b3.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ p038k0.k e(B b3) {
        b3.getClass();
        return null;
    }

    final p038k0.h d() {
        return this.f6995b;
    }

    final void f(boolean z3) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f6999f = z3;
        this.f6998e.a(this.f6994a, intentFilter2);
        if (this.f6999f) {
            z.a(this.f6994a);
        }
        this.f6997d.a(this.f6994a, intentFilter);
    }
}
