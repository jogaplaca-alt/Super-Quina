package E2;

import java.math.BigInteger;

/* JADX INFO: renamed from: E2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0203t extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final int[] f736A = {28, 728, 6454, 203, 2408, 1, 16632};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final int[] f737B = {17, 13, 9, 15, 11, 19, 7};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final int[] f738C = {9, 13, 17, 11, 15, 7, 19};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f739D = {6, 5, 3, 5, 4, 8, 1};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f740E = {3, 4, 6, 4, 5, 1, 8};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f741F = {1, 3, 9, 27, 81, 65, 17, 51, 64, 14, 42, 37, 22, 66, 20, 60, 2, 6, 18, 54, 73, 41, 34, 13, 39, 28, 84, 74};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f742G = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 
    1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 1, 1};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f743z;

    private static int L(int i3, int i4) {
        int i5 = i3 - i4;
        if (i5 > i4) {
            i5 = i4;
            i4 = i5;
        }
        int i6 = 1;
        int i7 = 1;
        while (i3 > i4) {
            i6 *= i3;
            if (i7 <= i5) {
                i6 /= i7;
                i7++;
            }
            i3--;
        }
        while (i7 <= i5) {
            i6 /= i7;
            i7++;
        }
        return i6;
    }

    static int[] M(int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int iL;
        int i9 = i5;
        int[] iArr = new int[i9];
        int i10 = i3;
        int i11 = i4;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = i9 - 1;
            if (i12 >= i14) {
                iArr[i12] = i11;
                return iArr;
            }
            int i15 = 1 << i12;
            i13 |= i15;
            int i16 = 1;
            while (true) {
                i8 = i11 - i16;
                int i17 = i9 - i12;
                int i18 = i17 - 2;
                iL = L(i8 - 1, i18);
                if (i7 == 0 && i13 == 0) {
                    int i19 = i17 - 1;
                    if (i8 - i19 >= i19) {
                        iL -= L(i8 - i17, i18);
                    }
                }
                if (i17 - 1 > 1) {
                    int iL2 = 0;
                    for (int i20 = i8 - i18; i20 > i6; i20--) {
                        iL2 += L((i8 - i20) - 1, i17 - 3);
                    }
                    iL -= iL2 * (i14 - i12);
                } else if (i8 > i6) {
                    iL--;
                }
                i10 -= iL;
                if (i10 < 0) {
                    break;
                }
                i16++;
                i13 &= i15 ^ (-1);
                i9 = i5;
            }
            i10 += iL;
            iArr[i12] = i16;
            i12++;
            i9 = i5;
            i11 = i8;
        }
    }

    protected void N() {
        this.f743z = true;
    }

    @Override // E2.Q
    protected void c() {
        int[] iArr = new int[14];
        int[] iArr2 = new int[46];
        if (this.f413l.length() > 13) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+?")) {
            throw new H("Invalid characters in input");
        }
        if (this.f413l.length() == 13 && this.f413l.charAt(0) != '0' && this.f413l.charAt(0) != '1') {
            throw new H("Input out of range");
        }
        BigInteger bigInteger = new BigInteger(this.f413l);
        if (this.f743z) {
            bigInteger = bigInteger.add(new BigInteger("2015133531096"));
        }
        BigInteger bigIntegerDivide = bigInteger.divide(new BigInteger("2013571"));
        BigInteger bigIntegerMod = bigInteger.mod(new BigInteger("2013571"));
        int i3 = bigIntegerDivide.compareTo(new BigInteger("183063")) == 1 ? 1 : 0;
        if (bigIntegerDivide.compareTo(new BigInteger("820063")) == 1) {
            i3 = 2;
        }
        if (bigIntegerDivide.compareTo(new BigInteger("1000775")) == 1) {
            i3 = 3;
        }
        if (bigIntegerDivide.compareTo(new BigInteger("1491020")) == 1) {
            i3 = 4;
        }
        if (bigIntegerDivide.compareTo(new BigInteger("1979844")) == 1) {
            i3 = 5;
        }
        if (bigIntegerDivide.compareTo(new BigInteger("1996938")) == 1) {
            i3 = 6;
        }
        int i4 = bigIntegerMod.compareTo(new BigInteger("183063")) == 1 ? 1 : 0;
        if (bigIntegerMod.compareTo(new BigInteger("820063")) == 1) {
            i4 = 2;
        }
        if (bigIntegerMod.compareTo(new BigInteger("1000775")) == 1) {
            i4 = 3;
        }
        if (bigIntegerMod.compareTo(new BigInteger("1491020")) == 1) {
            i4 = 4;
        }
        if (bigIntegerMod.compareTo(new BigInteger("1979844")) == 1) {
            i4 = 5;
        }
        if (bigIntegerMod.compareTo(new BigInteger("1996938")) == 1) {
            i4 = 6;
        }
        w("Data Characters: " + (i3 + 1) + " " + (i4 + 1));
        switch (i3) {
            case 1:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("183064"));
                break;
            case 2:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("820064"));
                break;
            case 3:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("1000776"));
                break;
            case 4:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("1491021"));
                break;
            case 5:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("1979845"));
                break;
            case 6:
                bigIntegerDivide = bigIntegerDivide.subtract(new BigInteger("1996939"));
                break;
        }
        switch (i4) {
            case 1:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("183064"));
                break;
            case 2:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("820064"));
                break;
            case 3:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("1000776"));
                break;
            case 4:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("1491021"));
                break;
            case 5:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("1979845"));
                break;
            case 6:
                bigIntegerMod = bigIntegerMod.subtract(new BigInteger("1996939"));
                break;
        }
        int iIntValue = bigIntegerDivide.intValue();
        int iIntValue2 = bigIntegerMod.intValue();
        int[] iArr3 = f736A;
        int i5 = iArr3[i3];
        int i6 = iIntValue / i5;
        int i7 = iIntValue % i5;
        int i8 = iArr3[i4];
        int i9 = iIntValue2 / i8;
        int i10 = iIntValue2 % i8;
        int[] iArr4 = f737B;
        int i11 = iArr4[i3];
        int[] iArr5 = f739D;
        int[] iArrM = M(i6, i11, 7, iArr5[i3], 1);
        int i12 = iArrM[0];
        int i13 = iArrM[1];
        int i14 = iArrM[2];
        int i15 = iArrM[3];
        int i16 = iArrM[4];
        int i17 = iArrM[5];
        int i18 = iArrM[6];
        int[] iArr6 = f738C;
        int i19 = iArr6[i3];
        int[] iArr7 = f740E;
        int[] iArrM2 = M(i7, i19, 7, iArr7[i3], 0);
        int[] iArr8 = {i12, iArrM2[0], i13, iArrM2[1], i14, iArrM2[2], i15, iArrM2[3], i16, iArrM2[4], i17, iArrM2[5], i18, iArrM2[6]};
        int[] iArrM3 = M(i9, iArr4[i4], 7, iArr5[i4], 1);
        int i20 = iArrM3[0];
        int i21 = iArrM3[1];
        int i22 = iArrM3[2];
        int i23 = iArrM3[3];
        int i24 = iArrM3[4];
        int i25 = iArrM3[5];
        int i26 = iArrM3[6];
        int[] iArrM4 = M(i10, iArr6[i4], 7, iArr7[i4], 0);
        int[] iArr9 = {i20, iArrM4[0], i21, iArrM4[1], i22, iArrM4[2], i23, iArrM4[3], i24, iArrM4[4], i25, iArrM4[5], i26, iArrM4[6]};
        int i27 = 0;
        int i28 = 0;
        for (int i29 = 14; i27 < i29; i29 = 14) {
            int[] iArr10 = f741F;
            i28 = i28 + (iArr10[i27] * iArr8[i27]) + (iArr10[i27 + 14] * iArr9[i27]);
            i27++;
        }
        int i30 = i28 % 89;
        w("Checksum: " + i30);
        int i31 = 0;
        for (int i32 = 14; i31 < i32; i32 = 14) {
            iArr[i31] = f742G[(i30 * 14) + i31];
            i31++;
        }
        iArr2[0] = 1;
        iArr2[1] = 1;
        iArr2[44] = 1;
        iArr2[45] = 1;
        for (int i33 = 0; i33 < 14; i33++) {
            iArr2[i33 + 2] = iArr8[i33];
            iArr2[i33 + 16] = iArr[i33];
            iArr2[i33 + 30] = iArr9[i33];
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z3 = false;
        for (int i34 = 0; i34 < 46; i34++) {
            for (int i35 = 0; i35 < iArr2[i34]; i35++) {
                if (z3) {
                    sb.append('1');
                    sb2.append('0');
                } else {
                    sb.append('0');
                    sb2.append('1');
                }
            }
            z3 = !z3;
        }
        this.f416o = "(01)";
        String str = "";
        for (int length = this.f413l.length(); length < 13; length++) {
            str = str + "0";
        }
        String str2 = str + this.f413l;
        int iCharAt = 0;
        for (int i36 = 0; i36 < 13; i36++) {
            iCharAt += str2.charAt(i36) - '0';
            if ((i36 & 1) == 0) {
                iCharAt += (str2.charAt(i36) - '0') * 2;
            }
        }
        int i37 = 10 - (iCharAt % 10);
        if (i37 == 10) {
            i37 = 0;
        }
        this.f416o += (str2 + ((char) (i37 + 48)));
        boolean z4 = this.f743z;
        int i38 = (z4 ? 1 : 0) + 1;
        this.f418q = i38;
        int[] iArr11 = new int[i38];
        this.f419r = iArr11;
        iArr11[z4 ? 1 : 0] = -1;
        String[] strArr = new String[i38];
        this.f417p = strArr;
        strArr[z4 ? 1 : 0] = Q.a(sb);
        if (this.f743z) {
            sb2.delete(70, sb2.length());
            sb2.delete(0, 4);
            this.f419r[0] = 1;
            this.f417p[0] = "04" + Q.a(sb2);
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return false;
    }
}
