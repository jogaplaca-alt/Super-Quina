package p017e0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f9457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f9458b;

    public static void a(String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        try {
            if (f9458b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f9458b == null) {
                f9457a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f9458b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f9458b.invoke(null, Long.valueOf(f9457a))).booleanValue();
        } catch (Exception e3) {
            c("isTagEnabled", e3);
            return false;
        }
    }
}
