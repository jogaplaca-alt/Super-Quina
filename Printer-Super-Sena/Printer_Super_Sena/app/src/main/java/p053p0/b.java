package p053p0;

/* JADX INFO: loaded from: classes.dex */
final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g.a f10467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10468b;

    b(g.a aVar, long j3) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f10467a = aVar;
        this.f10468b = j3;
    }

    @Override // p053p0.g
    public long b() {
        return this.f10468b;
    }

    @Override // p053p0.g
    public g.a c() {
        return this.f10467a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10467a.equals(gVar.c()) && this.f10468b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.f10467a.hashCode() ^ 1000003) * 1000003;
        long j3 = this.f10468b;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f10467a + ", nextRequestWaitMillis=" + this.f10468b + "}";
    }
}
