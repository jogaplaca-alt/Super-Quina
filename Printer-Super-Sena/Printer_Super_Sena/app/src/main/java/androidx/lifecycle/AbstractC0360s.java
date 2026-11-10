package androidx.lifecycle;

import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0360s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Object f5643k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f5644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p034j.b f5645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f5648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f5649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f5653j;

    /* JADX INFO: renamed from: androidx.lifecycle.s$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC0360s.this.f5644a) {
                obj = AbstractC0360s.this.f5649f;
                AbstractC0360s.this.f5649f = AbstractC0360s.f5643k;
            }
            AbstractC0360s.this.m(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.s$b */
    private class b extends d {
        b(InterfaceC0363v interfaceC0363v) {
            super(interfaceC0363v);
        }

        @Override // androidx.lifecycle.AbstractC0360s.d
        boolean k() {
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.s$c */
    class c extends d implements InterfaceC0356n {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final InterfaceC0358p f5656e;

        c(InterfaceC0358p interfaceC0358p, InterfaceC0363v interfaceC0363v) {
            super(interfaceC0363v);
            this.f5656e = interfaceC0358p;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            AbstractC0354l.b bVarB = this.f5656e.getLifecycle().b();
            if (bVarB == AbstractC0354l.b.DESTROYED) {
                AbstractC0360s.this.l(this.f5658a);
                return;
            }
            AbstractC0354l.b bVar = null;
            while (bVar != bVarB) {
                h(k());
                bVar = bVarB;
                bVarB = this.f5656e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC0360s.d
        void i() {
            this.f5656e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.AbstractC0360s.d
        boolean j(InterfaceC0358p interfaceC0358p) {
            return this.f5656e == interfaceC0358p;
        }

        @Override // androidx.lifecycle.AbstractC0360s.d
        boolean k() {
            return this.f5656e.getLifecycle().b().b(AbstractC0354l.b.STARTED);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.s$d */
    private abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InterfaceC0363v f5658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5660c = -1;

        d(InterfaceC0363v interfaceC0363v) {
            this.f5658a = interfaceC0363v;
        }

        void h(boolean z3) {
            if (z3 == this.f5659b) {
                return;
            }
            this.f5659b = z3;
            AbstractC0360s.this.b(z3 ? 1 : -1);
            if (this.f5659b) {
                AbstractC0360s.this.d(this);
            }
        }

        void i() {
        }

        boolean j(InterfaceC0358p interfaceC0358p) {
            return false;
        }

        abstract boolean k();
    }

    public AbstractC0360s(Object obj) {
        this.f5644a = new Object();
        this.f5645b = new p034j.b();
        this.f5646c = 0;
        this.f5649f = f5643k;
        this.f5653j = new a();
        this.f5648e = obj;
        this.f5650g = 0;
    }

    static void a(String str) {
        if (p031i.c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(d dVar) {
        if (dVar.f5659b) {
            if (!dVar.k()) {
                dVar.h(false);
                return;
            }
            int i3 = dVar.f5660c;
            int i4 = this.f5650g;
            if (i3 >= i4) {
                return;
            }
            dVar.f5660c = i4;
            dVar.f5658a.a(this.f5648e);
        }
    }

    void b(int i3) {
        int i4 = this.f5646c;
        this.f5646c = i3 + i4;
        if (this.f5647d) {
            return;
        }
        this.f5647d = true;
        while (true) {
            try {
                int i5 = this.f5646c;
                if (i4 == i5) {
                    this.f5647d = false;
                    return;
                }
                boolean z3 = i4 == 0 && i5 > 0;
                boolean z4 = i4 > 0 && i5 == 0;
                if (z3) {
                    i();
                } else if (z4) {
                    j();
                }
                i4 = i5;
            } catch (Throwable th) {
                this.f5647d = false;
                throw th;
            }
        }
    }

    void d(d dVar) {
        if (this.f5651h) {
            this.f5652i = true;
            return;
        }
        this.f5651h = true;
        do {
            this.f5652i = false;
            if (dVar != null) {
                c(dVar);
                dVar = null;
            } else {
                j.b.d dVarM = this.f5645b.m();
                while (dVarM.hasNext()) {
                    c((d) ((Map.Entry) dVarM.next()).getValue());
                    if (this.f5652i) {
                        break;
                    }
                }
            }
        } while (this.f5652i);
        this.f5651h = false;
    }

    public Object e() {
        Object obj = this.f5648e;
        if (obj != f5643k) {
            return obj;
        }
        return null;
    }

    public boolean f() {
        return this.f5646c > 0;
    }

    public void g(InterfaceC0358p interfaceC0358p, InterfaceC0363v interfaceC0363v) {
        a("observe");
        if (interfaceC0358p.getLifecycle().b() == AbstractC0354l.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC0358p, interfaceC0363v);
        d dVar = (d) this.f5645b.p(interfaceC0363v, cVar);
        if (dVar != null && !dVar.j(interfaceC0358p)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC0358p.getLifecycle().a(cVar);
    }

    public void h(InterfaceC0363v interfaceC0363v) {
        a("observeForever");
        b bVar = new b(interfaceC0363v);
        d dVar = (d) this.f5645b.p(interfaceC0363v, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.h(true);
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k(Object obj) {
        boolean z3;
        synchronized (this.f5644a) {
            z3 = this.f5649f == f5643k;
            this.f5649f = obj;
        }
        if (z3) {
            p031i.c.h().d(this.f5653j);
        }
    }

    public void l(InterfaceC0363v interfaceC0363v) {
        a("removeObserver");
        d dVar = (d) this.f5645b.q(interfaceC0363v);
        if (dVar == null) {
            return;
        }
        dVar.i();
        dVar.h(false);
    }

    protected void m(Object obj) {
        a("setValue");
        this.f5650g++;
        this.f5648e = obj;
        d(null);
    }

    public AbstractC0360s() {
        this.f5644a = new Object();
        this.f5645b = new p034j.b();
        this.f5646c = 0;
        Object obj = f5643k;
        this.f5649f = obj;
        this.f5653j = new a();
        this.f5648e = obj;
        this.f5650g = -1;
    }
}
