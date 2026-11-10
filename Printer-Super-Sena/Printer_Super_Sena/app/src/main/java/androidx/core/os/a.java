package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4513a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4517e;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    private static final class C0056a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0056a f4518a = new C0056a();

        private C0056a() {
        }

        public final int a(int i3) {
            return SdkExtensions.getExtensionVersion(i3);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f4514b = i3 >= 30 ? C0056a.f4518a.a(30) : 0;
        f4515c = i3 >= 30 ? C0056a.f4518a.a(31) : 0;
        f4516d = i3 >= 30 ? C0056a.f4518a.a(33) : 0;
        f4517e = i3 >= 30 ? C0056a.f4518a.a(1000000) : 0;
    }

    private a() {
    }

    public static final boolean a(String str, String str2) {
        S1.k.e(str, "codename");
        S1.k.e(str2, "buildCodename");
        if (S1.k.a("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        S1.k.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        S1.k.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33) {
            if (i3 >= 32) {
                String str = Build.VERSION.CODENAME;
                S1.k.d(str, "CODENAME");
                if (a("Tiramisu", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
