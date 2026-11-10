package p041l0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
