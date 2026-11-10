package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class b implements e {
    b() {
    }

    private f o(d dVar) {
        return (f) dVar.d();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return o(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public float b(d dVar) {
        return o(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return b(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return b(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
        m(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList f(d dVar) {
        return o(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void g(d dVar, float f3) {
        dVar.a().setElevation(f3);
    }

    @Override // androidx.cardview.widget.e
    public void h(d dVar, Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        dVar.f(new f(colorStateList, f3));
        View viewA = dVar.a();
        viewA.setClipToOutline(true);
        viewA.setElevation(f4);
        m(dVar, f5);
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar, float f3) {
        o(dVar).h(f3);
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
        m(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, ColorStateList colorStateList) {
        o(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return dVar.a().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, float f3) {
        o(dVar).g(f3, dVar.b(), dVar.g());
        p(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void n() {
    }

    public void p(d dVar) {
        if (!dVar.b()) {
            dVar.c(0, 0, 0, 0);
            return;
        }
        float fA = a(dVar);
        float fB = b(dVar);
        int iCeil = (int) Math.ceil(g.c(fA, fB, dVar.g()));
        int iCeil2 = (int) Math.ceil(g.d(fA, fB, dVar.g()));
        dVar.c(iCeil, iCeil2, iCeil, iCeil2);
    }
}
