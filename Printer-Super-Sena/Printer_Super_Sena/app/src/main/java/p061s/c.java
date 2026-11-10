package p061s;

import java.util.ArrayList;
import java.util.Iterator;
import p058r.d;
import p058r.e;
import p058r.f;

/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList f11627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11628l;

    public c(e eVar, int i3) {
        super(eVar);
        this.f11627k = new ArrayList();
        this.f11696f = i3;
        q();
    }

    private void q() {
        e eVar;
        e eVar2 = this.f11692b;
        e eVarL = eVar2.L(this.f11696f);
        while (true) {
            e eVar3 = eVarL;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarL = eVar2.L(this.f11696f);
            }
        }
        this.f11692b = eVar;
        this.f11627k.add(eVar.N(this.f11696f));
        e eVarJ = eVar.J(this.f11696f);
        while (eVarJ != null) {
            this.f11627k.add(eVarJ.N(this.f11696f));
            eVarJ = eVarJ.J(this.f11696f);
        }
        for (p pVar : this.f11627k) {
            int i3 = this.f11696f;
            if (i3 == 0) {
                pVar.f11692b.f10678c = this;
            } else if (i3 == 1) {
                pVar.f11692b.f10680d = this;
            }
        }
        if (this.f11696f == 0 && ((f) this.f11692b.K()).P1() && this.f11627k.size() > 1) {
            ArrayList arrayList = this.f11627k;
            this.f11692b = ((p) arrayList.get(arrayList.size() - 1)).f11692b;
        }
        this.f11628l = this.f11696f == 0 ? this.f11692b.z() : this.f11692b.S();
    }

    private e r() {
        for (int i3 = 0; i3 < this.f11627k.size(); i3++) {
            p pVar = (p) this.f11627k.get(i3);
            if (pVar.f11692b.V() != 8) {
                return pVar.f11692b;
            }
        }
        return null;
    }

    private e s() {
        for (int size = this.f11627k.size() - 1; size >= 0; size--) {
            p pVar = (p) this.f11627k.get(size);
            if (pVar.f11692b.V() != 8) {
                return pVar.f11692b;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:293:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    @Override // p061s.p, p061s.d
    public void a(d dVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f3;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f4;
        if (this.f11698h.f11647j && this.f11699i.f11647j) {
            e eVarK = this.f11692b.K();
            boolean zP1 = eVarK instanceof f ? ((f) eVarK).P1() : false;
            int i15 = this.f11699i.f11644g - this.f11698h.f11644g;
            int size = this.f11627k.size();
            int i16 = 0;
            while (true) {
                i3 = -1;
                i4 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (((p) this.f11627k.get(i16)).f11692b.V() != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            for (int i18 = i17; i18 >= 0; i18--) {
                if (((p) this.f11627k.get(i18)).f11692b.V() != 8) {
                    i3 = i18;
                    break;
                }
            }
            int i19 = 0;
            while (true) {
                if (i19 >= 2) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    f3 = 0.0f;
                    break;
                }
                int i20 = 0;
                i6 = 0;
                i7 = 0;
                int i21 = 0;
                f3 = 0.0f;
                while (i20 < size) {
                    p pVar = (p) this.f11627k.get(i20);
                    if (pVar.f11692b.V() != i4) {
                        i21++;
                        if (i20 > 0 && i20 >= i16) {
                            i6 += pVar.f11698h.f11643f;
                        }
                        g gVar = pVar.f11695e;
                        int i22 = gVar.f11644g;
                        boolean z4 = pVar.f11694d != e.b.MATCH_CONSTRAINT;
                        if (z4) {
                            int i23 = this.f11696f;
                            if (i23 == 0 && !pVar.f11692b.f10682e.f11695e.f11647j) {
                                return;
                            }
                            if (i23 == 1 && !pVar.f11692b.f10684f.f11695e.f11647j) {
                                return;
                            } else {
                                i13 = i22;
                            }
                        } else {
                            i13 = i22;
                            if (pVar.f11691a == 1 && i19 == 0) {
                                i14 = gVar.f11659m;
                                i7++;
                            } else {
                                if (gVar.f11647j) {
                                    i14 = i13;
                                }
                                if (z4) {
                                    i6 += i14;
                                } else {
                                    i7++;
                                    f4 = pVar.f11692b.f10645D0[this.f11696f];
                                    if (f4 >= 0.0f) {
                                        f3 += f4;
                                    }
                                }
                                if (i20 >= i17 && i20 < i3) {
                                    i6 += -pVar.f11699i.f11643f;
                                }
                            }
                            z4 = true;
                            if (z4) {
                                i7++;
                                f4 = pVar.f11692b.f10645D0[this.f11696f];
                                if (f4 >= 0.0f) {
                                    f3 += f4;
                                }
                            } else {
                                i6 += i14;
                            }
                            if (i20 >= i17) {
                            }
                        }
                        i14 = i13;
                        if (z4) {
                            i7++;
                            f4 = pVar.f11692b.f10645D0[this.f11696f];
                            if (f4 >= 0.0f) {
                                f3 += f4;
                            }
                        } else {
                            i6 += i14;
                        }
                        if (i20 >= i17) {
                        }
                    }
                    i20++;
                    i4 = 8;
                }
                if (i6 < i15 || i7 == 0) {
                    i5 = i21;
                    break;
                } else {
                    i19++;
                    i4 = 8;
                }
            }
            int i24 = this.f11698h.f11644g;
            if (zP1) {
                i24 = this.f11699i.f11644g;
            }
            if (i6 > i15) {
                i24 = zP1 ? i24 + ((int) (((i6 - i15) / 2.0f) + 0.5f)) : i24 - ((int) (((i6 - i15) / 2.0f) + 0.5f));
            }
            if (i7 > 0) {
                float f5 = i15 - i6;
                int i25 = (int) ((f5 / i7) + 0.5f);
                int i26 = 0;
                int i27 = 0;
                while (i26 < size) {
                    p pVar2 = (p) this.f11627k.get(i26);
                    int i28 = i25;
                    int i29 = i6;
                    if (pVar2.f11692b.V() != 8 && pVar2.f11694d == e.b.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f11695e;
                        if (gVar2.f11647j) {
                            zP1 = zP1;
                            i24 = i24;
                            f5 = f5;
                        } else {
                            int i30 = f3 > 0.0f ? (int) (((pVar2.f11692b.f10645D0[this.f11696f] * f5) / f3) + 0.5f) : i28;
                            if (this.f11696f == 0) {
                                e eVar = pVar2.f11692b;
                                i12 = eVar.f10638A;
                                i11 = eVar.f10724z;
                            } else {
                                e eVar2 = pVar2.f11692b;
                                int i31 = eVar2.f10644D;
                                i11 = eVar2.f10642C;
                                i12 = i31;
                            }
                            int iMax = Math.max(i11, pVar2.f11691a == 1 ? Math.min(i30, gVar2.f11659m) : i30);
                            if (i12 > 0) {
                                iMax = Math.min(i12, iMax);
                            }
                            if (iMax != i30) {
                                i27++;
                                i30 = iMax;
                            }
                            pVar2.f11695e.d(i30);
                        }
                    } else {
                        zP1 = zP1;
                        i24 = i24;
                        f5 = f5;
                    }
                    i26++;
                    i25 = i28;
                    i6 = i29;
                    i24 = i24;
                    f5 = f5;
                    zP1 = zP1;
                    i5 = i5;
                }
                z3 = zP1;
                i8 = i5;
                i9 = i24;
                int i32 = i6;
                if (i27 > 0) {
                    i7 -= i27;
                    i6 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        p pVar3 = (p) this.f11627k.get(i33);
                        if (pVar3.f11692b.V() != 8) {
                            if (i33 > 0 && i33 >= i16) {
                                i6 += pVar3.f11698h.f11643f;
                            }
                            i6 += pVar3.f11695e.f11644g;
                            if (i33 < i17 && i33 < i3) {
                                i6 += -pVar3.f11699i.f11643f;
                            }
                        }
                    }
                } else {
                    i6 = i32;
                }
                i10 = 2;
                if (this.f11628l == 2 && i27 == 0) {
                    this.f11628l = 0;
                }
            } else {
                z3 = zP1;
                i8 = i5;
                i9 = i24;
                i10 = 2;
            }
            if (i6 > i15) {
                this.f11628l = i10;
            }
            if (i8 > 0 && i7 == 0 && i16 == i3) {
                this.f11628l = i10;
            }
            int i34 = this.f11628l;
            if (i34 == 1) {
                int i35 = i8;
                int i36 = i35 > 1 ? (i15 - i6) / (i35 - 1) : i35 == 1 ? (i15 - i6) / 2 : 0;
                if (i7 > 0) {
                    i36 = 0;
                }
                int i37 = i9;
                for (int i38 = 0; i38 < size; i38++) {
                    p pVar4 = (p) this.f11627k.get(z3 ? size - (i38 + 1) : i38);
                    if (pVar4.f11692b.V() == 8) {
                        pVar4.f11698h.d(i37);
                        pVar4.f11699i.d(i37);
                    } else {
                        if (i38 > 0) {
                            i37 = z3 ? i37 - i36 : i37 + i36;
                        }
                        if (i38 > 0 && i38 >= i16) {
                            i37 = z3 ? i37 - pVar4.f11698h.f11643f : i37 + pVar4.f11698h.f11643f;
                        }
                        if (z3) {
                            pVar4.f11699i.d(i37);
                        } else {
                            pVar4.f11698h.d(i37);
                        }
                        g gVar3 = pVar4.f11695e;
                        int i39 = gVar3.f11644g;
                        if (pVar4.f11694d == e.b.MATCH_CONSTRAINT && pVar4.f11691a == 1) {
                            i39 = gVar3.f11659m;
                        }
                        i37 = z3 ? i37 - i39 : i37 + i39;
                        if (z3) {
                            pVar4.f11698h.d(i37);
                        } else {
                            pVar4.f11699i.d(i37);
                        }
                        pVar4.f11697g = true;
                        if (i38 < i17 && i38 < i3) {
                            i37 = z3 ? i37 - (-pVar4.f11699i.f11643f) : i37 + (-pVar4.f11699i.f11643f);
                        }
                    }
                }
                return;
            }
            int i40 = i8;
            if (i34 == 0) {
                int i41 = (i15 - i6) / (i40 + 1);
                if (i7 > 0) {
                    i41 = 0;
                }
                int i42 = i9;
                for (int i43 = 0; i43 < size; i43++) {
                    p pVar5 = (p) this.f11627k.get(z3 ? size - (i43 + 1) : i43);
                    if (pVar5.f11692b.V() == 8) {
                        pVar5.f11698h.d(i42);
                        pVar5.f11699i.d(i42);
                    } else {
                        int i44 = z3 ? i42 - i41 : i42 + i41;
                        if (i43 > 0 && i43 >= i16) {
                            i44 = z3 ? i44 - pVar5.f11698h.f11643f : i44 + pVar5.f11698h.f11643f;
                        }
                        if (z3) {
                            pVar5.f11699i.d(i44);
                        } else {
                            pVar5.f11698h.d(i44);
                        }
                        g gVar4 = pVar5.f11695e;
                        int iMin = gVar4.f11644g;
                        if (pVar5.f11694d == e.b.MATCH_CONSTRAINT && pVar5.f11691a == 1) {
                            iMin = Math.min(iMin, gVar4.f11659m);
                        }
                        i42 = z3 ? i44 - iMin : i44 + iMin;
                        if (z3) {
                            pVar5.f11698h.d(i42);
                        } else {
                            pVar5.f11699i.d(i42);
                        }
                        if (i43 < i17 && i43 < i3) {
                            i42 = z3 ? i42 - (-pVar5.f11699i.f11643f) : i42 + (-pVar5.f11699i.f11643f);
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float fY = this.f11696f == 0 ? this.f11692b.y() : this.f11692b.R();
                if (z3) {
                    fY = 1.0f - fY;
                }
                int i45 = (int) (((i15 - i6) * fY) + 0.5f);
                if (i45 < 0 || i7 > 0) {
                    i45 = 0;
                }
                int i46 = z3 ? i9 - i45 : i9 + i45;
                for (int i47 = 0; i47 < size; i47++) {
                    p pVar6 = (p) this.f11627k.get(z3 ? size - (i47 + 1) : i47);
                    if (pVar6.f11692b.V() == 8) {
                        pVar6.f11698h.d(i46);
                        pVar6.f11699i.d(i46);
                    } else {
                        if (i47 > 0 && i47 >= i16) {
                            i46 = z3 ? i46 - pVar6.f11698h.f11643f : i46 + pVar6.f11698h.f11643f;
                        }
                        if (z3) {
                            pVar6.f11699i.d(i46);
                        } else {
                            pVar6.f11698h.d(i46);
                        }
                        g gVar5 = pVar6.f11695e;
                        int i48 = gVar5.f11644g;
                        if (pVar6.f11694d == e.b.MATCH_CONSTRAINT && pVar6.f11691a == 1) {
                            i48 = gVar5.f11659m;
                        }
                        i46 = z3 ? i46 - i48 : i46 + i48;
                        if (z3) {
                            pVar6.f11698h.d(i46);
                        } else {
                            pVar6.f11699i.d(i46);
                        }
                        if (i47 < i17 && i47 < i3) {
                            i46 = z3 ? i46 - (-pVar6.f11699i.f11643f) : i46 + (-pVar6.f11699i.f11643f);
                        }
                    }
                }
            }
        }
    }

    @Override // p061s.p
    void d() {
        Iterator it = this.f11627k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d();
        }
        int size = this.f11627k.size();
        if (size < 1) {
            return;
        }
        e eVar = ((p) this.f11627k.get(0)).f11692b;
        e eVar2 = ((p) this.f11627k.get(size - 1)).f11692b;
        if (this.f11696f == 0) {
            d dVar = eVar.f10662O;
            d dVar2 = eVar2.f10664Q;
            f fVarI = i(dVar, 0);
            int iF = dVar.f();
            e eVarR = r();
            if (eVarR != null) {
                iF = eVarR.f10662O.f();
            }
            if (fVarI != null) {
                b(this.f11698h, fVarI, iF);
            }
            f fVarI2 = i(dVar2, 0);
            int iF2 = dVar2.f();
            e eVarS = s();
            if (eVarS != null) {
                iF2 = eVarS.f10664Q.f();
            }
            if (fVarI2 != null) {
                b(this.f11699i, fVarI2, -iF2);
            }
        } else {
            d dVar3 = eVar.f10663P;
            d dVar4 = eVar2.f10665R;
            f fVarI3 = i(dVar3, 1);
            int iF3 = dVar3.f();
            e eVarR2 = r();
            if (eVarR2 != null) {
                iF3 = eVarR2.f10663P.f();
            }
            if (fVarI3 != null) {
                b(this.f11698h, fVarI3, iF3);
            }
            f fVarI4 = i(dVar4, 1);
            int iF4 = dVar4.f();
            e eVarS2 = s();
            if (eVarS2 != null) {
                iF4 = eVarS2.f10665R.f();
            }
            if (fVarI4 != null) {
                b(this.f11699i, fVarI4, -iF4);
            }
        }
        this.f11698h.f11638a = this;
        this.f11699i.f11638a = this;
    }

    @Override // p061s.p
    public void e() {
        for (int i3 = 0; i3 < this.f11627k.size(); i3++) {
            ((p) this.f11627k.get(i3)).e();
        }
    }

    @Override // p061s.p
    void f() {
        this.f11693c = null;
        Iterator it = this.f11627k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
    }

    @Override // p061s.p
    public long j() {
        int size = this.f11627k.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) this.f11627k.get(i3);
            j3 = j3 + ((long) pVar.f11698h.f11643f) + pVar.j() + ((long) pVar.f11699i.f11643f);
        }
        return j3;
    }

    @Override // p061s.p
    boolean m() {
        int size = this.f11627k.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((p) this.f11627k.get(i3)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f11696f == 0 ? "horizontal : " : "vertical : ");
        for (p pVar : this.f11627k) {
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
