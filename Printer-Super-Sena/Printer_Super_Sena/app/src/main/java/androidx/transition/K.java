package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class K extends I {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f6556h = true;

    static class a {
        static void a(View view, int i3, int i4, int i5, int i6) {
            view.setLeftTopRightBottom(i3, i4, i5, i6);
        }
    }

    K() {
    }

    @Override // androidx.transition.E
    public void e(View view, int i3, int i4, int i5, int i6) {
        if (f6556h) {
            try {
                a.a(view, i3, i4, i5, i6);
            } catch (NoSuchMethodError unused) {
                f6556h = false;
            }
        }
    }
}
