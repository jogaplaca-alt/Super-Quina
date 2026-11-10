package p061s;

import p058r.d;
import p058r.e;
import p058r.i;

/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f11673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f11674l;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11675a;

        static {
            int[] iArr = new int[p.b.values().length];
            f11675a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11675a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11675a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f11673k = fVar;
        this.f11674l = null;
        this.f11698h.f11642e = f.a.TOP;
        this.f11699i.f11642e = f.a.BOTTOM;
        fVar.f11642e = f.a.BASELINE;
        this.f11696f = 1;
    }

    @Override // p061s.p, p061s.d
    public void a(d dVar) {
        float f3;
        float fV;
        float fV2;
        int i3;
        int i4 = a.f11675a[this.f11700j.ordinal()];
        if (i4 == 1) {
            p(dVar);
        } else if (i4 == 2) {
            o(dVar);
        } else if (i4 == 3) {
            e eVar = this.f11692b;
            n(dVar, eVar.f10663P, eVar.f10665R, 1);
            return;
        }
        g gVar = this.f11695e;
        if (gVar.f11640c && !gVar.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT) {
            e eVar2 = this.f11692b;
            int i5 = eVar2.f10720x;
            if (i5 == 2) {
                e eVarK = eVar2.K();
                if (eVarK != null) {
                    g gVar2 = eVarK.f10684f.f11695e;
                    if (gVar2.f11647j) {
                        this.f11695e.d((int) ((gVar2.f11644g * this.f11692b.f10646E) + 0.5f));
                    }
                }
            } else if (i5 == 3 && eVar2.f10682e.f11695e.f11647j) {
                int iW = eVar2.w();
                if (iW != -1) {
                    if (iW == 0) {
                        e eVar3 = this.f11692b;
                        fV2 = eVar3.f10682e.f11695e.f11644g * eVar3.v();
                        i3 = (int) (fV2 + 0.5f);
                    } else if (iW != 1) {
                        i3 = 0;
                    } else {
                        e eVar4 = this.f11692b;
                        f3 = eVar4.f10682e.f11695e.f11644g;
                        fV = eVar4.v();
                    }
                    this.f11695e.d(i3);
                } else {
                    e eVar5 = this.f11692b;
                    f3 = eVar5.f10682e.f11695e.f11644g;
                    fV = eVar5.v();
                }
                fV2 = f3 / fV;
                i3 = (int) (fV2 + 0.5f);
                this.f11695e.d(i3);
            }
        }
        f fVar = this.f11698h;
        if (fVar.f11640c) {
            f fVar2 = this.f11699i;
            if (fVar2.f11640c) {
                if (fVar.f11647j && fVar2.f11647j && this.f11695e.f11647j) {
                    return;
                }
                if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT) {
                    e eVar6 = this.f11692b;
                    if (eVar6.f10718w == 0 && !eVar6.k0()) {
                        f fVar3 = (f) this.f11698h.f11649l.get(0);
                        f fVar4 = (f) this.f11699i.f11649l.get(0);
                        int i6 = fVar3.f11644g;
                        f fVar5 = this.f11698h;
                        int i7 = i6 + fVar5.f11643f;
                        int i8 = fVar4.f11644g + this.f11699i.f11643f;
                        fVar5.d(i7);
                        this.f11699i.d(i8);
                        this.f11695e.d(i8 - i7);
                        return;
                    }
                }
                if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT && this.f11691a == 1 && this.f11698h.f11649l.size() > 0 && this.f11699i.f11649l.size() > 0) {
                    f fVar6 = (f) this.f11698h.f11649l.get(0);
                    int i9 = (((f) this.f11699i.f11649l.get(0)).f11644g + this.f11699i.f11643f) - (fVar6.f11644g + this.f11698h.f11643f);
                    g gVar3 = this.f11695e;
                    int i10 = gVar3.f11659m;
                    if (i9 < i10) {
                        gVar3.d(i9);
                    } else {
                        gVar3.d(i10);
                    }
                }
                if (this.f11695e.f11647j && this.f11698h.f11649l.size() > 0 && this.f11699i.f11649l.size() > 0) {
                    f fVar7 = (f) this.f11698h.f11649l.get(0);
                    f fVar8 = (f) this.f11699i.f11649l.get(0);
                    int i11 = fVar7.f11644g + this.f11698h.f11643f;
                    int i12 = fVar8.f11644g + this.f11699i.f11643f;
                    float fR = this.f11692b.R();
                    if (fVar7 == fVar8) {
                        i11 = fVar7.f11644g;
                        i12 = fVar8.f11644g;
                        fR = 0.5f;
                    }
                    this.f11698h.d((int) (i11 + 0.5f + (((i12 - i11) - this.f11695e.f11644g) * fR)));
                    this.f11699i.d(this.f11698h.f11644g + this.f11695e.f11644g);
                }
            }
        }
    }

    @Override // p061s.p
    void d() {
        e eVarK;
        e eVarK2;
        e eVar = this.f11692b;
        if (eVar.f10674a) {
            this.f11695e.d(eVar.x());
        }
        if (!this.f11695e.f11647j) {
            this.f11694d = this.f11692b.T();
            if (this.f11692b.Z()) {
                this.f11674l = new p061s.a(this);
            }
            e.b bVar = this.f11694d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (eVarK2 = this.f11692b.K()) != null && eVarK2.T() == e.b.FIXED) {
                    int iX = (eVarK2.x() - this.f11692b.f10663P.f()) - this.f11692b.f10665R.f();
                    b(this.f11698h, eVarK2.f10684f.f11698h, this.f11692b.f10663P.f());
                    b(this.f11699i, eVarK2.f10684f.f11699i, -this.f11692b.f10665R.f());
                    this.f11695e.d(iX);
                    return;
                }
                if (this.f11694d == e.b.FIXED) {
                    this.f11695e.d(this.f11692b.x());
                }
            }
        } else if (this.f11694d == e.b.MATCH_PARENT && (eVarK = this.f11692b.K()) != null && eVarK.T() == e.b.FIXED) {
            b(this.f11698h, eVarK.f10684f.f11698h, this.f11692b.f10663P.f());
            b(this.f11699i, eVarK.f10684f.f11699i, -this.f11692b.f10665R.f());
            return;
        }
        g gVar = this.f11695e;
        boolean z3 = gVar.f11647j;
        if (z3) {
            e eVar2 = this.f11692b;
            if (eVar2.f10674a) {
                d[] dVarArr = eVar2.f10670W;
                d dVar = dVarArr[2];
                d dVar2 = dVar.f10622f;
                if (dVar2 != null && dVarArr[3].f10622f != null) {
                    if (eVar2.k0()) {
                        this.f11698h.f11643f = this.f11692b.f10670W[2].f();
                        this.f11699i.f11643f = -this.f11692b.f10670W[3].f();
                    } else {
                        f fVarH = h(this.f11692b.f10670W[2]);
                        if (fVarH != null) {
                            b(this.f11698h, fVarH, this.f11692b.f10670W[2].f());
                        }
                        f fVarH2 = h(this.f11692b.f10670W[3]);
                        if (fVarH2 != null) {
                            b(this.f11699i, fVarH2, -this.f11692b.f10670W[3].f());
                        }
                        this.f11698h.f11639b = true;
                        this.f11699i.f11639b = true;
                    }
                    if (this.f11692b.Z()) {
                        b(this.f11673k, this.f11698h, this.f11692b.p());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f11698h, fVarH3, this.f11692b.f10670W[2].f());
                        b(this.f11699i, this.f11698h, this.f11695e.f11644g);
                        if (this.f11692b.Z()) {
                            b(this.f11673k, this.f11698h, this.f11692b.p());
                            return;
                        }
                        return;
                    }
                    return;
                }
                d dVar3 = dVarArr[3];
                if (dVar3.f10622f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f11699i, fVarH4, -this.f11692b.f10670W[3].f());
                        b(this.f11698h, this.f11699i, -this.f11695e.f11644g);
                    }
                    if (this.f11692b.Z()) {
                        b(this.f11673k, this.f11698h, this.f11692b.p());
                        return;
                    }
                    return;
                }
                d dVar4 = dVarArr[4];
                if (dVar4.f10622f != null) {
                    f fVarH5 = h(dVar4);
                    if (fVarH5 != null) {
                        b(this.f11673k, fVarH5, 0);
                        b(this.f11698h, this.f11673k, -this.f11692b.p());
                        b(this.f11699i, this.f11698h, this.f11695e.f11644g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof i) || eVar2.K() == null || this.f11692b.o(d.b.CENTER).f10622f != null) {
                    return;
                }
                b(this.f11698h, this.f11692b.K().f10684f.f11698h, this.f11692b.Y());
                b(this.f11699i, this.f11698h, this.f11695e.f11644g);
                if (this.f11692b.Z()) {
                    b(this.f11673k, this.f11698h, this.f11692b.p());
                    return;
                }
                return;
            }
        }
        if (z3 || this.f11694d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            e eVar3 = this.f11692b;
            int i3 = eVar3.f10720x;
            if (i3 == 2) {
                e eVarK3 = eVar3.K();
                if (eVarK3 != null) {
                    g gVar2 = eVarK3.f10684f.f11695e;
                    this.f11695e.f11649l.add(gVar2);
                    gVar2.f11648k.add(this.f11695e);
                    g gVar3 = this.f11695e;
                    gVar3.f11639b = true;
                    gVar3.f11648k.add(this.f11698h);
                    this.f11695e.f11648k.add(this.f11699i);
                }
            } else if (i3 == 3 && !eVar3.k0()) {
                e eVar4 = this.f11692b;
                if (eVar4.f10718w != 3) {
                    g gVar4 = eVar4.f10682e.f11695e;
                    this.f11695e.f11649l.add(gVar4);
                    gVar4.f11648k.add(this.f11695e);
                    g gVar5 = this.f11695e;
                    gVar5.f11639b = true;
                    gVar5.f11648k.add(this.f11698h);
                    this.f11695e.f11648k.add(this.f11699i);
                }
            }
        }
        e eVar5 = this.f11692b;
        d[] dVarArr2 = eVar5.f10670W;
        d dVar5 = dVarArr2[2];
        d dVar6 = dVar5.f10622f;
        if (dVar6 != null && dVarArr2[3].f10622f != null) {
            if (eVar5.k0()) {
                this.f11698h.f11643f = this.f11692b.f10670W[2].f();
                this.f11699i.f11643f = -this.f11692b.f10670W[3].f();
            } else {
                f fVarH6 = h(this.f11692b.f10670W[2]);
                f fVarH7 = h(this.f11692b.f10670W[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f11700j = p.b.CENTER;
            }
            if (this.f11692b.Z()) {
                c(this.f11673k, this.f11698h, 1, this.f11674l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = h(dVar5);
            if (fVarH8 != null) {
                b(this.f11698h, fVarH8, this.f11692b.f10670W[2].f());
                c(this.f11699i, this.f11698h, 1, this.f11695e);
                if (this.f11692b.Z()) {
                    c(this.f11673k, this.f11698h, 1, this.f11674l);
                }
                e.b bVar2 = this.f11694d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f11692b.v() > 0.0f) {
                    l lVar = this.f11692b.f10682e;
                    if (lVar.f11694d == bVar3) {
                        lVar.f11695e.f11648k.add(this.f11695e);
                        this.f11695e.f11649l.add(this.f11692b.f10682e.f11695e);
                        this.f11695e.f11638a = this;
                    }
                }
            }
        } else {
            d dVar7 = dVarArr2[3];
            if (dVar7.f10622f != null) {
                f fVarH9 = h(dVar7);
                if (fVarH9 != null) {
                    b(this.f11699i, fVarH9, -this.f11692b.f10670W[3].f());
                    c(this.f11698h, this.f11699i, -1, this.f11695e);
                    if (this.f11692b.Z()) {
                        c(this.f11673k, this.f11698h, 1, this.f11674l);
                    }
                }
            } else {
                d dVar8 = dVarArr2[4];
                if (dVar8.f10622f != null) {
                    f fVarH10 = h(dVar8);
                    if (fVarH10 != null) {
                        b(this.f11673k, fVarH10, 0);
                        c(this.f11698h, this.f11673k, -1, this.f11674l);
                        c(this.f11699i, this.f11698h, 1, this.f11695e);
                    }
                } else if (!(eVar5 instanceof i) && eVar5.K() != null) {
                    b(this.f11698h, this.f11692b.K().f10684f.f11698h, this.f11692b.Y());
                    c(this.f11699i, this.f11698h, 1, this.f11695e);
                    if (this.f11692b.Z()) {
                        c(this.f11673k, this.f11698h, 1, this.f11674l);
                    }
                    e.b bVar4 = this.f11694d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f11692b.v() > 0.0f) {
                        l lVar2 = this.f11692b.f10682e;
                        if (lVar2.f11694d == bVar5) {
                            lVar2.f11695e.f11648k.add(this.f11695e);
                            this.f11695e.f11649l.add(this.f11692b.f10682e.f11695e);
                            this.f11695e.f11638a = this;
                        }
                    }
                }
            }
        }
        if (this.f11695e.f11649l.size() == 0) {
            this.f11695e.f11640c = true;
        }
    }

    @Override // p061s.p
    public void e() {
        f fVar = this.f11698h;
        if (fVar.f11647j) {
            this.f11692b.n1(fVar.f11644g);
        }
    }

    @Override // p061s.p
    void f() {
        this.f11693c = null;
        this.f11698h.c();
        this.f11699i.c();
        this.f11673k.c();
        this.f11695e.c();
        this.f11697g = false;
    }

    @Override // p061s.p
    boolean m() {
        return this.f11694d != e.b.MATCH_CONSTRAINT || this.f11692b.f10720x == 0;
    }

    void q() {
        this.f11697g = false;
        this.f11698h.c();
        this.f11698h.f11647j = false;
        this.f11699i.c();
        this.f11699i.f11647j = false;
        this.f11673k.c();
        this.f11673k.f11647j = false;
        this.f11695e.f11647j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f11692b.t();
    }
}
