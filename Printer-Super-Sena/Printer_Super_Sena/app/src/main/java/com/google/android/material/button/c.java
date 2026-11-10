package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.appcompat.widget.AbstractC0272p;
import androidx.core.view.Z;
import com.google.android.material.internal.F;
import p042l1.g;
import p042l1.k;
import p042l1.n;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f7835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final boolean f7836v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f7837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f7838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f7845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f7846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f7847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f7848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f7849m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7853q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LayerDrawable f7855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f7856t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7850n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7851o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7852p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7854r = true;

    static {
        int i3 = Build.VERSION.SDK_INT;
        boolean z3 = false;
        f7835u = i3 >= 21;
        if (i3 >= 21 && i3 <= 22) {
            z3 = true;
        }
        f7836v = z3;
    }

    c(MaterialButton materialButton, k kVar) {
        this.f7837a = materialButton;
        this.f7838b = kVar;
    }

    private void G(int i3, int i4) {
        int iH = Z.H(this.f7837a);
        int paddingTop = this.f7837a.getPaddingTop();
        int iG = Z.G(this.f7837a);
        int paddingBottom = this.f7837a.getPaddingBottom();
        int i5 = this.f7841e;
        int i6 = this.f7842f;
        this.f7842f = i4;
        this.f7841e = i3;
        if (!this.f7851o) {
            H();
        }
        Z.E0(this.f7837a, iH, (paddingTop + i3) - i5, iG, (paddingBottom + i4) - i6);
    }

    private void H() {
        this.f7837a.setInternalBackground(a());
        g gVarF = f();
        if (gVarF != null) {
            gVarF.U(this.f7856t);
            gVarF.setState(this.f7837a.getDrawableState());
        }
    }

    private void I(k kVar) {
        if (f7836v && !this.f7851o) {
            int iH = Z.H(this.f7837a);
            int paddingTop = this.f7837a.getPaddingTop();
            int iG = Z.G(this.f7837a);
            int paddingBottom = this.f7837a.getPaddingBottom();
            H();
            Z.E0(this.f7837a, iH, paddingTop, iG, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void K() {
        g gVarF = f();
        g gVarN = n();
        if (gVarF != null) {
            gVarF.a0(this.f7844h, this.f7847k);
            if (gVarN != null) {
                gVarN.Z(this.f7844h, this.f7850n ? p002a1.a.d(this.f7837a, S0.a.f1521m) : 0);
            }
        }
    }

    private InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.f7839c, this.f7841e, this.f7840d, this.f7842f);
    }

    private Drawable a() {
        g gVar = new g(this.f7838b);
        gVar.K(this.f7837a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.f7846j);
        PorterDuff.Mode mode = this.f7845i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.a0(this.f7844h, this.f7847k);
        g gVar2 = new g(this.f7838b);
        gVar2.setTint(0);
        gVar2.Z(this.f7844h, this.f7850n ? p002a1.a.d(this.f7837a, S0.a.f1521m) : 0);
        if (f7835u) {
            g gVar3 = new g(this.f7838b);
            this.f7849m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(p033i1.b.e(this.f7848l), L(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f7849m);
            this.f7855s = rippleDrawable;
            return rippleDrawable;
        }
        p033i1.a aVar = new p033i1.a(this.f7838b);
        this.f7849m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, p033i1.b.e(this.f7848l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f7849m});
        this.f7855s = layerDrawable;
        return L(layerDrawable);
    }

    private g g(boolean z3) {
        LayerDrawable layerDrawable = this.f7855s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f7835u ? (g) ((LayerDrawable) ((InsetDrawable) this.f7855s.getDrawable(0)).getDrawable()).getDrawable(!z3 ? 1 : 0) : (g) this.f7855s.getDrawable(!z3 ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    void A(boolean z3) {
        this.f7850n = z3;
        K();
    }

    void B(ColorStateList colorStateList) {
        if (this.f7847k != colorStateList) {
            this.f7847k = colorStateList;
            K();
        }
    }

    void C(int i3) {
        if (this.f7844h != i3) {
            this.f7844h = i3;
            K();
        }
    }

    void D(ColorStateList colorStateList) {
        if (this.f7846j != colorStateList) {
            this.f7846j = colorStateList;
            if (f() != null) {
                androidx.core.graphics.drawable.a.o(f(), this.f7846j);
            }
        }
    }

    void E(PorterDuff.Mode mode) {
        if (this.f7845i != mode) {
            this.f7845i = mode;
            if (f() == null || this.f7845i == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(f(), this.f7845i);
        }
    }

    void F(boolean z3) {
        this.f7854r = z3;
    }

    void J(int i3, int i4) {
        Drawable drawable = this.f7849m;
        if (drawable != null) {
            drawable.setBounds(this.f7839c, this.f7841e, i4 - this.f7840d, i3 - this.f7842f);
        }
    }

    int b() {
        return this.f7843g;
    }

    public int c() {
        return this.f7842f;
    }

    public int d() {
        return this.f7841e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f7855s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f7855s.getNumberOfLayers() > 2 ? (n) this.f7855s.getDrawable(2) : (n) this.f7855s.getDrawable(1);
    }

    g f() {
        return g(false);
    }

    ColorStateList h() {
        return this.f7848l;
    }

    k i() {
        return this.f7838b;
    }

    ColorStateList j() {
        return this.f7847k;
    }

    int k() {
        return this.f7844h;
    }

    ColorStateList l() {
        return this.f7846j;
    }

    PorterDuff.Mode m() {
        return this.f7845i;
    }

    boolean o() {
        return this.f7851o;
    }

    boolean p() {
        return this.f7853q;
    }

    boolean q() {
        return this.f7854r;
    }

    void r(TypedArray typedArray) {
        this.f7839c = typedArray.getDimensionPixelOffset(S0.k.Q2, 0);
        this.f7840d = typedArray.getDimensionPixelOffset(S0.k.R2, 0);
        this.f7841e = typedArray.getDimensionPixelOffset(S0.k.S2, 0);
        this.f7842f = typedArray.getDimensionPixelOffset(S0.k.T2, 0);
        int i3 = S0.k.X2;
        if (typedArray.hasValue(i3)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i3, -1);
            this.f7843g = dimensionPixelSize;
            z(this.f7838b.w(dimensionPixelSize));
            this.f7852p = true;
        }
        this.f7844h = typedArray.getDimensionPixelSize(S0.k.h3, 0);
        this.f7845i = F.i(typedArray.getInt(S0.k.W2, -1), PorterDuff.Mode.SRC_IN);
        this.f7846j = p030h1.c.a(this.f7837a.getContext(), typedArray, S0.k.V2);
        this.f7847k = p030h1.c.a(this.f7837a.getContext(), typedArray, S0.k.g3);
        this.f7848l = p030h1.c.a(this.f7837a.getContext(), typedArray, S0.k.f3);
        this.f7853q = typedArray.getBoolean(S0.k.U2, false);
        this.f7856t = typedArray.getDimensionPixelSize(S0.k.Y2, 0);
        this.f7854r = typedArray.getBoolean(S0.k.i3, true);
        int iH = Z.H(this.f7837a);
        int paddingTop = this.f7837a.getPaddingTop();
        int iG = Z.G(this.f7837a);
        int paddingBottom = this.f7837a.getPaddingBottom();
        if (typedArray.hasValue(S0.k.P2)) {
            t();
        } else {
            H();
        }
        Z.E0(this.f7837a, iH + this.f7839c, paddingTop + this.f7841e, iG + this.f7840d, paddingBottom + this.f7842f);
    }

    void s(int i3) {
        if (f() != null) {
            f().setTint(i3);
        }
    }

    void t() {
        this.f7851o = true;
        this.f7837a.setSupportBackgroundTintList(this.f7846j);
        this.f7837a.setSupportBackgroundTintMode(this.f7845i);
    }

    void u(boolean z3) {
        this.f7853q = z3;
    }

    void v(int i3) {
        if (this.f7852p && this.f7843g == i3) {
            return;
        }
        this.f7843g = i3;
        this.f7852p = true;
        z(this.f7838b.w(i3));
    }

    public void w(int i3) {
        G(this.f7841e, i3);
    }

    public void x(int i3) {
        G(i3, this.f7842f);
    }

    void y(ColorStateList colorStateList) {
        if (this.f7848l != colorStateList) {
            this.f7848l = colorStateList;
            boolean z3 = f7835u;
            if (z3 && AbstractC0272p.a(this.f7837a.getBackground())) {
                a.a(this.f7837a.getBackground()).setColor(p033i1.b.e(colorStateList));
            } else {
                if (z3 || !(this.f7837a.getBackground() instanceof p033i1.a)) {
                    return;
                }
                ((p033i1.a) this.f7837a.getBackground()).setTintList(p033i1.b.e(colorStateList));
            }
        }
    }

    void z(k kVar) {
        this.f7838b = kVar;
        I(kVar);
    }
}
