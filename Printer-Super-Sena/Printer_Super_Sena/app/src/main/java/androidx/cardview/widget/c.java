package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
abstract class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f3652a = new RectF();

    c() {
    }

    private g o(Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        return new g(context.getResources(), colorStateList, f3, f4, f5);
    }

    private g p(d dVar) {
        return (g) dVar.d();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return p(dVar).i();
    }

    @Override // androidx.cardview.widget.e
    public float b(d dVar) {
        return p(dVar).g();
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return p(dVar).j();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return p(dVar).k();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList f(d dVar) {
        return p(dVar).f();
    }

    @Override // androidx.cardview.widget.e
    public void g(d dVar, float f3) {
        p(dVar).r(f3);
    }

    @Override // androidx.cardview.widget.e
    public void h(d dVar, Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        g gVarO = o(context, colorStateList, f3, f4, f5);
        gVarO.m(dVar.g());
        dVar.f(gVarO);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar, float f3) {
        p(dVar).p(f3);
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void j(d dVar) {
        p(dVar).m(dVar.g());
        q(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void k(d dVar, ColorStateList colorStateList) {
        p(dVar).o(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return p(dVar).l();
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar, float f3) {
        p(dVar).q(f3);
        q(dVar);
    }

    public void q(d dVar) {
        Rect rect = new Rect();
        p(dVar).h(rect);
        dVar.e((int) Math.ceil(d(dVar)), (int) Math.ceil(c(dVar)));
        dVar.c(rect.left, rect.top, rect.right, rect.bottom);
    }
}
