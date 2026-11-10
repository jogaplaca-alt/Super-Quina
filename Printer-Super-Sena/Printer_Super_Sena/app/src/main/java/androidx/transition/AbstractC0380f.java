package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;

/* JADX INFO: renamed from: androidx.transition.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0380f {

    /* JADX INFO: renamed from: androidx.transition.f$a */
    static class a {
        static <T, V> ObjectAnimator a(T t3, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t3, property, (TypeConverter) null, path);
        }
    }

    static ObjectAnimator a(Object obj, Property property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? a.a(obj, property, path) : ObjectAnimator.ofFloat(obj, new C0382h(property, path), 0.0f, 1.0f);
    }
}
