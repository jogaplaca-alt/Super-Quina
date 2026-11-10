package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0476w1 extends AbstractC0470u1 {
    C0476w1() {
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* synthetic */ int a(Object obj) {
        return ((C0473v1) obj).a();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* synthetic */ int b(Object obj) {
        return ((C0473v1) obj).b();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* bridge */ /* synthetic */ Object c(Object obj) {
        B0 b3 = (B0) obj;
        C0473v1 c0473v1 = b3.zzc;
        if (c0473v1 != C0473v1.c()) {
            return c0473v1;
        }
        C0473v1 c0473v1F = C0473v1.f();
        b3.zzc = c0473v1F;
        return c0473v1F;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* synthetic */ Object d(Object obj) {
        return ((B0) obj).zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (C0473v1.c().equals(obj2)) {
            return obj;
        }
        if (C0473v1.c().equals(obj)) {
            return C0473v1.e((C0473v1) obj, (C0473v1) obj2);
        }
        ((C0473v1) obj).d((C0473v1) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* bridge */ /* synthetic */ void f(Object obj, int i3, long j3) {
        ((C0473v1) obj).j(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final void g(Object obj) {
        ((B0) obj).zzc.h();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* synthetic */ void h(Object obj, Object obj2) {
        ((B0) obj).zzc = (C0473v1) obj2;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0470u1
    final /* synthetic */ void i(Object obj, K1 k3) {
        ((C0473v1) obj).k(k3);
    }
}
