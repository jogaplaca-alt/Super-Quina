package U0;

import S0.i;
import S0.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.Z;
import com.google.android.material.internal.A;
import com.google.android.material.internal.C;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import p042l1.g;
import p042l1.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements A.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f1983n = j.f1727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f1984o = S0.a.f1511c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f1985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final A f1987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f1988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f1989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f1990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f1991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f1993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f1994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f1995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WeakReference f1996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private WeakReference f1997m;

    /* JADX INFO: renamed from: U0.a$a, reason: collision with other inner class name */
    class RunnableC0026a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f1999b;

        RunnableC0026a(View view, FrameLayout frameLayout) {
            this.f1998a = view;
            this.f1999b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.N(this.f1998a, this.f1999b);
        }
    }

    private a(Context context, int i3, int i4, int i5, d.a aVar) {
        this.f1985a = new WeakReference(context);
        C.c(context);
        this.f1988d = new Rect();
        A a3 = new A(this);
        this.f1987c = a3;
        a3.g().setTextAlign(Paint.Align.CENTER);
        d dVar = new d(context, i3, i4, i5, aVar);
        this.f1989e = dVar;
        this.f1986b = new g(k.b(context, x() ? dVar.m() : dVar.i(), x() ? dVar.l() : dVar.h()).m());
        K();
    }

    private boolean A() {
        FrameLayout frameLayoutI = i();
        return frameLayoutI != null && frameLayoutI.getId() == S0.e.f1653v;
    }

    private void B() {
        this.f1987c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void C() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f1989e.e());
        if (this.f1986b.v() != colorStateListValueOf) {
            this.f1986b.V(colorStateListValueOf);
            invalidateSelf();
        }
    }

    private void D() {
        this.f1987c.l(true);
        F();
        O();
        invalidateSelf();
    }

    private void E() {
        WeakReference weakReference = this.f1996l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f1996l.get();
        WeakReference weakReference2 = this.f1997m;
        N(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    private void F() {
        Context context = (Context) this.f1985a.get();
        if (context == null) {
            return;
        }
        this.f1986b.setShapeAppearanceModel(k.b(context, x() ? this.f1989e.m() : this.f1989e.i(), x() ? this.f1989e.l() : this.f1989e.h()).m());
        invalidateSelf();
    }

    private void G() {
        p030h1.d dVar;
        Context context = (Context) this.f1985a.get();
        if (context == null || this.f1987c.e() == (dVar = new p030h1.d(context, this.f1989e.z()))) {
            return;
        }
        this.f1987c.k(dVar, context);
        H();
        O();
        invalidateSelf();
    }

    private void H() {
        this.f1987c.g().setColor(this.f1989e.j());
        invalidateSelf();
    }

    private void I() {
        P();
        this.f1987c.l(true);
        O();
        invalidateSelf();
    }

    private void J() {
        boolean zF = this.f1989e.F();
        setVisible(zF, false);
        if (!e.f2042a || i() == null || zF) {
            return;
        }
        ((ViewGroup) i().getParent()).invalidate();
    }

    private void K() {
        F();
        G();
        I();
        D();
        B();
        C();
        H();
        E();
        O();
        J();
    }

    private void L(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != S0.e.f1653v) {
            WeakReference weakReference = this.f1997m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                M(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(S0.e.f1653v);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f1997m = new WeakReference(frameLayout);
                frameLayout.post(new RunnableC0026a(view, frameLayout));
            }
        }
    }

    private static void M(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void O() {
        Context context = (Context) this.f1985a.get();
        WeakReference weakReference = this.f1996l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f1988d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.f1997m;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null || e.f2042a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        c(rect2, view);
        e.d(this.f1988d, this.f1990f, this.f1991g, this.f1994j, this.f1995k);
        float f3 = this.f1993i;
        if (f3 != -1.0f) {
            this.f1986b.S(f3);
        }
        if (rect.equals(this.f1988d)) {
            return;
        }
        this.f1986b.setBounds(this.f1988d);
    }

    private void P() {
        if (l() == -2) {
            this.f1992h = m();
            return;
        }
        double dL = l();
        Double.isNaN(dL);
        this.f1992h = ((int) Math.pow(10.0d, dL - 1.0d)) - 1;
    }

    private void b(View view) {
        float y3;
        float x3;
        View viewI = i();
        if (viewI == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y4 = view.getY();
            x3 = view.getX();
            viewI = (View) view.getParent();
            y3 = y4;
        } else if (!A()) {
            y3 = 0.0f;
            x3 = 0.0f;
        } else {
            if (!(viewI.getParent() instanceof View)) {
                return;
            }
            y3 = viewI.getY();
            x3 = viewI.getX();
            viewI = (View) viewI.getParent();
        }
        float fU = u(viewI, y3);
        float fK = k(viewI, x3);
        float fG = g(viewI, y3);
        float fQ = q(viewI, x3);
        if (fU < 0.0f) {
            this.f1991g += Math.abs(fU);
        }
        if (fK < 0.0f) {
            this.f1990f += Math.abs(fK);
        }
        if (fG > 0.0f) {
            this.f1991g -= Math.abs(fG);
        }
        if (fQ > 0.0f) {
            this.f1990f -= Math.abs(fQ);
        }
    }

    private void c(Rect rect, View view) {
        float f3 = x() ? this.f1989e.f2004d : this.f1989e.f2003c;
        this.f1993i = f3;
        if (f3 != -1.0f) {
            this.f1994j = f3;
            this.f1995k = f3;
        } else {
            this.f1994j = Math.round((x() ? this.f1989e.f2007g : this.f1989e.f2005e) / 2.0f);
            this.f1995k = Math.round((x() ? this.f1989e.f2008h : this.f1989e.f2006f) / 2.0f);
        }
        if (x()) {
            String strF = f();
            this.f1994j = Math.max(this.f1994j, (this.f1987c.h(strF) / 2.0f) + this.f1989e.g());
            float fMax = Math.max(this.f1995k, (this.f1987c.f(strF) / 2.0f) + this.f1989e.k());
            this.f1995k = fMax;
            this.f1994j = Math.max(this.f1994j, fMax);
        }
        int iW = w();
        int iF = this.f1989e.f();
        if (iF == 8388691 || iF == 8388693) {
            this.f1991g = rect.bottom - iW;
        } else {
            this.f1991g = rect.top + iW;
        }
        int iV = v();
        int iF2 = this.f1989e.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f1990f = Z.C(view) == 0 ? (rect.left - this.f1994j) + iV : (rect.right + this.f1994j) - iV;
        } else {
            this.f1990f = Z.C(view) == 0 ? (rect.right + this.f1994j) - iV : (rect.left - this.f1994j) + iV;
        }
        if (this.f1989e.E()) {
            b(view);
        }
    }

    public static a d(Context context) {
        return new a(context, 0, f1984o, f1983n, null);
    }

    private void e(Canvas canvas) {
        String strF = f();
        if (strF != null) {
            Rect rect = new Rect();
            this.f1987c.g().getTextBounds(strF, 0, strF.length(), rect);
            float fExactCenterY = this.f1991g - rect.exactCenterY();
            canvas.drawText(strF, this.f1990f, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.f1987c.g());
        }
    }

    private String f() {
        if (z()) {
            return s();
        }
        if (y()) {
            return o();
        }
        return null;
    }

    private float g(View view, float f3) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f1991g + this.f1995k) - (((View) view.getParent()).getHeight() - view.getY())) + f3;
    }

    private CharSequence j() {
        return this.f1989e.p();
    }

    private float k(View view, float f3) {
        return (this.f1990f - this.f1994j) + view.getX() + f3;
    }

    private String o() {
        if (this.f1992h == -2 || n() <= this.f1992h) {
            return NumberFormat.getInstance(this.f1989e.x()).format(n());
        }
        Context context = (Context) this.f1985a.get();
        return context == null ? "" : String.format(this.f1989e.x(), context.getString(i.f1703p), Integer.valueOf(this.f1992h), "+");
    }

    private String p() {
        Context context;
        if (this.f1989e.q() == 0 || (context = (Context) this.f1985a.get()) == null) {
            return null;
        }
        return (this.f1992h == -2 || n() <= this.f1992h) ? context.getResources().getQuantityString(this.f1989e.q(), n(), Integer.valueOf(n())) : context.getString(this.f1989e.n(), Integer.valueOf(this.f1992h));
    }

    private float q(View view, float f3) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f1990f + this.f1994j) - (((View) view.getParent()).getWidth() - view.getX())) + f3;
    }

    private String s() {
        String strR = r();
        int iL = l();
        if (iL == -2 || strR == null || strR.length() <= iL) {
            return strR;
        }
        Context context = (Context) this.f1985a.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(i.f1696i), strR.substring(0, iL - 1), "…");
    }

    private CharSequence t() {
        CharSequence charSequenceO = this.f1989e.o();
        return charSequenceO != null ? charSequenceO : r();
    }

    private float u(View view, float f3) {
        return (this.f1991g - this.f1995k) + view.getY() + f3;
    }

    private int v() {
        int iR = x() ? this.f1989e.r() : this.f1989e.s();
        if (this.f1989e.f2011k == 1) {
            iR += x() ? this.f1989e.f2010j : this.f1989e.f2009i;
        }
        return iR + this.f1989e.b();
    }

    private int w() {
        int iB = this.f1989e.B();
        if (x()) {
            iB = this.f1989e.A();
            Context context = (Context) this.f1985a.get();
            if (context != null) {
                iB = T0.a.c(iB, iB - this.f1989e.t(), T0.a.b(0.0f, 1.0f, 0.3f, 1.0f, p030h1.c.e(context) - 1.0f));
            }
        }
        if (this.f1989e.f2011k == 0) {
            iB -= Math.round(this.f1995k);
        }
        return iB + this.f1989e.c();
    }

    private boolean x() {
        return z() || y();
    }

    public void N(View view, FrameLayout frameLayout) {
        this.f1996l = new WeakReference(view);
        boolean z3 = e.f2042a;
        if (z3 && frameLayout == null) {
            L(view);
        } else {
            this.f1997m = new WeakReference(frameLayout);
        }
        if (!z3) {
            M(view);
        }
        O();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.A.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f1986b.draw(canvas);
        if (x()) {
            e(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1989e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1988d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1988d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence h() {
        if (!isVisible()) {
            return null;
        }
        if (z()) {
            return t();
        }
        return y() ? p() : j();
    }

    public FrameLayout i() {
        WeakReference weakReference = this.f1997m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int l() {
        return this.f1989e.u();
    }

    public int m() {
        return this.f1989e.v();
    }

    public int n() {
        if (this.f1989e.C()) {
            return this.f1989e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.A.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public String r() {
        return this.f1989e.y();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f1989e.H(i3);
        B();
    }

    public boolean y() {
        return !this.f1989e.D() && this.f1989e.C();
    }

    public boolean z() {
        return this.f1989e.D();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
