package F0;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class f0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g0 f954a;

    /* synthetic */ f0(g0 g0Var, e0 e0Var) {
        this.f954a = g0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            synchronized (this.f954a.f958f) {
                try {
                    b0 b0Var = (b0) message.obj;
                    d0 d0Var = (d0) this.f954a.f958f.get(b0Var);
                    if (d0Var != null && d0Var.i()) {
                        if (d0Var.j()) {
                            d0Var.g("GmsClientSupervisor");
                        }
                        this.f954a.f958f.remove(b0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        synchronized (this.f954a.f958f) {
            try {
                b0 b0Var2 = (b0) message.obj;
                d0 d0Var2 = (d0) this.f954a.f958f.get(b0Var2);
                if (d0Var2 != null && d0Var2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(b0Var2), new Exception());
                    ComponentName componentNameB = d0Var2.b();
                    if (componentNameB == null) {
                        componentNameB = b0Var2.a();
                    }
                    if (componentNameB == null) {
                        String strC = b0Var2.c();
                        AbstractC0220n.f(strC);
                        componentNameB = new ComponentName(strC, "unknown");
                    }
                    d0Var2.onServiceDisconnected(componentNameB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
