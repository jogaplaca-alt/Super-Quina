package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends RecyclerView.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f6210g = true;

    public final void A(RecyclerView.D d3) {
        I(d3);
        h(d3);
    }

    public final void B(RecyclerView.D d3) {
        J(d3);
    }

    public final void C(RecyclerView.D d3, boolean z3) {
        K(d3, z3);
        h(d3);
    }

    public final void D(RecyclerView.D d3, boolean z3) {
        L(d3, z3);
    }

    public final void E(RecyclerView.D d3) {
        M(d3);
        h(d3);
    }

    public final void F(RecyclerView.D d3) {
        N(d3);
    }

    public final void G(RecyclerView.D d3) {
        O(d3);
        h(d3);
    }

    public final void H(RecyclerView.D d3) {
        P(d3);
    }

    public void I(RecyclerView.D d3) {
    }

    public void J(RecyclerView.D d3) {
    }

    public void K(RecyclerView.D d3, boolean z3) {
    }

    public void L(RecyclerView.D d3, boolean z3) {
    }

    public void M(RecyclerView.D d3) {
    }

    public void N(RecyclerView.D d3) {
    }

    public void O(RecyclerView.D d3) {
    }

    public void P(RecyclerView.D d3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i3;
        int i4;
        return (bVar == null || ((i3 = bVar.f5939a) == (i4 = bVar2.f5939a) && bVar.f5940b == bVar2.f5940b)) ? w(d3) : y(d3, i3, bVar.f5940b, i4, bVar2.f5940b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.D d3, RecyclerView.D d4, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i3;
        int i4;
        int i5 = bVar.f5939a;
        int i6 = bVar.f5940b;
        if (d4.J()) {
            int i7 = bVar.f5939a;
            i4 = bVar.f5940b;
            i3 = i7;
        } else {
            i3 = bVar2.f5939a;
            i4 = bVar2.f5940b;
        }
        return x(d3, d4, i5, i6, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i3 = bVar.f5939a;
        int i4 = bVar.f5940b;
        View view = d3.f5908a;
        int left = bVar2 == null ? view.getLeft() : bVar2.f5939a;
        int top = bVar2 == null ? view.getTop() : bVar2.f5940b;
        if (d3.v() || (i3 == left && i4 == top)) {
            return z(d3);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(d3, i3, i4, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.D d3, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i3 = bVar.f5939a;
        int i4 = bVar2.f5939a;
        if (i3 != i4 || bVar.f5940b != bVar2.f5940b) {
            return y(d3, i3, bVar.f5940b, i4, bVar2.f5940b);
        }
        E(d3);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.D d3) {
        return !this.f6210g || d3.t();
    }

    public abstract boolean w(RecyclerView.D d3);

    public abstract boolean x(RecyclerView.D d3, RecyclerView.D d4, int i3, int i4, int i5, int i6);

    public abstract boolean y(RecyclerView.D d3, int i3, int i4, int i5, int i6);

    public abstract boolean z(RecyclerView.D d3);
}
