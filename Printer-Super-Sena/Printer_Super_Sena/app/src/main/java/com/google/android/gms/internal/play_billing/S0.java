package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class S0 extends U0 {
    /* synthetic */ S0(R0 r3) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.U0
    final void a(Object obj, long j3) {
        ((I0) E1.k(obj, j3)).a();
    }

    @Override // com.google.android.gms.internal.play_billing.U0
    final void b(Object obj, Object obj2, long j3) {
        I0 i0E = (I0) E1.k(obj, j3);
        I0 i3 = (I0) E1.k(obj2, j3);
        int size = i0E.size();
        int size2 = i3.size();
        if (size > 0 && size2 > 0) {
            if (!i0E.b()) {
                i0E = i0E.e(size2 + size);
            }
            i0E.addAll(i3);
        }
        if (size > 0) {
            i3 = i0E;
        }
        E1.x(obj, j3, i3);
    }
}
