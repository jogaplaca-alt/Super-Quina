package p084z1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import p075w1.d;
import p075w1.u;
import p075w1.v;
import p081y1.c;
import p081y1.i;

/* JADX INFO: loaded from: classes.dex */
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f12987a;

    private static final class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u f12988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f12989b;

        public a(d dVar, Type type, u uVar, i iVar) {
            this.f12988a = new n(dVar, uVar, type);
            this.f12989b = iVar;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection b(E1.a aVar) throws IOException {
            if (aVar.c0() == E1.b.NULL) {
                aVar.Y();
                return null;
            }
            Collection collection = (Collection) this.f12989b.a();
            aVar.g();
            while (aVar.O()) {
                collection.add(this.f12988a.b(aVar));
            }
            aVar.J();
            return collection;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, Collection collection) throws IOException {
            if (collection == null) {
                cVar.R();
                return;
            }
            cVar.y();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f12988a.d(cVar, it.next());
            }
            cVar.J();
        }
    }

    public b(c cVar) {
        this.f12987a = cVar;
    }

    @Override // p075w1.v
    public u a(d dVar, D1.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = p081y1.b.h(typeD, clsC);
        return new a(dVar, typeH, dVar.m(D1.a.b(typeH)), this.f12987a.b(aVar));
    }
}
