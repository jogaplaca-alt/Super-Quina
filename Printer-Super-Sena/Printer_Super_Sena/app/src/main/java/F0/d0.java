package F0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class d0 implements ServiceConnection, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f925a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f926b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IBinder f928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b0 f929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ComponentName f930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ g0 f931g;

    public d0(g0 g0Var, b0 b0Var) {
        this.f931g = g0Var;
        this.f929e = b0Var;
    }

    public final int a() {
        return this.f926b;
    }

    public final ComponentName b() {
        return this.f930f;
    }

    public final IBinder c() {
        return this.f928d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f925a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f926b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (J0.e.i()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            g0 g0Var = this.f931g;
            boolean zC = g0Var.f962j.c(g0Var.f959g, str, this.f929e.b(g0Var.f959g), this, 4225, executor);
            this.f927c = zC;
            if (zC) {
                this.f931g.f960h.sendMessageDelayed(this.f931g.f960h.obtainMessage(1, this.f929e), this.f931g.f964l);
            } else {
                this.f926b = 2;
                try {
                    g0 g0Var2 = this.f931g;
                    g0Var2.f962j.b(g0Var2.f959g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f925a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f931g.f960h.removeMessages(1, this.f929e);
        g0 g0Var = this.f931g;
        g0Var.f962j.b(g0Var.f959g, this);
        this.f927c = false;
        this.f926b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f925a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f925a.isEmpty();
    }

    public final boolean j() {
        return this.f927c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f931g.f958f) {
            try {
                this.f931g.f960h.removeMessages(1, this.f929e);
                this.f928d = iBinder;
                this.f930f = componentName;
                Iterator it = this.f925a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f926b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f931g.f958f) {
            try {
                this.f931g.f960h.removeMessages(1, this.f929e);
                this.f928d = null;
                this.f930f = componentName;
                Iterator it = this.f925a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f926b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
