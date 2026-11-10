package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class H implements InterfaceC0356n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F f5569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5570c;

    public H(String str, F f3) {
        S1.k.e(str, "key");
        S1.k.e(f3, "handle");
        this.f5568a = str;
        this.f5569b = f3;
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        S1.k.e(interfaceC0358p, "source");
        S1.k.e(aVar, "event");
        if (aVar == AbstractC0354l.a.ON_DESTROY) {
            this.f5570c = false;
            interfaceC0358p.getLifecycle().c(this);
        }
    }

    public final void h(Y.d dVar, AbstractC0354l abstractC0354l) {
        S1.k.e(dVar, "registry");
        S1.k.e(abstractC0354l, "lifecycle");
        if (this.f5570c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f5570c = true;
        abstractC0354l.a(this);
        dVar.h(this.f5568a, this.f5569b.c());
    }

    public final F i() {
        return this.f5569b;
    }

    public final boolean j() {
        return this.f5570c;
    }
}
