package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6545a = true;

    static class a {
        static int a(ViewGroup viewGroup, int i3) {
            return viewGroup.getChildDrawingOrder(i3);
        }

        static void b(ViewGroup viewGroup, boolean z3) {
            viewGroup.suppressLayout(z3);
        }
    }

    private static void a(ViewGroup viewGroup, boolean z3) {
        if (f6545a) {
            try {
                a.b(viewGroup, z3);
            } catch (NoSuchMethodError unused) {
                f6545a = false;
            }
        }
    }

    static void b(ViewGroup viewGroup, boolean z3) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z3);
        } else {
            a(viewGroup, z3);
        }
    }
}
