package K1;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: K1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0237f implements Collection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f1213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f1214b;

    public C0237f(Object[] objArr, boolean z3) {
        S1.k.e(objArr, "values");
        this.f1213a = objArr;
        this.f1214b = z3;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return AbstractC0243l.j(this.f1213a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        S1.k.e(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f1213a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return S1.b.a(this.f1213a);
    }

    public int j() {
        return this.f1213a.length;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return j();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        S1.k.e(objArr, "array");
        return S1.f.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return o.b(this.f1213a, this.f1214b);
    }
}
