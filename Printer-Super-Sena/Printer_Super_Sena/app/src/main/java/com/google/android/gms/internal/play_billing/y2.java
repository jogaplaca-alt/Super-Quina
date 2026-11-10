package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class y2 extends B0 implements InterfaceC0422f1 {
    private static final y2 zzb;
    private int zzd;
    private int zze;

    static {
        y2 y2Var = new y2();
        zzb = y2Var;
        B0.v(y2.class, y2Var);
    }

    private y2() {
    }

    public static y2 B() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", x2.f7580a});
        }
        if (i4 == 3) {
            return new y2();
        }
        v2 v2Var = null;
        if (i4 == 4) {
            return new w2(v2Var);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
