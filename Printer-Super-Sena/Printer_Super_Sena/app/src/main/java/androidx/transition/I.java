package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class I extends E {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f6554f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f6555g = true;

    static class a {
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    I() {
    }

    @Override // androidx.transition.E
    public void h(View view, Matrix matrix) {
        if (f6554f) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f6554f = false;
            }
        }
    }

    @Override // androidx.transition.E
    public void i(View view, Matrix matrix) {
        if (f6555g) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f6555g = false;
            }
        }
    }
}
