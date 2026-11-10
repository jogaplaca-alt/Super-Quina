package E2;

import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: E2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0193i extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f551B = {"212222", "222122", "222221", "121223", "121322", "131222", "122213", "122312", "132212", "221213", "221312", "231212", "112232", "122132", "122231", "113222", "123122", "123221", "223211", "221132", "221231", "213212", "223112", "312131", "311222", "321122", "321221", "312212", "322112", "322211", "212123", "212321", "232121", "111323", "131123", "131321", "112313", "132113", "132311", "211313", "231113", "231311", "112133", "112331", "132131", "113123", "113321", "133121", "313121", "211331", "231131", "213113", "213311", "213131", "311123", "311321", "331121", "312113", "312311", "332111", "314111", "221411", "431111", "111224", "111422", "121124", "121421", "141122", "141221", "112214", "112412", "122114", "122411", "142112", "142211", "241211", "221114", "413111", "241112", "134111", "111242", "121142", "121241", "114212", "124112", "124211", "411212", "421112", "421211", "212141", "214121", "412121", "111143", "111341", "131141", "114113", "114311", "411113", "411311", "113141", "114131", "311141", "411131", "211412", "211214", "211232", "211133"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f552C = {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "3112"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f553D = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f554E = {0, 1, 2, 3, 4, 5, 6, 7, 4, 5, 6, 7, 0, 1, 2, 3};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final a[] f556z = new a[170];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final int[] f555A = new int[170];

    /* JADX INFO: renamed from: E2.i$a */
    private enum a {
        NULL,
        SHIFTA,
        LATCHA,
        SHIFTB,
        LATCHB,
        SHIFTC,
        LATCHC,
        AORB,
        ABORC,
        CANDB,
        CANDBB
    }

    private void L(int i3) {
        if (i3 > 1) {
            int i4 = 1;
            while (i4 < i3) {
                a[] aVarArr = this.f556z;
                int i5 = i4 - 1;
                if (aVarArr[i5] == aVarArr[i4]) {
                    int[] iArr = this.f555A;
                    iArr[i5] = iArr[i5] + iArr[i4];
                    for (int i6 = i4 + 1; i6 < i3; i6++) {
                        int[] iArr2 = this.f555A;
                        int i7 = i6 - 1;
                        iArr2[i7] = iArr2[i6];
                        a[] aVarArr2 = this.f556z;
                        aVarArr2[i7] = aVarArr2[i6];
                    }
                    i3--;
                    i4--;
                }
                i4++;
            }
        }
    }

    private a M(int i3) {
        if (i3 <= 31) {
            return a.SHIFTA;
        }
        if (i3 >= 48 && i3 <= 57) {
            return a.ABORC;
        }
        if (i3 <= 95) {
            return a.AORB;
        }
        if (i3 <= 127) {
            return a.SHIFTB;
        }
        if (i3 <= 159) {
            return a.SHIFTA;
        }
        return i3 <= 223 ? a.AORB : a.SHIFTB;
    }

    private void N(int i3, int[] iArr, int i4) {
        if (i3 > 127) {
            if (i3 < 160) {
                iArr[i4] = i3 - 64;
                return;
            } else {
                iArr[i4] = i3 - 160;
                return;
            }
        }
        if (i3 < 32) {
            iArr[i4] = i3 + 64;
        } else {
            iArr[i4] = i3 - 32;
        }
    }

    private void O(int i3, int[] iArr, int i4) {
        if (i3 > 127) {
            iArr[i4] = i3 - 160;
        } else {
            iArr[i4] = i3 - 32;
        }
    }

    private void P(int i3, int i4, int[] iArr, int i5) {
        iArr[i5] = (Character.getNumericValue(i3) * 10) + Character.getNumericValue(i4);
    }

    private void Q(int i3) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        int i4 = 0;
        while (i4 < i3) {
            a[] aVarArr = this.f556z;
            a aVar5 = aVarArr[i4];
            int i5 = this.f555A[i4];
            a aVar6 = i4 != 0 ? aVarArr[i4 - 1] : a.NULL;
            a aVar7 = i4 != i3 + (-1) ? aVarArr[i4 + 1] : a.NULL;
            if (i4 == 0) {
                if (i3 == 1 && i5 == 2 && aVar5 == a.ABORC) {
                    aVarArr[i4] = a.LATCHC;
                }
                if (aVar5 == a.ABORC) {
                    if (i5 >= 4) {
                        aVarArr[i4] = a.LATCHC;
                    } else {
                        aVar5 = a.AORB;
                        aVarArr[i4] = aVar5;
                    }
                }
                a aVar8 = a.SHIFTA;
                if (aVar5 == aVar8) {
                    aVarArr[i4] = a.LATCHA;
                }
                a aVar9 = a.AORB;
                if (aVar5 == aVar9 && aVar7 == aVar8) {
                    aVar5 = a.LATCHA;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar9) {
                    aVarArr[i4] = a.LATCHB;
                }
            } else {
                a aVar10 = a.ABORC;
                if (aVar5 == aVar10 && i5 >= 4) {
                    aVar5 = a.LATCHC;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar10) {
                    aVar5 = a.AORB;
                    aVarArr[i4] = aVar5;
                }
                a aVar11 = a.AORB;
                if (aVar5 == aVar11 && aVar6 == (aVar4 = a.LATCHA)) {
                    aVarArr[i4] = aVar4;
                    aVar5 = aVar4;
                }
                if (aVar5 == aVar11 && aVar6 == (aVar3 = a.LATCHB)) {
                    aVarArr[i4] = aVar3;
                    aVar5 = aVar3;
                }
                if (aVar5 == aVar11 && aVar7 == a.SHIFTA) {
                    aVar5 = a.LATCHA;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar11 && aVar7 == a.SHIFTB) {
                    aVar5 = a.LATCHB;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar11) {
                    aVar5 = a.LATCHB;
                    aVarArr[i4] = aVar5;
                }
                a aVar12 = a.SHIFTA;
                if (aVar5 == aVar12 && i5 > 1) {
                    aVar5 = a.LATCHA;
                    aVarArr[i4] = aVar5;
                }
                a aVar13 = a.SHIFTB;
                if (aVar5 == aVar13 && i5 > 1) {
                    aVar5 = a.LATCHB;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar12 && aVar6 == (aVar2 = a.LATCHA)) {
                    aVarArr[i4] = aVar2;
                    aVar5 = aVar2;
                }
                if (aVar5 == aVar13 && aVar6 == (aVar = a.LATCHB)) {
                    aVarArr[i4] = aVar;
                    aVar5 = aVar;
                }
                if (aVar5 == aVar12 && aVar6 == a.LATCHC) {
                    aVar5 = a.LATCHA;
                    aVarArr[i4] = aVar5;
                }
                if (aVar5 == aVar13 && aVar6 == a.LATCHC) {
                    aVarArr[i4] = a.LATCHB;
                }
            }
            i4++;
        }
        L(i3);
    }

    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        int i3 = 1;
        int i4 = 1;
        for (int i5 = 0; i5 < this.f418q; i5++) {
            int i6 = 0;
            boolean z3 = true;
            int iCharAt = 15;
            while (i6 < this.f417p[i5].length()) {
                if (z3) {
                    int iCharAt2 = this.f417p[i5].charAt(i6) - '0';
                    int i7 = this.f419r[i5];
                    if (i7 == -1) {
                        i7 = this.f405d;
                    }
                    if (iCharAt2 != 0 && i7 != 0) {
                        this.f423v.add(new G2.e(iCharAt, i3, iCharAt2, i7));
                    }
                    int i8 = iCharAt2 + iCharAt;
                    if (i8 > this.f421t) {
                        this.f421t = i8;
                    }
                    i4 = i7;
                    z3 = false;
                } else {
                    i6 = i6;
                    z3 = true;
                }
                int i9 = i6;
                iCharAt += this.f417p[i5].charAt(i9) - '0';
                i6 = i9 + 1;
            }
            i3 += i4;
            if (i3 > this.f420s) {
                this.f420s = i3;
            }
            if (i5 != this.f418q - 1) {
                this.f423v.add(new G2.e(15.0d, i3 - 1, this.f421t - 15, 2.0d));
            }
        }
        this.f423v.add(new G2.e(0.0d, 0.0d, this.f421t + 15, 2.0d));
        this.f423v.add(new G2.e(0.0d, i3 - 1, this.f421t + 15, 2.0d));
        this.f421t += 15;
        this.f420s++;
    }

    /* JADX WARN: Code duplicated, block: B:175:0x0229 A[PHI: r2
      0x0229: PHI (r2v53 double) = (r2v47 double), (r2v56 double) binds: [B:183:0x023e, B:174:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:259:0x031b  */
    /* JADX WARN: Code duplicated, block: B:321:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:323:0x03dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:324:0x03de  */
    /* JADX WARN: Code duplicated, block: B:326:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:329:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:331:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:335:0x0411  */
    /* JADX WARN: Code duplicated, block: B:338:0x0418  */
    /* JADX WARN: Code duplicated, block: B:341:0x041e A[LOOP:18: B:340:0x041c->B:341:0x041e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:344:0x042c A[LOOP:19: B:343:0x042a->B:344:0x042c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:347:0x0498  */
    /* JADX WARN: Code duplicated, block: B:349:0x04c6 A[LOOP:21: B:348:0x04c4->B:349:0x04c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:353:0x050e A[LOOP:17: B:255:0x030e->B:353:0x050e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:408:0x0409 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:347:0x0498, please report this as an issue */
    @Override // E2.Q
    protected void c() {
        int i3;
        char c3;
        int i4;
        char c4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        char c5;
        int[] iArr;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String string;
        int i16;
        char c6;
        char c7;
        char c8;
        int i17;
        int i18;
        int i19;
        if (!this.f413l.matches("[\u0000-ÿ]+")) {
            throw new H("Invalid characters in input data");
        }
        int[] iArrK = Q.K(this.f413l, StandardCharsets.ISO_8859_1, new int[0]);
        this.f415n = iArrK;
        int length = iArrK.length;
        char[] cArr = new char[160];
        char[] cArr2 = new char[160];
        int[] iArr2 = new int[160];
        if (length > 157) {
            throw new H("Input too long");
        }
        for (int i20 = 0; i20 < length; i20++) {
            if (this.f415n[i20] >= 128) {
                cArr2[i20] = 'f';
            } else {
                cArr2[i20] = ' ';
            }
        }
        int i21 = 0;
        while (true) {
            i3 = 3;
            c3 = 'F';
            i4 = 1;
            if (i21 >= length) {
                break;
            }
            if (cArr2[i21] == 'f') {
                int i22 = 0;
                do {
                    i22++;
                    i19 = i21 + i22;
                } while (cArr2[i19] == 'f');
                if (i22 >= 5 || (i22 >= 3 && i19 == length - 1)) {
                    for (int i23 = 0; i23 <= i22; i23++) {
                        cArr2[i21 + i23] = 'F';
                    }
                }
            }
            i21++;
        }
        if (length > 1) {
            int i24 = 1;
            while (i24 < length) {
                if (cArr2[i24 - 1] == c3 && cArr2[i24] == ' ') {
                    int i25 = 0;
                    while (true) {
                        i18 = i24 + i25;
                        if (cArr2[i18] != ' ' || i18 >= length) {
                            break;
                        } else {
                            i25++;
                        }
                    }
                    if (i25 < 5 || (i25 < 3 && i18 == length - 1)) {
                        for (int i26 = 0; i26 < i25; i26++) {
                            cArr2[i24 + i26] = 'n';
                        }
                    }
                }
                i24++;
                c3 = 'F';
            }
        }
        int i27 = 0;
        a aVarM = M(this.f415n[0]);
        if (this.f415n[0] == -1) {
            aVarM = a.ABORC;
        }
        int i28 = 0;
        int i29 = 160;
        while (i28 < i29) {
            this.f555A[i28] = i27;
            i28++;
            i29 = 160;
            i27 = 0;
        }
        int i30 = 0;
        int i31 = 0;
        do {
            this.f556z[i30] = aVarM;
            while (this.f556z[i30] == aVarM && i31 < length) {
                int[] iArr3 = this.f555A;
                iArr3[i30] = iArr3[i30] + 1;
                i31++;
                if (i31 < length) {
                    aVarM = M(this.f415n[i31]);
                    if (this.f415n[i31] == -1) {
                        aVarM = a.ABORC;
                    }
                }
            }
            i30++;
        } while (i31 < length);
        Q(i30);
        int i32 = 0;
        int i33 = 0;
        while (i32 < i30) {
            int i34 = 0;
            while (i34 < this.f555A[i32]) {
                int iOrdinal = this.f556z[i32].ordinal();
                if (iOrdinal == 1) {
                    cArr[i33] = 'a';
                } else if (iOrdinal == 2) {
                    cArr[i33] = 'A';
                } else if (iOrdinal == i3) {
                    cArr[i33] = 'b';
                } else if (iOrdinal == 4) {
                    cArr[i33] = 'B';
                } else if (iOrdinal == 6) {
                    cArr[i33] = 'C';
                }
                i33++;
                i34++;
                i3 = 3;
            }
            i32++;
            i3 = 3;
        }
        if (cArr[0] == 'a') {
            int i35 = 0;
            do {
                cArr[i35] = 'A';
                i35++;
            } while (cArr[i35] == 'a');
        }
        if (cArr[0] == 'b') {
            int i36 = 0;
            do {
                cArr[i36] = 'B';
                i36++;
            } while (cArr[i36] == 'b');
        }
        int i37 = 0;
        int i38 = 0;
        while (i37 < i33) {
            if (cArr[i37] == 'C') {
                if (this.f415n[i37] != -1) {
                    i38++;
                } else if ((i38 & 1) != 0) {
                    int i39 = i37 - i38;
                    if (i39 != 0) {
                        cArr[i39] = 'B';
                    } else {
                        cArr[i37 - 1] = 'B';
                    }
                }
                i37++;
            } else if ((i38 & 1) != 0) {
                int i40 = i37 - i38;
                if (i40 != 0) {
                    cArr[i40] = 'B';
                } else {
                    cArr[i37 - 1] = 'B';
                }
            }
            i38 = 0;
            i37++;
        }
        if ((i38 & 1) != 0) {
            int i41 = i37 - i38;
            if (i41 != 0) {
                c4 = 'B';
                cArr[i41] = 'B';
            } else {
                c4 = 'B';
                cArr[i37 - 1] = 'B';
            }
        } else {
            c4 = 'B';
        }
        int i42 = 1;
        while (i42 < i33 - 1) {
            if (cArr[i42] == 'C' && cArr[i42 - 1] == c4 && cArr[i42 + 1] == c4) {
                cArr[i42] = c4;
            }
            i42++;
            c4 = 'B';
        }
        double d3 = 0.0d;
        char c9 = ' ';
        for (int i43 = 0; i43 < length; i43++) {
            char c10 = cArr[i43];
            if (c10 == 'a' || c10 == 'b') {
                d3 += 1.0d;
            }
            char c11 = cArr2[i43];
            if (c11 == 'f' || c11 == 'n') {
                d3 += 1.0d;
            }
            if ((c10 == 'A' || c10 == 'B' || c10 == 'C') && c10 != c9) {
                d3 += 1.0d;
                c9 = c10;
            }
            if (i43 == 0) {
                if (c10 == 'B' && cArr[1] == 'C') {
                    d3 -= 1.0d;
                }
                if (c10 == 'B' && cArr[1] == 'B' && cArr[2] == 'C') {
                    d3 -= 1.0d;
                }
                if (c11 == 'F') {
                    d3 += 2.0d;
                }
            } else {
                if (c11 == 'F' && cArr2[i43 - 1] != 'F') {
                    d3 += 2.0d;
                }
                if (c11 != 'F' && cArr2[i43 - 1] == 'F') {
                    d3 += 2.0d;
                }
            }
            d3 = (c10 != 'C' || this.f415n[i43] == -1) ? d3 + 1.0d : d3 + 0.5d;
        }
        Q.a aVar = this.f403b;
        Q.a aVar2 = Q.a.GS1;
        if (aVar == aVar2 && cArr[0] != 'A') {
            d3 -= 1.0d;
        }
        if (d3 > 77.0d) {
            throw new H("Input too long");
        }
        int i44 = (int) (d3 + 2.0d);
        int i45 = i44 / 5;
        if (i44 % 5 > 0) {
            i45++;
        }
        if (i45 == 1) {
            i45 = 2;
        }
        char c12 = cArr[0];
        switch (c12) {
            case 'A':
            default:
                i5 = 0;
                break;
            case 'B':
                i5 = 1;
                break;
            case 'C':
                i5 = 2;
                break;
        }
        if (this.f404c) {
            if (i5 == 2) {
                i5 = 5;
            }
            if (aVar == aVar2) {
                throw new H("Cannot use both GS1 mode and Reader Initialisation");
            }
            i7 = (c12 == 'B' && cArr[1] == 'C') ? 6 : i5;
            iArr2[0] = ((i45 - 2) * 7) + i7;
            iArr2[1] = 96;
            i6 = 2;
        } else {
            if (aVar == aVar2) {
                if (c12 == 'B') {
                    i7 = 3;
                } else if (c12 == 'C') {
                    i7 = 4;
                }
                i6 = 0;
            } else {
                if (c12 == 'B' && cArr[1] == 'C') {
                    i5 = 5;
                }
                if (c12 == 'B' && cArr[1] == 'B' && cArr[2] == 'C') {
                    i6 = 0;
                    i7 = 6;
                }
            }
            i7 = i5;
            i6 = 0;
        }
        iArr2[i6] = ((i45 - 2) * 7) + i7;
        int i46 = i6 + 1;
        int i47 = 101;
        int i48 = 100;
        if (cArr2[0] == 'F') {
            if (c12 == 'A') {
                iArr2[i46] = 101;
                iArr2[i6 + 2] = 101;
            } else if (c12 == 'B') {
                iArr2[i46] = 100;
                iArr2[i6 + 2] = 100;
            }
            i46 = i6 + 3;
            z3 = true;
        } else {
            z3 = false;
        }
        char c13 = c12;
        boolean z4 = z3;
        int i49 = 0;
        while (true) {
            if (i49 != 0) {
                char c14 = cArr[i49];
                if (c14 != cArr[i49 - 1]) {
                    switch (c14) {
                        case 'A':
                            iArr2[i46] = i47;
                            i46++;
                            c13 = 'A';
                            break;
                        case 'B':
                            iArr2[i46] = i48;
                            i46++;
                            c13 = 'B';
                            break;
                        case 'C':
                            if (i49 == i4) {
                                c8 = 0;
                                c7 = 'B';
                                i17 = 2;
                                if (cArr[0] != 'B') {
                                }
                                c13 = 'C';
                            } else {
                                c7 = 'B';
                                c8 = 0;
                                i17 = 2;
                            }
                            if (i49 != i17 || cArr[c8] != c7 || cArr[i4] != c7) {
                                iArr2[i46] = 99;
                                i46++;
                            }
                            c13 = 'C';
                            break;
                        default:
                            break;
                    }
                }
            }
            if (i49 != 0) {
                char c15 = cArr2[i49];
                if (c15 == 'F' && !z4) {
                    if (c13 == 'A') {
                        iArr2[i46] = i47;
                        iArr2[i46 + 1] = i47;
                    } else if (c13 == 'B') {
                        iArr2[i46] = i48;
                        iArr2[i46 + 1] = i48;
                    }
                    i46 += 2;
                    z4 = true;
                }
                if (c15 == ' ' && z4) {
                    if (c13 == 'A') {
                        iArr2[i46] = i47;
                        iArr2[i46 + 1] = i47;
                    } else if (c13 == 'B') {
                        iArr2[i46] = i48;
                        iArr2[i46 + 1] = i48;
                    }
                    i46 += 2;
                    z4 = false;
                }
            }
            char c16 = cArr2[i44];
            if (c16 == 'f' || c16 == 'n') {
                if (c13 == 'A') {
                    iArr2[i46] = i47;
                } else if (c13 == 'B') {
                    iArr2[i46] = i48;
                }
                i46++;
            }
            char c17 = cArr[i44];
            if (c17 != 'a') {
                c5 = 'b';
                if (c17 == 'b') {
                }
                iArr = this.f415n;
                i8 = iArr[i49];
                if (i8 != -1) {
                    c6 = cArr[i49];
                    if (c6 == 'a') {
                        N(i8, iArr2, i46);
                        i46++;
                        i49++;
                    } else {
                        if (c6 != c5) {
                            switch (c6) {
                                case 'A':
                                    N(i8, iArr2, i46);
                                    i46++;
                                    i49++;
                                    break;
                                case 'C':
                                    P(i8, iArr[i49 + 1], iArr2, i46);
                                    i46++;
                                    i49 += 2;
                                    break;
                            }
                        }
                        O(i8, iArr2, i46);
                        i46++;
                        i49++;
                    }
                } else {
                    iArr2[i46] = 102;
                    i46++;
                    i49++;
                }
                if (i49 >= length) {
                    i9 = 5 - ((i46 + 2) % 5);
                    if (i9 == 5) {
                        i9 = 0;
                    }
                    i10 = i46 + i9;
                    if (i10 < 8) {
                        i9 += 8 - i10;
                    }
                    for (i11 = 0; i11 < i9; i11++) {
                        iArr2[i46] = 106;
                        i46++;
                    }
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    while (i12 < i46) {
                        int i50 = iArr2[i12];
                        i13 += (i12 + 2) * i50;
                        i12++;
                        i14 += i50 * i12;
                    }
                    int i51 = i13 % 107;
                    int i52 = i46 + 1;
                    int i53 = (i14 + (i51 * i52)) % 107;
                    iArr2[i46] = i51;
                    iArr2[i52] = i53;
                    this.f416o = "";
                    this.f417p = new String[i45];
                    this.f418q = i45;
                    this.f419r = new int[i45];
                    w("Symbol Rows: " + i45);
                    w("First Check Digit: " + i51);
                    w("Second Check Digit: " + i53);
                    u("Codewords: ");
                    for (i15 = 0; i15 < i45; i15++) {
                        string = ("" + f552C[f553D[i15]]) + "1";
                        for (i16 = 0; i16 < 5; i16++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(string);
                            int i54 = (i15 * 5) + i16;
                            sb.append(f551B[iArr2[i54]]);
                            string = sb.toString();
                            y(iArr2[i54]);
                        }
                        this.f417p[i15] = string + f552C[f554E[i15]];
                        this.f419r[i15] = 10;
                    }
                    v();
                    return;
                }
                i47 = 101;
                i48 = 100;
                i4 = 1;
            } else {
                c5 = 'b';
            }
            iArr2[i46] = c5;
            i46++;
            iArr = this.f415n;
            i8 = iArr[i49];
            if (i8 != -1) {
                c6 = cArr[i49];
                if (c6 == 'a') {
                    N(i8, iArr2, i46);
                    i46++;
                    i49++;
                } else {
                    if (c6 != c5) {
                        switch (c6) {
                            case 'A':
                                N(i8, iArr2, i46);
                                i46++;
                                i49++;
                                break;
                            case 'C':
                                P(i8, iArr[i49 + 1], iArr2, i46);
                                i46++;
                                i49 += 2;
                                break;
                        }
                    }
                    O(i8, iArr2, i46);
                    i46++;
                    i49++;
                }
            } else {
                iArr2[i46] = 102;
                i46++;
                i49++;
            }
            if (i49 >= length) {
                i9 = 5 - ((i46 + 2) % 5);
                if (i9 == 5) {
                    i9 = 0;
                }
                i10 = i46 + i9;
                if (i10 < 8) {
                    i9 += 8 - i10;
                }
                while (i11 < i9) {
                    iArr2[i46] = 106;
                    i46++;
                }
                i12 = 0;
                i13 = 0;
                i14 = 0;
                while (i12 < i46) {
                    int i55 = iArr2[i12];
                    i13 += (i12 + 2) * i55;
                    i12++;
                    i14 += i55 * i12;
                }
                int i56 = i13 % 107;
                int i57 = i46 + 1;
                int i58 = (i14 + (i56 * i57)) % 107;
                iArr2[i46] = i56;
                iArr2[i57] = i58;
                this.f416o = "";
                this.f417p = new String[i45];
                this.f418q = i45;
                this.f419r = new int[i45];
                w("Symbol Rows: " + i45);
                w("First Check Digit: " + i56);
                w("Second Check Digit: " + i58);
                u("Codewords: ");
                while (i15 < i45) {
                    string = ("" + f552C[f553D[i15]]) + "1";
                    while (i16 < 5) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(string);
                        int i59 = (i15 * 5) + i16;
                        sb2.append(f551B[iArr2[i59]]);
                        string = sb2.toString();
                        y(iArr2[i59]);
                    }
                    this.f417p[i15] = string + f552C[f554E[i15]];
                    this.f419r[i15] = 10;
                }
                v();
                return;
            }
            i47 = 101;
            i48 = 100;
            i4 = 1;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
