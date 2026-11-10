package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AbstractC0301j0;
import androidx.core.view.C0297h0;
import androidx.core.view.InterfaceC0299i0;
import androidx.core.view.InterfaceC0303k0;
import androidx.core.view.Z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class L extends AbstractC0245a implements ActionBarOverlayLayout.d {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final Interpolator f2465D = new AccelerateInterpolator();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final Interpolator f2466E = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f2472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f2473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContainer f2474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    M f2475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ActionBarContextView f2476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f2477h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    d f2481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    androidx.appcompat.view.b f2482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    androidx.appcompat.view.b.a f2483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2484o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2486q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f2489t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f2490u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f2491v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    androidx.appcompat.view.h f2493x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f2494y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f2495z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f2478i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2479j = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ArrayList f2485p = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2487r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f2488s = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2492w = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    final InterfaceC0299i0 f2467A = new a();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    final InterfaceC0299i0 f2468B = new b();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    final InterfaceC0303k0 f2469C = new c();

    class a extends AbstractC0301j0 {
        a() {
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            View view2;
            L l3 = L.this;
            if (l3.f2488s && (view2 = l3.f2477h) != null) {
                view2.setTranslationY(0.0f);
                L.this.f2474e.setTranslationY(0.0f);
            }
            L.this.f2474e.setVisibility(8);
            L.this.f2474e.setTransitioning(false);
            L l4 = L.this;
            l4.f2493x = null;
            l4.C();
            ActionBarOverlayLayout actionBarOverlayLayout = L.this.f2473d;
            if (actionBarOverlayLayout != null) {
                Z.n0(actionBarOverlayLayout);
            }
        }
    }

    class b extends AbstractC0301j0 {
        b() {
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            L l3 = L.this;
            l3.f2493x = null;
            l3.f2474e.requestLayout();
        }
    }

    class c implements InterfaceC0303k0 {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0303k0
        public void a(View view) {
            ((View) L.this.f2474e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements androidx.appcompat.view.menu.g.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f2499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f2500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.appcompat.view.b.a f2501e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference f2502f;

        public d(Context context, androidx.appcompat.view.b.a aVar) {
            this.f2499c = context;
            this.f2501e = aVar;
            androidx.appcompat.view.menu.g gVarW = new androidx.appcompat.view.menu.g(context).W(1);
            this.f2500d = gVarW;
            gVarW.V(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            androidx.appcompat.view.b.a aVar = this.f2501e;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.f2501e == null) {
                return;
            }
            k();
            L.this.f2476g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            L l3 = L.this;
            if (l3.f2481l != this) {
                return;
            }
            if (L.B(l3.f2489t, l3.f2490u, false)) {
                this.f2501e.d(this);
            } else {
                L l4 = L.this;
                l4.f2482m = this;
                l4.f2483n = this.f2501e;
            }
            this.f2501e = null;
            L.this.A(false);
            L.this.f2476g.g();
            L l5 = L.this;
            l5.f2473d.setHideOnContentScrollEnabled(l5.f2495z);
            L.this.f2481l = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference weakReference = this.f2502f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f2500d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f2499c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return L.this.f2476g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return L.this.f2476g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (L.this.f2481l != this) {
                return;
            }
            this.f2500d.h0();
            try {
                this.f2501e.a(this, this.f2500d);
            } finally {
                this.f2500d.g0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return L.this.f2476g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            L.this.f2476g.setCustomView(view);
            this.f2502f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i3) {
            o(L.this.f2470a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            L.this.f2476g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i3) {
            r(L.this.f2470a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            L.this.f2476g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z3) {
            super.s(z3);
            L.this.f2476g.setTitleOptional(z3);
        }

        public boolean t() {
            this.f2500d.h0();
            try {
                return this.f2501e.c(this, this.f2500d);
            } finally {
                this.f2500d.g0();
            }
        }
    }

    public L(Activity activity, boolean z3) {
        this.f2472c = activity;
        View decorView = activity.getWindow().getDecorView();
        I(decorView);
        if (z3) {
            return;
        }
        this.f2477h = decorView.findViewById(R.id.content);
    }

    static boolean B(boolean z3, boolean z4, boolean z5) {
        if (z5) {
            return true;
        }
        return (z3 || z4) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private M F(View view) {
        if (view instanceof M) {
            return (M) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void H() {
        if (this.f2491v) {
            this.f2491v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2473d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            Q(false);
        }
    }

    private void I(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(p012d.f.f9207p);
        this.f2473d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2475f = F(view.findViewById(p012d.f.f9192a));
        this.f2476g = (ActionBarContextView) view.findViewById(p012d.f.f9197f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(p012d.f.f9194c);
        this.f2474e = actionBarContainer;
        M m3 = this.f2475f;
        if (m3 == null || this.f2476g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f2470a = m3.getContext();
        boolean z3 = (this.f2475f.j() & 4) != 0;
        if (z3) {
            this.f2480k = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f2470a);
        N(aVarB.a() || z3);
        L(aVarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.f2470a.obtainStyledAttributes(null, p012d.j.f9342a, p012d.a.f9085c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9382k, false)) {
            M(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(p012d.j.f9374i, 0);
        if (dimensionPixelSize != 0) {
            K(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void L(boolean z3) {
        this.f2486q = z3;
        if (z3) {
            this.f2474e.setTabContainer(null);
            this.f2475f.n(null);
        } else {
            this.f2475f.n(null);
            this.f2474e.setTabContainer(null);
        }
        boolean z4 = false;
        boolean z5 = G() == 2;
        this.f2475f.x(!this.f2486q && z5);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2473d;
        if (!this.f2486q && z5) {
            z4 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    private boolean O() {
        return Z.U(this.f2474e);
    }

    private void P() {
        if (this.f2491v) {
            return;
        }
        this.f2491v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2473d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        Q(false);
    }

    private void Q(boolean z3) {
        if (B(this.f2489t, this.f2490u, this.f2491v)) {
            if (this.f2492w) {
                return;
            }
            this.f2492w = true;
            E(z3);
            return;
        }
        if (this.f2492w) {
            this.f2492w = false;
            D(z3);
        }
    }

    public void A(boolean z3) {
        C0297h0 c0297h0S;
        C0297h0 c0297h0F;
        if (z3) {
            P();
        } else {
            H();
        }
        if (!O()) {
            if (z3) {
                this.f2475f.k(4);
                this.f2476g.setVisibility(0);
                return;
            } else {
                this.f2475f.k(0);
                this.f2476g.setVisibility(8);
                return;
            }
        }
        if (z3) {
            c0297h0F = this.f2475f.s(4, 100L);
            c0297h0S = this.f2476g.f(0, 200L);
        } else {
            c0297h0S = this.f2475f.s(0, 200L);
            c0297h0F = this.f2476g.f(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(c0297h0F, c0297h0S);
        hVar.h();
    }

    void C() {
        androidx.appcompat.view.b.a aVar = this.f2483n;
        if (aVar != null) {
            aVar.d(this.f2482m);
            this.f2482m = null;
            this.f2483n = null;
        }
    }

    public void D(boolean z3) {
        View view;
        androidx.appcompat.view.h hVar = this.f2493x;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f2487r != 0 || (!this.f2494y && !z3)) {
            this.f2467A.a(null);
            return;
        }
        this.f2474e.setAlpha(1.0f);
        this.f2474e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f3 = -this.f2474e.getHeight();
        if (z3) {
            int[] iArr = {0, 0};
            this.f2474e.getLocationInWindow(iArr);
            f3 -= iArr[1];
        }
        C0297h0 c0297h0M = Z.e(this.f2474e).m(f3);
        c0297h0M.k(this.f2469C);
        hVar2.c(c0297h0M);
        if (this.f2488s && (view = this.f2477h) != null) {
            hVar2.c(Z.e(view).m(f3));
        }
        hVar2.f(f2465D);
        hVar2.e(250L);
        hVar2.g(this.f2467A);
        this.f2493x = hVar2;
        hVar2.h();
    }

    public void E(boolean z3) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f2493x;
        if (hVar != null) {
            hVar.a();
        }
        this.f2474e.setVisibility(0);
        if (this.f2487r == 0 && (this.f2494y || z3)) {
            this.f2474e.setTranslationY(0.0f);
            float f3 = -this.f2474e.getHeight();
            if (z3) {
                int[] iArr = {0, 0};
                this.f2474e.getLocationInWindow(iArr);
                f3 -= iArr[1];
            }
            this.f2474e.setTranslationY(f3);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            C0297h0 c0297h0M = Z.e(this.f2474e).m(0.0f);
            c0297h0M.k(this.f2469C);
            hVar2.c(c0297h0M);
            if (this.f2488s && (view2 = this.f2477h) != null) {
                view2.setTranslationY(f3);
                hVar2.c(Z.e(this.f2477h).m(0.0f));
            }
            hVar2.f(f2466E);
            hVar2.e(250L);
            hVar2.g(this.f2468B);
            this.f2493x = hVar2;
            hVar2.h();
        } else {
            this.f2474e.setAlpha(1.0f);
            this.f2474e.setTranslationY(0.0f);
            if (this.f2488s && (view = this.f2477h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f2468B.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2473d;
        if (actionBarOverlayLayout != null) {
            Z.n0(actionBarOverlayLayout);
        }
    }

    public int G() {
        return this.f2475f.r();
    }

    public void J(int i3, int i4) {
        int iJ = this.f2475f.j();
        if ((i4 & 4) != 0) {
            this.f2480k = true;
        }
        this.f2475f.y((i3 & i4) | ((i4 ^ (-1)) & iJ));
    }

    public void K(float f3) {
        Z.y0(this.f2474e, f3);
    }

    public void M(boolean z3) {
        if (z3 && !this.f2473d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f2495z = z3;
        this.f2473d.setHideOnContentScrollEnabled(z3);
    }

    public void N(boolean z3) {
        this.f2475f.q(z3);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z3) {
        this.f2488s = z3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f2490u) {
            this.f2490u = false;
            Q(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        androidx.appcompat.view.h hVar = this.f2493x;
        if (hVar != null) {
            hVar.a();
            this.f2493x = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i3) {
        this.f2487r = i3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f2490u) {
            return;
        }
        this.f2490u = true;
        Q(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean h() {
        M m3 = this.f2475f;
        if (m3 == null || !m3.u()) {
            return false;
        }
        this.f2475f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void i(boolean z3) {
        if (z3 == this.f2484o) {
            return;
        }
        this.f2484o = z3;
        if (this.f2485p.size() <= 0) {
            return;
        }
        H.a(this.f2485p.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public int j() {
        return this.f2475f.j();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public Context k() {
        if (this.f2471b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2470a.getTheme().resolveAttribute(p012d.a.f9087e, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f2471b = new ContextThemeWrapper(this.f2470a, i3);
            } else {
                this.f2471b = this.f2470a;
            }
        }
        return this.f2471b;
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void m(Configuration configuration) {
        L(androidx.appcompat.view.a.b(this.f2470a).e());
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f2481l;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void r(boolean z3) {
        if (this.f2480k) {
            return;
        }
        s(z3);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void s(boolean z3) {
        J(z3 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void t(boolean z3) {
        J(z3 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void u(int i3) {
        this.f2475f.p(i3);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void v(Drawable drawable) {
        this.f2475f.w(drawable);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void w(boolean z3) {
        androidx.appcompat.view.h hVar;
        this.f2494y = z3;
        if (z3 || (hVar = this.f2493x) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void x(CharSequence charSequence) {
        this.f2475f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public void y(CharSequence charSequence) {
        this.f2475f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0245a
    public androidx.appcompat.view.b z(androidx.appcompat.view.b.a aVar) {
        d dVar = this.f2481l;
        if (dVar != null) {
            dVar.c();
        }
        this.f2473d.setHideOnContentScrollEnabled(false);
        this.f2476g.k();
        d dVar2 = new d(this.f2476g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f2481l = dVar2;
        dVar2.k();
        this.f2476g.h(dVar2);
        A(true);
        return dVar2;
    }

    public L(Dialog dialog) {
        I(dialog.getWindow().getDecorView());
    }
}
