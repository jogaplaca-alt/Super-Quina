package E2;

import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class r extends Q {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final int[] f701C = {0, 161, 961, 2015, 2715, 0, 336, 1036, 1516};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f702D = {1, 10, 34, 70, 126, 4, 20, 48, 81};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f703E = {12, 10, 8, 6, 4, 5, 7, 9, 11};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f704F = {4, 6, 8, 10, 12, 10, 8, 6, 4};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f705G = {8, 6, 4, 3, 1, 2, 4, 6, 8};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f706H = {1, 3, 5, 6, 8, 7, 5, 3, 1};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f707I = {1, 3, 9, 27, 2, 6, 18, 54, 4, 12, 36, 29, 8, 24, 72, 58, 16, 48, 65, 37, 32, 17, 51, 74, 64, 34, 23, 69, 49, 68, 46, 59};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f708J = {3, 8, 2, 1, 1, 3, 5, 5, 1, 1, 3, 3, 7, 1, 1, 3, 1, 9, 1, 1, 2, 7, 4, 1, 1, 2, 5, 6, 1, 1, 2, 3, 8, 1, 1, 1, 5, 7, 1, 1, 1, 3, 9, 1, 1};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f709A = 1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private a f710B = a.LINEAR;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f711z;

    public enum a {
        LINEAR,
        OMNI,
        STACKED
    }

    protected void L(boolean z3) {
        this.f711z = z3;
    }

    public void M(a aVar) {
        this.f710B = aVar;
    }

    public void N(int i3) {
        if (i3 >= 1) {
            this.f709A = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid DataBar-14 Stacked separator height: " + i3);
    }

    /* JADX WARN: Code duplicated, block: B:225:0x0533  */
    @Override // E2.Q
    protected void c() {
        int i3;
        int i4;
        int i5;
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 5, 100);
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 8, 4);
        int[] iArr5 = new int[46];
        StringBuilder sb = new StringBuilder();
        if (this.f413l.length() > 13) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+?")) {
            throw new H("Invalid characters in input");
        }
        BigInteger bigInteger = new BigInteger(this.f413l);
        if (this.f711z) {
            bigInteger = bigInteger.add(new BigInteger("10000000000000"));
            i3 = 1;
        } else {
            i3 = 0;
        }
        BigInteger bigIntegerDivide = bigInteger.divide(new BigInteger("4537077"));
        BigInteger bigIntegerMod = bigInteger.mod(new BigInteger("4537077"));
        int[] iArr6 = {bigIntegerDivide.divide(new BigInteger("1597")).intValue(), bigIntegerDivide.mod(new BigInteger("1597")).intValue(), bigIntegerMod.divide(new BigInteger("1597")).intValue(), bigIntegerMod.mod(new BigInteger("1597")).intValue()};
        u("Data Characters: ");
        for (int i6 = 0; i6 < 4; i6++) {
            y(iArr6[i6]);
        }
        v();
        int i7 = iArr6[0];
        if (i7 >= 0 && i7 <= 160) {
            iArr[0] = 0;
        }
        int i8 = iArr6[0];
        if (i8 >= 161 && i8 <= 960) {
            iArr[0] = 1;
        }
        int i9 = iArr6[0];
        if (i9 >= 961 && i9 <= 2014) {
            iArr[0] = 2;
        }
        int i10 = iArr6[0];
        if (i10 >= 2015 && i10 <= 2714) {
            iArr[0] = 3;
        }
        int i11 = iArr6[0];
        if (i11 >= 2715 && i11 <= 2840) {
            iArr[0] = 4;
        }
        int i12 = iArr6[1];
        if (i12 >= 0 && i12 <= 335) {
            iArr[1] = 5;
        }
        int i13 = iArr6[1];
        if (i13 >= 336 && i13 <= 1035) {
            iArr[1] = 6;
        }
        int i14 = iArr6[1];
        if (i14 >= 1036 && i14 <= 1515) {
            iArr[1] = 7;
        }
        int i15 = iArr6[1];
        if (i15 >= 1516 && i15 <= 1596) {
            iArr[1] = 8;
        }
        int i16 = iArr6[3];
        if (i16 >= 0 && i16 <= 335) {
            iArr[3] = 5;
        }
        int i17 = iArr6[3];
        if (i17 >= 336 && i17 <= 1035) {
            iArr[3] = 6;
        }
        int i18 = iArr6[3];
        if (i18 >= 1036 && i18 <= 1515) {
            iArr[3] = 7;
        }
        int i19 = iArr6[3];
        if (i19 >= 1516 && i19 <= 1596) {
            iArr[3] = 8;
        }
        int i20 = iArr6[2];
        if (i20 >= 0 && i20 <= 160) {
            iArr[2] = 0;
        }
        int i21 = iArr6[2];
        if (i21 >= 161 && i21 <= 960) {
            iArr[2] = 1;
        }
        int i22 = iArr6[2];
        if (i22 >= 961 && i22 <= 2014) {
            iArr[2] = 2;
        }
        int i23 = iArr6[2];
        if (i23 >= 2015 && i23 <= 2714) {
            iArr[2] = 3;
        }
        int i24 = iArr6[2];
        if (i24 >= 2715 && i24 <= 2840) {
            iArr[2] = 4;
        }
        int i25 = iArr6[0];
        int[] iArr7 = f701C;
        int i26 = iArr[0];
        int i27 = i25 - iArr7[i26];
        int[] iArr8 = f702D;
        iArr2[0] = i27 / iArr8[i26];
        int i28 = iArr6[0];
        int i29 = iArr[0];
        iArr3[0] = (i28 - iArr7[i29]) % iArr8[i29];
        int i30 = iArr6[1];
        int i31 = iArr[1];
        iArr2[1] = (i30 - iArr7[i31]) % iArr8[i31];
        int i32 = iArr6[1];
        int i33 = iArr[1];
        iArr3[1] = (i32 - iArr7[i33]) / iArr8[i33];
        int i34 = iArr6[3];
        int i35 = iArr[3];
        iArr2[3] = (i34 - iArr7[i35]) % iArr8[i35];
        int i36 = iArr6[3];
        int i37 = iArr[3];
        iArr3[3] = (i36 - iArr7[i37]) / iArr8[i37];
        int i38 = 2;
        int i39 = iArr6[2];
        int i40 = iArr[2];
        iArr2[2] = (i39 - iArr7[i40]) / iArr8[i40];
        int i41 = iArr6[2];
        int i42 = iArr[2];
        iArr3[2] = (i41 - iArr7[i42]) % iArr8[i42];
        int i43 = 0;
        while (i43 < 4) {
            if (i43 == 0 || i43 == i38) {
                int i44 = iArr2[i43];
                int[] iArr9 = f703E;
                int i45 = iArr[i43];
                int[] iArrM = C0203t.M(i44, iArr9[i45], 4, f705G[i45], 1);
                iArr4[0][i43] = iArrM[0];
                iArr4[2][i43] = iArrM[1];
                iArr4[4][i43] = iArrM[2];
                iArr4[6][i43] = iArrM[3];
                int i46 = iArr3[i43];
                int[] iArr10 = f704F;
                int i47 = iArr[i43];
                int[] iArrM2 = C0203t.M(i46, iArr10[i47], 4, f706H[i47], 0);
                iArr4[1][i43] = iArrM2[0];
                iArr4[3][i43] = iArrM2[1];
                iArr4[5][i43] = iArrM2[2];
                iArr4[7][i43] = iArrM2[3];
            } else {
                int i48 = iArr2[i43];
                int[] iArr11 = f703E;
                int i49 = iArr[i43];
                int[] iArrM3 = C0203t.M(i48, iArr11[i49], 4, f705G[i49], 0);
                iArr4[0][i43] = iArrM3[0];
                iArr4[2][i43] = iArrM3[1];
                iArr4[4][i43] = iArrM3[2];
                iArr4[6][i43] = iArrM3[3];
                int i50 = iArr3[i43];
                int[] iArr12 = f704F;
                int i51 = iArr[i43];
                int[] iArrM4 = C0203t.M(i50, iArr12[i51], 4, f706H[i51], 1);
                iArr4[1][i43] = iArrM4[0];
                iArr4[3][i43] = iArrM4[1];
                iArr4[5][i43] = iArrM4[2];
                iArr4[7][i43] = iArrM4[3];
            }
            i43++;
            i38 = 2;
        }
        int i52 = 0;
        for (int i53 = 0; i53 < 8; i53++) {
            int[] iArr13 = f707I;
            int i54 = iArr13[i53];
            int[] iArr14 = iArr4[i53];
            i52 = i52 + (i54 * iArr14[0]) + (iArr13[i53 + 8] * iArr14[1]) + (iArr13[i53 + 16] * iArr14[2]) + (iArr13[i53 + 24] * iArr14[3]);
        }
        int i55 = i52 % 79;
        if (i55 >= 8) {
            i55++;
        }
        if (i55 >= 72) {
            i55++;
        }
        int i56 = i55 / 9;
        int i57 = i55 % 9;
        w("Checksum: " + i55);
        char c3 = 0;
        iArr5[0] = 1;
        iArr5[1] = 1;
        iArr5[44] = 1;
        iArr5[45] = 1;
        int i58 = 0;
        while (i58 < 8) {
            int[] iArr15 = iArr4[i58];
            iArr5[i58 + 2] = iArr15[c3];
            int[] iArr16 = iArr4[7 - i58];
            iArr5[i58 + 15] = iArr16[1];
            iArr5[i58 + 23] = iArr15[3];
            iArr5[i58 + 36] = iArr16[2];
            i58++;
            c3 = 0;
        }
        for (int i59 = 0; i59 < 5; i59++) {
            int[] iArr17 = f708J;
            iArr5[i59 + 10] = iArr17[(i56 * 5) + i59];
            iArr5[i59 + 31] = iArr17[(4 - i59) + (i57 * 5)];
        }
        boolean z3 = false;
        this.f418q = 0;
        boolean[] zArr2 = new boolean[100];
        int i60 = 0;
        while (i60 < 100) {
            zArr2[i60] = z3;
            i60++;
            z3 = false;
        }
        if (this.f710B == a.LINEAR) {
            int i61 = 0;
            int i62 = 0;
            char c4 = '0';
            for (int i63 = 46; i61 < i63; i63 = 46) {
                for (int i64 = 0; i64 < iArr5[i61]; i64++) {
                    if (c4 == '1') {
                        zArr[this.f418q][i62] = true;
                    }
                    i62++;
                }
                c4 = c4 == '1' ? '0' : '1';
                i61++;
            }
            if (this.f421t < i62) {
                this.f421t = i62;
            }
            if (this.f711z) {
                for (int i65 = 4; i65 < 92; i65++) {
                    zArr2[i65] = !zArr[0][i65];
                }
                boolean z4 = false;
                boolean z5 = true;
                int i66 = 16;
                char c5 = '1';
                while (i66 < 32) {
                    if (zArr[0][i66] || c5 != '1') {
                        zArr2[i66] = false;
                        c5 = '1';
                    } else {
                        zArr2[i66] = z5;
                        c5 = '0';
                    }
                    i66++;
                    z5 = true;
                }
                int i67 = 63;
                char c6 = '1';
                while (i67 < 78) {
                    if (zArr[z4 ? 1 : 0][i67] || c6 != '1') {
                        zArr2[i67] = z4;
                        c6 = '1';
                    } else {
                        zArr2[i67] = true;
                        c6 = '0';
                    }
                    i67++;
                    z4 = false;
                }
            }
            this.f418q++;
            StringBuilder sb2 = new StringBuilder(14);
            for (int length = this.f413l.length(); length < 13; length++) {
                sb2.append('0');
            }
            sb2.append(this.f413l);
            int iCharAt = 0;
            for (int i68 = 0; i68 < 13; i68++) {
                iCharAt += sb2.charAt(i68) - '0';
                if ((i68 & 1) == 0) {
                    iCharAt += (sb2.charAt(i68) - '0') * 2;
                }
            }
            int i69 = 10 - (iCharAt % 10);
            if (i69 == 10) {
                i69 = 0;
            }
            w("Check Digit: " + i69);
            sb2.append((char) (i69 + 48));
            this.f416o = "(01)" + ((Object) sb2);
        }
        int i70 = 23;
        if (this.f710B == a.STACKED) {
            int i71 = 0;
            char c7 = '0';
            for (int i72 = 0; i72 < 23; i72++) {
                for (int i73 = 0; i73 < iArr5[i72]; i73++) {
                    zArr[this.f418q][i71] = c7 == '1';
                    i71++;
                }
                c7 = c7 == '1' ? '0' : '1';
            }
            int i74 = this.f418q;
            boolean[] zArr3 = zArr[i74];
            zArr3[i71] = true;
            zArr3[i71 + 1] = false;
            int i75 = i74 + 2;
            this.f418q = i75;
            boolean[] zArr4 = zArr[i75];
            zArr4[0] = true;
            zArr4[1] = false;
            int i76 = 0;
            int i77 = 46;
            int i78 = 23;
            char c8 = '1';
            while (i78 < i77) {
                for (int i79 = 0; i79 < iArr5[i78]; i79++) {
                    zArr[this.f418q][i76 + 2] = c8 == '1';
                    i76++;
                }
                c8 = c8 == '1' ? '0' : '1';
                i78++;
                i77 = 46;
            }
            int i80 = 1;
            while (i80 < i77) {
                int i81 = this.f418q;
                if (zArr[i81 - 2][i80] == zArr[i81][i80]) {
                    if (!zArr[i81 - 2][i80]) {
                        zArr[i81 - 1][i80] = true;
                    }
                } else if (!zArr[i81 - 1][i80 - 1]) {
                    zArr[i81 - 1][i80] = true;
                }
                i80++;
                i77 = 46;
            }
            int i82 = 1;
            int i83 = 0;
            while (i83 < 4) {
                zArr[this.f418q - i82][i83] = false;
                i83++;
                i82 = 1;
            }
            boolean z6 = false;
            if (this.f711z) {
                int i84 = 4;
                for (int i85 = 46; i84 < i85; i85 = 46) {
                    zArr2[i84] = !zArr[0][i84];
                    i84++;
                }
                boolean z7 = true;
                int i86 = 16;
                char c9 = '1';
                while (i86 < 32) {
                    if (zArr[z6 ? 1 : 0][i86] || c9 != '1') {
                        zArr2[i86] = z6;
                        c9 = '1';
                    } else {
                        zArr2[i86] = z7;
                        c9 = '0';
                    }
                    i86++;
                    z6 = false;
                    z7 = true;
                }
            }
            this.f418q++;
            if (this.f421t < 50) {
                this.f421t = 50;
            }
        }
        if (this.f710B == a.OMNI) {
            char c10 = '0';
            int i87 = 0;
            for (int i88 = 0; i88 < 23; i88++) {
                for (int i89 = 0; i89 < iArr5[i88]; i89++) {
                    zArr[this.f418q][i87] = c10 == '1';
                    i87++;
                }
                c10 = c10 == '1' ? '0' : '1';
            }
            int i90 = this.f418q;
            boolean[] zArr5 = zArr[i90];
            zArr5[i87] = true;
            zArr5[i87 + 1] = false;
            int i91 = i90 + 4;
            this.f418q = i91;
            boolean[] zArr6 = zArr[i91];
            zArr6[0] = true;
            zArr6[1] = false;
            int i92 = 0;
            int i93 = 46;
            char c11 = '1';
            while (i70 < i93) {
                for (int i94 = 0; i94 < iArr5[i70]; i94++) {
                    zArr[this.f418q][i92 + 2] = c11 == '1';
                    i92++;
                }
                c11 = c11 == '1' ? '0' : '1';
                i70++;
                i93 = 46;
            }
            for (int i95 = 5; i95 < i93; i95 += 2) {
                zArr[this.f418q - 2][i95] = true;
            }
            int i96 = 4;
            while (i96 < i93) {
                int i97 = this.f418q;
                if (!zArr[i97 - 4][i96]) {
                    zArr[i97 - 3][i96] = true;
                }
                i96++;
                i93 = 46;
            }
            int i98 = 17;
            char c12 = '1';
            while (i98 < 33) {
                int i99 = this.f418q;
                if (zArr[i99 - 4][i98] || c12 != '1') {
                    zArr[i99 - 3][i98] = false;
                    c12 = '1';
                } else {
                    zArr[i99 - 3][i98] = true;
                    c12 = '0';
                }
                i98++;
            }
            int i100 = 4;
            for (int i101 = 46; i100 < i101; i101 = 46) {
                int i102 = this.f418q;
                if (!zArr[i102][i100]) {
                    zArr[i102 - 1][i100] = true;
                }
                i100++;
            }
            int i103 = 16;
            char c13 = '1';
            while (i103 < 32) {
                int i104 = this.f418q;
                if (zArr[i104][i103] || c13 != '1') {
                    zArr[i104 - 1][i103] = false;
                    c13 = '1';
                } else {
                    zArr[i104 - 1][i103] = true;
                    c13 = '0';
                }
                i103++;
            }
            if (this.f421t < 50) {
                this.f421t = 50;
            }
            if (this.f711z) {
                for (int i105 = 4; i105 < 46; i105++) {
                    zArr2[i105] = !zArr[0][i105];
                }
                boolean z8 = false;
                boolean z9 = true;
                int i106 = 16;
                char c14 = '1';
                while (i106 < 32) {
                    if (zArr[z8 ? 1 : 0][i106] || c14 != '1') {
                        zArr2[i106] = z8;
                        c14 = '1';
                    } else {
                        zArr2[i106] = z9;
                        c14 = '0';
                    }
                    i106++;
                    z8 = false;
                    z9 = true;
                }
            }
            this.f418q++;
        }
        int i107 = this.f418q;
        this.f417p = new String[i107 + i3];
        this.f419r = new int[i107 + i3];
        if (this.f711z) {
            sb.setLength(0);
            for (int i108 = 0; i108 < this.f421t; i108++) {
                if (zArr2[i108]) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            i4 = 0;
            this.f417p[0] = Q.a(sb);
            this.f419r[0] = 1;
        } else {
            i4 = 0;
        }
        int i109 = 0;
        while (true) {
            i5 = this.f418q;
            if (i109 >= i5) {
                break;
            }
            sb.setLength(i4);
            for (int i110 = 0; i110 < this.f421t; i110++) {
                if (zArr[i109][i110]) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            this.f417p[i109 + i3] = Q.a(sb);
            i109++;
        }
        a aVar = this.f710B;
        if (aVar == a.LINEAR) {
            this.f419r[i3] = -1;
        }
        if (aVar == a.STACKED) {
            int[] iArr18 = this.f419r;
            iArr18[i3] = 5;
            iArr18[i3 + 1] = this.f709A;
            iArr18[i3 + 2] = 7;
        }
        if (aVar == a.OMNI) {
            int[] iArr19 = this.f419r;
            iArr19[i3] = -1;
            int i111 = this.f709A;
            iArr19[i3 + 1] = i111;
            iArr19[i3 + 2] = i111;
            iArr19[i3 + 3] = i111;
            iArr19[i3 + 4] = -1;
        }
        if (this.f711z) {
            this.f418q = i5 + 1;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return false;
    }

    @Override // E2.Q
    public void D(Q.a aVar) {
    }
}
