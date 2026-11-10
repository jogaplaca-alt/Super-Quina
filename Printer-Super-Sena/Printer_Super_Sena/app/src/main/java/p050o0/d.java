package p050o0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p044m0.d f10382c;

    static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f10384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private p044m0.d f10385c;

        b() {
        }

        @Override // o0.o.a
        public o a() {
            String str = "";
            if (this.f10383a == null) {
                str = " backendName";
            }
            if (this.f10385c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f10383a, this.f10384b, this.f10385c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o0.o.a
        public o.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f10383a = str;
            return this;
        }

        @Override // o0.o.a
        public o.a c(byte[] bArr) {
            this.f10384b = bArr;
            return this;
        }

        @Override // o0.o.a
        public o.a d(p044m0.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f10385c = dVar;
            return this;
        }
    }

    @Override // p050o0.o
    public String b() {
        return this.f10380a;
    }

    @Override // p050o0.o
    public byte[] c() {
        return this.f10381b;
    }

    @Override // p050o0.o
    public p044m0.d d() {
        return this.f10382c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f10380a.equals(oVar.b())) {
            if (Arrays.equals(this.f10381b, oVar instanceof d ? ((d) oVar).f10381b : oVar.c()) && this.f10382c.equals(oVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f10380a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f10381b)) * 1000003) ^ this.f10382c.hashCode();
    }

    private d(String str, byte[] bArr, p044m0.d dVar) {
        this.f10380a = str;
        this.f10381b = bArr;
        this.f10382c = dVar;
    }
}
