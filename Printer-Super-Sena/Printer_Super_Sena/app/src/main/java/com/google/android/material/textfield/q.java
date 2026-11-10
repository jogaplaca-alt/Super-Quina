package com.google.android.material.textfield;

import A.AbstractC0157c;
import A.T;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
class q extends t {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final boolean f8657s;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f8660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AutoCompleteTextView f8661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f8662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f8663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AbstractC0157c.a f8664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f8668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AccessibilityManager f8669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f8670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator f8671r;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q.this.r();
            q.this.f8671r.start();
        }
    }

    static {
        f8657s = Build.VERSION.SDK_INT >= 21;
    }

    q(s sVar) {
        super(sVar);
        this.f8662i = new View.OnClickListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8653a.J(view);
            }
        };
        this.f8663j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                this.f8654a.K(view, z3);
            }
        };
        this.f8664k = new AbstractC0157c.a() { // from class: com.google.android.material.textfield.o
            @Override // A.AbstractC0157c.a
            public final void onTouchExplorationStateChanged(boolean z3) {
                this.f8655a.L(z3);
            }
        };
        this.f8668o = Long.MAX_VALUE;
        Context context = sVar.getContext();
        int i3 = S0.a.f1485C;
        this.f8659f = p022f1.h.f(context, i3, 67);
        this.f8658e = p022f1.h.f(sVar.getContext(), i3, 50);
        this.f8660g = p022f1.h.g(sVar.getContext(), S0.a.f1489G, T0.a.f1956a);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i3, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f8660g);
        valueAnimatorOfFloat.setDuration(i3);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f8650a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void F() {
        this.f8671r = E(this.f8659f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f8658e, 1.0f, 0.0f);
        this.f8670q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    private boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f8668o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean zIsPopupShowing = this.f8661h.isPopupShowing();
        O(zIsPopupShowing);
        this.f8666m = zIsPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f8706d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z3) {
        this.f8665l = z3;
        r();
        if (z3) {
            return;
        }
        O(false);
        this.f8666m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z3) {
        AutoCompleteTextView autoCompleteTextView = this.f8661h;
        if (autoCompleteTextView == null || r.a(autoCompleteTextView)) {
            return;
        }
        Z.z0(this.f8706d, z3 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f8666m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z3) {
        if (this.f8667n != z3) {
            this.f8667n = z3;
            this.f8671r.cancel();
            this.f8670q.start();
        }
    }

    private void P() {
        this.f8661h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f8651a.M(view, motionEvent);
            }
        });
        if (f8657s) {
            this.f8661h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.l
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f8652a.N();
                }
            });
        }
        this.f8661h.setThreshold(0);
    }

    private void Q() {
        if (this.f8661h == null) {
            return;
        }
        if (G()) {
            this.f8666m = false;
        }
        if (this.f8666m) {
            this.f8666m = false;
            return;
        }
        if (f8657s) {
            O(!this.f8667n);
        } else {
            this.f8667n = !this.f8667n;
            r();
        }
        if (!this.f8667n) {
            this.f8661h.dismissDropDown();
        } else {
            this.f8661h.requestFocus();
            this.f8661h.showDropDown();
        }
    }

    private void R() {
        this.f8666m = true;
        this.f8668o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.t
    public void a(Editable editable) {
        if (this.f8669p.isTouchExplorationEnabled() && r.a(this.f8661h) && !this.f8706d.hasFocus()) {
            this.f8661h.dismissDropDown();
        }
        this.f8661h.post(new Runnable() { // from class: com.google.android.material.textfield.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f8656a.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.t
    int c() {
        return S0.i.f1694g;
    }

    @Override // com.google.android.material.textfield.t
    int d() {
        return f8657s ? S0.d.f1611i : S0.d.f1612j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnFocusChangeListener e() {
        return this.f8663j;
    }

    @Override // com.google.android.material.textfield.t
    View.OnClickListener f() {
        return this.f8662i;
    }

    @Override // com.google.android.material.textfield.t
    public AbstractC0157c.a h() {
        return this.f8664k;
    }

    @Override // com.google.android.material.textfield.t
    boolean i(int i3) {
        return i3 != 0;
    }

    @Override // com.google.android.material.textfield.t
    boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean k() {
        return this.f8665l;
    }

    @Override // com.google.android.material.textfield.t
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    boolean m() {
        return this.f8667n;
    }

    @Override // com.google.android.material.textfield.t
    public void n(EditText editText) {
        this.f8661h = D(editText);
        P();
        this.f8703a.setErrorIconDrawable((Drawable) null);
        if (!r.a(editText) && this.f8669p.isTouchExplorationEnabled()) {
            Z.z0(this.f8706d, 2);
        }
        this.f8703a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.t
    public void o(View view, T t3) {
        if (!r.a(this.f8661h)) {
            t3.m0(Spinner.class.getName());
        }
        if (t3.W()) {
            t3.w0(null);
        }
    }

    @Override // com.google.android.material.textfield.t
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f8669p.isEnabled() || r.a(this.f8661h)) {
            return;
        }
        boolean z3 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f8667n && !this.f8661h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z3) {
            Q();
            R();
        }
    }

    @Override // com.google.android.material.textfield.t
    void s() {
        F();
        this.f8669p = (AccessibilityManager) this.f8705c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.t
    boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.t
    void u() {
        AutoCompleteTextView autoCompleteTextView = this.f8661h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f8657s) {
                this.f8661h.setOnDismissListener(null);
            }
        }
    }
}
