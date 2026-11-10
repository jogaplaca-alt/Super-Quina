package androidx.room;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends D {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u uVar) {
        super(uVar);
        S1.k.e(uVar, "database");
    }

    protected abstract void bind(Z.k kVar, Object obj);

    public final int handle(Object obj) {
        Z.k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, obj);
            return kVarAcquire.n();
        } finally {
            release(kVarAcquire);
        }
    }

    public final int handleMultiple(Iterable<Object> iterable) {
        S1.k.e(iterable, "entities");
        Z.k kVarAcquire = acquire();
        try {
            Iterator<Object> it = iterable.iterator();
            int iN = 0;
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                iN += kVarAcquire.n();
            }
            release(kVarAcquire);
            return iN;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final int handleMultiple(Object[] objArr) {
        S1.k.e(objArr, "entities");
        Z.k kVarAcquire = acquire();
        try {
            int iN = 0;
            for (Object obj : objArr) {
                bind(kVarAcquire, obj);
                iN += kVarAcquire.n();
            }
            release(kVarAcquire);
            return iN;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }
}
