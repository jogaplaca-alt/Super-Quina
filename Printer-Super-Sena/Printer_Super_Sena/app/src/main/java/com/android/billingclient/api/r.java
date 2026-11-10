package com.android.billingclient.api;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.play_billing.C0411c2;
import com.google.android.gms.internal.play_billing.C0419e2;
import com.google.android.gms.internal.play_billing.C0431h2;
import com.google.android.gms.internal.play_billing.C0460r0;
import com.google.android.gms.internal.play_billing.N;
import com.google.android.gms.internal.play_billing.N1;
import com.google.android.gms.internal.play_billing.R1;
import com.google.android.gms.internal.play_billing.T1;
import com.google.android.gms.internal.play_billing.X1;
import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.k2;
import com.google.android.gms.internal.play_billing.q2;
import com.google.android.gms.internal.play_billing.r2;
import com.google.android.gms.internal.play_billing.t2;
import com.google.android.gms.internal.play_billing.u2;
import com.google.android.gms.internal.play_billing.y2;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class r implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0431h2 f7155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f7157d;

    r(Context context, C0431h2 c0431h2) {
        this.f7157d = new s(context);
        this.f7155b = c0431h2;
        this.f7156c = context;
    }

    @Override // com.android.billingclient.api.p
    public final void a(N1 n3) {
        if (n3 == null) {
            return;
        }
        try {
            q2 q2VarI = r2.I();
            C0431h2 c0431h2 = this.f7155b;
            if (c0431h2 != null) {
                q2VarI.n(c0431h2);
            }
            q2VarI.k(n3);
            this.f7157d.a((r2) q2VarI.g());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.p
    public final void b(byte[] bArr) {
        try {
            g(C0419e2.C(bArr, C0460r0.a()));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.p
    public final void c(int i3, List list, List list2, C0394e c0394e, boolean z3, boolean z4) {
        C0419e2 c0419e2;
        try {
            int i4 = o.f7121a;
            try {
                C0411c2 c0411c2J = C0419e2.J();
                c0411c2J.p(4);
                c0411c2J.k(list);
                c0411c2J.o(false);
                c0411c2J.n(z4);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    Purchase purchase = (Purchase) it.next();
                    t2 t2VarF = u2.F();
                    t2VarF.k(purchase.d());
                    t2VarF.m(purchase.e());
                    t2VarF.l(purchase.c());
                    c0411c2J.l(t2VarF);
                }
                T1 t1F = X1.F();
                t1F.l(c0394e.b());
                t1F.k(c0394e.a());
                c0411c2J.m(t1F);
                c0419e2 = (C0419e2) c0411c2J.g();
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to create logging payload", e3);
                c0419e2 = null;
            }
            g(c0419e2);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.p
    public final void d(R1 r3) {
        if (r3 == null) {
            return;
        }
        try {
            q2 q2VarI = r2.I();
            C0431h2 c0431h2 = this.f7155b;
            if (c0431h2 != null) {
                q2VarI.n(c0431h2);
            }
            q2VarI.l(r3);
            this.f7157d.a((r2) q2VarI.g());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.p
    public final void e(int i3, List list, boolean z3, boolean z4) {
        C0419e2 c0419e2;
        try {
            int i4 = o.f7121a;
            try {
                C0411c2 c0411c2J = C0419e2.J();
                c0411c2J.p(i3);
                c0411c2J.o(false);
                c0411c2J.n(z4);
                c0411c2J.k(list);
                c0419e2 = (C0419e2) c0411c2J.g();
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to create logging payload", e3);
                c0419e2 = null;
            }
            g(c0419e2);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.p
    public final void f(y2 y2Var) {
        if (y2Var == null) {
            return;
        }
        try {
            q2 q2VarI = r2.I();
            C0431h2 c0431h2 = this.f7155b;
            if (c0431h2 != null) {
                q2VarI.n(c0431h2);
            }
            q2VarI.p(y2Var);
            this.f7157d.a((r2) q2VarI.g());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }

    final void g(C0419e2 c0419e2) {
        if (c0419e2 == null) {
            return;
        }
        try {
            if (this.f7155b != null) {
                try {
                    Context context = this.f7156c;
                    String string = null;
                    ContentResolver contentResolver = context == null ? null : context.getContentResolver();
                    if (contentResolver != null) {
                        string = Settings.Secure.getString(contentResolver, "android_id");
                    }
                    int iA = string == null ? 0 : com.google.android.gms.internal.play_billing.J.a().b(string).a();
                    int i3 = N.f7364b;
                    long j3 = ((long) (iA % 100)) % 100;
                    if (j3 < 0) {
                        j3 += 100;
                    }
                    if (((int) j3) < 0) {
                        q2 q2VarI = r2.I();
                        C0431h2 c0431h2 = this.f7155b;
                        if (c0431h2 != null) {
                            q2VarI.n(c0431h2);
                        }
                        q2VarI.m(c0419e2);
                        j2 j2VarD = k2.D();
                        z.a(this.f7156c);
                        j2VarD.k(false);
                        q2VarI.o(j2VarD);
                        this.f7157d.a((r2) q2VarI.g());
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.C.j("BillingLogger", "Unable to log.", th);
        }
    }
}
