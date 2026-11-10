package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class G implements InterfaceC0356n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J f5567a;

    public G(J j3) {
        S1.k.e(j3, "provider");
        this.f5567a = j3;
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        S1.k.e(interfaceC0358p, "source");
        S1.k.e(aVar, "event");
        if (aVar == AbstractC0354l.a.ON_CREATE) {
            interfaceC0358p.getLifecycle().c(this);
            this.f5567a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
