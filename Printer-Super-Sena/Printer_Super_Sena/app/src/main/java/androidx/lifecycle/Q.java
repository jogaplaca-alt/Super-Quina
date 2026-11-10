package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Q {
    public static O a(P.b bVar, Class cls) {
        S1.k.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static O b(P.b bVar, Class cls, T.a aVar) {
        S1.k.e(cls, "modelClass");
        S1.k.e(aVar, "extras");
        return bVar.a(cls);
    }
}
