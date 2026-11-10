package p042l1;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
class s extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9979f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9980g = 0.0f;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            s sVar = s.this;
            if (sVar.f9976c == null || sVar.f9977d.isEmpty()) {
                return;
            }
            s sVar2 = s.this;
            RectF rectF = sVar2.f9977d;
            outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, sVar2.f9980g);
        }
    }

    s(View view) {
        m(view);
    }

    private float l() {
        RectF rectF;
        k kVar = this.f9976c;
        if (kVar == null || (rectF = this.f9977d) == null) {
            return 0.0f;
        }
        return kVar.f9909f.a(rectF);
    }

    private void m(View view) {
        view.setOutlineProvider(new a());
    }

    private boolean n() {
        k kVar;
        if (this.f9977d.isEmpty() || (kVar = this.f9976c) == null) {
            return false;
        }
        return kVar.u(this.f9977d);
    }

    private boolean o() {
        k kVar;
        if (!this.f9977d.isEmpty() && (kVar = this.f9976c) != null && this.f9975b && !kVar.u(this.f9977d) && p(this.f9976c)) {
            float fA = this.f9976c.r().a(this.f9977d);
            float fA2 = this.f9976c.t().a(this.f9977d);
            float fA3 = this.f9976c.j().a(this.f9977d);
            float fA4 = this.f9976c.l().a(this.f9977d);
            if (fA == 0.0f && fA3 == 0.0f && fA2 == fA4) {
                RectF rectF = this.f9977d;
                rectF.set(rectF.left - fA2, rectF.top, rectF.right, rectF.bottom);
                this.f9980g = fA2;
                return true;
            }
            if (fA == 0.0f && fA2 == 0.0f && fA3 == fA4) {
                RectF rectF2 = this.f9977d;
                rectF2.set(rectF2.left, rectF2.top - fA3, rectF2.right, rectF2.bottom);
                this.f9980g = fA3;
                return true;
            }
            if (fA2 == 0.0f && fA4 == 0.0f && fA == fA3) {
                RectF rectF3 = this.f9977d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + fA, rectF3.bottom);
                this.f9980g = fA;
                return true;
            }
            if (fA3 == 0.0f && fA4 == 0.0f && fA == fA2) {
                RectF rectF4 = this.f9977d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + fA);
                this.f9980g = fA;
                return true;
            }
        }
        return false;
    }

    private static boolean p(k kVar) {
        return (kVar.q() instanceof j) && (kVar.s() instanceof j) && (kVar.i() instanceof j) && (kVar.k() instanceof j);
    }

    @Override // p042l1.o
    void b(View view) {
        this.f9980g = l();
        this.f9979f = n() || o();
        view.setClipToOutline(!i());
        if (i()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // p042l1.o
    boolean i() {
        return !this.f9979f || this.f9974a;
    }
}
