package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.core.view.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0291e0 {

    /* JADX INFO: renamed from: androidx.core.view.e0$a */
    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z3) {
            viewGroup.setTransitionGroup(z3);
        }
    }

    public static int a(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static boolean b(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(viewGroup);
        }
        Boolean bool = (Boolean) viewGroup.getTag(p070v.b.f12359Q);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && Z.L(viewGroup) == null) ? false : true;
    }
}
