package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class k2 extends B0 implements InterfaceC0422f1 {
    private static final k2 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        k2 k2Var = new k2();
        zzb = k2Var;
        B0.v(k2.class, k2Var);
    }

    private k2() {
    }

    static /* synthetic */ void C(k2 k2Var, boolean z3) {
        k2Var.zzd |= 2;
        k2Var.zzf = false;
    }

    public static j2 D() {
        return (j2) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new k2();
        }
        AbstractC0435i2 abstractC0435i2 = null;
        if (i4 == 4) {
            return new j2(abstractC0435i2);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
