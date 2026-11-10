package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f4535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f4536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f4537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f4538e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f4534a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f4535b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f4536c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f4537d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f4538e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e3) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e3);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
