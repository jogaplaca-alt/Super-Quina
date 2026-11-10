package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class r2 extends B0 implements InterfaceC0422f1 {
    private static final r2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private C0431h2 zzg;
    private k2 zzh;

    static {
        r2 r2Var = new r2();
        zzb = r2Var;
        B0.v(r2.class, r2Var);
    }

    private r2() {
    }

    static /* synthetic */ void C(r2 r2Var, y2 y2Var) {
        r2Var.zzf = y2Var;
        r2Var.zze = 4;
    }

    static /* synthetic */ void D(r2 r2Var, C0419e2 c0419e2) {
        r2Var.zzf = c0419e2;
        r2Var.zze = 5;
    }

    static /* synthetic */ void E(r2 r2Var, k2 k2Var) {
        k2Var.getClass();
        r2Var.zzh = k2Var;
        r2Var.zzd |= 2;
    }

    static /* synthetic */ void F(r2 r2Var, C0431h2 c0431h2) {
        r2Var.zzg = c0431h2;
        r2Var.zzd |= 1;
    }

    static /* synthetic */ void G(r2 r2Var, N1 n3) {
        r2Var.zzf = n3;
        r2Var.zze = 2;
    }

    static /* synthetic */ void H(r2 r2Var, R1 r3) {
        r2Var.zzf = r3;
        r2Var.zze = 3;
    }

    public static q2 I() {
        return (q2) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", N1.class, R1.class, y2.class, C0419e2.class, "zzh"});
        }
        if (i4 == 3) {
            return new r2();
        }
        p2 p2Var = null;
        if (i4 == 4) {
            return new q2(p2Var);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
