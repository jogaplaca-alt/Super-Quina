package p074w0;

/* JADX INFO: renamed from: w0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0718a extends AbstractC0722e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f12586f;

    /* JADX INFO: renamed from: w0.a$b */
    static final class b extends AbstractC0722e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f12588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f12589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f12590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f12591e;

        b() {
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e a() {
            String str = "";
            if (this.f12587a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f12588b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f12589c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f12590d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f12591e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C0718a(this.f12587a.longValue(), this.f12588b.intValue(), this.f12589c.intValue(), this.f12590d.longValue(), this.f12591e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e.a b(int i3) {
            this.f12589c = Integer.valueOf(i3);
            return this;
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e.a c(long j3) {
            this.f12590d = Long.valueOf(j3);
            return this;
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e.a d(int i3) {
            this.f12588b = Integer.valueOf(i3);
            return this;
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e.a e(int i3) {
            this.f12591e = Integer.valueOf(i3);
            return this;
        }

        @Override // p074w0.AbstractC0722e.a
        AbstractC0722e.a f(long j3) {
            this.f12587a = Long.valueOf(j3);
            return this;
        }
    }

    @Override // p074w0.AbstractC0722e
    int b() {
        return this.f12584d;
    }

    @Override // p074w0.AbstractC0722e
    long c() {
        return this.f12585e;
    }

    @Override // p074w0.AbstractC0722e
    int d() {
        return this.f12583c;
    }

    @Override // p074w0.AbstractC0722e
    int e() {
        return this.f12586f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0722e)) {
            return false;
        }
        AbstractC0722e abstractC0722e = (AbstractC0722e) obj;
        return this.f12582b == abstractC0722e.f() && this.f12583c == abstractC0722e.d() && this.f12584d == abstractC0722e.b() && this.f12585e == abstractC0722e.c() && this.f12586f == abstractC0722e.e();
    }

    @Override // p074w0.AbstractC0722e
    long f() {
        return this.f12582b;
    }

    public int hashCode() {
        long j3 = this.f12582b;
        int i3 = (((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f12583c) * 1000003) ^ this.f12584d) * 1000003;
        long j4 = this.f12585e;
        return this.f12586f ^ ((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f12582b + ", loadBatchSize=" + this.f12583c + ", criticalSectionEnterTimeoutMs=" + this.f12584d + ", eventCleanUpAge=" + this.f12585e + ", maxBlobByteSizePerRow=" + this.f12586f + "}";
    }

    private C0718a(long j3, int i3, int i4, long j4, int i5) {
        this.f12582b = j3;
        this.f12583c = i3;
        this.f12584d = i4;
        this.f12585e = j4;
        this.f12586f = i5;
    }
}
