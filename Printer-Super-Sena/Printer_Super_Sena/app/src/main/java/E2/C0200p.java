package E2;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: E2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0200p extends Q {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f610D = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f611E = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 22, 23, 24, 25, 26, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final int[] f612F = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f613G = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 22, 23, 24, 25, 26, 0, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 27, 28, 29, 30, 31};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final int[] f614H = {16, 22, 28, 40, 52, 70, 104, 148};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f615I = {18, 22, 32, 42, 54, 76, 98, 134};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f616J = {10, 19, 44, 91, 182, 370, 732, 1480};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int[] f617K = {10, 16, 26, 44, 70, 140, 280, 560};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final int[] f618L = {1, 1, 1, 1, 1, 2, 4, 8};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int[] f619M = {10, 19, 44, 91, 182, 185, 183, 185};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f620N = {10, 16, 26, 44, 70, 70, 70, 70};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f621O = {4, 5, 7, 9, 12, 17, 22, 30};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final int[] f622P = {5, 7, 10, 15, 21, 30, 46, 68};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b f626z = b.NONE;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final int[] f623A = new int[1500];

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final int[][] f624B = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 136, 120);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final boolean[][] f625C = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 148, 134);

    /* JADX INFO: renamed from: E2.p$a */
    private enum a {
        C1_ASCII,
        C1_C40,
        C1_DECIMAL,
        C1_TEXT,
        C1_EDI,
        C1_BYTE
    }

    /* JADX INFO: renamed from: E2.p$b */
    public enum b {
        NONE,
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        S,
        T
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0171  */
    /* JADX WARN: Code duplicated, block: B:103:0x0176  */
    /* JADX WARN: Code duplicated, block: B:111:0x018c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0191  */
    /* JADX WARN: Code duplicated, block: B:117:0x019f  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:127:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:129:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:131:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:155:0x022c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0231  */
    /* JADX WARN: Code duplicated, block: B:165:0x0250  */
    /* JADX WARN: Code duplicated, block: B:167:0x0256  */
    /* JADX WARN: Code duplicated, block: B:169:0x025c  */
    /* JADX WARN: Code duplicated, block: B:173:0x0268  */
    /* JADX WARN: Code duplicated, block: B:178:0x0274  */
    /* JADX WARN: Code duplicated, block: B:181:0x027a  */
    /* JADX WARN: Code duplicated, block: B:221:0x0355  */
    /* JADX WARN: Code duplicated, block: B:223:0x035a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0379  */
    /* JADX WARN: Code duplicated, block: B:233:0x037f  */
    /* JADX WARN: Code duplicated, block: B:235:0x0385  */
    /* JADX WARN: Code duplicated, block: B:239:0x0391  */
    /* JADX WARN: Code duplicated, block: B:244:0x039d  */
    /* JADX WARN: Code duplicated, block: B:247:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:287:0x047c  */
    /* JADX WARN: Code duplicated, block: B:289:0x0480  */
    /* JADX WARN: Code duplicated, block: B:297:0x049f  */
    /* JADX WARN: Code duplicated, block: B:299:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:301:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:305:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:310:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:314:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:320:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:379:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:381:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:383:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:384:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:387:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:390:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:393:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:398:0x0603  */
    /* JADX WARN: Code duplicated, block: B:401:0x0609  */
    /* JADX WARN: Code duplicated, block: B:403:0x0613  */
    /* JADX WARN: Code duplicated, block: B:405:0x0617  */
    /* JADX WARN: Code duplicated, block: B:406:0x062b  */
    /* JADX WARN: Code duplicated, block: B:409:0x0646  */
    /* JADX WARN: Code duplicated, block: B:411:0x0658  */
    /* JADX WARN: Code duplicated, block: B:414:0x066c  */
    /* JADX WARN: Code duplicated, block: B:417:0x0671  */
    /* JADX WARN: Code duplicated, block: B:419:0x0679  */
    /* JADX WARN: Code duplicated, block: B:424:0x068d  */
    /* JADX WARN: Code duplicated, block: B:427:0x0692  */
    /* JADX WARN: Code duplicated, block: B:429:0x069c  */
    /* JADX WARN: Code duplicated, block: B:434:0x06b0  */
    /* JADX WARN: Code duplicated, block: B:437:0x06b5  */
    /* JADX WARN: Code duplicated, block: B:439:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:443:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:445:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:447:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:449:0x0708  */
    /* JADX WARN: Code duplicated, block: B:454:0x072a  */
    /* JADX WARN: Code duplicated, block: B:457:0x072f  */
    /* JADX WARN: Code duplicated, block: B:459:0x0737  */
    /* JADX WARN: Code duplicated, block: B:462:0x074b  */
    /* JADX WARN: Code duplicated, block: B:465:0x0763  */
    /* JADX WARN: Code duplicated, block: B:469:0x077e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:482:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:484:0x07a6  */
    /* JADX WARN: Code duplicated, block: B:486:0x07ab A[LOOP:21: B:485:0x07a9->B:486:0x07ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:489:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:491:0x07cc A[LOOP:27: B:490:0x07ca->B:491:0x07cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:493:0x07e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:535:0x08f9  */
    /* JADX WARN: Code duplicated, block: B:538:0x090d  */
    /* JADX WARN: Code duplicated, block: B:541:0x0912  */
    /* JADX WARN: Code duplicated, block: B:543:0x091a  */
    /* JADX WARN: Code duplicated, block: B:548:0x092d  */
    /* JADX WARN: Code duplicated, block: B:551:0x0932  */
    /* JADX WARN: Code duplicated, block: B:553:0x093c  */
    /* JADX WARN: Code duplicated, block: B:558:0x094f  */
    /* JADX WARN: Code duplicated, block: B:560:0x0954  */
    /* JADX WARN: Code duplicated, block: B:562:0x095e  */
    /* JADX WARN: Code duplicated, block: B:563:0x096a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00db  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:643:0x0685 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x06a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x06cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:652:0x0771 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0925 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0947 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:70:0x0108  */
    /* JADX WARN: Code duplicated, block: B:80:0x0133  */
    /* JADX WARN: Code duplicated, block: B:82:0x0136  */
    /* JADX WARN: Code duplicated, block: B:84:0x013d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0143  */
    /* JADX WARN: Code duplicated, block: B:89:0x0149  */
    /* JADX WARN: Code duplicated, block: B:97:0x0160  */
    /* JADX WARN: Instruction removed from duplicated block: B:381:0x05b9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:393:0x05ec, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:405:0x0617, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:406:0x062b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:409:0x0646, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:411:0x0658, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:447:0x06f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:449:0x0708, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:535:0x08f9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x00f2, please report this as an issue */
    private int L() {
        int i3;
        int i4;
        int[] iArr;
        int i5;
        a aVarP;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        a aVar;
        a aVarP2;
        a aVar2;
        int i11;
        int i12;
        int i13;
        a aVar3;
        int i14;
        char c3;
        int i15;
        int i16;
        String strSubstring;
        String str;
        int i17;
        int i18;
        int length;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        a aVar4;
        a aVar5;
        int i26;
        a aVar6;
        a aVar7;
        int i27;
        int i28;
        boolean z3;
        int i29;
        int i30;
        int i31;
        int i32;
        a aVar8;
        a aVar9;
        boolean z4;
        int i33;
        a aVar10;
        a aVarP3;
        int i34;
        int i35;
        int i36;
        boolean z5;
        int i37;
        int i38;
        int i39;
        int i40;
        a aVar11;
        a aVar12;
        boolean z6;
        int i41;
        a aVar13;
        a aVarP4;
        int i42;
        int i43;
        int i44;
        boolean z7;
        int i45;
        int i46;
        int i47;
        boolean z8;
        a aVar14;
        int[] iArr2;
        int i48;
        int i49;
        int i50;
        int i51;
        boolean z9;
        int i52;
        int i53;
        int i54;
        int i55;
        int i56;
        int[] iArr3;
        int i57;
        int i58;
        int i59;
        int i60;
        int i61;
        int i62;
        boolean z10;
        int i63;
        int i64;
        int[] iArr4 = new int[6];
        int[] iArr5 = new int[6];
        int[] iArr6 = new int[6];
        int[] iArrK = Q.K(this.f413l, StandardCharsets.ISO_8859_1, new int[0]);
        this.f415n = iArrK;
        int length2 = iArrK.length;
        int i65 = 1;
        if (this.f403b == Q.a.GS1) {
            this.f623A[0] = 232;
            i3 = 1;
        } else {
            i3 = 0;
        }
        a aVar15 = a.C1_ASCII;
        String str2 = "";
        int i66 = 0;
        int i67 = 0;
        int i68 = 0;
        int i69 = 0;
        int i70 = 0;
        a aVar16 = aVar15;
        while (true) {
            if (aVar15 != aVar16) {
                int iOrdinal = aVar16.ordinal();
                if (iOrdinal == i65) {
                    this.f623A[i3] = 230;
                } else if (iOrdinal == 3) {
                    this.f623A[i3] = 239;
                } else if (iOrdinal == 4) {
                    this.f623A[i3] = 238;
                } else if (iOrdinal == 5) {
                    this.f623A[i3] = 231;
                }
                i3++;
            }
            a aVar17 = a.C1_BYTE;
            int i71 = (aVar15 == aVar17 || aVar16 != aVar17) ? i70 : i3;
            a aVar18 = a.C1_ASCII;
            if (aVar16 == aVar18) {
                int i72 = length2 - i66;
                i4 = i71;
                iArr = iArr6;
                if (i72 >= 21) {
                    int i73 = 0;
                    int i74 = 0;
                    while (i74 < 21) {
                        int i75 = this.f415n[i66 + i74];
                        int i76 = i69;
                        if (i75 >= 48 && i75 <= 57) {
                            i73++;
                        }
                        i74++;
                        i69 = i76;
                    }
                    i5 = i69;
                    if (i73 == 21) {
                        aVarP = a.C1_DECIMAL;
                        str2 = str2 + "1111";
                    }
                    if (aVarP == a.C1_ASCII) {
                        i59 = 13;
                        if (i72 >= 13) {
                            i60 = 0;
                            i61 = 0;
                            while (i60 < i59) {
                                i64 = this.f415n[i66 + i60];
                                if (i64 < 48 && i64 <= 57) {
                                    i61++;
                                }
                                i60++;
                                i59 = 13;
                            }
                            if (i61 == i59) {
                                z10 = false;
                                for (i62 = i66 + 13; i62 < length2; i62++) {
                                    i63 = this.f415n[i62];
                                    if (i63 >= 48 || i63 > 57) {
                                        z10 = true;
                                    }
                                }
                                if (!z10) {
                                    aVarP = a.C1_DECIMAL;
                                    str2 = str2 + "1111";
                                }
                            }
                        }
                    }
                    if (aVarP == a.C1_ASCII) {
                        i47 = i66 + 1;
                        if (i47 != length2 || (i57 = (iArr3 = this.f415n)[i66]) < 48 || i57 > 57 || (i58 = iArr3[i47]) < 48 || i58 > 57) {
                            z8 = false;
                        } else {
                            this.f623A[i3] = ((i57 - 48) * 10) + (i58 - 48) + 130;
                            i3++;
                            i66 += 2;
                            z8 = true;
                        }
                        if (!z8) {
                            if (this.f415n[i66] == -1) {
                                if (length2 - i66 >= 15) {
                                    i55 = 0;
                                    for (i54 = 0; i54 < 15; i54++) {
                                        i56 = this.f415n[i66 + i54];
                                        if (i56 < 48 && i56 <= 57) {
                                            i55++;
                                        }
                                    }
                                    if (i55 == 15) {
                                        this.f623A[i3] = 236;
                                        i3++;
                                        i66++;
                                        aVarP = a.C1_DECIMAL;
                                    }
                                }
                                if (length2 - i66 >= 7) {
                                    i50 = 0;
                                    for (i49 = 0; i49 < 7; i49++) {
                                        i53 = this.f415n[i66 + i49];
                                        if (i53 < 48 && i53 <= 57) {
                                            i50++;
                                        }
                                    }
                                    if (i50 == 7) {
                                        z9 = false;
                                        for (i51 = i66 + 7; i51 < length2; i51++) {
                                            i52 = this.f415n[i66 + i51];
                                            if (i52 >= 48 || i52 > 57) {
                                                z9 = true;
                                            }
                                        }
                                        if (!z9) {
                                            this.f623A[i3] = 236;
                                            i3++;
                                            i66++;
                                            aVarP = a.C1_DECIMAL;
                                        }
                                    }
                                }
                            }
                            aVar14 = a.C1_ASCII;
                            if (aVarP == aVar14 && (aVarP = P(length2, i66, aVar16)) == aVar14) {
                                iArr2 = this.f415n;
                                i48 = iArr2[i66];
                                if (i48 > 127) {
                                    int[] iArr7 = this.f623A;
                                    iArr7[i3] = 235;
                                    iArr7[i3 + 1] = iArr2[i66] - 127;
                                    i3 += 2;
                                } else {
                                    if (i48 == -1) {
                                        this.f623A[i3] = 232;
                                    } else {
                                        this.f623A[i3] = i48 + 1;
                                    }
                                    i3++;
                                }
                                i66++;
                            }
                        }
                    }
                } else {
                    i5 = i69;
                }
                aVarP = aVar18;
                if (aVarP == a.C1_ASCII) {
                    i59 = 13;
                    if (i72 >= 13) {
                        i60 = 0;
                        i61 = 0;
                        while (i60 < i59) {
                            i64 = this.f415n[i66 + i60];
                            if (i64 < 48) {
                            }
                            i60++;
                            i59 = 13;
                        }
                        if (i61 == i59) {
                            z10 = false;
                            while (i62 < length2) {
                                i63 = this.f415n[i62];
                                if (i63 >= 48) {
                                    z10 = true;
                                } else {
                                    z10 = true;
                                }
                            }
                            if (!z10) {
                                aVarP = a.C1_DECIMAL;
                                str2 = str2 + "1111";
                            }
                        }
                    }
                }
                if (aVarP == a.C1_ASCII) {
                    i47 = i66 + 1;
                    if (i47 != length2) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (!z8) {
                        if (this.f415n[i66] == -1) {
                            if (length2 - i66 >= 15) {
                                i55 = 0;
                                while (i54 < 15) {
                                    i56 = this.f415n[i66 + i54];
                                    if (i56 < 48) {
                                    }
                                }
                                if (i55 == 15) {
                                    this.f623A[i3] = 236;
                                    i3++;
                                    i66++;
                                    aVarP = a.C1_DECIMAL;
                                }
                            }
                            if (length2 - i66 >= 7) {
                                i50 = 0;
                                while (i49 < 7) {
                                    i53 = this.f415n[i66 + i49];
                                    if (i53 < 48) {
                                    }
                                }
                                if (i50 == 7) {
                                    z9 = false;
                                    while (i51 < length2) {
                                        i52 = this.f415n[i66 + i51];
                                        if (i52 >= 48) {
                                            z9 = true;
                                        } else {
                                            z9 = true;
                                        }
                                    }
                                    if (!z9) {
                                        this.f623A[i3] = 236;
                                        i3++;
                                        i66++;
                                        aVarP = a.C1_DECIMAL;
                                    }
                                }
                            }
                        }
                        aVar14 = a.C1_ASCII;
                        if (aVarP == aVar14) {
                            iArr2 = this.f415n;
                            i48 = iArr2[i66];
                            if (i48 > 127) {
                                int[] iArr8 = this.f623A;
                                iArr8[i3] = 235;
                                iArr8[i3 + 1] = iArr2[i66] - 127;
                                i3 += 2;
                            } else {
                                if (i48 == -1) {
                                    this.f623A[i3] = 232;
                                } else {
                                    this.f623A[i3] = i48 + 1;
                                }
                                i3++;
                            }
                            i66++;
                        }
                    }
                }
            } else {
                i4 = i71;
                iArr = iArr6;
                i5 = i69;
                aVarP = aVar16;
            }
            a aVar19 = a.C1_C40;
            if (aVar16 == aVar19) {
                if (i67 == 0) {
                    int i77 = length2 - i66;
                    if (i77 >= 12) {
                        int i78 = 0;
                        int i79 = 0;
                        for (int i80 = 12; i78 < i80; i80 = 12) {
                            int i81 = this.f415n[i66 + i78];
                            a aVar20 = aVar19;
                            if (i81 >= 48 && i81 <= 57) {
                                i79++;
                            }
                            i78++;
                            aVar19 = aVar20;
                        }
                        aVar11 = aVar19;
                        if (i79 == 12) {
                            aVar12 = a.C1_ASCII;
                            z6 = true;
                        }
                        if (i77 >= 8) {
                            i42 = 0;
                            i43 = 0;
                            for (i41 = 8; i42 < i41; i41 = 8) {
                                i46 = this.f415n[i66 + i42];
                                a aVar21 = aVar12;
                                if (i46 < 48 && i46 <= 57) {
                                    i43++;
                                }
                                i42++;
                                aVar12 = aVar21;
                            }
                            aVar13 = aVar12;
                            if (i77 == 8) {
                                i44 = i43;
                                z7 = true;
                            } else {
                                i44 = i66 + 8;
                                z7 = true;
                                while (i44 < length2) {
                                    i45 = this.f415n[i44];
                                    if (i45 > 48 || i45 >= 57) {
                                        z7 = false;
                                    }
                                    i44++;
                                }
                            }
                            if (i44 != 8 && z7) {
                                aVarP4 = a.C1_ASCII;
                                z6 = true;
                            }
                            if (!z6) {
                                aVarP4 = P(length2, i66, aVar16);
                            }
                            aVarP = aVarP4;
                        } else {
                            aVar13 = aVar12;
                        }
                        aVarP4 = aVar13;
                        if (!z6) {
                            aVarP4 = P(length2, i66, aVar16);
                        }
                        aVarP = aVarP4;
                    } else {
                        aVar11 = aVar19;
                    }
                    aVar12 = aVar11;
                    z6 = false;
                    if (i77 >= 8) {
                        i42 = 0;
                        i43 = 0;
                        while (i42 < i41) {
                            i46 = this.f415n[i66 + i42];
                            a aVar22 = aVar12;
                            if (i46 < 48) {
                            }
                            i42++;
                            aVar12 = aVar22;
                        }
                        aVar13 = aVar12;
                        if (i77 == 8) {
                            i44 = i43;
                            z7 = true;
                        } else {
                            i44 = i66 + 8;
                            z7 = true;
                            while (i44 < length2) {
                                i45 = this.f415n[i44];
                                if (i45 > 48) {
                                    z7 = false;
                                } else {
                                    z7 = false;
                                }
                                i44++;
                            }
                        }
                        if (i44 != 8) {
                        }
                        if (!z6) {
                            aVarP4 = P(length2, i66, aVar16);
                        }
                        aVarP = aVarP4;
                    } else {
                        aVar13 = aVar12;
                    }
                    aVarP4 = aVar13;
                    if (!z6) {
                        aVarP4 = P(length2, i66, aVar16);
                    }
                    aVarP = aVarP4;
                } else {
                    aVarP = aVar19;
                }
                if (aVarP != a.C1_C40) {
                    this.f623A[i3] = 255;
                    i3++;
                } else {
                    int[] iArr9 = this.f415n;
                    int i82 = iArr9[i66];
                    if (i82 > 127) {
                        iArr4[i67] = 1;
                        iArr4[i67 + 1] = 30;
                        i67 += 2;
                        int[] iArr10 = f610D;
                        int i83 = iArr9[i66];
                        i40 = iArr10[i83 - 128];
                        i39 = f611E[i83 - 128];
                    } else {
                        int i84 = f610D[i82];
                        i39 = f611E[i82];
                        i40 = i84;
                    }
                    if (iArr9[i66] == -1) {
                        i39 = 27;
                        i40 = 2;
                    }
                    if (i40 != 0) {
                        iArr4[i67] = i40 - 1;
                        i67++;
                    }
                    iArr4[i67] = i39;
                    int i85 = i67 + 1;
                    if (i85 >= 3) {
                        int i86 = (iArr4[0] * 1600) + (iArr4[1] * 40) + iArr4[2] + 1;
                        int[] iArr11 = this.f623A;
                        iArr11[i3] = i86 / 256;
                        iArr11[i3 + 1] = i86 % 256;
                        i3 += 2;
                        iArr4[0] = iArr4[3];
                        iArr4[1] = iArr4[4];
                        iArr4[2] = iArr4[5];
                        iArr4[3] = 0;
                        iArr4[4] = 0;
                        iArr4[5] = 0;
                        i67 -= 2;
                    } else {
                        i67 = i85;
                    }
                    i66++;
                }
            }
            a aVar23 = a.C1_TEXT;
            if (aVar16 == aVar23) {
                if (i68 == 0) {
                    int i87 = length2 - i66;
                    if (i87 >= 12) {
                        int i88 = 0;
                        int i89 = 0;
                        for (int i90 = 12; i88 < i90; i90 = 12) {
                            int i91 = this.f415n[i66 + i88];
                            a aVar24 = aVar23;
                            if (i91 >= 48 && i91 <= 57) {
                                i89++;
                            }
                            i88++;
                            aVar23 = aVar24;
                        }
                        aVar8 = aVar23;
                        if (i89 == 12) {
                            aVar9 = a.C1_ASCII;
                            z4 = true;
                        }
                        if (i87 >= 8) {
                            i34 = 0;
                            i35 = 0;
                            for (i33 = 8; i34 < i33; i33 = 8) {
                                i38 = this.f415n[i66 + i34];
                                a aVar25 = aVar9;
                                if (i38 < 48 && i38 <= 57) {
                                    i35++;
                                }
                                i34++;
                                aVar9 = aVar25;
                            }
                            aVar10 = aVar9;
                            if (i87 == 8) {
                                i36 = i35;
                                z5 = true;
                            } else {
                                i36 = i66 + 8;
                                z5 = true;
                                while (i36 < length2) {
                                    i37 = this.f415n[i36];
                                    if (i37 > 48 || i37 >= 57) {
                                        z5 = false;
                                    }
                                    i36++;
                                }
                            }
                            if (i36 != 8 && z5) {
                                aVarP3 = a.C1_ASCII;
                                z4 = true;
                            }
                            if (!z4) {
                                aVarP3 = P(length2, i66, aVar16);
                            }
                            aVarP = aVarP3;
                        } else {
                            aVar10 = aVar9;
                        }
                        aVarP3 = aVar10;
                        if (!z4) {
                            aVarP3 = P(length2, i66, aVar16);
                        }
                        aVarP = aVarP3;
                    } else {
                        aVar8 = aVar23;
                    }
                    aVar9 = aVar8;
                    z4 = false;
                    if (i87 >= 8) {
                        i34 = 0;
                        i35 = 0;
                        while (i34 < i33) {
                            i38 = this.f415n[i66 + i34];
                            a aVar26 = aVar9;
                            if (i38 < 48) {
                            }
                            i34++;
                            aVar9 = aVar26;
                        }
                        aVar10 = aVar9;
                        if (i87 == 8) {
                            i36 = i35;
                            z5 = true;
                        } else {
                            i36 = i66 + 8;
                            z5 = true;
                            while (i36 < length2) {
                                i37 = this.f415n[i36];
                                if (i37 > 48) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                i36++;
                            }
                        }
                        if (i36 != 8) {
                        }
                        if (!z4) {
                            aVarP3 = P(length2, i66, aVar16);
                        }
                        aVarP = aVarP3;
                    } else {
                        aVar10 = aVar9;
                    }
                    aVarP3 = aVar10;
                    if (!z4) {
                        aVarP3 = P(length2, i66, aVar16);
                    }
                    aVarP = aVarP3;
                } else {
                    aVarP = aVar23;
                }
                if (aVarP != a.C1_TEXT) {
                    this.f623A[i3] = 255;
                    i3++;
                } else {
                    int[] iArr12 = this.f415n;
                    int i92 = iArr12[i66];
                    if (i92 > 127) {
                        iArr5[i68] = 1;
                        iArr5[i68 + 1] = 30;
                        i68 += 2;
                        int[] iArr13 = f612F;
                        int i93 = iArr12[i66];
                        i32 = iArr13[i93 - 128];
                        i31 = f613G[i93 - 128];
                    } else {
                        int i94 = f612F[i92];
                        i31 = f613G[i92];
                        i32 = i94;
                    }
                    if (iArr12[i66] == -1) {
                        i31 = 27;
                        i32 = 2;
                    }
                    if (i32 != 0) {
                        iArr5[i68] = i32 - 1;
                        i68++;
                    }
                    iArr5[i68] = i31;
                    int i95 = i68 + 1;
                    if (i95 >= 3) {
                        int i96 = (iArr5[0] * 1600) + (iArr5[1] * 40) + iArr5[2] + 1;
                        int[] iArr14 = this.f623A;
                        iArr14[i3] = i96 / 256;
                        iArr14[i3 + 1] = i96 % 256;
                        i3 += 2;
                        iArr5[0] = iArr5[3];
                        iArr5[1] = iArr5[4];
                        iArr5[2] = iArr5[5];
                        iArr5[3] = 0;
                        iArr5[4] = 0;
                        iArr5[5] = 0;
                        i68 -= 2;
                    } else {
                        i68 = i95;
                    }
                    i66++;
                }
            }
            a aVar27 = a.C1_EDI;
            if (aVar16 != aVar27) {
                i69 = i5;
            } else {
                if (i5 == 0) {
                    int i97 = length2 - i66;
                    if (i97 >= 12) {
                        int i98 = 0;
                        int i99 = 0;
                        for (int i100 = 12; i98 < i100; i100 = 12) {
                            int i101 = this.f415n[i66 + i98];
                            a aVar28 = aVar27;
                            if (i101 >= 48 && i101 <= 57) {
                                i99++;
                            }
                            i98++;
                            aVar27 = aVar28;
                        }
                        aVar4 = aVar27;
                        if (i99 == 12) {
                            aVar5 = a.C1_ASCII;
                        }
                        if (i97 >= 8) {
                            i27 = 0;
                            i28 = 0;
                            for (i26 = 8; i27 < i26; i26 = 8) {
                                i30 = this.f415n[i66 + i27];
                                a aVar29 = aVar5;
                                if (i30 < 48 && i30 <= 57) {
                                    i28++;
                                }
                                i27++;
                                aVar5 = aVar29;
                            }
                            aVar6 = aVar5;
                            if (i97 == 8) {
                                z3 = true;
                            } else {
                                i28 = i66 + 8;
                                z3 = true;
                                while (i28 < length2) {
                                    i29 = this.f415n[i28];
                                    if (i29 > 48 || i29 >= 57) {
                                        z3 = false;
                                    }
                                    i28++;
                                }
                            }
                            if (i28 != 8 && z3) {
                                aVar7 = a.C1_ASCII;
                            }
                            if (N(this.f415n[i66]) || !N(this.f415n[i66 + 1]) || !N(this.f415n[i66 + 2])) {
                                aVar7 = a.C1_ASCII;
                            }
                            aVarP = aVar7;
                        } else {
                            aVar6 = aVar5;
                        }
                        aVar7 = aVar6;
                        if (N(this.f415n[i66])) {
                            aVar7 = a.C1_ASCII;
                        } else {
                            aVar7 = a.C1_ASCII;
                        }
                        aVarP = aVar7;
                    } else {
                        aVar4 = aVar27;
                    }
                    aVar5 = aVar4;
                    if (i97 >= 8) {
                        i27 = 0;
                        i28 = 0;
                        while (i27 < i26) {
                            i30 = this.f415n[i66 + i27];
                            a aVar210 = aVar5;
                            if (i30 < 48) {
                            }
                            i27++;
                            aVar5 = aVar210;
                        }
                        aVar6 = aVar5;
                        if (i97 == 8) {
                            z3 = true;
                        } else {
                            i28 = i66 + 8;
                            z3 = true;
                            while (i28 < length2) {
                                i29 = this.f415n[i28];
                                if (i29 > 48) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                i28++;
                            }
                        }
                        if (i28 != 8) {
                        }
                        if (N(this.f415n[i66])) {
                            aVar7 = a.C1_ASCII;
                        } else {
                            aVar7 = a.C1_ASCII;
                        }
                        aVarP = aVar7;
                    } else {
                        aVar6 = aVar5;
                    }
                    aVar7 = aVar6;
                    if (N(this.f415n[i66])) {
                        aVar7 = a.C1_ASCII;
                    } else {
                        aVar7 = a.C1_ASCII;
                    }
                    aVarP = aVar7;
                } else {
                    aVarP = aVar27;
                }
                if (aVarP != a.C1_EDI) {
                    this.f623A[i3] = 255;
                    i3++;
                    i69 = i5;
                } else {
                    int i102 = this.f415n[i66];
                    int i103 = i102 == 42 ? 1 : 0;
                    if (i102 == 62) {
                        i103 = 2;
                    }
                    if (i102 == 32) {
                        i103 = 3;
                    }
                    if (i102 >= 48 && i102 <= 57) {
                        i103 = i102 - 44;
                    }
                    if (i102 >= 65 && i102 <= 90) {
                        i103 = i102 - 51;
                    }
                    iArr[i5] = i103;
                    i69 = i5 + 1;
                    if (i69 >= 3) {
                        int i104 = (iArr[0] * 1600) + (iArr[1] * 40) + iArr[2] + 1;
                        int[] iArr15 = this.f623A;
                        iArr15[i3] = i104 / 256;
                        iArr15[i3 + 1] = i104 % 256;
                        i3 += 2;
                        iArr[0] = iArr[3];
                        iArr[1] = iArr[4];
                        iArr[2] = iArr[5];
                        iArr[3] = 0;
                        iArr[4] = 0;
                        iArr[5] = 0;
                        i69 = i5 - 2;
                    }
                    i66++;
                }
            }
            a aVar30 = a.C1_DECIMAL;
            if (aVar16 == aVar30) {
                int i105 = length2 - i66;
                char c4 = (i105 < 1 || (i25 = this.f415n[i66]) < 48 || i25 > 57) ? (char) 0 : (char) 1;
                if (i105 < 2 || c4 != 1) {
                    aVar3 = aVar30;
                } else {
                    int i106 = this.f415n[i66 + 1];
                    aVar3 = aVar30;
                    if (i106 >= 48 && i106 <= 57) {
                        i14 = 3;
                        c4 = 2;
                    }
                    if (i105 >= i14 || c4 != 2 || (i24 = this.f415n[i66 + 2]) < 48 || i24 > 57) {
                        c3 = 3;
                    } else {
                        c3 = 3;
                        c4 = 3;
                    }
                    if (c4 != c3) {
                        strSubstring = str2 + "111111";
                        if (strSubstring.length() <= 16) {
                            i18 = 2;
                        } else {
                            i18 = 3;
                        }
                        if (strSubstring.length() <= 8) {
                            i18 = 1;
                        }
                        length = (i18 * 8) - strSubstring.length();
                        if (length == 8) {
                            length = 0;
                        }
                        if (length == 2) {
                            strSubstring = strSubstring + "01";
                        }
                        if (length != 4 || length == 6) {
                            if (c4 >= 1) {
                                i19 = this.f415n[i66] - 47;
                                i20 = 8;
                                while (i20 > 0) {
                                    if ((i19 & i20) != 0) {
                                        strSubstring = strSubstring + "1";
                                    } else {
                                        strSubstring = strSubstring + "0";
                                    }
                                    i20 >>= 1;
                                    i19 = i19;
                                }
                                i66++;
                            } else {
                                strSubstring = strSubstring + "1111";
                            }
                        }
                        if (length == 6) {
                            strSubstring = strSubstring + "01";
                        }
                        if (i18 >= 1) {
                            for (i23 = 0; i23 < 8; i23++) {
                                if (strSubstring.charAt(i23) == '1') {
                                    int[] iArr16 = this.f623A;
                                    iArr16[i3] = iArr16[i3] + (128 >> i23);
                                }
                            }
                            i3++;
                        }
                        if (i18 >= 2) {
                            for (i22 = 0; i22 < 8; i22++) {
                                if (strSubstring.charAt(i22 + 8) == '1') {
                                    int[] iArr17 = this.f623A;
                                    iArr17[i3] = iArr17[i3] + (128 >> i22);
                                }
                            }
                            i3++;
                        }
                        if (i18 == 3) {
                            for (i21 = 0; i21 < 8; i21++) {
                                if (strSubstring.charAt(i21 + 16) == '1') {
                                    int[] iArr18 = this.f623A;
                                    iArr18[i3] = iArr18[i3] + (128 >> i21);
                                }
                            }
                            i3++;
                        }
                        aVarP = a.C1_ASCII;
                    } else {
                        int[] iArr19 = this.f415n;
                        i15 = ((iArr19[i66] - 48) * 100) + ((iArr19[i66 + 1] - 48) * 10) + (iArr19[i66 + 2] - 48) + 1;
                        for (i16 = 512; i16 > 0; i16 >>= 1) {
                            if ((i15 & i16) != 0) {
                                str = str2 + "1";
                            } else {
                                str = str2 + "0";
                            }
                            str2 = str;
                        }
                        i66 += 3;
                        strSubstring = str2;
                        aVarP = aVar3;
                    }
                    if (strSubstring.length() >= 24) {
                        for (i17 = 0; i17 < 8; i17++) {
                            if (strSubstring.charAt(i17) == '1') {
                                int[] iArr20 = this.f623A;
                                iArr20[i3] = iArr20[i3] + (128 >> i17);
                            }
                            if (strSubstring.charAt(i17 + 8) == '1') {
                                int[] iArr21 = this.f623A;
                                int i107 = i3 + 1;
                                iArr21[i107] = iArr21[i107] + (128 >> i17);
                            }
                            if (strSubstring.charAt(i17 + 16) == '1') {
                                int[] iArr22 = this.f623A;
                                int i108 = i3 + 2;
                                iArr22[i108] = iArr22[i108] + (128 >> i17);
                            }
                        }
                        i3 += 3;
                        if (strSubstring.length() > 24) {
                            strSubstring = strSubstring.substring(24);
                        }
                    }
                    str2 = strSubstring;
                }
                i14 = 3;
                if (i105 >= i14) {
                    c3 = 3;
                } else {
                    c3 = 3;
                }
                if (c4 != c3) {
                    strSubstring = str2 + "111111";
                    if (strSubstring.length() <= 16) {
                        i18 = 2;
                    } else {
                        i18 = 3;
                    }
                    if (strSubstring.length() <= 8) {
                        i18 = 1;
                    }
                    length = (i18 * 8) - strSubstring.length();
                    if (length == 8) {
                        length = 0;
                    }
                    if (length == 2) {
                        strSubstring = strSubstring + "01";
                    }
                    if (length != 4) {
                        if (c4 >= 1) {
                            i19 = this.f415n[i66] - 47;
                            i20 = 8;
                            while (i20 > 0) {
                                if ((i19 & i20) != 0) {
                                    strSubstring = strSubstring + "1";
                                } else {
                                    strSubstring = strSubstring + "0";
                                }
                                i20 >>= 1;
                                i19 = i19;
                            }
                            i66++;
                        } else {
                            strSubstring = strSubstring + "1111";
                        }
                    } else if (c4 >= 1) {
                        i19 = this.f415n[i66] - 47;
                        i20 = 8;
                        while (i20 > 0) {
                            if ((i19 & i20) != 0) {
                                strSubstring = strSubstring + "1";
                            } else {
                                strSubstring = strSubstring + "0";
                            }
                            i20 >>= 1;
                            i19 = i19;
                        }
                        i66++;
                    } else {
                        strSubstring = strSubstring + "1111";
                    }
                    if (length == 6) {
                        strSubstring = strSubstring + "01";
                    }
                    if (i18 >= 1) {
                        while (i23 < 8) {
                            if (strSubstring.charAt(i23) == '1') {
                                int[] iArr110 = this.f623A;
                                iArr110[i3] = iArr110[i3] + (128 >> i23);
                            }
                        }
                        i3++;
                    }
                    if (i18 >= 2) {
                        while (i22 < 8) {
                            if (strSubstring.charAt(i22 + 8) == '1') {
                                int[] iArr111 = this.f623A;
                                iArr111[i3] = iArr111[i3] + (128 >> i22);
                            }
                        }
                        i3++;
                    }
                    if (i18 == 3) {
                        while (i21 < 8) {
                            if (strSubstring.charAt(i21 + 16) == '1') {
                                int[] iArr112 = this.f623A;
                                iArr112[i3] = iArr112[i3] + (128 >> i21);
                            }
                        }
                        i3++;
                    }
                    aVarP = a.C1_ASCII;
                } else {
                    int[] iArr113 = this.f415n;
                    i15 = ((iArr113[i66] - 48) * 100) + ((iArr113[i66 + 1] - 48) * 10) + (iArr113[i66 + 2] - 48) + 1;
                    while (i16 > 0) {
                        if ((i15 & i16) != 0) {
                            str = str2 + "1";
                        } else {
                            str = str2 + "0";
                        }
                        str2 = str;
                    }
                    i66 += 3;
                    strSubstring = str2;
                    aVarP = aVar3;
                }
                if (strSubstring.length() >= 24) {
                    while (i17 < 8) {
                        if (strSubstring.charAt(i17) == '1') {
                            int[] iArr23 = this.f623A;
                            iArr23[i3] = iArr23[i3] + (128 >> i17);
                        }
                        if (strSubstring.charAt(i17 + 8) == '1') {
                            int[] iArr24 = this.f623A;
                            int i109 = i3 + 1;
                            iArr24[i109] = iArr24[i109] + (128 >> i17);
                        }
                        if (strSubstring.charAt(i17 + 16) == '1') {
                            int[] iArr25 = this.f623A;
                            int i1010 = i3 + 2;
                            iArr25[i1010] = iArr25[i1010] + (128 >> i17);
                        }
                    }
                    i3 += 3;
                    if (strSubstring.length() > 24) {
                        strSubstring = strSubstring.substring(24);
                    }
                }
                str2 = strSubstring;
            }
            a aVar31 = a.C1_BYTE;
            if (aVar16 == aVar31) {
                int i110 = this.f415n[i66];
                if (i110 == -1) {
                    aVarP2 = a.C1_ASCII;
                } else {
                    if (i110 <= 127) {
                        aVarP2 = P(length2, i66, aVar16);
                    } else {
                        aVar = aVar31;
                    }
                    if (aVar != aVar31) {
                        i11 = i3 - i4;
                        if (i11 <= 249) {
                            i13 = i3;
                            i6 = i4;
                            while (i13 >= i6) {
                                a aVar32 = aVar;
                                int[] iArr26 = this.f623A;
                                iArr26[i13 + 1] = iArr26[i13];
                                i13--;
                                aVar = aVar32;
                            }
                            aVar2 = aVar;
                            this.f623A[i6] = i11;
                            i3++;
                        } else {
                            aVar2 = aVar;
                            i6 = i4;
                            for (i12 = i3; i12 >= i6; i12--) {
                                int[] iArr27 = this.f623A;
                                iArr27[i12 + 2] = iArr27[i12];
                            }
                            int[] iArr28 = this.f623A;
                            iArr28[i6] = (i11 / 250) + 249;
                            iArr28[i6 + 1] = i11 % 250;
                            i3 += 2;
                        }
                    } else {
                        aVar2 = aVar;
                        i6 = i4;
                        this.f623A[i3] = this.f415n[i66];
                        i3++;
                        i66++;
                    }
                    aVarP = aVar2;
                }
                aVar = aVarP2;
                if (aVar != aVar31) {
                    i11 = i3 - i4;
                    if (i11 <= 249) {
                        i13 = i3;
                        i6 = i4;
                        while (i13 >= i6) {
                            a aVar33 = aVar;
                            int[] iArr29 = this.f623A;
                            iArr29[i13 + 1] = iArr29[i13];
                            i13--;
                            aVar = aVar33;
                        }
                        aVar2 = aVar;
                        this.f623A[i6] = i11;
                        i3++;
                    } else {
                        aVar2 = aVar;
                        i6 = i4;
                        while (i12 >= i6) {
                            int[] iArr210 = this.f623A;
                            iArr210[i12 + 2] = iArr210[i12];
                        }
                        int[] iArr211 = this.f623A;
                        iArr211[i6] = (i11 / 250) + 249;
                        iArr211[i6 + 1] = i11 % 250;
                        i3 += 2;
                    }
                } else {
                    aVar2 = aVar;
                    i6 = i4;
                    this.f623A[i3] = this.f415n[i66];
                    i3++;
                    i66++;
                }
                aVarP = aVar2;
            } else {
                i6 = i4;
            }
            if (i3 > 1480) {
                throw new H("Input data too long");
            }
            if (i66 >= length2) {
                if (i67 == 2) {
                    iArr4[2] = 1;
                    int i111 = (iArr4[0] * 1600) + (iArr4[1] * 40) + 2;
                    int[] iArr30 = this.f623A;
                    iArr30[i3] = i111 / 256;
                    iArr30[i3 + 1] = i111 % 256;
                    iArr30[i3 + 2] = 255;
                    i3 += 3;
                }
                if (i67 == 1) {
                    iArr4[1] = 1;
                    iArr4[2] = 31;
                    int i112 = (iArr4[0] * 1600) + 72;
                    int[] iArr31 = this.f623A;
                    iArr31[i3] = i112 / 256;
                    iArr31[i3 + 1] = i112 % 256;
                    iArr31[i3 + 2] = 255;
                    i3 += 3;
                }
                if (i68 == 2) {
                    iArr5[2] = 1;
                    int i113 = (iArr5[0] * 1600) + (iArr5[1] * 40) + 2;
                    int[] iArr32 = this.f623A;
                    iArr32[i3] = i113 / 256;
                    iArr32[i3 + 1] = i113 % 256;
                    iArr32[i3 + 2] = 255;
                    i3 += 3;
                }
                if (i68 == 1) {
                    iArr5[1] = 1;
                    iArr5[2] = 31;
                    int i114 = (iArr5[0] * 1600) + 72;
                    int[] iArr33 = this.f623A;
                    iArr33[i3] = i114 / 256;
                    iArr33[i3 + 1] = i114 % 256;
                    iArr33[i3 + 2] = 255;
                    i3 += 3;
                }
                if (aVar16 == a.C1_DECIMAL) {
                    String str3 = str2 + "111111";
                    int i115 = str3.length() <= 8 ? 1 : str3.length() <= 16 ? 2 : 3;
                    int length3 = (i115 * 8) - str3.length();
                    if (length3 == 8) {
                        length3 = 0;
                    }
                    if (length3 == 2) {
                        str3 = str3 + "01";
                    }
                    if (length3 != 4) {
                        i7 = 6;
                        if (length3 == 6) {
                        }
                        if (length3 == i7) {
                            str3 = str3 + "01";
                        }
                        if (i115 >= 1) {
                            for (i10 = 0; i10 < 8; i10++) {
                                if (str3.charAt(i10) == '1') {
                                    int[] iArr34 = this.f623A;
                                    iArr34[i3] = iArr34[i3] + (128 >> i10);
                                }
                            }
                            i3++;
                        }
                        if (i115 >= 2) {
                            for (i9 = 0; i9 < 8; i9++) {
                                if (str3.charAt(i9 + 8) == '1') {
                                    int[] iArr35 = this.f623A;
                                    iArr35[i3] = iArr35[i3] + (128 >> i9);
                                }
                            }
                            i3++;
                        }
                        if (i115 == 3) {
                            for (i8 = 0; i8 < 8; i8++) {
                                if (str3.charAt(i8 + 16) == '1') {
                                    int[] iArr36 = this.f623A;
                                    iArr36[i3] = iArr36[i3] + (128 >> i8);
                                }
                            }
                            i3++;
                        }
                    } else {
                        i7 = 6;
                    }
                    str3 = str3 + "1111";
                    if (length3 == i7) {
                        str3 = str3 + "01";
                    }
                    if (i115 >= 1) {
                        while (i10 < 8) {
                            if (str3.charAt(i10) == '1') {
                                int[] iArr37 = this.f623A;
                                iArr37[i3] = iArr37[i3] + (128 >> i10);
                            }
                        }
                        i3++;
                    }
                    if (i115 >= 2) {
                        while (i9 < 8) {
                            if (str3.charAt(i9 + 8) == '1') {
                                int[] iArr38 = this.f623A;
                                iArr38[i3] = iArr38[i3] + (128 >> i9);
                            }
                        }
                        i3++;
                    }
                    if (i115 == 3) {
                        while (i8 < 8) {
                            if (str3.charAt(i8 + 16) == '1') {
                                int[] iArr39 = this.f623A;
                                iArr39[i3] = iArr39[i3] + (128 >> i8);
                            }
                        }
                        i3++;
                    }
                }
                if (aVar16 == a.C1_BYTE) {
                    int i116 = i3 - i6;
                    if (i116 <= 249) {
                        for (int i117 = i3; i117 >= i6; i117--) {
                            int[] iArr40 = this.f623A;
                            iArr40[i117 + 1] = iArr40[i117];
                        }
                        this.f623A[i6] = i116;
                        i3++;
                    } else {
                        for (int i118 = i3; i118 >= i6; i118--) {
                            int[] iArr41 = this.f623A;
                            iArr41[i118 + 2] = iArr41[i118];
                        }
                        int[] iArr42 = this.f623A;
                        iArr42[i6] = (i116 / 250) + 249;
                        iArr42[i6 + 1] = i116 % 250;
                        i3 += 2;
                    }
                }
                if (i3 <= 1480) {
                    return i3;
                }
                throw new H("Input data too long");
            }
            i70 = i6;
            aVar15 = aVar16;
            iArr6 = iArr;
            i65 = 1;
            aVar16 = aVarP;
        }
    }

    private static int M(b bVar) {
        switch (bVar.ordinal()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    private boolean N(int i3) {
        boolean z3 = i3 == 13;
        if (i3 == 42) {
            z3 = true;
        }
        if (i3 == 62) {
            z3 = true;
        }
        if (i3 == 32) {
            z3 = true;
        }
        if (i3 >= 48 && i3 <= 57) {
            z3 = true;
        }
        if (i3 < 65 || i3 > 90) {
            return z3;
        }
        return true;
    }

    private void O(int i3) {
        u("Codewords: ");
        for (int i4 = 0; i4 < i3; i4++) {
            y(this.f623A[i4]);
        }
        v();
    }

    /* JADX WARN: Code duplicated, block: B:96:0x0131  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    private a P(int i3, int i4, a aVar) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        a aVar2;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        int i7;
        double d9;
        if (aVar == a.C1_ASCII) {
            d3 = 0.0d;
            d4 = 1.0d;
            d5 = 1.0d;
            d6 = 1.0d;
            d7 = 2.0d;
        } else {
            d3 = 1.0d;
            d4 = 2.0d;
            d5 = 2.0d;
            d6 = 2.0d;
            d7 = 3.0d;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            d8 = 0.0d;
        } else if (iOrdinal == 3) {
            d8 = d4;
            d5 = 0.0d;
        } else if (iOrdinal == 4) {
            d8 = d4;
            d6 = 0.0d;
        } else if (iOrdinal != 5) {
            d8 = d4;
        } else {
            d8 = d4;
            d7 = 0.0d;
        }
        int i8 = i4;
        double d10 = d5;
        double d11 = d6;
        double d12 = d7;
        while (i8 < i3 && i8 <= i4 + 8) {
            int i9 = this.f415n[i8];
            int i10 = i9 <= 127 ? i9 : i9 - 127;
            if (i9 < 48 || i9 > 57) {
                double dX = X(d3);
                d3 = this.f415n[i8] > 127 ? dX + 2.0d : dX + 1.0d;
            } else {
                d3 += 0.5d;
            }
            boolean z5 = false;
            if (i10 == 32) {
                d8 += 0.6666666666666666d;
                z3 = true;
            } else {
                z3 = false;
            }
            if (i10 >= 48 && i10 <= 57) {
                d8 += 0.6666666666666666d;
                z3 = true;
            }
            if (i10 >= 65 && i10 <= 90) {
                d8 += 0.6666666666666666d;
                z3 = true;
            }
            int i11 = this.f415n[i8];
            if (i11 > 127) {
                d8 += 1.3333333333333333d;
            }
            if (!z3) {
                d8 += 1.3333333333333333d;
            }
            if (i10 == 32) {
                d10 += 0.6666666666666666d;
                i5 = 48;
                z4 = true;
            } else {
                i5 = 48;
                z4 = false;
            }
            if (i10 >= i5 && i10 <= 57) {
                d10 += 0.6666666666666666d;
                z4 = true;
            }
            if (i10 >= 97 && i10 <= 122) {
                d10 += 0.6666666666666666d;
                z4 = true;
            }
            if (i11 > 127) {
                d10 += 1.3333333333333333d;
            }
            if (!z4) {
                d10 += 1.3333333333333333d;
            }
            if (i11 == 13) {
                d11 += 0.6666666666666666d;
                z5 = true;
            }
            if (i11 == 42) {
                d11 += 0.6666666666666666d;
                z5 = true;
            }
            if (i11 == 62) {
                d11 += 0.6666666666666666d;
                z5 = true;
            }
            if (i11 == 32) {
                d11 += 0.6666666666666666d;
                i6 = 48;
                z5 = true;
            } else {
                i6 = 48;
            }
            if (i11 < i6 || i11 > 57) {
                i7 = 65;
            } else {
                d11 += 0.6666666666666666d;
                i7 = 65;
                z5 = true;
            }
            if (i11 >= i7 && i11 <= 90) {
                d11 += 0.6666666666666666d;
                z5 = true;
            }
            if (i11 <= 127) {
                d9 = z5 ? 4.333333333333333d : 3.3333333333333335d;
                if (i11 == -1) {
                    d12 += 3.0d;
                } else {
                    d12 += 1.0d;
                }
                i8++;
            }
            d11 += d9;
            if (i11 == -1) {
                d12 += 3.0d;
            } else {
                d12 += 1.0d;
            }
            i8++;
        }
        double dX2 = X(d3);
        double dX3 = X(d8);
        double dX4 = X(d10);
        double dX5 = X(d11);
        double dX6 = X(d12);
        a aVar3 = a.C1_ASCII;
        if (i8 == i3) {
            int i12 = (int) dX5;
            if (dX4 <= i12) {
                i12 = (int) dX4;
                aVar2 = a.C1_TEXT;
            } else {
                aVar2 = aVar3;
            }
            if (dX3 <= i12) {
                i12 = (int) dX3;
                aVar2 = a.C1_C40;
            }
            if (dX2 <= i12) {
                i12 = (int) dX2;
            } else {
                aVar3 = aVar2;
            }
            return dX6 <= ((double) i12) ? a.C1_BYTE : aVar3;
        }
        double d13 = dX5 + 1.0d;
        a aVar4 = (d13 > dX2 || d13 > dX3 || d13 > dX6 || d13 > dX4) ? aVar3 : a.C1_EDI;
        double d14 = dX3 + 1.0d;
        if (d14 <= dX2 && d14 <= dX4) {
            if (dX3 < dX5) {
                aVar4 = a.C1_C40;
            } else if (dX3 == dX5) {
                aVar4 = V(i3, i4) ? a.C1_EDI : a.C1_C40;
            }
        }
        double d15 = dX4 + 1.0d;
        if (d15 <= dX2 && d15 <= dX3 && d15 <= dX6 && d15 <= dX5) {
            aVar4 = a.C1_TEXT;
        }
        double d16 = dX2 + 1.0d;
        if (d16 > dX6 || d16 > dX3 || d16 > dX4 || d16 > dX5) {
            aVar3 = aVar4;
        }
        double d17 = dX6 + 1.0d;
        return (d17 > dX2 || d17 > dX3 || d17 > dX4 || d17 > dX5) ? aVar3 : a.C1_BYTE;
    }

    private void Q(int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 < i5) {
                S((i6 * 2) + i3, 1);
            } else {
                int i7 = (i6 * 2) + i3;
                S(i7, 0);
                if (i6 != i4 - 1) {
                    int i8 = i7 + 1;
                    Y(i8, 1);
                    Y(i8, this.f421t - 2);
                }
            }
        }
    }

    private void R(int i3, int i4, int i5, int i6, int i7, int i8) {
        for (int i9 = i3; i9 < i3 + i5; i9++) {
            for (int i10 = i4; i10 < i4 + i6; i10++) {
                if (this.f624B[i9][i10] == 49) {
                    Y(i9 + i7, i10 + i8);
                }
            }
        }
    }

    private void S(int i3, int i4) {
        if (i4 != 0) {
            for (int i5 = 0; i5 < this.f421t; i5++) {
                Y(i3, i5);
            }
            return;
        }
        for (int i6 = 1; i6 < this.f421t - 1; i6++) {
            Y(i3, i6);
        }
    }

    private void T(int i3) {
        for (int i4 = this.f421t - 1; i4 > 0; i4--) {
            if (this.f625C[i3][i4 - 1]) {
                Y(i3, i4);
            }
        }
    }

    private void U(int i3, int i4, int i5) {
        int i6 = 0;
        if (i5 != 0) {
            while (i6 < i4) {
                Y(i6, i3);
                i6++;
            }
        } else {
            while (i6 < i4) {
                Y((this.f418q - i6) - 1, i3);
                i6++;
            }
        }
    }

    private boolean V(int i3, int i4) {
        int i5;
        int i6 = i4;
        while (true) {
            i5 = i4 + i6;
            if (!N(this.f415n[i5]) || i5 >= i3) {
                break;
            }
            i6++;
        }
        if (i5 == i3) {
            return false;
        }
        int i7 = this.f415n[i5 - 1];
        return i7 == 13 || i7 == 42 || i7 == 62;
    }

    private void W(int i3, int i4) {
        this.f625C[i3][i4] = false;
    }

    private double X(double d3) {
        double d4 = (int) d3;
        Double.isNaN(d4);
        double d5 = d3 - d4;
        return d5 > 0.01d ? (d3 - d5) + 1.0d : d3;
    }

    private void Y(int i3, int i4) {
        this.f625C[i3][i4] = true;
    }

    @Override // E2.Q
    protected void c() {
        int iM;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr2 = new int[600];
        int[] iArr3 = new int[2100];
        int length = this.f413l.length();
        O o3 = new O();
        int[] iArr4 = new int[190];
        StringBuilder sb = new StringBuilder();
        if (!this.f413l.matches("[\u0000-ÿ]+")) {
            throw new H("Invalid characters in input data");
        }
        if (this.f626z == b.S) {
            w("Version: S");
            if (length > 18) {
                throw new H("Input data too long");
            }
            if (!this.f413l.matches("[0-9]+?")) {
                throw new H("Invalid characters in input");
            }
            if (length <= 12) {
                i3 = 2;
                i10 = 8;
                i11 = 4;
            } else {
                i3 = 3;
                i10 = 12;
                i11 = 6;
            }
            if (length <= 6) {
                i12 = 2;
                i3 = 1;
                i10 = 4;
            } else {
                i12 = i11;
            }
            BigInteger bigInteger = new BigInteger(this.f413l);
            for (int i13 = 0; i13 < i10; i13++) {
                this.f623A[(i10 - i13) - 1] = bigInteger.shiftRight(i13 * 5).and(BigInteger.valueOf(31L)).intValue();
            }
            O(i10);
            o3.d(37);
            o3.c(i10, 1);
            o3.a(i10, this.f623A);
            w("ECC Codeword Count: " + i10);
            for (int i14 = 0; i14 < i10; i14++) {
                iArr3[i14] = this.f623A[i14];
                iArr3[i14 + i10] = o3.b((i10 - i14) - 1);
            }
            for (int i15 = 0; i15 < 136; i15++) {
                for (int i16 = 0; i16 < 120; i16++) {
                    this.f624B[i15][i16] = 48;
                }
            }
            int i17 = 0;
            for (int i18 = 0; i18 < 2; i18++) {
                for (int i19 = 0; i19 < i12; i19++) {
                    if ((iArr3[i17] & 16) != 0) {
                        this.f624B[i18 * 2][i19 * 5] = 49;
                    }
                    if ((iArr3[i17] & 8) != 0) {
                        this.f624B[i18 * 2][(i19 * 5) + 1] = 49;
                    }
                    if ((iArr3[i17] & 4) != 0) {
                        this.f624B[i18 * 2][(i19 * 5) + 2] = 49;
                    }
                    if ((iArr3[i17] & 2) != 0) {
                        this.f624B[(i18 * 2) + 1][i19 * 5] = 49;
                    }
                    if ((iArr3[i17] & 1) != 0) {
                        this.f624B[(i18 * 2) + 1][(i19 * 5) + 1] = 49;
                    }
                    int i20 = i17 + 1;
                    if ((iArr3[i20] & 16) != 0) {
                        this.f624B[i18 * 2][(i19 * 5) + 3] = 49;
                    }
                    if ((iArr3[i20] & 8) != 0) {
                        this.f624B[i18 * 2][(i19 * 5) + 4] = 49;
                    }
                    if ((iArr3[i20] & 4) != 0) {
                        this.f624B[(i18 * 2) + 1][(i19 * 5) + 2] = 49;
                    }
                    if ((iArr3[i20] & 2) != 0) {
                        this.f624B[(i18 * 2) + 1][(i19 * 5) + 3] = 49;
                    }
                    if ((iArr3[i20] & 1) != 0) {
                        this.f624B[(i18 * 2) + 1][(i19 * 5) + 4] = 49;
                    }
                    i17 += 2;
                }
            }
            w("Grid Size: " + i12 + " X 2");
            this.f418q = 8;
            this.f421t = (i3 * 10) + 1;
            iM = 9;
        } else {
            iM = 1;
            i3 = 0;
        }
        int i21 = 10;
        if (this.f626z == b.T) {
            w("Version: T");
            for (int i22 = 0; i22 < 40; i22++) {
                this.f623A[i22] = 0;
            }
            int iL = L();
            if (iL > 38) {
                throw new H("Input data too long");
            }
            if (iL <= 24) {
                i6 = 24;
                i7 = 2;
                i8 = 8;
                i9 = 16;
            } else {
                i6 = 38;
                i7 = 3;
                i8 = 12;
                i9 = 22;
            }
            if (iL <= 10) {
                i6 = 10;
                i7 = 1;
                i8 = 4;
            } else {
                i21 = i9;
            }
            O(iL);
            while (iL < i6) {
                this.f623A[iL] = 129;
                iL++;
            }
            o3.d(301);
            o3.c(i21, 1);
            o3.a(i6, this.f623A);
            w("ECC Codeword Count: " + i21);
            for (int i23 = 0; i23 < i6; i23++) {
                iArr3[i23] = this.f623A[i23];
            }
            for (int i24 = 0; i24 < i21; i24++) {
                iArr3[i6 + i24] = o3.b((i21 - i24) - 1);
            }
            for (int i25 = 0; i25 < 136; i25++) {
                for (int i26 = 0; i26 < 120; i26++) {
                    this.f624B[i25][i26] = 48;
                }
            }
            int i27 = 0;
            for (int i28 = 0; i28 < 5; i28++) {
                for (int i29 = 0; i29 < i8; i29++) {
                    if ((iArr3[i27] & 128) != 0) {
                        this.f624B[i28 * 2][i29 * 4] = 49;
                    }
                    if ((iArr3[i27] & 64) != 0) {
                        this.f624B[i28 * 2][(i29 * 4) + 1] = 49;
                    }
                    if ((iArr3[i27] & 32) != 0) {
                        this.f624B[i28 * 2][(i29 * 4) + 2] = 49;
                    }
                    if ((iArr3[i27] & 16) != 0) {
                        this.f624B[i28 * 2][(i29 * 4) + 3] = 49;
                    }
                    if ((iArr3[i27] & 8) != 0) {
                        this.f624B[(i28 * 2) + 1][i29 * 4] = 49;
                    }
                    if ((iArr3[i27] & 4) != 0) {
                        this.f624B[(i28 * 2) + 1][(i29 * 4) + 1] = 49;
                    }
                    if ((iArr3[i27] & 2) != 0) {
                        this.f624B[(i28 * 2) + 1][(i29 * 4) + 2] = 49;
                    }
                    if ((iArr3[i27] & 1) != 0) {
                        this.f624B[(i28 * 2) + 1][(i29 * 4) + 3] = 49;
                    }
                    i27++;
                }
            }
            w("Grid Size: " + i8 + " X 5");
            this.f418q = 16;
            this.f421t = (i7 * 16) + 1;
            i3 = i7;
            iM = 10;
        }
        b bVar = this.f626z;
        if (bVar != b.S && bVar != b.T) {
            for (int i30 = 0; i30 < 1500; i30++) {
                this.f623A[i30] = 0;
            }
            int iL2 = L();
            for (int i31 = 7; i31 >= 0; i31--) {
                if (f616J[i31] >= iL2) {
                    iM = i31 + 1;
                }
            }
            if (M(this.f626z) > iM) {
                iM = M(this.f626z);
            }
            int i32 = iM - 1;
            w("Version: " + ((char) (iM + 64)));
            O(iL2);
            while (true) {
                i4 = f616J[i32];
                if (iL2 >= i4) {
                    break;
                }
                this.f623A[iL2] = 129;
                iL2++;
            }
            int i33 = f618L[i32];
            o3.d(301);
            o3.c(f620N[i32], 0);
            for (int i34 = 0; i34 < i33; i34++) {
                int i35 = 0;
                while (true) {
                    i5 = f619M[i32];
                    if (i35 >= i5) {
                        break;
                    }
                    iArr4[i35] = this.f623A[(i35 * i33) + i34];
                    i35++;
                }
                o3.a(i5, iArr4);
                for (int i36 = 0; i36 < f620N[i32]; i36++) {
                    iArr2[(f617K[i32] - ((i36 * i33) + i34)) - 1] = o3.b(i36);
                }
            }
            w("ECC Codeword Count: " + f617K[i32]);
            for (int i37 = 0; i37 < i4; i37++) {
                iArr3[i37] = this.f623A[i37];
            }
            for (int i38 = 0; i38 < f617K[i32]; i38++) {
                iArr3[i4 + i38] = iArr2[i38];
            }
            for (int i39 = 0; i39 < 136; i39++) {
                for (int i40 = 0; i40 < 120; i40++) {
                    this.f624B[i39][i40] = 48;
                }
            }
            int i41 = 0;
            int i42 = 0;
            while (true) {
                iArr = f622P;
                if (i41 >= iArr[i32]) {
                    break;
                }
                for (int i43 = 0; i43 < f621O[i32]; i43++) {
                    if ((iArr3[i42] & 128) != 0) {
                        this.f624B[i41 * 2][i43 * 4] = 49;
                    }
                    if ((iArr3[i42] & 64) != 0) {
                        this.f624B[i41 * 2][(i43 * 4) + 1] = 49;
                    }
                    if ((iArr3[i42] & 32) != 0) {
                        this.f624B[i41 * 2][(i43 * 4) + 2] = 49;
                    }
                    if ((iArr3[i42] & 16) != 0) {
                        this.f624B[i41 * 2][(i43 * 4) + 3] = 49;
                    }
                    if ((iArr3[i42] & 8) != 0) {
                        this.f624B[(i41 * 2) + 1][i43 * 4] = 49;
                    }
                    if ((iArr3[i42] & 4) != 0) {
                        this.f624B[(i41 * 2) + 1][(i43 * 4) + 1] = 49;
                    }
                    if ((iArr3[i42] & 2) != 0) {
                        this.f624B[(i41 * 2) + 1][(i43 * 4) + 2] = 49;
                    }
                    if ((iArr3[i42] & 1) != 0) {
                        this.f624B[(i41 * 2) + 1][(i43 * 4) + 3] = 49;
                    }
                    i42++;
                }
                i41++;
            }
            w("Grid Size: " + f621O[i32] + " X " + iArr[i32]);
            this.f418q = f614H[i32];
            this.f421t = f615I[i32];
        }
        for (int i44 = 0; i44 < 148; i44++) {
            for (int i45 = 0; i45 < 134; i45++) {
                this.f625C[i44][i45] = false;
            }
        }
        switch (iM) {
            case 1:
                Q(6, 3, 1);
                U(4, 6, 1);
                U(12, 5, 0);
                Y(5, 12);
                T(0);
                T(15);
                R(0, 0, 5, 4, 0, 0);
                R(0, 4, 5, 12, 0, 2);
                R(5, 0, 5, 12, 6, 0);
                R(5, 12, 5, 4, 6, 2);
                break;
            case 2:
                Q(8, 4, 1);
                U(4, 8, 1);
                U(16, 7, 0);
                Y(7, 16);
                T(0);
                T(21);
                R(0, 0, 7, 4, 0, 0);
                R(0, 4, 7, 16, 0, 2);
                R(7, 0, 7, 16, 8, 0);
                R(7, 16, 7, 4, 8, 2);
                break;
            case 3:
                Q(11, 4, 2);
                U(4, 11, 1);
                U(26, 13, 1);
                U(4, 10, 0);
                U(26, 10, 0);
                T(0);
                T(27);
                R(0, 0, 10, 4, 0, 0);
                R(0, 4, 10, 20, 0, 2);
                R(0, 24, 10, 4, 0, 4);
                R(10, 0, 10, 4, 8, 0);
                R(10, 4, 10, 20, 8, 2);
                R(10, 24, 10, 4, 8, 4);
                break;
            case 4:
                Q(16, 5, 1);
                U(4, 16, 1);
                U(20, 16, 1);
                U(36, 16, 1);
                U(4, 15, 0);
                U(20, 15, 0);
                U(36, 15, 0);
                T(0);
                T(12);
                T(27);
                T(39);
                R(0, 0, 15, 4, 0, 0);
                R(0, 4, 15, 14, 0, 2);
                R(0, 18, 15, 14, 0, 4);
                R(0, 32, 15, 4, 0, 6);
                R(15, 0, 15, 4, 10, 0);
                R(15, 4, 15, 14, 10, 2);
                R(15, 18, 15, 14, 10, 4);
                R(15, 32, 15, 4, 10, 6);
                break;
            case 5:
                Q(22, 5, 2);
                U(4, 22, 1);
                U(26, 24, 1);
                U(48, 22, 1);
                U(4, 21, 0);
                U(26, 21, 0);
                U(48, 21, 0);
                T(0);
                T(12);
                T(39);
                T(51);
                R(0, 0, 21, 4, 0, 0);
                R(0, 4, 21, 20, 0, 2);
                R(0, 24, 21, 20, 0, 4);
                R(0, 44, 21, 4, 0, 6);
                R(21, 0, 21, 4, 10, 0);
                R(21, 4, 21, 20, 10, 2);
                R(21, 24, 21, 20, 10, 4);
                R(21, 44, 21, 4, 10, 6);
                break;
            case 6:
                Q(31, 5, 3);
                U(4, 31, 1);
                U(26, 35, 1);
                U(48, 31, 1);
                U(70, 35, 1);
                U(4, 30, 0);
                U(26, 30, 0);
                U(48, 30, 0);
                U(70, 30, 0);
                T(0);
                T(12);
                T(24);
                T(45);
                T(57);
                T(69);
                R(0, 0, 30, 4, 0, 0);
                R(0, 4, 30, 20, 0, 2);
                R(0, 24, 30, 20, 0, 4);
                R(0, 44, 30, 20, 0, 6);
                R(0, 64, 30, 4, 0, 8);
                R(30, 0, 30, 4, 10, 0);
                R(30, 4, 30, 20, 10, 2);
                R(30, 24, 30, 20, 10, 4);
                R(30, 44, 30, 20, 10, 6);
                R(30, 64, 30, 4, 10, 8);
                break;
            case 7:
                Q(47, 6, 2);
                U(6, 47, 1);
                U(27, 49, 1);
                U(48, 47, 1);
                U(69, 49, 1);
                U(90, 47, 1);
                U(6, 46, 0);
                U(27, 46, 0);
                U(48, 46, 0);
                U(69, 46, 0);
                U(90, 46, 0);
                T(0);
                T(12);
                T(24);
                T(36);
                T(67);
                T(79);
                T(91);
                T(103);
                R(0, 0, 46, 6, 0, 0);
                R(0, 6, 46, 19, 0, 2);
                R(0, 25, 46, 19, 0, 4);
                R(0, 44, 46, 19, 0, 6);
                R(0, 63, 46, 19, 0, 8);
                R(0, 82, 46, 6, 0, 10);
                R(46, 0, 46, 6, 12, 0);
                R(46, 6, 46, 19, 12, 2);
                R(46, 25, 46, 19, 12, 4);
                R(46, 44, 46, 19, 12, 6);
                R(46, 63, 46, 19, 12, 8);
                R(46, 82, 46, 6, 12, 10);
                break;
            case 8:
                Q(69, 6, 3);
                U(6, 69, 1);
                U(26, 73, 1);
                U(46, 69, 1);
                U(66, 73, 1);
                U(86, 69, 1);
                U(106, 73, 1);
                U(126, 69, 1);
                U(6, 68, 0);
                U(26, 68, 0);
                U(46, 68, 0);
                U(66, 68, 0);
                U(86, 68, 0);
                U(106, 68, 0);
                U(126, 68, 0);
                T(0);
                T(12);
                T(24);
                T(36);
                T(48);
                T(60);
                T(87);
                T(99);
                T(111);
                T(123);
                T(135);
                T(147);
                R(0, 0, 68, 6, 0, 0);
                R(0, 6, 68, 18, 0, 2);
                R(0, 24, 68, 18, 0, 4);
                R(0, 42, 68, 18, 0, 6);
                R(0, 60, 68, 18, 0, 8);
                R(0, 78, 68, 18, 0, 10);
                R(0, 96, 68, 18, 0, 12);
                R(0, 114, 68, 6, 0, 14);
                R(68, 0, 68, 6, 12, 0);
                R(68, 6, 68, 18, 12, 2);
                R(68, 24, 68, 18, 12, 4);
                R(68, 42, 68, 18, 12, 6);
                R(68, 60, 68, 18, 12, 8);
                R(68, 78, 68, 18, 12, 10);
                R(68, 96, 68, 18, 12, 12);
                R(68, 114, 68, 6, 12, 14);
                break;
            case 9:
                S(5, 1);
                S(7, 1);
                Y(6, 0);
                Y(6, this.f421t - 1);
                W(7, 1);
                W(7, this.f421t - 2);
                if (i3 == 1) {
                    Y(0, 5);
                    R(0, 0, 4, 5, 0, 0);
                    R(0, 5, 4, 5, 0, 1);
                } else if (i3 == 2) {
                    Y(0, 10);
                    Y(4, 10);
                    R(0, 0, 4, 10, 0, 0);
                    R(0, 10, 4, 10, 0, 1);
                } else if (i3 == 3) {
                    Y(0, 15);
                    Y(4, 15);
                    Y(6, 15);
                    R(0, 0, 4, 15, 0, 0);
                    R(0, 15, 4, 15, 0, 1);
                }
                break;
            case 10:
                S(11, 1);
                S(13, 1);
                S(15, 1);
                Y(12, 0);
                Y(12, this.f421t - 1);
                Y(14, 0);
                Y(14, this.f421t - 1);
                W(13, 1);
                W(13, this.f421t - 2);
                W(15, 1);
                W(15, this.f421t - 2);
                if (i3 == 1) {
                    Y(0, 8);
                    Y(10, 8);
                    R(0, 0, 10, 8, 0, 0);
                    R(0, 8, 10, 8, 0, 1);
                } else if (i3 == 2) {
                    Y(0, 16);
                    Y(10, 16);
                    Y(12, 16);
                    R(0, 0, 10, 16, 0, 0);
                    R(0, 16, 10, 16, 0, 1);
                } else if (i3 == 3) {
                    Y(0, 24);
                    Y(10, 24);
                    Y(12, 24);
                    Y(14, 24);
                    R(0, 0, 10, 24, 0, 0);
                    R(0, 24, 10, 24, 0, 1);
                }
                break;
        }
        this.f416o = "";
        int i46 = this.f418q;
        this.f417p = new String[i46];
        this.f419r = new int[i46];
        for (int i47 = 0; i47 < this.f418q; i47++) {
            sb.setLength(0);
            for (int i48 = 0; i48 < this.f421t; i48++) {
                if (this.f625C[i47][i48]) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            this.f417p[i47] = Q.a(sb);
            this.f419r[i47] = 1;
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }
}
