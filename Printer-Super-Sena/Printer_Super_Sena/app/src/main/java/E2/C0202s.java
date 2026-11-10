package E2;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: E2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0202s extends Q {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final int[] f716C = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f717D = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f718E = {12, 10, 8, 6, 4};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f719F = {5, 7, 9, 11, 13};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f720G = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f721H = {2, 4, 5, 6, 8};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f722I = {1, 3, 9, 27, 81, 32, 96, 77, 20, 60, 180, 118, 143, 7, 21, 63, 189, 145, 13, 39, 117, 140, 209, 205, 193, 157, 49, 147, 19, 57, 171, 91, 62, 186, 136, 197, 169, 85, 44, 132, 185, 133, 188, 142, 4, 12, 36, 108, 113, 128, 173, 97, 80, 29, 87, 50, 150, 28, 84, 41, 123, 158, 52, 156, 46, 138, 203, 187, 139, 206, 196, 166, 76, 17, 51, 153, 37, 111, 122, 155, 43, 129, 176, 106, 107, 110, 119, 146, 16, 48, 144, 10, 30, 90, 59, 177, 109, 116, 137, 200, 178, 112, 125, 164, 70, 210, 208, 202, 184, 130, 179, 115, 134, 191, 151, 31, 93, 68, 204, 190, 148, 22, 66, 198, 172, 94, 71, 2, 6, 18, 54, 162, 64, 192, 154, 40, 120, 149, 25, 75, 14, 42, 126, 167, 79, 26, 78, 23, 69, 207, 199, 175, 103, 98, 83, 38, 114, 131, 182, 124, 161, 61, 183, 127, 170, 88, 53, 159, 55, 165, 73, 8, 24, 72, 5, 15, 45, 135, 194, 160, 58, 174, 100, 89};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f723J = {1, 8, 4, 1, 1, 1, 1, 4, 8, 1, 3, 6, 4, 1, 1, 1, 1, 4, 6, 3, 3, 4, 6, 1, 1, 1, 1, 6, 4, 3, 3, 2, 8, 1, 1, 1, 1, 8, 2, 3, 2, 6, 5, 1, 1, 1, 1, 5, 6, 2, 2, 2, 9, 1, 1, 1, 1, 9, 2, 2};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int[] f724K = {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6, 3, 8, 0, 0, 0, 0, 0, 0, 0, 1, 10, 3, 8, 5, 0, 0, 0, 0, 0, 0, 1, 10, 3, 8, 7, 12, 0, 0, 0, 0, 0, 1, 10, 3, 8, 9, 12, 11, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 10, 9, 0, 0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 0, 1, 2, 3, 4, 5, 8, 7, 10, 9, 12, 11};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f725L = {0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10, 3, 4, 13, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 18, 3, 4, 13, 14, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 18, 3, 4, 13, 14, 11, 12, 21, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 18, 3, 4, 13, 14, 15, 16, 21, 22, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 18, 15, 16, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 18, 19, 20, 21, 22, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 14, 11, 12, 17, 18, 15, 16, 21, 22, 19, 20};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f726A = 2;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean f727B = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f728z;

    /* JADX INFO: renamed from: E2.s$a */
    private enum a {
        NUMERIC,
        ALPHA,
        ISOIEC,
        INVALID_CHAR,
        ANY_ENC,
        ALPHA_OR_ISO
    }

    public C0202s() {
        this.f403b = Q.a.GS1;
    }

    private static boolean L(a[] aVarArr) {
        int i3;
        int i4;
        int[] iArr = new int[200];
        a[] aVarArr2 = new a[200];
        iArr[0] = 1;
        aVarArr2[0] = aVarArr[0];
        int i5 = 0;
        for (int i6 = 1; i6 < aVarArr.length; i6++) {
            a aVar = aVarArr[i6];
            if (aVar == aVarArr[i6 - 1]) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                i5++;
                iArr[i5] = 1;
                aVarArr2[i5] = aVar;
            }
        }
        int i7 = i5 + 1;
        int i8 = 0;
        while (i8 < i7) {
            a aVar2 = aVarArr2[i8];
            int i9 = i8 + 1;
            a aVar3 = aVarArr2[i9];
            a aVar4 = a.ISOIEC;
            if (aVar2 == aVar4 && i8 != i5) {
                a aVar5 = a.ANY_ENC;
                if (aVar3 == aVar5 && iArr[i9] >= 4) {
                    aVarArr2[i9] = a.NUMERIC;
                }
                if (aVar3 == aVar5 && iArr[i9] < 4) {
                    aVarArr2[i9] = aVar4;
                }
                a aVar6 = a.ALPHA_OR_ISO;
                if (aVar3 == aVar6 && iArr[i9] >= 5) {
                    aVarArr2[i9] = a.ALPHA;
                }
                if (aVar3 == aVar6 && iArr[i9] < 5) {
                    aVarArr2[i9] = aVar4;
                }
            }
            if (aVar2 == a.ALPHA_OR_ISO) {
                aVar2 = a.ALPHA;
                aVarArr2[i8] = aVar2;
            }
            a aVar7 = a.ALPHA;
            if (aVar2 == aVar7 && i8 != i5) {
                a aVar8 = a.ANY_ENC;
                if (aVar3 == aVar8 && iArr[i9] >= 6) {
                    aVarArr2[i9] = a.NUMERIC;
                }
                if (aVar3 == aVar8 && (i4 = iArr[i9]) < 6) {
                    if (i8 != i5 - 1 || i4 < 4) {
                        aVarArr2[i9] = aVar7;
                    } else {
                        aVarArr2[i9] = a.NUMERIC;
                    }
                }
            }
            if (aVar2 == a.ANY_ENC) {
                aVarArr2[i8] = a.NUMERIC;
            }
            i8 = i9;
        }
        if (i7 > 1) {
            int i10 = 1;
            while (i10 < i7) {
                int i11 = i10 - 1;
                if (aVarArr2[i11] == aVarArr2[i10]) {
                    iArr[i11] = iArr[i11] + iArr[i10];
                    for (int i12 = i10 + 1; i12 < i7; i12++) {
                        int i13 = i12 - 1;
                        iArr[i13] = iArr[i12];
                        aVarArr2[i13] = aVarArr2[i12];
                    }
                    i7--;
                    i10--;
                }
                i10++;
            }
        }
        int i14 = 0;
        while (true) {
            i3 = i7 - 1;
            if (i14 >= i3) {
                break;
            }
            if (aVarArr2[i14] == a.NUMERIC) {
                int i15 = iArr[i14];
                if ((i15 & 1) != 0) {
                    iArr[i14] = i15 - 1;
                    int i16 = i14 + 1;
                    iArr[i16] = iArr[i16] + 1;
                }
            }
            i14++;
        }
        int i17 = 0;
        for (int i18 = 0; i18 < i7; i18++) {
            for (int i19 = 0; i19 < iArr[i18]; i19++) {
                aVarArr[i17] = aVarArr2[i18];
                i17++;
            }
        }
        return aVarArr2[i3] == a.NUMERIC && (iArr[i3] & 1) != 0;
    }

    private static int M(boolean z3, int i3, int[] iArr, StringBuilder sb) {
        int length;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        a aVar;
        char c3;
        int i11;
        a aVar2 = a.NUMERIC;
        int i12 = (iArr.length >= 16 && iArr[0] == 48 && iArr[1] == 49) ? 1 : 2;
        if (iArr.length >= 20 && i12 == 1 && iArr[2] == 57 && iArr[16] == 51) {
            if (iArr.length >= 26 && iArr[17] == 49 && iArr[18] == 48) {
                double d3 = 0.0d;
                for (int i13 = 0; i13 < 6; i13++) {
                    double d4 = iArr[i13 + 20] - 48;
                    Double.isNaN(d4);
                    d3 = (d3 * 10.0d) + d4;
                }
                if (d3 < 99999.0d) {
                    if (iArr[19] == 51 && iArr.length == 26 && d3 / 1000.0d <= 32.767d) {
                        i12 = 3;
                    }
                    if (iArr.length == 34) {
                        int i14 = iArr[26];
                        if (i14 == 49 && iArr[27] == 49) {
                            i12 = 7;
                        }
                        if (i14 == 49 && iArr[27] == 51) {
                            i12 = 9;
                        }
                        if (i14 == 49 && iArr[27] == 53) {
                            i12 = 11;
                        }
                        if (i14 == 49 && iArr[27] == 55) {
                            i12 = 13;
                        }
                    }
                }
            }
            if (iArr.length >= 26 && iArr[17] == 50 && iArr[18] == 48) {
                double d5 = 0.0d;
                int i15 = 0;
                for (int i16 = 6; i15 < i16; i16 = 6) {
                    double d6 = iArr[i15 + 20] - 48;
                    Double.isNaN(d6);
                    d5 = (d5 * 10.0d) + d6;
                    i15++;
                }
                if (d5 < 99999.0d) {
                    int i17 = iArr[19];
                    if ((i17 == 50 || i17 == 51) && iArr.length == 26) {
                        i12 = i17 == 51 ? 4 : 4;
                    }
                    if (iArr.length == 34) {
                        int i18 = iArr[26];
                        if (i18 == 49 && iArr[27] == 49) {
                            i12 = 8;
                        }
                        if (i18 == 49 && iArr[27] == 51) {
                            i12 = 10;
                        }
                        if (i18 == 49 && iArr[27] == 53) {
                            i12 = 12;
                        }
                        if (i18 == 49 && iArr[27] == 55) {
                            i12 = 14;
                        }
                    }
                }
            }
            if (iArr[17] == 57) {
                int i19 = iArr[18];
                if (i19 == 50) {
                    c3 = 19;
                    int i20 = iArr[19];
                    if (i20 >= 48 && i20 <= 51) {
                        i12 = 5;
                    }
                } else {
                    c3 = 19;
                }
                if (i19 == 51 && (i11 = iArr[c3]) >= 48 && i11 <= 51) {
                    i12 = 6;
                }
            }
        }
        switch (i12) {
            case 1:
                sb.append("1XX");
                length = 16;
                break;
            case 2:
                sb.append("00XX");
                length = 0;
                break;
            case 3:
                sb.append("0100");
                length = iArr.length;
                break;
            case 4:
                sb.append("0101");
                length = iArr.length;
                break;
            case 5:
                sb.append("01100XX");
                length = 20;
                break;
            case 6:
                sb.append("01101XX");
                length = 23;
                break;
            default:
                sb.append("0" + Integer.toBinaryString(i12 + 49));
                length = iArr.length;
                break;
        }
        for (int i21 = 0; i21 < length; i21++) {
            int i22 = iArr[i21];
            if (i22 < 48 || i22 > 57) {
                throw new H("Invalid characters in input data");
            }
        }
        if (i12 == 1) {
            G2.f.a(sb, iArr[2] - 48, 4);
            int i23 = 1;
            for (int i24 = 5; i23 < i24; i24 = 5) {
                G2.f.a(sb, P(iArr, i23 * 3, 3), 10);
                i23++;
            }
        }
        int i25 = 3;
        if (i12 == 3 || i12 == 4) {
            int i26 = 5;
            int i27 = 1;
            while (i27 < i26) {
                G2.f.a(sb, P(iArr, i27 * 3, i25), 10);
                i27++;
                i26 = 5;
                i25 = 3;
            }
            int iP = P(iArr, 20, 6);
            if (i12 == 4 && iArr[19] == 51) {
                iP += 10000;
            }
            G2.f.a(sb, iP, 15);
        }
        if (i12 == 5 || i12 == 6) {
            int i28 = 1;
            for (int i29 = 5; i28 < i29; i29 = 5) {
                G2.f.a(sb, P(iArr, i28 * 3, 3), 10);
                i28++;
            }
            i4 = 3;
            i5 = 10;
            G2.f.a(sb, iArr[19] - 48, 2);
            if (i12 == 6) {
                G2.f.a(sb, P(iArr, 20, 3), 10);
            }
            i6 = 7;
        } else {
            i6 = 7;
            i4 = 3;
            i5 = 10;
        }
        if (i12 >= i6 && i12 <= 14) {
            int i30 = 1;
            while (i30 < 5) {
                G2.f.a(sb, P(iArr, i30 * 3, i4), i5);
                i30++;
                i4 = 3;
            }
            int i31 = iArr[19] - 48;
            int i32 = 0;
            for (int i33 = 5; i32 < i33; i33 = 5) {
                i31 = (i31 * 10) + (iArr[i32 + 21] - 48);
                i32++;
            }
            G2.f.a(sb, i31, 20);
            G2.f.a(sb, iArr.length == 34 ? (P(iArr, 28, 2) * 384) + ((P(iArr, 30, 2) - 1) * 32) + P(iArr, 32, 2) : 38400, 16);
        }
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, length, iArr.length);
        String str = "0000";
        if (iArrCopyOfRange.length != 0) {
            a[] aVarArr = new a[iArrCopyOfRange.length];
            boolean z4 = false;
            for (int i34 = 0; i34 < iArrCopyOfRange.length; i34++) {
                int i35 = iArrCopyOfRange[i34];
                if (i35 == -1) {
                    aVar = a.ANY_ENC;
                } else if (i35 >= 48 && i35 <= 57) {
                    aVar = a.ANY_ENC;
                } else if ((i35 >= 65 && i35 <= 90) || i35 == 42 || i35 == 44 || i35 == 45 || i35 == 46 || i35 == 47) {
                    aVar = a.ALPHA_OR_ISO;
                } else if ((i35 >= 97 && i35 <= 122) || i35 == 33 || i35 == 34 || i35 == 37 || i35 == 38 || i35 == 39 || i35 == 40 || i35 == 41 || i35 == 43 || i35 == 58 || i35 == 59 || i35 == 60 || i35 == 61 || i35 == 62 || i35 == 63 || i35 == 95 || i35 == 32) {
                    aVar = a.ISOIEC;
                } else {
                    aVar = a.INVALID_CHAR;
                    z4 = true;
                }
                aVarArr[i34] = aVar;
            }
            if (z4) {
                throw new H("Invalid characters in input data");
            }
            for (int i36 = 0; i36 < iArrCopyOfRange.length - 1; i36++) {
                a aVar3 = aVarArr[i36];
                a aVar4 = a.ISOIEC;
                if (aVar3 == aVar4) {
                    int i37 = i36 + 1;
                    if (iArrCopyOfRange[i37] == -1) {
                        aVarArr[i37] = aVar4;
                    }
                }
            }
            for (int i38 = 0; i38 < iArrCopyOfRange.length - 1; i38++) {
                a aVar5 = aVarArr[i38];
                a aVar6 = a.ALPHA_OR_ISO;
                if (aVar5 == aVar6) {
                    int i39 = i38 + 1;
                    if (iArrCopyOfRange[i39] == -1) {
                        aVarArr[i39] = aVar6;
                    }
                }
            }
            boolean zL = L(aVarArr);
            a aVar7 = aVarArr[0];
            a aVar8 = a.ALPHA;
            if (aVar7 == aVar8) {
                sb.append("0000");
                aVar2 = aVar8;
            }
            a aVar9 = aVarArr[0];
            a aVar10 = a.ISOIEC;
            if (aVar9 == aVar10) {
                sb.append("0000");
                sb.append("00100");
                aVar2 = aVar10;
            }
            int i40 = zL ? 1 : 0;
            int i41 = 0;
            while (i40 < iArrCopyOfRange.length) {
                int iOrdinal = aVarArr[i41].ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        if (i41 != 0) {
                            if (aVar2 == a.NUMERIC) {
                                sb.append("0000");
                            }
                            if (aVar2 == a.ISOIEC) {
                                sb.append("00100");
                            }
                        }
                        int i42 = iArrCopyOfRange[i41];
                        if (i42 >= 48 && i42 <= 57) {
                            G2.f.a(sb, i42 - 43, 5);
                        }
                        int i43 = iArrCopyOfRange[i41];
                        if (i43 >= 65 && i43 <= 90) {
                            G2.f.a(sb, i43 - 33, 6);
                        }
                        aVar2 = a.ALPHA;
                        if (iArrCopyOfRange[i41] == -1) {
                            sb.append("01111");
                        }
                        if (iArrCopyOfRange[i41] == 42) {
                            sb.append("111010");
                        }
                        if (iArrCopyOfRange[i41] == 44) {
                            sb.append("111011");
                        }
                        if (iArrCopyOfRange[i41] == 45) {
                            sb.append("111100");
                        }
                        if (iArrCopyOfRange[i41] == 46) {
                            sb.append("111101");
                        }
                        if (iArrCopyOfRange[i41] == 47) {
                            sb.append("111110");
                        }
                    } else if (iOrdinal == 2) {
                        if (i41 != 0) {
                            if (aVar2 == a.NUMERIC) {
                                sb.append("0000");
                                sb.append("00100");
                            }
                            if (aVar2 == a.ALPHA) {
                                sb.append("00100");
                            }
                        }
                        int i44 = iArrCopyOfRange[i41];
                        if (i44 >= 48 && i44 <= 57) {
                            G2.f.a(sb, i44 - 43, 5);
                        }
                        int i45 = iArrCopyOfRange[i41];
                        if (i45 < 65 || i45 > 90) {
                            i10 = 7;
                        } else {
                            i10 = 7;
                            G2.f.a(sb, i45 - 1, 7);
                        }
                        int i46 = iArrCopyOfRange[i41];
                        if (i46 >= 97 && i46 <= 122) {
                            G2.f.a(sb, i46 - 7, i10);
                        }
                        aVar2 = a.ISOIEC;
                        if (iArrCopyOfRange[i41] == -1) {
                            sb.append("01111");
                        }
                        if (iArrCopyOfRange[i41] == 33) {
                            sb.append("11101000");
                        }
                        if (iArrCopyOfRange[i41] == 34) {
                            sb.append("11101001");
                        }
                        if (iArrCopyOfRange[i41] == 37) {
                            sb.append("11101010");
                        }
                        if (iArrCopyOfRange[i41] == 38) {
                            sb.append("11101011");
                        }
                        if (iArrCopyOfRange[i41] == 39) {
                            sb.append("11101100");
                        }
                        if (iArrCopyOfRange[i41] == 40) {
                            sb.append("11101101");
                        }
                        if (iArrCopyOfRange[i41] == 41) {
                            sb.append("11101110");
                        }
                        if (iArrCopyOfRange[i41] == 42) {
                            sb.append("11101111");
                        }
                        if (iArrCopyOfRange[i41] == 43) {
                            sb.append("11110000");
                        }
                        if (iArrCopyOfRange[i41] == 44) {
                            sb.append("11110001");
                        }
                        if (iArrCopyOfRange[i41] == 45) {
                            sb.append("11110010");
                        }
                        if (iArrCopyOfRange[i41] == 46) {
                            sb.append("11110011");
                        }
                        if (iArrCopyOfRange[i41] == 47) {
                            sb.append("11110100");
                        }
                        if (iArrCopyOfRange[i41] == 58) {
                            sb.append("11110101");
                        }
                        if (iArrCopyOfRange[i41] == 59) {
                            sb.append("11110110");
                        }
                        if (iArrCopyOfRange[i41] == 60) {
                            sb.append("11110111");
                        }
                        if (iArrCopyOfRange[i41] == 61) {
                            sb.append("11111000");
                        }
                        if (iArrCopyOfRange[i41] == 62) {
                            sb.append("11111001");
                        }
                        if (iArrCopyOfRange[i41] == 63) {
                            sb.append("11111010");
                        }
                        if (iArrCopyOfRange[i41] == 95) {
                            sb.append("11111011");
                        }
                        if (iArrCopyOfRange[i41] == 32) {
                            sb.append("11111100");
                        }
                    }
                    i41++;
                } else {
                    a aVar11 = a.NUMERIC;
                    if (aVar2 != aVar11) {
                        sb.append("000");
                    }
                    int i47 = iArrCopyOfRange[i41];
                    int i48 = i47 != -1 ? i47 - 48 : 10;
                    int i49 = iArrCopyOfRange[i41 + 1];
                    G2.f.a(sb, (i48 * 11) + (i49 != -1 ? i49 - 48 : 10) + 8, 7);
                    i41 += 2;
                    aVar2 = aVar11;
                }
                i40 = zL ? i41 + 1 : i41;
            }
            int iN = N(sb.length(), z3, i3);
            if (zL) {
                if (aVar2 != a.NUMERIC) {
                    G2.f.a(sb, iArrCopyOfRange[i41] - 43, 5);
                } else if (iN < 4 || iN > 6) {
                    G2.f.a(sb, ((iArrCopyOfRange[i41] - 48) * 11) + 18, 7);
                } else {
                    G2.f.a(sb, iArrCopyOfRange[i41] - 47, 4);
                }
            }
        }
        if (sb.length() > 252) {
            throw new H("Input too long");
        }
        int iN2 = N(sb.length(), z3, i3);
        if (aVar2 == a.NUMERIC) {
            i7 = iN2 - 4;
        } else {
            str = "";
            i7 = iN2;
        }
        while (i7 > 0) {
            str = str + "00100";
            i7 -= 5;
        }
        sb.append(str.substring(0, iN2));
        char c4 = (((sb.length() / 12) + 1) & 1) == 0 ? '0' : '1';
        char c5 = sb.length() <= 156 ? '0' : '1';
        if (i12 == 1) {
            sb.setCharAt(2, c4);
            i8 = 3;
            sb.setCharAt(3, c5);
        } else {
            i8 = 3;
        }
        if (i12 == 2) {
            sb.setCharAt(i8, c4);
            sb.setCharAt(4, c5);
        }
        if (i12 != 5) {
            i9 = 6;
            if (i12 == 6) {
            }
            return i12;
        }
        i9 = 6;
        sb.setCharAt(i9, c4);
        sb.setCharAt(7, c5);
        return i12;
    }

    private static int N(int i3, boolean z3, int i4) {
        int i5 = 12 - (i3 % 12);
        if (i5 == 12) {
            i5 = 0;
        }
        if (i3 < 36) {
            i5 = 36 - i3;
        }
        return (z3 && (((i3 + i5) / 12) + 1) % (i4 * 2) == 1) ? i5 + 12 : i5;
    }

    private void O(StringBuilder sb) {
        w("Binary Length: " + sb.length());
        u("Binary String: ");
        int i3 = 0;
        for (int i4 = 0; i4 < sb.length(); i4++) {
            int i5 = i4 % 4;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            if (sb.charAt(i4) == '1') {
                                i3++;
                            }
                            u(Integer.toHexString(i3));
                            i3 = 0;
                        }
                    } else if (sb.charAt(i4) == '1') {
                        i3 += 2;
                    }
                } else if (sb.charAt(i4) == '1') {
                    i3 += 4;
                }
            } else if (sb.charAt(i4) == '1') {
                i3 += 8;
            }
        }
        if (sb.length() % 4 != 0) {
            u(Integer.toHexString(i3));
        }
        v();
    }

    private static int P(int[] iArr, int i3, int i4) {
        int iPow = (int) Math.pow(10.0d, i4 - 1);
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += (iArr[i3 + i6] - 48) * iPow;
            iPow /= 10;
        }
        return i5;
    }

    private static String Q(CharSequence charSequence, int i3, boolean z3, boolean z4, boolean z5, boolean z6, AtomicBoolean atomicBoolean) {
        int i4;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z7 = true;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            int iCharAt = charSequence.charAt(i5) - '0';
            for (int i6 = 0; i6 < iCharAt; i6++) {
                sb.append(z7 ? '1' : '0');
                sb2.append(z7 ? '0' : '1');
            }
            z7 = !z7;
        }
        for (int i7 = 0; i7 < 4; i7++) {
            sb2.setCharAt(i7, '0');
            sb2.setCharAt((sb2.length() - 1) - i7, '0');
        }
        boolean z8 = atomicBoolean.get();
        boolean z9 = false;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = (i8 * 49) + 19 + (z4 ? 1 : 0);
            if (z5) {
                int i10 = z8 ? 15 : 13;
                for (i4 = z8 ? 2 : 0; i4 < i10; i4++) {
                    int i11 = i4 + i9;
                    if (i11 < sb.length()) {
                        if (sb.charAt(i11) == '1') {
                            sb2.setCharAt(i11, '0');
                            z9 = false;
                        } else {
                            sb2.setCharAt(i11, z9 ? '0' : '1');
                            z9 = !z9;
                        }
                    }
                }
            } else {
                if (z6) {
                    i9 -= 17;
                }
                i4 = z8 ? 2 : 0;
                for (int i12 = z8 ? 14 : 12; i12 >= i4; i12--) {
                    int i13 = i12 + i9;
                    if (i13 < sb.length()) {
                        if (sb.charAt(i13) == '1') {
                            sb2.setCharAt(i13, '0');
                            z9 = false;
                        } else {
                            sb2.setCharAt(i13, z9 ? '0' : '1');
                            z9 = !z9;
                        }
                    }
                }
            }
            z8 = !z8;
        }
        if (z3) {
            atomicBoolean.set(z8);
        }
        return Q.a(sb2);
    }

    protected void R(boolean z3) {
        this.f728z = z3;
    }

    public void S(int i3) {
        if (i3 >= 1 && i3 <= 10) {
            this.f726A = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid column count: " + i3);
    }

    public void T(boolean z3) {
        this.f727B = z3;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x034e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0368  */
    /* JADX WARN: Code duplicated, block: B:133:0x036c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x036e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0378  */
    /* JADX WARN: Code duplicated, block: B:136:0x037b  */
    /* JADX WARN: Code duplicated, block: B:140:0x039e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x03c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x03d3 A[LOOP:17: B:150:0x03d1->B:151:0x03d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:154:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:157:0x03fb A[LOOP:18: B:155:0x03f7->B:157:0x03fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x0416  */
    /* JADX WARN: Code duplicated, block: B:163:0x041d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0438  */
    /* JADX WARN: Code duplicated, block: B:167:0x043b  */
    /* JADX WARN: Code duplicated, block: B:197:0x045a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x03a0 A[ADDED_TO_REGION, EDGE_INSN: B:198:0x03a0->B:141:0x03a0 BREAK  A[LOOP:15: B:129:0x035b->B:142:0x03a2], REMOVE, SYNTHETIC] */
    @Override // E2.Q
    protected void c() {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        boolean z4;
        boolean z5;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        AtomicBoolean atomicBoolean;
        int i13;
        int i14;
        int i15;
        int i16;
        StringBuilder sb;
        int i17;
        StringBuilder sb2;
        int i18;
        boolean z6;
        int i19;
        int[] iArr = new int[21];
        int[] iArr2 = new int[21];
        int[] iArr3 = new int[21];
        int[] iArr4 = new int[21];
        int i20 = 1;
        int i21 = 0;
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 21, 8);
        int[] iArr6 = new int[235];
        int[] iArr7 = new int[235];
        int[] iArrK = Q.K(this.f413l, StandardCharsets.US_ASCII, new int[0]);
        this.f415n = iArrK;
        if (iArrK == null) {
            throw new H("Invalid characters in input data");
        }
        StringBuilder sb3 = new StringBuilder(iArrK.length * 8);
        if (this.f728z) {
            sb3.append('1');
            i3 = 1;
        } else {
            sb3.append('0');
            i3 = 0;
        }
        w("Encoding Method: " + M(this.f727B, this.f726A, this.f415n, sb3));
        O(sb3);
        int i22 = 12;
        int length = sb3.length() / 12;
        u("Data Characters: ");
        int i23 = 0;
        while (i23 < length) {
            iArr[i23] = i21;
            while (i21 < i22) {
                if (sb3.charAt((i23 * 12) + i21) == '1') {
                    iArr[i23] = iArr[i23] + (2048 >> i21);
                }
                i21++;
                i22 = 12;
            }
            y(iArr[i23]);
            i23++;
            i22 = 12;
            i21 = 0;
        }
        v();
        int i24 = 0;
        while (i24 < length) {
            if (iArr[i24] <= 347) {
                iArr2[i24] = i20;
            }
            int i25 = iArr[i24];
            if (i25 >= 348 && i25 <= 1387) {
                iArr2[i24] = 2;
            }
            int i26 = iArr[i24];
            if (i26 >= 1388 && i26 <= 2947) {
                iArr2[i24] = 3;
            }
            int i27 = iArr[i24];
            if (i27 >= 2948 && i27 <= 3987) {
                iArr2[i24] = 4;
            }
            if (iArr[i24] >= 3988) {
                iArr2[i24] = 5;
            }
            int i28 = iArr[i24];
            int[] iArr8 = f716C;
            int i29 = iArr2[i24];
            int i30 = i28 - iArr8[i29 - 1];
            int[] iArr9 = f717D;
            iArr3[i24] = i30 / iArr9[i29 - i20];
            int i31 = iArr[i24];
            int i32 = iArr2[i24];
            iArr4[i24] = (i31 - iArr8[i32 - 1]) % iArr9[i32 - i20];
            int i33 = iArr3[i24];
            int[] iArr10 = f718E;
            int i34 = iArr2[i24];
            int[] iArrM = C0203t.M(i33, iArr10[i34 - 1], 4, f720G[i34 - i20], 0);
            int[] iArr11 = iArr5[i24];
            iArr11[0] = iArrM[0];
            iArr11[2] = iArrM[1];
            iArr11[4] = iArrM[2];
            iArr11[6] = iArrM[3];
            int i35 = iArr4[i24];
            int[] iArr12 = f719F;
            int i36 = iArr2[i24];
            int[] iArrM2 = C0203t.M(i35, iArr12[i36 - 1], 4, f721H[i36 - 1], 1);
            int[] iArr13 = iArr5[i24];
            iArr13[1] = iArrM2[0];
            iArr13[3] = iArrM2[1];
            iArr13[5] = iArrM2[2];
            iArr13[7] = iArrM2[3];
            i24++;
            i20 = 1;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < length; i38++) {
            int i39 = f725L[(((length - 2) / 2) * 21) + i38];
            for (int i40 = 0; i40 < 8; i40++) {
                i37 += iArr5[i38][i40] * f722I[(i39 * 8) + i40];
            }
        }
        int i41 = length + 1;
        int i42 = ((length - 3) * 211) + (i37 % 211);
        w("Check Character: " + i42);
        int i43 = (i42 < 348 || i42 > 1387) ? 1 : 2;
        if (i42 < 1388 || i42 > 2947) {
            i4 = i43;
            i5 = 2948;
        } else {
            i5 = 2948;
            i4 = 3;
        }
        if (i42 < i5 || i42 > 3987) {
            i6 = 3988;
        } else {
            i6 = 3988;
            i4 = 4;
        }
        if (i42 >= i6) {
            i4 = 5;
        }
        int i44 = i4 - 1;
        int i45 = f716C[i44];
        int i46 = f717D[i44];
        int i47 = (i42 - i45) / i46;
        int i48 = (i42 - i45) % i46;
        int[] iArrM3 = C0203t.M(i47, f718E[i44], 4, f720G[i44], 0);
        int i49 = iArrM3[0];
        int i50 = iArrM3[1];
        int i51 = iArrM3[2];
        int i52 = iArrM3[3];
        int[] iArrM4 = C0203t.M(i48, f719F[i44], 4, f721H[i44], 1);
        int[] iArr14 = {i49, iArrM4[0], i50, iArrM4[1], i51, iArrM4[2], i52, iArrM4[3]};
        int i53 = i41 / 2;
        int i54 = i41 & 1;
        int i55 = i53 + i54;
        int i56 = (i55 * 5) + (i41 * 8);
        int i57 = i56 + 4;
        for (int i58 = 0; i58 < i57; i58++) {
            iArr6[i58] = 0;
        }
        int i59 = 0;
        while (i59 < i55) {
            int i60 = (((((length - 1) / 2) + i54) - 1) * 11) + i59;
            int i61 = i54;
            for (int i62 = 0; i62 < 5; i62++) {
                iArr6[(i59 * 21) + i62 + 10] = f723J[((f724K[i60] - 1) * 5) + i62];
            }
            i59++;
            i54 = i61;
        }
        int i63 = 8;
        for (int i64 = 0; i64 < 8; i64++) {
            iArr6[i64 + 2] = iArr14[i64];
        }
        int i65 = 1;
        while (i65 < length) {
            int i66 = 0;
            while (i66 < i63) {
                iArr6[(((i65 - 1) / 2) * 21) + 23 + i66] = iArr5[i65][i66];
                i66++;
                i63 = 8;
            }
            i65 += 2;
            i63 = 8;
        }
        for (int i67 = 0; i67 < length; i67 += 2) {
            for (int i68 = 0; i68 < 8; i68++) {
                iArr6[((i67 / 2) * 21) + 15 + i68] = iArr5[i67][7 - i68];
            }
        }
        if (this.f727B) {
            int i69 = i53 + (i41 % 2);
            int i70 = this.f726A;
            if (this.f728z && i70 == 1) {
                i70 = 2;
            }
            int i71 = i69 / i70;
            if (i69 % i70 > 0) {
                i71++;
            }
            int i72 = (i71 * 4) - 3;
            this.f418q = i72;
            this.f419r = new int[i72 + i3];
            this.f417p = new String[i72 + i3];
            int i73 = 0;
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            int i74 = 0;
            int i75 = 0;
            int i76 = 1;
            while (i76 <= i71) {
                Arrays.fill(iArr7, i73);
                int i77 = i76 < i71 ? i70 : i69 - i74;
                iArr7[i73] = 1;
                iArr7[1] = 1;
                int i78 = i76 % 2;
                if (i78 != 1) {
                    i7 = i74;
                    if (i70 % 2 != 1) {
                        z3 = false;
                    }
                    if (z3 && i76 == i71 && i77 != i70) {
                        if (i77 % 2 == 1) {
                            iArr7[0] = 2;
                            z4 = true;
                            z5 = true;
                        }
                        i8 = i7;
                        i9 = 2;
                        i10 = 0;
                        while (true) {
                            i11 = (i8 * 21) + 2;
                            i12 = length;
                            atomicBoolean = atomicBoolean2;
                            i14 = 0;
                            for (i13 = 21; i14 < i13; i13 = 21) {
                                i19 = i11 + i14;
                                if (i19 < i57) {
                                    if (z4) {
                                        iArr7[i14 + (i10 * 21) + 2] = iArr6[i19];
                                    } else {
                                        iArr7[(20 - i14) + (((i77 - 1) - i10) * 21) + 2] = iArr6[i19];
                                    }
                                }
                                i9++;
                                i14++;
                            }
                            i15 = i10 + 1;
                            i8++;
                            if (i15 >= i70 || i8 >= i69) {
                                break;
                            }
                            i10 = i15;
                            atomicBoolean2 = atomicBoolean;
                            length = i12;
                        }
                        iArr7[i9] = 1;
                        iArr7[i9 + 1] = 1;
                        i16 = i9 + 2;
                        int i79 = i75 + i3;
                        this.f419r[i79] = -1;
                        sb = new StringBuilder();
                        int i80 = i69;
                        if (i78 != 1 || z5) {
                            sb.append('0');
                        }
                        i17 = 0;
                        while (i17 < i16) {
                            sb.append((char) (iArr7[i17] + 48));
                            i17++;
                            i8 = i8;
                        }
                        int i81 = i8;
                        this.f417p[i79] = sb.toString();
                        if (i76 != 1) {
                            sb2 = new StringBuilder("05");
                            for (i18 = 5; i18 < i70 * 49; i18 += 2) {
                                sb2.append("11");
                            }
                            int i82 = (i75 - 2) + i3;
                            this.f417p[i82] = sb2.toString();
                            int[] iArr15 = this.f419r;
                            iArr15[i82] = 1;
                            if (i76 == i71 || i12 % 2 != 0) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            int i83 = (i75 - 1) + i3;
                            iArr15[i83] = 1;
                            this.f417p[i83] = Q(sb, i15, false, z5, z4, z6, atomicBoolean);
                        }
                        if (i76 != i71) {
                            int i84 = i75 + 1 + i3;
                            this.f419r[i84] = 1;
                            this.f417p[i84] = Q(sb, i15, true, false, z4, false, atomicBoolean);
                        }
                        i75 += 4;
                        i76++;
                        atomicBoolean2 = atomicBoolean;
                        length = i12;
                        i69 = i80;
                        i74 = i81;
                        i73 = 0;
                    }
                    z4 = z3;
                    z5 = false;
                    i8 = i7;
                    i9 = 2;
                    i10 = 0;
                    while (true) {
                        i11 = (i8 * 21) + 2;
                        i12 = length;
                        atomicBoolean = atomicBoolean2;
                        i14 = 0;
                        while (i14 < i13) {
                            i19 = i11 + i14;
                            if (i19 < i57) {
                                if (z4) {
                                    iArr7[i14 + (i10 * 21) + 2] = iArr6[i19];
                                } else {
                                    iArr7[(20 - i14) + (((i77 - 1) - i10) * 21) + 2] = iArr6[i19];
                                }
                            }
                            i9++;
                            i14++;
                        }
                        i15 = i10 + 1;
                        i8++;
                        if (i15 >= i70) {
                            break;
                        }
                        break;
                        break;
                        i10 = i15;
                        atomicBoolean2 = atomicBoolean;
                        length = i12;
                    }
                    iArr7[i9] = 1;
                    iArr7[i9 + 1] = 1;
                    i16 = i9 + 2;
                    int i710 = i75 + i3;
                    this.f419r[i710] = -1;
                    sb = new StringBuilder();
                    int i85 = i69;
                    if (i78 != 1) {
                        sb.append('0');
                    } else {
                        sb.append('0');
                    }
                    i17 = 0;
                    while (i17 < i16) {
                        sb.append((char) (iArr7[i17] + 48));
                        i17++;
                        i8 = i8;
                    }
                    int i86 = i8;
                    this.f417p[i710] = sb.toString();
                    if (i76 != 1) {
                        sb2 = new StringBuilder("05");
                        while (i18 < i70 * 49) {
                            sb2.append("11");
                        }
                        int i87 = (i75 - 2) + i3;
                        this.f417p[i87] = sb2.toString();
                        int[] iArr16 = this.f419r;
                        iArr16[i87] = 1;
                        if (i76 == i71) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        int i88 = (i75 - 1) + i3;
                        iArr16[i88] = 1;
                        this.f417p[i88] = Q(sb, i15, false, z5, z4, z6, atomicBoolean);
                    }
                    if (i76 != i71) {
                        int i89 = i75 + 1 + i3;
                        this.f419r[i89] = 1;
                        this.f417p[i89] = Q(sb, i15, true, false, z4, false, atomicBoolean);
                    }
                    i75 += 4;
                    i76++;
                    atomicBoolean2 = atomicBoolean;
                    length = i12;
                    i69 = i85;
                    i74 = i86;
                    i73 = 0;
                } else {
                    i7 = i74;
                }
                z3 = true;
                if (z3) {
                    z4 = z3;
                    z5 = false;
                } else {
                    z4 = z3;
                    z5 = false;
                }
                i8 = i7;
                i9 = 2;
                i10 = 0;
                while (true) {
                    i11 = (i8 * 21) + 2;
                    i12 = length;
                    atomicBoolean = atomicBoolean2;
                    i14 = 0;
                    while (i14 < i13) {
                        i19 = i11 + i14;
                        if (i19 < i57) {
                            if (z4) {
                                iArr7[i14 + (i10 * 21) + 2] = iArr6[i19];
                            } else {
                                iArr7[(20 - i14) + (((i77 - 1) - i10) * 21) + 2] = iArr6[i19];
                            }
                        }
                        i9++;
                        i14++;
                    }
                    i15 = i10 + 1;
                    i8++;
                    if (i15 >= i70) {
                        break;
                        break;
                    } else {
                        break;
                        break;
                    }
                    i10 = i15;
                    atomicBoolean2 = atomicBoolean;
                    length = i12;
                }
                iArr7[i9] = 1;
                iArr7[i9 + 1] = 1;
                i16 = i9 + 2;
                int i711 = i75 + i3;
                this.f419r[i711] = -1;
                sb = new StringBuilder();
                int i810 = i69;
                if (i78 != 1) {
                    sb.append('0');
                } else {
                    sb.append('0');
                }
                i17 = 0;
                while (i17 < i16) {
                    sb.append((char) (iArr7[i17] + 48));
                    i17++;
                    i8 = i8;
                }
                int i811 = i8;
                this.f417p[i711] = sb.toString();
                if (i76 != 1) {
                    sb2 = new StringBuilder("05");
                    while (i18 < i70 * 49) {
                        sb2.append("11");
                    }
                    int i812 = (i75 - 2) + i3;
                    this.f417p[i812] = sb2.toString();
                    int[] iArr17 = this.f419r;
                    iArr17[i812] = 1;
                    if (i76 == i71) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    int i813 = (i75 - 1) + i3;
                    iArr17[i813] = 1;
                    this.f417p[i813] = Q(sb, i15, false, z5, z4, z6, atomicBoolean);
                }
                if (i76 != i71) {
                    int i814 = i75 + 1 + i3;
                    this.f419r[i814] = 1;
                    this.f417p[i814] = Q(sb, i15, true, false, z4, false, atomicBoolean);
                }
                i75 += 4;
                i76++;
                atomicBoolean2 = atomicBoolean;
                length = i12;
                i69 = i810;
                i74 = i811;
                i73 = 0;
            }
            this.f416o = "";
            this.f418q += i3;
        } else {
            iArr6[0] = 1;
            iArr6[1] = 1;
            iArr6[i56 + 2] = 1;
            iArr6[i56 + 3] = 1;
            int i90 = i3 + 1;
            this.f418q = i90;
            int[] iArr18 = new int[i90];
            this.f419r = iArr18;
            iArr18[i3] = -1;
            this.f417p = new String[i90];
            StringBuilder sb4 = new StringBuilder("0");
            for (int i91 = 0; i91 < i57; i91++) {
                sb4.append((char) (iArr6[i91] + 48));
            }
            this.f417p[i3] = sb4.toString();
        }
        if (this.f728z) {
            String[] strArr = this.f417p;
            strArr[0] = Q(strArr[1], 4, false, false, true, false, new AtomicBoolean(false));
            this.f419r[0] = 1;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
