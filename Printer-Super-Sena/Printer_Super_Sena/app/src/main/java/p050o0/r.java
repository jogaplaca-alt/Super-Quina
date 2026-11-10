package p050o0;

import p044m0.b;
import p044m0.c;
import p044m0.e;
import p044m0.f;
import p044m0.h;

/* JADX INFO: loaded from: classes.dex */
final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f10409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f10411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f10412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f10413e;

    r(o oVar, String str, b bVar, e eVar, s sVar) {
        this.f10409a = oVar;
        this.f10410b = str;
        this.f10411c = bVar;
        this.f10412d = eVar;
        this.f10413e = sVar;
    }

    @Override // p044m0.f
    public void a(c cVar) {
        d(cVar, new h() { // from class: o0.q
            @Override // p044m0.h
            public final void a(Exception exc) {
                r.c(exc);
            }
        });
    }

    public void d(c cVar, h hVar) {
        this.f10413e.a(n.a().e(this.f10409a).c(cVar).f(this.f10410b).d(this.f10412d).b(this.f10411c).a(), hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }
}
