package androidx.transition;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class M extends K {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f6557i = true;

    static class a {
        static void a(View view, int i3) {
            view.setTransitionVisibility(i3);
        }
    }

    M() {
    }

    @Override // androidx.transition.E
    public void g(View view, int i3) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i3);
        } else if (f6557i) {
            try {
                a.a(view, i3);
            } catch (NoSuchMethodError unused) {
                f6557i = false;
            }
        }
    }
}
