package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p022f1.h;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f7674j = S0.a.f1533y;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f7675k = S0.a.f1483A;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f7676l = S0.a.f1488F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f7677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f7680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimeInterpolator f7681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ViewPropertyAnimator f7685i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f7685i = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f7677a = new LinkedHashSet();
        this.f7682f = 0;
        this.f7683g = 2;
        this.f7684h = 0;
    }

    private void J(View view, int i3, long j3, TimeInterpolator timeInterpolator) {
        this.f7685i = view.animate().translationY(i3).setInterpolator(timeInterpolator).setDuration(j3).setListener(new a());
    }

    private void Q(View view, int i3) {
        this.f7683g = i3;
        Iterator it = this.f7677a.iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        return i3 == 2;
    }

    public boolean K() {
        return this.f7683g == 1;
    }

    public boolean L() {
        return this.f7683g == 2;
    }

    public void M(View view) {
        N(view, true);
    }

    public void N(View view, boolean z3) {
        if (K()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f7685i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Q(view, 1);
        int i3 = this.f7682f + this.f7684h;
        if (z3) {
            J(view, i3, this.f7679c, this.f7681e);
        } else {
            view.setTranslationY(i3);
        }
    }

    public void O(View view) {
        P(view, true);
    }

    public void P(View view, boolean z3) {
        if (L()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f7685i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Q(view, 2);
        if (z3) {
            J(view, 0, this.f7678b, this.f7680d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        this.f7682f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f7678b = h.f(view.getContext(), f7674j, 225);
        this.f7679c = h.f(view.getContext(), f7675k, 175);
        Context context = view.getContext();
        int i4 = f7676l;
        this.f7680d = h.g(context, i4, T0.a.f1959d);
        this.f7681e = h.g(view.getContext(), i4, T0.a.f1958c);
        return super.p(coordinatorLayout, view, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i4 > 0) {
            M(view);
        } else if (i4 < 0) {
            O(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7677a = new LinkedHashSet();
        this.f7682f = 0;
        this.f7683g = 2;
        this.f7684h = 0;
    }
}
