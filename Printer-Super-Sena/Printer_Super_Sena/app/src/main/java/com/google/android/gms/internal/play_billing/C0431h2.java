package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0431h2 extends B0 implements InterfaceC0422f1 {
    private static final C0431h2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C0431h2 c0431h2 = new C0431h2();
        zzb = c0431h2;
        B0.v(C0431h2.class, c0431h2);
    }

    private C0431h2() {
    }

    static /* synthetic */ void C(C0431h2 c0431h2, String str) {
        str.getClass();
        c0431h2.zzd |= 1;
        c0431h2.zze = str;
    }

    static /* synthetic */ void D(C0431h2 c0431h2, String str) {
        str.getClass();
        c0431h2.zzd |= 2;
        c0431h2.zzf = str;
    }

    public static C0427g2 E() {
        return (C0427g2) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.B0
    protected final Object z(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return B0.s(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new C0431h2();
        }
        AbstractC0423f2 abstractC0423f2 = null;
        if (i4 == 4) {
            return new C0427g2(abstractC0423f2);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }
}
