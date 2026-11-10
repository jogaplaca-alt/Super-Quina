package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class z implements InterfaceC0356n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0344b.a f5677b;

    z(Object obj) {
        this.f5676a = obj;
        this.f5677b = C0344b.f5603c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        this.f5677b.a(interfaceC0358p, aVar, this.f5676a);
    }
}
