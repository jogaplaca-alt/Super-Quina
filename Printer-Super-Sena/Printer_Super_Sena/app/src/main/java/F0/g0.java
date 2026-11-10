package F0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class g0 extends AbstractC0214h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f958f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile Handler f960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f0 f961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final I0.b f962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile Executor f965m;

    g0(Context context, Looper looper, Executor executor) {
        f0 f0Var = new f0(this, null);
        this.f961i = f0Var;
        this.f959g = context.getApplicationContext();
        this.f960h = new N0.e(looper, f0Var);
        this.f962j = I0.b.a();
        this.f963k = 5000L;
        this.f964l = 300000L;
        this.f965m = executor;
    }

    @Override // F0.AbstractC0214h
    protected final void c(b0 b0Var, ServiceConnection serviceConnection, String str) {
        AbstractC0220n.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f958f) {
            try {
                d0 d0Var = (d0) this.f958f.get(b0Var);
                if (d0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + b0Var.toString());
                }
                if (!d0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + b0Var.toString());
                }
                d0Var.f(serviceConnection, str);
                if (d0Var.i()) {
                    this.f960h.sendMessageDelayed(this.f960h.obtainMessage(0, b0Var), this.f963k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // F0.AbstractC0214h
    protected final boolean e(b0 b0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        AbstractC0220n.g(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f958f) {
            try {
                d0 d0Var = (d0) this.f958f.get(b0Var);
                if (executor == null) {
                    executor = this.f965m;
                }
                if (d0Var == null) {
                    d0Var = new d0(this, b0Var);
                    d0Var.d(serviceConnection, serviceConnection, str);
                    d0Var.e(str, executor);
                    this.f958f.put(b0Var, d0Var);
                } else {
                    this.f960h.removeMessages(0, b0Var);
                    if (d0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + b0Var.toString());
                    }
                    d0Var.d(serviceConnection, serviceConnection, str);
                    int iA = d0Var.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(d0Var.b(), d0Var.c());
                    } else if (iA == 2) {
                        d0Var.e(str, executor);
                    }
                }
                zJ = d0Var.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
