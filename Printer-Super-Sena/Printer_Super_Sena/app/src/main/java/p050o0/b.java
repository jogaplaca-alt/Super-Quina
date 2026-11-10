package p050o0;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f10359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f10360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f10363f;

    /* JADX INFO: renamed from: o0.b$b, reason: collision with other inner class name */
    static final class C0128b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f10365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f10366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f10367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f10368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map f10369f;

        C0128b() {
        }

        @Override // o0.i.a
        public i d() {
            String str = "";
            if (this.f10364a == null) {
                str = " transportName";
            }
            if (this.f10366c == null) {
                str = str + " encodedPayload";
            }
            if (this.f10367d == null) {
                str = str + " eventMillis";
            }
            if (this.f10368e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f10369f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f10364a, this.f10365b, this.f10366c, this.f10367d.longValue(), this.f10368e.longValue(), this.f10369f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o0.i.a
        protected Map e() {
            Map map = this.f10369f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // o0.i.a
        protected i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f10369f = map;
            return this;
        }

        @Override // o0.i.a
        public i.a g(Integer num) {
            this.f10365b = num;
            return this;
        }

        @Override // o0.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f10366c = hVar;
            return this;
        }

        @Override // o0.i.a
        public i.a i(long j3) {
            this.f10367d = Long.valueOf(j3);
            return this;
        }

        @Override // o0.i.a
        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f10364a = str;
            return this;
        }

        @Override // o0.i.a
        public i.a k(long j3) {
            this.f10368e = Long.valueOf(j3);
            return this;
        }
    }

    @Override // p050o0.i
    protected Map c() {
        return this.f10363f;
    }

    @Override // p050o0.i
    public Integer d() {
        return this.f10359b;
    }

    @Override // p050o0.i
    public h e() {
        return this.f10360c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f10358a.equals(iVar.j()) && ((num = this.f10359b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f10360c.equals(iVar.e()) && this.f10361d == iVar.f() && this.f10362e == iVar.k() && this.f10363f.equals(iVar.c());
    }

    @Override // p050o0.i
    public long f() {
        return this.f10361d;
    }

    public int hashCode() {
        int iHashCode = (this.f10358a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f10359b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f10360c.hashCode()) * 1000003;
        long j3 = this.f10361d;
        int i3 = (iHashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f10362e;
        return ((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ this.f10363f.hashCode();
    }

    @Override // p050o0.i
    public String j() {
        return this.f10358a;
    }

    @Override // p050o0.i
    public long k() {
        return this.f10362e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f10358a + ", code=" + this.f10359b + ", encodedPayload=" + this.f10360c + ", eventMillis=" + this.f10361d + ", uptimeMillis=" + this.f10362e + ", autoMetadata=" + this.f10363f + "}";
    }

    private b(String str, Integer num, h hVar, long j3, long j4, Map map) {
        this.f10358a = str;
        this.f10359b = num;
        this.f10360c = hVar;
        this.f10361d = j3;
        this.f10362e = j4;
        this.f10363f = map;
    }
}
