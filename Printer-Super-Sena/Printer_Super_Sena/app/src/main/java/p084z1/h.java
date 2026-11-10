package p084z1;

import E1.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import p075w1.d;
import p075w1.n;
import p075w1.p;
import p075w1.u;
import p075w1.v;
import p081y1.c;
import p081y1.f;
import p081y1.i;
import p081y1.m;

/* JADX INFO: loaded from: classes.dex */
public final class h implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f13009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f13010b;

    private final class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u f13011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u f13012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final i f13013c;

        public a(d dVar, Type type, u uVar, Type type2, u uVar2, i iVar) {
            this.f13011a = new n(dVar, uVar, type);
            this.f13012b = new n(dVar, uVar2, type2);
            this.f13013c = iVar;
        }

        private String e(p075w1.i iVar) {
            if (!iVar.p()) {
                if (iVar.n()) {
                    return "null";
                }
                throw new AssertionError();
            }
            n nVarL = iVar.l();
            if (nVarL.y()) {
                return String.valueOf(nVarL.u());
            }
            if (nVarL.w()) {
                return Boolean.toString(nVarL.q());
            }
            if (nVarL.z()) {
                return nVarL.v();
            }
            throw new AssertionError();
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map b(E1.a aVar) throws IOException {
            b bVarC0 = aVar.c0();
            if (bVarC0 == b.NULL) {
                aVar.Y();
                return null;
            }
            Map map = (Map) this.f13013c.a();
            if (bVarC0 == b.BEGIN_ARRAY) {
                aVar.g();
                while (aVar.O()) {
                    aVar.g();
                    Object objB = this.f13011a.b(aVar);
                    if (map.put(objB, this.f13012b.b(aVar)) != null) {
                        throw new p("duplicate key: " + objB);
                    }
                    aVar.J();
                }
                aVar.J();
            } else {
                aVar.t();
                while (aVar.O()) {
                    f.f12859a.a(aVar);
                    Object objB2 = this.f13011a.b(aVar);
                    if (map.put(objB2, this.f13012b.b(aVar)) != null) {
                        throw new p("duplicate key: " + objB2);
                    }
                }
                aVar.K();
            }
            return map;
        }

        @Override // p075w1.u
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(E1.c cVar, Map map) throws IOException {
            if (map == null) {
                cVar.R();
                return;
            }
            if (!h.this.f13010b) {
                cVar.G();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.P(String.valueOf(entry.getKey()));
                    this.f13012b.d(cVar, entry.getValue());
                }
                cVar.K();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i3 = 0;
            boolean z3 = false;
            for (Map.Entry entry2 : map.entrySet()) {
                p075w1.i iVarC = this.f13011a.c(entry2.getKey());
                arrayList.add(iVarC);
                arrayList2.add(entry2.getValue());
                z3 |= iVarC.m() || iVarC.o();
            }
            if (!z3) {
                cVar.G();
                int size = arrayList.size();
                while (i3 < size) {
                    cVar.P(e((p075w1.i) arrayList.get(i3)));
                    this.f13012b.d(cVar, arrayList2.get(i3));
                    i3++;
                }
                cVar.K();
                return;
            }
            cVar.y();
            int size2 = arrayList.size();
            while (i3 < size2) {
                cVar.y();
                m.b((p075w1.i) arrayList.get(i3), cVar);
                this.f13012b.d(cVar, arrayList2.get(i3));
                cVar.J();
                i3++;
            }
            cVar.J();
        }
    }

    public h(c cVar, boolean z3) {
        this.f13009a = cVar;
        this.f13010b = z3;
    }

    private u b(d dVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.f13093f : dVar.m(D1.a.b(type));
    }

    @Override // p075w1.v
    public u a(d dVar, D1.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = p081y1.b.j(typeD, clsC);
        return new a(dVar, typeArrJ[0], b(dVar, typeArrJ[0]), typeArrJ[1], dVar.m(D1.a.b(typeArrJ[1])), this.f13009a.b(aVar));
    }
}
