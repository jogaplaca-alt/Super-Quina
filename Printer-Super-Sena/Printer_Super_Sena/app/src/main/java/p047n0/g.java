package p047n0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f10151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f10152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f10154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f10155g;

    static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f10156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f10157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private k f10158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f10159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f10161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p f10162g;

        b() {
        }

        @Override // n0.m.a
        public m a() {
            String str = "";
            if (this.f10156a == null) {
                str = " requestTimeMs";
            }
            if (this.f10157b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f10156a.longValue(), this.f10157b.longValue(), this.f10158c, this.f10159d, this.f10160e, this.f10161f, this.f10162g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // n0.m.a
        public m.a b(k kVar) {
            this.f10158c = kVar;
            return this;
        }

        @Override // n0.m.a
        public m.a c(List list) {
            this.f10161f = list;
            return this;
        }

        @Override // n0.m.a
        m.a d(Integer num) {
            this.f10159d = num;
            return this;
        }

        @Override // n0.m.a
        m.a e(String str) {
            this.f10160e = str;
            return this;
        }

        @Override // n0.m.a
        public m.a f(p pVar) {
            this.f10162g = pVar;
            return this;
        }

        @Override // n0.m.a
        public m.a g(long j3) {
            this.f10156a = Long.valueOf(j3);
            return this;
        }

        @Override // n0.m.a
        public m.a h(long j3) {
            this.f10157b = Long.valueOf(j3);
            return this;
        }
    }

    @Override // p047n0.m
    public k b() {
        return this.f10151c;
    }

    @Override // p047n0.m
    public List c() {
        return this.f10154f;
    }

    @Override // p047n0.m
    public Integer d() {
        return this.f10152d;
    }

    @Override // p047n0.m
    public String e() {
        return this.f10153e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f10149a == mVar.g() && this.f10150b == mVar.h() && ((kVar = this.f10151c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f10152d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f10153e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f10154f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.f10155g;
            if (pVar == null) {
                if (mVar.f() == null) {
                    return true;
                }
            } else if (pVar.equals(mVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // p047n0.m
    public p f() {
        return this.f10155g;
    }

    @Override // p047n0.m
    public long g() {
        return this.f10149a;
    }

    @Override // p047n0.m
    public long h() {
        return this.f10150b;
    }

    public int hashCode() {
        long j3 = this.f10149a;
        long j4 = this.f10150b;
        int i3 = (((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        k kVar = this.f10151c;
        int iHashCode = (i3 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f10152d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f10153e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f10154f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f10155g;
        return iHashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f10149a + ", requestUptimeMs=" + this.f10150b + ", clientInfo=" + this.f10151c + ", logSource=" + this.f10152d + ", logSourceName=" + this.f10153e + ", logEvents=" + this.f10154f + ", qosTier=" + this.f10155g + "}";
    }

    private g(long j3, long j4, k kVar, Integer num, String str, List list, p pVar) {
        this.f10149a = j3;
        this.f10150b = j4;
        this.f10151c = kVar;
        this.f10152d = num;
        this.f10153e = str;
        this.f10154f = list;
        this.f10155g = pVar;
    }
}
