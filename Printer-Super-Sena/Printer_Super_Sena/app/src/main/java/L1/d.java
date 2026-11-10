package L1;

import K1.AbstractC0239h;
import K1.C;
import S1.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Map, Serializable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final a f1238m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f1239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f1240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f1241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f1242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private L1.f f1247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f1248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private L1.e f1249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1250l;

    private static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i3) {
            return Integer.highestOneBit(V1.d.a(i3, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i3) {
            return Integer.numberOfLeadingZeros(i3) + 1;
        }

        private a() {
        }
    }

    public static final class b extends C0018d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            if (a() >= d().f1244f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            c cVar = new c(d(), b());
            e();
            return cVar;
        }

        public final void i(StringBuilder sb) {
            k.e(sb, "sb");
            if (a() >= d().f1244f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = d().f1239a[b()];
            if (k.a(obj, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = d().f1240b;
            k.b(objArr);
            Object obj2 = objArr[b()];
            if (k.a(obj2, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (a() >= d().f1244f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = d().f1239a[b()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().f1240b;
            k.b(objArr);
            Object obj2 = objArr[b()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    public static final class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f1251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1252b;

        public c(d dVar, int i3) {
            k.e(dVar, "map");
            this.f1251a = dVar;
            this.f1252b = i3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (k.a(entry.getKey(), getKey()) && k.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f1251a.f1239a[this.f1252b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object[] objArr = this.f1251a.f1240b;
            k.b(objArr);
            return objArr[this.f1252b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            this.f1251a.j();
            Object[] objArrH = this.f1251a.h();
            int i3 = this.f1252b;
            Object obj2 = objArrH[i3];
            objArrH[i3] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: L1.d$d, reason: collision with other inner class name */
    public static class C0018d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f1253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1255c;

        public C0018d(d dVar) {
            k.e(dVar, "map");
            this.f1253a = dVar;
            this.f1255c = -1;
            e();
        }

        public final int a() {
            return this.f1254b;
        }

        public final int b() {
            return this.f1255c;
        }

        public final d d() {
            return this.f1253a;
        }

        public final void e() {
            while (this.f1254b < this.f1253a.f1244f) {
                int[] iArr = this.f1253a.f1241c;
                int i3 = this.f1254b;
                if (iArr[i3] >= 0) {
                    return;
                } else {
                    this.f1254b = i3 + 1;
                }
            }
        }

        public final void f(int i3) {
            this.f1254b = i3;
        }

        public final void g(int i3) {
            this.f1255c = i3;
        }

        public final boolean hasNext() {
            return this.f1254b < this.f1253a.f1244f;
        }

        public final void remove() {
            if (this.f1255c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f1253a.j();
            this.f1253a.I(this.f1255c);
            this.f1255c = -1;
        }
    }

    public static final class e extends C0018d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            if (a() >= d().f1244f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = d().f1239a[b()];
            e();
            return obj;
        }
    }

    public static final class f extends C0018d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            if (a() >= d().f1244f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object[] objArr = d().f1240b;
            k.b(objArr);
            Object obj = objArr[b()];
            e();
            return obj;
        }
    }

    private d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i3, int i4) {
        this.f1239a = objArr;
        this.f1240b = objArr2;
        this.f1241c = iArr;
        this.f1242d = iArr2;
        this.f1243e = i3;
        this.f1244f = i4;
        this.f1245g = f1238m.d(v());
    }

    private final boolean B(Collection collection) {
        boolean z3 = false;
        if (collection.isEmpty()) {
            return false;
        }
        p(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (C((Map.Entry) it.next())) {
                z3 = true;
            }
        }
        return z3;
    }

    private final boolean C(Map.Entry entry) {
        int iG = g(entry.getKey());
        Object[] objArrH = h();
        if (iG >= 0) {
            objArrH[iG] = entry.getValue();
            return true;
        }
        int i3 = (-iG) - 1;
        if (k.a(entry.getValue(), objArrH[i3])) {
            return false;
        }
        objArrH[i3] = entry.getValue();
        return true;
    }

    private final boolean D(int i3) {
        int iZ = z(this.f1239a[i3]);
        int i4 = this.f1243e;
        while (true) {
            int[] iArr = this.f1242d;
            if (iArr[iZ] == 0) {
                iArr[iZ] = i3 + 1;
                this.f1241c[i3] = iZ;
                return true;
            }
            i4--;
            if (i4 < 0) {
                return false;
            }
            iZ = iZ == 0 ? v() - 1 : iZ - 1;
        }
    }

    private final void E(int i3) {
        if (this.f1244f > size()) {
            k();
        }
        int i4 = 0;
        if (i3 != v()) {
            this.f1242d = new int[i3];
            this.f1245g = f1238m.d(i3);
        } else {
            AbstractC0239h.g(this.f1242d, 0, 0, v());
        }
        while (i4 < this.f1244f) {
            int i5 = i4 + 1;
            if (!D(i4)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i4 = i5;
        }
    }

    private final void G(int i3) {
        int iB = V1.d.b(this.f1243e * 2, v() / 2);
        int i4 = 0;
        int i5 = i3;
        do {
            i3 = i3 == 0 ? v() - 1 : i3 - 1;
            i4++;
            if (i4 > this.f1243e) {
                this.f1242d[i5] = 0;
                return;
            }
            int[] iArr = this.f1242d;
            int i6 = iArr[i3];
            if (i6 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i5] = -1;
            } else {
                int i7 = i6 - 1;
                if (((z(this.f1239a[i7]) - i3) & (v() - 1)) >= i4) {
                    this.f1242d[i5] = i6;
                    this.f1241c[i7] = i5;
                }
                iB--;
            }
            i5 = i3;
            i4 = 0;
            iB--;
        } while (iB >= 0);
        this.f1242d[i5] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(int i3) {
        L1.c.f(this.f1239a, i3);
        G(this.f1241c[i3]);
        this.f1241c[i3] = -1;
        this.f1246h = size() - 1;
    }

    private final boolean K(int i3) {
        int iT = t();
        int i4 = this.f1244f;
        int i5 = iT - i4;
        int size = i4 - size();
        return i5 < i3 && i5 + size >= i3 && size >= t() / 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] h() {
        Object[] objArr = this.f1240b;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = L1.c.d(t());
        this.f1240b = objArrD;
        return objArrD;
    }

    private final void k() {
        int i3;
        Object[] objArr = this.f1240b;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = this.f1244f;
            if (i4 >= i3) {
                break;
            }
            if (this.f1241c[i4] >= 0) {
                Object[] objArr2 = this.f1239a;
                objArr2[i5] = objArr2[i4];
                if (objArr != null) {
                    objArr[i5] = objArr[i4];
                }
                i5++;
            }
            i4++;
        }
        L1.c.g(this.f1239a, i5, i3);
        if (objArr != null) {
            L1.c.g(objArr, i5, this.f1244f);
        }
        this.f1244f = i5;
    }

    private final boolean n(Map map) {
        return size() == map.size() && l(map.entrySet());
    }

    private final void o(int i3) {
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        if (i3 > t()) {
            int iT = (t() * 3) / 2;
            if (i3 <= iT) {
                i3 = iT;
            }
            this.f1239a = L1.c.e(this.f1239a, i3);
            Object[] objArr = this.f1240b;
            this.f1240b = objArr != null ? L1.c.e(objArr, i3) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f1241c, i3);
            k.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f1241c = iArrCopyOf;
            int iC = f1238m.c(i3);
            if (iC > v()) {
                E(iC);
            }
        }
    }

    private final void p(int i3) {
        if (K(i3)) {
            E(v());
        } else {
            o(this.f1244f + i3);
        }
    }

    private final int r(Object obj) {
        int iZ = z(obj);
        int i3 = this.f1243e;
        while (true) {
            int i4 = this.f1242d[iZ];
            if (i4 == 0) {
                return -1;
            }
            if (i4 > 0) {
                int i5 = i4 - 1;
                if (k.a(this.f1239a[i5], obj)) {
                    return i5;
                }
            }
            i3--;
            if (i3 < 0) {
                return -1;
            }
            iZ = iZ == 0 ? v() - 1 : iZ - 1;
        }
    }

    private final int s(Object obj) {
        int i3 = this.f1244f;
        while (true) {
            i3--;
            if (i3 < 0) {
                return -1;
            }
            if (this.f1241c[i3] >= 0) {
                Object[] objArr = this.f1240b;
                k.b(objArr);
                if (k.a(objArr[i3], obj)) {
                    return i3;
                }
            }
        }
    }

    private final int v() {
        return this.f1242d.length;
    }

    private final int z(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f1245g;
    }

    public final e A() {
        return new e(this);
    }

    public final boolean F(Map.Entry entry) {
        k.e(entry, "entry");
        j();
        int iR = r(entry.getKey());
        if (iR < 0) {
            return false;
        }
        Object[] objArr = this.f1240b;
        k.b(objArr);
        if (!k.a(objArr[iR], entry.getValue())) {
            return false;
        }
        I(iR);
        return true;
    }

    public final int H(Object obj) {
        j();
        int iR = r(obj);
        if (iR < 0) {
            return -1;
        }
        I(iR);
        return iR;
    }

    public final boolean J(Object obj) {
        j();
        int iS = s(obj);
        if (iS < 0) {
            return false;
        }
        I(iS);
        return true;
    }

    public final f L() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        j();
        C it = new V1.c(0, this.f1244f - 1).iterator();
        while (it.hasNext()) {
            int iA = it.a();
            int[] iArr = this.f1241c;
            int i3 = iArr[iA];
            if (i3 >= 0) {
                this.f1242d[i3] = 0;
                iArr[iA] = -1;
            }
        }
        L1.c.g(this.f1239a, 0, this.f1244f);
        Object[] objArr = this.f1240b;
        if (objArr != null) {
            L1.c.g(objArr, 0, this.f1244f);
        }
        this.f1246h = 0;
        this.f1244f = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return r(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return s(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return u();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && n((Map) obj));
    }

    public final int g(Object obj) {
        j();
        while (true) {
            int iZ = z(obj);
            int iB = V1.d.b(this.f1243e * 2, v() / 2);
            int i3 = 0;
            while (true) {
                int i4 = this.f1242d[iZ];
                if (i4 <= 0) {
                    if (this.f1244f >= t()) {
                        p(1);
                        break;
                    }
                    int i5 = this.f1244f;
                    int i6 = i5 + 1;
                    this.f1244f = i6;
                    this.f1239a[i5] = obj;
                    this.f1241c[i5] = iZ;
                    this.f1242d[iZ] = i6;
                    this.f1246h = size() + 1;
                    if (i3 > this.f1243e) {
                        this.f1243e = i3;
                    }
                    return i5;
                }
                if (k.a(this.f1239a[i4 - 1], obj)) {
                    return -i4;
                }
                i3++;
                if (i3 > iB) {
                    E(v() * 2);
                    break;
                }
                iZ = iZ == 0 ? v() - 1 : iZ - 1;
            }
        }
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iR = r(obj);
        if (iR < 0) {
            return null;
        }
        Object[] objArr = this.f1240b;
        k.b(objArr);
        return objArr[iR];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarQ = q();
        int iJ = 0;
        while (bVarQ.hasNext()) {
            iJ += bVarQ.j();
        }
        return iJ;
    }

    public final Map i() {
        j();
        this.f1250l = true;
        return this;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void j() {
        if (this.f1250l) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return w();
    }

    public final boolean l(Collection collection) {
        k.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!m((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean m(Map.Entry entry) {
        k.e(entry, "entry");
        int iR = r(entry.getKey());
        if (iR < 0) {
            return false;
        }
        Object[] objArr = this.f1240b;
        k.b(objArr);
        return k.a(objArr[iR], entry.getValue());
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        j();
        int iG = g(obj);
        Object[] objArrH = h();
        if (iG >= 0) {
            objArrH[iG] = obj2;
            return null;
        }
        int i3 = (-iG) - 1;
        Object obj3 = objArrH[i3];
        objArrH[i3] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        k.e(map, "from");
        j();
        B(map.entrySet());
    }

    public final b q() {
        return new b(this);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        int iH = H(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f1240b;
        k.b(objArr);
        Object obj2 = objArr[iH];
        L1.c.f(objArr, iH);
        return obj2;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return x();
    }

    public final int t() {
        return this.f1239a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarQ = q();
        int i3 = 0;
        while (bVarQ.hasNext()) {
            if (i3 > 0) {
                sb.append(", ");
            }
            bVarQ.i(sb);
            i3++;
        }
        sb.append("}");
        String string = sb.toString();
        k.d(string, "sb.toString()");
        return string;
    }

    public Set u() {
        L1.e eVar = this.f1249k;
        if (eVar != null) {
            return eVar;
        }
        L1.e eVar2 = new L1.e(this);
        this.f1249k = eVar2;
        return eVar2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return y();
    }

    public Set w() {
        L1.f fVar = this.f1247i;
        if (fVar != null) {
            return fVar;
        }
        L1.f fVar2 = new L1.f(this);
        this.f1247i = fVar2;
        return fVar2;
    }

    public int x() {
        return this.f1246h;
    }

    public Collection y() {
        g gVar = this.f1248j;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f1248j = gVar2;
        return gVar2;
    }

    public d() {
        this(8);
    }

    public d(int i3) {
        this(L1.c.d(i3), null, new int[i3], new int[f1238m.c(i3)], 2, 0);
    }
}
