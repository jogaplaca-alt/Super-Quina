package p061s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p058r.d;
import p058r.f;
import p058r.h;
import p058r.j;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f11629a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f11632d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11630b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11631c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f11633e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f11634f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.InterfaceC0133b f11635g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b.a f11636h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList f11637i = new ArrayList();

    public e(f fVar) {
        this.f11629a = fVar;
        this.f11632d = fVar;
    }

    private void a(f fVar, int i3, int i4, f fVar2, ArrayList arrayList, m mVar) {
        p pVar = fVar.f11641d;
        if (pVar.f11693c == null) {
            f fVar3 = this.f11629a;
            if (pVar == fVar3.f10682e || pVar == fVar3.f10684f) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i4);
                arrayList.add(mVar);
            }
            pVar.f11693c = mVar;
            mVar.a(pVar);
            for (d dVar : pVar.f11698h.f11648k) {
                if (dVar instanceof f) {
                    a((f) dVar, i3, 0, fVar2, arrayList, mVar);
                }
            }
            for (d dVar2 : pVar.f11699i.f11648k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i3, 1, fVar2, arrayList, mVar);
                }
            }
            if (i3 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f11673k.f11648k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i3, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            for (f fVar4 : pVar.f11698h.f11649l) {
                if (fVar4 == fVar2) {
                    mVar.f11667b = true;
                }
                a(fVar4, i3, 0, fVar2, arrayList, mVar);
            }
            for (f fVar5 : pVar.f11699i.f11649l) {
                if (fVar5 == fVar2) {
                    mVar.f11667b = true;
                }
                a(fVar5, i3, 1, fVar2, arrayList, mVar);
            }
            if (i3 == 1 && (pVar instanceof n)) {
                Iterator it = ((n) pVar).f11673k.f11649l.iterator();
                while (it.hasNext()) {
                    a((f) it.next(), i3, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    private boolean b(f fVar) {
        int iW;
        r.e.b bVar;
        int iX;
        r.e.b bVar2;
        r.e.b bVar3;
        r.e.b bVar4;
        for (p058r.e eVar : fVar.f10831L0) {
            r.e.b[] bVarArr = eVar.f10673Z;
            r.e.b bVar5 = bVarArr[0];
            r.e.b bVar6 = bVarArr[1];
            if (eVar.V() == 8) {
                eVar.f10674a = true;
            } else {
                if (eVar.f10640B < 1.0f && bVar5 == r.e.b.MATCH_CONSTRAINT) {
                    eVar.f10718w = 2;
                }
                if (eVar.f10646E < 1.0f && bVar6 == r.e.b.MATCH_CONSTRAINT) {
                    eVar.f10720x = 2;
                }
                if (eVar.v() > 0.0f) {
                    r.e.b bVar7 = r.e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == r.e.b.WRAP_CONTENT || bVar6 == r.e.b.FIXED)) {
                        eVar.f10718w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == r.e.b.WRAP_CONTENT || bVar5 == r.e.b.FIXED)) {
                        eVar.f10720x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.f10718w == 0) {
                            eVar.f10718w = 3;
                        }
                        if (eVar.f10720x == 0) {
                            eVar.f10720x = 3;
                        }
                    }
                }
                r.e.b bVar8 = r.e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.f10718w == 1 && (eVar.f10662O.f10622f == null || eVar.f10664Q.f10622f == null)) {
                    bVar5 = r.e.b.WRAP_CONTENT;
                }
                r.e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.f10720x == 1 && (eVar.f10663P.f10622f == null || eVar.f10665R.f10622f == null)) {
                    bVar6 = r.e.b.WRAP_CONTENT;
                }
                r.e.b bVar10 = bVar6;
                l lVar = eVar.f10682e;
                lVar.f11694d = bVar9;
                int i3 = eVar.f10718w;
                lVar.f11691a = i3;
                n nVar = eVar.f10684f;
                nVar.f11694d = bVar10;
                int i4 = eVar.f10720x;
                nVar.f11691a = i4;
                r.e.b bVar11 = r.e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == r.e.b.FIXED || bVar9 == r.e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == r.e.b.FIXED || bVar10 == r.e.b.WRAP_CONTENT)) {
                    int iW2 = eVar.W();
                    if (bVar9 == bVar11) {
                        iW = (fVar.W() - eVar.f10662O.f10623g) - eVar.f10664Q.f10623g;
                        bVar = r.e.b.FIXED;
                    } else {
                        iW = iW2;
                        bVar = bVar9;
                    }
                    int iX2 = eVar.x();
                    if (bVar10 == bVar11) {
                        iX = (fVar.x() - eVar.f10663P.f10623g) - eVar.f10665R.f10623g;
                        bVar2 = r.e.b.FIXED;
                    } else {
                        iX = iX2;
                        bVar2 = bVar10;
                    }
                    l(eVar, bVar, iW, bVar2, iX);
                    eVar.f10682e.f11695e.d(eVar.W());
                    eVar.f10684f.f11695e.d(eVar.x());
                    eVar.f10674a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = r.e.b.WRAP_CONTENT) || bVar10 == r.e.b.FIXED)) {
                        if (i3 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar, bVar4, 0, bVar4, 0);
                            }
                            int iX3 = eVar.x();
                            int i5 = (int) ((iX3 * eVar.f10681d0) + 0.5f);
                            r.e.b bVar12 = r.e.b.FIXED;
                            l(eVar, bVar12, i5, bVar12, iX3);
                            eVar.f10682e.f11695e.d(eVar.W());
                            eVar.f10684f.f11695e.d(eVar.x());
                            eVar.f10674a = true;
                        } else if (i3 == 1) {
                            l(eVar, bVar4, 0, bVar10, 0);
                            eVar.f10682e.f11695e.f11659m = eVar.W();
                        } else if (i3 == 2) {
                            r.e.b bVar13 = fVar.f10673Z[0];
                            r.e.b bVar14 = r.e.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                l(eVar, bVar14, (int) ((eVar.f10640B * fVar.W()) + 0.5f), bVar10, eVar.x());
                                eVar.f10682e.f11695e.d(eVar.W());
                                eVar.f10684f.f11695e.d(eVar.x());
                                eVar.f10674a = true;
                            }
                        } else {
                            d[] dVarArr = eVar.f10670W;
                            if (dVarArr[0].f10622f == null || dVarArr[1].f10622f == null) {
                                l(eVar, bVar4, 0, bVar10, 0);
                                eVar.f10682e.f11695e.d(eVar.W());
                                eVar.f10684f.f11695e.d(eVar.x());
                                eVar.f10674a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = r.e.b.WRAP_CONTENT) || bVar9 == r.e.b.FIXED)) {
                        if (i4 == 3) {
                            if (bVar9 == bVar3) {
                                l(eVar, bVar3, 0, bVar3, 0);
                            }
                            int iW3 = eVar.W();
                            float f3 = eVar.f10681d0;
                            if (eVar.w() == -1) {
                                f3 = 1.0f / f3;
                            }
                            r.e.b bVar15 = r.e.b.FIXED;
                            l(eVar, bVar15, iW3, bVar15, (int) ((iW3 * f3) + 0.5f));
                            eVar.f10682e.f11695e.d(eVar.W());
                            eVar.f10684f.f11695e.d(eVar.x());
                            eVar.f10674a = true;
                        } else if (i4 == 1) {
                            l(eVar, bVar9, 0, bVar3, 0);
                            eVar.f10684f.f11695e.f11659m = eVar.x();
                        } else if (i4 == 2) {
                            r.e.b bVar16 = fVar.f10673Z[1];
                            r.e.b bVar17 = r.e.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                l(eVar, bVar9, eVar.W(), bVar17, (int) ((eVar.f10646E * fVar.x()) + 0.5f));
                                eVar.f10682e.f11695e.d(eVar.W());
                                eVar.f10684f.f11695e.d(eVar.x());
                                eVar.f10674a = true;
                            }
                        } else {
                            d[] dVarArr2 = eVar.f10670W;
                            if (dVarArr2[2].f10622f == null || dVarArr2[3].f10622f == null) {
                                l(eVar, bVar3, 0, bVar10, 0);
                                eVar.f10682e.f11695e.d(eVar.W());
                                eVar.f10684f.f11695e.d(eVar.x());
                                eVar.f10674a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i3 == 1 || i4 == 1) {
                            r.e.b bVar18 = r.e.b.WRAP_CONTENT;
                            l(eVar, bVar18, 0, bVar18, 0);
                            eVar.f10682e.f11695e.f11659m = eVar.W();
                            eVar.f10684f.f11695e.f11659m = eVar.x();
                        } else if (i4 == 2 && i3 == 2) {
                            r.e.b[] bVarArr2 = fVar.f10673Z;
                            r.e.b bVar19 = bVarArr2[0];
                            r.e.b bVar20 = r.e.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                l(eVar, bVar20, (int) ((eVar.f10640B * fVar.W()) + 0.5f), bVar20, (int) ((eVar.f10646E * fVar.x()) + 0.5f));
                                eVar.f10682e.f11695e.d(eVar.W());
                                eVar.f10684f.f11695e.d(eVar.x());
                                eVar.f10674a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(f fVar, int i3) {
        int size = this.f11637i.size();
        long jMax = 0;
        for (int i4 = 0; i4 < size; i4++) {
            jMax = Math.max(jMax, ((m) this.f11637i.get(i4)).b(fVar, i3));
        }
        return (int) jMax;
    }

    private void i(p pVar, int i3, ArrayList arrayList) {
        for (d dVar : pVar.f11698h.f11648k) {
            if (dVar instanceof f) {
                a((f) dVar, i3, 0, pVar.f11699i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f11698h, i3, 0, pVar.f11699i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f11699i.f11648k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i3, 1, pVar.f11698h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f11699i, i3, 1, pVar.f11698h, arrayList, null);
            }
        }
        if (i3 == 1) {
            for (d dVar3 : ((n) pVar).f11673k.f11648k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i3, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(p058r.e eVar, r.e.b bVar, int i3, r.e.b bVar2, int i4) {
        b.a aVar = this.f11636h;
        aVar.f11617a = bVar;
        aVar.f11618b = bVar2;
        aVar.f11619c = i3;
        aVar.f11620d = i4;
        this.f11635g.a(eVar, aVar);
        eVar.k1(this.f11636h.f11621e);
        eVar.L0(this.f11636h.f11622f);
        eVar.K0(this.f11636h.f11624h);
        eVar.A0(this.f11636h.f11623g);
    }

    public void c() {
        d(this.f11633e);
        this.f11637i.clear();
        m.f11665h = 0;
        i(this.f11629a.f10682e, 0, this.f11637i);
        i(this.f11629a.f10684f, 1, this.f11637i);
        this.f11630b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f11632d.f10682e.f();
        this.f11632d.f10684f.f();
        arrayList.add(this.f11632d.f10682e);
        arrayList.add(this.f11632d.f10684f);
        HashSet hashSet = null;
        for (p058r.e eVar : this.f11632d.f10831L0) {
            if (eVar instanceof h) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.i0()) {
                    if (eVar.f10678c == null) {
                        eVar.f10678c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f10678c);
                } else {
                    arrayList.add(eVar.f10682e);
                }
                if (eVar.k0()) {
                    if (eVar.f10680d == null) {
                        eVar.f10680d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f10680d);
                } else {
                    arrayList.add(eVar.f10684f);
                }
                if (eVar instanceof j) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            p pVar = (p) it2.next();
            if (pVar.f11692b != this.f11632d) {
                pVar.d();
            }
        }
    }

    public boolean f(boolean z3) {
        boolean z4;
        boolean z5 = false;
        if (this.f11630b || this.f11631c) {
            for (p058r.e eVar : this.f11629a.f10831L0) {
                eVar.n();
                eVar.f10674a = false;
                eVar.f10682e.r();
                eVar.f10684f.q();
            }
            this.f11629a.n();
            f fVar = this.f11629a;
            fVar.f10674a = false;
            fVar.f10682e.r();
            this.f11629a.f10684f.q();
            this.f11631c = false;
        }
        if (b(this.f11632d)) {
            return false;
        }
        this.f11629a.m1(0);
        this.f11629a.n1(0);
        r.e.b bVarU = this.f11629a.u(0);
        r.e.b bVarU2 = this.f11629a.u(1);
        if (this.f11630b) {
            c();
        }
        int iX = this.f11629a.X();
        int iY = this.f11629a.Y();
        this.f11629a.f10682e.f11698h.d(iX);
        this.f11629a.f10684f.f11698h.d(iY);
        m();
        r.e.b bVar = r.e.b.WRAP_CONTENT;
        if (bVarU == bVar || bVarU2 == bVar) {
            if (z3) {
                Iterator it = this.f11633e.iterator();
                while (it.hasNext()) {
                    if (!((p) it.next()).m()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3 && bVarU == r.e.b.WRAP_CONTENT) {
                this.f11629a.P0(r.e.b.FIXED);
                f fVar2 = this.f11629a;
                fVar2.k1(e(fVar2, 0));
                f fVar3 = this.f11629a;
                fVar3.f10682e.f11695e.d(fVar3.W());
            }
            if (z3 && bVarU2 == r.e.b.WRAP_CONTENT) {
                this.f11629a.g1(r.e.b.FIXED);
                f fVar4 = this.f11629a;
                fVar4.L0(e(fVar4, 1));
                f fVar5 = this.f11629a;
                fVar5.f10684f.f11695e.d(fVar5.x());
            }
        }
        f fVar6 = this.f11629a;
        r.e.b bVar2 = fVar6.f10673Z[0];
        r.e.b bVar3 = r.e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == r.e.b.MATCH_PARENT) {
            int iW = fVar6.W() + iX;
            this.f11629a.f10682e.f11699i.d(iW);
            this.f11629a.f10682e.f11695e.d(iW - iX);
            m();
            f fVar7 = this.f11629a;
            r.e.b bVar4 = fVar7.f10673Z[1];
            if (bVar4 == bVar3 || bVar4 == r.e.b.MATCH_PARENT) {
                int iX2 = fVar7.x() + iY;
                this.f11629a.f10684f.f11699i.d(iX2);
                this.f11629a.f10684f.f11695e.d(iX2 - iY);
            }
            m();
            z4 = true;
        } else {
            z4 = false;
        }
        for (p pVar : this.f11633e) {
            if (pVar.f11692b != this.f11629a || pVar.f11697g) {
                pVar.e();
            }
        }
        for (p pVar2 : this.f11633e) {
            if (z4 || pVar2.f11692b != this.f11629a) {
                if (!pVar2.f11698h.f11647j || ((!pVar2.f11699i.f11647j && !(pVar2 instanceof j)) || (!pVar2.f11695e.f11647j && !(pVar2 instanceof c) && !(pVar2 instanceof j)))) {
                    this.f11629a.P0(bVarU);
                    this.f11629a.g1(bVarU2);
                    return z5;
                }
            }
        }
        z5 = true;
        this.f11629a.P0(bVarU);
        this.f11629a.g1(bVarU2);
        return z5;
    }

    public boolean g(boolean z3) {
        if (this.f11630b) {
            for (p058r.e eVar : this.f11629a.f10831L0) {
                eVar.n();
                eVar.f10674a = false;
                l lVar = eVar.f10682e;
                lVar.f11695e.f11647j = false;
                lVar.f11697g = false;
                lVar.r();
                n nVar = eVar.f10684f;
                nVar.f11695e.f11647j = false;
                nVar.f11697g = false;
                nVar.q();
            }
            this.f11629a.n();
            f fVar = this.f11629a;
            fVar.f10674a = false;
            l lVar2 = fVar.f10682e;
            lVar2.f11695e.f11647j = false;
            lVar2.f11697g = false;
            lVar2.r();
            n nVar2 = this.f11629a.f10684f;
            nVar2.f11695e.f11647j = false;
            nVar2.f11697g = false;
            nVar2.q();
            c();
        }
        if (b(this.f11632d)) {
            return false;
        }
        this.f11629a.m1(0);
        this.f11629a.n1(0);
        this.f11629a.f10682e.f11698h.d(0);
        this.f11629a.f10684f.f11698h.d(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00c1  */
    public boolean h(boolean z3, int i3) {
        boolean z4;
        r.e.b bVar;
        boolean z5 = false;
        r.e.b bVarU = this.f11629a.u(0);
        r.e.b bVarU2 = this.f11629a.u(1);
        int iX = this.f11629a.X();
        int iY = this.f11629a.Y();
        if (z3 && (bVarU == (bVar = r.e.b.WRAP_CONTENT) || bVarU2 == bVar)) {
            for (p pVar : this.f11633e) {
                if (pVar.f11696f == i3 && !pVar.m()) {
                    z3 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z3 && bVarU == r.e.b.WRAP_CONTENT) {
                    this.f11629a.P0(r.e.b.FIXED);
                    f fVar = this.f11629a;
                    fVar.k1(e(fVar, 0));
                    f fVar2 = this.f11629a;
                    fVar2.f10682e.f11695e.d(fVar2.W());
                }
            } else if (z3 && bVarU2 == r.e.b.WRAP_CONTENT) {
                this.f11629a.g1(r.e.b.FIXED);
                f fVar3 = this.f11629a;
                fVar3.L0(e(fVar3, 1));
                f fVar4 = this.f11629a;
                fVar4.f10684f.f11695e.d(fVar4.x());
            }
        }
        if (i3 == 0) {
            f fVar5 = this.f11629a;
            r.e.b bVar2 = fVar5.f10673Z[0];
            if (bVar2 == r.e.b.FIXED || bVar2 == r.e.b.MATCH_PARENT) {
                int iW = fVar5.W() + iX;
                this.f11629a.f10682e.f11699i.d(iW);
                this.f11629a.f10682e.f11695e.d(iW - iX);
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            f fVar6 = this.f11629a;
            r.e.b bVar3 = fVar6.f10673Z[1];
            if (bVar3 == r.e.b.FIXED || bVar3 == r.e.b.MATCH_PARENT) {
                int iX2 = fVar6.x() + iY;
                this.f11629a.f10684f.f11699i.d(iX2);
                this.f11629a.f10684f.f11695e.d(iX2 - iY);
                z4 = true;
            } else {
                z4 = false;
            }
        }
        m();
        for (p pVar2 : this.f11633e) {
            if (pVar2.f11696f == i3 && (pVar2.f11692b != this.f11629a || pVar2.f11697g)) {
                pVar2.e();
            }
        }
        for (p pVar3 : this.f11633e) {
            if (pVar3.f11696f == i3 && (z4 || pVar3.f11692b != this.f11629a)) {
                if (!pVar3.f11698h.f11647j || !pVar3.f11699i.f11647j || (!(pVar3 instanceof c) && !pVar3.f11695e.f11647j)) {
                    this.f11629a.P0(bVarU);
                    this.f11629a.g1(bVarU2);
                    return z5;
                }
            }
        }
        z5 = true;
        this.f11629a.P0(bVarU);
        this.f11629a.g1(bVarU2);
        return z5;
    }

    public void j() {
        this.f11630b = true;
    }

    public void k() {
        this.f11631c = true;
    }

    public void m() {
        g gVar;
        for (p058r.e eVar : this.f11629a.f10831L0) {
            if (!eVar.f10674a) {
                r.e.b[] bVarArr = eVar.f10673Z;
                boolean z3 = false;
                r.e.b bVar = bVarArr[0];
                r.e.b bVar2 = bVarArr[1];
                int i3 = eVar.f10718w;
                int i4 = eVar.f10720x;
                r.e.b bVar3 = r.e.b.WRAP_CONTENT;
                boolean z4 = bVar == bVar3 || (bVar == r.e.b.MATCH_CONSTRAINT && i3 == 1);
                if (bVar2 == bVar3 || (bVar2 == r.e.b.MATCH_CONSTRAINT && i4 == 1)) {
                    z3 = true;
                }
                g gVar2 = eVar.f10682e.f11695e;
                boolean z5 = gVar2.f11647j;
                g gVar3 = eVar.f10684f.f11695e;
                boolean z6 = gVar3.f11647j;
                if (z5 && z6) {
                    r.e.b bVar4 = r.e.b.FIXED;
                    l(eVar, bVar4, gVar2.f11644g, bVar4, gVar3.f11644g);
                    eVar.f10674a = true;
                } else if (z5 && z3) {
                    l(eVar, r.e.b.FIXED, gVar2.f11644g, bVar3, gVar3.f11644g);
                    if (bVar2 == r.e.b.MATCH_CONSTRAINT) {
                        eVar.f10684f.f11695e.f11659m = eVar.x();
                    } else {
                        eVar.f10684f.f11695e.d(eVar.x());
                        eVar.f10674a = true;
                    }
                } else if (z6 && z4) {
                    l(eVar, bVar3, gVar2.f11644g, r.e.b.FIXED, gVar3.f11644g);
                    if (bVar == r.e.b.MATCH_CONSTRAINT) {
                        eVar.f10682e.f11695e.f11659m = eVar.W();
                    } else {
                        eVar.f10682e.f11695e.d(eVar.W());
                        eVar.f10674a = true;
                    }
                }
                if (eVar.f10674a && (gVar = eVar.f10684f.f11674l) != null) {
                    gVar.d(eVar.p());
                }
            }
        }
    }

    public void n(b.InterfaceC0133b interfaceC0133b) {
        this.f11635g = interfaceC0133b;
    }
}
