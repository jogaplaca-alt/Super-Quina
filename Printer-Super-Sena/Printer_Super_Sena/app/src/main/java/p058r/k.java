package p058r;

import p049o.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f10817a = new boolean[3];

    static void a(f fVar, d dVar, e eVar) {
        eVar.f10712t = -1;
        eVar.f10714u = -1;
        e.b bVar = fVar.f10673Z[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f10673Z[0] == e.b.MATCH_PARENT) {
            int i3 = eVar.f10662O.f10623g;
            int iW = fVar.W() - eVar.f10664Q.f10623g;
            d dVar2 = eVar.f10662O;
            dVar2.f10625i = dVar.q(dVar2);
            d dVar3 = eVar.f10664Q;
            dVar3.f10625i = dVar.q(dVar3);
            dVar.f(eVar.f10662O.f10625i, i3);
            dVar.f(eVar.f10664Q.f10625i, iW);
            eVar.f10712t = 2;
            eVar.O0(i3, iW);
        }
        if (fVar.f10673Z[1] == bVar2 || eVar.f10673Z[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i4 = eVar.f10663P.f10623g;
        int iX = fVar.x() - eVar.f10665R.f10623g;
        d dVar4 = eVar.f10663P;
        dVar4.f10625i = dVar.q(dVar4);
        d dVar5 = eVar.f10665R;
        dVar5.f10625i = dVar.q(dVar5);
        dVar.f(eVar.f10663P.f10625i, i4);
        dVar.f(eVar.f10665R.f10625i, iX);
        if (eVar.f10697l0 > 0 || eVar.V() == 8) {
            d dVar6 = eVar.f10666S;
            dVar6.f10625i = dVar.q(dVar6);
            dVar.f(eVar.f10666S.f10625i, eVar.f10697l0 + i4);
        }
        eVar.f10714u = 2;
        eVar.f1(i4, iX);
    }

    public static final boolean b(int i3, int i4) {
        return (i3 & i4) == i4;
    }
}
