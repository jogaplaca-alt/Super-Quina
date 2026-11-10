package p059r0;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e f10863c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10865b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f10866a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f10867b = 0;

        a() {
        }

        public e a() {
            return new e(this.f10866a, this.f10867b);
        }

        public a b(long j3) {
            this.f10866a = j3;
            return this;
        }

        public a c(long j3) {
            this.f10867b = j3;
            return this;
        }
    }

    e(long j3, long j4) {
        this.f10864a = j3;
        this.f10865b = j4;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f10864a;
    }

    public long b() {
        return this.f10865b;
    }
}
