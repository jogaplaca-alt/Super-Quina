package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.AbstractC0301j0;
import androidx.core.view.C0297h0;

/* JADX INFO: loaded from: classes.dex */
public class n0 implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f3561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f3564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f3565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f3566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f3567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    CharSequence f3569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f3570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f3571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window.Callback f3572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f3573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C0259c f3574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f3577q;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f3578a;

        a() {
            this.f3578a = new androidx.appcompat.view.menu.a(n0.this.f3561a.getContext(), 0, R.id.home, 0, 0, n0.this.f3569i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0 n0Var = n0.this;
            Window.Callback callback = n0Var.f3572l;
            if (callback == null || !n0Var.f3573m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f3578a);
        }
    }

    class b extends AbstractC0301j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3580a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3581b;

        b(int i3) {
            this.f3581b = i3;
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            if (this.f3580a) {
                return;
            }
            n0.this.f3561a.setVisibility(this.f3581b);
        }

        @Override // androidx.core.view.AbstractC0301j0, androidx.core.view.InterfaceC0299i0
        public void b(View view) {
            n0.this.f3561a.setVisibility(0);
        }

        @Override // androidx.core.view.AbstractC0301j0, androidx.core.view.InterfaceC0299i0
        public void c(View view) {
            this.f3580a = true;
        }
    }

    public n0(Toolbar toolbar, boolean z3) {
        this(toolbar, z3, p012d.h.f9238a, p012d.e.f9163n);
    }

    private void F(CharSequence charSequence) {
        this.f3569i = charSequence;
        if ((this.f3562b & 8) != 0) {
            this.f3561a.setTitle(charSequence);
            if (this.f3568h) {
                androidx.core.view.Z.t0(this.f3561a.getRootView(), charSequence);
            }
        }
    }

    private void G() {
        if ((this.f3562b & 4) != 0) {
            if (TextUtils.isEmpty(this.f3571k)) {
                this.f3561a.setNavigationContentDescription(this.f3576p);
            } else {
                this.f3561a.setNavigationContentDescription(this.f3571k);
            }
        }
    }

    private void H() {
        if ((this.f3562b & 4) == 0) {
            this.f3561a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f3561a;
        Drawable drawable = this.f3567g;
        if (drawable == null) {
            drawable = this.f3577q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void I() {
        Drawable drawable;
        int i3 = this.f3562b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) == 0 || (drawable = this.f3566f) == null) {
            drawable = this.f3565e;
        }
        this.f3561a.setLogo(drawable);
    }

    private int z() {
        if (this.f3561a.getNavigationIcon() == null) {
            return 11;
        }
        this.f3577q = this.f3561a.getNavigationIcon();
        return 15;
    }

    public void A(View view) {
        View view2 = this.f3564d;
        if (view2 != null && (this.f3562b & 16) != 0) {
            this.f3561a.removeView(view2);
        }
        this.f3564d = view;
        if (view == null || (this.f3562b & 16) == 0) {
            return;
        }
        this.f3561a.addView(view);
    }

    public void B(int i3) {
        if (i3 == this.f3576p) {
            return;
        }
        this.f3576p = i3;
        if (TextUtils.isEmpty(this.f3561a.getNavigationContentDescription())) {
            p(this.f3576p);
        }
    }

    public void C(Drawable drawable) {
        this.f3566f = drawable;
        I();
    }

    public void D(CharSequence charSequence) {
        this.f3571k = charSequence;
        G();
    }

    public void E(CharSequence charSequence) {
        this.f3570j = charSequence;
        if ((this.f3562b & 8) != 0) {
            this.f3561a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.M
    public void a(Menu menu, androidx.appcompat.view.menu.m.a aVar) {
        if (this.f3574n == null) {
            C0259c c0259c = new C0259c(this.f3561a.getContext());
            this.f3574n = c0259c;
            c0259c.s(p012d.f.f9198g);
        }
        this.f3574n.l(aVar);
        this.f3561a.K((androidx.appcompat.view.menu.g) menu, this.f3574n);
    }

    @Override // androidx.appcompat.widget.M
    public boolean b() {
        return this.f3561a.A();
    }

    @Override // androidx.appcompat.widget.M
    public boolean c() {
        return this.f3561a.B();
    }

    @Override // androidx.appcompat.widget.M
    public void collapseActionView() {
        this.f3561a.e();
    }

    @Override // androidx.appcompat.widget.M
    public boolean d() {
        return this.f3561a.w();
    }

    @Override // androidx.appcompat.widget.M
    public boolean e() {
        return this.f3561a.Q();
    }

    @Override // androidx.appcompat.widget.M
    public void f() {
        this.f3573m = true;
    }

    @Override // androidx.appcompat.widget.M
    public boolean g() {
        return this.f3561a.d();
    }

    @Override // androidx.appcompat.widget.M
    public Context getContext() {
        return this.f3561a.getContext();
    }

    @Override // androidx.appcompat.widget.M
    public CharSequence getTitle() {
        return this.f3561a.getTitle();
    }

    @Override // androidx.appcompat.widget.M
    public void h() {
        this.f3561a.f();
    }

    @Override // androidx.appcompat.widget.M
    public void i(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.f3561a.L(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.M
    public int j() {
        return this.f3562b;
    }

    @Override // androidx.appcompat.widget.M
    public void k(int i3) {
        this.f3561a.setVisibility(i3);
    }

    @Override // androidx.appcompat.widget.M
    public Menu l() {
        return this.f3561a.getMenu();
    }

    @Override // androidx.appcompat.widget.M
    public void m(int i3) {
        C(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.M
    public void n(d0 d0Var) {
        View view = this.f3563c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f3561a;
            if (parent == toolbar) {
                toolbar.removeView(this.f3563c);
            }
        }
        this.f3563c = d0Var;
    }

    @Override // androidx.appcompat.widget.M
    public ViewGroup o() {
        return this.f3561a;
    }

    @Override // androidx.appcompat.widget.M
    public void p(int i3) {
        D(i3 == 0 ? null : getContext().getString(i3));
    }

    @Override // androidx.appcompat.widget.M
    public void q(boolean z3) {
    }

    @Override // androidx.appcompat.widget.M
    public int r() {
        return this.f3575o;
    }

    @Override // androidx.appcompat.widget.M
    public C0297h0 s(int i3, long j3) {
        return androidx.core.view.Z.e(this.f3561a).b(i3 == 0 ? 1.0f : 0.0f).f(j3).h(new b(i3));
    }

    @Override // androidx.appcompat.widget.M
    public void setIcon(int i3) {
        setIcon(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.M
    public void setTitle(CharSequence charSequence) {
        this.f3568h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.M
    public void setWindowCallback(Window.Callback callback) {
        this.f3572l = callback;
    }

    @Override // androidx.appcompat.widget.M
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f3568h) {
            return;
        }
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.M
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.M
    public boolean u() {
        return this.f3561a.v();
    }

    @Override // androidx.appcompat.widget.M
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.M
    public void w(Drawable drawable) {
        this.f3567g = drawable;
        H();
    }

    @Override // androidx.appcompat.widget.M
    public void x(boolean z3) {
        this.f3561a.setCollapsible(z3);
    }

    @Override // androidx.appcompat.widget.M
    public void y(int i3) {
        View view;
        int i4 = this.f3562b ^ i3;
        this.f3562b = i3;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i4 & 3) != 0) {
                I();
            }
            if ((i4 & 8) != 0) {
                if ((i3 & 8) != 0) {
                    this.f3561a.setTitle(this.f3569i);
                    this.f3561a.setSubtitle(this.f3570j);
                } else {
                    this.f3561a.setTitle((CharSequence) null);
                    this.f3561a.setSubtitle((CharSequence) null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f3564d) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                this.f3561a.addView(view);
            } else {
                this.f3561a.removeView(view);
            }
        }
    }

    public n0(Toolbar toolbar, boolean z3, int i3, int i4) {
        Drawable drawable;
        this.f3575o = 0;
        this.f3576p = 0;
        this.f3561a = toolbar;
        this.f3569i = toolbar.getTitle();
        this.f3570j = toolbar.getSubtitle();
        this.f3568h = this.f3569i != null;
        this.f3567g = toolbar.getNavigationIcon();
        j0 j0VarV = j0.v(toolbar.getContext(), null, p012d.j.f9342a, p012d.a.f9085c, 0);
        this.f3577q = j0VarV.g(p012d.j.f9386l);
        if (z3) {
            CharSequence charSequenceP = j0VarV.p(p012d.j.f9410r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = j0VarV.p(p012d.j.f9402p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                E(charSequenceP2);
            }
            Drawable drawableG = j0VarV.g(p012d.j.f9394n);
            if (drawableG != null) {
                C(drawableG);
            }
            Drawable drawableG2 = j0VarV.g(p012d.j.f9390m);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f3567g == null && (drawable = this.f3577q) != null) {
                w(drawable);
            }
            y(j0VarV.k(p012d.j.f9370h, 0));
            int iN = j0VarV.n(p012d.j.f9366g, 0);
            if (iN != 0) {
                A(LayoutInflater.from(this.f3561a.getContext()).inflate(iN, (ViewGroup) this.f3561a, false));
                y(this.f3562b | 16);
            }
            int iM = j0VarV.m(p012d.j.f9378j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f3561a.getLayoutParams();
                layoutParams.height = iM;
                this.f3561a.setLayoutParams(layoutParams);
            }
            int iE = j0VarV.e(p012d.j.f9362f, -1);
            int iE2 = j0VarV.e(p012d.j.f9358e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f3561a.J(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = j0VarV.n(p012d.j.f9414s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f3561a;
                toolbar2.N(toolbar2.getContext(), iN2);
            }
            int iN3 = j0VarV.n(p012d.j.f9406q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f3561a;
                toolbar3.M(toolbar3.getContext(), iN3);
            }
            int iN4 = j0VarV.n(p012d.j.f9398o, 0);
            if (iN4 != 0) {
                this.f3561a.setPopupTheme(iN4);
            }
        } else {
            this.f3562b = z();
        }
        j0VarV.w();
        B(i3);
        this.f3571k = this.f3561a.getNavigationContentDescription();
        this.f3561a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.M
    public void setIcon(Drawable drawable) {
        this.f3565e = drawable;
        I();
    }
}
