package com.google.android.material.appbar;

import A.T;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C;
import androidx.core.view.C0282a;
import androidx.core.view.C0332z0;
import androidx.core.view.I;
import androidx.core.view.Z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f7587z = S0.j.f1719f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private C0332z0 f7594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f7595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WeakReference f7601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f7602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f7603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f7604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List f7605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f7606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final TimeInterpolator f7607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int[] f7608u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f7609v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Integer f7610w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f7611x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Behavior f7612y;

    protected static class BaseBehavior<T extends AppBarLayout> extends j {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f7613k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f7614l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ValueAnimator f7615m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private c f7616n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private WeakReference f7617o;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f7618a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f7619b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f7618a = coordinatorLayout;
                this.f7619b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.T(this.f7618a, this.f7619b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends C0282a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f7621d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f7622e;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f7621d = appBarLayout;
                this.f7622e = coordinatorLayout;
            }

            @Override // androidx.core.view.C0282a
            public void g(View view, T t3) {
                View viewJ0;
                super.g(view, t3);
                t3.m0(ScrollView.class.getName());
                if (this.f7621d.getTotalScrollRange() == 0 || (viewJ0 = BaseBehavior.this.j0(this.f7622e)) == null || !BaseBehavior.this.f0(this.f7621d)) {
                    return;
                }
                if (BaseBehavior.this.Q() != (-this.f7621d.getTotalScrollRange())) {
                    t3.b(T.a.f38q);
                    t3.F0(true);
                }
                if (BaseBehavior.this.Q() != 0) {
                    if (!viewJ0.canScrollVertically(-1)) {
                        t3.b(T.a.f39r);
                        t3.F0(true);
                    } else if ((-this.f7621d.getDownNestedPreScrollRange()) != 0) {
                        t3.b(T.a.f39r);
                        t3.F0(true);
                    }
                }
            }

            @Override // androidx.core.view.C0282a
            public boolean j(View view, int i3, Bundle bundle) {
                if (i3 == 4096) {
                    this.f7621d.setExpanded(false);
                    return true;
                }
                if (i3 != 8192) {
                    return super.j(view, i3, bundle);
                }
                if (BaseBehavior.this.Q() != 0) {
                    View viewJ0 = BaseBehavior.this.j0(this.f7622e);
                    if (!viewJ0.canScrollVertically(-1)) {
                        this.f7621d.setExpanded(true);
                        return true;
                    }
                    int i4 = -this.f7621d.getDownNestedPreScrollRange();
                    if (i4 != 0) {
                        BaseBehavior.this.u(this.f7622e, this.f7621d, viewJ0, 0, i4, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        public BaseBehavior() {
        }

        private void A0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int iQ = Q() - topInset;
            int iI0 = i0(appBarLayout, iQ);
            if (iI0 >= 0) {
                View childAt = appBarLayout.getChildAt(iI0);
                d dVar = (d) childAt.getLayoutParams();
                int iC = dVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iD = -childAt.getBottom();
                    if (iI0 == 0 && Z.z(appBarLayout) && Z.z(childAt)) {
                        topInset2 -= appBarLayout.getTopInset();
                    }
                    if (e0(iC, 2)) {
                        iD += Z.D(childAt);
                    } else if (e0(iC, 5)) {
                        int iD2 = Z.D(childAt) + iD;
                        if (iQ < iD2) {
                            topInset2 = iD2;
                        } else {
                            iD = iD2;
                        }
                    }
                    if (e0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) dVar).topMargin;
                        iD -= ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    }
                    Z(coordinatorLayout, appBarLayout, p076x.a.b(b0(iQ, iD, topInset2) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void B0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, boolean z3) {
            View viewH0 = h0(appBarLayout, i3);
            boolean zB = false;
            if (viewH0 != null) {
                int iC = ((d) viewH0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iD = Z.D(viewH0);
                    if (i4 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i3) < (viewH0.getBottom() - iD) - appBarLayout.getTopInset()) : (-i3) >= (viewH0.getBottom() - iD) - appBarLayout.getTopInset()) {
                        zB = true;
                    }
                }
            }
            if (appBarLayout.o()) {
                zB = appBarLayout.B(g0(coordinatorLayout));
            }
            boolean zY = appBarLayout.y(zB);
            if (z3 || (zY && z0(coordinatorLayout, appBarLayout))) {
                if (appBarLayout.getBackground() != null) {
                    appBarLayout.getBackground().jumpToCurrentState();
                }
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 23 && appBarLayout.getForeground() != null) {
                    appBarLayout.getForeground().jumpToCurrentState();
                }
                if (i5 < 21 || appBarLayout.getStateListAnimator() == null) {
                    return;
                }
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        private void Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (Z.P(coordinatorLayout)) {
                return;
            }
            Z.q0(coordinatorLayout, new b(appBarLayout, coordinatorLayout));
        }

        private void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, float f3) {
            int iAbs = Math.abs(Q() - i3);
            float fAbs = Math.abs(f3);
            a0(coordinatorLayout, appBarLayout, i3, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4) {
            int iQ = Q();
            if (iQ == i3) {
                ValueAnimator valueAnimator = this.f7615m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f7615m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f7615m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f7615m = valueAnimator3;
                valueAnimator3.setInterpolator(T0.a.f1960e);
                this.f7615m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f7615m.setDuration(Math.min(i4, 600));
            this.f7615m.setIntValues(iQ, i3);
            this.f7615m.start();
        }

        private int b0(int i3, int i4, int i5) {
            return i3 < (i4 + i5) / 2 ? i4 : i5;
        }

        private boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.k() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        private static boolean e0(int i3, int i4) {
            return (i3 & i4) == i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (((d) appBarLayout.getChildAt(i3).getLayoutParams()).f7632a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View g0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof C) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View h0(AppBarLayout appBarLayout, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int i0(AppBarLayout appBarLayout, int i3) {
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if (e0(dVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i5 = -i3;
                if (top <= i5 && bottom >= i5) {
                    return i4;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View j0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).e() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int m0(AppBarLayout appBarLayout, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            int topInset = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                d dVar = (d) childAt.getLayoutParams();
                Interpolator interpolatorD = dVar.d();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorD == null) {
                        break;
                    }
                    int iC = dVar.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= Z.D(childAt);
                        }
                    }
                    if (Z.z(childAt)) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f3 = topInset;
                    return Integer.signum(i3) * (childAt.getTop() + Math.round(f3 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f3)));
                }
            }
            return i3;
        }

        private boolean z0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List listT = coordinatorLayout.t(appBarLayout);
            int size = listT.size();
            for (int i3 = 0; i3 < size; i3++) {
                CoordinatorLayout.c cVarE = ((CoordinatorLayout.f) ((View) listT.get(i3)).getLayoutParams()).e();
                if (cVarE instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarE).O() != 0;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.j
        int Q() {
            return I() + this.f7613k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public boolean L(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.f7617o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public int O(AppBarLayout appBarLayout) {
            return (-appBarLayout.getDownNestedScrollRange()) + appBarLayout.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public int P(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void R(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            A0(coordinatorLayout, appBarLayout);
            if (appBarLayout.o()) {
                appBarLayout.y(appBarLayout.B(g0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.l, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public boolean p(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            boolean zP = super.p(coordinatorLayout, appBarLayout, i3);
            int pendingAction = appBarLayout.getPendingAction();
            c cVar = this.f7616n;
            if (cVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z3 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z3) {
                            Z(coordinatorLayout, appBarLayout, i4, 0.0f);
                        } else {
                            T(coordinatorLayout, appBarLayout, i4);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z3) {
                            Z(coordinatorLayout, appBarLayout, 0, 0.0f);
                        } else {
                            T(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (cVar.f7624c) {
                T(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (cVar.f7625d) {
                T(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(cVar.f7626e);
                T(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.f7616n.f7628g ? Z.D(childAt) + appBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.f7616n.f7627f)));
            }
            appBarLayout.u();
            this.f7616n = null;
            K(p076x.a.b(I(), -appBarLayout.getTotalScrollRange(), 0));
            B0(coordinatorLayout, appBarLayout, I(), 0, true);
            appBarLayout.s(I());
            Y(coordinatorLayout, appBarLayout);
            return zP;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public boolean q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return super.q(coordinatorLayout, appBarLayout, i3, i4, i5, i6);
            }
            coordinatorLayout.L(appBarLayout, i3, i4, View.MeasureSpec.makeMeasureSpec(0, 0), i6);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void u(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            int i6;
            int downNestedPreScrollRange;
            if (i4 != 0) {
                if (i4 < 0) {
                    int i7 = -appBarLayout.getTotalScrollRange();
                    i6 = i7;
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i6 != downNestedPreScrollRange) {
                    iArr[1] = S(coordinatorLayout, appBarLayout, i4, i6, downNestedPreScrollRange);
                }
            }
            if (appBarLayout.o()) {
                appBarLayout.y(appBarLayout.B(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            if (i6 < 0) {
                iArr[1] = S(coordinatorLayout, appBarLayout, i6, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i6 == 0) {
                Y(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        public void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof c) {
                w0((c) parcelable, true);
                super.B(coordinatorLayout, appBarLayout, this.f7616n.c());
            } else {
                super.B(coordinatorLayout, appBarLayout, parcelable);
                this.f7616n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public Parcelable C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableC = super.C(coordinatorLayout, appBarLayout);
            c cVarX0 = x0(parcelableC, appBarLayout);
            return cVarX0 == null ? parcelableC : cVarX0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public boolean E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            ValueAnimator valueAnimator;
            boolean z3 = (i3 & 2) != 0 && (appBarLayout.o() || d0(coordinatorLayout, appBarLayout, view));
            if (z3 && (valueAnimator = this.f7615m) != null) {
                valueAnimator.cancel();
            }
            this.f7617o = null;
            this.f7614l = i4;
            return z3;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            if (this.f7614l == 0 || i3 == 1) {
                A0(coordinatorLayout, appBarLayout);
                if (appBarLayout.o()) {
                    appBarLayout.y(appBarLayout.B(view));
                }
            }
            this.f7617o = new WeakReference(view);
        }

        void w0(c cVar, boolean z3) {
            if (this.f7616n == null || z3) {
                this.f7616n = cVar;
            }
        }

        c x0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int I2 = I();
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                int bottom = childAt.getBottom() + I2;
                if (childAt.getTop() + I2 <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = F.a.f834b;
                    }
                    c cVar = new c(parcelable);
                    boolean z3 = I2 == 0;
                    cVar.f7625d = z3;
                    cVar.f7624c = !z3 && (-I2) >= appBarLayout.getTotalScrollRange();
                    cVar.f7626e = i3;
                    cVar.f7628g = bottom == Z.D(childAt) + appBarLayout.getTopInset();
                    cVar.f7627f = bottom / childAt.getHeight();
                    return cVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
        public int U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5) {
            int iQ = Q();
            int i6 = 0;
            if (i4 == 0 || iQ < i4 || iQ > i5) {
                this.f7613k = 0;
            } else {
                int iB = p076x.a.b(i3, i4, i5);
                if (iQ != iB) {
                    int iM0 = appBarLayout.i() ? m0(appBarLayout, iB) : iB;
                    boolean zK = K(iM0);
                    int i7 = iQ - iB;
                    this.f7613k = iB - iM0;
                    if (zK) {
                        while (i6 < appBarLayout.getChildCount()) {
                            d dVar = (d) appBarLayout.getChildAt(i6).getLayoutParams();
                            b bVarB = dVar.b();
                            if (bVarB != null && (dVar.c() & 1) != 0) {
                                bVarB.a(appBarLayout, appBarLayout.getChildAt(i6), I());
                            }
                            i6++;
                        }
                    }
                    if (!zK && appBarLayout.i()) {
                        coordinatorLayout.g(appBarLayout);
                    }
                    appBarLayout.s(I());
                    B0(coordinatorLayout, appBarLayout, iB, iB < iQ ? -1 : 1, false);
                    i6 = i7;
                }
            }
            Y(coordinatorLayout, appBarLayout);
            return i6;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class c extends F.a {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            boolean f7624c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f7625d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f7626e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            float f7627f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            boolean f7628g;

            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public c createFromParcel(Parcel parcel) {
                    return new c(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new c(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public c[] newArray(int i3) {
                    return new c[i3];
                }
            }

            public c(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f7624c = parcel.readByte() != 0;
                this.f7625d = parcel.readByte() != 0;
                this.f7626e = parcel.readInt();
                this.f7627f = parcel.readFloat();
                this.f7628g = parcel.readByte() != 0;
            }

            @Override // F.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeByte(this.f7624c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f7625d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f7626e);
                parcel.writeFloat(this.f7627f);
                parcel.writeByte(this.f7628g ? (byte) 1 : (byte) 0);
            }

            public c(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.H(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.l
        public /* bridge */ /* synthetic */ int I() {
            return super.I();
        }

        @Override // com.google.android.material.appbar.l
        public /* bridge */ /* synthetic */ boolean K(int i3) {
            return super.K(i3);
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.o(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: o0 */
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            return super.p(coordinatorLayout, appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: p0 */
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            return super.q(coordinatorLayout, appBarLayout, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ void u(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            super.u(coordinatorLayout, appBarLayout, view, i3, i4, iArr, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super.x(coordinatorLayout, appBarLayout, view, i3, i4, i5, i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: s0 */
        public /* bridge */ /* synthetic */ void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.B(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: t0 */
        public /* bridge */ /* synthetic */ Parcelable C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.C(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: u0 */
        public /* bridge */ /* synthetic */ boolean E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            return super.E(coordinatorLayout, appBarLayout, view, view2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: v0 */
        public /* bridge */ /* synthetic */ void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            super.G(coordinatorLayout, appBarLayout, view, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends k {
        public ScrollingViewBehavior() {
        }

        private static int V(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarE = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).e();
            if (cVarE instanceof BaseBehavior) {
                return ((BaseBehavior) cVarE).Q();
            }
            return 0;
        }

        private void W(View view, View view2) {
            CoordinatorLayout.c cVarE = ((CoordinatorLayout.f) view2.getLayoutParams()).e();
            if (cVarE instanceof BaseBehavior) {
                Z.b0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarE).f7613k) + Q()) - M(view2));
            }
        }

        private void X(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.o()) {
                    appBarLayout.y(appBarLayout.B(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean A(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z3) {
            AppBarLayout appBarLayoutL = L(coordinatorLayout.s(view));
            if (appBarLayoutL != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f7659d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutL.v(false, !z3);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.k
        float N(View view) {
            int i3;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iV = V(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iV > downNestedPreScrollRange) && (i3 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iV / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.k
        int P(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.P(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.k
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public AppBarLayout L(List list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) list.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
            W(view, view2);
            X(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void m(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                Z.q0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.l, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.p(coordinatorLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.k, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return super.q(coordinatorLayout, view, i3, i4, i5, i6);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.A5);
            S(typedArrayObtainStyledAttributes.getDimensionPixelSize(S0.k.B5, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements I {
        a() {
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            return AppBarLayout.this.t(c0332z0);
        }
    }

    public static abstract class b {
        public abstract void a(AppBarLayout appBarLayout, View view, float f3);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f7630a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f7631b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, View view, float f3) {
            b(this.f7630a, appBarLayout, view);
            float fAbs = this.f7630a.top - Math.abs(f3);
            if (fAbs > 0.0f) {
                Z.x0(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fA = 1.0f - p076x.a.a(Math.abs(fAbs / this.f7630a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f7630a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f7631b);
            this.f7631b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f7631b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            Z.x0(view, this.f7631b);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1509a);
    }

    private boolean A() {
        return this.f7609v != null && getTopInset() > 0;
    }

    private boolean C() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || Z.z(childAt)) ? false : true;
    }

    private void D(float f3, float f4) {
        ValueAnimator valueAnimator = this.f7603p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f3, f4);
        this.f7603p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f7606s);
        this.f7603p.setInterpolator(this.f7607t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f7604q;
        if (animatorUpdateListener != null) {
            this.f7603p.addUpdateListener(animatorUpdateListener);
        }
        this.f7603p.start();
    }

    private void E() {
        setWillNotDraw(!A());
    }

    private void c() {
        WeakReference weakReference = this.f7601n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f7601n = null;
    }

    private Integer d() {
        Drawable drawable = this.f7609v;
        if (drawable instanceof p042l1.g) {
            return Integer.valueOf(((p042l1.g) drawable).y());
        }
        ColorStateList colorStateListF = com.google.android.material.drawable.h.f(drawable);
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    private View e(View view) {
        int i3;
        if (this.f7601n == null && (i3 = this.f7600m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i3) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f7600m);
            }
            if (viewFindViewById != null) {
                this.f7601n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f7601n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean j() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((d) getChildAt(i3).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void l(final p042l1.g gVar, final ColorStateList colorStateList, final ColorStateList colorStateList2) {
        final Integer numF = p002a1.a.f(getContext(), S0.a.f1521m);
        this.f7604q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f7642a.q(colorStateList, colorStateList2, gVar, numF, valueAnimator);
            }
        };
        Z.u0(this, gVar);
    }

    private void m(Context context, final p042l1.g gVar) {
        gVar.K(context);
        this.f7604q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f7647a.r(gVar, valueAnimator);
            }
        };
        Z.u0(this, gVar);
    }

    private void n() {
        Behavior behavior = this.f7612y;
        BaseBehavior.c cVarX0 = (behavior == null || this.f7589b == -1 || this.f7593f != 0) ? null : behavior.x0(F.a.f834b, this);
        this.f7589b = -1;
        this.f7590c = -1;
        this.f7591d = -1;
        if (cVarX0 != null) {
            this.f7612y.w0(cVarX0, false);
        }
    }

    private boolean p() {
        return getBackground() instanceof p042l1.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(ColorStateList colorStateList, ColorStateList colorStateList2, p042l1.g gVar, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int iK = p002a1.a.k(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        gVar.V(ColorStateList.valueOf(iK));
        if (this.f7609v != null && (num2 = this.f7610w) != null && num2.equals(num)) {
            androidx.core.graphics.drawable.a.n(this.f7609v, iK);
        }
        if (this.f7605r.isEmpty()) {
            return;
        }
        Iterator it = this.f7605r.iterator();
        while (it.hasNext()) {
            H.a(it.next());
            if (gVar.v() != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(p042l1.g gVar, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        gVar.U(fFloatValue);
        Drawable drawable = this.f7609v;
        if (drawable instanceof p042l1.g) {
            ((p042l1.g) drawable).U(fFloatValue);
        }
        Iterator it = this.f7605r.iterator();
        if (it.hasNext()) {
            H.a(it.next());
            gVar.y();
            throw null;
        }
    }

    private void w(boolean z3, boolean z4, boolean z5) {
        this.f7593f = (z3 ? 1 : 2) | (z4 ? 4 : 0) | (z5 ? 8 : 0);
        requestLayout();
    }

    private boolean x(boolean z3) {
        if (this.f7597j == z3) {
            return false;
        }
        this.f7597j = z3;
        refreshDrawableState();
        return true;
    }

    boolean B(View view) {
        View viewE = e(view);
        if (viewE != null) {
            view = viewE;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (A()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f7588a);
            this.f7609v.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7609v;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.f7612y = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iD;
        int i3 = this.f7590c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = dVar.f7632a;
                if ((i5 & 5) != 5) {
                    if (i4 > 0) {
                        break;
                    }
                } else {
                    int i6 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    if ((i5 & 8) != 0) {
                        iD = Z.D(childAt);
                    } else {
                        if ((i5 & 2) != 0) {
                            iD = measuredHeight - Z.D(childAt);
                        } else {
                            iMin = i6 + measuredHeight;
                        }
                        if (childCount == 0 && Z.z(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i4 += iMin;
                    }
                    iMin = i6 + iD;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i4 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i4);
        this.f7590c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i3 = this.f7591d;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int iD = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                int i5 = dVar.f7632a;
                if ((i5 & 1) == 0) {
                    break;
                }
                iD += measuredHeight;
                if ((i5 & 2) != 0) {
                    iD -= Z.D(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, iD);
        this.f7591d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f7600m;
    }

    public p042l1.g getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof p042l1.g) {
            return (p042l1.g) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iD = Z.D(this);
        if (iD == 0) {
            int childCount = getChildCount();
            iD = childCount >= 1 ? Z.D(getChildAt(childCount - 1)) : 0;
            if (iD == 0) {
                return getHeight() / 3;
            }
        }
        return (iD * 2) + topInset;
    }

    int getPendingAction() {
        return this.f7593f;
    }

    public Drawable getStatusBarForeground() {
        return this.f7609v;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        C0332z0 c0332z0 = this.f7594g;
        if (c0332z0 != null) {
            return c0332z0.l();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i3 = this.f7589b;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int iD = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = dVar.f7632a;
                if ((i5 & 1) == 0) {
                    break;
                }
                iD += measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                if (i4 == 0 && Z.z(childAt)) {
                    iD -= getTopInset();
                }
                if ((i5 & 2) != 0) {
                    iD -= Z.D(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, iD);
        this.f7589b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new d((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    boolean i() {
        return this.f7592e;
    }

    boolean k() {
        return getTotalScrollRange() != 0;
    }

    public boolean o() {
        return this.f7599l;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        p042l1.h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        if (this.f7608u == null) {
            this.f7608u = new int[4];
        }
        int[] iArr = this.f7608u;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z3 = this.f7597j;
        int i4 = S0.a.f1500R;
        if (!z3) {
            i4 = -i4;
        }
        iArr[0] = i4;
        iArr[1] = (z3 && this.f7598k) ? S0.a.f1501S : -S0.a.f1501S;
        int i5 = S0.a.f1497O;
        if (!z3) {
            i5 = -i5;
        }
        iArr[2] = i5;
        iArr[3] = (z3 && this.f7598k) ? S0.a.f1496N : -S0.a.f1496N;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        boolean z4 = true;
        if (Z.z(this) && C()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                Z.b0(getChildAt(childCount), topInset);
            }
        }
        n();
        this.f7592e = false;
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            if (((d) getChildAt(i7).getLayoutParams()).d() != null) {
                this.f7592e = true;
                break;
            }
        }
        Drawable drawable = this.f7609v;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f7596i) {
            return;
        }
        if (!this.f7599l && !j()) {
            z4 = false;
        }
        x(z4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != 1073741824 && Z.z(this) && C()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = p076x.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i4));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        n();
    }

    void s(int i3) {
        this.f7588a = i3;
        if (!willNotDraw()) {
            Z.h0(this);
        }
        List list = this.f7595h;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                H.a(this.f7595h.get(i4));
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        p042l1.h.d(this, f3);
    }

    public void setExpanded(boolean z3) {
        v(z3, Z.U(this));
    }

    public void setLiftOnScroll(boolean z3) {
        this.f7599l = z3;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f7600m = -1;
        if (view == null) {
            c();
        } else {
            this.f7601n = new WeakReference(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i3) {
        this.f7600m = i3;
        c();
    }

    public void setLiftableOverrideEnabled(boolean z3) {
        this.f7596i = z3;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i3);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f7609v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f7609v = drawable != null ? drawable.mutate() : null;
            this.f7610w = d();
            Drawable drawable3 = this.f7609v;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f7609v.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f7609v, Z.C(this));
                this.f7609v.setVisible(getVisibility() == 0, false);
                this.f7609v.setCallback(this);
            }
            E();
            Z.h0(this);
        }
    }

    public void setStatusBarForegroundColor(int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(int i3) {
        setStatusBarForeground(p016e.a.b(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            s.b(this, f3);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f7609v;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
    }

    C0332z0 t(C0332z0 c0332z0) {
        C0332z0 c0332z1 = Z.z(this) ? c0332z0 : null;
        if (!p082z.c.a(this.f7594g, c0332z1)) {
            this.f7594g = c0332z1;
            E();
            requestLayout();
        }
        return c0332z0;
    }

    void u() {
        this.f7593f = 0;
    }

    public void v(boolean z3, boolean z4) {
        w(z3, z4, true);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7609v;
    }

    boolean y(boolean z3) {
        return z(z3, !this.f7596i);
    }

    boolean z(boolean z3, boolean z4) {
        if (!z4 || this.f7598k == z3) {
            return false;
        }
        this.f7598k = z3;
        refreshDrawableState();
        if (!p()) {
            return true;
        }
        if (this.f7602o) {
            D(z3 ? 0.0f : 1.0f, z3 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f7599l) {
            return true;
        }
        D(z3 ? 0.0f : this.f7611x, z3 ? this.f7611x : 0.0f);
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f7587z;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f7589b = -1;
        this.f7590c = -1;
        this.f7591d = -1;
        this.f7593f = 0;
        this.f7605r = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
                s.a(this);
            }
            s.c(this, attributeSet, i3, i4);
        }
        TypedArray typedArrayI = com.google.android.material.internal.C.i(context2, attributeSet, S0.k.f1863k, i3, i4, new int[0]);
        Z.u0(this, typedArrayI.getDrawable(S0.k.f1867l));
        ColorStateList colorStateListA = p030h1.c.a(context2, typedArrayI, S0.k.f1891r);
        this.f7602o = colorStateListA != null;
        ColorStateList colorStateListF = com.google.android.material.drawable.h.f(getBackground());
        if (colorStateListF != null) {
            p042l1.g gVar = new p042l1.g();
            gVar.V(colorStateListF);
            if (colorStateListA != null) {
                l(gVar, colorStateListF, colorStateListA);
            } else {
                m(context2, gVar);
            }
        }
        this.f7606s = p022f1.h.f(context2, S0.a.f1534z, getResources().getInteger(S0.f.f1658a));
        this.f7607t = p022f1.h.g(context2, S0.a.f1491I, T0.a.f1956a);
        int i6 = S0.k.f1883p;
        if (typedArrayI.hasValue(i6)) {
            w(typedArrayI.getBoolean(i6, false), false, false);
        }
        if (i5 >= 21) {
            int i7 = S0.k.f1879o;
            if (typedArrayI.hasValue(i7)) {
                s.b(this, typedArrayI.getDimensionPixelSize(i7, 0));
            }
        }
        if (i5 >= 26) {
            int i8 = S0.k.f1875n;
            if (typedArrayI.hasValue(i8)) {
                setKeyboardNavigationCluster(typedArrayI.getBoolean(i8, false));
            }
            int i9 = S0.k.f1871m;
            if (typedArrayI.hasValue(i9)) {
                setTouchscreenBlocksFocus(typedArrayI.getBoolean(i9, false));
            }
        }
        this.f7611x = getResources().getDimension(S0.c.f1567a);
        this.f7599l = typedArrayI.getBoolean(S0.k.f1887q, false);
        this.f7600m = typedArrayI.getResourceId(S0.k.f1895s, -1);
        setStatusBarForeground(typedArrayI.getDrawable(S0.k.f1899t));
        typedArrayI.recycle();
        Z.D0(this, new a());
    }

    public static class d extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f7633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f7634c;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7632a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.f1907v);
            this.f7632a = typedArrayObtainStyledAttributes.getInt(S0.k.f1915x, 0);
            f(typedArrayObtainStyledAttributes.getInt(S0.k.f1911w, 0));
            int i3 = S0.k.f1919y;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.f7634c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i3, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private b a(int i3) {
            if (i3 != 1) {
                return null;
            }
            return new c();
        }

        public b b() {
            return this.f7633b;
        }

        public int c() {
            return this.f7632a;
        }

        public Interpolator d() {
            return this.f7634c;
        }

        boolean e() {
            int i3 = this.f7632a;
            return (i3 & 1) == 1 && (i3 & 10) != 0;
        }

        public void f(int i3) {
            this.f7633b = a(i3);
        }

        public d(int i3, int i4) {
            super(i3, i4);
            this.f7632a = 1;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7632a = 1;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7632a = 1;
        }

        public d(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7632a = 1;
        }
    }
}
