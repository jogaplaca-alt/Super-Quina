package p058r;

import java.util.ArrayList;
import p049o.d;
import p049o.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    /* JADX WARN: Code duplicated, block: B:100:0x016d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0173  */
    /* JADX WARN: Code duplicated, block: B:104:0x0194  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[PHI: r8 r16
      0x0033: PHI (r8v39 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[PHI: r8 r16
      0x0035: PHI (r8v3 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:202:0x034e  */
    /* JADX WARN: Code duplicated, block: B:222:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:323:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [o.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [o.i] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [r.e] */
    static void a(f fVar, d dVar, int i3, int i4, c cVar) {
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj;
        int i5;
        d dVar2;
        i iVar;
        i iVar2;
        d dVar3;
        i iVar3;
        ?? r5;
        i iVar4;
        int size;
        d dVar4;
        int i6;
        int i7 = i3;
        e eVar = cVar.f10595a;
        e eVar2 = cVar.f10597c;
        e eVar3 = cVar.f10596b;
        e eVar4 = cVar.f10598d;
        e eVar5 = cVar.f10599e;
        float f3 = cVar.f10605k;
        boolean z6 = fVar.f10673Z[i7] == e.b.WRAP_CONTENT;
        if (i7 == 0) {
            int i8 = eVar5.f10725z0;
            z3 = i8 == 0;
            z4 = i8 == 1;
            if (i8 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            int i9 = eVar5.f10639A0;
            z3 = i9 == 0;
            z4 = i9 == 1;
            if (i9 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        boolean z7 = z4;
        boolean z8 = false;
        boolean z9 = z3;
        ?? r8 = eVar;
        while (true) {
            obj = null;
            if (z8) {
                break;
            }
            d dVar5 = r8.f10670W[i4];
            int i10 = z5 ? 1 : 4;
            int iF = dVar5.f();
            e.b bVar = r8.f10673Z[i7];
            float f4 = f3;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            boolean z10 = bVar == bVar2 && r8.f10722y[i7] == 0;
            d dVar6 = dVar5.f10622f;
            if (dVar6 != null && r8 != eVar) {
                iF += dVar6.f();
            }
            int i11 = iF;
            if (z5 && r8 != eVar && r8 != eVar3) {
                i10 = 8;
            }
            d dVar7 = dVar5.f10622f;
            if (dVar7 != null) {
                if (r8 == eVar3) {
                    dVar.h(dVar5.f10625i, dVar7.f10625i, i11, 6);
                } else {
                    dVar.h(dVar5.f10625i, dVar7.f10625i, i11, 8);
                }
                if (z10 && !z5) {
                    i10 = 5;
                }
                dVar.e(dVar5.f10625i, dVar5.f10622f.f10625i, i11, (r8 == eVar3 && z5 && r8.h0(i7)) ? 5 : i10);
            } else {
                eVar = eVar;
            }
            if (z6) {
                if (r8.V() == 8 || r8.f10673Z[i7] != bVar2) {
                    i6 = 0;
                } else {
                    d[] dVarArr = r8.f10670W;
                    i6 = 0;
                    dVar.h(dVarArr[i4 + 1].f10625i, dVarArr[i4].f10625i, 0, 5);
                }
                dVar.h(r8.f10670W[i4].f10625i, fVar.f10670W[i4].f10625i, i6, 8);
            }
            d dVar8 = r8.f10670W[i4 + 1].f10622f;
            if (dVar8 != null) {
                e eVar6 = dVar8.f10620d;
                d dVar9 = eVar6.f10670W[i4].f10622f;
                if (dVar9 != null && dVar9.f10620d == r8) {
                    obj = eVar6;
                }
            }
            if (obj != null) {
                r8 = obj;
                z8 = z8;
            } else {
                z8 = true;
            }
            eVar5 = eVar5;
            f3 = f4;
            eVar = eVar;
            r8 = r8;
        }
        e eVar7 = eVar5;
        float f5 = f3;
        e eVar8 = eVar;
        if (eVar4 != null) {
            int i12 = i4 + 1;
            if (eVar2.f10670W[i12].f10622f != null) {
                d dVar10 = eVar4.f10670W[i12];
                if (eVar4.f10673Z[i7] == e.b.MATCH_CONSTRAINT && eVar4.f10722y[i7] == 0 && !z5) {
                    d dVar11 = dVar10.f10622f;
                    if (dVar11.f10620d == fVar) {
                        dVar.e(dVar10.f10625i, dVar11.f10625i, -dVar10.f(), 5);
                    } else if (z5) {
                        dVar4 = dVar10.f10622f;
                        if (dVar4.f10620d == fVar) {
                            dVar.e(dVar10.f10625i, dVar4.f10625i, -dVar10.f(), 4);
                        }
                    }
                } else if (z5) {
                    dVar4 = dVar10.f10622f;
                    if (dVar4.f10620d == fVar) {
                        dVar.e(dVar10.f10625i, dVar4.f10625i, -dVar10.f(), 4);
                    }
                }
                dVar.j(dVar10.f10625i, eVar2.f10670W[i12].f10622f.f10625i, -dVar10.f(), 6);
            }
        }
        if (z6) {
            int i13 = i4 + 1;
            i iVar5 = fVar.f10670W[i13].f10625i;
            d dVar12 = eVar2.f10670W[i13];
            dVar.h(iVar5, dVar12.f10625i, dVar12.f(), 8);
        }
        ArrayList arrayList = cVar.f10602h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f6 = (!cVar.f10612r || cVar.f10614t) ? f5 : cVar.f10604j;
            float f7 = 0.0f;
            e eVar9 = null;
            int i14 = 0;
            float f8 = 0.0f;
            while (i14 < size) {
                e eVar10 = (e) arrayList.get(i14);
                float f9 = eVar10.f10645D0[i7];
                if (f9 < f7) {
                    if (cVar.f10614t) {
                        d[] dVarArr2 = eVar10.f10670W;
                        dVar.e(dVarArr2[i4 + 1].f10625i, dVarArr2[i4].f10625i, 0, 4);
                    } else {
                        f9 = 1.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i14++;
                    size = size;
                    arrayList = arrayList;
                    f7 = 0.0f;
                }
                if (f9 == 0.0f) {
                    d[] dVarArr3 = eVar10.f10670W;
                    dVar.e(dVarArr3[i4 + 1].f10625i, dVarArr3[i4].f10625i, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (eVar9 != null) {
                        d[] dVarArr4 = eVar9.f10670W;
                        i iVar6 = dVarArr4[i4].f10625i;
                        int i15 = i4 + 1;
                        i iVar7 = dVarArr4[i15].f10625i;
                        d[] dVarArr5 = eVar10.f10670W;
                        i iVar8 = dVarArr5[i4].f10625i;
                        i iVar9 = dVarArr5[i15].f10625i;
                        p049o.b bVarR = dVar.r();
                        bVarR.l(f8, f6, f9, iVar6, iVar7, iVar8, iVar9);
                        dVar.d(bVarR);
                    }
                    eVar9 = eVar10;
                    f8 = f9;
                }
                i14++;
                size = size;
                arrayList = arrayList;
                f7 = 0.0f;
            }
        }
        if (eVar3 != null && (eVar3 == eVar4 || z5)) {
            d dVar13 = eVar8.f10670W[i4];
            int i16 = i4 + 1;
            d dVar14 = eVar2.f10670W[i16];
            d dVar15 = dVar13.f10622f;
            i iVar10 = dVar15 != null ? dVar15.f10625i : null;
            d dVar16 = dVar14.f10622f;
            i iVar11 = dVar16 != null ? dVar16.f10625i : null;
            d dVar17 = eVar3.f10670W[i4];
            if (eVar4 != null) {
                dVar14 = eVar4.f10670W[i16];
            }
            if (iVar10 != null && iVar11 != null) {
                dVar.c(dVar17.f10625i, iVar10, dVar17.f(), i7 == 0 ? eVar7.f10703o0 : eVar7.f10705p0, iVar11, dVar14.f10625i, dVar14.f(), 7);
            }
        } else if (!z9 || eVar3 == null) {
            int i17 = 8;
            if (z7 && eVar3 != null) {
                int i18 = cVar.f10604j;
                boolean z11 = i18 > 0 && cVar.f10603i == i18;
                e eVar11 = eVar3;
                e eVar12 = eVar11;
                while (eVar12 != null) {
                    e eVar13 = eVar12.f10649F0[i7];
                    while (eVar13 != null && eVar13.V() == i17) {
                        eVar13 = eVar13.f10649F0[i7];
                    }
                    if (eVar12 == eVar3 || eVar12 == eVar4 || eVar13 == null) {
                        eVar11 = eVar11;
                        i5 = 8;
                    } else {
                        e eVar14 = eVar13 == eVar4 ? null : eVar13;
                        d dVar18 = eVar12.f10670W[i4];
                        i iVar12 = dVar18.f10625i;
                        d dVar19 = dVar18.f10622f;
                        if (dVar19 != null) {
                            i iVar13 = dVar19.f10625i;
                        }
                        int i19 = i4 + 1;
                        i iVar14 = eVar11.f10670W[i19].f10625i;
                        int iF2 = dVar18.f();
                        int iF3 = eVar12.f10670W[i19].f();
                        if (eVar14 != null) {
                            dVar2 = eVar14.f10670W[i4];
                            i iVar15 = dVar2.f10625i;
                            d dVar20 = dVar2.f10622f;
                            iVar2 = dVar20 != null ? dVar20.f10625i : null;
                            iVar = iVar15;
                        } else {
                            dVar2 = eVar4.f10670W[i4];
                            iVar = dVar2 != null ? dVar2.f10625i : null;
                            iVar2 = eVar12.f10670W[i19].f10625i;
                        }
                        if (dVar2 != null) {
                            iF3 += dVar2.f();
                        }
                        int i20 = iF3;
                        int iF4 = eVar11.f10670W[i19].f() + iF2;
                        int i21 = z11 ? 8 : 4;
                        if (iVar12 == null || iVar14 == null || iVar == null || iVar2 == null) {
                            i5 = 8;
                        } else {
                            i5 = 8;
                            dVar.c(iVar12, iVar14, iF4, 0.5f, iVar, iVar2, i20, i21);
                        }
                        eVar13 = eVar14;
                    }
                    eVar11 = eVar12.V() != i5 ? eVar12 : eVar11;
                    i7 = i3;
                    eVar12 = eVar13;
                    i17 = 8;
                }
                d dVar21 = eVar3.f10670W[i4];
                d dVar22 = eVar8.f10670W[i4].f10622f;
                int i22 = i4 + 1;
                d dVar23 = eVar4.f10670W[i22];
                d dVar24 = eVar2.f10670W[i22].f10622f;
                if (dVar22 != null) {
                    if (eVar3 != eVar4) {
                        dVar.e(dVar21.f10625i, dVar22.f10625i, dVar21.f(), 5);
                    } else if (dVar24 != null) {
                        dVar.c(dVar21.f10625i, dVar22.f10625i, dVar21.f(), 0.5f, dVar23.f10625i, dVar24.f10625i, dVar23.f(), 5);
                    }
                }
                if (dVar24 != null && eVar3 != eVar4) {
                    dVar.e(dVar23.f10625i, dVar24.f10625i, -dVar23.f(), 5);
                }
            }
        } else {
            int i23 = cVar.f10604j;
            boolean z12 = i23 > 0 && cVar.f10603i == i23;
            e eVar15 = eVar3;
            e eVar16 = eVar15;
            while (eVar16 != null) {
                e eVar17 = eVar16.f10649F0[i7];
                while (eVar17 != null && eVar17.V() == 8) {
                    eVar17 = eVar17.f10649F0[i7];
                }
                if (eVar17 != null || eVar16 == eVar4) {
                    d dVar25 = eVar16.f10670W[i4];
                    i iVar16 = dVar25.f10625i;
                    d dVar26 = dVar25.f10622f;
                    i iVar17 = dVar26 != null ? dVar26.f10625i : null;
                    if (eVar15 != eVar16) {
                        iVar17 = eVar15.f10670W[i4 + 1].f10625i;
                    } else if (eVar16 == eVar3) {
                        d dVar27 = eVar8.f10670W[i4].f10622f;
                        iVar17 = dVar27 != null ? dVar27.f10625i : null;
                    }
                    int iF5 = dVar25.f();
                    int i24 = i4 + 1;
                    int iF6 = eVar16.f10670W[i24].f();
                    if (eVar17 != null) {
                        dVar3 = eVar17.f10670W[i4];
                        iVar3 = dVar3.f10625i;
                    } else {
                        dVar3 = eVar2.f10670W[i24].f10622f;
                        if (dVar3 != null) {
                            iVar3 = dVar3.f10625i;
                        } else {
                            iVar3 = null;
                        }
                        i iVar18 = eVar16.f10670W[i24].f10625i;
                        if (dVar3 != null) {
                            iF6 += dVar3.f();
                        }
                        int iF7 = iF5 + eVar15.f10670W[i24].f();
                        if (iVar16 == null && iVar17 != null && iVar3 != null && iVar18 != null) {
                            if (eVar16 == eVar3) {
                                iF7 = eVar3.f10670W[i4].f();
                            }
                            eVar17 = eVar17;
                            dVar.c(iVar16, iVar17, iF7, 0.5f, iVar3, iVar18, eVar16 == eVar4 ? eVar4.f10670W[i24].f() : iF6, z12 ? 8 : 5);
                        }
                        if (eVar16.V() != 8) {
                            eVar16 = eVar15;
                        }
                        eVar15 = eVar16;
                        eVar16 = eVar17;
                    }
                    i iVar19 = eVar16.f10670W[i24].f10625i;
                    if (dVar3 != null) {
                        iF6 += dVar3.f();
                    }
                    int iF8 = iF5 + eVar15.f10670W[i24].f();
                    if (iVar16 == null) {
                    }
                }
                if (eVar16.V() != 8) {
                    eVar16 = eVar15;
                }
                eVar15 = eVar16;
                eVar16 = eVar17;
            }
        }
        if ((!z9 && !z7) || eVar3 == null || eVar3 == eVar4) {
            return;
        }
        d[] dVarArr6 = eVar3.f10670W;
        d dVar28 = dVarArr6[i4];
        if (eVar4 == null) {
            eVar4 = eVar3;
        }
        int i25 = i4 + 1;
        d dVar29 = eVar4.f10670W[i25];
        d dVar30 = dVar28.f10622f;
        i iVar20 = dVar30 != null ? dVar30.f10625i : null;
        d dVar31 = dVar29.f10622f;
        if (dVar31 != null) {
            iVar4 = dVar31.f10625i;
        } else {
            r5 = 0;
        }
        if (eVar2 != eVar4) {
            d dVar32 = eVar2.f10670W[i25].f10622f;
            if (dVar32 != null) {
                r5 = iVar4;
                obj = dVar32.f10625i;
            }
            r5 = iVar4;
            r5 = obj;
        }
        if (eVar3 == eVar4) {
            dVar29 = dVarArr6[i25];
        }
        if (iVar20 == null || r5 == 0) {
            return;
        }
        dVar.c(dVar28.f10625i, iVar20, dVar28.f(), 0.5f, r5, dVar29.f10625i, eVar4.f10670W[i25].f(), 5);
    }

    public static void b(f fVar, d dVar, ArrayList arrayList, int i3) {
        int i4;
        c[] cVarArr;
        int i5;
        if (i3 == 0) {
            i4 = fVar.f10743W0;
            cVarArr = fVar.f10746Z0;
            i5 = 0;
        } else {
            i4 = fVar.f10744X0;
            cVarArr = fVar.f10745Y0;
            i5 = 2;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            c cVar = cVarArr[i6];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f10595a)) {
                a(fVar, dVar, i3, i5, cVar);
            }
        }
    }
}
