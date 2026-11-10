package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.z2;
import org.json.JSONException;
import p038k0.InterfaceC0514e;

/* JADX INFO: loaded from: classes.dex */
final class n extends z2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InterfaceC0514e f7119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final p f7120d;

    /* synthetic */ n(InterfaceC0514e interfaceC0514e, p pVar, p038k0.o oVar) {
        this.f7119c = interfaceC0514e;
        this.f7120d = pVar;
    }

    @Override // com.google.android.gms.internal.play_billing.A2
    public final void l(Bundle bundle) {
        if (bundle == null) {
            p pVar = this.f7120d;
            C0394e c0394e = q.f7138j;
            pVar.a(o.b(63, 13, c0394e));
            this.f7119c.a(c0394e, null);
            return;
        }
        int iB = com.google.android.gms.internal.play_billing.C.b(bundle, "BillingClient");
        String strE = com.google.android.gms.internal.play_billing.C.e(bundle, "BillingClient");
        C0394e.a aVarC = C0394e.c();
        aVarC.c(iB);
        aVarC.b(strE);
        if (iB != 0) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "getBillingConfig() failed. Response code: " + iB);
            C0394e c0394eA = aVarC.a();
            this.f7120d.a(o.b(23, 13, c0394eA));
            this.f7119c.a(c0394eA, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            aVarC.c(6);
            C0394e c0394eA2 = aVarC.a();
            this.f7120d.a(o.b(64, 13, c0394eA2));
            this.f7119c.a(c0394eA2, null);
            return;
        }
        try {
            this.f7119c.a(aVarC.a(), new C0392c(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e3);
            p pVar2 = this.f7120d;
            C0394e c0394e2 = q.f7138j;
            pVar2.a(o.b(65, 13, c0394e2));
            this.f7119c.a(c0394e2, null);
        }
    }
}
