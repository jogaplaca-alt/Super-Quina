package com.google.android.material.sidesheet;

import A.T;
import A.Y;
import S0.i;
import S0.j;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;
import androidx.core.view.r;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p042l1.g;
import p042l1.k;

/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c implements p022f1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.material.sidesheet.c f8391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f8392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f8393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f8394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f8395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f8396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f8397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private G.c f8401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f8403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private WeakReference f8408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private WeakReference f8409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private VelocityTracker f8411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private p022f1.g f8412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Set f8414x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final G.c.AbstractC0015c f8415y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f8390z = i.f1687B;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final int f8389A = j.f1726m;

    class a extends G.c.AbstractC0015c {
        a() {
        }

        @Override // G.c.AbstractC0015c
        public int a(View view, int i3, int i4) {
            return p076x.a.b(i3, SideSheetBehavior.this.f8391a.g(), SideSheetBehavior.this.f8391a.f());
        }

        @Override // G.c.AbstractC0015c
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // G.c.AbstractC0015c
        public int d(View view) {
            return SideSheetBehavior.this.f8404n + SideSheetBehavior.this.k0();
        }

        @Override // G.c.AbstractC0015c
        public void j(int i3) {
            if (i3 == 1 && SideSheetBehavior.this.f8398h) {
                SideSheetBehavior.this.J0(1);
            }
        }

        @Override // G.c.AbstractC0015c
        public void k(View view, int i3, int i4, int i5, int i6) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewF0 = SideSheetBehavior.this.f0();
            if (viewF0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) != null) {
                SideSheetBehavior.this.f8391a.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewF0.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.a0(view, i3);
        }

        @Override // G.c.AbstractC0015c
        public void l(View view, float f3, float f4) {
            int iW = SideSheetBehavior.this.W(view, f3, f4);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.O0(view, iW, sideSheetBehavior.N0());
        }

        @Override // G.c.AbstractC0015c
        public boolean m(View view, int i3) {
            return (SideSheetBehavior.this.f8399i == 1 || SideSheetBehavior.this.f8408r == null || SideSheetBehavior.this.f8408r.get() != view) ? false : true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.J0(5);
            if (SideSheetBehavior.this.f8408r == null || SideSheetBehavior.this.f8408r.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.f8408r.get()).requestLayout();
        }
    }

    class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f8421c = new Runnable() { // from class: com.google.android.material.sidesheet.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f8425a.c();
            }
        };

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f8420b = false;
            if (SideSheetBehavior.this.f8401k != null && SideSheetBehavior.this.f8401k.m(true)) {
                b(this.f8419a);
            } else if (SideSheetBehavior.this.f8399i == 2) {
                SideSheetBehavior.this.J0(this.f8419a);
            }
        }

        void b(int i3) {
            if (SideSheetBehavior.this.f8408r == null || SideSheetBehavior.this.f8408r.get() == null) {
                return;
            }
            this.f8419a = i3;
            if (this.f8420b) {
                return;
            }
            Z.i0((View) SideSheetBehavior.this.f8408r.get(), this.f8421c);
            this.f8420b = true;
        }
    }

    public SideSheetBehavior() {
        this.f8396f = new d();
        this.f8398h = true;
        this.f8399i = 5;
        this.f8400j = 5;
        this.f8403m = 0.1f;
        this.f8410t = -1;
        this.f8414x = new LinkedHashSet();
        this.f8415y = new a();
    }

    private void A0(CoordinatorLayout coordinatorLayout) {
        int i3;
        View viewFindViewById;
        if (this.f8409s != null || (i3 = this.f8410t) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i3)) == null) {
            return;
        }
        this.f8409s = new WeakReference(viewFindViewById);
    }

    private void B0(View view, T.a aVar, int i3) {
        Z.m0(view, aVar, null, Y(i3));
    }

    private void C0() {
        VelocityTracker velocityTracker = this.f8411u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8411u = null;
        }
    }

    private void D0(View view, Runnable runnable) {
        if (v0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void G0(int i3) {
        com.google.android.material.sidesheet.c cVar = this.f8391a;
        if (cVar == null || cVar.j() != i3) {
            if (i3 == 0) {
                this.f8391a = new com.google.android.material.sidesheet.b(this);
                if (this.f8395e == null || s0()) {
                    return;
                }
                k.b bVarV = this.f8395e.v();
                bVarV.E(0.0f).w(0.0f);
                R0(bVarV.m());
                return;
            }
            if (i3 == 1) {
                this.f8391a = new com.google.android.material.sidesheet.a(this);
                if (this.f8395e == null || r0()) {
                    return;
                }
                k.b bVarV2 = this.f8395e.v();
                bVarV2.A(0.0f).s(0.0f);
                R0(bVarV2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i3 + ". Must be 0 or 1.");
        }
    }

    private void H0(View view, int i3) {
        G0(r.b(((CoordinatorLayout.f) view.getLayoutParams()).f4216c, i3) == 3 ? 1 : 0);
    }

    private boolean K0() {
        return this.f8401k != null && (this.f8398h || this.f8399i == 1);
    }

    private boolean M0(View view) {
        return (view.isShown() || Z.q(view) != null) && this.f8398h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(View view, int i3, boolean z3) {
        if (!w0(view, i3, z3)) {
            J0(i3);
        } else {
            J0(2);
            this.f8396f.b(i3);
        }
    }

    private void P0() {
        View view;
        WeakReference weakReference = this.f8408r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        Z.k0(view, 262144);
        Z.k0(view, 1048576);
        if (this.f8399i != 5) {
            B0(view, T.a.f46y, 5);
        }
        if (this.f8399i != 3) {
            B0(view, T.a.f44w, 3);
        }
    }

    private void Q0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.f8408r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f8408r.get();
        View viewF0 = f0();
        if (viewF0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) == null) {
            return;
        }
        this.f8391a.o(marginLayoutParams, (int) ((this.f8404n * view.getScaleX()) + this.f8407q));
        viewF0.requestLayout();
    }

    private void R0(k kVar) {
        g gVar = this.f8393c;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
    }

    private void S0(View view) {
        int i3 = this.f8399i == 5 ? 4 : 0;
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private int U(int i3, View view) {
        int i4 = this.f8399i;
        if (i4 == 1 || i4 == 2) {
            return i3 - this.f8391a.h(view);
        }
        if (i4 == 3) {
            return 0;
        }
        if (i4 == 5) {
            return this.f8391a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f8399i);
    }

    private float V(float f3, float f4) {
        return Math.abs(f3 - f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W(View view, float f3, float f4) {
        if (u0(f3)) {
            return 3;
        }
        if (L0(view, f3)) {
            if (!this.f8391a.m(f3, f4) && !this.f8391a.l(view)) {
                return 3;
            }
        } else if (f3 == 0.0f || !com.google.android.material.sidesheet.d.a(f3, f4)) {
            int left = view.getLeft();
            if (Math.abs(left - g0()) < Math.abs(left - this.f8391a.e())) {
                return 3;
            }
        }
        return 5;
    }

    private void X() {
        WeakReference weakReference = this.f8409s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f8409s = null;
    }

    private Y Y(final int i3) {
        return new Y() { // from class: m1.a
            @Override // A.Y
            public final boolean a(View view, Y.a aVar) {
                return this.f10004a.x0(i3, view, aVar);
            }
        };
    }

    private void Z(Context context) {
        if (this.f8395e == null) {
            return;
        }
        g gVar = new g(this.f8395e);
        this.f8393c = gVar;
        gVar.K(context);
        ColorStateList colorStateList = this.f8394d;
        if (colorStateList != null) {
            this.f8393c.V(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f8393c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(View view, int i3) {
        if (this.f8414x.isEmpty()) {
            return;
        }
        this.f8391a.b(i3);
        Iterator it = this.f8414x.iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
    }

    private void b0(View view) {
        if (Z.q(view) == null) {
            Z.t0(view, view.getResources().getString(f8390z));
        }
    }

    private int c0(int i3, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    private ValueAnimator.AnimatorUpdateListener e0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewF0 = f0();
        if (viewF0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f8391a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: m1.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f10008a.y0(marginLayoutParams, iC, viewF0, valueAnimator);
            }
        };
    }

    private int h0() {
        com.google.android.material.sidesheet.c cVar = this.f8391a;
        return (cVar == null || cVar.j() == 0) ? 5 : 3;
    }

    private CoordinatorLayout.f q0() {
        View view;
        WeakReference weakReference = this.f8408r;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) view.getLayoutParams();
    }

    private boolean r0() {
        CoordinatorLayout.f fVarQ0 = q0();
        return fVarQ0 != null && ((ViewGroup.MarginLayoutParams) fVarQ0).leftMargin > 0;
    }

    private boolean s0() {
        CoordinatorLayout.f fVarQ0 = q0();
        return fVarQ0 != null && ((ViewGroup.MarginLayoutParams) fVarQ0).rightMargin > 0;
    }

    private boolean t0(MotionEvent motionEvent) {
        return K0() && V((float) this.f8413w, motionEvent.getX()) > ((float) this.f8401k.z());
    }

    private boolean u0(float f3) {
        return this.f8391a.k(f3);
    }

    private boolean v0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && Z.T(view);
    }

    private boolean w0(View view, int i3, boolean z3) {
        int iL0 = l0(i3);
        G.c cVarP0 = p0();
        return cVarP0 != null && (!z3 ? !cVarP0.Q(view, iL0, view.getTop()) : !cVarP0.O(iL0, view.getTop()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x0(int i3, View view, Y.a aVar) {
        I0(i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, View view, ValueAnimator valueAnimator) {
        this.f8391a.o(marginLayoutParams, T0.a.c(i3, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(int i3) {
        View view = (View) this.f8408r.get();
        if (view != null) {
            O0(view, i3, false);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void B(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        c cVar = (c) parcelable;
        if (cVar.c() != null) {
            super.B(coordinatorLayout, view, cVar.c());
        }
        int i3 = cVar.f8418c;
        if (i3 == 1 || i3 == 2) {
            i3 = 5;
        }
        this.f8399i = i3;
        this.f8400j = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable C(CoordinatorLayout coordinatorLayout, View view) {
        return new c(super.C(coordinatorLayout, view), this);
    }

    public void E0(int i3) {
        this.f8410t = i3;
        X();
        WeakReference weakReference = this.f8408r;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i3 == -1 || !Z.U(view)) {
                return;
            }
            view.requestLayout();
        }
    }

    public void F0(boolean z3) {
        this.f8398h = z3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f8399i == 1 && actionMasked == 0) {
            return true;
        }
        if (K0()) {
            this.f8401k.F(motionEvent);
        }
        if (actionMasked == 0) {
            C0();
        }
        if (this.f8411u == null) {
            this.f8411u = VelocityTracker.obtain();
        }
        this.f8411u.addMovement(motionEvent);
        if (K0() && actionMasked == 2 && !this.f8402l && t0(motionEvent)) {
            this.f8401k.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f8402l;
    }

    public void I0(final int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference weakReference = this.f8408r;
        if (weakReference == null || weakReference.get() == null) {
            J0(i3);
        } else {
            D0((View) this.f8408r.get(), new Runnable() { // from class: m1.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10006a.z0(i3);
                }
            });
        }
    }

    void J0(int i3) {
        View view;
        if (this.f8399i == i3) {
            return;
        }
        this.f8399i = i3;
        if (i3 == 3 || i3 == 5) {
            this.f8400j = i3;
        }
        WeakReference weakReference = this.f8408r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S0(view);
        Iterator it = this.f8414x.iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
        P0();
    }

    boolean L0(View view, float f3) {
        return this.f8391a.n(view, f3);
    }

    public boolean N0() {
        return true;
    }

    @Override // p022f1.b
    public void a() {
        p022f1.g gVar = this.f8412v;
        if (gVar == null) {
            return;
        }
        androidx.activity.b bVarC = gVar.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            I0(5);
        } else {
            this.f8412v.h(bVarC, h0(), new b(), e0());
        }
    }

    @Override // p022f1.b
    public void b(androidx.activity.b bVar) {
        p022f1.g gVar = this.f8412v;
        if (gVar == null) {
            return;
        }
        gVar.j(bVar);
    }

    @Override // p022f1.b
    public void c(androidx.activity.b bVar) {
        p022f1.g gVar = this.f8412v;
        if (gVar == null) {
            return;
        }
        gVar.l(bVar, h0());
        Q0();
    }

    @Override // p022f1.b
    public void d() {
        p022f1.g gVar = this.f8412v;
        if (gVar == null) {
            return;
        }
        gVar.f();
    }

    int d0() {
        return this.f8404n;
    }

    public View f0() {
        WeakReference weakReference = this.f8409s;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public int g0() {
        return this.f8391a.d();
    }

    public float i0() {
        return this.f8403m;
    }

    float j0() {
        return 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        super.k(fVar);
        this.f8408r = null;
        this.f8401k = null;
        this.f8412v = null;
    }

    int k0() {
        return this.f8407q;
    }

    int l0(int i3) {
        if (i3 == 3) {
            return g0();
        }
        if (i3 == 5) {
            return this.f8391a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i3);
    }

    int m0() {
        return this.f8406p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void n() {
        super.n();
        this.f8408r = null;
        this.f8401k = null;
        this.f8412v = null;
    }

    int n0() {
        return this.f8405o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        G.c cVar;
        if (!M0(view)) {
            this.f8402l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            C0();
        }
        if (this.f8411u == null) {
            this.f8411u = VelocityTracker.obtain();
        }
        this.f8411u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f8413w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f8402l) {
            this.f8402l = false;
            return false;
        }
        return (this.f8402l || (cVar = this.f8401k) == null || !cVar.P(motionEvent)) ? false : true;
    }

    int o0() {
        return 500;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (Z.z(coordinatorLayout) && !Z.z(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f8408r == null) {
            this.f8408r = new WeakReference(view);
            this.f8412v = new p022f1.g(view);
            g gVar = this.f8393c;
            if (gVar != null) {
                Z.u0(view, gVar);
                g gVar2 = this.f8393c;
                float fW = this.f8397g;
                if (fW == -1.0f) {
                    fW = Z.w(view);
                }
                gVar2.U(fW);
            } else {
                ColorStateList colorStateList = this.f8394d;
                if (colorStateList != null) {
                    Z.v0(view, colorStateList);
                }
            }
            S0(view);
            P0();
            if (Z.A(view) == 0) {
                Z.z0(view, 1);
            }
            b0(view);
        }
        H0(view, i3);
        if (this.f8401k == null) {
            this.f8401k = G.c.o(coordinatorLayout, this.f8415y);
        }
        int iH = this.f8391a.h(view);
        coordinatorLayout.K(view, i3);
        this.f8405o = coordinatorLayout.getWidth();
        this.f8406p = this.f8391a.i(coordinatorLayout);
        this.f8404n = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f8407q = marginLayoutParams != null ? this.f8391a.a(marginLayoutParams) : 0;
        Z.a0(view, U(iH, view));
        A0(coordinatorLayout);
        Iterator it = this.f8414x.iterator();
        while (it.hasNext()) {
            H.a(it.next());
        }
        return true;
    }

    G.c p0() {
        return this.f8401k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(c0(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, -1, marginLayoutParams.width), c0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, -1, marginLayoutParams.height));
        return true;
    }

    protected static class c extends F.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f8418c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
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
            this.f8418c = parcel.readInt();
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f8418c);
        }

        public c(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f8418c = sideSheetBehavior.f8399i;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8396f = new d();
        this.f8398h = true;
        this.f8399i = 5;
        this.f8400j = 5;
        this.f8403m = 0.1f;
        this.f8410t = -1;
        this.f8414x = new LinkedHashSet();
        this.f8415y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.Q5);
        int i3 = S0.k.S5;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.f8394d = p030h1.c.a(context, typedArrayObtainStyledAttributes, i3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(S0.k.V5)) {
            this.f8395e = k.e(context, attributeSet, 0, f8389A).m();
        }
        int i4 = S0.k.U5;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            E0(typedArrayObtainStyledAttributes.getResourceId(i4, -1));
        }
        Z(context);
        this.f8397g = typedArrayObtainStyledAttributes.getDimension(S0.k.R5, -1.0f);
        F0(typedArrayObtainStyledAttributes.getBoolean(S0.k.T5, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f8392b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
