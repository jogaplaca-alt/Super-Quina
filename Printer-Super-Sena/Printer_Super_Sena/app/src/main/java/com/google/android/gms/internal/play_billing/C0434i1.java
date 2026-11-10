package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0434i1 implements InterfaceC0456p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0418e1 f7448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC0470u1 f7449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AbstractC0463s0 f7451d;

    private C0434i1(AbstractC0470u1 abstractC0470u1, AbstractC0463s0 abstractC0463s0, InterfaceC0418e1 interfaceC0418e1) {
        this.f7449b = abstractC0470u1;
        this.f7450c = abstractC0463s0.c(interfaceC0418e1);
        this.f7451d = abstractC0463s0;
        this.f7448a = interfaceC0418e1;
    }

    static C0434i1 j(AbstractC0470u1 abstractC0470u1, AbstractC0463s0 abstractC0463s0, InterfaceC0418e1 interfaceC0418e1) {
        return new C0434i1(abstractC0470u1, abstractC0463s0, interfaceC0418e1);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void a(Object obj) {
        this.f7449b.g(obj);
        this.f7451d.b(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void b(Object obj, K1 k3) {
        this.f7451d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final Object c() {
        InterfaceC0418e1 interfaceC0418e1 = this.f7448a;
        return interfaceC0418e1 instanceof B0 ? ((B0) interfaceC0418e1).m() : interfaceC0418e1.d().c();
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final int d(Object obj) {
        AbstractC0470u1 abstractC0470u1 = this.f7449b;
        int iB = abstractC0470u1.b(abstractC0470u1.d(obj));
        if (!this.f7450c) {
            return iB;
        }
        this.f7451d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void e(Object obj, Object obj2) {
        AbstractC0461r1.v(this.f7449b, obj, obj2);
        if (this.f7450c) {
            this.f7451d.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void f(Object obj, byte[] bArr, int i3, int i4, T t3) {
        B0 b3 = (B0) obj;
        if (b3.zzc == C0473v1.c()) {
            b3.zzc = C0473v1.f();
        }
        androidx.appcompat.app.H.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final boolean g(Object obj, Object obj2) {
        AbstractC0470u1 abstractC0470u1 = this.f7449b;
        if (!abstractC0470u1.d(obj).equals(abstractC0470u1.d(obj2))) {
            return false;
        }
        if (!this.f7450c) {
            return true;
        }
        this.f7451d.a(obj);
        this.f7451d.a(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final boolean h(Object obj) {
        this.f7451d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final int i(Object obj) {
        int iHashCode = this.f7449b.d(obj).hashCode();
        if (!this.f7450c) {
            return iHashCode;
        }
        this.f7451d.a(obj);
        throw null;
    }
}
