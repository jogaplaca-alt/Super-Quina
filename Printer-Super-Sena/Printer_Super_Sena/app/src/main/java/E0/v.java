package E0;

import C0.C0179a;
import F0.AbstractC0220n;
import F0.C0210d;
import F0.H;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class v extends Q0.d implements D0.f.a, D0.f.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final D0.a.AbstractC0005a f233j = P0.d.f1438c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final D0.a.AbstractC0005a f236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final C0210d f238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private P0.e f239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private u f240i;

    public v(Context context, Handler handler, C0210d c0210d) {
        D0.a.AbstractC0005a abstractC0005a = f233j;
        this.f234c = context;
        this.f235d = handler;
        this.f238g = (C0210d) AbstractC0220n.g(c0210d, "ClientSettings must not be null");
        this.f237f = c0210d.e();
        this.f236e = abstractC0005a;
    }

    static /* bridge */ /* synthetic */ void S(v vVar, Q0.l lVar) {
        C0179a c0179aC = lVar.c();
        if (c0179aC.g()) {
            H h3 = (H) AbstractC0220n.f(lVar.d());
            C0179a c0179aC2 = h3.c();
            if (!c0179aC2.g()) {
                String strValueOf = String.valueOf(c0179aC2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                vVar.f240i.b(c0179aC2);
                vVar.f239h.disconnect();
                return;
            }
            vVar.f240i.a(h3.d(), vVar.f237f);
        } else {
            vVar.f240i.b(c0179aC);
        }
        vVar.f239h.disconnect();
    }

    @Override // Q0.f
    public final void G(Q0.l lVar) {
        this.f235d.post(new t(this, lVar));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [D0.a$f, P0.e] */
    public final void T(u uVar) {
        P0.e eVar = this.f239h;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f238g.i(Integer.valueOf(System.identityHashCode(this)));
        D0.a.AbstractC0005a abstractC0005a = this.f236e;
        Context context = this.f234c;
        Handler handler = this.f235d;
        C0210d c0210d = this.f238g;
        this.f239h = abstractC0005a.a(context, handler.getLooper(), c0210d, c0210d.f(), this, this);
        this.f240i = uVar;
        Set set = this.f237f;
        if (set == null || set.isEmpty()) {
            this.f235d.post(new s(this));
        } else {
            this.f239h.k();
        }
    }

    public final void U() {
        P0.e eVar = this.f239h;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // E0.c
    public final void c(int i3) {
        this.f240i.d(i3);
    }

    @Override // E0.h
    public final void d(C0179a c0179a) {
        this.f240i.b(c0179a);
    }

    @Override // E0.c
    public final void e(Bundle bundle) {
        this.f239h.h(this);
    }
}
