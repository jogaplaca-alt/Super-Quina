package p050o0;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import p044m0.b;
import p044m0.g;
import p044m0.h;
import p068u0.e;
import p071v0.L;
import p071v0.P;
import p080y0.a;

/* JADX INFO: loaded from: classes.dex */
public class t implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile u f10414e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f10417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final L f10418d;

    t(a aVar, a aVar2, e eVar, L l3, P p3) {
        this.f10415a = aVar;
        this.f10416b = aVar2;
        this.f10417c = eVar;
        this.f10418d = l3;
        p3.c();
    }

    private i b(n nVar) {
        return i.a().i(this.f10415a.a()).k(this.f10416b.a()).j(nVar.g()).h(new h(nVar.b(), nVar.d())).g(nVar.c().a()).d();
    }

    public static t c() {
        u uVar = f10414e;
        if (uVar != null) {
            return uVar.t();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        if (f10414e == null) {
            synchronized (t.class) {
                try {
                    if (f10414e == null) {
                        f10414e = e.y().b(context).a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // p050o0.s
    public void a(n nVar, h hVar) {
        this.f10417c.a(nVar.f().f(nVar.c().c()), b(nVar), hVar);
    }

    public L e() {
        return this.f10418d;
    }

    public g g(f fVar) {
        return new p(d(fVar), o.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
