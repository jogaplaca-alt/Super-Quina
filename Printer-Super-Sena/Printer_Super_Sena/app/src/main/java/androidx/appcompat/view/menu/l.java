package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m.a f2919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k f2920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f2922l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    static class b {
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public l(Context context, g gVar, View view, boolean z3, int i3) {
        this(context, gVar, view, z3, i3, 0);
    }

    private k a() {
        Display defaultDisplay = ((WindowManager) this.f2911a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        k dVar = Math.min(point.x, point.y) >= this.f2911a.getResources().getDimensionPixelSize(p012d.d.f9118a) ? new d(this.f2911a, this.f2916f, this.f2914d, this.f2915e, this.f2913c) : new q(this.f2911a, this.f2912b, this.f2916f, this.f2914d, this.f2915e, this.f2913c);
        dVar.o(this.f2912b);
        dVar.x(this.f2922l);
        dVar.s(this.f2916f);
        dVar.l(this.f2919i);
        dVar.u(this.f2918h);
        dVar.v(this.f2917g);
        return dVar;
    }

    private void l(int i3, int i4, boolean z3, boolean z4) {
        k kVarC = c();
        kVarC.y(z4);
        if (z3) {
            if ((androidx.core.view.r.b(this.f2917g, Z.C(this.f2916f)) & 7) == 5) {
                i3 -= this.f2916f.getWidth();
            }
            kVarC.w(i3);
            kVarC.z(i4);
            int i5 = (int) ((this.f2911a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            kVarC.t(new Rect(i3 - i5, i4 - i5, i3 + i5, i4 + i5));
        }
        kVarC.f();
    }

    public void b() {
        if (d()) {
            this.f2920j.dismiss();
        }
    }

    public k c() {
        if (this.f2920j == null) {
            this.f2920j = a();
        }
        return this.f2920j;
    }

    public boolean d() {
        k kVar = this.f2920j;
        return kVar != null && kVar.b();
    }

    protected void e() {
        this.f2920j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2921k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f2916f = view;
    }

    public void g(boolean z3) {
        this.f2918h = z3;
        k kVar = this.f2920j;
        if (kVar != null) {
            kVar.u(z3);
        }
    }

    public void h(int i3) {
        this.f2917g = i3;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f2921k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f2919i = aVar;
        k kVar = this.f2920j;
        if (kVar != null) {
            kVar.l(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f2916f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i3, int i4) {
        if (d()) {
            return true;
        }
        if (this.f2916f == null) {
            return false;
        }
        l(i3, i4, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z3, int i3, int i4) {
        this.f2917g = 8388611;
        this.f2922l = new a();
        this.f2911a = context;
        this.f2912b = gVar;
        this.f2916f = view;
        this.f2913c = z3;
        this.f2914d = i3;
        this.f2915e = i4;
    }
}
