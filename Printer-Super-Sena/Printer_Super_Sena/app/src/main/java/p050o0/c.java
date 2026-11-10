package p050o0;

import p044m0.e;

/* JADX INFO: loaded from: classes.dex */
final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f10370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p044m0.c f10372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f10373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p044m0.b f10374e;

    static final class b extends n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private o f10375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private p044m0.c f10377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e f10378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private p044m0.b f10379e;

        b() {
        }

        @Override // o0.n.a
        public n a() {
            String str = "";
            if (this.f10375a == null) {
                str = " transportContext";
            }
            if (this.f10376b == null) {
                str = str + " transportName";
            }
            if (this.f10377c == null) {
                str = str + " event";
            }
            if (this.f10378d == null) {
                str = str + " transformer";
            }
            if (this.f10379e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f10375a, this.f10376b, this.f10377c, this.f10378d, this.f10379e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o0.n.a
        n.a b(p044m0.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f10379e = bVar;
            return this;
        }

        @Override // o0.n.a
        n.a c(p044m0.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f10377c = cVar;
            return this;
        }

        @Override // o0.n.a
        n.a d(e eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f10378d = eVar;
            return this;
        }

        @Override // o0.n.a
        public n.a e(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f10375a = oVar;
            return this;
        }

        @Override // o0.n.a
        public n.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f10376b = str;
            return this;
        }
    }

    @Override // p050o0.n
    public p044m0.b b() {
        return this.f10374e;
    }

    @Override // p050o0.n
    p044m0.c c() {
        return this.f10372c;
    }

    @Override // p050o0.n
    e e() {
        return this.f10373d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f10370a.equals(nVar.f()) && this.f10371b.equals(nVar.g()) && this.f10372c.equals(nVar.c()) && this.f10373d.equals(nVar.e()) && this.f10374e.equals(nVar.b());
    }

    @Override // p050o0.n
    public o f() {
        return this.f10370a;
    }

    @Override // p050o0.n
    public String g() {
        return this.f10371b;
    }

    public int hashCode() {
        return ((((((((this.f10370a.hashCode() ^ 1000003) * 1000003) ^ this.f10371b.hashCode()) * 1000003) ^ this.f10372c.hashCode()) * 1000003) ^ this.f10373d.hashCode()) * 1000003) ^ this.f10374e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f10370a + ", transportName=" + this.f10371b + ", event=" + this.f10372c + ", transformer=" + this.f10373d + ", encoding=" + this.f10374e + "}";
    }

    private c(o oVar, String str, p044m0.c cVar, e eVar, p044m0.b bVar) {
        this.f10370a = oVar;
        this.f10371b = str;
        this.f10372c = cVar;
        this.f10373d = eVar;
        this.f10374e = bVar;
    }
}
