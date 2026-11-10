package p071v0;

import I1.a;
import java.util.concurrent.Executor;
import p056q0.b;
import p074w0.InterfaceC0721d;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f12483d;

    public Q(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f12480a = aVar;
        this.f12481b = aVar2;
        this.f12482c = aVar3;
        this.f12483d = aVar4;
    }

    public static Q a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new Q(aVar, aVar2, aVar3, aVar4);
    }

    public static P c(Executor executor, InterfaceC0721d interfaceC0721d, S s3, p077x0.b bVar) {
        return new P(executor, interfaceC0721d, s3, bVar);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public P get() {
        return c((Executor) this.f12480a.get(), (InterfaceC0721d) this.f12481b.get(), (S) this.f12482c.get(), (p077x0.b) this.f12483d.get());
    }
}
