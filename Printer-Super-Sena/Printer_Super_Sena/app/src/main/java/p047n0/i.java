package p047n0;

/* JADX INFO: loaded from: classes.dex */
final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o.c f10164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o.b f10165b;

    static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private o.c f10166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private o.b f10167b;

        b() {
        }

        @Override // n0.o.a
        public o a() {
            return new i(this.f10166a, this.f10167b);
        }

        @Override // n0.o.a
        public o.a b(o.b bVar) {
            this.f10167b = bVar;
            return this;
        }

        @Override // n0.o.a
        public o.a c(o.c cVar) {
            this.f10166a = cVar;
            return this;
        }
    }

    @Override // p047n0.o
    public o.b b() {
        return this.f10165b;
    }

    @Override // p047n0.o
    public o.c c() {
        return this.f10164a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.f10164a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.f10165b;
            if (bVar == null) {
                if (oVar.b() == null) {
                    return true;
                }
            } else if (bVar.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.f10164a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f10165b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f10164a + ", mobileSubtype=" + this.f10165b + "}";
    }

    private i(o.c cVar, o.b bVar) {
        this.f10164a = cVar;
        this.f10165b = bVar;
    }
}
