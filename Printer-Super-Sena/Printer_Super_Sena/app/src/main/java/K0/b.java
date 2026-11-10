package K0;

import J0.e;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f1205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f1206b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f1205a;
        if (context2 != null && (bool = f1206b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f1206b = null;
        if (e.f()) {
            f1206b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f1206b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f1206b = Boolean.FALSE;
            }
        }
        f1205a = applicationContext;
        return f1206b.booleanValue();
    }
}
