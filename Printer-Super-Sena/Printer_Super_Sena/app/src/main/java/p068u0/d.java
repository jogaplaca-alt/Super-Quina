package p068u0;

import I1.a;
import java.util.concurrent.Executor;
import p053p0.e;
import p056q0.b;
import p071v0.S;
import p074w0.InterfaceC0721d;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f11937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f11938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f11939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f11940e;

    public d(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f11936a = aVar;
        this.f11937b = aVar2;
        this.f11938c = aVar3;
        this.f11939d = aVar4;
        this.f11940e = aVar5;
    }

    public static d a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, e eVar, S s3, InterfaceC0721d interfaceC0721d, p077x0.b bVar) {
        return new c(executor, eVar, s3, interfaceC0721d, bVar);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f11936a.get(), (e) this.f11937b.get(), (S) this.f11938c.get(), (InterfaceC0721d) this.f11939d.get(), (p077x0.b) this.f11940e.get());
    }
}
