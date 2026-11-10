package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0419e2 extends B0 implements InterfaceC0422f1 {
    private static final H0 zzb = new Y1();
    private static final C0419e2 zzd;
    private int zze;
    private int zzg;
    private X1 zzj;
    private boolean zzk;
    private boolean zzl;
    private String zzf = "";
    private G0 zzh = B0.o();
    private I0 zzi = B0.p();

    static {
        C0419e2 c0419e2 = new C0419e2();
        zzd = c0419e2;
        B0.v(C0419e2.class, c0419e2);
    }

    private C0419e2() {
    }

    public static C0419e2 C(byte[] bArr, C0460r0 c0460r0) {
        return (C0419e2) B0.n(zzd, bArr, c0460r0);
    }

    static /* synthetic */ void D(C0419e2 c0419e2, u2 u2Var) {
        u2Var.getClass();
        I0 i3 = c0419e2.zzi;
        if (!i3.b()) {
            c0419e2.zzi = B0.q(i3);
        }
        c0419e2.zzi.add(u2Var);
    }

    static /* synthetic */ void E(C0419e2 c0419e2, X1 x3) {
        x3.getClass();
        c0419e2.zzj = x3;
        c0419e2.zze |= 4;
    }

    static /* synthetic */ void F(C0419e2 c0419e2, boolean z3) {
        c0419e2.zze |= 8;
        c0419e2.zzk = z3;
    }

    static /* synthetic */ void G(C0419e2 c0419e2, boolean z3) {
        c0419e2.zze |= 16;
        c0419e2.zzl = false;
    }

    static /* synthetic */ void H(C0419e2 c0419e2, Iterable iterable) {
        G0 g3 = c0419e2.zzh;
        if (!g3.b()) {
            int size = g3.size();
            c0419e2.zzh = g3.e(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c0419e2.zzh.d(((EnumC0407b2) it.next()).a());
        }
    }

    static /* synthetic */ void I(C0419e2 c0419e2, int i3) {
        c0419e2.zzg = i3 - 1;
        c0419e2.zze |= 2;
    }

    public static C0411c2 J() {
        return (C0411c2) zzd.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", C0415d2.f7420a, "zzh", C0403a2.f7409a, "zzi", u2.class, "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new C0419e2();
        }
        Y1 y3 = null;
        if (i4 == 4) {
            return new C0411c2(y3);
        }
        if (i4 != 5) {
            return null;
        }
        return zzd;
    }
}
