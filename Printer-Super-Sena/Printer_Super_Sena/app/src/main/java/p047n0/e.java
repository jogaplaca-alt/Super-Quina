package p047n0;

/* JADX INFO: loaded from: classes.dex */
final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k.b f10131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p047n0.a f10132b;

    static final class b extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private k.b f10133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p047n0.a f10134b;

        b() {
        }

        @Override // n0.k.a
        public k a() {
            return new e(this.f10133a, this.f10134b);
        }

        @Override // n0.k.a
        public k.a b(p047n0.a aVar) {
            this.f10134b = aVar;
            return this;
        }

        @Override // n0.k.a
        public k.a c(k.b bVar) {
            this.f10133a = bVar;
            return this;
        }
    }

    @Override // p047n0.k
    public p047n0.a b() {
        return this.f10132b;
    }

    @Override // p047n0.k
    public k.b c() {
        return this.f10131a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.f10131a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            p047n0.a aVar = this.f10132b;
            if (aVar == null) {
                if (kVar.b() == null) {
                    return true;
                }
            } else if (aVar.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.f10131a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        p047n0.a aVar = this.f10132b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f10131a + ", androidClientInfo=" + this.f10132b + "}";
    }

    private e(k.b bVar, p047n0.a aVar) {
        this.f10131a = bVar;
        this.f10132b = aVar;
    }
}
