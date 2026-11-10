package androidx.recyclerview.widget;

import A.AbstractC0156b;
import A.T;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.app.H;
import androidx.core.view.AbstractC0289d0;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.C {

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    static final boolean f5803A0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    private static final boolean f5804B0;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    private static final boolean f5805C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    private static final Class[] f5806D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    static final Interpolator f5807E0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final int[] f5808w0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    static final boolean f5809x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    static final boolean f5810y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    static final boolean f5811z0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final AccessibilityManager f5812A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private List f5813B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    boolean f5814C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    boolean f5815D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f5816E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f5817F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private k f5818G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private EdgeEffect f5819H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private EdgeEffect f5820I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private EdgeEffect f5821J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private EdgeEffect f5822K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    l f5823L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private int f5824M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private int f5825N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private VelocityTracker f5826O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private int f5827P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f5828Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private int f5829R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private int f5830S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f5831T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private r f5832U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private final int f5833V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private final int f5834W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f5835a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f5836a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final v f5837b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f5838b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y f5839c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f5840c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    a f5841d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    final C f5842d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    b f5843e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    androidx.recyclerview.widget.f f5844e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final androidx.recyclerview.widget.r f5845f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    androidx.recyclerview.widget.f.b f5846f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f5847g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    final A f5848g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Runnable f5849h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private t f5850h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Rect f5851i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private List f5852i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f5853j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    boolean f5854j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final RectF f5855k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    boolean f5856k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f5857l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private l.a f5858l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    o f5859m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    boolean f5860m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ArrayList f5861n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    androidx.recyclerview.widget.m f5862n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayList f5863o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final int[] f5864o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private s f5865p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private androidx.core.view.D f5866p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f5867q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final int[] f5868q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f5869r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final int[] f5870r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f5871s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    final int[] f5872s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f5873t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    final List f5874t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5875u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private Runnable f5876u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f5877v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private final androidx.recyclerview.widget.r.b f5878v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f5879w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5880x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5881y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f5882z;

    public static class A {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray f5884b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f5895m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f5896n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f5897o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f5898p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f5899q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5883a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5885c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5886d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5887e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5888f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f5889g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f5890h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f5891i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f5892j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f5893k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f5894l = false;

        void a(int i3) {
            if ((this.f5887e & i3) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f5887e));
        }

        public int b() {
            return this.f5890h ? this.f5885c - this.f5886d : this.f5888f;
        }

        public int c() {
            return this.f5883a;
        }

        public boolean d() {
            return this.f5883a != -1;
        }

        public boolean e() {
            return this.f5890h;
        }

        void f(g gVar) {
            this.f5887e = 1;
            this.f5888f = gVar.e();
            this.f5890h = false;
            this.f5891i = false;
            this.f5892j = false;
        }

        public boolean g() {
            return this.f5894l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f5883a + ", mData=" + this.f5884b + ", mItemCount=" + this.f5888f + ", mIsMeasuring=" + this.f5892j + ", mPreviousLayoutItemCount=" + this.f5885c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f5886d + ", mStructureChanged=" + this.f5889g + ", mInPreLayout=" + this.f5890h + ", mRunSimpleAnimations=" + this.f5893k + ", mRunPredictiveAnimations=" + this.f5894l + '}';
        }
    }

    public static abstract class B {
    }

    class C implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        OverScroller f5902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Interpolator f5903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5905f;

        C() {
            Interpolator interpolator = RecyclerView.f5807E0;
            this.f5903d = interpolator;
            this.f5904e = false;
            this.f5905f = false;
            this.f5902c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i3, int i4, int i5, int i6) {
            int iRound;
            int iAbs = Math.abs(i3);
            int iAbs2 = Math.abs(i4);
            boolean z3 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i5 * i5) + (i6 * i6));
            int iSqrt2 = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z3 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i7 = width / 2;
            float f3 = width;
            float f4 = i7;
            float fB = f4 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f3)) * f4);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z3) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f3) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        private float b(float f3) {
            return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            Z.i0(RecyclerView.this, this);
        }

        public void c(int i3, int i4) {
            RecyclerView.this.setScrollState(2);
            this.f5901b = 0;
            this.f5900a = 0;
            Interpolator interpolator = this.f5903d;
            Interpolator interpolator2 = RecyclerView.f5807E0;
            if (interpolator != interpolator2) {
                this.f5903d = interpolator2;
                this.f5902c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f5902c.fling(0, 0, i3, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f5904e) {
                this.f5905f = true;
            } else {
                d();
            }
        }

        public void f(int i3, int i4, int i5, Interpolator interpolator) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = a(i3, i4, 0, 0);
            }
            int i6 = i5;
            if (interpolator == null) {
                interpolator = RecyclerView.f5807E0;
            }
            if (this.f5903d != interpolator) {
                this.f5903d = interpolator;
                this.f5902c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f5901b = 0;
            this.f5900a = 0;
            RecyclerView.this.setScrollState(2);
            this.f5902c.startScroll(0, 0, i3, i4, i6);
            if (Build.VERSION.SDK_INT < 23) {
                this.f5902c.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f5902c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f5859m == null) {
                g();
                return;
            }
            this.f5905f = false;
            this.f5904e = true;
            recyclerView.v();
            OverScroller overScroller = this.f5902c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.f5900a;
                int i7 = currY - this.f5901b;
                this.f5900a = currX;
                this.f5901b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f5872s0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i6, i7, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f5872s0;
                    i6 -= iArr2[0];
                    i7 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i6, i7);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f5857l != null) {
                    int[] iArr3 = recyclerView3.f5872s0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.h1(i6, i7, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f5872s0;
                    i4 = iArr4[0];
                    i3 = iArr4[1];
                    i6 -= i4;
                    i7 -= i3;
                    z zVar = recyclerView4.f5859m.f5950g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int iB = RecyclerView.this.f5848g0.b();
                        if (iB == 0) {
                            zVar.r();
                        } else if (zVar.f() >= iB) {
                            zVar.p(iB - 1);
                            zVar.j(i4, i3);
                        } else {
                            zVar.j(i4, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.f5861n.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f5872s0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i4, i3, i6, i7, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f5872s0;
                int i8 = i6 - iArr6[0];
                int i9 = i7 - iArr6[1];
                if (i4 != 0 || i3 != 0) {
                    recyclerView6.J(i4, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z3 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
                z zVar2 = RecyclerView.this.f5859m.f5950g;
                if ((zVar2 == null || !zVar2.g()) && z3) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i8 < 0) {
                            i5 = -currVelocity;
                        } else {
                            i5 = i8 > 0 ? currVelocity : 0;
                        }
                        if (i9 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i9 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i5, currVelocity);
                    }
                    if (RecyclerView.f5803A0) {
                        RecyclerView.this.f5846f0.b();
                    }
                } else {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.f fVar = recyclerView7.f5844e0;
                    if (fVar != null) {
                        fVar.f(recyclerView7, i4, i3);
                    }
                }
            }
            z zVar3 = RecyclerView.this.f5859m.f5950g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f5904e = false;
            if (this.f5905f) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.u1(1);
            }
        }
    }

    public static abstract class D {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final List f5907s = Collections.emptyList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f5908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference f5909b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f5917j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        RecyclerView f5925r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5910c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5911d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f5912e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5913f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f5914g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        D f5915h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        D f5916i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        List f5918k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List f5919l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f5920m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        v f5921n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f5922o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f5923p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f5924q = -1;

        public D(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f5908a = view;
        }

        private void g() {
            if (this.f5918k == null) {
                ArrayList arrayList = new ArrayList();
                this.f5918k = arrayList;
                this.f5919l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(int i3, boolean z3) {
            if (this.f5911d == -1) {
                this.f5911d = this.f5910c;
            }
            if (this.f5914g == -1) {
                this.f5914g = this.f5910c;
            }
            if (z3) {
                this.f5914g += i3;
            }
            this.f5910c += i3;
            if (this.f5908a.getLayoutParams() != null) {
                ((p) this.f5908a.getLayoutParams()).f5970c = true;
            }
        }

        void B(RecyclerView recyclerView) {
            int i3 = this.f5924q;
            if (i3 != -1) {
                this.f5923p = i3;
            } else {
                this.f5923p = Z.A(this.f5908a);
            }
            recyclerView.k1(this, 4);
        }

        void C(RecyclerView recyclerView) {
            recyclerView.k1(this, this.f5923p);
            this.f5923p = 0;
        }

        void D() {
            this.f5917j = 0;
            this.f5910c = -1;
            this.f5911d = -1;
            this.f5912e = -1L;
            this.f5914g = -1;
            this.f5920m = 0;
            this.f5915h = null;
            this.f5916i = null;
            d();
            this.f5923p = 0;
            this.f5924q = -1;
            RecyclerView.s(this);
        }

        void E() {
            if (this.f5911d == -1) {
                this.f5911d = this.f5910c;
            }
        }

        void F(int i3, int i4) {
            this.f5917j = (i3 & i4) | (this.f5917j & (i4 ^ (-1)));
        }

        public final void G(boolean z3) {
            int i3 = this.f5920m;
            int i4 = z3 ? i3 - 1 : i3 + 1;
            this.f5920m = i4;
            if (i4 < 0) {
                this.f5920m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z3 && i4 == 1) {
                this.f5917j |= 16;
            } else if (z3 && i4 == 0) {
                this.f5917j &= -17;
            }
        }

        void H(v vVar, boolean z3) {
            this.f5921n = vVar;
            this.f5922o = z3;
        }

        boolean I() {
            return (this.f5917j & 16) != 0;
        }

        boolean J() {
            return (this.f5917j & 128) != 0;
        }

        void K() {
            this.f5921n.J(this);
        }

        boolean L() {
            return (this.f5917j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f5917j) == 0) {
                g();
                this.f5918k.add(obj);
            }
        }

        void b(int i3) {
            this.f5917j = i3 | this.f5917j;
        }

        void c() {
            this.f5911d = -1;
            this.f5914g = -1;
        }

        void d() {
            List list = this.f5918k;
            if (list != null) {
                list.clear();
            }
            this.f5917j &= -1025;
        }

        void e() {
            this.f5917j &= -33;
        }

        void f() {
            this.f5917j &= -257;
        }

        boolean h() {
            return (this.f5917j & 16) == 0 && Z.R(this.f5908a);
        }

        void i(int i3, int i4, boolean z3) {
            b(8);
            A(i4, z3);
            this.f5910c = i3;
        }

        public final int j() {
            RecyclerView recyclerView = this.f5925r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c0(this);
        }

        public final long k() {
            return this.f5912e;
        }

        public final int l() {
            return this.f5913f;
        }

        public final int m() {
            int i3 = this.f5914g;
            return i3 == -1 ? this.f5910c : i3;
        }

        public final int n() {
            return this.f5911d;
        }

        List o() {
            if ((this.f5917j & 1024) != 0) {
                return f5907s;
            }
            List list = this.f5918k;
            return (list == null || list.size() == 0) ? f5907s : this.f5919l;
        }

        boolean p(int i3) {
            return (i3 & this.f5917j) != 0;
        }

        boolean q() {
            return (this.f5917j & 512) != 0 || t();
        }

        boolean r() {
            return (this.f5908a.getParent() == null || this.f5908a.getParent() == this.f5925r) ? false : true;
        }

        boolean s() {
            return (this.f5917j & 1) != 0;
        }

        boolean t() {
            return (this.f5917j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f5910c + " id=" + this.f5912e + ", oldPos=" + this.f5911d + ", pLpos:" + this.f5914g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f5922o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f5920m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f5908a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f5917j & 16) == 0 && !Z.R(this.f5908a);
        }

        boolean v() {
            return (this.f5917j & 8) != 0;
        }

        boolean w() {
            return this.f5921n != null;
        }

        boolean x() {
            return (this.f5917j & 256) != 0;
        }

        boolean y() {
            return (this.f5917j & 2) != 0;
        }

        boolean z() {
            return (this.f5917j & 2) != 0;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    class RunnableC0365a implements Runnable {
        RunnableC0365a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f5873t || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f5867q) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f5879w) {
                recyclerView2.f5877v = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$b, reason: case insensitive filesystem */
    class RunnableC0366b implements Runnable {
        RunnableC0366b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.f5823L;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f5860m0 = false;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$c, reason: case insensitive filesystem */
    static class InterpolatorC0367c implements Interpolator {
        InterpolatorC0367c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$d, reason: case insensitive filesystem */
    class C0368d implements androidx.recyclerview.widget.r.b {
        C0368d() {
        }

        @Override // androidx.recyclerview.widget.r.b
        public void a(D d3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f5859m.q1(d3.f5908a, recyclerView.f5837b);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void b(D d3, l.b bVar, l.b bVar2) {
            RecyclerView.this.m(d3, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void c(D d3, l.b bVar, l.b bVar2) {
            RecyclerView.this.f5837b.J(d3);
            RecyclerView.this.o(d3, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void d(D d3, l.b bVar, l.b bVar2) {
            d3.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f5814C) {
                if (recyclerView.f5823L.b(d3, d3, bVar, bVar2)) {
                    RecyclerView.this.N0();
                }
            } else if (recyclerView.f5823L.d(d3, bVar, bVar2)) {
                RecyclerView.this.N0();
            }
        }
    }

    class e implements b.InterfaceC0084b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public View a(int i3) {
            return RecyclerView.this.getChildAt(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void b(View view) {
            D dG0 = RecyclerView.g0(view);
            if (dG0 != null) {
                dG0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void c(int i3) {
            View childAt = RecyclerView.this.getChildAt(i3);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void d() {
            int iK = k();
            for (int i3 = 0; i3 < iK; i3++) {
                View viewA = a(i3);
                RecyclerView.this.A(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public D e(View view) {
            return RecyclerView.g0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void f(int i3) {
            D dG0;
            View viewA = a(i3);
            if (viewA != null && (dG0 = RecyclerView.g0(viewA)) != null) {
                if (dG0.x() && !dG0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + dG0 + RecyclerView.this.Q());
                }
                dG0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void g(View view) {
            D dG0 = RecyclerView.g0(view);
            if (dG0 != null) {
                dG0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void h(View view, int i3, ViewGroup.LayoutParams layoutParams) {
            D dG0 = RecyclerView.g0(view);
            if (dG0 != null) {
                if (!dG0.x() && !dG0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + dG0 + RecyclerView.this.Q());
                }
                dG0.f();
            }
            RecyclerView.this.attachViewToParent(view, i3, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public void i(View view, int i3) {
            RecyclerView.this.addView(view, i3);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0084b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    class f implements a.InterfaceC0083a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void a(int i3, int i4) {
            RecyclerView.this.D0(i3, i4);
            RecyclerView.this.f5854j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public D c(int i3) {
            D dA0 = RecyclerView.this.a0(i3, true);
            if (dA0 == null || RecyclerView.this.f5843e.n(dA0.f5908a)) {
                return null;
            }
            return dA0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void d(int i3, int i4) {
            RecyclerView.this.E0(i3, i4, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f5854j0 = true;
            recyclerView.f5848g0.f5886d += i4;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void e(int i3, int i4) {
            RecyclerView.this.E0(i3, i4, false);
            RecyclerView.this.f5854j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void f(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void g(int i3, int i4) {
            RecyclerView.this.C0(i3, i4);
            RecyclerView.this.f5854j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0083a
        public void h(int i3, int i4, Object obj) {
            RecyclerView.this.x1(i3, i4, obj);
            RecyclerView.this.f5856k0 = true;
        }

        void i(a.b bVar) {
            int i3 = bVar.f6067a;
            if (i3 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f5859m.V0(recyclerView, bVar.f6068b, bVar.f6070d);
                return;
            }
            if (i3 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f5859m.Y0(recyclerView2, bVar.f6068b, bVar.f6070d);
            } else if (i3 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f5859m.a1(recyclerView3, bVar.f6068b, bVar.f6070d, bVar.f6069c);
            } else {
                if (i3 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f5859m.X0(recyclerView4, bVar.f6068b, bVar.f6070d, 1);
            }
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f5931a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5932b = false;

        public final void c(D d3, int i3) {
            d3.f5910c = i3;
            if (i()) {
                d3.f5912e = f(i3);
            }
            d3.F(1, 519);
            androidx.core.os.t.a("RV OnBindView");
            m(d3, i3, d3.o());
            d3.d();
            ViewGroup.LayoutParams layoutParams = d3.f5908a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f5970c = true;
            }
            androidx.core.os.t.b();
        }

        public final D d(ViewGroup viewGroup, int i3) {
            try {
                androidx.core.os.t.a("RV CreateView");
                D dN = n(viewGroup, i3);
                if (dN.f5908a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                dN.f5913f = i3;
                androidx.core.os.t.b();
                return dN;
            } catch (Throwable th) {
                androidx.core.os.t.b();
                throw th;
            }
        }

        public abstract int e();

        public long f(int i3) {
            return -1L;
        }

        public int g(int i3) {
            return 0;
        }

        public final boolean h() {
            return this.f5931a.a();
        }

        public final boolean i() {
            return this.f5932b;
        }

        public final void j() {
            this.f5931a.b();
        }

        public void k(RecyclerView recyclerView) {
        }

        public abstract void l(D d3, int i3);

        public void m(D d3, int i3, List list) {
            l(d3, i3);
        }

        public abstract D n(ViewGroup viewGroup, int i3);

        public void o(RecyclerView recyclerView) {
        }

        public boolean p(D d3) {
            return false;
        }

        public void q(D d3) {
        }

        public void r(D d3) {
        }

        public void s(D d3) {
        }

        public void t(i iVar) {
            this.f5931a.registerObserver(iVar);
        }

        public void u(boolean z3) {
            if (h()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f5932b = z3;
        }

        public void v(i iVar) {
            this.f5931a.unregisterObserver(iVar);
        }
    }

    static class h extends Observable {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    public static abstract class i {
        public abstract void a();
    }

    public interface j {
    }

    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a f5933a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList f5934b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f5935c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f5936d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f5937e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f5938f = 250;

        interface a {
            void a(D d3);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f5939a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f5940b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f5941c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f5942d;

            public b a(D d3) {
                return b(d3, 0);
            }

            public b b(D d3, int i3) {
                View view = d3.f5908a;
                this.f5939a = view.getLeft();
                this.f5940b = view.getTop();
                this.f5941c = view.getRight();
                this.f5942d = view.getBottom();
                return this;
            }
        }

        static int e(D d3) {
            int i3 = d3.f5917j;
            int i4 = i3 & 14;
            if (d3.t()) {
                return 4;
            }
            if ((i3 & 4) != 0) {
                return i4;
            }
            int iN = d3.n();
            int iJ = d3.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i4 : i4 | 2048;
        }

        public abstract boolean a(D d3, b bVar, b bVar2);

        public abstract boolean b(D d3, D d4, b bVar, b bVar2);

        public abstract boolean c(D d3, b bVar, b bVar2);

        public abstract boolean d(D d3, b bVar, b bVar2);

        public abstract boolean f(D d3);

        public boolean g(D d3, List list) {
            return f(d3);
        }

        public final void h(D d3) {
            r(d3);
            a aVar = this.f5933a;
            if (aVar != null) {
                aVar.a(d3);
            }
        }

        public final void i() {
            if (this.f5934b.size() <= 0) {
                this.f5934b.clear();
            } else {
                H.a(this.f5934b.get(0));
                throw null;
            }
        }

        public abstract void j(D d3);

        public abstract void k();

        public long l() {
            return this.f5935c;
        }

        public long m() {
            return this.f5938f;
        }

        public long n() {
            return this.f5937e;
        }

        public long o() {
            return this.f5936d;
        }

        public abstract boolean p();

        public b q() {
            return new b();
        }

        public void r(D d3) {
        }

        public b s(A a3, D d3) {
            return q().a(d3);
        }

        public b t(A a3, D d3, int i3, List list) {
            return q().a(d3);
        }

        public abstract void u();

        void v(a aVar) {
            this.f5933a = aVar;
        }
    }

    private class m implements l.a {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(D d3) {
            d3.G(true);
            if (d3.f5915h != null && d3.f5916i == null) {
                d3.f5915h = null;
            }
            d3.f5916i = null;
            if (d3.I() || RecyclerView.this.W0(d3.f5908a) || !d3.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d3.f5908a, false);
        }
    }

    public static abstract class n {
        public void d(Rect rect, int i3, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, A a3) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, A a3) {
            f(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, A a3) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.b f5944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView f5945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.recyclerview.widget.q.b f5946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.recyclerview.widget.q.b f5947d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.q f5948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.q f5949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        z f5950g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f5951h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f5952i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f5953j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f5954k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f5955l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f5956m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f5957n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f5958o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f5959p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f5960q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f5961r;

        class a implements androidx.recyclerview.widget.q.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.q.b
            public View a(int i3) {
                return o.this.N(i3);
            }

            @Override // androidx.recyclerview.widget.q.b
            public int b() {
                return o.this.s0() - o.this.j0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int c() {
                return o.this.i0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int d(View view) {
                return o.this.Y(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.q.b
            public int e(View view) {
                return o.this.V(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        class b implements androidx.recyclerview.widget.q.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.q.b
            public View a(int i3) {
                return o.this.N(i3);
            }

            @Override // androidx.recyclerview.widget.q.b
            public int b() {
                return o.this.b0() - o.this.h0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int c() {
                return o.this.k0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int d(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.q.b
            public int e(View view) {
                return o.this.Z(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
            void a(int i3, int i4);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f5964a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f5965b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f5966c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f5967d;
        }

        public o() {
            a aVar = new a();
            this.f5946c = aVar;
            b bVar = new b();
            this.f5947d = bVar;
            this.f5948e = new androidx.recyclerview.widget.q(aVar);
            this.f5949f = new androidx.recyclerview.widget.q(bVar);
            this.f5951h = false;
            this.f5952i = false;
            this.f5953j = false;
            this.f5954k = true;
            this.f5955l = true;
        }

        private static boolean A0(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (i5 > 0 && i3 != i5) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i3;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i3;
            }
            return true;
        }

        private void D(int i3, View view) {
            this.f5944a.d(i3);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001b  */
        /* JADX WARN: Code duplicated, block: B:5:0x0010  */
        public static int P(int i3, int i4, int i5, int i6, boolean z3) {
            int iMax = Math.max(0, i3 - i5);
            if (z3) {
                if (i6 >= 0) {
                    i4 = 1073741824;
                } else if (i6 != -1 || (i4 != Integer.MIN_VALUE && (i4 == 0 || i4 != 1073741824))) {
                    i4 = 0;
                    i6 = 0;
                } else {
                    i6 = iMax;
                }
            } else if (i6 >= 0) {
                i4 = 1073741824;
            } else {
                if (i6 != -1) {
                    if (i6 == -2) {
                        i4 = (i4 == Integer.MIN_VALUE || i4 == 1073741824) ? Integer.MIN_VALUE : 0;
                    } else {
                        i4 = 0;
                        i6 = 0;
                    }
                }
                i6 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i6, i4);
        }

        private int[] Q(View view, Rect rect) {
            int iI0 = i0();
            int iK0 = k0();
            int iS0 = s0() - j0();
            int iB0 = b0() - h0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i3 = left - iI0;
            int iMin = Math.min(0, i3);
            int i4 = top - iK0;
            int iMin2 = Math.min(0, i4);
            int i5 = iWidth - iS0;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, iHeight - iB0);
            if (d0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i3, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i5);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i4, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        private void k(View view, int i3, boolean z3) {
            D dG0 = RecyclerView.g0(view);
            if (z3 || dG0.v()) {
                this.f5945b.f5845f.b(dG0);
            } else {
                this.f5945b.f5845f.p(dG0);
            }
            p pVar = (p) view.getLayoutParams();
            if (dG0.L() || dG0.w()) {
                if (dG0.w()) {
                    dG0.K();
                } else {
                    dG0.e();
                }
                this.f5944a.c(view, i3, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f5945b) {
                int iM = this.f5944a.m(view);
                if (i3 == -1) {
                    i3 = this.f5944a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f5945b.indexOfChild(view) + this.f5945b.Q());
                }
                if (iM != i3) {
                    this.f5945b.f5859m.F0(iM, i3);
                }
            } else {
                this.f5944a.a(view, i3, false);
                pVar.f5970c = true;
                z zVar = this.f5950g;
                if (zVar != null && zVar.h()) {
                    this.f5950g.k(view);
                }
            }
            if (pVar.f5971d) {
                dG0.f5908a.invalidate();
                pVar.f5971d = false;
            }
        }

        public static d m0(Context context, AttributeSet attributeSet, int i3, int i4) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.c.f2052f, i3, i4);
            dVar.f5964a = typedArrayObtainStyledAttributes.getInt(V.c.f2053g, 1);
            dVar.f5965b = typedArrayObtainStyledAttributes.getInt(V.c.f2063q, 1);
            dVar.f5966c = typedArrayObtainStyledAttributes.getBoolean(V.c.f2062p, false);
            dVar.f5967d = typedArrayObtainStyledAttributes.getBoolean(V.c.f2064r, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int s(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i4, i5) : size;
            }
            return Math.min(size, Math.max(i4, i5));
        }

        private boolean x0(RecyclerView recyclerView, int i3, int i4) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iI0 = i0();
            int iK0 = k0();
            int iS0 = s0() - j0();
            int iB0 = b0() - h0();
            Rect rect = this.f5945b.f5851i;
            U(focusedChild, rect);
            return rect.left - i3 < iS0 && rect.right - i3 > iI0 && rect.top - i4 < iB0 && rect.bottom - i4 > iK0;
        }

        private void z1(v vVar, int i3, View view) {
            D dG0 = RecyclerView.g0(view);
            if (dG0.J()) {
                return;
            }
            if (dG0.t() && !dG0.v() && !this.f5945b.f5857l.i()) {
                u1(i3);
                vVar.C(dG0);
            } else {
                C(i3);
                vVar.D(view);
                this.f5945b.f5845f.k(dG0);
            }
        }

        public abstract int A(A a3);

        public abstract int A1(int i3, v vVar, A a3);

        public void B(v vVar) {
            for (int iO = O() - 1; iO >= 0; iO--) {
                z1(vVar, iO, N(iO));
            }
        }

        public boolean B0() {
            z zVar = this.f5950g;
            return zVar != null && zVar.h();
        }

        public abstract void B1(int i3);

        public void C(int i3) {
            D(i3, N(i3));
        }

        public boolean C0(View view, boolean z3, boolean z4) {
            boolean z5 = this.f5948e.b(view, 24579) && this.f5949f.b(view, 24579);
            return z3 ? z5 : !z5;
        }

        public abstract int C1(int i3, v vVar, A a3);

        public void D0(View view, int i3, int i4, int i5, int i6) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f5969b;
            view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void D1(RecyclerView recyclerView) {
            E1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void E(RecyclerView recyclerView) {
            this.f5952i = true;
            K0(recyclerView);
        }

        public void E0(View view, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rectL0 = this.f5945b.l0(view);
            int i5 = i3 + rectL0.left + rectL0.right;
            int i6 = i4 + rectL0.top + rectL0.bottom;
            int iP = P(s0(), t0(), i0() + j0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).width, p());
            int iP2 = P(b0(), c0(), k0() + h0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i6, ((ViewGroup.MarginLayoutParams) pVar).height, q());
            if (J1(view, iP, iP2, pVar)) {
                view.measure(iP, iP2);
            }
        }

        void E1(int i3, int i4) {
            this.f5960q = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            this.f5958o = mode;
            if (mode == 0 && !RecyclerView.f5810y0) {
                this.f5960q = 0;
            }
            this.f5961r = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f5959p = mode2;
            if (mode2 != 0 || RecyclerView.f5810y0) {
                return;
            }
            this.f5961r = 0;
        }

        void F(RecyclerView recyclerView, v vVar) {
            this.f5952i = false;
            M0(recyclerView, vVar);
        }

        public void F0(int i3, int i4) {
            View viewN = N(i3);
            if (viewN != null) {
                C(i3);
                m(viewN, i4);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3 + this.f5945b.toString());
            }
        }

        public void F1(int i3, int i4) {
            this.f5945b.setMeasuredDimension(i3, i4);
        }

        public View G(View view) {
            View viewS;
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null || (viewS = recyclerView.S(view)) == null || this.f5944a.n(viewS)) {
                return null;
            }
            return viewS;
        }

        public void G0(int i3) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                recyclerView.A0(i3);
            }
        }

        public void G1(Rect rect, int i3, int i4) {
            F1(s(i3, rect.width() + i0() + j0(), g0()), s(i4, rect.height() + k0() + h0(), f0()));
        }

        public View H(int i3) {
            int iO = O();
            for (int i4 = 0; i4 < iO; i4++) {
                View viewN = N(i4);
                D dG0 = RecyclerView.g0(viewN);
                if (dG0 != null && dG0.m() == i3 && !dG0.J() && (this.f5945b.f5848g0.e() || !dG0.v())) {
                    return viewN;
                }
            }
            return null;
        }

        public void H0(int i3) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                recyclerView.B0(i3);
            }
        }

        void H1(int i3, int i4) {
            int iO = O();
            if (iO == 0) {
                this.f5945b.x(i3, i4);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            for (int i9 = 0; i9 < iO; i9++) {
                View viewN = N(i9);
                Rect rect = this.f5945b.f5851i;
                U(viewN, rect);
                int i10 = rect.left;
                if (i10 < i7) {
                    i7 = i10;
                }
                int i11 = rect.right;
                if (i11 > i5) {
                    i5 = i11;
                }
                int i12 = rect.top;
                if (i12 < i8) {
                    i8 = i12;
                }
                int i13 = rect.bottom;
                if (i13 > i6) {
                    i6 = i13;
                }
            }
            this.f5945b.f5851i.set(i7, i8, i5, i6);
            G1(this.f5945b.f5851i, i3, i4);
        }

        public abstract p I();

        public void I0(g gVar, g gVar2) {
        }

        void I1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f5945b = null;
                this.f5944a = null;
                this.f5960q = 0;
                this.f5961r = 0;
            } else {
                this.f5945b = recyclerView;
                this.f5944a = recyclerView.f5843e;
                this.f5960q = recyclerView.getWidth();
                this.f5961r = recyclerView.getHeight();
            }
            this.f5958o = 1073741824;
            this.f5959p = 1073741824;
        }

        public p J(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public boolean J0(RecyclerView recyclerView, ArrayList arrayList, int i3, int i4) {
            return false;
        }

        boolean J1(View view, int i3, int i4, p pVar) {
            return (!view.isLayoutRequested() && this.f5954k && A0(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) pVar).width) && A0(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p K(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void K0(RecyclerView recyclerView) {
        }

        boolean K1() {
            return false;
        }

        public int L() {
            return -1;
        }

        public void L0(RecyclerView recyclerView) {
        }

        boolean L1(View view, int i3, int i4, p pVar) {
            return (this.f5954k && A0(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) pVar).width) && A0(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int M(View view) {
            return ((p) view.getLayoutParams()).f5969b.bottom;
        }

        public void M0(RecyclerView recyclerView, v vVar) {
            L0(recyclerView);
        }

        public abstract void M1(RecyclerView recyclerView, A a3, int i3);

        public View N(int i3) {
            androidx.recyclerview.widget.b bVar = this.f5944a;
            if (bVar != null) {
                return bVar.f(i3);
            }
            return null;
        }

        public abstract View N0(View view, int i3, v vVar, A a3);

        public void N1(z zVar) {
            z zVar2 = this.f5950g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.f5950g.r();
            }
            this.f5950g = zVar;
            zVar.q(this.f5945b, this);
        }

        public int O() {
            androidx.recyclerview.widget.b bVar = this.f5944a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public void O0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f5945b;
            P0(recyclerView.f5837b, recyclerView.f5848g0, accessibilityEvent);
        }

        void O1() {
            z zVar = this.f5950g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public void P0(v vVar, A a3, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z3 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f5945b.canScrollVertically(-1) && !this.f5945b.canScrollHorizontally(-1) && !this.f5945b.canScrollHorizontally(1)) {
                z3 = false;
            }
            accessibilityEvent.setScrollable(z3);
            g gVar = this.f5945b.f5857l;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.e());
            }
        }

        public boolean P1() {
            return false;
        }

        void Q0(T t3) {
            RecyclerView recyclerView = this.f5945b;
            R0(recyclerView.f5837b, recyclerView.f5848g0, t3);
        }

        public boolean R() {
            RecyclerView recyclerView = this.f5945b;
            return recyclerView != null && recyclerView.f5847g;
        }

        public void R0(v vVar, A a3, T t3) {
            if (this.f5945b.canScrollVertically(-1) || this.f5945b.canScrollHorizontally(-1)) {
                t3.a(8192);
                t3.F0(true);
            }
            if (this.f5945b.canScrollVertically(1) || this.f5945b.canScrollHorizontally(1)) {
                t3.a(4096);
                t3.F0(true);
            }
            t3.o0(T.e.b(o0(vVar, a3), S(vVar, a3), z0(vVar, a3), p0(vVar, a3)));
        }

        public int S(v vVar, A a3) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null || recyclerView.f5857l == null || !p()) {
                return 1;
            }
            return this.f5945b.f5857l.e();
        }

        void S0(View view, T t3) {
            D dG0 = RecyclerView.g0(view);
            if (dG0 == null || dG0.v() || this.f5944a.n(dG0.f5908a)) {
                return;
            }
            RecyclerView recyclerView = this.f5945b;
            T0(recyclerView.f5837b, recyclerView.f5848g0, view, t3);
        }

        public int T(View view) {
            return view.getBottom() + M(view);
        }

        public void T0(v vVar, A a3, View view, T t3) {
            t3.p0(T.f.a(q() ? l0(view) : 0, 1, p() ? l0(view) : 0, 1, false, false));
        }

        public void U(View view, Rect rect) {
            RecyclerView.i0(view, rect);
        }

        public View U0(View view, int i3) {
            return null;
        }

        public int V(View view) {
            return view.getLeft() - e0(view);
        }

        public void V0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int W(View view) {
            Rect rect = ((p) view.getLayoutParams()).f5969b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void W0(RecyclerView recyclerView) {
        }

        public int X(View view) {
            Rect rect = ((p) view.getLayoutParams()).f5969b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void X0(RecyclerView recyclerView, int i3, int i4, int i5) {
        }

        public int Y(View view) {
            return view.getRight() + n0(view);
        }

        public void Y0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int Z(View view) {
            return view.getTop() - q0(view);
        }

        public void Z0(RecyclerView recyclerView, int i3, int i4) {
        }

        public View a0() {
            View focusedChild;
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f5944a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void a1(RecyclerView recyclerView, int i3, int i4, Object obj) {
            Z0(recyclerView, i3, i4);
        }

        public int b() {
            RecyclerView recyclerView = this.f5945b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.e();
            }
            return 0;
        }

        public int b0() {
            return this.f5961r;
        }

        public abstract void b1(v vVar, A a3);

        public int c0() {
            return this.f5959p;
        }

        public void c1(A a3) {
        }

        public int d0() {
            return Z.C(this.f5945b);
        }

        public void d1(v vVar, A a3, int i3, int i4) {
            this.f5945b.x(i3, i4);
        }

        public int e0(View view) {
            return ((p) view.getLayoutParams()).f5969b.left;
        }

        public boolean e1(RecyclerView recyclerView, View view, View view2) {
            return B0() || recyclerView.v0();
        }

        public int f0() {
            return Z.D(this.f5945b);
        }

        public boolean f1(RecyclerView recyclerView, A a3, View view, View view2) {
            return e1(recyclerView, view, view2);
        }

        public void g(View view) {
            h(view, -1);
        }

        public int g0() {
            return Z.E(this.f5945b);
        }

        public void g1(Parcelable parcelable) {
        }

        public void h(View view, int i3) {
            k(view, i3, true);
        }

        public int h0() {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable h1() {
            return null;
        }

        public void i(View view) {
            j(view, -1);
        }

        public int i0() {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void i1(int i3) {
        }

        public void j(View view, int i3) {
            k(view, i3, false);
        }

        public int j0() {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void j1(z zVar) {
            if (this.f5950g == zVar) {
                this.f5950g = null;
            }
        }

        public int k0() {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        boolean k1(int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f5945b;
            return l1(recyclerView.f5837b, recyclerView.f5848g0, i3, bundle);
        }

        public void l(String str) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int l0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0044 A[PHI: r8
          0x0044: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:24:0x0063, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean l1(v vVar, A a3, int i3, Bundle bundle) {
            int iB0;
            int iS0;
            int i4;
            int i5;
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null) {
                return false;
            }
            if (i3 == 4096) {
                iB0 = recyclerView.canScrollVertically(1) ? (b0() - k0()) - h0() : 0;
                if (this.f5945b.canScrollHorizontally(1)) {
                    iS0 = (s0() - i0()) - j0();
                    i4 = iB0;
                    i5 = iS0;
                } else {
                    i4 = iB0;
                    i5 = 0;
                }
            } else if (i3 != 8192) {
                i5 = 0;
                i4 = 0;
            } else {
                iB0 = recyclerView.canScrollVertically(-1) ? -((b0() - k0()) - h0()) : 0;
                if (this.f5945b.canScrollHorizontally(-1)) {
                    iS0 = -((s0() - i0()) - j0());
                    i4 = iB0;
                    i5 = iS0;
                } else {
                    i4 = iB0;
                    i5 = 0;
                }
            }
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            this.f5945b.p1(i5, i4, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void m(View view, int i3) {
            n(view, i3, (p) view.getLayoutParams());
        }

        boolean m1(View view, int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f5945b;
            return n1(recyclerView.f5837b, recyclerView.f5848g0, view, i3, bundle);
        }

        public void n(View view, int i3, p pVar) {
            D dG0 = RecyclerView.g0(view);
            if (dG0.v()) {
                this.f5945b.f5845f.b(dG0);
            } else {
                this.f5945b.f5845f.p(dG0);
            }
            this.f5944a.c(view, i3, pVar, dG0.v());
        }

        public int n0(View view) {
            return ((p) view.getLayoutParams()).f5969b.right;
        }

        public boolean n1(v vVar, A a3, View view, int i3, Bundle bundle) {
            return false;
        }

        public void o(View view, Rect rect) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.l0(view));
            }
        }

        public int o0(v vVar, A a3) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView == null || recyclerView.f5857l == null || !q()) {
                return 1;
            }
            return this.f5945b.f5857l.e();
        }

        public void o1(v vVar) {
            for (int iO = O() - 1; iO >= 0; iO--) {
                if (!RecyclerView.g0(N(iO)).J()) {
                    r1(iO, vVar);
                }
            }
        }

        public abstract boolean p();

        public int p0(v vVar, A a3) {
            return 0;
        }

        void p1(v vVar) {
            int iJ = vVar.j();
            for (int i3 = iJ - 1; i3 >= 0; i3--) {
                View viewN = vVar.n(i3);
                D dG0 = RecyclerView.g0(viewN);
                if (!dG0.J()) {
                    dG0.G(false);
                    if (dG0.x()) {
                        this.f5945b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f5945b.f5823L;
                    if (lVar != null) {
                        lVar.j(dG0);
                    }
                    dG0.G(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f5945b.invalidate();
            }
        }

        public abstract boolean q();

        public int q0(View view) {
            return ((p) view.getLayoutParams()).f5969b.top;
        }

        public void q1(View view, v vVar) {
            t1(view);
            vVar.B(view);
        }

        public boolean r(p pVar) {
            return pVar != null;
        }

        public void r0(View view, boolean z3, Rect rect) {
            Matrix matrix;
            if (z3) {
                Rect rect2 = ((p) view.getLayoutParams()).f5969b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f5945b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f5945b.f5855k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void r1(int i3, v vVar) {
            View viewN = N(i3);
            u1(i3);
            vVar.B(viewN);
        }

        public int s0() {
            return this.f5960q;
        }

        public boolean s1(Runnable runnable) {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void t(int i3, int i4, A a3, c cVar) {
        }

        public int t0() {
            return this.f5958o;
        }

        public void t1(View view) {
            this.f5944a.p(view);
        }

        public void u(int i3, c cVar) {
        }

        boolean u0() {
            int iO = O();
            for (int i3 = 0; i3 < iO; i3++) {
                ViewGroup.LayoutParams layoutParams = N(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void u1(int i3) {
            if (N(i3) != null) {
                this.f5944a.q(i3);
            }
        }

        public abstract int v(A a3);

        public boolean v0() {
            return this.f5952i;
        }

        public boolean v1(RecyclerView recyclerView, View view, Rect rect, boolean z3) {
            return w1(recyclerView, view, rect, z3, false);
        }

        public abstract int w(A a3);

        public abstract boolean w0();

        public boolean w1(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
            int[] iArrQ = Q(view, rect);
            int i3 = iArrQ[0];
            int i4 = iArrQ[1];
            if ((z4 && !x0(recyclerView, i3, i4)) || (i3 == 0 && i4 == 0)) {
                return false;
            }
            if (z3) {
                recyclerView.scrollBy(i3, i4);
            } else {
                recyclerView.m1(i3, i4);
            }
            return true;
        }

        public abstract int x(A a3);

        public void x1() {
            RecyclerView recyclerView = this.f5945b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int y(A a3);

        public final boolean y0() {
            return this.f5955l;
        }

        public void y1() {
            this.f5951h = true;
        }

        public abstract int z(A a3);

        public boolean z0(v vVar, A a3) {
            return false;
        }
    }

    public interface q {
        void a(View view);

        void b(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i3, int i4);
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z3);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i3) {
        }

        public abstract void b(RecyclerView recyclerView, int i3, int i4);
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray f5972a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5973b = 0;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList f5974a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f5975b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f5976c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f5977d = 0;

            a() {
            }
        }

        private a g(int i3) {
            a aVar = (a) this.f5972a.get(i3);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f5972a.put(i3, aVar2);
            return aVar2;
        }

        void a() {
            this.f5973b++;
        }

        public void b() {
            for (int i3 = 0; i3 < this.f5972a.size(); i3++) {
                ((a) this.f5972a.valueAt(i3)).f5974a.clear();
            }
        }

        void c() {
            this.f5973b--;
        }

        void d(int i3, long j3) {
            a aVarG = g(i3);
            aVarG.f5977d = j(aVarG.f5977d, j3);
        }

        void e(int i3, long j3) {
            a aVarG = g(i3);
            aVarG.f5976c = j(aVarG.f5976c, j3);
        }

        public D f(int i3) {
            a aVar = (a) this.f5972a.get(i3);
            if (aVar == null || aVar.f5974a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f5974a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((D) arrayList.get(size)).r()) {
                    return (D) arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z3) {
            if (gVar != null) {
                c();
            }
            if (!z3 && this.f5973b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(D d3) {
            int iL = d3.l();
            ArrayList arrayList = g(iL).f5974a;
            if (((a) this.f5972a.get(iL)).f5975b <= arrayList.size()) {
                return;
            }
            d3.D();
            arrayList.add(d3);
        }

        long j(long j3, long j4) {
            return j3 == 0 ? j4 : ((j3 / 4) * 3) + (j4 / 4);
        }

        boolean k(int i3, long j3, long j4) {
            long j5 = g(i3).f5977d;
            return j5 == 0 || j3 + j5 < j4;
        }

        boolean l(int i3, long j3, long j4) {
            long j5 = g(i3).f5976c;
            return j5 == 0 || j3 + j5 < j4;
        }
    }

    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList f5978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList f5979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList f5980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f5981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        u f5984g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.f5978a = arrayList;
            this.f5979b = null;
            this.f5980c = new ArrayList();
            this.f5981d = Collections.unmodifiableList(arrayList);
            this.f5982e = 2;
            this.f5983f = 2;
        }

        private boolean H(D d3, int i3, int i4, long j3) {
            d3.f5925r = RecyclerView.this;
            int iL = d3.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j3 != Long.MAX_VALUE && !this.f5984g.k(iL, nanoTime, j3)) {
                return false;
            }
            RecyclerView.this.f5857l.c(d3, i3);
            this.f5984g.d(d3.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d3);
            if (!RecyclerView.this.f5848g0.e()) {
                return true;
            }
            d3.f5914g = i4;
            return true;
        }

        private void b(D d3) {
            if (RecyclerView.this.u0()) {
                View view = d3.f5908a;
                if (Z.A(view) == 0) {
                    Z.z0(view, 1);
                }
                androidx.recyclerview.widget.m mVar = RecyclerView.this.f5862n0;
                if (mVar == null) {
                    return;
                }
                C0282a c0282aN = mVar.n();
                if (c0282aN instanceof androidx.recyclerview.widget.m.a) {
                    ((androidx.recyclerview.widget.m.a) c0282aN).o(view);
                }
                Z.q0(view, c0282aN);
            }
        }

        private void q(ViewGroup viewGroup, boolean z3) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z3) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(D d3) {
            View view = d3.f5908a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i3) {
            a((D) this.f5980c.get(i3), true);
            this.f5980c.remove(i3);
        }

        public void B(View view) {
            D dG0 = RecyclerView.g0(view);
            if (dG0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (dG0.w()) {
                dG0.K();
            } else if (dG0.L()) {
                dG0.e();
            }
            C(dG0);
            if (RecyclerView.this.f5823L == null || dG0.u()) {
                return;
            }
            RecyclerView.this.f5823L.j(dG0);
        }

        void C(D d3) {
            boolean z3;
            boolean z4 = false;
            boolean z5 = true;
            if (d3.w() || d3.f5908a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d3.w());
                sb.append(" isAttached:");
                sb.append(d3.f5908a.getParent() != null);
                sb.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d3.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d3 + RecyclerView.this.Q());
            }
            if (d3.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
            boolean zH = d3.h();
            g gVar = RecyclerView.this.f5857l;
            if ((gVar != null && zH && gVar.p(d3)) || d3.u()) {
                if (this.f5983f <= 0 || d3.p(526)) {
                    z3 = false;
                } else {
                    int size = this.f5980c.size();
                    if (size >= this.f5983f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.f5803A0 && size > 0 && !RecyclerView.this.f5846f0.d(d3.f5910c)) {
                        int i3 = size - 1;
                        while (i3 >= 0) {
                            if (!RecyclerView.this.f5846f0.d(((D) this.f5980c.get(i3)).f5910c)) {
                                break;
                            } else {
                                i3--;
                            }
                        }
                        size = i3 + 1;
                    }
                    this.f5980c.add(size, d3);
                    z3 = true;
                }
                if (z3) {
                    z4 = z3;
                    z5 = false;
                } else {
                    a(d3, true);
                    z4 = z3;
                }
            } else {
                z5 = false;
            }
            RecyclerView.this.f5845f.q(d3);
            if (z4 || z5 || !zH) {
                return;
            }
            d3.f5925r = null;
        }

        void D(View view) {
            D dG0 = RecyclerView.g0(view);
            if (!dG0.p(12) && dG0.y() && !RecyclerView.this.q(dG0)) {
                if (this.f5979b == null) {
                    this.f5979b = new ArrayList();
                }
                dG0.H(this, true);
                this.f5979b.add(dG0);
                return;
            }
            if (!dG0.t() || dG0.v() || RecyclerView.this.f5857l.i()) {
                dG0.H(this, false);
                this.f5978a.add(dG0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
            }
        }

        void E(u uVar) {
            u uVar2 = this.f5984g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f5984g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f5984g.a();
        }

        void F(B b3) {
        }

        public void G(int i3) {
            this.f5982e = i3;
            K();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:58:0x00f5 A[PHI: r1 r4
          0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$D) = (r1v11 androidx.recyclerview.widget.RecyclerView$D), (r1v30 androidx.recyclerview.widget.RecyclerView$D) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:68:0x014e  */
        /* JADX WARN: Code duplicated, block: B:74:0x017a  */
        /* JADX WARN: Code duplicated, block: B:76:0x0180  */
        /* JADX WARN: Code duplicated, block: B:85:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:86:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:88:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:89:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:92:0x01d4 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:94:0x01d7  */
        D I(int i3, boolean z3, long j3) {
            D dL;
            boolean z4;
            D d3;
            boolean z5;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            int iM;
            RecyclerView recyclerViewW;
            if (i3 < 0 || i3 >= RecyclerView.this.f5848g0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i3 + "(" + i3 + "). Item count:" + RecyclerView.this.f5848g0.b() + RecyclerView.this.Q());
            }
            if (RecyclerView.this.f5848g0.e()) {
                dL = h(i3);
                z4 = dL != null;
                if (dL == null && (dL = m(i3, z3)) != null) {
                    if (L(dL)) {
                        z4 = true;
                    } else {
                        if (!z3) {
                            dL.b(4);
                            if (dL.w()) {
                                RecyclerView.this.removeDetachedView(dL.f5908a, false);
                                dL.K();
                            } else if (dL.L()) {
                                dL.e();
                            }
                            C(dL);
                        }
                        dL = null;
                    }
                }
                if (dL == null) {
                    d3 = dL;
                } else {
                    iM = RecyclerView.this.f5841d.m(i3);
                    if (iM >= 0 || iM >= RecyclerView.this.f5857l.e()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + iM + ").state:" + RecyclerView.this.f5848g0.b() + RecyclerView.this.Q());
                    }
                    int iG = RecyclerView.this.f5857l.g(iM);
                    if (RecyclerView.this.f5857l.i() && (dL = l(RecyclerView.this.f5857l.f(iM), iG, z3)) != null) {
                        dL.f5910c = iM;
                        z4 = true;
                    }
                    if (dL == null) {
                        D dF = i().f(iG);
                        if (dF != null) {
                            dF.D();
                            if (RecyclerView.f5809x0) {
                                r(dF);
                            }
                        }
                        dL = dF;
                    }
                    if (dL == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j3 != Long.MAX_VALUE && !this.f5984g.l(iG, nanoTime, j3)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        D d4 = recyclerView.f5857l.d(recyclerView, iG);
                        if (RecyclerView.f5803A0 && (recyclerViewW = RecyclerView.W(d4.f5908a)) != null) {
                            d4.f5909b = new WeakReference(recyclerViewW);
                        }
                        this.f5984g.e(iG, RecyclerView.this.getNanoTime() - nanoTime);
                        d3 = d4;
                    } else {
                        d3 = dL;
                    }
                }
                z5 = z4;
                if (z5 && !RecyclerView.this.f5848g0.e() && d3.p(8192)) {
                    d3.F(0, 8192);
                    if (RecyclerView.this.f5848g0.f5893k) {
                        int iE = l.e(d3) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.S0(d3, recyclerView2.f5823L.t(recyclerView2.f5848g0, d3, iE, d3.o()));
                    }
                }
                if (RecyclerView.this.f5848g0.e() || !d3.s()) {
                    boolean zH = (d3.s() || d3.z() || d3.t()) ? H(d3, RecyclerView.this.f5841d.m(i3), i3, j3) : false;
                    layoutParams = d3.f5908a.getLayoutParams();
                    if (layoutParams == null) {
                        pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                        d3.f5908a.setLayoutParams(pVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        pVar = (p) layoutParams;
                    } else {
                        pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                        d3.f5908a.setLayoutParams(pVar);
                    }
                    pVar.f5968a = d3;
                    pVar.f5971d = !z5 && zH;
                    return d3;
                }
                d3.f5914g = i3;
                layoutParams = d3.f5908a.getLayoutParams();
                if (layoutParams == null) {
                    pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                    d3.f5908a.setLayoutParams(pVar);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                    d3.f5908a.setLayoutParams(pVar);
                } else {
                    pVar = (p) layoutParams;
                }
                pVar.f5968a = d3;
                pVar.f5971d = !z5 && zH;
                return d3;
            }
            dL = null;
            if (dL == null) {
                if (L(dL)) {
                    if (!z3) {
                        dL.b(4);
                        if (dL.w()) {
                            RecyclerView.this.removeDetachedView(dL.f5908a, false);
                            dL.K();
                        } else if (dL.L()) {
                            dL.e();
                        }
                        C(dL);
                    }
                    dL = null;
                } else {
                    z4 = true;
                }
            }
            if (dL == null) {
                iM = RecyclerView.this.f5841d.m(i3);
                if (iM >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + iM + ").state:" + RecyclerView.this.f5848g0.b() + RecyclerView.this.Q());
            }
            d3 = dL;
            z5 = z4;
            if (z5) {
                d3.F(0, 8192);
                if (RecyclerView.this.f5848g0.f5893k) {
                    int iE2 = l.e(d3) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.S0(d3, recyclerView3.f5823L.t(recyclerView3.f5848g0, d3, iE2, d3.o()));
                }
            }
            if (RecyclerView.this.f5848g0.e()) {
                if (d3.s()) {
                }
            } else {
                if (d3.s()) {
                }
            }
            layoutParams = d3.f5908a.getLayoutParams();
            if (layoutParams == null) {
                pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                d3.f5908a.setLayoutParams(pVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                d3.f5908a.setLayoutParams(pVar);
            } else {
                pVar = (p) layoutParams;
            }
            pVar.f5968a = d3;
            pVar.f5971d = !z5 && zH;
            return d3;
        }

        void J(D d3) {
            if (d3.f5922o) {
                this.f5979b.remove(d3);
            } else {
                this.f5978a.remove(d3);
            }
            d3.f5921n = null;
            d3.f5922o = false;
            d3.e();
        }

        void K() {
            o oVar = RecyclerView.this.f5859m;
            this.f5983f = this.f5982e + (oVar != null ? oVar.f5956m : 0);
            for (int size = this.f5980c.size() - 1; size >= 0 && this.f5980c.size() > this.f5983f; size--) {
                A(size);
            }
        }

        boolean L(D d3) {
            if (d3.v()) {
                return RecyclerView.this.f5848g0.e();
            }
            int i3 = d3.f5910c;
            if (i3 >= 0 && i3 < RecyclerView.this.f5857l.e()) {
                if (RecyclerView.this.f5848g0.e() || RecyclerView.this.f5857l.g(d3.f5910c) == d3.l()) {
                    return !RecyclerView.this.f5857l.i() || d3.k() == RecyclerView.this.f5857l.f(d3.f5910c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d3 + RecyclerView.this.Q());
        }

        void M(int i3, int i4) {
            int i5;
            int i6 = i4 + i3;
            for (int size = this.f5980c.size() - 1; size >= 0; size--) {
                D d3 = (D) this.f5980c.get(size);
                if (d3 != null && (i5 = d3.f5910c) >= i3 && i5 < i6) {
                    d3.b(2);
                    A(size);
                }
            }
        }

        void a(D d3, boolean z3) {
            RecyclerView.s(d3);
            View view = d3.f5908a;
            androidx.recyclerview.widget.m mVar = RecyclerView.this.f5862n0;
            if (mVar != null) {
                C0282a c0282aN = mVar.n();
                Z.q0(view, c0282aN instanceof androidx.recyclerview.widget.m.a ? ((androidx.recyclerview.widget.m.a) c0282aN).n(view) : null);
            }
            if (z3) {
                g(d3);
            }
            d3.f5925r = null;
            i().i(d3);
        }

        public void c() {
            this.f5978a.clear();
            z();
        }

        void d() {
            int size = this.f5980c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((D) this.f5980c.get(i3)).c();
            }
            int size2 = this.f5978a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((D) this.f5978a.get(i4)).c();
            }
            ArrayList arrayList = this.f5979b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    ((D) this.f5979b.get(i5)).c();
                }
            }
        }

        void e() {
            this.f5978a.clear();
            ArrayList arrayList = this.f5979b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i3) {
            if (i3 >= 0 && i3 < RecyclerView.this.f5848g0.b()) {
                return !RecyclerView.this.f5848g0.e() ? i3 : RecyclerView.this.f5841d.m(i3);
            }
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.f5848g0.b() + RecyclerView.this.Q());
        }

        void g(D d3) {
            RecyclerView.this.getClass();
            g gVar = RecyclerView.this.f5857l;
            if (gVar != null) {
                gVar.s(d3);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f5848g0 != null) {
                recyclerView.f5845f.q(d3);
            }
        }

        D h(int i3) {
            int size;
            int iM;
            ArrayList arrayList = this.f5979b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    D d3 = (D) this.f5979b.get(i4);
                    if (!d3.L() && d3.m() == i3) {
                        d3.b(32);
                        return d3;
                    }
                }
                if (RecyclerView.this.f5857l.i() && (iM = RecyclerView.this.f5841d.m(i3)) > 0 && iM < RecyclerView.this.f5857l.e()) {
                    long jF = RecyclerView.this.f5857l.f(iM);
                    for (int i5 = 0; i5 < size; i5++) {
                        D d4 = (D) this.f5979b.get(i5);
                        if (!d4.L() && d4.k() == jF) {
                            d4.b(32);
                            return d4;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f5984g == null) {
                this.f5984g = new u();
            }
            return this.f5984g;
        }

        int j() {
            return this.f5978a.size();
        }

        public List k() {
            return this.f5981d;
        }

        D l(long j3, int i3, boolean z3) {
            for (int size = this.f5978a.size() - 1; size >= 0; size--) {
                D d3 = (D) this.f5978a.get(size);
                if (d3.k() == j3 && !d3.L()) {
                    if (i3 == d3.l()) {
                        d3.b(32);
                        if (d3.v() && !RecyclerView.this.f5848g0.e()) {
                            d3.F(2, 14);
                        }
                        return d3;
                    }
                    if (!z3) {
                        this.f5978a.remove(size);
                        RecyclerView.this.removeDetachedView(d3.f5908a, false);
                        y(d3.f5908a);
                    }
                }
            }
            int size2 = this.f5980c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                D d4 = (D) this.f5980c.get(size2);
                if (d4.k() == j3 && !d4.r()) {
                    if (i3 == d4.l()) {
                        if (!z3) {
                            this.f5980c.remove(size2);
                        }
                        return d4;
                    }
                    if (!z3) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        D m(int i3, boolean z3) {
            View viewE;
            int size = this.f5978a.size();
            for (int i4 = 0; i4 < size; i4++) {
                D d3 = (D) this.f5978a.get(i4);
                if (!d3.L() && d3.m() == i3 && !d3.t() && (RecyclerView.this.f5848g0.f5890h || !d3.v())) {
                    d3.b(32);
                    return d3;
                }
            }
            if (z3 || (viewE = RecyclerView.this.f5843e.e(i3)) == null) {
                int size2 = this.f5980c.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    D d4 = (D) this.f5980c.get(i5);
                    if (!d4.t() && d4.m() == i3 && !d4.r()) {
                        if (!z3) {
                            this.f5980c.remove(i5);
                        }
                        return d4;
                    }
                }
                return null;
            }
            D dG0 = RecyclerView.g0(viewE);
            RecyclerView.this.f5843e.s(viewE);
            int iM = RecyclerView.this.f5843e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f5843e.d(iM);
                D(viewE);
                dG0.b(8224);
                return dG0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + dG0 + RecyclerView.this.Q());
        }

        View n(int i3) {
            return ((D) this.f5978a.get(i3)).f5908a;
        }

        public View o(int i3) {
            return p(i3, false);
        }

        View p(int i3, boolean z3) {
            return I(i3, z3, Long.MAX_VALUE).f5908a;
        }

        void s() {
            int size = this.f5980c.size();
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = (p) ((D) this.f5980c.get(i3)).f5908a.getLayoutParams();
                if (pVar != null) {
                    pVar.f5970c = true;
                }
            }
        }

        void t() {
            int size = this.f5980c.size();
            for (int i3 = 0; i3 < size; i3++) {
                D d3 = (D) this.f5980c.get(i3);
                if (d3 != null) {
                    d3.b(6);
                    d3.a(null);
                }
            }
            g gVar = RecyclerView.this.f5857l;
            if (gVar == null || !gVar.i()) {
                z();
            }
        }

        void u(int i3, int i4) {
            int size = this.f5980c.size();
            for (int i5 = 0; i5 < size; i5++) {
                D d3 = (D) this.f5980c.get(i5);
                if (d3 != null && d3.f5910c >= i3) {
                    d3.A(i4, true);
                }
            }
        }

        void v(int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            if (i3 < i4) {
                i5 = -1;
                i7 = i3;
                i6 = i4;
            } else {
                i5 = 1;
                i6 = i3;
                i7 = i4;
            }
            int size = this.f5980c.size();
            for (int i9 = 0; i9 < size; i9++) {
                D d3 = (D) this.f5980c.get(i9);
                if (d3 != null && (i8 = d3.f5910c) >= i7 && i8 <= i6) {
                    if (i8 == i3) {
                        d3.A(i4 - i3, false);
                    } else {
                        d3.A(i5, false);
                    }
                }
            }
        }

        void w(int i3, int i4, boolean z3) {
            int i5 = i3 + i4;
            for (int size = this.f5980c.size() - 1; size >= 0; size--) {
                D d3 = (D) this.f5980c.get(size);
                if (d3 != null) {
                    int i6 = d3.f5910c;
                    if (i6 >= i5) {
                        d3.A(-i4, z3);
                    } else if (i6 >= i3) {
                        d3.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z3) {
            c();
            i().h(gVar, gVar2, z3);
        }

        void y(View view) {
            D dG0 = RecyclerView.g0(view);
            dG0.f5921n = null;
            dG0.f5922o = false;
            dG0.e();
            C(dG0);
        }

        void z() {
            for (int size = this.f5980c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f5980c.clear();
            if (RecyclerView.f5803A0) {
                RecyclerView.this.f5846f0.b();
            }
        }
    }

    public interface w {
    }

    private class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f5848g0.f5889g = true;
            recyclerView.Q0(true);
            if (RecyclerView.this.f5841d.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    public static abstract class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f5989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o f5990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5992e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f5993f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f5995h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5988a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f5994g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f5996a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f5997b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f5998c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f5999d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f6000e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f6001f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f6002g;

            public a(int i3, int i4) {
                this(i3, i4, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f6000e != null && this.f5998c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f5998c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f5999d >= 0;
            }

            public void b(int i3) {
                this.f5999d = i3;
            }

            void c(RecyclerView recyclerView) {
                int i3 = this.f5999d;
                if (i3 >= 0) {
                    this.f5999d = -1;
                    recyclerView.x0(i3);
                    this.f6001f = false;
                } else {
                    if (!this.f6001f) {
                        this.f6002g = 0;
                        return;
                    }
                    e();
                    recyclerView.f5842d0.f(this.f5996a, this.f5997b, this.f5998c, this.f6000e);
                    int i4 = this.f6002g + 1;
                    this.f6002g = i4;
                    if (i4 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f6001f = false;
                }
            }

            public void d(int i3, int i4, int i5, Interpolator interpolator) {
                this.f5996a = i3;
                this.f5997b = i4;
                this.f5998c = i5;
                this.f6000e = interpolator;
                this.f6001f = true;
            }

            public a(int i3, int i4, int i5, Interpolator interpolator) {
                this.f5999d = -1;
                this.f6001f = false;
                this.f6002g = 0;
                this.f5996a = i3;
                this.f5997b = i4;
                this.f5998c = i5;
                this.f6000e = interpolator;
            }
        }

        public interface b {
            PointF e(int i3);
        }

        public PointF a(int i3) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).e(i3);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i3) {
            return this.f5989b.f5859m.H(i3);
        }

        public int c() {
            return this.f5989b.f5859m.O();
        }

        public int d(View view) {
            return this.f5989b.e0(view);
        }

        public o e() {
            return this.f5990c;
        }

        public int f() {
            return this.f5988a;
        }

        public boolean g() {
            return this.f5991d;
        }

        public boolean h() {
            return this.f5992e;
        }

        protected void i(PointF pointF) {
            float f3 = pointF.x;
            float f4 = pointF.y;
            float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void j(int i3, int i4) {
            PointF pointFA;
            RecyclerView recyclerView = this.f5989b;
            if (this.f5988a == -1 || recyclerView == null) {
                r();
            }
            if (this.f5991d && this.f5993f == null && this.f5990c != null && (pointFA = a(this.f5988a)) != null) {
                float f3 = pointFA.x;
                if (f3 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.h1((int) Math.signum(f3), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f5991d = false;
            View view = this.f5993f;
            if (view != null) {
                if (d(view) == this.f5988a) {
                    o(this.f5993f, recyclerView.f5848g0, this.f5994g);
                    this.f5994g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f5993f = null;
                }
            }
            if (this.f5992e) {
                l(i3, i4, recyclerView.f5848g0, this.f5994g);
                boolean zA = this.f5994g.a();
                this.f5994g.c(recyclerView);
                if (zA && this.f5992e) {
                    this.f5991d = true;
                    recyclerView.f5842d0.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f5993f = view;
            }
        }

        protected abstract void l(int i3, int i4, A a3, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, A a3, a aVar);

        public void p(int i3) {
            this.f5988a = i3;
        }

        void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f5842d0.g();
            if (this.f5995h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f5989b = recyclerView;
            this.f5990c = oVar;
            int i3 = this.f5988a;
            if (i3 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f5848g0.f5883a = i3;
            this.f5992e = true;
            this.f5991d = true;
            this.f5993f = b(f());
            m();
            this.f5989b.f5842d0.e();
            this.f5995h = true;
        }

        protected final void r() {
            if (this.f5992e) {
                this.f5992e = false;
                n();
                this.f5989b.f5848g0.f5883a = -1;
                this.f5993f = null;
                this.f5988a = -1;
                this.f5991d = false;
                this.f5990c.j1(this);
                this.f5990c = null;
                this.f5989b = null;
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f5809x0 = i3 == 19 || i3 == 20;
        f5810y0 = i3 >= 23;
        f5811z0 = true;
        f5803A0 = i3 >= 21;
        f5804B0 = false;
        f5805C0 = false;
        Class cls = Integer.TYPE;
        f5806D0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f5807E0 = new InterpolatorC0367c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void B() {
        int i3 = this.f5881y;
        this.f5881y = 0;
        if (i3 == 0 || !u0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC0156b.b(accessibilityEventObtain, i3);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void D() {
        this.f5848g0.a(1);
        R(this.f5848g0);
        this.f5848g0.f5892j = false;
        r1();
        this.f5845f.f();
        H0();
        P0();
        e1();
        A a3 = this.f5848g0;
        a3.f5891i = a3.f5893k && this.f5856k0;
        this.f5856k0 = false;
        this.f5854j0 = false;
        a3.f5890h = a3.f5894l;
        a3.f5888f = this.f5857l.e();
        V(this.f5864o0);
        if (this.f5848g0.f5893k) {
            int iG = this.f5843e.g();
            for (int i3 = 0; i3 < iG; i3++) {
                D dG0 = g0(this.f5843e.f(i3));
                if (!dG0.J() && (!dG0.t() || this.f5857l.i())) {
                    this.f5845f.e(dG0, this.f5823L.t(this.f5848g0, dG0, l.e(dG0), dG0.o()));
                    if (this.f5848g0.f5891i && dG0.y() && !dG0.v() && !dG0.J() && !dG0.t()) {
                        this.f5845f.c(d0(dG0), dG0);
                    }
                }
            }
        }
        if (this.f5848g0.f5894l) {
            f1();
            A a4 = this.f5848g0;
            boolean z3 = a4.f5889g;
            a4.f5889g = false;
            this.f5859m.b1(this.f5837b, a4);
            this.f5848g0.f5889g = z3;
            for (int i4 = 0; i4 < this.f5843e.g(); i4++) {
                D dG1 = g0(this.f5843e.f(i4));
                if (!dG1.J() && !this.f5845f.i(dG1)) {
                    int iE = l.e(dG1);
                    boolean zP = dG1.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.b bVarT = this.f5823L.t(this.f5848g0, dG1, iE, dG1.o());
                    if (zP) {
                        S0(dG1, bVarT);
                    } else {
                        this.f5845f.a(dG1, bVarT);
                    }
                }
            }
            t();
        } else {
            t();
        }
        I0();
        t1(false);
        this.f5848g0.f5887e = 2;
    }

    private void E() {
        r1();
        H0();
        this.f5848g0.a(6);
        this.f5841d.j();
        this.f5848g0.f5888f = this.f5857l.e();
        A a3 = this.f5848g0;
        a3.f5886d = 0;
        a3.f5890h = false;
        this.f5859m.b1(this.f5837b, a3);
        A a4 = this.f5848g0;
        a4.f5889g = false;
        this.f5839c = null;
        a4.f5893k = a4.f5893k && this.f5823L != null;
        a4.f5887e = 4;
        I0();
        t1(false);
    }

    private void F() {
        this.f5848g0.a(4);
        r1();
        H0();
        A a3 = this.f5848g0;
        a3.f5887e = 1;
        if (a3.f5893k) {
            for (int iG = this.f5843e.g() - 1; iG >= 0; iG--) {
                D dG0 = g0(this.f5843e.f(iG));
                if (!dG0.J()) {
                    long jD0 = d0(dG0);
                    l.b bVarS = this.f5823L.s(this.f5848g0, dG0);
                    D dG = this.f5845f.g(jD0);
                    if (dG == null || dG.J()) {
                        this.f5845f.d(dG0, bVarS);
                    } else {
                        boolean zH = this.f5845f.h(dG);
                        boolean zH2 = this.f5845f.h(dG0);
                        if (zH && dG == dG0) {
                            this.f5845f.d(dG0, bVarS);
                        } else {
                            l.b bVarN = this.f5845f.n(dG);
                            this.f5845f.d(dG0, bVarS);
                            l.b bVarM = this.f5845f.m(dG0);
                            if (bVarN == null) {
                                m0(jD0, dG0, dG);
                            } else {
                                n(dG, dG0, bVarN, bVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f5845f.o(this.f5878v0);
        }
        this.f5859m.p1(this.f5837b);
        A a4 = this.f5848g0;
        a4.f5885c = a4.f5888f;
        this.f5814C = false;
        this.f5815D = false;
        a4.f5893k = false;
        a4.f5894l = false;
        this.f5859m.f5951h = false;
        ArrayList arrayList = this.f5837b.f5979b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f5859m;
        if (oVar.f5957n) {
            oVar.f5956m = 0;
            oVar.f5957n = false;
            this.f5837b.K();
        }
        this.f5859m.c1(this.f5848g0);
        I0();
        t1(false);
        this.f5845f.f();
        int[] iArr = this.f5864o0;
        if (y(iArr[0], iArr[1])) {
            J(0, 0);
        }
        T0();
        c1();
    }

    private void K0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f5825N) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f5825N = motionEvent.getPointerId(i3);
            int x3 = (int) (motionEvent.getX(i3) + 0.5f);
            this.f5829R = x3;
            this.f5827P = x3;
            int y3 = (int) (motionEvent.getY(i3) + 0.5f);
            this.f5830S = y3;
            this.f5828Q = y3;
        }
    }

    private boolean L(MotionEvent motionEvent) {
        s sVar = this.f5865p;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return U(motionEvent);
        }
        sVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f5865p = null;
        }
        return true;
    }

    private boolean O0() {
        return this.f5823L != null && this.f5859m.P1();
    }

    private void P0() {
        boolean z3;
        if (this.f5814C) {
            this.f5841d.u();
            if (this.f5815D) {
                this.f5859m.W0(this);
            }
        }
        if (O0()) {
            this.f5841d.s();
        } else {
            this.f5841d.j();
        }
        boolean z4 = this.f5854j0 || this.f5856k0;
        this.f5848g0.f5893k = this.f5873t && this.f5823L != null && ((z3 = this.f5814C) || z4 || this.f5859m.f5951h) && (!z3 || this.f5857l.i());
        A a3 = this.f5848g0;
        a3.f5894l = a3.f5893k && z4 && !this.f5814C && O0();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void R0(float f3, float f4, float f5, float f6) {
        boolean z3;
        boolean z4 = true;
        if (f4 >= 0.0f) {
            if (f4 > 0.0f) {
                O();
                androidx.core.widget.d.c(this.f5821J, f4 / getWidth(), f5 / getHeight());
            } else {
                z3 = false;
            }
            if (f6 < 0.0f) {
                P();
                androidx.core.widget.d.c(this.f5820I, (-f6) / getHeight(), f3 / getWidth());
            } else if (f6 > 0.0f) {
                M();
                androidx.core.widget.d.c(this.f5822K, f6 / getHeight(), 1.0f - (f3 / getWidth()));
            } else {
                z4 = z3;
            }
            if (z4 && f4 == 0.0f && f6 == 0.0f) {
                return;
            }
            Z.h0(this);
        }
        N();
        androidx.core.widget.d.c(this.f5819H, (-f4) / getWidth(), 1.0f - (f5 / getHeight()));
        z3 = true;
        if (f6 < 0.0f) {
            P();
            androidx.core.widget.d.c(this.f5820I, (-f6) / getHeight(), f3 / getWidth());
        } else if (f6 > 0.0f) {
            M();
            androidx.core.widget.d.c(this.f5822K, f6 / getHeight(), 1.0f - (f3 / getWidth()));
        } else {
            z4 = z3;
        }
        if (z4) {
        }
        Z.h0(this);
    }

    private void T0() {
        View viewFindViewById;
        if (!this.f5840c0 || this.f5857l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f5805C0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f5843e.n(focusedChild)) {
                    return;
                }
            } else if (this.f5843e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewX = null;
        D dZ = (this.f5848g0.f5896n == -1 || !this.f5857l.i()) ? null : Z(this.f5848g0.f5896n);
        if (dZ != null && !this.f5843e.n(dZ.f5908a) && dZ.f5908a.hasFocusable()) {
            viewX = dZ.f5908a;
        } else if (this.f5843e.g() > 0) {
            viewX = X();
        }
        if (viewX != null) {
            int i3 = this.f5848g0.f5897o;
            if (i3 != -1 && (viewFindViewById = viewX.findViewById(i3)) != null && viewFindViewById.isFocusable()) {
                viewX = viewFindViewById;
            }
            viewX.requestFocus();
        }
    }

    private boolean U(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f5863o.size();
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = (s) this.f5863o.get(i3);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.f5865p = sVar;
                return true;
            }
        }
        return false;
    }

    private void U0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f5819H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f5819H.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f5820I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f5820I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f5821J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f5821J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f5822K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f5822K.isFinished();
        }
        if (zIsFinished) {
            Z.h0(this);
        }
    }

    private void V(int[] iArr) {
        int iG = this.f5843e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iG; i5++) {
            D dG0 = g0(this.f5843e.f(i5));
            if (!dG0.J()) {
                int iM = dG0.m();
                if (iM < i3) {
                    i3 = iM;
                }
                if (iM > i4) {
                    i4 = iM;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    static RecyclerView W(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView recyclerViewW = W(viewGroup.getChildAt(i3));
            if (recyclerViewW != null) {
                return recyclerViewW;
            }
        }
        return null;
    }

    private View X() {
        D dY;
        A a3 = this.f5848g0;
        int i3 = a3.f5895m;
        if (i3 == -1) {
            i3 = 0;
        }
        int iB = a3.b();
        for (int i4 = i3; i4 < iB; i4++) {
            D dY2 = Y(i4);
            if (dY2 == null) {
                break;
            }
            if (dY2.f5908a.hasFocusable()) {
                return dY2.f5908a;
            }
        }
        int iMin = Math.min(iB, i3);
        do {
            iMin--;
            if (iMin < 0 || (dY = Y(iMin)) == null) {
                return null;
            }
        } while (!dY.f5908a.hasFocusable());
        return dY.f5908a;
    }

    private void b1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f5851i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f5970c) {
                Rect rect = pVar.f5969b;
                Rect rect2 = this.f5851i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f5851i);
            offsetRectIntoDescendantCoords(view, this.f5851i);
        }
        this.f5859m.w1(this, view, this.f5851i, !this.f5873t, view2 == null);
    }

    private void c1() {
        A a3 = this.f5848g0;
        a3.f5896n = -1L;
        a3.f5895m = -1;
        a3.f5897o = -1;
    }

    private void d1() {
        VelocityTracker velocityTracker = this.f5826O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        u1(0);
        U0();
    }

    private void e1() {
        int iJ;
        View focusedChild = (this.f5840c0 && hasFocus() && this.f5857l != null) ? getFocusedChild() : null;
        D dT = focusedChild != null ? T(focusedChild) : null;
        if (dT == null) {
            c1();
            return;
        }
        this.f5848g0.f5896n = this.f5857l.i() ? dT.k() : -1L;
        A a3 = this.f5848g0;
        if (this.f5814C) {
            iJ = -1;
        } else {
            iJ = dT.v() ? dT.f5911d : dT.j();
        }
        a3.f5895m = iJ;
        this.f5848g0.f5897o = j0(dT.f5908a);
    }

    private void g(D d3) {
        View view = d3.f5908a;
        boolean z3 = view.getParent() == this;
        this.f5837b.J(f0(view));
        if (d3.x()) {
            this.f5843e.c(view, -1, view.getLayoutParams(), true);
        } else if (z3) {
            this.f5843e.k(view);
        } else {
            this.f5843e.b(view, true);
        }
    }

    static D g0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f5968a;
    }

    private androidx.core.view.D getScrollingChildHelper() {
        if (this.f5866p0 == null) {
            this.f5866p0 = new androidx.core.view.D(this);
        }
        return this.f5866p0;
    }

    static void i0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f5969b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int j0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private void j1(g gVar, boolean z3, boolean z4) {
        g gVar2 = this.f5857l;
        if (gVar2 != null) {
            gVar2.v(this.f5835a);
            this.f5857l.o(this);
        }
        if (!z3 || z4) {
            V0();
        }
        this.f5841d.u();
        g gVar3 = this.f5857l;
        this.f5857l = gVar;
        if (gVar != null) {
            gVar.t(this.f5835a);
            gVar.k(this);
        }
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.I0(gVar3, this.f5857l);
        }
        this.f5837b.x(gVar3, this.f5857l, z3);
        this.f5848g0.f5889g = true;
    }

    private String k0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void m0(long j3, D d3, D d4) {
        int iG = this.f5843e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            D dG0 = g0(this.f5843e.f(i3));
            if (dG0 != d3 && d0(dG0) == j3) {
                g gVar = this.f5857l;
                if (gVar == null || !gVar.i()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + dG0 + " \n View Holder 2:" + d3 + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + dG0 + " \n View Holder 2:" + d3 + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d4 + " cannot be found but it is necessary for " + d3 + Q());
    }

    private void n(D d3, D d4, l.b bVar, l.b bVar2, boolean z3, boolean z4) {
        d3.G(false);
        if (z3) {
            g(d3);
        }
        if (d3 != d4) {
            if (z4) {
                g(d4);
            }
            d3.f5915h = d4;
            g(d3);
            this.f5837b.J(d3);
            d4.G(false);
            d4.f5916i = d3;
        }
        if (this.f5823L.b(d3, d4, bVar, bVar2)) {
            N0();
        }
    }

    private boolean o0() {
        int iG = this.f5843e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            D dG0 = g0(this.f5843e.f(i3));
            if (dG0 != null && !dG0.J() && dG0.y()) {
                return true;
            }
        }
        return false;
    }

    private void q0() {
        if (Z.B(this) == 0) {
            Z.B0(this, 8);
        }
    }

    private void r() {
        d1();
        setScrollState(0);
    }

    private void r0() {
        this.f5843e = new b(new e());
    }

    static void s(D d3) {
        WeakReference weakReference = d3.f5909b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == d3.f5908a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            d3.f5909b = null;
        }
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i3, int i4) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strK0 = k0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strK0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f5806D0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i4)};
                } catch (NoSuchMethodException e3) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e4) {
                        e4.initCause(e3);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strK0, e4);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strK0, e5);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strK0, e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strK0, e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strK0, e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strK0, e9);
            }
        }
    }

    private boolean w0(View view, View view2, int i3) {
        int i4;
        if (view2 == null || view2 == this || S(view2) == null) {
            return false;
        }
        if (view == null || S(view) == null) {
            return true;
        }
        this.f5851i.set(0, 0, view.getWidth(), view.getHeight());
        this.f5853j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f5851i);
        offsetDescendantRectToMyCoords(view2, this.f5853j);
        byte b3 = -1;
        int i5 = this.f5859m.d0() == 1 ? -1 : 1;
        Rect rect = this.f5851i;
        int i6 = rect.left;
        Rect rect2 = this.f5853j;
        int i7 = rect2.left;
        if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
            i4 = 1;
        } else {
            int i8 = rect.right;
            int i9 = rect2.right;
            i4 = ((i8 > i9 || i6 >= i9) && i6 > i7) ? -1 : 0;
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
            b3 = 1;
        } else {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if ((i12 <= i13 && i10 < i13) || i10 <= i11) {
                b3 = 0;
            }
        }
        if (i3 == 1) {
            return b3 < 0 || (b3 == 0 && i4 * i5 <= 0);
        }
        if (i3 == 2) {
            return b3 > 0 || (b3 == 0 && i4 * i5 >= 0);
        }
        if (i3 == 17) {
            return i4 < 0;
        }
        if (i3 == 33) {
            return b3 < 0;
        }
        if (i3 == 66) {
            return i4 > 0;
        }
        if (i3 == 130) {
            return b3 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i3 + Q());
    }

    private void w1() {
        this.f5842d0.g();
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.O1();
        }
    }

    private boolean y(int i3, int i4) {
        V(this.f5864o0);
        int[] iArr = this.f5864o0;
        return (iArr[0] == i3 && iArr[1] == i4) ? false : true;
    }

    void A(View view) {
        D dG0 = g0(view);
        G0(view);
        g gVar = this.f5857l;
        if (gVar != null && dG0 != null) {
            gVar.r(dG0);
        }
        List list = this.f5813B;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.f5813B.get(size)).b(view);
            }
        }
    }

    public void A0(int i3) {
        int iG = this.f5843e.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f5843e.f(i4).offsetLeftAndRight(i3);
        }
    }

    public void B0(int i3) {
        int iG = this.f5843e.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f5843e.f(i4).offsetTopAndBottom(i3);
        }
    }

    void C() {
        if (this.f5857l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f5859m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        A a3 = this.f5848g0;
        a3.f5892j = false;
        if (a3.f5887e == 1) {
            D();
            this.f5859m.D1(this);
            E();
        } else if (!this.f5841d.q() && this.f5859m.s0() == getWidth() && this.f5859m.b0() == getHeight()) {
            this.f5859m.D1(this);
        } else {
            this.f5859m.D1(this);
            E();
        }
        F();
    }

    void C0(int i3, int i4) {
        int iJ = this.f5843e.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            D dG0 = g0(this.f5843e.i(i5));
            if (dG0 != null && !dG0.J() && dG0.f5910c >= i3) {
                dG0.A(i4, false);
                this.f5848g0.f5889g = true;
            }
        }
        this.f5837b.u(i3, i4);
        requestLayout();
    }

    void D0(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int iJ = this.f5843e.j();
        if (i3 < i4) {
            i7 = -1;
            i6 = i3;
            i5 = i4;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = 1;
        }
        for (int i9 = 0; i9 < iJ; i9++) {
            D dG0 = g0(this.f5843e.i(i9));
            if (dG0 != null && (i8 = dG0.f5910c) >= i6 && i8 <= i5) {
                if (i8 == i3) {
                    dG0.A(i4 - i3, false);
                } else {
                    dG0.A(i7, false);
                }
                this.f5848g0.f5889g = true;
            }
        }
        this.f5837b.v(i3, i4);
        requestLayout();
    }

    void E0(int i3, int i4, boolean z3) {
        int i5 = i3 + i4;
        int iJ = this.f5843e.j();
        for (int i6 = 0; i6 < iJ; i6++) {
            D dG0 = g0(this.f5843e.i(i6));
            if (dG0 != null && !dG0.J()) {
                int i7 = dG0.f5910c;
                if (i7 >= i5) {
                    dG0.A(-i4, z3);
                    this.f5848g0.f5889g = true;
                } else if (i7 >= i3) {
                    dG0.i(i3 - 1, -i4, z3);
                    this.f5848g0.f5889g = true;
                }
            }
        }
        this.f5837b.w(i3, i4, z3);
        requestLayout();
    }

    public void F0(View view) {
    }

    public boolean G(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return getScrollingChildHelper().d(i3, i4, iArr, iArr2, i5);
    }

    public void G0(View view) {
    }

    public final void H(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        getScrollingChildHelper().e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    void H0() {
        this.f5816E++;
    }

    void I(int i3) {
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.i1(i3);
        }
        L0(i3);
        t tVar = this.f5850h0;
        if (tVar != null) {
            tVar.a(this, i3);
        }
        List list = this.f5852i0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f5852i0.get(size)).a(this, i3);
            }
        }
    }

    void I0() {
        J0(true);
    }

    void J(int i3, int i4) {
        this.f5817F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i4);
        M0(i3, i4);
        t tVar = this.f5850h0;
        if (tVar != null) {
            tVar.b(this, i3, i4);
        }
        List list = this.f5852i0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f5852i0.get(size)).b(this, i3, i4);
            }
        }
        this.f5817F--;
    }

    void J0(boolean z3) {
        int i3 = this.f5816E - 1;
        this.f5816E = i3;
        if (i3 < 1) {
            this.f5816E = 0;
            if (z3) {
                B();
                K();
            }
        }
    }

    void K() {
        int i3;
        for (int size = this.f5874t0.size() - 1; size >= 0; size--) {
            D d3 = (D) this.f5874t0.get(size);
            if (d3.f5908a.getParent() == this && !d3.J() && (i3 = d3.f5924q) != -1) {
                Z.z0(d3.f5908a, i3);
                d3.f5924q = -1;
            }
        }
        this.f5874t0.clear();
    }

    public void L0(int i3) {
    }

    void M() {
        if (this.f5822K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f5818G.a(this, 3);
        this.f5822K = edgeEffectA;
        if (this.f5847g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void M0(int i3, int i4) {
    }

    void N() {
        if (this.f5819H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f5818G.a(this, 0);
        this.f5819H = edgeEffectA;
        if (this.f5847g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void N0() {
        if (this.f5860m0 || !this.f5867q) {
            return;
        }
        Z.i0(this, this.f5876u0);
        this.f5860m0 = true;
    }

    void O() {
        if (this.f5821J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f5818G.a(this, 2);
        this.f5821J = edgeEffectA;
        if (this.f5847g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void P() {
        if (this.f5820I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f5818G.a(this, 1);
        this.f5820I = edgeEffectA;
        if (this.f5847g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String Q() {
        return " " + super.toString() + ", adapter:" + this.f5857l + ", layout:" + this.f5859m + ", context:" + getContext();
    }

    void Q0(boolean z3) {
        this.f5815D = z3 | this.f5815D;
        this.f5814C = true;
        z0();
    }

    final void R(A a3) {
        if (getScrollState() != 2) {
            a3.f5898p = 0;
            a3.f5899q = 0;
        } else {
            OverScroller overScroller = this.f5842d0.f5902c;
            a3.f5898p = overScroller.getFinalX() - overScroller.getCurrX();
            a3.f5899q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View S(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    void S0(D d3, l.b bVar) {
        d3.F(0, 8192);
        if (this.f5848g0.f5891i && d3.y() && !d3.v() && !d3.J()) {
            this.f5845f.c(d0(d3), d3);
        }
        this.f5845f.e(d3, bVar);
    }

    public D T(View view) {
        View viewS = S(view);
        if (viewS == null) {
            return null;
        }
        return f0(viewS);
    }

    void V0() {
        l lVar = this.f5823L;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.o1(this.f5837b);
            this.f5859m.p1(this.f5837b);
        }
        this.f5837b.c();
    }

    boolean W0(View view) {
        r1();
        boolean zR = this.f5843e.r(view);
        if (zR) {
            D dG0 = g0(view);
            this.f5837b.J(dG0);
            this.f5837b.C(dG0);
        }
        t1(!zR);
        return zR;
    }

    public void X0(n nVar) {
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.l("Cannot remove item decoration during a scroll  or layout");
        }
        this.f5861n.remove(nVar);
        if (this.f5861n.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        y0();
        requestLayout();
    }

    public D Y(int i3) {
        D d3 = null;
        if (this.f5814C) {
            return null;
        }
        int iJ = this.f5843e.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            D dG0 = g0(this.f5843e.i(i4));
            if (dG0 != null && !dG0.v() && c0(dG0) == i3) {
                if (!this.f5843e.n(dG0.f5908a)) {
                    return dG0;
                }
                d3 = dG0;
            }
        }
        return d3;
    }

    public void Y0(s sVar) {
        this.f5863o.remove(sVar);
        if (this.f5865p == sVar) {
            this.f5865p = null;
        }
    }

    public D Z(long j3) {
        g gVar = this.f5857l;
        D d3 = null;
        if (gVar != null && gVar.i()) {
            int iJ = this.f5843e.j();
            for (int i3 = 0; i3 < iJ; i3++) {
                D dG0 = g0(this.f5843e.i(i3));
                if (dG0 != null && !dG0.v() && dG0.k() == j3) {
                    if (!this.f5843e.n(dG0.f5908a)) {
                        return dG0;
                    }
                    d3 = dG0;
                }
            }
        }
        return d3;
    }

    public void Z0(t tVar) {
        List list = this.f5852i0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void a(int i3, int i4) {
        if (i3 < 0) {
            N();
            if (this.f5819H.isFinished()) {
                this.f5819H.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            O();
            if (this.f5821J.isFinished()) {
                this.f5821J.onAbsorb(i3);
            }
        }
        if (i4 < 0) {
            P();
            if (this.f5820I.isFinished()) {
                this.f5820I.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            M();
            if (this.f5822K.isFinished()) {
                this.f5822K.onAbsorb(i4);
            }
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        Z.h0(this);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    D a0(int i3, boolean z3) {
        int iJ = this.f5843e.j();
        D d3 = null;
        for (int i4 = 0; i4 < iJ; i4++) {
            D dG0 = g0(this.f5843e.i(i4));
            if (dG0 != null && !dG0.v()) {
                if (z3) {
                    if (dG0.f5910c != i3) {
                        continue;
                    } else {
                        if (this.f5843e.n(dG0.f5908a)) {
                            return dG0;
                        }
                        d3 = dG0;
                    }
                } else if (dG0.m() != i3) {
                    continue;
                } else {
                    if (this.f5843e.n(dG0.f5908a)) {
                        return dG0;
                    }
                    d3 = dG0;
                }
            }
        }
        return d3;
    }

    void a1() {
        D d3;
        int iG = this.f5843e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            View viewF = this.f5843e.f(i3);
            D dF0 = f0(viewF);
            if (dF0 != null && (d3 = dF0.f5916i) != null) {
                View view = d3.f5908a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i3, int i4) {
        o oVar = this.f5859m;
        if (oVar == null || !oVar.J0(this, arrayList, i3, i4)) {
            super.addFocusables(arrayList, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean b0(int i3, int i4) {
        o oVar = this.f5859m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f5879w) {
            return false;
        }
        int iP = oVar.p();
        boolean zQ = this.f5859m.q();
        if (iP == 0 || Math.abs(i3) < this.f5833V) {
            i3 = 0;
        }
        if (!zQ || Math.abs(i4) < this.f5833V) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        float f3 = i3;
        float f4 = i4;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z3 = iP != 0 || zQ;
            dispatchNestedFling(f3, f4, z3);
            r rVar = this.f5832U;
            if (rVar != null && rVar.a(i3, i4)) {
                return true;
            }
            if (z3) {
                if (zQ) {
                    iP = (iP == true ? 1 : 0) | 2;
                }
                s1(iP, 1);
                int i5 = this.f5834W;
                int iMax = Math.max(-i5, Math.min(i3, i5));
                int i6 = this.f5834W;
                this.f5842d0.c(iMax, Math.max(-i6, Math.min(i4, i6)));
                return true;
            }
        }
        return false;
    }

    int c0(D d3) {
        if (d3.p(524) || !d3.s()) {
            return -1;
        }
        return this.f5841d.e(d3.f5910c);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f5859m.r((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.p()) {
            return this.f5859m.v(this.f5848g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.p()) {
            return this.f5859m.w(this.f5848g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.p()) {
            return this.f5859m.x(this.f5848g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.q()) {
            return this.f5859m.y(this.f5848g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.q()) {
            return this.f5859m.z(this.f5848g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f5859m;
        if (oVar != null && oVar.q()) {
            return this.f5859m.A(this.f5848g0);
        }
        return 0;
    }

    long d0(D d3) {
        return this.f5857l.i() ? d3.k() : d3.f5910c;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return getScrollingChildHelper().a(f3, f4, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return getScrollingChildHelper().b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return getScrollingChildHelper().f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z3;
        super.draw(canvas);
        int size = this.f5861n.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((n) this.f5861n.get(i3)).i(canvas, this, this.f5848g0);
        }
        EdgeEffect edgeEffect = this.f5819H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z3 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f5847g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f5819H;
            z3 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f5820I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f5847g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f5820I;
            z3 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f5821J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f5847g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f5821J;
            z3 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f5822K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f5847g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f5822K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 |= z4;
            canvas.restoreToCount(iSave4);
        }
        if ((z3 || this.f5823L == null || this.f5861n.size() <= 0 || !this.f5823L.p()) ? z3 : true) {
            Z.h0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    public int e0(View view) {
        D dG0 = g0(view);
        if (dG0 != null) {
            return dG0.m();
        }
        return -1;
    }

    public D f0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void f1() {
        int iJ = this.f5843e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            D dG0 = g0(this.f5843e.i(i3));
            if (!dG0.J()) {
                dG0.E();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View viewN0;
        boolean z3;
        View viewU0 = this.f5859m.U0(view, i3);
        if (viewU0 != null) {
            return viewU0;
        }
        boolean z4 = (this.f5857l == null || this.f5859m == null || v0() || this.f5879w) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z4 && (i3 == 2 || i3 == 1)) {
            if (this.f5859m.q()) {
                int i4 = i3 == 2 ? 130 : 33;
                z3 = focusFinder.findNextFocus(this, view, i4) == null;
                if (f5804B0) {
                    i3 = i4;
                }
            } else {
                z3 = false;
            }
            if (!z3 && this.f5859m.p()) {
                int i5 = (this.f5859m.d0() == 1) ^ (i3 == 2) ? 66 : 17;
                boolean z5 = focusFinder.findNextFocus(this, view, i5) == null;
                if (f5804B0) {
                    i3 = i5;
                }
                z3 = z5;
            }
            if (z3) {
                v();
                if (S(view) == null) {
                    return null;
                }
                r1();
                this.f5859m.N0(view, i3, this.f5837b, this.f5848g0);
                t1(false);
            }
            viewN0 = focusFinder.findNextFocus(this, view, i3);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i3);
            if (viewFindNextFocus == null && z4) {
                v();
                if (S(view) == null) {
                    return null;
                }
                r1();
                viewN0 = this.f5859m.N0(view, i3, this.f5837b, this.f5848g0);
                t1(false);
            } else {
                viewN0 = viewFindNextFocus;
            }
        }
        if (viewN0 == null || viewN0.hasFocusable()) {
            return w0(view, viewN0, i3) ? viewN0 : super.focusSearch(view, i3);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i3);
        }
        b1(viewN0, null);
        return view;
    }

    boolean g1(int i3, int i4, MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        v();
        if (this.f5857l != null) {
            int[] iArr = this.f5872s0;
            iArr[0] = 0;
            iArr[1] = 0;
            h1(i3, i4, iArr);
            int[] iArr2 = this.f5872s0;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i5 = i10;
            i6 = i9;
            i7 = i3 - i9;
            i8 = i4 - i10;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.f5861n.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f5872s0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i6, i5, i7, i8, this.f5868q0, 0, iArr3);
        int[] iArr4 = this.f5872s0;
        int i11 = iArr4[0];
        int i12 = i7 - i11;
        int i13 = iArr4[1];
        int i14 = i8 - i13;
        boolean z3 = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.f5829R;
        int[] iArr5 = this.f5868q0;
        int i16 = iArr5[0];
        this.f5829R = i15 - i16;
        int i17 = this.f5830S;
        int i18 = iArr5[1];
        this.f5830S = i17 - i18;
        int[] iArr6 = this.f5870r0;
        iArr6[0] = iArr6[0] + i16;
        iArr6[1] = iArr6[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.B.a(motionEvent, 8194)) {
                R0(motionEvent.getX(), i12, motionEvent.getY(), i14);
            }
            u(i3, i4);
        }
        if (i6 != 0 || i5 != 0) {
            J(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z3 && i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f5859m;
        if (oVar != null) {
            return oVar.I();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f5859m;
        if (oVar != null) {
            return oVar.J(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f5857l;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f5859m;
        return oVar != null ? oVar.L() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        return super.getChildDrawingOrder(i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f5847g;
    }

    public androidx.recyclerview.widget.m getCompatAccessibilityDelegate() {
        return this.f5862n0;
    }

    public k getEdgeEffectFactory() {
        return this.f5818G;
    }

    public l getItemAnimator() {
        return this.f5823L;
    }

    public int getItemDecorationCount() {
        return this.f5861n.size();
    }

    public o getLayoutManager() {
        return this.f5859m;
    }

    public int getMaxFlingVelocity() {
        return this.f5834W;
    }

    public int getMinFlingVelocity() {
        return this.f5833V;
    }

    long getNanoTime() {
        if (f5803A0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.f5832U;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f5840c0;
    }

    public u getRecycledViewPool() {
        return this.f5837b.i();
    }

    public int getScrollState() {
        return this.f5824M;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public void h0(View view, Rect rect) {
        i0(view, rect);
    }

    void h1(int i3, int i4, int[] iArr) {
        r1();
        H0();
        androidx.core.os.t.a("RV Scroll");
        R(this.f5848g0);
        int iA1 = i3 != 0 ? this.f5859m.A1(i3, this.f5837b, this.f5848g0) : 0;
        int iC1 = i4 != 0 ? this.f5859m.C1(i4, this.f5837b, this.f5848g0) : 0;
        androidx.core.os.t.b();
        a1();
        I0();
        t1(false);
        if (iArr != null) {
            iArr[0] = iA1;
            iArr[1] = iC1;
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i3) {
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.l("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f5861n.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i3 < 0) {
            this.f5861n.add(nVar);
        } else {
            this.f5861n.add(i3, nVar);
        }
        y0();
        requestLayout();
    }

    public void i1(int i3) {
        if (this.f5879w) {
            return;
        }
        v1();
        o oVar = this.f5859m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.B1(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f5867q;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f5879w;
    }

    @Override // android.view.View, androidx.core.view.C
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(q qVar) {
        if (this.f5813B == null) {
            this.f5813B = new ArrayList();
        }
        this.f5813B.add(qVar);
    }

    public void k(s sVar) {
        this.f5863o.add(sVar);
    }

    boolean k1(D d3, int i3) {
        if (!v0()) {
            Z.z0(d3.f5908a, i3);
            return true;
        }
        d3.f5924q = i3;
        this.f5874t0.add(d3);
        return false;
    }

    public void l(t tVar) {
        if (this.f5852i0 == null) {
            this.f5852i0 = new ArrayList();
        }
        this.f5852i0.add(tVar);
    }

    Rect l0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f5970c) {
            return pVar.f5969b;
        }
        if (this.f5848g0.e() && (pVar.b() || pVar.d())) {
            return pVar.f5969b;
        }
        Rect rect = pVar.f5969b;
        rect.set(0, 0, 0, 0);
        int size = this.f5861n.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f5851i.set(0, 0, 0, 0);
            ((n) this.f5861n.get(i3)).e(this.f5851i, view, this, this.f5848g0);
            int i4 = rect.left;
            Rect rect2 = this.f5851i;
            rect.left = i4 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f5970c = false;
        return rect;
    }

    boolean l1(AccessibilityEvent accessibilityEvent) {
        if (!v0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? AbstractC0156b.a(accessibilityEvent) : 0;
        this.f5881y |= iA != 0 ? iA : 0;
        return true;
    }

    void m(D d3, l.b bVar, l.b bVar2) {
        d3.G(false);
        if (this.f5823L.a(d3, bVar, bVar2)) {
            N0();
        }
    }

    public void m1(int i3, int i4) {
        n1(i3, i4, null);
    }

    public boolean n0() {
        return !this.f5873t || this.f5814C || this.f5841d.p();
    }

    public void n1(int i3, int i4, Interpolator interpolator) {
        o1(i3, i4, interpolator, Integer.MIN_VALUE);
    }

    void o(D d3, l.b bVar, l.b bVar2) {
        g(d3);
        d3.G(false);
        if (this.f5823L.c(d3, bVar, bVar2)) {
            N0();
        }
    }

    public void o1(int i3, int i4, Interpolator interpolator, int i5) {
        p1(i3, i4, interpolator, i5, false);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.f5816E = 0;
        this.f5867q = true;
        this.f5873t = this.f5873t && !isLayoutRequested();
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.E(this);
        }
        this.f5860m0 = false;
        if (f5803A0) {
            ThreadLocal threadLocal = androidx.recyclerview.widget.f.f6167e;
            androidx.recyclerview.widget.f fVar = (androidx.recyclerview.widget.f) threadLocal.get();
            this.f5844e0 = fVar;
            if (fVar == null) {
                this.f5844e0 = new androidx.recyclerview.widget.f();
                Display displayV = Z.v(this);
                if (isInEditMode() || displayV == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayV.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                androidx.recyclerview.widget.f fVar2 = this.f5844e0;
                fVar2.f6171c = (long) (1.0E9f / refreshRate);
                threadLocal.set(fVar2);
            }
            this.f5844e0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.f fVar;
        super.onDetachedFromWindow();
        l lVar = this.f5823L;
        if (lVar != null) {
            lVar.k();
        }
        v1();
        this.f5867q = false;
        o oVar = this.f5859m;
        if (oVar != null) {
            oVar.F(this, this.f5837b);
        }
        this.f5874t0.clear();
        removeCallbacks(this.f5876u0);
        this.f5845f.j();
        if (!f5803A0 || (fVar = this.f5844e0) == null) {
            return;
        }
        fVar.j(this);
        this.f5844e0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f5861n.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((n) this.f5861n.get(i3)).g(canvas, this, this.f5848g0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f3;
        float axisValue;
        if (this.f5859m != null && !this.f5879w && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.f5859m.q() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f5859m.p() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f5859m.q()) {
                    f3 = -axisValue2;
                } else if (this.f5859m.p()) {
                    axisValue = axisValue2;
                    f3 = 0.0f;
                } else {
                    f3 = 0.0f;
                }
            } else {
                f3 = 0.0f;
            }
            if (f3 != 0.0f || axisValue != 0.0f) {
                g1((int) (axisValue * this.f5836a0), (int) (f3 * this.f5838b0), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        if (this.f5879w) {
            return false;
        }
        this.f5865p = null;
        if (U(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.f5859m;
        if (oVar == null) {
            return false;
        }
        boolean zP = oVar.p();
        boolean zQ = this.f5859m.q();
        if (this.f5826O == null) {
            this.f5826O = VelocityTracker.obtain();
        }
        this.f5826O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f5880x) {
                this.f5880x = false;
            }
            this.f5825N = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.f5829R = x3;
            this.f5827P = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.f5830S = y3;
            this.f5828Q = y3;
            if (this.f5824M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                u1(1);
            }
            int[] iArr = this.f5870r0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = zP;
            if (zQ) {
                i3 = (zP ? 1 : 0) | 2;
            }
            s1(i3, 0);
        } else if (actionMasked == 1) {
            this.f5826O.clear();
            u1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f5825N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f5825N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f5824M != 1) {
                int i4 = x4 - this.f5827P;
                int i5 = y4 - this.f5828Q;
                if (!zP || Math.abs(i4) <= this.f5831T) {
                    z3 = false;
                } else {
                    this.f5829R = x4;
                    z3 = true;
                }
                if (zQ && Math.abs(i5) > this.f5831T) {
                    this.f5830S = y4;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.f5825N = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f5829R = x5;
            this.f5827P = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f5830S = y5;
            this.f5828Q = y5;
        } else if (actionMasked == 6) {
            K0(motionEvent);
        }
        return this.f5824M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        androidx.core.os.t.a("RV OnLayout");
        C();
        androidx.core.os.t.b();
        this.f5873t = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        o oVar = this.f5859m;
        if (oVar == null) {
            x(i3, i4);
            return;
        }
        if (oVar.w0()) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f5859m.d1(this.f5837b, this.f5848g0, i3, i4);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.f5857l == null) {
                return;
            }
            if (this.f5848g0.f5887e == 1) {
                D();
            }
            this.f5859m.E1(i3, i4);
            this.f5848g0.f5892j = true;
            E();
            this.f5859m.H1(i3, i4);
            if (this.f5859m.K1()) {
                this.f5859m.E1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f5848g0.f5892j = true;
                E();
                this.f5859m.H1(i3, i4);
                return;
            }
            return;
        }
        if (this.f5869r) {
            this.f5859m.d1(this.f5837b, this.f5848g0, i3, i4);
            return;
        }
        if (this.f5882z) {
            r1();
            H0();
            P0();
            I0();
            A a3 = this.f5848g0;
            if (a3.f5894l) {
                a3.f5890h = true;
            } else {
                this.f5841d.j();
                this.f5848g0.f5890h = false;
            }
            this.f5882z = false;
            t1(false);
        } else if (this.f5848g0.f5894l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f5857l;
        if (gVar != null) {
            this.f5848g0.f5888f = gVar.e();
        } else {
            this.f5848g0.f5888f = 0;
        }
        r1();
        this.f5859m.d1(this.f5837b, this.f5848g0, i3, i4);
        t1(false);
        this.f5848g0.f5890h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (v0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f5839c = yVar;
        super.onRestoreInstanceState(yVar.c());
        o oVar = this.f5859m;
        if (oVar == null || (parcelable2 = this.f5839c.f5987c) == null) {
            return;
        }
        oVar.g1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f5839c;
        if (yVar2 != null) {
            yVar.d(yVar2);
        } else {
            o oVar = this.f5859m;
            if (oVar != null) {
                yVar.f5987c = oVar.h1();
            } else {
                yVar.f5987c = null;
            }
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 && i4 == i6) {
            return;
        }
        t0();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z3;
        if (this.f5879w || this.f5880x) {
            return false;
        }
        if (L(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.f5859m;
        if (oVar == null) {
            return false;
        }
        boolean zP = oVar.p();
        boolean zQ = this.f5859m.q();
        if (this.f5826O == null) {
            this.f5826O = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f5870r0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.f5870r0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f5826O.addMovement(motionEventObtain);
                this.f5826O.computeCurrentVelocity(1000, this.f5834W);
                float f3 = zP ? -this.f5826O.getXVelocity(this.f5825N) : 0.0f;
                float f4 = zQ ? -this.f5826O.getYVelocity(this.f5825N) : 0.0f;
                if ((f3 == 0.0f && f4 == 0.0f) || !b0((int) f3, (int) f4)) {
                    setScrollState(0);
                }
                d1();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5825N);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f5825N + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.f5829R - x3;
                int iMax2 = this.f5830S - y3;
                if (this.f5824M != 1) {
                    if (zP) {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.f5831T) : Math.min(0, iMax + this.f5831T);
                        if (iMax != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                    }
                    if (zQ) {
                        iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.f5831T) : Math.min(0, iMax2 + this.f5831T);
                        if (iMax2 != 0) {
                            z3 = true;
                        }
                    }
                    if (z3) {
                        setScrollState(1);
                    }
                }
                int i4 = iMax;
                int i5 = iMax2;
                if (this.f5824M == 1) {
                    int[] iArr3 = this.f5872s0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    if (G(zP ? i4 : 0, zQ ? i5 : 0, iArr3, this.f5868q0, 0)) {
                        int[] iArr4 = this.f5872s0;
                        i4 -= iArr4[0];
                        i5 -= iArr4[1];
                        int[] iArr5 = this.f5870r0;
                        int i6 = iArr5[0];
                        int[] iArr6 = this.f5868q0;
                        iArr5[0] = i6 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i7 = i5;
                    int[] iArr7 = this.f5868q0;
                    this.f5829R = x3 - iArr7[0];
                    this.f5830S = y3 - iArr7[1];
                    if (g1(zP ? i4 : 0, zQ ? i7 : 0, motionEvent)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    androidx.recyclerview.widget.f fVar = this.f5844e0;
                    if (fVar != null && (i4 != 0 || i7 != 0)) {
                        fVar.f(this, i4, i7);
                    }
                }
            } else if (actionMasked == 3) {
                r();
            } else if (actionMasked == 5) {
                this.f5825N = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f5829R = x4;
                this.f5827P = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f5830S = y4;
                this.f5828Q = y4;
            } else if (actionMasked == 6) {
                K0(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.f5825N = motionEvent.getPointerId(0);
        int x5 = (int) (motionEvent.getX() + 0.5f);
        this.f5829R = x5;
        this.f5827P = x5;
        int y5 = (int) (motionEvent.getY() + 0.5f);
        this.f5830S = y5;
        this.f5828Q = y5;
        if (zQ) {
            i3 = zP;
            i3 = (zP ? 1 : 0) | 2;
        }
        i3 = zP;
        s1(i3, 0);
        this.f5826O.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    void p(String str) {
        if (v0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
        }
        if (this.f5817F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + Q()));
        }
    }

    void p0() {
        this.f5841d = new a(new f());
    }

    void p1(int i3, int i4, Interpolator interpolator, int i5, boolean z3) {
        o oVar = this.f5859m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f5879w) {
            return;
        }
        if (!oVar.p()) {
            i3 = 0;
        }
        if (!this.f5859m.q()) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        if (i5 != Integer.MIN_VALUE && i5 <= 0) {
            scrollBy(i3, i4);
            return;
        }
        if (z3) {
            int i6 = i3 != 0 ? 1 : 0;
            if (i4 != 0) {
                i6 |= 2;
            }
            s1(i6, 1);
        }
        this.f5842d0.f(i3, i4, i5, interpolator);
    }

    boolean q(D d3) {
        l lVar = this.f5823L;
        return lVar == null || lVar.g(d3, d3.o());
    }

    public void q1(int i3) {
        if (this.f5879w) {
            return;
        }
        o oVar = this.f5859m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.M1(this, this.f5848g0, i3);
        }
    }

    void r1() {
        int i3 = this.f5875u + 1;
        this.f5875u = i3;
        if (i3 != 1 || this.f5879w) {
            return;
        }
        this.f5877v = false;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z3) {
        D dG0 = g0(view);
        if (dG0 != null) {
            if (dG0.x()) {
                dG0.f();
            } else if (!dG0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + dG0 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f5859m.f1(this, this.f5848g0, view, view2) && view2 != null) {
            b1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        return this.f5859m.v1(this, view, rect, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        int size = this.f5863o.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((s) this.f5863o.get(i3)).c(z3);
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f5875u != 0 || this.f5879w) {
            this.f5877v = true;
        } else {
            super.requestLayout();
        }
    }

    void s0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.e(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(V.b.f2044a), resources.getDimensionPixelSize(V.b.f2046c), resources.getDimensionPixelOffset(V.b.f2045b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
    }

    public boolean s1(int i3, int i4) {
        return getScrollingChildHelper().p(i3, i4);
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i4) {
        o oVar = this.f5859m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f5879w) {
            return;
        }
        boolean zP = oVar.p();
        boolean zQ = this.f5859m.q();
        if (zP || zQ) {
            if (!zP) {
                i3 = 0;
            }
            if (!zQ) {
                i4 = 0;
            }
            g1(i3, i4, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (l1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.m mVar) {
        this.f5862n0 = mVar;
        Z.q0(this, mVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        j1(gVar, false, true);
        Q0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z3) {
        if (z3 != this.f5847g) {
            t0();
        }
        this.f5847g = z3;
        super.setClipToPadding(z3);
        if (this.f5873t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        p082z.h.g(kVar);
        this.f5818G = kVar;
        t0();
    }

    public void setHasFixedSize(boolean z3) {
        this.f5869r = z3;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.f5823L;
        if (lVar2 != null) {
            lVar2.k();
            this.f5823L.v(null);
        }
        this.f5823L = lVar;
        if (lVar != null) {
            lVar.v(this.f5858l0);
        }
    }

    public void setItemViewCacheSize(int i3) {
        this.f5837b.G(i3);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z3) {
        suppressLayout(z3);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f5859m) {
            return;
        }
        v1();
        if (this.f5859m != null) {
            l lVar = this.f5823L;
            if (lVar != null) {
                lVar.k();
            }
            this.f5859m.o1(this.f5837b);
            this.f5859m.p1(this.f5837b);
            this.f5837b.c();
            if (this.f5867q) {
                this.f5859m.F(this, this.f5837b);
            }
            this.f5859m.I1(null);
            this.f5859m = null;
        } else {
            this.f5837b.c();
        }
        this.f5843e.o();
        this.f5859m = oVar;
        if (oVar != null) {
            if (oVar.f5945b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f5945b.Q());
            }
            oVar.I1(this);
            if (this.f5867q) {
                this.f5859m.E(this);
            }
        }
        this.f5837b.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        getScrollingChildHelper().m(z3);
    }

    public void setOnFlingListener(r rVar) {
        this.f5832U = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f5850h0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z3) {
        this.f5840c0 = z3;
    }

    public void setRecycledViewPool(u uVar) {
        this.f5837b.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
    }

    void setScrollState(int i3) {
        if (i3 == this.f5824M) {
            return;
        }
        this.f5824M = i3;
        if (i3 != 2) {
            w1();
        }
        I(i3);
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.f5831T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.f5831T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(B b3) {
        this.f5837b.F(b3);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().o(i3);
    }

    @Override // android.view.View, androidx.core.view.C
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z3) {
        if (z3 != this.f5879w) {
            p("Do not suppressLayout in layout or scroll");
            if (z3) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f5879w = true;
                this.f5880x = true;
                v1();
                return;
            }
            this.f5879w = false;
            if (this.f5877v && this.f5859m != null && this.f5857l != null) {
                requestLayout();
            }
            this.f5877v = false;
        }
    }

    void t() {
        int iJ = this.f5843e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            D dG0 = g0(this.f5843e.i(i3));
            if (!dG0.J()) {
                dG0.c();
            }
        }
        this.f5837b.d();
    }

    void t0() {
        this.f5822K = null;
        this.f5820I = null;
        this.f5821J = null;
        this.f5819H = null;
    }

    void t1(boolean z3) {
        if (this.f5875u < 1) {
            this.f5875u = 1;
        }
        if (!z3 && !this.f5879w) {
            this.f5877v = false;
        }
        if (this.f5875u == 1) {
            if (z3 && this.f5877v && !this.f5879w && this.f5859m != null && this.f5857l != null) {
                C();
            }
            if (!this.f5879w) {
                this.f5877v = false;
            }
        }
        this.f5875u--;
    }

    void u(int i3, int i4) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f5819H;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            zIsFinished = false;
        } else {
            this.f5819H.onRelease();
            zIsFinished = this.f5819H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f5821J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.f5821J.onRelease();
            zIsFinished |= this.f5821J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f5820I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.f5820I.onRelease();
            zIsFinished |= this.f5820I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f5822K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.f5822K.onRelease();
            zIsFinished |= this.f5822K.isFinished();
        }
        if (zIsFinished) {
            Z.h0(this);
        }
    }

    boolean u0() {
        AccessibilityManager accessibilityManager = this.f5812A;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void u1(int i3) {
        getScrollingChildHelper().r(i3);
    }

    void v() {
        if (!this.f5873t || this.f5814C) {
            androidx.core.os.t.a("RV FullInvalidate");
            C();
            androidx.core.os.t.b();
            return;
        }
        if (this.f5841d.p()) {
            if (!this.f5841d.o(4) || this.f5841d.o(11)) {
                if (this.f5841d.p()) {
                    androidx.core.os.t.a("RV FullInvalidate");
                    C();
                    androidx.core.os.t.b();
                    return;
                }
                return;
            }
            androidx.core.os.t.a("RV PartialInvalidate");
            r1();
            H0();
            this.f5841d.s();
            if (!this.f5877v) {
                if (o0()) {
                    C();
                } else {
                    this.f5841d.i();
                }
            }
            t1(true);
            I0();
            androidx.core.os.t.b();
        }
    }

    public boolean v0() {
        return this.f5816E > 0;
    }

    public void v1() {
        setScrollState(0);
        w1();
    }

    void x(int i3, int i4) {
        setMeasuredDimension(o.s(i3, getPaddingLeft() + getPaddingRight(), Z.E(this)), o.s(i4, getPaddingTop() + getPaddingBottom(), Z.D(this)));
    }

    void x0(int i3) {
        if (this.f5859m == null) {
            return;
        }
        setScrollState(2);
        this.f5859m.B1(i3);
        awakenScrollBars();
    }

    void x1(int i3, int i4, Object obj) {
        int i5;
        int iJ = this.f5843e.j();
        int i6 = i3 + i4;
        for (int i7 = 0; i7 < iJ; i7++) {
            View viewI = this.f5843e.i(i7);
            D dG0 = g0(viewI);
            if (dG0 != null && !dG0.J() && (i5 = dG0.f5910c) >= i3 && i5 < i6) {
                dG0.b(2);
                dG0.a(obj);
                ((p) viewI.getLayoutParams()).f5970c = true;
            }
        }
        this.f5837b.M(i3, i4);
    }

    void y0() {
        int iJ = this.f5843e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ((p) this.f5843e.i(i3).getLayoutParams()).f5970c = true;
        }
        this.f5837b.s();
    }

    void z(View view) {
        D dG0 = g0(view);
        F0(view);
        g gVar = this.f5857l;
        if (gVar != null && dG0 != null) {
            gVar.q(dG0);
        }
        List list = this.f5813B;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.f5813B.get(size)).a(view);
            }
        }
    }

    void z0() {
        int iJ = this.f5843e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            D dG0 = g0(this.f5843e.i(i3));
            if (dG0 != null && !dG0.J()) {
                dG0.b(6);
            }
        }
        y0();
        this.f5837b.t();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, V.a.f2043a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f5835a = new x();
        this.f5837b = new v();
        this.f5845f = new androidx.recyclerview.widget.r();
        this.f5849h = new RunnableC0365a();
        this.f5851i = new Rect();
        this.f5853j = new Rect();
        this.f5855k = new RectF();
        this.f5861n = new ArrayList();
        this.f5863o = new ArrayList();
        this.f5875u = 0;
        this.f5814C = false;
        this.f5815D = false;
        this.f5816E = 0;
        this.f5817F = 0;
        this.f5818G = new k();
        this.f5823L = new c();
        this.f5824M = 0;
        this.f5825N = -1;
        this.f5836a0 = Float.MIN_VALUE;
        this.f5838b0 = Float.MIN_VALUE;
        boolean z3 = true;
        this.f5840c0 = true;
        this.f5842d0 = new C();
        this.f5846f0 = f5803A0 ? new androidx.recyclerview.widget.f.b() : null;
        this.f5848g0 = new A();
        this.f5854j0 = false;
        this.f5856k0 = false;
        this.f5858l0 = new m();
        this.f5860m0 = false;
        this.f5864o0 = new int[2];
        this.f5868q0 = new int[2];
        this.f5870r0 = new int[2];
        this.f5872s0 = new int[2];
        this.f5874t0 = new ArrayList();
        this.f5876u0 = new RunnableC0366b();
        this.f5878v0 = new C0368d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5831T = viewConfiguration.getScaledTouchSlop();
        this.f5836a0 = AbstractC0289d0.f(viewConfiguration, context);
        this.f5838b0 = AbstractC0289d0.j(viewConfiguration, context);
        this.f5833V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5834W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f5823L.v(this.f5858l0);
        p0();
        r0();
        q0();
        if (Z.A(this) == 0) {
            Z.z0(this, 1);
        }
        this.f5812A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.m(this));
        int[] iArr = V.c.f2052f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(V.c.f2061o);
        if (typedArrayObtainStyledAttributes.getInt(V.c.f2055i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f5847g = typedArrayObtainStyledAttributes.getBoolean(V.c.f2054h, true);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(V.c.f2056j, false);
        this.f5871s = z4;
        if (z4) {
            s0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(V.c.f2059m), typedArrayObtainStyledAttributes.getDrawable(V.c.f2060n), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(V.c.f2057k), typedArrayObtainStyledAttributes.getDrawable(V.c.f2058l));
        }
        typedArrayObtainStyledAttributes.recycle();
        w(context, string, attributeSet, i3, 0);
        if (i4 >= 21) {
            int[] iArr2 = f5808w0;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i3, 0);
            if (i4 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i3, 0);
            }
            z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z3);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        D f5968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f5969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f5970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5971d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5969b = new Rect();
            this.f5970c = true;
            this.f5971d = false;
        }

        public int a() {
            return this.f5968a.m();
        }

        public boolean b() {
            return this.f5968a.y();
        }

        public boolean c() {
            return this.f5968a.v();
        }

        public boolean d() {
            return this.f5968a.t();
        }

        public p(int i3, int i4) {
            super(i3, i4);
            this.f5969b = new Rect();
            this.f5970c = true;
            this.f5971d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5969b = new Rect();
            this.f5970c = true;
            this.f5971d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5969b = new Rect();
            this.f5970c = true;
            this.f5971d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f5969b = new Rect();
            this.f5970c = true;
            this.f5971d = false;
        }
    }

    public static class y extends F.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f5987c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public y[] newArray(int i3) {
                return new y[i3];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5987c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void d(y yVar) {
            this.f5987c = yVar.f5987c;
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f5987c, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f5859m;
        if (oVar != null) {
            return oVar.K(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }
}
