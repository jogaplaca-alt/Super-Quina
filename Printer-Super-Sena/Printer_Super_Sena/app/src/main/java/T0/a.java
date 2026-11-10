package T0;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f1956a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f1957b = new Q.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f1958c = new Q.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f1959d = new Q.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f1960e = new DecelerateInterpolator();

    public static float a(float f3, float f4, float f5) {
        return f3 + (f5 * (f4 - f3));
    }

    public static float b(float f3, float f4, float f5, float f6, float f7) {
        if (f7 <= f5) {
            return f3;
        }
        return f7 >= f6 ? f4 : a(f3, f4, (f7 - f5) / (f6 - f5));
    }

    public static int c(int i3, int i4, float f3) {
        return i3 + Math.round(f3 * (i4 - i3));
    }
}
