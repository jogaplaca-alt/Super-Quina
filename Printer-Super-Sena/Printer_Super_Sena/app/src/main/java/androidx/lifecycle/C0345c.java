package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0345c implements InterfaceC0356n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0350h[] f5610a;

    public C0345c(InterfaceC0350h[] interfaceC0350hArr) {
        S1.k.e(interfaceC0350hArr, "generatedAdapters");
        this.f5610a = interfaceC0350hArr;
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        S1.k.e(interfaceC0358p, "source");
        S1.k.e(aVar, "event");
        new C0361t();
        InterfaceC0350h[] interfaceC0350hArr = this.f5610a;
        if (interfaceC0350hArr.length > 0) {
            InterfaceC0350h interfaceC0350h = interfaceC0350hArr[0];
            throw null;
        }
        if (interfaceC0350hArr.length <= 0) {
            return;
        }
        InterfaceC0350h interfaceC0350h2 = interfaceC0350hArr[0];
        throw null;
    }
}
