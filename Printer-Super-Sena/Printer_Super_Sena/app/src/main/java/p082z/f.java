package p082z;

import S1.k;

/* JADX INFO: loaded from: classes.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f12979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12980b;

    public f(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f12979a = new Object[i3];
    }

    private final boolean c(Object obj) {
        int i3 = this.f12980b;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f12979a[i4] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // p082z.e
    public boolean a(Object obj) {
        k.e(obj, "instance");
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.f12980b;
        Object[] objArr = this.f12979a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.f12980b = i3 + 1;
        return true;
    }

    @Override // p082z.e
    public Object b() {
        int i3 = this.f12980b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object obj = this.f12979a[i4];
        k.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f12979a[i4] = null;
        this.f12980b--;
        return obj;
    }
}
