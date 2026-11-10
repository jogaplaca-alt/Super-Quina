package K1;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: K1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0238g extends AbstractC0235d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1215d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object[] f1216e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f1218b = f1216e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1219c;

    /* JADX INFO: renamed from: K1.g$a */
    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        public final int a(int i3, int i4) {
            int i5 = i3 + (i3 >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                return i4 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            return i5;
        }

        private a() {
        }
    }

    private final void n(int i3, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f1218b.length;
        while (i3 < length && it.hasNext()) {
            this.f1218b[i3] = it.next();
            i3++;
        }
        int i4 = this.f1217a;
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            this.f1218b[i5] = it.next();
        }
        this.f1219c = size() + collection.size();
    }

    private final void o(int i3) {
        Object[] objArr = new Object[i3];
        Object[] objArr2 = this.f1218b;
        AbstractC0239h.d(objArr2, objArr, 0, this.f1217a, objArr2.length);
        Object[] objArr3 = this.f1218b;
        int length = objArr3.length;
        int i4 = this.f1217a;
        AbstractC0239h.d(objArr3, objArr, length - i4, 0, i4);
        this.f1217a = 0;
        this.f1218b = objArr;
    }

    private final int p(int i3) {
        return i3 == 0 ? AbstractC0243l.m(this.f1218b) : i3 - 1;
    }

    private final void q(int i3) {
        if (i3 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f1218b;
        if (i3 <= objArr.length) {
            return;
        }
        if (objArr == f1216e) {
            this.f1218b = new Object[V1.d.a(i3, 10)];
        } else {
            o(f1215d.a(objArr.length, i3));
        }
    }

    private final int r(int i3) {
        if (i3 == AbstractC0243l.m(this.f1218b)) {
            return 0;
        }
        return i3 + 1;
    }

    private final int s(int i3) {
        return i3 < 0 ? i3 + this.f1218b.length : i3;
    }

    private final int t(int i3) {
        Object[] objArr = this.f1218b;
        return i3 >= objArr.length ? i3 - objArr.length : i3;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        m(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        S1.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        q(size() + collection.size());
        n(t(this.f1217a + size()), collection);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iT = t(this.f1217a + size());
        int i3 = this.f1217a;
        if (i3 < iT) {
            AbstractC0242k.h(this.f1218b, null, i3, iT);
        } else if (!isEmpty()) {
            Object[] objArr = this.f1218b;
            AbstractC0242k.h(objArr, null, this.f1217a, objArr.length);
            AbstractC0242k.h(this.f1218b, null, 0, iT);
        }
        this.f1217a = 0;
        this.f1219c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        AbstractC0233b.f1212a.a(i3, size());
        return this.f1218b[t(this.f1217a + i3)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i3;
        int iT = t(this.f1217a + size());
        int length = this.f1217a;
        if (length < iT) {
            while (length < iT) {
                if (S1.k.a(obj, this.f1218b[length])) {
                    i3 = this.f1217a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iT) {
            return -1;
        }
        int length2 = this.f1218b.length;
        while (length < length2) {
            if (S1.k.a(obj, this.f1218b[length])) {
                i3 = this.f1217a;
            } else {
                length++;
            }
        }
        for (int i4 = 0; i4 < iT; i4++) {
            if (S1.k.a(obj, this.f1218b[i4])) {
                length = i4 + this.f1218b.length;
                i3 = this.f1217a;
            }
        }
        return -1;
        return length - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // K1.AbstractC0235d
    public int j() {
        return this.f1219c;
    }

    @Override // K1.AbstractC0235d
    public Object k(int i3) {
        AbstractC0233b.f1212a.a(i3, size());
        if (i3 == p.g(this)) {
            return v();
        }
        if (i3 == 0) {
            return u();
        }
        int iT = t(this.f1217a + i3);
        Object obj = this.f1218b[iT];
        if (i3 < (size() >> 1)) {
            int i4 = this.f1217a;
            if (iT >= i4) {
                Object[] objArr = this.f1218b;
                AbstractC0239h.d(objArr, objArr, i4 + 1, i4, iT);
            } else {
                Object[] objArr2 = this.f1218b;
                AbstractC0239h.d(objArr2, objArr2, 1, 0, iT);
                Object[] objArr3 = this.f1218b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i5 = this.f1217a;
                AbstractC0239h.d(objArr3, objArr3, i5 + 1, i5, objArr3.length - 1);
            }
            Object[] objArr4 = this.f1218b;
            int i6 = this.f1217a;
            objArr4[i6] = null;
            this.f1217a = r(i6);
        } else {
            int iT2 = t(this.f1217a + p.g(this));
            if (iT <= iT2) {
                Object[] objArr5 = this.f1218b;
                AbstractC0239h.d(objArr5, objArr5, iT, iT + 1, iT2 + 1);
            } else {
                Object[] objArr6 = this.f1218b;
                AbstractC0239h.d(objArr6, objArr6, iT, iT + 1, objArr6.length);
                Object[] objArr7 = this.f1218b;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC0239h.d(objArr7, objArr7, 0, 1, iT2 + 1);
            }
            this.f1218b[iT2] = null;
        }
        this.f1219c = size() - 1;
        return obj;
    }

    public final void l(Object obj) {
        q(size() + 1);
        int iP = p(this.f1217a);
        this.f1217a = iP;
        this.f1218b[iP] = obj;
        this.f1219c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iM;
        int i3;
        int iT = t(this.f1217a + size());
        int i4 = this.f1217a;
        if (i4 < iT) {
            iM = iT - 1;
            if (i4 <= iM) {
                while (!S1.k.a(obj, this.f1218b[iM])) {
                    if (iM != i4) {
                        iM--;
                    }
                }
                i3 = this.f1217a;
                return iM - i3;
            }
            return -1;
        }
        if (i4 > iT) {
            for (int i5 = iT - 1; -1 < i5; i5--) {
                if (S1.k.a(obj, this.f1218b[i5])) {
                    iM = i5 + this.f1218b.length;
                    i3 = this.f1217a;
                    return iM - i3;
                }
            }
            iM = AbstractC0243l.m(this.f1218b);
            int i6 = this.f1217a;
            if (i6 <= iM) {
                while (!S1.k.a(obj, this.f1218b[iM])) {
                    if (iM != i6) {
                        iM--;
                    }
                }
                i3 = this.f1217a;
                return iM - i3;
            }
        }
        return -1;
    }

    public final void m(Object obj) {
        q(size() + 1);
        this.f1218b[t(this.f1217a + size())] = obj;
        this.f1219c = size() + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int iT;
        S1.k.e(collection, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f1218b.length != 0) {
            int iT2 = t(this.f1217a + size());
            int i3 = this.f1217a;
            if (i3 < iT2) {
                iT = i3;
                while (i3 < iT2) {
                    Object obj = this.f1218b[i3];
                    if (collection.contains(obj)) {
                        z3 = true;
                    } else {
                        this.f1218b[iT] = obj;
                        iT++;
                    }
                    i3++;
                }
                AbstractC0242k.h(this.f1218b, null, iT, iT2);
            } else {
                int length = this.f1218b.length;
                int i4 = i3;
                boolean z4 = false;
                while (i3 < length) {
                    Object[] objArr = this.f1218b;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (collection.contains(obj2)) {
                        z4 = true;
                    } else {
                        this.f1218b[i4] = obj2;
                        i4++;
                    }
                    i3++;
                }
                iT = t(i4);
                for (int i5 = 0; i5 < iT2; i5++) {
                    Object[] objArr2 = this.f1218b;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (collection.contains(obj3)) {
                        z4 = true;
                    } else {
                        this.f1218b[iT] = obj3;
                        iT = r(iT);
                    }
                }
                z3 = z4;
            }
            if (z3) {
                this.f1219c = s(iT - this.f1217a);
            }
        }
        return z3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int iT;
        S1.k.e(collection, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f1218b.length != 0) {
            int iT2 = t(this.f1217a + size());
            int i3 = this.f1217a;
            if (i3 < iT2) {
                iT = i3;
                while (i3 < iT2) {
                    Object obj = this.f1218b[i3];
                    if (collection.contains(obj)) {
                        this.f1218b[iT] = obj;
                        iT++;
                    } else {
                        z3 = true;
                    }
                    i3++;
                }
                AbstractC0242k.h(this.f1218b, null, iT, iT2);
            } else {
                int length = this.f1218b.length;
                int i4 = i3;
                boolean z4 = false;
                while (i3 < length) {
                    Object[] objArr = this.f1218b;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (collection.contains(obj2)) {
                        this.f1218b[i4] = obj2;
                        i4++;
                    } else {
                        z4 = true;
                    }
                    i3++;
                }
                iT = t(i4);
                for (int i5 = 0; i5 < iT2; i5++) {
                    Object[] objArr2 = this.f1218b;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (collection.contains(obj3)) {
                        this.f1218b[iT] = obj3;
                        iT = r(iT);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                this.f1219c = s(iT - this.f1217a);
            }
        }
        return z3;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        AbstractC0233b.f1212a.a(i3, size());
        int iT = t(this.f1217a + i3);
        Object[] objArr = this.f1218b;
        Object obj2 = objArr[iT];
        objArr[iT] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        S1.k.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = AbstractC0240i.a(objArr, size());
        }
        int iT = t(this.f1217a + size());
        int i3 = this.f1217a;
        if (i3 < iT) {
            AbstractC0242k.e(this.f1218b, objArr, 0, i3, iT, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f1218b;
            AbstractC0239h.d(objArr2, objArr, 0, this.f1217a, objArr2.length);
            Object[] objArr3 = this.f1218b;
            AbstractC0239h.d(objArr3, objArr, objArr3.length - this.f1217a, 0, iT);
        }
        if (objArr.length > size()) {
            objArr[size()] = null;
        }
        return objArr;
    }

    public final Object u() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f1218b;
        int i3 = this.f1217a;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f1217a = r(i3);
        this.f1219c = size() - 1;
        return obj;
    }

    public final Object v() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iT = t(this.f1217a + p.g(this));
        Object[] objArr = this.f1218b;
        Object obj = objArr[iT];
        objArr[iT] = null;
        this.f1219c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        AbstractC0233b.f1212a.b(i3, size());
        if (i3 == size()) {
            m(obj);
            return;
        }
        if (i3 == 0) {
            l(obj);
            return;
        }
        q(size() + 1);
        int iT = t(this.f1217a + i3);
        if (i3 < ((size() + 1) >> 1)) {
            int iP = p(iT);
            int iP2 = p(this.f1217a);
            int i4 = this.f1217a;
            if (iP >= i4) {
                Object[] objArr = this.f1218b;
                objArr[iP2] = objArr[i4];
                AbstractC0239h.d(objArr, objArr, i4, i4 + 1, iP + 1);
            } else {
                Object[] objArr2 = this.f1218b;
                AbstractC0239h.d(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.f1218b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0239h.d(objArr3, objArr3, 0, 1, iP + 1);
            }
            this.f1218b[iP] = obj;
            this.f1217a = iP2;
        } else {
            int iT2 = t(this.f1217a + size());
            if (iT < iT2) {
                Object[] objArr4 = this.f1218b;
                AbstractC0239h.d(objArr4, objArr4, iT + 1, iT, iT2);
            } else {
                Object[] objArr5 = this.f1218b;
                AbstractC0239h.d(objArr5, objArr5, 1, 0, iT2);
                Object[] objArr6 = this.f1218b;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0239h.d(objArr6, objArr6, iT + 1, iT, objArr6.length - 1);
            }
            this.f1218b[iT] = obj;
        }
        this.f1219c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        S1.k.e(collection, "elements");
        AbstractC0233b.f1212a.b(i3, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i3 == size()) {
            return addAll(collection);
        }
        q(size() + collection.size());
        int iT = t(this.f1217a + size());
        int iT2 = t(this.f1217a + i3);
        int size = collection.size();
        if (i3 < ((size() + 1) >> 1)) {
            int i4 = this.f1217a;
            int length = i4 - size;
            if (iT2 < i4) {
                Object[] objArr = this.f1218b;
                AbstractC0239h.d(objArr, objArr, length, i4, objArr.length);
                if (size >= iT2) {
                    Object[] objArr2 = this.f1218b;
                    AbstractC0239h.d(objArr2, objArr2, objArr2.length - size, 0, iT2);
                } else {
                    Object[] objArr3 = this.f1218b;
                    AbstractC0239h.d(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f1218b;
                    AbstractC0239h.d(objArr4, objArr4, 0, size, iT2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f1218b;
                AbstractC0239h.d(objArr5, objArr5, length, i4, iT2);
            } else {
                Object[] objArr6 = this.f1218b;
                length += objArr6.length;
                int i5 = iT2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    AbstractC0239h.d(objArr6, objArr6, length, i4, iT2);
                } else {
                    AbstractC0239h.d(objArr6, objArr6, length, i4, i4 + length2);
                    Object[] objArr7 = this.f1218b;
                    AbstractC0239h.d(objArr7, objArr7, 0, this.f1217a + length2, iT2);
                }
            }
            this.f1217a = length;
            n(s(iT2 - size), collection);
        } else {
            int i6 = iT2 + size;
            if (iT2 < iT) {
                int i7 = size + iT;
                Object[] objArr8 = this.f1218b;
                if (i7 <= objArr8.length) {
                    AbstractC0239h.d(objArr8, objArr8, i6, iT2, iT);
                } else if (i6 >= objArr8.length) {
                    AbstractC0239h.d(objArr8, objArr8, i6 - objArr8.length, iT2, iT);
                } else {
                    int length3 = iT - (i7 - objArr8.length);
                    AbstractC0239h.d(objArr8, objArr8, 0, length3, iT);
                    Object[] objArr9 = this.f1218b;
                    AbstractC0239h.d(objArr9, objArr9, i6, iT2, length3);
                }
            } else {
                Object[] objArr10 = this.f1218b;
                AbstractC0239h.d(objArr10, objArr10, size, 0, iT);
                Object[] objArr11 = this.f1218b;
                if (i6 >= objArr11.length) {
                    AbstractC0239h.d(objArr11, objArr11, i6 - objArr11.length, iT2, objArr11.length);
                } else {
                    AbstractC0239h.d(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f1218b;
                    AbstractC0239h.d(objArr12, objArr12, i6, iT2, objArr12.length - size);
                }
            }
            n(iT2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
