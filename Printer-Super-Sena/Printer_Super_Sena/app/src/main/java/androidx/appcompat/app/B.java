package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class B extends Service {

    private static class a {
        static int a() {
            return 512;
        }
    }

    public static ServiceInfo a(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) B.class), Build.VERSION.SDK_INT >= 24 ? a.a() | 128 : 640);
    }
}
