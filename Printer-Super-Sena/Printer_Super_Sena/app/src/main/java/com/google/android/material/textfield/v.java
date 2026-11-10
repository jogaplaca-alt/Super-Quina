package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class v {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private ColorStateList f8707A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private Typeface f8708B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f8712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f8713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f8714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f8715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout f8716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f8717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private FrameLayout f8719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animator f8720l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f8721m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8722n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8723o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f8724p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8725q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f8726r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f8727s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8728t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8729u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f8730v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f8731w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f8732x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f8733y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8734z;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f8736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f8738d;

        a(int i3, TextView textView, int i4, TextView textView2) {
            this.f8735a = i3;
            this.f8736b = textView;
            this.f8737c = i4;
            this.f8738d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.f8722n = this.f8735a;
            v.this.f8720l = null;
            TextView textView = this.f8736b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8737c == 1 && v.this.f8726r != null) {
                    v.this.f8726r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f8738d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f8738d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8738d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f8738d.setAlpha(0.0f);
            }
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = v.this.f8716h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public v(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f8715g = context;
        this.f8716h = textInputLayout;
        this.f8721m = context.getResources().getDimensionPixelSize(S0.c.f1583i);
        int i3 = S0.a.f1486D;
        this.f8709a = p022f1.h.f(context, i3, 217);
        this.f8710b = p022f1.h.f(context, S0.a.f1483A, 167);
        this.f8711c = p022f1.h.f(context, i3, 167);
        int i4 = S0.a.f1487E;
        this.f8712d = p022f1.h.g(context, i4, T0.a.f1959d);
        TimeInterpolator timeInterpolator = T0.a.f1956a;
        this.f8713e = p022f1.h.g(context, i4, timeInterpolator);
        this.f8714f = p022f1.h.g(context, S0.a.f1489G, timeInterpolator);
    }

    private void D(int i3, int i4) {
        TextView textViewM;
        TextView textViewM2;
        if (i3 == i4) {
            return;
        }
        if (i4 != 0 && (textViewM2 = m(i4)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i3 != 0 && (textViewM = m(i3)) != null) {
            textViewM.setVisibility(4);
            if (i3 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f8722n = i4;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        return Z.U(this.f8716h) && this.f8716h.isEnabled() && !(this.f8723o == this.f8722n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void S(int i3, int i4, boolean z3) {
        if (i3 == i4) {
            return;
        }
        if (z3) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f8720l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f8732x, this.f8733y, 2, i3, i4);
            i(arrayList, this.f8725q, this.f8726r, 1, i3, i4);
            T0.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i4, m(i3), i3, m(i4)));
            animatorSet.start();
        } else {
            D(i3, i4);
        }
        this.f8716h.p0();
        this.f8716h.u0(z3);
        this.f8716h.A0();
    }

    private boolean g() {
        return (this.f8717i == null || this.f8716h.getEditText() == null) ? false : true;
    }

    private void i(List list, boolean z3, TextView textView, int i3, int i4, int i5) {
        if (textView == null || !z3) {
            return;
        }
        if (i3 == i5 || i3 == i4) {
            ObjectAnimator objectAnimatorJ = j(textView, i5 == i3);
            if (i3 == i5 && i4 != 0) {
                objectAnimatorJ.setStartDelay(this.f8711c);
            }
            list.add(objectAnimatorJ);
            if (i5 != i3 || i4 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f8711c);
            list.add(objectAnimatorK);
        }
    }

    private ObjectAnimator j(TextView textView, boolean z3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z3 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z3 ? this.f8710b : this.f8711c);
        objectAnimatorOfFloat.setInterpolator(z3 ? this.f8713e : this.f8714f);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f8721m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f8709a);
        objectAnimatorOfFloat.setInterpolator(this.f8712d);
        return objectAnimatorOfFloat;
    }

    private TextView m(int i3) {
        if (i3 == 1) {
            return this.f8726r;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f8733y;
    }

    private int v(boolean z3, int i3, int i4) {
        return z3 ? this.f8715g.getResources().getDimensionPixelSize(i3) : i4;
    }

    private boolean y(int i3) {
        return (i3 != 1 || this.f8726r == null || TextUtils.isEmpty(this.f8724p)) ? false : true;
    }

    boolean A() {
        return this.f8725q;
    }

    boolean B() {
        return this.f8732x;
    }

    void C(TextView textView, int i3) {
        FrameLayout frameLayout;
        if (this.f8717i == null) {
            return;
        }
        if (!z(i3) || (frameLayout = this.f8719k) == null) {
            this.f8717i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i4 = this.f8718j - 1;
        this.f8718j = i4;
        O(this.f8717i, i4);
    }

    void E(int i3) {
        this.f8728t = i3;
        TextView textView = this.f8726r;
        if (textView != null) {
            Z.s0(textView, i3);
        }
    }

    void F(CharSequence charSequence) {
        this.f8727s = charSequence;
        TextView textView = this.f8726r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void G(boolean z3) {
        if (this.f8725q == z3) {
            return;
        }
        h();
        if (z3) {
            androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(this.f8715g);
            this.f8726r = f3;
            f3.setId(S0.e.f1626L);
            this.f8726r.setTextAlignment(5);
            Typeface typeface = this.f8708B;
            if (typeface != null) {
                this.f8726r.setTypeface(typeface);
            }
            H(this.f8729u);
            I(this.f8730v);
            F(this.f8727s);
            E(this.f8728t);
            this.f8726r.setVisibility(4);
            e(this.f8726r, 0);
        } else {
            w();
            C(this.f8726r, 0);
            this.f8726r = null;
            this.f8716h.p0();
            this.f8716h.A0();
        }
        this.f8725q = z3;
    }

    void H(int i3) {
        this.f8729u = i3;
        TextView textView = this.f8726r;
        if (textView != null) {
            this.f8716h.c0(textView, i3);
        }
    }

    void I(ColorStateList colorStateList) {
        this.f8730v = colorStateList;
        TextView textView = this.f8726r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void J(int i3) {
        this.f8734z = i3;
        TextView textView = this.f8733y;
        if (textView != null) {
            androidx.core.widget.j.o(textView, i3);
        }
    }

    void K(boolean z3) {
        if (this.f8732x == z3) {
            return;
        }
        h();
        if (z3) {
            androidx.appcompat.widget.F f3 = new androidx.appcompat.widget.F(this.f8715g);
            this.f8733y = f3;
            f3.setId(S0.e.f1627M);
            this.f8733y.setTextAlignment(5);
            Typeface typeface = this.f8708B;
            if (typeface != null) {
                this.f8733y.setTypeface(typeface);
            }
            this.f8733y.setVisibility(4);
            Z.s0(this.f8733y, 1);
            J(this.f8734z);
            L(this.f8707A);
            e(this.f8733y, 1);
            this.f8733y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f8733y, 1);
            this.f8733y = null;
            this.f8716h.p0();
            this.f8716h.A0();
        }
        this.f8732x = z3;
    }

    void L(ColorStateList colorStateList) {
        this.f8707A = colorStateList;
        TextView textView = this.f8733y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void N(Typeface typeface) {
        if (typeface != this.f8708B) {
            this.f8708B = typeface;
            M(this.f8726r, typeface);
            M(this.f8733y, typeface);
        }
    }

    void Q(CharSequence charSequence) {
        h();
        this.f8724p = charSequence;
        this.f8726r.setText(charSequence);
        int i3 = this.f8722n;
        if (i3 != 1) {
            this.f8723o = 1;
        }
        S(i3, this.f8723o, P(this.f8726r, charSequence));
    }

    void R(CharSequence charSequence) {
        h();
        this.f8731w = charSequence;
        this.f8733y.setText(charSequence);
        int i3 = this.f8722n;
        if (i3 != 2) {
            this.f8723o = 2;
        }
        S(i3, this.f8723o, P(this.f8733y, charSequence));
    }

    void e(TextView textView, int i3) {
        if (this.f8717i == null && this.f8719k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f8715g);
            this.f8717i = linearLayout;
            linearLayout.setOrientation(0);
            this.f8716h.addView(this.f8717i, -1, -2);
            this.f8719k = new FrameLayout(this.f8715g);
            this.f8717i.addView(this.f8719k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f8716h.getEditText() != null) {
                f();
            }
        }
        if (z(i3)) {
            this.f8719k.setVisibility(0);
            this.f8719k.addView(textView);
        } else {
            this.f8717i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f8717i.setVisibility(0);
        this.f8718j++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f8716h.getEditText();
            boolean zH = p030h1.c.h(this.f8715g);
            LinearLayout linearLayout = this.f8717i;
            int i3 = S0.c.f1549I;
            Z.E0(linearLayout, v(zH, i3, Z.H(editText)), v(zH, S0.c.f1550J, this.f8715g.getResources().getDimensionPixelSize(S0.c.f1548H)), v(zH, i3, Z.G(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f8720l;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return y(this.f8723o);
    }

    int n() {
        return this.f8728t;
    }

    CharSequence o() {
        return this.f8727s;
    }

    CharSequence p() {
        return this.f8724p;
    }

    int q() {
        TextView textView = this.f8726r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList r() {
        TextView textView = this.f8726r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence s() {
        return this.f8731w;
    }

    View t() {
        return this.f8733y;
    }

    int u() {
        TextView textView = this.f8733y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void w() {
        this.f8724p = null;
        h();
        if (this.f8722n == 1) {
            if (!this.f8732x || TextUtils.isEmpty(this.f8731w)) {
                this.f8723o = 0;
            } else {
                this.f8723o = 2;
            }
        }
        S(this.f8722n, this.f8723o, P(this.f8726r, ""));
    }

    void x() {
        h();
        int i3 = this.f8722n;
        if (i3 == 2) {
            this.f8723o = 0;
        }
        S(i3, this.f8723o, P(this.f8733y, ""));
    }

    boolean z(int i3) {
        return i3 == 0 || i3 == 1;
    }
}
