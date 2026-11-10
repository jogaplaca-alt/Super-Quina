package I0;

import F0.AbstractC0220n;
import F0.h0;
import J0.e;
import K0.d;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f1176b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f1177c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1178a = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f1177c == null) {
            synchronized (f1176b) {
                try {
                    if (f1177c == null) {
                        f1177c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b bVar = f1177c;
        AbstractC0220n.f(bVar);
        return bVar;
    }

    private static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i3, boolean z3, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((d.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return g(context, intent, serviceConnection, i3, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f1178a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zG = g(context, intent, serviceConnection, i3, executor);
            if (zG) {
                return zG;
            }
            this.f1178a.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.f1178a.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }

    private static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof h0);
    }

    private static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i3, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!e.g() || executor == null) ? context.bindService(intent, serviceConnection, i3) : context.bindService(intent, i3, executor, serviceConnection);
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f1178a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f1178a.get(serviceConnection));
        } finally {
            this.f1178a.remove(serviceConnection);
        }
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i3, Executor executor) {
        return e(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
