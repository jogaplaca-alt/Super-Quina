package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f4595a = Collections.synchronizedMap(new WeakHashMap());

    private static class a {
        static float a(VelocityTracker velocityTracker, int i3) {
            return velocityTracker.getAxisVelocity(i3);
        }

        static float b(VelocityTracker velocityTracker, int i3, int i4) {
            return velocityTracker.getAxisVelocity(i3, i4);
        }

        static boolean c(VelocityTracker velocityTracker, int i3) {
            return velocityTracker.isAxisSupported(i3);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f4595a.containsKey(velocityTracker)) {
                f4595a.put(velocityTracker, new V());
            }
            ((V) f4595a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i3) {
        c(velocityTracker, i3, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i3, float f3) {
        velocityTracker.computeCurrentVelocity(i3, f3);
        V vE = e(velocityTracker);
        if (vE != null) {
            vE.c(i3, f3);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i3);
        }
        if (i3 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i3 == 1) {
            return velocityTracker.getYVelocity();
        }
        V vE = e(velocityTracker);
        if (vE != null) {
            return vE.d(i3);
        }
        return 0.0f;
    }

    private static V e(VelocityTracker velocityTracker) {
        return (V) f4595a.get(velocityTracker);
    }
}
