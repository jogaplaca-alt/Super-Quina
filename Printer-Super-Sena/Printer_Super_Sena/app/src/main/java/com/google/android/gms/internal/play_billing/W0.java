package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class W0 implements InterfaceC0410c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0410c1[] f7382a;

    W0(InterfaceC0410c1... interfaceC0410c1Arr) {
        this.f7382a = interfaceC0410c1Arr;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0410c1
    public final InterfaceC0406b1 a(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            InterfaceC0410c1 interfaceC0410c1 = this.f7382a[i3];
            if (interfaceC0410c1.b(cls)) {
                return interfaceC0410c1.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0410c1
    public final boolean b(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.f7382a[i3].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
