package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f4556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f4557b;

    static class a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* JADX INFO: renamed from: androidx.core.text.b$b, reason: collision with other inner class name */
    static class C0058b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            if (i3 < 24) {
                try {
                    f4557b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e3) {
                    throw new IllegalStateException(e3);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f4556a = cls.getMethod("getScript", String.class);
            f4557b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e4) {
            f4556a = null;
            f4557b = null;
            Log.w("ICUCompat", e4);
        }
    }

    private static String a(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f4557b;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
        }
        return string;
    }

    private static String b(String str) {
        try {
            Method method = f4556a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            return C0058b.c(C0058b.a(C0058b.b(locale)));
        }
        if (i3 < 21) {
            String strA = a(locale);
            if (strA != null) {
                return b(strA);
            }
            return null;
        }
        try {
            return a.a((Locale) f4557b.invoke(null, locale));
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
            return a.a(locale);
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
            return a.a(locale);
        }
    }
}
