package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f6211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f6212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.t f6213c = new a();

    class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6214a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i3) {
            super.a(recyclerView, i3);
            if (i3 == 0 && this.f6214a) {
                this.f6214a = false;
                p.this.k();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.f6214a = true;
        }
    }

    private void f() {
        this.f6211a.Z0(this.f6213c);
        this.f6211a.setOnFlingListener(null);
    }

    private void i() {
        if (this.f6211a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f6211a.l(this.f6213c);
        this.f6211a.setOnFlingListener(this);
    }

    private boolean j(RecyclerView.o oVar, int i3, int i4) {
        RecyclerView.z zVarD;
        int iH;
        if (!(oVar instanceof RecyclerView.z.b) || (zVarD = d(oVar)) == null || (iH = h(oVar, i3, i4)) == -1) {
            return false;
        }
        zVarD.p(iH);
        oVar.N1(zVarD);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i3, int i4) {
        RecyclerView.o layoutManager = this.f6211a.getLayoutManager();
        if (layoutManager == null || this.f6211a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f6211a.getMinFlingVelocity();
        return (Math.abs(i4) > minFlingVelocity || Math.abs(i3) > minFlingVelocity) && j(layoutManager, i3, i4);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6211a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f6211a = recyclerView;
        if (recyclerView != null) {
            i();
            this.f6212b = new Scroller(this.f6211a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    protected RecyclerView.z d(RecyclerView.o oVar) {
        return e(oVar);
    }

    protected abstract h e(RecyclerView.o oVar);

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i3, int i4);

    void k() {
        RecyclerView.o layoutManager;
        View viewG;
        RecyclerView recyclerView = this.f6211a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewG = g(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewG);
        int i3 = iArrC[0];
        if (i3 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f6211a.m1(i3, iArrC[1]);
    }
}
