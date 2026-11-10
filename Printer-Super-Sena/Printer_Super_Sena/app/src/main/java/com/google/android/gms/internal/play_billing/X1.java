package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class X1 extends B0 implements InterfaceC0422f1 {
    private static final X1 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        X1 x3 = new X1();
        zzb = x3;
        B0.v(X1.class, x3);
    }

    private X1() {
    }

    static /* synthetic */ void C(X1 x3, int i3) {
        x3.zzd |= 1;
        x3.zze = i3;
    }

    static /* synthetic */ void D(X1 x3, String str) {
        str.getClass();
        x3.zzd |= 2;
        x3.zzf = str;
    }

    static /* synthetic */ void E(X1 x3, int i3) {
        x3.zzg = i3 - 1;
        x3.zzd |= 4;
    }

    public static T1 F() {
        return (T1) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", V1.f7378a, "zzh"});
        }
        if (i4 == 3) {
            return new X1();
        }
        S1 s3 = null;
        if (i4 == 4) {
            return new T1(s3);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
