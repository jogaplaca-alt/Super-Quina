package F0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: F0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0214h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f966a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g0 f967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static HandlerThread f968c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Executor f969d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f970e = false;

    public static AbstractC0214h a(Context context) {
        synchronized (f966a) {
            try {
                if (f967b == null) {
                    f967b = new g0(context.getApplicationContext(), f970e ? b().getLooper() : context.getMainLooper(), f969d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f967b;
    }

    public static HandlerThread b() {
        synchronized (f966a) {
            try {
                HandlerThread handlerThread = f968c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f968c = handlerThread2;
                handlerThread2.start();
                return f968c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract void c(b0 b0Var, ServiceConnection serviceConnection, String str);

    public final void d(String str, String str2, int i3, ServiceConnection serviceConnection, String str3, boolean z3) {
        c(new b0(str, str2, 4225, z3), serviceConnection, str3);
    }

    protected abstract boolean e(b0 b0Var, ServiceConnection serviceConnection, String str, Executor executor);
}
