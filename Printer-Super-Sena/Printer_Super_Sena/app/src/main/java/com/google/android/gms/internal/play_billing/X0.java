package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class X0 implements InterfaceC0459q1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final InterfaceC0410c1 f7384b = new V0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0410c1 f7385a;

    public X0() {
        InterfaceC0410c1 interfaceC0410c1;
        C0481y0 c0481y0C = C0481y0.c();
        try {
            interfaceC0410c1 = (InterfaceC0410c1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            interfaceC0410c1 = f7384b;
        }
        W0 w3 = new W0(c0481y0C, interfaceC0410c1);
        byte[] bArr = J0.f7336d;
        this.f7385a = w3;
    }

    private static boolean b(InterfaceC0406b1 interfaceC0406b1) {
        return interfaceC0406b1.b() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0459q1
    public final InterfaceC0456p1 a(Class cls) {
        AbstractC0461r1.w(cls);
        InterfaceC0406b1 interfaceC0406b1A = this.f7385a.a(cls);
        if (interfaceC0406b1A.a()) {
            return B0.class.isAssignableFrom(cls) ? C0434i1.j(AbstractC0461r1.t(), AbstractC0469u0.b(), interfaceC0406b1A.c()) : C0434i1.j(AbstractC0461r1.s(), AbstractC0469u0.a(), interfaceC0406b1A.c());
        }
        if (B0.class.isAssignableFrom(cls)) {
            return b(interfaceC0406b1A) ? C0430h1.A(cls, interfaceC0406b1A, AbstractC0441k1.b(), U0.d(), AbstractC0461r1.t(), AbstractC0469u0.b(), AbstractC0402a1.b()) : C0430h1.A(cls, interfaceC0406b1A, AbstractC0441k1.b(), U0.d(), AbstractC0461r1.t(), null, AbstractC0402a1.b());
        }
        return b(interfaceC0406b1A) ? C0430h1.A(cls, interfaceC0406b1A, AbstractC0441k1.a(), U0.c(), AbstractC0461r1.s(), AbstractC0469u0.a(), AbstractC0402a1.a()) : C0430h1.A(cls, interfaceC0406b1A, AbstractC0441k1.a(), U0.c(), AbstractC0461r1.s(), null, AbstractC0402a1.a());
    }
}
