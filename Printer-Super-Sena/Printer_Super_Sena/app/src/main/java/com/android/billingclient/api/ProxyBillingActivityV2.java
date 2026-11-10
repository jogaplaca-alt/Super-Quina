package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
public class ProxyBillingActivityV2 extends androidx.activity.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p004b.c f7025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p004b.c f7026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ResultReceiver f7027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ResultReceiver f7028d;

    final void n(p004b.a aVar) {
        Intent intentC = aVar.c();
        int iB = com.google.android.gms.internal.play_billing.C.d(intentC, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f7027c;
        if (resultReceiver != null) {
            resultReceiver.send(iB, intentC == null ? null : intentC.getExtras());
        }
        if (aVar.d() != -1 || iB != 0) {
            com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + aVar.d() + " and billing's responseCode: " + iB);
        }
        finish();
    }

    final void o(p004b.a aVar) {
        Intent intentC = aVar.c();
        int iB = com.google.android.gms.internal.play_billing.C.d(intentC, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f7028d;
        if (resultReceiver != null) {
            resultReceiver.send(iB, intentC == null ? null : intentC.getExtras());
        }
        if (aVar.d() != -1 || iB != 0) {
            com.google.android.gms.internal.play_billing.C.i("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(aVar.d()), Integer.valueOf(iB)));
        }
        finish();
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7025a = registerForActivityResult(new p008c.f(), new p004b.b() { // from class: com.android.billingclient.api.v
            @Override // p004b.b
            public final void onActivityResult(Object obj) {
                this.f7161a.n((p004b.a) obj);
            }
        });
        this.f7026b = registerForActivityResult(new p008c.f(), new p004b.b() { // from class: com.android.billingclient.api.w
            @Override // p004b.b
            public final void onActivityResult(Object obj) {
                this.f7162a.o((p004b.a) obj);
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f7027c = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            } else {
                if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                    this.f7028d = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
                    return;
                }
                return;
            }
        }
        com.google.android.gms.internal.play_billing.C.h("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f7027c = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f7025a.a(new b.f.a(pendingIntent).a());
        } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.f7028d = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.f7026b.a(new b.f.a(pendingIntent2).a());
        }
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f7027c;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f7028d;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
