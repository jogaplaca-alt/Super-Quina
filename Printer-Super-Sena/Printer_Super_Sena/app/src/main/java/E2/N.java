package E2;

import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class N extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final char[] f365B = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final int[] f366C = {19, 34, 55, 80, 108, 136, 156, 194, 232, 274, 324, 370, 428, 461, 523, 589, 647, 721, 795, 861, 932, 1006, 1094, 1174, 1276, 1370, 1468, 1531, 1631, 1735, 1843, 1955, 2071, 2191, 2306, 2434, 2566, 2702, 2812, 2956};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f367D = {16, 28, 44, 64, 86, 108, 124, 154, 182, 216, 254, 290, 334, 365, 415, 453, 507, 563, 627, 669, 714, 782, 860, 914, 1000, 1062, 1128, 1193, 1267, 1373, 1455, 1541, 1631, 1725, 1812, 1914, 1992, 2102, 2216, 2334};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f368E = {13, 22, 34, 48, 62, 76, 88, 110, 132, 154, 180, 206, 244, 261, 295, 325, 367, 397, 445, 485, 512, 568, 614, 664, 718, 754, 808, 871, 911, 985, 1033, 1115, 1171, 1231, 1286, 1354, 1426, 1502, 1582, 1666};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f369F = {9, 16, 26, 36, 46, 60, 66, 86, 100, 122, 140, 158, 180, 197, 223, 253, 283, 313, 341, 385, 406, 442, 464, 514, 538, 596, 628, 661, 701, 745, 793, 845, 901, 961, 986, 1054, 1096, 1142, 1222, 1276};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f370G = {1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 6, 6, 6, 6, 7, 8, 8, 9, 9, 10, 12, 12, 12, 13, 14, 15, 16, 17, 18, 19, 19, 20, 21, 22, 24, 25};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f371H = {1, 1, 1, 2, 2, 4, 4, 4, 5, 5, 5, 8, 9, 9, 10, 10, 11, 13, 14, 16, 17, 17, 18, 20, 21, 23, 25, 26, 28, 29, 31, 33, 35, 37, 38, 40, 43, 45, 47, 49};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f372I = {1, 1, 2, 2, 4, 4, 6, 6, 8, 8, 8, 10, 12, 16, 12, 17, 16, 18, 21, 20, 23, 23, 25, 27, 29, 34, 34, 35, 38, 40, 43, 45, 48, 51, 53, 56, 59, 62, 65, 68};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f373J = {1, 1, 2, 4, 4, 4, 5, 6, 8, 8, 11, 11, 16, 16, 18, 16, 19, 21, 25, 25, 25, 34, 30, 32, 35, 37, 40, 42, 45, 48, 51, 54, 57, 60, 63, 66, 70, 74, 77, 81};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int[] f374K = {26, 44, 70, 100, 134, 172, 196, 242, 292, 346, 404, 466, 532, 581, 655, 733, 815, 901, 991, 1085, 1156, 1258, 1364, 1474, 1588, 1706, 1828, 1921, 2051, 2185, 2323, 2465, 2611, 2761, 2876, 3034, 3196, 3362, 3532, 3706};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f375L = {21, 25, 29, 33, 37, 41, 45, 49, 53, 57, 61, 65, 69, 73, 77, 81, 85, 89, 93, 97, 101, 105, 109, 113, 117, 121, 125, 129, 133, 137, 141, 145, 149, 153, 157, 161, 165, 169, 173, 177};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int[] f376M = {0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f377N = {6, 18, 0, 0, 0, 0, 0, 6, 22, 0, 0, 0, 0, 0, 6, 26, 0, 0, 0, 0, 0, 6, 30, 0, 0, 0, 0, 0, 6, 34, 0, 0, 0, 0, 0, 6, 22, 38, 0, 0, 0, 0, 6, 24, 42, 0, 0, 0, 0, 6, 26, 46, 0, 0, 0, 0, 6, 28, 50, 0, 0, 0, 0, 6, 30, 54, 0, 0, 0, 0, 6, 32, 58, 0, 0, 0, 0, 6, 34, 62, 0, 0, 0, 0, 6, 26, 46, 66, 0, 0, 0, 6, 26, 48, 70, 0, 0, 0, 6, 26, 50, 74, 0, 0, 0, 6, 30, 54, 78, 0, 0, 0, 6, 30, 56, 82, 0, 0, 0, 6, 30, 58, 86, 0, 0, 0, 6, 34, 62, 90, 0, 0, 0, 6, 28, 50, 72, 94, 0, 0, 6, 26, 50, 74, 98, 0, 0, 6, 30, 54, 78, 102, 0, 0, 6, 28, 54, 80, 106, 0, 0, 6, 32, 58, 84, 110, 0, 0, 6, 30, 58, 86, 114, 0, 0, 6, 34, 62, 90, 118, 0, 0, 6, 26, 50, 74, 98, 122, 0, 6, 30, 54, 78, 102, 126, 0, 6, 26, 52, 78, 104, 130, 0, 6, 30, 56, 82, 108, 134, 0, 6, 34, 60, 86, 112, 138, 0, 6, 30, 58, 86, 114, 142, 0, 6, 34, 62, 90, 118, 146, 0, 6, 30, 54, 78, 102, 126, 150, 6, 24, 50, 76, 102, 128, 154, 6, 28, 54, 80, 106, 132, 158, 6, 32, 58, 84, 110, 136, 162, 6, 26, 54, 82, 110, 138, 166, 6, 30, 58, 86, 114, 142, 170};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f378O = {21522, 20773, 24188, 23371, 17913, 16590, 20375, 19104, 30660, 29427, 32170, 30877, 26159, 25368, 27713, 26998, 5769, 5054, 7399, 6608, 1890, 597, 3340, 2107, 13663, 12392, 16177, 14854, 9396, 8579, 11994, 11245};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final int[] f379P = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private a f380A = a.L;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f381z;

    public enum a {
        L,
        M,
        Q,
        H
    }

    private enum b {
        NULL,
        KANJI,
        BINARY,
        ALPHANUM,
        NUMERIC
    }

    private static void L(int[] iArr, int[] iArr2, int i3, int i4, int i5) {
        int i6 = f374K[i3 - 1] - i4;
        int i7 = i4 / i5;
        int i8 = i5 - (i4 % i5);
        int i9 = i6 / i5;
        int[] iArr3 = new int[i7 + 2];
        int[] iArr4 = new int[i9 + 2];
        int[] iArr5 = new int[i4 + 2];
        int[] iArr6 = new int[i6 + 2];
        int i10 = 0;
        int i11 = 0;
        while (i10 < i5) {
            int i12 = i10 < i8 ? i7 : i7 + 1;
            for (int i13 = 0; i13 < i9; i13++) {
                iArr4[i13] = 0;
            }
            for (int i14 = 0; i14 < i12; i14++) {
                iArr3[i14] = iArr2[i11 + i14];
            }
            O o3 = new O();
            o3.d(285);
            o3.c(i9, 0);
            o3.a(i12, iArr3);
            for (int i15 = 0; i15 < i9; i15++) {
                iArr4[i15] = o3.b(i15);
            }
            for (int i16 = 0; i16 < i7; i16++) {
                iArr5[(i16 * i5) + i10] = iArr3[i16];
            }
            if (i10 >= i8) {
                iArr5[(i7 * i5) + (i10 - i8)] = iArr3[i7];
            }
            for (int i17 = 0; i17 < i9; i17++) {
                iArr6[(i17 * i5) + i10] = iArr4[(i9 - i17) - 1];
            }
            i11 += i12;
            i10++;
        }
        for (int i18 = 0; i18 < i4; i18++) {
            iArr[i18] = iArr5[i18];
        }
        for (int i19 = 0; i19 < i6; i19++) {
            iArr[i19 + i4] = iArr6[i19];
        }
    }

    private static void M(int[] iArr, int i3, a aVar, int i4) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            i4 |= 8;
        } else if (iOrdinal == 2) {
            i4 |= 24;
        } else if (iOrdinal == 3) {
            i4 |= 16;
        }
        int i5 = f378O[i4];
        for (int i6 = 0; i6 < 6; i6++) {
            int i7 = (i6 * i3) + 8;
            iArr[i7] = iArr[i7] + ((i5 >> i6) & 1);
        }
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = (i3 * 8) + ((i3 - i8) - 1);
            iArr[i9] = iArr[i9] + ((i5 >> i8) & 1);
        }
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = (i3 * 8) + (5 - i10);
            iArr[i11] = iArr[i11] + ((i5 >> (i10 + 9)) & 1);
        }
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = (((i3 - 7) + i12) * i3) + 8;
            iArr[i13] = iArr[i13] + ((i5 >> (i12 + 8)) & 1);
        }
        int i14 = (i3 * 7) + 8;
        iArr[i14] = iArr[i14] + ((i5 >> 6) & 1);
        int i15 = i3 * 8;
        int i16 = i15 + 8;
        iArr[i16] = iArr[i16] + ((i5 >> 7) & 1);
        int i17 = i15 + 7;
        iArr[i17] = iArr[i17] + ((i5 >> 8) & 1);
    }

    private static void N(byte[] bArr, int i3, a aVar, int i4) {
        int i5;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            i5 = i4 | 8;
        } else if (iOrdinal != 2) {
            i5 = iOrdinal != 3 ? i4 : i4 | 16;
        } else {
            i5 = i4 | 24;
        }
        int i6 = f378O[i5];
        for (int i7 = 0; i7 < 6; i7++) {
            bArr[(i7 * i3) + 8] = (byte) (((i6 >> i7) & 1) != 0 ? 1 >> i4 : 0);
        }
        for (int i8 = 0; i8 < 8; i8++) {
            bArr[(i3 * 8) + ((i3 - i8) - 1)] = (byte) (((i6 >> i8) & 1) != 0 ? 1 >> i4 : 0);
        }
        for (int i9 = 0; i9 < 6; i9++) {
            bArr[(i3 * 8) + (5 - i9)] = (byte) (((i6 >> (i9 + 9)) & 1) != 0 ? 1 >> i4 : 0);
        }
        for (int i10 = 0; i10 < 7; i10++) {
            bArr[(((i3 - 7) + i10) * i3) + 8] = (byte) (((i6 >> (i10 + 8)) & 1) != 0 ? 1 >> i4 : 0);
        }
        bArr[(i3 * 7) + 8] = (byte) (((i6 >> 6) & 1) != 0 ? 1 >> i4 : 0);
        int i11 = i3 * 8;
        bArr[i11 + 8] = (byte) (((i6 >> 7) & 1) != 0 ? 1 >> i4 : 0);
        bArr[i11 + 7] = (byte) (((i6 >> 8) & 1) != 0 ? 1 >> i4 : 0);
    }

    private static void O(int[] iArr, int i3, int i4) {
        int i5 = f379P[i4 - 7];
        for (int i6 = 0; i6 < 6; i6++) {
            int i7 = i3 - 11;
            int i8 = (i7 * i3) + i6;
            int i9 = i6 * 3;
            int i10 = (i5 >> i9) & 1;
            iArr[i8] = iArr[i8] + i10;
            int i11 = i3 - 10;
            int i12 = (i11 * i3) + i6;
            int i13 = (i5 >> (i9 + 1)) & 1;
            iArr[i12] = iArr[i12] + i13;
            int i14 = i3 - 9;
            int i15 = (i14 * i3) + i6;
            int i16 = (i5 >> (i9 + 2)) & 1;
            iArr[i15] = iArr[i15] + i16;
            int i17 = i6 * i3;
            int i18 = i7 + i17;
            iArr[i18] = iArr[i18] + i10;
            int i19 = i11 + i17;
            iArr[i19] = iArr[i19] + i13;
            int i20 = i17 + i14;
            iArr[i20] = iArr[i20] + i16;
        }
    }

    private static int P(int[] iArr, int i3, a aVar) {
        int[] iArr2 = new int[8];
        int i4 = i3 * i3;
        byte[] bArr = new byte[i4];
        byte[] bArr2 = new byte[i4];
        for (int i5 = 0; i5 < i3; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = (i6 * i3) + i5;
                bArr[i7] = 0;
                if ((iArr[i7] & 240) == 0) {
                    int i8 = i6 + i5;
                    int i9 = i8 & 1;
                    if (i9 == 0) {
                        bArr[i7] = (byte) 1;
                    }
                    if ((i6 & 1) == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 2);
                    }
                    if (i5 % 3 == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 4);
                    }
                    if (i8 % 3 == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 8);
                    }
                    if ((((i6 / 2) + (i5 / 3)) & 1) == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 16);
                    }
                    int i10 = i6 * i5;
                    int i11 = i10 & 1;
                    int i12 = i10 % 3;
                    int i13 = i11 + i12;
                    if (i13 == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 32);
                    }
                    if ((i13 & 1) == 0) {
                        bArr[i7] = (byte) (bArr[i7] + 64);
                    }
                    if (((i9 + i12) & 1) == 0) {
                        bArr[i7] = (byte) (bArr[i7] - 128);
                    }
                }
            }
        }
        for (int i14 = 0; i14 < i3; i14++) {
            for (int i15 = 0; i15 < i3; i15++) {
                int i16 = (i15 * i3) + i14;
                bArr2[i16] = (byte) (((iArr[i16] & 1) != 0 ? (byte) 255 : (byte) 0) ^ bArr[i16]);
            }
        }
        for (int i17 = 0; i17 < 8; i17++) {
            N(bArr2, i3, aVar, i17);
            iArr2[i17] = V(bArr2, i3, i17);
        }
        int i18 = iArr2[0];
        int i19 = 0;
        for (int i20 = 1; i20 < 8; i20++) {
            int i21 = iArr2[i20];
            if (i21 < i18) {
                i19 = i20;
                i18 = i21;
            }
        }
        for (int i22 = 0; i22 < i3; i22++) {
            for (int i23 = 0; i23 < i3; i23++) {
                int i24 = (i23 * i3) + i22;
                if ((bArr[i24] & (1 << i19)) != 0) {
                    if ((iArr[i24] & 1) != 0) {
                        iArr[i24] = 0;
                    } else {
                        iArr[i24] = 1;
                    }
                }
            }
        }
        return i19;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00ee  */
    private static b[] Q(int i3, b[] bVarArr) {
        int i4;
        int i5;
        int i6;
        int length = bVarArr.length;
        b bVar = b.NULL;
        int i7 = 0;
        for (b bVar2 : bVarArr) {
            if (bVar2 != bVar) {
                i7++;
                bVar = bVar2;
            }
        }
        int[] iArr = new int[i7];
        b[] bVarArr2 = new b[i7];
        b bVar3 = b.NULL;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            i4 = 1;
            if (i9 >= length) {
                break;
            }
            b bVar4 = bVarArr[i9];
            if (bVar4 != bVar3) {
                i8++;
                iArr[i8] = 1;
                bVarArr2[i8] = bVar4;
                bVar3 = bVarArr[i9];
            } else {
                iArr[i8] = iArr[i8] + 1;
            }
            i9++;
        }
        if (i7 > 1) {
            int i10 = 0;
            while (true) {
                i5 = 9;
                i6 = 4;
                if (i10 > i7 - 2) {
                    break;
                }
                b bVar5 = bVarArr2[i10];
                b bVar6 = b.BINARY;
                if (bVar5 == bVar6) {
                    int i11 = i10 + 1;
                    int iOrdinal = bVarArr2[i11].ordinal();
                    if (iOrdinal != 1) {
                        if (iOrdinal != 3) {
                            if (iOrdinal == 4 && iArr[i11] < e0(i3, 3, 4, 5)) {
                                bVarArr2[i11] = bVar6;
                            }
                        } else if (iArr[i11] < e0(i3, 7, 8, 9)) {
                            bVarArr2[i11] = bVar6;
                        }
                    } else if (iArr[i11] < e0(i3, 4, 5, 6)) {
                        bVarArr2[i11] = bVar6;
                    }
                }
                b bVar7 = bVarArr2[i10];
                b bVar8 = b.ALPHANUM;
                if (bVar7 == bVar8) {
                    int i12 = i10 + 1;
                    if (bVarArr2[i12] == b.NUMERIC && iArr[i12] < e0(i3, 6, 8, 10)) {
                        bVarArr2[i12] = bVar8;
                    }
                }
                i10++;
            }
            int i13 = i7 - 1;
            while (i13 > 0) {
                b bVar9 = bVarArr2[i13];
                b bVar10 = b.BINARY;
                if (bVar9 == bVar10) {
                    int i14 = i13 - 1;
                    int iOrdinal2 = bVarArr2[i14].ordinal();
                    if (iOrdinal2 != i4) {
                        if (iOrdinal2 != 3) {
                            if (iOrdinal2 == i6 && iArr[i14] < e0(i3, 3, i6, 5)) {
                                bVarArr2[i14] = bVar10;
                            }
                        } else if (iArr[i14] < e0(i3, 7, 8, i5)) {
                            bVarArr2[i14] = bVar10;
                        }
                    } else if (iArr[i14] < e0(i3, i6, 5, 6)) {
                        bVarArr2[i14] = bVar10;
                    }
                }
                b bVar11 = bVarArr2[i13];
                b bVar12 = b.ALPHANUM;
                if (bVar11 == bVar12) {
                    int i15 = i13 - 1;
                    if (bVarArr2[i15] == b.NUMERIC) {
                        if (iArr[i15] < e0(i3, 6, 8, 10)) {
                            bVarArr2[i15] = bVar12;
                        }
                    }
                }
                i13--;
                i6 = 4;
                i5 = 9;
                i4 = 1;
            }
        }
        b[] bVarArr3 = new b[bVarArr.length];
        int i16 = 0;
        for (int i17 = 0; i17 < i7; i17++) {
            b bVar13 = bVarArr2[i17];
            for (int i18 = 0; i18 < iArr[i17]; i18++) {
                bVarArr3[i16] = bVar13;
                i16++;
            }
        }
        return bVarArr3;
    }

    private static void R(int i3, int i4, StringBuilder sb) {
        int i5 = 1 << (i4 - 1);
        for (int i6 = 0; i6 < i4; i6++) {
            if (((i5 >> i6) & i3) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
    }

    private static int S(int i3, b[] bVarArr) {
        int i4;
        b bVar = bVarArr[i3];
        int i5 = 0;
        do {
            i5++;
            i4 = i3 + i5;
            if (i4 >= bVarArr.length) {
                break;
            }
        } while (bVarArr[i4] == bVar);
        return i5;
    }

    private static boolean T(int[] iArr, int i3) {
        return (iArr[i3 / 8] & (128 >> (i3 % 8))) != 0;
    }

    private static void U(b[] bVarArr, int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 > 255) {
                bVarArr[i3] = b.KANJI;
            } else {
                bVarArr[i3] = b.BINARY;
                if (X(i4)) {
                    bVarArr[i3] = b.ALPHANUM;
                }
                int i5 = iArr[i3];
                if (i5 == -1) {
                    bVarArr[i3] = b.ALPHANUM;
                }
                if (Y(i5)) {
                    bVarArr[i3] = b.NUMERIC;
                }
            }
        }
    }

    private static int V(byte[] bArr, int i3, int i4) {
        int i5 = i3 * i3;
        byte[] bArr2 = new byte[i5];
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i3) + i6;
                if ((bArr[i8] & (1 << i4)) != 0) {
                    bArr2[i8] = 49;
                } else {
                    bArr2[i8] = 48;
                }
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            byte b3 = bArr2[i10];
            int i11 = 0;
            for (int i12 = 0; i12 < i3; i12++) {
                byte b4 = bArr2[(i12 * i3) + i10];
                if (b4 == b3) {
                    i11++;
                } else {
                    if (i11 > 5) {
                        i9 += i11 - 2;
                    }
                    b3 = b4;
                    i11 = 0;
                }
            }
            if (i11 > 5) {
                i9 += i11 - 2;
            }
        }
        for (int i13 = 0; i13 < i3; i13++) {
            int i14 = i13 * i3;
            byte b5 = bArr2[i14];
            int i15 = 0;
            for (int i16 = 0; i16 < i3; i16++) {
                byte b6 = bArr2[i14 + i16];
                if (b6 == b5) {
                    i15++;
                } else {
                    if (i15 > 5) {
                        i9 += i15 - 2;
                    }
                    b5 = b6;
                    i15 = 0;
                }
            }
            if (i15 > 5) {
                i9 += i15 - 2;
            }
        }
        int i17 = 0;
        while (true) {
            int i18 = i3 - 1;
            if (i17 >= i18) {
                break;
            }
            int i19 = 0;
            while (i19 < i18) {
                int i20 = i19 * i3;
                byte b7 = bArr2[i20 + i17];
                i19++;
                int i21 = i19 * i3;
                if (b7 == bArr2[i21 + i17]) {
                    int i22 = i17 + 1;
                    if (b7 == bArr2[i20 + i22] && b7 == bArr2[i21 + i22]) {
                        i9 += 3;
                    }
                }
            }
            i17++;
        }
        for (int i23 = 0; i23 < i3; i23++) {
            for (int i24 = 0; i24 < i3 - 7; i24++) {
                int i25 = 0;
                for (int i26 = 0; i26 < 7; i26++) {
                    if (bArr2[((i24 + i26) * i3) + i23] == 49) {
                        i25 += 64 >> i26;
                    }
                }
                if (i25 == 93) {
                    int i27 = i24 - 4;
                    int i28 = 0;
                    while (i27 < i24) {
                        i28 = (i27 >= 0 && bArr2[(i27 * i3) + i23] != 48) ? 0 : i28 + 1;
                        i27++;
                    }
                    int i29 = i24 + 7;
                    int i30 = 0;
                    while (i29 <= i24 + 10) {
                        i30 = (i29 < i3 && bArr2[(i29 * i3) + i23] != 48) ? 0 : i30 + 1;
                        i29++;
                    }
                    if (i28 == 4 || i30 == 4) {
                        i9 += 40;
                    }
                }
            }
        }
        for (int i31 = 0; i31 < i3; i31++) {
            for (int i32 = 0; i32 < i3 - 7; i32++) {
                int i33 = 0;
                for (int i34 = 0; i34 < 7; i34++) {
                    if (bArr2[(i31 * i3) + i32 + i34] == 49) {
                        i33 += 64 >> i34;
                    }
                }
                if (i33 == 93) {
                    int i35 = i32 - 4;
                    int i36 = 0;
                    while (i35 < i32) {
                        i36 = (i35 >= 0 && bArr2[(i31 * i3) + i35] != 48) ? 0 : i36 + 1;
                        i35++;
                    }
                    int i37 = i32 + 7;
                    int i38 = 0;
                    while (i37 <= i32 + 10) {
                        i38 = (i37 < i3 && bArr2[(i31 * i3) + i37] != 48) ? 0 : i38 + 1;
                        i37++;
                    }
                    if (i36 == 4 || i38 == 4) {
                        i9 += 40;
                    }
                }
            }
        }
        int i39 = 0;
        for (int i40 = 0; i40 < i3; i40++) {
            for (int i41 = 0; i41 < i3; i41++) {
                if (bArr2[(i41 * i3) + i40] == 49) {
                    i39++;
                }
            }
        }
        int i42 = (i39 / i5) * 100;
        return i9 + ((i42 <= 50 ? (50 - i42) / 5 : (i42 - 50) / 5) * 10);
    }

    private static int W(int i3, b[] bVarArr, int[] iArr, boolean z3, int i4) {
        int iS;
        int length = bVarArr.length;
        b[] bVarArrQ = Q(i3, bVarArr);
        b bVar = b.NULL;
        int i5 = z3 ? 4 : 0;
        if (i4 != 3) {
            i5 += 12;
        }
        int iE0 = i5;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            b bVar2 = bVarArrQ[i7];
            if (bVar2 != bVar) {
                iE0 += 4;
                int iOrdinal = bVar2.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        iE0 += e0(i3, 8, 16, 16);
                        for (int i8 = i7; i8 < S(i7, bVarArrQ) + i7; i8++) {
                            iE0 = iArr[i8] > 255 ? iE0 + 16 : iE0 + 8;
                        }
                    } else if (iOrdinal == 3) {
                        iE0 += e0(i3, 9, 11, 13);
                        int iS2 = S(i7, bVarArrQ);
                        if (z3) {
                            for (int i9 = i7; i9 < i7 + iS2; i9++) {
                                if (iArr[i9] == 37) {
                                    i6++;
                                }
                            }
                        }
                        int i10 = iS2 + i6;
                        int i11 = i10 % 2;
                        if (i11 == 0) {
                            iS = (i10 / 2) * 11;
                        } else if (i11 == 1) {
                            iE0 = iE0 + (((i10 - 1) / 2) * 11) + 6;
                        }
                    } else if (iOrdinal == 4) {
                        iE0 += e0(i3, 10, 12, 14);
                        int iS3 = S(i7, bVarArrQ) % 3;
                        if (iS3 == 0) {
                            iS = (S(i7, bVarArrQ) / 3) * 10;
                        } else if (iS3 == 1) {
                            iE0 = iE0 + (((S(i7, bVarArrQ) - 1) / 3) * 10) + 4;
                        } else if (iS3 == 2) {
                            iE0 = iE0 + (((S(i7, bVarArrQ) - 2) / 3) * 10) + 7;
                        }
                    }
                    bVar = bVarArrQ[i7];
                } else {
                    iE0 += e0(i3, 8, 10, 12);
                    iS = S(i7, bVarArrQ) * 13;
                }
                iE0 += iS;
                bVar = bVarArrQ[i7];
            }
        }
        return iE0;
    }

    private static boolean X(int i3) {
        return (i3 >= 48 && i3 <= 57) || (i3 >= 65 && i3 <= 90) || i3 == 32 || i3 == 36 || i3 == 37 || i3 == 42 || i3 == 43 || i3 == 45 || i3 == 46 || i3 == 47 || i3 == 58;
    }

    private static boolean Y(int i3) {
        return i3 >= 48 && i3 <= 57;
    }

    private static void Z(int[] iArr, int i3, int i4, int i5) {
        int[] iArr2 = {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        int i6 = i4 - 2;
        int i7 = i5 - 2;
        for (int i8 = 0; i8 < 5; i8++) {
            for (int i9 = 0; i9 < 5; i9++) {
                if (iArr2[(i9 * 5) + i8] == 1) {
                    iArr[((i9 + i7) * i3) + i8 + i6] = 17;
                } else {
                    iArr[((i9 + i7) * i3) + i8 + i6] = 16;
                }
            }
        }
    }

    private static void a0(int[] iArr, int i3, int i4, int i5) {
        int[] iArr2 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i6 = 0; i6 < 7; i6++) {
            for (int i7 = 0; i7 < 7; i7++) {
                if (iArr2[(i7 * 7) + i6] == 1) {
                    iArr[((i7 + i5) * i3) + i6 + i4] = 17;
                } else {
                    iArr[((i7 + i5) * i3) + i6 + i4] = 16;
                }
            }
        }
    }

    private static void b0(int[] iArr, int i3, int[] iArr2, int i4) {
        int i5 = i4 * 8;
        int i6 = i3 - 1;
        int i7 = i6;
        int i8 = 0;
        int i9 = 0;
        boolean z3 = true;
        do {
            int i10 = (i3 - 2) - (i8 * 2);
            if (i10 < 6) {
                i10--;
            }
            int i11 = i7 * i3;
            int i12 = i10 + 1 + i11;
            if ((iArr[i12] & 240) == 0) {
                if (T(iArr2, i9)) {
                    iArr[i12] = 1;
                } else {
                    iArr[i12] = 0;
                }
                i9++;
            }
            if (i9 < i5) {
                int i13 = i11 + i10;
                if ((iArr[i13] & 240) == 0) {
                    if (T(iArr2, i9)) {
                        iArr[i13] = 1;
                    } else {
                        iArr[i13] = 0;
                    }
                    i9++;
                }
            }
            i7 = z3 ? i7 - 1 : i7 + 1;
            if (i7 == -1) {
                i8++;
                i7 = 0;
                z3 = false;
            }
            if (i7 == i3) {
                i8++;
                i7 = i6;
                z3 = true;
            }
        } while (i9 < i5);
    }

    private void c0(int[] iArr, int i3, int i4, b[] bVarArr, int[] iArr2, boolean z3, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        StringBuilder sb = new StringBuilder(i6 + 12);
        if (z3) {
            sb.append("0101");
        }
        int i10 = 3;
        if (i5 != 3) {
            sb.append("0111");
            if (i5 <= 127) {
                R(i5, 8, sb);
            } else if (i5 <= 16383) {
                R(i5 + 32768, 16, sb);
            } else {
                R(i5 + 12582912, 24, sb);
            }
        }
        u("Encoding: ");
        int i11 = 0;
        while (true) {
            b bVar = bVarArr[i11];
            int i12 = 0;
            do {
                i12++;
                i7 = i12 + i11;
                if (i7 >= bVarArr.length) {
                    break;
                }
            } while (bVarArr[i7] == bVar);
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 1) {
                sb.append("1000");
                R(i12, e0(i3, 8, 10, 12), sb);
                u("KNJI ");
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = iArr2[i11 + i13];
                    int i15 = 33088;
                    if (i14 >= 33088 && i14 <= 40956) {
                        i14 -= i15;
                    } else if (i14 >= 57408 && i14 <= 60351) {
                        i15 = 49472;
                        i14 -= i15;
                    }
                    int i16 = ((i14 >> 8) * 192) + (i14 & 255);
                    R(i16, 13, sb);
                    y(i16);
                }
            } else if (iOrdinal == 2) {
                sb.append("0100");
                R(i12, e0(i3, 8, 16, 16), sb);
                u("BYTE ");
                for (int i17 = 0; i17 < i12; i17++) {
                    int i18 = iArr2[i11 + i17];
                    if (i18 == -1) {
                        i18 = 29;
                    }
                    R(i18, 8, sb);
                    y(i18);
                }
            } else if (iOrdinal == i10) {
                sb.append("0010");
                if (z3) {
                    i8 = 0;
                    for (int i19 = 0; i19 < i12; i19++) {
                        if (iArr2[i11 + i19] == 37) {
                            i8++;
                        }
                    }
                } else {
                    i8 = 0;
                }
                int i20 = i8 + i12;
                int[] iArr3 = new int[i20];
                int i21 = 0;
                for (int i22 = 0; i22 < i12; i22++) {
                    int i23 = iArr2[i11 + i22];
                    if (i23 == -1) {
                        iArr3[i22 + i21] = 37;
                    } else {
                        iArr3[i22 + i21] = i23;
                        if (z3 && i23 == 37) {
                            i21++;
                            iArr3[i22 + i21] = i23;
                        }
                    }
                }
                R(i20, e0(i3, 9, 11, 13), sb);
                u("ALPH ");
                int i24 = 0;
                while (true) {
                    int i25 = i24 + 1;
                    if (i25 >= i20) {
                        break;
                    }
                    char c3 = (char) iArr3[i24];
                    char[] cArr = f365B;
                    int iC = (G2.a.c(c3, cArr) * 45) + G2.a.c((char) iArr3[i25], cArr);
                    R(iC, 11, sb);
                    y(iC);
                    i24 += 2;
                }
                if (i20 % 2 != 0) {
                    int iC2 = G2.a.c((char) iArr3[i20 - 1], f365B);
                    R(iC2, 6, sb);
                    y(iC2);
                }
            } else if (iOrdinal == 4) {
                sb.append("0001");
                R(i12, e0(i3, 10, 12, 14), sb);
                u("NUMB ");
                int i26 = 0;
                while (i26 < i12) {
                    int i27 = i11 + i26;
                    int numericValue = Character.getNumericValue(iArr2[i27]);
                    if (i26 + 1 < i12) {
                        numericValue = (numericValue * 10) + Character.getNumericValue(iArr2[i27 + 1]);
                        if (i26 + 2 < i12) {
                            numericValue = (numericValue * 10) + Character.getNumericValue(iArr2[i27 + 2]);
                            i9 = 3;
                        } else {
                            i9 = 2;
                        }
                    } else {
                        i9 = 1;
                    }
                    R(numericValue, (i9 * 3) + 1, sb);
                    y(numericValue);
                    i26 += i9;
                }
            }
            if (i7 >= bVarArr.length) {
                break;
            }
            i11 = i7;
            i10 = 3;
        }
        v();
        sb.append("0000");
        int length = sb.length();
        int i28 = 8 - (length % 8);
        if (i28 == 8) {
            i28 = 0;
        }
        int i29 = (length + i28) / 8;
        for (int i30 = 0; i30 < i28; i30++) {
            sb.append('0');
        }
        for (int i31 = 0; i31 < i29; i31++) {
            iArr[i31] = 0;
            for (int i32 = 0; i32 < 8; i32++) {
                if (sb.charAt((i31 * 8) + i32) == '1') {
                    iArr[i31] = iArr[i31] + (128 >> i32);
                }
            }
        }
        boolean z4 = false;
        while (i29 < i4) {
            if (z4) {
                iArr[i29] = 17;
                z4 = false;
            } else {
                iArr[i29] = 236;
                z4 = true;
            }
            i29++;
        }
        u("Codewords: ");
        for (int i33 = 0; i33 < i4; i33++) {
            y(iArr[i33]);
        }
        v();
    }

    private static void d0(int[] iArr, int i3, int i4) {
        boolean z3 = true;
        for (int i5 = 0; i5 < i3; i5++) {
            if (z3) {
                iArr[(i3 * 6) + i5] = 33;
                iArr[(i5 * i3) + 6] = 33;
                z3 = false;
            } else {
                iArr[(i3 * 6) + i5] = 32;
                iArr[(i5 * i3) + 6] = 32;
                z3 = true;
            }
        }
        a0(iArr, i3, 0, 0);
        int i6 = i3 - 7;
        a0(iArr, i3, 0, i6);
        a0(iArr, i3, i6, 0);
        for (int i7 = 0; i7 < 7; i7++) {
            int i8 = i3 * 7;
            iArr[i8 + i7] = 16;
            int i9 = i7 * i3;
            iArr[i9 + 7] = 16;
            int i10 = (i3 - 1) - i7;
            iArr[i8 + i10] = 16;
            int i11 = i3 - 8;
            iArr[i9 + i11] = 16;
            iArr[(i11 * i3) + i7] = 16;
            iArr[(i10 * i3) + 7] = 16;
        }
        int i12 = i3 * 7;
        iArr[i12 + 7] = 16;
        int i13 = i3 - 8;
        iArr[i12 + i13] = 16;
        iArr[(i13 * i3) + 7] = 16;
        if (i4 != 1) {
            int i14 = f376M[i4 - 1];
            for (int i15 = 0; i15 < i14; i15++) {
                for (int i16 = 0; i16 < i14; i16++) {
                    int[] iArr2 = f377N;
                    int i17 = (i4 - 2) * 7;
                    int i18 = iArr2[i17 + i15];
                    int i19 = iArr2[i17 + i16];
                    if ((iArr[(i19 * i3) + i18] & 16) == 0) {
                        Z(iArr, i3, i18, i19);
                    }
                }
            }
        }
        for (int i20 = 0; i20 < 8; i20++) {
            int i21 = i3 * 8;
            int i22 = i21 + i20;
            iArr[i22] = iArr[i22] + 32;
            int i23 = (i20 * i3) + 8;
            iArr[i23] = iArr[i23] + 32;
            int i24 = (i3 - 1) - i20;
            iArr[i21 + i24] = 32;
            iArr[(i24 * i3) + 8] = 32;
        }
        int i25 = (i3 * 8) + 8;
        iArr[i25] = iArr[i25] + 32;
        iArr[((i3 - 8) * i3) + 8] = 33;
        if (i4 >= 7) {
            for (int i26 = 0; i26 < 6; i26++) {
                int i27 = i3 - 9;
                iArr[(i27 * i3) + i26] = 32;
                int i28 = i3 - 10;
                iArr[(i28 * i3) + i26] = 32;
                int i29 = i3 - 11;
                iArr[(i29 * i3) + i26] = 32;
                int i30 = i26 * i3;
                iArr[i27 + i30] = 32;
                iArr[i28 + i30] = 32;
                iArr[i30 + i29] = 32;
            }
        }
    }

    private static int e0(int i3, int i4, int i5, int i6) {
        if (i3 < 10) {
            return i4;
        }
        return (i3 < 10 || i3 > 26) ? i6 : i5;
    }

    @Override // E2.Q
    protected void c() {
        int i3;
        int[] iArr;
        boolean z3 = this.f403b == Q.a.GS1;
        b();
        if (this.f414m == 20) {
            Charset charsetForName = Charset.forName("Shift_JIS");
            this.f415n = new int[this.f413l.length()];
            int i4 = 0;
            while (i4 < this.f415n.length) {
                int i5 = i4 + 1;
                byte[] bArrArray = charsetForName.encode(CharBuffer.wrap(this.f413l, i4, i5)).array();
                this.f415n[i4] = bArrArray.length == 2 ? (bArrArray[1] & 255) | ((bArrArray[0] & 255) << 8) : bArrArray[0];
                i4 = i5;
            }
        }
        int[] iArr2 = this.f415n;
        b[] bVarArr = new b[iArr2.length];
        U(bVarArr, iArr2);
        int iW = W(40, bVarArr, this.f415n, z3, this.f414m);
        a aVar = this.f380A;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            i3 = 2334;
        } else if (iOrdinal != 2) {
            i3 = iOrdinal != 3 ? 2956 : 1276;
        } else {
            i3 = 1666;
        }
        if (iW > i3 * 8) {
            throw new H("Input too long for selected error correction level");
        }
        int i6 = 40;
        for (int i7 = 39; i7 >= 0; i7--) {
            int iOrdinal2 = aVar.ordinal();
            if (iOrdinal2 == 1) {
                iArr = f367D;
            } else if (iOrdinal2 != 2) {
                iArr = iOrdinal2 != 3 ? f366C : f369F;
            } else {
                iArr = f368E;
            }
            int i8 = i7 + 1;
            int iW2 = W(i8, bVarArr, this.f415n, z3, this.f414m);
            if (iArr[i7] * 8 >= iW2) {
                i6 = i8;
                iW = iW2;
            }
        }
        b[] bVarArrQ = Q(i6, bVarArr);
        int i9 = this.f381z;
        if (i9 >= 1 && i9 <= 40) {
            if (i9 > i6) {
                iW = W(i9, bVarArrQ, this.f415n, z3, this.f414m);
                bVarArrQ = Q(i9, bVarArrQ);
                i6 = i9;
            }
            if (this.f381z < i6) {
                throw new H("Input too long for selected symbol size");
            }
        }
        b[] bVarArr2 = bVarArrQ;
        int i10 = i6;
        int i11 = iW;
        int[] iArr3 = f367D;
        int i12 = i10 - 1;
        if (i11 <= iArr3[i12] * 8) {
            aVar = a.M;
        }
        int[] iArr4 = f368E;
        if (i11 <= iArr4[i12] * 8) {
            aVar = a.Q;
        }
        int[] iArr5 = f369F;
        if (i11 <= iArr5[i12] * 8) {
            aVar = a.H;
        }
        a aVar2 = aVar;
        int i13 = f366C[i12];
        int i14 = f370G[i12];
        int iOrdinal3 = aVar2.ordinal();
        if (iOrdinal3 == 1) {
            i13 = iArr3[i12];
            i14 = f371H[i12];
        } else if (iOrdinal3 == 2) {
            i13 = iArr4[i12];
            i14 = f372I[i12];
        } else if (iOrdinal3 == 3) {
            i13 = iArr5[i12];
            i14 = f373J[i12];
        }
        int i15 = i13;
        int[] iArr6 = new int[i15 + 1];
        int[] iArr7 = f374K;
        int[] iArr8 = new int[iArr7[i12] + 1];
        c0(iArr6, i10, i15, bVarArr2, this.f415n, z3, this.f414m, i11);
        L(iArr8, iArr6, i10, i15, i14);
        int i16 = f375L[i12];
        int[] iArr9 = new int[i16 * i16];
        w("Version: " + i10);
        w("ECC Level: " + aVar2.name());
        d0(iArr9, i16, i10);
        b0(iArr9, i16, iArr8, iArr7[i12]);
        if (i10 >= 7) {
            O(iArr9, i16, i10);
        }
        int iP = P(iArr9, i16, aVar2);
        w("Mask Pattern: " + Integer.toBinaryString(iP));
        M(iArr9, i16, aVar2, iP);
        this.f416o = "";
        this.f417p = new String[i16];
        this.f418q = i16;
        this.f419r = new int[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            StringBuilder sb = new StringBuilder(i16);
            for (int i18 = 0; i18 < i16; i18++) {
                if ((iArr9[(i17 * i16) + i18] & 1) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            this.f417p[i17] = Q.a(sb);
            this.f419r[i17] = 1;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
