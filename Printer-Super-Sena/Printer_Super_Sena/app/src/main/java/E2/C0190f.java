package E2;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: E2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0190f extends Q {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String[] f501E = {"212222", "222122", "222221", "121223", "121322", "131222", "122213", "122312", "132212", "221213", "221312", "231212", "112232", "122132", "122231", "113222", "123122", "123221", "223211", "221132", "221231", "213212", "223112", "312131", "311222", "321122", "321221", "312212", "322112", "322211", "212123", "212321", "232121", "111323", "131123", "131321", "112313", "132113", "132311", "211313", "231113", "231311", "112133", "112331", "132131", "113123", "113321", "133121", "313121", "211331", "231131", "213113", "213311", "213131", "311123", "311321", "331121", "312113", "312311", "332111", "314111", "221411", "431111", "111224", "111422", "121124", "121421", "141122", "141221", "112214", "112412", "122114", "122411", "142112", "142211", "241211", "221114", "413111", "241112", "134111", "111242", "121142", "121241", "114212", "124112", "124211", "411212", "421112", "421211", "212141", "214121", "412121", "111143", "111341", "131141", "114113", "114311", "411113", "411311", "113141", "114131", "311141", "411131", "211412", "211214", "211232", "2331112"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f502A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f503B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private a f504C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int[][] f506z = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 44, 62);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final a[] f505D = new a[44];

    /* JADX INFO: renamed from: E2.f$a */
    private enum a {
        MODEA,
        MODEB,
        MODEC
    }

    /* JADX INFO: renamed from: E2.f$b */
    private enum b {
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

    private int L(int i3) {
        if (i3 < 32) {
            return i3 + 64;
        }
        if (i3 <= 127) {
            return i3 - 32;
        }
        return i3 <= 159 ? i3 - 64 : i3 - 160;
    }

    private a M(int i3) {
        int i4 = this.f415n[i3];
        if (i4 >= 48 && i4 <= 57) {
            return a.MODEC;
        }
        if (i4 < 128 || i4 > 160) {
            return (i4 < 0 || i4 > 31) ? a.MODEB : a.MODEA;
        }
        return a.MODEA;
    }

    private void N() {
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int length = this.f415n.length - 1;
        a aVarM = a.MODEA;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        boolean z4 = false;
        do {
            if (i7 == 0) {
                i10 = this.f502A;
                aVarM = M(i8);
                this.f505D[i9] = aVarM;
                if (i9 == 0 && this.f403b == Q.a.GS1) {
                    this.f506z[i9][i7] = 102;
                    i7++;
                    i10--;
                }
            }
            if (this.f415n[i8] == -1) {
                this.f506z[i9][i7] = 102;
                i7++;
                i10--;
                i8++;
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 && i10 <= 2) {
                int iOrdinal = aVarM.ordinal();
                if (iOrdinal == 0) {
                    if (O(this.f415n[i8]) == b.ABORC) {
                        this.f506z[i9][i7] = L(this.f415n[i8]);
                        i7++;
                        i10--;
                        i8++;
                        z3 = true;
                    }
                    if (O(this.f415n[i8]) == b.SHIFTB && i10 == 1) {
                        this.f506z[i9][i7] = 100;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                    int[] iArr2 = this.f415n;
                    if (iArr2[i8] >= 244 && !z3) {
                        int[] iArr3 = this.f506z[i9];
                        iArr3[i7] = 100;
                        int i11 = i7 + 1;
                        int i12 = i10 - 1;
                        if (i12 == 1) {
                            iArr3[i11] = 101;
                            i11 = i7 + 2;
                            i12 = i10 - 2;
                        }
                        i7 = i11;
                        i10 = i12;
                        z3 = true;
                    }
                    if (iArr2[i8] >= 128 && !z3 && i10 == 1) {
                        this.f506z[i9][i7] = 100;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                } else if (iOrdinal == 1) {
                    if (O(this.f415n[i8]) == b.ABORC) {
                        this.f506z[i9][i7] = L(this.f415n[i8]);
                        i7++;
                        i10--;
                        i8++;
                        z3 = true;
                    }
                    if (O(this.f415n[i8]) == b.SHIFTA && i10 == 1) {
                        this.f506z[i9][i7] = 101;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                    int[] iArr4 = this.f415n;
                    int i13 = iArr4[i8];
                    if (i13 >= 128 && i13 <= 159 && !z3) {
                        int[] iArr5 = this.f506z[i9];
                        iArr5[i7] = 101;
                        int i14 = i7 + 1;
                        int i15 = i10 - 1;
                        if (i15 == 1) {
                            iArr5[i14] = 100;
                            i14 = i7 + 2;
                            i15 = i10 - 2;
                        }
                        i7 = i14;
                        i10 = i15;
                        z3 = true;
                    }
                    if (iArr4[i8] >= 160 && !z3 && i10 == 1) {
                        this.f506z[i9][i7] = 101;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                } else if (iOrdinal == 2) {
                    b bVarO = O(this.f415n[i8]);
                    b bVar = b.ABORC;
                    if (bVarO != bVar && i10 == 1) {
                        this.f506z[i9][i7] = 101;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                    if (O(this.f415n[i8]) == bVar && O(this.f415n[i8 + 1]) != bVar && i10 == 1) {
                        this.f506z[i9][i7] = 101;
                        i7++;
                        i10--;
                        z3 = true;
                    }
                    if (this.f415n[i8] >= 128) {
                        int[] iArr6 = this.f506z[i9];
                        iArr6[i7] = 101;
                        int i16 = i7 + 1;
                        int i17 = i10 - 1;
                        if (i17 == 1) {
                            iArr6[i16] = 100;
                            i7 += 2;
                            i10 -= 2;
                        } else {
                            i10 = i17;
                            i7 = i16;
                        }
                    }
                }
            }
            if (!z3 && ((O(this.f415n[i8]) == b.AORB || O(this.f415n[i8]) == b.SHIFTA) && aVarM == a.MODEA)) {
                int[] iArr7 = this.f415n;
                if (iArr7[i8] >= 128) {
                    this.f506z[i9][i7] = 101;
                    i7++;
                    i10--;
                }
                this.f506z[i9][i7] = L(iArr7[i8]);
                i7++;
                i10--;
                i8++;
                z3 = true;
            }
            if (!z3 && ((O(this.f415n[i8]) == b.AORB || O(this.f415n[i8]) == b.SHIFTB) && aVarM == a.MODEB)) {
                int[] iArr8 = this.f415n;
                if (iArr8[i8] >= 128) {
                    this.f506z[i9][i7] = 100;
                    i7++;
                    i10--;
                }
                this.f506z[i9][i7] = L(iArr8[i8]);
                i7++;
                i10--;
                i8++;
                z3 = true;
            }
            if (!z3) {
                b bVarO2 = O(this.f415n[i8]);
                b bVar2 = b.ABORC;
                if (bVarO2 == bVar2) {
                    int i18 = i8 + 1;
                    if (O(this.f415n[i18]) == bVar2 && aVarM == a.MODEC) {
                        int[] iArr9 = this.f506z[i9];
                        int[] iArr10 = this.f415n;
                        iArr9[i7] = ((iArr10[i8] - 48) * 10) + (iArr10[i18] - 48);
                        i7++;
                        i10--;
                        i8 += 2;
                        z3 = true;
                    }
                }
            }
            if (!z3 && (aVarM == a.MODEA || aVarM == a.MODEB)) {
                if (O(this.f415n[i8]) != b.ABORC) {
                    i6 = -1;
                    if (this.f415n[i8] == -1) {
                    }
                } else {
                    i6 = -1;
                }
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    int i21 = i19 + 1;
                    int[] iArr11 = this.f415n;
                    i19 = iArr11[i8 + i20] == i6 ? i19 + 2 : i21;
                    i20++;
                    int i22 = i8 + i20;
                    if (O(iArr11[i22]) != b.ABORC) {
                        iArr = this.f415n;
                        if (iArr[i22] != -1) {
                            break;
                        }
                    }
                    i6 = -1;
                }
                int i23 = i19 - 1;
                if (i23 < 4 || i23 % 2 != 1) {
                    this.f506z[i9][i7] = L(iArr[i8]);
                    i7++;
                    i10--;
                    i8++;
                } else {
                    int[] iArr12 = this.f506z[i9];
                    iArr12[i7] = 99;
                    iArr12[i7 + 1] = ((iArr[i8] - 48) * 10) + (iArr[i8 + 1] - 48);
                    i7 += 2;
                    i10 -= 2;
                    i8 += 2;
                    aVarM = a.MODEC;
                }
                z3 = true;
            }
            if (!z3 && aVarM == a.MODEB && O(this.f415n[i8]) == b.SHIFTA) {
                int[] iArr13 = this.f415n;
                int i24 = i8 + 1;
                int i25 = iArr13[i24];
                if (i25 < 96 || i25 > 127) {
                    int[] iArr14 = this.f506z[i9];
                    iArr14[i7] = 101;
                    int i26 = i7 + 1;
                    int i27 = i10 - 1;
                    if (iArr13[i8] >= 128) {
                        iArr14[i26] = 100;
                        i26 = i7 + 2;
                        i27 = i10 - 2;
                    }
                    iArr14[i26] = L(iArr13[i8]);
                    aVarM = a.MODEA;
                    i7 = i26 + 1;
                    i10 = i27 - 1;
                } else {
                    int[] iArr15 = this.f506z[i9];
                    iArr15[i7] = 98;
                    int i28 = i7 + 1;
                    int i29 = i10 - 1;
                    if (iArr13[i8] >= 128) {
                        iArr15[i28] = 100;
                        i28 = i7 + 2;
                        i29 = i10 - 2;
                    }
                    iArr15[i28] = L(iArr13[i8]);
                    i7 = i28 + 1;
                    i10 = i29 - 1;
                }
                i8 = i24;
                z3 = true;
            }
            if (!z3 && aVarM == a.MODEA) {
                b bVarO3 = O(this.f415n[i8]);
                b bVar3 = b.SHIFTB;
                if (bVarO3 == bVar3) {
                    int i30 = i8 + 1;
                    if (O(this.f415n[i30]) == b.SHIFTA && O(this.f415n[i8 + 2]) == bVar3) {
                        int[] iArr16 = this.f506z[i9];
                        iArr16[i7] = 98;
                        int i31 = i7 + 1;
                        int i32 = i10 - 1;
                        int[] iArr17 = this.f415n;
                        if (iArr17[i8] >= 128) {
                            iArr16[i31] = 101;
                            i31 = i7 + 2;
                            i32 = i10 - 2;
                        }
                        iArr16[i31] = L(iArr17[i8]);
                        i7 = i31 + 1;
                        i10 = i32 - 1;
                    } else {
                        int[] iArr18 = this.f506z[i9];
                        iArr18[i7] = 100;
                        int i33 = i7 + 1;
                        int i34 = i10 - 1;
                        int[] iArr19 = this.f415n;
                        if (iArr19[i8] >= 128) {
                            iArr18[i33] = 101;
                            i33 = i7 + 2;
                            i34 = i10 - 2;
                        }
                        iArr18[i33] = L(iArr19[i8]);
                        aVarM = a.MODEB;
                        i7 = i33 + 1;
                        i10 = i34 - 1;
                    }
                    i8 = i30;
                    z3 = true;
                }
            }
            if (!z3 && aVarM == a.MODEC) {
                b bVarO4 = O(this.f415n[i8]);
                b bVar4 = b.ABORC;
                if (bVarO4 != bVar4 || O(this.f415n[i8 + 1]) != bVar4) {
                    if (O(this.f415n[i8]) == b.SHIFTA) {
                        int[] iArr20 = this.f506z[i9];
                        iArr20[i7] = 101;
                        int i35 = i7 + 1;
                        int i36 = i10 - 1;
                        int[] iArr21 = this.f415n;
                        if (iArr21[i8] >= 128) {
                            iArr20[i35] = 101;
                            i35 = i7 + 2;
                            i36 = i10 - 2;
                        }
                        iArr20[i35] = L(iArr21[i8]);
                        i4 = i35 + 1;
                        i5 = i36 - 1;
                        i8++;
                        aVarM = a.MODEA;
                    } else {
                        int[] iArr22 = this.f506z[i9];
                        iArr22[i7] = 100;
                        int i37 = i7 + 1;
                        int i38 = i10 - 1;
                        int[] iArr23 = this.f415n;
                        if (iArr23[i8] >= 128) {
                            iArr22[i37] = 100;
                            i37 = i7 + 2;
                            i38 = i10 - 2;
                        }
                        iArr22[i37] = L(iArr23[i8]);
                        i4 = i37 + 1;
                        i5 = i38 - 1;
                        i8++;
                        aVarM = a.MODEB;
                    }
                    i7 = i4;
                    i10 = i5;
                }
            }
            if (i8 == length) {
                if (i10 == 1) {
                    a aVar = a.MODEA;
                    if (aVarM == aVar) {
                        this.f506z[i9][i7] = 100;
                        aVarM = a.MODEB;
                    } else {
                        this.f506z[i9][i7] = 101;
                        aVarM = aVar;
                    }
                    i7++;
                    i10--;
                }
                if (i10 == 0) {
                    i10 = this.f502A;
                    i9++;
                    a[] aVarArr = this.f505D;
                    a aVar2 = a.MODEA;
                    aVarArr[i9] = aVar2;
                    aVarM = aVar2;
                    i3 = 2;
                    i7 = 0;
                } else {
                    i3 = 2;
                }
                if (i10 > i3) {
                    do {
                        a aVar3 = a.MODEA;
                        if (aVarM == aVar3) {
                            this.f506z[i9][i7] = 100;
                            aVarM = a.MODEB;
                        } else {
                            this.f506z[i9][i7] = 101;
                            aVarM = aVar3;
                        }
                        i7++;
                        i10--;
                    } while (i10 > 2);
                }
                this.f504C = aVarM;
                z4 = true;
            } else if (i10 <= 0) {
                i9++;
                if (i9 > 43) {
                    throw new H("Too many rows.");
                }
                i7 = 0;
            }
        } while (!z4);
        if (i9 == 0) {
            while (i7 <= this.f502A) {
                a aVar4 = a.MODEA;
                if (aVarM == aVar4) {
                    this.f506z[i9][i7] = 100;
                    aVar4 = a.MODEB;
                } else {
                    this.f506z[i9][i7] = 101;
                }
                aVarM = aVar4;
                i7++;
            }
            i9++;
            a[] aVarArr2 = this.f505D;
            a aVar5 = a.MODEA;
            aVarArr2[i9] = aVar5;
            int i39 = 0;
            while (i39 <= this.f502A - 2) {
                a aVar6 = a.MODEA;
                if (aVar5 == aVar6) {
                    this.f506z[i9][i39] = 100;
                    aVar6 = a.MODEB;
                } else {
                    this.f506z[i9][i39] = 101;
                }
                i39++;
                aVar5 = aVar6;
            }
        }
        this.f503B = i9 + 1;
    }

    private b O(int i3) {
        if (i3 == -1) {
            return b.AORB;
        }
        if (i3 <= 31) {
            return b.SHIFTA;
        }
        if (i3 >= 48 && i3 <= 57) {
            return b.ABORC;
        }
        if (i3 <= 95) {
            return b.AORB;
        }
        if (i3 <= 127) {
            return b.SHIFTB;
        }
        if (i3 <= 159) {
            return b.SHIFTA;
        }
        return i3 <= 223 ? b.AORB : b.SHIFTB;
    }

    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        while (i3 < this.f418q) {
            int i6 = 0;
            boolean z3 = true;
            int iCharAt = 0;
            while (i6 < this.f417p[i3].length()) {
                if (z3) {
                    int iCharAt2 = this.f417p[i3].charAt(i6) - '0';
                    int i7 = this.f419r[i3];
                    if (i7 == -1) {
                        i7 = this.f405d;
                    }
                    if (iCharAt2 != 0 && i7 != 0) {
                        this.f423v.add(new G2.e(iCharAt, i4, iCharAt2, i7));
                    }
                    int i8 = iCharAt2 + iCharAt;
                    if (i8 > this.f421t) {
                        this.f421t = i8;
                    }
                    i5 = i7;
                    z3 = false;
                } else {
                    i3 = i3;
                    i4 = i4;
                    z3 = true;
                }
                iCharAt += this.f417p[i3].charAt(i6) - '0';
                i6++;
                i3 = i3;
                i4 = i4;
            }
            int i9 = i3;
            i4 += i5;
            if (i4 > this.f420s) {
                this.f420s = i4;
            }
            if (i9 != this.f418q - 1) {
                this.f423v.add(new G2.e(11.0d, i4 - 1, this.f421t - 24, 2.0d));
            }
            i3 = i9 + 1;
        }
        this.f423v.add(new G2.e(0.0d, 0.0d, this.f421t, 2.0d));
        this.f423v.add(new G2.e(0.0d, i4 - 1, this.f421t, 2.0d));
        this.f420s++;
    }

    @Override // E2.Q
    protected void c() {
        int i3;
        int i4;
        int[] iArr = new int[44];
        int[] iArr2 = new int[44];
        this.f504C = a.MODEA;
        if (!this.f413l.matches("[\u0000-ÿ]+")) {
            throw new H("Invalid characters in input data");
        }
        int[] iArrK = Q.K(this.f413l, StandardCharsets.ISO_8859_1, 0);
        this.f415n = iArrK;
        int length = iArrK.length - 1;
        if (length > 5450) {
            throw new H("Input data too long");
        }
        b bVar = b.AORB;
        double d3 = 0.0d;
        int i5 = 0;
        while (i5 < length) {
            b bVarO = O(this.f415n[i5]);
            if (bVarO != bVar) {
                d3 += 1.0d;
            }
            d3 = bVarO != b.ABORC ? d3 + 1.0d : d3 + 0.5d;
            if (this.f415n[i5] > 127) {
                d3 += 1.0d;
            }
            i5++;
            bVar = bVarO;
        }
        double d4 = d3 + 2.0d;
        int iSqrt = (int) (Math.sqrt(d4 / 1.45d) + 0.5d);
        this.f503B = iSqrt;
        if (iSqrt < 2) {
            this.f503B = 2;
        }
        if (this.f503B > 44) {
            this.f503B = 44;
        }
        int i6 = ((int) d4) / this.f503B;
        this.f502A = i6;
        if (i6 < 4) {
            this.f502A = 4;
        }
        if (this.f502A > 62) {
            throw new H("Input data too long");
        }
        N();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = this.f415n[i9];
            if (i10 == -1) {
                i7 += (i9 + 1) * 29;
                i4 = i9 * 29;
            } else {
                i7 += (i9 + 1) * i10;
                i4 = i10 * i9;
            }
            i8 += i4;
        }
        int i11 = i7 % 86;
        int i12 = i8 % 86;
        a aVar = this.f504C;
        if (aVar == a.MODEA || aVar == a.MODEB) {
            int i13 = i11 + 64;
            i11 = i13 > 95 ? i11 - 32 : i13;
            int i14 = i12 + 64;
            i12 = i14 > 95 ? i12 - 32 : i14;
        }
        int[][] iArr3 = this.f506z;
        int i15 = this.f503B;
        int[] iArr4 = iArr3[i15 - 1];
        int i16 = this.f502A;
        iArr4[i16 - 2] = i11;
        iArr3[i15 - 1][i16 - 1] = i12;
        if (this.f505D[0] == a.MODEC) {
            iArr[0] = i15 - 2;
        } else {
            int i17 = i15 + 62;
            iArr[0] = i17;
            if (i17 > 95) {
                iArr[0] = i15 - 33;
            }
        }
        for (int i18 = 1; i18 < this.f503B; i18++) {
            if (this.f505D[i18] == a.MODEC) {
                iArr[i18] = i18 + 42;
            } else if (i18 < 6) {
                iArr[i18] = i18 + 10;
            } else {
                iArr[i18] = i18 + 20;
            }
        }
        int i19 = 0;
        while (true) {
            i3 = this.f503B;
            int i20 = 103;
            if (i19 >= i3) {
                break;
            }
            int iOrdinal = this.f505D[i19].ordinal();
            if (iOrdinal == 0) {
                i20 = 201;
            } else if (iOrdinal == 1) {
                i20 = 203;
            } else if (iOrdinal == 2) {
                i20 = 202;
            }
            int i21 = i20 + (iArr[i19] * 2);
            for (int i22 = 0; i22 < this.f502A; i22++) {
                i21 += (i22 + 3) * this.f506z[i19][i22];
            }
            iArr2[i19] = i21 % 103;
            i19++;
        }
        this.f416o = "";
        this.f418q = i3;
        this.f417p = new String[i3];
        this.f419r = new int[i3];
        w("Grid Size: " + this.f502A + " X " + this.f503B);
        StringBuilder sb = new StringBuilder();
        sb.append("K1 Check Digit: ");
        sb.append(i11);
        w(sb.toString());
        w("K2 Check Digit: " + i12);
        u("Encoding: ");
        for (int i23 = 0; i23 < this.f503B; i23++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            String[] strArr = f501E;
            sb2.append(strArr[103]);
            String string = sb2.toString();
            int iOrdinal2 = this.f505D[i23].ordinal();
            if (iOrdinal2 == 0) {
                string = string + strArr[98];
                u("MODEA ");
            } else if (iOrdinal2 == 1) {
                string = string + strArr[100];
                u("MODEB ");
            } else if (iOrdinal2 == 2) {
                string = string + strArr[99];
                u("MODEC ");
            }
            String str = string + strArr[iArr[i23]];
            y(iArr[i23]);
            for (int i24 = 0; i24 < this.f502A; i24++) {
                str = str + f501E[this.f506z[i23][i24]];
                y(this.f506z[i23][i24]);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            String[] strArr2 = f501E;
            sb3.append(strArr2[iArr2[i23]]);
            String string2 = sb3.toString();
            u("(" + iArr2[i23] + ") ");
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string2);
            sb4.append(strArr2[106]);
            this.f417p[i23] = sb4.toString();
            this.f419r[i23] = 15;
        }
        v();
        this.f420s = this.f503B * 15;
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
