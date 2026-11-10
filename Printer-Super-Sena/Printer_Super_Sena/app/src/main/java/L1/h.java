package L1;

import K1.AbstractC0236e;
import S1.k;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC0236e implements Set, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1259a;

    public h(d dVar) {
        k.e(dVar, "backing");
        this.f1259a = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.f1259a.g(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        this.f1259a.j();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f1259a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f1259a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1259a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f1259a.A();
    }

    @Override // K1.AbstractC0236e
    public int j() {
        return this.f1259a.size();
    }

    public final Set k() {
        this.f1259a.i();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f1259a.H(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f1259a.j();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f1259a.j();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }
}
