package L1;

import K1.AbstractC0233b;
import K1.AbstractC0235d;
import K1.AbstractC0239h;
import K1.C0238g;
import S1.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC0235d implements List, RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f1229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f1233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f1234f;

    private static final class a implements ListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f1235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1237c;

        public a(b bVar, int i3) {
            k.e(bVar, "list");
            this.f1235a = bVar;
            this.f1236b = i3;
            this.f1237c = -1;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            b bVar = this.f1235a;
            int i3 = this.f1236b;
            this.f1236b = i3 + 1;
            bVar.add(i3, obj);
            this.f1237c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f1236b < this.f1235a.f1231c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f1236b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            if (this.f1236b >= this.f1235a.f1231c) {
                throw new NoSuchElementException();
            }
            int i3 = this.f1236b;
            this.f1236b = i3 + 1;
            this.f1237c = i3;
            return this.f1235a.f1229a[this.f1235a.f1230b + this.f1237c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1236b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i3 = this.f1236b;
            if (i3 <= 0) {
                throw new NoSuchElementException();
            }
            int i4 = i3 - 1;
            this.f1236b = i4;
            this.f1237c = i4;
            return this.f1235a.f1229a[this.f1235a.f1230b + this.f1237c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1236b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i3 = this.f1237c;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f1235a.remove(i3);
            this.f1236b = this.f1237c;
            this.f1237c = -1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            int i3 = this.f1237c;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f1235a.set(i3, obj);
        }
    }

    private b(Object[] objArr, int i3, int i4, boolean z3, b bVar, b bVar2) {
        this.f1229a = objArr;
        this.f1230b = i3;
        this.f1231c = i4;
        this.f1232d = z3;
        this.f1233e = bVar;
        this.f1234f = bVar2;
    }

    private final void o(int i3, Collection collection, int i4) {
        b bVar = this.f1233e;
        if (bVar != null) {
            bVar.o(i3, collection, i4);
            this.f1229a = this.f1233e.f1229a;
            this.f1231c += i4;
        } else {
            v(i3, i4);
            Iterator it = collection.iterator();
            for (int i5 = 0; i5 < i4; i5++) {
                this.f1229a[i3 + i5] = it.next();
            }
        }
    }

    private final void p(int i3, Object obj) {
        b bVar = this.f1233e;
        if (bVar == null) {
            v(i3, 1);
            this.f1229a[i3] = obj;
        } else {
            bVar.p(i3, obj);
            this.f1229a = this.f1233e.f1229a;
            this.f1231c++;
        }
    }

    private final void r() {
        if (w()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean s(List list) {
        return c.h(this.f1229a, this.f1230b, this.f1231c, list);
    }

    private final void t(int i3) {
        if (this.f1233e != null) {
            throw new IllegalStateException();
        }
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f1229a;
        if (i3 > objArr.length) {
            this.f1229a = c.e(this.f1229a, C0238g.f1215d.a(objArr.length, i3));
        }
    }

    private final void u(int i3) {
        t(this.f1231c + i3);
    }

    private final void v(int i3, int i4) {
        u(i4);
        Object[] objArr = this.f1229a;
        AbstractC0239h.d(objArr, objArr, i3 + i4, i3, this.f1230b + this.f1231c);
        this.f1231c += i4;
    }

    private final boolean w() {
        b bVar;
        return this.f1232d || ((bVar = this.f1234f) != null && bVar.f1232d);
    }

    private final Object x(int i3) {
        b bVar = this.f1233e;
        if (bVar != null) {
            Object objX = bVar.x(i3);
            this.f1231c--;
            return objX;
        }
        Object[] objArr = this.f1229a;
        Object obj = objArr[i3];
        AbstractC0239h.d(objArr, objArr, i3, i3 + 1, this.f1230b + this.f1231c);
        c.f(this.f1229a, (this.f1230b + this.f1231c) - 1);
        this.f1231c--;
        return obj;
    }

    private final void y(int i3, int i4) {
        b bVar = this.f1233e;
        if (bVar != null) {
            bVar.y(i3, i4);
        } else {
            Object[] objArr = this.f1229a;
            AbstractC0239h.d(objArr, objArr, i3, i3 + i4, this.f1231c);
            Object[] objArr2 = this.f1229a;
            int i5 = this.f1231c;
            c.g(objArr2, i5 - i4, i5);
        }
        this.f1231c -= i4;
    }

    private final int z(int i3, int i4, Collection collection, boolean z3) {
        b bVar = this.f1233e;
        if (bVar != null) {
            int iZ = bVar.z(i3, i4, collection, z3);
            this.f1231c -= iZ;
            return iZ;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = i3 + i5;
            if (collection.contains(this.f1229a[i7]) == z3) {
                Object[] objArr = this.f1229a;
                i5++;
                objArr[i6 + i3] = objArr[i7];
                i6++;
            } else {
                i5++;
            }
        }
        int i8 = i4 - i6;
        Object[] objArr2 = this.f1229a;
        AbstractC0239h.d(objArr2, objArr2, i3 + i6, i4 + i3, this.f1231c);
        Object[] objArr3 = this.f1229a;
        int i9 = this.f1231c;
        c.g(objArr3, i9 - i8, i9);
        this.f1231c -= i8;
        return i8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        r();
        p(this.f1230b + this.f1231c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        r();
        int size = collection.size();
        o(this.f1230b + this.f1231c, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        r();
        y(this.f1230b, this.f1231c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && s((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        AbstractC0233b.f1212a.a(i3, this.f1231c);
        return this.f1229a[this.f1230b + i3];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.i(this.f1229a, this.f1230b, this.f1231c);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i3 = 0; i3 < this.f1231c; i3++) {
            if (k.a(this.f1229a[this.f1230b + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f1231c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a(this, 0);
    }

    @Override // K1.AbstractC0235d
    public int j() {
        return this.f1231c;
    }

    @Override // K1.AbstractC0235d
    public Object k(int i3) {
        r();
        AbstractC0233b.f1212a.a(i3, this.f1231c);
        return x(this.f1230b + i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i3 = this.f1231c - 1; i3 >= 0; i3--) {
            if (k.a(this.f1229a[this.f1230b + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return new a(this, 0);
    }

    public final List q() {
        if (this.f1233e != null) {
            throw new IllegalStateException();
        }
        r();
        this.f1232d = true;
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        r();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        r();
        return z(this.f1230b, this.f1231c, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        r();
        return z(this.f1230b, this.f1231c, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        r();
        AbstractC0233b.f1212a.a(i3, this.f1231c);
        Object[] objArr = this.f1229a;
        int i4 = this.f1230b;
        Object obj2 = objArr[i4 + i3];
        objArr[i4 + i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i3, int i4) {
        AbstractC0233b.f1212a.c(i3, i4, this.f1231c);
        Object[] objArr = this.f1229a;
        int i5 = this.f1230b + i3;
        int i6 = i4 - i3;
        boolean z3 = this.f1232d;
        b bVar = this.f1234f;
        return new b(objArr, i5, i6, z3, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        k.e(objArr, "destination");
        int length = objArr.length;
        int i3 = this.f1231c;
        if (length < i3) {
            Object[] objArr2 = this.f1229a;
            int i4 = this.f1230b;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i4, i3 + i4, objArr.getClass());
            k.d(objArrCopyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return objArrCopyOfRange;
        }
        Object[] objArr3 = this.f1229a;
        int i5 = this.f1230b;
        AbstractC0239h.d(objArr3, objArr, 0, i5, i3 + i5);
        int length2 = objArr.length;
        int i6 = this.f1231c;
        if (length2 > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c.j(this.f1229a, this.f1230b, this.f1231c);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        AbstractC0233b.f1212a.b(i3, this.f1231c);
        return new a(this, i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        r();
        AbstractC0233b.f1212a.b(i3, this.f1231c);
        p(this.f1230b + i3, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        k.e(collection, "elements");
        r();
        AbstractC0233b.f1212a.b(i3, this.f1231c);
        int size = collection.size();
        o(this.f1230b + i3, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = this.f1229a;
        int i3 = this.f1230b;
        return AbstractC0239h.f(objArr, i3, this.f1231c + i3);
    }

    public b() {
        this(10);
    }

    public b(int i3) {
        this(c.d(i3), 0, 0, false, null, null);
    }
}
