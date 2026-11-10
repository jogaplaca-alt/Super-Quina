package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0481y0 implements InterfaceC0410c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0481y0 f7581a = new C0481y0();

    private C0481y0() {
    }

    public static C0481y0 c() {
        return f7581a;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0410c1
    public final InterfaceC0406b1 a(Class cls) {
        if (!B0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC0406b1) B0.l(cls.asSubclass(B0.class)).z(3, null, null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0410c1
    public final boolean b(Class cls) {
        return B0.class.isAssignableFrom(cls);
    }
}
