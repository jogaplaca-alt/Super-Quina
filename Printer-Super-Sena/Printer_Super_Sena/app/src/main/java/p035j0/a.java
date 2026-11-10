package p035j0;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.Z;
import androidx.fragment.app.AbstractActivityC0338f;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import androidx.fragment.app.o;
import androidx.fragment.app.w;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import p082z.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends RecyclerView.g implements p035j0.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AbstractC0354l f9697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final o f9698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final p046n.d f9699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p046n.d f9700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p046n.d f9701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g f9702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f9703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9704j;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    class ViewOnLayoutChangeListenerC0120a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f9705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p035j0.b f9706b;

        ViewOnLayoutChangeListenerC0120a(FrameLayout frameLayout, p035j0.b bVar) {
            this.f9705a = frameLayout;
            this.f9706b = bVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            if (this.f9705a.getParent() != null) {
                this.f9705a.removeOnLayoutChangeListener(this);
                a.this.L(this.f9706b);
            }
        }
    }

    class b implements InterfaceC0356n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p035j0.b f9708a;

        b(p035j0.b bVar) {
            this.f9708a = bVar;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (a.this.P()) {
                return;
            }
            interfaceC0358p.getLifecycle().c(this);
            if (Z.T(this.f9708a.N())) {
                a.this.L(this.f9708a);
            }
        }
    }

    class c extends o.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f9710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f9711b;

        c(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, FrameLayout frameLayout) {
            this.f9710a = abstractComponentCallbacksC0337e;
            this.f9711b = frameLayout;
        }

        @Override // androidx.fragment.app.o.l
        public void m(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, View view, Bundle bundle) {
            if (abstractComponentCallbacksC0337e == this.f9710a) {
                oVar.p1(this);
                a.this.w(view, this.f9711b);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f9703i = false;
            aVar.B();
        }
    }

    class e implements InterfaceC0356n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f9714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f9715b;

        e(Handler handler, Runnable runnable) {
            this.f9714a = handler;
            this.f9715b = runnable;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            if (aVar == AbstractC0354l.a.ON_DESTROY) {
                this.f9714a.removeCallbacks(this.f9715b);
                interfaceC0358p.getLifecycle().c(this);
            }
        }
    }

    private static abstract class f extends RecyclerView.i {
        private f() {
        }

        /* synthetic */ f(ViewOnLayoutChangeListenerC0120a viewOnLayoutChangeListenerC0120a) {
            this();
        }
    }

    class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewPager2.i f9717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView.i f9718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private InterfaceC0356n f9719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ViewPager2 f9720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f9721e = -1;

        /* JADX INFO: renamed from: j0.a$g$a, reason: collision with other inner class name */
        class C0121a extends ViewPager2.i {
            C0121a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void a(int i3) {
                g.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void c(int i3) {
                g.this.d(false);
            }
        }

        class b extends f {
            b() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                g.this.d(true);
            }
        }

        class c implements InterfaceC0356n {
            c() {
            }

            @Override // androidx.lifecycle.InterfaceC0356n
            public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
                g.this.d(false);
            }
        }

        g() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(RecyclerView recyclerView) {
            this.f9720d = a(recyclerView);
            C0121a c0121a = new C0121a();
            this.f9717a = c0121a;
            this.f9720d.g(c0121a);
            b bVar = new b();
            this.f9718b = bVar;
            a.this.t(bVar);
            c cVar = new c();
            this.f9719c = cVar;
            a.this.f9697c.a(cVar);
        }

        void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.f9717a);
            a.this.v(this.f9718b);
            a.this.f9697c.c(this.f9719c);
            this.f9720d = null;
        }

        void d(boolean z3) {
            int currentItem;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e;
            if (a.this.P() || this.f9720d.getScrollState() != 0 || a.this.f9699e.j() || a.this.e() == 0 || (currentItem = this.f9720d.getCurrentItem()) >= a.this.e()) {
                return;
            }
            long jF = a.this.f(currentItem);
            if ((jF != this.f9721e || z3) && (abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) a.this.f9699e.g(jF)) != null && abstractComponentCallbacksC0337e.Z()) {
                this.f9721e = jF;
                w wVarJ = a.this.f9698d.j();
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = null;
                for (int i3 = 0; i3 < a.this.f9699e.o(); i3++) {
                    long jK = a.this.f9699e.k(i3);
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = (AbstractComponentCallbacksC0337e) a.this.f9699e.p(i3);
                    if (abstractComponentCallbacksC0337e3.Z()) {
                        if (jK != this.f9721e) {
                            wVarJ.p(abstractComponentCallbacksC0337e3, AbstractC0354l.b.STARTED);
                        } else {
                            abstractComponentCallbacksC0337e2 = abstractComponentCallbacksC0337e3;
                        }
                        abstractComponentCallbacksC0337e3.F1(jK == this.f9721e);
                    }
                }
                if (abstractComponentCallbacksC0337e2 != null) {
                    wVarJ.p(abstractComponentCallbacksC0337e2, AbstractC0354l.b.RESUMED);
                }
                if (wVarJ.l()) {
                    return;
                }
                wVarJ.h();
            }
        }
    }

    public a(AbstractActivityC0338f abstractActivityC0338f) {
        this(abstractActivityC0338f.getSupportFragmentManager(), abstractActivityC0338f.getLifecycle());
    }

    private void A(int i3) {
        long jF = f(i3);
        if (this.f9699e.e(jF)) {
            return;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eY = y(i3);
        abstractComponentCallbacksC0337eY.E1((AbstractComponentCallbacksC0337e.m) this.f9700f.g(jF));
        this.f9699e.l(jF, abstractComponentCallbacksC0337eY);
    }

    private boolean C(long j3) {
        View viewU;
        if (this.f9701g.e(j3)) {
            return true;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f9699e.g(j3);
        return (abstractComponentCallbacksC0337e == null || (viewU = abstractComponentCallbacksC0337e.U()) == null || viewU.getParent() == null) ? false : true;
    }

    private static boolean D(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long E(int i3) {
        Long lValueOf = null;
        for (int i4 = 0; i4 < this.f9701g.o(); i4++) {
            if (((Integer) this.f9701g.p(i4)).intValue() == i3) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f9701g.k(i4));
            }
        }
        return lValueOf;
    }

    private static long K(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void M(long j3) {
        ViewParent parent;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f9699e.g(j3);
        if (abstractComponentCallbacksC0337e == null) {
            return;
        }
        if (abstractComponentCallbacksC0337e.U() != null && (parent = abstractComponentCallbacksC0337e.U().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!x(j3)) {
            this.f9700f.m(j3);
        }
        if (!abstractComponentCallbacksC0337e.Z()) {
            this.f9699e.m(j3);
            return;
        }
        if (P()) {
            this.f9704j = true;
            return;
        }
        if (abstractComponentCallbacksC0337e.Z() && x(j3)) {
            this.f9700f.l(j3, this.f9698d.g1(abstractComponentCallbacksC0337e));
        }
        this.f9698d.j().m(abstractComponentCallbacksC0337e).h();
        this.f9699e.m(j3);
    }

    private void N() {
        Handler handler = new Handler(Looper.getMainLooper());
        d dVar = new d();
        this.f9697c.a(new e(handler, dVar));
        handler.postDelayed(dVar, 10000L);
    }

    private void O(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, FrameLayout frameLayout) {
        this.f9698d.Y0(new c(abstractComponentCallbacksC0337e, frameLayout), false);
    }

    private static String z(String str, long j3) {
        return str + j3;
    }

    void B() {
        if (!this.f9704j || P()) {
            return;
        }
        p046n.b bVar = new p046n.b();
        for (int i3 = 0; i3 < this.f9699e.o(); i3++) {
            long jK = this.f9699e.k(i3);
            if (!x(jK)) {
                bVar.add(Long.valueOf(jK));
                this.f9701g.m(jK);
            }
        }
        if (!this.f9703i) {
            this.f9704j = false;
            for (int i4 = 0; i4 < this.f9699e.o(); i4++) {
                long jK2 = this.f9699e.k(i4);
                if (!C(jK2)) {
                    bVar.add(Long.valueOf(jK2));
                }
            }
        }
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            M(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final void l(p035j0.b bVar, int i3) {
        long jK = bVar.k();
        int id = bVar.N().getId();
        Long lE = E(id);
        if (lE != null && lE.longValue() != jK) {
            M(lE.longValue());
            this.f9701g.m(lE.longValue());
        }
        this.f9701g.l(jK, Integer.valueOf(id));
        A(i3);
        FrameLayout frameLayoutN = bVar.N();
        if (Z.T(frameLayoutN)) {
            if (frameLayoutN.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutN.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0120a(frameLayoutN, bVar));
        }
        B();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final p035j0.b n(ViewGroup viewGroup, int i3) {
        return p035j0.b.M(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final boolean p(p035j0.b bVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final void q(p035j0.b bVar) {
        L(bVar);
        B();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void s(p035j0.b bVar) {
        Long lE = E(bVar.N().getId());
        if (lE != null) {
            M(lE.longValue());
            this.f9701g.m(lE.longValue());
        }
    }

    void L(p035j0.b bVar) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f9699e.g(bVar.k());
        if (abstractComponentCallbacksC0337e == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutN = bVar.N();
        View viewU = abstractComponentCallbacksC0337e.U();
        if (!abstractComponentCallbacksC0337e.Z() && viewU != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (abstractComponentCallbacksC0337e.Z() && viewU == null) {
            O(abstractComponentCallbacksC0337e, frameLayoutN);
            return;
        }
        if (abstractComponentCallbacksC0337e.Z() && viewU.getParent() != null) {
            if (viewU.getParent() != frameLayoutN) {
                w(viewU, frameLayoutN);
                return;
            }
            return;
        }
        if (abstractComponentCallbacksC0337e.Z()) {
            w(viewU, frameLayoutN);
            return;
        }
        if (P()) {
            if (this.f9698d.B0()) {
                return;
            }
            this.f9697c.a(new b(bVar));
            return;
        }
        O(abstractComponentCallbacksC0337e, frameLayoutN);
        this.f9698d.j().d(abstractComponentCallbacksC0337e, "f" + bVar.k()).p(abstractComponentCallbacksC0337e, AbstractC0354l.b.STARTED).h();
        this.f9702h.d(false);
    }

    boolean P() {
        return this.f9698d.H0();
    }

    @Override // p035j0.c
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f9699e.o() + this.f9700f.o());
        for (int i3 = 0; i3 < this.f9699e.o(); i3++) {
            long jK = this.f9699e.k(i3);
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f9699e.g(jK);
            if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.Z()) {
                this.f9698d.X0(bundle, z("f#", jK), abstractComponentCallbacksC0337e);
            }
        }
        for (int i4 = 0; i4 < this.f9700f.o(); i4++) {
            long jK2 = this.f9700f.k(i4);
            if (x(jK2)) {
                bundle.putParcelable(z("s#", jK2), (Parcelable) this.f9700f.g(jK2));
            }
        }
        return bundle;
    }

    @Override // p035j0.c
    public final void b(Parcelable parcelable) {
        if (!this.f9700f.j() || !this.f9699e.j()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (D(str, "f#")) {
                this.f9699e.l(K(str, "f#"), this.f9698d.l0(bundle, str));
            } else {
                if (!D(str, "s#")) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jK = K(str, "s#");
                AbstractComponentCallbacksC0337e.m mVar = (AbstractComponentCallbacksC0337e.m) bundle.getParcelable(str);
                if (x(jK)) {
                    this.f9700f.l(jK, mVar);
                }
            }
        }
        if (this.f9699e.j()) {
            return;
        }
        this.f9704j = true;
        this.f9703i = true;
        B();
        N();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void k(RecyclerView recyclerView) {
        h.a(this.f9702h == null);
        g gVar = new g();
        this.f9702h = gVar;
        gVar.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void o(RecyclerView recyclerView) {
        this.f9702h.c(recyclerView);
        this.f9702h = null;
    }

    void w(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean x(long j3) {
        return j3 >= 0 && j3 < ((long) e());
    }

    public abstract AbstractComponentCallbacksC0337e y(int i3);

    public a(o oVar, AbstractC0354l abstractC0354l) {
        this.f9699e = new p046n.d();
        this.f9700f = new p046n.d();
        this.f9701g = new p046n.d();
        this.f9703i = false;
        this.f9704j = false;
        this.f9698d = oVar;
        this.f9697c = abstractC0354l;
        super.u(true);
    }
}
