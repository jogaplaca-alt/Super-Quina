package p056q0;

/* JADX INFO: loaded from: classes.dex */
public final class a implements I1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f10554c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile I1.a f10555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f10556b = f10554c;

    private a(I1.a aVar) {
        this.f10555a = aVar;
    }

    public static I1.a a(I1.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f10554c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // I1.a
    public Object get() {
        Object obj = this.f10556b;
        Object obj2 = f10554c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f10556b;
                    if (obj == obj2) {
                        obj = this.f10555a.get();
                        this.f10556b = b(this.f10556b, obj);
                        this.f10555a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }
}
