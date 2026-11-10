package E2;

import com.hoho.android.usbserial.driver.UsbId;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes.dex */
public class x extends Q {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final char[] f798G = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f799H = {9, 30, 59, 114, 170, 237, 315, 405, 506, 618, 741, 875, 1021};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f800I = {11, 40, 79, 146, 218, 305, 405, 521, 650, 794, 953, 1125, 1313};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f801J = {0, 15, 13, 11, 9, 45, 40, 35, 30, 25, 89, 79, 69, 59, 49, 146, 130, 114, 98, 81, 218, 194, 170, 146, 121, 305, 271, 237, 203, 169, 405, 360, 315, 270, 225, 521, 463, 405, 347, 289, 650, 578, 506, 434, 361, 794, 706, 618, 530, 441, 953, 847, 741, 635, 529, 1125, 1000, 875, 750, 625, 1313, 1167, 1021, 875, 729};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int[] f802K = {18, 50, 98, 81, 121, 113, 113, 116, 121, 126, 118, 125, 122};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f803L = {1, 1, 1, 2, 2, 2, 2, 3, 2, 7, 5, 10, 6};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int[] f804M = {0, 0, 0, 0, 0, 1, 2, 2, 4, 0, 4, 0, 6};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f805N = {0, 0, 0, 0, 3, 1, 0, 0, 5, 1, 0, 0, 7, 1, 0, 0, 9, 1, 0, 0, 5, 1, 0, 0, 10, 1, 0, 0, 15, 1, 0, 0, 20, 1, 0, 0, 25, 1, 0, 0, 9, 1, 0, 0, 19, 1, 0, 0, 29, 1, 0, 0, 39, 1, 0, 0, 49, 1, 0, 0, 8, 2, 0, 0, 16, 2, 0, 0, 24, 2, 0, 0, 32, 2, 0, 0, 41, 1, 10, 1, 12, 2, 0, 0, 24, 2, 0, 0, 36, 2, 0, 0, 48, 2, 0, 0, 61, 1, 60, 1, 11, 3, 0, 0, 23, 1, 22, 2, 34, 2, 33, 1, 45, 3, 0, 0, 57, 1, 56, 2, 12, 1, 11, 3, 23, 2, 22, 2, 34, 3, 33, 1, 45, 4, 0, 0, 57, 1, 56, 3, 12, 2, 11, 3, 23, 5, 0, 0, 35, 3, 34, 2, 47, 1, 46, 4, 58, 4, 57, 1, 12, 6, 0, 0, 24, 6, 0, 0, 36, 6, 0, 0, 48, 6, 0, 0, 61, 1, 60, 5, 13, 4, 12, 3, 26, 1, 25, 6, 38, 5, 37, 2, 51, 2, 50, 5, 63, 7, 0, 0, 12, 6, 11, 3, 24, 4, 23, 5, 36, 2, 35, 7, 47, 9, 0, 0, 59, 7, 58, 2, 13, 5, 12, 5, 25, 10, 0, 0, 38, 5, 37, 5, 50, 10, 0, 0, 63, 5, 62, 5, 13, 1, 12, 11, 25, 3, 24, 9, 37, 5, 36, 7, 49, 7, 48, 5, 61, 9, 60, 3};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f806O = {728, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 727, 624, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 651, 726, 623, 528, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 553, 652, 725, 622, 527, 440, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 463, 554, 653, 724, 621, 526, 439, 360, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 381, 464, 555, 654, 723, 620, 525, 438, 359, 288, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 307, 382, 465, 556, 655, 722, 619, 524, 437, 358, 287, 224, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 241, 308, 383, 466, 557, 656, 721, 618, 523, 436, 357, 286, 223, 168, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 183, 242, 309, 384, 467, 558, 657, 720, 617, 522, 435, 356, 285, 222, 167, 120, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 133, 184, 243, 310, 385, 468, 559, 658, 719, 616, 521, 434, 355, 284, 221, 166, 119, 80, 49, 50, 51, 52, 53, 54, 55, 56, 91, 134, 185, 244, 311, 386, 469, 560, 659, 718, 615, 520, 433, 354, 283, 220, 165, 118, 79, 48, 25, 26, 27, 28, 29, 30, 57, 92, 135, 186, 245, 312, 387, 470, 561, 660, 717, 614, 519, 432, 353, 282, 219, 164, 117, 78, 47, 24, 9, 10, 11, 12, 31, 58, 93, 136, 187, 246, 313, 388, 471, 562, 661, 716, 613, 518, 431, 352, 281, 218, 163, 116, 77, 46, 23, 8, 1, 2, 13, 32, 59, 94, 137, 188, 247, 314, 389, 472, 563, 662, 715, 612, 517, 430, 351, 280, 217, 162, 115, 76, 45, 22, 7, 0, 3, 14, 33, 60, 95, 138, 189, 248, 315, 390, 473, 564, 663, 714, 611, UsbId.ARM_MBED, 429, 350, 279, 216, 161, 114, 75, 44, 21, 6, 5, 4, 15, 34, 61, 96, 139, 190, 249, 316, 391, 474, 565, 664, 713, 610, 515, 428, 349, 278, 215, 160, 113, 74, 43, 20, 19, 18, 17, 16, 35, 62, 97, 140, 191, 250, 317, 392, 475, 566, 665, 712, 609, 514, 427, 348, 277, 214, 159, 112, 73, 42, 41, 40, 39, 38, 37, 36, 63, 98, 141, 192, 251, 318, 393, 476, 567, 666, 711, 608, 513, 426, 347, 276, 213, 158, 111, 72, 71, 70, 69, 68, 67, 66, 65, 64, 99, 142, 193, 252, 319, 394, 477, 568, 667, 710, 607, 512, 425, 346, 275, 212, 157, 110, 109, 108, 107, 106, 105, 104, 103, 102, 101, 100, 143, 194, 253, 320, 395, 478, 569, 668, 709, 606, 511, 424, 345, 274, 211, 156, 155, 154, 153, 152, 151, 150, 149, 148, 147, 146, 145, 144, 195, 254, 321, 396, 479, 570, 669, 708, 605, 510, 423, 344, 273, 210, 209, 208, 207, 206, 205, 204, 203, 202, 201, 200, 199, 198, 197, 196, 255, 322, 397, 480, 571, 670, 707, 604, 509, 422, 343, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 323, 398, 481, 572, 671, 706, 603, 508, 421, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 329, 328, 327, 326, 325, 324, 399, 482, 573, 672, 705, 602, 507, 420, 419, 418, 417, 416, 415, 414, 413, 412, 411, 410, 409, 408, 407, 406, 405, 404, 403, 402, 401, 400, 483, 574, 673, 704, 601, 506, 505, 504, 503, 502, 501, 500, 499, 498, 497, 496, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 575, 674, 703, 600, 599, 598, 597, 596, 595, 594, 593, 592, 591, 590, 589, 588, 587, 586, 585, 584, 583, 582, 581, 580, 579, 578, 577, 576, 675, 702, 701, 700, 699, 698, 697, 696, 695, 694, 693, 692, 691, 690, 689, 688, 687, 686, 685, 684, 683, 682, 681, 680, 679, 678, 677, 676};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final char[] f807P = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final int[] f808A = new int[1460];

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean[] f809B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private a f810C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private a f811D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f812E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f813F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private StringBuilder f814z;

    private enum a {
        NULL,
        GM_NUMBER,
        GM_LOWER,
        GM_UPPER,
        GM_MIXED,
        GM_CONTROL,
        GM_BYTE,
        GM_CHINESE
    }

    public x() {
        a aVar = a.NULL;
        this.f810C = aVar;
        this.f811D = aVar;
        this.f812E = 0;
        this.f813F = -1;
    }

    private void L(int i3, int i4) {
        for (int i5 = 0; i5 < 9; i5++) {
            if (((256 >> i5) & i4) != 0) {
                this.f814z.insert(i3 + i5, '0');
            } else {
                this.f814z.insert(i3 + i5, '1');
            }
        }
    }

    private void M(int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr = new int[1320];
        int[] iArr2 = new int[130];
        int[] iArr3 = new int[115];
        int[] iArr4 = new int[70];
        O o3 = new O();
        int i8 = i4 - 1;
        int i9 = i5 - 1;
        int i10 = f801J[(i8 * 5) + i9];
        for (int i11 = 0; i11 < 1320; i11++) {
            iArr[i11] = 0;
        }
        for (int i12 = 0; i12 < i3; i12++) {
            for (int i13 = 0; i13 < 7; i13++) {
                if (this.f814z.charAt((i12 * 7) + i13) == '1') {
                    iArr[i12] = iArr[i12] + (64 >> i13);
                }
            }
        }
        u("Codewords: ");
        for (int i14 = 0; i14 < i3; i14++) {
            y(iArr[i14]);
        }
        v();
        iArr[i3] = 0;
        for (int i15 = i3 + 1; i15 < i10; i15++) {
            if ((i15 & 1) != 0) {
                iArr[i15] = 126;
            } else {
                iArr[i15] = 0;
            }
        }
        int i16 = f802K[i8];
        int i17 = f803L[i8];
        int i18 = i16 - 1;
        int i19 = f804M[i8];
        int[] iArr5 = f805N;
        int i20 = (i8 * 20) + (i9 * 4);
        int i21 = iArr5[i20];
        int i22 = iArr5[i20 + 1];
        int i23 = iArr5[i20 + 2];
        int i24 = 0;
        int i25 = 0;
        while (true) {
            int i26 = i17 + i19;
            if (i24 >= i26) {
                return;
            }
            int i27 = i24 < i17 ? i16 : i18;
            if (i24 < i22) {
                i6 = i23;
                i7 = i21;
            } else {
                i6 = i23;
                i7 = i6;
            }
            int i28 = i27 - i7;
            int i29 = i21;
            for (int i30 = 0; i30 < i28; i30++) {
                iArr3[i30] = iArr[i25];
                i25++;
            }
            o3.d(137);
            o3.c(i7, 1);
            o3.a(i28, iArr3);
            for (int i31 = 0; i31 < i7; i31++) {
                iArr4[i31] = o3.b(i31);
            }
            for (int i32 = 0; i32 < i28; i32++) {
                iArr2[i32] = iArr3[i32];
            }
            for (int i33 = 0; i33 < i7; i33++) {
                iArr2[i33 + i28] = iArr4[(i7 - i33) - 1];
            }
            for (int i34 = 0; i34 < i18; i34++) {
                this.f808A[(i26 * i34) + i24] = iArr2[i34];
            }
            if (i27 == i16) {
                this.f808A[(i26 * i18) + i24] = iArr2[i18];
            }
            i24++;
            i17 = i17;
            i23 = i6;
            i21 = i29;
        }
    }

    private void N(int i3, int i4, int i5, int i6) {
        int[] iArr = new int[i4 + 1];
        int[] iArr2 = new int[i5 * i5];
        for (int i7 = 0; i7 <= i4; i7++) {
            if (i6 == 1) {
                iArr[i7] = 3 - (i7 % 4);
            } else {
                iArr[i7] = ((i7 + 5) - i6) % 4;
            }
        }
        for (int i8 = 0; i8 < i5; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                iArr2[(i8 * i5) + i9] = 0;
            }
        }
        int i10 = i5 / 2;
        int i11 = i10;
        for (int i12 = 0; i12 <= i4; i12++) {
            for (int i13 = i10; i13 <= i11; i13++) {
                iArr2[(i10 * i5) + i13] = iArr[i12];
                int i14 = i13 * i5;
                iArr2[i14 + i10] = iArr[i12];
                int i15 = (i5 - i10) - 1;
                iArr2[(i15 * i5) + i13] = iArr[i12];
                iArr2[i14 + i15] = iArr[i12];
            }
            i10--;
            i11++;
        }
        for (int i16 = 0; i16 < i5; i16++) {
            for (int i17 = 0; i17 < i5; i17++) {
                int i18 = iArr2[(i16 * i5) + i17];
                if ((i18 & 2) != 0) {
                    this.f809B[(((i16 * 6) + 1) * i3) + (i17 * 6) + 1] = true;
                }
                if ((i18 & 1) != 0) {
                    this.f809B[(((i16 * 6) + 1) * i3) + (i17 * 6) + 2] = true;
                }
            }
        }
    }

    private int P(int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = this.f415n[i3 + i6] <= 255 ? i5 + 8 : i5 + 16;
        }
        return i5;
    }

    private int Q(int i3, int i4) {
        int i5;
        int i6 = 0;
        int i7 = 0;
        do {
            i6 += 13;
            if (i7 < i4) {
                int[] iArr = this.f415n;
                int i8 = i3 + i7;
                if (iArr[i8] == 13 && iArr[i8 + 1] == 10) {
                    i7++;
                }
                int i9 = i3 + i7;
                int i10 = iArr[i9];
                if (i10 >= 48 && i10 <= 57 && (i5 = iArr[i9 + 1]) >= 48 && i5 <= 57) {
                    i7++;
                }
            }
            i7++;
        } while (i7 < i4);
        return i6;
    }

    private int R(int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += 6;
            for (int i7 = 0; i7 < 63; i7++) {
                if (this.f415n[i3 + i6] == f798G[i7]) {
                    i5 += 10;
                }
            }
        }
        return i5;
    }

    private int S(int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < i4) {
            int[] iArr = this.f415n;
            int i9 = i3 + i5;
            int i10 = iArr[i9];
            if (i10 < 48 || i10 > 57) {
                i7++;
            } else {
                i6++;
            }
            if (i5 != 0 && i10 == 10 && iArr[i9 - 1] == 13) {
                i7--;
            }
            if (i6 == 3) {
                i8 = i7 == 1 ? i8 + 20 : i8 + 10;
                if (i7 > 1) {
                    i8 += 100;
                }
                i6 = 0;
                i7 = 0;
            }
            i5++;
        }
        if (i6 > 0) {
            i8 = i7 == 1 ? i8 + 20 : i8 + 10;
        }
        if (i7 > 1) {
            i8 += 100;
        }
        int i11 = this.f415n[(i3 + i5) - 1];
        return (i11 < 48 || i11 > 57) ? i8 + 100 : i8;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0138  */
    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    private a[] T(int i3) {
        int i4;
        int i5;
        a aVar;
        a[] aVarArr = new a[i3];
        for (int i6 = 0; i6 < i3; i6++) {
            aVarArr[i6] = a.NULL;
            if (this.f415n[i6] > 255) {
                aVarArr[i6] = a.GM_CHINESE;
            }
        }
        if (i3 > 3) {
            int i7 = 1;
            do {
                int[] iArr = this.f415n;
                if (iArr[i7] == 13) {
                    int i8 = i7 + 1;
                    if (iArr[i8] == 10) {
                        a aVar2 = aVarArr[i7 - 1];
                        a aVar3 = a.GM_CHINESE;
                        if (aVar2 == aVar3) {
                            aVarArr[i7] = aVar3;
                            aVarArr[i8] = aVar3;
                        }
                        i7 += 2;
                    } else {
                        i7++;
                    }
                } else {
                    i7++;
                }
            } while (i7 < i3 - 1);
            int i9 = i3 - 3;
            do {
                int[] iArr2 = this.f415n;
                if (iArr2[i9] == 13) {
                    int i10 = i9 + 1;
                    if (iArr2[i10] == 10) {
                        a aVar4 = aVarArr[i9 + 2];
                        a aVar5 = a.GM_CHINESE;
                        if (aVar4 == aVar5) {
                            aVarArr[i9] = aVar5;
                            aVarArr[i10] = aVar5;
                        }
                        i9 -= 2;
                    } else {
                        i9--;
                    }
                } else {
                    i9--;
                }
            } while (i9 > 0);
        }
        int i11 = 1;
        int i12 = 0;
        boolean z3 = false;
        int i13 = 0;
        while (true) {
            i4 = i3 - 1;
            if (i11 >= i4) {
                break;
            }
            int i14 = this.f415n[i11];
            if (i14 < 48 || i14 > 57) {
                if (z3) {
                    if (i12 % 2 == 0) {
                        a aVar6 = aVarArr[i13 - 1];
                        a aVar7 = a.GM_CHINESE;
                        if (aVar6 == aVar7 && aVarArr[i11] == aVar7) {
                            for (int i15 = 0; i15 < i12; i15++) {
                                aVarArr[(i11 - i15) - 1] = a.GM_CHINESE;
                            }
                        }
                    }
                    z3 = false;
                }
            } else if (z3) {
                i12++;
            } else {
                i13 = i11;
                i12 = 1;
                z3 = true;
            }
            i11++;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = this.f415n[i16];
            if (i17 >= 97 && i17 <= 122) {
                aVarArr[i16] = a.GM_LOWER;
            }
        }
        for (int i18 = 0; i18 < i3; i18++) {
            int i19 = this.f415n[i18];
            if (i19 >= 65 && i19 <= 90) {
                aVarArr[i18] = a.GM_UPPER;
            }
        }
        boolean z4 = false;
        int i20 = 0;
        int i21 = 0;
        for (int i22 = 1; i22 < i4; i22++) {
            if (this.f415n[i22] == 32) {
                if (z4) {
                    i21++;
                } else {
                    i20 = i22;
                    z4 = true;
                    i21 = 1;
                }
            } else if (z4) {
                a aVar8 = aVarArr[i20 - 1];
                a aVar9 = aVarArr[i22];
                a aVar10 = a.GM_LOWER;
                if (aVar8 == aVar10 || aVar8 == (aVar = a.GM_UPPER)) {
                    for (int i23 = 0; i23 < i21; i23++) {
                        aVarArr[(i22 - i23) - 1] = aVar8;
                    }
                } else if (aVar9 == aVar10 || aVar9 == aVar) {
                    for (int i24 = 0; i24 < i21; i24++) {
                        aVarArr[(i22 - i24) - 1] = aVar9;
                    }
                }
                z4 = false;
            }
        }
        for (int i25 = 0; i25 < i3; i25++) {
            if (aVarArr[i25] == a.NULL) {
                int[] iArr3 = this.f415n;
                int i26 = iArr3[i25];
                if (i26 >= 48 && i26 <= 57) {
                    aVarArr[i25] = a.GM_NUMBER;
                } else if (i26 != 13) {
                    if (i26 != 32) {
                        switch (i26) {
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                                aVarArr[i25] = a.GM_NUMBER;
                                break;
                        }
                    } else {
                        aVarArr[i25] = a.GM_NUMBER;
                    }
                } else if (i25 < i4) {
                    int i27 = i25 + 1;
                    if (iArr3[i27] == 10) {
                        a aVar11 = a.GM_NUMBER;
                        aVarArr[i25] = aVar11;
                        aVarArr[i27] = aVar11;
                    }
                }
            }
        }
        for (int i28 = 0; i28 < i3; i28++) {
            if (aVarArr[i28] == a.NULL) {
                aVarArr[i28] = a.GM_BYTE;
            }
        }
        int[] iArr4 = new int[i3];
        a[] aVarArr2 = new a[i3];
        int[] iArr5 = new int[i3];
        iArr4[0] = 1;
        aVarArr2[0] = aVarArr[0];
        iArr5[0] = 0;
        int i29 = 0;
        for (int i30 = 1; i30 < i3; i30++) {
            a aVar12 = aVarArr[i30];
            if (aVar12 == aVarArr[i30 - 1]) {
                iArr4[i29] = iArr4[i29] + 1;
            } else {
                i29++;
                iArr4[i29] = 1;
                aVarArr2[i29] = aVar12;
                iArr5[i29] = i30;
            }
        }
        if (i29 > 1) {
            for (int i31 = 1; i31 < i29; i31++) {
                if (iArr4[i31] <= 3 && aVarArr2[i31 - 1] != a.GM_CHINESE) {
                    boolean z5 = true;
                    for (int i32 = 0; i32 < iArr4[i31]; i32++) {
                        boolean z6 = false;
                        for (int i33 = 0; i33 < 63; i33++) {
                            if (this.f415n[iArr5[i31] + i32] == f798G[i33]) {
                                z6 = true;
                            }
                        }
                        if (!z6) {
                            z5 = false;
                        }
                    }
                    if (z5) {
                        aVarArr2[i31] = a.GM_CONTROL;
                    }
                }
            }
        }
        if (i29 >= 3) {
            int i34 = 0;
            while (i34 < i29 - 1) {
                int i35 = i34 + 1;
                int i36 = i34 + 2;
                int i37 = i34;
                int i38 = i29;
                a aVarV = V(i34 == 0 ? a.NULL : aVarArr2[i34 - 1], aVarArr2[i34], aVarArr2[i35], aVarArr2[i36], iArr4[i34], iArr4[i35], iArr4[i36], iArr5[i34], i36 == i29);
                aVarArr2[i37] = aVarV;
                if (aVarV == a.GM_CONTROL) {
                    aVarArr2[i37] = aVarArr2[i37 - 1];
                }
                i29 = i38;
                i34 = i35;
            }
            int i39 = i34;
            i5 = i29;
            aVarArr2[i39] = this.f810C;
            int i40 = i39 + 1;
            aVarArr2[i40] = this.f811D;
            a aVar13 = aVarArr2[i39];
            a aVar14 = a.GM_CONTROL;
            if (aVar13 == aVar14) {
                aVarArr2[i39] = aVarArr2[i39 - 1];
            }
            if (aVarArr2[i40] == aVar14) {
                aVarArr2[i40] = aVarArr2[i39];
            }
        } else {
            i5 = i29;
        }
        for (int i41 = 0; i41 < i5; i41++) {
            for (int i42 = 0; i42 < iArr4[i41]; i42++) {
                aVarArr[iArr5[i41] + i42] = aVarArr2[i41];
            }
        }
        return aVarArr;
    }

    /* JADX WARN: Code duplicated, block: B:244:0x0370  */
    /* JADX WARN: Code duplicated, block: B:245:0x0375  */
    /* JADX WARN: Code duplicated, block: B:248:0x037e  */
    /* JADX WARN: Code duplicated, block: B:250:0x0382  */
    /* JADX WARN: Code duplicated, block: B:251:0x038a  */
    /* JADX WARN: Code duplicated, block: B:349:0x0528  */
    /* JADX WARN: Code duplicated, block: B:358:0x053f  */
    private int U(int i3, boolean z3) {
        int[] iArr;
        a[] aVarArr;
        a aVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int iC;
        int i8;
        boolean z4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr2 = new int[3];
        a[] aVarArrT = T(i3);
        this.f814z = new StringBuilder();
        a aVar2 = a.NULL;
        u("Encoding: ");
        if (z3) {
            this.f814z.append("1010");
            u("INIT ");
        }
        int i14 = this.f414m;
        if (i14 != 3 && i14 != 29) {
            this.f814z.append("1100");
            int i15 = this.f414m;
            if (i15 >= 0 && i15 <= 1023) {
                this.f814z.append('0');
                for (int i16 = 512; i16 > 0; i16 >>= 1) {
                    if ((this.f414m & i16) != 0) {
                        this.f814z.append('1');
                    } else {
                        this.f814z.append('0');
                    }
                }
            }
            int i17 = this.f414m;
            if (i17 >= 1024 && i17 <= 32767) {
                this.f814z.append("10");
                for (int i18 = 16384; i18 > 0; i18 >>= 1) {
                    if ((this.f414m & i18) != 0) {
                        this.f814z.append('1');
                    } else {
                        this.f814z.append('0');
                    }
                }
            }
            int i19 = this.f414m;
            if (i19 >= 32768 && i19 <= 811799) {
                this.f814z.append("11");
                for (int i20 = 524288; i20 > 0; i20 >>= 1) {
                    if ((this.f414m & i20) != 0) {
                        this.f814z.append('1');
                    } else {
                        this.f814z.append('0');
                    }
                }
            }
            u("ECI ");
            y(this.f414m);
        }
        int i21 = 0;
        int i22 = 0;
        int length = 0;
        int i23 = 0;
        int length2 = 0;
        int i24 = 0;
        int i25 = 0;
        while (true) {
            a aVar3 = aVarArrT[i21];
            if (aVar3 != aVar2) {
                int iOrdinal = aVar2.ordinal();
                aVarArr = aVarArrT;
                iArr = iArr2;
                aVar = aVar2;
                if (iOrdinal != 0) {
                    i4 = i21;
                    if (iOrdinal == 1) {
                        if (i22 == 1) {
                            this.f814z.insert(length2, "10");
                        } else if (i22 == 2) {
                            this.f814z.insert(length2, "01");
                        } else if (i22 == 3) {
                            this.f814z.insert(length2, "00");
                        }
                        int iOrdinal2 = aVar3.ordinal();
                        if (iOrdinal2 == 2) {
                            this.f814z.append("1111111100");
                        } else if (iOrdinal2 == 3) {
                            this.f814z.append("1111111101");
                        } else if (iOrdinal2 == 4) {
                            this.f814z.append("1111111110");
                        } else if (iOrdinal2 == 6) {
                            this.f814z.append("1111111111");
                        } else if (iOrdinal2 == 7) {
                            this.f814z.append("1111111011");
                        }
                    } else if (iOrdinal == 2 || iOrdinal == 3) {
                        int iOrdinal3 = aVar3.ordinal();
                        if (iOrdinal3 == 1) {
                            this.f814z.append("11101");
                        } else if (iOrdinal3 == 2 || iOrdinal3 == 3) {
                            this.f814z.append("11110");
                        } else if (iOrdinal3 == 4) {
                            this.f814z.append("1111100");
                        } else if (iOrdinal3 == 6) {
                            this.f814z.append("1111110");
                        } else if (iOrdinal3 == 7) {
                            this.f814z.append("11100");
                        }
                    } else if (iOrdinal == 4) {
                        int iOrdinal4 = aVar3.ordinal();
                        if (iOrdinal4 == 1) {
                            this.f814z.append("1111110010");
                        } else if (iOrdinal4 == 2) {
                            this.f814z.append("1111110011");
                        } else if (iOrdinal4 == 3) {
                            this.f814z.append("1111110100");
                        } else if (iOrdinal4 == 6) {
                            this.f814z.append("1111110111");
                        } else if (iOrdinal4 == 7) {
                            this.f814z.append("1111110001");
                        }
                    } else if (iOrdinal == 6) {
                        L(length, i23);
                        int iOrdinal5 = aVar3.ordinal();
                        if (iOrdinal5 == 1) {
                            this.f814z.append("0010");
                        } else if (iOrdinal5 == 2) {
                            this.f814z.append("0011");
                        } else if (iOrdinal5 == 3) {
                            this.f814z.append("0100");
                        } else if (iOrdinal5 == 4) {
                            this.f814z.append("0101");
                        } else if (iOrdinal5 == 7) {
                            this.f814z.append("0001");
                        }
                        i23 = 0;
                    } else if (iOrdinal == 7) {
                        int iOrdinal6 = aVar3.ordinal();
                        if (iOrdinal6 == 1) {
                            this.f814z.append("1111111100001");
                        } else if (iOrdinal6 == 2) {
                            this.f814z.append("1111111100010");
                        } else if (iOrdinal6 == 3) {
                            this.f814z.append("1111111100011");
                        } else if (iOrdinal6 == 4) {
                            this.f814z.append("1111111100100");
                        } else if (iOrdinal6 == 6) {
                            this.f814z.append("1111111100101");
                        }
                    }
                } else {
                    i4 = i21;
                    int iOrdinal7 = aVar3.ordinal();
                    if (iOrdinal7 == 1) {
                        this.f814z.append("0010");
                    } else if (iOrdinal7 == 2) {
                        this.f814z.append("0011");
                    } else if (iOrdinal7 == 3) {
                        this.f814z.append("0100");
                    } else if (iOrdinal7 == 4) {
                        this.f814z.append("0101");
                    } else if (iOrdinal7 == 6) {
                        this.f814z.append("0111");
                    } else if (iOrdinal7 == 7) {
                        this.f814z.append("0001");
                    }
                }
                int iOrdinal8 = aVar3.ordinal();
                if (iOrdinal8 == 1) {
                    u("NUMB ");
                } else if (iOrdinal8 == 2) {
                    u("LOWR ");
                } else if (iOrdinal8 == 3) {
                    u("UPPR ");
                } else if (iOrdinal8 == 4) {
                    u("MIXD ");
                } else if (iOrdinal8 == 6) {
                    u("BYTE ");
                } else if (iOrdinal8 == 7) {
                    u("CHIN ");
                }
            } else {
                iArr = iArr2;
                aVarArr = aVarArrT;
                aVar = aVar2;
                i4 = i21;
            }
            int iOrdinal9 = aVar3.ordinal();
            int i26 = 32;
            if (iOrdinal9 == 1) {
                i5 = i3;
                i21 = i4;
                if (aVar != aVar3) {
                    length2 = this.f814z.length();
                }
                int i27 = 48;
                iArr[0] = 48;
                iArr[1] = 48;
                iArr[2] = 48;
                int i28 = 0;
                int i29 = -1;
                while (true) {
                    int[] iArr3 = this.f415n;
                    int i30 = iArr3[i21];
                    if (i30 >= i27 && i30 <= 57) {
                        iArr[i28] = i30;
                        i28++;
                    }
                    i6 = iArr3[i21];
                    if (i6 != i26) {
                        switch (i6) {
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                                i24 = i6;
                                i29 = i28;
                                break;
                        }
                    } else {
                        i24 = i6;
                        i29 = i28;
                    }
                    if (i21 >= i5 - 1 || i6 != 13) {
                        i6 = i24;
                    } else {
                        int i31 = i21 + 1;
                        if (iArr3[i31] == 10) {
                            i21 = i31;
                            i29 = i28;
                        } else {
                            i6 = i24;
                        }
                    }
                    i21++;
                    if (i28 < 3 && i21 < i5) {
                        i24 = i6;
                        i27 = 48;
                        i26 = 32;
                    }
                }
                if (i29 != -1) {
                    if (i6 == 19) {
                        i25 = 15;
                    } else if (i6 != 32) {
                        switch (i6) {
                            case 43:
                                i25 = 3;
                                break;
                            case 44:
                                i25 = 12;
                                break;
                            case 45:
                                i25 = 6;
                                break;
                            case 46:
                                i25 = 9;
                                break;
                        }
                    } else {
                        i25 = 0;
                    }
                    int i32 = i25 + i29 + 1000;
                    y(i32);
                    for (int i33 = 512; i33 > 0; i33 >>= 1) {
                        if ((i32 & i33) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                    }
                }
                int i34 = ((iArr[0] - 48) * 100) + ((iArr[1] - 48) * 10) + (iArr[2] - 48);
                y(i34);
                for (int i35 = 512; i35 > 0; i35 >>= 1) {
                    if ((i34 & i35) != 0) {
                        this.f814z.append('1');
                    } else {
                        this.f814z.append('0');
                    }
                }
                i25 = i34;
                i24 = i6;
                i22 = i28;
            } else if (iOrdinal9 == 2) {
                i5 = i3;
                i7 = i4;
                int i36 = this.f415n[i7];
                boolean z5 = i36 < 97 || i36 > 122;
                if (i36 == 32) {
                    z5 = false;
                }
                if (z5) {
                    this.f814z.append("1111101");
                    O(this.f415n[i7]);
                } else {
                    iC = G2.a.c((char) i36, f807P) - 36;
                    y(iC);
                    for (int i37 = 16; i37 > 0; i37 >>= 1) {
                        if ((iC & i37) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                    }
                    i25 = iC;
                }
                i21 = i7 + 1;
            } else if (iOrdinal9 == 3) {
                i5 = i3;
                i7 = i4;
                int i38 = this.f415n[i7];
                boolean z6 = i38 < 65 || i38 > 90;
                if (i38 == 32) {
                    z6 = false;
                }
                if (z6) {
                    this.f814z.append("1111101");
                    O(this.f415n[i7]);
                } else {
                    iC = G2.a.c((char) i38, f807P) - 10;
                    if (iC == 52) {
                        iC = 26;
                    }
                    y(iC);
                    for (int i39 = 16; i39 > 0; i39 >>= 1) {
                        if ((iC & i39) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                    }
                    i25 = iC;
                }
                i21 = i7 + 1;
            } else if (iOrdinal9 != 4) {
                if (iOrdinal9 == 6) {
                    i5 = i3;
                    int i40 = i4;
                    if (aVar != aVar3) {
                        length = this.f814z.length();
                    }
                    if (i23 == 512) {
                        L(length, i23);
                        this.f814z.append("0111");
                        length = this.f814z.length();
                        i23 = 0;
                    }
                    i8 = this.f415n[i40];
                    y(i8);
                    for (int i41 = 128; i41 > 0; i41 >>= 1) {
                        if ((i8 & i41) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                    }
                    i21 = i40 + 1;
                    i23++;
                } else if (iOrdinal9 != 7) {
                    i5 = i3;
                    i21 = i4;
                } else {
                    int[] iArr4 = this.f415n;
                    int i42 = iArr4[i4];
                    if (i42 > 255) {
                        int i43 = (65280 & i42) >> 8;
                        int i44 = i42 & 255;
                        if (i43 >= 160 && i43 <= 169) {
                            i25 = ((i43 - 161) * 96) + (i44 - 160);
                        }
                        if (i43 >= 176 && i43 <= 247) {
                            i25 = ((i43 - 167) * 96) + (i44 - 160);
                        }
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        i5 = i3;
                        i9 = i4;
                    } else {
                        i5 = i3;
                        i9 = i4;
                        if (i9 != i5 - 1) {
                            if (i42 == 13) {
                                int i45 = i9 + 1;
                                if (iArr4[i45] == 10) {
                                    i25 = 7776;
                                    i9 = i45;
                                }
                            }
                            z4 = true;
                        }
                    }
                    if (z4 || i9 == i5 - 1 || (i13 = iArr4[i9]) < 48 || i13 > 57) {
                        i10 = i9;
                    } else {
                        int i46 = i9 + 1;
                        i10 = i9;
                        int i47 = iArr4[i46];
                        if (i47 >= 48 && i47 <= 57) {
                            i25 = ((i13 - 48) * 10) + 8033 + (i47 - 48);
                            i11 = i46;
                        }
                        if (z4) {
                            i8 = i25;
                        } else {
                            i8 = iArr4[i11] + 7777;
                        }
                        y(i8);
                        for (i12 = 4096; i12 > 0; i12 >>= 1) {
                            if ((i8 & i12) != 0) {
                                this.f814z.append('1');
                            } else {
                                this.f814z.append('0');
                            }
                        }
                        i21 = i11 + 1;
                    }
                    i11 = i10;
                    if (z4) {
                        i8 = iArr4[i11] + 7777;
                    } else {
                        i8 = i25;
                    }
                    y(i8);
                    while (i12 > 0) {
                        if ((i8 & i12) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                    }
                    i21 = i11 + 1;
                }
                i25 = i8;
            } else {
                i5 = i3;
                i7 = i4;
                int i48 = this.f415n[i7];
                boolean z7 = i48 < 48 || i48 > 57;
                if (i48 >= 65 && i48 <= 90) {
                    z7 = false;
                }
                if (i48 >= 97 && i48 <= 122) {
                    z7 = false;
                }
                if (i48 == 32) {
                    z7 = false;
                }
                if (z7) {
                    this.f814z.append("1111110110");
                    O(this.f415n[i7]);
                } else {
                    iC = G2.a.c((char) i48, f807P);
                    y(iC);
                    while (i26 > 0) {
                        if ((iC & i26) != 0) {
                            this.f814z.append('1');
                        } else {
                            this.f814z.append('0');
                        }
                        i26 >>= 1;
                    }
                    i25 = iC;
                }
                i21 = i7 + 1;
            }
            if (this.f814z.length() > 9191) {
                return 1;
            }
            if (i21 >= i5) {
                v();
                if (aVar3 == a.GM_NUMBER) {
                    if (i22 == 1) {
                        this.f814z.insert(length2, "10");
                    } else if (i22 == 2) {
                        this.f814z.insert(length2, "01");
                    } else if (i22 == 3) {
                        this.f814z.insert(length2, "00");
                    }
                }
                if (aVar3 == a.GM_BYTE) {
                    L(length, i23);
                }
                int iOrdinal10 = aVar3.ordinal();
                if (iOrdinal10 == 1) {
                    this.f814z.append("1111111010");
                } else if (iOrdinal10 == 2 || iOrdinal10 == 3) {
                    this.f814z.append("11011");
                } else if (iOrdinal10 == 4) {
                    this.f814z.append("1111110000");
                } else if (iOrdinal10 == 6) {
                    this.f814z.append("0000");
                } else if (iOrdinal10 == 7) {
                    this.f814z.append("1111111100000");
                }
                int length3 = 7 - (this.f814z.length() % 7);
                if (length3 == 7) {
                    length3 = 0;
                }
                for (int i49 = 0; i49 < length3; i49++) {
                    this.f814z.append('0');
                }
                return this.f814z.length() > 9191 ? 1 : 0;
            }
            aVar2 = aVar3;
            aVarArrT = aVarArr;
            iArr2 = iArr;
        }
    }

    private a V(a aVar, a aVar2, a aVar3, a aVar4, int i3, int i4, int i5, int i6, boolean z3) {
        int i7;
        int i8;
        int i9 = Integer.MAX_VALUE;
        a aVar5 = aVar2;
        int i10 = 1;
        while (true) {
            int i11 = 8;
            if (i10 >= 8) {
                return aVar5;
            }
            if (Z(aVar2, Y(i10))) {
                int i12 = 1;
                while (i12 < i11) {
                    if (Z(aVar3, Y(i12))) {
                        int i13 = i9;
                        a aVar6 = aVar5;
                        int i14 = 1;
                        while (i14 < i11) {
                            if (Z(aVar4, Y(i14))) {
                                i7 = i14;
                                i8 = i13;
                                int iW = W(aVar, Y(i10), Y(i12), Y(i14), i3, i4, i5, i6, z3);
                                if (iW <= i8) {
                                    a aVarY = Y(i10);
                                    this.f810C = Y(i12);
                                    this.f811D = Y(i7);
                                    i13 = iW;
                                    aVar6 = aVarY;
                                }
                                i14 = i7 + 1;
                                i11 = 8;
                            } else {
                                i7 = i14;
                                i8 = i13;
                            }
                            i13 = i8;
                            i14 = i7 + 1;
                            i11 = 8;
                        }
                        i9 = i13;
                        aVar5 = aVar6;
                    }
                    i12++;
                    i11 = 8;
                }
            }
            i10++;
        }
    }

    private int W(a aVar, a aVar2, a aVar3, a aVar4, int i3, int i4, int i5, int i6, boolean z3) {
        int iX = X(aVar, aVar2, i3, i6);
        int i7 = i6 + i3;
        int iX2 = iX + X(aVar2, aVar3, i4, i7) + X(aVar3, aVar4, i5, i7 + i4);
        if (!z3) {
            return iX2;
        }
        int iOrdinal = aVar4.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                return iX2 + 5;
            }
            if (iOrdinal != 4) {
                if (iOrdinal != 6) {
                    return iOrdinal != 7 ? iX2 : iX2 + 13;
                }
                return iX2 + 4;
            }
        }
        return iX2 + 10;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:34:0x0059  */
    /* JADX WARN: Code duplicated, block: B:43:0x006d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0070  */
    private int X(a aVar, a aVar2, int i3, int i4) {
        int iS;
        int iOrdinal = aVar2.ordinal();
        if (iOrdinal == 1) {
            iS = S(i4, i3);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            iS = i3 * 5;
        } else if (iOrdinal == 4) {
            iS = R(i4, i3);
        } else if (iOrdinal != 5) {
            iS = iOrdinal != 7 ? P(i4, i3) : Q(i4, i3);
        } else {
            iS = i3 * 6;
        }
        int iOrdinal2 = aVar.ordinal();
        if (iOrdinal2 == 0) {
            iS += 4;
        } else if (iOrdinal2 != 1) {
            if (iOrdinal2 == 2) {
                int iOrdinal3 = aVar2.ordinal();
                if (iOrdinal3 == 1 || iOrdinal3 == 3) {
                    iS += 5;
                } else if (iOrdinal3 == 4 || iOrdinal3 == 5 || iOrdinal3 == 6) {
                    iS += 7;
                } else if (iOrdinal3 == 7) {
                    iS += 5;
                }
            } else if (iOrdinal2 == 3) {
                int iOrdinal4 = aVar2.ordinal();
                if (iOrdinal4 == 1 || iOrdinal4 == 2) {
                    iS += 5;
                } else if (iOrdinal4 == 4 || iOrdinal4 == 5 || iOrdinal4 == 6) {
                    iS += 7;
                } else if (iOrdinal4 == 7) {
                    iS += 5;
                }
            } else if (iOrdinal2 != 4) {
                if (iOrdinal2 != 6) {
                    if (iOrdinal2 == 7 && aVar2 != a.GM_CHINESE && aVar2 != a.GM_CONTROL) {
                        iS += 13;
                    }
                } else if (aVar2 != a.GM_BYTE) {
                    iS += 4;
                }
            } else if (aVar2 != a.GM_MIXED) {
                iS += 10;
            }
        } else if (aVar2 != a.GM_CHINESE && aVar2 != a.GM_CONTROL) {
            iS += 10;
        }
        a aVar3 = a.GM_BYTE;
        if (aVar != aVar3 && aVar2 == aVar3) {
            iS += 9;
        }
        a aVar4 = a.GM_NUMBER;
        return (aVar == aVar4 || aVar2 != aVar4) ? iS : iS + 2;
    }

    private a Y(int i3) {
        switch (i3) {
            case 1:
                return a.GM_CHINESE;
            case 2:
                return a.GM_BYTE;
            case 3:
                return a.GM_CONTROL;
            case 4:
                return a.GM_MIXED;
            case 5:
                return a.GM_UPPER;
            case 6:
                return a.GM_LOWER;
            case 7:
                return a.GM_NUMBER;
            default:
                return a.NULL;
        }
    }

    private boolean Z(a aVar, a aVar2) {
        int iOrdinal;
        int iOrdinal2 = aVar.ordinal();
        if (iOrdinal2 == 1) {
            int iOrdinal3 = aVar2.ordinal();
            if (iOrdinal3 == 1 || iOrdinal3 == 4 || iOrdinal3 == 6 || iOrdinal3 == 7) {
                return true;
            }
        } else if (iOrdinal2 == 2) {
            int iOrdinal4 = aVar2.ordinal();
            if (iOrdinal4 == 2 || iOrdinal4 == 4 || iOrdinal4 == 6 || iOrdinal4 == 7) {
                return true;
            }
        } else if (iOrdinal2 == 3) {
            int iOrdinal5 = aVar2.ordinal();
            if (iOrdinal5 == 3 || iOrdinal5 == 4 || iOrdinal5 == 6 || iOrdinal5 == 7) {
                return true;
            }
        } else if (iOrdinal2 == 5) {
            int iOrdinal6 = aVar2.ordinal();
            if (iOrdinal6 == 5 || iOrdinal6 == 6 || iOrdinal6 == 7) {
                return true;
            }
        } else if (iOrdinal2 == 6) {
            int iOrdinal7 = aVar2.ordinal();
            if (iOrdinal7 == 6 || iOrdinal7 == 7) {
                return true;
            }
        } else if (iOrdinal2 == 7 && ((iOrdinal = aVar2.ordinal()) == 6 || iOrdinal == 7)) {
            return true;
        }
        return false;
    }

    private void a0(int i3, int i4) {
        int i5 = 13 - ((i3 - 1) / 2);
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = f806O[((i6 + i5) * 27) + i7 + i5];
                int[] iArr = this.f808A;
                int i9 = i8 * 2;
                b0(i7, i6, iArr[i9], iArr[i9 + 1], i4);
            }
        }
    }

    void O(int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < 64; i5++) {
            if (f798G[i5] == i3) {
                i4 = i5;
            }
        }
        u("SHT/");
        y(i4);
        for (int i6 = 32; i6 > 0; i6 >>= 1) {
            if ((i4 & i6) != 0) {
                this.f814z.append('1');
            } else {
                this.f814z.append('0');
            }
        }
    }

    void b0(int i3, int i4, int i5, int i6, int i7) {
        int i8 = (i3 * 6) + 1;
        int i9 = i4 * 6;
        int i10 = i9 + 1;
        if ((i6 & 64) != 0) {
            this.f809B[(i10 * i7) + i8 + 2] = true;
        }
        if ((i6 & 32) != 0) {
            this.f809B[(i10 * i7) + i8 + 3] = true;
        }
        if ((i6 & 16) != 0) {
            this.f809B[((i9 + 2) * i7) + i8] = true;
        }
        if ((i6 & 8) != 0) {
            this.f809B[((i9 + 2) * i7) + i8 + 1] = true;
        }
        if ((i6 & 4) != 0) {
            this.f809B[((i9 + 2) * i7) + i8 + 2] = true;
        }
        if ((i6 & 2) != 0) {
            this.f809B[((i9 + 2) * i7) + i8 + 3] = true;
        }
        if ((i6 & 1) != 0) {
            this.f809B[((i9 + 3) * i7) + i8] = true;
        }
        if ((i5 & 64) != 0) {
            this.f809B[((i9 + 3) * i7) + i8 + 1] = true;
        }
        if ((i5 & 32) != 0) {
            this.f809B[((i9 + 3) * i7) + i8 + 2] = true;
        }
        if ((i5 & 16) != 0) {
            this.f809B[((i9 + 3) * i7) + i8 + 3] = true;
        }
        if ((i5 & 8) != 0) {
            this.f809B[((i9 + 4) * i7) + i8] = true;
        }
        if ((i5 & 4) != 0) {
            this.f809B[((i9 + 4) * i7) + i8 + 1] = true;
        }
        if ((i5 & 2) != 0) {
            this.f809B[((i9 + 4) * i7) + i8 + 2] = true;
        }
        if ((i5 & 1) != 0) {
            this.f809B[((i9 + 4) * i7) + i8 + 3] = true;
        }
    }

    @Override // E2.Q
    protected void c() {
        int length;
        boolean z3;
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 1460; i5++) {
            this.f808A[i5] = 0;
        }
        try {
            Charset charsetForName = Charset.forName("GB2312");
            if (charsetForName.newEncoder().canEncode(this.f413l)) {
                byte[] bytes = this.f413l.getBytes(charsetForName);
                this.f415n = new int[bytes.length];
                int i6 = 0;
                length = 0;
                while (i6 < bytes.length) {
                    byte b3 = bytes[i6];
                    if ((b3 & 255) < 161 || (b3 & 255) > 247) {
                        this.f415n[length] = b3 & 255;
                    } else {
                        i6++;
                        this.f415n[length] = ((b3 & 255) * 256) + (bytes[i6] & 255);
                    }
                    length++;
                    i6++;
                }
                w("Using GB2312 character encoding");
                this.f414m = 29;
            } else {
                b();
                length = this.f415n.length;
            }
            if (U(length, this.f404c) != 0) {
                throw new H("Input data too long");
            }
            int length2 = this.f814z.length() / 7;
            int iMax = 1;
            for (int i7 = 0; i7 < 13; i7++) {
                if (f799H[i7] < length2) {
                    iMax = i7 + 1;
                }
            }
            int i8 = 13;
            for (int i9 = 12; i9 > 0; i9--) {
                if (f800I[i9 - 1] >= length2) {
                    i8 = i9;
                }
            }
            int iMax2 = iMax == 1 ? 5 : 3;
            if (iMax == 2 || iMax == 3) {
                iMax2 = 4;
            }
            int i10 = iMax == 1 ? 4 : 1;
            if (iMax == 2 || iMax == 3) {
                i10 = 2;
            }
            int i11 = this.f812E;
            if (i11 < 1 || i11 > 13) {
                z3 = false;
            } else {
                iMax = Math.max(i11, i8);
                z3 = true;
            }
            if (z3) {
                iMax2 = iMax == 1 ? 5 : 3;
                if (iMax == 2 || iMax == 3) {
                    iMax2 = 4;
                }
                if (length2 > f801J[((iMax - 1) * 5) + (iMax2 - 1)]) {
                    iMax++;
                }
            }
            if (!z3) {
                int i12 = this.f813F;
                if (i12 >= 1 && i12 <= 5) {
                    iMax2 = Math.max(i12, i10);
                }
                int i13 = iMax2 - 1;
                if (length2 > f801J[((iMax - 1) * 5) + i13]) {
                    while (true) {
                        i4 = iMax + 1;
                        if (length2 <= f801J[(iMax * 5) + i13] || i4 > 13) {
                            break;
                        } else {
                            iMax = i4;
                        }
                    }
                    iMax = i4;
                }
            }
            if (iMax2 == 2) {
                i3 = 1167;
            } else if (iMax2 == 3) {
                i3 = 1021;
            } else if (iMax2 != 4) {
                i3 = iMax2 != 5 ? 1313 : 729;
            } else {
                i3 = 875;
            }
            if (length2 > i3) {
                throw new H("Input data too long");
            }
            M(length2, iMax, iMax2);
            int i14 = (iMax * 12) + 6;
            int i15 = (iMax * 2) + 1;
            w("Layers: " + iMax);
            w("ECC Level: " + iMax2);
            w("Data Codewords: " + length2);
            w("ECC Codewords: " + f801J[((iMax + (-1)) * 5) + iMax2 + (-1)]);
            w("Grid Size: " + i15 + " X " + i15);
            this.f809B = new boolean[i14 * i14];
            for (int i16 = 0; i16 < i14; i16++) {
                for (int i17 = 0; i17 < i14; i17++) {
                    this.f809B[(i17 * i14) + i16] = false;
                }
            }
            a0(i15, i14);
            N(i14, iMax, i15, iMax2);
            for (int i18 = 0; i18 < i15; i18++) {
                int i19 = 1 - (i18 & 1);
                for (int i20 = 0; i20 < i15; i20++) {
                    if (i19 == 1) {
                        for (int i21 = 0; i21 < 5; i21++) {
                            boolean[] zArr = this.f809B;
                            int i22 = i20 * 6;
                            int i23 = i18 * 6;
                            zArr[(i22 * i14) + i23 + i21] = true;
                            zArr[((i22 + 5) * i14) + i23 + i21] = true;
                            int i24 = ((i22 + i21) * i14) + i23;
                            zArr[i24] = true;
                            zArr[i24 + 5] = true;
                        }
                        this.f809B[(((i20 * 6) + 5) * i14) + (i18 * 6) + 5] = true;
                        i19 = 0;
                    } else {
                        i19 = 1;
                    }
                }
            }
            this.f421t = i14;
            this.f418q = i14;
            this.f419r = new int[i14];
            this.f417p = new String[i14];
            for (int i25 = 0; i25 < i14; i25++) {
                sb.setLength(0);
                for (int i26 = 0; i26 < i14; i26++) {
                    if (this.f809B[(i25 * i14) + i26]) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                this.f419r[i25] = 1;
                this.f417p[i25] = Q.a(sb);
            }
        } catch (UnsupportedCharsetException unused) {
            throw new H("Byte conversion encoding error");
        }
    }
}
