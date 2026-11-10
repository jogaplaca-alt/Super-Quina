package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0439k extends AbstractC0428h implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AbstractC0483z f7456b = new C0432i(r.f7490f, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f7457c = 0;

    AbstractC0439k() {
    }

    static AbstractC0439k q(Object[] objArr, int i3) {
        return i3 == 0 ? r.f7490f : new r(objArr, i3);
    }

    public static AbstractC0439k r(Collection collection) {
        if (!(collection instanceof AbstractC0428h)) {
            Object[] array = collection.toArray();
            int length = array.length;
            AbstractC0457q.a(array, length);
            return q(array, length);
        }
        AbstractC0439k abstractC0439kM = ((AbstractC0428h) collection).m();
        if (!abstractC0439kM.n()) {
            return abstractC0439kM;
        }
        Object[] array2 = abstractC0439kM.toArray();
        return q(array2, array2.length);
    }

    public static AbstractC0439k s() {
        return r.f7490f;
    }

    public static AbstractC0439k t(Object obj) {
        Object[] objArr = {obj};
        AbstractC0457q.a(objArr, 1);
        return q(objArr, 1);
    }

    @Override // java.util.List
    public final void add(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i3 = 0; i3 < size; i3++) {
                        if (I2.a(get(i3), list.get(i3))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && I2.a(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i3 = 0; i3 < size; i3++) {
            iHashCode = (iHashCode * 31) + get(i3).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (obj.equals(get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    int j(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i4] = get(i4);
        }
        return size;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0428h
    public final AbstractC0439k m() {
        return this;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC0439k subList(int i3, int i4) {
        AbstractC0404b.c(i3, i4, size());
        int i5 = i4 - i3;
        if (i5 == size()) {
            return this;
        }
        return i5 == 0 ? r.f7490f : new C0436j(this, i3, i5);
    }

    @Override // java.util.List
    public final Object remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final AbstractC0483z listIterator(int i3) {
        AbstractC0404b.b(i3, size(), "index");
        return isEmpty() ? f7456b : new C0432i(this, i3);
    }
}
