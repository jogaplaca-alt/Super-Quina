package p072v1;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.a f12509b = d.a.DEFAULT;

    /* JADX INFO: renamed from: v1.a$a, reason: collision with other inner class name */
    private static final class C0135a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.a f12511b;

        C0135a(int i3, d.a aVar) {
            this.f12510a = i3;
            this.f12511b = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return d.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f12510a == dVar.tag() && this.f12511b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f12510a) + (this.f12511b.hashCode() ^ 2041407134);
        }

        @Override // p072v1.d
        public d.a intEncoding() {
            return this.f12511b;
        }

        @Override // p072v1.d
        public int tag() {
            return this.f12510a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f12510a + "intEncoding=" + this.f12511b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0135a(this.f12508a, this.f12509b);
    }

    public a c(int i3) {
        this.f12508a = i3;
        return this;
    }
}
