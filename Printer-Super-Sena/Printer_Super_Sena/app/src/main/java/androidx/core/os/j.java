package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f4524b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f4525a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Locale[] f4526a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f4526a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strC = androidx.core.text.b.c(locale);
            if (!strC.isEmpty()) {
                return strC.equals(androidx.core.text.b.c(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private j(l lVar) {
        this.f4525a = lVar;
    }

    public static j a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? j(b.a(localeArr)) : new j(new k(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static j c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = Build.VERSION.SDK_INT >= 21 ? a.a(strArrSplit[i3]) : b(strArrSplit[i3]);
        }
        return a(localeArr);
    }

    public static j e() {
        return f4524b;
    }

    public static j j(LocaleList localeList) {
        return new j(new s(localeList));
    }

    public Locale d(int i3) {
        return this.f4525a.get(i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && this.f4525a.equals(((j) obj).f4525a);
    }

    public boolean f() {
        return this.f4525a.isEmpty();
    }

    public int g() {
        return this.f4525a.size();
    }

    public String h() {
        return this.f4525a.b();
    }

    public int hashCode() {
        return this.f4525a.hashCode();
    }

    public Object i() {
        return this.f4525a.a();
    }

    public String toString() {
        return this.f4525a.toString();
    }
}
