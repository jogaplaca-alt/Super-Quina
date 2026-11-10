package p047n0;

/* JADX INFO: loaded from: classes.dex */
final class h extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10163a;

    h(long j3) {
        this.f10163a = j3;
    }

    @Override // p047n0.n
    public long c() {
        return this.f10163a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f10163a == ((n) obj).c();
    }

    public int hashCode() {
        long j3 = this.f10163a;
        return 1000003 ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f10163a + "}";
    }
}
