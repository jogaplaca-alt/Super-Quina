package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class n {
    static int a(RecyclerView.A a3, j jVar, View view, View view2, RecyclerView.o oVar, boolean z3) {
        if (oVar.O() == 0 || a3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return Math.abs(oVar.l0(view) - oVar.l0(view2)) + 1;
        }
        return Math.min(jVar.n(), jVar.d(view2) - jVar.g(view));
    }

    static int b(RecyclerView.A a3, j jVar, View view, View view2, RecyclerView.o oVar, boolean z3, boolean z4) {
        if (oVar.O() == 0 || a3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z4 ? Math.max(0, (a3.b() - Math.max(oVar.l0(view), oVar.l0(view2))) - 1) : Math.max(0, Math.min(oVar.l0(view), oVar.l0(view2)));
        if (z3) {
            return Math.round((iMax * (Math.abs(jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.l0(view) - oVar.l0(view2)) + 1))) + (jVar.m() - jVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.A a3, j jVar, View view, View view2, RecyclerView.o oVar, boolean z3) {
        if (oVar.O() == 0 || a3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return a3.b();
        }
        return (int) (((jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.l0(view) - oVar.l0(view2)) + 1)) * a3.b());
    }
}
