package p074w0;

import p050o0.i;
import p050o0.o;

/* JADX INFO: renamed from: w0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0719b extends AbstractC0728k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f12593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f12594c;

    C0719b(long j3, o oVar, i iVar) {
        this.f12592a = j3;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f12593b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f12594c = iVar;
    }

    @Override // p074w0.AbstractC0728k
    public i b() {
        return this.f12594c;
    }

    @Override // p074w0.AbstractC0728k
    public long c() {
        return this.f12592a;
    }

    @Override // p074w0.AbstractC0728k
    public o d() {
        return this.f12593b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0728k)) {
            return false;
        }
        AbstractC0728k abstractC0728k = (AbstractC0728k) obj;
        return this.f12592a == abstractC0728k.c() && this.f12593b.equals(abstractC0728k.d()) && this.f12594c.equals(abstractC0728k.b());
    }

    public int hashCode() {
        long j3 = this.f12592a;
        return this.f12594c.hashCode() ^ ((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f12593b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f12592a + ", transportContext=" + this.f12593b + ", event=" + this.f12594c + "}";
    }
}
