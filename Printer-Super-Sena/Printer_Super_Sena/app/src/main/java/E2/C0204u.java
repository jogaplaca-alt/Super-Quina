package E2;

/* JADX INFO: renamed from: E2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0204u extends Q {

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final int[] f749T;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final int f756a0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f757A;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f761E;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private int f765I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private b f766J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private int[] f767K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private int f768L;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private int f770N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f744O = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final int[] f745P = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 22, 23, 24, 25, 26, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final int[] f746Q = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3};

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final int[] f747R = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 22, 23, 24, 25, 26, 0, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 27, 28, 29, 30, 31};

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final int[] f748S = {0, 1, 3, 5, 7, 8, 10, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 2, 4, 6, 9, 11, 14};

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private static final int[] f750U = {10, 12, 18, 14, 32, 16, 26, 18, 20, 36, 22, 36, 24, 26, 48, 32, 36, 40, 44, 48, 52, 64, 72, 80, 88, 96, 104, 120, 132, 144};

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private static final int[] f751V = {10, 12, 8, 14, 8, 16, 12, 18, 20, 12, 22, 16, 24, 26, 16, 16, 18, 20, 22, 24, 26, 16, 18, 20, 22, 24, 26, 20, 22, 24};

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private static final int[] f752W = {10, 12, 18, 14, 16, 16, 26, 18, 20, 18, 22, 18, 24, 26, 24, 16, 18, 20, 22, 24, 26, 16, 18, 20, 22, 24, 26, 20, 22, 24};

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private static final int[] f753X = {3, 5, 5, 8, 10, 12, 16, 18, 22, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private static final int[] f754Y = {3, 5, 5, 8, 10, 12, 16, 18, 22, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 102, 140, 92, 114, 144, 174, 136, 175, 163, 156};

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private static final int[] f755Z = {5, 7, 7, 10, 11, 12, 14, 14, 18, 18, 20, 24, 24, 28, 28, 36, 42, 48, 56, 68, 42, 56, 36, 48, 56, 68, 56, 68, 62, 62};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f771z = a.NONE;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f758B = 1;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int f759C = 1;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private int f760D = 1;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f762F = -1;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private final int[] f763G = new int[2200];

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private final int[] f764H = new int[2200];

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private final int[] f769M = new int[8];

    /* JADX INFO: renamed from: E2.u$a */
    public enum a {
        NONE,
        SQUARE,
        RECTANGULAR
    }

    /* JADX INFO: renamed from: E2.u$b */
    private enum b {
        NULL,
        DM_ASCII,
        DM_C40,
        DM_TEXT,
        DM_X12,
        DM_EDIFACT,
        DM_BASE256
    }

    static {
        int[] iArr = {10, 12, 8, 14, 8, 16, 12, 18, 20, 12, 22, 16, 24, 26, 16, 32, 36, 40, 44, 48, 52, 64, 72, 80, 88, 96, 104, 120, 132, 144};
        f749T = iArr;
        f756a0 = iArr.length;
    }

    private void L(int i3, int i4) {
        for (int i5 = i4; i5 > 0; i5--) {
            if (i5 == i4) {
                this.f763G[i3] = 129;
                i3++;
            } else {
                int i6 = i3 + 1;
                int i7 = (i6 * 149) % 253;
                int i8 = i7 + 130;
                if (i8 <= 254) {
                    this.f763G[i3] = i8;
                } else {
                    this.f763G[i3] = i7 - 124;
                }
                i3 = i6;
            }
        }
    }

    private void M(int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = (i3 + 2) / i4;
        O o3 = new O();
        o3.d(301);
        o3.c(i5, 1);
        for (int i9 = 0; i9 < i8; i9++) {
            int[] iArr = new int[256];
            int[] iArr2 = new int[256];
            int i10 = i9;
            int i11 = 0;
            while (i10 < i3) {
                iArr[i11] = this.f763G[i10];
                i10 += i8;
                i11++;
            }
            o3.a(i11, iArr);
            for (int i12 = 0; i12 < i5; i12++) {
                iArr2[i12] = o3.b(i12);
            }
            int i13 = i5 - 1;
            for (int i14 = i9; i14 < i5 * i8; i14 += i8) {
                if (i6 == 1) {
                    if (i9 < 8) {
                        i7 = i13 - 1;
                        this.f763G[i3 + i14 + 2] = iArr2[i13];
                    } else {
                        this.f763G[(i3 + i14) - 8] = iArr2[i13];
                        i13--;
                    }
                } else {
                    i7 = i13 - 1;
                    this.f763G[i3 + i14] = iArr2[i13];
                }
                i13 = i7;
            }
        }
    }

    private int N(int i3, int i4) {
        int length = this.f415n.length;
        int iOrdinal = this.f766J.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            int i5 = this.f768L;
            if (i5 == 1) {
                if (i3 > 1) {
                    this.f763G[i4] = 254;
                    i4++;
                    u("ASC ");
                }
                int[] iArr = this.f763G;
                int i6 = this.f415n[length - 1];
                iArr[i4] = i6 + 1;
                y(i6);
                i4++;
            } else if (i5 == 2) {
                int[] iArr2 = this.f769M;
                int i7 = (iArr2[0] * 1600) + (iArr2[1] * 40) + 1;
                int[] iArr3 = this.f763G;
                iArr3[i4] = i7 / 256;
                iArr3[i4 + 1] = i7 % 256;
                int i8 = i4 + 2;
                u("(" + this.f769M[0] + " " + this.f769M[1] + " 0) ");
                if (i3 > 2) {
                    this.f763G[i8] = 254;
                    i4 += 3;
                    u("ASC ");
                } else {
                    i4 = i8;
                }
            } else if (i3 > 0) {
                this.f763G[i4] = 254;
                i4++;
                u("ASC ");
            }
        } else if (iOrdinal == 4) {
            if (i3 == 1 && this.f768L == 1) {
                int[] iArr4 = this.f763G;
                int i9 = this.f415n[length - 1];
                iArr4[i4] = i9 + 1;
                y(i9);
            } else {
                if (i3 > 0) {
                    this.f763G[i4] = 254;
                    i4++;
                    u("ASC ");
                }
                int i10 = this.f768L;
                if (i10 == 1) {
                    int[] iArr5 = this.f763G;
                    int i11 = this.f415n[length - 1];
                    iArr5[i4] = i11 + 1;
                    y(i11);
                } else if (i10 == 2) {
                    int[] iArr6 = this.f763G;
                    int i12 = this.f415n[length - 2];
                    iArr6[i4] = i12 + 1;
                    y(i12);
                    int[] iArr7 = this.f763G;
                    int i13 = this.f415n[length - 1];
                    iArr7[i4 + 1] = i13 + 1;
                    y(i13);
                    i4 += 2;
                }
            }
            i4++;
        } else if (iOrdinal == 5) {
            if (i3 <= 2) {
                if (this.f768L == 1) {
                    int[] iArr8 = this.f763G;
                    int i14 = this.f415n[length - 1];
                    iArr8[i4] = i14 + 1;
                    y(i14);
                    i4++;
                }
                if (this.f768L == 2) {
                    int[] iArr9 = this.f763G;
                    int i15 = this.f415n[length - 2];
                    iArr9[i4] = i15 + 1;
                    y(i15);
                    int[] iArr10 = this.f763G;
                    int i16 = this.f415n[length - 1];
                    iArr10[i4 + 1] = i16 + 1;
                    y(i16);
                    i4 += 2;
                }
            } else {
                int i17 = this.f768L;
                if (i17 == 0) {
                    this.f763G[i4] = 124;
                    i4++;
                    u("(31 0 0 0) ");
                } else if (i17 == 1) {
                    int[] iArr11 = this.f763G;
                    iArr11[i4] = (this.f769M[0] << 2) + 1;
                    iArr11[i4 + 1] = 240;
                    i4 += 2;
                    u("(" + this.f769M[0] + " 31 0 0) ");
                } else if (i17 == 2) {
                    int[] iArr12 = this.f763G;
                    int[] iArr13 = this.f769M;
                    iArr12[i4] = (iArr13[0] << 2) + ((iArr13[1] & 48) >> 4);
                    iArr12[i4 + 1] = ((iArr13[1] & 15) << 4) + 7;
                    iArr12[i4 + 2] = 192;
                    i4 += 3;
                    u("(" + this.f769M[0] + " " + this.f769M[1] + " 31 0) ");
                } else if (i17 == 3) {
                    int[] iArr14 = this.f763G;
                    int[] iArr15 = this.f769M;
                    iArr14[i4] = (iArr15[0] << 2) + ((iArr15[1] & 48) >> 4);
                    iArr14[i4 + 1] = ((iArr15[1] & 15) << 4) + ((iArr15[2] & 60) >> 2);
                    iArr14[i4 + 2] = ((iArr15[2] & 3) << 6) + 31;
                    i4 += 3;
                    u("(" + this.f769M[0] + " " + this.f769M[1] + " " + this.f769M[2] + " 31) ");
                }
            }
        }
        v();
        u("Codewords: ");
        for (int i18 = 0; i18 < i4; i18++) {
            y(this.f763G[i18]);
        }
        v();
        return i4;
    }

    /* JADX WARN: Code duplicated, block: B:215:0x0695  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:215:0x0695 -> B:199:0x0667). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    private int O() {
        /*
            Method dump skipped, instruction units count: 2072
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E2.C0204u.O():int");
    }

    private void P(int i3, char c3) {
        int i4 = this.f765I;
        if (i4 - i3 >= 0) {
            int[] iArr = this.f764H;
            System.arraycopy(iArr, i3, iArr, i3 + 1, i4 - i3);
        }
        this.f764H[i3] = c3;
        this.f765I++;
    }

    private void Q(int i3, int i4, char c3) {
        while (i4 > i3) {
            int[] iArr = this.f763G;
            iArr[i4] = iArr[i4 - 1];
            i4--;
        }
        this.f763G[i3] = c3;
    }

    private boolean R(int i3) {
        int i4 = i3 + 1;
        int[] iArr = this.f415n;
        return i4 < iArr.length && Character.isDigit((char) iArr[i3]) && Character.isDigit((char) this.f415n[i4]);
    }

    private boolean S(int i3) {
        if (i3 == 13 || i3 == 42 || i3 == 62 || i3 == 32) {
            return true;
        }
        if (i3 < 48 || i3 > 57) {
            return i3 >= 65 && i3 <= 90;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162  */
    /* JADX WARN: Code duplicated, block: B:109:0x017a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0180  */
    /* JADX WARN: Code duplicated, block: B:116:0x018c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0191  */
    /* JADX WARN: Code duplicated, block: B:121:0x019a  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:154:0x0216  */
    /* JADX WARN: Code duplicated, block: B:164:0x0232  */
    /* JADX WARN: Code duplicated, block: B:167:0x0242  */
    /* JADX WARN: Code duplicated, block: B:179:0x0262 A[LOOP:0: B:22:0x004a->B:179:0x0262, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:180:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0145  */
    /* JADX WARN: Code duplicated, block: B:95:0x0149  */
    /* JADX WARN: Code duplicated, block: B:96:0x014e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0155  */
    private b T(int i3, b bVar) {
        double d3;
        double d4;
        double dCeil;
        double dCeil2;
        double dCeil3;
        double dCeil4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        int length = this.f415n.length;
        b bVar2 = b.NULL;
        double d16 = 2.0d;
        double dCeil5 = 0.0d;
        if (bVar == b.DM_ASCII) {
            d3 = 1.25d;
            dCeil4 = 0.0d;
            d4 = 1.0d;
            dCeil = 1.0d;
            dCeil2 = 1.0d;
            dCeil3 = 1.0d;
        } else {
            d3 = 2.25d;
            d4 = 2.0d;
            dCeil = 2.0d;
            dCeil2 = 2.0d;
            dCeil3 = 2.0d;
            dCeil4 = 1.0d;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                dCeil = 0.0d;
            } else if (iOrdinal == 4) {
                dCeil2 = 0.0d;
            } else if (iOrdinal == 5) {
                dCeil3 = 0.0d;
            } else if (iOrdinal == 6) {
                d3 = 0.0d;
            }
            dCeil5 = d4;
        }
        int i4 = i3;
        while (true) {
            if (i4 == length) {
                dCeil4 = Math.ceil(dCeil4);
                double dCeil6 = Math.ceil(d3);
                dCeil3 = Math.ceil(dCeil3);
                dCeil = Math.ceil(dCeil);
                dCeil2 = Math.ceil(dCeil2);
                dCeil5 = Math.ceil(dCeil5);
                bVar2 = b.DM_C40;
                if (dCeil2 < dCeil5 - 0.0416666679084301d) {
                    bVar2 = b.DM_X12;
                    d15 = dCeil2;
                } else {
                    d15 = dCeil5;
                }
                if (dCeil < d15 - 0.0416666679084301d) {
                    bVar2 = b.DM_TEXT;
                    d15 = dCeil;
                }
                if (dCeil3 < d15 - 0.0416666679084301d) {
                    bVar2 = b.DM_EDIFACT;
                    d15 = dCeil3;
                }
                if (dCeil6 < d15 - 0.0416666679084301d) {
                    bVar2 = b.DM_BASE256;
                    d15 = dCeil6;
                }
                if (dCeil4 <= d15 + 0.0416666679084301d) {
                    bVar2 = b.DM_ASCII;
                }
                d3 = dCeil6;
            } else {
                int i5 = this.f415n[i4];
                if (i5 < 48 || i5 > 57) {
                    dCeil4 = i5 > 127 ? Math.ceil(dCeil4) + d16 : Math.ceil(dCeil4) + 1.0d;
                } else {
                    dCeil4 += 0.5d;
                }
                int i6 = this.f415n[i4];
                if (i6 == 32 || ((i6 >= 48 && i6 <= 57) || (i6 >= 65 && i6 <= 90))) {
                    dCeil5 += 0.6666666666666666d;
                } else {
                    dCeil5 = i6 > 127 ? dCeil5 + 2.6666666666666665d : dCeil5 + 1.3333333333333333d;
                }
                if (i6 == 32 || ((i6 >= 48 && i6 <= 57) || (i6 >= 97 && i6 <= 122))) {
                    dCeil += 0.6666666666666666d;
                } else {
                    dCeil = i6 > 127 ? dCeil + 2.6666666666666665d : dCeil + 1.3333333333333333d;
                }
                if (S(i6)) {
                    dCeil2 += 0.6666666666666666d;
                } else {
                    dCeil2 += this.f415n[i4] > 127 ? 4.333333333333333d : 3.3333333333333335d;
                }
                int i7 = this.f415n[i4];
                if (i7 < 32 || i7 > 94) {
                    if (i7 > 127) {
                        d5 = 17.0d;
                    } else {
                        dCeil3 += 13.0d;
                    }
                    if (i7 == -1) {
                        dCeil3 += 13.0d;
                    }
                    if (i7 == -1) {
                        d3 += 4.0d;
                    } else {
                        d6 = 1.0d;
                        d3 += 1.0d;
                    }
                    if (i4 > i3 + 3) {
                        d7 = dCeil5 + d6;
                        d8 = dCeil4 - 0.0416666679084301d;
                        if (d7 < d8 && d7 < d3 - 0.0416666679084301d && d7 < dCeil3 - 0.0416666679084301d && d7 < dCeil - 0.0416666679084301d) {
                            d14 = dCeil2 - 0.0416666679084301d;
                            if (dCeil5 < d14) {
                                bVar2 = b.DM_C40;
                            }
                            if (dCeil5 >= d14 && dCeil5 <= dCeil2 + 0.0416666679084301d) {
                                if (U(i4, length)) {
                                    bVar2 = b.DM_X12;
                                } else {
                                    bVar2 = b.DM_C40;
                                }
                            }
                        }
                        d9 = dCeil2 + 1.0d;
                        if (d9 < d8 && d9 < d3 - 0.0416666679084301d && d9 < dCeil3 - 0.0416666679084301d && d9 < dCeil - 0.0416666679084301d && d9 < dCeil5 - 0.0416666679084301d) {
                            bVar2 = b.DM_X12;
                        }
                        d10 = dCeil + 1.0d;
                        if (d10 < d8 && d10 < d3 - 0.0416666679084301d && d10 < dCeil3 - 0.0416666679084301d && d10 < dCeil2 - 0.0416666679084301d && d10 < dCeil5 - 0.0416666679084301d) {
                            bVar2 = b.DM_TEXT;
                        }
                        d11 = dCeil3 + 1.0d;
                        if (d11 < d8 && d11 < d3 - 0.0416666679084301d && d11 < dCeil - 0.0416666679084301d && d11 < dCeil2 - 0.0416666679084301d && d11 < dCeil5 - 0.0416666679084301d) {
                            bVar2 = b.DM_EDIFACT;
                        }
                        d12 = d3 + 1.0d;
                        if (d12 > dCeil4 + 0.0416666679084301d || (d12 < dCeil3 - 0.0416666679084301d && d12 < dCeil - 0.0416666679084301d && d12 < dCeil2 - 0.0416666679084301d && d12 < dCeil5 - 0.0416666679084301d)) {
                            bVar2 = b.DM_BASE256;
                        }
                        d13 = dCeil4 + 1.0d;
                        if (d13 <= d3 + 0.0416666679084301d && d13 <= dCeil3 + 0.0416666679084301d && d13 <= dCeil + 0.0416666679084301d && d13 <= dCeil2 + 0.0416666679084301d && d13 <= 0.0416666679084301d + dCeil5) {
                            bVar2 = b.DM_ASCII;
                        }
                    }
                    i4++;
                    if (bVar2 != b.NULL) {
                        return bVar2;
                    }
                    d16 = 2.0d;
                } else {
                    d5 = 0.75d;
                }
                dCeil3 += d5;
                if (i7 == -1) {
                    dCeil3 += 13.0d;
                }
                if (i7 == -1) {
                    d3 += 4.0d;
                } else {
                    d6 = 1.0d;
                    d3 += 1.0d;
                }
                if (i4 > i3 + 3) {
                    d7 = dCeil5 + d6;
                    d8 = dCeil4 - 0.0416666679084301d;
                    if (d7 < d8) {
                        d14 = dCeil2 - 0.0416666679084301d;
                        if (dCeil5 < d14) {
                            bVar2 = b.DM_C40;
                        }
                        if (dCeil5 >= d14) {
                            if (U(i4, length)) {
                                bVar2 = b.DM_X12;
                            } else {
                                bVar2 = b.DM_C40;
                            }
                        }
                    }
                    d9 = dCeil2 + 1.0d;
                    if (d9 < d8) {
                        bVar2 = b.DM_X12;
                    }
                    d10 = dCeil + 1.0d;
                    if (d10 < d8) {
                        bVar2 = b.DM_TEXT;
                    }
                    d11 = dCeil3 + 1.0d;
                    if (d11 < d8) {
                        bVar2 = b.DM_EDIFACT;
                    }
                    d12 = d3 + 1.0d;
                    if (d12 > dCeil4 + 0.0416666679084301d) {
                        bVar2 = b.DM_BASE256;
                    } else {
                        bVar2 = b.DM_BASE256;
                    }
                    d13 = dCeil4 + 1.0d;
                    if (d13 <= d3 + 0.0416666679084301d) {
                        bVar2 = b.DM_ASCII;
                    }
                }
                i4++;
                if (bVar2 != b.NULL) {
                    return bVar2;
                }
                d16 = 2.0d;
            }
            d6 = 1.0d;
            if (i4 > i3 + 3) {
                d7 = dCeil5 + d6;
                d8 = dCeil4 - 0.0416666679084301d;
                if (d7 < d8) {
                    d14 = dCeil2 - 0.0416666679084301d;
                    if (dCeil5 < d14) {
                        bVar2 = b.DM_C40;
                    }
                    if (dCeil5 >= d14) {
                        if (U(i4, length)) {
                            bVar2 = b.DM_X12;
                        } else {
                            bVar2 = b.DM_C40;
                        }
                    }
                }
                d9 = dCeil2 + 1.0d;
                if (d9 < d8) {
                    bVar2 = b.DM_X12;
                }
                d10 = dCeil + 1.0d;
                if (d10 < d8) {
                    bVar2 = b.DM_TEXT;
                }
                d11 = dCeil3 + 1.0d;
                if (d11 < d8) {
                    bVar2 = b.DM_EDIFACT;
                }
                d12 = d3 + 1.0d;
                if (d12 > dCeil4 + 0.0416666679084301d) {
                    bVar2 = b.DM_BASE256;
                } else {
                    bVar2 = b.DM_BASE256;
                }
                d13 = dCeil4 + 1.0d;
                if (d13 <= d3 + 0.0416666679084301d) {
                    bVar2 = b.DM_ASCII;
                }
            }
            i4++;
            if (bVar2 != b.NULL) {
                return bVar2;
            }
            d16 = 2.0d;
        }
    }

    private boolean U(int i3, int i4) {
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (i3 < i4) {
            if (i6 == 0 && !S(this.f415n[i3])) {
                i6 = i3;
            }
            if (i7 == 0 && ((i5 = this.f415n[i3]) == 13 || i5 == 42 || i5 == 62)) {
                i7 = i3;
            }
            i3++;
        }
        return (i6 == 0 || i7 == 0 || i7 >= i6) ? false : true;
    }

    private void V(int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i5 < 0) {
            i5 += i3;
            i6 += 4 - ((i3 + 4) % 8);
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) % 8);
        }
        this.f767K[(i5 * i4) + i6] = (i7 << 3) + i8;
    }

    private void W(int i3, int i4, int i5, int i6, int i7) {
        int i8 = i5 - 2;
        int i9 = i6 - 2;
        V(i3, i4, i8, i9, i7, 7);
        int i10 = i6 - 1;
        V(i3, i4, i8, i10, i7, 6);
        int i11 = i5 - 1;
        V(i3, i4, i11, i9, i7, 5);
        V(i3, i4, i11, i10, i7, 4);
        V(i3, i4, i11, i6, i7, 3);
        V(i3, i4, i5, i9, i7, 2);
        V(i3, i4, i5, i10, i7, 1);
        V(i3, i4, i5, i6, i7, 0);
    }

    private void X(int i3, int i4, int i5) {
        int i6 = i3 - 1;
        V(i3, i4, i6, 0, i5, 7);
        V(i3, i4, i6, 1, i5, 6);
        V(i3, i4, i6, 2, i5, 5);
        V(i3, i4, 0, i4 - 2, i5, 4);
        int i7 = i4 - 1;
        V(i3, i4, 0, i7, i5, 3);
        V(i3, i4, 1, i7, i5, 2);
        V(i3, i4, 2, i7, i5, 1);
        V(i3, i4, 3, i7, i5, 0);
    }

    private void Y(int i3, int i4, int i5) {
        V(i3, i4, i3 - 3, 0, i5, 7);
        V(i3, i4, i3 - 2, 0, i5, 6);
        V(i3, i4, i3 - 1, 0, i5, 5);
        V(i3, i4, 0, i4 - 4, i5, 4);
        V(i3, i4, 0, i4 - 3, i5, 3);
        V(i3, i4, 0, i4 - 2, i5, 2);
        int i6 = i4 - 1;
        V(i3, i4, 0, i6, i5, 1);
        V(i3, i4, 1, i6, i5, 0);
    }

    private void Z(int i3, int i4, int i5) {
        V(i3, i4, i3 - 3, 0, i5, 7);
        V(i3, i4, i3 - 2, 0, i5, 6);
        V(i3, i4, i3 - 1, 0, i5, 5);
        V(i3, i4, 0, i4 - 2, i5, 4);
        int i6 = i4 - 1;
        V(i3, i4, 0, i6, i5, 3);
        V(i3, i4, 1, i6, i5, 2);
        V(i3, i4, 2, i6, i5, 1);
        V(i3, i4, 3, i6, i5, 0);
    }

    private void a0(int i3, int i4, int i5) {
        int i6 = i3 - 1;
        V(i3, i4, i6, 0, i5, 7);
        int i7 = i4 - 1;
        V(i3, i4, i6, i7, i5, 6);
        int i8 = i4 - 3;
        V(i3, i4, 0, i8, i5, 5);
        int i9 = i4 - 2;
        V(i3, i4, 0, i9, i5, 4);
        V(i3, i4, 0, i7, i5, 3);
        V(i3, i4, 1, i8, i5, 2);
        V(i3, i4, 1, i9, i5, 1);
        V(i3, i4, 1, i7, i5, 0);
    }

    private void b0(int i3, int i4) {
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                this.f767K[(i7 * i4) + i8] = 0;
            }
        }
        int i9 = 4;
        int i10 = 1;
        while (true) {
            if (i9 == i3 && i6 == 0) {
                X(i3, i4, i10);
                i10++;
            }
            int i11 = i3 - 2;
            if (i9 == i11 && i6 == 0 && i4 % 4 != 0) {
                Y(i3, i4, i10);
                i10++;
            }
            if (i9 == i11 && i6 == 0 && i4 % 8 == 4) {
                Z(i3, i4, i10);
                i10++;
            }
            if (i9 == i3 + 4 && i6 == 2 && i4 % 8 == 0) {
                a0(i3, i4, i10);
                i5 = i10 + 1;
            } else {
                i5 = i10;
            }
            while (true) {
                if (i9 < i3 && i6 >= 0 && this.f767K[(i9 * i4) + i6] == 0) {
                    W(i3, i4, i9, i6, i5);
                    i5++;
                }
                int i12 = i9 - 2;
                int i13 = i6 + 2;
                if (i12 < 0 || i13 >= i4) {
                    break;
                }
                i6 = i13;
                i9 = i12;
            }
            int i14 = i9 - 1;
            int i15 = i6 + 5;
            while (true) {
                if (i14 >= 0 && i15 < i4 && this.f767K[(i14 * i4) + i15] == 0) {
                    W(i3, i4, i14, i15, i5);
                    i5++;
                }
                int i16 = i14 + 2;
                int i17 = i15 - 2;
                if (i16 >= i3 || i17 < 0) {
                    break;
                }
                i14 = i16;
                i15 = i17;
            }
            i9 = i14 + 5;
            i6 = i15 - 1;
            if (i9 >= i3 && i6 >= i4) {
                break;
            } else {
                i10 = i5;
            }
        }
        int[] iArr = this.f767K;
        int i18 = i3 * i4;
        int i19 = i18 - 1;
        if (iArr[i19] == 0) {
            iArr[(i18 - i4) - 2] = 1;
            iArr[i19] = 1;
        }
    }

    @Override // E2.Q
    protected void c() {
        StringBuilder sb = new StringBuilder();
        b();
        int iO = O();
        int i3 = this.f757A;
        int i4 = 1;
        int i5 = (i3 < 1 || i3 > f756a0) ? -1 : f748S[i3 - 1];
        int i6 = this.f768L;
        int i7 = iO + i6;
        if (this.f766J == b.DM_X12 && i6 == 2) {
            i7++;
        }
        int i8 = f756a0;
        int i9 = i8 - 1;
        for (int i10 = i8 - 1; i10 > -1; i10--) {
            if (f753X[i10] >= i7) {
                i9 = i10;
            }
        }
        if (i5 == -1) {
            a aVar = this.f771z;
            if (aVar == a.SQUARE) {
                while (i9 < f756a0 && f749T[i9] != f750U[i9]) {
                    i9++;
                }
            } else if (aVar == a.RECTANGULAR) {
                while (i9 < f756a0 && f749T[i9] == f750U[i9]) {
                    i9++;
                }
            }
            i5 = i9;
            if (i5 >= f756a0) {
                throw new H("Data too long to fit in symbol");
            }
        } else if (i9 > i5) {
            throw new H("Input too long for selected symbol size");
        }
        int[] iArr = f753X;
        int iN = N(iArr[i5] - iO, iO);
        int i11 = iArr[i5];
        if (iN > i11) {
            throw new H("Data too long to fit in symbol");
        }
        int i12 = f749T[i5];
        int i13 = f750U[i5];
        int i14 = f751V[i5];
        int i15 = f752W[i5];
        int i16 = f754Y[i5];
        int i17 = f755Z[i5];
        this.f770N = i16 + i17;
        int i18 = i11 - iN;
        if (i18 != 0) {
            L(iN, i18);
        }
        M(i11, i16, i17, i5 == 29 ? 1 : 0);
        int i19 = i13 - ((i13 / i15) * 2);
        int i20 = i12 - ((i12 / i14) * 2);
        this.f767K = new int[i19 * i20];
        b0(i20, i19);
        int i21 = i13 * i12;
        int[] iArr2 = new int[i21];
        for (int i22 = 0; i22 < i21; i22++) {
            iArr2[i22] = 0;
        }
        for (int i23 = 0; i23 < i12; i23 += i14) {
            for (int i24 = 0; i24 < i13; i24++) {
                iArr2[(i23 * i13) + i24] = 1;
            }
            for (int i25 = 0; i25 < i13; i25 += 2) {
                iArr2[(((i23 + i14) - 1) * i13) + i25] = 1;
            }
        }
        for (int i26 = 0; i26 < i13; i26 += i15) {
            for (int i27 = 0; i27 < i12; i27++) {
                iArr2[(i27 * i13) + i26] = 1;
            }
            for (int i28 = 0; i28 < i12; i28 += 2) {
                iArr2[(((i28 * i13) + i26) + i15) - 1] = 1;
            }
        }
        int i29 = 0;
        while (i29 < i20) {
            int i30 = 0;
            while (i30 < i19) {
                int i31 = this.f767K[(((i20 - i29) - 1) * i19) + i30];
                if (i31 == i4 || (i31 > 7 && (this.f763G[(i31 >> 3) - 1] & (1 << (i31 & 7))) != 0)) {
                    iArr2[((i29 + 1 + ((i29 / (i14 - 2)) * 2)) * i13) + 1 + i30 + ((i30 / (i15 - 2)) * 2)] = 1;
                }
                i30++;
                i4 = 1;
            }
            i29++;
            i4 = 1;
        }
        this.f762F = G2.a.d(i5, f748S) + 1;
        this.f416o = "";
        this.f417p = new String[i12];
        this.f418q = i12;
        this.f419r = new int[i12];
        for (int i32 = i12 - 1; i32 >= 0; i32--) {
            sb.setLength(0);
            for (int i33 = 0; i33 < i13; i33++) {
                if (iArr2[(i13 * i32) + i33] == 1) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            int i34 = (i12 - i32) - 1;
            this.f417p[i34] = Q.a(sb);
            this.f419r[i34] = this.f408g;
        }
        w("Grid Size: " + i13 + " X " + i12);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data Codewords: ");
        sb2.append(i16);
        w(sb2.toString());
        w("ECC Codewords: " + i17);
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
