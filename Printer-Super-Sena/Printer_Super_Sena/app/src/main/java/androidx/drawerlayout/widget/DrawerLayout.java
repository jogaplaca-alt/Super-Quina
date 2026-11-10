package androidx.drawerlayout.widget;

import A.T;
import A.Y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.m0;
import androidx.core.view.C0282a;
import androidx.core.view.C0332z0;
import androidx.core.view.I;
import androidx.core.view.Z;
import androidx.core.view.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f4861N = {R.attr.colorPrimaryDark};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    static final int[] f4862O = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    static final boolean f4863P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final boolean f4864Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final boolean f4865R;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Drawable f4866A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private CharSequence f4867B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private CharSequence f4868C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private C0332z0 f4869D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f4870E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private Drawable f4871F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private Drawable f4872G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private Drawable f4873H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private Drawable f4874I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final ArrayList f4875J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private Rect f4876K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private Matrix f4877L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private final Y f4878M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f4879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f4884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final G.c f4885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final G.c f4886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f4887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h f4888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OnBackInvokedCallback f4892n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OnBackInvokedDispatcher f4893o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f4894p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f4895q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f4896r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4897s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4898t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private d f4899u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f4900v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4901w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4902x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f4903y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f4904z;

    class a extends C0282a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f4905d = new Rect();

        a() {
        }

        private void n(T t3, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (DrawerLayout.C(childAt)) {
                    t3.c(childAt);
                }
            }
        }

        private void o(T t3, T t4) {
            Rect rect = this.f4905d;
            t4.n(rect);
            t3.j0(rect);
            t3.N0(t4.Y());
            t3.z0(t4.y());
            t3.m0(t4.q());
            t3.q0(t4.t());
            t3.r0(t4.N());
            t3.u0(t4.P());
            t3.g0(t4.I());
            t3.G0(t4.V());
            t3.a(t4.k());
        }

        @Override // androidx.core.view.C0282a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewR = DrawerLayout.this.r();
            if (viewR == null) {
                return true;
            }
            CharSequence charSequenceU = DrawerLayout.this.u(DrawerLayout.this.v(viewR));
            if (charSequenceU == null) {
                return true;
            }
            text.add(charSequenceU);
            return true;
        }

        @Override // androidx.core.view.C0282a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            if (DrawerLayout.f4863P) {
                super.g(view, t3);
            } else {
                T tA0 = T.a0(t3);
                super.g(view, tA0);
                t3.I0(view);
                Object objI = Z.I(view);
                if (objI instanceof View) {
                    t3.B0((View) objI);
                }
                o(t3, tA0);
                tA0.d0();
                n(t3, (ViewGroup) view);
            }
            t3.m0("androidx.drawerlayout.widget.DrawerLayout");
            t3.t0(false);
            t3.u0(false);
            t3.e0(T.a.f26e);
            t3.e0(T.a.f27f);
        }

        @Override // androidx.core.view.C0282a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f4863P || DrawerLayout.C(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static class b {
        static OnBackInvokedDispatcher a(DrawerLayout drawerLayout) {
            return drawerLayout.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new m0(runnable);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    static final class c extends C0282a {
        c() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            if (DrawerLayout.C(view)) {
                return;
            }
            t3.B0(null);
        }
    }

    public interface d {
        void a(int i3);

        void b(View view);

        void c(View view, float f3);

        void d(View view);
    }

    public static abstract class g implements d {
        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void a(int i3) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.d
        public void c(View view, float f3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h extends G.c.AbstractC0015c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private G.c f4917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f4918c = new Runnable() { // from class: androidx.drawerlayout.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f4922a.o();
            }
        };

        h(int i3) {
            this.f4916a = i3;
        }

        private void n() {
            View viewP = DrawerLayout.this.p(this.f4916a == 3 ? 5 : 3);
            if (viewP != null) {
                DrawerLayout.this.h(viewP);
            }
        }

        @Override // G.c.AbstractC0015c
        public int a(View view, int i3, int i4) {
            if (DrawerLayout.this.e(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i3, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i3, width));
        }

        @Override // G.c.AbstractC0015c
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // G.c.AbstractC0015c
        public int d(View view) {
            if (DrawerLayout.this.G(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // G.c.AbstractC0015c
        public void f(int i3, int i4) {
            View viewP = (i3 & 1) == 1 ? DrawerLayout.this.p(3) : DrawerLayout.this.p(5);
            if (viewP == null || DrawerLayout.this.t(viewP) != 0) {
                return;
            }
            this.f4917b.b(viewP, i4);
        }

        @Override // G.c.AbstractC0015c
        public boolean g(int i3) {
            return false;
        }

        @Override // G.c.AbstractC0015c
        public void h(int i3, int i4) {
            DrawerLayout.this.postDelayed(this.f4918c, 160L);
        }

        @Override // G.c.AbstractC0015c
        public void i(View view, int i3) {
            ((e) view.getLayoutParams()).f4909c = false;
            n();
        }

        @Override // G.c.AbstractC0015c
        public void j(int i3) {
            DrawerLayout.this.c0(i3, this.f4917b.v());
        }

        @Override // G.c.AbstractC0015c
        public void k(View view, int i3, int i4, int i5, int i6) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.e(view, 3) ? i3 + width : DrawerLayout.this.getWidth() - i3) / width;
            DrawerLayout.this.Y(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // G.c.AbstractC0015c
        public void l(View view, float f3, float f4) {
            int i3;
            float fW = DrawerLayout.this.w(view);
            int width = view.getWidth();
            if (DrawerLayout.this.e(view, 3)) {
                i3 = (f3 > 0.0f || (f3 == 0.0f && fW > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f3 < 0.0f || (f3 == 0.0f && fW > 0.5f)) {
                    width2 -= width;
                }
                i3 = width2;
            }
            this.f4917b.O(i3, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // G.c.AbstractC0015c
        public boolean m(View view, int i3) {
            return DrawerLayout.this.G(view) && DrawerLayout.this.e(view, this.f4916a) && DrawerLayout.this.t(view) == 0;
        }

        void o() {
            View viewP;
            int width;
            int iX = this.f4917b.x();
            boolean z3 = this.f4916a == 3;
            if (z3) {
                viewP = DrawerLayout.this.p(3);
                width = (viewP != null ? -viewP.getWidth() : 0) + iX;
            } else {
                viewP = DrawerLayout.this.p(5);
                width = DrawerLayout.this.getWidth() - iX;
            }
            if (viewP != null) {
                if (((!z3 || viewP.getLeft() >= width) && (z3 || viewP.getLeft() <= width)) || DrawerLayout.this.t(viewP) != 0) {
                    return;
                }
                e eVar = (e) viewP.getLayoutParams();
                this.f4917b.Q(viewP, width, viewP.getTop());
                eVar.f4909c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.d();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f4918c);
        }

        public void q(G.c cVar) {
            this.f4917b = cVar;
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f4863P = true;
        f4864Q = i3 >= 21;
        f4865R = i3 >= 29;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, J.a.f1179a);
    }

    private boolean A() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((e) getChildAt(i3).getLayoutParams()).f4909c) {
                return true;
            }
        }
        return false;
    }

    private boolean B() {
        return r() != null;
    }

    static boolean C(View view) {
        return (Z.A(view) == 4 || Z.A(view) == 2) ? false : true;
    }

    private boolean J(float f3, float f4, View view) {
        if (this.f4876K == null) {
            this.f4876K = new Rect();
        }
        view.getHitRect(this.f4876K);
        return this.f4876K.contains((int) f3, (int) f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean K(View view, Y.a aVar) {
        if (!F(view) || t(view) == 2) {
            return false;
        }
        h(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0332z0 L(View view, C0332z0 c0332z0) {
        ((DrawerLayout) view).W(c0332z0, c0332z0.m().f4483b > 0);
        return c0332z0.c();
    }

    private void M(Drawable drawable, int i3) {
        if (drawable == null || !androidx.core.graphics.drawable.a.h(drawable)) {
            return;
        }
        androidx.core.graphics.drawable.a.m(drawable, i3);
    }

    private Drawable T() {
        int iC = Z.C(this);
        if (iC == 0) {
            Drawable drawable = this.f4871F;
            if (drawable != null) {
                M(drawable, iC);
                return this.f4871F;
            }
        } else {
            Drawable drawable2 = this.f4872G;
            if (drawable2 != null) {
                M(drawable2, iC);
                return this.f4872G;
            }
        }
        return this.f4873H;
    }

    private Drawable U() {
        int iC = Z.C(this);
        if (iC == 0) {
            Drawable drawable = this.f4872G;
            if (drawable != null) {
                M(drawable, iC);
                return this.f4872G;
            }
        } else {
            Drawable drawable2 = this.f4871F;
            if (drawable2 != null) {
                M(drawable2, iC);
                return this.f4871F;
            }
        }
        return this.f4874I;
    }

    private void V() {
        if (f4864Q) {
            return;
        }
        this.f4904z = T();
        this.f4866A = U();
    }

    private void a0(View view) {
        T.a aVar = T.a.f46y;
        Z.k0(view, aVar.b());
        if (!F(view) || t(view) == 2) {
            return;
        }
        Z.m0(view, aVar, null, this.f4878M);
    }

    private void b0(View view, boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((z3 || G(childAt)) && !(z3 && childAt == view)) {
                Z.z0(childAt, 4);
            } else {
                Z.z0(childAt, 1);
            }
        }
    }

    private boolean o(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventX = x(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventX);
            motionEventX.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent x(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f4877L == null) {
                this.f4877L = new Matrix();
            }
            matrix.invert(this.f4877L);
            motionEventObtain.transform(this.f4877L);
        }
        return motionEventObtain;
    }

    static String y(int i3) {
        if ((i3 & 3) == 3) {
            return "LEFT";
        }
        return (i3 & 5) == 5 ? "RIGHT" : Integer.toHexString(i3);
    }

    private static boolean z(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    boolean D(View view) {
        return ((e) view.getLayoutParams()).f4907a == 0;
    }

    public boolean E(int i3) {
        View viewP = p(i3);
        if (viewP != null) {
            return F(viewP);
        }
        return false;
    }

    public boolean F(View view) {
        if (G(view)) {
            return (((e) view.getLayoutParams()).f4910d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean G(View view) {
        int iB = r.b(((e) view.getLayoutParams()).f4907a, Z.C(view));
        return ((iB & 3) == 0 && (iB & 5) == 0) ? false : true;
    }

    public boolean H(int i3) {
        View viewP = p(i3);
        if (viewP != null) {
            return I(viewP);
        }
        return false;
    }

    public boolean I(View view) {
        if (G(view)) {
            return ((e) view.getLayoutParams()).f4908b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void N(View view, float f3) {
        float fW = w(view);
        float width = view.getWidth();
        int i3 = ((int) (width * f3)) - ((int) (fW * width));
        if (!e(view, 3)) {
            i3 = -i3;
        }
        view.offsetLeftAndRight(i3);
        Y(view, f3);
    }

    public void O(int i3) {
        P(i3, true);
    }

    public void P(int i3, boolean z3) {
        View viewP = p(i3);
        if (viewP != null) {
            R(viewP, z3);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + y(i3));
    }

    public void Q(View view) {
        R(view, true);
    }

    public void R(View view, boolean z3) {
        if (!G(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f4891m) {
            eVar.f4908b = 1.0f;
            eVar.f4910d = 1;
            b0(view, true);
            a0(view);
            Z();
        } else if (z3) {
            eVar.f4910d |= 2;
            if (e(view, 3)) {
                this.f4885g.Q(view, 0, view.getTop());
            } else {
                this.f4886h.Q(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            N(view, 1.0f);
            c0(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void S(d dVar) {
        List list = this.f4900v;
        if (list == null) {
            return;
        }
        list.remove(dVar);
    }

    public void W(C0332z0 c0332z0, boolean z3) {
        this.f4869D = c0332z0;
        this.f4870E = z3;
        setWillNotDraw(!z3 && getBackground() == null);
        requestLayout();
    }

    public void X(int i3, int i4) {
        View viewP;
        int iB = r.b(i4, Z.C(this));
        if (i4 == 3) {
            this.f4894p = i3;
        } else if (i4 == 5) {
            this.f4895q = i3;
        } else if (i4 == 8388611) {
            this.f4896r = i3;
        } else if (i4 == 8388613) {
            this.f4897s = i3;
        }
        if (i3 != 0) {
            (iB == 3 ? this.f4885g : this.f4886h).a();
        }
        if (i3 != 1) {
            if (i3 == 2 && (viewP = p(iB)) != null) {
                Q(viewP);
                return;
            }
            return;
        }
        View viewP2 = p(iB);
        if (viewP2 != null) {
            h(viewP2);
        }
    }

    void Y(View view, float f3) {
        e eVar = (e) view.getLayoutParams();
        if (f3 == eVar.f4908b) {
            return;
        }
        eVar.f4908b = f3;
        n(view, f3);
    }

    void Z() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            View viewR = r();
            OnBackInvokedDispatcher onBackInvokedDispatcherA = b.a(this);
            boolean z3 = viewR != null && onBackInvokedDispatcherA != null && t(viewR) == 0 && Z.T(this);
            if (z3 && this.f4893o == null) {
                if (this.f4892n == null) {
                    this.f4892n = b.b(new Runnable() { // from class: androidx.drawerlayout.widget.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f4920a.j();
                        }
                    });
                }
                b.c(onBackInvokedDispatcherA, this.f4892n);
                this.f4893o = onBackInvokedDispatcherA;
                return;
            }
            if (z3 || (onBackInvokedDispatcher = this.f4893o) == null) {
                return;
            }
            b.d(onBackInvokedDispatcher, this.f4892n);
            this.f4893o = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i3, int i4) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!G(childAt)) {
                this.f4875J.add(childAt);
            } else if (F(childAt)) {
                childAt.addFocusables(arrayList, i3, i4);
                z3 = true;
            }
        }
        if (!z3) {
            int size = this.f4875J.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.f4875J.get(i6);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i3, i4);
                }
            }
        }
        this.f4875J.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (q() != null || G(view)) {
            Z.z0(view, 4);
        } else {
            Z.z0(view, 1);
        }
        if (f4863P) {
            return;
        }
        Z.q0(view, this.f4879a);
    }

    public void c(d dVar) {
        if (this.f4900v == null) {
            this.f4900v = new ArrayList();
        }
        this.f4900v.add(dVar);
    }

    void c0(int i3, View view) {
        int i4;
        int iA = this.f4885g.A();
        int iA2 = this.f4886h.A();
        if (iA == 1 || iA2 == 1) {
            i4 = 1;
        } else {
            i4 = 2;
            if (iA != 2 && iA2 != 2) {
                i4 = 0;
            }
        }
        if (view != null && i3 == 0) {
            float f3 = ((e) view.getLayoutParams()).f4908b;
            if (f3 == 0.0f) {
                l(view);
            } else if (f3 == 1.0f) {
                m(view);
            }
        }
        if (i4 != this.f4889k) {
            this.f4889k = i4;
            List list = this.f4900v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f4900v.get(size)).a(i4);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            fMax = Math.max(fMax, ((e) getChildAt(i3).getLayoutParams()).f4908b);
        }
        this.f4883e = fMax;
        boolean zM = this.f4885g.m(true);
        boolean zM2 = this.f4886h.m(true);
        if (zM || zM2) {
            Z.h0(this);
        }
    }

    void d() {
        if (this.f4898t) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f4898t = true;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f4883e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt = getChildAt(i3);
            if (J(x3, y3, childAt) && !D(childAt) && o(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        int height = getHeight();
        boolean zD = D(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i3 = 0;
        if (zD) {
            int childCount = getChildCount();
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view && childAt.getVisibility() == 0 && z(childAt) && G(childAt) && childAt.getHeight() >= height) {
                    if (e(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i4) {
                            i4 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i4, 0, width, getHeight());
            i3 = i4;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(iSave);
        float f3 = this.f4883e;
        if (f3 > 0.0f && zD) {
            int i6 = this.f4882d;
            this.f4884f.setColor((i6 & 16777215) | (((int) ((((-16777216) & i6) >>> 24) * f3)) << 24));
            canvas.drawRect(i3, 0.0f, width, getHeight(), this.f4884f);
        } else if (this.f4904z != null && e(view, 3)) {
            int intrinsicWidth = this.f4904z.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f4885g.x(), 1.0f));
            this.f4904z.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f4904z.setAlpha((int) (fMax * 255.0f));
            this.f4904z.draw(canvas);
        } else if (this.f4866A != null && e(view, 5)) {
            int intrinsicWidth2 = this.f4866A.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f4886h.x(), 1.0f));
            this.f4866A.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f4866A.setAlpha((int) (fMax2 * 255.0f));
            this.f4866A.draw(canvas);
        }
        return zDrawChild;
    }

    boolean e(View view, int i3) {
        return (v(view) & i3) == i3;
    }

    public void f(int i3) {
        g(i3, true);
    }

    public void g(int i3, boolean z3) {
        View viewP = p(i3);
        if (viewP != null) {
            i(viewP, z3);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + y(i3));
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (f4864Q) {
            return this.f4880b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f4903y;
    }

    public void h(View view) {
        i(view, true);
    }

    public void i(View view, boolean z3) {
        if (!G(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f4891m) {
            eVar.f4908b = 0.0f;
            eVar.f4910d = 0;
        } else if (z3) {
            eVar.f4910d |= 4;
            if (e(view, 3)) {
                this.f4885g.Q(view, -view.getWidth(), view.getTop());
            } else {
                this.f4886h.Q(view, getWidth(), view.getTop());
            }
        } else {
            N(view, 0.0f);
            c0(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void j() {
        k(false);
    }

    void k(boolean z3) {
        int childCount = getChildCount();
        boolean zQ = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (G(childAt) && (!z3 || eVar.f4909c)) {
                zQ |= e(childAt, 3) ? this.f4885g.Q(childAt, -childAt.getWidth(), childAt.getTop()) : this.f4886h.Q(childAt, getWidth(), childAt.getTop());
                eVar.f4909c = false;
            }
        }
        this.f4887i.p();
        this.f4888j.p();
        if (zQ) {
            invalidate();
        }
    }

    void l(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f4910d & 1) == 1) {
            eVar.f4910d = 0;
            List list = this.f4900v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f4900v.get(size)).d(view);
                }
            }
            b0(view, false);
            a0(view);
            Z();
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void m(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f4910d & 1) == 0) {
            eVar.f4910d = 1;
            List list = this.f4900v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((d) this.f4900v.get(size)).b(view);
                }
            }
            b0(view, true);
            a0(view);
            Z();
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void n(View view, float f3) {
        List list = this.f4900v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((d) this.f4900v.get(size)).c(view, f3);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4891m = true;
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4891m = true;
        Z();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C0332z0 c0332z0;
        super.onDraw(canvas);
        if (!this.f4870E || this.f4903y == null) {
            return;
        }
        int iL = (Build.VERSION.SDK_INT < 21 || (c0332z0 = this.f4869D) == null) ? 0 : c0332z0.l();
        if (iL > 0) {
            this.f4903y.setBounds(0, 0, getWidth(), iL);
            this.f4903y.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        View viewT;
        int actionMasked = motionEvent.getActionMasked();
        boolean zP = this.f4885g.P(motionEvent) | this.f4886h.P(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                k(true);
                this.f4898t = false;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    k(true);
                    this.f4898t = false;
                }
            } else if (this.f4885g.d(3)) {
                this.f4887i.p();
                this.f4888j.p();
            }
            z3 = false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            this.f4901w = x3;
            this.f4902x = y3;
            z3 = this.f4883e > 0.0f && (viewT = this.f4885g.t((int) x3, (int) y3)) != null && D(viewT);
            this.f4898t = false;
        }
        return zP || z3 || A() || this.f4898t;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4 || !B()) {
            return super.onKeyDown(i3, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return super.onKeyUp(i3, keyEvent);
        }
        View viewR = r();
        if (viewR != null && t(viewR) == 0) {
            j();
        }
        return viewR != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        C0332z0 c0332z0J;
        float f3;
        int i7;
        this.f4890l = true;
        int i8 = i5 - i3;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (D(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (e(childAt, 3)) {
                        float f4 = measuredWidth;
                        i7 = (-measuredWidth) + ((int) (eVar.f4908b * f4));
                        f3 = (measuredWidth + i7) / f4;
                    } else {
                        float f5 = measuredWidth;
                        int i11 = i8 - ((int) (eVar.f4908b * f5));
                        f3 = (i8 - i11) / f5;
                        i7 = i11;
                    }
                    boolean z4 = f3 != eVar.f4908b;
                    int i12 = eVar.f4907a & 112;
                    if (i12 == 16) {
                        int i13 = i6 - i4;
                        int i14 = (i13 - measuredHeight) / 2;
                        int i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight;
                            int i17 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i16 > i13 - i17) {
                                i14 = (i13 - i17) - measuredHeight;
                            }
                        }
                        childAt.layout(i7, i14, measuredWidth + i7, measuredHeight + i14);
                    } else if (i12 != 80) {
                        int i18 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        childAt.layout(i7, i18, measuredWidth + i7, measuredHeight + i18);
                    } else {
                        int i19 = i6 - i4;
                        childAt.layout(i7, (i19 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i19 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                    }
                    if (z4) {
                        Y(childAt, f3);
                    }
                    int i20 = eVar.f4908b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i20) {
                        childAt.setVisibility(i20);
                    }
                }
            }
        }
        if (f4865R && (c0332z0J = Z.J(this)) != null) {
            androidx.core.graphics.e eVarH = c0332z0J.h();
            G.c cVar = this.f4885g;
            cVar.L(Math.max(cVar.w(), eVarH.f4482a));
            G.c cVar2 = this.f4886h;
            cVar2.L(Math.max(cVar2.w(), eVarH.f4484c));
        }
        this.f4890l = false;
        this.f4891m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z3 = this.f4869D != null && Z.z(this);
        int iC = Z.C(this);
        int childCount = getChildCount();
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z3) {
                    int iB = r.b(eVar.f4907a, iC);
                    if (Z.z(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            C0332z0 c0332z0R = this.f4869D;
                            if (iB == 3) {
                                c0332z0R = c0332z0R.r(c0332z0R.j(), c0332z0R.l(), 0, c0332z0R.i());
                            } else if (iB == 5) {
                                c0332z0R = c0332z0R.r(0, c0332z0R.l(), c0332z0R.k(), c0332z0R.i());
                            }
                            Z.i(childAt, c0332z0R);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        C0332z0 c0332z0R2 = this.f4869D;
                        if (iB == 3) {
                            c0332z0R2 = c0332z0R2.r(c0332z0R2.j(), c0332z0R2.l(), 0, c0332z0R2.i());
                        } else if (iB == 5) {
                            c0332z0R2 = c0332z0R2.r(0, c0332z0R2.l(), c0332z0R2.k(), c0332z0R2.i());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = c0332z0R2.j();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = c0332z0R2.l();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = c0332z0R2.k();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = c0332z0R2.i();
                    }
                }
                if (D(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!G(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f4864Q) {
                        float fW = Z.w(childAt);
                        float f3 = this.f4880b;
                        if (fW != f3) {
                            Z.y0(childAt, f3);
                        }
                    }
                    int iV = v(childAt) & 7;
                    boolean z6 = iV == 3;
                    if ((z6 && z4) || (!z6 && z5)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + y(iV) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z6) {
                        z4 = true;
                    } else {
                        z5 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i3, this.f4881c + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i4, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewP;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.c());
        int i3 = fVar.f4911c;
        if (i3 != 0 && (viewP = p(i3)) != null) {
            Q(viewP);
        }
        int i4 = fVar.f4912d;
        if (i4 != 3) {
            X(i4, 3);
        }
        int i5 = fVar.f4913e;
        if (i5 != 3) {
            X(i5, 5);
        }
        int i6 = fVar.f4914f;
        if (i6 != 3) {
            X(i6, 8388611);
        }
        int i7 = fVar.f4915g;
        if (i7 != 3) {
            X(i7, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        V();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            e eVar = (e) getChildAt(i3).getLayoutParams();
            int i4 = eVar.f4910d;
            boolean z3 = i4 == 1;
            boolean z4 = i4 == 2;
            if (z3 || z4) {
                fVar.f4911c = eVar.f4907a;
                break;
            }
        }
        fVar.f4912d = this.f4894p;
        fVar.f4913e = this.f4895q;
        fVar.f4914f = this.f4896r;
        fVar.f4915g = this.f4897s;
        return fVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        View viewQ;
        this.f4885g.F(motionEvent);
        this.f4886h.F(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            this.f4901w = x3;
            this.f4902x = y3;
            this.f4898t = false;
        } else if (action == 1) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            View viewT = this.f4885g.t((int) x4, (int) y4);
            if (viewT != null && D(viewT)) {
                float f3 = x4 - this.f4901w;
                float f4 = y4 - this.f4902x;
                int iZ = this.f4885g.z();
                z3 = (f3 * f3) + (f4 * f4) >= ((float) (iZ * iZ)) || (viewQ = q()) == null || t(viewQ) == 2;
            }
            k(z3);
        } else if (action == 3) {
            k(true);
            this.f4898t = false;
        }
        return true;
    }

    View p(int i3) {
        int iB = r.b(i3, Z.C(this)) & 7;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if ((v(childAt) & 7) == iB) {
                return childAt;
            }
        }
        return null;
    }

    View q() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((((e) childAt.getLayoutParams()).f4910d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View r() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (G(childAt) && I(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        super.requestDisallowInterceptTouchEvent(z3);
        if (z3) {
            k(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4890l) {
            return;
        }
        super.requestLayout();
    }

    public int s(int i3) {
        int iC = Z.C(this);
        if (i3 == 3) {
            int i4 = this.f4894p;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iC == 0 ? this.f4896r : this.f4897s;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i3 == 5) {
            int i6 = this.f4895q;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iC == 0 ? this.f4897s : this.f4896r;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i3 == 8388611) {
            int i8 = this.f4896r;
            if (i8 != 3) {
                return i8;
            }
            int i9 = iC == 0 ? this.f4894p : this.f4895q;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
        if (i3 != 8388613) {
            return 0;
        }
        int i10 = this.f4897s;
        if (i10 != 3) {
            return i10;
        }
        int i11 = iC == 0 ? this.f4895q : this.f4894p;
        if (i11 != 3) {
            return i11;
        }
        return 0;
    }

    public void setDrawerElevation(float f3) {
        this.f4880b = f3;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (G(childAt)) {
                Z.y0(childAt, this.f4880b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.f4899u;
        if (dVar2 != null) {
            S(dVar2);
        }
        if (dVar != null) {
            c(dVar);
        }
        this.f4899u = dVar;
    }

    public void setDrawerLockMode(int i3) {
        X(i3, 3);
        X(i3, 5);
    }

    public void setScrimColor(int i3) {
        this.f4882d = i3;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f4903y = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i3) {
        this.f4903y = new ColorDrawable(i3);
        invalidate();
    }

    public int t(View view) {
        if (G(view)) {
            return s(((e) view.getLayoutParams()).f4907a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence u(int i3) {
        int iB = r.b(i3, Z.C(this));
        if (iB == 3) {
            return this.f4867B;
        }
        if (iB == 5) {
            return this.f4868C;
        }
        return null;
    }

    int v(View view) {
        return r.b(((e) view.getLayoutParams()).f4907a, Z.C(this));
    }

    float w(View view) {
        return ((e) view.getLayoutParams()).f4908b;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4879a = new c();
        this.f4882d = -1728053248;
        this.f4884f = new Paint();
        this.f4891m = true;
        this.f4894p = 3;
        this.f4895q = 3;
        this.f4896r = 3;
        this.f4897s = 3;
        this.f4871F = null;
        this.f4872G = null;
        this.f4873H = null;
        this.f4874I = null;
        this.f4878M = new Y() { // from class: androidx.drawerlayout.widget.b
            @Override // A.Y
            public final boolean a(View view, Y.a aVar) {
                return this.f4921a.K(view, aVar);
            }
        };
        setDescendantFocusability(262144);
        float f3 = getResources().getDisplayMetrics().density;
        this.f4881c = (int) ((64.0f * f3) + 0.5f);
        float f4 = f3 * 400.0f;
        h hVar = new h(3);
        this.f4887i = hVar;
        h hVar2 = new h(5);
        this.f4888j = hVar2;
        G.c cVarN = G.c.n(this, 1.0f, hVar);
        this.f4885g = cVarN;
        cVarN.M(1);
        cVarN.N(f4);
        hVar.q(cVarN);
        G.c cVarN2 = G.c.n(this, 1.0f, hVar2);
        this.f4886h = cVarN2;
        cVarN2.M(2);
        cVarN2.N(f4);
        hVar2.q(cVarN2);
        setFocusableInTouchMode(true);
        Z.z0(this, 1);
        Z.q0(this, new a());
        setMotionEventSplittingEnabled(false);
        if (Z.z(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                Z.D0(this, new I() { // from class: androidx.drawerlayout.widget.c
                    @Override // androidx.core.view.I
                    public final C0332z0 a(View view, C0332z0 c0332z0) {
                        return DrawerLayout.L(view, c0332z0);
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f4861N);
                try {
                    this.f4903y = typedArrayObtainStyledAttributes.getDrawable(0);
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            } else {
                this.f4903y = null;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, J.c.f1181a, i3, 0);
        try {
            int i4 = J.c.f1182b;
            if (typedArrayObtainStyledAttributes2.hasValue(i4)) {
                this.f4880b = typedArrayObtainStyledAttributes2.getDimension(i4, 0.0f);
            } else {
                this.f4880b = getResources().getDimension(J.b.f1180a);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f4875J = new ArrayList();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i3) {
        this.f4903y = i3 != 0 ? androidx.core.content.a.d(getContext(), i3) : null;
        invalidate();
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f4908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4910d;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4907a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f4862O);
            this.f4907a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(int i3, int i4) {
            super(i3, i4);
            this.f4907a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f4907a = 0;
            this.f4907a = eVar.f4907a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4907a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4907a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    protected static class f extends F.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f4915g;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4911c = 0;
            this.f4911c = parcel.readInt();
            this.f4912d = parcel.readInt();
            this.f4913e = parcel.readInt();
            this.f4914f = parcel.readInt();
            this.f4915g = parcel.readInt();
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f4911c);
            parcel.writeInt(this.f4912d);
            parcel.writeInt(this.f4913e);
            parcel.writeInt(this.f4914f);
            parcel.writeInt(this.f4915g);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.f4911c = 0;
        }
    }
}
