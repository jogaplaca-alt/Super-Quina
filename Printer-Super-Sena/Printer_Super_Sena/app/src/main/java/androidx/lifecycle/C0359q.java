package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0359q extends AbstractC0354l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f5628k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p034j.a f5630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0354l.b f5631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference f5632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f5636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Y1.a f5637j;

    /* JADX INFO: renamed from: androidx.lifecycle.q$a */
    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final AbstractC0354l.b a(AbstractC0354l.b bVar, AbstractC0354l.b bVar2) {
            S1.k.e(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.q$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AbstractC0354l.b f5638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private InterfaceC0356n f5639b;

        public b(InterfaceC0357o interfaceC0357o, AbstractC0354l.b bVar) {
            S1.k.e(bVar, "initialState");
            S1.k.b(interfaceC0357o);
            this.f5639b = r.f(interfaceC0357o);
            this.f5638a = bVar;
        }

        public final void a(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            S1.k.e(aVar, "event");
            AbstractC0354l.b bVarC = aVar.c();
            this.f5638a = C0359q.f5628k.a(this.f5638a, bVarC);
            InterfaceC0356n interfaceC0356n = this.f5639b;
            S1.k.b(interfaceC0358p);
            interfaceC0356n.d(interfaceC0358p, aVar);
            this.f5638a = bVarC;
        }

        public final AbstractC0354l.b b() {
            return this.f5638a;
        }
    }

    private C0359q(InterfaceC0358p interfaceC0358p, boolean z3) {
        this.f5629b = z3;
        this.f5630c = new p034j.a();
        AbstractC0354l.b bVar = AbstractC0354l.b.INITIALIZED;
        this.f5631d = bVar;
        this.f5636i = new ArrayList();
        this.f5632e = new WeakReference(interfaceC0358p);
        this.f5637j = Y1.c.a(bVar);
    }

    private final void d(InterfaceC0358p interfaceC0358p) {
        Iterator itJ = this.f5630c.j();
        S1.k.d(itJ, "observerMap.descendingIterator()");
        while (itJ.hasNext() && !this.f5635h) {
            Map.Entry entry = (Map.Entry) itJ.next();
            S1.k.d(entry, "next()");
            InterfaceC0357o interfaceC0357o = (InterfaceC0357o) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f5631d) > 0 && !this.f5635h && this.f5630c.contains(interfaceC0357o)) {
                AbstractC0354l.a aVarA = AbstractC0354l.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.c());
                bVar.a(interfaceC0358p, aVarA);
                k();
            }
        }
    }

    private final AbstractC0354l.b e(InterfaceC0357o interfaceC0357o) {
        b bVar;
        Map.Entry entryR = this.f5630c.r(interfaceC0357o);
        AbstractC0354l.b bVar2 = null;
        AbstractC0354l.b bVarB = (entryR == null || (bVar = (b) entryR.getValue()) == null) ? null : bVar.b();
        if (!this.f5636i.isEmpty()) {
            ArrayList arrayList = this.f5636i;
            bVar2 = (AbstractC0354l.b) arrayList.get(arrayList.size() - 1);
        }
        a aVar = f5628k;
        return aVar.a(aVar.a(this.f5631d, bVarB), bVar2);
    }

    private final void f(String str) {
        if (!this.f5629b || p031i.c.h().c()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void g(InterfaceC0358p interfaceC0358p) {
        j.b.d dVarM = this.f5630c.m();
        S1.k.d(dVarM, "observerMap.iteratorWithAdditions()");
        while (dVarM.hasNext() && !this.f5635h) {
            Map.Entry entry = (Map.Entry) dVarM.next();
            InterfaceC0357o interfaceC0357o = (InterfaceC0357o) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f5631d) < 0 && !this.f5635h && this.f5630c.contains(interfaceC0357o)) {
                l(bVar.b());
                AbstractC0354l.a aVarB = AbstractC0354l.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC0358p, aVarB);
                k();
            }
        }
    }

    private final boolean i() {
        if (this.f5630c.size() == 0) {
            return true;
        }
        Map.Entry entryK = this.f5630c.k();
        S1.k.b(entryK);
        AbstractC0354l.b bVarB = ((b) entryK.getValue()).b();
        Map.Entry entryN = this.f5630c.n();
        S1.k.b(entryN);
        AbstractC0354l.b bVarB2 = ((b) entryN.getValue()).b();
        return bVarB == bVarB2 && this.f5631d == bVarB2;
    }

    private final void j(AbstractC0354l.b bVar) {
        AbstractC0354l.b bVar2 = this.f5631d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0354l.b.INITIALIZED && bVar == AbstractC0354l.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f5631d + " in component " + this.f5632e.get()).toString());
        }
        this.f5631d = bVar;
        if (this.f5634g || this.f5633f != 0) {
            this.f5635h = true;
            return;
        }
        this.f5634g = true;
        n();
        this.f5634g = false;
        if (this.f5631d == AbstractC0354l.b.DESTROYED) {
            this.f5630c = new p034j.a();
        }
    }

    private final void k() {
        ArrayList arrayList = this.f5636i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void l(AbstractC0354l.b bVar) {
        this.f5636i.add(bVar);
    }

    private final void n() {
        InterfaceC0358p interfaceC0358p = (InterfaceC0358p) this.f5632e.get();
        if (interfaceC0358p == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f5635h = false;
            AbstractC0354l.b bVar = this.f5631d;
            Map.Entry entryK = this.f5630c.k();
            S1.k.b(entryK);
            if (bVar.compareTo(((b) entryK.getValue()).b()) < 0) {
                d(interfaceC0358p);
            }
            Map.Entry entryN = this.f5630c.n();
            if (!this.f5635h && entryN != null && this.f5631d.compareTo(((b) entryN.getValue()).b()) > 0) {
                g(interfaceC0358p);
            }
        }
        this.f5635h = false;
        this.f5637j.setValue(b());
    }

    @Override // androidx.lifecycle.AbstractC0354l
    public void a(InterfaceC0357o interfaceC0357o) {
        InterfaceC0358p interfaceC0358p;
        S1.k.e(interfaceC0357o, "observer");
        f("addObserver");
        AbstractC0354l.b bVar = this.f5631d;
        AbstractC0354l.b bVar2 = AbstractC0354l.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0354l.b.INITIALIZED;
        }
        b bVar3 = new b(interfaceC0357o, bVar2);
        if (((b) this.f5630c.p(interfaceC0357o, bVar3)) == null && (interfaceC0358p = (InterfaceC0358p) this.f5632e.get()) != null) {
            boolean z3 = this.f5633f != 0 || this.f5634g;
            AbstractC0354l.b bVarE = e(interfaceC0357o);
            this.f5633f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f5630c.contains(interfaceC0357o)) {
                l(bVar3.b());
                AbstractC0354l.a aVarB = AbstractC0354l.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC0358p, aVarB);
                k();
                bVarE = e(interfaceC0357o);
            }
            if (!z3) {
                n();
            }
            this.f5633f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0354l
    public AbstractC0354l.b b() {
        return this.f5631d;
    }

    @Override // androidx.lifecycle.AbstractC0354l
    public void c(InterfaceC0357o interfaceC0357o) {
        S1.k.e(interfaceC0357o, "observer");
        f("removeObserver");
        this.f5630c.q(interfaceC0357o);
    }

    public void h(AbstractC0354l.a aVar) {
        S1.k.e(aVar, "event");
        f("handleLifecycleEvent");
        j(aVar.c());
    }

    public void m(AbstractC0354l.b bVar) {
        S1.k.e(bVar, "state");
        f("setCurrentState");
        j(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0359q(InterfaceC0358p interfaceC0358p) {
        this(interfaceC0358p, true);
        S1.k.e(interfaceC0358p, "provider");
    }
}
