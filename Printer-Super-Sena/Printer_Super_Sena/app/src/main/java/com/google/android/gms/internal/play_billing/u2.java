package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class u2 extends B0 implements InterfaceC0422f1 {
    private static final u2 zzb;
    private int zzd;
    private int zzf;
    private I0 zze = B0.p();
    private String zzg = "";

    static {
        u2 u2Var = new u2();
        zzb = u2Var;
        B0.v(u2.class, u2Var);
    }

    private u2() {
    }

    static /* synthetic */ void C(u2 u2Var, Iterable iterable) {
        I0 i3 = u2Var.zze;
        if (!i3.b()) {
            u2Var.zze = B0.q(i3);
        }
        P.g(iterable, u2Var.zze);
    }

    static /* synthetic */ void D(u2 u2Var, int i3) {
        u2Var.zzd |= 1;
        u2Var.zzf = i3;
    }

    static /* synthetic */ void E(u2 u2Var, String str) {
        str.getClass();
        u2Var.zzd |= 2;
        u2Var.zzg = str;
    }

    public static t2 F() {
        return (t2) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new u2();
        }
        s2 s2Var = null;
        if (i4 == 4) {
            return new t2(s2Var);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
