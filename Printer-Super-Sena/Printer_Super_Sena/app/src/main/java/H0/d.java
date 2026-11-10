package H0;

import E0.i;
import F0.C0223q;
import F0.C0225t;
import F0.InterfaceC0224s;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class d extends D0.e implements InterfaceC0224s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final D0.a.g f1078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final D0.a.AbstractC0005a f1079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final D0.a f1080m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f1081n = 0;

    static {
        D0.a.g gVar = new D0.a.g();
        f1078k = gVar;
        c cVar = new c();
        f1079l = cVar;
        f1080m = new D0.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C0225t c0225t) {
        super(context, f1080m, c0225t, D0.e.a.f186c);
    }

    @Override // F0.InterfaceC0224s
    public final R0.d a(final C0223q c0223q) {
        com.google.android.gms.common.api.internal.c.a aVarA = com.google.android.gms.common.api.internal.c.a();
        aVarA.d(M0.d.f1292a);
        aVarA.c(false);
        aVarA.b(new i() { // from class: H0.b
            @Override // E0.i
            public final void a(Object obj, Object obj2) {
                int i3 = d.f1081n;
                ((a) ((e) obj).A()).Q(c0223q);
                ((R0.e) obj2).b(null);
            }
        });
        return c(aVarA.a());
    }
}
