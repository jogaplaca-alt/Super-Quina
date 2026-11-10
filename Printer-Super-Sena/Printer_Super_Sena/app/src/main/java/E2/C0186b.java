package E2;

import com.hoho.android.usbserial.driver.UsbId;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: E2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0186b extends Q {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f468E = {609, 608, 411, 413, 415, 417, 419, 421, 423, 425, 427, 429, 431, 433, 435, 437, 439, 441, 443, 445, 447, 449, 451, 453, 455, 457, 459, 607, 606, 410, 412, 414, 416, 418, 420, 422, 424, 426, 428, 430, 432, 434, 436, 438, 440, 442, 444, 446, 448, 450, 452, 454, 456, 458, 605, 604, 409, 408, 243, 245, 247, 249, 251, 253, 255, 257, 259, 261, 263, 265, 267, 269, 271, 273, 275, 277, 279, 281, 283, 460, 461, 603, 602, 407, 406, 242, 244, 246, 248, 250, 252, 254, 256, 258, 260, 262, 264, 266, 268, 270, 272, 274, 276, 278, 280, 282, 462, 463, 601, 600, 405, 404, 241, 240, 107, 109, 111, 113, 115, 117, 119, 121, 123, 125, 127, 129, 131, 133, 135, 137, 139, 284, 285, 464, 465, 599, 598, 403, 402, 239, 238, 106, 108, 110, 112, 114, 116, 118, 120, 122, 124, 126, 128, 130, 132, 134, 136, 138, 286, 287, 466, 467, 597, 596, 401, 400, 237, 236, 105, 104, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 140, 141, 288, 289, 468, 469, 595, 594, 399, 398, 235, 234, 103, 102, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 142, 143, 290, 291, 470, 471, 593, 592, 397, 396, 233, 232, 101, 100, 1, 1, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 0, 1, 28, 29, 144, 145, 292, 293, 472, 473, 591, 590, 395, 394, 231, 230, 99, 98, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 30, 31, 146, 147, 294, 295, 474, 475, 589, 588, 393, 392, 229, 228, 97, 96, 2027, 1, 0, 0, 0, 0, 0, 0, 0, 1, 2007, 32, 33, 148, 149, 296, 297, 476, 477, 587, 586, 391, 390, 227, 226, 95, 94, 2026, 1, 0, 1, 1, 1, 1, 1, 0, 1, 2008, 34, 35, 150, 151, 298, 299, 478, 479, 585, 584, 389, 388, 225, 224, 93, 92, 2025, 1, 0, 1, 0, 0, 0, 1, 0, 1, 2009, 36, 37, 152, 153, 300, 301, 480, 481, 583, 582, 387, 386, 223, 222, 91, 90, 2024, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2010, 38, 39, 154, 155, 302, 303, 482, 483, 581, 580, 385, 384, 221, 220, 89, 88, 2023, 1, 0, 1, 0, 0, 0, 1, 0, 1, 2011, 40, 41, 156, 157, 304, 305, 484, 485, 579, 578, 383, 382, 219, 218, 87, 86, 2022, 1, 0, 1, 1, 1, 1, 1, 0, 1, 2012, 42, 43, 158, 159, 306, 307, 486, 487, 577, 576, 381, 380, 217, 216, 85, 84, 2021, 1, 0, 0, 0, 0, 0, 0, 0, 1, 2013, 44, 45, 160, 161, 308, 309, 488, 489, 575, 574, 379, 378, 215, 214, 83, 82, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 46, 47, 162, 163, 310, 311, 490, 491, 573, 572, 377, 376, 213, 212, 81, 80, 0, 0, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 0, 0, 48, 49, 164, 165, 312, 313, 492, 493, 571, 570, 375, 374, 211, 210, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 58, 56, 54, 50, 51, 166, 167, 314, 315, 494, 495, 569, 568, 373, 372, 209, 208, 79, 77, 75, 73, 71, 69, 67, 65, 63, 61, 59, 57, 55, 52, 53, 168, 169, 316, 317, 496, 497, 567, 566, 371, 370, 206, 204, 202, 200, 198, 196, 194, 192, 190, 188, 186, 184, 182, 180, 178, 176, 174, 170, 171, 318, 319, 498, 499, 565, 564, 369, 368, 207, 205, 203, 201, 199, 197, 195, 193, 191, 189, 187, 185, 183, 181, 179, 177, 175, 172, 173, 320, 321, 500, 501, 563, 562, 366, 364, 362, 360, 358, 356, 354, 352, 350, 348, 346, 344, 342, 340, 338, 336, 334, 332, 330, 328, 326, 322, 323, 502, 503, 561, 560, 367, 365, 363, 361, 359, 357, 355, 353, 351, 349, 347, 345, 343, 341, 339, 337, 335, 333, 331, 329, 327, 324, 325, 504, 505, 558, 556, 554, 552, 550, 548, 546, 544, 542, 540, 538, 536, 534, 532, 530, 528, 526, 524, 522, 520, 518, UsbId.ARM_MBED, 514, 512, 510, 506, 507, 559, 557, 555, 553, 551, 549, 547, 545, 543, 541, 539, 537, 535, 533, 531, 529, 527, 525, 523, 521, 519, 517, 515, 513, 511, 508, 509};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[][] f469F = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 151, 151);

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f470G = {32, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 12, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 4, 4, 4, 4, 4, 23, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 24, 8, 24, 8, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 8, 8, 8, 8, 8, 8, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 4, 8, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8, 4, 8, 4, 4};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f471H = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 300, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 15, 16, 17, 18, 19, 1, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 301, 18, 302, 20, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 21, 22, 23, 24, 25, 26, 20, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 27, 21, 28, 22, 23, 24, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 25, 30, 26, 27};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final String[] f472I = {"00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001", "11010", "11011", "11100", "11101", "11110", "11111"};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String[] f473J = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final String[] f474K = {"000", "001", "010", "011", "100", "101", "110", "111"};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f475L = {21, 48, 60, 88, 120, 156, 196, 240, 230, 272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int[] f476M = {17, 40, 51, 76};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f477N = {96, 246, 408, 616, 840, 1104, 1392, 1704, 2040, 2420, 2820, 3250, 3720, 4200, 4730, 5270, 5840, 6450, 7080, 7750, 8430, 9150, 9900, 10680, 11484, 12324, 13188, 14076, 15000, 15948, 16920, 17940};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f478O = {84, 204, 352, 520, 720, 944, 1184, 1456, 1750, 2070, 2410, 2780, 3180, 3590, 4040, 4500, 5000, 5520, 6060, 6630, 7210, 7830, 8472, 9132, 9816, 10536, 11280, 12036, 12828, 13644, 14472, 15348};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final int[] f479P = {66, 168, 288, 432, 592, 776, 984, 1208, 1450, 1720, 2000, 2300, 2640, 2980, 3350, 3740, 4150, 4580, 5030, 5500, 5990, 6500, 7032, 7584, 8160, 8760, 9372, 9996, 10656, 11340, 12024, 12744};

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final int[] f480Q = {48, 126, 216, 328, 456, 600, 760, 936, 1120, 1330, 1550, 1790, 2050, 2320, 2610, 2910, 3230, 3570, 3920, 4290, 4670, 5070, 5484, 5916, 6360, 6828, 7308, 7800, 8316, 8844, 9384, 9948};

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final int[] f481R = {78, 198, 336, 520};

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final int[] f482S = {66, 168, 288, 440};

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final int[] f483T = {48, 138, 232, 360};

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private static final int[] f484U = {36, 102, 176, 280};

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private static final int[] f485V = {66, 64, 62, 60, 57, 55, 53, 51, 49, 47, 45, 42, 40, 38, 36, 34, 32, 30, 28, 25, 23, 21, 19, 17, 15, 13, 10, 8, 6, 4, 2, 0};

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private static final int[] f486W = {6, 4, 2, 0};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private String f488B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f491z = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f487A = 2;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f489C = 1;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private int f490D = 1;

    static {
        int i3;
        int i4;
        int i5;
        for (int i6 = 0; i6 < 151; i6++) {
            for (int i7 = 0; i7 < 151; i7++) {
                f469F[i6][i7] = 0;
            }
        }
        for (int i8 = 1; i8 < 33; i8++) {
            int i9 = i8 - 1;
            int i10 = (i9 * 112) + (i9 * 16 * i9) + 2;
            int i11 = (i9 * 4) + 28 + (i8 * 4);
            int i12 = i9 * 2;
            int i13 = 64 - i12;
            int i14 = 63 - i12;
            int i15 = i10;
            int i16 = 0;
            while (true) {
                i3 = i10 + i11;
                if (i15 >= i3) {
                    break;
                }
                int[][] iArr = f469F;
                int i17 = i13 + i16;
                iArr[N(i17)][N(i14)] = i15;
                iArr[N(i17)][N(62 - i12)] = i15 + 1;
                i16++;
                i15 += 2;
            }
            int i18 = i12 + 78;
            int i19 = 0;
            while (true) {
                i4 = i10 + (i11 * 2);
                if (i3 >= i4) {
                    break;
                }
                int[][] iArr2 = f469F;
                int i20 = i13 + i19;
                iArr2[N(i18)][N(i20)] = i3;
                iArr2[N(i12 + 79)][N(i20)] = i3 + 1;
                i19++;
                i3 += 2;
            }
            int i21 = i12 + 77;
            int i22 = 0;
            while (true) {
                i5 = (i11 * 3) + i10;
                if (i4 >= i5) {
                    break;
                }
                int[][] iArr3 = f469F;
                int i23 = i21 - i22;
                iArr3[N(i23)][N(i18)] = i4;
                iArr3[N(i23)][N(i12 + 79)] = i4 + 1;
                i22++;
                i4 += 2;
            }
            int i24 = 0;
            while (i5 < (i11 * 4) + i10) {
                int[][] iArr4 = f469F;
                int i25 = i21 - i24;
                iArr4[N(i14)][N(i25)] = i5;
                iArr4[N(62 - i12)][N(i25)] = i5 + 1;
                i24++;
                i5 += 2;
            }
        }
        for (int i26 = 69; i26 <= 81; i26++) {
            for (int i27 = 69; i27 <= 81; i27++) {
                f469F[i27][i26] = 1;
            }
        }
        for (int i28 = 70; i28 <= 80; i28++) {
            for (int i29 = 70; i29 <= 80; i29++) {
                f469F[i29][i28] = 0;
            }
        }
        for (int i30 = 71; i30 <= 79; i30++) {
            for (int i31 = 71; i31 <= 79; i31++) {
                f469F[i31][i30] = 1;
            }
        }
        for (int i32 = 72; i32 <= 78; i32++) {
            for (int i33 = 72; i33 <= 78; i33++) {
                f469F[i33][i32] = 0;
            }
        }
        for (int i34 = 73; i34 <= 77; i34++) {
            for (int i35 = 73; i35 <= 77; i35++) {
                f469F[i35][i34] = 1;
            }
        }
        for (int i36 = 74; i36 <= 76; i36++) {
            for (int i37 = 74; i37 <= 76; i37++) {
                f469F[i37][i36] = 0;
            }
        }
        for (int i38 = 11; i38 < 151; i38 += 16) {
            for (int i39 = 1; i39 < 151; i39 += 2) {
                int[][] iArr5 = f469F;
                iArr5[i39][i38] = 1;
                iArr5[i38][i39] = 1;
            }
        }
        for (int i40 = 0; i40 < 10; i40++) {
            f469F[N(i40 + 66)][N(64)] = i40 + 20000;
        }
        for (int i41 = 0; i41 < 10; i41++) {
            f469F[N(77)][N(i41 + 66)] = i41 + 20010;
        }
        for (int i42 = 0; i42 < 10; i42++) {
            f469F[N(75 - i42)][N(77)] = i42 + 20020;
        }
        for (int i43 = 0; i43 < 10; i43++) {
            f469F[N(64)][N(75 - i43)] = i43 + 20030;
        }
        int[][] iArr6 = f469F;
        iArr6[N(64)][N(64)] = 1;
        iArr6[N(65)][N(64)] = 1;
        iArr6[N(64)][N(65)] = 1;
        iArr6[N(77)][N(64)] = 1;
        iArr6[N(77)][N(65)] = 1;
        iArr6[N(77)][N(76)] = 1;
    }

    private void L(StringBuilder sb, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        if (i3 == 6) {
            i6 = 32;
            i7 = 32;
            i8 = 67;
        } else if (i3 == 8) {
            i6 = 128;
            i7 = 128;
            i8 = 301;
        } else if (i3 == 10) {
            i6 = 512;
            i7 = 512;
            i8 = 1033;
        } else {
            if (i3 != 12) {
                throw new H("Unrecognized codeword size: " + i3);
            }
            i6 = 2048;
            i7 = 2048;
            i8 = 4201;
        }
        O o3 = new O();
        int[] iArr = new int[i4 + 3];
        int[] iArr2 = new int[i5 + 3];
        for (int i9 = 0; i9 < i4; i9++) {
            for (int i10 = 0; i10 < i3; i10++) {
                if (sb.charAt((i9 * i3) + i10) == '1') {
                    iArr[i9] = iArr[i9] + (i6 >> i10);
                }
            }
        }
        o3.d(i8);
        o3.c(i5, 1);
        o3.a(i4, iArr);
        for (int i11 = 0; i11 < i5; i11++) {
            iArr2[i11] = o3.b(i11);
        }
        for (int i12 = i5 - 1; i12 >= 0; i12--) {
            for (int i13 = i7; i13 > 0; i13 >>= 1) {
                if ((iArr2[i12] & i13) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
        }
    }

    private StringBuilder M(String str, boolean z3, int i3) {
        StringBuilder sb = new StringBuilder();
        int iR = R(i3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < str.length()) {
            if ((sb.length() + 1) % iR == 0) {
                if (i5 == iR - 1) {
                    sb.append('0');
                } else {
                    if (i5 == 0) {
                        sb.append('1');
                    } else {
                        sb.append(str.charAt(i4));
                    }
                    i5 = 0;
                }
                i4--;
                i5 = 0;
            } else {
                sb.append(str.charAt(i4));
                if (str.charAt(i4) == '1') {
                    i5++;
                }
            }
            i4++;
        }
        int length = iR - (sb.length() % iR);
        if (length == iR) {
            length = 0;
        }
        for (int i6 = 0; i6 < length; i6++) {
            sb.append('1');
        }
        int length2 = sb.length();
        int i7 = 0;
        for (int i8 = length2 - iR; i8 < length2 && i8 >= 0; i8++) {
            if (sb.charAt(i8) == '1') {
                i7++;
            }
        }
        if (i7 == iR) {
            sb.setCharAt(length2 - 1, '0');
        }
        u("Codewords: ");
        for (int i9 = 0; i9 < length2 / iR; i9++) {
            int i10 = 1 << (iR - 1);
            int i11 = 0;
            for (int i12 = 0; i12 < iR; i12++) {
                if (sb.charAt((i9 * iR) + i12) == '1') {
                    i11 += i10;
                }
                i10 >>= 1;
            }
            y(i11);
        }
        v();
        return sb;
    }

    private static int N(int i3) {
        if (i3 > 10) {
            i3++;
        }
        if (i3 > 26) {
            i3++;
        }
        if (i3 > 42) {
            i3++;
        }
        if (i3 > 58) {
            i3++;
        }
        if (i3 > 74) {
            i3++;
        }
        if (i3 > 90) {
            i3++;
        }
        if (i3 > 106) {
            i3++;
        }
        if (i3 > 122) {
            i3++;
        }
        return i3 > 138 ? i3 + 1 : i3;
    }

    private String O(boolean z3, int i3, int i4) {
        int i5;
        StringBuilder sb = new StringBuilder();
        int i6 = 16;
        if (z3) {
            int i7 = i3 - 1;
            if ((i7 & 2) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if ((i7 & 1) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if (!this.f404c && ((i4 - 1) & 32) == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            while (i6 > 0) {
                if (((i4 - 1) & i6) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                i6 >>= 1;
            }
            i5 = 2;
        } else {
            while (i6 > 0) {
                if (((i3 - 1) & i6) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                i6 >>= 1;
            }
            if (!this.f404c && ((i4 - 1) & 1024) == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            for (int i8 = 512; i8 > 0; i8 >>= 1) {
                if (((i4 - 1) & i8) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            i5 = 4;
        }
        w("Mode Message: " + ((Object) sb));
        int[] iArr = new int[i5];
        int i9 = 0;
        for (int i10 = 0; i10 < i5; i10++) {
            for (int i11 = 0; i11 < 4; i11++) {
                if (sb.charAt((i10 * 4) + i11) == '1') {
                    iArr[i10] = iArr[i10] + (8 >> i11);
                }
            }
        }
        O o3 = new O();
        o3.d(19);
        if (z3) {
            o3.c(5, 1);
            o3.a(2, iArr);
            int[] iArr2 = new int[6];
            for (int i12 = 0; i12 < 5; i12++) {
                iArr2[i12] = o3.b(i12);
            }
            while (i9 < 5) {
                for (int i13 = 8; i13 > 0; i13 >>= 1) {
                    if ((iArr2[4 - i9] & i13) != 0) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                i9++;
            }
        } else {
            o3.c(6, 1);
            o3.a(4, iArr);
            int[] iArr3 = new int[6];
            for (int i14 = 0; i14 < 6; i14++) {
                iArr3[i14] = o3.b(i14);
            }
            while (i9 < 6) {
                for (int i15 = 8; i15 > 0; i15 >>= 1) {
                    if ((iArr3[5 - i9] & i15) != 0) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                i9++;
            }
        }
        return sb.toString();
    }

    private String P() {
        String string = Integer.toString(this.f414m);
        StringBuilder sb = new StringBuilder(string.length() * 4);
        for (int i3 = 0; i3 < string.length(); i3++) {
            sb.append(f473J[string.charAt(i3) - '.']);
            x(string.charAt(i3));
        }
        return sb.toString();
    }

    private String Q() {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr = this.f415n;
        int[] iArr2 = new int[iArr.length * 2];
        int[] iArr3 = new int[iArr.length * 2];
        int[] iArr4 = new int[iArr.length + 1];
        int[] iArr5 = new int[iArr.length + 1];
        int i8 = 0;
        if (this.f403b == Q.a.GS1) {
            iArr2[0] = 0;
            iArr3[0] = 8;
            iArr2[1] = 400;
            iArr3[1] = 8;
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i9 = this.f414m;
        if (i9 != 3) {
            iArr2[i3] = 0;
            int i10 = i3 + 1;
            iArr3[i3] = 8;
            int i11 = i9 < 100000 ? 5 : 6;
            if (i9 < 10000) {
                i11 = 4;
            }
            if (i9 < 1000) {
                i11 = 3;
            }
            if (i9 < 100) {
                i11 = 2;
            }
            if (i9 < 10) {
                i11 = 1;
            }
            iArr2[i10] = i11 + 400;
            i3 += 2;
            iArr3[i10] = 8;
        }
        int i12 = 0;
        while (true) {
            int[] iArr6 = this.f415n;
            i4 = 32;
            if (i12 >= iArr6.length) {
                break;
            }
            int i13 = iArr6[i12];
            if (i13 == -1) {
                iArr2[i3] = 0;
                int i14 = i3 + 1;
                iArr3[i3] = 8;
                iArr2[i14] = 400;
                i3 += 2;
                iArr3[i14] = 8;
            } else {
                if (i13 > 127 || i13 == 0) {
                    iArr2[i3] = i13;
                    i7 = i3 + 1;
                    iArr3[i3] = 32;
                } else {
                    iArr2[i3] = f471H[i13];
                    i7 = i3 + 1;
                    iArr3[i3] = f470G[iArr6[i12]];
                }
                i3 = i7;
            }
            i12++;
        }
        for (int i15 = 0; i15 < i3 - 1; i15++) {
            if (iArr2[i15] == 300) {
                int i16 = i15 + 1;
                if (iArr2[i16] == 11 && iArr3[i15] == 12 && iArr3[i16] == 4) {
                    iArr2[i15] = 2;
                    iArr3[i15] = 8;
                    if (i16 != i3) {
                        while (i16 < i3) {
                            int i17 = i16 + 1;
                            iArr2[i16] = iArr2[i17];
                            iArr3[i16] = iArr3[i17];
                            i16 = i17;
                        }
                    }
                    i3--;
                }
            }
            if (iArr2[i15] == 302) {
                int i18 = i15 + 1;
                if (iArr2[i18] == 1 && iArr3[i15] == 24 && iArr3[i18] == 23) {
                    iArr2[i15] = 3;
                    iArr3[i15] = 8;
                    if (i18 != i3) {
                        while (i18 < i3) {
                            int i19 = i18 + 1;
                            iArr2[i18] = iArr2[i19];
                            iArr3[i18] = iArr3[i19];
                            i18 = i19;
                        }
                    }
                    i3--;
                }
            }
            if (iArr2[i15] == 301) {
                int i20 = i15 + 1;
                if (iArr2[i20] == 1 && iArr3[i15] == 24 && iArr3[i20] == 23) {
                    iArr2[i15] = 4;
                    iArr3[i15] = 8;
                    if (i20 != i3) {
                        while (i20 < i3) {
                            int i21 = i20 + 1;
                            iArr2[i20] = iArr2[i21];
                            iArr3[i20] = iArr3[i21];
                            i20 = i21;
                        }
                    }
                    i3--;
                }
            }
            if (iArr2[i15] == 21) {
                int i22 = i15 + 1;
                if (iArr2[i22] == 1 && iArr3[i15] == 8 && iArr3[i22] == 23) {
                    iArr2[i15] = 5;
                    iArr3[i15] = 8;
                    if (i22 != i3) {
                        while (i22 < i3) {
                            int i23 = i22 + 1;
                            iArr2[i22] = iArr2[i23];
                            iArr3[i22] = iArr3[i23];
                            i22 = i23;
                        }
                    }
                    i3--;
                }
            }
        }
        int i24 = 0;
        for (int i25 = 0; i25 < i3; i25++) {
            if (i25 <= 0 || iArr3[i25] != iArr3[i25 - 1]) {
                iArr4[i24] = iArr3[i25];
                iArr5[i24] = 1;
                i24++;
            } else {
                int i26 = i24 - 1;
                iArr5[i26] = iArr5[i26] + 1;
            }
        }
        if ((iArr4[0] & 1) != 0) {
            iArr4[0] = 1;
        }
        if ((iArr4[0] & 2) != 0) {
            iArr4[0] = 2;
        }
        if ((iArr4[0] & 4) != 0) {
            iArr4[0] = 4;
        }
        if ((iArr4[0] & 8) != 0) {
            iArr4[0] = 8;
        }
        if (i24 > 1) {
            for (int i27 = 1; i27 < i24; i27++) {
                int i28 = iArr4[i27];
                int i29 = iArr4[i27 - 1];
                if ((i28 & i29) != 0) {
                    iArr4[i27] = i28 & i29;
                }
            }
            int i30 = i24 - 1;
            if ((iArr4[i30] & 1) != 0) {
                iArr4[i30] = 1;
            }
            if ((iArr4[i30] & 2) != 0) {
                iArr4[i30] = 2;
            }
            if ((iArr4[i30] & 4) != 0) {
                iArr4[i30] = 4;
            }
            if ((iArr4[i30] & 8) != 0) {
                iArr4[i30] = 8;
            }
            for (int i31 = i24 - 2; i31 > 0; i31--) {
                int i32 = iArr4[i31];
                int i33 = iArr4[i31 + 1];
                if ((i32 & i33) != 0) {
                    iArr4[i31] = i32 & i33;
                }
            }
            for (int i34 = 1; i34 < i24; i34++) {
                if ((iArr4[i34] & 8) != 0) {
                    iArr4[i34] = 8;
                }
                if ((iArr4[i34] & 4) != 0) {
                    iArr4[i34] = 4;
                }
                if ((iArr4[i34] & 2) != 0) {
                    iArr4[i34] = 2;
                }
                if ((iArr4[i34] & 1) != 0) {
                    iArr4[i34] = 1;
                }
            }
            int i35 = 0;
            do {
                int i36 = i35 + 1;
                if (iArr4[i35] == iArr4[i36]) {
                    iArr5[i35] = iArr5[i35] + iArr5[i36];
                    while (i36 < i24 - 1) {
                        int i37 = i36 + 1;
                        iArr4[i36] = iArr4[i37];
                        iArr5[i36] = iArr5[i37];
                        i36 = i37;
                    }
                    i24--;
                } else {
                    i35 = i36;
                }
            } while (i35 < i24 - 1);
        }
        int i38 = 0;
        int i39 = 0;
        while (true) {
            i5 = 64;
            if (i38 >= i24) {
                break;
            }
            if (iArr5[i38] >= 3 || iArr4[i38] == 32) {
                for (int i40 = 0; i40 < iArr5[i38]; i40++) {
                    iArr3[i39 + i40] = iArr4[i38];
                }
            } else {
                for (int i41 = 0; i41 < iArr5[i38]; i41++) {
                    iArr3[i39 + i41] = iArr4[i38] + 64;
                }
            }
            i39 += iArr5[i38];
            i38++;
        }
        if (i3 > 0 && iArr3[0] == 65) {
            iArr3[0] = 1;
        }
        for (int i42 = 0; i42 < i3; i42++) {
            int i43 = iArr2[i42];
            if (i43 >= 300 && i43 < 400) {
                int i44 = iArr3[i42];
                if (i44 > 64) {
                    i44 -= 64;
                }
                switch (i43) {
                    case 300:
                        if (i44 == 4) {
                            iArr2[i42] = 14;
                        } else if (i44 == 8) {
                            iArr2[i42] = 1;
                        }
                        break;
                    case 301:
                        if (i44 == 8) {
                            iArr2[i42] = 17;
                        } else if (i44 == 16) {
                            iArr2[i42] = 12;
                        }
                        break;
                    case 302:
                        if (i44 == 8) {
                            iArr2[i42] = 19;
                        } else if (i44 == 16) {
                            iArr2[i42] = 13;
                        }
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        u("Encoding: ");
        if (this.f490D != 1) {
            String[] strArr = f472I;
            sb.append(strArr[29]);
            u("ML ");
            sb.append(strArr[29]);
            u("UL ");
        }
        int i45 = 1;
        int i46 = 1;
        while (i8 < i3) {
            int i47 = iArr3[i8];
            if (i47 != i45) {
                if (iArr2[i8] < 400) {
                    int i48 = i45 == i4 ? i46 : i45;
                    if (i47 > i5) {
                        if (i47 != 65) {
                            if (i47 == 66) {
                                if (i48 == 1 || i48 == 4) {
                                    sb.append(f472I[28]);
                                    u("LL ");
                                } else if (i48 == 8) {
                                    String[] strArr2 = f472I;
                                    sb.append(strArr2[31]);
                                    u("UL ");
                                    sb.append(strArr2[28]);
                                    u("LL ");
                                } else if (i48 == 16) {
                                    sb.append(f473J[14]);
                                    u("UL ");
                                    sb.append(f472I[28]);
                                    u("LL ");
                                }
                                i48 = 2;
                            } else if (i47 == 68) {
                                if (i48 == 1 || i48 == 2) {
                                    sb.append(f472I[29]);
                                    u("ML ");
                                } else if (i48 == 8) {
                                    String[] strArr3 = f472I;
                                    sb.append(strArr3[31]);
                                    u("UL ");
                                    sb.append(strArr3[29]);
                                    u("ML ");
                                } else if (i48 == 16) {
                                    sb.append(f473J[14]);
                                    u("UL ");
                                    sb.append(f472I[29]);
                                    u("ML ");
                                }
                                i48 = 4;
                            } else if (i47 != 72) {
                                if (i47 == 80) {
                                    if (i48 == 1 || i48 == 2) {
                                        sb.append(f472I[30]);
                                        u("DL ");
                                    } else if (i48 == 4) {
                                        String[] strArr4 = f472I;
                                        sb.append(strArr4[29]);
                                        u("UL ");
                                        sb.append(strArr4[30]);
                                        u("DL ");
                                    } else if (i48 == 8) {
                                        String[] strArr5 = f472I;
                                        sb.append(strArr5[31]);
                                        u("UL ");
                                        sb.append(strArr5[30]);
                                        u("DL ");
                                    }
                                    i48 = 16;
                                }
                            } else if (i48 == 1 || i48 == 2 || i48 == 4) {
                                sb.append(f472I[0]);
                                u("PS ");
                            } else if (i48 == 16) {
                                sb.append(f473J[0]);
                                u("PS ");
                            }
                        } else if (i48 != 2) {
                            if (i48 == 4) {
                                sb.append(f472I[29]);
                                u("UL ");
                            } else if (i48 == 8) {
                                sb.append(f472I[31]);
                                u("UL ");
                            } else if (i48 == 16) {
                                sb.append(f473J[15]);
                                u("US ");
                            }
                            i48 = 1;
                        } else {
                            sb.append(f472I[28]);
                            u("US ");
                        }
                        i45 = i48;
                    } else {
                        if (i47 == 1) {
                            if (i48 == 2) {
                                String[] strArr6 = f472I;
                                sb.append(strArr6[29]);
                                u("ML ");
                                sb.append(strArr6[29]);
                                u("UL ");
                            } else if (i48 != 4) {
                                if (i48 == 8) {
                                    sb.append(f472I[31]);
                                    u("UL ");
                                } else if (i48 == 16) {
                                    sb.append(f473J[14]);
                                    u("UL ");
                                }
                                i45 = 1;
                            } else {
                                sb.append(f472I[29]);
                                u("UL ");
                            }
                            i45 = 1;
                        } else if (i47 == 2) {
                            if (i48 == 1 || i48 == 4) {
                                sb.append(f472I[28]);
                                u("LL ");
                            } else if (i48 == 8) {
                                String[] strArr7 = f472I;
                                sb.append(strArr7[31]);
                                u("UL ");
                                sb.append(strArr7[28]);
                                u("LL ");
                            } else if (i48 == 16) {
                                sb.append(f473J[14]);
                                u("UL ");
                                sb.append(f472I[28]);
                                u("LL ");
                            }
                            i48 = 2;
                        } else if (i47 == 4) {
                            if (i48 == 1 || i48 == 2) {
                                sb.append(f472I[29]);
                                u("ML ");
                            } else if (i48 == 8) {
                                String[] strArr8 = f472I;
                                sb.append(strArr8[31]);
                                u("UL ");
                                sb.append(strArr8[29]);
                                u("ML ");
                            } else if (i48 == 16) {
                                sb.append(f473J[14]);
                                u("UL ");
                                sb.append(f472I[29]);
                                u("ML ");
                            }
                            i48 = 4;
                        } else if (i47 == 8) {
                            if (i48 == 1 || i48 == 2) {
                                String[] strArr9 = f472I;
                                sb.append(strArr9[29]);
                                u("ML ");
                                sb.append(strArr9[30]);
                                u("PL ");
                            } else if (i48 == 4) {
                                sb.append(f472I[30]);
                                u("PL ");
                            } else if (i48 == 16) {
                                sb.append(f473J[14]);
                                u("UL ");
                                String[] strArr10 = f472I;
                                sb.append(strArr10[29]);
                                u("ML ");
                                sb.append(strArr10[30]);
                                u("PL ");
                            }
                            i48 = 8;
                        } else if (i47 == 16) {
                            if (i48 == 1 || i48 == 2) {
                                sb.append(f472I[30]);
                                u("DL ");
                            } else if (i48 == 4) {
                                String[] strArr11 = f472I;
                                sb.append(strArr11[29]);
                                u("UL ");
                                sb.append(strArr11[30]);
                                u("DL ");
                            } else if (i48 == 8) {
                                String[] strArr12 = f472I;
                                sb.append(strArr12[31]);
                                u("UL ");
                                sb.append(strArr12[30]);
                                u("DL ");
                            }
                            i48 = 16;
                        } else if (i47 == 32) {
                            if (i48 == 1 || i48 == 2 || i48 == 4) {
                                sb.append(f472I[31]);
                                u("BS ");
                                i6 = i48;
                                i45 = 32;
                            } else {
                                if (i48 == 8) {
                                    String[] strArr13 = f472I;
                                    sb.append(strArr13[31]);
                                    u("UL ");
                                    sb.append(strArr13[31]);
                                    u("BS ");
                                } else if (i48 != 16) {
                                    i45 = i48;
                                    i6 = i45;
                                } else {
                                    sb.append(f473J[14]);
                                    u("UL ");
                                    sb.append(f472I[31]);
                                    u("BS ");
                                }
                                i45 = 32;
                                i6 = 1;
                            }
                            int i49 = 0;
                            while (true) {
                                int i50 = i49 + 1;
                                if (iArr3[i8 + i49] == 32) {
                                    i49 = i50;
                                } else {
                                    if (i49 > 2079) {
                                        throw new H("Input too long");
                                    }
                                    if (i49 > 31) {
                                        sb.append("00000");
                                        for (int i51 = 1024; i51 > 0; i51 >>= 1) {
                                            if (((i49 - 31) & i51) != 0) {
                                                sb.append('1');
                                            } else {
                                                sb.append('0');
                                            }
                                        }
                                    } else {
                                        for (int i52 = 16; i52 > 0; i52 >>= 1) {
                                            if ((i49 & i52) != 0) {
                                                sb.append('1');
                                            } else {
                                                sb.append('0');
                                            }
                                        }
                                    }
                                    i46 = i6;
                                }
                            }
                        }
                        i45 = i48;
                    }
                }
            }
            int i53 = iArr3[i8];
            i5 = 64;
            if (i53 > 64) {
                i53 -= 64;
            }
            if (i53 == 1 || i53 == 2 || i53 == 4 || i53 == 8) {
                int i54 = iArr2[i8];
                if (i54 >= 400) {
                    u("FLG(" + (iArr2[i8] - 400) + ") ");
                    sb.append(f474K[iArr2[i8] - 400]);
                    if (iArr2[i8] != 400) {
                        sb.append(P());
                    }
                } else {
                    sb.append(f472I[i54]);
                    y(iArr2[i8]);
                }
            } else if (i53 == 16) {
                sb.append(f473J[iArr2[i8]]);
                y(iArr2[i8]);
            } else if (i53 == 32) {
                for (int i55 = 128; i55 > 0; i55 >>= 1) {
                    if ((iArr2[i8] & i55) != 0) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                y(iArr2[i8]);
            }
            i8++;
            i4 = 32;
        }
        v();
        return sb.toString();
    }

    private static int R(int i3) {
        if (i3 >= 23) {
            return 12;
        }
        if (i3 < 9 || i3 > 22) {
            return (i3 < 3 || i3 > 8) ? 6 : 8;
        }
        return 10;
    }

    @Override // E2.Q
    protected void c() {
        boolean z3;
        StringBuilder sbM;
        int i3;
        int[] iArr;
        int i4;
        int[] iArr2;
        int i5;
        int[] iArr3;
        int[] iArr4;
        if (this.f403b == Q.a.GS1 && this.f404c) {
            throw new H("Cannot encode in GS1 and Reader Initialisation mode at the same time");
        }
        b();
        if (this.f490D != 1) {
            StringBuilder sb = new StringBuilder();
            if (this.f488B != null) {
                sb.append(' ');
                sb.append(this.f488B);
                sb.append(' ');
            }
            sb.append((char) (this.f489C + 64));
            sb.append((char) (this.f490D + 64));
            this.f415n = G2.a.b(this.f415n, 0, Q.K(sb.toString(), StandardCharsets.US_ASCII, new int[0]));
        }
        String strQ = Q();
        int length = strQ.length();
        int i6 = this.f491z;
        if (i6 == 0) {
            int i7 = this.f404c ? 1 : 4;
            int i8 = 0;
            while (true) {
                int i9 = this.f487A;
                if (i9 == 1) {
                    iArr3 = f477N;
                    iArr4 = f481R;
                } else if (i9 == 2) {
                    iArr3 = f478O;
                    iArr4 = f482S;
                } else if (i9 == 3) {
                    iArr3 = f479P;
                    iArr4 = f483T;
                } else {
                    if (i9 != 4) {
                        throw new H("Unrecognized ECC level: " + this.f487A);
                    }
                    iArr3 = f480Q;
                    iArr4 = f484U;
                }
                i3 = 0;
                for (int i10 = 32; i10 > 0; i10--) {
                    int i11 = iArr3[i10 - 1];
                    if (length < i11) {
                        i3 = i10;
                        i8 = i11;
                    }
                }
                z3 = false;
                for (int i12 = i7; i12 > 0; i12--) {
                    int i13 = iArr4[i12 - 1];
                    if (length < i13) {
                        i3 = i12;
                        i8 = i13;
                        z3 = true;
                    }
                }
                if (i3 == 0) {
                    throw new H("Input too long (too many bits for selected ECC)");
                }
                sbM = M(strQ, z3, i3);
                int length2 = sbM.length();
                if (length2 <= i8) {
                    break;
                } else {
                    length = length2;
                }
            }
        } else {
            if (i6 < 1 || i6 > 4) {
                i6 -= 4;
                z3 = false;
            } else {
                z3 = true;
            }
            sbM = M(strQ, z3, i6);
            if (sbM.length() > R(i6) * ((z3 ? f476M : f475L)[i6 - 1] - 3)) {
                throw new H("Data too long for specified Aztec Code symbol size");
            }
            i3 = i6;
        }
        boolean z4 = this.f404c;
        if (z4 && z3 && i3 > 1) {
            throw new H("Symbol is too large for reader initialization");
        }
        if (z4 && i3 > 22) {
            throw new H("Symbol is too large for reader initialization");
        }
        int iR = R(i3);
        int length3 = sbM.length() / iR;
        int i14 = (z3 ? f476M[i3 - 1] : f475L[i3 - 1]) - length3;
        w("Compact Mode: " + z3);
        w("Layers: " + i3);
        w("Codeword Length: " + iR + " bits");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data Codewords: ");
        sb2.append(length3);
        w(sb2.toString());
        w("ECC Codewords: " + i14);
        L(sbM, iR, length3, i14);
        for (int i15 = 0; i15 < sbM.length() / 2; i15++) {
            int length4 = (sbM.length() - i15) - 1;
            char cCharAt = sbM.charAt(i15);
            sbM.setCharAt(i15, sbM.charAt(length4));
            sbM.setCharAt(length4, cCharAt);
        }
        String strO = O(z3, i3, length3);
        if (z3) {
            this.f416o = "";
            int[] iArr5 = f486W;
            int i16 = i3 - 1;
            int i17 = 27 - (iArr5[i16] * 2);
            this.f418q = i17;
            int[] iArr6 = new int[i17];
            this.f419r = iArr6;
            iArr6[0] = -1;
            this.f417p = new String[i17];
            int i18 = iArr5[i16];
            while (true) {
                int[] iArr7 = f486W;
                if (i18 >= 27 - iArr7[i16]) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(27);
                int i19 = iArr7[i16];
                while (true) {
                    iArr2 = f486W;
                    i5 = iArr2[i16];
                    if (i19 < 27 - i5) {
                        int i20 = f468E[(i18 * 27) + i19];
                        if (i20 == 0) {
                            sb3.append('0');
                        }
                        if (i20 == 1) {
                            sb3.append('1');
                        }
                        if (i20 >= 2) {
                            int i21 = i20 - 2;
                            if (i21 < sbM.length()) {
                                sb3.append(sbM.charAt(i21));
                            } else if (i20 >= 2000) {
                                sb3.append(strO.charAt(i20 - 2000));
                            } else {
                                sb3.append('0');
                            }
                        }
                        i19++;
                    }
                }
                this.f419r[i18 - i5] = 1;
                this.f417p[i18 - iArr2[i16]] = Q.a(sb3);
                i18++;
            }
        } else {
            this.f416o = "";
            int[] iArr8 = f485V;
            int i22 = i3 - 1;
            int i23 = 151 - (iArr8[i22] * 2);
            this.f418q = i23;
            int[] iArr9 = new int[i23];
            this.f419r = iArr9;
            iArr9[0] = -1;
            this.f417p = new String[i23];
            int i24 = iArr8[i22];
            while (true) {
                int[] iArr10 = f485V;
                if (i24 >= 151 - iArr10[i22]) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(151);
                int i25 = iArr10[i22];
                while (true) {
                    iArr = f485V;
                    i4 = iArr[i22];
                    if (i25 < 151 - i4) {
                        int i26 = f469F[i25][i24];
                        if (i26 == 1) {
                            sb4.append('1');
                        }
                        if (i26 == 0) {
                            sb4.append('0');
                        }
                        if (i26 >= 2) {
                            int i27 = i26 - 2;
                            if (i27 < sbM.length()) {
                                sb4.append(sbM.charAt(i27));
                            } else if (i26 >= 20000) {
                                sb4.append(strO.charAt(i26 - 20000));
                            } else {
                                sb4.append('0');
                            }
                        }
                        i25++;
                    }
                }
                this.f419r[i24 - i4] = 1;
                this.f417p[i24 - iArr[i22]] = Q.a(sb4);
                i24++;
            }
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
