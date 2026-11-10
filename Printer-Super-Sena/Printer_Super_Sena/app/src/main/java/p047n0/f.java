package p047n0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f10136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f10140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final o f10141g;

    static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f10142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f10143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f10144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f10145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f10147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private o f10148g;

        b() {
        }

        @Override // n0.l.a
        public l a() {
            String str = "";
            if (this.f10142a == null) {
                str = " eventTimeMs";
            }
            if (this.f10144c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f10147f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f10142a.longValue(), this.f10143b, this.f10144c.longValue(), this.f10145d, this.f10146e, this.f10147f.longValue(), this.f10148g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // n0.l.a
        public l.a b(Integer num) {
            this.f10143b = num;
            return this;
        }

        @Override // n0.l.a
        public l.a c(long j3) {
            this.f10142a = Long.valueOf(j3);
            return this;
        }

        @Override // n0.l.a
        public l.a d(long j3) {
            this.f10144c = Long.valueOf(j3);
            return this;
        }

        @Override // n0.l.a
        public l.a e(o oVar) {
            this.f10148g = oVar;
            return this;
        }

        @Override // n0.l.a
        l.a f(byte[] bArr) {
            this.f10145d = bArr;
            return this;
        }

        @Override // n0.l.a
        l.a g(String str) {
            this.f10146e = str;
            return this;
        }

        @Override // n0.l.a
        public l.a h(long j3) {
            this.f10147f = Long.valueOf(j3);
            return this;
        }
    }

    @Override // p047n0.l
    public Integer b() {
        return this.f10136b;
    }

    @Override // p047n0.l
    public long c() {
        return this.f10135a;
    }

    @Override // p047n0.l
    public long d() {
        return this.f10137c;
    }

    @Override // p047n0.l
    public o e() {
        return this.f10141g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f10135a == lVar.c() && ((num = this.f10136b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f10137c == lVar.d()) {
            if (Arrays.equals(this.f10138d, lVar instanceof f ? ((f) lVar).f10138d : lVar.f()) && ((str = this.f10139e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f10140f == lVar.h()) {
                o oVar = this.f10141g;
                if (oVar == null) {
                    if (lVar.e() == null) {
                        return true;
                    }
                } else if (oVar.equals(lVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p047n0.l
    public byte[] f() {
        return this.f10138d;
    }

    @Override // p047n0.l
    public String g() {
        return this.f10139e;
    }

    @Override // p047n0.l
    public long h() {
        return this.f10140f;
    }

    public int hashCode() {
        long j3 = this.f10135a;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f10136b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j4 = this.f10137c;
        int iHashCode2 = (((((i3 ^ iHashCode) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f10138d)) * 1000003;
        String str = this.f10139e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j5 = this.f10140f;
        int i4 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        o oVar = this.f10141g;
        return i4 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f10135a + ", eventCode=" + this.f10136b + ", eventUptimeMs=" + this.f10137c + ", sourceExtension=" + Arrays.toString(this.f10138d) + ", sourceExtensionJsonProto3=" + this.f10139e + ", timezoneOffsetSeconds=" + this.f10140f + ", networkConnectionInfo=" + this.f10141g + "}";
    }

    private f(long j3, Integer num, long j4, byte[] bArr, String str, long j5, o oVar) {
        this.f10135a = j3;
        this.f10136b = num;
        this.f10137c = j4;
        this.f10138d = bArr;
        this.f10139e = str;
        this.f10140f = j5;
        this.f10141g = oVar;
    }
}
