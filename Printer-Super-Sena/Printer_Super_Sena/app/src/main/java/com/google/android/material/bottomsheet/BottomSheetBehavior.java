package com.google.android.material.bottomsheet;

import A.T;
import A.Y;
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
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import com.google.android.material.internal.F;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p042l1.k;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements p022f1.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final int f7712i0 = j.f1720g;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f7713A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final i f7714B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private ValueAnimator f7715C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    int f7716D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    int f7717E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    int f7718F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    float f7719G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    int f7720H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    float f7721I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f7722J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private boolean f7723K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f7724L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    int f7725M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    int f7726N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    G.c f7727O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f7728P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f7729Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private boolean f7730R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private float f7731S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f7732T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    int f7733U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    int f7734V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    WeakReference f7735W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    WeakReference f7736X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    WeakReference f7737Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private final ArrayList f7738Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7739a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private VelocityTracker f7740a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7741b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    p022f1.f f7742b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7743c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    int f7744c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7745d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f7746d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7747e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    boolean f7748e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7749f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Map f7750f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7751g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    final SparseIntArray f7752g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7753h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final G.c.AbstractC0015c f7754h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p042l1.g f7756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f7757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7765s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f7766t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7769w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f7770x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f7771y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private k f7772z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7774b;

        a(View view, int i3) {
            this.f7773a = view;
            this.f7774b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.b1(this.f7773a, this.f7774b, false);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.U0(5);
            WeakReference weakReference = BottomSheetBehavior.this.f7735W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((View) BottomSheetBehavior.this.f7735W.get()).requestLayout();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f7756j != null) {
                BottomSheetBehavior.this.f7756j.W(fFloatValue);
            }
        }
    }

    class d implements F.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7778a;

        d(boolean z3) {
            this.f7778a = z3;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.F.c
        public C0332z0 a(View view, C0332z0 c0332z0, F.d dVar) {
            boolean z3;
            androidx.core.graphics.e eVarF = c0332z0.f(C0332z0.m.d());
            androidx.core.graphics.e eVarF2 = c0332z0.f(C0332z0.m.c());
            BottomSheetBehavior.this.f7770x = eVarF.f4483b;
            boolean zG = F.g(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f7762p) {
                BottomSheetBehavior.this.f7769w = c0332z0.i();
                paddingBottom = dVar.f8194d + BottomSheetBehavior.this.f7769w;
            }
            if (BottomSheetBehavior.this.f7763q) {
                paddingLeft = (zG ? dVar.f8193c : dVar.f8191a) + eVarF.f4482a;
            }
            if (BottomSheetBehavior.this.f7764r) {
                paddingRight = (zG ? dVar.f8191a : dVar.f8193c) + eVarF.f4484c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z4 = true;
            if (BottomSheetBehavior.this.f7766t) {
                int i3 = marginLayoutParams.leftMargin;
                int i4 = eVarF.f4482a;
                if (i3 != i4) {
                    marginLayoutParams.leftMargin = i4;
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            if (BottomSheetBehavior.this.f7767u) {
                int i5 = marginLayoutParams.rightMargin;
                int i6 = eVarF.f4484c;
                if (i5 != i6) {
                    marginLayoutParams.rightMargin = i6;
                    z3 = true;
                }
            }
            if (BottomSheetBehavior.this.f7768v) {
                int i7 = marginLayoutParams.topMargin;
                int i8 = eVarF.f4483b;
                if (i7 != i8) {
                    marginLayoutParams.topMargin = i8;
                } else {
                    z4 = z3;
                }
            } else {
                z4 = z3;
            }
            if (z4) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f7778a) {
                BottomSheetBehavior.this.f7760n = eVarF2.f4485d;
            }
            if (BottomSheetBehavior.this.f7762p || this.f7778a) {
                BottomSheetBehavior.this.g1(false);
            }
            return c0332z0;
        }
    }

    class e extends G.c.AbstractC0015c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7780a;

        e() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.f7734V + bottomSheetBehavior.s0()) / 2;
        }

        @Override // G.c.AbstractC0015c
        public int a(View view, int i3, int i4) {
            return view.getLeft();
        }

        @Override // G.c.AbstractC0015c
        public int b(View view, int i3, int i4) {
            return p076x.a.b(i3, BottomSheetBehavior.this.s0(), e(view));
        }

        @Override // G.c.AbstractC0015c
        public int e(View view) {
            return BottomSheetBehavior.this.j0() ? BottomSheetBehavior.this.f7734V : BottomSheetBehavior.this.f7720H;
        }

        @Override // G.c.AbstractC0015c
        public void j(int i3) {
            if (i3 == 1 && BottomSheetBehavior.this.f7724L) {
                BottomSheetBehavior.this.U0(1);
            }
        }

        @Override // G.c.AbstractC0015c
        public void k(View view, int i3, int i4, int i5, int i6) {
            BottomSheetBehavior.this.o0(i4);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:6:0x0010  */
        @Override // G.c.AbstractC0015c
        public void l(View view, float f3, float f4) {
            int i3 = 6;
            if (f4 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f7722J && bottomSheetBehavior.Y0(view, f4)) {
                    if ((Math.abs(f3) < Math.abs(f4) && f4 > BottomSheetBehavior.this.f7747e) || n(view)) {
                        i3 = 5;
                    } else if (BottomSheetBehavior.this.f7741b || Math.abs(view.getTop() - BottomSheetBehavior.this.s0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.f7718F)) {
                        i3 = 3;
                    }
                } else if (f4 == 0.0f || Math.abs(f3) > Math.abs(f4)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.f7741b) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i4 = bottomSheetBehavior2.f7718F;
                        if (top < i4) {
                            if (top < Math.abs(top - bottomSheetBehavior2.f7720H)) {
                                i3 = 3;
                            } else if (BottomSheetBehavior.this.Z0()) {
                                i3 = 4;
                            }
                        } else if (Math.abs(top - i4) >= Math.abs(top - BottomSheetBehavior.this.f7720H) || BottomSheetBehavior.this.Z0()) {
                            i3 = 4;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.f7717E) < Math.abs(top - BottomSheetBehavior.this.f7720H)) {
                        i3 = 3;
                    } else {
                        i3 = 4;
                    }
                } else if (BottomSheetBehavior.this.f7741b) {
                    i3 = 4;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.f7718F) >= Math.abs(top2 - BottomSheetBehavior.this.f7720H) || BottomSheetBehavior.this.Z0()) {
                        i3 = 4;
                    }
                }
            } else if (BottomSheetBehavior.this.f7741b) {
                i3 = 3;
            } else {
                int top3 = view.getTop();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f7780a;
                if (BottomSheetBehavior.this.Z0()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior3.W0(jCurrentTimeMillis, (top3 * 100.0f) / bottomSheetBehavior3.f7734V)) {
                        i3 = 4;
                    }
                } else if (top3 <= BottomSheetBehavior.this.f7718F) {
                }
                i3 = 3;
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.b1(view, i3, bottomSheetBehavior4.a1());
        }

        @Override // G.c.AbstractC0015c
        public boolean m(View view, int i3) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i4 = bottomSheetBehavior.f7725M;
            if (i4 == 1 || bottomSheetBehavior.f7748e0) {
                return false;
            }
            if (i4 == 3 && bottomSheetBehavior.f7744c0 == i3) {
                WeakReference weakReference = bottomSheetBehavior.f7737Y;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f7780a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.f7735W;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class f implements Y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7782a;

        f(int i3) {
            this.f7782a = i3;
        }

        @Override // A.Y
        public boolean a(View view, Y.a aVar) {
            BottomSheetBehavior.this.T0(this.f7782a);
            return true;
        }
    }

    public static abstract class g {
        void a(View view) {
        }

        public abstract void b(View view, float f3);

        public abstract void c(View view, int i3);
    }

    public BottomSheetBehavior() {
        this.f7739a = 0;
        this.f7741b = true;
        this.f7743c = false;
        this.f7758l = -1;
        this.f7759m = -1;
        this.f7714B = new i(this, null);
        this.f7719G = 0.5f;
        this.f7721I = -1.0f;
        this.f7724L = true;
        this.f7725M = 4;
        this.f7726N = 4;
        this.f7731S = 0.1f;
        this.f7738Z = new ArrayList();
        this.f7746d0 = -1;
        this.f7752g0 = new SparseIntArray();
        this.f7754h0 = new e();
    }

    private boolean A0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && Z.T(view);
    }

    private void C0(View view, T.a aVar, int i3) {
        Z.m0(view, aVar, null, l0(i3));
    }

    private void D0() {
        this.f7744c0 = -1;
        this.f7746d0 = -1;
        VelocityTracker velocityTracker = this.f7740a0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7740a0 = null;
        }
    }

    private void E0(h hVar) {
        int i3 = this.f7739a;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.f7749f = hVar.f7785d;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.f7741b = hVar.f7786e;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.f7722J = hVar.f7787f;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.f7723K = hVar.f7788g;
        }
    }

    private void F0(View view, Runnable runnable) {
        if (A0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void V0(View view) {
        boolean z3 = (Build.VERSION.SDK_INT < 29 || x0() || this.f7751g) ? false : true;
        if (this.f7762p || this.f7763q || this.f7764r || this.f7766t || this.f7767u || this.f7768v || z3) {
            F.b(view, new d(z3));
        }
    }

    private boolean X0() {
        return this.f7727O != null && (this.f7724L || this.f7725M == 1);
    }

    private int b0(View view, int i3, int i4) {
        return Z.c(view, view.getResources().getString(i3), l0(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(View view, int i3, boolean z3) {
        int iT0 = t0(i3);
        G.c cVar = this.f7727O;
        if (cVar == null || (!z3 ? cVar.Q(view, view.getLeft(), iT0) : cVar.O(view.getLeft(), iT0))) {
            U0(i3);
            return;
        }
        U0(2);
        e1(i3, true);
        this.f7714B.c(i3);
    }

    private void c1() {
        WeakReference weakReference = this.f7735W;
        if (weakReference != null) {
            d1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.f7736X;
        if (weakReference2 != null) {
            d1((View) weakReference2.get(), 1);
        }
    }

    private void d0() {
        int iH0 = h0();
        if (this.f7741b) {
            this.f7720H = Math.max(this.f7734V - iH0, this.f7717E);
        } else {
            this.f7720H = this.f7734V - iH0;
        }
    }

    private void d1(View view, int i3) {
        if (view == null) {
            return;
        }
        k0(view, i3);
        if (!this.f7741b && this.f7725M != 6) {
            this.f7752g0.put(i3, b0(view, S0.i.f1688a, 6));
        }
        if (this.f7722J && z0() && this.f7725M != 5) {
            C0(view, T.a.f46y, 5);
        }
        int i4 = this.f7725M;
        if (i4 == 3) {
            C0(view, T.a.f45x, this.f7741b ? 4 : 6);
            return;
        }
        if (i4 == 4) {
            C0(view, T.a.f44w, this.f7741b ? 3 : 6);
        } else {
            if (i4 != 6) {
                return;
            }
            C0(view, T.a.f45x, 4);
            C0(view, T.a.f44w, 3);
        }
    }

    private float e0(float f3, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f3 > 0.0f) {
                return radius / f3;
            }
        }
        return 0.0f;
    }

    private void e1(int i3, boolean z3) {
        boolean zW0;
        ValueAnimator valueAnimator;
        if (i3 == 2 || this.f7713A == (zW0 = w0()) || this.f7756j == null) {
            return;
        }
        this.f7713A = zW0;
        if (!z3 || (valueAnimator = this.f7715C) == null) {
            ValueAnimator valueAnimator2 = this.f7715C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f7715C.cancel();
            }
            this.f7756j.W(this.f7713A ? g0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.f7715C.reverse();
        } else {
            this.f7715C.setFloatValues(this.f7756j.w(), zW0 ? g0() : 1.0f);
            this.f7715C.start();
        }
    }

    private void f0() {
        this.f7718F = (int) (this.f7734V * (1.0f - this.f7719G));
    }

    private void f1(boolean z3) {
        Map map;
        WeakReference weakReference = this.f7735W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z3) {
                if (this.f7750f0 != null) {
                    return;
                } else {
                    this.f7750f0 = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.f7735W.get()) {
                    if (z3) {
                        this.f7750f0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f7743c) {
                            Z.z0(childAt, 4);
                        }
                    } else if (this.f7743c && (map = this.f7750f0) != null && map.containsKey(childAt)) {
                        Z.z0(childAt, ((Integer) this.f7750f0.get(childAt)).intValue());
                    }
                }
            }
            if (!z3) {
                this.f7750f0 = null;
            } else if (this.f7743c) {
                ((View) this.f7735W.get()).sendAccessibilityEvent(8);
            }
        }
    }

    private float g0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        if (this.f7756j == null || (weakReference = this.f7735W) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.f7735W.get();
        if (!v0() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(e0(this.f7756j.D(), rootWindowInsets.getRoundedCorner(0)), e0(this.f7756j.E(), rootWindowInsets.getRoundedCorner(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(boolean z3) {
        View view;
        if (this.f7735W != null) {
            d0();
            if (this.f7725M != 4 || (view = (View) this.f7735W.get()) == null) {
                return;
            }
            if (z3) {
                T0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    private int h0() {
        int i3;
        if (this.f7751g) {
            return Math.min(Math.max(this.f7753h, this.f7734V - ((this.f7733U * 9) / 16)), this.f7732T) + this.f7769w;
        }
        return (this.f7761o || this.f7762p || (i3 = this.f7760n) <= 0) ? this.f7749f + this.f7769w : Math.max(this.f7749f, i3 + this.f7755i);
    }

    private float i0(int i3) {
        float f3;
        float fS0;
        int i4 = this.f7720H;
        if (i3 > i4 || i4 == s0()) {
            int i5 = this.f7720H;
            f3 = i5 - i3;
            fS0 = this.f7734V - i5;
        } else {
            int i6 = this.f7720H;
            f3 = i6 - i3;
            fS0 = i6 - s0();
        }
        return f3 / fS0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0() {
        return y0() && z0();
    }

    private void k0(View view, int i3) {
        if (view == null) {
            return;
        }
        Z.k0(view, 524288);
        Z.k0(view, 262144);
        Z.k0(view, 1048576);
        int i4 = this.f7752g0.get(i3, -1);
        if (i4 != -1) {
            Z.k0(view, i4);
            this.f7752g0.delete(i3);
        }
    }

    private Y l0(int i3) {
        return new f(i3);
    }

    private void m0(Context context) {
        if (this.f7772z == null) {
            return;
        }
        p042l1.g gVar = new p042l1.g(this.f7772z);
        this.f7756j = gVar;
        gVar.K(context);
        ColorStateList colorStateList = this.f7757k;
        if (colorStateList != null) {
            this.f7756j.V(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f7756j.setTint(typedValue.data);
    }

    private void n0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(g0(), 1.0f);
        this.f7715C = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f7715C.addUpdateListener(new c());
    }

    public static BottomSheetBehavior q0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarE = ((CoordinatorLayout.f) layoutParams).e();
        if (cVarE instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarE;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int r0(int i3, int i4, int i5, int i6) {
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

    private int t0(int i3) {
        if (i3 == 3) {
            return s0();
        }
        if (i3 == 4) {
            return this.f7720H;
        }
        if (i3 == 5) {
            return this.f7734V;
        }
        if (i3 == 6) {
            return this.f7718F;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
    }

    private float u0() {
        VelocityTracker velocityTracker = this.f7740a0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f7745d);
        return this.f7740a0.getYVelocity(this.f7744c0);
    }

    private boolean v0() {
        WeakReference weakReference = this.f7735W;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.f7735W.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean w0() {
        return this.f7725M == 3 && (this.f7771y || v0());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void B(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.B(coordinatorLayout, view, hVar.c());
        E0(hVar);
        int i3 = hVar.f7784c;
        if (i3 == 1 || i3 == 2) {
            this.f7725M = 4;
            this.f7726N = 4;
        } else {
            this.f7725M = i3;
            this.f7726N = i3;
        }
    }

    public boolean B0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable C(CoordinatorLayout coordinatorLayout, View view) {
        return new h(super.C(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        this.f7729Q = 0;
        this.f7730R = false;
        return (i3 & 2) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void G(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
        WeakReference weakReference;
        int i4 = 3;
        if (view.getTop() == s0()) {
            U0(3);
            return;
        }
        if (!B0() || ((weakReference = this.f7737Y) != null && view2 == weakReference.get() && this.f7730R)) {
            if (this.f7729Q > 0) {
                if (!this.f7741b && view.getTop() > this.f7718F) {
                    i4 = 6;
                }
            } else if (this.f7722J && Y0(view, u0())) {
                i4 = 5;
            } else if (this.f7729Q == 0) {
                int top = view.getTop();
                if (!this.f7741b) {
                    int i5 = this.f7718F;
                    if (top < i5) {
                        if (top >= Math.abs(top - this.f7720H)) {
                            if (Z0()) {
                                i4 = 4;
                            } else {
                                i4 = 6;
                            }
                        }
                    } else if (Math.abs(top - i5) < Math.abs(top - this.f7720H)) {
                        i4 = 6;
                    } else {
                        i4 = 4;
                    }
                } else if (Math.abs(top - this.f7717E) >= Math.abs(top - this.f7720H)) {
                    i4 = 4;
                }
            } else {
                if (!this.f7741b) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.f7718F) < Math.abs(top2 - this.f7720H)) {
                        i4 = 6;
                    }
                }
                i4 = 4;
            }
            b1(view, i4, false);
            this.f7730R = false;
        }
    }

    public void G0(boolean z3) {
        this.f7724L = z3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f7725M == 1 && actionMasked == 0) {
            return true;
        }
        if (X0()) {
            this.f7727O.F(motionEvent);
        }
        if (actionMasked == 0) {
            D0();
        }
        if (this.f7740a0 == null) {
            this.f7740a0 = VelocityTracker.obtain();
        }
        this.f7740a0.addMovement(motionEvent);
        if (X0() && actionMasked == 2 && !this.f7728P && Math.abs(this.f7746d0 - motionEvent.getY()) > this.f7727O.z()) {
            this.f7727O.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f7728P;
    }

    public void H0(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f7716D = i3;
        e1(this.f7725M, true);
    }

    public void I0(boolean z3) {
        if (this.f7741b == z3) {
            return;
        }
        this.f7741b = z3;
        if (this.f7735W != null) {
            d0();
        }
        U0((this.f7741b && this.f7725M == 6) ? 3 : this.f7725M);
        e1(this.f7725M, true);
        c1();
    }

    public void J0(boolean z3) {
        this.f7761o = z3;
    }

    public void K0(float f3) {
        if (f3 <= 0.0f || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f7719G = f3;
        if (this.f7735W != null) {
            f0();
        }
    }

    public void L0(boolean z3) {
        if (this.f7722J != z3) {
            this.f7722J = z3;
            if (!z3 && this.f7725M == 5) {
                T0(4);
            }
            c1();
        }
    }

    public void M0(int i3) {
        this.f7759m = i3;
    }

    public void N0(int i3) {
        this.f7758l = i3;
    }

    public void O0(int i3) {
        P0(i3, false);
    }

    public final void P0(int i3, boolean z3) {
        if (i3 == -1) {
            if (this.f7751g) {
                return;
            } else {
                this.f7751g = true;
            }
        } else {
            if (!this.f7751g && this.f7749f == i3) {
                return;
            }
            this.f7751g = false;
            this.f7749f = Math.max(0, i3);
        }
        g1(z3);
    }

    public void Q0(int i3) {
        this.f7739a = i3;
    }

    public void R0(int i3) {
        this.f7747e = i3;
    }

    public void S0(boolean z3) {
        this.f7723K = z3;
    }

    public void T0(int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.f7722J && i3 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i3);
            return;
        }
        int i4 = (i3 == 6 && this.f7741b && t0(i3) <= this.f7717E) ? 3 : i3;
        WeakReference weakReference = this.f7735W;
        if (weakReference == null || weakReference.get() == null) {
            U0(i3);
        } else {
            View view = (View) this.f7735W.get();
            F0(view, new a(view, i4));
        }
    }

    void U0(int i3) {
        View view;
        if (this.f7725M == i3) {
            return;
        }
        this.f7725M = i3;
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.f7722J && i3 == 5)) {
            this.f7726N = i3;
        }
        WeakReference weakReference = this.f7735W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            f1(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            f1(false);
        }
        e1(i3, true);
        for (int i4 = 0; i4 < this.f7738Z.size(); i4++) {
            ((g) this.f7738Z.get(i4)).c(view, i3);
        }
        c1();
    }

    public boolean W0(long j3, float f3) {
        return false;
    }

    boolean Y0(View view, float f3) {
        if (this.f7723K) {
            return true;
        }
        if (z0() && view.getTop() >= this.f7720H) {
            return Math.abs((((float) view.getTop()) + (f3 * this.f7731S)) - ((float) this.f7720H)) / ((float) h0()) > 0.5f;
        }
        return false;
    }

    public boolean Z0() {
        return false;
    }

    @Override // p022f1.b
    public void a() {
        p022f1.f fVar = this.f7742b0;
        if (fVar == null) {
            return;
        }
        androidx.activity.b bVarC = fVar.c();
        if (bVarC == null || Build.VERSION.SDK_INT < 34) {
            T0(this.f7722J ? 5 : 4);
        } else if (this.f7722J) {
            this.f7742b0.h(bVarC, new b());
        } else {
            this.f7742b0.i(bVarC, null);
            T0(4);
        }
    }

    public boolean a1() {
        return true;
    }

    @Override // p022f1.b
    public void b(androidx.activity.b bVar) {
        p022f1.f fVar = this.f7742b0;
        if (fVar == null) {
            return;
        }
        fVar.j(bVar);
    }

    @Override // p022f1.b
    public void c(androidx.activity.b bVar) {
        p022f1.f fVar = this.f7742b0;
        if (fVar == null) {
            return;
        }
        fVar.l(bVar);
    }

    public void c0(g gVar) {
        if (this.f7738Z.contains(gVar)) {
            return;
        }
        this.f7738Z.add(gVar);
    }

    @Override // p022f1.b
    public void d() {
        p022f1.f fVar = this.f7742b0;
        if (fVar == null) {
            return;
        }
        fVar.f();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        super.k(fVar);
        this.f7735W = null;
        this.f7727O = null;
        this.f7742b0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void n() {
        super.n();
        this.f7735W = null;
        this.f7727O = null;
        this.f7742b0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i3;
        G.c cVar;
        if (!view.isShown() || !this.f7724L) {
            this.f7728P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D0();
        }
        if (this.f7740a0 == null) {
            this.f7740a0 = VelocityTracker.obtain();
        }
        this.f7740a0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x3 = (int) motionEvent.getX();
            this.f7746d0 = (int) motionEvent.getY();
            if (this.f7725M != 2) {
                WeakReference weakReference = this.f7737Y;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.C(view2, x3, this.f7746d0)) {
                    this.f7744c0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f7748e0 = true;
                }
            }
            this.f7728P = this.f7744c0 == -1 && !coordinatorLayout.C(view, x3, this.f7746d0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f7748e0 = false;
            this.f7744c0 = -1;
            if (this.f7728P) {
                this.f7728P = false;
                return false;
            }
        }
        if (!this.f7728P && (cVar = this.f7727O) != null && cVar.P(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f7737Y;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f7728P || this.f7725M == 1 || coordinatorLayout.C(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f7727O == null || (i3 = this.f7746d0) == -1 || Math.abs(((float) i3) - motionEvent.getY()) <= ((float) this.f7727O.z())) ? false : true;
    }

    void o0(int i3) {
        View view = (View) this.f7735W.get();
        if (view == null || this.f7738Z.isEmpty()) {
            return;
        }
        float fI0 = i0(i3);
        for (int i4 = 0; i4 < this.f7738Z.size(); i4++) {
            ((g) this.f7738Z.get(i4)).b(view, fI0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (Z.z(coordinatorLayout) && !Z.z(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f7735W == null) {
            this.f7753h = coordinatorLayout.getResources().getDimensionPixelSize(S0.c.f1569b);
            V0(view);
            Z.K0(view, new com.google.android.material.bottomsheet.a(view));
            this.f7735W = new WeakReference(view);
            this.f7742b0 = new p022f1.f(view);
            p042l1.g gVar = this.f7756j;
            if (gVar != null) {
                Z.u0(view, gVar);
                p042l1.g gVar2 = this.f7756j;
                float fW = this.f7721I;
                if (fW == -1.0f) {
                    fW = Z.w(view);
                }
                gVar2.U(fW);
            } else {
                ColorStateList colorStateList = this.f7757k;
                if (colorStateList != null) {
                    Z.v0(view, colorStateList);
                }
            }
            c1();
            if (Z.A(view) == 0) {
                Z.z0(view, 1);
            }
        }
        if (this.f7727O == null) {
            this.f7727O = G.c.o(coordinatorLayout, this.f7754h0);
        }
        int top = view.getTop();
        coordinatorLayout.K(view, i3);
        this.f7733U = coordinatorLayout.getWidth();
        this.f7734V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f7732T = height;
        int iMin = this.f7734V;
        int i4 = iMin - height;
        int i5 = this.f7770x;
        if (i4 < i5) {
            if (this.f7765s) {
                int i6 = this.f7759m;
                if (i6 != -1) {
                    iMin = Math.min(iMin, i6);
                }
                this.f7732T = iMin;
            } else {
                int iMin2 = iMin - i5;
                int i7 = this.f7759m;
                if (i7 != -1) {
                    iMin2 = Math.min(iMin2, i7);
                }
                this.f7732T = iMin2;
            }
        }
        this.f7717E = Math.max(0, this.f7734V - this.f7732T);
        f0();
        d0();
        int i8 = this.f7725M;
        if (i8 == 3) {
            Z.b0(view, s0());
        } else if (i8 == 6) {
            Z.b0(view, this.f7718F);
        } else if (this.f7722J && i8 == 5) {
            Z.b0(view, this.f7734V);
        } else if (i8 == 4) {
            Z.b0(view, this.f7720H);
        } else if (i8 == 1 || i8 == 2) {
            Z.b0(view, top - view.getTop());
        }
        e1(this.f7725M, false);
        this.f7737Y = new WeakReference(p0(view));
        for (int i9 = 0; i9 < this.f7738Z.size(); i9++) {
            ((g) this.f7738Z.get(i9)).a(view);
        }
        return true;
    }

    View p0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (Z.V(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View viewP0 = p0(viewGroup.getChildAt(i3));
                if (viewP0 != null) {
                    return viewP0;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(r0(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, this.f7758l, marginLayoutParams.width), r0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, this.f7759m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
        WeakReference weakReference;
        if (B0() && (weakReference = this.f7737Y) != null && view2 == weakReference.get()) {
            return this.f7725M != 3 || super.s(coordinatorLayout, view, view2, f3, f4);
        }
        return false;
    }

    public int s0() {
        if (this.f7741b) {
            return this.f7717E;
        }
        return Math.max(this.f7716D, this.f7765s ? 0 : this.f7770x);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1) {
            return;
        }
        WeakReference weakReference = this.f7737Y;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!B0() || view2 == view3) {
            int top = view.getTop();
            int i6 = top - i4;
            if (i4 > 0) {
                if (i6 < s0()) {
                    int iS0 = top - s0();
                    iArr[1] = iS0;
                    Z.b0(view, -iS0);
                    U0(3);
                } else {
                    if (!this.f7724L) {
                        return;
                    }
                    iArr[1] = i4;
                    Z.b0(view, -i4);
                    U0(1);
                }
            } else if (i4 < 0 && !view2.canScrollVertically(-1)) {
                if (i6 > this.f7720H && !j0()) {
                    int i7 = top - this.f7720H;
                    iArr[1] = i7;
                    Z.b0(view, -i7);
                    U0(4);
                } else {
                    if (!this.f7724L) {
                        return;
                    }
                    iArr[1] = i4;
                    Z.b0(view, -i4);
                    U0(1);
                }
            }
            o0(view.getTop());
            this.f7729Q = i4;
            this.f7730R = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
    }

    public boolean x0() {
        return this.f7761o;
    }

    public boolean y0() {
        return this.f7722J;
    }

    public boolean z0() {
        return true;
    }

    private class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f7791c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f7790b = false;
                G.c cVar = BottomSheetBehavior.this.f7727O;
                if (cVar != null && cVar.m(true)) {
                    i iVar = i.this;
                    iVar.c(iVar.f7789a);
                    return;
                }
                i iVar2 = i.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f7725M == 2) {
                    bottomSheetBehavior.U0(iVar2.f7789a);
                }
            }
        }

        private i() {
            this.f7791c = new a();
        }

        void c(int i3) {
            WeakReference weakReference = BottomSheetBehavior.this.f7735W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f7789a = i3;
            if (this.f7790b) {
                return;
            }
            Z.i0((View) BottomSheetBehavior.this.f7735W.get(), this.f7791c);
            this.f7790b = true;
        }

        /* synthetic */ i(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class h extends F.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f7784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f7786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f7787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f7788g;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7784c = parcel.readInt();
            this.f7785d = parcel.readInt();
            this.f7786e = parcel.readInt() == 1;
            this.f7787f = parcel.readInt() == 1;
            this.f7788g = parcel.readInt() == 1;
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f7784c);
            parcel.writeInt(this.f7785d);
            parcel.writeInt(this.f7786e ? 1 : 0);
            parcel.writeInt(this.f7787f ? 1 : 0);
            parcel.writeInt(this.f7788g ? 1 : 0);
        }

        public h(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f7784c = bottomSheetBehavior.f7725M;
            this.f7785d = bottomSheetBehavior.f7749f;
            this.f7786e = bottomSheetBehavior.f7741b;
            this.f7787f = bottomSheetBehavior.f7722J;
            this.f7788g = bottomSheetBehavior.f7723K;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3;
        super(context, attributeSet);
        this.f7739a = 0;
        this.f7741b = true;
        this.f7743c = false;
        this.f7758l = -1;
        this.f7759m = -1;
        this.f7714B = new i(this, null);
        this.f7719G = 0.5f;
        this.f7721I = -1.0f;
        this.f7724L = true;
        this.f7725M = 4;
        this.f7726N = 4;
        this.f7731S = 0.1f;
        this.f7738Z = new ArrayList();
        this.f7746d0 = -1;
        this.f7752g0 = new SparseIntArray();
        this.f7754h0 = new e();
        this.f7755i = context.getResources().getDimensionPixelSize(S0.c.f1574d0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S0.k.f1864k0);
        int i4 = S0.k.f1880o0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f7757k = p030h1.c.a(context, typedArrayObtainStyledAttributes, i4);
        }
        if (typedArrayObtainStyledAttributes.hasValue(S0.k.f1763G0)) {
            this.f7772z = k.e(context, attributeSet, S0.a.f1512d, f7712i0).m();
        }
        m0(context);
        n0();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7721I = typedArrayObtainStyledAttributes.getDimension(S0.k.f1876n0, -1.0f);
        }
        int i5 = S0.k.f1868l0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            N0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        int i6 = S0.k.f1872m0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            M0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = S0.k.f1904u0;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i7);
        if (typedValuePeekValue != null && (i3 = typedValuePeekValue.data) == -1) {
            O0(i3);
        } else {
            O0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        L0(typedArrayObtainStyledAttributes.getBoolean(S0.k.f1900t0, false));
        J0(typedArrayObtainStyledAttributes.getBoolean(S0.k.f1920y0, false));
        I0(typedArrayObtainStyledAttributes.getBoolean(S0.k.f1892r0, true));
        S0(typedArrayObtainStyledAttributes.getBoolean(S0.k.f1916x0, false));
        G0(typedArrayObtainStyledAttributes.getBoolean(S0.k.f1884p0, true));
        Q0(typedArrayObtainStyledAttributes.getInt(S0.k.f1908v0, 0));
        K0(typedArrayObtainStyledAttributes.getFloat(S0.k.f1896s0, 0.5f));
        int i8 = S0.k.f1888q0;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i8);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            H0(typedValuePeekValue2.data);
        } else {
            H0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i8, 0));
        }
        R0(typedArrayObtainStyledAttributes.getInt(S0.k.f1912w0, 500));
        this.f7762p = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1747C0, false);
        this.f7763q = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1751D0, false);
        this.f7764r = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1755E0, false);
        this.f7765s = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1759F0, true);
        this.f7766t = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1924z0, false);
        this.f7767u = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1739A0, false);
        this.f7768v = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1743B0, false);
        this.f7771y = typedArrayObtainStyledAttributes.getBoolean(S0.k.f1767H0, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f7745d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
