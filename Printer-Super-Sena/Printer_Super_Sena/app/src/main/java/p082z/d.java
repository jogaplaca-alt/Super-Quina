package p082z;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12978b;

    public d(Object obj, Object obj2) {
        this.f12977a = obj;
        this.f12978b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f12977a, this.f12977a) && c.a(dVar.f12978b, this.f12978b);
    }

    public int hashCode() {
        Object obj = this.f12977a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f12978b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f12977a + " " + this.f12978b + "}";
    }
}
