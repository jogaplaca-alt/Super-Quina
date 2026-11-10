package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.core.graphics.a$a, reason: collision with other inner class name */
    static class C0054a {
        static ColorFilter a(int i3, Object obj) {
            return new BlendModeColorFilter(i3, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i3, b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = c.b.a(bVar);
            if (objA != null) {
                return C0054a.a(i3, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = c.a(bVar);
        if (modeA != null) {
            return new PorterDuffColorFilter(i3, modeA);
        }
        return null;
    }
}
