package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f4589a;

    static class a {
        static PointerIcon a(Bitmap bitmap, float f3, float f4) {
            return PointerIcon.create(bitmap, f3, f4);
        }

        static PointerIcon b(Context context, int i3) {
            return PointerIcon.getSystemIcon(context, i3);
        }

        static PointerIcon c(Resources resources, int i3) {
            return PointerIcon.load(resources, i3);
        }
    }

    private M(PointerIcon pointerIcon) {
        this.f4589a = pointerIcon;
    }

    public static M b(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 24 ? new M(a.b(context, i3)) : new M(null);
    }

    public Object a() {
        return this.f4589a;
    }
}
