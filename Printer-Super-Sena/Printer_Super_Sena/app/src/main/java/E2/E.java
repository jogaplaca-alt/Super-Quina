package E2;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class E extends Q {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final char[] f295G = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f296H = {17477, 16754, 20011, 19228, 21934, 20633, 24512, 23287, 26515, 25252, 28157, 26826, 30328, 29519, 31766, 31009, 1758, 1001, 3248, 2439, 5941, 4610, 7515, 6252, 9480, 8255, 12134, 10833, 13539, 12756, 16013, 15290};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f297I = {11, 13, 15, 17};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private b[] f299B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private StringBuilder f300C;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int[] f302E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int[] f303F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f304z;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private a f298A = a.L;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private final int[] f301D = new int[4];

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

    /* JADX WARN: Code duplicated, block: B:62:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d3  */
    private int L(int i3) {
        int[] iArr;
        int i4;
        int[] iArr2 = new int[8];
        int i5 = i3 * i3;
        int[] iArr3 = new int[i5];
        this.f303F = new int[i5];
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i3) + i6;
                iArr3[i8] = 0;
                if ((this.f302E[i8] & 240) == 0) {
                    if ((i7 & 1) == 0) {
                        iArr3[i8] = 1;
                    }
                    if ((((i7 / 2) + (i6 / 3)) & 1) == 0) {
                        iArr3[i8] = iArr3[i8] + 2;
                    }
                    int i9 = i7 * i6;
                    int i10 = i9 & 1;
                    int i11 = i9 % 3;
                    if (((i10 + i11) & 1) == 0) {
                        iArr3[i8] = iArr3[i8] + 4;
                    }
                    if (((((i7 + i6) & 1) + i11) & 1) == 0) {
                        iArr3[i8] = iArr3[i8] + 8;
                    }
                }
            }
        }
        for (int i12 = 0; i12 < i3; i12++) {
            for (int i13 = 0; i13 < i3; i13++) {
                int i14 = (i13 * i3) + i12;
                this.f303F[i14] = ((this.f302E[i14] & 1) != 0 ? 255 : 0) ^ iArr3[i14];
            }
        }
        for (int i15 = 0; i15 < 4; i15++) {
            iArr2[i15] = M(i3, i15);
        }
        int i16 = iArr2[0];
        int i17 = 0;
        for (int i18 = 1; i18 < 4; i18++) {
            int i19 = iArr2[i18];
            if (i19 > i16) {
                i17 = i18;
                i16 = i19;
            }
        }
        for (int i20 = 0; i20 < i3; i20++) {
            for (int i21 = 0; i21 < i3; i21++) {
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 == 3 && (iArr3[(i21 * i3) + i20] & 8) != 0) {
                                iArr = this.f302E;
                                i4 = (i21 * i3) + i20;
                                if ((iArr[i4] & 1) != 0) {
                                    iArr[i4] = 0;
                                } else {
                                    iArr[i4] = 1;
                                }
                            }
                        } else if ((iArr3[(i21 * i3) + i20] & 4) != 0) {
                            iArr = this.f302E;
                            i4 = (i21 * i3) + i20;
                            if ((iArr[i4] & 1) != 0) {
                                iArr[i4] = 0;
                            } else {
                                iArr[i4] = 1;
                            }
                        }
                    } else if ((iArr3[(i21 * i3) + i20] & 2) != 0) {
                        iArr = this.f302E;
                        i4 = (i21 * i3) + i20;
                        if ((iArr[i4] & 1) != 0) {
                            iArr[i4] = 0;
                        } else {
                            iArr[i4] = 1;
                        }
                    }
                } else if ((iArr3[(i21 * i3) + i20] & 1) != 0) {
                    iArr = this.f302E;
                    i4 = (i21 * i3) + i20;
                    if ((iArr[i4] & 1) != 0) {
                        iArr[i4] = 0;
                    } else {
                        iArr[i4] = 1;
                    }
                }
            }
        }
        return i17;
    }

    private int M(int i3, int i4) {
        int i5;
        int i6 = 0;
        if (i4 != 0) {
            i5 = 2;
            if (i4 != 1) {
                i5 = i4 != 2 ? i4 != 3 ? 0 : 8 : 4;
            }
        } else {
            i5 = 1;
        }
        int i7 = 0;
        for (int i8 = 1; i8 < i3; i8++) {
            int[] iArr = this.f303F;
            if ((iArr[((i8 * i3) + i3) - 1] & i5) != 0) {
                i6++;
            }
            if ((iArr[((i3 - 1) * i3) + i8] & i5) != 0) {
                i7++;
            }
        }
        return i6 <= i7 ? (i6 * 16) + i7 : i6 + (i7 * 16);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    /* JADX WARN: Code duplicated, block: B:50:0x013a  */
    private void N(int i3) {
        int i4;
        int i5;
        int i6;
        u("Encoding: ");
        int i7 = 0;
        while (true) {
            b bVar = this.f299B[i7];
            int i8 = 0;
            do {
                i8++;
                i4 = i8 + i7;
                if (i4 >= this.f413l.length()) {
                    break;
                }
            } while (this.f299B[i4] == bVar);
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 1) {
                if (i3 == 2) {
                    this.f300C.append("11");
                } else if (i3 == 3) {
                    this.f300C.append("011");
                }
                this.f300C.append(a0(i8, 1 << i3));
                u("KANJ (" + i8 + ") ");
                for (int i9 = 0; i9 < i8; i9++) {
                    try {
                        byte[] bytes = ("" + this.f413l.charAt(i7 + i9)).getBytes("SJIS");
                        int i10 = (bytes[0] & 255) << 8;
                        if (bytes.length > 1) {
                            i10 += bytes[1] & 255;
                        }
                        int i11 = i10 - (i10 > 40959 ? 49472 : 33088);
                        int i12 = (((65280 & i11) >> 8) * 192) + (i11 & 255);
                        this.f300C.append(a0(i12, 4096));
                        y(i12);
                    } catch (UnsupportedEncodingException unused) {
                        throw new H("Character encoding error");
                    }
                }
            } else if (iOrdinal == 2) {
                if (i3 == 2) {
                    this.f300C.append("10");
                } else if (i3 == 3) {
                    this.f300C.append("010");
                }
                this.f300C.append(a0(i8, 2 << i3));
                u("BYTE (" + i8 + ") ");
                for (int i13 = 0; i13 < i8; i13++) {
                    char cCharAt = this.f413l.charAt(i7 + i13);
                    this.f300C.append(a0(cCharAt, 128));
                    y(cCharAt);
                }
            } else if (iOrdinal == 3) {
                if (i3 == 1) {
                    this.f300C.append("1");
                } else if (i3 == 2) {
                    this.f300C.append("01");
                } else if (i3 == 3) {
                    this.f300C.append("001");
                }
                this.f300C.append(a0(i8, 2 << i3));
                u("ALPH (" + i8 + ") ");
                for (int i14 = 0; i14 < i8; i14 += 2) {
                    int i15 = i7 + i14;
                    char cCharAt2 = this.f413l.charAt(i15);
                    char[] cArr = f295G;
                    int iC = G2.a.c(cCharAt2, cArr);
                    if (i14 + 1 < i8) {
                        int i16 = i15 + 1;
                        if (this.f299B[i16] == b.ALPHANUM) {
                            iC = (iC * 45) + G2.a.c(this.f413l.charAt(i16), cArr);
                            i5 = 2;
                        } else {
                            i5 = 1;
                        }
                    } else {
                        i5 = 1;
                    }
                    this.f300C.append(a0(iC, 1 << (i5 * 5)));
                    y(iC);
                }
            } else if (iOrdinal == 4) {
                if (i3 == 1) {
                    this.f300C.append("0");
                } else if (i3 == 2) {
                    this.f300C.append("00");
                } else if (i3 == 3) {
                    this.f300C.append("000");
                }
                this.f300C.append(a0(i8, 4 << i3));
                u("NUMB (" + i8 + ") ");
                for (int i17 = 0; i17 < i8; i17 += 3) {
                    int i18 = i7 + i17;
                    int numericValue = Character.getNumericValue(this.f413l.charAt(i18));
                    if (i17 + 1 < i8) {
                        int i19 = i18 + 1;
                        if (this.f299B[i19] == b.NUMERIC) {
                            numericValue = (numericValue * 10) + Character.getNumericValue(this.f413l.charAt(i19));
                            i6 = 2;
                        } else {
                            i6 = 1;
                        }
                    } else {
                        i6 = 1;
                    }
                    if (i17 + 2 < i8) {
                        int i20 = i18 + 2;
                        if (this.f299B[i20] == b.NUMERIC) {
                            numericValue = (numericValue * 10) + Character.getNumericValue(this.f413l.charAt(i20));
                            i6 = 3;
                        }
                    }
                    this.f300C.append(a0(numericValue, 1 << (i6 * 3)));
                    y(numericValue);
                }
            }
            if (i4 >= this.f413l.length() - 1) {
                break;
            } else {
                i7 = i4;
            }
        }
        if (i3 == 0) {
            this.f300C.append("000");
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && this.f300C.length() < 125) {
                    this.f300C.append("000000000");
                }
            } else if (this.f300C.length() < 81) {
                this.f300C.append("0000000");
            }
        } else if (this.f300C.length() < 37) {
            this.f300C.append("00000");
        }
        v();
    }

    private void O() {
        int[] iArr = new int[4];
        int[] iArr2 = new int[3];
        O o3 = new O();
        int length = 20 - this.f300C.length();
        if (length <= 4) {
            for (int i3 = 0; i3 < length; i3++) {
                this.f300C.append("0");
            }
        } else {
            int length2 = 8 - (this.f300C.length() % 8);
            if (length2 == 8) {
                length2 = 0;
            }
            for (int i4 = 0; i4 < length2; i4++) {
                this.f300C.append("0");
            }
            int length3 = this.f300C.length();
            if (20 - length3 > 4) {
                int i5 = (16 - length3) / 8;
                for (int i6 = 0; i6 < i5; i6++) {
                    if ((i6 & 1) != 0) {
                        this.f300C.append("00010001");
                    } else {
                        this.f300C.append("11101100");
                    }
                }
            }
            this.f300C.append("0000");
        }
        for (int i7 = 0; i7 < 2; i7++) {
            iArr[i7] = 0;
            int i8 = i7 * 8;
            if (this.f300C.charAt(i8) == '1') {
                iArr[i7] = iArr[i7] + 128;
            }
            if (this.f300C.charAt(i8 + 1) == '1') {
                iArr[i7] = iArr[i7] + 64;
            }
            if (this.f300C.charAt(i8 + 2) == '1') {
                iArr[i7] = iArr[i7] + 32;
            }
            if (this.f300C.charAt(i8 + 3) == '1') {
                iArr[i7] = iArr[i7] + 16;
            }
            if (this.f300C.charAt(i8 + 4) == '1') {
                iArr[i7] = iArr[i7] + 8;
            }
            if (this.f300C.charAt(i8 + 5) == '1') {
                iArr[i7] = iArr[i7] + 4;
            }
            if (this.f300C.charAt(i8 + 6) == '1') {
                iArr[i7] = iArr[i7] + 2;
            }
            if (this.f300C.charAt(i8 + 7) == '1') {
                iArr[i7] = iArr[i7] + 1;
            }
        }
        iArr[2] = 0;
        if (this.f300C.charAt(16) == '1') {
            iArr[2] = iArr[2] + 8;
        }
        if (this.f300C.charAt(17) == '1') {
            iArr[2] = iArr[2] + 4;
        }
        if (this.f300C.charAt(18) == '1') {
            iArr[2] = iArr[2] + 2;
        }
        if (this.f300C.charAt(19) == '1') {
            iArr[2] = iArr[2] + 1;
        }
        u("Codewords: ");
        for (int i9 = 0; i9 < 3; i9++) {
            y(iArr[i9]);
        }
        v();
        o3.d(285);
        o3.c(2, 0);
        o3.a(3, iArr);
        for (int i10 = 0; i10 < 2; i10++) {
            iArr2[i10] = o3.b(i10);
        }
        for (int i11 = 0; i11 < 2; i11++) {
            this.f300C.append(a0(iArr2[1 - i11], 128));
        }
    }

    private void P(a aVar) {
        int i3;
        int i4;
        int[] iArr = new int[6];
        int[] iArr2 = new int[7];
        O o3 = new O();
        int i5 = aVar == a.M ? 32 : 40;
        int length = 8 - (this.f300C.length() % 8);
        if (length == 8) {
            length = 0;
        }
        for (int i6 = 0; i6 < length; i6++) {
            this.f300C.append("0");
        }
        int length2 = (i5 - this.f300C.length()) / 8;
        for (int i7 = 0; i7 < length2; i7++) {
            if ((i7 & 1) != 0) {
                this.f300C.append("00010001");
            } else {
                this.f300C.append("11101100");
            }
        }
        if (aVar == a.M) {
            i4 = 6;
            i3 = 4;
        } else {
            i3 = 5;
            i4 = 5;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            iArr[i8] = 0;
            int i9 = i8 * 8;
            if (this.f300C.charAt(i9) == '1') {
                iArr[i8] = iArr[i8] + 128;
            }
            if (this.f300C.charAt(i9 + 1) == '1') {
                iArr[i8] = iArr[i8] + 64;
            }
            if (this.f300C.charAt(i9 + 2) == '1') {
                iArr[i8] = iArr[i8] + 32;
            }
            if (this.f300C.charAt(i9 + 3) == '1') {
                iArr[i8] = iArr[i8] + 16;
            }
            if (this.f300C.charAt(i9 + 4) == '1') {
                iArr[i8] = iArr[i8] + 8;
            }
            if (this.f300C.charAt(i9 + 5) == '1') {
                iArr[i8] = iArr[i8] + 4;
            }
            if (this.f300C.charAt(i9 + 6) == '1') {
                iArr[i8] = iArr[i8] + 2;
            }
            if (this.f300C.charAt(i9 + 7) == '1') {
                iArr[i8] = iArr[i8] + 1;
            }
        }
        u("Codewords: ");
        for (int i10 = 0; i10 < i3; i10++) {
            y(iArr[i10]);
        }
        v();
        o3.d(285);
        o3.c(i4, 0);
        o3.a(i3, iArr);
        for (int i11 = 0; i11 < i4; i11++) {
            iArr2[i11] = o3.b(i11);
        }
        for (int i12 = 0; i12 < i4; i12++) {
            this.f300C.append(a0(iArr2[(i4 - i12) - 1], 128));
        }
    }

    private void Q(a aVar) {
        int i3;
        int i4;
        int[] iArr = new int[12];
        int[] iArr2 = new int[12];
        O o3 = new O();
        int i5 = aVar == a.M ? 68 : 84;
        int length = i5 - this.f300C.length();
        if (length <= 4) {
            for (int i6 = 0; i6 < length; i6++) {
                this.f300C.append("0");
            }
        } else {
            int length2 = 8 - (this.f300C.length() % 8);
            if (length2 == 8) {
                length2 = 0;
            }
            for (int i7 = 0; i7 < length2; i7++) {
                this.f300C.append("0");
            }
            int length3 = i5 - this.f300C.length();
            if (length3 > 4) {
                int i8 = (length3 - 4) / 8;
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((i9 & 1) != 0) {
                        this.f300C.append("00010001");
                    } else {
                        this.f300C.append("11101100");
                    }
                }
            }
            this.f300C.append("0000");
        }
        if (aVar == a.M) {
            i3 = 9;
            i4 = 8;
        } else {
            i3 = 11;
            i4 = 6;
        }
        for (int i10 = 0; i10 < i3 - 1; i10++) {
            iArr[i10] = 0;
            int i11 = i10 * 8;
            if (this.f300C.charAt(i11) == '1') {
                iArr[i10] = iArr[i10] + 128;
            }
            if (this.f300C.charAt(i11 + 1) == '1') {
                iArr[i10] = iArr[i10] + 64;
            }
            if (this.f300C.charAt(i11 + 2) == '1') {
                iArr[i10] = iArr[i10] + 32;
            }
            if (this.f300C.charAt(i11 + 3) == '1') {
                iArr[i10] = iArr[i10] + 16;
            }
            if (this.f300C.charAt(i11 + 4) == '1') {
                iArr[i10] = iArr[i10] + 8;
            }
            if (this.f300C.charAt(i11 + 5) == '1') {
                iArr[i10] = iArr[i10] + 4;
            }
            if (this.f300C.charAt(i11 + 6) == '1') {
                iArr[i10] = iArr[i10] + 2;
            }
            if (this.f300C.charAt(i11 + 7) == '1') {
                iArr[i10] = iArr[i10] + 1;
            }
        }
        if (aVar == a.L) {
            iArr[10] = 0;
            if (this.f300C.charAt(80) == '1') {
                iArr[10] = iArr[10] + 8;
            }
            if (this.f300C.charAt(81) == '1') {
                iArr[10] = iArr[10] + 4;
            }
            if (this.f300C.charAt(82) == '1') {
                iArr[10] = iArr[10] + 2;
            }
            if (this.f300C.charAt(83) == '1') {
                iArr[10] = iArr[10] + 1;
            }
        }
        if (aVar == a.M) {
            iArr[8] = 0;
            if (this.f300C.charAt(64) == '1') {
                iArr[8] = iArr[8] + 8;
            }
            if (this.f300C.charAt(65) == '1') {
                iArr[8] = iArr[8] + 4;
            }
            if (this.f300C.charAt(66) == '1') {
                iArr[8] = iArr[8] + 2;
            }
            if (this.f300C.charAt(67) == '1') {
                iArr[8] = iArr[8] + 1;
            }
        }
        u("Codewords: ");
        for (int i12 = 0; i12 < i3; i12++) {
            y(iArr[i12]);
        }
        v();
        o3.d(285);
        o3.c(i4, 0);
        o3.a(i3, iArr);
        for (int i13 = 0; i13 < i4; i13++) {
            iArr2[i13] = o3.b(i13);
        }
        for (int i14 = 0; i14 < i4; i14++) {
            this.f300C.append(a0(iArr2[(i4 - i14) - 1], 128));
        }
    }

    private void R(a aVar) {
        int i3;
        int i4;
        int[] iArr = new int[17];
        int[] iArr2 = new int[15];
        O o3 = new O();
        int i5 = aVar == a.M ? 112 : 128;
        if (aVar == a.Q) {
            i5 = 80;
        }
        int length = 8 - (this.f300C.length() % 8);
        if (length == 8) {
            length = 0;
        }
        for (int i6 = 0; i6 < length; i6++) {
            this.f300C.append("0");
        }
        int length2 = (i5 - this.f300C.length()) / 8;
        for (int i7 = 0; i7 < length2; i7++) {
            if ((i7 & 1) != 0) {
                this.f300C.append("00010001");
            } else {
                this.f300C.append("11101100");
            }
        }
        int i8 = 10;
        int i9 = 14;
        if (aVar == a.M) {
            i3 = 14;
            i4 = 10;
        } else {
            i3 = 16;
            i4 = 8;
        }
        if (aVar != a.Q) {
            i8 = i3;
            i9 = i4;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            iArr[i10] = 0;
            int i11 = i10 * 8;
            if (this.f300C.charAt(i11) == '1') {
                iArr[i10] = iArr[i10] + 128;
            }
            if (this.f300C.charAt(i11 + 1) == '1') {
                iArr[i10] = iArr[i10] + 64;
            }
            if (this.f300C.charAt(i11 + 2) == '1') {
                iArr[i10] = iArr[i10] + 32;
            }
            if (this.f300C.charAt(i11 + 3) == '1') {
                iArr[i10] = iArr[i10] + 16;
            }
            if (this.f300C.charAt(i11 + 4) == '1') {
                iArr[i10] = iArr[i10] + 8;
            }
            if (this.f300C.charAt(i11 + 5) == '1') {
                iArr[i10] = iArr[i10] + 4;
            }
            if (this.f300C.charAt(i11 + 6) == '1') {
                iArr[i10] = iArr[i10] + 2;
            }
            if (this.f300C.charAt(i11 + 7) == '1') {
                iArr[i10] = iArr[i10] + 1;
            }
        }
        u("Codewords: ");
        for (int i12 = 0; i12 < i8; i12++) {
            y(iArr[i12]);
        }
        v();
        o3.d(285);
        o3.c(i9, 0);
        o3.a(i8, iArr);
        for (int i13 = 0; i13 < i9; i13++) {
            iArr2[i13] = o3.b(i13);
        }
        for (int i14 = 0; i14 < i9; i14++) {
            this.f300C.append(a0(iArr2[(i9 - i14) - 1], 128));
        }
    }

    private void S() {
        int i3;
        b bVar = b.NULL;
        for (int i4 = 0; i4 < 4; i4++) {
            this.f301D[i4] = 0;
        }
        for (int i5 = 0; i5 < this.f413l.length(); i5++) {
            if (bVar != this.f299B[i5]) {
                int i6 = 0;
                while (true) {
                    i3 = i6 + 1;
                    int i7 = i5 + i3;
                    if (i7 >= this.f413l.length()) {
                        break;
                    }
                    b[] bVarArr = this.f299B;
                    if (bVarArr[i7] != bVarArr[i5]) {
                        break;
                    } else {
                        i6 = i3;
                    }
                }
                int iOrdinal = this.f299B[i5].ordinal();
                if (iOrdinal == 1) {
                    int[] iArr = this.f301D;
                    int i8 = i3 * 13;
                    iArr[2] = iArr[2] + i8 + 5;
                    iArr[3] = iArr[3] + i8 + 7;
                } else if (iOrdinal == 2) {
                    int[] iArr2 = this.f301D;
                    int i9 = i3 * 8;
                    iArr2[2] = iArr2[2] + i9 + 6;
                    iArr2[3] = iArr2[3] + i9 + 8;
                } else if (iOrdinal == 3) {
                    int i10 = i3 % 2 == 1 ? ((i6 / 2) * 11) + 6 : (i3 / 2) * 11;
                    int[] iArr3 = this.f301D;
                    iArr3[1] = iArr3[1] + i10 + 4;
                    iArr3[2] = iArr3[2] + i10 + 6;
                    iArr3[3] = iArr3[3] + i10 + 8;
                } else if (iOrdinal == 4) {
                    int i11 = i3 % 3;
                    int i12 = i11 != 1 ? i11 != 2 ? (i3 / 3) * 10 : (((i6 - 1) / 3) * 10) + 7 : ((i6 / 3) * 10) + 4;
                    int[] iArr4 = this.f301D;
                    iArr4[0] = iArr4[0] + i12 + 3;
                    iArr4[1] = iArr4[1] + i12 + 5;
                    iArr4[2] = iArr4[2] + i12 + 7;
                    iArr4[3] = iArr4[3] + i12 + 9;
                }
                bVar = this.f299B[i5];
            }
        }
        int[] iArr5 = this.f301D;
        int i13 = iArr5[1];
        if (i13 < 37) {
            iArr5[1] = i13 + 5;
        }
        int i14 = iArr5[2];
        if (i14 < 81) {
            iArr5[2] = i14 + 7;
        }
        int i15 = iArr5[3];
        if (i15 < 125) {
            iArr5[3] = i15 + 9;
        }
    }

    private void T() {
        if (this.f413l.matches("[\u0000-ÿ]+")) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f413l.length(); i4++) {
            if (this.f413l.charAt(i4) == '?') {
                i3++;
            }
        }
        try {
            int i5 = 0;
            for (byte b3 : this.f413l.getBytes("SJIS")) {
                if (b3 == 63) {
                    i5++;
                }
            }
            if (i3 != i5) {
                throw new H("Invalid characters in input data");
            }
        } catch (UnsupportedEncodingException unused) {
            throw new H("Character encoding error");
        }
    }

    private boolean U(char c3) {
        boolean z3 = c3 >= '0' && c3 <= '9';
        if (c3 >= 'A' && c3 <= 'Z') {
            z3 = true;
        }
        if (c3 == ' ' || c3 == ':' || c3 == '$' || c3 == '%' || c3 == '*' || c3 == '+') {
            return true;
        }
        switch (c3) {
            case '-':
            case '.':
            case '/':
                return true;
            default:
                return z3;
        }
    }

    private char V(a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return 'L';
        }
        if (iOrdinal == 1) {
            return 'M';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? ' ' : 'H';
        }
        return 'Q';
    }

    private void W(int i3, int i4, int i5) {
        int[] iArr = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i6 = 0; i6 < 7; i6++) {
            for (int i7 = 0; i7 < 7; i7++) {
                if (iArr[(i7 * 7) + i6] == 1) {
                    this.f302E[((i7 + i5) * i3) + i6 + i4] = 17;
                } else {
                    this.f302E[((i7 + i5) * i3) + i6 + i4] = 16;
                }
            }
        }
    }

    private void X(int i3) {
        int length = this.f300C.length();
        int i4 = i3 - 1;
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        boolean z3 = true;
        do {
            int i8 = (i3 - 2) - (i6 * 2);
            int i9 = i5 * i3;
            int i10 = i8 + 1 + i9;
            if ((this.f302E[i10] & 240) == 0) {
                if (this.f300C.charAt(i7) == '1') {
                    this.f302E[i10] = 1;
                } else {
                    this.f302E[i10] = 0;
                }
                i7++;
            }
            if (i7 < length) {
                int i11 = i9 + i8;
                if ((this.f302E[i11] & 240) == 0) {
                    if (this.f300C.charAt(i7) == '1') {
                        this.f302E[i11] = 1;
                    } else {
                        this.f302E[i11] = 0;
                    }
                    i7++;
                }
            }
            i5 = z3 ? i5 - 1 : i5 + 1;
            if (i5 == 0) {
                i6++;
                i5 = 1;
                z3 = false;
            }
            if (i5 == i3) {
                i6++;
                i5 = i4;
                z3 = true;
            }
        } while (i7 < length);
    }

    private void Y() {
        int length = this.f413l.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f413l.charAt(i3) > 255) {
                this.f299B[i3] = b.KANJI;
            } else {
                this.f299B[i3] = b.BINARY;
                if (U(this.f413l.charAt(i3))) {
                    this.f299B[i3] = b.ALPHANUM;
                }
                if (this.f413l.charAt(i3) >= '0' && this.f413l.charAt(i3) <= '9') {
                    this.f299B[i3] = b.NUMERIC;
                }
            }
        }
        for (int i4 = 0; i4 < length; i4++) {
            b[] bVarArr = this.f299B;
            b bVar = bVarArr[i4];
            b bVar2 = b.NUMERIC;
            if (bVar == bVar2 && ((i4 != 0 && bVarArr[i4 - 1] != bVar2) || i4 == 0)) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + i4;
                    if (i6 >= length || this.f299B[i6] != b.NUMERIC) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 < 6) {
                    for (int i7 = 0; i7 < i5; i7++) {
                        this.f299B[i4 + i7] = b.ALPHANUM;
                    }
                }
            }
        }
        for (int i8 = 0; i8 < length; i8++) {
            b[] bVarArr2 = this.f299B;
            b bVar3 = bVarArr2[i8];
            b bVar4 = b.ALPHANUM;
            if (bVar3 == bVar4 && ((i8 != 0 && bVarArr2[i8 - 1] != bVar4) || i8 == 0)) {
                int i9 = 0;
                while (true) {
                    int i10 = i9 + i8;
                    if (i10 >= length || this.f299B[i10] != b.ALPHANUM) {
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i9 < 6) {
                    for (int i11 = 0; i11 < i9; i11++) {
                        this.f299B[i8 + i11] = b.BINARY;
                    }
                }
            }
        }
    }

    private void Z(int i3) {
        boolean z3 = true;
        for (int i4 = 0; i4 < i3; i4++) {
            if (z3) {
                int[] iArr = this.f302E;
                iArr[i4] = 33;
                iArr[i4 * i3] = 33;
                z3 = false;
            } else {
                int[] iArr2 = this.f302E;
                iArr2[i4] = 32;
                iArr2[i4 * i3] = 32;
                z3 = true;
            }
        }
        W(i3, 0, 0);
        for (int i5 = 0; i5 < 7; i5++) {
            int[] iArr3 = this.f302E;
            iArr3[(i3 * 7) + i5] = 16;
            iArr3[(i5 * i3) + 7] = 16;
        }
        this.f302E[(i3 * 7) + 7] = 16;
        for (int i6 = 0; i6 < 8; i6++) {
            int[] iArr4 = this.f302E;
            int i7 = (i3 * 8) + i6;
            iArr4[i7] = iArr4[i7] + 32;
            int i8 = (i6 * i3) + 8;
            iArr4[i8] = iArr4[i8] + 32;
        }
        int[] iArr5 = this.f302E;
        int i9 = (i3 * 8) + 8;
        iArr5[i9] = iArr5[i9] + 32;
    }

    private String a0(int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        while (i4 != 0) {
            if ((i3 & i4) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            i4 >>= 1;
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0235  */
    @Override // E2.Q
    protected void c() {
        int i3;
        boolean[] zArr = new boolean[4];
        StringBuilder sb = new StringBuilder();
        if (this.f413l.length() > 35) {
            throw new H("Input data too long");
        }
        T();
        for (int i4 = 0; i4 < 4; i4++) {
            zArr[i4] = true;
        }
        this.f299B = new b[40];
        Y();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f413l.length(); i7++) {
            if (this.f413l.charAt(i7) >= '0' && this.f413l.charAt(i7) <= '9') {
                i6++;
            }
            if (U(this.f413l.charAt(i7))) {
                i5++;
            }
        }
        if (i5 == this.f413l.length()) {
            for (int i8 = 0; i8 < this.f413l.length(); i8++) {
                this.f299B[i8] = b.ALPHANUM;
            }
        }
        if (i6 == this.f413l.length()) {
            for (int i9 = 0; i9 < this.f413l.length(); i9++) {
                this.f299B[i9] = b.NUMERIC;
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (int i10 = 0; i10 < this.f413l.length(); i10++) {
            b bVar = this.f299B[i10];
            if (bVar == b.BINARY) {
                z3 = true;
            }
            if (bVar == b.ALPHANUM) {
                z4 = true;
            }
            if (bVar == b.KANJI) {
                z5 = true;
            }
        }
        S();
        if (z3) {
            zArr[0] = false;
            zArr[1] = false;
        }
        if (z4) {
            zArr[0] = false;
        }
        if (z5) {
            zArr[0] = false;
            zArr[1] = false;
        }
        int[] iArr = this.f301D;
        if (iArr[0] > 20) {
            zArr[0] = false;
        }
        int i11 = iArr[1];
        if (i11 > 40) {
            zArr[1] = false;
        }
        int i12 = iArr[2];
        if (i12 > 84) {
            zArr[2] = false;
        }
        int i13 = iArr[3];
        if (i13 > 128) {
            throw new H("Input data too long");
        }
        a aVar = this.f298A;
        if (aVar == a.H) {
            throw new H("Error correction level H not available");
        }
        a aVar2 = a.Q;
        if (aVar == aVar2) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            if (i13 > 80) {
                throw new H("Input data too long");
            }
        }
        a aVar3 = a.M;
        if (aVar == aVar3) {
            zArr[0] = false;
            if (i11 > 32) {
                zArr[1] = false;
            }
            if (i12 > 68) {
                zArr[2] = false;
            }
            if (i13 > 112) {
                throw new H("Input data too long");
            }
        }
        int i14 = zArr[2] ? 2 : 3;
        if (zArr[1]) {
            i14 = 1;
        }
        int i15 = zArr[0] ? 0 : i14;
        int i16 = this.f304z;
        if (i16 >= 1 && i16 <= 4 && i16 - 1 >= i15) {
            i15 = i16 - 1;
        }
        if (i15 == 3) {
            if (i13 <= 112) {
                aVar = aVar3;
            }
            if (i13 <= 80) {
                aVar = aVar2;
            }
        }
        if (i15 == 2 && i12 <= 68) {
            aVar = aVar3;
        }
        if (i15 != 1 || i11 > 32) {
            aVar3 = aVar;
        }
        this.f300C = new StringBuilder();
        N(i15);
        if (this.f300C.length() > 128) {
            throw new H("Input data too long");
        }
        if (i15 == 0) {
            O();
            w("Version: M1");
        } else if (i15 == 1) {
            P(aVar3);
            w("Version: M2");
            w("ECC Level: " + V(aVar3));
        } else if (i15 == 2) {
            Q(aVar3);
            w("Version: M3");
            w("ECC Level: " + V(aVar3));
        } else if (i15 == 3) {
            R(aVar3);
            w("Version: M4");
            w("ECC Level: " + V(aVar3));
        }
        int i17 = f297I[i15];
        this.f302E = new int[i17 * i17];
        for (int i18 = 0; i18 < i17; i18++) {
            for (int i19 = 0; i19 < i17; i19++) {
                this.f302E[(i18 * i17) + i19] = 0;
            }
        }
        Z(i17);
        X(i17);
        int iL = L(i17);
        w("Mask Pattern: " + Integer.toBinaryString(iL));
        if (i15 == 1) {
            int iOrdinal = aVar3.ordinal();
            if (iOrdinal == 0) {
                i3 = 1;
            } else if (iOrdinal != 1) {
                i3 = 0;
            } else {
                i3 = 2;
            }
        } else if (i15 == 2) {
            int iOrdinal2 = aVar3.ordinal();
            if (iOrdinal2 == 0) {
                i3 = 3;
            } else if (iOrdinal2 != 1) {
                i3 = 0;
            } else {
                i3 = 4;
            }
        } else if (i15 == 3) {
            int iOrdinal3 = aVar3.ordinal();
            if (iOrdinal3 == 0) {
                i3 = 5;
            } else if (iOrdinal3 == 1) {
                i3 = 6;
            } else if (iOrdinal3 != 2) {
                i3 = 0;
            } else {
                i3 = 7;
            }
        } else {
            i3 = 0;
        }
        int i20 = f296H[(i3 << 2) + iL];
        if ((i20 & 16384) != 0) {
            int[] iArr2 = this.f302E;
            int i21 = (i17 * 8) + 1;
            iArr2[i21] = iArr2[i21] + 1;
        }
        if ((i20 & 8192) != 0) {
            int[] iArr3 = this.f302E;
            int i22 = (i17 * 8) + 2;
            iArr3[i22] = iArr3[i22] + 1;
        }
        if ((i20 & 4096) != 0) {
            int[] iArr4 = this.f302E;
            int i23 = (i17 * 8) + 3;
            iArr4[i23] = iArr4[i23] + 1;
        }
        if ((i20 & 2048) != 0) {
            int[] iArr5 = this.f302E;
            int i24 = (i17 * 8) + 4;
            iArr5[i24] = iArr5[i24] + 1;
        }
        if ((i20 & 1024) != 0) {
            int[] iArr6 = this.f302E;
            int i25 = (i17 * 8) + 5;
            iArr6[i25] = iArr6[i25] + 1;
        }
        if ((i20 & 512) != 0) {
            int[] iArr7 = this.f302E;
            int i26 = (i17 * 8) + 6;
            iArr7[i26] = iArr7[i26] + 1;
        }
        if ((i20 & 256) != 0) {
            int[] iArr8 = this.f302E;
            int i27 = (i17 * 8) + 7;
            iArr8[i27] = iArr8[i27] + 1;
        }
        if ((i20 & 128) != 0) {
            int[] iArr9 = this.f302E;
            int i28 = (i17 * 8) + 8;
            iArr9[i28] = iArr9[i28] + 1;
        }
        if ((i20 & 64) != 0) {
            int[] iArr10 = this.f302E;
            int i29 = (i17 * 7) + 8;
            iArr10[i29] = iArr10[i29] + 1;
        }
        if ((i20 & 32) != 0) {
            int[] iArr11 = this.f302E;
            int i30 = (i17 * 6) + 8;
            iArr11[i30] = iArr11[i30] + 1;
        }
        if ((i20 & 16) != 0) {
            int[] iArr12 = this.f302E;
            int i31 = (i17 * 5) + 8;
            iArr12[i31] = iArr12[i31] + 1;
        }
        if ((i20 & 8) != 0) {
            int[] iArr13 = this.f302E;
            int i32 = (i17 * 4) + 8;
            iArr13[i32] = iArr13[i32] + 1;
        }
        if ((i20 & 4) != 0) {
            int[] iArr14 = this.f302E;
            int i33 = (i17 * 3) + 8;
            iArr14[i33] = iArr14[i33] + 1;
        }
        if ((i20 & 2) != 0) {
            int[] iArr15 = this.f302E;
            int i34 = (i17 * 2) + 8;
            iArr15[i34] = iArr15[i34] + 1;
        }
        if ((i20 & 1) != 0) {
            int[] iArr16 = this.f302E;
            int i35 = i17 + 8;
            iArr16[i35] = iArr16[i35] + 1;
        }
        this.f416o = "";
        this.f417p = new String[i17];
        this.f418q = i17;
        this.f419r = new int[i17];
        for (int i36 = 0; i36 < i17; i36++) {
            sb.setLength(0);
            for (int i37 = 0; i37 < i17; i37++) {
                if ((this.f302E[(i36 * i17) + i37] & 1) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            this.f417p[i36] = Q.a(sb);
            this.f419r[i36] = 1;
        }
    }
}
