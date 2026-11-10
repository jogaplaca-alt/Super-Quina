package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class R1 extends B0 implements InterfaceC0422f1 {
    private static final R1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        R1 r3 = new R1();
        zzb = r3;
        B0.v(R1.class, r3);
    }

    private R1() {
    }

    static /* synthetic */ void C(R1 r3, int i3) {
        r3.zzg = i3 - 1;
        r3.zzd |= 1;
    }

    public static Q1 D() {
        return (Q1) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", O1.f7368a, o2.class});
        }
        if (i4 == 3) {
            return new R1();
        }
        P1 p3 = null;
        if (i4 == 4) {
            return new Q1(p3);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
