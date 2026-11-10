package p084z1;

import java.lang.reflect.Type;
import p075w1.d;
import p075w1.g;
import p075w1.h;
import p075w1.i;
import p075w1.o;
import p075w1.u;
import p075w1.v;

/* JADX INFO: loaded from: classes.dex */
public final class m extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f13049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d f13050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D1.a f13051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v f13052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f13053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile u f13055g;

    private final class b implements g {
        private b() {
        }

        @Override // p075w1.g
        public Object a(i iVar, Type type) {
            return m.this.f13050b.l(iVar, type);
        }
    }

    private static final class c implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final D1.a f13057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f13059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h f13060d;

        c(Object obj, D1.a aVar, boolean z3, Class cls) {
            h hVar = obj instanceof h ? (h) obj : null;
            this.f13060d = hVar;
            p081y1.a.a(hVar != null);
            this.f13057a = aVar;
            this.f13058b = z3;
            this.f13059c = cls;
        }

        @Override // p075w1.v
        public u a(d dVar, D1.a aVar) {
            boolean zIsAssignableFrom;
            D1.a aVar2 = this.f13057a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.f13058b && this.f13057a.d() == aVar.c());
            } else {
                zIsAssignableFrom = this.f13059c.isAssignableFrom(aVar.c());
            }
            if (zIsAssignableFrom) {
                return new m(null, this.f13060d, dVar, aVar, this);
            }
            return null;
        }
    }

    public m(o oVar, h hVar, d dVar, D1.a aVar, v vVar, boolean z3) {
        this.f13053e = new b();
        this.f13049a = hVar;
        this.f13050b = dVar;
        this.f13051c = aVar;
        this.f13052d = vVar;
        this.f13054f = z3;
    }

    private u f() {
        u uVar = this.f13055g;
        if (uVar != null) {
            return uVar;
        }
        u uVarO = this.f13050b.o(this.f13052d, this.f13051c);
        this.f13055g = uVarO;
        return uVarO;
    }

    public static v g(D1.a aVar, Object obj) {
        return new c(obj, aVar, aVar.d() == aVar.c(), null);
    }

    @Override // p075w1.u
    public Object b(E1.a aVar) {
        if (this.f13049a == null) {
            return f().b(aVar);
        }
        i iVarA = p081y1.m.a(aVar);
        if (this.f13054f && iVarA.n()) {
            return null;
        }
        return this.f13049a.deserialize(iVarA, this.f13051c.d(), this.f13053e);
    }

    @Override // p075w1.u
    public void d(E1.c cVar, Object obj) {
        f().d(cVar, obj);
    }

    @Override // p084z1.l
    public u e() {
        return f();
    }

    public m(o oVar, h hVar, d dVar, D1.a aVar, v vVar) {
        this(oVar, hVar, dVar, aVar, vVar, true);
    }
}
