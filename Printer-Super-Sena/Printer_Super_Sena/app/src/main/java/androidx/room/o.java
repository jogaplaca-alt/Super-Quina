package androidx.room;

import K1.J;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.AbstractC0360s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f6330q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f6331r = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f6332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f6333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f6334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f6335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f6336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0371c f6337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f6338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f6339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Z.k f6340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f6341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final m f6342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final p034j.b f6343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private r f6344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f6345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f6346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f6347p;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final void a(Z.g gVar) {
            S1.k.e(gVar, "database");
            if (gVar.i()) {
                gVar.q();
            } else {
                gVar.b();
            }
        }

        public final String b(String str, String str2) {
            S1.k.e(str, "tableName");
            S1.k.e(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        private a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f6348e = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f6349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f6350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f6351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6352d;

        public static final class a {
            public /* synthetic */ a(S1.g gVar) {
                this();
            }

            private a() {
            }
        }

        public b(int i3) {
            this.f6349a = new long[i3];
            this.f6350b = new boolean[i3];
            this.f6351c = new int[i3];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.f6352d) {
                        return null;
                    }
                    long[] jArr = this.f6349a;
                    int length = jArr.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        int i5 = i4 + 1;
                        int i6 = 1;
                        boolean z3 = jArr[i3] > 0;
                        boolean[] zArr = this.f6350b;
                        if (z3 != zArr[i4]) {
                            int[] iArr = this.f6351c;
                            if (!z3) {
                                i6 = 2;
                            }
                            iArr[i4] = i6;
                        } else {
                            this.f6351c[i4] = 0;
                        }
                        zArr[i4] = z3;
                        i3++;
                        i4 = i5;
                    }
                    this.f6352d = false;
                    return (int[]) this.f6351c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean b(int... iArr) {
            boolean z3;
            S1.k.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z3 = false;
                    for (int i3 : iArr) {
                        long[] jArr = this.f6349a;
                        long j3 = jArr[i3];
                        jArr[i3] = 1 + j3;
                        if (j3 == 0) {
                            this.f6352d = true;
                            z3 = true;
                        }
                    }
                    J1.l lVar = J1.l.f1194a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z3;
        }

        public final boolean c(int... iArr) {
            boolean z3;
            S1.k.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z3 = false;
                    for (int i3 : iArr) {
                        long[] jArr = this.f6349a;
                        long j3 = jArr[i3];
                        jArr[i3] = j3 - 1;
                        if (j3 == 1) {
                            this.f6352d = true;
                            z3 = true;
                        }
                    }
                    J1.l lVar = J1.l.f1194a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z3;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.f6350b, false);
                this.f6352d = true;
                J1.l lVar = J1.l.f1194a;
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f6353a;

        public c(String[] strArr) {
            S1.k.e(strArr, "tables");
            this.f6353a = strArr;
        }

        public final String[] a() {
            return this.f6353a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set set);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f6354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f6355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f6356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set f6357d;

        public d(c cVar, int[] iArr, String[] strArr) {
            S1.k.e(cVar, "observer");
            S1.k.e(iArr, "tableIds");
            S1.k.e(strArr, "tableNames");
            this.f6354a = cVar;
            this.f6355b = iArr;
            this.f6356c = strArr;
            this.f6357d = !(strArr.length == 0) ? J.c(strArr[0]) : J.d();
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final int[] a() {
            return this.f6355b;
        }

        public final void b(Set set) {
            Set setD;
            S1.k.e(set, "invalidatedTablesIds");
            int[] iArr = this.f6355b;
            int length = iArr.length;
            if (length != 0) {
                int i3 = 0;
                if (length != 1) {
                    Set setB = J.b();
                    int[] iArr2 = this.f6355b;
                    int length2 = iArr2.length;
                    int i4 = 0;
                    while (i3 < length2) {
                        int i5 = i4 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i3]))) {
                            setB.add(this.f6356c[i4]);
                        }
                        i3++;
                        i4 = i5;
                    }
                    setD = J.a(setB);
                } else {
                    setD = set.contains(Integer.valueOf(iArr[0])) ? this.f6357d : J.d();
                }
            } else {
                setD = J.d();
            }
            if (setD.isEmpty()) {
                return;
            }
            this.f6354a.c(setD);
        }

        public final void c(String[] strArr) {
            Set setD;
            S1.k.e(strArr, "tables");
            int length = this.f6356c.length;
            if (length == 0) {
                setD = J.d();
            } else if (length == 1) {
                int length2 = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        setD = J.d();
                        break;
                    } else {
                        if (X1.c.d(strArr[i3], this.f6356c[0], true)) {
                            setD = this.f6357d;
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                Set setB = J.b();
                for (String str : strArr) {
                    for (String str2 : this.f6356c) {
                        if (X1.c.d(str2, str, true)) {
                            setB.add(str2);
                        }
                    }
                }
                setD = J.a(setB);
            }
            if (setD.isEmpty()) {
                return;
            }
            this.f6354a.c(setD);
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f6358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WeakReference f6359c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(o oVar, c cVar) {
            super(cVar.a());
            S1.k.e(oVar, "tracker");
            S1.k.e(cVar, "delegate");
            this.f6358b = oVar;
            this.f6359c = new WeakReference(cVar);
        }

        @Override // androidx.room.o.c
        public void c(Set set) {
            S1.k.e(set, "tables");
            c cVar = (c) this.f6359c.get();
            if (cVar == null) {
                this.f6358b.p(this);
            } else {
                cVar.c(set);
            }
        }
    }

    public static final class f implements Runnable {
        f() {
        }

        private final Set a() throws IOException {
            o oVar = o.this;
            Set setB = J.b();
            Cursor cursorZ = u.z(oVar.h(), new Z.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
            while (cursorZ.moveToNext()) {
                try {
                    setB.add(Integer.valueOf(cursorZ.getInt(0)));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        P1.a.a(cursorZ, th);
                        throw th2;
                    }
                }
            }
            J1.l lVar = J1.l.f1194a;
            P1.a.a(cursorZ, null);
            Set setA = J.a(setB);
            if (!setA.isEmpty()) {
                if (o.this.g() == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Z.k kVarG = o.this.g();
                if (kVarG == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                kVarG.n();
            }
            return setA;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set setD;
            C0371c c0371c;
            Lock lockK = o.this.h().k();
            lockK.lock();
            try {
                try {
                    if (!o.this.f()) {
                        lockK.unlock();
                        C0371c c0371c2 = o.this.f6337f;
                        if (c0371c2 != null) {
                            c0371c2.e();
                            return;
                        }
                        return;
                    }
                    if (!o.this.j().compareAndSet(true, false)) {
                        lockK.unlock();
                        C0371c c0371c3 = o.this.f6337f;
                        if (c0371c3 != null) {
                            c0371c3.e();
                            return;
                        }
                        return;
                    }
                    if (o.this.h().r()) {
                        lockK.unlock();
                        C0371c c0371c4 = o.this.f6337f;
                        if (c0371c4 != null) {
                            c0371c4.e();
                            return;
                        }
                        return;
                    }
                    Z.g gVarA = o.this.h().m().A();
                    gVarA.q();
                    try {
                        setD = a();
                        gVarA.m();
                        gVarA.a();
                        lockK.unlock();
                        c0371c = o.this.f6337f;
                        if (c0371c != null) {
                            c0371c.e();
                        }
                        if (setD.isEmpty()) {
                            return;
                        }
                        p034j.b bVarI = o.this.i();
                        o oVar = o.this;
                        synchronized (bVarI) {
                            try {
                                Iterator it = oVar.i().iterator();
                                while (it.hasNext()) {
                                    ((d) ((Map.Entry) it.next()).getValue()).b(setD);
                                }
                                J1.l lVar = J1.l.f1194a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        gVarA.a();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    lockK.unlock();
                    C0371c c0371c5 = o.this.f6337f;
                    if (c0371c5 != null) {
                        c0371c5.e();
                    }
                    throw th3;
                }
            } catch (SQLiteException e3) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
                setD = J.d();
                lockK.unlock();
                c0371c = o.this.f6337f;
                if (c0371c != null) {
                }
            } catch (IllegalStateException e4) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
                setD = J.d();
                lockK.unlock();
                c0371c = o.this.f6337f;
                if (c0371c != null) {
                }
            }
        }
    }

    public o(u uVar, Map map, Map map2, String... strArr) {
        String lowerCase;
        S1.k.e(uVar, "database");
        S1.k.e(map, "shadowTablesMap");
        S1.k.e(map2, "viewTables");
        S1.k.e(strArr, "tableNames");
        this.f6332a = uVar;
        this.f6333b = map;
        this.f6334c = map2;
        this.f6338g = new AtomicBoolean(false);
        this.f6341j = new b(strArr.length);
        this.f6342k = new m(uVar);
        this.f6343l = new p034j.b();
        this.f6345n = new Object();
        this.f6346o = new Object();
        this.f6335d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Locale locale = Locale.US;
            S1.k.d(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            S1.k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f6335d.put(lowerCase2, Integer.valueOf(i3));
            String str2 = (String) this.f6333b.get(strArr[i3]);
            if (str2 != null) {
                S1.k.d(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                S1.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i3] = lowerCase2;
        }
        this.f6336e = strArr2;
        for (Map.Entry entry : this.f6333b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            S1.k.d(locale2, "US");
            String lowerCase3 = str3.toLowerCase(locale2);
            S1.k.d(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f6335d.containsKey(lowerCase3)) {
                String str4 = (String) entry.getKey();
                S1.k.d(locale2, "US");
                String lowerCase4 = str4.toLowerCase(locale2);
                S1.k.d(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.f6335d;
                map3.put(lowerCase4, K1.D.h(map3, lowerCase3));
            }
        }
        this.f6347p = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        synchronized (this.f6346o) {
            this.f6339h = false;
            this.f6341j.d();
            Z.k kVar = this.f6340i;
            if (kVar != null) {
                kVar.close();
                J1.l lVar = J1.l.f1194a;
            }
        }
    }

    private final String[] q(String[] strArr) {
        Set setB = J.b();
        for (String str : strArr) {
            Map map = this.f6334c;
            Locale locale = Locale.US;
            S1.k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            S1.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map map2 = this.f6334c;
                S1.k.d(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                S1.k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map2.get(lowerCase2);
                S1.k.b(obj);
                setB.addAll((Collection) obj);
            } else {
                setB.add(str);
            }
        }
        return (String[]) J.a(setB).toArray(new String[0]);
    }

    private final void t(Z.g gVar, int i3) {
        gVar.j("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)");
        String str = this.f6336e[i3];
        for (String str2 : f6331r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f6330q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i3 + " AND invalidated = 0; END";
            S1.k.d(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.j(str3);
        }
    }

    private final void u(Z.g gVar, int i3) {
        String str = this.f6336e[i3];
        for (String str2 : f6331r) {
            String str3 = "DROP TRIGGER IF EXISTS " + f6330q.b(str, str2);
            S1.k.d(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.j(str3);
        }
    }

    private final String[] x(String[] strArr) {
        String[] strArrQ = q(strArr);
        for (String str : strArrQ) {
            Map map = this.f6335d;
            Locale locale = Locale.US;
            S1.k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            S1.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return strArrQ;
    }

    public void c(c cVar) {
        d dVar;
        S1.k.e(cVar, "observer");
        String[] strArrQ = q(cVar.a());
        ArrayList arrayList = new ArrayList(strArrQ.length);
        for (String str : strArrQ) {
            Map map = this.f6335d;
            Locale locale = Locale.US;
            S1.k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            S1.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(num);
        }
        int[] iArrO = K1.n.o(arrayList);
        d dVar2 = new d(cVar, iArrO, strArrQ);
        synchronized (this.f6343l) {
            dVar = (d) this.f6343l.p(cVar, dVar2);
        }
        if (dVar == null && this.f6341j.b(Arrays.copyOf(iArrO, iArrO.length))) {
            v();
        }
    }

    public void d(c cVar) {
        S1.k.e(cVar, "observer");
        c(new e(this, cVar));
    }

    public AbstractC0360s e(String[] strArr, boolean z3, Callable callable) {
        S1.k.e(strArr, "tableNames");
        S1.k.e(callable, "computeFunction");
        return this.f6342k.a(x(strArr), z3, callable);
    }

    public final boolean f() {
        if (!this.f6332a.x()) {
            return false;
        }
        if (!this.f6339h) {
            this.f6332a.m().A();
        }
        if (this.f6339h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final Z.k g() {
        return this.f6340i;
    }

    public final u h() {
        return this.f6332a;
    }

    public final p034j.b i() {
        return this.f6343l;
    }

    public final AtomicBoolean j() {
        return this.f6338g;
    }

    public final Map k() {
        return this.f6335d;
    }

    public final void l(Z.g gVar) {
        S1.k.e(gVar, "database");
        synchronized (this.f6346o) {
            if (this.f6339h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            gVar.j("PRAGMA temp_store = MEMORY;");
            gVar.j("PRAGMA recursive_triggers='ON';");
            gVar.j("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            w(gVar);
            this.f6340i = gVar.p("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.f6339h = true;
            J1.l lVar = J1.l.f1194a;
        }
    }

    public final void m(String... strArr) {
        S1.k.e(strArr, "tables");
        synchronized (this.f6343l) {
            try {
                for (Map.Entry entry : this.f6343l) {
                    S1.k.d(entry, "(observer, wrapper)");
                    c cVar = (c) entry.getKey();
                    d dVar = (d) entry.getValue();
                    if (!cVar.b()) {
                        dVar.c(strArr);
                    }
                }
                J1.l lVar = J1.l.f1194a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        if (this.f6338g.compareAndSet(false, true)) {
            C0371c c0371c = this.f6337f;
            if (c0371c != null) {
                c0371c.j();
            }
            this.f6332a.n().execute(this.f6347p);
        }
    }

    public void p(c cVar) {
        d dVar;
        S1.k.e(cVar, "observer");
        synchronized (this.f6343l) {
            dVar = (d) this.f6343l.q(cVar);
        }
        if (dVar != null) {
            b bVar = this.f6341j;
            int[] iArrA = dVar.a();
            if (bVar.c(Arrays.copyOf(iArrA, iArrA.length))) {
                v();
            }
        }
    }

    public final void r(C0371c c0371c) {
        S1.k.e(c0371c, "autoCloser");
        this.f6337f = c0371c;
        c0371c.l(new Runnable() { // from class: androidx.room.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f6329a.n();
            }
        });
    }

    public final void s(Context context, String str, Intent intent) {
        S1.k.e(context, "context");
        S1.k.e(str, "name");
        S1.k.e(intent, "serviceIntent");
        this.f6344m = new r(context, str, intent, this, this.f6332a.n());
    }

    public final void v() {
        if (this.f6332a.x()) {
            w(this.f6332a.m().A());
        }
    }

    public final void w(Z.g gVar) {
        S1.k.e(gVar, "database");
        if (gVar.F()) {
            return;
        }
        try {
            Lock lockK = this.f6332a.k();
            lockK.lock();
            try {
                synchronized (this.f6345n) {
                    int[] iArrA = this.f6341j.a();
                    if (iArrA == null) {
                        lockK.unlock();
                        return;
                    }
                    f6330q.a(gVar);
                    try {
                        int length = iArrA.length;
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < length) {
                            int i5 = iArrA[i3];
                            int i6 = i4 + 1;
                            if (i5 == 1) {
                                t(gVar, i4);
                            } else if (i5 == 2) {
                                u(gVar, i4);
                            }
                            i3++;
                            i4 = i6;
                        }
                        gVar.m();
                        gVar.a();
                        J1.l lVar = J1.l.f1194a;
                        lockK.unlock();
                    } catch (Throwable th) {
                        gVar.a();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                lockK.unlock();
                throw th2;
            }
        } catch (SQLiteException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        } catch (IllegalStateException e4) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
        }
    }
}
