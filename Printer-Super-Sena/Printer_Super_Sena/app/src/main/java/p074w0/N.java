package p074w0;

import I1.a;
import p056q0.b;

/* JADX INFO: loaded from: classes.dex */
public final class N implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f12567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f12568e;

    public N(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f12564a = aVar;
        this.f12565b = aVar2;
        this.f12566c = aVar3;
        this.f12567d = aVar4;
        this.f12568e = aVar5;
    }

    public static N a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new N(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static M c(p080y0.a aVar, p080y0.a aVar2, Object obj, Object obj2, a aVar3) {
        return new M(aVar, aVar2, (AbstractC0722e) obj, (U) obj2, aVar3);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public M get() {
        return c((p080y0.a) this.f12564a.get(), (p080y0.a) this.f12565b.get(), this.f12566c.get(), this.f12567d.get(), this.f12568e);
    }
}
