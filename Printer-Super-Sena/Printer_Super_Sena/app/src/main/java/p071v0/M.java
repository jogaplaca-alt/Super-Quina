package p071v0;

import I1.a;
import android.content.Context;
import java.util.concurrent.Executor;
import p053p0.e;
import p056q0.b;
import p074w0.InterfaceC0720c;
import p074w0.InterfaceC0721d;

/* JADX INFO: loaded from: classes.dex */
public final class M implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f12468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f12469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f12470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f12471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f12472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f12473i;

    public M(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        this.f12465a = aVar;
        this.f12466b = aVar2;
        this.f12467c = aVar3;
        this.f12468d = aVar4;
        this.f12469e = aVar5;
        this.f12470f = aVar6;
        this.f12471g = aVar7;
        this.f12472h = aVar8;
        this.f12473i = aVar9;
    }

    public static M a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        return new M(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static L c(Context context, e eVar, InterfaceC0721d interfaceC0721d, S s3, Executor executor, p077x0.b bVar, p080y0.a aVar, p080y0.a aVar2, InterfaceC0720c interfaceC0720c) {
        return new L(context, eVar, interfaceC0721d, s3, executor, bVar, aVar, aVar2, interfaceC0720c);
    }

    @Override // I1.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public L get() {
        return c((Context) this.f12465a.get(), (e) this.f12466b.get(), (InterfaceC0721d) this.f12467c.get(), (S) this.f12468d.get(), (Executor) this.f12469e.get(), (p077x0.b) this.f12470f.get(), (p080y0.a) this.f12471g.get(), (p080y0.a) this.f12472h.get(), (InterfaceC0720c) this.f12473i.get());
    }
}
