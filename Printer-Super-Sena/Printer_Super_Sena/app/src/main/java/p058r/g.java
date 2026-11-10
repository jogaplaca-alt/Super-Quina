package p058r;

import java.util.ArrayList;
import p049o.d;

/* JADX INFO: loaded from: classes.dex */
public class g extends l {

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private e[] f10786x1;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f10763a1 = -1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private int f10764b1 = -1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private int f10765c1 = -1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f10766d1 = -1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private int f10767e1 = -1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private int f10768f1 = -1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private float f10769g1 = 0.5f;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private float f10770h1 = 0.5f;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private float f10771i1 = 0.5f;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private float f10772j1 = 0.5f;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private float f10773k1 = 0.5f;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private float f10774l1 = 0.5f;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private int f10775m1 = 0;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private int f10776n1 = 0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private int f10777o1 = 2;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private int f10778p1 = 2;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private int f10779q1 = 0;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private int f10780r1 = -1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private int f10781s1 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private ArrayList f10782t1 = new ArrayList();

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private e[] f10783u1 = null;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private e[] f10784v1 = null;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private int[] f10785w1 = null;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private int f10787y1 = 0;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10788a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f10791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d f10792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f10793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private d f10794g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f10795h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f10796i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f10797j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f10798k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f10804q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f10789b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10790c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f10799l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f10800m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f10801n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f10802o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f10803p = 0;

        public a(int i3, d dVar, d dVar2, d dVar3, d dVar4, int i4) {
            this.f10795h = 0;
            this.f10796i = 0;
            this.f10797j = 0;
            this.f10798k = 0;
            this.f10804q = 0;
            this.f10788a = i3;
            this.f10791d = dVar;
            this.f10792e = dVar2;
            this.f10793f = dVar3;
            this.f10794g = dVar4;
            this.f10795h = g.this.z1();
            this.f10796i = g.this.B1();
            this.f10797j = g.this.A1();
            this.f10798k = g.this.y1();
            this.f10804q = i4;
        }

        private void h() {
            this.f10799l = 0;
            this.f10800m = 0;
            this.f10789b = null;
            this.f10790c = 0;
            int i3 = this.f10802o;
            for (int i4 = 0; i4 < i3 && this.f10801n + i4 < g.this.f10787y1; i4++) {
                e eVar = g.this.f10786x1[this.f10801n + i4];
                if (this.f10788a == 0) {
                    int iW = eVar.W();
                    int i5 = g.this.f10775m1;
                    if (eVar.V() == 8) {
                        i5 = 0;
                    }
                    this.f10799l += iW + i5;
                    int iK2 = g.this.k2(eVar, this.f10804q);
                    if (this.f10789b == null || this.f10790c < iK2) {
                        this.f10789b = eVar;
                        this.f10790c = iK2;
                        this.f10800m = iK2;
                    }
                } else {
                    int iL2 = g.this.l2(eVar, this.f10804q);
                    int iK3 = g.this.k2(eVar, this.f10804q);
                    int i6 = g.this.f10776n1;
                    if (eVar.V() == 8) {
                        i6 = 0;
                    }
                    this.f10800m += iK3 + i6;
                    if (this.f10789b == null || this.f10790c < iL2) {
                        this.f10789b = eVar;
                        this.f10790c = iL2;
                        this.f10799l = iL2;
                    }
                }
            }
        }

        public void b(e eVar) {
            if (this.f10788a == 0) {
                int iL2 = g.this.l2(eVar, this.f10804q);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    this.f10803p++;
                    iL2 = 0;
                }
                this.f10799l += iL2 + (eVar.V() != 8 ? g.this.f10775m1 : 0);
                int iK2 = g.this.k2(eVar, this.f10804q);
                if (this.f10789b == null || this.f10790c < iK2) {
                    this.f10789b = eVar;
                    this.f10790c = iK2;
                    this.f10800m = iK2;
                }
            } else {
                int iL3 = g.this.l2(eVar, this.f10804q);
                int iK3 = g.this.k2(eVar, this.f10804q);
                if (eVar.T() == e.b.MATCH_CONSTRAINT) {
                    this.f10803p++;
                    iK3 = 0;
                }
                this.f10800m += iK3 + (eVar.V() != 8 ? g.this.f10776n1 : 0);
                if (this.f10789b == null || this.f10790c < iL3) {
                    this.f10789b = eVar;
                    this.f10790c = iL3;
                    this.f10799l = iL3;
                }
            }
            this.f10802o++;
        }

        public void c() {
            this.f10790c = 0;
            this.f10789b = null;
            this.f10799l = 0;
            this.f10800m = 0;
            this.f10801n = 0;
            this.f10802o = 0;
            this.f10803p = 0;
        }

        public void d(boolean z3, int i3, boolean z4) {
            e eVar;
            float f3;
            float f4;
            int i4 = this.f10802o;
            for (int i5 = 0; i5 < i4 && this.f10801n + i5 < g.this.f10787y1; i5++) {
                e eVar2 = g.this.f10786x1[this.f10801n + i5];
                if (eVar2 != null) {
                    eVar2.u0();
                }
            }
            if (i4 == 0 || this.f10789b == null) {
                return;
            }
            boolean z5 = z4 && i3 == 0;
            int i6 = -1;
            int i7 = -1;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = z3 ? (i4 - 1) - i8 : i8;
                if (this.f10801n + i9 >= g.this.f10787y1) {
                    break;
                }
                e eVar3 = g.this.f10786x1[this.f10801n + i9];
                if (eVar3 != null && eVar3.V() == 0) {
                    if (i6 == -1) {
                        i6 = i8;
                    }
                    i7 = i8;
                }
            }
            e eVar4 = null;
            if (this.f10788a != 0) {
                e eVar5 = this.f10789b;
                eVar5.N0(g.this.f10763a1);
                int i10 = this.f10795h;
                if (i3 > 0) {
                    i10 += g.this.f10775m1;
                }
                if (z3) {
                    eVar5.f10664Q.a(this.f10793f, i10);
                    if (z4) {
                        eVar5.f10662O.a(this.f10791d, this.f10797j);
                    }
                    if (i3 > 0) {
                        this.f10793f.f10620d.f10662O.a(eVar5.f10664Q, 0);
                    }
                } else {
                    eVar5.f10662O.a(this.f10791d, i10);
                    if (z4) {
                        eVar5.f10664Q.a(this.f10793f, this.f10797j);
                    }
                    if (i3 > 0) {
                        this.f10791d.f10620d.f10664Q.a(eVar5.f10662O, 0);
                    }
                }
                for (int i11 = 0; i11 < i4 && this.f10801n + i11 < g.this.f10787y1; i11++) {
                    e eVar6 = g.this.f10786x1[this.f10801n + i11];
                    if (eVar6 != null) {
                        if (i11 == 0) {
                            eVar6.k(eVar6.f10663P, this.f10792e, this.f10796i);
                            int i12 = g.this.f10764b1;
                            float f5 = g.this.f10770h1;
                            if (this.f10801n == 0 && g.this.f10766d1 != -1) {
                                i12 = g.this.f10766d1;
                                f5 = g.this.f10772j1;
                            } else if (z4 && g.this.f10768f1 != -1) {
                                i12 = g.this.f10768f1;
                                f5 = g.this.f10774l1;
                            }
                            eVar6.e1(i12);
                            eVar6.d1(f5);
                        }
                        if (i11 == i4 - 1) {
                            eVar6.k(eVar6.f10665R, this.f10794g, this.f10798k);
                        }
                        if (eVar4 != null) {
                            eVar6.f10663P.a(eVar4.f10665R, g.this.f10776n1);
                            if (i11 == i6) {
                                eVar6.f10663P.u(this.f10796i);
                            }
                            eVar4.f10665R.a(eVar6.f10663P, 0);
                            if (i11 == i7 + 1) {
                                eVar4.f10665R.u(this.f10798k);
                            }
                        }
                        if (eVar6 != eVar5) {
                            if (z3) {
                                int i13 = g.this.f10777o1;
                                if (i13 == 0) {
                                    eVar6.f10664Q.a(eVar5.f10664Q, 0);
                                } else if (i13 == 1) {
                                    eVar6.f10662O.a(eVar5.f10662O, 0);
                                } else if (i13 == 2) {
                                    eVar6.f10662O.a(eVar5.f10662O, 0);
                                    eVar6.f10664Q.a(eVar5.f10664Q, 0);
                                }
                            } else {
                                int i14 = g.this.f10777o1;
                                if (i14 == 0) {
                                    eVar6.f10662O.a(eVar5.f10662O, 0);
                                } else if (i14 == 1) {
                                    eVar6.f10664Q.a(eVar5.f10664Q, 0);
                                } else if (i14 == 2) {
                                    if (z5) {
                                        eVar6.f10662O.a(this.f10791d, this.f10795h);
                                        eVar6.f10664Q.a(this.f10793f, this.f10797j);
                                    } else {
                                        eVar6.f10662O.a(eVar5.f10662O, 0);
                                        eVar6.f10664Q.a(eVar5.f10664Q, 0);
                                    }
                                }
                            }
                        }
                        eVar4 = eVar6;
                    }
                }
                return;
            }
            e eVar7 = this.f10789b;
            eVar7.e1(g.this.f10764b1);
            int i15 = this.f10796i;
            if (i3 > 0) {
                i15 += g.this.f10776n1;
            }
            eVar7.f10663P.a(this.f10792e, i15);
            if (z4) {
                eVar7.f10665R.a(this.f10794g, this.f10798k);
            }
            if (i3 > 0) {
                this.f10792e.f10620d.f10665R.a(eVar7.f10663P, 0);
            }
            if (g.this.f10778p1 != 3 || eVar7.Z()) {
                eVar = eVar7;
                break;
            }
            int i16 = 0;
            while (true) {
                if (i16 < i4) {
                    int i17 = z3 ? (i4 - 1) - i16 : i16;
                    if (this.f10801n + i17 < g.this.f10787y1) {
                        eVar = g.this.f10786x1[this.f10801n + i17];
                        if (eVar.Z()) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                }
                eVar = eVar7;
                break;
            }
            int i18 = 0;
            while (i18 < i4) {
                int i19 = z3 ? (i4 - 1) - i18 : i18;
                if (this.f10801n + i19 >= g.this.f10787y1) {
                    return;
                }
                e eVar8 = g.this.f10786x1[this.f10801n + i19];
                if (eVar8 == null) {
                    eVar8 = eVar4;
                } else {
                    if (i18 == 0) {
                        eVar8.k(eVar8.f10662O, this.f10791d, this.f10795h);
                    }
                    if (i19 == 0) {
                        int i20 = g.this.f10763a1;
                        float f6 = g.this.f10769g1;
                        if (z3) {
                            f6 = 1.0f - f6;
                        }
                        if (this.f10801n == 0 && g.this.f10765c1 != -1) {
                            i20 = g.this.f10765c1;
                            if (z3) {
                                f4 = g.this.f10771i1;
                                f3 = 1.0f - f4;
                            } else {
                                f3 = g.this.f10771i1;
                            }
                            f6 = f3;
                        } else if (z4 && g.this.f10767e1 != -1) {
                            i20 = g.this.f10767e1;
                            if (z3) {
                                f4 = g.this.f10773k1;
                                f3 = 1.0f - f4;
                            } else {
                                f3 = g.this.f10773k1;
                            }
                            f6 = f3;
                        }
                        eVar8.N0(i20);
                        eVar8.M0(f6);
                    }
                    if (i18 == i4 - 1) {
                        eVar8.k(eVar8.f10664Q, this.f10793f, this.f10797j);
                    }
                    if (eVar4 != null) {
                        eVar8.f10662O.a(eVar4.f10664Q, g.this.f10775m1);
                        if (i18 == i6) {
                            eVar8.f10662O.u(this.f10795h);
                        }
                        eVar4.f10664Q.a(eVar8.f10662O, 0);
                        if (i18 == i7 + 1) {
                            eVar4.f10664Q.u(this.f10797j);
                        }
                    }
                    if (eVar8 != eVar7) {
                        if (g.this.f10778p1 == 3 && eVar.Z() && eVar8 != eVar && eVar8.Z()) {
                            eVar8.f10666S.a(eVar.f10666S, 0);
                        } else {
                            int i21 = g.this.f10778p1;
                            if (i21 == 0) {
                                eVar8.f10663P.a(eVar7.f10663P, 0);
                            } else if (i21 == 1) {
                                eVar8.f10665R.a(eVar7.f10665R, 0);
                            } else if (z5) {
                                eVar8.f10663P.a(this.f10792e, this.f10796i);
                                eVar8.f10665R.a(this.f10794g, this.f10798k);
                            } else {
                                eVar8.f10663P.a(eVar7.f10663P, 0);
                                eVar8.f10665R.a(eVar7.f10665R, 0);
                            }
                        }
                    }
                    i18++;
                    eVar4 = eVar8;
                }
                i18++;
                eVar4 = eVar8;
            }
        }

        public int e() {
            return this.f10788a == 1 ? this.f10800m - g.this.f10776n1 : this.f10800m;
        }

        public int f() {
            return this.f10788a == 0 ? this.f10799l - g.this.f10775m1 : this.f10799l;
        }

        public void g(int i3) {
            int i4 = this.f10803p;
            if (i4 == 0) {
                return;
            }
            int i5 = this.f10802o;
            int i6 = i3 / i4;
            for (int i7 = 0; i7 < i5 && this.f10801n + i7 < g.this.f10787y1; i7++) {
                e eVar = g.this.f10786x1[this.f10801n + i7];
                if (this.f10788a == 0) {
                    if (eVar != null && eVar.A() == e.b.MATCH_CONSTRAINT && eVar.f10718w == 0) {
                        g.this.D1(eVar, e.b.FIXED, i6, eVar.T(), eVar.x());
                    }
                } else if (eVar != null && eVar.T() == e.b.MATCH_CONSTRAINT && eVar.f10720x == 0) {
                    g.this.D1(eVar, eVar.A(), eVar.W(), e.b.FIXED, i6);
                }
            }
            h();
        }

        public void i(int i3) {
            this.f10801n = i3;
        }

        public void j(int i3, d dVar, d dVar2, d dVar3, d dVar4, int i4, int i5, int i6, int i7, int i8) {
            this.f10788a = i3;
            this.f10791d = dVar;
            this.f10792e = dVar2;
            this.f10793f = dVar3;
            this.f10794g = dVar4;
            this.f10795h = i4;
            this.f10796i = i5;
            this.f10797j = i6;
            this.f10798k = i7;
            this.f10804q = i8;
        }
    }

    private void j2(boolean z3) {
        e eVar;
        float f3;
        int i3;
        if (this.f10785w1 == null || this.f10784v1 == null || this.f10783u1 == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f10787y1; i4++) {
            this.f10786x1[i4].u0();
        }
        int[] iArr = this.f10785w1;
        int i5 = iArr[0];
        int i6 = iArr[1];
        float f4 = this.f10769g1;
        e eVar2 = null;
        int i7 = 0;
        while (i7 < i5) {
            if (z3) {
                i3 = (i5 - i7) - 1;
                f3 = 1.0f - this.f10769g1;
            } else {
                f3 = f4;
                i3 = i7;
            }
            e eVar3 = this.f10784v1[i3];
            if (eVar3 != null && eVar3.V() != 8) {
                if (i7 == 0) {
                    eVar3.k(eVar3.f10662O, this.f10662O, z1());
                    eVar3.N0(this.f10763a1);
                    eVar3.M0(f3);
                }
                if (i7 == i5 - 1) {
                    eVar3.k(eVar3.f10664Q, this.f10664Q, A1());
                }
                if (i7 > 0 && eVar2 != null) {
                    eVar3.k(eVar3.f10662O, eVar2.f10664Q, this.f10775m1);
                    eVar2.k(eVar2.f10664Q, eVar3.f10662O, 0);
                }
                eVar2 = eVar3;
            }
            i7++;
            f4 = f3;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            e eVar4 = this.f10783u1[i8];
            if (eVar4 != null && eVar4.V() != 8) {
                if (i8 == 0) {
                    eVar4.k(eVar4.f10663P, this.f10663P, B1());
                    eVar4.e1(this.f10764b1);
                    eVar4.d1(this.f10770h1);
                }
                if (i8 == i6 - 1) {
                    eVar4.k(eVar4.f10665R, this.f10665R, y1());
                }
                if (i8 > 0 && eVar2 != null) {
                    eVar4.k(eVar4.f10663P, eVar2.f10665R, this.f10776n1);
                    eVar2.k(eVar2.f10665R, eVar4.f10663P, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = (i10 * i5) + i9;
                if (this.f10781s1 == 1) {
                    i11 = (i9 * i6) + i10;
                }
                e[] eVarArr = this.f10786x1;
                if (i11 < eVarArr.length && (eVar = eVarArr[i11]) != null && eVar.V() != 8) {
                    e eVar5 = this.f10784v1[i9];
                    e eVar6 = this.f10783u1[i10];
                    if (eVar != eVar5) {
                        eVar.k(eVar.f10662O, eVar5.f10662O, 0);
                        eVar.k(eVar.f10664Q, eVar5.f10664Q, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.k(eVar.f10663P, eVar6.f10663P, 0);
                        eVar.k(eVar.f10665R, eVar6.f10665R, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k2(e eVar, int i3) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.T() == e.b.MATCH_CONSTRAINT) {
            int i4 = eVar.f10720x;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (eVar.f10646E * i3);
                if (i5 != eVar.x()) {
                    eVar.Y0(true);
                    D1(eVar, eVar.A(), eVar.W(), e.b.FIXED, i5);
                }
                return i5;
            }
            if (i4 == 1) {
                return eVar.x();
            }
            if (i4 == 3) {
                return (int) ((eVar.W() * eVar.f10681d0) + 0.5f);
            }
        }
        return eVar.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l2(e eVar, int i3) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.A() == e.b.MATCH_CONSTRAINT) {
            int i4 = eVar.f10718w;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (eVar.f10640B * i3);
                if (i5 != eVar.W()) {
                    eVar.Y0(true);
                    D1(eVar, e.b.FIXED, i5, eVar.T(), eVar.x());
                }
                return i5;
            }
            if (i4 == 1) {
                return eVar.W();
            }
            if (i4 == 3) {
                return (int) ((eVar.x() * eVar.f10681d0) + 0.5f);
            }
        }
        return eVar.W();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x010f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:119:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:122:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060  */
    /* JADX WARN: Code duplicated, block: B:47:0x006a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0078  */
    /* JADX WARN: Code duplicated, block: B:54:0x0080  */
    /* JADX WARN: Code duplicated, block: B:57:0x0088  */
    /* JADX WARN: Code duplicated, block: B:61:0x0090  */
    /* JADX WARN: Code duplicated, block: B:64:0x0097  */
    /* JADX WARN: Code duplicated, block: B:66:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x009f  */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x005e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void m2(p058r.e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p058r.g.m2(r.e[], int, int, int, int[]):void");
    }

    private void n2(e[] eVarArr, int i3, int i4, int i5, int[] iArr) {
        int i6;
        int i7;
        int i8;
        d dVar;
        int iA1;
        d dVar2;
        int iY1;
        int i9;
        if (i3 == 0) {
            return;
        }
        this.f10782t1.clear();
        a aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
        this.f10782t1.add(aVar);
        if (i4 == 0) {
            i6 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i11 < i3) {
                e eVar = eVarArr[i11];
                int iL2 = l2(eVar, i5);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i12 = i6;
                boolean z3 = (i10 == i5 || (this.f10775m1 + i10) + iL2 > i5) && aVar.f10789b != null;
                if (!z3 && i11 > 0 && (i9 = this.f10780r1) > 0 && i11 % i9 == 0) {
                    z3 = true;
                }
                if (z3) {
                    aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
                    aVar.i(i11);
                    this.f10782t1.add(aVar);
                } else {
                    if (i11 > 0) {
                        i10 += this.f10775m1 + iL2;
                    }
                    aVar.b(eVar);
                    i11++;
                    i6 = i12;
                }
                i10 = iL2;
                aVar.b(eVar);
                i11++;
                i6 = i12;
            }
        } else {
            i6 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i3) {
                e eVar2 = eVarArr[i14];
                int iK2 = k2(eVar2, i5);
                if (eVar2.T() == e.b.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i15 = i6;
                boolean z4 = (i13 == i5 || (this.f10776n1 + i13) + iK2 > i5) && aVar.f10789b != null;
                if (!z4 && i14 > 0 && (i7 = this.f10780r1) > 0 && i14 % i7 == 0) {
                    z4 = true;
                }
                if (z4) {
                    aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
                    aVar.i(i14);
                    this.f10782t1.add(aVar);
                } else {
                    if (i14 > 0) {
                        i13 += this.f10776n1 + iK2;
                    }
                    aVar.b(eVar2);
                    i14++;
                    i6 = i15;
                }
                i13 = iK2;
                aVar.b(eVar2);
                i14++;
                i6 = i15;
            }
        }
        int size = this.f10782t1.size();
        d dVar3 = this.f10662O;
        d dVar4 = this.f10663P;
        d dVar5 = this.f10664Q;
        d dVar6 = this.f10665R;
        int iZ1 = z1();
        int iB1 = B1();
        int iA2 = A1();
        int iY2 = y1();
        e.b bVarA = A();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z5 = bVarA == bVar || T() == bVar;
        if (i6 > 0 && z5) {
            for (int i16 = 0; i16 < size; i16++) {
                a aVar2 = (a) this.f10782t1.get(i16);
                if (i4 == 0) {
                    aVar2.g(i5 - aVar2.f());
                } else {
                    aVar2.g(i5 - aVar2.e());
                }
            }
        }
        int i17 = iB1;
        int i18 = iA2;
        int iE = 0;
        int iF = 0;
        int i19 = 0;
        int i20 = iZ1;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i21 = iY2;
        while (i19 < size) {
            a aVar3 = (a) this.f10782t1.get(i19);
            if (i4 == 0) {
                if (i19 < size - 1) {
                    dVar2 = ((a) this.f10782t1.get(i19 + 1)).f10789b.f10663P;
                    iY1 = 0;
                } else {
                    dVar2 = this.f10665R;
                    iY1 = y1();
                }
                d dVar9 = aVar3.f10789b.f10665R;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i22 = iE;
                d dVar12 = dVar7;
                int i23 = iF;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i8 = i19;
                aVar3.j(i4, dVar10, dVar12, dVar13, dVar2, i20, i17, i18, iY1, i5);
                int iMax = Math.max(i23, aVar3.f());
                iE = i22 + aVar3.e();
                if (i8 > 0) {
                    iE += this.f10776n1;
                }
                dVar8 = dVar11;
                iF = iMax;
                dVar7 = dVar9;
                i17 = 0;
                dVar = dVar14;
                int i24 = iY1;
                dVar6 = dVar2;
                i21 = i24;
            } else {
                d dVar15 = dVar8;
                int i25 = iE;
                int i26 = iF;
                i8 = i19;
                if (i8 < size - 1) {
                    dVar = ((a) this.f10782t1.get(i8 + 1)).f10789b.f10662O;
                    iA1 = 0;
                } else {
                    dVar = this.f10664Q;
                    iA1 = A1();
                }
                d dVar16 = aVar3.f10789b.f10664Q;
                aVar3.j(i4, dVar15, dVar7, dVar, dVar6, i20, i17, iA1, i21, i5);
                iF = i26 + aVar3.f();
                int iMax2 = Math.max(i25, aVar3.e());
                if (i8 > 0) {
                    iF += this.f10775m1;
                }
                iE = iMax2;
                i18 = iA1;
                dVar8 = dVar16;
                i20 = 0;
            }
            i19 = i8 + 1;
            dVar5 = dVar;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void o2(e[] eVarArr, int i3, int i4, int i5, int[] iArr) {
        int i6;
        int i7;
        int i8;
        d dVar;
        int iA1;
        d dVar2;
        int iY1;
        int i9;
        if (i3 == 0) {
            return;
        }
        this.f10782t1.clear();
        a aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
        this.f10782t1.add(aVar);
        if (i4 == 0) {
            int i10 = 0;
            i6 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i3) {
                int i13 = i10 + 1;
                e eVar = eVarArr[i12];
                int iL2 = l2(eVar, i5);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i14 = i6;
                boolean z3 = (i11 == i5 || (this.f10775m1 + i11) + iL2 > i5) && aVar.f10789b != null;
                if (!z3 && i12 > 0 && (i9 = this.f10780r1) > 0 && i13 > i9) {
                    z3 = true;
                }
                if (z3) {
                    aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
                    aVar.i(i12);
                    this.f10782t1.add(aVar);
                    i10 = i13;
                    i11 = iL2;
                } else {
                    i11 = i12 > 0 ? i11 + this.f10775m1 + iL2 : iL2;
                    i10 = 0;
                }
                aVar.b(eVar);
                i12++;
                i6 = i14;
            }
        } else {
            int i15 = 0;
            i6 = 0;
            int i16 = 0;
            while (i16 < i3) {
                e eVar2 = eVarArr[i16];
                int iK2 = k2(eVar2, i5);
                if (eVar2.T() == e.b.MATCH_CONSTRAINT) {
                    i6++;
                }
                int i17 = i6;
                boolean z4 = (i15 == i5 || (this.f10776n1 + i15) + iK2 > i5) && aVar.f10789b != null;
                if (!z4 && i16 > 0 && (i7 = this.f10780r1) > 0 && i7 < 0) {
                    z4 = true;
                }
                if (z4) {
                    aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
                    aVar.i(i16);
                    this.f10782t1.add(aVar);
                } else {
                    if (i16 > 0) {
                        i15 += this.f10776n1 + iK2;
                    }
                    aVar.b(eVar2);
                    i16++;
                    i6 = i17;
                }
                i15 = iK2;
                aVar.b(eVar2);
                i16++;
                i6 = i17;
            }
        }
        int size = this.f10782t1.size();
        d dVar3 = this.f10662O;
        d dVar4 = this.f10663P;
        d dVar5 = this.f10664Q;
        d dVar6 = this.f10665R;
        int iZ1 = z1();
        int iB1 = B1();
        int iA2 = A1();
        int iY2 = y1();
        e.b bVarA = A();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z5 = bVarA == bVar || T() == bVar;
        if (i6 > 0 && z5) {
            for (int i18 = 0; i18 < size; i18++) {
                a aVar2 = (a) this.f10782t1.get(i18);
                if (i4 == 0) {
                    aVar2.g(i5 - aVar2.f());
                } else {
                    aVar2.g(i5 - aVar2.e());
                }
            }
        }
        int i19 = iB1;
        int i20 = iA2;
        int iE = 0;
        int iF = 0;
        int i21 = 0;
        int i22 = iZ1;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i23 = iY2;
        while (i21 < size) {
            a aVar3 = (a) this.f10782t1.get(i21);
            if (i4 == 0) {
                if (i21 < size - 1) {
                    dVar2 = ((a) this.f10782t1.get(i21 + 1)).f10789b.f10663P;
                    iY1 = 0;
                } else {
                    dVar2 = this.f10665R;
                    iY1 = y1();
                }
                d dVar9 = aVar3.f10789b.f10665R;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i24 = iE;
                d dVar12 = dVar7;
                int i25 = iF;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i8 = i21;
                aVar3.j(i4, dVar10, dVar12, dVar13, dVar2, i22, i19, i20, iY1, i5);
                int iMax = Math.max(i25, aVar3.f());
                iE = i24 + aVar3.e();
                if (i8 > 0) {
                    iE += this.f10776n1;
                }
                dVar8 = dVar11;
                iF = iMax;
                dVar7 = dVar9;
                i19 = 0;
                dVar = dVar14;
                int i26 = iY1;
                dVar6 = dVar2;
                i23 = i26;
            } else {
                d dVar15 = dVar8;
                int i27 = iE;
                int i28 = iF;
                i8 = i21;
                if (i8 < size - 1) {
                    dVar = ((a) this.f10782t1.get(i8 + 1)).f10789b.f10662O;
                    iA1 = 0;
                } else {
                    dVar = this.f10664Q;
                    iA1 = A1();
                }
                d dVar16 = aVar3.f10789b.f10664Q;
                aVar3.j(i4, dVar15, dVar7, dVar, dVar6, i22, i19, iA1, i23, i5);
                iF = i28 + aVar3.f();
                int iMax2 = Math.max(i27, aVar3.e());
                if (i8 > 0) {
                    iF += this.f10775m1;
                }
                iE = iMax2;
                i20 = iA1;
                dVar8 = dVar16;
                i22 = 0;
            }
            i21 = i8 + 1;
            dVar5 = dVar;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void p2(e[] eVarArr, int i3, int i4, int i5, int[] iArr) {
        a aVar;
        if (i3 == 0) {
            return;
        }
        if (this.f10782t1.size() == 0) {
            aVar = new a(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, i5);
            this.f10782t1.add(aVar);
        } else {
            a aVar2 = (a) this.f10782t1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i4, this.f10662O, this.f10663P, this.f10664Q, this.f10665R, z1(), B1(), A1(), y1(), i5);
        }
        for (int i6 = 0; i6 < i3; i6++) {
            aVar.b(eVarArr[i6]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void A2(float f3) {
        this.f10774l1 = f3;
    }

    public void B2(int i3) {
        this.f10768f1 = i3;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0106  */
    /* JADX WARN: Code duplicated, block: B:74:0x0115  */
    @Override // p058r.l
    public void C1(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        boolean z3;
        char c3;
        int iMin;
        int iMin2;
        if (this.f10816M0 > 0 && !E1()) {
            H1(0, 0);
            G1(false);
            return;
        }
        int iZ1 = z1();
        int iA1 = A1();
        int iB1 = B1();
        int iY1 = y1();
        int[] iArr = new int[2];
        int i9 = (i4 - iZ1) - iA1;
        int i10 = this.f10781s1;
        if (i10 == 1) {
            i9 = (i6 - iB1) - iY1;
        }
        int i11 = i9;
        if (i10 == 0) {
            if (this.f10763a1 == -1) {
                this.f10763a1 = 0;
            }
            if (this.f10764b1 == -1) {
                this.f10764b1 = 0;
            }
        } else {
            if (this.f10763a1 == -1) {
                this.f10763a1 = 0;
            }
            if (this.f10764b1 == -1) {
                this.f10764b1 = 0;
            }
        }
        e[] eVarArr = this.f10815L0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i7 = this.f10816M0;
            if (i12 >= i7) {
                break;
            }
            if (this.f10815L0[i12].V() == 8) {
                i13++;
            }
            i12++;
        }
        if (i13 > 0) {
            eVarArr = new e[i7 - i13];
            int i14 = 0;
            for (int i15 = 0; i15 < this.f10816M0; i15++) {
                e eVar = this.f10815L0[i15];
                if (eVar.V() != 8) {
                    eVarArr[i14] = eVar;
                    i14++;
                }
            }
            i8 = i14;
        } else {
            i8 = i7;
        }
        this.f10786x1 = eVarArr;
        this.f10787y1 = i8;
        int i16 = this.f10779q1;
        if (i16 == 0) {
            z3 = true;
            p2(eVarArr, i8, this.f10781s1, i11, iArr);
        } else if (i16 == 1) {
            z3 = true;
            n2(eVarArr, i8, this.f10781s1, i11, iArr);
        } else {
            if (i16 != 2) {
                if (i16 != 3) {
                    iArr = iArr;
                    c3 = 0;
                    z3 = true;
                } else {
                    z3 = true;
                    o2(eVarArr, i8, this.f10781s1, i11, iArr);
                }
                iMin = iArr[c3] + iZ1 + iA1;
                iMin2 = iArr[z3 ? 1 : 0] + iB1 + iY1;
                if (i3 == 1073741824) {
                    iMin = i4;
                } else if (i3 == Integer.MIN_VALUE) {
                    iMin = Math.min(iMin, i4);
                } else if (i3 != 0) {
                    iMin = 0;
                }
                if (i5 == 1073741824) {
                    iMin2 = i6;
                } else if (i5 == Integer.MIN_VALUE) {
                    iMin2 = Math.min(iMin2, i6);
                } else if (i5 != 0) {
                    iMin2 = 0;
                }
                H1(iMin, iMin2);
                k1(iMin);
                L0(iMin2);
                if (this.f10816M0 <= 0) {
                    z3 = false;
                }
                G1(z3);
            }
            z3 = true;
            m2(eVarArr, i8, this.f10781s1, i11, iArr);
        }
        c3 = 0;
        iMin = iArr[c3] + iZ1 + iA1;
        iMin2 = iArr[z3 ? 1 : 0] + iB1 + iY1;
        if (i3 == 1073741824) {
            iMin = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i4);
        } else if (i3 != 0) {
            iMin = 0;
        }
        if (i5 == 1073741824) {
            iMin2 = i6;
        } else if (i5 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i6);
        } else if (i5 != 0) {
            iMin2 = 0;
        }
        H1(iMin, iMin2);
        k1(iMin);
        L0(iMin2);
        if (this.f10816M0 <= 0) {
            z3 = false;
        }
        G1(z3);
    }

    public void C2(int i3) {
        this.f10780r1 = i3;
    }

    public void D2(int i3) {
        this.f10781s1 = i3;
    }

    public void E2(int i3) {
        this.f10778p1 = i3;
    }

    public void F2(float f3) {
        this.f10770h1 = f3;
    }

    public void G2(int i3) {
        this.f10776n1 = i3;
    }

    public void H2(int i3) {
        this.f10764b1 = i3;
    }

    public void I2(int i3) {
        this.f10779q1 = i3;
    }

    @Override // p058r.e
    public void g(d dVar, boolean z3) {
        super.g(dVar, z3);
        boolean z4 = K() != null && ((f) K()).P1();
        int i3 = this.f10779q1;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = this.f10782t1.size();
                int i4 = 0;
                while (i4 < size) {
                    ((a) this.f10782t1.get(i4)).d(z4, i4, i4 == size + (-1));
                    i4++;
                }
            } else if (i3 == 2) {
                j2(z4);
            } else if (i3 == 3) {
                int size2 = this.f10782t1.size();
                int i5 = 0;
                while (i5 < size2) {
                    ((a) this.f10782t1.get(i5)).d(z4, i5, i5 == size2 + (-1));
                    i5++;
                }
            }
        } else if (this.f10782t1.size() > 0) {
            ((a) this.f10782t1.get(0)).d(z4, 0, true);
        }
        G1(false);
    }

    public void q2(float f3) {
        this.f10771i1 = f3;
    }

    public void r2(int i3) {
        this.f10765c1 = i3;
    }

    public void s2(float f3) {
        this.f10772j1 = f3;
    }

    public void t2(int i3) {
        this.f10766d1 = i3;
    }

    public void u2(int i3) {
        this.f10777o1 = i3;
    }

    public void v2(float f3) {
        this.f10769g1 = f3;
    }

    public void w2(int i3) {
        this.f10775m1 = i3;
    }

    public void x2(int i3) {
        this.f10763a1 = i3;
    }

    public void y2(float f3) {
        this.f10773k1 = f3;
    }

    public void z2(int i3) {
        this.f10767e1 = i3;
    }
}
