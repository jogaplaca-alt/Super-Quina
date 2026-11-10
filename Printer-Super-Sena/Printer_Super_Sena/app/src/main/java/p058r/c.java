package p058r;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f10595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f10596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f10597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f10598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f10599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected e f10600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected e f10601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ArrayList f10602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f10603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f10604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f10605k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f10606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f10607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f10608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f10609o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10610p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10611q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f10612r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f10613s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f10614t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f10615u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f10616v;

    public c(e eVar, int i3, boolean z3) {
        this.f10595a = eVar;
        this.f10610p = i3;
        this.f10611q = z3;
    }

    private void b() {
        int i3 = this.f10610p * 2;
        e eVar = this.f10595a;
        this.f10609o = true;
        e eVar2 = eVar;
        boolean z3 = false;
        while (!z3) {
            this.f10603i++;
            e[] eVarArr = eVar.f10649F0;
            int i4 = this.f10610p;
            e eVar3 = null;
            eVarArr[i4] = null;
            eVar.f10647E0[i4] = null;
            if (eVar.V() != 8) {
                this.f10606l++;
                e.b bVarU = eVar.u(this.f10610p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarU != bVar) {
                    this.f10607m += eVar.E(this.f10610p);
                }
                int iF = this.f10607m + eVar.f10670W[i3].f();
                this.f10607m = iF;
                int i5 = i3 + 1;
                this.f10607m = iF + eVar.f10670W[i5].f();
                int iF2 = this.f10608n + eVar.f10670W[i3].f();
                this.f10608n = iF2;
                this.f10608n = iF2 + eVar.f10670W[i5].f();
                if (this.f10596b == null) {
                    this.f10596b = eVar;
                }
                this.f10598d = eVar;
                e.b[] bVarArr = eVar.f10673Z;
                int i6 = this.f10610p;
                if (bVarArr[i6] == bVar) {
                    int i7 = eVar.f10722y[i6];
                    if (i7 == 0 || i7 == 3 || i7 == 2) {
                        this.f10604j++;
                        float f3 = eVar.f10645D0[i6];
                        if (f3 > 0.0f) {
                            this.f10605k += f3;
                        }
                        if (c(eVar, i6)) {
                            if (f3 < 0.0f) {
                                this.f10612r = true;
                            } else {
                                this.f10613s = true;
                            }
                            if (this.f10602h == null) {
                                this.f10602h = new ArrayList();
                            }
                            this.f10602h.add(eVar);
                        }
                        if (this.f10600f == null) {
                            this.f10600f = eVar;
                        }
                        e eVar4 = this.f10601g;
                        if (eVar4 != null) {
                            eVar4.f10647E0[this.f10610p] = eVar;
                        }
                        this.f10601g = eVar;
                    }
                    if (this.f10610p == 0) {
                        if (eVar.f10718w != 0 || eVar.f10724z != 0 || eVar.f10638A != 0) {
                            this.f10609o = false;
                        }
                    } else if (eVar.f10720x != 0 || eVar.f10642C != 0 || eVar.f10644D != 0) {
                        this.f10609o = false;
                    }
                    if (eVar.f10681d0 != 0.0f) {
                        this.f10609o = false;
                        this.f10615u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f10649F0[this.f10610p] = eVar;
            }
            d dVar = eVar.f10670W[i3 + 1].f10622f;
            if (dVar != null) {
                e eVar5 = dVar.f10620d;
                d dVar2 = eVar5.f10670W[i3].f10622f;
                if (dVar2 != null && dVar2.f10620d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z3 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f10596b;
        if (eVar6 != null) {
            this.f10607m -= eVar6.f10670W[i3].f();
        }
        e eVar7 = this.f10598d;
        if (eVar7 != null) {
            this.f10607m -= eVar7.f10670W[i3 + 1].f();
        }
        this.f10597c = eVar;
        if (this.f10610p == 0 && this.f10611q) {
            this.f10599e = eVar;
        } else {
            this.f10599e = this.f10595a;
        }
        this.f10614t = this.f10613s && this.f10612r;
    }

    private static boolean c(e eVar, int i3) {
        int i4;
        return eVar.V() != 8 && eVar.f10673Z[i3] == e.b.MATCH_CONSTRAINT && ((i4 = eVar.f10722y[i3]) == 0 || i4 == 3);
    }

    public void a() {
        if (!this.f10616v) {
            b();
        }
        this.f10616v = true;
    }
}
