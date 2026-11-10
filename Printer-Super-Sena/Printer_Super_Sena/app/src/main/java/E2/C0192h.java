package E2;

import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: E2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0192h extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    protected static final String[] f528B = {"212222", "222122", "222221", "121223", "121322", "131222", "122213", "122312", "132212", "221213", "221312", "231212", "112232", "122132", "122231", "113222", "123122", "123221", "223211", "221132", "221231", "213212", "223112", "312131", "311222", "321122", "321221", "312212", "322112", "322211", "212123", "212321", "232121", "111323", "131123", "131321", "112313", "132113", "132311", "211313", "231113", "231311", "112133", "112331", "132131", "113123", "113321", "133121", "313121", "211331", "231131", "213113", "213311", "213131", "311123", "311321", "331121", "312113", "312311", "332111", "314111", "221411", "431111", "111224", "111422", "121124", "121421", "141122", "141221", "112214", "112412", "122114", "122411", "142112", "142211", "241211", "221114", "413111", "241112", "134111", "111242", "121142", "121241", "114212", "124112", "124211", "411212", "421112", "421211", "212141", "214121", "412121", "111143", "111341", "131141", "114113", "114311", "411113", "411311", "113141", "114131", "311141", "411131", "211412", "211214", "211232", "2331112"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f530z = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private a f529A = a.OFF;

    /* JADX INFO: renamed from: E2.h$a */
    private enum a {
        OFF,
        CCA,
        CCB,
        CCC
    }

    /* JADX INFO: renamed from: E2.h$b */
    private enum b {
        SHIFTN,
        LATCHN,
        SHIFTF,
        LATCHF
    }

    /* JADX INFO: renamed from: E2.h$c */
    private enum c {
        NULL,
        SHIFTA,
        LATCHA,
        SHIFTB,
        LATCHB,
        SHIFTC,
        LATCHC,
        AORB,
        ABORC
    }

    private int L(c[] cVarArr, int[] iArr, int i3) {
        if (i3 > 1) {
            int i4 = 1;
            while (i4 < i3) {
                int i5 = i4 - 1;
                if (cVarArr[i5] == cVarArr[i4]) {
                    iArr[i5] = iArr[i5] + iArr[i4];
                    for (int i6 = i4 + 1; i6 < i3; i6++) {
                        int i7 = i6 - 1;
                        iArr[i7] = iArr[i6];
                        cVarArr[i7] = cVarArr[i6];
                    }
                    i3--;
                    i4--;
                }
                i4++;
            }
        }
        return i3;
    }

    private c M(int i3, int i4) {
        c cVar;
        if (i3 == -1) {
            cVar = i4 % 2 == 0 ? c.ABORC : c.AORB;
        } else if (i3 == -2 || i3 == -3 || i3 == -4) {
            cVar = c.AORB;
        } else if (i3 <= 31) {
            cVar = c.SHIFTA;
        } else if (i3 >= 48 && i3 <= 57) {
            cVar = c.ABORC;
        } else if (i3 <= 95) {
            cVar = c.AORB;
        } else if (i3 <= 127) {
            cVar = c.SHIFTB;
        } else if (i3 <= 159) {
            cVar = c.SHIFTA;
        } else {
            cVar = i3 <= 223 ? c.AORB : c.SHIFTB;
        }
        return (this.f530z && cVar == c.ABORC) ? c.AORB : cVar;
    }

    private int N(int i3, c cVar) {
        return (i3 == -1 && cVar == c.ABORC) ? 2 : 1;
    }

    private int O(c[] cVarArr, int[] iArr, int i3) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            c cVar5 = cVarArr[i4];
            int i6 = iArr[i4];
            c cVar6 = i4 != 0 ? cVarArr[i4 - 1] : c.NULL;
            c cVar7 = i4 != i3 + (-1) ? cVarArr[i4 + 1] : c.NULL;
            int i7 = 0;
            for (int i8 = 0; i8 < i6 - i7; i8++) {
                if (N(this.f415n[i5 + i8], cVar5) == 2) {
                    i7++;
                }
            }
            if (i4 == 0) {
                if (i3 == 1 && i6 == 2 && cVar5 == c.ABORC) {
                    cVar5 = c.LATCHC;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == c.ABORC) {
                    if (i6 >= 4) {
                        cVar5 = c.LATCHC;
                        cVarArr[i4] = cVar5;
                    } else {
                        cVar5 = c.AORB;
                        cVarArr[i4] = cVar5;
                    }
                }
                c cVar8 = c.SHIFTA;
                if (cVar5 == cVar8) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                c cVar9 = c.AORB;
                if (cVar5 == cVar9 && cVar7 == cVar8) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar9) {
                    cVarArr[i4] = c.LATCHB;
                }
            } else {
                c cVar10 = c.ABORC;
                if (cVar5 == cVar10 && i6 >= 4) {
                    cVar5 = c.LATCHC;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar10) {
                    cVar5 = c.AORB;
                    cVarArr[i4] = cVar5;
                }
                c cVar11 = c.AORB;
                if (cVar5 == cVar11 && cVar6 == (cVar4 = c.LATCHA)) {
                    cVarArr[i4] = cVar4;
                    cVar5 = cVar4;
                }
                if (cVar5 == cVar11 && cVar6 == (cVar3 = c.LATCHB)) {
                    cVarArr[i4] = cVar3;
                    cVar5 = cVar3;
                }
                if (cVar5 == cVar11 && cVar7 == c.SHIFTA) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar11 && cVar7 == c.SHIFTB) {
                    cVar5 = c.LATCHB;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar11) {
                    cVar5 = c.LATCHB;
                    cVarArr[i4] = cVar5;
                }
                c cVar12 = c.SHIFTA;
                if (cVar5 == cVar12 && i6 > 1) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                c cVar13 = c.SHIFTB;
                if (cVar5 == cVar13 && i6 > 1) {
                    cVar5 = c.LATCHB;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar12 && cVar6 == (cVar2 = c.LATCHA)) {
                    cVarArr[i4] = cVar2;
                    cVar5 = cVar2;
                }
                if (cVar5 == cVar13 && cVar6 == (cVar = c.LATCHB)) {
                    cVarArr[i4] = cVar;
                    cVar5 = cVar;
                }
                if (cVar5 == cVar12 && cVar7 == cVar11) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar13 && cVar7 == cVar11) {
                    cVar5 = c.LATCHB;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar12 && cVar6 == c.LATCHC) {
                    cVar5 = c.LATCHA;
                    cVarArr[i4] = cVar5;
                }
                if (cVar5 == cVar13 && cVar6 == c.LATCHC) {
                    cVarArr[i4] = c.LATCHB;
                }
            }
            int i9 = iArr[i4] - i7;
            iArr[i4] = i9;
            i5 += i9;
            i4++;
        }
        return L(cVarArr, iArr, i3);
    }

    private static String P(String str) {
        return str.replace("\\<FNC1>", "").replace("\\<FNC2>", "").replace("\\<FNC3>", "").replace("\\<FNC4>", "");
    }

    private void Q(c[] cVarArr, int i3, int i4, int i5, int i6) {
        c cVar;
        c cVar2;
        int i7;
        if ((i5 & 1) != 0) {
            if (i3 - i4 == 0 || i6 > 0) {
                int i8 = i3 - 1;
                if (i3 >= cVarArr.length || (cVar = cVarArr[i3]) == null || cVar == c.LATCHC) {
                    cVar = c.LATCHB;
                }
                cVar2 = cVar;
                i7 = i8;
            } else {
                i7 = i3 - i5;
                int i9 = i7 - 1;
                if (i9 < 0 || (cVar2 = cVarArr[i9]) == null || cVar2 == c.LATCHC) {
                    cVar2 = c.LATCHB;
                }
            }
            cVarArr[i7] = cVar2;
        }
    }

    protected void R() {
        this.f529A = a.CCA;
    }

    protected void S() {
        this.f529A = a.CCB;
    }

    protected void T() {
        this.f529A = a.CCC;
    }

    public void U(boolean z3) {
        this.f530z = z3;
    }

    public void V() {
        this.f529A = a.OFF;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01b7 A[PHI: r1
      0x01b7: PHI (r1v66 double) = (r1v62 double), (r1v61 double) binds: [B:138:0x01cc, B:129:0x01b5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // E2.Q
    protected void c() {
        int iO;
        int i3;
        int i4;
        c cVar;
        int i5;
        c cVar2;
        int i6;
        b bVar = b.LATCHN;
        c[] cVarArr = new c[200];
        int[] iArr = new int[200];
        int[] iArr2 = new int[200];
        int[] iArrK = Q.K(this.f413l, StandardCharsets.ISO_8859_1, new int[0]);
        this.f415n = iArrK;
        if (iArrK == null) {
            throw new H("Invalid characters in input data");
        }
        int length = iArrK.length;
        b[] bVarArr = new b[200];
        c[] cVarArr2 = new c[200];
        if (length > 170) {
            throw new H("Input data too long");
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (this.f415n[i7] >= 128) {
                bVarArr[i7] = b.SHIFTF;
            } else {
                bVarArr[i7] = b.LATCHN;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i8 = bVarArr[i9] == b.SHIFTF ? i8 + 1 : 0;
            if (i8 >= 5) {
                for (int i10 = i9; i10 > i9 - 5; i10--) {
                    bVarArr[i10] = b.LATCHF;
                }
            }
            if (i8 >= 3 && i9 == length - 1) {
                for (int i11 = i9; i11 > i9 - 3; i11--) {
                    bVarArr[i11] = b.LATCHF;
                }
            }
        }
        for (int i12 = 1; i12 < length; i12++) {
            if (bVarArr[i12 - 1] == b.LATCHF && bVarArr[i12] == b.LATCHN) {
                int i13 = 0;
                while (true) {
                    i6 = i12 + i13;
                    if (bVarArr[i6] != b.LATCHN || i6 >= length) {
                        break;
                    } else {
                        i13++;
                    }
                }
                if (i13 < 5 || (i13 < 3 && i6 == length - 1)) {
                    for (int i14 = 0; i14 < i13; i14++) {
                        bVarArr[i12 + i14] = b.SHIFTN;
                    }
                }
            }
        }
        if (length > 0) {
            int i15 = this.f415n[0];
            int i16 = (i15 < 48 || i15 > 57) ? 0 : 1;
            c cVarM = M(i15, i16);
            cVarArr[0] = cVarM;
            iArr[0] = iArr[0] + N(i15, cVarM);
            int i17 = 1;
            int i18 = 0;
            while (i17 < length) {
                int i19 = this.f415n[i17];
                c cVarM2 = M(i19, i16);
                if (cVarM2 == cVarM) {
                    iArr[i18] = iArr[i18] + N(i19, cVarM2);
                } else {
                    i18++;
                    cVarArr[i18] = cVarM2;
                    iArr[i18] = N(i19, cVarM2);
                }
                i16 = (i19 < 48 || i19 > 57) ? 0 : i16 + 1;
                i17++;
                cVarM = cVarM2;
            }
            iO = O(cVarArr, iArr, i18 + 1);
        } else {
            iO = 0;
        }
        if (length > 0) {
            int i20 = 0;
            for (int i21 = 0; i21 < iO; i21++) {
                for (int i22 = 0; i22 < iArr[i21]; i22++) {
                    cVarArr2[i20] = cVarArr[i21];
                    i20++;
                }
            }
            i3 = i20;
        } else {
            cVarArr2[0] = c.LATCHB;
            i3 = 0;
        }
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i26 < i3) {
            if (cVarArr2[i26] == c.LATCHC) {
                int i27 = i23 + 1;
                int i28 = this.f415n[i26];
                if (i28 >= 48 && i28 <= 57) {
                    i23 = i27;
                    i24++;
                } else if (i28 == -1) {
                    i23 = i27;
                    i25++;
                } else {
                    i23 = i27;
                }
            } else {
                Q(cVarArr2, i26, i23, i24, i25);
                i23 = 0;
                i24 = 0;
                i25 = 0;
            }
            i26++;
        }
        Q(cVarArr2, i26, i23, i24, i25);
        if (cVarArr2[0] == c.SHIFTA) {
            int i29 = 0;
            do {
                cVarArr2[i29] = c.LATCHA;
                i29++;
            } while (cVarArr2[i29] == c.SHIFTA);
        }
        if (cVarArr2[0] == c.SHIFTB) {
            int i30 = 0;
            do {
                cVarArr2[i30] = c.LATCHB;
                i30++;
            } while (cVarArr2[i30] == c.SHIFTB);
        }
        c cVar3 = c.NULL;
        double d3 = 0.0d;
        for (int i31 = 0; i31 < length; i31++) {
            c cVar4 = cVarArr2[i31];
            if (cVar4 == c.SHIFTA || cVar4 == c.SHIFTB) {
                d3 += 1.0d;
            }
            b bVar2 = bVarArr[i31];
            if (bVar2 == b.SHIFTF || bVar2 == b.SHIFTN) {
                d3 += 1.0d;
            }
            if ((cVar4 == c.LATCHA || cVar4 == c.LATCHB || cVar4 == c.LATCHC) && cVar4 != cVar3) {
                d3 += 1.0d;
                cVar3 = cVar4;
            }
            if (i31 != 0) {
                b bVar3 = b.LATCHF;
                if (bVar2 == bVar3 && bVarArr[i31 - 1] != bVar3) {
                    d3 += 2.0d;
                }
                if (bVar2 != bVar3 && bVarArr[i31 - 1] == bVar3) {
                    d3 += 2.0d;
                }
            } else if (bVar2 == b.LATCHF) {
                d3 += 2.0d;
            }
            d3 += (cVar4 != c.LATCHC || this.f415n[i31] == -1) ? 1.0d : 0.5d;
        }
        if (d3 > 80.0d) {
            throw new H("Input data too long");
        }
        u("Encoding: ");
        int i32 = 99;
        int i33 = 4;
        if (this.f404c) {
            int iOrdinal = cVarArr2[0].ordinal();
            if (iOrdinal == 2) {
                iArr2[0] = 103;
                cVar = c.LATCHA;
                iArr2[1] = 96;
                u("STARTA FNC3 ");
            } else if (iOrdinal != 4) {
                iArr2[0] = 104;
                iArr2[1] = 96;
                iArr2[2] = 99;
                cVar = c.LATCHC;
                u("STARTB FNC3 CODEC ");
                i4 = 2;
            } else {
                iArr2[0] = 104;
                cVar = c.LATCHB;
                iArr2[1] = 96;
                u("STARTB FNC3 ");
            }
            i4 = 1;
        } else {
            i4 = 0;
            int iOrdinal2 = cVarArr2[0].ordinal();
            if (iOrdinal2 == 2) {
                iArr2[0] = 103;
                cVar = c.LATCHA;
                u("STARTA ");
                i4 = 0;
            } else if (iOrdinal2 != 4) {
                iArr2[0] = 105;
                cVar = c.LATCHC;
                u("STARTC ");
            } else {
                iArr2[0] = 104;
                cVar = c.LATCHB;
                u("STARTB ");
            }
        }
        int i34 = i4 + 1;
        if (this.f403b == Q.a.GS1) {
            iArr2[1] = 102;
            i34 = i4 + 2;
            u("FNC1 ");
        }
        b bVar4 = bVarArr[0];
        b bVar5 = b.LATCHF;
        if (bVar4 == bVar5) {
            int iOrdinal3 = cVar.ordinal();
            if (iOrdinal3 == 2) {
                iArr2[i34] = 101;
                iArr2[i34 + 1] = 101;
                u("FNC4 FNC4 ");
            } else if (iOrdinal3 == 4) {
                iArr2[i34] = 100;
                iArr2[i34 + 1] = 100;
                u("FNC4 FNC4 ");
            }
            i34 += 2;
            bVar = bVar5;
        }
        int i35 = i34;
        b bVar6 = bVar;
        c cVar5 = cVar;
        int i36 = 0;
        while (i36 < length) {
            if (i36 != 0 && (cVar2 = cVarArr2[i36]) != cVar5) {
                int iOrdinal4 = cVar2.ordinal();
                if (iOrdinal4 == 2) {
                    iArr2[i35] = 101;
                    i35++;
                    cVar5 = c.LATCHA;
                    u("CODEA ");
                } else if (iOrdinal4 == i33) {
                    iArr2[i35] = 100;
                    i35++;
                    cVar5 = c.LATCHB;
                    u("CODEB ");
                } else if (iOrdinal4 == 6) {
                    iArr2[i35] = i32;
                    i35++;
                    cVar5 = c.LATCHC;
                    u("CODEC ");
                }
            }
            if (i36 != 0) {
                b bVar7 = bVarArr[i36];
                b bVar8 = b.LATCHF;
                if (bVar7 == bVar8 && bVar6 == b.LATCHN) {
                    int iOrdinal5 = cVar5.ordinal();
                    if (iOrdinal5 == 2) {
                        iArr2[i35] = 101;
                        iArr2[i35 + 1] = 101;
                        u("FNC4 FNC4 ");
                    } else if (iOrdinal5 == i33) {
                        iArr2[i35] = 100;
                        iArr2[i35 + 1] = 100;
                        u("FNC4 FNC4 ");
                    }
                    i35 += 2;
                    bVar6 = bVar8;
                }
                b bVar9 = bVarArr[i36];
                b bVar10 = b.LATCHN;
                if (bVar9 == bVar10 && bVar6 == bVar8) {
                    int iOrdinal6 = cVar5.ordinal();
                    if (iOrdinal6 == 2) {
                        iArr2[i35] = 101;
                        iArr2[i35 + 1] = 101;
                        u("FNC4 FNC4 ");
                    } else if (iOrdinal6 == i33) {
                        iArr2[i35] = 100;
                        iArr2[i35 + 1] = 100;
                        u("FNC4 FNC4 ");
                    }
                    i35 += 2;
                    bVar6 = bVar10;
                }
            }
            b bVar11 = bVarArr[i36];
            if (bVar11 == b.SHIFTF || bVar11 == b.SHIFTN) {
                int iOrdinal7 = cVar5.ordinal();
                if (iOrdinal7 == 2) {
                    iArr2[i35] = 101;
                    u("FNC4 ");
                } else if (iOrdinal7 == i33) {
                    iArr2[i35] = 100;
                    u("FNC4 ");
                }
                i35++;
            }
            c cVar6 = cVarArr2[i36];
            if (cVar6 == c.SHIFTA || cVar6 == c.SHIFTB) {
                iArr2[i35] = 98;
                u("SHFT ");
                i35++;
            }
            int i37 = this.f415n[i36];
            int iOrdinal8 = cVarArr2[i36].ordinal();
            if (iOrdinal8 != 1 && iOrdinal8 != 2) {
                if (iOrdinal8 == 3 || iOrdinal8 == 4) {
                    if (i37 == -1) {
                        iArr2[i35] = 102;
                        u("FNC1 ");
                    } else if (i37 == -2) {
                        iArr2[i35] = 97;
                        u("FNC2 ");
                    } else if (i37 == -3) {
                        iArr2[i35] = 96;
                        u("FNC3 ");
                    } else if (i37 == -4) {
                        iArr2[i35] = 100;
                        u("FNC4 ");
                    } else if (i37 > 127) {
                        int i38 = i37 - 160;
                        iArr2[i35] = i38;
                        y(i38);
                    } else {
                        int i39 = i37 - 32;
                        iArr2[i35] = i39;
                        y(i39);
                    }
                } else if (iOrdinal8 == 6) {
                    if (i37 == -1) {
                        iArr2[i35] = 102;
                        u("FNC1 ");
                        i35++;
                        i36++;
                    } else {
                        int i40 = ((i37 - 48) * 10) + (this.f415n[i36 + 1] - 48);
                        iArr2[i35] = i40;
                        y(i40);
                        i35++;
                        i36 += 2;
                    }
                }
                i32 = 99;
                i33 = 4;
            } else if (i37 == -1) {
                iArr2[i35] = 102;
                u("FNC1 ");
            } else if (i37 == -2) {
                iArr2[i35] = 97;
                u("FNC2 ");
            } else if (i37 == -3) {
                iArr2[i35] = 96;
                u("FNC3 ");
            } else if (i37 == -4) {
                iArr2[i35] = 101;
                u("FNC4 ");
            } else if (i37 > 127) {
                if (i37 < 160) {
                    iArr2[i35] = i37 - 64;
                } else {
                    iArr2[i35] = i37 - 160;
                }
                y(iArr2[i35]);
            } else {
                if (i37 < 32) {
                    iArr2[i35] = i37 + 64;
                } else {
                    iArr2[i35] = i37 - 32;
                }
                y(iArr2[i35]);
            }
            i35++;
            i36++;
            i32 = 99;
            i33 = 4;
        }
        v();
        int iOrdinal9 = this.f529A.ordinal();
        if (iOrdinal9 == 1 || iOrdinal9 == 2) {
            int iOrdinal10 = cVarArr2[length - 1].ordinal();
            if (iOrdinal10 == 2) {
                i5 = 100;
            } else if (iOrdinal10 != 4) {
                i5 = iOrdinal10 != 6 ? 0 : 101;
            } else {
                i5 = 99;
            }
            w("Linkage Flag: " + i5);
        } else if (iOrdinal9 != 3) {
            i5 = 0;
        } else {
            int iOrdinal11 = cVarArr2[length - 1].ordinal();
            if (iOrdinal11 == 2) {
                i5 = 99;
            } else if (iOrdinal11 != 4) {
                i5 = iOrdinal11 != 6 ? 0 : 100;
            } else {
                i5 = 101;
            }
            w("Linkage Flag: " + i5);
        }
        if (i5 != 0) {
            iArr2[i35] = i5;
            i35++;
        }
        w("Data Codewords: " + i35);
        int i41 = 0;
        int i42 = 0;
        while (i42 < i35) {
            i41 += i42 == 0 ? iArr2[i42] : iArr2[i42] * i42;
            i42++;
        }
        int i43 = i41 % 103;
        w("Check Digit: " + i43);
        StringBuilder sb = new StringBuilder((i35 * 6) + 13);
        for (int i44 = 0; i44 < i35; i44++) {
            sb.append(f528B[iArr2[i44]]);
        }
        String[] strArr = f528B;
        sb.append(strArr[i43]);
        sb.append(strArr[106]);
        if (this.f403b != Q.a.GS1) {
            this.f416o = P(this.f413l);
            if (this.f403b == Q.a.HIBC) {
                this.f416o = "*" + this.f416o + "*";
            }
        }
        if (this.f529A == a.OFF) {
            this.f417p = new String[]{sb.toString()};
            this.f419r = new int[]{-1};
            this.f418q = 1;
        } else {
            this.f417p = new String[]{"0" + ((Object) sb), sb.toString()};
            this.f419r = new int[]{1, -1};
            this.f418q = 2;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
