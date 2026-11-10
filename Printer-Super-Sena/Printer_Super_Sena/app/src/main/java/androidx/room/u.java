package androidx.room;

import K1.J;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f6381o = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile Z.g f6382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f6383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Executor f6384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Z.h f6385d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected List f6389h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private C0371c f6392k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map f6394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f6395n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final o f6386e = g();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f6390i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ReentrantReadWriteLock f6391j = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ThreadLocal f6393l = new ThreadLocal();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f6396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f6397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f6398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f6399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f6400e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f6401f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Executor f6402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Executor f6403h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Z.h.c f6404i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f6405j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private c f6406k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Intent f6407l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f6408m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f6409n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f6410o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private TimeUnit f6411p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final d f6412q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Set f6413r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Set f6414s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private String f6415t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private File f6416u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Callable f6417v;

        public a(Context context, Class cls, String str) {
            S1.k.e(context, "context");
            S1.k.e(cls, "klass");
            this.f6396a = context;
            this.f6397b = cls;
            this.f6398c = str;
            this.f6399d = new ArrayList();
            this.f6400e = new ArrayList();
            this.f6401f = new ArrayList();
            this.f6406k = c.AUTOMATIC;
            this.f6408m = true;
            this.f6410o = -1L;
            this.f6412q = new d();
            this.f6413r = new LinkedHashSet();
        }

        public a a(W.a... aVarArr) {
            S1.k.e(aVarArr, "migrations");
            if (this.f6414s == null) {
                this.f6414s = new HashSet();
            }
            for (W.a aVar : aVarArr) {
                Set set = this.f6414s;
                S1.k.b(set);
                set.add(Integer.valueOf(aVar.f2075a));
                Set set2 = this.f6414s;
                S1.k.b(set2);
                set2.add(Integer.valueOf(aVar.f2076b));
            }
            this.f6412q.b((W.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
            return this;
        }

        public u b() {
            Executor executor = this.f6402g;
            if (executor == null && this.f6403h == null) {
                Executor executorG = p031i.c.g();
                this.f6403h = executorG;
                this.f6402g = executorG;
            } else if (executor != null && this.f6403h == null) {
                this.f6403h = executor;
            } else if (executor == null) {
                this.f6402g = this.f6403h;
            }
            Set set = this.f6414s;
            if (set != null) {
                S1.k.b(set);
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (this.f6413r.contains(Integer.valueOf(iIntValue))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + iIntValue).toString());
                    }
                }
            }
            Z.h.c c3 = this.f6404i;
            if (c3 == null) {
                c3 = new p001a0.f();
            }
            if (c3 != null) {
                if (this.f6410o > 0) {
                    if (this.f6398c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j3 = this.f6410o;
                    TimeUnit timeUnit = this.f6411p;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    Executor executor2 = this.f6402g;
                    if (executor2 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    c3 = new C0373e(c3, new C0371c(j3, timeUnit, executor2));
                }
                String str = this.f6415t;
                if (str != null || this.f6416u != null || this.f6417v != null) {
                    if (this.f6398c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    int i3 = str == null ? 0 : 1;
                    File file = this.f6416u;
                    int i4 = file == null ? 0 : 1;
                    Callable callable = this.f6417v;
                    if (i3 + i4 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    c3 = new C(str, file, callable, c3);
                }
            } else {
                c3 = null;
            }
            Z.h.c cVar = c3;
            if (cVar == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Context context = this.f6396a;
            String str2 = this.f6398c;
            d dVar = this.f6412q;
            List list = this.f6399d;
            boolean z3 = this.f6405j;
            c cVarC = this.f6406k.c(context);
            Executor executor3 = this.f6402g;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor4 = this.f6403h;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            C0374f c0374f = new C0374f(context, str2, cVar, dVar, list, z3, cVarC, executor3, executor4, this.f6407l, this.f6408m, this.f6409n, this.f6413r, this.f6415t, this.f6416u, this.f6417v, null, this.f6400e, this.f6401f);
            u uVar = (u) t.b(this.f6397b, "_Impl");
            uVar.s(c0374f);
            return uVar;
        }
    }

    public static final class b {
        public /* synthetic */ b(S1.g gVar) {
            this();
        }

        private b() {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean b(ActivityManager activityManager) {
            return Z.c.b(activityManager);
        }

        public final c c(Context context) {
            S1.k.e(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || b(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f6422a = new LinkedHashMap();

        private final void a(W.a aVar) {
            int i3 = aVar.f2075a;
            int i4 = aVar.f2076b;
            Map map = this.f6422a;
            Integer numValueOf = Integer.valueOf(i3);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i4))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i4)) + " with " + aVar);
            }
            treeMap2.put(Integer.valueOf(i4), aVar);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0019  */
        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: Code duplicated, block: B:15:0x002c  */
        /* JADX WARN: Code duplicated, block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:40:0x0036 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x0017 A[DONT_INVERT] */
        private final List e(List list, boolean z3, int i3, int i4) {
            TreeMap treeMap;
            Set setKeySet;
            Iterator it;
            boolean z4;
            Integer num;
            int i5;
            int iIntValue;
            int iIntValue2;
            do {
                if (!z3) {
                    if (i3 <= i4) {
                        return list;
                    }
                    treeMap = (TreeMap) this.f6422a.get(Integer.valueOf(i3));
                    if (treeMap == null) {
                        if (z3) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                z4 = false;
                                break;
                                break;
                            }
                            num = (Integer) it.next();
                            if (!z3) {
                                i5 = i3 + 1;
                                S1.k.d(num, "targetVersion");
                                iIntValue = num.intValue();
                                if (i5 <= iIntValue) {
                                    continue;
                                }
                            } else {
                                S1.k.d(num, "targetVersion");
                                iIntValue2 = num.intValue();
                                if (i4 <= iIntValue2) {
                                    continue;
                                }
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i3 >= i4) {
                        return list;
                    }
                    treeMap = (TreeMap) this.f6422a.get(Integer.valueOf(i3));
                    if (treeMap == null) {
                        if (z3) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                z4 = false;
                                break;
                            }
                            num = (Integer) it.next();
                            if (!z3) {
                                S1.k.d(num, "targetVersion");
                                iIntValue2 = num.intValue();
                                if (i4 <= iIntValue2 && iIntValue2 < i3) {
                                    Object obj = treeMap.get(num);
                                    S1.k.b(obj);
                                    list.add(obj);
                                    i3 = num.intValue();
                                    z4 = true;
                                    break;
                                    break;
                                }
                            } else {
                                i5 = i3 + 1;
                                S1.k.d(num, "targetVersion");
                                iIntValue = num.intValue();
                                if (i5 <= iIntValue && iIntValue <= i4) {
                                    Object obj2 = treeMap.get(num);
                                    S1.k.b(obj2);
                                    list.add(obj2);
                                    i3 = num.intValue();
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                    } else {
                        return null;
                    }
                }
            } while (z4);
            return null;
        }

        public void b(W.a... aVarArr) {
            S1.k.e(aVarArr, "migrations");
            for (W.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public final boolean c(int i3, int i4) {
            Map mapF = f();
            if (!mapF.containsKey(Integer.valueOf(i3))) {
                return false;
            }
            Map mapG = (Map) mapF.get(Integer.valueOf(i3));
            if (mapG == null) {
                mapG = K1.D.g();
            }
            return mapG.containsKey(Integer.valueOf(i4));
        }

        public List d(int i3, int i4) {
            if (i3 == i4) {
                return K1.n.f();
            }
            return e(new ArrayList(), i4 > i3, i3, i4);
        }

        public Map f() {
            return this.f6422a;
        }
    }

    public static abstract class e {
    }

    static final class f extends S1.l implements R1.l {
        f() {
            super(1);
        }

        @Override // R1.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object c(Z.g gVar) {
            S1.k.e(gVar, "it");
            u.this.t();
            return null;
        }
    }

    static final class g extends S1.l implements R1.l {
        g() {
            super(1);
        }

        @Override // R1.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object c(Z.g gVar) {
            S1.k.e(gVar, "it");
            u.this.u();
            return null;
        }
    }

    public u() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        S1.k.d(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f6394m = mapSynchronizedMap;
        this.f6395n = new LinkedHashMap();
    }

    private final Object B(Class cls, Z.h hVar) {
        if (cls.isInstance(hVar)) {
            return hVar;
        }
        if (hVar instanceof androidx.room.g) {
            return B(cls, ((androidx.room.g) hVar).g());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        c();
        Z.g gVarA = m().A();
        l().w(gVarA);
        if (gVarA.i()) {
            gVarA.q();
        } else {
            gVarA.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        m().A().a();
        if (r()) {
            return;
        }
        l().o();
    }

    public static /* synthetic */ Cursor z(u uVar, Z.j jVar, CancellationSignal cancellationSignal, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i3 & 2) != 0) {
            cancellationSignal = null;
        }
        return uVar.y(jVar, cancellationSignal);
    }

    public void A() {
        m().A().m();
    }

    public void c() {
        if (!this.f6387f && w()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void d() {
        if (!r() && this.f6393l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void e() {
        c();
        C0371c c0371c = this.f6392k;
        if (c0371c == null) {
            t();
        } else {
            c0371c.g(new f());
        }
    }

    public Z.k f(String str) {
        S1.k.e(str, "sql");
        c();
        d();
        return m().A().p(str);
    }

    protected abstract o g();

    protected abstract Z.h h(C0374f c0374f);

    public void i() {
        C0371c c0371c = this.f6392k;
        if (c0371c == null) {
            u();
        } else {
            c0371c.g(new g());
        }
    }

    public List j(Map map) {
        S1.k.e(map, "autoMigrationSpecs");
        return K1.n.f();
    }

    public final Lock k() {
        ReentrantReadWriteLock.ReadLock lock = this.f6391j.readLock();
        S1.k.d(lock, "readWriteLock.readLock()");
        return lock;
    }

    public o l() {
        return this.f6386e;
    }

    public Z.h m() {
        Z.h hVar = this.f6385d;
        if (hVar != null) {
            return hVar;
        }
        S1.k.n("internalOpenHelper");
        return null;
    }

    public Executor n() {
        Executor executor = this.f6383b;
        if (executor != null) {
            return executor;
        }
        S1.k.n("internalQueryExecutor");
        return null;
    }

    public Set o() {
        return J.d();
    }

    protected Map p() {
        return K1.D.g();
    }

    public Executor q() {
        Executor executor = this.f6384c;
        if (executor != null) {
            return executor;
        }
        S1.k.n("internalTransactionExecutor");
        return null;
    }

    public boolean r() {
        return m().A().F();
    }

    public void s(C0374f c0374f) {
        S1.k.e(c0374f, "configuration");
        this.f6385d = h(c0374f);
        Set<Class> setO = o();
        BitSet bitSet = new BitSet();
        for (Class cls : setO) {
            int size = c0374f.f6318r.size() - 1;
            if (size < 0) {
                size = -1;
                break;
            }
            while (true) {
                int i3 = size - 1;
                if (cls.isAssignableFrom(c0374f.f6318r.get(size).getClass())) {
                    bitSet.set(size);
                    break;
                } else {
                    if (i3 < 0) {
                        size = -1;
                        break;
                    }
                    size = i3;
                }
            }
            if (size < 0) {
                throw new IllegalArgumentException(("A required auto migration spec (" + cls.getCanonicalName() + ") is missing in the database configuration.").toString());
            }
            this.f6390i.put(cls, c0374f.f6318r.get(size));
        }
        int size2 = c0374f.f6318r.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i4 = size2 - 1;
                if (!bitSet.get(size2)) {
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
                if (i4 < 0) {
                    break;
                } else {
                    size2 = i4;
                }
            }
        }
        for (W.a aVar : j(this.f6390i)) {
            if (!c0374f.f6304d.c(aVar.f2075a, aVar.f2076b)) {
                c0374f.f6304d.b(aVar);
            }
        }
        B b3 = (B) B(B.class, m());
        if (b3 != null) {
            b3.G(c0374f);
        }
        C0372d c0372d = (C0372d) B(C0372d.class, m());
        if (c0372d != null) {
            this.f6392k = c0372d.f6281b;
            l().r(c0372d.f6281b);
        }
        boolean z3 = c0374f.f6307g == c.WRITE_AHEAD_LOGGING;
        m().setWriteAheadLoggingEnabled(z3);
        this.f6389h = c0374f.f6305e;
        this.f6383b = c0374f.f6308h;
        this.f6384c = new F(c0374f.f6309i);
        this.f6387f = c0374f.f6306f;
        this.f6388g = z3;
        if (c0374f.f6310j != null) {
            if (c0374f.f6302b == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            l().s(c0374f.f6301a, c0374f.f6302b, c0374f.f6310j);
        }
        Map mapP = p();
        BitSet bitSet2 = new BitSet();
        for (Map.Entry entry : mapP.entrySet()) {
            Class cls2 = (Class) entry.getKey();
            for (Class cls3 : (List) entry.getValue()) {
                int size3 = c0374f.f6317q.size() - 1;
                if (size3 < 0) {
                    size3 = -1;
                    break;
                }
                while (true) {
                    int i5 = size3 - 1;
                    if (cls3.isAssignableFrom(c0374f.f6317q.get(size3).getClass())) {
                        bitSet2.set(size3);
                        break;
                    } else {
                        if (i5 < 0) {
                            size3 = -1;
                            break;
                        }
                        size3 = i5;
                    }
                }
                if (size3 < 0) {
                    throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + cls2.getCanonicalName() + " is missing in the database configuration.").toString());
                }
                this.f6395n.put(cls3, c0374f.f6317q.get(size3));
            }
        }
        int size4 = c0374f.f6317q.size() - 1;
        if (size4 < 0) {
            return;
        }
        while (true) {
            int i6 = size4 - 1;
            if (!bitSet2.get(size4)) {
                throw new IllegalArgumentException("Unexpected type converter " + c0374f.f6317q.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
            if (i6 < 0) {
                return;
            } else {
                size4 = i6;
            }
        }
    }

    protected void v(Z.g gVar) {
        S1.k.e(gVar, "db");
        l().l(gVar);
    }

    public final boolean w() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final boolean x() {
        Z.g gVar = this.f6382a;
        return gVar != null && gVar.isOpen();
    }

    public Cursor y(Z.j jVar, CancellationSignal cancellationSignal) {
        S1.k.e(jVar, "query");
        c();
        d();
        return cancellationSignal != null ? m().A().r(jVar, cancellationSignal) : m().A().C(jVar);
    }
}
