package com.google.android.gms.common.api.internal;

import C0.C0179a;
import E0.C0184b;
import F0.AbstractC0209c;
import F0.C0211e;
import F0.C0218l;
import F0.C0221o;
import F0.C0222p;
import android.os.SystemClock;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class p implements R0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0184b f7289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f7291e;

    p(b bVar, int i3, C0184b c0184b, long j3, long j4, String str, String str2) {
        this.f7287a = bVar;
        this.f7288b = i3;
        this.f7289c = c0184b;
        this.f7290d = j3;
        this.f7291e = j4;
    }

    static p b(b bVar, int i3, C0184b c0184b) {
        boolean zF;
        if (!bVar.d()) {
            return null;
        }
        C0222p c0222pA = C0221o.b().a();
        if (c0222pA == null) {
            zF = true;
        } else {
            if (!c0222pA.e()) {
                return null;
            }
            zF = c0222pA.f();
            l lVarS = bVar.s(c0184b);
            if (lVarS != null) {
                if (!(lVarS.v() instanceof AbstractC0209c)) {
                    return null;
                }
                AbstractC0209c abstractC0209c = (AbstractC0209c) lVarS.v();
                if (abstractC0209c.G() && !abstractC0209c.a()) {
                    C0211e c0211eC = c(lVarS, abstractC0209c, i3);
                    if (c0211eC == null) {
                        return null;
                    }
                    lVarS.G();
                    zF = c0211eC.g();
                }
            }
        }
        return new p(bVar, i3, c0184b, zF ? System.currentTimeMillis() : 0L, zF ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static C0211e c(l lVar, AbstractC0209c abstractC0209c, int i3) {
        int[] iArrD;
        int[] iArrE;
        C0211e c0211eE = abstractC0209c.E();
        if (c0211eE == null || !c0211eE.f() || ((iArrD = c0211eE.d()) != null ? !J0.a.a(iArrD, i3) : !((iArrE = c0211eE.e()) == null || !J0.a.a(iArrE, i3))) || lVar.t() >= c0211eE.c()) {
            return null;
        }
        return c0211eE;
    }

    @Override // R0.b
    public final void a(R0.d dVar) {
        l lVarS;
        int iG;
        int i3;
        int i4;
        int i5;
        int iC;
        long j3;
        long j4;
        int iElapsedRealtime;
        if (this.f7287a.d()) {
            C0222p c0222pA = C0221o.b().a();
            if ((c0222pA == null || c0222pA.e()) && (lVarS = this.f7287a.s(this.f7289c)) != null && (lVarS.v() instanceof AbstractC0209c)) {
                AbstractC0209c abstractC0209c = (AbstractC0209c) lVarS.v();
                boolean zF = this.f7290d > 0;
                int iW = abstractC0209c.w();
                if (c0222pA != null) {
                    zF &= c0222pA.f();
                    int iC2 = c0222pA.c();
                    int iD = c0222pA.d();
                    iG = c0222pA.g();
                    if (abstractC0209c.G() && !abstractC0209c.a()) {
                        C0211e c0211eC = c(lVarS, abstractC0209c, this.f7288b);
                        if (c0211eC == null) {
                            return;
                        }
                        boolean z3 = c0211eC.g() && this.f7290d > 0;
                        iD = c0211eC.c();
                        zF = z3;
                    }
                    i3 = iC2;
                    i4 = iD;
                } else {
                    iG = 0;
                    i3 = 5000;
                    i4 = 100;
                }
                b bVar = this.f7287a;
                if (dVar.g()) {
                    i5 = 0;
                    iC = 0;
                } else {
                    if (dVar.e()) {
                        i5 = 100;
                    } else {
                        Exception excC = dVar.c();
                        if (excC instanceof D0.b) {
                            Status statusA = ((D0.b) excC).a();
                            int iD2 = statusA.d();
                            C0179a c0179aC = statusA.c();
                            if (c0179aC == null) {
                                i5 = iD2;
                            } else {
                                iC = c0179aC.c();
                                i5 = iD2;
                            }
                        } else {
                            i5 = 101;
                        }
                    }
                    iC = -1;
                }
                if (zF) {
                    long j5 = this.f7290d;
                    long j6 = this.f7291e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j6);
                    j3 = j5;
                    j4 = jCurrentTimeMillis;
                } else {
                    j3 = 0;
                    j4 = 0;
                    iElapsedRealtime = -1;
                }
                bVar.A(new C0218l(this.f7288b, i5, iC, j3, j4, null, null, iW, iElapsedRealtime), iG, i3, i4);
            }
        }
    }
}
