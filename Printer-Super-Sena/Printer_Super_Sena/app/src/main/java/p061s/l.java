package p061s;

import p058r.d;
import p058r.e;
import p058r.i;

/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f11663k = new int[2];

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11664a;

        static {
            int[] iArr = new int[p.b.values().length];
            f11664a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11664a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11664a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(e eVar) {
        super(eVar);
        this.f11698h.f11642e = f.a.LEFT;
        this.f11699i.f11642e = f.a.RIGHT;
        this.f11696f = 0;
    }

    private void q(int[] iArr, int i3, int i4, int i5, int i6, float f3, int i7) {
        int i8 = i4 - i3;
        int i9 = i6 - i5;
        if (i7 != -1) {
            if (i7 == 0) {
                iArr[0] = (int) ((i9 * f3) + 0.5f);
                iArr[1] = i9;
                return;
            } else {
                if (i7 != 1) {
                    return;
                }
                iArr[0] = i8;
                iArr[1] = (int) ((i8 * f3) + 0.5f);
                return;
            }
        }
        int i10 = (int) ((i9 * f3) + 0.5f);
        int i11 = (int) ((i8 / f3) + 0.5f);
        if (i10 <= i8) {
            iArr[0] = i10;
            iArr[1] = i9;
        } else if (i11 <= i9) {
            iArr[0] = i8;
            iArr[1] = i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:127:0x02f2  */
    @Override // p061s.p, p061s.d
    public void a(d dVar) {
        int iG;
        int i3;
        int iG2;
        float f3;
        float fV;
        float fV2;
        int i4;
        int i5 = a.f11664a[this.f11700j.ordinal()];
        if (i5 == 1) {
            p(dVar);
        } else if (i5 == 2) {
            o(dVar);
        } else if (i5 == 3) {
            e eVar = this.f11692b;
            n(dVar, eVar.f10662O, eVar.f10664Q, 0);
            return;
        }
        if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT) {
            e eVar2 = this.f11692b;
            int i6 = eVar2.f10718w;
            if (i6 == 2) {
                e eVarK = eVar2.K();
                if (eVarK != null) {
                    g gVar = eVarK.f10682e.f11695e;
                    if (gVar.f11647j) {
                        this.f11695e.d((int) ((gVar.f11644g * this.f11692b.f10640B) + 0.5f));
                    }
                }
            } else if (i6 == 3) {
                int i7 = eVar2.f10720x;
                if (i7 == 0 || i7 == 3) {
                    n nVar = eVar2.f10684f;
                    f fVar = nVar.f11698h;
                    f fVar2 = nVar.f11699i;
                    boolean z3 = eVar2.f10662O.f10622f != null;
                    boolean z4 = eVar2.f10663P.f10622f != null;
                    boolean z5 = eVar2.f10664Q.f10622f != null;
                    boolean z6 = eVar2.f10665R.f10622f != null;
                    int iW = eVar2.w();
                    if (z3 && z4 && z5 && z6) {
                        float fV3 = this.f11692b.v();
                        if (fVar.f11647j && fVar2.f11647j) {
                            f fVar3 = this.f11698h;
                            if (fVar3.f11640c && this.f11699i.f11640c) {
                                q(f11663k, ((f) fVar3.f11649l.get(0)).f11644g + this.f11698h.f11643f, ((f) this.f11699i.f11649l.get(0)).f11644g - this.f11699i.f11643f, fVar.f11644g + fVar.f11643f, fVar2.f11644g - fVar2.f11643f, fV3, iW);
                                this.f11695e.d(f11663k[0]);
                                this.f11692b.f10684f.f11695e.d(f11663k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f11698h;
                        if (fVar4.f11647j) {
                            f fVar5 = this.f11699i;
                            if (fVar5.f11647j) {
                                if (!fVar.f11640c || !fVar2.f11640c) {
                                    return;
                                }
                                q(f11663k, fVar4.f11644g + fVar4.f11643f, fVar5.f11644g - fVar5.f11643f, ((f) fVar.f11649l.get(0)).f11644g + fVar.f11643f, ((f) fVar2.f11649l.get(0)).f11644g - fVar2.f11643f, fV3, iW);
                                this.f11695e.d(f11663k[0]);
                                this.f11692b.f10684f.f11695e.d(f11663k[1]);
                            }
                        }
                        f fVar6 = this.f11698h;
                        if (!fVar6.f11640c || !this.f11699i.f11640c || !fVar.f11640c || !fVar2.f11640c) {
                            return;
                        }
                        q(f11663k, ((f) fVar6.f11649l.get(0)).f11644g + this.f11698h.f11643f, ((f) this.f11699i.f11649l.get(0)).f11644g - this.f11699i.f11643f, ((f) fVar.f11649l.get(0)).f11644g + fVar.f11643f, ((f) fVar2.f11649l.get(0)).f11644g - fVar2.f11643f, fV3, iW);
                        this.f11695e.d(f11663k[0]);
                        this.f11692b.f10684f.f11695e.d(f11663k[1]);
                    } else if (z3 && z5) {
                        if (!this.f11698h.f11640c || !this.f11699i.f11640c) {
                            return;
                        }
                        float fV4 = this.f11692b.v();
                        int i8 = ((f) this.f11698h.f11649l.get(0)).f11644g + this.f11698h.f11643f;
                        int i9 = ((f) this.f11699i.f11649l.get(0)).f11644g - this.f11699i.f11643f;
                        if (iW == -1 || iW == 0) {
                            int iG3 = g(i9 - i8, 0);
                            int i10 = (int) ((iG3 * fV4) + 0.5f);
                            int iG4 = g(i10, 1);
                            if (i10 != iG4) {
                                iG3 = (int) ((iG4 / fV4) + 0.5f);
                            }
                            this.f11695e.d(iG3);
                            this.f11692b.f10684f.f11695e.d(iG4);
                        } else if (iW == 1) {
                            int iG5 = g(i9 - i8, 0);
                            int i11 = (int) ((iG5 / fV4) + 0.5f);
                            int iG6 = g(i11, 1);
                            if (i11 != iG6) {
                                iG5 = (int) ((iG6 * fV4) + 0.5f);
                            }
                            this.f11695e.d(iG5);
                            this.f11692b.f10684f.f11695e.d(iG6);
                        }
                    } else if (z4 && z6) {
                        if (!fVar.f11640c || !fVar2.f11640c) {
                            return;
                        }
                        float fV5 = this.f11692b.v();
                        int i12 = ((f) fVar.f11649l.get(0)).f11644g + fVar.f11643f;
                        int i13 = ((f) fVar2.f11649l.get(0)).f11644g - fVar2.f11643f;
                        if (iW == -1) {
                            iG = g(i13 - i12, 1);
                            i3 = (int) ((iG / fV5) + 0.5f);
                            iG2 = g(i3, 0);
                            if (i3 != iG2) {
                                iG = (int) ((iG2 * fV5) + 0.5f);
                            }
                            this.f11695e.d(iG2);
                            this.f11692b.f10684f.f11695e.d(iG);
                        } else if (iW == 0) {
                            int iG7 = g(i13 - i12, 1);
                            int i14 = (int) ((iG7 * fV5) + 0.5f);
                            int iG8 = g(i14, 0);
                            if (i14 != iG8) {
                                iG7 = (int) ((iG8 / fV5) + 0.5f);
                            }
                            this.f11695e.d(iG8);
                            this.f11692b.f10684f.f11695e.d(iG7);
                        } else if (iW == 1) {
                            iG = g(i13 - i12, 1);
                            i3 = (int) ((iG / fV5) + 0.5f);
                            iG2 = g(i3, 0);
                            if (i3 != iG2) {
                                iG = (int) ((iG2 * fV5) + 0.5f);
                            }
                            this.f11695e.d(iG2);
                            this.f11692b.f10684f.f11695e.d(iG);
                        }
                    }
                } else {
                    int iW2 = eVar2.w();
                    if (iW2 != -1) {
                        if (iW2 == 0) {
                            e eVar3 = this.f11692b;
                            fV2 = eVar3.f10684f.f11695e.f11644g / eVar3.v();
                            i4 = (int) (fV2 + 0.5f);
                        } else if (iW2 != 1) {
                            i4 = 0;
                        } else {
                            e eVar4 = this.f11692b;
                            f3 = eVar4.f10684f.f11695e.f11644g;
                            fV = eVar4.v();
                        }
                        this.f11695e.d(i4);
                    } else {
                        e eVar5 = this.f11692b;
                        f3 = eVar5.f10684f.f11695e.f11644g;
                        fV = eVar5.v();
                    }
                    fV2 = f3 * fV;
                    i4 = (int) (fV2 + 0.5f);
                    this.f11695e.d(i4);
                }
            }
        }
        f fVar7 = this.f11698h;
        if (fVar7.f11640c) {
            f fVar8 = this.f11699i;
            if (fVar8.f11640c) {
                if (fVar7.f11647j && fVar8.f11647j && this.f11695e.f11647j) {
                    return;
                }
                if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT) {
                    e eVar6 = this.f11692b;
                    if (eVar6.f10718w == 0 && !eVar6.i0()) {
                        f fVar9 = (f) this.f11698h.f11649l.get(0);
                        f fVar10 = (f) this.f11699i.f11649l.get(0);
                        int i15 = fVar9.f11644g;
                        f fVar11 = this.f11698h;
                        int i16 = i15 + fVar11.f11643f;
                        int i17 = fVar10.f11644g + this.f11699i.f11643f;
                        fVar11.d(i16);
                        this.f11699i.d(i17);
                        this.f11695e.d(i17 - i16);
                        return;
                    }
                }
                if (!this.f11695e.f11647j && this.f11694d == e.b.MATCH_CONSTRAINT && this.f11691a == 1 && this.f11698h.f11649l.size() > 0 && this.f11699i.f11649l.size() > 0) {
                    int iMin = Math.min((((f) this.f11699i.f11649l.get(0)).f11644g + this.f11699i.f11643f) - (((f) this.f11698h.f11649l.get(0)).f11644g + this.f11698h.f11643f), this.f11695e.f11659m);
                    e eVar7 = this.f11692b;
                    int i18 = eVar7.f10638A;
                    int iMax = Math.max(eVar7.f10724z, iMin);
                    if (i18 > 0) {
                        iMax = Math.min(i18, iMax);
                    }
                    this.f11695e.d(iMax);
                }
                if (this.f11695e.f11647j) {
                    f fVar12 = (f) this.f11698h.f11649l.get(0);
                    f fVar13 = (f) this.f11699i.f11649l.get(0);
                    int i19 = fVar12.f11644g + this.f11698h.f11643f;
                    int i20 = fVar13.f11644g + this.f11699i.f11643f;
                    float fY = this.f11692b.y();
                    if (fVar12 == fVar13) {
                        i19 = fVar12.f11644g;
                        i20 = fVar13.f11644g;
                        fY = 0.5f;
                    }
                    this.f11698h.d((int) (i19 + 0.5f + (((i20 - i19) - this.f11695e.f11644g) * fY)));
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
            this.f11695e.d(eVar.W());
        }
        if (this.f11695e.f11647j) {
            e.b bVar = this.f11694d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (eVarK = this.f11692b.K()) != null && (eVarK.A() == e.b.FIXED || eVarK.A() == bVar2)) {
                b(this.f11698h, eVarK.f10682e.f11698h, this.f11692b.f10662O.f());
                b(this.f11699i, eVarK.f10682e.f11699i, -this.f11692b.f10664Q.f());
                return;
            }
        } else {
            e.b bVarA = this.f11692b.A();
            this.f11694d = bVarA;
            if (bVarA != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (bVarA == bVar3 && (eVarK2 = this.f11692b.K()) != null && (eVarK2.A() == e.b.FIXED || eVarK2.A() == bVar3)) {
                    int iW = (eVarK2.W() - this.f11692b.f10662O.f()) - this.f11692b.f10664Q.f();
                    b(this.f11698h, eVarK2.f10682e.f11698h, this.f11692b.f10662O.f());
                    b(this.f11699i, eVarK2.f10682e.f11699i, -this.f11692b.f10664Q.f());
                    this.f11695e.d(iW);
                    return;
                }
                if (this.f11694d == e.b.FIXED) {
                    this.f11695e.d(this.f11692b.W());
                }
            }
        }
        g gVar = this.f11695e;
        if (gVar.f11647j) {
            e eVar2 = this.f11692b;
            if (eVar2.f10674a) {
                d[] dVarArr = eVar2.f10670W;
                d dVar = dVarArr[0];
                d dVar2 = dVar.f10622f;
                if (dVar2 != null && dVarArr[1].f10622f != null) {
                    if (eVar2.i0()) {
                        this.f11698h.f11643f = this.f11692b.f10670W[0].f();
                        this.f11699i.f11643f = -this.f11692b.f10670W[1].f();
                        return;
                    }
                    f fVarH = h(this.f11692b.f10670W[0]);
                    if (fVarH != null) {
                        b(this.f11698h, fVarH, this.f11692b.f10670W[0].f());
                    }
                    f fVarH2 = h(this.f11692b.f10670W[1]);
                    if (fVarH2 != null) {
                        b(this.f11699i, fVarH2, -this.f11692b.f10670W[1].f());
                    }
                    this.f11698h.f11639b = true;
                    this.f11699i.f11639b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f11698h, fVarH3, this.f11692b.f10670W[0].f());
                        b(this.f11699i, this.f11698h, this.f11695e.f11644g);
                        return;
                    }
                    return;
                }
                d dVar3 = dVarArr[1];
                if (dVar3.f10622f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f11699i, fVarH4, -this.f11692b.f10670W[1].f());
                        b(this.f11698h, this.f11699i, -this.f11695e.f11644g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof i) || eVar2.K() == null || this.f11692b.o(d.b.CENTER).f10622f != null) {
                    return;
                }
                b(this.f11698h, this.f11692b.K().f10682e.f11698h, this.f11692b.X());
                b(this.f11699i, this.f11698h, this.f11695e.f11644g);
                return;
            }
        }
        if (this.f11694d == e.b.MATCH_CONSTRAINT) {
            e eVar3 = this.f11692b;
            int i3 = eVar3.f10718w;
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
            } else if (i3 == 3) {
                if (eVar3.f10720x == 3) {
                    this.f11698h.f11638a = this;
                    this.f11699i.f11638a = this;
                    n nVar = eVar3.f10684f;
                    nVar.f11698h.f11638a = this;
                    nVar.f11699i.f11638a = this;
                    gVar.f11638a = this;
                    if (eVar3.k0()) {
                        this.f11695e.f11649l.add(this.f11692b.f10684f.f11695e);
                        this.f11692b.f10684f.f11695e.f11648k.add(this.f11695e);
                        n nVar2 = this.f11692b.f10684f;
                        nVar2.f11695e.f11638a = this;
                        this.f11695e.f11649l.add(nVar2.f11698h);
                        this.f11695e.f11649l.add(this.f11692b.f10684f.f11699i);
                        this.f11692b.f10684f.f11698h.f11648k.add(this.f11695e);
                        this.f11692b.f10684f.f11699i.f11648k.add(this.f11695e);
                    } else if (this.f11692b.i0()) {
                        this.f11692b.f10684f.f11695e.f11649l.add(this.f11695e);
                        this.f11695e.f11648k.add(this.f11692b.f10684f.f11695e);
                    } else {
                        this.f11692b.f10684f.f11695e.f11649l.add(this.f11695e);
                    }
                } else {
                    g gVar4 = eVar3.f10684f.f11695e;
                    gVar.f11649l.add(gVar4);
                    gVar4.f11648k.add(this.f11695e);
                    this.f11692b.f10684f.f11698h.f11648k.add(this.f11695e);
                    this.f11692b.f10684f.f11699i.f11648k.add(this.f11695e);
                    g gVar5 = this.f11695e;
                    gVar5.f11639b = true;
                    gVar5.f11648k.add(this.f11698h);
                    this.f11695e.f11648k.add(this.f11699i);
                    this.f11698h.f11649l.add(this.f11695e);
                    this.f11699i.f11649l.add(this.f11695e);
                }
            }
        }
        e eVar4 = this.f11692b;
        d[] dVarArr2 = eVar4.f10670W;
        d dVar4 = dVarArr2[0];
        d dVar5 = dVar4.f10622f;
        if (dVar5 != null && dVarArr2[1].f10622f != null) {
            if (eVar4.i0()) {
                this.f11698h.f11643f = this.f11692b.f10670W[0].f();
                this.f11699i.f11643f = -this.f11692b.f10670W[1].f();
                return;
            }
            f fVarH5 = h(this.f11692b.f10670W[0]);
            f fVarH6 = h(this.f11692b.f10670W[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f11700j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = h(dVar4);
            if (fVarH7 != null) {
                b(this.f11698h, fVarH7, this.f11692b.f10670W[0].f());
                c(this.f11699i, this.f11698h, 1, this.f11695e);
                return;
            }
            return;
        }
        d dVar6 = dVarArr2[1];
        if (dVar6.f10622f != null) {
            f fVarH8 = h(dVar6);
            if (fVarH8 != null) {
                b(this.f11699i, fVarH8, -this.f11692b.f10670W[1].f());
                c(this.f11698h, this.f11699i, -1, this.f11695e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof i) || eVar4.K() == null) {
            return;
        }
        b(this.f11698h, this.f11692b.K().f10682e.f11698h, this.f11692b.X());
        c(this.f11699i, this.f11698h, 1, this.f11695e);
    }

    @Override // p061s.p
    public void e() {
        f fVar = this.f11698h;
        if (fVar.f11647j) {
            this.f11692b.m1(fVar.f11644g);
        }
    }

    @Override // p061s.p
    void f() {
        this.f11693c = null;
        this.f11698h.c();
        this.f11699i.c();
        this.f11695e.c();
        this.f11697g = false;
    }

    @Override // p061s.p
    boolean m() {
        return this.f11694d != e.b.MATCH_CONSTRAINT || this.f11692b.f10718w == 0;
    }

    void r() {
        this.f11697g = false;
        this.f11698h.c();
        this.f11698h.f11647j = false;
        this.f11699i.c();
        this.f11699i.f11647j = false;
        this.f11695e.f11647j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f11692b.t();
    }
}
