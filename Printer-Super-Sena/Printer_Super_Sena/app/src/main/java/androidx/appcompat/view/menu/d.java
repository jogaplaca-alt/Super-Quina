package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.Y;
import androidx.appcompat.widget.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final int f2781B = p012d.g.f9222e;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    boolean f2782A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Handler f2788g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f2796o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f2797p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2799r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2800s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2801t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f2802u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private m.a f2805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ViewTreeObserver f2806y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2807z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f2789h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final List f2790i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f2791j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f2792k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Y f2793l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2794m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2795n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f2803v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2798q = G();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.b() || d.this.f2790i.size() <= 0 || ((C0043d) d.this.f2790i.get(0)).f2815a.B()) {
                return;
            }
            View view = d.this.f2797p;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator it = d.this.f2790i.iterator();
            while (it.hasNext()) {
                ((C0043d) it.next()).f2815a.f();
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
            ViewTreeObserver viewTreeObserver = d.this.f2806y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.f2806y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.f2806y.removeGlobalOnLayoutListener(dVar.f2791j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements Y {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0043d f2811a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f2812b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ g f2813c;

            a(C0043d c0043d, MenuItem menuItem, g gVar) {
                this.f2811a = c0043d;
                this.f2812b = menuItem;
                this.f2813c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0043d c0043d = this.f2811a;
                if (c0043d != null) {
                    d.this.f2782A = true;
                    c0043d.f2816b.e(false);
                    d.this.f2782A = false;
                }
                if (this.f2812b.isEnabled() && this.f2812b.hasSubMenu()) {
                    this.f2813c.N(this.f2812b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.Y
        public void e(g gVar, MenuItem menuItem) {
            d.this.f2788g.removeCallbacksAndMessages(null);
            int size = d.this.f2790i.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (gVar == ((C0043d) d.this.f2790i.get(i3)).f2816b) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return;
            }
            int i4 = i3 + 1;
            d.this.f2788g.postAtTime(new a(i4 < d.this.f2790i.size() ? (C0043d) d.this.f2790i.get(i4) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.Y
        public void h(g gVar, MenuItem menuItem) {
            d.this.f2788g.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    private static class C0043d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Z f2815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f2816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2817c;

        public C0043d(Z z3, g gVar, int i3) {
            this.f2815a = z3;
            this.f2816b = gVar;
            this.f2817c = i3;
        }

        public ListView a() {
            return this.f2815a.k();
        }
    }

    public d(Context context, View view, int i3, int i4, boolean z3) {
        this.f2783b = context;
        this.f2796o = view;
        this.f2785d = i3;
        this.f2786e = i4;
        this.f2787f = z3;
        Resources resources = context.getResources();
        this.f2784c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(p012d.d.f9119b));
        this.f2788g = new Handler();
    }

    private Z C() {
        Z z3 = new Z(this.f2783b, null, this.f2785d, this.f2786e);
        z3.U(this.f2793l);
        z3.L(this);
        z3.K(this);
        z3.D(this.f2796o);
        z3.G(this.f2795n);
        z3.J(true);
        z3.I(2);
        return z3;
    }

    private int D(g gVar) {
        int size = this.f2790i.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (gVar == ((C0043d) this.f2790i.get(i3)).f2816b) {
                return i3;
            }
        }
        return -1;
    }

    private MenuItem E(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = gVar.getItem(i3);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View F(C0043d c0043d, g gVar) {
        f fVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemE = E(c0043d.f2816b, gVar);
        if (menuItemE == null) {
            return null;
        }
        ListView listViewA = c0043d.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            headersCount = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (menuItemE == fVar.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int G() {
        return androidx.core.view.Z.C(this.f2796o) == 1 ? 0 : 1;
    }

    private int H(int i3) {
        List list = this.f2790i;
        ListView listViewA = ((C0043d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f2797p.getWindowVisibleDisplayFrame(rect);
        if (this.f2798q == 1) {
            return (iArr[0] + listViewA.getWidth()) + i3 > rect.right ? 0 : 1;
        }
        return iArr[0] - i3 < 0 ? 1 : 0;
    }

    private void I(g gVar) {
        C0043d c0043d;
        View viewF;
        int i3;
        int i4;
        int i5;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2783b);
        f fVar = new f(gVar, layoutInflaterFrom, this.f2787f, f2781B);
        if (!b() && this.f2803v) {
            fVar.d(true);
        } else if (b()) {
            fVar.d(k.A(gVar));
        }
        int iR = k.r(fVar, null, this.f2783b, this.f2784c);
        Z zC = C();
        zC.o(fVar);
        zC.F(iR);
        zC.G(this.f2795n);
        if (this.f2790i.size() > 0) {
            List list = this.f2790i;
            c0043d = (C0043d) list.get(list.size() - 1);
            viewF = F(c0043d, gVar);
        } else {
            c0043d = null;
            viewF = null;
        }
        if (viewF != null) {
            zC.V(false);
            zC.S(null);
            int iH = H(iR);
            boolean z3 = iH == 1;
            this.f2798q = iH;
            if (Build.VERSION.SDK_INT >= 26) {
                zC.D(viewF);
                i4 = 0;
                i3 = 0;
            } else {
                int[] iArr = new int[2];
                this.f2796o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewF.getLocationOnScreen(iArr2);
                if ((this.f2795n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f2796o.getWidth();
                    iArr2[0] = iArr2[0] + viewF.getWidth();
                }
                i3 = iArr2[0] - iArr[0];
                i4 = iArr2[1] - iArr[1];
            }
            if ((this.f2795n & 5) == 5) {
                if (z3) {
                    i5 = i3 + iR;
                } else {
                    iR = viewF.getWidth();
                    i5 = i3 - iR;
                }
            } else if (z3) {
                iR = viewF.getWidth();
                i5 = i3 + iR;
            } else {
                i5 = i3 - iR;
            }
            zC.a(i5);
            zC.N(true);
            zC.n(i4);
        } else {
            if (this.f2799r) {
                zC.a(this.f2801t);
            }
            if (this.f2800s) {
                zC.n(this.f2802u);
            }
            zC.H(q());
        }
        this.f2790i.add(new C0043d(zC, gVar, this.f2798q));
        zC.f();
        ListView listViewK = zC.k();
        listViewK.setOnKeyListener(this);
        if (c0043d == null && this.f2804w && gVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(p012d.g.f9229l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.z());
            listViewK.addHeaderView(frameLayout, null, false);
            zC.f();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z3) {
        int iD = D(gVar);
        if (iD < 0) {
            return;
        }
        int i3 = iD + 1;
        if (i3 < this.f2790i.size()) {
            ((C0043d) this.f2790i.get(i3)).f2816b.e(false);
        }
        C0043d c0043d = (C0043d) this.f2790i.remove(iD);
        c0043d.f2816b.Q(this);
        if (this.f2782A) {
            c0043d.f2815a.T(null);
            c0043d.f2815a.E(0);
        }
        c0043d.f2815a.dismiss();
        int size = this.f2790i.size();
        if (size > 0) {
            this.f2798q = ((C0043d) this.f2790i.get(size - 1)).f2817c;
        } else {
            this.f2798q = G();
        }
        if (size != 0) {
            if (z3) {
                ((C0043d) this.f2790i.get(0)).f2816b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.f2805x;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f2806y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f2806y.removeGlobalOnLayoutListener(this.f2791j);
            }
            this.f2806y = null;
        }
        this.f2797p.removeOnAttachStateChangeListener(this.f2792k);
        this.f2807z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b() {
        return this.f2790i.size() > 0 && ((C0043d) this.f2790i.get(0)).f2815a.b();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.f2790i.size();
        if (size > 0) {
            C0043d[] c0043dArr = (C0043d[]) this.f2790i.toArray(new C0043d[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                C0043d c0043d = c0043dArr[i3];
                if (c0043d.f2815a.b()) {
                    c0043d.f2815a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable e() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.p
    public void f() {
        if (b()) {
            return;
        }
        Iterator it = this.f2789h.iterator();
        while (it.hasNext()) {
            I((g) it.next());
        }
        this.f2789h.clear();
        View view = this.f2796o;
        this.f2797p = view;
        if (view != null) {
            boolean z3 = this.f2806y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f2806y = viewTreeObserver;
            if (z3) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f2791j);
            }
            this.f2797p.addOnAttachStateChangeListener(this.f2792k);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        if (this.f2790i.isEmpty()) {
            return null;
        }
        List list = this.f2790i;
        return ((C0043d) list.get(list.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void l(m.a aVar) {
        this.f2805x = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean m(r rVar) {
        for (C0043d c0043d : this.f2790i) {
            if (rVar == c0043d.f2816b) {
                c0043d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        o(rVar);
        m.a aVar = this.f2805x;
        if (aVar != null) {
            aVar.b(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void n(boolean z3) {
        Iterator it = this.f2790i.iterator();
        while (it.hasNext()) {
            k.B(((C0043d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void o(g gVar) {
        gVar.c(this, this.f2783b);
        if (b()) {
            I(gVar);
        } else {
            this.f2789h.add(gVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0043d c0043d;
        int size = this.f2790i.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                c0043d = null;
                break;
            }
            c0043d = (C0043d) this.f2790i.get(i3);
            if (!c0043d.f2815a.b()) {
                break;
            } else {
                i3++;
            }
        }
        if (c0043d != null) {
            c0043d.f2816b.e(false);
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
    protected boolean p() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(View view) {
        if (this.f2796o != view) {
            this.f2796o = view;
            this.f2795n = androidx.core.view.r.b(this.f2794m, androidx.core.view.Z.C(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(boolean z3) {
        this.f2803v = z3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i3) {
        if (this.f2794m != i3) {
            this.f2794m = i3;
            this.f2795n = androidx.core.view.r.b(i3, androidx.core.view.Z.C(this.f2796o));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i3) {
        this.f2799r = true;
        this.f2801t = i3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f2807z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(boolean z3) {
        this.f2804w = z3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void z(int i3) {
        this.f2800s = true;
        this.f2802u = i3;
    }
}
