package p050o0;

import I1.a;
import p056q0.b;
import p068u0.e;
import p071v0.L;
import p071v0.P;

/* JADX INFO: loaded from: classes.dex */
public final class v implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f10422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f10423e;

    public v(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f10419a = aVar;
        this.f10420b = aVar2;
        this.f10421c = aVar3;
        this.f10422d = aVar4;
        this.f10423e = aVar5;
    }

    public static v a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(p080y0.a aVar, p080y0.a aVar2, e eVar, L l3, P p3) {
        return new t(aVar, aVar2, eVar, l3, p3);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c((p080y0.a) this.f10419a.get(), (p080y0.a) this.f10420b.get(), (e) this.f10421c.get(), (L) this.f10422d.get(), (P) this.f10423e.get());
    }
}
