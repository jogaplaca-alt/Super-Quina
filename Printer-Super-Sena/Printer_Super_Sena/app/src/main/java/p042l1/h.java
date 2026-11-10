package p042l1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.F;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    static d a(int i3) {
        if (i3 != 0) {
            return i3 != 1 ? b() : new e();
        }
        return new j();
    }

    static d b() {
        return new j();
    }

    static f c() {
        return new f();
    }

    public static void d(View view, float f3) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).U(f3);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.M()) {
            gVar.Y(F.f(view));
        }
    }
}
