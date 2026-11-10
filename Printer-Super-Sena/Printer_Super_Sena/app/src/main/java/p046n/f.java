package p046n;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f10041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f10042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f10043c;

    final class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f10044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10047d = false;

        a(int i3) {
            this.f10044a = i3;
            this.f10045b = f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10046c < this.f10045b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = f.this.b(this.f10046c, this.f10044a);
            this.f10046c++;
            this.f10047d = true;
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f10047d) {
                throw new IllegalStateException();
            }
            int i3 = this.f10046c - 1;
            this.f10046c = i3;
            this.f10045b--;
            this.f10047d = false;
            f.this.h(i3);
        }
    }

    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int iD = f.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                f.this.g(entry.getKey(), entry.getValue());
            }
            return iD != f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = f.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return p046n.c.c(f.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = f.this.d() - 1; iD >= 0; iD--) {
                Object objB = f.this.b(iD, 0);
                Object objB2 = f.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new d();
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return f.j(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = f.this.d() - 1; iD >= 0; iD--) {
                Object objB = f.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = f.this.e(obj);
            if (iE < 0) {
                return false;
            }
            f.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return f.o(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return f.p(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 0);
        }
    }

    final class d implements Iterator, Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10051a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10053c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10052b = -1;

        d() {
            this.f10051a = f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f10052b++;
            this.f10053c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f10053c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return p046n.c.c(entry.getKey(), f.this.b(this.f10052b, 0)) && p046n.c.c(entry.getValue(), f.this.b(this.f10052b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f10053c) {
                return f.this.b(this.f10052b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f10053c) {
                return f.this.b(this.f10052b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10052b < this.f10051a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f10053c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = f.this.b(this.f10052b, 0);
            Object objB2 = f.this.b(this.f10052b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f10053c) {
                throw new IllegalStateException();
            }
            f.this.h(this.f10052b);
            this.f10052b--;
            this.f10051a--;
            this.f10053c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f10053c) {
                return f.this.i(this.f10052b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = f.this.f(obj);
            if (iF < 0) {
                return false;
            }
            f.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int iD = f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < iD) {
                if (collection.contains(f.this.b(i3, 1))) {
                    f.this.h(i3);
                    i3--;
                    iD--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int iD = f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < iD) {
                if (!collection.contains(f.this.b(i3, 1))) {
                    f.this.h(i3);
                    i3--;
                    iD--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 1);
        }
    }

    f() {
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i3, int i4);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(Object obj, Object obj2);

    protected abstract void h(int i3);

    protected abstract Object i(int i3, Object obj);

    public Set l() {
        if (this.f10041a == null) {
            this.f10041a = new b();
        }
        return this.f10041a;
    }

    public Set m() {
        if (this.f10042b == null) {
            this.f10042b = new c();
        }
        return this.f10042b;
    }

    public Collection n() {
        if (this.f10043c == null) {
            this.f10043c = new e();
        }
        return this.f10043c;
    }

    public Object[] q(int i3) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i4 = 0; i4 < iD; i4++) {
            objArr[i4] = b(i4, i3);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i3) {
        int iD = d();
        if (objArr.length < iD) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iD);
        }
        for (int i4 = 0; i4 < iD; i4++) {
            objArr[i4] = b(i4, i3);
        }
        if (objArr.length > iD) {
            objArr[iD] = null;
        }
        return objArr;
    }
}
