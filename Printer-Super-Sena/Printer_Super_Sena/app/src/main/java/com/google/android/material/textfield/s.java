package com.google.android.material.textfield;

import A.AbstractC0157c;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.j0;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.Z;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
class s extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f8673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f8674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CheckableImageButton f8675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f8676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f8677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnLongClickListener f8678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CheckableImageButton f8679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d f8680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashSet f8682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f8683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f8684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView.ScaleType f8686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View.OnLongClickListener f8687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f8688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TextView f8689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f8690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private EditText f8691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AccessibilityManager f8692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AbstractC0157c.a f8693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TextWatcher f8694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TextInputLayout.f f8695w;

    class a extends com.google.android.material.internal.B {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            s.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.B, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            s.this.m().b(charSequence, i3, i4, i5);
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            if (s.this.f8691s == textInputLayout.getEditText()) {
                return;
            }
            if (s.this.f8691s != null) {
                s.this.f8691s.removeTextChangedListener(s.this.f8694v);
                if (s.this.f8691s.getOnFocusChangeListener() == s.this.m().e()) {
                    s.this.f8691s.setOnFocusChangeListener(null);
                }
            }
            s.this.f8691s = textInputLayout.getEditText();
            if (s.this.f8691s != null) {
                s.this.f8691s.addTextChangedListener(s.this.f8694v);
            }
            s.this.m().n(s.this.f8691s);
            s sVar = s.this;
            sVar.h0(sVar.m());
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            s.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            s.this.M();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray f8699a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f8700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8702d;

        d(s sVar, j0 j0Var) {
            this.f8700b = sVar;
            this.f8701c = j0Var.n(S0.k.P7, 0);
            this.f8702d = j0Var.n(S0.k.n8, 0);
        }

        private t b(int i3) {
            if (i3 == -1) {
                return new C0503g(this.f8700b);
            }
            if (i3 == 0) {
                return new x(this.f8700b);
            }
            if (i3 == 1) {
                return new z(this.f8700b, this.f8702d);
            }
            if (i3 == 2) {
                return new C0502f(this.f8700b);
            }
            if (i3 == 3) {
                return new q(this.f8700b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i3);
        }

        t c(int i3) {
            t tVar = (t) this.f8699a.get(i3);
            if (tVar != null) {
                return tVar;
            }
            t tVarB = b(i3);
            this.f8699a.append(i3, tVarB);
            return tVarB;
        }
    }

    s(TextInputLayout textInputLayout, j0 j0Var) {
        super(textInputLayout.getContext());
        this.f8681i = 0;
        this.f8682j = new LinkedHashSet();
        this.f8694v = new a();
        b bVar = new b();
        this.f8695w = bVar;
        this.f8692t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f8673a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f8674b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, S0.e.f1624J);
        this.f8675c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, S0.e.f1623I);
        this.f8679g = checkableImageButtonI2;
        this.f8680h = new d(this, j0Var);
        androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(getContext());
        this.f8689q = f3;
        C(j0Var);
        B(j0Var);
        D(j0Var);
        frameLayout.addView(checkableImageButtonI2);
        addView(f3);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.i(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B(j0 j0Var) {
        int i3 = S0.k.o8;
        if (!j0Var.s(i3)) {
            int i4 = S0.k.T7;
            if (j0Var.s(i4)) {
                this.f8683k = p030h1.c.b(getContext(), j0Var, i4);
            }
            int i5 = S0.k.U7;
            if (j0Var.s(i5)) {
                this.f8684l = com.google.android.material.internal.F.i(j0Var.k(i5, -1), null);
            }
        }
        int i6 = S0.k.R7;
        if (j0Var.s(i6)) {
            U(j0Var.k(i6, 0));
            int i7 = S0.k.O7;
            if (j0Var.s(i7)) {
                Q(j0Var.p(i7));
            }
            O(j0Var.a(S0.k.N7, true));
        } else if (j0Var.s(i3)) {
            int i8 = S0.k.p8;
            if (j0Var.s(i8)) {
                this.f8683k = p030h1.c.b(getContext(), j0Var, i8);
            }
            int i9 = S0.k.q8;
            if (j0Var.s(i9)) {
                this.f8684l = com.google.android.material.internal.F.i(j0Var.k(i9, -1), null);
            }
            U(j0Var.a(i3, false) ? 1 : 0);
            Q(j0Var.p(S0.k.m8));
        }
        T(j0Var.f(S0.k.Q7, getResources().getDimensionPixelSize(S0.c.f1574d0)));
        int i10 = S0.k.S7;
        if (j0Var.s(i10)) {
            X(u.b(j0Var.k(i10, -1)));
        }
    }

    private void C(j0 j0Var) {
        int i3 = S0.k.Z7;
        if (j0Var.s(i3)) {
            this.f8676d = p030h1.c.b(getContext(), j0Var, i3);
        }
        int i4 = S0.k.a8;
        if (j0Var.s(i4)) {
            this.f8677e = com.google.android.material.internal.F.i(j0Var.k(i4, -1), null);
        }
        int i5 = S0.k.Y7;
        if (j0Var.s(i5)) {
            c0(j0Var.g(i5));
        }
        this.f8675c.setContentDescription(getResources().getText(S0.i.f1693f));
        Z.z0(this.f8675c, 2);
        this.f8675c.setClickable(false);
        this.f8675c.setPressable(false);
        this.f8675c.setFocusable(false);
    }

    private void D(j0 j0Var) {
        this.f8689q.setVisibility(8);
        this.f8689q.setId(S0.e.f1630P);
        this.f8689q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        Z.s0(this.f8689q, 1);
        q0(j0Var.n(S0.k.F8, 0));
        int i3 = S0.k.G8;
        if (j0Var.s(i3)) {
            r0(j0Var.c(i3));
        }
        p0(j0Var.p(S0.k.E8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AbstractC0157c.a aVar = this.f8693u;
        if (aVar == null || (accessibilityManager = this.f8692t) == null) {
            return;
        }
        AbstractC0157c.b(accessibilityManager, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f8693u == null || this.f8692t == null || !Z.T(this)) {
            return;
        }
        AbstractC0157c.a(this.f8692t, this.f8693u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(t tVar) {
        if (this.f8691s == null) {
            return;
        }
        if (tVar.e() != null) {
            this.f8691s.setOnFocusChangeListener(tVar.e());
        }
        if (tVar.g() != null) {
            this.f8679g.setOnFocusChangeListener(tVar.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i3) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(S0.g.f1668i, viewGroup, false);
        checkableImageButton.setId(i3);
        u.e(checkableImageButton);
        if (p030h1.c.h(getContext())) {
            AbstractC0321u.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i3) {
        Iterator it = this.f8682j.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.H.a(it.next());
            throw null;
        }
    }

    private void s0(t tVar) {
        tVar.s();
        this.f8693u = tVar.h();
        g();
    }

    private int t(t tVar) {
        int i3 = this.f8680h.f8701c;
        return i3 == 0 ? tVar.d() : i3;
    }

    private void t0(t tVar) {
        M();
        this.f8693u = null;
        tVar.u();
    }

    private void u0(boolean z3) {
        if (!z3 || n() == null) {
            u.a(this.f8673a, this.f8679g, this.f8683k, this.f8684l);
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(n()).mutate();
        androidx.core.graphics.drawable.a.n(drawableMutate, this.f8673a.getErrorCurrentTextColors());
        this.f8679g.setImageDrawable(drawableMutate);
    }

    private void v0() {
        this.f8674b.setVisibility((this.f8679g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility((F() || G() || ((this.f8688p == null || this.f8690r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    private void w0() {
        this.f8675c.setVisibility(s() != null && this.f8673a.N() && this.f8673a.d0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.f8673a.o0();
    }

    private void y0() {
        int visibility = this.f8689q.getVisibility();
        int i3 = (this.f8688p == null || this.f8690r) ? 8 : 0;
        if (visibility != i3) {
            m().q(i3 == 0);
        }
        v0();
        this.f8689q.setVisibility(i3);
        this.f8673a.o0();
    }

    boolean A() {
        return this.f8681i != 0;
    }

    boolean E() {
        return A() && this.f8679g.isChecked();
    }

    boolean F() {
        return this.f8674b.getVisibility() == 0 && this.f8679g.getVisibility() == 0;
    }

    boolean G() {
        return this.f8675c.getVisibility() == 0;
    }

    void H(boolean z3) {
        this.f8690r = z3;
        y0();
    }

    void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f8673a.d0());
        }
    }

    void J() {
        u.d(this.f8673a, this.f8679g, this.f8683k);
    }

    void K() {
        u.d(this.f8673a, this.f8675c, this.f8676d);
    }

    void L(boolean z3) {
        boolean z4;
        boolean zIsActivated;
        boolean zIsChecked;
        t tVarM = m();
        boolean z5 = true;
        if (!tVarM.l() || (zIsChecked = this.f8679g.isChecked()) == tVarM.m()) {
            z4 = false;
        } else {
            this.f8679g.setChecked(!zIsChecked);
            z4 = true;
        }
        if (!tVarM.j() || (zIsActivated = this.f8679g.isActivated()) == tVarM.k()) {
            z5 = z4;
        } else {
            N(!zIsActivated);
        }
        if (z3 || z5) {
            J();
        }
    }

    void N(boolean z3) {
        this.f8679g.setActivated(z3);
    }

    void O(boolean z3) {
        this.f8679g.setCheckable(z3);
    }

    void P(int i3) {
        Q(i3 != 0 ? getResources().getText(i3) : null);
    }

    void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f8679g.setContentDescription(charSequence);
        }
    }

    void R(int i3) {
        S(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    void S(Drawable drawable) {
        this.f8679g.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f8673a, this.f8679g, this.f8683k, this.f8684l);
            J();
        }
    }

    void T(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i3 != this.f8685m) {
            this.f8685m = i3;
            u.g(this.f8679g, i3);
            u.g(this.f8675c, i3);
        }
    }

    void U(int i3) {
        if (this.f8681i == i3) {
            return;
        }
        t0(m());
        int i4 = this.f8681i;
        this.f8681i = i3;
        j(i4);
        a0(i3 != 0);
        t tVarM = m();
        R(t(tVarM));
        P(tVarM.c());
        O(tVarM.l());
        if (!tVarM.i(this.f8673a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f8673a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i3);
        }
        s0(tVarM);
        V(tVarM.f());
        EditText editText = this.f8691s;
        if (editText != null) {
            tVarM.n(editText);
            h0(tVarM);
        }
        u.a(this.f8673a, this.f8679g, this.f8683k, this.f8684l);
        L(true);
    }

    void V(View.OnClickListener onClickListener) {
        u.h(this.f8679g, onClickListener, this.f8687o);
    }

    void W(View.OnLongClickListener onLongClickListener) {
        this.f8687o = onLongClickListener;
        u.i(this.f8679g, onLongClickListener);
    }

    void X(ImageView.ScaleType scaleType) {
        this.f8686n = scaleType;
        u.j(this.f8679g, scaleType);
        u.j(this.f8675c, scaleType);
    }

    void Y(ColorStateList colorStateList) {
        if (this.f8683k != colorStateList) {
            this.f8683k = colorStateList;
            u.a(this.f8673a, this.f8679g, colorStateList, this.f8684l);
        }
    }

    void Z(PorterDuff.Mode mode) {
        if (this.f8684l != mode) {
            this.f8684l = mode;
            u.a(this.f8673a, this.f8679g, this.f8683k, mode);
        }
    }

    void a0(boolean z3) {
        if (F() != z3) {
            this.f8679g.setVisibility(z3 ? 0 : 8);
            v0();
            x0();
            this.f8673a.o0();
        }
    }

    void b0(int i3) {
        c0(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
        K();
    }

    void c0(Drawable drawable) {
        this.f8675c.setImageDrawable(drawable);
        w0();
        u.a(this.f8673a, this.f8675c, this.f8676d, this.f8677e);
    }

    void d0(View.OnClickListener onClickListener) {
        u.h(this.f8675c, onClickListener, this.f8678f);
    }

    void e0(View.OnLongClickListener onLongClickListener) {
        this.f8678f = onLongClickListener;
        u.i(this.f8675c, onLongClickListener);
    }

    void f0(ColorStateList colorStateList) {
        if (this.f8676d != colorStateList) {
            this.f8676d = colorStateList;
            u.a(this.f8673a, this.f8675c, colorStateList, this.f8677e);
        }
    }

    void g0(PorterDuff.Mode mode) {
        if (this.f8677e != mode) {
            this.f8677e = mode;
            u.a(this.f8673a, this.f8675c, this.f8676d, mode);
        }
    }

    void h() {
        this.f8679g.performClick();
        this.f8679g.jumpDrawablesToCurrentState();
    }

    void i0(int i3) {
        j0(i3 != 0 ? getResources().getText(i3) : null);
    }

    void j0(CharSequence charSequence) {
        this.f8679g.setContentDescription(charSequence);
    }

    CheckableImageButton k() {
        if (G()) {
            return this.f8675c;
        }
        if (A() && F()) {
            return this.f8679g;
        }
        return null;
    }

    void k0(int i3) {
        l0(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    CharSequence l() {
        return this.f8679g.getContentDescription();
    }

    void l0(Drawable drawable) {
        this.f8679g.setImageDrawable(drawable);
    }

    t m() {
        return this.f8680h.c(this.f8681i);
    }

    void m0(boolean z3) {
        if (z3 && this.f8681i != 1) {
            U(1);
        } else {
            if (z3) {
                return;
            }
            U(0);
        }
    }

    Drawable n() {
        return this.f8679g.getDrawable();
    }

    void n0(ColorStateList colorStateList) {
        this.f8683k = colorStateList;
        u.a(this.f8673a, this.f8679g, colorStateList, this.f8684l);
    }

    int o() {
        return this.f8685m;
    }

    void o0(PorterDuff.Mode mode) {
        this.f8684l = mode;
        u.a(this.f8673a, this.f8679g, this.f8683k, mode);
    }

    int p() {
        return this.f8681i;
    }

    void p0(CharSequence charSequence) {
        this.f8688p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f8689q.setText(charSequence);
        y0();
    }

    ImageView.ScaleType q() {
        return this.f8686n;
    }

    void q0(int i3) {
        androidx.core.widget.j.o(this.f8689q, i3);
    }

    CheckableImageButton r() {
        return this.f8679g;
    }

    void r0(ColorStateList colorStateList) {
        this.f8689q.setTextColor(colorStateList);
    }

    Drawable s() {
        return this.f8675c.getDrawable();
    }

    CharSequence u() {
        return this.f8679g.getContentDescription();
    }

    Drawable v() {
        return this.f8679g.getDrawable();
    }

    CharSequence w() {
        return this.f8688p;
    }

    ColorStateList x() {
        return this.f8689q.getTextColors();
    }

    void x0() {
        if (this.f8673a.f8578d == null) {
            return;
        }
        Z.E0(this.f8689q, getContext().getResources().getDimensionPixelSize(S0.c.f1551K), this.f8673a.f8578d.getPaddingTop(), (F() || G()) ? 0 : Z.G(this.f8673a.f8578d), this.f8673a.f8578d.getPaddingBottom());
    }

    int y() {
        return Z.G(this) + Z.G(this.f8689q) + ((F() || G()) ? this.f8679g.getMeasuredWidth() + AbstractC0321u.b((ViewGroup.MarginLayoutParams) this.f8679g.getLayoutParams()) : 0);
    }

    TextView z() {
        return this.f8689q;
    }
}
