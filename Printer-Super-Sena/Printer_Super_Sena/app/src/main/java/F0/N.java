package F0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f853a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f856d;

    public static int a(Context context) {
        b(context);
        return f856d;
    }

    private static void b(Context context) {
        synchronized (f853a) {
            try {
                if (f854b) {
                    return;
                }
                f854b = true;
                try {
                    Bundle bundle = K0.d.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f855c = bundle.getString("com.google.app.id");
                    f856d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
