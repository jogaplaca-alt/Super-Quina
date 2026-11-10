package com.google.android.material.carousel;

import S0.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.o implements com.google.android.material.carousel.b, RecyclerView.z.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f7857A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private Map f7858B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private com.google.android.material.carousel.c f7859C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final View.OnLayoutChangeListener f7860D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f7861E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f7862F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private int f7863G;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f7864s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f7865t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f7866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7867v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final c f7868w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.google.android.material.carousel.d f7869x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private g f7870y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private f f7871z;

    class a extends androidx.recyclerview.widget.h {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public PointF a(int i3) {
            return CarouselLayoutManager.this.e(i3);
        }

        @Override // androidx.recyclerview.widget.h
        public int t(View view, int i3) {
            if (CarouselLayoutManager.this.f7870y == null || !CarouselLayoutManager.this.f()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.g2(carouselLayoutManager.l0(view));
        }

        @Override // androidx.recyclerview.widget.h
        public int u(View view, int i3) {
            if (CarouselLayoutManager.this.f7870y == null || CarouselLayoutManager.this.f()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.g2(carouselLayoutManager.l0(view));
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f7873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f7874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f7875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final d f7876d;

        b(View view, float f3, float f4, d dVar) {
            this.f7873a = view;
            this.f7874b = f3;
            this.f7875c = f4;
            this.f7876d = dVar;
        }
    }

    private static class c extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Paint f7877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f7878b;

        c() {
            Paint paint = new Paint();
            this.f7877a = paint;
            this.f7878b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a3) {
            super.i(canvas, recyclerView, a3);
            this.f7877a.setStrokeWidth(recyclerView.getResources().getDimension(S0.c.f1594r));
            for (f.c cVar : this.f7878b) {
                this.f7877a.setColor(androidx.core.graphics.d.c(-65281, -16776961, cVar.f7909c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).f()) {
                    canvas.drawLine(cVar.f7908b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).A2(), cVar.f7908b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).v2(), this.f7877a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).x2(), cVar.f7908b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).y2(), cVar.f7908b, this.f7877a);
                }
            }
        }

        void j(List list) {
            this.f7878b = Collections.unmodifiableList(list);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f.c f7879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final f.c f7880b;

        d(f.c cVar, f.c cVar2) {
            p082z.h.a(cVar.f7907a <= cVar2.f7907a);
            this.f7879a = cVar;
            this.f7880b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A2() {
        return this.f7859C.j();
    }

    private int B2() {
        if (R() || !this.f7869x.f()) {
            return 0;
        }
        return u2() == 1 ? h0() : j0();
    }

    private int C2(int i3, f fVar) {
        return F2() ? (int) (((n2() - fVar.h().f7907a) - (i3 * fVar.f())) - (fVar.f() / 2.0f)) : (int) (((i3 * fVar.f()) - fVar.a().f7907a) + (fVar.f() / 2.0f));
    }

    private int D2(int i3, f fVar) {
        int i4 = Integer.MAX_VALUE;
        for (f.c cVar : fVar.e()) {
            float f3 = (i3 * fVar.f()) + (fVar.f() / 2.0f);
            int iN2 = (F2() ? (int) ((n2() - cVar.f7907a) - f3) : (int) (f3 - cVar.f7907a)) - this.f7864s;
            if (Math.abs(i4) > Math.abs(iN2)) {
                i4 = iN2;
            }
        }
        return i4;
    }

    private static d E2(List list, float f3, boolean z3) {
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        float f6 = Float.MAX_VALUE;
        float f7 = -3.4028235E38f;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < list.size(); i7++) {
            f.c cVar = (f.c) list.get(i7);
            float f8 = z3 ? cVar.f7908b : cVar.f7907a;
            float fAbs = Math.abs(f8 - f3);
            if (f8 <= f3 && fAbs <= f4) {
                i3 = i7;
                f4 = fAbs;
            }
            if (f8 > f3 && fAbs <= f5) {
                i5 = i7;
                f5 = fAbs;
            }
            if (f8 <= f6) {
                i4 = i7;
                f6 = f8;
            }
            if (f8 > f7) {
                i6 = i7;
                f7 = f8;
            }
        }
        if (i3 == -1) {
            i3 = i4;
        }
        if (i5 == -1) {
            i5 = i6;
        }
        return new d((f.c) list.get(i3), (f.c) list.get(i5));
    }

    private boolean G2(float f3, d dVar) {
        float fZ1 = Z1(f3, s2(f3, dVar) / 2.0f);
        if (F2()) {
            if (fZ1 >= 0.0f) {
                return false;
            }
        } else if (fZ1 <= n2()) {
            return false;
        }
        return true;
    }

    private boolean H2(float f3, d dVar) {
        float fY1 = Y1(f3, s2(f3, dVar) / 2.0f);
        if (F2()) {
            if (fY1 <= n2()) {
                return false;
            }
        } else if (fY1 >= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) {
            return;
        }
        view.post(new Runnable() { // from class: X0.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f2105a.N2();
            }
        });
    }

    private void J2() {
        if (this.f7867v && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i3 = 0; i3 < O(); i3++) {
                View viewN = N(i3);
                Log.d("CarouselLayoutManager", "item position " + l0(viewN) + ", center:" + o2(viewN) + ", child index:" + i3);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private b K2(RecyclerView.v vVar, float f3, int i3) {
        View viewO = vVar.o(i3);
        E0(viewO, 0, 0);
        float fY1 = Y1(f3, this.f7871z.f() / 2.0f);
        d dVarE2 = E2(this.f7871z.g(), fY1, false);
        return new b(viewO, fY1, d2(viewO, fY1, dVarE2), dVarE2);
    }

    private float L2(View view, float f3, float f4, Rect rect) {
        float fY1 = Y1(f3, f4);
        d dVarE2 = E2(this.f7871z.g(), fY1, false);
        float fD2 = d2(view, fY1, dVarE2);
        super.U(view, rect);
        V2(view, fY1, dVarE2);
        this.f7859C.l(view, rect, f4, fD2);
        return fD2;
    }

    private void M2(RecyclerView.v vVar) {
        View viewO = vVar.o(0);
        E0(viewO, 0, 0);
        f fVarG = this.f7869x.g(this, viewO);
        if (F2()) {
            fVarG = f.n(fVarG, n2());
        }
        this.f7870y = g.f(this, fVarG, p2(), r2(), B2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        this.f7870y = null;
        x1();
    }

    private void O2(RecyclerView.v vVar) {
        while (O() > 0) {
            View viewN = N(0);
            float fO2 = o2(viewN);
            if (!H2(fO2, E2(this.f7871z.g(), fO2, true))) {
                break;
            } else {
                q1(viewN, vVar);
            }
        }
        while (O() - 1 >= 0) {
            View viewN2 = N(O() - 1);
            float fO3 = o2(viewN2);
            if (!G2(fO3, E2(this.f7871z.g(), fO3, true))) {
                return;
            } else {
                q1(viewN2, vVar);
            }
        }
    }

    private int P2(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (O() == 0 || i3 == 0) {
            return 0;
        }
        if (this.f7870y == null) {
            M2(vVar);
        }
        int iH2 = h2(i3, this.f7864s, this.f7865t, this.f7866u);
        this.f7864s += iH2;
        W2(this.f7870y);
        float f3 = this.f7871z.f() / 2.0f;
        float fE2 = e2(l0(N(0)));
        Rect rect = new Rect();
        float f4 = F2() ? this.f7871z.h().f7908b : this.f7871z.a().f7908b;
        float f5 = Float.MAX_VALUE;
        for (int i4 = 0; i4 < O(); i4++) {
            View viewN = N(i4);
            float fAbs = Math.abs(f4 - L2(viewN, fE2, f3, rect));
            if (viewN != null && fAbs < f5) {
                this.f7862F = l0(viewN);
                f5 = fAbs;
            }
            fE2 = Y1(fE2, this.f7871z.f());
        }
        k2(vVar, a3);
        return iH2;
    }

    private void Q2(RecyclerView recyclerView, int i3) {
        if (f()) {
            recyclerView.scrollBy(i3, 0);
        } else {
            recyclerView.scrollBy(0, i3);
        }
    }

    private void S2(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f1779L0);
            R2(typedArrayObtainStyledAttributes.getInt(k.f1782M0, 0));
            U2(typedArrayObtainStyledAttributes.getInt(k.x5, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void V2(View view, float f3, d dVar) {
    }

    private void W2(g gVar) {
        int i3 = this.f7866u;
        int i4 = this.f7865t;
        if (i3 <= i4) {
            this.f7871z = F2() ? gVar.h() : gVar.l();
        } else {
            this.f7871z = gVar.j(this.f7864s, i4, i3);
        }
        this.f7868w.j(this.f7871z.g());
    }

    private void X1(View view, int i3, b bVar) {
        float f3 = this.f7871z.f() / 2.0f;
        j(view, i3);
        float f4 = bVar.f7875c;
        this.f7859C.k(view, (int) (f4 - f3), (int) (f4 + f3));
        V2(view, bVar.f7874b, bVar.f7876d);
    }

    private void X2() {
        int iB = b();
        int i3 = this.f7861E;
        if (iB == i3 || this.f7870y == null) {
            return;
        }
        if (this.f7869x.h(this, i3)) {
            N2();
        }
        this.f7861E = iB;
    }

    private float Y1(float f3, float f4) {
        return F2() ? f3 - f4 : f3 + f4;
    }

    private void Y2() {
        if (!this.f7867v || O() < 1) {
            return;
        }
        int i3 = 0;
        while (i3 < O() - 1) {
            int iL0 = l0(N(i3));
            int i4 = i3 + 1;
            int iL1 = l0(N(i4));
            if (iL0 > iL1) {
                J2();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i3 + "] had adapter position [" + iL0 + "] and child at index [" + i4 + "] had adapter position [" + iL1 + "].");
            }
            i3 = i4;
        }
    }

    private float Z1(float f3, float f4) {
        return F2() ? f3 + f4 : f3 - f4;
    }

    private void a2(RecyclerView.v vVar, int i3, int i4) {
        if (i3 < 0 || i3 >= b()) {
            return;
        }
        b bVarK2 = K2(vVar, e2(i3), i3);
        X1(bVarK2.f7873a, i4, bVarK2);
    }

    private void b2(RecyclerView.v vVar, RecyclerView.A a3, int i3) {
        float fE2 = e2(i3);
        while (i3 < a3.b()) {
            b bVarK2 = K2(vVar, fE2, i3);
            if (G2(bVarK2.f7875c, bVarK2.f7876d)) {
                return;
            }
            fE2 = Y1(fE2, this.f7871z.f());
            if (!H2(bVarK2.f7875c, bVarK2.f7876d)) {
                X1(bVarK2.f7873a, -1, bVarK2);
            }
            i3++;
        }
    }

    private void c2(RecyclerView.v vVar, int i3) {
        float fE2 = e2(i3);
        while (i3 >= 0) {
            b bVarK2 = K2(vVar, fE2, i3);
            if (H2(bVarK2.f7875c, bVarK2.f7876d)) {
                return;
            }
            fE2 = Z1(fE2, this.f7871z.f());
            if (!G2(bVarK2.f7875c, bVarK2.f7876d)) {
                X1(bVarK2.f7873a, 0, bVarK2);
            }
            i3--;
        }
    }

    private float d2(View view, float f3, d dVar) {
        f.c cVar = dVar.f7879a;
        float f4 = cVar.f7908b;
        f.c cVar2 = dVar.f7880b;
        float fB = T0.a.b(f4, cVar2.f7908b, cVar.f7907a, cVar2.f7907a, f3);
        if (dVar.f7880b != this.f7871z.c() && dVar.f7879a != this.f7871z.j()) {
            return fB;
        }
        float fD = this.f7859C.d((RecyclerView.p) view.getLayoutParams()) / this.f7871z.f();
        f.c cVar3 = dVar.f7880b;
        return fB + ((f3 - cVar3.f7907a) * ((1.0f - cVar3.f7909c) + fD));
    }

    private float e2(int i3) {
        return Y1(z2() - this.f7864s, this.f7871z.f() * i3);
    }

    private int f2(RecyclerView.A a3, g gVar) {
        boolean zF2 = F2();
        f fVarL = zF2 ? gVar.l() : gVar.h();
        f.c cVarA = zF2 ? fVarL.a() : fVarL.h();
        int iB = (int) (((((a3.b() - 1) * fVarL.f()) * (zF2 ? -1.0f : 1.0f)) - (cVarA.f7907a - z2())) + (w2() - cVarA.f7907a) + (zF2 ? -cVarA.f7913g : cVarA.f7914h));
        return zF2 ? Math.min(0, iB) : Math.max(0, iB);
    }

    private static int h2(int i3, int i4, int i5, int i6) {
        int i7 = i4 + i3;
        if (i7 < i5) {
            return i5 - i4;
        }
        return i7 > i6 ? i6 - i4 : i3;
    }

    private int i2(g gVar) {
        boolean zF2 = F2();
        f fVarH = zF2 ? gVar.h() : gVar.l();
        return (int) (z2() - Z1((zF2 ? fVarH.h() : fVarH.a()).f7907a, fVarH.f() / 2.0f));
    }

    private int j2(int i3) {
        int iU2 = u2();
        if (i3 == 1) {
            return -1;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 17) {
            if (iU2 == 0) {
                return F2() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return iU2 == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 66) {
            if (iU2 == 0) {
                return F2() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i3 == 130) {
            return iU2 == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i3);
        return Integer.MIN_VALUE;
    }

    private void k2(RecyclerView.v vVar, RecyclerView.A a3) {
        O2(vVar);
        if (O() == 0) {
            c2(vVar, this.f7857A - 1);
            b2(vVar, a3, this.f7857A);
        } else {
            int iL0 = l0(N(0));
            int iL1 = l0(N(O() - 1));
            c2(vVar, iL0 - 1);
            b2(vVar, a3, iL1 + 1);
        }
        Y2();
    }

    private View l2() {
        return N(F2() ? 0 : O() - 1);
    }

    private View m2() {
        return N(F2() ? O() - 1 : 0);
    }

    private int n2() {
        return f() ? a() : d();
    }

    private float o2(View view) {
        Rect rect = new Rect();
        super.U(view, rect);
        return f() ? rect.centerX() : rect.centerY();
    }

    private int p2() {
        int i3;
        int i4;
        if (O() <= 0) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) N(0).getLayoutParams();
        if (this.f7859C.f7889a == 0) {
            i3 = ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
            i4 = ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        } else {
            i3 = ((ViewGroup.MarginLayoutParams) pVar).topMargin;
            i4 = ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }
        return i3 + i4;
    }

    private f q2(int i3) {
        f fVar;
        Map map = this.f7858B;
        return (map == null || (fVar = (f) map.get(Integer.valueOf(p076x.a.b(i3, 0, Math.max(0, b() + (-1)))))) == null) ? this.f7870y.g() : fVar;
    }

    private int r2() {
        if (R() || !this.f7869x.f()) {
            return 0;
        }
        return u2() == 1 ? k0() : i0();
    }

    private float s2(float f3, d dVar) {
        f.c cVar = dVar.f7879a;
        float f4 = cVar.f7910d;
        f.c cVar2 = dVar.f7880b;
        return T0.a.b(f4, cVar2.f7910d, cVar.f7908b, cVar2.f7908b, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v2() {
        return this.f7859C.e();
    }

    private int w2() {
        return this.f7859C.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x2() {
        return this.f7859C.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y2() {
        return this.f7859C.h();
    }

    private int z2() {
        return this.f7859C.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.A a3) {
        return this.f7866u - this.f7865t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (p()) {
            return P2(i3, vVar, a3);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void B1(int i3) {
        this.f7862F = i3;
        if (this.f7870y == null) {
            return;
        }
        this.f7864s = C2(i3, q2(i3));
        this.f7857A = p076x.a.b(i3, 0, Math.max(0, b() - 1));
        W2(this.f7870y);
        x1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        if (q()) {
            return P2(i3, vVar, a3);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E0(View view, int i3, int i4) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    boolean F2() {
        return f() && d0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p I() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(RecyclerView recyclerView) {
        super.K0(recyclerView);
        this.f7869x.e(recyclerView.getContext());
        N2();
        recyclerView.addOnLayoutChangeListener(this.f7860D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.M0(recyclerView, vVar);
        recyclerView.removeOnLayoutChangeListener(this.f7860D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M1(RecyclerView recyclerView, RecyclerView.A a3, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i3);
        N1(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View N0(View view, int i3, RecyclerView.v vVar, RecyclerView.A a3) {
        int iJ2;
        if (O() == 0 || (iJ2 = j2(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iJ2 == -1) {
            if (l0(view) == 0) {
                return null;
            }
            a2(vVar, l0(N(0)) - 1, 0);
            return m2();
        }
        if (l0(view) == b() - 1) {
            return null;
        }
        a2(vVar, l0(N(O() - 1)) + 1, -1);
        return l2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(AccessibilityEvent accessibilityEvent) {
        super.O0(accessibilityEvent);
        if (O() > 0) {
            accessibilityEvent.setFromIndex(l0(N(0)));
            accessibilityEvent.setToIndex(l0(N(O() - 1)));
        }
    }

    public void R2(int i3) {
        this.f7863G = i3;
        N2();
    }

    public void T2(com.google.android.material.carousel.d dVar) {
        this.f7869x = dVar;
        N2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U(View view, Rect rect) {
        super.U(view, rect);
        float fCenterY = rect.centerY();
        if (f()) {
            fCenterY = rect.centerX();
        }
        float fS2 = s2(fCenterY, E2(this.f7871z.g(), fCenterY, true));
        float fWidth = f() ? (rect.width() - fS2) / 2.0f : 0.0f;
        float fHeight = f() ? 0.0f : (rect.height() - fS2) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public void U2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        l(null);
        com.google.android.material.carousel.c cVar = this.f7859C;
        if (cVar == null || i3 != cVar.f7889a) {
            this.f7859C = com.google.android.material.carousel.c.b(this, i3);
            N2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i3, int i4) {
        super.V0(recyclerView, i3, i4);
        X2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView, int i3, int i4) {
        super.Y0(recyclerView, i3, i4);
        X2();
    }

    @Override // com.google.android.material.carousel.b
    public int a() {
        return s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView.v vVar, RecyclerView.A a3) {
        if (a3.b() <= 0 || n2() <= 0.0f) {
            o1(vVar);
            this.f7857A = 0;
            return;
        }
        boolean zF2 = F2();
        boolean z3 = this.f7870y == null;
        if (z3) {
            M2(vVar);
        }
        int iI2 = i2(this.f7870y);
        int iF2 = f2(a3, this.f7870y);
        this.f7865t = zF2 ? iF2 : iI2;
        if (zF2) {
            iF2 = iI2;
        }
        this.f7866u = iF2;
        if (z3) {
            this.f7864s = iI2;
            this.f7858B = this.f7870y.i(b(), this.f7865t, this.f7866u, F2());
            int i3 = this.f7862F;
            if (i3 != -1) {
                this.f7864s = C2(i3, q2(i3));
            }
        }
        int i4 = this.f7864s;
        this.f7864s = i4 + h2(0, i4, this.f7865t, this.f7866u);
        this.f7857A = p076x.a.b(this.f7857A, 0, a3.b());
        W2(this.f7870y);
        B(vVar);
        k2(vVar, a3);
        this.f7861E = b();
    }

    @Override // com.google.android.material.carousel.b
    public int c() {
        return this.f7863G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView.A a3) {
        super.c1(a3);
        if (O() == 0) {
            this.f7857A = 0;
        } else {
            this.f7857A = l0(N(0));
        }
        Y2();
    }

    @Override // com.google.android.material.carousel.b
    public int d() {
        return b0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF e(int i3) {
        if (this.f7870y == null) {
            return null;
        }
        int iT2 = t2(i3, q2(i3));
        return f() ? new PointF(iT2, 0.0f) : new PointF(0.0f, iT2);
    }

    @Override // com.google.android.material.carousel.b
    public boolean f() {
        return this.f7859C.f7889a == 0;
    }

    int g2(int i3) {
        return (int) (this.f7864s - C2(i3, q2(i3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean p() {
        return f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean q() {
        return !f();
    }

    int t2(int i3, f fVar) {
        return C2(i3, fVar) - this.f7864s;
    }

    public int u2() {
        return this.f7859C.f7889a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.A a3) {
        if (O() == 0 || this.f7870y == null || b() <= 1) {
            return 0;
        }
        return (int) (s0() * (this.f7870y.g().f() / x(a3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.A a3) {
        return this.f7864s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w1(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
        int iD2;
        if (this.f7870y == null || (iD2 = D2(l0(view), q2(l0(view)))) == 0) {
            return false;
        }
        Q2(recyclerView, D2(l0(view), this.f7870y.j(this.f7864s + h2(iD2, this.f7864s, this.f7865t, this.f7866u), this.f7865t, this.f7866u)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.A a3) {
        return this.f7866u - this.f7865t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.A a3) {
        if (O() == 0 || this.f7870y == null || b() <= 1) {
            return 0;
        }
        return (int) (b0() * (this.f7870y.g().f() / A(a3)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z(RecyclerView.A a3) {
        return this.f7864s;
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar) {
        this(dVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar, int i3) {
        this.f7867v = false;
        this.f7868w = new c();
        this.f7857A = 0;
        this.f7860D = new View.OnLayoutChangeListener() { // from class: X0.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                this.f2104a.I2(view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        };
        this.f7862F = -1;
        this.f7863G = 0;
        T2(dVar);
        U2(i3);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f7867v = false;
        this.f7868w = new c();
        this.f7857A = 0;
        this.f7860D = new View.OnLayoutChangeListener() { // from class: X0.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                this.f2104a.I2(view, i5, i6, i7, i8, i9, i10, i11, i12);
            }
        };
        this.f7862F = -1;
        this.f7863G = 0;
        T2(new h());
        S2(context, attributeSet);
    }
}
