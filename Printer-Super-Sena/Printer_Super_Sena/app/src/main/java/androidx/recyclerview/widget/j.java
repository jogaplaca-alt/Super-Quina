package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f6202c;

    static class a extends j {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f6200a.Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6200a.X(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6200a.W(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f6200a.V(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f6200a.s0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f6200a.s0() - this.f6200a.j0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f6200a.j0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f6200a.t0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f6200a.c0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f6200a.i0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f6200a.s0() - this.f6200a.i0()) - this.f6200a.j0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f6200a.r0(view, true, this.f6202c);
            return this.f6202c.right;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f6200a.r0(view, true, this.f6202c);
            return this.f6202c.left;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i3) {
            this.f6200a.G0(i3);
        }
    }

    static class b extends j {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f6200a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6200a.W(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6200a.X(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f6200a.Z(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f6200a.b0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f6200a.b0() - this.f6200a.h0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f6200a.h0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f6200a.c0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f6200a.t0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f6200a.k0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f6200a.b0() - this.f6200a.k0()) - this.f6200a.h0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f6200a.r0(view, true, this.f6202c);
            return this.f6202c.bottom;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f6200a.r0(view, true, this.f6202c);
            return this.f6202c.top;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i3) {
            this.f6200a.H0(i3);
        }
    }

    /* synthetic */ j(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static j a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static j b(RecyclerView.o oVar, int i3) {
        if (i3 == 0) {
            return a(oVar);
        }
        if (i3 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static j c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f6201b) {
            return 0;
        }
        return n() - this.f6201b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i3);

    public void s() {
        this.f6201b = n();
    }

    private j(RecyclerView.o oVar) {
        this.f6201b = Integer.MIN_VALUE;
        this.f6202c = new Rect();
        this.f6200a = oVar;
    }
}
