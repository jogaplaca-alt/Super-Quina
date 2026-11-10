package p058r;

import p049o.d;
import p049o.i;

/* JADX INFO: loaded from: classes.dex */
public class a extends j {

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    private int f10591N0 = 0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    private boolean f10592O0 = true;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    private int f10593P0 = 0;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    boolean f10594Q0 = false;

    public void A1(int i3) {
        this.f10591N0 = i3;
    }

    public void B1(int i3) {
        this.f10593P0 = i3;
    }

    @Override // p058r.e
    public void g(d dVar, boolean z3) {
        d[] dVarArr;
        boolean z4;
        int i3;
        int i4;
        int i5;
        d[] dVarArr2 = this.f10670W;
        dVarArr2[0] = this.f10662O;
        dVarArr2[2] = this.f10663P;
        dVarArr2[1] = this.f10664Q;
        dVarArr2[3] = this.f10665R;
        int i6 = 0;
        while (true) {
            dVarArr = this.f10670W;
            if (i6 >= dVarArr.length) {
                break;
            }
            d dVar2 = dVarArr[i6];
            dVar2.f10625i = dVar.q(dVar2);
            i6++;
        }
        int i7 = this.f10591N0;
        if (i7 < 0 || i7 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i7];
        if (!this.f10594Q0) {
            t1();
        }
        if (this.f10594Q0) {
            this.f10594Q0 = false;
            int i8 = this.f10591N0;
            if (i8 == 0 || i8 == 1) {
                dVar.f(this.f10662O.f10625i, this.f10685f0);
                dVar.f(this.f10664Q.f10625i, this.f10685f0);
                return;
            } else {
                if (i8 == 2 || i8 == 3) {
                    dVar.f(this.f10663P.f10625i, this.f10687g0);
                    dVar.f(this.f10665R.f10625i, this.f10687g0);
                    return;
                }
                return;
            }
        }
        int i9 = 0;
        while (true) {
            if (i9 >= this.f10816M0) {
                z4 = false;
                break;
            }
            e eVar = this.f10815L0[i9];
            if ((this.f10592O0 || eVar.h()) && ((((i4 = this.f10591N0) == 0 || i4 == 1) && eVar.A() == e.b.MATCH_CONSTRAINT && eVar.f10662O.f10622f != null && eVar.f10664Q.f10622f != null) || (((i5 = this.f10591N0) == 2 || i5 == 3) && eVar.T() == e.b.MATCH_CONSTRAINT && eVar.f10663P.f10622f != null && eVar.f10665R.f10622f != null))) {
                z4 = true;
                break;
            }
            i9++;
        }
        boolean z5 = this.f10662O.l() || this.f10664Q.l();
        boolean z6 = this.f10663P.l() || this.f10665R.l();
        int i10 = !(!z4 && (((i3 = this.f10591N0) == 0 && z5) || ((i3 == 2 && z6) || ((i3 == 1 && z5) || (i3 == 3 && z6))))) ? 4 : 5;
        for (int i11 = 0; i11 < this.f10816M0; i11++) {
            e eVar2 = this.f10815L0[i11];
            if (this.f10592O0 || eVar2.h()) {
                i iVarQ = dVar.q(eVar2.f10670W[this.f10591N0]);
                d[] dVarArr3 = eVar2.f10670W;
                int i12 = this.f10591N0;
                d dVar4 = dVarArr3[i12];
                dVar4.f10625i = iVarQ;
                d dVar5 = dVar4.f10622f;
                int i13 = (dVar5 == null || dVar5.f10620d != this) ? 0 : dVar4.f10623g;
                if (i12 == 0 || i12 == 2) {
                    dVar.i(dVar3.f10625i, iVarQ, this.f10593P0 - i13, z4);
                } else {
                    dVar.g(dVar3.f10625i, iVarQ, this.f10593P0 + i13, z4);
                }
                dVar.e(dVar3.f10625i, iVarQ, this.f10593P0 + i13, i10);
            }
        }
        int i14 = this.f10591N0;
        if (i14 == 0) {
            dVar.e(this.f10664Q.f10625i, this.f10662O.f10625i, 0, 8);
            dVar.e(this.f10662O.f10625i, this.f10675a0.f10664Q.f10625i, 0, 4);
            dVar.e(this.f10662O.f10625i, this.f10675a0.f10662O.f10625i, 0, 0);
            return;
        }
        if (i14 == 1) {
            dVar.e(this.f10662O.f10625i, this.f10664Q.f10625i, 0, 8);
            dVar.e(this.f10662O.f10625i, this.f10675a0.f10662O.f10625i, 0, 4);
            dVar.e(this.f10662O.f10625i, this.f10675a0.f10664Q.f10625i, 0, 0);
        } else if (i14 == 2) {
            dVar.e(this.f10665R.f10625i, this.f10663P.f10625i, 0, 8);
            dVar.e(this.f10663P.f10625i, this.f10675a0.f10665R.f10625i, 0, 4);
            dVar.e(this.f10663P.f10625i, this.f10675a0.f10663P.f10625i, 0, 0);
        } else if (i14 == 3) {
            dVar.e(this.f10663P.f10625i, this.f10665R.f10625i, 0, 8);
            dVar.e(this.f10663P.f10625i, this.f10675a0.f10663P.f10625i, 0, 4);
            dVar.e(this.f10663P.f10625i, this.f10675a0.f10665R.f10625i, 0, 0);
        }
    }

    @Override // p058r.e
    public boolean h() {
        return true;
    }

    @Override // p058r.e
    public boolean n0() {
        return this.f10594Q0;
    }

    @Override // p058r.e
    public boolean o0() {
        return this.f10594Q0;
    }

    public boolean t1() {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        boolean z3 = true;
        while (true) {
            i3 = this.f10816M0;
            if (i6 >= i3) {
                break;
            }
            e eVar = this.f10815L0[i6];
            if ((this.f10592O0 || eVar.h()) && ((((i4 = this.f10591N0) == 0 || i4 == 1) && !eVar.n0()) || (((i5 = this.f10591N0) == 2 || i5 == 3) && !eVar.o0()))) {
                z3 = false;
            }
            i6++;
        }
        if (!z3 || i3 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z4 = false;
        for (int i7 = 0; i7 < this.f10816M0; i7++) {
            e eVar2 = this.f10815L0[i7];
            if (this.f10592O0 || eVar2.h()) {
                if (!z4) {
                    int i8 = this.f10591N0;
                    if (i8 == 0) {
                        iMax = eVar2.o(d.b.LEFT).e();
                    } else if (i8 == 1) {
                        iMax = eVar2.o(d.b.RIGHT).e();
                    } else if (i8 == 2) {
                        iMax = eVar2.o(d.b.TOP).e();
                    } else if (i8 == 3) {
                        iMax = eVar2.o(d.b.BOTTOM).e();
                    }
                    z4 = true;
                }
                int i9 = this.f10591N0;
                if (i9 == 0) {
                    iMax = Math.min(iMax, eVar2.o(d.b.LEFT).e());
                } else if (i9 == 1) {
                    iMax = Math.max(iMax, eVar2.o(d.b.RIGHT).e());
                } else if (i9 == 2) {
                    iMax = Math.min(iMax, eVar2.o(d.b.TOP).e());
                } else if (i9 == 3) {
                    iMax = Math.max(iMax, eVar2.o(d.b.BOTTOM).e());
                }
            }
        }
        int i10 = iMax + this.f10593P0;
        int i11 = this.f10591N0;
        if (i11 == 0 || i11 == 1) {
            F0(i10, i10);
        } else {
            I0(i10, i10);
        }
        this.f10594Q0 = true;
        return true;
    }

    @Override // p058r.e
    public String toString() {
        String str = "[Barrier] " + t() + " {";
        for (int i3 = 0; i3 < this.f10816M0; i3++) {
            e eVar = this.f10815L0[i3];
            if (i3 > 0) {
                str = str + ", ";
            }
            str = str + eVar.t();
        }
        return str + "}";
    }

    public boolean u1() {
        return this.f10592O0;
    }

    public int v1() {
        return this.f10591N0;
    }

    public int w1() {
        return this.f10593P0;
    }

    public int x1() {
        int i3 = this.f10591N0;
        if (i3 == 0 || i3 == 1) {
            return 0;
        }
        return (i3 == 2 || i3 == 3) ? 1 : -1;
    }

    protected void y1() {
        for (int i3 = 0; i3 < this.f10816M0; i3++) {
            e eVar = this.f10815L0[i3];
            if (this.f10592O0 || eVar.h()) {
                int i4 = this.f10591N0;
                if (i4 == 0 || i4 == 1) {
                    eVar.S0(0, true);
                } else if (i4 == 2 || i4 == 3) {
                    eVar.S0(1, true);
                }
            }
        }
    }

    public void z1(boolean z3) {
        this.f10592O0 = z3;
    }
}
