package androidx.room;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends D {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(u uVar) {
        super(uVar);
        S1.k.e(uVar, "database");
    }

    protected abstract void bind(Z.k kVar, Object obj);

    public final void insert(Object obj) {
        Z.k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, obj);
            kVarAcquire.B();
        } finally {
            release(kVarAcquire);
        }
    }

    public final long insertAndReturnId(Object obj) {
        Z.k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, obj);
            return kVarAcquire.B();
        } finally {
            release(kVarAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<Object> collection) {
        S1.k.e(collection, "entities");
        Z.k kVarAcquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i3 = 0;
            for (Object obj : collection) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    K1.n.j();
                }
                bind(kVarAcquire, obj);
                jArr[i3] = kVarAcquire.B();
                i3 = i4;
            }
            return jArr;
        } finally {
            release(kVarAcquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<Object> collection) {
        S1.k.e(collection, "entities");
        Z.k kVarAcquire = acquire();
        Iterator<Object> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i3 = 0; i3 < size; i3++) {
                bind(kVarAcquire, it.next());
                lArr[i3] = Long.valueOf(kVarAcquire.B());
            }
            release(kVarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Object[] objArr) {
        S1.k.e(objArr, "entities");
        Z.k kVarAcquire = acquire();
        try {
            List listC = K1.n.c();
            for (Object obj : objArr) {
                bind(kVarAcquire, obj);
                listC.add(Long.valueOf(kVarAcquire.B()));
            }
            return K1.n.a(listC);
        } finally {
            release(kVarAcquire);
        }
    }

    public final void insert(Object[] objArr) {
        S1.k.e(objArr, "entities");
        Z.k kVarAcquire = acquire();
        try {
            for (Object obj : objArr) {
                bind(kVarAcquire, obj);
                kVarAcquire.B();
            }
            release(kVarAcquire);
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(Object[] objArr) {
        S1.k.e(objArr, "entities");
        Z.k kVarAcquire = acquire();
        try {
            long[] jArr = new long[objArr.length];
            int length = objArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 1;
                bind(kVarAcquire, objArr[i3]);
                jArr[i4] = kVarAcquire.B();
                i3++;
                i4 = i5;
            }
            release(kVarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Object[] objArr) {
        S1.k.e(objArr, "entities");
        Z.k kVarAcquire = acquire();
        Iterator itA = S1.b.a(objArr);
        try {
            int length = objArr.length;
            Long[] lArr = new Long[length];
            for (int i3 = 0; i3 < length; i3++) {
                bind(kVarAcquire, itA.next());
                lArr[i3] = Long.valueOf(kVarAcquire.B());
            }
            release(kVarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<Object> collection) {
        S1.k.e(collection, "entities");
        Z.k kVarAcquire = acquire();
        try {
            List listC = K1.n.c();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                listC.add(Long.valueOf(kVarAcquire.B()));
            }
            return K1.n.a(listC);
        } finally {
            release(kVarAcquire);
        }
    }

    public final void insert(Iterable<Object> iterable) {
        S1.k.e(iterable, "entities");
        Z.k kVarAcquire = acquire();
        try {
            Iterator<Object> it = iterable.iterator();
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                kVarAcquire.B();
            }
            release(kVarAcquire);
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }
}
