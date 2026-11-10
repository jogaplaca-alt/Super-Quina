package p071v0;

import java.util.Set;

/* JADX INFO: renamed from: v0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0703d extends z.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f12493c;

    /* JADX INFO: renamed from: v0.d$b */
    static final class b extends z.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f12495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set f12496c;

        b() {
        }

        @Override // v0.z.b.a
        public z.b a() {
            String str = "";
            if (this.f12494a == null) {
                str = " delta";
            }
            if (this.f12495b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f12496c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C0703d(this.f12494a.longValue(), this.f12495b.longValue(), this.f12496c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v0.z.b.a
        public z.b.a b(long j3) {
            this.f12494a = Long.valueOf(j3);
            return this;
        }

        @Override // v0.z.b.a
        public z.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f12496c = set;
            return this;
        }

        @Override // v0.z.b.a
        public z.b.a d(long j3) {
            this.f12495b = Long.valueOf(j3);
            return this;
        }
    }

    @Override // v0.z.b
    long b() {
        return this.f12491a;
    }

    @Override // v0.z.b
    Set c() {
        return this.f12493c;
    }

    @Override // v0.z.b
    long d() {
        return this.f12492b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z.b)) {
            return false;
        }
        z.b bVar = (z.b) obj;
        return this.f12491a == bVar.b() && this.f12492b == bVar.d() && this.f12493c.equals(bVar.c());
    }

    public int hashCode() {
        long j3 = this.f12491a;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003;
        long j4 = this.f12492b;
        return this.f12493c.hashCode() ^ ((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f12491a + ", maxAllowedDelay=" + this.f12492b + ", flags=" + this.f12493c + "}";
    }

    private C0703d(long j3, long j4, Set set) {
        this.f12491a = j3;
        this.f12492b = j4;
        this.f12493c = set;
    }
}
