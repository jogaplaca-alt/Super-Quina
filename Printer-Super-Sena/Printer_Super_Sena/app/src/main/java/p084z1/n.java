package p084z1;

import E1.a;
import E1.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import p075w1.d;
import p075w1.u;

/* JADX INFO: loaded from: classes.dex */
final class n extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f13061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f13062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f13063c;

    n(d dVar, u uVar, Type type) {
        this.f13061a = dVar;
        this.f13062b = uVar;
        this.f13063c = type;
    }

    private static Type e(Type type, Object obj) {
        if (obj != null) {
            return ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type;
        }
        return type;
    }

    private static boolean f(u uVar) {
        u uVarE;
        while ((uVar instanceof l) && (uVarE = ((l) uVar).e()) != uVar) {
            uVar = uVarE;
        }
        return uVar instanceof k.b;
    }

    @Override // p075w1.u
    public Object b(a aVar) {
        return this.f13062b.b(aVar);
    }

    @Override // p075w1.u
    public void d(c cVar, Object obj) {
        u uVarM = this.f13062b;
        Type typeE = e(this.f13063c, obj);
        if (typeE != this.f13063c) {
            uVarM = this.f13061a.m(D1.a.b(typeE));
            if ((uVarM instanceof k.b) && !f(this.f13062b)) {
                uVarM = this.f13062b;
            }
        }
        uVarM.d(cVar, obj);
    }
}
