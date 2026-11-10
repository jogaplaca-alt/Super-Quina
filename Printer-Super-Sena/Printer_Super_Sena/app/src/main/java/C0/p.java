package C0;

import F0.AbstractC0220n;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static p f141b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f142a;

    public p(Context context) {
        this.f142a = context.getApplicationContext();
    }

    public static p a(Context context) {
        AbstractC0220n.f(context);
        synchronized (p.class) {
            try {
                if (f141b == null) {
                    D.a(context);
                    f141b = new p(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f141b;
    }

    static final z b(PackageInfo packageInfo, z... zVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            A a3 = new A(packageInfo.signatures[0].toByteArray());
            for (int i3 = 0; i3 < zVarArr.length; i3++) {
                if (zVarArr[i3].equals(a3)) {
                    return zVarArr[i3];
                }
            }
        }
        return null;
    }

    public static final boolean c(PackageInfo packageInfo, boolean z3) {
        PackageInfo packageInfo2;
        if (!z3) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z3 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z3 ? b(packageInfo2, C.f113a) : b(packageInfo2, C.f113a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
