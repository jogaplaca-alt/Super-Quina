package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class N1 extends B0 implements InterfaceC0422f1 {
    private static final N1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private X1 zzh;

    static {
        N1 n3 = new N1();
        zzb = n3;
        B0.v(N1.class, n3);
    }

    private N1() {
    }

    public static N1 C(byte[] bArr, C0460r0 c0460r0) {
        return (N1) B0.n(zzb, bArr, c0460r0);
    }

    static /* synthetic */ void D(N1 n3, X1 x3) {
        x3.getClass();
        n3.zzh = x3;
        n3.zzd |= 2;
    }

    static /* synthetic */ void E(N1 n3, int i3) {
        n3.zzg = i3 - 1;
        n3.zzd |= 1;
    }

    public static M1 F() {
        return (M1) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", O1.f7368a, "zzh", o2.class});
        }
        if (i4 == 3) {
            return new N1();
        }
        L1 l3 = null;
        if (i4 == 4) {
            return new M1(l3);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
