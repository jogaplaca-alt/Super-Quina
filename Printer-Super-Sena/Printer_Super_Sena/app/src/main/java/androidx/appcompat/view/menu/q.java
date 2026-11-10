package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.Z;

/* JADX INFO: loaded from: classes.dex */
final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f2925v = p012d.g.f9230m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f2927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f2928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f2932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Z f2933i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f2937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    View f2938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private m.a f2939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ViewTreeObserver f2940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2943s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2945u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f2934j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f2935k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2944t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.b() || q.this.f2933i.B()) {
                return;
            }
            View view = q.this.f2938n;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.f2933i.f();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.f2940p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.f2940p = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.f2940p.removeGlobalOnLayoutListener(qVar.f2934j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i3, int i4, boolean z3) {
        this.f2926b = context;
        this.f2927c = gVar;
        this.f2929e = z3;
        this.f2928d = new f(gVar, LayoutInflater.from(context), z3, f2925v);
        this.f2931g = i3;
        this.f2932h = i4;
        Resources resources = context.getResources();
        this.f2930f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(p012d.d.f9119b));
        this.f2937m = view;
        this.f2933i = new Z(context, null, i3, i4);
        gVar.c(this, context);
    }

    private boolean C() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f2941q || (view = this.f2937m) == null) {
            return false;
        }
        this.f2938n = view;
        this.f2933i.K(this);
        this.f2933i.L(this);
        this.f2933i.J(true);
        View view2 = this.f2938n;
        boolean z3 = this.f2940p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f2940p = viewTreeObserver;
        if (z3) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f2934j);
        }
        view2.addOnAttachStateChangeListener(this.f2935k);
        this.f2933i.D(view2);
        this.f2933i.G(this.f2944t);
        if (!this.f2942r) {
            this.f2943s = k.r(this.f2928d, null, this.f2926b, this.f2930f);
            this.f2942r = true;
        }
        this.f2933i.F(this.f2943s);
        this.f2933i.I(2);
        this.f2933i.H(q());
        this.f2933i.f();
        ListView listViewK = this.f2933i.k();
        listViewK.setOnKeyListener(this);
        if (this.f2945u && this.f2927c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f2926b).inflate(p012d.g.f9229l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f2927c.z());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.f2933i.o(this.f2928d);
        this.f2933i.f();
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z3) {
        if (gVar != this.f2927c) {
            return;
        }
        dismiss();
        m.a aVar = this.f2939o;
        if (aVar != null) {
            aVar.a(gVar, z3);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b() {
        return !this.f2941q && this.f2933i.b();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (b()) {
            this.f2933i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable e() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.p
    public void f() {
        if (!C()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        return this.f2933i.k();
    }

    @Override // androidx.appcompat.view.menu.m
    public void l(m.a aVar) {
        this.f2939o = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean m(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f2926b, rVar, this.f2938n, this.f2929e, this.f2931g, this.f2932h);
            lVar.j(this.f2939o);
            lVar.g(k.A(rVar));
            lVar.i(this.f2936l);
            this.f2936l = null;
            this.f2927c.e(false);
            int iC = this.f2933i.c();
            int iG = this.f2933i.g();
            if ((Gravity.getAbsoluteGravity(this.f2944t, androidx.core.view.Z.C(this.f2937m)) & 7) == 5) {
                iC += this.f2937m.getWidth();
            }
            if (lVar.n(iC, iG)) {
                m.a aVar = this.f2939o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        this.f2942r = false;
        f fVar = this.f2928d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void o(g gVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f2941q = true;
        this.f2927c.close();
        ViewTreeObserver viewTreeObserver = this.f2940p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2940p = this.f2938n.getViewTreeObserver();
            }
            this.f2940p.removeGlobalOnLayoutListener(this.f2934j);
            this.f2940p = null;
        }
        this.f2938n.removeOnAttachStateChangeListener(this.f2935k);
        PopupWindow.OnDismissListener onDismissListener = this.f2936l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(View view) {
        this.f2937m = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(boolean z3) {
        this.f2928d.d(z3);
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i3) {
        this.f2944t = i3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i3) {
        this.f2933i.a(i3);
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f2936l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(boolean z3) {
        this.f2945u = z3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void z(int i3) {
        this.f2933i.n(i3);
    }
}
