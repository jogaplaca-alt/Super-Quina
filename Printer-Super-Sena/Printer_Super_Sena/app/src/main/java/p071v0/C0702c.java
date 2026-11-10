package p071v0;

import java.util.Map;
import p080y0.a;

/* JADX INFO: renamed from: v0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0702c extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f12490b;

    C0702c(a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f12489a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f12490b = map;
    }

    @Override // p071v0.z
    a e() {
        return this.f12489a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f12489a.equals(zVar.e()) && this.f12490b.equals(zVar.h());
    }

    @Override // p071v0.z
    Map h() {
        return this.f12490b;
    }

    public int hashCode() {
        return ((this.f12489a.hashCode() ^ 1000003) * 1000003) ^ this.f12490b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f12489a + ", values=" + this.f12490b + "}";
    }
}
