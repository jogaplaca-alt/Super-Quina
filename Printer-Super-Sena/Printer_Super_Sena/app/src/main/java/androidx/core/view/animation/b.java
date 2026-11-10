package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    static class a {
        static Interpolator a(float f3, float f4) {
            return new PathInterpolator(f3, f4);
        }

        static Interpolator b(float f3, float f4, float f5, float f6) {
            return new PathInterpolator(f3, f4, f5, f6);
        }

        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f3, float f4, float f5, float f6) {
        return Build.VERSION.SDK_INT >= 21 ? a.b(f3, f4, f5, f6) : new androidx.core.view.animation.a(f3, f4, f5, f6);
    }

    public static Interpolator b(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? a.c(path) : new androidx.core.view.animation.a(path);
    }
}
