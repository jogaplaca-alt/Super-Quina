package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class k extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j f6203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f6204e;

    class a extends h {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.z
        protected void o(View view, RecyclerView.A a3, RecyclerView.z.a aVar) {
            k kVar = k.this;
            int[] iArrC = kVar.c(kVar.f6211a.getLayoutManager(), view);
            int i3 = iArrC[0];
            int i4 = iArrC[1];
            int iW = w(Math.max(Math.abs(i3), Math.abs(i4)));
            if (iW > 0) {
                aVar.d(i3, i4, iW, this.f6192j);
            }
        }

        @Override // androidx.recyclerview.widget.h
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.h
        protected int x(int i3) {
            return Math.min(100, super.x(i3));
        }
    }

    private int l(RecyclerView.o oVar, View view, j jVar) {
        return (jVar.g(view) + (jVar.e(view) / 2)) - (jVar.m() + (jVar.n() / 2));
    }

    private View m(RecyclerView.o oVar, j jVar) {
        int iO = oVar.O();
        View view = null;
        if (iO == 0) {
            return null;
        }
        int iM = jVar.m() + (jVar.n() / 2);
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < iO; i4++) {
            View viewN = oVar.N(i4);
            int iAbs = Math.abs((jVar.g(viewN) + (jVar.e(viewN) / 2)) - iM);
            if (iAbs < i3) {
                view = viewN;
                i3 = iAbs;
            }
        }
        return view;
    }

    private j n(RecyclerView.o oVar) {
        j jVar = this.f6204e;
        if (jVar == null || jVar.f6200a != oVar) {
            this.f6204e = j.a(oVar);
        }
        return this.f6204e;
    }

    private j o(RecyclerView.o oVar) {
        if (oVar.q()) {
            return p(oVar);
        }
        if (oVar.p()) {
            return n(oVar);
        }
        return null;
    }

    private j p(RecyclerView.o oVar) {
        j jVar = this.f6203d;
        if (jVar == null || jVar.f6200a != oVar) {
            this.f6203d = j.c(oVar);
        }
        return this.f6203d;
    }

    private boolean q(RecyclerView.o oVar, int i3, int i4) {
        if (oVar.p()) {
            return i3 > 0;
        }
        return i4 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean r(RecyclerView.o oVar) {
        PointF pointFE;
        int iB = oVar.b();
        if (!(oVar instanceof RecyclerView.z.b) || (pointFE = ((RecyclerView.z.b) oVar).e(iB - 1)) == null) {
            return false;
        }
        return pointFE.x < 0.0f || pointFE.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.p
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.p()) {
            iArr[0] = l(oVar, view, n(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.q()) {
            iArr[1] = l(oVar, view, p(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.p
    protected h e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new a(this.f6211a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.p
    public View g(RecyclerView.o oVar) {
        if (oVar.q()) {
            return m(oVar, p(oVar));
        }
        if (oVar.p()) {
            return m(oVar, n(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.p
    public int h(RecyclerView.o oVar, int i3, int i4) {
        j jVarO;
        int iB = oVar.b();
        if (iB == 0 || (jVarO = o(oVar)) == null) {
            return -1;
        }
        int iO = oVar.O();
        View view = null;
        View view2 = null;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < iO; i7++) {
            View viewN = oVar.N(i7);
            if (viewN != null) {
                int iL = l(oVar, viewN, jVarO);
                if (iL <= 0 && iL > i5) {
                    view2 = viewN;
                    i5 = iL;
                }
                if (iL >= 0 && iL < i6) {
                    view = viewN;
                    i6 = iL;
                }
            }
        }
        boolean zQ = q(oVar, i3, i4);
        if (zQ && view != null) {
            return oVar.l0(view);
        }
        if (!zQ && view2 != null) {
            return oVar.l0(view2);
        }
        if (zQ) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iL0 = oVar.l0(view) + (r(oVar) == zQ ? -1 : 1);
        if (iL0 < 0 || iL0 >= iB) {
            return -1;
        }
        return iL0;
    }
}
