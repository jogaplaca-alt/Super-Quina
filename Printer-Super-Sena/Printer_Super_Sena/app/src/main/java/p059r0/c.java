package p059r0;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f10844c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f10846b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f10847a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f10848b = b.REASON_UNKNOWN;

        a() {
        }

        public c a() {
            return new c(this.f10847a, this.f10848b);
        }

        public a b(long j3) {
            this.f10847a = j3;
            return this;
        }

        public a c(b bVar) {
            this.f10848b = bVar;
            return this;
        }
    }

    public enum b implements p072v1.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10857a;

        b(int i3) {
            this.f10857a = i3;
        }

        @Override // p072v1.c
        public int a() {
            return this.f10857a;
        }
    }

    c(long j3, b bVar) {
        this.f10845a = j3;
        this.f10846b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f10845a;
    }

    public b b() {
        return this.f10846b;
    }
}
