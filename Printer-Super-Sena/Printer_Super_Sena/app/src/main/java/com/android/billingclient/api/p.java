package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0448n;
import com.google.android.gms.internal.play_billing.EnumC0407b2;
import com.google.android.gms.internal.play_billing.N1;
import com.google.android.gms.internal.play_billing.R1;
import com.google.android.gms.internal.play_billing.y2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0448n f7122a = AbstractC0448n.c("com.android.vending.billing.PURCHASES_UPDATED", EnumC0407b2.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", EnumC0407b2.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", EnumC0407b2.ALTERNATIVE_BILLING_ACTION);

    void a(N1 n3);

    void b(byte[] bArr);

    void c(int i3, List list, List list2, C0394e c0394e, boolean z3, boolean z4);

    void d(R1 r3);

    void e(int i3, List list, boolean z3, boolean z4);

    void f(y2 y2Var);
}
