package D0;

import E0.C0183a;
import E0.C0184b;
import E0.j;
import E0.n;
import E0.v;
import F0.AbstractC0209c;
import F0.AbstractC0220n;
import F0.C0210d;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.H;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.l;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D0.a f178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final D0.a.d f179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0184b f180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Looper f181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j f184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final com.google.android.gms.common.api.internal.b f185j;

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f186c = new C0006a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f188b;

        /* JADX INFO: renamed from: D0.e$a$a, reason: collision with other inner class name */
        public static class C0006a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private j f189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Looper f190b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f189a == null) {
                    this.f189a = new C0183a();
                }
                if (this.f190b == null) {
                    this.f190b = Looper.getMainLooper();
                }
                return new a(this.f189a, this.f190b);
            }
        }

        private a(j jVar, Account account, Looper looper) {
            this.f187a = jVar;
            this.f188b = looper;
        }
    }

    private e(Context context, Activity activity, D0.a aVar, D0.a.d dVar, a aVar2) {
        AbstractC0220n.g(context, "Null context is not permitted.");
        AbstractC0220n.g(aVar, "Api must not be null.");
        AbstractC0220n.g(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) AbstractC0220n.g(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f176a = context2;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : d(context);
        this.f177b = attributionTag;
        this.f178c = aVar;
        this.f179d = dVar;
        this.f181f = aVar2.f188b;
        C0184b c0184bA = C0184b.a(aVar, dVar, attributionTag);
        this.f180e = c0184bA;
        this.f183h = new n(this);
        com.google.android.gms.common.api.internal.b bVarT = com.google.android.gms.common.api.internal.b.t(context2);
        this.f185j = bVarT;
        this.f182g = bVarT.k();
        this.f184i = aVar2.f187a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.common.api.internal.f.u(activity, bVarT, c0184bA);
        }
        bVarT.D(this);
    }

    private final R0.d j(int i3, com.google.android.gms.common.api.internal.c cVar) {
        R0.e eVar = new R0.e();
        this.f185j.z(this, i3, cVar, eVar, this.f184i);
        return eVar.a();
    }

    protected C0210d.a b() {
        C0210d.a aVar = new C0210d.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.f176a.getClass().getName());
        aVar.b(this.f176a.getPackageName());
        return aVar;
    }

    public R0.d c(com.google.android.gms.common.api.internal.c cVar) {
        return j(2, cVar);
    }

    protected String d(Context context) {
        return null;
    }

    public final C0184b e() {
        return this.f180e;
    }

    protected String f() {
        return this.f177b;
    }

    public final int g() {
        return this.f182g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final D0.a.f h(Looper looper, l lVar) {
        C0210d c0210dA = b().a();
        D0.a.f fVarA = ((D0.a.AbstractC0005a) AbstractC0220n.f(this.f178c.a())).a(this.f176a, looper, c0210dA, this.f179d, lVar, lVar);
        String strF = f();
        if (strF != null && (fVarA instanceof AbstractC0209c)) {
            ((AbstractC0209c) fVarA).M(strF);
        }
        if (strF == null || !(fVarA instanceof E0.g)) {
            return fVarA;
        }
        H.a(fVarA);
        throw null;
    }

    public final v i(Context context, Handler handler) {
        return new v(context, handler, b().a());
    }

    public e(Context context, D0.a aVar, D0.a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }
}
