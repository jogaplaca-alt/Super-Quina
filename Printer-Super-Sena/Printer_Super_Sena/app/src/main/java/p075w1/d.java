package p075w1;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p081y1.g;
import p081y1.k;
import p081y1.m;
import p084z1.h;
import p084z1.i;
import p084z1.j;
import p084z1.l;
import p084z1.o;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    static final p075w1.c f12628A = p075w1.b.f12620a;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    static final t f12629B = s.f12694a;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    static final t f12630C = s.f12695b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final String f12631z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal f12632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f12633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p081y1.c f12634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p084z1.e f12635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List f12636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final p081y1.d f12637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final p075w1.c f12638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map f12639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f12640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f12641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f12642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f12643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f12644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f12645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f12646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final boolean f12647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f12648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final int f12649r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final int f12650s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final q f12651t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final List f12652u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final List f12653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final t f12654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final t f12655x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final List f12656y;

    class a extends u {
        a() {
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(E1.a aVar) throws IOException {
            if (aVar.c0() != E1.b.NULL) {
                return Double.valueOf(aVar.T());
            }
            aVar.Y();
            return null;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.R();
                return;
            }
            double dDoubleValue = number.doubleValue();
            d.d(dDoubleValue);
            cVar.b0(dDoubleValue);
        }
    }

    class b extends u {
        b() {
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(E1.a aVar) throws IOException {
            if (aVar.c0() != E1.b.NULL) {
                return Float.valueOf((float) aVar.T());
            }
            aVar.Y();
            return null;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.R();
                return;
            }
            float fFloatValue = number.floatValue();
            d.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            cVar.e0(number);
        }
    }

    class c extends u {
        c() {
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(E1.a aVar) throws IOException {
            if (aVar.c0() != E1.b.NULL) {
                return Long.valueOf(aVar.V());
            }
            aVar.Y();
            return null;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.R();
            } else {
                cVar.f0(number.toString());
            }
        }
    }

    /* JADX INFO: renamed from: w1.d$d, reason: collision with other inner class name */
    class C0139d extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f12659a;

        C0139d(u uVar) {
            this.f12659a = uVar;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(E1.a aVar) {
            return new AtomicLong(((Number) this.f12659a.b(aVar)).longValue());
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, AtomicLong atomicLong) {
            this.f12659a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f12660a;

        e(u uVar) {
            this.f12660a = uVar;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(E1.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.g();
            while (aVar.O()) {
                arrayList.add(Long.valueOf(((Number) this.f12660a.b(aVar)).longValue()));
            }
            aVar.J();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i3 = 0; i3 < size; i3++) {
                atomicLongArray.set(i3, ((Long) arrayList.get(i3)).longValue());
            }
            return atomicLongArray;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.y();
            int length = atomicLongArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                this.f12660a.d(cVar, Long.valueOf(atomicLongArray.get(i3)));
            }
            cVar.J();
        }
    }

    static class f extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private u f12661a = null;

        f() {
        }

        private u f() {
            u uVar = this.f12661a;
            if (uVar != null) {
                return uVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // p075w1.u
        public Object b(E1.a aVar) {
            return f().b(aVar);
        }

        @Override // p075w1.u
        public void d(E1.c cVar, Object obj) {
            f().d(cVar, obj);
        }

        @Override // p084z1.l
        public u e() {
            return f();
        }

        public void g(u uVar) {
            if (this.f12661a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f12661a = uVar;
        }
    }

    public d() {
        this(p081y1.d.f12845g, f12628A, Collections.emptyMap(), false, false, false, true, false, false, false, true, q.f12686a, f12631z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f12629B, f12630C, Collections.emptyList());
    }

    private static void a(Object obj, E1.a aVar) {
        if (obj != null) {
            try {
                if (aVar.c0() == E1.b.END_DOCUMENT) {
                } else {
                    throw new p("JSON document was not fully consumed.");
                }
            } catch (E1.d e3) {
                throw new p(e3);
            } catch (IOException e4) {
                throw new j(e4);
            }
        }
    }

    private static u b(u uVar) {
        return new C0139d(uVar).a();
    }

    private static u c(u uVar) {
        return new e(uVar).a();
    }

    static void d(double d3) {
        if (Double.isNaN(d3) || Double.isInfinite(d3)) {
            throw new IllegalArgumentException(d3 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private u e(boolean z3) {
        return z3 ? o.f13109v : new a();
    }

    private u f(boolean z3) {
        return z3 ? o.f13108u : new b();
    }

    private static u p(q qVar) {
        return qVar == q.f12686a ? o.f13107t : new c();
    }

    public Object g(E1.a aVar, D1.a aVar2) {
        boolean zP = aVar.P();
        boolean z3 = true;
        aVar.h0(true);
        try {
            try {
                try {
                    aVar.c0();
                    z3 = false;
                    Object objB = m(aVar2).b(aVar);
                    aVar.h0(zP);
                    return objB;
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
                } catch (IllegalStateException e4) {
                    throw new p(e4);
                }
            } catch (EOFException e5) {
                if (!z3) {
                    throw new p(e5);
                }
                aVar.h0(zP);
                return null;
            } catch (IOException e6) {
                throw new p(e6);
            }
        } catch (Throwable th) {
            aVar.h0(zP);
            throw th;
        }
    }

    public Object h(Reader reader, D1.a aVar) {
        E1.a aVarQ = q(reader);
        Object objG = g(aVarQ, aVar);
        a(objG, aVarQ);
        return objG;
    }

    public Object i(String str, D1.a aVar) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), aVar);
    }

    public Object j(String str, Class cls) {
        return k.b(cls).cast(i(str, D1.a.a(cls)));
    }

    public Object k(i iVar, D1.a aVar) {
        if (iVar == null) {
            return null;
        }
        return g(new p084z1.f(iVar), aVar);
    }

    public Object l(i iVar, Type type) {
        return k(iVar, D1.a.b(type));
    }

    public u m(D1.a aVar) {
        boolean z3;
        Objects.requireNonNull(aVar, "type must not be null");
        u uVar = (u) this.f12633b.get(aVar);
        if (uVar != null) {
            return uVar;
        }
        Map map = (Map) this.f12632a.get();
        if (map == null) {
            map = new HashMap();
            this.f12632a.set(map);
            z3 = true;
        } else {
            u uVar2 = (u) map.get(aVar);
            if (uVar2 != null) {
                return uVar2;
            }
            z3 = false;
        }
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator it = this.f12636e.iterator();
            u uVarA = null;
            while (it.hasNext()) {
                uVarA = ((v) it.next()).a(this, aVar);
                if (uVarA != null) {
                    fVar.g(uVarA);
                    map.put(aVar, uVarA);
                    break;
                }
            }
            if (z3) {
                this.f12632a.remove();
            }
            if (uVarA != null) {
                if (z3) {
                    this.f12633b.putAll(map);
                }
                return uVarA;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z3) {
                this.f12632a.remove();
            }
            throw th;
        }
    }

    public u n(Class cls) {
        return m(D1.a.a(cls));
    }

    public u o(v vVar, D1.a aVar) {
        if (!this.f12636e.contains(vVar)) {
            vVar = this.f12635d;
        }
        boolean z3 = false;
        for (v vVar2 : this.f12636e) {
            if (z3) {
                u uVarA = vVar2.a(this, aVar);
                if (uVarA != null) {
                    return uVarA;
                }
            } else if (vVar2 == vVar) {
                z3 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public E1.a q(Reader reader) {
        E1.a aVar = new E1.a(reader);
        aVar.h0(this.f12645n);
        return aVar;
    }

    public E1.c r(Writer writer) throws IOException {
        if (this.f12642k) {
            writer.write(")]}'\n");
        }
        E1.c cVar = new E1.c(writer);
        if (this.f12644m) {
            cVar.X("  ");
        }
        cVar.W(this.f12643l);
        cVar.Y(this.f12645n);
        cVar.Z(this.f12640i);
        return cVar;
    }

    public String s(Object obj) {
        return obj == null ? u(k.f12683a) : t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f12640i + ",factories:" + this.f12636e + ",instanceCreators:" + this.f12634c + "}";
    }

    public String u(i iVar) {
        StringWriter stringWriter = new StringWriter();
        y(iVar, stringWriter);
        return stringWriter.toString();
    }

    public void v(Object obj, Type type, E1.c cVar) {
        u uVarM = m(D1.a.b(type));
        boolean zN = cVar.N();
        cVar.Y(true);
        boolean zM = cVar.M();
        cVar.W(this.f12643l);
        boolean zL = cVar.L();
        cVar.Z(this.f12640i);
        try {
            try {
                uVarM.d(cVar, obj);
                cVar.Y(zN);
                cVar.W(zM);
                cVar.Z(zL);
            } catch (IOException e3) {
                throw new j(e3);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            cVar.Y(zN);
            cVar.W(zM);
            cVar.Z(zL);
            throw th;
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, r(m.c(appendable)));
        } catch (IOException e3) {
            throw new j(e3);
        }
    }

    public void x(i iVar, E1.c cVar) {
        boolean zN = cVar.N();
        cVar.Y(true);
        boolean zM = cVar.M();
        cVar.W(this.f12643l);
        boolean zL = cVar.L();
        cVar.Z(this.f12640i);
        try {
            try {
                m.b(iVar, cVar);
                cVar.Y(zN);
                cVar.W(zM);
                cVar.Z(zL);
            } catch (IOException e3) {
                throw new j(e3);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            cVar.Y(zN);
            cVar.W(zM);
            cVar.Z(zL);
            throw th;
        }
    }

    public void y(i iVar, Appendable appendable) {
        try {
            x(iVar, r(m.c(appendable)));
        } catch (IOException e3) {
            throw new j(e3);
        }
    }

    d(p081y1.d dVar, p075w1.c cVar, Map map, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, q qVar, String str, int i3, int i4, List list, List list2, List list3, t tVar, t tVar2, List list4) {
        this.f12632a = new ThreadLocal();
        this.f12633b = new ConcurrentHashMap();
        this.f12637f = dVar;
        this.f12638g = cVar;
        this.f12639h = map;
        p081y1.c cVar2 = new p081y1.c(map, z10, list4);
        this.f12634c = cVar2;
        this.f12640i = z3;
        this.f12641j = z4;
        this.f12642k = z5;
        this.f12643l = z6;
        this.f12644m = z7;
        this.f12645n = z8;
        this.f12646o = z9;
        this.f12647p = z10;
        this.f12651t = qVar;
        this.f12648q = str;
        this.f12649r = i3;
        this.f12650s = i4;
        this.f12652u = list;
        this.f12653v = list2;
        this.f12654w = tVar;
        this.f12655x = tVar2;
        this.f12656y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(o.f13086W);
        arrayList.add(j.e(tVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(o.f13066C);
        arrayList.add(o.f13100m);
        arrayList.add(o.f13094g);
        arrayList.add(o.f13096i);
        arrayList.add(o.f13098k);
        u uVarP = p(qVar);
        arrayList.add(o.b(Long.TYPE, Long.class, uVarP));
        arrayList.add(o.b(Double.TYPE, Double.class, e(z9)));
        arrayList.add(o.b(Float.TYPE, Float.class, f(z9)));
        arrayList.add(i.e(tVar2));
        arrayList.add(o.f13102o);
        arrayList.add(o.f13104q);
        arrayList.add(o.c(AtomicLong.class, b(uVarP)));
        arrayList.add(o.c(AtomicLongArray.class, c(uVarP)));
        arrayList.add(o.f13106s);
        arrayList.add(o.f13111x);
        arrayList.add(o.f13068E);
        arrayList.add(o.f13070G);
        arrayList.add(o.c(BigDecimal.class, o.f13113z));
        arrayList.add(o.c(BigInteger.class, o.f13064A));
        arrayList.add(o.c(g.class, o.f13065B));
        arrayList.add(o.f13072I);
        arrayList.add(o.f13074K);
        arrayList.add(o.f13078O);
        arrayList.add(o.f13080Q);
        arrayList.add(o.f13084U);
        arrayList.add(o.f13076M);
        arrayList.add(o.f13091d);
        arrayList.add(p084z1.c.f12990b);
        arrayList.add(o.f13082S);
        if (C1.d.f156a) {
            arrayList.add(C1.d.f160e);
            arrayList.add(C1.d.f159d);
            arrayList.add(C1.d.f161f);
        }
        arrayList.add(p084z1.a.f12984c);
        arrayList.add(o.f13089b);
        arrayList.add(new p084z1.b(cVar2));
        arrayList.add(new h(cVar2, z4));
        p084z1.e eVar = new p084z1.e(cVar2);
        this.f12635d = eVar;
        arrayList.add(eVar);
        arrayList.add(o.f13087X);
        arrayList.add(new p084z1.k(cVar2, cVar, dVar, eVar, list4));
        this.f12636e = Collections.unmodifiableList(arrayList);
    }
}
