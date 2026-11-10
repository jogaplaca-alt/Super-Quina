package F0;

import android.content.Context;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseIntArray f838a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0.i f839b;

    public D(C0.i iVar) {
        AbstractC0220n.f(iVar);
        this.f839b = iVar;
    }

    public final int a(Context context, int i3) {
        return this.f838a.get(i3, -1);
    }

    public final int b(Context context, D0.a.f fVar) {
        AbstractC0220n.f(context);
        AbstractC0220n.f(fVar);
        int i3 = 0;
        if (!fVar.l()) {
            return 0;
        }
        int iN = fVar.n();
        int iA = a(context, iN);
        if (iA == -1) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f838a.size()) {
                    i3 = -1;
                    break;
                }
                int iKeyAt = this.f838a.keyAt(i4);
                if (iKeyAt > iN && this.f838a.get(iKeyAt) == 0) {
                    break;
                }
                i4++;
            }
            iA = i3 == -1 ? this.f839b.f(context, iN) : i3;
            this.f838a.put(iN, iA);
        }
        return iA;
    }

    public final void c() {
        this.f838a.clear();
    }
}
