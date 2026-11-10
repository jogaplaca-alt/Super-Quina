package J1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f1189b;

    public g(Object obj, Object obj2) {
        this.f1188a = obj;
        this.f1189b = obj2;
    }

    public final Object a() {
        return this.f1188a;
    }

    public final Object b() {
        return this.f1189b;
    }

    public final Object c() {
        return this.f1188a;
    }

    public final Object d() {
        return this.f1189b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return S1.k.a(this.f1188a, gVar.f1188a) && S1.k.a(this.f1189b, gVar.f1189b);
    }

    public int hashCode() {
        Object obj = this.f1188a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1189b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f1188a + ", " + this.f1189b + ')';
    }
}
