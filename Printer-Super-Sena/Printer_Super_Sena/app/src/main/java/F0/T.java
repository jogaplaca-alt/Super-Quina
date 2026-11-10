package F0;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class T extends L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC0209c f861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f862d;

    public T(AbstractC0209c abstractC0209c, int i3) {
        this.f861c = abstractC0209c;
        this.f862d = i3;
    }

    @Override // F0.InterfaceC0216j
    public final void O(int i3, IBinder iBinder, X x3) {
        AbstractC0209c abstractC0209c = this.f861c;
        AbstractC0220n.g(abstractC0209c, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC0220n.f(x3);
        AbstractC0209c.Y(abstractC0209c, x3);
        P(i3, iBinder, x3.f868a);
    }

    @Override // F0.InterfaceC0216j
    public final void P(int i3, IBinder iBinder, Bundle bundle) {
        AbstractC0220n.g(this.f861c, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f861c.K(i3, iBinder, bundle, this.f862d);
        this.f861c = null;
    }

    @Override // F0.InterfaceC0216j
    public final void m(int i3, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
