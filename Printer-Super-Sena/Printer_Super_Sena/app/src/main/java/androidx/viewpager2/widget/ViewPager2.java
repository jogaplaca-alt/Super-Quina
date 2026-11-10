package androidx.viewpager2.widget;

import A.T;
import A.Y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.Z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static boolean f6832u = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f6833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f6834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.viewpager2.widget.b f6835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f6837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecyclerView.i f6838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayoutManager f6839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Parcelable f6841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    RecyclerView f6842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private androidx.recyclerview.widget.k f6843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    androidx.viewpager2.widget.e f6844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.viewpager2.widget.b f6845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private androidx.viewpager2.widget.c f6846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private androidx.viewpager2.widget.d f6847o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RecyclerView.l f6848p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6849q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f6850r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f6851s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    e f6852t;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f6837e = true;
            viewPager2.f6844l.l();
        }
    }

    class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i3) {
            if (i3 == 0) {
                ViewPager2.this.o();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i3) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f6836d != i3) {
                viewPager2.f6836d = i3;
                viewPager2.f6852t.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i3) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f6842j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.q {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width != -1 || ((ViewGroup.MarginLayoutParams) pVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i3) {
            return false;
        }

        boolean c(int i3, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.g gVar) {
        }

        void f(RecyclerView.g gVar) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        boolean k(int i3) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i3, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }

        void j(T t3) {
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i3) {
            return (i3 == 8192 || i3 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(T t3) {
            if (ViewPager2.this.e()) {
                return;
            }
            t3.e0(T.a.f39r);
            t3.e0(T.a.f38q);
            t3.F0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i3) {
            if (b(i3)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.i {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void Q1(RecyclerView.A a3, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.Q1(a3, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void R0(RecyclerView.v vVar, RecyclerView.A a3, T t3) {
            super.R0(vVar, a3, t3);
            ViewPager2.this.f6852t.j(t3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean l1(RecyclerView.v vVar, RecyclerView.A a3, int i3, Bundle bundle) {
            return ViewPager2.this.f6852t.b(i3) ? ViewPager2.this.f6852t.k(i3) : super.l1(vVar, a3, i3, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean w1(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
            return false;
        }
    }

    public static abstract class i {
        public void a(int i3) {
        }

        public void b(int i3, float f3, int i4) {
        }

        public void c(int i3) {
        }
    }

    class j extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Y f6860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Y f6861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RecyclerView.i f6862d;

        class a implements Y {
            a() {
            }

            @Override // A.Y
            public boolean a(View view, Y.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements Y {
            b() {
            }

            @Override // A.Y
            public boolean a(View view, Y.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
            this.f6860b = new a();
            this.f6861c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iE;
            int iE2;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    iE = ViewPager2.this.getAdapter().e();
                } else {
                    iE2 = ViewPager2.this.getAdapter().e();
                    iE = 0;
                }
                T.P0(accessibilityNodeInfo).o0(T.e.b(iE, iE2, false, 0));
            }
            iE = 0;
            iE2 = 0;
            T.P0(accessibilityNodeInfo).o0(T.e.b(iE, iE2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iE;
            RecyclerView.g adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iE = adapter.e()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f6836d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f6836d < iE - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i3, Bundle bundle) {
            return i3 == 8192 || i3 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.g gVar) {
            w();
            if (gVar != null) {
                gVar.t(this.f6862d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.g gVar) {
            if (gVar != null) {
                gVar.v(this.f6862d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            Z.z0(recyclerView, 2);
            this.f6862d = new c();
            if (Z.A(ViewPager2.this) == 0) {
                Z.z0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i3, Bundle bundle) {
            if (!c(i3, bundle)) {
                throw new IllegalStateException();
            }
            v(i3 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        void v(int i3) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i3, true);
            }
        }

        void w() {
            int iE;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i3 = R.id.accessibilityActionPageLeft;
            Z.k0(viewPager2, R.id.accessibilityActionPageLeft);
            Z.k0(viewPager2, R.id.accessibilityActionPageRight);
            Z.k0(viewPager2, R.id.accessibilityActionPageUp);
            Z.k0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iE = ViewPager2.this.getAdapter().e()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f6836d < iE - 1) {
                    Z.m0(viewPager2, new T.a(R.id.accessibilityActionPageDown, null), null, this.f6860b);
                }
                if (ViewPager2.this.f6836d > 0) {
                    Z.m0(viewPager2, new T.a(R.id.accessibilityActionPageUp, null), null, this.f6861c);
                    return;
                }
                return;
            }
            boolean zD = ViewPager2.this.d();
            int i4 = zD ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zD) {
                i3 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f6836d < iE - 1) {
                Z.m0(viewPager2, new T.a(i4, null), null, this.f6860b);
            }
            if (ViewPager2.this.f6836d > 0) {
                Z.m0(viewPager2, new T.a(i3, null), null, this.f6861c);
            }
        }
    }

    public interface k {
    }

    private class l extends androidx.recyclerview.widget.k {
        l() {
        }

        @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.p
        public View g(RecyclerView.o oVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.g(oVar);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f6852t.d() ? ViewPager2.this.f6852t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f6836d);
            accessibilityEvent.setToIndex(ViewPager2.this.f6836d);
            ViewPager2.this.f6852t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f6873b;

        o(int i3, RecyclerView recyclerView) {
            this.f6872a = i3;
            this.f6873b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6873b.q1(this.f6872a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6833a = new Rect();
        this.f6834b = new Rect();
        this.f6835c = new androidx.viewpager2.widget.b(3);
        this.f6837e = false;
        this.f6838f = new a();
        this.f6840h = -1;
        this.f6848p = null;
        this.f6849q = false;
        this.f6850r = true;
        this.f6851s = -1;
        b(context, attributeSet);
    }

    private RecyclerView.q a() {
        return new d();
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f6852t = f6832u ? new j() : new f();
        m mVar = new m(context);
        this.f6842j = mVar;
        mVar.setId(Z.m());
        this.f6842j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f6839g = hVar;
        this.f6842j.setLayoutManager(hVar);
        this.f6842j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f6842j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f6842j.j(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f6844l = eVar;
        this.f6846n = new androidx.viewpager2.widget.c(this, eVar, this.f6842j);
        l lVar = new l();
        this.f6843k = lVar;
        lVar.b(this.f6842j);
        this.f6842j.l(this.f6844l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f6845m = bVar;
        this.f6844l.o(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f6845m.d(bVar2);
        this.f6845m.d(cVar);
        this.f6852t.h(this.f6845m, this.f6842j);
        this.f6845m.d(this.f6835c);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f6839g);
        this.f6847o = dVar;
        this.f6845m.d(dVar);
        RecyclerView recyclerView = this.f6842j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.g gVar) {
        if (gVar != null) {
            gVar.t(this.f6838f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        RecyclerView.g adapter;
        if (this.f6840h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f6841i;
        if (parcelable != null) {
            if (adapter instanceof p035j0.c) {
                ((p035j0.c) adapter).b(parcelable);
            }
            this.f6841i = null;
        }
        int iMax = Math.max(0, Math.min(this.f6840h, adapter.e() - 1));
        this.f6836d = iMax;
        this.f6840h = -1;
        this.f6842j.i1(iMax);
        this.f6852t.m();
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = p032i0.a.f9645g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(p032i0.a.f9646h, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.g gVar) {
        if (gVar != null) {
            gVar.v(this.f6838f);
        }
    }

    public boolean c() {
        return this.f6846n.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        return this.f6842j.canScrollHorizontally(i3);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.f6842j.canScrollVertically(i3);
    }

    boolean d() {
        return this.f6839g.d0() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof n) {
            int i3 = ((n) parcelable).f6869a;
            sparseArray.put(this.f6842j.getId(), sparseArray.get(i3));
            sparseArray.remove(i3);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f6850r;
    }

    public void g(i iVar) {
        this.f6835c.d(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f6852t.a() ? this.f6852t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.g getAdapter() {
        return this.f6842j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f6836d;
    }

    public int getItemDecorationCount() {
        return this.f6842j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f6851s;
    }

    public int getOrientation() {
        return this.f6839g.t2();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f6842j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f6844l.h();
    }

    public void h() {
        this.f6847o.d();
    }

    public void j(int i3, boolean z3) {
        if (c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        k(i3, z3);
    }

    void k(int i3, boolean z3) {
        RecyclerView.g adapter = getAdapter();
        if (adapter == null) {
            if (this.f6840h != -1) {
                this.f6840h = Math.max(i3, 0);
                return;
            }
            return;
        }
        if (adapter.e() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i3, 0), adapter.e() - 1);
        if (iMin == this.f6836d && this.f6844l.j()) {
            return;
        }
        int i4 = this.f6836d;
        if (iMin == i4 && z3) {
            return;
        }
        double dG = i4;
        this.f6836d = iMin;
        this.f6852t.q();
        if (!this.f6844l.j()) {
            dG = this.f6844l.g();
        }
        this.f6844l.m(iMin, z3);
        if (!z3) {
            this.f6842j.i1(iMin);
            return;
        }
        double d3 = iMin;
        Double.isNaN(d3);
        if (Math.abs(d3 - dG) <= 3.0d) {
            this.f6842j.q1(iMin);
            return;
        }
        this.f6842j.i1(d3 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f6842j;
        recyclerView.post(new o(iMin, recyclerView));
    }

    public void n(i iVar) {
        this.f6835c.e(iVar);
    }

    void o() {
        androidx.recyclerview.widget.k kVar = this.f6843k;
        if (kVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewG = kVar.g(this.f6839g);
        if (viewG == null) {
            return;
        }
        int iL0 = this.f6839g.l0(viewG);
        if (iL0 != this.f6836d && getScrollState() == 0) {
            this.f6845m.c(iL0);
        }
        this.f6837e = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f6852t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int measuredWidth = this.f6842j.getMeasuredWidth();
        int measuredHeight = this.f6842j.getMeasuredHeight();
        this.f6833a.left = getPaddingLeft();
        this.f6833a.right = (i5 - i3) - getPaddingRight();
        this.f6833a.top = getPaddingTop();
        this.f6833a.bottom = (i6 - i4) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f6833a, this.f6834b);
        RecyclerView recyclerView = this.f6842j;
        Rect rect = this.f6834b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f6837e) {
            o();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        measureChild(this.f6842j, i3, i4);
        int measuredWidth = this.f6842j.getMeasuredWidth();
        int measuredHeight = this.f6842j.getMeasuredHeight();
        int measuredState = this.f6842j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        this.f6840h = nVar.f6870b;
        this.f6841i = nVar.f6871c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f6869a = this.f6842j.getId();
        int i3 = this.f6840h;
        if (i3 == -1) {
            i3 = this.f6836d;
        }
        nVar.f6870b = i3;
        Parcelable parcelable = this.f6841i;
        if (parcelable != null) {
            nVar.f6871c = parcelable;
        } else {
            Object adapter = this.f6842j.getAdapter();
            if (adapter instanceof p035j0.c) {
                nVar.f6871c = ((p035j0.c) adapter).a();
            }
        }
        return nVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        return this.f6852t.c(i3, bundle) ? this.f6852t.l(i3, bundle) : super.performAccessibilityAction(i3, bundle);
    }

    public void setAdapter(RecyclerView.g gVar) {
        RecyclerView.g adapter = this.f6842j.getAdapter();
        this.f6852t.f(adapter);
        m(adapter);
        this.f6842j.setAdapter(gVar);
        this.f6836d = 0;
        i();
        this.f6852t.e(gVar);
        f(gVar);
    }

    public void setCurrentItem(int i3) {
        j(i3, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        super.setLayoutDirection(i3);
        this.f6852t.p();
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1 && i3 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f6851s = i3;
        this.f6842j.requestLayout();
    }

    public void setOrientation(int i3) {
        this.f6839g.G2(i3);
        this.f6852t.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f6849q) {
                this.f6848p = this.f6842j.getItemAnimator();
                this.f6849q = true;
            }
            this.f6842j.setItemAnimator(null);
        } else if (this.f6849q) {
            this.f6842j.setItemAnimator(this.f6848p);
            this.f6848p = null;
            this.f6849q = false;
        }
        this.f6847o.d();
        if (kVar == null) {
            return;
        }
        this.f6847o.e(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z3) {
        this.f6850r = z3;
        this.f6852t.s();
    }

    static class n extends View.BaseSavedState {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f6871c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new n(parcel, classLoader) : new n(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i3) {
                return new n[i3];
            }
        }

        n(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel, classLoader);
        }

        private void c(Parcel parcel, ClassLoader classLoader) {
            this.f6869a = parcel.readInt();
            this.f6870b = parcel.readInt();
            this.f6871c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f6869a);
            parcel.writeInt(this.f6870b);
            parcel.writeParcelable(this.f6871c, i3);
        }

        n(Parcel parcel) {
            super(parcel);
            c(parcel, null);
        }

        n(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
