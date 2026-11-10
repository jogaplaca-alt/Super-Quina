package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.C;
import androidx.core.view.D;
import androidx.core.view.E;
import androidx.core.view.F;
import androidx.core.view.G;
import androidx.core.view.H;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements F, E, C, G {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final String f6451P = "SwipeRefreshLayout";

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final int[] f6452Q = {R.attr.enabled};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    int f6453A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    int f6454B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.b f6455C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private Animation f6456D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private Animation f6457E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private Animation f6458F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private Animation f6459G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private Animation f6460H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f6461I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f6462J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    boolean f6463K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f6464L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private Animation.AnimationListener f6465M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private final Animation f6466N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private final Animation f6467O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    j f6469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final H f6474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final D f6475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f6476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f6477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f6478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f6481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f6482o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f6483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f6486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6487t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DecelerateInterpolator f6488u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f6489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6490w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f6491x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f6492y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f6493z;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f6470c) {
                swipeRefreshLayout.r();
                return;
            }
            swipeRefreshLayout.f6455C.setAlpha(255);
            SwipeRefreshLayout.this.f6455C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.f6461I && (jVar = swipeRefreshLayout2.f6469b) != null) {
                jVar.f();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f6481n = swipeRefreshLayout3.f6489v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f3);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f3);
        }
    }

    class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6498b;

        d(int i3, int i4) {
            this.f6497a = i3;
            this.f6498b = i4;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            androidx.swiperefreshlayout.widget.b bVar = SwipeRefreshLayout.this.f6455C;
            int i3 = this.f6497a;
            bVar.setAlpha((int) (i3 + ((this.f6498b - i3) * f3)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f6486s) {
                return;
            }
            swipeRefreshLayout.x(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.f6463K ? swipeRefreshLayout.f6453A - Math.abs(swipeRefreshLayout.f6493z) : swipeRefreshLayout.f6453A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i3 = swipeRefreshLayout2.f6491x;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i3 + ((int) ((iAbs - i3) * f3))) - swipeRefreshLayout2.f6489v.getTop());
            SwipeRefreshLayout.this.f6455C.e(1.0f - f3);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout.this.p(f3);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f4 = swipeRefreshLayout.f6492y;
            swipeRefreshLayout.setAnimationProgress(f4 + ((-f4) * f3));
            SwipeRefreshLayout.this.p(f3);
        }
    }

    public interface i {
    }

    public interface j {
        void f();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6470c = false;
        this.f6472e = -1.0f;
        this.f6476i = new int[2];
        this.f6477j = new int[2];
        this.f6478k = new int[2];
        this.f6485r = -1;
        this.f6490w = -1;
        this.f6465M = new a();
        this.f6466N = new f();
        this.f6467O = new g();
        this.f6471d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f6480m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f6488u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f6462J = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i3 = (int) (displayMetrics.density * 64.0f);
        this.f6453A = i3;
        this.f6472e = i3;
        this.f6474g = new H(this);
        this.f6475h = new D(this);
        setNestedScrollingEnabled(true);
        int i4 = -this.f6462J;
        this.f6481n = i4;
        this.f6493z = i4;
        p(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6452Q);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(int i3, Animation.AnimationListener animationListener) {
        this.f6491x = i3;
        this.f6466N.reset();
        this.f6466N.setDuration(200L);
        this.f6466N.setInterpolator(this.f6488u);
        if (animationListener != null) {
            this.f6489v.b(animationListener);
        }
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(this.f6466N);
    }

    private void b(int i3, Animation.AnimationListener animationListener) {
        if (this.f6486s) {
            y(i3, animationListener);
            return;
        }
        this.f6491x = i3;
        this.f6467O.reset();
        this.f6467O.setDuration(200L);
        this.f6467O.setInterpolator(this.f6488u);
        if (animationListener != null) {
            this.f6489v.b(animationListener);
        }
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(this.f6467O);
    }

    private void d() {
        this.f6489v = new androidx.swiperefreshlayout.widget.a(getContext());
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.f6455C = bVar;
        bVar.l(1);
        this.f6489v.setImageDrawable(this.f6455C);
        this.f6489v.setVisibility(8);
        addView(this.f6489v);
    }

    private void f() {
        if (this.f6468a == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.f6489v)) {
                    this.f6468a = childAt;
                    return;
                }
            }
        }
    }

    private void g(float f3) {
        if (f3 > this.f6472e) {
            s(true, true);
            return;
        }
        this.f6470c = false;
        this.f6455C.j(0.0f, 0.0f);
        b(this.f6481n, !this.f6486s ? new e() : null);
        this.f6455C.d(false);
    }

    private boolean k(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void l(float f3) {
        this.f6455C.d(true);
        float fMin = Math.min(1.0f, Math.abs(f3 / this.f6472e));
        double d3 = fMin;
        Double.isNaN(d3);
        float fMax = (((float) Math.max(d3 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f3) - this.f6472e;
        int i3 = this.f6454B;
        if (i3 <= 0) {
            i3 = this.f6463K ? this.f6453A - this.f6493z : this.f6453A;
        }
        float f4 = i3;
        double dMax = Math.max(0.0f, Math.min(fAbs, f4 * 2.0f) / f4) / 4.0f;
        double dPow = Math.pow(dMax, 2.0d);
        Double.isNaN(dMax);
        float f5 = ((float) (dMax - dPow)) * 2.0f;
        int i4 = this.f6493z + ((int) ((f4 * fMin) + (f4 * f5 * 2.0f)));
        if (this.f6489v.getVisibility() != 0) {
            this.f6489v.setVisibility(0);
        }
        if (!this.f6486s) {
            this.f6489v.setScaleX(1.0f);
            this.f6489v.setScaleY(1.0f);
        }
        if (this.f6486s) {
            setAnimationProgress(Math.min(1.0f, f3 / this.f6472e));
        }
        if (f3 < this.f6472e) {
            if (this.f6455C.getAlpha() > 76 && !k(this.f6458F)) {
                w();
            }
        } else if (this.f6455C.getAlpha() < 255 && !k(this.f6459G)) {
            v();
        }
        this.f6455C.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.f6455C.e(Math.min(1.0f, fMax));
        this.f6455C.g((((fMax * 0.4f) - 0.25f) + (f5 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i4 - this.f6481n);
    }

    private void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f6485r) {
            this.f6485r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void s(boolean z3, boolean z4) {
        if (this.f6470c != z3) {
            this.f6461I = z4;
            f();
            this.f6470c = z3;
            if (z3) {
                a(this.f6481n, this.f6465M);
            } else {
                x(this.f6465M);
            }
        }
    }

    private void setColorViewAlpha(int i3) {
        this.f6489v.getBackground().setAlpha(i3);
        this.f6455C.setAlpha(i3);
    }

    private Animation t(int i3, int i4) {
        d dVar = new d(i3, i4);
        dVar.setDuration(300L);
        this.f6489v.b(null);
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(dVar);
        return dVar;
    }

    private void u(float f3) {
        float f4 = this.f6483p;
        float f5 = f3 - f4;
        int i3 = this.f6471d;
        if (f5 <= i3 || this.f6484q) {
            return;
        }
        this.f6482o = f4 + i3;
        this.f6484q = true;
        this.f6455C.setAlpha(76);
    }

    private void v() {
        this.f6459G = t(this.f6455C.getAlpha(), 255);
    }

    private void w() {
        this.f6458F = t(this.f6455C.getAlpha(), 76);
    }

    private void y(int i3, Animation.AnimationListener animationListener) {
        this.f6491x = i3;
        this.f6492y = this.f6489v.getScaleX();
        h hVar = new h();
        this.f6460H = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f6489v.b(animationListener);
        }
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(this.f6460H);
    }

    private void z(Animation.AnimationListener animationListener) {
        this.f6489v.setVisibility(0);
        this.f6455C.setAlpha(255);
        b bVar = new b();
        this.f6456D = bVar;
        bVar.setDuration(this.f6480m);
        if (animationListener != null) {
            this.f6489v.b(animationListener);
        }
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(this.f6456D);
    }

    public boolean c() {
        View view = this.f6468a;
        return view instanceof ListView ? androidx.core.widget.g.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return this.f6475h.a(f3, f4, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f6475h.b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return this.f6475h.c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f6475h.f(i3, i4, i5, i6, iArr);
    }

    public void e(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        if (i7 == 0) {
            this.f6475h.e(i3, i4, i5, i6, iArr, i7, iArr2);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        int i5 = this.f6490w;
        if (i5 < 0) {
            return i4;
        }
        if (i4 == i3 - 1) {
            return i5;
        }
        return i4 >= i5 ? i4 + 1 : i4;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f6474g.a();
    }

    public int getProgressCircleDiameter() {
        return this.f6462J;
    }

    public int getProgressViewEndOffset() {
        return this.f6453A;
    }

    public int getProgressViewStartOffset() {
        return this.f6493z;
    }

    @Override // androidx.core.view.E
    public void h(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f6475h.j();
    }

    @Override // androidx.core.view.E
    public void i(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View, androidx.core.view.C
    public boolean isNestedScrollingEnabled() {
        return this.f6475h.l();
    }

    @Override // androidx.core.view.E
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i3, i4, iArr);
        }
    }

    @Override // androidx.core.view.F
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i7 != 0) {
            return;
        }
        int i8 = iArr[1];
        e(i3, i4, i5, i6, this.f6477j, i7, iArr);
        int i9 = i6 - (iArr[1] - i8);
        int i10 = i9 == 0 ? i6 + this.f6477j[1] : i9;
        if (i10 >= 0 || c()) {
            return;
        }
        float fAbs = this.f6473f + Math.abs(i10);
        this.f6473f = fAbs;
        l(fAbs);
        iArr[1] = iArr[1] + i9;
    }

    @Override // androidx.core.view.E
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        m(view, i3, i4, i5, i6, i7, this.f6478k);
    }

    @Override // androidx.core.view.E
    public boolean o(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            return onStartNestedScroll(view, view2, i3);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6487t && actionMasked == 0) {
            this.f6487t = false;
        }
        if (!isEnabled() || this.f6487t || c() || this.f6470c || this.f6479l) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.f6493z - this.f6489v.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f6485r = pointerId;
            this.f6484q = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.f6483p = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.f6484q = false;
            this.f6485r = -1;
        } else if (actionMasked == 2) {
            int i3 = this.f6485r;
            if (i3 == -1) {
                Log.e(f6451P, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i3);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            u(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.f6484q = false;
            this.f6485r = -1;
        } else if (actionMasked == 6) {
            q(motionEvent);
        }
        return this.f6484q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f6468a == null) {
            f();
        }
        View view = this.f6468a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f6489v.getMeasuredWidth();
        int measuredHeight2 = this.f6489v.getMeasuredHeight();
        int i7 = measuredWidth / 2;
        int i8 = measuredWidth2 / 2;
        int i9 = this.f6481n;
        this.f6489v.layout(i7 - i8, i9, i7 + i8, measuredHeight2 + i9);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f6468a == null) {
            f();
        }
        View view = this.f6468a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f6489v.measure(View.MeasureSpec.makeMeasureSpec(this.f6462J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f6462J, 1073741824));
        this.f6490w = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == this.f6489v) {
                this.f6490w = i5;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        return dispatchNestedFling(f3, f4, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return dispatchNestedPreFling(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        if (i4 > 0) {
            float f3 = this.f6473f;
            if (f3 > 0.0f) {
                float f4 = i4;
                if (f4 > f3) {
                    iArr[1] = (int) f3;
                    this.f6473f = 0.0f;
                } else {
                    this.f6473f = f3 - f4;
                    iArr[1] = i4;
                }
                l(this.f6473f);
            }
        }
        if (this.f6463K && i4 > 0 && this.f6473f == 0.0f && Math.abs(i4 - iArr[1]) > 0) {
            this.f6489v.setVisibility(8);
        }
        int[] iArr2 = this.f6476i;
        if (dispatchNestedPreScroll(i3 - iArr[0], i4 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        m(view, i3, i4, i5, i6, 0, this.f6478k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f6474g.b(view, view2, i3);
        startNestedScroll(i3 & 2);
        this.f6473f = 0.0f;
        this.f6479l = true;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f6504a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.f6470c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return (!isEnabled() || this.f6487t || this.f6470c || (i3 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onStopNestedScroll(View view) {
        this.f6474g.d(view);
        this.f6479l = false;
        float f3 = this.f6473f;
        if (f3 > 0.0f) {
            g(f3);
            this.f6473f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6487t && actionMasked == 0) {
            this.f6487t = false;
        }
        if (!isEnabled() || this.f6487t || c() || this.f6470c || this.f6479l) {
            return false;
        }
        if (actionMasked == 0) {
            this.f6485r = motionEvent.getPointerId(0);
            this.f6484q = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f6485r);
                if (iFindPointerIndex < 0) {
                    Log.e(f6451P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f6484q) {
                    float y3 = (motionEvent.getY(iFindPointerIndex) - this.f6482o) * 0.5f;
                    this.f6484q = false;
                    g(y3);
                }
                this.f6485r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f6485r);
                if (iFindPointerIndex2 < 0) {
                    Log.e(f6451P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y4 = motionEvent.getY(iFindPointerIndex2);
                u(y4);
                if (this.f6484q) {
                    float f3 = (y4 - this.f6482o) * 0.5f;
                    if (f3 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    l(f3);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(f6451P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f6485r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    q(motionEvent);
                }
            }
        }
        return true;
    }

    void p(float f3) {
        int i3 = this.f6491x;
        setTargetOffsetTopAndBottom((i3 + ((int) ((this.f6493z - i3) * f3))) - this.f6489v.getTop());
    }

    void r() {
        this.f6489v.clearAnimation();
        this.f6455C.stop();
        this.f6489v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f6486s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f6493z - this.f6481n);
        }
        this.f6481n = this.f6489v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        View view;
        ViewParent parent;
        if ((Build.VERSION.SDK_INT >= 21 || !(this.f6468a instanceof AbsListView)) && ((view = this.f6468a) == null || Z.V(view))) {
            super.requestDisallowInterceptTouchEvent(z3);
        } else {
            if (this.f6464L || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z3);
        }
    }

    void setAnimationProgress(float f3) {
        this.f6489v.setScaleX(f3);
        this.f6489v.setScaleY(f3);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.f6455C.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = androidx.core.content.a.b(context, iArr[i3]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i3) {
        this.f6472e = i3;
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        if (z3) {
            return;
        }
        r();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z3) {
        this.f6464L = z3;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        this.f6475h.m(z3);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f6469b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i3) {
        setProgressBackgroundColorSchemeResource(i3);
    }

    public void setProgressBackgroundColorSchemeColor(int i3) {
        this.f6489v.setBackgroundColor(i3);
    }

    public void setProgressBackgroundColorSchemeResource(int i3) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.b(getContext(), i3));
    }

    public void setRefreshing(boolean z3) {
        if (!z3 || this.f6470c == z3) {
            s(z3, false);
            return;
        }
        this.f6470c = z3;
        setTargetOffsetTopAndBottom((!this.f6463K ? this.f6453A + this.f6493z : this.f6453A) - this.f6481n);
        this.f6461I = false;
        z(this.f6465M);
    }

    public void setSize(int i3) {
        if (i3 == 0 || i3 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i3 == 0) {
                this.f6462J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f6462J = (int) (displayMetrics.density * 40.0f);
            }
            this.f6489v.setImageDrawable(null);
            this.f6455C.l(i3);
            this.f6489v.setImageDrawable(this.f6455C);
        }
    }

    public void setSlingshotDistance(int i3) {
        this.f6454B = i3;
    }

    void setTargetOffsetTopAndBottom(int i3) {
        this.f6489v.bringToFront();
        Z.b0(this.f6489v, i3);
        this.f6481n = this.f6489v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return this.f6475h.o(i3);
    }

    @Override // android.view.View, androidx.core.view.C
    public void stopNestedScroll() {
        this.f6475h.q();
    }

    void x(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.f6457E = cVar;
        cVar.setDuration(150L);
        this.f6489v.b(animationListener);
        this.f6489v.clearAnimation();
        this.f6489v.startAnimation(this.f6457E);
    }

    static class k extends View.BaseSavedState {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f6504a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i3) {
                return new k[i3];
            }
        }

        k(Parcelable parcelable, boolean z3) {
            super(parcelable);
            this.f6504a = z3;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f6504a ? (byte) 1 : (byte) 0);
        }

        k(Parcel parcel) {
            super(parcel);
            this.f6504a = parcel.readByte() != 0;
        }
    }
}
