package com.android.billingclient.api;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class y {
    static x a(Bundle bundle, String str, String str2) {
        C0394e c0394e = q.f7138j;
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("%s got null owned items list", str2));
            return new x(c0394e, 54);
        }
        int iB = com.google.android.gms.internal.play_billing.C.b(bundle, "BillingClient");
        String strE = com.google.android.gms.internal.play_billing.C.e(bundle, "BillingClient");
        C0394e.a aVarC = C0394e.c();
        aVarC.c(iB);
        aVarC.b(strE);
        C0394e c0394eA = aVarC.a();
        if (iB != 0) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(iB)));
            return new x(c0394eA, 23);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return new x(c0394e, 55);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
            return new x(c0394e, 56);
        }
        if (stringArrayList2 == null) {
            com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
            return new x(c0394e, 57);
        }
        if (stringArrayList3 != null) {
            return new x(q.f7140l, 1);
        }
        com.google.android.gms.internal.play_billing.C.i("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
        return new x(c0394e, 58);
    }
}
