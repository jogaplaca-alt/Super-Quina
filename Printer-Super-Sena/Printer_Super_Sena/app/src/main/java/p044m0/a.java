package p044m0;

/* JADX INFO: loaded from: classes.dex */
final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f9996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f9998c;

    a(Integer num, Object obj, d dVar) {
        this.f9996a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f9997b = obj;
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f9998c = dVar;
    }

    @Override // p044m0.c
    public Integer a() {
        return this.f9996a;
    }

    @Override // p044m0.c
    public Object b() {
        return this.f9997b;
    }

    @Override // p044m0.c
    public d c() {
        return this.f9998c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f9996a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f9997b.equals(cVar.b()) && this.f9998c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f9996a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f9997b.hashCode()) * 1000003) ^ this.f9998c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f9996a + ", payload=" + this.f9997b + ", priority=" + this.f9998c + "}";
    }
}
