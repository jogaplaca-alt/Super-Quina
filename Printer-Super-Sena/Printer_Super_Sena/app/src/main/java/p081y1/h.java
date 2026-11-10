package p081y1;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator f12861i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator f12862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f12864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final e f12867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f12868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f12869h;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f12865d;
        }
    }

    final class c extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f12883f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f12865d;
        }
    }

    private abstract class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f12874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f12875b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f12876c;

        d() {
            this.f12874a = h.this.f12867f.f12881d;
            this.f12876c = h.this.f12866e;
        }

        final e a() {
            e eVar = this.f12874a;
            h hVar = h.this;
            if (eVar == hVar.f12867f) {
                throw new NoSuchElementException();
            }
            if (hVar.f12866e != this.f12876c) {
                throw new ConcurrentModificationException();
            }
            this.f12874a = eVar.f12881d;
            this.f12875b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f12874a != h.this.f12867f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f12875b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f12875b = null;
            this.f12876c = h.this.f12866e;
        }
    }

    public h() {
        this(f12861i, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(e eVar, boolean z3) {
        while (eVar != null) {
            e eVar2 = eVar.f12879b;
            e eVar3 = eVar.f12880c;
            int i3 = eVar2 != null ? eVar2.f12886i : 0;
            int i4 = eVar3 != null ? eVar3.f12886i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                e eVar4 = eVar3.f12879b;
                e eVar5 = eVar3.f12880c;
                int i6 = (eVar4 != null ? eVar4.f12886i : 0) - (eVar5 != null ? eVar5.f12886i : 0);
                if (i6 == -1 || (i6 == 0 && !z3)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z3) {
                    return;
                }
            } else if (i5 == 2) {
                e eVar6 = eVar2.f12879b;
                e eVar7 = eVar2.f12880c;
                int i7 = (eVar6 != null ? eVar6.f12886i : 0) - (eVar7 != null ? eVar7.f12886i : 0);
                if (i7 == 1 || (i7 == 0 && !z3)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z3) {
                    return;
                }
            } else if (i5 == 0) {
                eVar.f12886i = i3 + 1;
                if (z3) {
                    return;
                }
            } else {
                eVar.f12886i = Math.max(i3, i4) + 1;
                if (!z3) {
                    return;
                }
            }
            eVar = eVar.f12878a;
        }
    }

    private void h(e eVar, e eVar2) {
        e eVar3 = eVar.f12878a;
        eVar.f12878a = null;
        if (eVar2 != null) {
            eVar2.f12878a = eVar3;
        }
        if (eVar3 == null) {
            this.f12864c = eVar2;
        } else if (eVar3.f12879b == eVar) {
            eVar3.f12879b = eVar2;
        } else {
            eVar3.f12880c = eVar2;
        }
    }

    private void i(e eVar) {
        e eVar2 = eVar.f12879b;
        e eVar3 = eVar.f12880c;
        e eVar4 = eVar3.f12879b;
        e eVar5 = eVar3.f12880c;
        eVar.f12880c = eVar4;
        if (eVar4 != null) {
            eVar4.f12878a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f12879b = eVar;
        eVar.f12878a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f12886i : 0, eVar4 != null ? eVar4.f12886i : 0) + 1;
        eVar.f12886i = iMax;
        eVar3.f12886i = Math.max(iMax, eVar5 != null ? eVar5.f12886i : 0) + 1;
    }

    private void j(e eVar) {
        e eVar2 = eVar.f12879b;
        e eVar3 = eVar.f12880c;
        e eVar4 = eVar2.f12879b;
        e eVar5 = eVar2.f12880c;
        eVar.f12879b = eVar5;
        if (eVar5 != null) {
            eVar5.f12878a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f12880c = eVar;
        eVar.f12878a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f12886i : 0, eVar5 != null ? eVar5.f12886i : 0) + 1;
        eVar.f12886i = iMax;
        eVar2.f12886i = Math.max(iMax, eVar4 != null ? eVar4.f12886i : 0) + 1;
    }

    e b(Object obj, boolean z3) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.f12862a;
        e eVar2 = this.f12864c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f12861i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f12883f) : comparator.compare(obj, eVar2.f12883f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.f12879b : eVar2.f12880c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z3) {
            return null;
        }
        e eVar4 = this.f12867f;
        if (eVar2 != null) {
            eVar = new e(this.f12863b, eVar2, obj, eVar4, eVar4.f12882e);
            if (iCompareTo < 0) {
                eVar2.f12879b = eVar;
            } else {
                eVar2.f12880c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f12861i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f12863b, eVar2, obj, eVar4, eVar4.f12882e);
            this.f12864c = eVar;
        }
        this.f12865d++;
        this.f12866e++;
        return eVar;
    }

    e c(Map.Entry entry) {
        e eVarD = d(entry.getKey());
        if (eVarD == null || !a(eVarD.f12885h, entry.getValue())) {
            return null;
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f12864c = null;
        this.f12865d = 0;
        this.f12866e++;
        e eVar = this.f12867f;
        eVar.f12882e = eVar;
        eVar.f12881d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    e d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f12868g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f12868g = bVar2;
        return bVar2;
    }

    void f(e eVar, boolean z3) {
        int i3;
        if (z3) {
            e eVar2 = eVar.f12882e;
            eVar2.f12881d = eVar.f12881d;
            eVar.f12881d.f12882e = eVar2;
        }
        e eVar3 = eVar.f12879b;
        e eVar4 = eVar.f12880c;
        e eVar5 = eVar.f12878a;
        int i4 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f12879b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f12880c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f12865d--;
            this.f12866e++;
            return;
        }
        e eVarB = eVar3.f12886i > eVar4.f12886i ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e eVar6 = eVar.f12879b;
        if (eVar6 != null) {
            i3 = eVar6.f12886i;
            eVarB.f12879b = eVar6;
            eVar6.f12878a = eVarB;
            eVar.f12879b = null;
        } else {
            i3 = 0;
        }
        e eVar7 = eVar.f12880c;
        if (eVar7 != null) {
            i4 = eVar7.f12886i;
            eVarB.f12880c = eVar7;
            eVar7.f12878a = eVarB;
            eVar.f12880c = null;
        }
        eVarB.f12886i = Math.max(i3, i4) + 1;
        h(eVar, eVarB);
    }

    e g(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f12885h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f12869h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f12869h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f12863b) {
            throw new NullPointerException("value == null");
        }
        e eVarB = b(obj, true);
        Object obj3 = eVarB.f12885h;
        eVarB.f12885h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f12885h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12865d;
    }

    public h(boolean z3) {
        this(f12861i, z3);
    }

    public h(Comparator comparator, boolean z3) {
        this.f12865d = 0;
        this.f12866e = 0;
        this.f12862a = comparator == null ? f12861i : comparator;
        this.f12863b = z3;
        this.f12867f = new e(z3);
    }

    static final class e implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f12878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f12879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f12880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e f12881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e f12882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Object f12883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f12884g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f12885h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f12886i;

        e(boolean z3) {
            this.f12883f = null;
            this.f12884g = z3;
            this.f12882e = this;
            this.f12881d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f12879b; eVar2 != null; eVar2 = eVar2.f12879b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f12880c; eVar2 != null; eVar2 = eVar2.f12880c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f12883f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f12885h;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f12883f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f12885h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f12883f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f12885h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f12884g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f12885h;
            this.f12885h = obj;
            return obj2;
        }

        public String toString() {
            return this.f12883f + "=" + this.f12885h;
        }

        e(boolean z3, e eVar, Object obj, e eVar2, e eVar3) {
            this.f12878a = eVar;
            this.f12883f = obj;
            this.f12884g = z3;
            this.f12886i = 1;
            this.f12881d = eVar2;
            this.f12882e = eVar3;
            eVar3.f12881d = this;
            eVar2.f12882e = this;
        }
    }
}
