package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: renamed from: androidx.transition.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0384j implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f6641a;

    C0384j() {
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f3, Rect rect, Rect rect2) {
        int i3 = rect.left;
        int i4 = i3 + ((int) ((rect2.left - i3) * f3));
        int i5 = rect.top;
        int i6 = i5 + ((int) ((rect2.top - i5) * f3));
        int i7 = rect.right;
        int i8 = i7 + ((int) ((rect2.right - i7) * f3));
        int i9 = rect.bottom;
        int i10 = i9 + ((int) ((rect2.bottom - i9) * f3));
        Rect rect3 = this.f6641a;
        if (rect3 == null) {
            return new Rect(i4, i6, i8, i10);
        }
        rect3.set(i4, i6, i8, i10);
        return this.f6641a;
    }
}
