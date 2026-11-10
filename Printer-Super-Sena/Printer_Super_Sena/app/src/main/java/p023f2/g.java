package p023f2;

import i2.b;
import java.nio.ByteBuffer;
import p011c2.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f9564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f9565c = b.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9563a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9566d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9567e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9568f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9569g = false;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9570a;

        static {
            int[] iArr = new int[c.values().length];
            f9570a = iArr;
            try {
                iArr[c.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9570a[c.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9570a[c.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9570a[c.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9570a[c.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9570a[c.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public g(c cVar) {
        this.f9564b = cVar;
    }

    public static g g(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (a.f9570a[cVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new i();
            case 3:
                return new j();
            case 4:
                return new p023f2.a();
            case 5:
                return new b();
            case 6:
                return new c();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    @Override // p023f2.f
    public c a() {
        return this.f9564b;
    }

    @Override // p023f2.f
    public boolean b() {
        return this.f9567e;
    }

    @Override // p023f2.f
    public boolean c() {
        return this.f9569g;
    }

    @Override // p023f2.f
    public boolean d() {
        return this.f9563a;
    }

    @Override // p023f2.f
    public boolean e() {
        return this.f9568f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f9563a != gVar.f9563a || this.f9566d != gVar.f9566d || this.f9567e != gVar.f9567e || this.f9568f != gVar.f9568f || this.f9569g != gVar.f9569g || this.f9564b != gVar.f9564b) {
            return false;
        }
        ByteBuffer byteBuffer = this.f9565c;
        ByteBuffer byteBuffer2 = gVar.f9565c;
        if (byteBuffer != null) {
            return byteBuffer.equals(byteBuffer2);
        }
        return byteBuffer2 == null;
    }

    @Override // p023f2.f
    public ByteBuffer f() {
        return this.f9565c;
    }

    public abstract void h();

    public int hashCode() {
        int iHashCode = (((this.f9563a ? 1 : 0) * 31) + this.f9564b.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f9565c;
        return ((((((((iHashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f9566d ? 1 : 0)) * 31) + (this.f9567e ? 1 : 0)) * 31) + (this.f9568f ? 1 : 0)) * 31) + (this.f9569g ? 1 : 0);
    }

    public void i(boolean z3) {
        this.f9563a = z3;
    }

    public void j(ByteBuffer byteBuffer) {
        this.f9565c = byteBuffer;
    }

    public void k(boolean z3) {
        this.f9567e = z3;
    }

    public void l(boolean z3) {
        this.f9568f = z3;
    }

    public void m(boolean z3) {
        this.f9569g = z3;
    }

    public void n(boolean z3) {
        this.f9566d = z3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ opcode:");
        sb.append(a());
        sb.append(", fin:");
        sb.append(d());
        sb.append(", rsv1:");
        sb.append(b());
        sb.append(", rsv2:");
        sb.append(e());
        sb.append(", rsv3:");
        sb.append(c());
        sb.append(", payload length:[pos:");
        sb.append(this.f9565c.position());
        sb.append(", len:");
        sb.append(this.f9565c.remaining());
        sb.append("], payload:");
        sb.append(this.f9565c.remaining() > 1000 ? "(too big to display)" : new String(this.f9565c.array()));
        sb.append('}');
        return sb.toString();
    }
}
