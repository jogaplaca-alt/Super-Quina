package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: renamed from: com.google.android.material.textfield.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0502f extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f8639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TimeInterpolator f8640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EditText f8641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f8642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f8643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimatorSet f8644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ValueAnimator f8645m;

    /* JADX INFO: renamed from: com.google.android.material.textfield.f$a */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0502f.this.f8704b.a0(true);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.f$b */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0502f.this.f8704b.a0(false);
        }
    }

    C0502f(s sVar) {
        super(sVar);
        this.f8642j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8632a.G(view);
            }
        };
        this.f8643k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f8633a.H(view, z3);
            }
        };
        Context context = sVar.getContext();
        int i3 = S0.a.f1485C;
        this.f8637e = p022f1.h.f(context, i3, 100);
        this.f8638f = p022f1.h.f(sVar.getContext(), i3, 150);
        this.f8639g = p022f1.h.g(sVar.getContext(), S0.a.f1489G, T0.a.f1956a);
        this.f8640h = p022f1.h.g(sVar.getContext(), S0.a.f1488F, T0.a.f1959d);
    }

    private void A(boolean z3) {
        boolean z4 = this.f8704b.F() == z3;
        if (z3 && !this.f8644l.isRunning()) {
            this.f8645m.cancel();
            this.f8644l.start();
            if (z4) {
                this.f8644l.end();
                return;
            }
            return;
        }
        if (z3) {
            return;
        }
        this.f8644l.cancel();
        this.f8645m.start();
        if (z4) {
            this.f8645m.end();
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f8639g);
        valueAnimatorOfFloat.setDuration(this.f8637e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8634a.E(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f8640h);
        valueAnimatorOfFloat.setDuration(this.f8638f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8636a.F(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8644l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f8644l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f8645m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f8706d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f8706d.setScaleX(fFloatValue);
        this.f8706d.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f8641i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z3) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f8641i;
        return editText != null && (editText.hasFocus() || this.f8706d.hasFocus()) && this.f8641i.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.t
    void a(Editable editable) {
        if (this.f8704b.w() != null) {
            return;
        }
        A(J());
    }

    @Override // com.google.android.material.textfield.t
    int c() {
        return S0.i.f1692e;
    }

    @Override // com.google.android.material.textfield.t
    int d() {
        return S0.d.f1613k;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener e() {
        return this.f8643k;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f8642j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener g() {
        return this.f8643k;
    }

    @Override // com.google.android.material.textfield.t
    public void n(EditText editText) {
        this.f8641i = editText;
        this.f8703a.setEndIconVisible(J());
    }

    @Override // com.google.android.material.textfield.t
    void q(boolean z3) {
        if (this.f8704b.w() == null) {
            return;
        }
        A(z3);
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        D();
    }

    @Override // com.google.android.material.textfield.t
    void u() {
        EditText editText = this.f8641i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8635a.I();
                }
            });
        }
    }
}
