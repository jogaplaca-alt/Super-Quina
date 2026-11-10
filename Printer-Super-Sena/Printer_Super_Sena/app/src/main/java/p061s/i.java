package p061s;

import java.util.ArrayList;
import java.util.Iterator;
import p058r.a;
import p058r.d;
import p058r.e;
import p058r.f;
import p058r.g;
import p058r.h;
import p058r.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static o a(e eVar, int i3, ArrayList arrayList, o oVar) {
        int iS1;
        int i4 = i3 == 0 ? eVar.f10655I0 : eVar.f10657J0;
        if (i4 != -1 && (oVar == null || i4 != oVar.f11678b)) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                o oVar2 = (o) arrayList.get(i5);
                if (oVar2.c() == i4) {
                    if (oVar != null) {
                        oVar.g(i3, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                    break;
                }
            }
        } else if (i4 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof j) && (iS1 = ((j) eVar).s1(i3)) != -1) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    o oVar3 = (o) arrayList.get(i6);
                    if (oVar3.c() == iS1) {
                        oVar = oVar3;
                        break;
                    }
                }
            }
            if (oVar == null) {
                oVar = new o(i3);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                hVar.r1().c(hVar.s1() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i3 == 0) {
                eVar.f10655I0 = oVar.c();
                eVar.f10662O.c(i3, arrayList, oVar);
                eVar.f10664Q.c(i3, arrayList, oVar);
            } else {
                eVar.f10657J0 = oVar.c();
                eVar.f10663P.c(i3, arrayList, oVar);
                eVar.f10666S.c(i3, arrayList, oVar);
                eVar.f10665R.c(i3, arrayList, oVar);
            }
            eVar.f10669V.c(i3, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList arrayList, int i3) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            o oVar = (o) arrayList.get(i4);
            if (i3 == oVar.f11678b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:176:0x0348  */
    public static boolean c(f fVar, b.InterfaceC0133b interfaceC0133b) {
        o oVar;
        o oVar2;
        ArrayList arrayListR1 = fVar.r1();
        int size = arrayListR1.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) arrayListR1.get(i4);
            if (!d(fVar.A(), fVar.T(), eVar.A(), eVar.T()) || (eVar instanceof g)) {
                return false;
            }
        }
        int i5 = 0;
        ArrayList arrayList = null;
        ArrayList<j> arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList<j> arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i5 < size) {
            e eVar2 = (e) arrayListR1.get(i5);
            if (!d(fVar.A(), fVar.T(), eVar2.A(), eVar2.T())) {
                f.S1(i3, eVar2, interfaceC0133b, fVar.f10762p1, b.a.f11614k);
            }
            boolean z3 = eVar2 instanceof h;
            if (z3) {
                h hVar = (h) eVar2;
                if (hVar.s1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(hVar);
                }
                if (hVar.s1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(hVar);
                }
            }
            if (eVar2 instanceof j) {
                if (eVar2 instanceof a) {
                    a aVar = (a) eVar2;
                    if (aVar.x1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.x1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    j jVar = (j) eVar2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(jVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(jVar);
                }
            }
            if (eVar2.f10662O.f10622f == null && eVar2.f10664Q.f10622f == null && !z3 && !(eVar2 instanceof a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(eVar2);
            }
            if (eVar2.f10663P.f10622f == null && eVar2.f10665R.f10622f == null && eVar2.f10666S.f10622f == null && !z3 && !(eVar2 instanceof a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(eVar2);
            }
            i5++;
            i3 = 0;
        }
        ArrayList<o> arrayList7 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((h) it.next(), 0, arrayList7, null);
            }
        }
        int i6 = 0;
        o oVar3 = null;
        if (arrayList2 != null) {
            for (j jVar2 : arrayList2) {
                o oVarA = a(jVar2, i6, arrayList7, oVar3);
                jVar2.r1(arrayList7, i6, oVarA);
                oVarA.b(arrayList7);
                i6 = 0;
                oVar3 = null;
            }
        }
        d dVarO = fVar.o(d.b.LEFT);
        if (dVarO.d() != null) {
            Iterator it2 = dVarO.d().iterator();
            while (it2.hasNext()) {
                a(((d) it2.next()).f10620d, 0, arrayList7, null);
            }
        }
        d dVarO2 = fVar.o(d.b.RIGHT);
        if (dVarO2.d() != null) {
            Iterator it3 = dVarO2.d().iterator();
            while (it3.hasNext()) {
                a(((d) it3.next()).f10620d, 0, arrayList7, null);
            }
        }
        d dVarO3 = fVar.o(d.b.CENTER);
        if (dVarO3.d() != null) {
            Iterator it4 = dVarO3.d().iterator();
            while (it4.hasNext()) {
                a(((d) it4.next()).f10620d, 0, arrayList7, null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                a((e) it5.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a((h) it6.next(), 1, arrayList7, null);
            }
        }
        int i7 = 1;
        if (arrayList4 != null) {
            for (j jVar3 : arrayList4) {
                o oVarA2 = a(jVar3, i7, arrayList7, oVar4);
                jVar3.r1(arrayList7, i7, oVarA2);
                oVarA2.b(arrayList7);
                i7 = 1;
                oVar4 = null;
            }
        }
        d dVarO4 = fVar.o(d.b.TOP);
        if (dVarO4.d() != null) {
            Iterator it7 = dVarO4.d().iterator();
            while (it7.hasNext()) {
                a(((d) it7.next()).f10620d, 1, arrayList7, null);
            }
        }
        d dVarO5 = fVar.o(d.b.BASELINE);
        if (dVarO5.d() != null) {
            Iterator it8 = dVarO5.d().iterator();
            while (it8.hasNext()) {
                a(((d) it8.next()).f10620d, 1, arrayList7, null);
            }
        }
        d dVarO6 = fVar.o(d.b.BOTTOM);
        if (dVarO6.d() != null) {
            Iterator it9 = dVarO6.d().iterator();
            while (it9.hasNext()) {
                a(((d) it9.next()).f10620d, 1, arrayList7, null);
            }
        }
        d dVarO7 = fVar.o(d.b.CENTER);
        if (dVarO7.d() != null) {
            Iterator it10 = dVarO7.d().iterator();
            while (it10.hasNext()) {
                a(((d) it10.next()).f10620d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it11 = arrayList6.iterator();
            while (it11.hasNext()) {
                a((e) it11.next(), 1, arrayList7, null);
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            e eVar3 = (e) arrayListR1.get(i8);
            if (eVar3.s0()) {
                o oVarB = b(arrayList7, eVar3.f10655I0);
                o oVarB2 = b(arrayList7, eVar3.f10657J0);
                if (oVarB != null && oVarB2 != null) {
                    oVarB.g(0, oVarB2);
                    oVarB2.i(2);
                    arrayList7.remove(oVarB);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (fVar.A() == e.b.WRAP_CONTENT) {
            oVar = null;
            int i9 = 0;
            for (o oVar5 : arrayList7) {
                if (oVar5.d() != 1) {
                    oVar5.h(false);
                    int iF = oVar5.f(fVar.K1(), 0);
                    if (iF > i9) {
                        oVar = oVar5;
                        i9 = iF;
                    }
                }
            }
            if (oVar != null) {
                fVar.P0(e.b.FIXED);
                fVar.k1(i9);
                oVar.h(true);
            } else {
                oVar = null;
            }
        } else {
            oVar = null;
        }
        if (fVar.T() == e.b.WRAP_CONTENT) {
            o oVar6 = null;
            int i10 = 0;
            for (o oVar7 : arrayList7) {
                if (oVar7.d() != 0) {
                    oVar7.h(false);
                    int iF2 = oVar7.f(fVar.K1(), 1);
                    if (iF2 > i10) {
                        oVar6 = oVar7;
                        i10 = iF2;
                    }
                }
            }
            if (oVar6 != null) {
                fVar.g1(e.b.FIXED);
                fVar.L0(i10);
                oVar6.h(true);
                oVar2 = oVar6;
            }
            return oVar == null || oVar2 != null;
        }
        oVar2 = null;
        if (oVar == null) {
        }
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
