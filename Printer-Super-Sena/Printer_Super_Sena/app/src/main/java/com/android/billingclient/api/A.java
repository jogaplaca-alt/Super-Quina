package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.AbstractC0439k;
import com.google.android.gms.internal.play_billing.C0460r0;
import com.google.android.gms.internal.play_billing.N1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class A extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ B f6993d;

    A(B b3, boolean z3) {
        this.f6993d = b3;
        this.f6991b = z3;
    }

    private final void b(Bundle bundle, C0394e c0394e, int i3) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.f6993d.f6996c.a(o.b(23, i3, c0394e));
            return;
        }
        try {
            this.f6993d.f6996c.a(N1.C(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), C0460r0.a()));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.C.i("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.f6990a) {
                return;
            }
            B b3 = this.f6993d;
            this.f6992c = b3.f6999f;
            p pVar = b3.f6996c;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                arrayList.add(o.a(intentFilter.getAction(i3)));
            }
            pVar.e(2, arrayList, false, this.f6992c);
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.f6991b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f6990a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingBroadcastManager", "Bundle is null.");
            p pVar = this.f6993d.f6996c;
            C0394e c0394e = q.f7138j;
            pVar.a(o.b(11, 1, c0394e));
            B b3 = this.f6993d;
            if (b3.f6995b != null) {
                b3.f6995b.a(c0394e, null);
                return;
            }
            return;
        }
        C0394e c0394eD = com.google.android.gms.internal.play_billing.C.d(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i3 = true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
        if (extras.getByteArray("BROADCAST_RECEIVER_LOGGING_PAYLOAD") != null) {
            try {
                this.f6993d.f6996c.b(extras.getByteArray("BROADCAST_RECEIVER_LOGGING_PAYLOAD"));
            } catch (Throwable unused) {
                com.google.android.gms.internal.play_billing.C.i("BillingBroadcastManager", "Failed parsing Api failure.");
            }
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List listG = com.google.android.gms.internal.play_billing.C.g(extras);
            if (c0394eD.b() == 0) {
                this.f6993d.f6996c.d(o.c(i3));
            } else {
                b(extras, c0394eD, i3);
            }
            this.f6993d.f6996c.c(4, AbstractC0439k.t(o.a(action)), listG, c0394eD, false, this.f6992c);
            this.f6993d.f6995b.a(c0394eD, listG);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            this.f6993d.f6996c.e(4, AbstractC0439k.t(o.a(action)), false, this.f6992c);
            if (c0394eD.b() != 0) {
                b(extras, c0394eD, i3);
                this.f6993d.f6995b.a(c0394eD, AbstractC0439k.s());
                return;
            }
            B b4 = this.f6993d;
            B.a(b4);
            B.e(b4);
            com.google.android.gms.internal.play_billing.C.i("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            p pVar2 = this.f6993d.f6996c;
            C0394e c0394e2 = q.f7138j;
            pVar2.a(o.b(77, i3, c0394e2));
            this.f6993d.f6995b.a(c0394e2, AbstractC0439k.s());
        }
    }
}
