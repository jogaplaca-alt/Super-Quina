package androidx.activity;

import K1.C0238g;
import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f2271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p082z.a f2272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0238g f2273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q f2274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnBackInvokedCallback f2275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnBackInvokedDispatcher f2276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2278h;

    static final class a extends S1.l implements R1.l {
        a() {
            super(1);
        }

        @Override // R1.l
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            d((androidx.activity.b) obj);
            return J1.l.f1194a;
        }

        public final void d(androidx.activity.b bVar) {
            S1.k.e(bVar, "backEvent");
            r.this.m(bVar);
        }
    }

    static final class b extends S1.l implements R1.l {
        b() {
            super(1);
        }

        @Override // R1.l
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            d((androidx.activity.b) obj);
            return J1.l.f1194a;
        }

        public final void d(androidx.activity.b bVar) {
            S1.k.e(bVar, "backEvent");
            r.this.l(bVar);
        }
    }

    static final class c extends S1.l implements R1.a {
        c() {
            super(0);
        }

        @Override // R1.a
        public /* bridge */ /* synthetic */ Object a() {
            d();
            return J1.l.f1194a;
        }

        public final void d() {
            r.this.k();
        }
    }

    static final class d extends S1.l implements R1.a {
        d() {
            super(0);
        }

        @Override // R1.a
        public /* bridge */ /* synthetic */ Object a() {
            d();
            return J1.l.f1194a;
        }

        public final void d() {
            r.this.j();
        }
    }

    static final class e extends S1.l implements R1.a {
        e() {
            super(0);
        }

        @Override // R1.a
        public /* bridge */ /* synthetic */ Object a() {
            d();
            return J1.l.f1194a;
        }

        public final void d() {
            r.this.k();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f2284a = new f();

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(R1.a aVar) {
            S1.k.e(aVar, "$onBackInvoked");
            aVar.a();
        }

        public final OnBackInvokedCallback b(final R1.a aVar) {
            S1.k.e(aVar, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.s
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    r.f.c(aVar);
                }
            };
        }

        public final void d(Object obj, int i3, Object obj2) {
            S1.k.e(obj, "dispatcher");
            S1.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            S1.k.e(obj, "dispatcher");
            S1.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f2285a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ R1.l f2286a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ R1.l f2287b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ R1.a f2288c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ R1.a f2289d;

            a(R1.l lVar, R1.l lVar2, R1.a aVar, R1.a aVar2) {
                this.f2286a = lVar;
                this.f2287b = lVar2;
                this.f2288c = aVar;
                this.f2289d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f2289d.a();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f2288c.a();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                S1.k.e(backEvent, "backEvent");
                this.f2287b.c(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                S1.k.e(backEvent, "backEvent");
                this.f2286a.c(new androidx.activity.b(backEvent));
            }
        }

        private g() {
        }

        public final OnBackInvokedCallback a(R1.l lVar, R1.l lVar2, R1.a aVar, R1.a aVar2) {
            S1.k.e(lVar, "onBackStarted");
            S1.k.e(lVar2, "onBackProgressed");
            S1.k.e(aVar, "onBackInvoked");
            S1.k.e(aVar2, "onBackCancelled");
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    private final class h implements InterfaceC0356n, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AbstractC0354l f2290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q f2291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.activity.c f2292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f2293d;

        public h(r rVar, AbstractC0354l abstractC0354l, q qVar) {
            S1.k.e(abstractC0354l, "lifecycle");
            S1.k.e(qVar, "onBackPressedCallback");
            this.f2293d = rVar;
            this.f2290a = abstractC0354l;
            this.f2291b = qVar;
            abstractC0354l.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f2290a.c(this);
            this.f2291b.i(this);
            androidx.activity.c cVar = this.f2292c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f2292c = null;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            S1.k.e(interfaceC0358p, "source");
            S1.k.e(aVar, "event");
            if (aVar == AbstractC0354l.a.ON_START) {
                this.f2292c = this.f2293d.i(this.f2291b);
                return;
            }
            if (aVar != AbstractC0354l.a.ON_STOP) {
                if (aVar == AbstractC0354l.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f2292c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    private final class i implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f2294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f2295b;

        public i(r rVar, q qVar) {
            S1.k.e(qVar, "onBackPressedCallback");
            this.f2295b = rVar;
            this.f2294a = qVar;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f2295b.f2273c.remove(this.f2294a);
            if (S1.k.a(this.f2295b.f2274d, this.f2294a)) {
                this.f2294a.c();
                this.f2295b.f2274d = null;
            }
            this.f2294a.i(this);
            R1.a aVarB = this.f2294a.b();
            if (aVarB != null) {
                aVarB.a();
            }
            this.f2294a.k(null);
        }
    }

    /* synthetic */ class j extends S1.j implements R1.a {
        j(Object obj) {
            super(0, obj, r.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // R1.a
        public /* bridge */ /* synthetic */ Object a() {
            i();
            return J1.l.f1194a;
        }

        public final void i() {
            ((r) this.f1931b).p();
        }
    }

    /* synthetic */ class k extends S1.j implements R1.a {
        k(Object obj) {
            super(0, obj, r.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // R1.a
        public /* bridge */ /* synthetic */ Object a() {
            i();
            return J1.l.f1194a;
        }

        public final void i() {
            ((r) this.f1931b).p();
        }
    }

    public r(Runnable runnable, p082z.a aVar) {
        this.f2271a = runnable;
        this.f2272b = aVar;
        this.f2273c = new C0238g();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            this.f2275e = i3 >= 34 ? g.f2285a.a(new a(), new b(), new c(), new d()) : f.f2284a.b(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        Object objPrevious;
        C0238g c0238g = this.f2273c;
        ListIterator<E> listIterator = c0238g.listIterator(c0238g.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((q) objPrevious).g());
        q qVar = (q) objPrevious;
        this.f2274d = null;
        if (qVar != null) {
            qVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(androidx.activity.b bVar) {
        Object objPrevious;
        C0238g c0238g = this.f2273c;
        ListIterator<E> listIterator = c0238g.listIterator(c0238g.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((q) objPrevious).g());
        q qVar = (q) objPrevious;
        if (qVar != null) {
            qVar.e(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        C0238g c0238g = this.f2273c;
        ListIterator<E> listIterator = c0238g.listIterator(c0238g.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((q) objPrevious).g());
        q qVar = (q) objPrevious;
        this.f2274d = qVar;
        if (qVar != null) {
            qVar.f(bVar);
        }
    }

    private final void o(boolean z3) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f2276f;
        OnBackInvokedCallback onBackInvokedCallback = this.f2275e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z3 && !this.f2277g) {
            f.f2284a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f2277g = true;
        } else {
            if (z3 || !this.f2277g) {
                return;
            }
            f.f2284a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f2277g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        boolean z3 = this.f2278h;
        C0238g c0238g = this.f2273c;
        boolean z4 = false;
        if (!(c0238g instanceof Collection) || !c0238g.isEmpty()) {
            Iterator<E> it = c0238g.iterator();
            while (it.hasNext()) {
                if (((q) it.next()).g()) {
                    z4 = true;
                    break;
                }
            }
        }
        this.f2278h = z4;
        if (z4 != z3) {
            p082z.a aVar = this.f2272b;
            if (aVar != null) {
                aVar.a(Boolean.valueOf(z4));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z4);
            }
        }
    }

    public final void h(InterfaceC0358p interfaceC0358p, q qVar) {
        S1.k.e(interfaceC0358p, "owner");
        S1.k.e(qVar, "onBackPressedCallback");
        AbstractC0354l lifecycle = interfaceC0358p.getLifecycle();
        if (lifecycle.b() == AbstractC0354l.b.DESTROYED) {
            return;
        }
        qVar.a(new h(this, lifecycle, qVar));
        p();
        qVar.k(new j(this));
    }

    public final androidx.activity.c i(q qVar) {
        S1.k.e(qVar, "onBackPressedCallback");
        this.f2273c.add(qVar);
        i iVar = new i(this, qVar);
        qVar.a(iVar);
        p();
        qVar.k(new k(this));
        return iVar;
    }

    public final void k() {
        Object objPrevious;
        C0238g c0238g = this.f2273c;
        ListIterator<E> listIterator = c0238g.listIterator(c0238g.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((q) objPrevious).g());
        q qVar = (q) objPrevious;
        this.f2274d = null;
        if (qVar != null) {
            qVar.d();
            return;
        }
        Runnable runnable = this.f2271a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        S1.k.e(onBackInvokedDispatcher, "invoker");
        this.f2276f = onBackInvokedDispatcher;
        o(this.f2278h);
    }

    public r(Runnable runnable) {
        this(runnable, null);
    }
}
