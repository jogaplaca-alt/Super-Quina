package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class f4250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f4251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f4252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f4253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f4254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f4255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f4256g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0051d f4257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f4258b;

        a(C0051d c0051d, Object obj) {
            this.f4257a = c0051d;
            this.f4258b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4257a.f4263a = this.f4258b;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f4259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0051d f4260b;

        b(Application application, C0051d c0051d) {
            this.f4259a = application;
            this.f4260b = c0051d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4259a.unregisterActivityLifecycleCallbacks(this.f4260b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f4261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f4262b;

        c(Object obj, Object obj2) {
            this.f4261a = obj;
            this.f4262b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f4253d;
                if (method != null) {
                    method.invoke(this.f4261a, this.f4262b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.f4254e.invoke(this.f4261a, this.f4262b, Boolean.FALSE);
                }
            } catch (RuntimeException e3) {
                if (e3.getClass() == RuntimeException.class && e3.getMessage() != null && e3.getMessage().startsWith("Unable to stop")) {
                    throw e3;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.d$d, reason: collision with other inner class name */
    private static final class C0051d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f4263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f4264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4266d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4267e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4268f = false;

        C0051d(Activity activity) {
            this.f4264b = activity;
            this.f4265c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f4264b == activity) {
                this.f4264b = null;
                this.f4267e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f4267e || this.f4268f || this.f4266d || !d.h(this.f4263a, this.f4265c, activity)) {
                return;
            }
            this.f4268f = true;
            this.f4263a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f4264b == activity) {
                this.f4266d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class clsA = a();
        f4250a = clsA;
        f4251b = b();
        f4252c = f();
        f4253d = d(clsA);
        f4254e = c(clsA);
        f4255f = e(clsA);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 == 26 || i3 == 27;
    }

    protected static boolean h(Object obj, int i3, Activity activity) {
        try {
            Object obj2 = f4252c.get(activity);
            if (obj2 == obj && activity.hashCode() == i3) {
                f4256g.postAtFrontOfQueue(new c(f4251b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f4255f == null) {
            return false;
        }
        if (f4254e == null && f4253d == null) {
            return false;
        }
        try {
            Object obj2 = f4252c.get(activity);
            if (obj2 == null || (obj = f4251b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C0051d c0051d = new C0051d(activity);
            application.registerActivityLifecycleCallbacks(c0051d);
            f4256g.post(new a(c0051d, obj2));
            try {
                if (g()) {
                    Method method = f4255f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f4256g.post(new b(application, c0051d));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
