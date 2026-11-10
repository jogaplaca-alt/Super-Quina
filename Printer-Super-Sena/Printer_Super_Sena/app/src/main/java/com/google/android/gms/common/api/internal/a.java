package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f7221e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f7222a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f7223b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f7224c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7225d = false;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.a$a, reason: collision with other inner class name */
    public interface InterfaceC0102a {
        void a(boolean z3);
    }

    private a() {
    }

    public static a b() {
        return f7221e;
    }

    public static void c(Application application) {
        a aVar = f7221e;
        synchronized (aVar) {
            try {
                if (!aVar.f7225d) {
                    application.registerActivityLifecycleCallbacks(aVar);
                    application.registerComponentCallbacks(aVar);
                    aVar.f7225d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z3) {
        synchronized (f7221e) {
            try {
                Iterator it = this.f7224c.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0102a) it.next()).a(z3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(InterfaceC0102a interfaceC0102a) {
        synchronized (f7221e) {
            this.f7224c.add(interfaceC0102a);
        }
    }

    public boolean d() {
        return this.f7222a.get();
    }

    public boolean e(boolean z3) {
        if (!this.f7223b.get()) {
            if (!J0.e.a()) {
                return z3;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f7223b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f7222a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f7223b;
        boolean zCompareAndSet = this.f7222a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f7223b;
        boolean zCompareAndSet = this.f7222a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        if (i3 == 20 && this.f7222a.compareAndSet(false, true)) {
            this.f7223b.set(true);
            f(true);
        }
    }
}
