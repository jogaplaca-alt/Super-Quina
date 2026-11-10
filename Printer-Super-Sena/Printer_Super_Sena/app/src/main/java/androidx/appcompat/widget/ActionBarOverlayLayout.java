package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.core.view.C0332z0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements L, androidx.core.view.G, androidx.core.view.E, androidx.core.view.F {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    static final int[] f3003F = {p012d.a.f9084b, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    ViewPropertyAnimator f3004A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final AnimatorListenerAdapter f3005B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final Runnable f3006C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final Runnable f3007D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private final androidx.core.view.H f3008E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f3011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarContainer f3012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private M f3013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f3014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f3019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f3022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f3023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f3024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f3025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f3026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f3027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f3028t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private C0332z0 f3029u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private C0332z0 f3030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private C0332z0 f3031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private C0332z0 f3032x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private d f3033y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private OverScroller f3034z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3004A = null;
            actionBarOverlayLayout.f3019k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3004A = null;
            actionBarOverlayLayout.f3019k = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3004A = actionBarOverlayLayout.f3012d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f3005B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3004A = actionBarOverlayLayout.f3012d.animate().translationY(-ActionBarOverlayLayout.this.f3012d.getHeight()).setListener(ActionBarOverlayLayout.this.f3005B);
        }
    }

    public interface d {
        void a(boolean z3);

        void b();

        void c();

        void d(int i3);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i3, int i4) {
            super(i3, i4);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3010b = 0;
        this.f3022n = new Rect();
        this.f3023o = new Rect();
        this.f3024p = new Rect();
        this.f3025q = new Rect();
        this.f3026r = new Rect();
        this.f3027s = new Rect();
        this.f3028t = new Rect();
        C0332z0 c0332z0 = C0332z0.f4720b;
        this.f3029u = c0332z0;
        this.f3030v = c0332z0;
        this.f3031w = c0332z0;
        this.f3032x = c0332z0;
        this.f3005B = new a();
        this.f3006C = new b();
        this.f3007D = new c();
        v(context);
        this.f3008E = new androidx.core.view.H(this);
    }

    private void A() {
        u();
        this.f3006C.run();
    }

    private boolean B(float f3) {
        this.f3034z.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f3034z.getFinalY() > this.f3012d.getHeight();
    }

    private void p() {
        u();
        this.f3007D.run();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private boolean q(View view, Rect rect, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        e eVar = (e) view.getLayoutParams();
        if (z3) {
            int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i4 = rect.left;
            if (i3 != i4) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i4;
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        if (z4) {
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
            int i6 = rect.top;
            if (i5 != i6) {
                ((ViewGroup.MarginLayoutParams) eVar).topMargin = i6;
                z7 = true;
            }
        }
        if (z6) {
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
            int i8 = rect.right;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i8;
                z7 = true;
            }
        }
        if (z5) {
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i10 = rect.bottom;
            if (i9 != i10) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i10;
                return true;
            }
        }
        return z7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private M t(View view) {
        if (view instanceof M) {
            return (M) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3003F);
        this.f3009a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f3014f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f3015g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3034z = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.f3007D, 600L);
    }

    private void y() {
        u();
        postDelayed(this.f3006C, 600L);
    }

    @Override // androidx.appcompat.widget.L
    public void a(Menu menu, androidx.appcompat.view.menu.m.a aVar) {
        z();
        this.f3013e.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.L
    public boolean b() {
        z();
        return this.f3013e.b();
    }

    @Override // androidx.appcompat.widget.L
    public boolean c() {
        z();
        return this.f3013e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.L
    public boolean d() {
        z();
        return this.f3013e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3014f == null || this.f3015g) {
            return;
        }
        int bottom = this.f3012d.getVisibility() == 0 ? (int) (this.f3012d.getBottom() + this.f3012d.getTranslationY() + 0.5f) : 0;
        this.f3014f.setBounds(0, bottom, getWidth(), this.f3014f.getIntrinsicHeight() + bottom);
        this.f3014f.draw(canvas);
    }

    @Override // androidx.appcompat.widget.L
    public boolean e() {
        z();
        return this.f3013e.e();
    }

    @Override // androidx.appcompat.widget.L
    public void f() {
        z();
        this.f3013e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean zQ = q(this.f3012d, rect, true, true, false, true);
        this.f3025q.set(rect);
        u0.a(this, this.f3025q, this.f3022n);
        if (!this.f3026r.equals(this.f3025q)) {
            this.f3026r.set(this.f3025q);
            zQ = true;
        }
        if (!this.f3023o.equals(this.f3022n)) {
            this.f3023o.set(this.f3022n);
            zQ = true;
        }
        if (zQ) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.L
    public boolean g() {
        z();
        return this.f3013e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f3012d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3008E.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f3013e.getTitle();
    }

    @Override // androidx.core.view.E
    public void h(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // androidx.core.view.E
    public void i(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.E
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i3, i4, iArr);
        }
    }

    @Override // androidx.appcompat.widget.L
    public void k(int i3) {
        z();
        if (i3 == 2) {
            this.f3013e.t();
        } else if (i3 == 5) {
            this.f3013e.v();
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.L
    public void l() {
        z();
        this.f3013e.h();
    }

    @Override // androidx.core.view.F
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        n(view, i3, i4, i5, i6, i7);
    }

    @Override // androidx.core.view.E
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i3, i4, i5, i6);
        }
    }

    @Override // androidx.core.view.E
    public boolean o(View view, View view2, int i3, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i3);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        C0332z0 c0332z0Y = C0332z0.y(windowInsets, this);
        boolean zQ = q(this.f3012d, new Rect(c0332z0Y.j(), c0332z0Y.l(), c0332z0Y.k(), c0332z0Y.i()), true, true, false, true);
        androidx.core.view.Z.h(this, c0332z0Y, this.f3022n);
        Rect rect = this.f3022n;
        C0332z0 c0332z0O = c0332z0Y.o(rect.left, rect.top, rect.right, rect.bottom);
        this.f3029u = c0332z0O;
        boolean z3 = true;
        if (!this.f3030v.equals(c0332z0O)) {
            this.f3030v = this.f3029u;
            zQ = true;
        }
        if (this.f3023o.equals(this.f3022n)) {
            z3 = zQ;
        } else {
            this.f3023o.set(this.f3022n);
        }
        if (z3) {
            requestLayout();
        }
        return c0332z0Y.a().c().b().w();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        androidx.core.view.Z.n0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f3012d, i3, 0, i4, 0);
        e eVar = (e) this.f3012d.getLayoutParams();
        int iMax = Math.max(0, this.f3012d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f3012d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3012d.getMeasuredState());
        boolean z3 = (androidx.core.view.Z.N(this) & 256) != 0;
        if (z3) {
            measuredHeight = this.f3009a;
            if (this.f3017i && this.f3012d.getTabContainer() != null) {
                measuredHeight += this.f3009a;
            }
        } else {
            measuredHeight = this.f3012d.getVisibility() != 8 ? this.f3012d.getMeasuredHeight() : 0;
        }
        this.f3024p.set(this.f3022n);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            this.f3031w = this.f3029u;
        } else {
            this.f3027s.set(this.f3025q);
        }
        if (!this.f3016h && !z3) {
            Rect rect = this.f3024p;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            if (i5 >= 21) {
                this.f3031w = this.f3031w.o(0, measuredHeight, 0, 0);
            }
        } else if (i5 >= 21) {
            this.f3031w = new C0332z0.b(this.f3031w).d(androidx.core.graphics.e.b(this.f3031w.j(), this.f3031w.l() + measuredHeight, this.f3031w.k(), this.f3031w.i())).a();
        } else {
            Rect rect2 = this.f3027s;
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
        }
        q(this.f3011c, this.f3024p, true, true, true, true);
        if (i5 >= 21 && !this.f3032x.equals(this.f3031w)) {
            C0332z0 c0332z0 = this.f3031w;
            this.f3032x = c0332z0;
            androidx.core.view.Z.i(this.f3011c, c0332z0);
        } else if (i5 < 21 && !this.f3028t.equals(this.f3027s)) {
            this.f3028t.set(this.f3027s);
            this.f3011c.a(this.f3027s);
        }
        measureChildWithMargins(this.f3011c, i3, 0, i4, 0);
        e eVar2 = (e) this.f3011c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f3011c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f3011c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3011c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (!this.f3018j || !z3) {
            return false;
        }
        if (B(f4)) {
            p();
        } else {
            A();
        }
        this.f3019k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        int i7 = this.f3020l + i4;
        this.f3020l = i7;
        setActionBarHideOffset(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f3008E.b(view, view2, i3);
        this.f3020l = getActionBarHideOffset();
        u();
        d dVar = this.f3033y;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f3012d.getVisibility() != 0) {
            return false;
        }
        return this.f3018j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.G
    public void onStopNestedScroll(View view) {
        if (this.f3018j && !this.f3019k) {
            if (this.f3020l <= this.f3012d.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f3033y;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
        z();
        int i4 = this.f3021m ^ i3;
        this.f3021m = i3;
        boolean z3 = (i3 & 4) == 0;
        boolean z4 = (i3 & 256) != 0;
        d dVar = this.f3033y;
        if (dVar != null) {
            dVar.a(!z4);
            if (z3 || !z4) {
                this.f3033y.b();
            } else {
                this.f3033y.e();
            }
        }
        if ((i4 & 256) == 0 || this.f3033y == null) {
            return;
        }
        androidx.core.view.Z.n0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f3010b = i3;
        d dVar = this.f3033y;
        if (dVar != null) {
            dVar.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i3) {
        u();
        this.f3012d.setTranslationY(-Math.max(0, Math.min(i3, this.f3012d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f3033y = dVar;
        if (getWindowToken() != null) {
            this.f3033y.d(this.f3010b);
            int i3 = this.f3021m;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                androidx.core.view.Z.n0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z3) {
        this.f3017i = z3;
    }

    public void setHideOnContentScrollEnabled(boolean z3) {
        if (z3 != this.f3018j) {
            this.f3018j = z3;
            if (z3) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        z();
        this.f3013e.setIcon(i3);
    }

    public void setLogo(int i3) {
        z();
        this.f3013e.m(i3);
    }

    public void setOverlayMode(boolean z3) {
        this.f3016h = z3;
        this.f3015g = z3 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z3) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f3013e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f3013e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.f3006C);
        removeCallbacks(this.f3007D);
        ViewPropertyAnimator viewPropertyAnimator = this.f3004A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f3016h;
    }

    void z() {
        if (this.f3011c == null) {
            this.f3011c = (ContentFrameLayout) findViewById(p012d.f.f9193b);
            this.f3012d = (ActionBarContainer) findViewById(p012d.f.f9194c);
            this.f3013e = t(findViewById(p012d.f.f9192a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f3013e.setIcon(drawable);
    }
}
