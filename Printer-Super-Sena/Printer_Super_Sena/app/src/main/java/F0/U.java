package F0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class U implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f864b;

    public U(AbstractC0209c abstractC0209c, int i3) {
        this.f864b = abstractC0209c;
        this.f863a = i3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC0209c abstractC0209c = this.f864b;
        if (iBinder == null) {
            AbstractC0209c.Z(abstractC0209c, 16);
            return;
        }
        synchronized (abstractC0209c.f896n) {
            try {
                AbstractC0209c abstractC0209c2 = this.f864b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC0209c2.f897o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0217k)) ? new M(iBinder) : (InterfaceC0217k) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f864b.a0(0, null, this.f863a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f864b.f896n) {
            this.f864b.f897o = null;
        }
        AbstractC0209c abstractC0209c = this.f864b;
        int i3 = this.f863a;
        Handler handler = abstractC0209c.f894l;
        handler.sendMessage(handler.obtainMessage(6, i3, 1));
    }
}
