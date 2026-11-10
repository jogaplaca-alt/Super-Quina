package L1;

import S1.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1256a;

    public e(d dVar) {
        k.e(dVar, "backing");
        this.f1256a = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f1256a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        k.e(collection, "elements");
        return this.f1256a.l(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1256a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f1256a.q();
    }

    @Override // K1.AbstractC0236e
    public int j() {
        return this.f1256a.size();
    }

    @Override // L1.a
    public boolean l(Map.Entry entry) {
        k.e(entry, "element");
        return this.f1256a.m(entry);
    }

    @Override // L1.a
    public boolean m(Map.Entry entry) {
        k.e(entry, "element");
        return this.f1256a.F(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        k.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f1256a.j();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f1256a.j();
        return super.retainAll(collection);
    }
}
