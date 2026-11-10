package com.google.android.material.textfield;

import A.T;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.j0;
import androidx.core.view.AbstractC0321u;
import androidx.core.view.Z;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
class A extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f8532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f8533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f8534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f8535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f8536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f8537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView.ScaleType f8539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f8540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8541j;

    A(TextInputLayout textInputLayout, j0 j0Var) {
        super(textInputLayout.getContext());
        this.f8532a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(S0.g.f1669j, (ViewGroup) this, false);
        this.f8535d = checkableImageButton;
        u.e(checkableImageButton);
        androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(getContext());
        this.f8533b = f3;
        j(j0Var);
        i(j0Var);
        addView(checkableImageButton);
        addView(f3);
    }

    private void C() {
        int i3 = (this.f8534c == null || this.f8541j) ? 8 : 0;
        setVisibility((this.f8535d.getVisibility() == 0 || i3 == 0) ? 0 : 8);
        this.f8533b.setVisibility(i3);
        this.f8532a.o0();
    }

    private void i(j0 j0Var) {
        this.f8533b.setVisibility(8);
        this.f8533b.setId(S0.e.f1629O);
        this.f8533b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Z.s0(this.f8533b, 1);
        o(j0Var.n(S0.k.v8, 0));
        int i3 = S0.k.w8;
        if (j0Var.s(i3)) {
            p(j0Var.c(i3));
        }
        n(j0Var.p(S0.k.u8));
    }

    private void j(j0 j0Var) {
        if (p030h1.c.h(getContext())) {
            AbstractC0321u.c((ViewGroup.MarginLayoutParams) this.f8535d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i3 = S0.k.C8;
        if (j0Var.s(i3)) {
            this.f8536e = p030h1.c.b(getContext(), j0Var, i3);
        }
        int i4 = S0.k.D8;
        if (j0Var.s(i4)) {
            this.f8537f = com.google.android.material.internal.F.i(j0Var.k(i4, -1), null);
        }
        int i5 = S0.k.z8;
        if (j0Var.s(i5)) {
            s(j0Var.g(i5));
            int i6 = S0.k.y8;
            if (j0Var.s(i6)) {
                r(j0Var.p(i6));
            }
            q(j0Var.a(S0.k.x8, true));
        }
        t(j0Var.f(S0.k.A8, getResources().getDimensionPixelSize(S0.c.f1574d0)));
        int i7 = S0.k.B8;
        if (j0Var.s(i7)) {
            w(u.b(j0Var.k(i7, -1)));
        }
    }

    void A(T t3) {
        if (this.f8533b.getVisibility() != 0) {
            t3.M0(this.f8535d);
        } else {
            t3.x0(this.f8533b);
            t3.M0(this.f8533b);
        }
    }

    void B() {
        EditText editText = this.f8532a.f8578d;
        if (editText == null) {
            return;
        }
        Z.E0(this.f8533b, k() ? 0 : Z.H(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(S0.c.f1551K), editText.getCompoundPaddingBottom());
    }

    CharSequence a() {
        return this.f8534c;
    }

    ColorStateList b() {
        return this.f8533b.getTextColors();
    }

    int c() {
        return Z.H(this) + Z.H(this.f8533b) + (k() ? this.f8535d.getMeasuredWidth() + AbstractC0321u.a((ViewGroup.MarginLayoutParams) this.f8535d.getLayoutParams()) : 0);
    }

    TextView d() {
        return this.f8533b;
    }

    CharSequence e() {
        return this.f8535d.getContentDescription();
    }

    Drawable f() {
        return this.f8535d.getDrawable();
    }

    int g() {
        return this.f8538g;
    }

    ImageView.ScaleType h() {
        return this.f8539h;
    }

    boolean k() {
        return this.f8535d.getVisibility() == 0;
    }

    void l(boolean z3) {
        this.f8541j = z3;
        C();
    }

    void m() {
        u.d(this.f8532a, this.f8535d, this.f8536e);
    }

    void n(CharSequence charSequence) {
        this.f8534c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f8533b.setText(charSequence);
        C();
    }

    void o(int i3) {
        androidx.core.widget.j.o(this.f8533b, i3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        B();
    }

    void p(ColorStateList colorStateList) {
        this.f8533b.setTextColor(colorStateList);
    }

    void q(boolean z3) {
        this.f8535d.setCheckable(z3);
    }

    void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f8535d.setContentDescription(charSequence);
        }
    }

    void s(Drawable drawable) {
        this.f8535d.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f8532a, this.f8535d, this.f8536e, this.f8537f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    void t(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i3 != this.f8538g) {
            this.f8538g = i3;
            u.g(this.f8535d, i3);
        }
    }

    void u(View.OnClickListener onClickListener) {
        u.h(this.f8535d, onClickListener, this.f8540i);
    }

    void v(View.OnLongClickListener onLongClickListener) {
        this.f8540i = onLongClickListener;
        u.i(this.f8535d, onLongClickListener);
    }

    void w(ImageView.ScaleType scaleType) {
        this.f8539h = scaleType;
        u.j(this.f8535d, scaleType);
    }

    void x(ColorStateList colorStateList) {
        if (this.f8536e != colorStateList) {
            this.f8536e = colorStateList;
            u.a(this.f8532a, this.f8535d, colorStateList, this.f8537f);
        }
    }

    void y(PorterDuff.Mode mode) {
        if (this.f8537f != mode) {
            this.f8537f = mode;
            u.a(this.f8532a, this.f8535d, this.f8536e, mode);
        }
    }

    void z(boolean z3) {
        if (k() != z3) {
            this.f8535d.setVisibility(z3 ? 0 : 8);
            B();
            C();
        }
    }
}
