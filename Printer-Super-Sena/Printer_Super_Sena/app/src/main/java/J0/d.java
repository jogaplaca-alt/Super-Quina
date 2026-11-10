package J0;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f1184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f1185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f1186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f1187d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f1187d == null) {
            boolean z3 = false;
            if (e.f() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z3 = true;
            }
            f1187d = Boolean.valueOf(z3);
        }
        return f1187d.booleanValue();
    }

    public static boolean b(Context context) {
        return f(context.getPackageManager());
    }

    public static boolean c(Context context) {
        if (b(context) && !e.e()) {
            return true;
        }
        if (d(context)) {
            return !e.f() || e.h();
        }
        return false;
    }

    public static boolean d(Context context) {
        if (f1185b == null) {
            boolean z3 = false;
            if (e.d() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z3 = true;
            }
            f1185b = Boolean.valueOf(z3);
        }
        return f1185b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f1186c == null) {
            boolean z3 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z3 = false;
            }
            f1186c = Boolean.valueOf(z3);
        }
        return f1186c.booleanValue();
    }

    public static boolean f(PackageManager packageManager) {
        if (f1184a == null) {
            boolean z3 = false;
            if (e.c() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z3 = true;
            }
            f1184a = Boolean.valueOf(z3);
        }
        return f1184a.booleanValue();
    }
}
