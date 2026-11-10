package p059r0;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f10868c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10870b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f10871a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f10872b = 0;

        a() {
        }

        public f a() {
            return new f(this.f10871a, this.f10872b);
        }

        public a b(long j3) {
            this.f10872b = j3;
            return this;
        }

        public a c(long j3) {
            this.f10871a = j3;
            return this;
        }
    }

    f(long j3, long j4) {
        this.f10869a = j3;
        this.f10870b = j4;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f10870b;
    }

    public long b() {
        return this.f10869a;
    }
}
