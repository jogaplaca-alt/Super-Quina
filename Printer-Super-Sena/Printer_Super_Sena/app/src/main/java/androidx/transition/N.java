package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class N extends M {
    N() {
    }

    @Override // androidx.transition.E
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.K, androidx.transition.E
    public void e(View view, int i3, int i4, int i5, int i6) {
        view.setLeftTopRightBottom(i3, i4, i5, i6);
    }

    @Override // androidx.transition.E
    public void f(View view, float f3) {
        view.setTransitionAlpha(f3);
    }

    @Override // androidx.transition.M, androidx.transition.E
    public void g(View view, int i3) {
        view.setTransitionVisibility(i3);
    }

    @Override // androidx.transition.I, androidx.transition.E
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.I, androidx.transition.E
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
