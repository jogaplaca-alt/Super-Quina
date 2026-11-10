package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class o2 extends B0 implements InterfaceC0422f1 {
    private static final o2 zzb;
    private int zzd;
    private int zze;

    static {
        o2 o2Var = new o2();
        zzb = o2Var;
        B0.v(o2.class, o2Var);
    }

    private o2() {
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", n2.f7481a});
        }
        if (i4 == 3) {
            return new o2();
        }
        l2 l2Var = null;
        if (i4 == 4) {
            return new m2(l2Var);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
