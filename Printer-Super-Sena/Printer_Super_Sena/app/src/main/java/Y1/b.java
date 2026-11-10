package Y1;

import J1.l;
import S1.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
final class b extends Z1.a implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2150c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");
    private volatile Object _state;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2151b;

    public b(Object obj) {
        this._state = obj;
    }

    private final boolean b(Object obj, Object obj2) {
        int i3;
        Z1.b[] bVarArrA;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2150c;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !k.a(obj3, obj)) {
                return false;
            }
            if (k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i4 = this.f2151b;
            if ((i4 & 1) != 0) {
                this.f2151b = i4 + 2;
                return true;
            }
            int i5 = i4 + 1;
            this.f2151b = i5;
            Z1.b[] bVarArrA2 = a();
            l lVar = l.f1194a;
            while (true) {
                d[] dVarArr = (d[]) bVarArrA2;
                if (dVarArr != null) {
                    for (d dVar : dVarArr) {
                    }
                }
                synchronized (this) {
                    i3 = this.f2151b;
                    if (i3 == i5) {
                        this.f2151b = i5 + 1;
                        return true;
                    }
                    bVarArrA = a();
                    l lVar2 = l.f1194a;
                }
                bVarArrA2 = bVarArrA;
                i5 = i3;
            }
        }
    }

    @Override // Y1.a
    public void setValue(Object obj) {
        if (obj == null) {
            obj = Z1.c.f2177a;
        }
        b(null, obj);
    }
}
