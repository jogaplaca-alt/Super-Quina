package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0448n;
import com.google.android.gms.internal.play_billing.C0411c2;
import com.google.android.gms.internal.play_billing.C0419e2;
import com.google.android.gms.internal.play_billing.EnumC0407b2;
import com.google.android.gms.internal.play_billing.M1;
import com.google.android.gms.internal.play_billing.N1;
import com.google.android.gms.internal.play_billing.Q1;
import com.google.android.gms.internal.play_billing.R1;
import com.google.android.gms.internal.play_billing.T1;
import com.google.android.gms.internal.play_billing.X1;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7121a = 0;

    static {
        AbstractC0448n abstractC0448n = p.f7122a;
    }

    public static EnumC0407b2 a(String str) {
        return (EnumC0407b2) p.f7122a.getOrDefault(str, EnumC0407b2.BROADCAST_ACTION_UNSPECIFIED);
    }

    public static N1 b(int i3, int i4, C0394e c0394e) {
        try {
            M1 m1F = N1.F();
            T1 t1F = X1.F();
            t1F.l(c0394e.b());
            t1F.k(c0394e.a());
            t1F.m(i3);
            m1F.k(t1F);
            m1F.l(i4);
            return (N1) m1F.g();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }

    public static R1 c(int i3) {
        try {
            Q1 q1D = R1.D();
            q1D.k(i3);
            return (R1) q1D.g();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }

    public static C0419e2 d(int i3, List list) {
        try {
            C0411c2 c0411c2J = C0419e2.J();
            c0411c2J.p(3);
            c0411c2J.k(list);
            return (C0419e2) c0411c2J.g();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }
}
