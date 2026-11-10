package p061s;

import java.util.ArrayList;
import p058r.a;
import p058r.d;
import p058r.e;
import p058r.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b.a f11660a = new b.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f11661b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f11662c = 0;

    private static boolean a(int i3, e eVar) {
        e.b bVar;
        e.b bVar2;
        e.b bVarA = eVar.A();
        e.b bVarT = eVar.T();
        f fVar = eVar.K() != null ? (f) eVar.K() : null;
        if (fVar != null) {
            fVar.A();
            e.b bVar3 = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.T();
            e.b bVar4 = e.b.FIXED;
        }
        e.b bVar5 = e.b.FIXED;
        boolean z3 = bVarA == bVar5 || eVar.n0() || bVarA == e.b.WRAP_CONTENT || (bVarA == (bVar2 = e.b.MATCH_CONSTRAINT) && eVar.f10718w == 0 && eVar.f10681d0 == 0.0f && eVar.a0(0)) || (bVarA == bVar2 && eVar.f10718w == 1 && eVar.d0(0, eVar.W()));
        boolean z4 = bVarT == bVar5 || eVar.o0() || bVarT == e.b.WRAP_CONTENT || (bVarT == (bVar = e.b.MATCH_CONSTRAINT) && eVar.f10720x == 0 && eVar.f10681d0 == 0.0f && eVar.a0(1)) || (bVarT == bVar && eVar.f10720x == 1 && eVar.d0(1, eVar.x()));
        if (eVar.f10681d0 <= 0.0f || !(z3 || z4)) {
            return z3 && z4;
        }
        return true;
    }

    private static void b(int i3, e eVar, b.InterfaceC0133b interfaceC0133b, boolean z3) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (eVar.g0()) {
            return;
        }
        f11661b++;
        if (!(eVar instanceof f) && eVar.m0()) {
            int i4 = i3 + 1;
            if (a(i4, eVar)) {
                f.S1(i4, eVar, interfaceC0133b, new b.a(), b.a.f11614k);
            }
        }
        d dVarO = eVar.o(d.b.LEFT);
        d dVarO2 = eVar.o(d.b.RIGHT);
        int iE = dVarO.e();
        int iE2 = dVarO2.e();
        if (dVarO.d() != null && dVarO.n()) {
            for (d dVar5 : dVarO.d()) {
                e eVar2 = dVar5.f10620d;
                int i5 = i3 + 1;
                boolean zA = a(i5, eVar2);
                if (eVar2.m0() && zA) {
                    f.S1(i5, eVar2, interfaceC0133b, new b.a(), b.a.f11614k);
                }
                boolean z4 = (dVar5 == eVar2.f10662O && (dVar4 = eVar2.f10664Q.f10622f) != null && dVar4.n()) || (dVar5 == eVar2.f10664Q && (dVar3 = eVar2.f10662O.f10622f) != null && dVar3.n());
                e.b bVarA = eVar2.A();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarA != bVar || zA) {
                    if (!eVar2.m0()) {
                        d dVar6 = eVar2.f10662O;
                        if (dVar5 == dVar6 && eVar2.f10664Q.f10622f == null) {
                            int iF = dVar6.f() + iE;
                            eVar2.F0(iF, eVar2.W() + iF);
                            b(i5, eVar2, interfaceC0133b, z3);
                        } else {
                            d dVar7 = eVar2.f10664Q;
                            if (dVar5 == dVar7 && dVar6.f10622f == null) {
                                int iF2 = iE - dVar7.f();
                                eVar2.F0(iF2 - eVar2.W(), iF2);
                                b(i5, eVar2, interfaceC0133b, z3);
                            } else if (z4 && !eVar2.i0()) {
                                d(i5, interfaceC0133b, eVar2, z3);
                            }
                        }
                    }
                } else if (eVar2.A() == bVar && eVar2.f10638A >= 0 && eVar2.f10724z >= 0 && ((eVar2.V() == 8 || (eVar2.f10718w == 0 && eVar2.v() == 0.0f)) && !eVar2.i0() && !eVar2.l0() && z4 && !eVar2.i0())) {
                    e(i5, eVar, interfaceC0133b, eVar2, z3);
                }
            }
        }
        if (eVar instanceof p058r.h) {
            return;
        }
        if (dVarO2.d() != null && dVarO2.n()) {
            for (d dVar8 : dVarO2.d()) {
                e eVar3 = dVar8.f10620d;
                int i6 = i3 + 1;
                boolean zA2 = a(i6, eVar3);
                if (eVar3.m0() && zA2) {
                    f.S1(i6, eVar3, interfaceC0133b, new b.a(), b.a.f11614k);
                }
                boolean z5 = (dVar8 == eVar3.f10662O && (dVar2 = eVar3.f10664Q.f10622f) != null && dVar2.n()) || (dVar8 == eVar3.f10664Q && (dVar = eVar3.f10662O.f10622f) != null && dVar.n());
                e.b bVarA2 = eVar3.A();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarA2 != bVar2 || zA2) {
                    if (!eVar3.m0()) {
                        d dVar9 = eVar3.f10662O;
                        if (dVar8 == dVar9 && eVar3.f10664Q.f10622f == null) {
                            int iF3 = dVar9.f() + iE2;
                            eVar3.F0(iF3, eVar3.W() + iF3);
                            b(i6, eVar3, interfaceC0133b, z3);
                        } else {
                            d dVar10 = eVar3.f10664Q;
                            if (dVar8 == dVar10 && dVar9.f10622f == null) {
                                int iF4 = iE2 - dVar10.f();
                                eVar3.F0(iF4 - eVar3.W(), iF4);
                                b(i6, eVar3, interfaceC0133b, z3);
                            } else if (z5 && !eVar3.i0()) {
                                d(i6, interfaceC0133b, eVar3, z3);
                            }
                        }
                    }
                } else if (eVar3.A() == bVar2 && eVar3.f10638A >= 0 && eVar3.f10724z >= 0 && (eVar3.V() == 8 || (eVar3.f10718w == 0 && eVar3.v() == 0.0f))) {
                    if (!eVar3.i0() && !eVar3.l0() && z5 && !eVar3.i0()) {
                        e(i6, eVar, interfaceC0133b, eVar3, z3);
                    }
                }
            }
        }
        eVar.q0();
    }

    private static void c(int i3, a aVar, b.InterfaceC0133b interfaceC0133b, int i4, boolean z3) {
        if (aVar.t1()) {
            if (i4 == 0) {
                b(i3 + 1, aVar, interfaceC0133b, z3);
            } else {
                i(i3 + 1, aVar, interfaceC0133b);
            }
        }
    }

    private static void d(int i3, b.InterfaceC0133b interfaceC0133b, e eVar, boolean z3) {
        float fY = eVar.y();
        int iE = eVar.f10662O.f10622f.e();
        int iE2 = eVar.f10664Q.f10622f.e();
        int iF = eVar.f10662O.f() + iE;
        int iF2 = iE2 - eVar.f10664Q.f();
        if (iE == iE2) {
            fY = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iW = eVar.W();
        int i4 = (iE2 - iE) - iW;
        if (iE > iE2) {
            i4 = (iE - iE2) - iW;
        }
        int i5 = ((int) (i4 > 0 ? (fY * i4) + 0.5f : fY * i4)) + iE;
        int i6 = i5 + iW;
        if (iE > iE2) {
            i6 = i5 - iW;
        }
        eVar.F0(i5, i6);
        b(i3 + 1, eVar, interfaceC0133b, z3);
    }

    private static void e(int i3, e eVar, b.InterfaceC0133b interfaceC0133b, e eVar2, boolean z3) {
        float fY = eVar2.y();
        int iE = eVar2.f10662O.f10622f.e() + eVar2.f10662O.f();
        int iE2 = eVar2.f10664Q.f10622f.e() - eVar2.f10664Q.f();
        if (iE2 >= iE) {
            int iW = eVar2.W();
            if (eVar2.V() != 8) {
                int i4 = eVar2.f10718w;
                if (i4 == 2) {
                    iW = (int) (eVar2.y() * 0.5f * (eVar instanceof f ? eVar.W() : eVar.K().W()));
                } else if (i4 == 0) {
                    iW = iE2 - iE;
                }
                iW = Math.max(eVar2.f10724z, iW);
                int i5 = eVar2.f10638A;
                if (i5 > 0) {
                    iW = Math.min(i5, iW);
                }
            }
            int i6 = iE + ((int) ((fY * ((iE2 - iE) - iW)) + 0.5f));
            eVar2.F0(i6, iW + i6);
            b(i3 + 1, eVar2, interfaceC0133b, z3);
        }
    }

    private static void f(int i3, b.InterfaceC0133b interfaceC0133b, e eVar) {
        float fR = eVar.R();
        int iE = eVar.f10663P.f10622f.e();
        int iE2 = eVar.f10665R.f10622f.e();
        int iF = eVar.f10663P.f() + iE;
        int iF2 = iE2 - eVar.f10665R.f();
        if (iE == iE2) {
            fR = 0.5f;
        } else {
            iE = iF;
            iE2 = iF2;
        }
        int iX = eVar.x();
        int i4 = (iE2 - iE) - iX;
        if (iE > iE2) {
            i4 = (iE - iE2) - iX;
        }
        int i5 = (int) (i4 > 0 ? (fR * i4) + 0.5f : fR * i4);
        int i6 = iE + i5;
        int i7 = i6 + iX;
        if (iE > iE2) {
            i6 = iE - i5;
            i7 = i6 - iX;
        }
        eVar.I0(i6, i7);
        i(i3 + 1, eVar, interfaceC0133b);
    }

    private static void g(int i3, e eVar, b.InterfaceC0133b interfaceC0133b, e eVar2) {
        float fR = eVar2.R();
        int iE = eVar2.f10663P.f10622f.e() + eVar2.f10663P.f();
        int iE2 = eVar2.f10665R.f10622f.e() - eVar2.f10665R.f();
        if (iE2 >= iE) {
            int iX = eVar2.x();
            if (eVar2.V() != 8) {
                int i4 = eVar2.f10720x;
                if (i4 == 2) {
                    iX = (int) (fR * 0.5f * (eVar instanceof f ? eVar.x() : eVar.K().x()));
                } else if (i4 == 0) {
                    iX = iE2 - iE;
                }
                iX = Math.max(eVar2.f10642C, iX);
                int i5 = eVar2.f10644D;
                if (i5 > 0) {
                    iX = Math.min(i5, iX);
                }
            }
            int i6 = iE + ((int) ((fR * ((iE2 - iE) - iX)) + 0.5f));
            eVar2.I0(i6, iX + i6);
            i(i3 + 1, eVar2, interfaceC0133b);
        }
    }

    public static void h(f fVar, b.InterfaceC0133b interfaceC0133b) {
        e.b bVarA = fVar.A();
        e.b bVarT = fVar.T();
        f11661b = 0;
        f11662c = 0;
        fVar.v0();
        ArrayList arrayListR1 = fVar.r1();
        int size = arrayListR1.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) arrayListR1.get(i3)).v0();
        }
        boolean zP1 = fVar.P1();
        if (bVarA == e.b.FIXED) {
            fVar.F0(0, fVar.W());
        } else {
            fVar.G0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) arrayListR1.get(i4);
            if (eVar instanceof p058r.h) {
                p058r.h hVar = (p058r.h) eVar;
                if (hVar.s1() == 1) {
                    if (hVar.t1() != -1) {
                        hVar.w1(hVar.t1());
                    } else if (hVar.u1() != -1 && fVar.n0()) {
                        hVar.w1(fVar.W() - hVar.u1());
                    } else if (fVar.n0()) {
                        hVar.w1((int) ((hVar.v1() * fVar.W()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((eVar instanceof a) && ((a) eVar).x1() == 0) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                e eVar2 = (e) arrayListR1.get(i5);
                if (eVar2 instanceof p058r.h) {
                    p058r.h hVar2 = (p058r.h) eVar2;
                    if (hVar2.s1() == 1) {
                        b(0, hVar2, interfaceC0133b, zP1);
                    }
                }
            }
        }
        b(0, fVar, interfaceC0133b, zP1);
        if (z4) {
            for (int i6 = 0; i6 < size; i6++) {
                e eVar3 = (e) arrayListR1.get(i6);
                if (eVar3 instanceof a) {
                    a aVar = (a) eVar3;
                    if (aVar.x1() == 0) {
                        c(0, aVar, interfaceC0133b, 0, zP1);
                    }
                }
            }
        }
        if (bVarT == e.b.FIXED) {
            fVar.I0(0, fVar.x());
        } else {
            fVar.H0(0);
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            e eVar4 = (e) arrayListR1.get(i7);
            if (eVar4 instanceof p058r.h) {
                p058r.h hVar3 = (p058r.h) eVar4;
                if (hVar3.s1() == 0) {
                    if (hVar3.t1() != -1) {
                        hVar3.w1(hVar3.t1());
                    } else if (hVar3.u1() != -1 && fVar.o0()) {
                        hVar3.w1(fVar.x() - hVar3.u1());
                    } else if (fVar.o0()) {
                        hVar3.w1((int) ((hVar3.v1() * fVar.x()) + 0.5f));
                    }
                    z5 = true;
                }
            } else if ((eVar4 instanceof a) && ((a) eVar4).x1() == 1) {
                z6 = true;
            }
        }
        if (z5) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar5 = (e) arrayListR1.get(i8);
                if (eVar5 instanceof p058r.h) {
                    p058r.h hVar4 = (p058r.h) eVar5;
                    if (hVar4.s1() == 0) {
                        i(1, hVar4, interfaceC0133b);
                    }
                }
            }
        }
        i(0, fVar, interfaceC0133b);
        if (z6) {
            for (int i9 = 0; i9 < size; i9++) {
                e eVar6 = (e) arrayListR1.get(i9);
                if (eVar6 instanceof a) {
                    a aVar2 = (a) eVar6;
                    if (aVar2.x1() == 1) {
                        c(0, aVar2, interfaceC0133b, 1, zP1);
                    }
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            e eVar7 = (e) arrayListR1.get(i10);
            if (eVar7.m0() && a(0, eVar7)) {
                f.S1(0, eVar7, interfaceC0133b, f11660a, b.a.f11614k);
                if (!(eVar7 instanceof p058r.h)) {
                    b(0, eVar7, interfaceC0133b, zP1);
                    i(0, eVar7, interfaceC0133b);
                } else if (((p058r.h) eVar7).s1() == 0) {
                    i(0, eVar7, interfaceC0133b);
                } else {
                    b(0, eVar7, interfaceC0133b, zP1);
                }
            }
        }
    }

    private static void i(int i3, e eVar, b.InterfaceC0133b interfaceC0133b) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (eVar.p0()) {
            return;
        }
        f11662c++;
        if (!(eVar instanceof f) && eVar.m0()) {
            int i4 = i3 + 1;
            if (a(i4, eVar)) {
                f.S1(i4, eVar, interfaceC0133b, new b.a(), b.a.f11614k);
            }
        }
        d dVarO = eVar.o(d.b.TOP);
        d dVarO2 = eVar.o(d.b.BOTTOM);
        int iE = dVarO.e();
        int iE2 = dVarO2.e();
        if (dVarO.d() != null && dVarO.n()) {
            for (d dVar5 : dVarO.d()) {
                e eVar2 = dVar5.f10620d;
                int i5 = i3 + 1;
                boolean zA = a(i5, eVar2);
                if (eVar2.m0() && zA) {
                    f.S1(i5, eVar2, interfaceC0133b, new b.a(), b.a.f11614k);
                }
                boolean z3 = (dVar5 == eVar2.f10663P && (dVar4 = eVar2.f10665R.f10622f) != null && dVar4.n()) || (dVar5 == eVar2.f10665R && (dVar3 = eVar2.f10663P.f10622f) != null && dVar3.n());
                e.b bVarT = eVar2.T();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarT != bVar || zA) {
                    if (!eVar2.m0()) {
                        d dVar6 = eVar2.f10663P;
                        if (dVar5 == dVar6 && eVar2.f10665R.f10622f == null) {
                            int iF = dVar6.f() + iE;
                            eVar2.I0(iF, eVar2.x() + iF);
                            i(i5, eVar2, interfaceC0133b);
                        } else {
                            d dVar7 = eVar2.f10665R;
                            if (dVar5 == dVar7 && dVar6.f10622f == null) {
                                int iF2 = iE - dVar7.f();
                                eVar2.I0(iF2 - eVar2.x(), iF2);
                                i(i5, eVar2, interfaceC0133b);
                            } else if (z3 && !eVar2.k0()) {
                                f(i5, interfaceC0133b, eVar2);
                            }
                        }
                    }
                } else if (eVar2.T() == bVar && eVar2.f10644D >= 0 && eVar2.f10642C >= 0 && (eVar2.V() == 8 || (eVar2.f10720x == 0 && eVar2.v() == 0.0f))) {
                    if (!eVar2.k0() && !eVar2.l0() && z3 && !eVar2.k0()) {
                        g(i5, eVar, interfaceC0133b, eVar2);
                    }
                }
            }
        }
        if (eVar instanceof p058r.h) {
            return;
        }
        if (dVarO2.d() != null && dVarO2.n()) {
            for (d dVar8 : dVarO2.d()) {
                e eVar3 = dVar8.f10620d;
                int i6 = i3 + 1;
                boolean zA2 = a(i6, eVar3);
                if (eVar3.m0() && zA2) {
                    f.S1(i6, eVar3, interfaceC0133b, new b.a(), b.a.f11614k);
                }
                boolean z4 = (dVar8 == eVar3.f10663P && (dVar2 = eVar3.f10665R.f10622f) != null && dVar2.n()) || (dVar8 == eVar3.f10665R && (dVar = eVar3.f10663P.f10622f) != null && dVar.n());
                e.b bVarT2 = eVar3.T();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarT2 != bVar2 || zA2) {
                    if (!eVar3.m0()) {
                        d dVar9 = eVar3.f10663P;
                        if (dVar8 == dVar9 && eVar3.f10665R.f10622f == null) {
                            int iF3 = dVar9.f() + iE2;
                            eVar3.I0(iF3, eVar3.x() + iF3);
                            i(i6, eVar3, interfaceC0133b);
                        } else {
                            d dVar10 = eVar3.f10665R;
                            if (dVar8 == dVar10 && dVar9.f10622f == null) {
                                int iF4 = iE2 - dVar10.f();
                                eVar3.I0(iF4 - eVar3.x(), iF4);
                                i(i6, eVar3, interfaceC0133b);
                            } else if (z4 && !eVar3.k0()) {
                                f(i6, interfaceC0133b, eVar3);
                            }
                        }
                    }
                } else if (eVar3.T() == bVar2 && eVar3.f10644D >= 0 && eVar3.f10642C >= 0 && (eVar3.V() == 8 || (eVar3.f10720x == 0 && eVar3.v() == 0.0f))) {
                    if (!eVar3.k0() && !eVar3.l0() && z4 && !eVar3.k0()) {
                        g(i6, eVar, interfaceC0133b, eVar3);
                    }
                }
            }
        }
        d dVarO3 = eVar.o(d.b.BASELINE);
        if (dVarO3.d() != null && dVarO3.n()) {
            int iE3 = dVarO3.e();
            for (d dVar11 : dVarO3.d()) {
                e eVar4 = dVar11.f10620d;
                int i7 = i3 + 1;
                boolean zA3 = a(i7, eVar4);
                if (eVar4.m0() && zA3) {
                    f.S1(i7, eVar4, interfaceC0133b, new b.a(), b.a.f11614k);
                }
                if (eVar4.T() != e.b.MATCH_CONSTRAINT || zA3) {
                    if (!eVar4.m0() && dVar11 == eVar4.f10666S) {
                        eVar4.E0(dVar11.f() + iE3);
                        i(i7, eVar4, interfaceC0133b);
                    }
                }
            }
        }
        eVar.r0();
    }
}
