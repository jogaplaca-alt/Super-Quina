package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4346c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Set f4347d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f4348e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NotificationManager f4350b;

    static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    private o(Context context) {
        this.f4349a = context;
        this.f4350b = (NotificationManager) context.getSystemService("notification");
    }

    public static o b(Context context) {
        return new o(context);
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f4350b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f4349a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f4349a.getApplicationInfo();
        String packageName = this.f4349a.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
