package p084z1;

import D1.a;
import p075w1.d;
import p075w1.h;
import p075w1.u;
import p075w1.v;
import p078x1.b;
import p081y1.c;

/* JADX INFO: loaded from: classes.dex */
public final class e implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f12996a;

    public e(c cVar) {
        this.f12996a = cVar;
    }

    @Override // p075w1.v
    public u a(d dVar, a aVar) {
        b bVar = (b) aVar.c().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return b(this.f12996a, dVar, aVar, bVar);
    }

    u b(c cVar, d dVar, a aVar, b bVar) {
        u mVar;
        Object objA = cVar.b(a.a(bVar.value())).a();
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof u) {
            mVar = (u) objA;
        } else if (objA instanceof v) {
            mVar = ((v) objA).a(dVar, aVar);
        } else {
            if (!(objA instanceof h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m(null, objA instanceof h ? (h) objA : null, dVar, aVar, null, zNullSafe);
            zNullSafe = false;
        }
        return (mVar == null || !zNullSafe) ? mVar : mVar.a();
    }
}
