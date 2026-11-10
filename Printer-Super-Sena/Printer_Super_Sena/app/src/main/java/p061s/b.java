package p061s;

import java.util.ArrayList;
import p049o.d;
import p058r.e;
import p058r.f;
import p058r.h;
import p058r.i;
import p058r.k;
import p058r.l;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f11611a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11612b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f11613c;

    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f11614k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f11615l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f11616m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e.b f11617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f11618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11621e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11622f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11623g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11624h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11625i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11626j;
    }

    /* JADX INFO: renamed from: s.b$b, reason: collision with other inner class name */
    public interface InterfaceC0133b {
        void a(e eVar, a aVar);

        void b();
    }

    public b(f fVar) {
        this.f11613c = fVar;
    }

    private boolean a(InterfaceC0133b interfaceC0133b, e eVar, int i3) {
        this.f11612b.f11617a = eVar.A();
        this.f11612b.f11618b = eVar.T();
        this.f11612b.f11619c = eVar.W();
        this.f11612b.f11620d = eVar.x();
        a aVar = this.f11612b;
        aVar.f11625i = false;
        aVar.f11626j = i3;
        e.b bVar = aVar.f11617a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z3 = bVar == bVar2;
        boolean z4 = aVar.f11618b == bVar2;
        boolean z5 = z3 && eVar.f10681d0 > 0.0f;
        boolean z6 = z4 && eVar.f10681d0 > 0.0f;
        if (z5 && eVar.f10722y[0] == 4) {
            aVar.f11617a = e.b.FIXED;
        }
        if (z6 && eVar.f10722y[1] == 4) {
            aVar.f11618b = e.b.FIXED;
        }
        interfaceC0133b.a(eVar, aVar);
        eVar.k1(this.f11612b.f11621e);
        eVar.L0(this.f11612b.f11622f);
        eVar.K0(this.f11612b.f11624h);
        eVar.A0(this.f11612b.f11623g);
        a aVar2 = this.f11612b;
        aVar2.f11626j = a.f11614k;
        return aVar2.f11625i;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    private void b(f fVar) {
        boolean z3;
        l lVar;
        n nVar;
        int size = fVar.f10831L0.size();
        boolean zT1 = fVar.T1(64);
        InterfaceC0133b interfaceC0133bI1 = fVar.I1();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) fVar.f10831L0.get(i3);
            if (!(eVar instanceof h) && !(eVar instanceof p058r.a) && !eVar.l0() && (!zT1 || (lVar = eVar.f10682e) == null || (nVar = eVar.f10684f) == null || !lVar.f11695e.f11647j || !nVar.f11695e.f11647j)) {
                e.b bVarU = eVar.u(0);
                e.b bVarU2 = eVar.u(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z4 = bVarU == bVar && eVar.f10718w != 1 && bVarU2 == bVar && eVar.f10720x != 1;
                if (!z4 && fVar.T1(1) && !(eVar instanceof l)) {
                    if (bVarU == bVar && eVar.f10718w == 0 && bVarU2 != bVar && !eVar.i0()) {
                        z4 = true;
                    }
                    if (bVarU2 == bVar && eVar.f10720x == 0 && bVarU != bVar && !eVar.i0()) {
                        z4 = true;
                    }
                    z3 = (!(bVarU == bVar || bVarU2 == bVar) || eVar.f10681d0 <= 0.0f) ? z4 : true;
                }
                if (!z3) {
                    a(interfaceC0133bI1, eVar, a.f11614k);
                }
            }
        }
        interfaceC0133bI1.b();
    }

    private void c(f fVar, String str, int i3, int i4, int i5) {
        int I2 = fVar.I();
        int iH = fVar.H();
        fVar.a1(0);
        fVar.Z0(0);
        fVar.k1(i4);
        fVar.L0(i5);
        fVar.a1(I2);
        fVar.Z0(iH);
        this.f11613c.X1(i3);
        this.f11613c.s1();
    }

    public long d(f fVar, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        boolean zH1;
        int i12;
        int i13;
        boolean z3;
        boolean z4;
        int i14;
        boolean z5;
        b bVar = this;
        InterfaceC0133b interfaceC0133bI1 = fVar.I1();
        int size = fVar.f10831L0.size();
        int iW = fVar.W();
        int iX = fVar.x();
        boolean zB = k.b(i3, 128);
        boolean z6 = zB || k.b(i3, 64);
        if (z6) {
            for (int i15 = 0; i15 < size; i15++) {
                e eVar = (e) fVar.f10831L0.get(i15);
                e.b bVarA = eVar.A();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                boolean z7 = (bVarA == bVar2) && (eVar.T() == bVar2) && eVar.v() > 0.0f;
                if ((eVar.i0() && z7) || ((eVar.k0() && z7) || (eVar instanceof l) || eVar.i0() || eVar.k0())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6) {
            boolean z8 = d.f10260r;
        }
        boolean z9 = z6 & ((i6 == 1073741824 && i8 == 1073741824) || zB);
        if (z9) {
            int iMin = Math.min(fVar.G(), i7);
            int iMin2 = Math.min(fVar.F(), i9);
            if (i6 == 1073741824 && fVar.W() != iMin) {
                fVar.k1(iMin);
                fVar.M1();
            }
            if (i8 == 1073741824 && fVar.x() != iMin2) {
                fVar.L0(iMin2);
                fVar.M1();
            }
            if (i6 == 1073741824 && i8 == 1073741824) {
                zH1 = fVar.F1(zB);
                i12 = 2;
            } else {
                boolean zG1 = fVar.G1(zB);
                if (i6 == 1073741824) {
                    zG1 &= fVar.H1(zB, 0);
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                if (i8 == 1073741824) {
                    zH1 = fVar.H1(zB, 1) & zG1;
                    i12++;
                } else {
                    zH1 = zG1;
                }
            }
            if (zH1) {
                fVar.p1(i6 == 1073741824, i8 == 1073741824);
            }
        } else {
            zH1 = false;
            i12 = 0;
        }
        if (zH1 && i12 == 2) {
            return 0L;
        }
        int iJ1 = fVar.J1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = bVar.f11611a.size();
        if (size > 0) {
            c(fVar, "First pass", 0, iW, iX);
        }
        if (size2 > 0) {
            e.b bVarA2 = fVar.A();
            e.b bVar3 = e.b.WRAP_CONTENT;
            boolean z10 = bVarA2 == bVar3;
            boolean z11 = fVar.T() == bVar3;
            int iMax = Math.max(fVar.W(), bVar.f11613c.I());
            int iMax2 = Math.max(fVar.x(), bVar.f11613c.H());
            int i16 = 0;
            boolean zF1 = false;
            while (i16 < size2) {
                e eVar2 = (e) bVar.f11611a.get(i16);
                if (eVar2 instanceof l) {
                    int iW2 = eVar2.W();
                    int iX2 = eVar2.x();
                    boolean zA = zF1 | bVar.a(interfaceC0133bI1, eVar2, a.f11615l);
                    int iW3 = eVar2.W();
                    int iX3 = eVar2.x();
                    if (iW3 != iW2) {
                        eVar2.k1(iW3);
                        if (z10 && eVar2.M() > iMax) {
                            iMax = Math.max(iMax, eVar2.M() + eVar2.o(r.d.b.RIGHT).f());
                        }
                        z5 = true;
                    }
                    if (iX3 != iX2) {
                        z5 = zA;
                        eVar2.L0(iX3);
                        if (z11 && eVar2.r() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.r() + eVar2.o(r.d.b.BOTTOM).f());
                        }
                        z5 = true;
                    }
                    z5 = zA;
                    zF1 = z5 | ((l) eVar2).F1();
                }
                i16++;
                iJ1 = iJ1;
            }
            int i17 = iJ1;
            int i18 = 2;
            int i19 = 0;
            while (i19 < i18) {
                int i20 = 0;
                while (i20 < size2) {
                    e eVar3 = (e) bVar.f11611a.get(i20);
                    if (((eVar3 instanceof i) && !(eVar3 instanceof l)) || (eVar3 instanceof h) || eVar3.V() == 8 || ((z9 && eVar3.f10682e.f11695e.f11647j && eVar3.f10684f.f11695e.f11647j) || (eVar3 instanceof l))) {
                        z3 = z9;
                    } else {
                        int iW4 = eVar3.W();
                        int iX4 = eVar3.x();
                        int iP = eVar3.p();
                        int i21 = a.f11615l;
                        z3 = z9;
                        if (i19 == 1) {
                            i21 = a.f11616m;
                        }
                        boolean zA2 = zF1 | bVar.a(interfaceC0133bI1, eVar3, i21);
                        int iW5 = eVar3.W();
                        int iX5 = eVar3.x();
                        if (iW5 != iW4) {
                            eVar3.k1(iW5);
                            if (z10 && eVar3.M() > iMax) {
                                iMax = Math.max(iMax, eVar3.M() + eVar3.o(r.d.b.RIGHT).f());
                            }
                            z4 = true;
                        } else {
                            z4 = zA2;
                        }
                        if (iX5 != iX4) {
                            eVar3.L0(iX5);
                            if (z11 && eVar3.r() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.r() + eVar3.o(r.d.b.BOTTOM).f());
                            }
                            z4 = true;
                        }
                        if (!eVar3.Z() || iP == eVar3.p()) {
                            zF1 = z4;
                        } else {
                            i14 = 1;
                            zF1 = true;
                        }
                        i20 += i14;
                        bVar = this;
                        z9 = z3;
                    }
                    i14 = 1;
                    i20 += i14;
                    bVar = this;
                    z9 = z3;
                }
                boolean z12 = z9;
                if (!zF1) {
                    break;
                }
                i19++;
                c(fVar, "intermediate pass", i19, iW, iX);
                i18 = 2;
                zF1 = false;
                bVar = this;
                z9 = z12;
            }
            i13 = i17;
        } else {
            i13 = iJ1;
        }
        fVar.W1(i13);
        return 0L;
    }

    public void e(f fVar) {
        this.f11611a.clear();
        int size = fVar.f10831L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) fVar.f10831L0.get(i3);
            e.b bVarA = eVar.A();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (bVarA == bVar || eVar.T() == bVar) {
                this.f11611a.add(eVar);
            }
        }
        fVar.M1();
    }
}
