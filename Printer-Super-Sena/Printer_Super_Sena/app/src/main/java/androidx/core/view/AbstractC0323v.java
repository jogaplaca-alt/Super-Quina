package androidx.core.view;

import android.os.Build;
import android.view.Menu;

/* JADX INFO: renamed from: androidx.core.view.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0323v {

    /* JADX INFO: renamed from: androidx.core.view.v$a */
    static class a {
        static void a(Menu menu, boolean z3) {
            menu.setGroupDividerEnabled(z3);
        }
    }

    public static void a(Menu menu, boolean z3) {
        if (menu instanceof p073w.a) {
            ((p073w.a) menu).setGroupDividerEnabled(z3);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z3);
        }
    }
}
