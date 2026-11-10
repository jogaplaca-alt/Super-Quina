package F0;

import C0.C0179a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class V extends J {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f866h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC0209c abstractC0209c, int i3, IBinder iBinder, Bundle bundle) {
        super(abstractC0209c, i3, bundle);
        this.f866h = abstractC0209c;
        this.f865g = iBinder;
    }

    @Override // F0.J
    protected final void f(C0179a c0179a) {
        if (this.f866h.f904v != null) {
            this.f866h.f904v.d(c0179a);
        }
        this.f866h.I(c0179a);
    }

    @Override // F0.J
    protected final boolean g() {
        try {
            IBinder iBinder = this.f865g;
            AbstractC0220n.f(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f866h.B().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f866h.B() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceP = this.f866h.p(this.f865g);
            if (iInterfaceP == null || !(AbstractC0209c.c0(this.f866h, 2, 4, iInterfaceP) || AbstractC0209c.c0(this.f866h, 3, 4, iInterfaceP))) {
                return false;
            }
            this.f866h.f908z = null;
            AbstractC0209c abstractC0209c = this.f866h;
            Bundle bundleU = abstractC0209c.u();
            if (abstractC0209c.f903u == null) {
                return true;
            }
            this.f866h.f903u.e(bundleU);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
