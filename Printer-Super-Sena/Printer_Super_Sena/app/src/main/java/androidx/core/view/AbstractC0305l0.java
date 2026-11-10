package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: androidx.core.view.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0305l0 {

    /* JADX INFO: renamed from: androidx.core.view.l0$a */
    static class a {
        static void a(Window window, boolean z3) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z3 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.l0$b */
    static class b {
        static void a(Window window, boolean z3) {
            window.setDecorFitsSystemWindows(z3);
        }
    }

    public static l1 a(Window window, View view) {
        return new l1(window, view);
    }

    public static void b(Window window, boolean z3) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.a(window, z3);
        } else {
            a.a(window, z3);
        }
    }
}
