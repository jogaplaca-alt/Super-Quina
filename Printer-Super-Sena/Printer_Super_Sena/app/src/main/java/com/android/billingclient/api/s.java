package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.r2;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p044m0.f f7159b;

    s(Context context) {
        try {
            p050o0.t.f(context);
            this.f7159b = p050o0.t.c().g(com.google.android.datatransport.cct.a.f7172g).a("PLAY_BILLING_LIBRARY", r2.class, p044m0.b.b("proto"), new p044m0.e() { // from class: k0.u
                @Override // p044m0.e
                public final Object a(Object obj) {
                    return ((r2) obj).h();
                }
            });
        } catch (Throwable unused) {
            this.f7158a = true;
        }
    }

    public final void a(r2 r2Var) {
        if (this.f7158a) {
            com.google.android.gms.internal.play_billing.C.i("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f7159b.a(p044m0.c.d(r2Var));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.C.i("BillingLogger", "logging failed.");
        }
    }
}
