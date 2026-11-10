package p053p0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable f10463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10464b;

    static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterable f10465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f10466b;

        b() {
        }

        @Override // p0.f.a
        public f a() {
            String str = "";
            if (this.f10465a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f10465a, this.f10466b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p0.f.a
        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f10465a = iterable;
            return this;
        }

        @Override // p0.f.a
        public f.a c(byte[] bArr) {
            this.f10466b = bArr;
            return this;
        }
    }

    @Override // p053p0.f
    public Iterable b() {
        return this.f10463a;
    }

    @Override // p053p0.f
    public byte[] c() {
        return this.f10464b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f10463a.equals(fVar.b())) {
            if (Arrays.equals(this.f10464b, fVar instanceof a ? ((a) fVar).f10464b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f10463a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f10464b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f10463a + ", extras=" + Arrays.toString(this.f10464b) + "}";
    }

    private a(Iterable iterable, byte[] bArr) {
        this.f10463a = iterable;
        this.f10464b = bArr;
    }
}
