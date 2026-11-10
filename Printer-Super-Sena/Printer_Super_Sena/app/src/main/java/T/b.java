package T;

import S1.g;
import S1.k;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // T.a
    public Object a(a.b bVar) {
        k.e(bVar, "key");
        return b().get(bVar);
    }

    public final void c(a.b bVar, Object obj) {
        k.e(bVar, "key");
        b().put(bVar, obj);
    }

    public b(a aVar) {
        k.e(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ b(a aVar, int i3, g gVar) {
        this((i3 & 1) != 0 ? a.C0024a.f1954b : aVar);
    }
}
