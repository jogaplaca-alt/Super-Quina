package U0;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f2042a = false;

    public static void a(a aVar, View view, FrameLayout frameLayout) {
        c(aVar, view, frameLayout);
        if (aVar.i() != null) {
            aVar.i().setForeground(aVar);
        } else {
            if (f2042a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(aVar);
        }
    }

    public static void b(a aVar, View view) {
        if (aVar == null) {
            return;
        }
        if (f2042a || aVar.i() != null) {
            aVar.i().setForeground(null);
        } else {
            view.getOverlay().remove(aVar);
        }
    }

    public static void c(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.N(view, frameLayout);
    }

    public static void d(Rect rect, float f3, float f4, float f5, float f6) {
        rect.set((int) (f3 - f5), (int) (f4 - f6), (int) (f3 + f5), (int) (f4 + f6));
    }
}
