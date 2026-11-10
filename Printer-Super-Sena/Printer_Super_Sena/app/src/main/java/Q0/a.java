package Q0;

import C0.C0179a;
import F0.AbstractC0209c;
import F0.AbstractC0213g;
import F0.AbstractC0220n;
import F0.C0210d;
import F0.F;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a extends AbstractC0213g implements P0.e {

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final /* synthetic */ int f1449M = 0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final boolean f1450I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final C0210d f1451J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private final Bundle f1452K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private final Integer f1453L;

    public a(Context context, Looper looper, boolean z3, C0210d c0210d, Bundle bundle, D0.f.a aVar, D0.f.b bVar) {
        super(context, looper, 44, c0210d, aVar, bVar);
        this.f1450I = true;
        this.f1451J = c0210d;
        this.f1452K = bundle;
        this.f1453L = c0210d.g();
    }

    public static Bundle h0(C0210d c0210d) {
        c0210d.f();
        Integer numG = c0210d.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c0210d.a());
        if (numG != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numG.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // F0.AbstractC0209c
    protected final String B() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // F0.AbstractC0209c
    protected final String C() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // P0.e
    public final void h(f fVar) {
        AbstractC0220n.g(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountB = this.f1451J.b();
            ((g) A()).Q(new j(1, new F(accountB, ((Integer) AbstractC0220n.f(this.f1453L)).intValue(), "<<default account>>".equals(accountB.name) ? A0.a.a(v()).b() : null)), fVar);
        } catch (RemoteException e3) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.G(new l(1, new C0179a(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e3);
            }
        }
    }

    @Override // F0.AbstractC0209c, D0.a.f
    public final boolean j() {
        return this.f1450I;
    }

    @Override // P0.e
    public final void k() {
        i(new AbstractC0209c.d());
    }

    @Override // F0.AbstractC0209c, D0.a.f
    public final int n() {
        return 12451000;
    }

    @Override // F0.AbstractC0209c
    protected final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // F0.AbstractC0209c
    protected final Bundle x() {
        if (!v().getPackageName().equals(this.f1451J.d())) {
            this.f1452K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f1451J.d());
        }
        return this.f1452K;
    }
}
