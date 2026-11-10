package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0430h1 implements InterfaceC0456p1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f7431o = new int[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Unsafe f7432p = E1.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f7433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f7434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InterfaceC0418e1 f7437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f7438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f7439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f7440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final U0 f7442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AbstractC0470u1 f7443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AbstractC0463s0 f7444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final C0438j1 f7445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Z0 f7446n;

    private C0430h1(int[] iArr, Object[] objArr, int i3, int i4, InterfaceC0418e1 interfaceC0418e1, int i5, boolean z3, int[] iArr2, int i6, int i7, C0438j1 c0438j1, U0 u3, AbstractC0470u1 abstractC0470u1, AbstractC0463s0 abstractC0463s0, Z0 z4) {
        this.f7433a = iArr;
        this.f7434b = objArr;
        this.f7435c = i3;
        this.f7436d = i4;
        boolean z5 = false;
        if (abstractC0463s0 != null && abstractC0463s0.c(interfaceC0418e1)) {
            z5 = true;
        }
        this.f7438f = z5;
        this.f7439g = iArr2;
        this.f7440h = i6;
        this.f7441i = i7;
        this.f7445m = c0438j1;
        this.f7442j = u3;
        this.f7443k = abstractC0470u1;
        this.f7444l = abstractC0463s0;
        this.f7437e = interfaceC0418e1;
        this.f7446n = z4;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    static C0430h1 A(Class cls, InterfaceC0406b1 interfaceC0406b1, C0438j1 c0438j1, U0 u3, AbstractC0470u1 abstractC0470u1, AbstractC0463s0 abstractC0463s0, Z0 z3) {
        int i3;
        int iCharAt;
        int iCharAt2;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        int i11;
        char cCharAt3;
        int i12;
        char cCharAt4;
        int i13;
        char cCharAt5;
        int i14;
        char cCharAt6;
        int i15;
        char cCharAt7;
        int i16;
        char cCharAt8;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int i21;
        int iObjectFieldOffset2;
        Field fieldO;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldO2;
        int i27;
        Object obj2;
        Field fieldO3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(interfaceC0406b1 instanceof C0453o1)) {
            androidx.appcompat.app.H.a(interfaceC0406b1);
            throw null;
        }
        C0453o1 c0453o1 = (C0453o1) interfaceC0406b1;
        String strD = c0453o1.d();
        int length = strD.length();
        char c3 = 55296;
        if (strD.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i3 = i32 + 1;
                if (strD.charAt(i32) < 55296) {
                    break;
                }
                i32 = i3;
            }
        } else {
            i3 = 1;
        }
        int i33 = i3 + 1;
        int iCharAt3 = strD.charAt(i3);
        if (iCharAt3 >= 55296) {
            int i34 = iCharAt3 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strD.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt3 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt3 == 0) {
            iArr = f7431o;
            i7 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i5 = 0;
            i8 = 0;
            i4 = 0;
            i6 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt4 = strD.charAt(i33);
            if (iCharAt4 >= 55296) {
                int i37 = iCharAt4 & 8191;
                int i38 = 13;
                while (true) {
                    i16 = i36 + 1;
                    cCharAt8 = strD.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i16;
                }
                iCharAt4 = i37 | (cCharAt8 << i38);
                i36 = i16;
            }
            int i39 = i36 + 1;
            int iCharAt5 = strD.charAt(i36);
            if (iCharAt5 >= 55296) {
                int i40 = iCharAt5 & 8191;
                int i41 = 13;
                while (true) {
                    i15 = i39 + 1;
                    cCharAt7 = strD.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i15;
                }
                iCharAt5 = i40 | (cCharAt7 << i41);
                i39 = i15;
            }
            int i42 = i39 + 1;
            int iCharAt6 = strD.charAt(i39);
            if (iCharAt6 >= 55296) {
                int i43 = iCharAt6 & 8191;
                int i44 = 13;
                while (true) {
                    i14 = i42 + 1;
                    cCharAt6 = strD.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i14;
                }
                iCharAt6 = i43 | (cCharAt6 << i44);
                i42 = i14;
            }
            int i45 = i42 + 1;
            int iCharAt7 = strD.charAt(i42);
            if (iCharAt7 >= 55296) {
                int i46 = iCharAt7 & 8191;
                int i47 = 13;
                while (true) {
                    i13 = i45 + 1;
                    cCharAt5 = strD.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i13;
                }
                iCharAt7 = i46 | (cCharAt5 << i47);
                i45 = i13;
            }
            int i48 = i45 + 1;
            iCharAt = strD.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i12 = i48 + 1;
                    cCharAt4 = strD.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i12;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i12;
            }
            int i51 = i48 + 1;
            iCharAt2 = strD.charAt(i48);
            if (iCharAt2 >= 55296) {
                int i52 = iCharAt2 & 8191;
                int i53 = 13;
                while (true) {
                    i11 = i51 + 1;
                    cCharAt3 = strD.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i11;
                }
                iCharAt2 = i52 | (cCharAt3 << i53);
                i51 = i11;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strD.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i10 = i54 + 1;
                    cCharAt2 = strD.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i10;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i10;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strD.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i9 = i57 + 1;
                    cCharAt = strD.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i9;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i9;
            }
            i4 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i5 = iCharAt6;
            i6 = iCharAt9;
            i7 = iCharAt4;
            i8 = iCharAt7;
            i33 = i57;
        }
        Unsafe unsafe = f7432p;
        Object[] objArrE = c0453o1.e();
        Class<?> cls2 = c0453o1.c().getClass();
        int i60 = i6 + iCharAt2;
        int i61 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i61];
        int i62 = i6;
        int i63 = i60;
        int i64 = 0;
        int i65 = 0;
        while (i33 < length) {
            int i66 = i33 + 1;
            int iCharAt10 = strD.charAt(i33);
            if (iCharAt10 >= c3) {
                int i67 = iCharAt10 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i30 = i68 + 1;
                    cCharAt12 = strD.charAt(i68);
                    if (cCharAt12 < c3) {
                        break;
                    }
                    i67 |= (cCharAt12 & 8191) << i69;
                    i69 += 13;
                    i68 = i30;
                }
                iCharAt10 = i67 | (cCharAt12 << i69);
                i17 = i30;
            } else {
                i17 = i66;
            }
            int i70 = i17 + 1;
            int iCharAt11 = strD.charAt(i17);
            if (iCharAt11 >= c3) {
                int i71 = iCharAt11 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i29 = i72 + 1;
                    cCharAt11 = strD.charAt(i72);
                    if (cCharAt11 < c3) {
                        break;
                    }
                    i71 |= (cCharAt11 & 8191) << i73;
                    i73 += 13;
                    i72 = i29;
                }
                iCharAt11 = i71 | (cCharAt11 << i73);
                i18 = i29;
            } else {
                i18 = i70;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i65;
                i64++;
            }
            int i74 = iCharAt11 & 255;
            int i75 = iCharAt11 & 2048;
            int i76 = length;
            if (i74 >= 51) {
                int i77 = i18 + 1;
                int iCharAt12 = strD.charAt(i18);
                char c4 = 55296;
                if (iCharAt12 >= 55296) {
                    int i78 = 13;
                    int i79 = iCharAt12 & 8191;
                    int i80 = i77;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strD.charAt(i80);
                        if (cCharAt10 < c4) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i80 = i28;
                        c4 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i78);
                    i24 = i28;
                } else {
                    i24 = i77;
                }
                int i81 = i24;
                int i82 = i74 - 51;
                if (i82 == 9 || i82 == 17) {
                    i25 = i4 + 1;
                    int i83 = i65 / 3;
                    objArr[i83 + i83 + 1] = objArrE[i4];
                } else {
                    if (i82 == 12) {
                        if (c0453o1.b() == 1 || i75 != 0) {
                            i25 = i4 + 1;
                            int i84 = i65 / 3;
                            objArr[i84 + i84 + 1] = objArrE[i4];
                        } else {
                            i75 = 0;
                        }
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrE[i26];
                    if (obj instanceof Field) {
                        fieldO2 = (Field) obj;
                    } else {
                        fieldO2 = O(cls2, (String) obj);
                        objArrE[i26] = fieldO2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO2);
                    i27 = i26 + 1;
                    obj2 = objArrE[i27];
                    if (obj2 instanceof Field) {
                        fieldO3 = (Field) obj2;
                    } else {
                        fieldO3 = O(cls2, (String) obj2);
                        objArrE[i27] = fieldO3;
                    }
                    c0453o1 = c0453o1;
                    strD = strD;
                    i21 = i4;
                    i19 = i81;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO3);
                    i20 = 0;
                }
                i4 = i25;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrE[i26];
                if (obj instanceof Field) {
                    fieldO2 = (Field) obj;
                } else {
                    fieldO2 = O(cls2, (String) obj);
                    objArrE[i26] = fieldO2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO2);
                i27 = i26 + 1;
                obj2 = objArrE[i27];
                if (obj2 instanceof Field) {
                    fieldO3 = (Field) obj2;
                } else {
                    fieldO3 = O(cls2, (String) obj2);
                    objArrE[i27] = fieldO3;
                }
                c0453o1 = c0453o1;
                strD = strD;
                i21 = i4;
                i19 = i81;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO3);
                i20 = 0;
            } else {
                int i85 = i4 + 1;
                Field fieldO4 = O(cls2, (String) objArrE[i4]);
                if (i74 == 9 || i74 == 17) {
                    c0453o1 = c0453o1;
                    int i86 = i65 / 3;
                    objArr[i86 + i86 + 1] = fieldO4.getType();
                } else {
                    if (i74 == 27) {
                        i22 = 1;
                        i23 = i4 + 2;
                    } else if (i74 == 49) {
                        i23 = i4 + 2;
                        i22 = 1;
                    } else if (i74 == 12 || i74 == 30 || i74 == 44) {
                        c0453o1 = c0453o1;
                        if (c0453o1.b() == 1 || i75 != 0) {
                            i23 = i4 + 2;
                            int i87 = i65 / 3;
                            objArr[i87 + i87 + 1] = objArrE[i85];
                            i85 = i23;
                        } else {
                            i75 = 0;
                        }
                    } else {
                        if (i74 == 50) {
                            int i88 = i4 + 2;
                            int i89 = i62 + 1;
                            iArr[i62] = i65;
                            int i90 = i65 / 3;
                            int i91 = i90 + i90;
                            objArr[i91] = objArrE[i85];
                            if (i75 != 0) {
                                i85 = i4 + 3;
                                objArr[i91 + 1] = objArrE[i88];
                                i62 = i89;
                            } else {
                                i85 = i88;
                                i62 = i89;
                                i75 = 0;
                            }
                        }
                        c0453o1 = c0453o1;
                    }
                    int i92 = i65 / 3;
                    objArr[i92 + i92 + i22] = objArrE[i85];
                    i85 = i23;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i74 > 17) {
                    i19 = i18;
                    i20 = 0;
                } else {
                    int i93 = i18 + 1;
                    int iCharAt13 = strD.charAt(i18);
                    if (iCharAt13 >= 55296) {
                        int i94 = iCharAt13 & 8191;
                        int i95 = 13;
                        while (true) {
                            i19 = i93 + 1;
                            cCharAt9 = strD.charAt(i93);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i94 |= (cCharAt9 & 8191) << i95;
                            i95 += 13;
                            i93 = i19;
                        }
                        iCharAt13 = i94 | (cCharAt9 << i95);
                    } else {
                        i19 = i93;
                    }
                    int i96 = i7 + i7 + (iCharAt13 / 32);
                    Object obj3 = objArrE[i96];
                    if (obj3 instanceof Field) {
                        fieldO = (Field) obj3;
                    } else {
                        fieldO = O(cls2, (String) obj3);
                        objArrE[i96] = fieldO;
                    }
                    i20 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO);
                }
                if (i74 >= 18 && i74 <= 49) {
                    iArr[i63] = iObjectFieldOffset3;
                    i63++;
                }
                i21 = i85;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i97 = i65 + 1;
            iArr2[i65] = iCharAt10;
            int i98 = i65 + 2;
            iArr2[i97] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i75 != 0 ? Integer.MIN_VALUE : 0) | (i74 << 20);
            i65 += 3;
            iArr2[i98] = (i20 << 20) | iObjectFieldOffset;
            i4 = i21;
            i33 = i19;
            length = i76;
            c0453o1 = c0453o1;
            strD = strD;
            i8 = i8;
            i5 = i5;
            c3 = 55296;
        }
        C0453o1 c0453o2 = c0453o1;
        return new C0430h1(iArr2, objArr, i5, i8, c0453o2.c(), c0453o2.b(), false, iArr, i6, i60, c0438j1, u3, abstractC0470u1, abstractC0463s0, z3);
    }

    private static double B(Object obj, long j3) {
        return ((Double) E1.k(obj, j3)).doubleValue();
    }

    private static float C(Object obj, long j3) {
        return ((Float) E1.k(obj, j3)).floatValue();
    }

    private static int D(Object obj, long j3) {
        return ((Integer) E1.k(obj, j3)).intValue();
    }

    private final int E(int i3) {
        return this.f7433a[i3 + 2];
    }

    private final int F(int i3, int i4) {
        int length = (this.f7433a.length / 3) - 1;
        while (i4 <= length) {
            int i5 = (length + i4) >>> 1;
            int i6 = i5 * 3;
            int i7 = this.f7433a[i6];
            if (i3 == i7) {
                return i6;
            }
            if (i3 < i7) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        return -1;
    }

    private static int G(int i3) {
        return (i3 >>> 20) & 255;
    }

    private final int H(int i3) {
        return this.f7433a[i3 + 1];
    }

    private static long I(Object obj, long j3) {
        return ((Long) E1.k(obj, j3)).longValue();
    }

    private final F0 J(int i3) {
        int i4 = i3 / 3;
        return (F0) this.f7434b[i4 + i4 + 1];
    }

    private final InterfaceC0456p1 K(int i3) {
        Object[] objArr = this.f7434b;
        int i4 = i3 / 3;
        int i5 = i4 + i4;
        InterfaceC0456p1 interfaceC0456p1 = (InterfaceC0456p1) objArr[i5];
        if (interfaceC0456p1 != null) {
            return interfaceC0456p1;
        }
        InterfaceC0456p1 interfaceC0456p1B = C0447m1.a().b((Class) objArr[i5 + 1]);
        this.f7434b[i5] = interfaceC0456p1B;
        return interfaceC0456p1B;
    }

    private final Object L(int i3) {
        int i4 = i3 / 3;
        return this.f7434b[i4 + i4];
    }

    private final Object M(Object obj, int i3) {
        InterfaceC0456p1 interfaceC0456p1K = K(i3);
        int iH = H(i3) & 1048575;
        if (!r(obj, i3)) {
            return interfaceC0456p1K.c();
        }
        Object object = f7432p.getObject(obj, iH);
        if (u(object)) {
            return object;
        }
        Object objC = interfaceC0456p1K.c();
        if (object != null) {
            interfaceC0456p1K.e(objC, object);
        }
        return objC;
    }

    private final Object N(Object obj, int i3, int i4) {
        InterfaceC0456p1 interfaceC0456p1K = K(i4);
        if (!v(obj, i3, i4)) {
            return interfaceC0456p1K.c();
        }
        Object object = f7432p.getObject(obj, H(i4) & 1048575);
        if (u(object)) {
            return object;
        }
        Object objC = interfaceC0456p1K.c();
        if (object != null) {
            interfaceC0456p1K.e(objC, object);
        }
        return objC;
    }

    private static Field O(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void j(Object obj) {
        if (!u(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void k(Object obj, Object obj2, int i3) {
        if (r(obj2, i3)) {
            int iH = H(i3) & 1048575;
            Unsafe unsafe = f7432p;
            long j3 = iH;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f7433a[i3] + " is present but null: " + obj2.toString());
            }
            InterfaceC0456p1 interfaceC0456p1K = K(i3);
            if (!r(obj, i3)) {
                if (u(object)) {
                    Object objC = interfaceC0456p1K.c();
                    interfaceC0456p1K.e(objC, object);
                    unsafe.putObject(obj, j3, objC);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                m(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!u(object2)) {
                Object objC2 = interfaceC0456p1K.c();
                interfaceC0456p1K.e(objC2, object2);
                unsafe.putObject(obj, j3, objC2);
                object2 = objC2;
            }
            interfaceC0456p1K.e(object2, object);
        }
    }

    private final void l(Object obj, Object obj2, int i3) {
        int i4 = this.f7433a[i3];
        if (v(obj2, i4, i3)) {
            int iH = H(i3) & 1048575;
            Unsafe unsafe = f7432p;
            long j3 = iH;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f7433a[i3] + " is present but null: " + obj2.toString());
            }
            InterfaceC0456p1 interfaceC0456p1K = K(i3);
            if (!v(obj, i4, i3)) {
                if (u(object)) {
                    Object objC = interfaceC0456p1K.c();
                    interfaceC0456p1K.e(objC, object);
                    unsafe.putObject(obj, j3, objC);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                n(obj, i4, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!u(object2)) {
                Object objC2 = interfaceC0456p1K.c();
                interfaceC0456p1K.e(objC2, object2);
                unsafe.putObject(obj, j3, objC2);
                object2 = objC2;
            }
            interfaceC0456p1K.e(object2, object);
        }
    }

    private final void m(Object obj, int i3) {
        int iE = E(i3);
        long j3 = 1048575 & iE;
        if (j3 == 1048575) {
            return;
        }
        E1.v(obj, j3, (1 << (iE >>> 20)) | E1.h(obj, j3));
    }

    private final void n(Object obj, int i3, int i4) {
        E1.v(obj, E(i4) & 1048575, i3);
    }

    private final void o(Object obj, int i3, Object obj2) {
        f7432p.putObject(obj, H(i3) & 1048575, obj2);
        m(obj, i3);
    }

    private final void p(Object obj, int i3, int i4, Object obj2) {
        f7432p.putObject(obj, H(i4) & 1048575, obj2);
        n(obj, i3, i4);
    }

    private final boolean q(Object obj, Object obj2, int i3) {
        return r(obj, i3) == r(obj2, i3);
    }

    private final boolean r(Object obj, int i3) {
        int iE = E(i3);
        long j3 = iE & 1048575;
        if (j3 != 1048575) {
            return (E1.h(obj, j3) & (1 << (iE >>> 20))) != 0;
        }
        int iH = H(i3);
        long j4 = iH & 1048575;
        switch (G(iH)) {
            case 0:
                return Double.doubleToRawLongBits(E1.f(obj, j4)) != 0;
            case 1:
                return Float.floatToRawIntBits(E1.g(obj, j4)) != 0;
            case 2:
                return E1.i(obj, j4) != 0;
            case 3:
                return E1.i(obj, j4) != 0;
            case 4:
                return E1.h(obj, j4) != 0;
            case 5:
                return E1.i(obj, j4) != 0;
            case 6:
                return E1.h(obj, j4) != 0;
            case 7:
                return E1.B(obj, j4);
            case 8:
                Object objK = E1.k(obj, j4);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof AbstractC0421f0) {
                    return !AbstractC0421f0.f7421b.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return E1.k(obj, j4) != null;
            case 10:
                return !AbstractC0421f0.f7421b.equals(E1.k(obj, j4));
            case 11:
                return E1.h(obj, j4) != 0;
            case 12:
                return E1.h(obj, j4) != 0;
            case 13:
                return E1.h(obj, j4) != 0;
            case 14:
                return E1.i(obj, j4) != 0;
            case 15:
                return E1.h(obj, j4) != 0;
            case 16:
                return E1.i(obj, j4) != 0;
            case 17:
                return E1.k(obj, j4) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean s(Object obj, int i3, int i4, int i5, int i6) {
        if (i4 == 1048575) {
            return r(obj, i3);
        }
        return (i5 & i6) != 0;
    }

    private static boolean t(Object obj, int i3, InterfaceC0456p1 interfaceC0456p1) {
        return interfaceC0456p1.h(E1.k(obj, i3 & 1048575));
    }

    private static boolean u(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof B0) {
            return ((B0) obj).y();
        }
        return true;
    }

    private final boolean v(Object obj, int i3, int i4) {
        return E1.h(obj, (long) (E(i4) & 1048575)) == i3;
    }

    private static boolean w(Object obj, long j3) {
        return ((Boolean) E1.k(obj, j3)).booleanValue();
    }

    private static final void x(int i3, Object obj, K1 k3) {
        if (obj instanceof String) {
            k3.G(i3, (String) obj);
        } else {
            k3.C(i3, (AbstractC0421f0) obj);
        }
    }

    static C0473v1 z(Object obj) {
        B0 b3 = (B0) obj;
        C0473v1 c0473v1 = b3.zzc;
        if (c0473v1 != C0473v1.c()) {
            return c0473v1;
        }
        C0473v1 c0473v1F = C0473v1.f();
        b3.zzc = c0473v1F;
        return c0473v1F;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void a(Object obj) {
        if (u(obj)) {
            if (obj instanceof B0) {
                B0 b3 = (B0) obj;
                b3.w(Integer.MAX_VALUE);
                b3.zza = 0;
                b3.u();
            }
            int[] iArr = this.f7433a;
            for (int i3 = 0; i3 < iArr.length; i3 += 3) {
                int iH = H(i3);
                int i4 = 1048575 & iH;
                int iG = G(iH);
                long j3 = i4;
                if (iG != 9) {
                    if (iG != 60 && iG != 68) {
                        switch (iG) {
                            case 17:
                                if (r(obj, i3)) {
                                    K(i3).a(f7432p.getObject(obj, j3));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f7442j.a(obj, j3);
                                break;
                            case 50:
                                Unsafe unsafe = f7432p;
                                Object object = unsafe.getObject(obj, j3);
                                if (object != null) {
                                    ((Y0) object).d();
                                    unsafe.putObject(obj, j3, object);
                                }
                                break;
                        }
                    } else if (v(obj, this.f7433a[i3], i3)) {
                        K(i3).a(f7432p.getObject(obj, j3));
                    }
                } else if (r(obj, i3)) {
                    K(i3).a(f7432p.getObject(obj, j3));
                }
            }
            this.f7443k.g(obj);
            if (this.f7438f) {
                this.f7444l.b(obj);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void b(Object obj, K1 k3) throws Throwable {
        int i3;
        int i4;
        int i5;
        ?? r9 = 1;
        Throwable th = null;
        if (this.f7438f) {
            this.f7444l.a(obj);
            throw null;
        }
        int[] iArr = this.f7433a;
        Unsafe unsafe = f7432p;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < iArr.length) {
            int iH = H(i9);
            int[] iArr2 = this.f7433a;
            int iG = G(iH);
            int i10 = iArr2[i9];
            if (iG <= 17) {
                int i11 = iArr2[i9 + 2];
                int i12 = i11 & i6;
                if (i12 != i7) {
                    i8 = i12 == i6 ? 0 : unsafe.getInt(obj, i12);
                    i7 = i12;
                }
                i3 = i7;
                i4 = i8;
                i5 = r9 << (i11 >>> 20);
            } else {
                i3 = i7;
                i4 = i8;
                i5 = 0;
            }
            long j3 = iH & i6;
            switch (iG) {
                case 0:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.g(i10, E1.f(obj, j3));
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 1:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.r(i10, E1.g(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 2:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.I(i10, unsafe.getLong(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 3:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.j(i10, unsafe.getLong(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 4:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.J(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 5:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.v(i10, unsafe.getLong(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 6:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.z(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 7:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.B(i10, E1.B(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 8:
                    if (s(obj, i9, i3, i4, i5)) {
                        x(i10, unsafe.getObject(obj, j3), k3);
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 9:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.s(i10, unsafe.getObject(obj, j3), K(i9));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 10:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.C(i10, (AbstractC0421f0) unsafe.getObject(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 11:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.h(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 12:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.y(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 13:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.o(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 14:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.c(i10, unsafe.getLong(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 15:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.F(i10, unsafe.getInt(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 16:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.H(i10, unsafe.getLong(obj, j3));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 17:
                    if (s(obj, i9, i3, i4, i5)) {
                        k3.E(i10, unsafe.getObject(obj, j3), K(i9));
                    } else {
                        continue;
                    }
                    i9 += 3;
                    i7 = i3;
                    i8 = i4;
                    r9 = 1;
                    th = null;
                    i6 = 1048575;
                    break;
                case 18:
                    AbstractC0461r1.y(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 19:
                    AbstractC0461r1.C(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 20:
                    AbstractC0461r1.E(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 21:
                    AbstractC0461r1.e(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 22:
                    AbstractC0461r1.D(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 23:
                    AbstractC0461r1.B(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 24:
                    AbstractC0461r1.A(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 25:
                    AbstractC0461r1.x(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 26:
                    int i13 = this.f7433a[i9];
                    List list = (List) unsafe.getObject(obj, j3);
                    int i14 = AbstractC0461r1.f7499d;
                    if (list != null && !list.isEmpty()) {
                        k3.b(i13, list);
                    }
                    break;
                case 27:
                    int i15 = this.f7433a[i9];
                    List list2 = (List) unsafe.getObject(obj, j3);
                    InterfaceC0456p1 interfaceC0456p1K = K(i9);
                    int i16 = AbstractC0461r1.f7499d;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i17 = 0; i17 < list2.size(); i17 += r9) {
                            ((C0452o0) k3).s(i15, list2.get(i17), interfaceC0456p1K);
                        }
                    }
                    break;
                case 28:
                    int i18 = this.f7433a[i9];
                    List list3 = (List) unsafe.getObject(obj, j3);
                    int i19 = AbstractC0461r1.f7499d;
                    if (list3 != null && !list3.isEmpty()) {
                        k3.k(i18, list3);
                    }
                    break;
                case 29:
                    AbstractC0461r1.d(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 30:
                    AbstractC0461r1.z(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 31:
                    AbstractC0461r1.F(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 32:
                    AbstractC0461r1.a(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 33:
                    AbstractC0461r1.b(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 34:
                    AbstractC0461r1.c(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, false);
                    break;
                case 35:
                    AbstractC0461r1.y(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 36:
                    AbstractC0461r1.C(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 37:
                    AbstractC0461r1.E(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 38:
                    AbstractC0461r1.e(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 39:
                    AbstractC0461r1.D(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 40:
                    AbstractC0461r1.B(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 41:
                    AbstractC0461r1.A(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 42:
                    AbstractC0461r1.x(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 43:
                    AbstractC0461r1.d(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 44:
                    AbstractC0461r1.z(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 45:
                    AbstractC0461r1.F(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 46:
                    AbstractC0461r1.a(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 47:
                    AbstractC0461r1.b(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 48:
                    AbstractC0461r1.c(this.f7433a[i9], (List) unsafe.getObject(obj, j3), k3, r9);
                    break;
                case 49:
                    int i20 = this.f7433a[i9];
                    List list4 = (List) unsafe.getObject(obj, j3);
                    InterfaceC0456p1 interfaceC0456p1K2 = K(i9);
                    int i21 = AbstractC0461r1.f7499d;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i22 = 0; i22 < list4.size(); i22 += r9) {
                            ((C0452o0) k3).E(i20, list4.get(i22), interfaceC0456p1K2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j3) != null) {
                        androidx.appcompat.app.H.a(L(i9));
                        throw th;
                    }
                    break;
                case 51:
                    if (v(obj, i10, i9)) {
                        k3.g(i10, B(obj, j3));
                    }
                    break;
                case 52:
                    if (v(obj, i10, i9)) {
                        k3.r(i10, C(obj, j3));
                    }
                    break;
                case 53:
                    if (v(obj, i10, i9)) {
                        k3.I(i10, I(obj, j3));
                    }
                    break;
                case 54:
                    if (v(obj, i10, i9)) {
                        k3.j(i10, I(obj, j3));
                    }
                    break;
                case 55:
                    if (v(obj, i10, i9)) {
                        k3.J(i10, D(obj, j3));
                    }
                    break;
                case 56:
                    if (v(obj, i10, i9)) {
                        k3.v(i10, I(obj, j3));
                    }
                    break;
                case 57:
                    if (v(obj, i10, i9)) {
                        k3.z(i10, D(obj, j3));
                    }
                    break;
                case 58:
                    if (v(obj, i10, i9)) {
                        k3.B(i10, w(obj, j3));
                    }
                    break;
                case 59:
                    if (v(obj, i10, i9)) {
                        x(i10, unsafe.getObject(obj, j3), k3);
                    }
                    break;
                case 60:
                    if (v(obj, i10, i9)) {
                        k3.s(i10, unsafe.getObject(obj, j3), K(i9));
                    }
                    break;
                case 61:
                    if (v(obj, i10, i9)) {
                        k3.C(i10, (AbstractC0421f0) unsafe.getObject(obj, j3));
                    }
                    break;
                case 62:
                    if (v(obj, i10, i9)) {
                        k3.h(i10, D(obj, j3));
                    }
                    break;
                case 63:
                    if (v(obj, i10, i9)) {
                        k3.y(i10, D(obj, j3));
                    }
                    break;
                case 64:
                    if (v(obj, i10, i9)) {
                        k3.o(i10, D(obj, j3));
                    }
                    break;
                case 65:
                    if (v(obj, i10, i9)) {
                        k3.c(i10, I(obj, j3));
                    }
                    break;
                case 66:
                    if (v(obj, i10, i9)) {
                        k3.F(i10, D(obj, j3));
                    }
                    break;
                case 67:
                    if (v(obj, i10, i9)) {
                        k3.H(i10, I(obj, j3));
                    }
                    break;
                case 68:
                    if (v(obj, i10, i9)) {
                        k3.E(i10, unsafe.getObject(obj, j3), K(i9));
                    }
                    break;
            }
            i9 += 3;
            i7 = i3;
            i8 = i4;
            r9 = 1;
            th = null;
            i6 = 1048575;
        }
        AbstractC0470u1 abstractC0470u1 = this.f7443k;
        abstractC0470u1.i(abstractC0470u1.d(obj), k3);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final Object c() {
        return ((B0) this.f7437e).m();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:142:0x038f  */
    /* JADX WARN: Code duplicated, block: B:175:0x0478  */
    /* JADX WARN: Code duplicated, block: B:92:0x021b  */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final int d(Object obj) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iW;
        int iW2;
        int iW3;
        int iX;
        int iW4;
        int i7;
        int iW5;
        int iW6;
        int iW7;
        int iJ;
        int iM;
        int size;
        int iR;
        int iW8;
        int iW9;
        int iW10;
        int size2;
        int iQ;
        int iW11;
        int iX2;
        int iK;
        int iW12;
        int iW13;
        int iW14;
        int iW15;
        int iW16;
        int iL;
        int iW17;
        Unsafe unsafe = f7432p;
        int i8 = 1048575;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        int iN = 0;
        while (i11 < this.f7433a.length) {
            int iH = H(i11);
            int iG = G(iH);
            int[] iArr = this.f7433a;
            int i12 = iArr[i11];
            int i13 = iArr[i11 + 2];
            int i14 = i13 & i8;
            if (iG <= 17) {
                if (i14 != i9) {
                    i10 = i14 == i8 ? 0 : unsafe.getInt(obj, i14);
                    i9 = i14;
                }
                i5 = 1 << (i13 >>> 20);
                i3 = i9;
                i4 = i10;
            } else {
                i3 = i9;
                i4 = i10;
                i5 = 0;
            }
            int i15 = iH & i8;
            if (iG >= EnumC0475w0.f7533M.a()) {
                EnumC0475w0.f7546Z.a();
            }
            long j3 = i15;
            switch (iG) {
                case 0:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        iW = AbstractC0449n0.w(i12 << 3);
                        iW4 = iW + 8;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 1:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        iW2 = AbstractC0449n0.w(i12 << 3);
                        iW4 = iW2 + 4;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 2:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        long j4 = unsafe.getLong(obj, j3);
                        iW3 = AbstractC0449n0.w(i12 << 3);
                        iX = AbstractC0449n0.x(j4);
                        iW4 = iW3 + iX;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 3:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        long j5 = unsafe.getLong(obj, j3);
                        iW3 = AbstractC0449n0.w(i12 << 3);
                        iX = AbstractC0449n0.x(j5);
                        iW4 = iW3 + iX;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 4:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        long j6 = unsafe.getInt(obj, j3);
                        iW3 = AbstractC0449n0.w(i12 << 3);
                        iX = AbstractC0449n0.x(j6);
                        iW4 = iW3 + iX;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 5:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        iW = AbstractC0449n0.w(i12 << 3);
                        iW4 = iW + 8;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 6:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        iW2 = AbstractC0449n0.w(i12 << 3);
                        iW4 = iW2 + 4;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 7:
                    i6 = i11;
                    if (s(obj, i6, i3, i4, i5)) {
                        iW4 = AbstractC0449n0.w(i12 << 3) + 1;
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 8:
                    int i16 = i11;
                    i6 = i16;
                    if (s(obj, i16, i3, i4, i5)) {
                        int i17 = i12 << 3;
                        Object object = unsafe.getObject(obj, j3);
                        if (object instanceof AbstractC0421f0) {
                            int iW18 = AbstractC0449n0.w(i17);
                            int iL2 = ((AbstractC0421f0) object).l();
                            iW4 = iW18 + AbstractC0449n0.w(iL2) + iL2;
                        } else {
                            iW3 = AbstractC0449n0.w(i17);
                            iX = AbstractC0449n0.v((String) object);
                            iW4 = iW3 + iX;
                        }
                        iN += iW4;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 9:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        iN += AbstractC0461r1.n(i12, unsafe.getObject(obj, j3), K(i7));
                        i6 = i7;
                    } else {
                        i6 = i7;
                    }
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 10:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        AbstractC0421f0 abstractC0421f0 = (AbstractC0421f0) unsafe.getObject(obj, j3);
                        int iW19 = AbstractC0449n0.w(i12 << 3);
                        int iL3 = abstractC0421f0.l();
                        iW5 = iW19 + AbstractC0449n0.w(iL3) + iL3;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 11:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        int i18 = unsafe.getInt(obj, j3);
                        iW6 = AbstractC0449n0.w(i12 << 3);
                        iW7 = AbstractC0449n0.w(i18);
                        iW5 = iW6 + iW7;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 12:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        long j7 = unsafe.getInt(obj, j3);
                        iW6 = AbstractC0449n0.w(i12 << 3);
                        iW7 = AbstractC0449n0.x(j7);
                        iW5 = iW6 + iW7;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 13:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        iW5 = AbstractC0449n0.w(i12 << 3) + 4;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 14:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        iW5 = AbstractC0449n0.w(i12 << 3) + 8;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 15:
                    i7 = i11;
                    if (s(obj, i7, i3, i4, i5)) {
                        int i19 = unsafe.getInt(obj, j3);
                        iW6 = AbstractC0449n0.w(i12 << 3);
                        iW7 = AbstractC0449n0.w((i19 >> 31) ^ (i19 + i19));
                        iW5 = iW6 + iW7;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 16:
                    i7 = i11;
                    if (s(obj, i11, i3, i4, i5)) {
                        long j8 = unsafe.getLong(obj, j3);
                        iW6 = AbstractC0449n0.w(i12 << 3);
                        iW7 = AbstractC0449n0.x((j8 >> 63) ^ (j8 + j8));
                        iW5 = iW6 + iW7;
                        iN += iW5;
                    }
                    i6 = i7;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 17:
                    if (s(obj, i11, i3, i4, i5)) {
                        iN += AbstractC0449n0.t(i12, (InterfaceC0418e1) unsafe.getObject(obj, j3), K(i11));
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 18:
                    iJ = AbstractC0461r1.j(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 19:
                    iJ = AbstractC0461r1.h(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j3);
                    int i20 = AbstractC0461r1.f7499d;
                    if (list.size() == 0) {
                        iM = 0;
                    } else {
                        iM = AbstractC0461r1.m(list) + (list.size() * AbstractC0449n0.w(i12 << 3));
                    }
                    iN += iM;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j3);
                    int i21 = AbstractC0461r1.f7499d;
                    size = list2.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iR = AbstractC0461r1.r(list2);
                        iW8 = AbstractC0449n0.w(i12 << 3);
                        iM = iR + (size * iW8);
                    }
                    iN += iM;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j3);
                    int i22 = AbstractC0461r1.f7499d;
                    size = list3.size();
                    if (size == 0) {
                        iM = 0;
                    } else {
                        iR = AbstractC0461r1.l(list3);
                        iW8 = AbstractC0449n0.w(i12 << 3);
                        iM = iR + (size * iW8);
                    }
                    iN += iM;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 23:
                    iJ = AbstractC0461r1.j(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 24:
                    iJ = AbstractC0461r1.h(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j3);
                    int i23 = AbstractC0461r1.f7499d;
                    int size3 = list4.size();
                    if (size3 == 0) {
                        iJ = 0;
                    } else {
                        iJ = size3 * (AbstractC0449n0.w(i12 << 3) + 1);
                    }
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j3);
                    int i24 = AbstractC0461r1.f7499d;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        iM = 0;
                    } else {
                        int iW20 = AbstractC0449n0.w(i12 << 3) * size4;
                        if (list5 instanceof O0) {
                            O0 o3 = (O0) list5;
                            iM = iW20;
                            for (int i25 = 0; i25 < size4; i25++) {
                                Object objH = o3.h(i25);
                                if (objH instanceof AbstractC0421f0) {
                                    int iL4 = ((AbstractC0421f0) objH).l();
                                    iM += AbstractC0449n0.w(iL4) + iL4;
                                } else {
                                    iM += AbstractC0449n0.v((String) objH);
                                }
                            }
                        } else {
                            iM = iW20;
                            for (int i26 = 0; i26 < size4; i26++) {
                                Object obj2 = list5.get(i26);
                                if (obj2 instanceof AbstractC0421f0) {
                                    int iL5 = ((AbstractC0421f0) obj2).l();
                                    iM += AbstractC0449n0.w(iL5) + iL5;
                                } else {
                                    iM += AbstractC0449n0.v((String) obj2);
                                }
                            }
                        }
                    }
                    iN += iM;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j3);
                    InterfaceC0456p1 interfaceC0456p1K = K(i11);
                    int i27 = AbstractC0461r1.f7499d;
                    int size5 = list6.size();
                    if (size5 == 0) {
                        iW9 = 0;
                    } else {
                        iW9 = AbstractC0449n0.w(i12 << 3) * size5;
                        for (int i28 = 0; i28 < size5; i28++) {
                            iW9 += AbstractC0449n0.u((InterfaceC0418e1) list6.get(i28), interfaceC0456p1K);
                        }
                    }
                    iN += iW9;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j3);
                    int i29 = AbstractC0461r1.f7499d;
                    int size6 = list7.size();
                    if (size6 == 0) {
                        iW10 = 0;
                    } else {
                        iW10 = size6 * AbstractC0449n0.w(i12 << 3);
                        for (int i30 = 0; i30 < list7.size(); i30++) {
                            int iL6 = ((AbstractC0421f0) list7.get(i30)).l();
                            iW10 += AbstractC0449n0.w(iL6) + iL6;
                        }
                    }
                    iN += iW10;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j3);
                    int i31 = AbstractC0461r1.f7499d;
                    size2 = list8.size();
                    if (size2 == 0) {
                        iJ = 0;
                    } else {
                        iQ = AbstractC0461r1.q(list8);
                        iW11 = AbstractC0449n0.w(i12 << 3);
                        iX2 = size2 * iW11;
                        iJ = iQ + iX2;
                    }
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j3);
                    int i32 = AbstractC0461r1.f7499d;
                    size2 = list9.size();
                    if (size2 == 0) {
                        iJ = 0;
                    } else {
                        iQ = AbstractC0461r1.g(list9);
                        iW11 = AbstractC0449n0.w(i12 << 3);
                        iX2 = size2 * iW11;
                        iJ = iQ + iX2;
                    }
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 31:
                    iJ = AbstractC0461r1.h(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 32:
                    iJ = AbstractC0461r1.j(i12, (List) unsafe.getObject(obj, j3), false);
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j3);
                    int i33 = AbstractC0461r1.f7499d;
                    size2 = list10.size();
                    if (size2 == 0) {
                        iJ = 0;
                    } else {
                        iQ = AbstractC0461r1.o(list10);
                        iW11 = AbstractC0449n0.w(i12 << 3);
                        iX2 = size2 * iW11;
                        iJ = iQ + iX2;
                    }
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j3);
                    int i34 = AbstractC0461r1.f7499d;
                    size2 = list11.size();
                    if (size2 == 0) {
                        iJ = 0;
                    } else {
                        iQ = AbstractC0461r1.p(list11);
                        iW11 = AbstractC0449n0.w(i12 << 3);
                        iX2 = size2 * iW11;
                        iJ = iQ + iX2;
                    }
                    iN += iJ;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 35:
                    iK = AbstractC0461r1.k((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 36:
                    iK = AbstractC0461r1.i((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 37:
                    iK = AbstractC0461r1.m((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 38:
                    iK = AbstractC0461r1.r((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 39:
                    iK = AbstractC0461r1.l((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 40:
                    iK = AbstractC0461r1.k((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 41:
                    iK = AbstractC0461r1.i((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j3);
                    int i35 = AbstractC0461r1.f7499d;
                    iK = list12.size();
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 43:
                    iK = AbstractC0461r1.q((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 44:
                    iK = AbstractC0461r1.g((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 45:
                    iK = AbstractC0461r1.i((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 46:
                    iK = AbstractC0461r1.k((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 47:
                    iK = AbstractC0461r1.o((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 48:
                    iK = AbstractC0461r1.p((List) unsafe.getObject(obj, j3));
                    if (iK > 0) {
                        iW12 = AbstractC0449n0.w(i12 << 3);
                        iW13 = AbstractC0449n0.w(iK);
                        iN += iW12 + iW13 + iK;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j3);
                    InterfaceC0456p1 interfaceC0456p1K2 = K(i11);
                    int i36 = AbstractC0461r1.f7499d;
                    int size7 = list13.size();
                    if (size7 == 0) {
                        iW9 = 0;
                    } else {
                        iW9 = 0;
                        for (int i37 = 0; i37 < size7; i37++) {
                            iW9 += AbstractC0449n0.t(i12, (InterfaceC0418e1) list13.get(i37), interfaceC0456p1K2);
                        }
                    }
                    iN += iW9;
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 50:
                    Y0 y3 = (Y0) unsafe.getObject(obj, j3);
                    androidx.appcompat.app.H.a(L(i11));
                    if (!y3.isEmpty()) {
                        Iterator it = y3.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 51:
                    if (v(obj, i12, i11)) {
                        iW14 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW14 + 8;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 52:
                    if (v(obj, i12, i11)) {
                        iW15 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW15 + 4;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 53:
                    if (v(obj, i12, i11)) {
                        long jI = I(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.x(jI);
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 54:
                    if (v(obj, i12, i11)) {
                        long jI2 = I(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.x(jI2);
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 55:
                    if (v(obj, i12, i11)) {
                        long jD = D(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.x(jD);
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 56:
                    if (v(obj, i12, i11)) {
                        iW14 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW14 + 8;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 57:
                    if (v(obj, i12, i11)) {
                        iW15 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW15 + 4;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 58:
                    if (v(obj, i12, i11)) {
                        iJ = AbstractC0449n0.w(i12 << 3) + 1;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 59:
                    if (v(obj, i12, i11)) {
                        int i38 = i12 << 3;
                        Object object2 = unsafe.getObject(obj, j3);
                        if (object2 instanceof AbstractC0421f0) {
                            iW16 = AbstractC0449n0.w(i38);
                            iL = ((AbstractC0421f0) object2).l();
                            iW17 = AbstractC0449n0.w(iL);
                            iJ = iW16 + iW17 + iL;
                            iN += iJ;
                        } else {
                            iQ = AbstractC0449n0.w(i38);
                            iX2 = AbstractC0449n0.v((String) object2);
                            iJ = iQ + iX2;
                            iN += iJ;
                        }
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 60:
                    if (v(obj, i12, i11)) {
                        iJ = AbstractC0461r1.n(i12, unsafe.getObject(obj, j3), K(i11));
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 61:
                    if (v(obj, i12, i11)) {
                        AbstractC0421f0 abstractC0421f1 = (AbstractC0421f0) unsafe.getObject(obj, j3);
                        iW16 = AbstractC0449n0.w(i12 << 3);
                        iL = abstractC0421f1.l();
                        iW17 = AbstractC0449n0.w(iL);
                        iJ = iW16 + iW17 + iL;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 62:
                    if (v(obj, i12, i11)) {
                        int iD = D(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.w(iD);
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 63:
                    if (v(obj, i12, i11)) {
                        long jD2 = D(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.x(jD2);
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 64:
                    if (v(obj, i12, i11)) {
                        iW15 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW15 + 4;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 65:
                    if (v(obj, i12, i11)) {
                        iW14 = AbstractC0449n0.w(i12 << 3);
                        iJ = iW14 + 8;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 66:
                    if (v(obj, i12, i11)) {
                        int iD2 = D(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.w((iD2 >> 31) ^ (iD2 + iD2));
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 67:
                    if (v(obj, i12, i11)) {
                        long jI3 = I(obj, j3);
                        iQ = AbstractC0449n0.w(i12 << 3);
                        iX2 = AbstractC0449n0.x((jI3 >> 63) ^ (jI3 + jI3));
                        iJ = iQ + iX2;
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                case 68:
                    if (v(obj, i12, i11)) {
                        iJ = AbstractC0449n0.t(i12, (InterfaceC0418e1) unsafe.getObject(obj, j3), K(i11));
                        iN += iJ;
                    }
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
                default:
                    i6 = i11;
                    i11 = i6 + 3;
                    i9 = i3;
                    i10 = i4;
                    i8 = 1048575;
                    break;
            }
        }
        AbstractC0470u1 abstractC0470u1 = this.f7443k;
        int iA = iN + abstractC0470u1.a(abstractC0470u1.d(obj));
        if (!this.f7438f) {
            return iA;
        }
        this.f7444l.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void e(Object obj, Object obj2) {
        j(obj);
        obj2.getClass();
        for (int i3 = 0; i3 < this.f7433a.length; i3 += 3) {
            int iH = H(i3);
            int i4 = 1048575 & iH;
            int[] iArr = this.f7433a;
            int iG = G(iH);
            int i5 = iArr[i3];
            long j3 = i4;
            switch (iG) {
                case 0:
                    if (r(obj2, i3)) {
                        E1.t(obj, j3, E1.f(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 1:
                    if (r(obj2, i3)) {
                        E1.u(obj, j3, E1.g(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 2:
                    if (r(obj2, i3)) {
                        E1.w(obj, j3, E1.i(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 3:
                    if (r(obj2, i3)) {
                        E1.w(obj, j3, E1.i(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 4:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 5:
                    if (r(obj2, i3)) {
                        E1.w(obj, j3, E1.i(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 6:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 7:
                    if (r(obj2, i3)) {
                        E1.r(obj, j3, E1.B(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 8:
                    if (r(obj2, i3)) {
                        E1.x(obj, j3, E1.k(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 9:
                    k(obj, obj2, i3);
                    break;
                case 10:
                    if (r(obj2, i3)) {
                        E1.x(obj, j3, E1.k(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 11:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 12:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 13:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 14:
                    if (r(obj2, i3)) {
                        E1.w(obj, j3, E1.i(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 15:
                    if (r(obj2, i3)) {
                        E1.v(obj, j3, E1.h(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 16:
                    if (r(obj2, i3)) {
                        E1.w(obj, j3, E1.i(obj2, j3));
                        m(obj, i3);
                    }
                    break;
                case 17:
                    k(obj, obj2, i3);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f7442j.b(obj, obj2, j3);
                    break;
                case 50:
                    int i6 = AbstractC0461r1.f7499d;
                    E1.x(obj, j3, Z0.a(E1.k(obj, j3), E1.k(obj2, j3)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (v(obj2, i5, i3)) {
                        E1.x(obj, j3, E1.k(obj2, j3));
                        n(obj, i5, i3);
                    }
                    break;
                case 60:
                    l(obj, obj2, i3);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (v(obj2, i5, i3)) {
                        E1.x(obj, j3, E1.k(obj2, j3));
                        n(obj, i5, i3);
                    }
                    break;
                case 68:
                    l(obj, obj2, i3);
                    break;
            }
        }
        AbstractC0461r1.v(this.f7443k, obj, obj2);
        if (this.f7438f) {
            this.f7444l.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final void f(Object obj, byte[] bArr, int i3, int i4, T t3) throws L0 {
        y(obj, bArr, i3, i4, 0, t3);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final boolean g(Object obj, Object obj2) {
        boolean zF;
        for (int i3 = 0; i3 < this.f7433a.length; i3 += 3) {
            int iH = H(i3);
            long j3 = iH & 1048575;
            switch (G(iH)) {
                case 0:
                    if (!q(obj, obj2, i3) || Double.doubleToLongBits(E1.f(obj, j3)) != Double.doubleToLongBits(E1.f(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!q(obj, obj2, i3) || Float.floatToIntBits(E1.g(obj, j3)) != Float.floatToIntBits(E1.g(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!q(obj, obj2, i3) || E1.i(obj, j3) != E1.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!q(obj, obj2, i3) || E1.i(obj, j3) != E1.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!q(obj, obj2, i3) || E1.i(obj, j3) != E1.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!q(obj, obj2, i3) || E1.B(obj, j3) != E1.B(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!q(obj, obj2, i3) || !AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!q(obj, obj2, i3) || !AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!q(obj, obj2, i3) || !AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!q(obj, obj2, i3) || E1.i(obj, j3) != E1.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!q(obj, obj2, i3) || E1.h(obj, j3) != E1.h(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!q(obj, obj2, i3) || E1.i(obj, j3) != E1.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!q(obj, obj2, i3) || !AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zF = AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3));
                    break;
                case 50:
                    zF = AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jE = E(i3) & 1048575;
                    if (E1.h(obj, jE) != E1.h(obj2, jE) || !AbstractC0461r1.f(E1.k(obj, j3), E1.k(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zF) {
                return false;
            }
        }
        if (!this.f7443k.d(obj).equals(this.f7443k.d(obj2))) {
            return false;
        }
        if (!this.f7438f) {
            return true;
        }
        this.f7444l.a(obj);
        this.f7444l.a(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6 A[LOOP:1: B:45:0x00b5->B:50:0x00c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final boolean h(Object obj) {
        int i3;
        int i4;
        List list;
        InterfaceC0456p1 interfaceC0456p1K;
        int i5;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.f7440h) {
            int[] iArr = this.f7439g;
            int[] iArr2 = this.f7433a;
            int i9 = iArr[i8];
            int i10 = iArr2[i9];
            int iH = H(i9);
            int i11 = this.f7433a[i9 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i6) {
                if (i12 != 1048575) {
                    i7 = f7432p.getInt(obj, i12);
                }
                i4 = i7;
                i3 = i12;
            } else {
                i3 = i6;
                i4 = i7;
            }
            if ((268435456 & iH) != 0 && !s(obj, i9, i3, i4, i13)) {
                return false;
            }
            int iG = G(iH);
            if (iG == 9 || iG == 17) {
                if (s(obj, i9, i3, i4, i13) && !t(obj, iH, K(i9))) {
                    return false;
                }
            } else if (iG == 27) {
                list = (List) E1.k(obj, iH & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    interfaceC0456p1K = K(i9);
                    for (i5 = 0; i5 < list.size(); i5++) {
                        if (!interfaceC0456p1K.h(list.get(i5))) {
                            return false;
                        }
                    }
                }
            } else if (iG == 60 || iG == 68) {
                if (v(obj, i10, i9) && !t(obj, iH, K(i9))) {
                    return false;
                }
            } else if (iG == 49) {
                list = (List) E1.k(obj, iH & 1048575);
                if (list.isEmpty()) {
                    interfaceC0456p1K = K(i9);
                    while (i5 < list.size()) {
                        if (!interfaceC0456p1K.h(list.get(i5))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iG == 50 && !((Y0) E1.k(obj, iH & 1048575)).isEmpty()) {
                androidx.appcompat.app.H.a(L(i9));
                throw null;
            }
            i8++;
            i6 = i3;
            i7 = i4;
        }
        if (!this.f7438f) {
            return true;
        }
        this.f7444l.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC0456p1
    public final int i(Object obj) {
        int i3;
        long jDoubleToLongBits;
        int i4;
        int iFloatToIntBits;
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f7433a.length; i7 += 3) {
            int iH = H(i7);
            int[] iArr = this.f7433a;
            int i8 = 1048575 & iH;
            int iG = G(iH);
            int i9 = iArr[i7];
            long j3 = i8;
            int iHashCode = 37;
            switch (iG) {
                case 0:
                    i3 = i6 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(E1.f(obj, j3));
                    byte[] bArr = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i4 = i6 * 53;
                    iFloatToIntBits = Float.floatToIntBits(E1.g(obj, j3));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 2:
                    i3 = i6 * 53;
                    jDoubleToLongBits = E1.i(obj, j3);
                    byte[] bArr2 = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i3 = i6 * 53;
                    jDoubleToLongBits = E1.i(obj, j3);
                    byte[] bArr3 = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 5:
                    i3 = i6 * 53;
                    jDoubleToLongBits = E1.i(obj, j3);
                    byte[] bArr4 = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 7:
                    i4 = i6 * 53;
                    iFloatToIntBits = J0.a(E1.B(obj, j3));
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 8:
                    i4 = i6 * 53;
                    iFloatToIntBits = ((String) E1.k(obj, j3)).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 9:
                    i5 = i6 * 53;
                    Object objK = E1.k(obj, j3);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i6 = i5 + iHashCode;
                    break;
                case 10:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.k(obj, j3).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 11:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 12:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 13:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 14:
                    i3 = i6 * 53;
                    jDoubleToLongBits = E1.i(obj, j3);
                    byte[] bArr5 = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.h(obj, j3);
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 16:
                    i3 = i6 * 53;
                    jDoubleToLongBits = E1.i(obj, j3);
                    byte[] bArr6 = J0.f7336d;
                    i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i5 = i6 * 53;
                    Object objK2 = E1.k(obj, j3);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
                    }
                    i6 = i5 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.k(obj, j3).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 50:
                    i4 = i6 * 53;
                    iFloatToIntBits = E1.k(obj, j3).hashCode();
                    i6 = i4 + iFloatToIntBits;
                    break;
                case 51:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(B(obj, j3));
                        byte[] bArr7 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = Float.floatToIntBits(C(obj, j3));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = I(obj, j3);
                        byte[] bArr8 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = I(obj, j3);
                        byte[] bArr9 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = I(obj, j3);
                        byte[] bArr10 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = J0.a(w(obj, j3));
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = ((String) E1.k(obj, j3)).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = E1.k(obj, j3).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = E1.k(obj, j3).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = I(obj, j3);
                        byte[] bArr11 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = D(obj, j3);
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (v(obj, i9, i7)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = I(obj, j3);
                        byte[] bArr12 = J0.f7336d;
                        i6 = i3 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (v(obj, i9, i7)) {
                        i4 = i6 * 53;
                        iFloatToIntBits = E1.k(obj, j3).hashCode();
                        i6 = i4 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i6 * 53) + this.f7443k.d(obj).hashCode();
        if (!this.f7438f) {
            return iHashCode2;
        }
        this.f7444l.a(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x026b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x026d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0282  */
    /* JADX WARN: Code duplicated, block: B:107:0x0288  */
    /* JADX WARN: Code duplicated, block: B:109:0x028c  */
    /* JADX WARN: Code duplicated, block: B:114:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:123:0x0307  */
    /* JADX WARN: Code duplicated, block: B:125:0x0315  */
    /* JADX WARN: Code duplicated, block: B:127:0x0319  */
    /* JADX WARN: Code duplicated, block: B:129:0x031f  */
    /* JADX WARN: Code duplicated, block: B:139:0x0361  */
    /* JADX WARN: Code duplicated, block: B:140:0x0363  */
    /* JADX WARN: Code duplicated, block: B:168:0x047f  */
    /* JADX WARN: Code duplicated, block: B:170:0x0485  */
    /* JADX WARN: Code duplicated, block: B:171:0x0488  */
    /* JADX WARN: Code duplicated, block: B:179:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:181:0x0505  */
    /* JADX WARN: Code duplicated, block: B:182:0x050a  */
    /* JADX WARN: Code duplicated, block: B:184:0x0519  */
    /* JADX WARN: Code duplicated, block: B:186:0x051e  */
    /* JADX WARN: Code duplicated, block: B:188:0x0523  */
    /* JADX WARN: Code duplicated, block: B:190:0x0548  */
    /* JADX WARN: Code duplicated, block: B:192:0x0550 A[LOOP:2: B:189:0x0546->B:192:0x0550, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x0579  */
    /* JADX WARN: Code duplicated, block: B:196:0x058e  */
    /* JADX WARN: Code duplicated, block: B:198:0x059a  */
    /* JADX WARN: Code duplicated, block: B:200:0x05a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:206:0x05b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:211:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:213:0x05e0  */
    /* JADX WARN: Code duplicated, block: B:215:0x05eb A[LOOP:3: B:214:0x05e9->B:215:0x05eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:220:0x0602 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x0604  */
    /* JADX WARN: Code duplicated, block: B:223:0x0615  */
    /* JADX WARN: Code duplicated, block: B:225:0x061d A[LOOP:4: B:222:0x0613->B:225:0x061d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:226:0x062b  */
    /* JADX WARN: Code duplicated, block: B:228:0x0637  */
    /* JADX WARN: Code duplicated, block: B:229:0x063c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:230:0x063e  */
    /* JADX WARN: Code duplicated, block: B:233:0x0655  */
    /* JADX WARN: Code duplicated, block: B:235:0x0659  */
    /* JADX WARN: Code duplicated, block: B:237:0x0663  */
    /* JADX WARN: Code duplicated, block: B:239:0x0677 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:240:0x0679  */
    /* JADX WARN: Code duplicated, block: B:243:0x0682  */
    /* JADX WARN: Code duplicated, block: B:247:0x0697  */
    /* JADX WARN: Code duplicated, block: B:248:0x069f  */
    /* JADX WARN: Code duplicated, block: B:251:0x06af  */
    /* JADX WARN: Code duplicated, block: B:254:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:258:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:259:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:261:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:263:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:265:0x06fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:266:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:267:0x0704  */
    /* JADX WARN: Code duplicated, block: B:270:0x070e  */
    /* JADX WARN: Code duplicated, block: B:272:0x0716  */
    /* JADX WARN: Code duplicated, block: B:274:0x071e  */
    /* JADX WARN: Code duplicated, block: B:276:0x0722 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:288:0x074e  */
    /* JADX WARN: Code duplicated, block: B:291:0x075d  */
    /* JADX WARN: Code duplicated, block: B:293:0x076b  */
    /* JADX WARN: Code duplicated, block: B:294:0x0796  */
    /* JADX WARN: Code duplicated, block: B:295:0x079d  */
    /* JADX WARN: Code duplicated, block: B:297:0x07b0  */
    /* JADX WARN: Code duplicated, block: B:299:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x07c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:302:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:303:0x07c8  */
    /* JADX WARN: Code duplicated, block: B:306:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:308:0x07df  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:310:0x07e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:320:0x0809  */
    /* JADX WARN: Code duplicated, block: B:322:0x0813 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:323:0x0815  */
    /* JADX WARN: Code duplicated, block: B:324:0x0819  */
    /* JADX WARN: Code duplicated, block: B:326:0x0821  */
    /* JADX WARN: Code duplicated, block: B:329:0x082e  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:331:0x0836  */
    /* JADX WARN: Code duplicated, block: B:333:0x083e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:337:0x084c  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:348:0x0872  */
    /* JADX WARN: Code duplicated, block: B:350:0x0883  */
    /* JADX WARN: Code duplicated, block: B:352:0x088f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:358:0x089e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:362:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:364:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:366:0x08c6 A[LOOP:10: B:365:0x08c4->B:366:0x08c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:371:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:373:0x08db  */
    /* JADX WARN: Code duplicated, block: B:375:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:377:0x08f0 A[LOOP:11: B:374:0x08e6->B:377:0x08f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:378:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:380:0x090b  */
    /* JADX WARN: Code duplicated, block: B:382:0x0917 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:388:0x0924  */
    /* JADX WARN: Code duplicated, block: B:393:0x0933  */
    /* JADX WARN: Code duplicated, block: B:395:0x0945  */
    /* JADX WARN: Code duplicated, block: B:396:0x094e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:397:0x0950  */
    /* JADX WARN: Code duplicated, block: B:399:0x0969  */
    /* JADX WARN: Code duplicated, block: B:401:0x097e  */
    /* JADX WARN: Code duplicated, block: B:403:0x098a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:409:0x0997 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:413:0x09a5  */
    /* JADX WARN: Code duplicated, block: B:415:0x09ba  */
    /* JADX WARN: Code duplicated, block: B:417:0x09c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:423:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:428:0x09e5  */
    /* JADX WARN: Code duplicated, block: B:430:0x09fa  */
    /* JADX WARN: Code duplicated, block: B:432:0x0a06 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:438:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:451:0x0a82  */
    /* JADX WARN: Code duplicated, block: B:454:0x0a94  */
    /* JADX WARN: Code duplicated, block: B:457:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:459:0x0ac0  */
    /* JADX WARN: Code duplicated, block: B:460:0x0acc  */
    /* JADX WARN: Code duplicated, block: B:462:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:464:0x0b01  */
    /* JADX WARN: Code duplicated, block: B:466:0x0b11  */
    /* JADX WARN: Code duplicated, block: B:468:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:473:0x0b42  */
    /* JADX WARN: Code duplicated, block: B:475:0x0b4d  */
    /* JADX WARN: Code duplicated, block: B:476:0x0b64  */
    /* JADX WARN: Code duplicated, block: B:478:0x0b70  */
    /* JADX WARN: Code duplicated, block: B:482:0x0b82  */
    /* JADX WARN: Code duplicated, block: B:486:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:488:0x0bb5  */
    /* JADX WARN: Code duplicated, block: B:489:0x0bc2  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bcc  */
    /* JADX WARN: Code duplicated, block: B:492:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:493:0x0c03  */
    /* JADX WARN: Code duplicated, block: B:494:0x0c0d  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c27  */
    /* JADX WARN: Code duplicated, block: B:498:0x0c2f  */
    /* JADX WARN: Code duplicated, block: B:499:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:508:0x0c5e  */
    /* JADX WARN: Code duplicated, block: B:509:0x0c62  */
    /* JADX WARN: Code duplicated, block: B:511:0x0c77  */
    /* JADX WARN: Code duplicated, block: B:513:0x0c81  */
    /* JADX WARN: Code duplicated, block: B:514:0x0c83  */
    /* JADX WARN: Code duplicated, block: B:516:0x0c90  */
    /* JADX WARN: Code duplicated, block: B:518:0x0ca6  */
    /* JADX WARN: Code duplicated, block: B:519:0x0cb8  */
    /* JADX WARN: Code duplicated, block: B:521:0x0cce  */
    /* JADX WARN: Code duplicated, block: B:522:0x0ce0  */
    /* JADX WARN: Code duplicated, block: B:524:0x0cf5  */
    /* JADX WARN: Code duplicated, block: B:525:0x0d07  */
    /* JADX WARN: Code duplicated, block: B:527:0x0d1c  */
    /* JADX WARN: Code duplicated, block: B:528:0x0d2e  */
    /* JADX WARN: Code duplicated, block: B:530:0x0d44  */
    /* JADX WARN: Code duplicated, block: B:531:0x0d59  */
    /* JADX WARN: Code duplicated, block: B:533:0x0d6f  */
    /* JADX WARN: Code duplicated, block: B:534:0x0d84 A[PHI: r0 r1 r2 r5 r6 r8 r18
      0x0d84: PHI (r0v117 int) = 
      (r0v91 int)
      (r0v92 int)
      (r0v93 int)
      (r0v94 int)
      (r0v95 int)
      (r0v96 int)
      (r0v97 int)
      (r0v98 int)
      (r0v101 int)
      (r0v110 int)
      (r0v118 int)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r1v186 int) = 
      (r1v163 int)
      (r1v164 int)
      (r1v165 int)
      (r1v166 int)
      (r1v167 int)
      (r1v168 int)
      (r1v169 int)
      (r1v170 int)
      (r1v175 int)
      (r1v180 int)
      (r1v187 int)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r2v110 int) = 
      (r2v95 int)
      (r2v96 int)
      (r2v97 int)
      (r2v98 int)
      (r2v99 int)
      (r2v100 int)
      (r2v101 int)
      (r2v102 int)
      (r2v105 int)
      (r2v107 int)
      (r2v111 int)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r5v103 com.google.android.gms.internal.play_billing.T) = 
      (r5v73 com.google.android.gms.internal.play_billing.T)
      (r5v74 com.google.android.gms.internal.play_billing.T)
      (r5v75 com.google.android.gms.internal.play_billing.T)
      (r5v76 com.google.android.gms.internal.play_billing.T)
      (r5v77 com.google.android.gms.internal.play_billing.T)
      (r5v78 com.google.android.gms.internal.play_billing.T)
      (r5v79 com.google.android.gms.internal.play_billing.T)
      (r5v80 com.google.android.gms.internal.play_billing.T)
      (r5v85 com.google.android.gms.internal.play_billing.T)
      (r2v94 com.google.android.gms.internal.play_billing.T)
      (r5v104 com.google.android.gms.internal.play_billing.T)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r6v88 com.google.android.gms.internal.play_billing.h1) = 
      (r6v54 com.google.android.gms.internal.play_billing.h1)
      (r6v55 com.google.android.gms.internal.play_billing.h1)
      (r6v56 com.google.android.gms.internal.play_billing.h1)
      (r6v57 com.google.android.gms.internal.play_billing.h1)
      (r6v58 com.google.android.gms.internal.play_billing.h1)
      (r6v59 com.google.android.gms.internal.play_billing.h1)
      (r6v60 com.google.android.gms.internal.play_billing.h1)
      (r6v61 com.google.android.gms.internal.play_billing.h1)
      (r6v67 com.google.android.gms.internal.play_billing.h1)
      (r6v80 com.google.android.gms.internal.play_billing.h1)
      (r6v89 com.google.android.gms.internal.play_billing.h1)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r8v138 byte[]) = 
      (r8v112 byte[])
      (r8v113 byte[])
      (r8v114 byte[])
      (r8v115 byte[])
      (r8v116 byte[])
      (r8v117 byte[])
      (r8v118 byte[])
      (r8v119 byte[])
      (r8v121 byte[])
      (r8v130 byte[])
      (r8v139 byte[])
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]
      0x0d84: PHI (r18v53 int) = 
      (r18v29 int)
      (r18v30 int)
      (r18v31 int)
      (r18v32 int)
      (r18v33 int)
      (r18v34 int)
      (r18v35 int)
      (r18v36 int)
      (r18v42 int)
      (r18v47 int)
      (r18v54 int)
     binds: [B:532:0x0d6d, B:529:0x0d42, B:526:0x0d1a, B:523:0x0cf3, B:520:0x0ccc, B:517:0x0ca4, B:510:0x0c75, B:508:0x0c5e, B:489:0x0bc2, B:465:0x0b0d, B:459:0x0ac0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:546:0x0ddc  */
    /* JADX WARN: Code duplicated, block: B:580:0x0d87 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x01cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x0355 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x037d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x039b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x03be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x0403 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x0426 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x0473 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x05ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x05a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x05c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x05fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0749 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0744 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0737 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0732 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0804 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x07f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0866 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0861 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x085c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0857 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x089a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x0895 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x08a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x08d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0920 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x091b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x092c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0993 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x098e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x099c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x09ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x09c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x09da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x0a0e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x0a09 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x0a46 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0a1c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0a6d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0456 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x016d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0344 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x036b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x0389 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x03cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x03f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0414 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x02de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x027d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x029f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x02c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0339 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0441 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x0441 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x04de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x04c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x0470 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:670:0x0a51 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x0a34 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x0da0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x04ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0a6b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x0568 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x0569 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x06bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x06a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:694:0x072a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:696:0x073c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x0724 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x07fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:704:0x07ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x07e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:0x07fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:712:0x0844 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:713:0x0840 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x0891 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:723:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x02cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x0245 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:0x0261 A[EDGE_INSN: B:729:0x0261->B:726:0x0261 BREAK  A[LOOP:15: B:93:0x024e->B:96:0x0258], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:79:0x0206  */
    /* JADX WARN: Code duplicated, block: B:81:0x020a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0215  */
    /* JADX WARN: Code duplicated, block: B:84:0x0220  */
    /* JADX WARN: Code duplicated, block: B:86:0x0227  */
    /* JADX WARN: Code duplicated, block: B:88:0x022f A[LOOP:12: B:85:0x0225->B:88:0x022f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x023b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0250  */
    /* JADX WARN: Code duplicated, block: B:96:0x0258 A[LOOP:15: B:93:0x024e->B:96:0x0258, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x0263  */
    final int y(Object obj, byte[] bArr, int i3, int i4, int i5, T t3) throws L0 {
        C0430h1 c0430h1;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iF;
        T t4;
        int i11;
        C0430h1 c0430h2;
        int iJ;
        byte[] bArr2;
        int i12;
        int i13;
        int iG;
        C0460r0 c0460r0;
        int i14;
        int[] iArr;
        int i15;
        int iG2;
        long j3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        T t5;
        Unsafe unsafe2;
        boolean z3;
        boolean z4;
        int iH;
        int i23;
        int iH2;
        int i24;
        int i25;
        int length;
        int i26;
        char[] cArr;
        int i27;
        int i28;
        int i29;
        byte b3;
        byte b4;
        int i30;
        boolean z5;
        byte b5;
        int i31;
        int i32;
        Unsafe unsafe3;
        int i33;
        int i34;
        Unsafe unsafe4;
        int i35;
        T t6;
        int i36;
        int i37;
        int i38;
        int i39;
        T t7;
        int i40;
        int i41;
        I0 i0E;
        int size;
        int i42;
        T t8;
        long j4;
        Unsafe unsafe5;
        I0 i43;
        int i44;
        int i45;
        int i46;
        int i47;
        C0430h1 c0430h3;
        int i48;
        int iH3;
        int i49;
        int i50;
        int i51;
        int i52;
        int i53;
        int i54;
        int iH4;
        int i55;
        C0 c3;
        int iH5;
        C0 c4;
        int i56;
        int i57;
        I0 i58;
        int i59;
        int i60;
        int iH6;
        int i61;
        int i62;
        int i63;
        I0 i64;
        int iH7;
        int i65;
        int i66;
        int i67;
        int iH8;
        int i68;
        int iH9;
        int i69;
        int i70;
        int i71;
        int i72;
        int iJ2;
        F0 f0J;
        AbstractC0470u1 abstractC0470u1;
        int i73;
        Iterator it;
        Object objU;
        int iIntValue;
        int size2;
        Object objU2;
        int i74;
        int i75;
        Integer num;
        int iIntValue2;
        int i76;
        Unsafe unsafe6;
        C0 c5;
        int iH10;
        int iH11;
        C0 c6;
        int i77;
        int i78;
        int i79;
        InterfaceC0456p1 interfaceC0456p1K;
        int i80;
        int iH12;
        int size3;
        int i81;
        Unsafe unsafe7;
        Object object;
        Unsafe unsafe8;
        long j5;
        int i82;
        int i83;
        boolean z6;
        int i84;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i90;
        F0 f0J2;
        C0430h1 c0430h4 = this;
        Object obj2 = obj;
        byte[] bArr3 = bArr;
        int i91 = i4;
        i5 = i5;
        T t9 = t3;
        int i92 = 3;
        j(obj);
        Unsafe unsafe9 = f7432p;
        int i93 = 0;
        int i94 = -1;
        int iL = i3;
        int i95 = -1;
        int i96 = 0;
        int i97 = 1048575;
        int i98 = 0;
        int i99 = 0;
        while (true) {
            if (iL < i91) {
                int i100 = iL + 1;
                int i101 = bArr3[iL];
                if (i101 < 0) {
                    i100 = U.i(i101, bArr3, i100, t9);
                    i101 = t9.f7372a;
                }
                int i102 = i101 >>> 3;
                if (i102 > i95) {
                    iF = (i102 < c0430h4.f7435c || i102 > c0430h4.f7436d) ? -1 : c0430h4.F(i102, i96 / i92);
                } else {
                    if (i102 < c0430h4.f7435c || i102 > c0430h4.f7436d) {
                        i10 = -1;
                    } else {
                        iF = c0430h4.F(i102, i93);
                    }
                    if (i10 == i94) {
                        t4 = t9;
                        i5 = i5;
                        i11 = i102;
                        unsafe = unsafe9;
                        i96 = 0;
                        c0430h2 = c0430h4;
                        iJ = i100;
                        i8 = i101;
                        bArr2 = bArr3;
                        i12 = i98;
                    } else {
                        i14 = i101 & 7;
                        iArr = c0430h4.f7433a;
                        i15 = iArr[i10 + 1];
                        iG2 = G(i15);
                        j3 = i15 & 1048575;
                        i16 = i101;
                        if (iG2 <= 17) {
                            int i103 = iArr[i10 + 2];
                            i17 = 1 << (i103 >>> 20);
                            i18 = i103 & 1048575;
                            i19 = i97;
                            if (i18 != i19) {
                                if (i19 != 1048575) {
                                    unsafe9.putInt(obj2, i19, i98);
                                }
                                if (i18 == 1048575) {
                                    i33 = 0;
                                } else {
                                    i33 = unsafe9.getInt(obj2, i18);
                                }
                                i97 = i18;
                                i98 = i33;
                            } else {
                                i97 = i19;
                            }
                            switch (iG2) {
                                case 0:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 1) {
                                        iL = i100 + 8;
                                        i98 |= i17;
                                        E1.t(obj2, j3, Double.longBitsToDouble(U.n(bArr3, i100)));
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22 == true ? 1 : 0;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 1:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 5) {
                                        iL = i100 + 4;
                                        i98 |= i17;
                                        E1.u(obj2, j3, Float.intBitsToFloat(U.b(bArr3, i100)));
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 0) {
                                        i98 |= i17;
                                        iL = U.k(bArr3, i100, t5);
                                        unsafe2.putLong(obj, j3, t5.f7373b);
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 0) {
                                        i98 |= i17;
                                        iL = U.h(bArr3, i100, t5);
                                        unsafe2.putInt(obj2, j3, t5.f7372a);
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 1) {
                                        iL = i100 + 8;
                                        i98 |= i17;
                                        unsafe2.putLong(obj, j3, U.n(bArr3, i100));
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 5) {
                                        iL = i100 + 4;
                                        i98 |= i17;
                                        unsafe2.putInt(obj2, j3, U.b(bArr3, i100));
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 7:
                                    i22 = i16 == true ? 1 : 0;
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 0) {
                                        i98 |= i17;
                                        iL = U.k(bArr3, i100, t5);
                                        if (t5.f7373b != 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        E1.r(obj2, j3, z3);
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 8:
                                    i100 = i100;
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    z4 = i16 == true ? 1 : 0;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 2) {
                                        if ((i15 & 536870912) != 0) {
                                            iH2 = U.h(bArr3, i100, t5);
                                            i24 = t5.f7372a;
                                            if (i24 >= 0) {
                                                throw L0.d();
                                            }
                                            i25 = i98 | i17;
                                            if (i24 == 0) {
                                                t5.f7374c = "";
                                                i28 = i25;
                                                i22 = z4 ? 1 : 0;
                                            } else {
                                                int i104 = J1.f7340b;
                                                length = bArr3.length;
                                                if ((((length - iH2) - i24) | iH2 | i24) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iH2), Integer.valueOf(i24)));
                                                }
                                                i26 = iH2 + i24;
                                                cArr = new char[i24];
                                                i27 = 0;
                                                while (iH2 < i26) {
                                                    b5 = bArr3[iH2];
                                                    if (F1.d(b5)) {
                                                        iH2++;
                                                        cArr[i27] = (char) b5;
                                                        i27++;
                                                    } else {
                                                        while (true) {
                                                            z4 = z4;
                                                            while (true) {
                                                                if (iH2 < i26) {
                                                                    i29 = iH2 + 1;
                                                                    b3 = bArr3[iH2];
                                                                    if (F1.d(b3)) {
                                                                        cArr[i27] = (char) b3;
                                                                        i27++;
                                                                        iH2 = i29;
                                                                        while (iH2 < i26) {
                                                                            b4 = bArr3[iH2];
                                                                            if (F1.d(b4)) {
                                                                            }
                                                                            iH2++;
                                                                            cArr[i27] = (char) b4;
                                                                            i27++;
                                                                        }
                                                                    } else {
                                                                        i30 = i25;
                                                                        if (b3 < -32) {
                                                                            if (i29 < i26) {
                                                                                throw L0.c();
                                                                            }
                                                                            iH2 += 2;
                                                                            F1.c(b3, bArr3[i29], cArr, i27);
                                                                            i27++;
                                                                        } else if (b3 < -16) {
                                                                            z5 = z4 ? 1 : 0;
                                                                            if (i29 < i26 - 2) {
                                                                                throw L0.c();
                                                                            }
                                                                            byte b6 = bArr3[i29];
                                                                            int i105 = iH2 + 3;
                                                                            byte b7 = bArr3[iH2 + 2];
                                                                            iH2 += 4;
                                                                            F1.a(b3, b6, b7, bArr3[i105], cArr, i27);
                                                                            i27 += 2;
                                                                            i25 = i30;
                                                                            z4 = z5 ? 1 : 0;
                                                                        } else {
                                                                            if (i29 < i26 - 1) {
                                                                                throw L0.c();
                                                                            }
                                                                            int i106 = iH2 + 2;
                                                                            byte b8 = bArr3[i29];
                                                                            boolean z7 = z4 ? 1 : 0;
                                                                            iH2 += 3;
                                                                            F1.b(b3, b8, bArr3[i106], cArr, i27);
                                                                            i27++;
                                                                            z4 = z7 ? 1 : 0;
                                                                        }
                                                                        i25 = i30;
                                                                        z4 = z4;
                                                                    }
                                                                } else {
                                                                    i28 = i25;
                                                                    i22 = z4 ? 1 : 0;
                                                                    t5.f7374c = new String(cArr, 0, i27);
                                                                    iH2 = i26;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                                while (true) {
                                                    z4 = z4;
                                                    while (true) {
                                                        if (iH2 < i26) {
                                                            i29 = iH2 + 1;
                                                            b3 = bArr3[iH2];
                                                            if (F1.d(b3)) {
                                                                cArr[i27] = (char) b3;
                                                                i27++;
                                                                iH2 = i29;
                                                                while (iH2 < i26) {
                                                                    b4 = bArr3[iH2];
                                                                    if (F1.d(b4)) {
                                                                    }
                                                                    iH2++;
                                                                    cArr[i27] = (char) b4;
                                                                    i27++;
                                                                }
                                                            } else {
                                                                i30 = i25;
                                                                if (b3 < -32) {
                                                                    if (i29 < i26) {
                                                                        throw L0.c();
                                                                    }
                                                                    iH2 += 2;
                                                                    F1.c(b3, bArr3[i29], cArr, i27);
                                                                    i27++;
                                                                } else if (b3 < -16) {
                                                                    z5 = z4 ? 1 : 0;
                                                                    if (i29 < i26 - 2) {
                                                                        throw L0.c();
                                                                    }
                                                                    byte b9 = bArr3[i29];
                                                                    int i107 = iH2 + 3;
                                                                    byte b10 = bArr3[iH2 + 2];
                                                                    iH2 += 4;
                                                                    F1.a(b3, b9, b10, bArr3[i107], cArr, i27);
                                                                    i27 += 2;
                                                                    i25 = i30;
                                                                    z4 = z5 ? 1 : 0;
                                                                } else {
                                                                    if (i29 < i26 - 1) {
                                                                        throw L0.c();
                                                                    }
                                                                    int i108 = iH2 + 2;
                                                                    byte b11 = bArr3[i29];
                                                                    boolean z8 = z4 ? 1 : 0;
                                                                    iH2 += 3;
                                                                    F1.b(b3, b11, bArr3[i108], cArr, i27);
                                                                    i27++;
                                                                    z4 = z8 ? 1 : 0;
                                                                }
                                                                i25 = i30;
                                                                z4 = z4;
                                                            }
                                                        } else {
                                                            i28 = i25;
                                                            i22 = z4 ? 1 : 0;
                                                            t5.f7374c = new String(cArr, 0, i27);
                                                            iH2 = i26;
                                                        }
                                                    }
                                                }
                                            }
                                            i98 = i28;
                                            iL = iH2;
                                        } else {
                                            i22 = z4 ? 1 : 0;
                                            iH = U.h(bArr3, i100, t5);
                                            i23 = t5.f7372a;
                                            if (i23 >= 0) {
                                                throw L0.d();
                                            }
                                            int i109 = i98 | i17;
                                            if (i23 == 0) {
                                                t5.f7374c = "";
                                            } else {
                                                t5.f7374c = new String(bArr3, iH, i23, J0.f7334b);
                                                iH += i23;
                                            }
                                            iL = iH;
                                            i98 = i109;
                                        }
                                        unsafe2.putObject(obj2, j3, t5.f7374c);
                                        i91 = i4;
                                        i5 = i5;
                                        t9 = t5;
                                        i96 = i21;
                                        i99 = i22;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i22 = z4 ? 1 : 0;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 9:
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i31 = i16 == true ? 1 : 0;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 2) {
                                        i98 |= i17;
                                        Object objM = c0430h4.M(obj2, i21);
                                        i91 = i4;
                                        int iM = U.m(objM, c0430h4.K(i21), bArr, i100, i91, t3);
                                        c0430h4.o(obj2, i21, objM);
                                        iL = iM;
                                        t9 = t5;
                                        i99 = i31;
                                        i96 = i21;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i22 = i31;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 10:
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i31 = i16 == true ? 1 : 0;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 2) {
                                        i98 |= i17;
                                        iL = U.a(bArr3, i100, t5);
                                        unsafe2.putObject(obj2, j3, t5.f7374c);
                                        i91 = i4;
                                        t9 = t5;
                                        i99 = i31;
                                        i96 = i21;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i22 = i31;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 12:
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i31 = i16 == true ? 1 : 0;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 0) {
                                        iL = U.h(bArr3, i100, t5);
                                        i32 = t5.f7372a;
                                        F0 f0J3 = c0430h4.J(i21);
                                        if ((i15 & Integer.MIN_VALUE) != 0 || f0J3 == null || f0J3.a(i32)) {
                                            i98 |= i17;
                                            unsafe2.putInt(obj2, j3, i32);
                                        } else {
                                            z(obj).j(i31 == true ? 1 : 0, Long.valueOf(i32));
                                        }
                                        i91 = i4;
                                        t9 = t5;
                                        i99 = i31;
                                        i96 = i21;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i22 = i31;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 15:
                                    i20 = i102;
                                    unsafe2 = unsafe9;
                                    i31 = i16 == true ? 1 : 0;
                                    i21 = i10;
                                    t5 = t9;
                                    if (i14 == 0) {
                                        i98 |= i17;
                                        iL = U.h(bArr3, i100, t5);
                                        unsafe2.putInt(obj2, j3, AbstractC0437j0.a(t5.f7372a));
                                        i91 = i4;
                                        t9 = t5;
                                        i99 = i31;
                                        i96 = i21;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        i22 = i31;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                case 16:
                                    i20 = i102;
                                    unsafe3 = unsafe9;
                                    i21 = i10;
                                    if (i14 == 0) {
                                        i98 |= i17;
                                        iL = U.k(bArr3, i100, t9);
                                        unsafe2 = unsafe3;
                                        unsafe3.putLong(obj, j3, AbstractC0437j0.b(t9.f7373b));
                                        i91 = i4;
                                        i5 = i5;
                                        i99 = i16 == true ? 1 : 0;
                                        t9 = t9;
                                        i96 = i21;
                                        i95 = i20;
                                        i92 = 3;
                                        i94 = -1;
                                        unsafe9 = unsafe2;
                                        i93 = 0;
                                    } else {
                                        unsafe2 = unsafe3;
                                        t5 = t9;
                                        i22 = i16 == true ? 1 : 0;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                                default:
                                    i92 = 3;
                                    if (i14 == 3) {
                                        i98 |= i17;
                                        Object objM2 = c0430h4.M(obj2, i10);
                                        int i110 = i10;
                                        iL = U.l(objM2, c0430h4.K(i10), bArr, i100, i4, (i102 << 3) | 4, t3);
                                        c0430h4.o(obj2, i110, objM2);
                                        i96 = i110;
                                        unsafe9 = unsafe9;
                                        i99 = i16 == true ? 1 : 0;
                                        i95 = i102;
                                        i94 = -1;
                                        i93 = 0;
                                        i91 = i4;
                                        i5 = i5;
                                    } else {
                                        i20 = i102;
                                        Unsafe unsafe10 = unsafe9;
                                        i21 = i10;
                                        i22 = i16 == true ? 1 : 0;
                                        t5 = t9;
                                        unsafe2 = unsafe10;
                                        i5 = i5;
                                        c0430h2 = c0430h4;
                                        iJ = i100;
                                        t4 = t5;
                                        unsafe = unsafe2;
                                        i96 = i21;
                                        bArr2 = bArr3;
                                        i12 = i98;
                                        i8 = i22;
                                        i11 = i20;
                                    }
                                    break;
                            }
                        } else {
                            i34 = i102;
                            unsafe4 = unsafe9;
                            i35 = i10;
                            t6 = t9;
                            i36 = i100;
                            i37 = i97;
                            i12 = i98;
                            if (iG2 == 27) {
                                i38 = i37;
                                t8 = t6;
                                if (iG2 <= 49) {
                                    j4 = i15;
                                    unsafe5 = f7432p;
                                    i43 = (I0) unsafe5.getObject(obj2, j3);
                                    if (i43.b()) {
                                        i36 = i36;
                                    } else {
                                        size3 = i43.size();
                                        if (size3 == 0) {
                                            i81 = 10;
                                        } else {
                                            i81 = size3 + size3;
                                        }
                                        I0 i0E2 = i43.e(i81);
                                        unsafe5.putObject(obj2, j3, i0E2);
                                        i43 = i0E2;
                                    }
                                    switch (iG2) {
                                        case 18:
                                        case 35:
                                            i44 = i4;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i45 = i36;
                                            i46 = i35;
                                            i47 = i34;
                                            c0430h3 = c0430h4;
                                            i48 = i16 == true ? 1 : 0;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH3 = U.h(bArr3, i45, t8);
                                                i49 = t8.f7372a + iH3;
                                                if (iH3 >= i49) {
                                                    Double.longBitsToDouble(U.n(bArr3, iH3));
                                                    throw null;
                                                }
                                                if (iH3 != i49) {
                                                    throw L0.g();
                                                }
                                                iJ = iH3;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 1) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    Double.longBitsToDouble(U.n(bArr3, i45));
                                                    throw null;
                                                }
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i44 = i4;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i45 = i36;
                                            i46 = i35;
                                            i47 = i34;
                                            c0430h3 = c0430h4;
                                            i48 = i16 == true ? 1 : 0;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH3 = U.h(bArr3, i45, t8);
                                                i50 = t8.f7372a + iH3;
                                                if (iH3 >= i50) {
                                                    Float.intBitsToFloat(U.b(bArr3, iH3));
                                                    throw null;
                                                }
                                                if (iH3 != i50) {
                                                    throw L0.g();
                                                }
                                                iJ = iH3;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 5) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    Float.intBitsToFloat(U.b(bArr3, i45));
                                                    throw null;
                                                }
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i44 = i4;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i45 = i36;
                                            i46 = i35;
                                            i47 = i34;
                                            c0430h3 = c0430h4;
                                            i48 = i16 == true ? 1 : 0;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH3 = U.h(bArr3, i45, t8);
                                                i51 = t8.f7372a + iH3;
                                                if (iH3 >= i51) {
                                                    U.k(bArr3, iH3, t8);
                                                    throw null;
                                                }
                                                if (iH3 != i51) {
                                                    throw L0.g();
                                                }
                                                iJ = iH3;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 0) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    U.k(bArr3, i45, t8);
                                                    long j6 = t8.f7373b;
                                                    throw null;
                                                }
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i52 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i53 = i36;
                                            i54 = i34;
                                            i46 = i35;
                                            if (i14 == 2) {
                                                if (i14 == 0) {
                                                    i47 = i54;
                                                    i44 = i52;
                                                    i45 = i53;
                                                    iJ = U.j(i48 == true ? 1 : 0, bArr, i53, i4, i43, t3);
                                                    c0430h3 = this;
                                                    if (iJ != i45) {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i99 = i48;
                                                        c0430h4 = c0430h3;
                                                        i91 = i44;
                                                        i95 = i47;
                                                        i96 = i46;
                                                        i98 = i12;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        iL = iJ;
                                                        t9 = t8;
                                                        obj2 = obj;
                                                    } else {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i8 = i48;
                                                        c0430h2 = c0430h3;
                                                        t4 = t8;
                                                        i11 = i47;
                                                        i96 = i46;
                                                        bArr2 = bArr3;
                                                        i12 = i12;
                                                        i97 = i38;
                                                        obj2 = obj;
                                                    }
                                                }
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                                break;
                                            } else {
                                                iJ = U.f(bArr3, i53, i43, t8);
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i52 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i53 = i36;
                                            i54 = i34;
                                            i46 = i35;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH4 = U.h(bArr3, i53, t8);
                                                i55 = t8.f7372a + iH4;
                                                if (iH4 >= i55) {
                                                    U.n(bArr3, iH4);
                                                    throw null;
                                                }
                                                if (iH4 != i55) {
                                                    throw L0.g();
                                                }
                                                i47 = i54;
                                                iJ = iH4;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 1) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    U.n(bArr3, i53);
                                                    throw null;
                                                }
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i52 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i53 = i36;
                                            i54 = i34;
                                            i46 = i35;
                                            if (i14 == 2) {
                                                if (i14 == 5) {
                                                    iH4 = i53 + 4;
                                                    c3 = (C0) i43;
                                                    c3.d(U.b(bArr3, i53));
                                                    while (iH4 < i52) {
                                                        iH5 = U.h(bArr3, iH4, t8);
                                                        if (i48 == t8.f7372a) {
                                                            c3.d(U.b(bArr3, iH5));
                                                            iH4 = iH5 + 4;
                                                        }
                                                    }
                                                }
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                c4 = (C0) i43;
                                                iH4 = U.h(bArr3, i53, t8);
                                                i56 = t8.f7372a + iH4;
                                                while (iH4 < i56) {
                                                    c4.d(U.b(bArr3, iH4));
                                                    iH4 += 4;
                                                }
                                                if (iH4 != i56) {
                                                    throw L0.g();
                                                }
                                            }
                                            i47 = i54;
                                            iJ = iH4;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i52 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i53 = i36;
                                            i54 = i34;
                                            i46 = i35;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH4 = U.h(bArr3, i53, t8);
                                                i57 = t8.f7372a + iH4;
                                                if (iH4 >= i57) {
                                                    U.k(bArr3, iH4, t8);
                                                    throw null;
                                                }
                                                if (iH4 != i57) {
                                                    throw L0.g();
                                                }
                                                i47 = i54;
                                                iJ = iH4;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 0) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    U.k(bArr3, i53, t8);
                                                    long j7 = t8.f7373b;
                                                    throw null;
                                                }
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 26:
                                            i52 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            i58 = i43;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i53 = i36;
                                            i54 = i34;
                                            i46 = i35;
                                            if (i14 == 2) {
                                                if ((j4 & 536870912) == 0) {
                                                    iJ = U.h(bArr3, i53, t8);
                                                    i63 = t8.f7372a;
                                                    if (i63 >= 0) {
                                                        throw L0.d();
                                                    }
                                                    if (i63 == 0) {
                                                        i64 = i58;
                                                        i64.add("");
                                                    } else {
                                                        i64 = i58;
                                                        i64.add(new String(bArr3, iJ, i63, J0.f7334b));
                                                        iJ += i63;
                                                    }
                                                    while (iJ < i52) {
                                                        iH7 = U.h(bArr3, iJ, t8);
                                                        if (i48 == t8.f7372a) {
                                                            iJ = U.h(bArr3, iH7, t8);
                                                            i65 = t8.f7372a;
                                                            if (i65 >= 0) {
                                                                throw L0.d();
                                                            }
                                                            if (i65 == 0) {
                                                                i64.add("");
                                                            } else {
                                                                i64.add(new String(bArr3, iJ, i65, J0.f7334b));
                                                                iJ += i65;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iJ = U.h(bArr3, i53, t8);
                                                    i59 = t8.f7372a;
                                                    if (i59 >= 0) {
                                                        throw L0.d();
                                                    }
                                                    if (i59 == 0) {
                                                        i58.add("");
                                                    } else {
                                                        i60 = iJ + i59;
                                                        if (J1.e(bArr3, iJ, i60)) {
                                                            throw L0.c();
                                                        }
                                                        i58.add(new String(bArr3, iJ, i59, J0.f7334b));
                                                        iJ = i60;
                                                    }
                                                    while (iJ < i52) {
                                                        iH6 = U.h(bArr3, iJ, t8);
                                                        if (i48 == t8.f7372a) {
                                                            iJ = U.h(bArr3, iH6, t8);
                                                            i61 = t8.f7372a;
                                                            if (i61 >= 0) {
                                                                throw L0.d();
                                                            }
                                                            if (i61 == 0) {
                                                                i58.add("");
                                                            } else {
                                                                i62 = iJ + i61;
                                                                if (J1.e(bArr3, iJ, i62)) {
                                                                    throw L0.c();
                                                                }
                                                                i58.add(new String(bArr3, iJ, i61, J0.f7334b));
                                                                iJ = i62;
                                                            }
                                                        }
                                                    }
                                                }
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        case 27:
                                            i66 = i36;
                                            i67 = i34;
                                            if (i14 == 2) {
                                                InterfaceC0456p1 interfaceC0456p1K2 = K(i35);
                                                i48 = i16 == true ? 1 : 0;
                                                t8 = t8;
                                                unsafe = unsafe4;
                                                i47 = i67;
                                                i45 = i66;
                                                iJ = U.e(interfaceC0456p1K2, i16 == true ? 1 : 0, bArr, i66, i4, i43, t3);
                                                c0430h3 = this;
                                                i44 = i4;
                                            } else {
                                                unsafe = unsafe4;
                                                i48 = i16 == true ? 1 : 0;
                                                i44 = i4;
                                                i45 = i66;
                                                i46 = i35;
                                                i47 = i67;
                                                c0430h3 = this;
                                                iJ = i45;
                                            }
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        case 28:
                                            i66 = i36;
                                            i67 = i34;
                                            if (i14 == 2) {
                                                iH8 = U.h(bArr3, i66, t8);
                                                i68 = t8.f7372a;
                                                if (i68 >= 0) {
                                                    throw L0.d();
                                                }
                                                if (i68 <= bArr3.length - iH8) {
                                                    throw L0.g();
                                                }
                                                if (i68 == 0) {
                                                    i43.add(AbstractC0421f0.f7421b);
                                                } else {
                                                    i43.add(AbstractC0421f0.t(bArr3, iH8, i68));
                                                    iH8 += i68;
                                                }
                                                while (iH8 < i4) {
                                                    iH9 = U.h(bArr3, iH8, t8);
                                                    if (i16 == t8.f7372a) {
                                                        unsafe = unsafe4;
                                                        iJ = iH8;
                                                        i44 = i4;
                                                        i48 = i16 == true ? 1 : 0;
                                                        i45 = i66;
                                                        i46 = i35;
                                                        i47 = i67;
                                                        c0430h3 = this;
                                                        if (iJ != i45) {
                                                            i46 = i35;
                                                            i5 = i5;
                                                            i99 = i48;
                                                            c0430h4 = c0430h3;
                                                            i91 = i44;
                                                            i95 = i47;
                                                            i96 = i46;
                                                            i98 = i12;
                                                            i97 = i38;
                                                            unsafe9 = unsafe;
                                                            i92 = 3;
                                                            i94 = -1;
                                                            i93 = 0;
                                                            iL = iJ;
                                                            t9 = t8;
                                                            obj2 = obj;
                                                        } else {
                                                            i46 = i35;
                                                            i5 = i5;
                                                            i8 = i48;
                                                            c0430h2 = c0430h3;
                                                            t4 = t8;
                                                            i11 = i47;
                                                            i96 = i46;
                                                            bArr2 = bArr3;
                                                            i12 = i12;
                                                            i97 = i38;
                                                            obj2 = obj;
                                                        }
                                                        break;
                                                    } else {
                                                        iH8 = U.h(bArr3, iH9, t8);
                                                        i69 = t8.f7372a;
                                                        if (i69 >= 0) {
                                                            throw L0.d();
                                                        }
                                                        if (i69 <= bArr3.length - iH8) {
                                                            throw L0.g();
                                                        }
                                                        if (i69 == 0) {
                                                            i43.add(AbstractC0421f0.f7421b);
                                                        } else {
                                                            i43.add(AbstractC0421f0.t(bArr3, iH8, i69));
                                                            iH8 += i69;
                                                        }
                                                    }
                                                }
                                                unsafe = unsafe4;
                                                iJ = iH8;
                                                i44 = i4;
                                                i48 = i16 == true ? 1 : 0;
                                                i45 = i66;
                                                i46 = i35;
                                                i47 = i67;
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                unsafe = unsafe4;
                                                i44 = i4;
                                                i48 = i16 == true ? 1 : 0;
                                                i45 = i66;
                                                i46 = i35;
                                                i47 = i67;
                                                c0430h3 = this;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i70 = i4;
                                            i71 = i16 == true ? 1 : 0;
                                            i72 = i36;
                                            if (i14 == 2) {
                                                iJ2 = U.f(bArr3, i72, i43, t8);
                                            } else if (i14 == 0) {
                                                c0430h3 = this;
                                                unsafe = unsafe4;
                                                i44 = i70;
                                                i48 = i71;
                                                t8 = t8;
                                                i45 = i72;
                                                i46 = i35;
                                                i47 = i34;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                iJ2 = U.j(i71 == true ? 1 : 0, bArr, i72, i4, i43, t3);
                                            }
                                            f0J = c0430h4.J(i35);
                                            abstractC0470u1 = c0430h4.f7443k;
                                            int i111 = AbstractC0461r1.f7499d;
                                            if (f0J != null) {
                                                i73 = iJ2;
                                                i67 = i34;
                                            } else if (i43 instanceof RandomAccess) {
                                                size2 = i43.size();
                                                objU2 = null;
                                                i74 = 0;
                                                i75 = 0;
                                                while (i74 < size2) {
                                                    int i112 = iJ2;
                                                    num = (Integer) i43.get(i74);
                                                    iIntValue2 = num.intValue();
                                                    if (f0J.a(iIntValue2)) {
                                                        if (i74 != i75) {
                                                            i43.set(i75, num);
                                                        }
                                                        i75++;
                                                        i76 = i34;
                                                    } else {
                                                        i76 = i34;
                                                        objU2 = AbstractC0461r1.u(obj2, i76, iIntValue2, objU2, abstractC0470u1);
                                                    }
                                                    i74++;
                                                    i34 = i76;
                                                    iJ2 = i112;
                                                }
                                                i73 = iJ2;
                                                i67 = i34;
                                                if (i75 != size2) {
                                                    i43.subList(i75, size2).clear();
                                                }
                                            } else {
                                                i73 = iJ2;
                                                i67 = i34;
                                                it = i43.iterator();
                                                objU = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!f0J.a(iIntValue)) {
                                                        objU = AbstractC0461r1.u(obj2, i67, iIntValue, objU, abstractC0470u1);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            unsafe = unsafe4;
                                            i44 = i70;
                                            i48 = i71 == true ? 1 : 0;
                                            i45 = i72;
                                            iJ = i73;
                                            i46 = i35;
                                            i47 = i67;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i70 = i4;
                                            i71 = i16 == true ? 1 : 0;
                                            unsafe6 = unsafe4;
                                            i72 = i36;
                                            if (i14 == 2) {
                                                if (i14 == 0) {
                                                    c5 = (C0) i43;
                                                    iH10 = U.h(bArr3, i72, t8);
                                                    c5.d(AbstractC0437j0.a(t8.f7372a));
                                                    while (iH10 < i70) {
                                                        iH11 = U.h(bArr3, iH10, t8);
                                                        if (i71 == t8.f7372a) {
                                                            iH10 = U.h(bArr3, iH11, t8);
                                                            c5.d(AbstractC0437j0.a(t8.f7372a));
                                                        }
                                                    }
                                                }
                                                unsafe = unsafe6;
                                                c0430h3 = c0430h4;
                                                i44 = i70;
                                                i48 = i71;
                                                t8 = t8;
                                                i45 = i72;
                                                i46 = i35;
                                                i47 = i34;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                c6 = (C0) i43;
                                                iH10 = U.h(bArr3, i72, t8);
                                                i77 = t8.f7372a + iH10;
                                                while (iH10 < i77) {
                                                    iH10 = U.h(bArr3, iH10, t8);
                                                    c6.d(AbstractC0437j0.a(t8.f7372a));
                                                }
                                                if (iH10 != i77) {
                                                    throw L0.g();
                                                }
                                            }
                                            unsafe = unsafe6;
                                            iJ = iH10;
                                            i44 = i70;
                                            t8 = t8;
                                            i45 = i72;
                                            c0430h3 = c0430h4;
                                            i48 = i71;
                                            i46 = i35;
                                            i47 = i34;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            i70 = i4;
                                            i71 = i16 == true ? 1 : 0;
                                            unsafe6 = unsafe4;
                                            i72 = i36;
                                            if (i14 == 2) {
                                                androidx.appcompat.app.H.a(i43);
                                                iH10 = U.h(bArr3, i72, t8);
                                                i78 = t8.f7372a + iH10;
                                                if (iH10 >= i78) {
                                                    U.k(bArr3, iH10, t8);
                                                    AbstractC0437j0.b(t8.f7373b);
                                                    throw null;
                                                }
                                                if (iH10 != i78) {
                                                    throw L0.g();
                                                }
                                                unsafe = unsafe6;
                                                iJ = iH10;
                                                i44 = i70;
                                                t8 = t8;
                                                i45 = i72;
                                                c0430h3 = c0430h4;
                                                i48 = i71;
                                                i46 = i35;
                                                i47 = i34;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                if (i14 == 0) {
                                                    androidx.appcompat.app.H.a(i43);
                                                    U.k(bArr3, i72, t8);
                                                    AbstractC0437j0.b(t8.f7373b);
                                                    throw null;
                                                }
                                                unsafe = unsafe6;
                                                c0430h3 = c0430h4;
                                                i44 = i70;
                                                i48 = i71;
                                                t8 = t8;
                                                i45 = i72;
                                                i46 = i35;
                                                i47 = i34;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                        default:
                                            if (i14 == 3) {
                                                i79 = ((i16 == true ? 1 : 0) & (-8)) | 4;
                                                interfaceC0456p1K = c0430h4.K(i35);
                                                int i113 = i36;
                                                unsafe6 = unsafe4;
                                                i72 = i113;
                                                i71 = i16 == true ? 1 : 0;
                                                iH10 = U.c(interfaceC0456p1K, bArr, i113, i4, i79, t3);
                                                i43.add(t8.f7374c);
                                                i80 = i4;
                                                while (iH10 < i80) {
                                                    iH12 = U.h(bArr3, iH10, t8);
                                                    if (i71 == t8.f7372a) {
                                                        i70 = i80;
                                                        unsafe = unsafe6;
                                                        iJ = iH10;
                                                        i44 = i70;
                                                        t8 = t8;
                                                        i45 = i72;
                                                        c0430h3 = c0430h4;
                                                        i48 = i71;
                                                        i46 = i35;
                                                        i47 = i34;
                                                        if (iJ != i45) {
                                                            i46 = i35;
                                                            i5 = i5;
                                                            i99 = i48;
                                                            c0430h4 = c0430h3;
                                                            i91 = i44;
                                                            i95 = i47;
                                                            i96 = i46;
                                                            i98 = i12;
                                                            i97 = i38;
                                                            unsafe9 = unsafe;
                                                            i92 = 3;
                                                            i94 = -1;
                                                            i93 = 0;
                                                            iL = iJ;
                                                            t9 = t8;
                                                            obj2 = obj;
                                                        } else {
                                                            i46 = i35;
                                                            i5 = i5;
                                                            i8 = i48;
                                                            c0430h2 = c0430h3;
                                                            t4 = t8;
                                                            i11 = i47;
                                                            i96 = i46;
                                                            bArr2 = bArr3;
                                                            i12 = i12;
                                                            i97 = i38;
                                                            obj2 = obj;
                                                        }
                                                    } else {
                                                        iH10 = U.c(interfaceC0456p1K, bArr, iH12, i4, i79, t3);
                                                        i43.add(t8.f7374c);
                                                        i80 = i80;
                                                        interfaceC0456p1K = interfaceC0456p1K;
                                                    }
                                                    break;
                                                }
                                                i70 = i80;
                                                unsafe = unsafe6;
                                                iJ = iH10;
                                                i44 = i70;
                                                t8 = t8;
                                                i45 = i72;
                                                c0430h3 = c0430h4;
                                                i48 = i71;
                                                i46 = i35;
                                                i47 = i34;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            } else {
                                                unsafe = unsafe4;
                                                i44 = i4;
                                                i46 = i35;
                                                t8 = t8;
                                                i45 = i36;
                                                i47 = i34;
                                                c0430h3 = c0430h4;
                                                i48 = i16 == true ? 1 : 0;
                                                iJ = i45;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    unsafe = unsafe4;
                                    i35 = i35;
                                    i40 = i34;
                                    c0430h2 = c0430h4;
                                    i41 = i16 == true ? 1 : 0;
                                    i39 = i36;
                                    if (iG2 == 50) {
                                        obj2 = obj;
                                        t4 = t3;
                                        unsafe8 = f7432p;
                                        j5 = iArr[i35 + 2] & 1048575;
                                        switch (iG2) {
                                            case 51:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 1) {
                                                    iJ = i83 + 8;
                                                    unsafe8.putObject(obj2, j3, Double.valueOf(Double.longBitsToDouble(U.n(bArr2, i83))));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 52:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 5) {
                                                    iJ = i83 + 4;
                                                    unsafe8.putObject(obj2, j3, Float.valueOf(Float.intBitsToFloat(U.b(bArr2, i83))));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 0) {
                                                    iJ = U.k(bArr2, i83, t4);
                                                    unsafe8.putObject(obj2, j3, Long.valueOf(t4.f7373b));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 0) {
                                                    iJ = U.h(bArr2, i83, t4);
                                                    unsafe8.putObject(obj2, j3, Integer.valueOf(t4.f7372a));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 1) {
                                                    iJ = i83 + 8;
                                                    unsafe8.putObject(obj2, j3, Long.valueOf(U.n(bArr2, i83)));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 5) {
                                                    iJ = i83 + 4;
                                                    unsafe8.putObject(obj2, j3, Integer.valueOf(U.b(bArr2, i83)));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 58:
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 0) {
                                                    iJ = U.k(bArr2, i83, t4);
                                                    if (t4.f7373b != 0) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    unsafe8.putObject(obj2, j3, Boolean.valueOf(z6));
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 59:
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                i82 = i35;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                if (i14 == 2) {
                                                    iJ = U.h(bArr2, i83, t4);
                                                    i84 = t4.f7372a;
                                                    if (i84 == 0) {
                                                        unsafe8.putObject(obj2, j3, "");
                                                    } else {
                                                        i85 = iJ + i84;
                                                        if ((i15 & 536870912) == 0 && !J1.e(bArr2, iJ, i85)) {
                                                            throw L0.c();
                                                        }
                                                        unsafe8.putObject(obj2, j3, new String(bArr2, iJ, i84, J0.f7334b));
                                                        iJ = i85;
                                                    }
                                                    unsafe8.putInt(obj2, j5, i11);
                                                } else {
                                                    i82 = i82;
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 60:
                                                i83 = i39;
                                                bArr2 = bArr3;
                                                if (i14 == 2) {
                                                    Object objN = c0430h2.N(obj2, i40, i35);
                                                    int iM2 = U.m(objN, c0430h2.K(i35), bArr, i83, i4, t3);
                                                    c0430h2.p(obj2, i40, i35, objN);
                                                    i8 = i41 == true ? 1 : 0;
                                                    iJ = iM2;
                                                    i82 = i35;
                                                    c0430h2 = c0430h2;
                                                    t4 = t4;
                                                    i11 = i40;
                                                } else {
                                                    i86 = i41 == true ? 1 : 0;
                                                    i11 = i40;
                                                    i82 = i35;
                                                    i8 = i86;
                                                    iJ = i83;
                                                }
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 61:
                                                i87 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                i88 = i40;
                                                i89 = i35;
                                                bArr2 = bArr3;
                                                if (i14 == 2) {
                                                    iJ = U.a(bArr2, i83, t4);
                                                    unsafe8.putObject(obj2, j3, t4.f7374c);
                                                    unsafe8.putInt(obj2, j5, i88);
                                                    c0430h2 = c0430h2;
                                                    i11 = i88;
                                                    i82 = i89;
                                                    t4 = t4;
                                                    i8 = i87;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                } else {
                                                    c0430h2 = c0430h2;
                                                    i11 = i88;
                                                    i82 = i89;
                                                    t4 = t4;
                                                    i8 = i87 == true ? 1 : 0;
                                                    iJ = i83;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                }
                                                break;
                                            case 63:
                                                i86 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                i88 = i40;
                                                i89 = i35;
                                                bArr2 = bArr3;
                                                if (i14 == 0) {
                                                    iJ = U.h(bArr2, i83, t4);
                                                    i90 = t4.f7372a;
                                                    f0J2 = c0430h2.J(i89);
                                                    if (f0J2 != null || f0J2.a(i90)) {
                                                        i87 = i86 == true ? 1 : 0;
                                                        unsafe8.putObject(obj2, j3, Integer.valueOf(i90));
                                                        unsafe8.putInt(obj2, j5, i88);
                                                    } else {
                                                        z(obj).j(i86 == true ? 1 : 0, Long.valueOf(i90));
                                                        i87 = i86 == true ? 1 : 0;
                                                    }
                                                    c0430h2 = c0430h2;
                                                    i11 = i88;
                                                    i82 = i89;
                                                    t4 = t4;
                                                    i8 = i87;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                }
                                                i11 = i88;
                                                i82 = i89;
                                                i8 = i86;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 66:
                                                i86 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                i88 = i40;
                                                i89 = i35;
                                                if (i14 == 0) {
                                                    bArr2 = bArr;
                                                    iJ = U.h(bArr2, i83, t4);
                                                    unsafe8.putObject(obj2, j3, Integer.valueOf(AbstractC0437j0.a(t4.f7372a)));
                                                    unsafe8.putInt(obj2, j5, i88);
                                                    i11 = i88;
                                                    i82 = i89;
                                                    t4 = t4;
                                                    i8 = i86;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                }
                                                bArr2 = bArr;
                                                i11 = i88;
                                                i82 = i89;
                                                i8 = i86;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 67:
                                                i86 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                i88 = i40;
                                                i89 = i35;
                                                if (i14 == 0) {
                                                    iJ = U.k(bArr3, i83, t4);
                                                    unsafe8.putObject(obj2, j3, Long.valueOf(AbstractC0437j0.b(t4.f7373b)));
                                                    unsafe8.putInt(obj2, j5, i88);
                                                    bArr2 = bArr;
                                                    i11 = i88;
                                                    i82 = i89;
                                                    t4 = t4;
                                                    i8 = i86;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                }
                                                bArr2 = bArr;
                                                i11 = i88;
                                                i82 = i89;
                                                i8 = i86;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                            case 68:
                                                if (i14 == 3) {
                                                    int i114 = ((i41 == true ? 1 : 0) & (-8)) | 4;
                                                    Object objN2 = c0430h2.N(obj2, i40, i35);
                                                    InterfaceC0456p1 interfaceC0456p1K3 = c0430h2.K(i35);
                                                    i86 = i41 == true ? 1 : 0;
                                                    i83 = i39;
                                                    int iL2 = U.l(objN2, interfaceC0456p1K3, bArr, i39, i4, i114, t3);
                                                    c0430h2.p(obj2, i40, i35, objN2);
                                                    i11 = i40;
                                                    i82 = i35;
                                                    iJ = iL2;
                                                    bArr2 = bArr3;
                                                    t4 = t4;
                                                    i8 = i86;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                } else {
                                                    i86 = i41 == true ? 1 : 0;
                                                    i83 = i39;
                                                    c0430h2 = c0430h2;
                                                    i11 = i40;
                                                    i82 = i35;
                                                    bArr2 = bArr3;
                                                    i8 = i86;
                                                    iJ = i83;
                                                    if (iJ != i83) {
                                                        i95 = i11;
                                                        c0430h4 = c0430h2;
                                                        bArr3 = bArr2;
                                                        i98 = i12;
                                                        i96 = i82;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        i5 = i5;
                                                        i99 = i8 == true ? 1 : 0;
                                                        iL = iJ;
                                                        t9 = t4;
                                                        i91 = i4;
                                                    } else {
                                                        i96 = i82;
                                                        i97 = i38;
                                                    }
                                                }
                                                break;
                                            default:
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i14 == 2) {
                                            unsafe7 = f7432p;
                                            Object objL = c0430h2.L(i35);
                                            object = unsafe7.getObject(obj, j3);
                                            if (!((Y0) object).f()) {
                                                Y0 y0B = Y0.a().b();
                                                Z0.a(y0B, object);
                                                unsafe7.putObject(obj, j3, y0B);
                                            }
                                            androidx.appcompat.app.H.a(objL);
                                            throw null;
                                        }
                                        obj2 = obj;
                                        t7 = t3;
                                    }
                                }
                            } else if (i14 == 2) {
                                i0E = (I0) unsafe4.getObject(obj2, j3);
                                if (!i0E.b()) {
                                    size = i0E.size();
                                    if (size == 0) {
                                        i42 = 10;
                                    } else {
                                        i42 = size + size;
                                    }
                                    i0E = i0E.e(i42);
                                    unsafe4.putObject(obj2, j3, i0E);
                                }
                                iL = U.e(c0430h4.K(i35), i16 == true ? 1 : 0, bArr, i36, i4, i0E, t3);
                                i91 = i4;
                                i5 = i5;
                                i99 = i16 == true ? 1 : 0;
                                i96 = i35;
                                unsafe9 = unsafe4;
                                t9 = t6;
                                i98 = i12;
                                i97 = i37;
                                i95 = i34;
                                i92 = 3;
                                i94 = -1;
                                i93 = 0;
                            } else {
                                i38 = i37;
                                i39 = i36;
                                t7 = t6;
                                unsafe = unsafe4;
                                i40 = i34;
                                c0430h2 = c0430h4;
                                i41 = i16 == true ? 1 : 0;
                            }
                            c0430h2 = c0430h2;
                            t4 = t7;
                            iJ = i39;
                            i11 = i40;
                            i96 = i35;
                            bArr2 = bArr3;
                            i8 = i41;
                            i97 = i38;
                        }
                    }
                    if (i8 == i5 || i5 == 0) {
                        if (c0430h2.f7438f || (c0460r0 = t4.f7375d) == C0460r0.f7494c) {
                            i13 = i8 == true ? 1 : 0;
                            iG = U.g(i13 == true ? 1 : 0, bArr, iJ, i4, z(obj), t3);
                        } else {
                            c0460r0.b(c0430h2.f7437e, i11);
                            C0473v1 c0473v1Z = z(obj);
                            boolean z9 = i8 == true ? 1 : 0;
                            i13 = i8 == true ? 1 : 0;
                            iG = U.g(z9 ? 1 : 0, bArr, iJ, i4, c0473v1Z, t3);
                        }
                        i91 = i4;
                        t9 = t3;
                        i98 = i12;
                        bArr3 = bArr2;
                        i5 = i5;
                        c0430h4 = c0430h2;
                        i95 = i11;
                        i99 = i13;
                        unsafe9 = unsafe;
                        i92 = 3;
                        i94 = -1;
                        i93 = 0;
                        iL = iG;
                    } else {
                        i7 = i12;
                        iL = iJ;
                        c0430h1 = c0430h2;
                        i9 = i97;
                        i6 = 1048575;
                    }
                }
                i10 = iF;
                if (i10 == i94) {
                    t4 = t9;
                    i5 = i5;
                    i11 = i102;
                    unsafe = unsafe9;
                    i96 = 0;
                    c0430h2 = c0430h4;
                    iJ = i100;
                    i8 = i101;
                    bArr2 = bArr3;
                    i12 = i98;
                } else {
                    i14 = i101 & 7;
                    iArr = c0430h4.f7433a;
                    i15 = iArr[i10 + 1];
                    iG2 = G(i15);
                    j3 = i15 & 1048575;
                    i16 = i101;
                    if (iG2 <= 17) {
                        int i1010 = iArr[i10 + 2];
                        i17 = 1 << (i1010 >>> 20);
                        i18 = i1010 & 1048575;
                        i19 = i97;
                        if (i18 != i19) {
                            if (i19 != 1048575) {
                                unsafe9.putInt(obj2, i19, i98);
                            }
                            if (i18 == 1048575) {
                                i33 = 0;
                            } else {
                                i33 = unsafe9.getInt(obj2, i18);
                            }
                            i97 = i18;
                            i98 = i33;
                        } else {
                            i97 = i19;
                        }
                        switch (iG2) {
                            case 0:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 1) {
                                    iL = i100 + 8;
                                    i98 |= i17;
                                    E1.t(obj2, j3, Double.longBitsToDouble(U.n(bArr3, i100)));
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22 == true ? 1 : 0;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 1:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 5) {
                                    iL = i100 + 4;
                                    i98 |= i17;
                                    E1.u(obj2, j3, Float.intBitsToFloat(U.b(bArr3, i100)));
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 2:
                            case 3:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 0) {
                                    i98 |= i17;
                                    iL = U.k(bArr3, i100, t5);
                                    unsafe2.putLong(obj, j3, t5.f7373b);
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 4:
                            case 11:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 0) {
                                    i98 |= i17;
                                    iL = U.h(bArr3, i100, t5);
                                    unsafe2.putInt(obj2, j3, t5.f7372a);
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 5:
                            case 14:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 1) {
                                    iL = i100 + 8;
                                    i98 |= i17;
                                    unsafe2.putLong(obj, j3, U.n(bArr3, i100));
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 6:
                            case 13:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 5) {
                                    iL = i100 + 4;
                                    i98 |= i17;
                                    unsafe2.putInt(obj2, j3, U.b(bArr3, i100));
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 7:
                                i22 = i16 == true ? 1 : 0;
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 0) {
                                    i98 |= i17;
                                    iL = U.k(bArr3, i100, t5);
                                    if (t5.f7373b != 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    E1.r(obj2, j3, z3);
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 8:
                                i100 = i100;
                                i20 = i102;
                                unsafe2 = unsafe9;
                                z4 = i16 == true ? 1 : 0;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 2) {
                                    if ((i15 & 536870912) != 0) {
                                        iH2 = U.h(bArr3, i100, t5);
                                        i24 = t5.f7372a;
                                        if (i24 >= 0) {
                                            throw L0.d();
                                        }
                                        i25 = i98 | i17;
                                        if (i24 == 0) {
                                            t5.f7374c = "";
                                            i28 = i25;
                                            i22 = z4 ? 1 : 0;
                                        } else {
                                            int i1011 = J1.f7340b;
                                            length = bArr3.length;
                                            if ((((length - iH2) - i24) | iH2 | i24) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iH2), Integer.valueOf(i24)));
                                            }
                                            i26 = iH2 + i24;
                                            cArr = new char[i24];
                                            i27 = 0;
                                            while (iH2 < i26) {
                                                b5 = bArr3[iH2];
                                                if (F1.d(b5)) {
                                                    iH2++;
                                                    cArr[i27] = (char) b5;
                                                    i27++;
                                                } else {
                                                    while (true) {
                                                        z4 = z4;
                                                        while (true) {
                                                            if (iH2 < i26) {
                                                                i29 = iH2 + 1;
                                                                b3 = bArr3[iH2];
                                                                if (F1.d(b3)) {
                                                                    cArr[i27] = (char) b3;
                                                                    i27++;
                                                                    iH2 = i29;
                                                                    while (iH2 < i26) {
                                                                        b4 = bArr3[iH2];
                                                                        if (F1.d(b4)) {
                                                                        }
                                                                        iH2++;
                                                                        cArr[i27] = (char) b4;
                                                                        i27++;
                                                                    }
                                                                } else {
                                                                    i30 = i25;
                                                                    if (b3 < -32) {
                                                                        if (i29 < i26) {
                                                                            throw L0.c();
                                                                        }
                                                                        iH2 += 2;
                                                                        F1.c(b3, bArr3[i29], cArr, i27);
                                                                        i27++;
                                                                    } else if (b3 < -16) {
                                                                        z5 = z4 ? 1 : 0;
                                                                        if (i29 < i26 - 2) {
                                                                            throw L0.c();
                                                                        }
                                                                        byte b12 = bArr3[i29];
                                                                        int i1012 = iH2 + 3;
                                                                        byte b13 = bArr3[iH2 + 2];
                                                                        iH2 += 4;
                                                                        F1.a(b3, b12, b13, bArr3[i1012], cArr, i27);
                                                                        i27 += 2;
                                                                        i25 = i30;
                                                                        z4 = z5 ? 1 : 0;
                                                                    } else {
                                                                        if (i29 < i26 - 1) {
                                                                            throw L0.c();
                                                                        }
                                                                        int i1013 = iH2 + 2;
                                                                        byte b14 = bArr3[i29];
                                                                        boolean z10 = z4 ? 1 : 0;
                                                                        iH2 += 3;
                                                                        F1.b(b3, b14, bArr3[i1013], cArr, i27);
                                                                        i27++;
                                                                        z4 = z10 ? 1 : 0;
                                                                    }
                                                                    i25 = i30;
                                                                    z4 = z4;
                                                                }
                                                            } else {
                                                                i28 = i25;
                                                                i22 = z4 ? 1 : 0;
                                                                t5.f7374c = new String(cArr, 0, i27);
                                                                iH2 = i26;
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            while (true) {
                                                z4 = z4;
                                                while (true) {
                                                    if (iH2 < i26) {
                                                        i29 = iH2 + 1;
                                                        b3 = bArr3[iH2];
                                                        if (F1.d(b3)) {
                                                            cArr[i27] = (char) b3;
                                                            i27++;
                                                            iH2 = i29;
                                                            while (iH2 < i26) {
                                                                b4 = bArr3[iH2];
                                                                if (F1.d(b4)) {
                                                                }
                                                                iH2++;
                                                                cArr[i27] = (char) b4;
                                                                i27++;
                                                            }
                                                        } else {
                                                            i30 = i25;
                                                            if (b3 < -32) {
                                                                if (i29 < i26) {
                                                                    throw L0.c();
                                                                }
                                                                iH2 += 2;
                                                                F1.c(b3, bArr3[i29], cArr, i27);
                                                                i27++;
                                                            } else if (b3 < -16) {
                                                                z5 = z4 ? 1 : 0;
                                                                if (i29 < i26 - 2) {
                                                                    throw L0.c();
                                                                }
                                                                byte b15 = bArr3[i29];
                                                                int i1014 = iH2 + 3;
                                                                byte b16 = bArr3[iH2 + 2];
                                                                iH2 += 4;
                                                                F1.a(b3, b15, b16, bArr3[i1014], cArr, i27);
                                                                i27 += 2;
                                                                i25 = i30;
                                                                z4 = z5 ? 1 : 0;
                                                            } else {
                                                                if (i29 < i26 - 1) {
                                                                    throw L0.c();
                                                                }
                                                                int i1015 = iH2 + 2;
                                                                byte b17 = bArr3[i29];
                                                                boolean z11 = z4 ? 1 : 0;
                                                                iH2 += 3;
                                                                F1.b(b3, b17, bArr3[i1015], cArr, i27);
                                                                i27++;
                                                                z4 = z11 ? 1 : 0;
                                                            }
                                                            i25 = i30;
                                                            z4 = z4;
                                                        }
                                                    } else {
                                                        i28 = i25;
                                                        i22 = z4 ? 1 : 0;
                                                        t5.f7374c = new String(cArr, 0, i27);
                                                        iH2 = i26;
                                                    }
                                                }
                                            }
                                        }
                                        i98 = i28;
                                        iL = iH2;
                                    } else {
                                        i22 = z4 ? 1 : 0;
                                        iH = U.h(bArr3, i100, t5);
                                        i23 = t5.f7372a;
                                        if (i23 >= 0) {
                                            throw L0.d();
                                        }
                                        int i1016 = i98 | i17;
                                        if (i23 == 0) {
                                            t5.f7374c = "";
                                        } else {
                                            t5.f7374c = new String(bArr3, iH, i23, J0.f7334b);
                                            iH += i23;
                                        }
                                        iL = iH;
                                        i98 = i1016;
                                    }
                                    unsafe2.putObject(obj2, j3, t5.f7374c);
                                    i91 = i4;
                                    i5 = i5;
                                    t9 = t5;
                                    i96 = i21;
                                    i99 = i22;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i22 = z4 ? 1 : 0;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 9:
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i31 = i16 == true ? 1 : 0;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 2) {
                                    i98 |= i17;
                                    Object objM3 = c0430h4.M(obj2, i21);
                                    i91 = i4;
                                    int iM3 = U.m(objM3, c0430h4.K(i21), bArr, i100, i91, t3);
                                    c0430h4.o(obj2, i21, objM3);
                                    iL = iM3;
                                    t9 = t5;
                                    i99 = i31;
                                    i96 = i21;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i22 = i31;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 10:
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i31 = i16 == true ? 1 : 0;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 2) {
                                    i98 |= i17;
                                    iL = U.a(bArr3, i100, t5);
                                    unsafe2.putObject(obj2, j3, t5.f7374c);
                                    i91 = i4;
                                    t9 = t5;
                                    i99 = i31;
                                    i96 = i21;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i22 = i31;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 12:
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i31 = i16 == true ? 1 : 0;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 0) {
                                    iL = U.h(bArr3, i100, t5);
                                    i32 = t5.f7372a;
                                    F0 f0J4 = c0430h4.J(i21);
                                    if ((i15 & Integer.MIN_VALUE) != 0) {
                                        i98 |= i17;
                                        unsafe2.putInt(obj2, j3, i32);
                                    } else {
                                        i98 |= i17;
                                        unsafe2.putInt(obj2, j3, i32);
                                    }
                                    i91 = i4;
                                    t9 = t5;
                                    i99 = i31;
                                    i96 = i21;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i22 = i31;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 15:
                                i20 = i102;
                                unsafe2 = unsafe9;
                                i31 = i16 == true ? 1 : 0;
                                i21 = i10;
                                t5 = t9;
                                if (i14 == 0) {
                                    i98 |= i17;
                                    iL = U.h(bArr3, i100, t5);
                                    unsafe2.putInt(obj2, j3, AbstractC0437j0.a(t5.f7372a));
                                    i91 = i4;
                                    t9 = t5;
                                    i99 = i31;
                                    i96 = i21;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    i22 = i31;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            case 16:
                                i20 = i102;
                                unsafe3 = unsafe9;
                                i21 = i10;
                                if (i14 == 0) {
                                    i98 |= i17;
                                    iL = U.k(bArr3, i100, t9);
                                    unsafe2 = unsafe3;
                                    unsafe3.putLong(obj, j3, AbstractC0437j0.b(t9.f7373b));
                                    i91 = i4;
                                    i5 = i5;
                                    i99 = i16 == true ? 1 : 0;
                                    t9 = t9;
                                    i96 = i21;
                                    i95 = i20;
                                    i92 = 3;
                                    i94 = -1;
                                    unsafe9 = unsafe2;
                                    i93 = 0;
                                } else {
                                    unsafe2 = unsafe3;
                                    t5 = t9;
                                    i22 = i16 == true ? 1 : 0;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                            default:
                                i92 = 3;
                                if (i14 == 3) {
                                    i98 |= i17;
                                    Object objM4 = c0430h4.M(obj2, i10);
                                    int i115 = i10;
                                    iL = U.l(objM4, c0430h4.K(i10), bArr, i100, i4, (i102 << 3) | 4, t3);
                                    c0430h4.o(obj2, i115, objM4);
                                    i96 = i115;
                                    unsafe9 = unsafe9;
                                    i99 = i16 == true ? 1 : 0;
                                    i95 = i102;
                                    i94 = -1;
                                    i93 = 0;
                                    i91 = i4;
                                    i5 = i5;
                                } else {
                                    i20 = i102;
                                    Unsafe unsafe11 = unsafe9;
                                    i21 = i10;
                                    i22 = i16 == true ? 1 : 0;
                                    t5 = t9;
                                    unsafe2 = unsafe11;
                                    i5 = i5;
                                    c0430h2 = c0430h4;
                                    iJ = i100;
                                    t4 = t5;
                                    unsafe = unsafe2;
                                    i96 = i21;
                                    bArr2 = bArr3;
                                    i12 = i98;
                                    i8 = i22;
                                    i11 = i20;
                                }
                                break;
                        }
                    } else {
                        i34 = i102;
                        unsafe4 = unsafe9;
                        i35 = i10;
                        t6 = t9;
                        i36 = i100;
                        i37 = i97;
                        i12 = i98;
                        if (iG2 == 27) {
                            i38 = i37;
                            t8 = t6;
                            if (iG2 <= 49) {
                                j4 = i15;
                                unsafe5 = f7432p;
                                i43 = (I0) unsafe5.getObject(obj2, j3);
                                if (i43.b()) {
                                    size3 = i43.size();
                                    if (size3 == 0) {
                                        i81 = 10;
                                    } else {
                                        i81 = size3 + size3;
                                    }
                                    I0 i0E3 = i43.e(i81);
                                    unsafe5.putObject(obj2, j3, i0E3);
                                    i43 = i0E3;
                                } else {
                                    i36 = i36;
                                }
                                switch (iG2) {
                                    case 18:
                                    case 35:
                                        i44 = i4;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i45 = i36;
                                        i46 = i35;
                                        i47 = i34;
                                        c0430h3 = c0430h4;
                                        i48 = i16 == true ? 1 : 0;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH3 = U.h(bArr3, i45, t8);
                                            i49 = t8.f7372a + iH3;
                                            if (iH3 >= i49) {
                                                Double.longBitsToDouble(U.n(bArr3, iH3));
                                                throw null;
                                            }
                                            if (iH3 != i49) {
                                                throw L0.g();
                                            }
                                            iJ = iH3;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 1) {
                                                androidx.appcompat.app.H.a(i43);
                                                Double.longBitsToDouble(U.n(bArr3, i45));
                                                throw null;
                                            }
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i44 = i4;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i45 = i36;
                                        i46 = i35;
                                        i47 = i34;
                                        c0430h3 = c0430h4;
                                        i48 = i16 == true ? 1 : 0;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH3 = U.h(bArr3, i45, t8);
                                            i50 = t8.f7372a + iH3;
                                            if (iH3 >= i50) {
                                                Float.intBitsToFloat(U.b(bArr3, iH3));
                                                throw null;
                                            }
                                            if (iH3 != i50) {
                                                throw L0.g();
                                            }
                                            iJ = iH3;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 5) {
                                                androidx.appcompat.app.H.a(i43);
                                                Float.intBitsToFloat(U.b(bArr3, i45));
                                                throw null;
                                            }
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i44 = i4;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i45 = i36;
                                        i46 = i35;
                                        i47 = i34;
                                        c0430h3 = c0430h4;
                                        i48 = i16 == true ? 1 : 0;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH3 = U.h(bArr3, i45, t8);
                                            i51 = t8.f7372a + iH3;
                                            if (iH3 >= i51) {
                                                U.k(bArr3, iH3, t8);
                                                throw null;
                                            }
                                            if (iH3 != i51) {
                                                throw L0.g();
                                            }
                                            iJ = iH3;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 0) {
                                                androidx.appcompat.app.H.a(i43);
                                                U.k(bArr3, i45, t8);
                                                long j8 = t8.f7373b;
                                                throw null;
                                            }
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i52 = i4;
                                        i48 = i16 == true ? 1 : 0;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i53 = i36;
                                        i54 = i34;
                                        i46 = i35;
                                        if (i14 == 2) {
                                            if (i14 == 0) {
                                                i47 = i54;
                                                i44 = i52;
                                                i45 = i53;
                                                iJ = U.j(i48 == true ? 1 : 0, bArr, i53, i4, i43, t3);
                                                c0430h3 = this;
                                                if (iJ != i45) {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i99 = i48;
                                                    c0430h4 = c0430h3;
                                                    i91 = i44;
                                                    i95 = i47;
                                                    i96 = i46;
                                                    i98 = i12;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    iL = iJ;
                                                    t9 = t8;
                                                    obj2 = obj;
                                                } else {
                                                    i46 = i35;
                                                    i5 = i5;
                                                    i8 = i48;
                                                    c0430h2 = c0430h3;
                                                    t4 = t8;
                                                    i11 = i47;
                                                    i96 = i46;
                                                    bArr2 = bArr3;
                                                    i12 = i12;
                                                    i97 = i38;
                                                    obj2 = obj;
                                                }
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                            break;
                                        } else {
                                            iJ = U.f(bArr3, i53, i43, t8);
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i52 = i4;
                                        i48 = i16 == true ? 1 : 0;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i53 = i36;
                                        i54 = i34;
                                        i46 = i35;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH4 = U.h(bArr3, i53, t8);
                                            i55 = t8.f7372a + iH4;
                                            if (iH4 >= i55) {
                                                U.n(bArr3, iH4);
                                                throw null;
                                            }
                                            if (iH4 != i55) {
                                                throw L0.g();
                                            }
                                            i47 = i54;
                                            iJ = iH4;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 1) {
                                                androidx.appcompat.app.H.a(i43);
                                                U.n(bArr3, i53);
                                                throw null;
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i52 = i4;
                                        i48 = i16 == true ? 1 : 0;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i53 = i36;
                                        i54 = i34;
                                        i46 = i35;
                                        if (i14 == 2) {
                                            if (i14 == 5) {
                                                iH4 = i53 + 4;
                                                c3 = (C0) i43;
                                                c3.d(U.b(bArr3, i53));
                                                while (iH4 < i52) {
                                                    iH5 = U.h(bArr3, iH4, t8);
                                                    if (i48 == t8.f7372a) {
                                                        c3.d(U.b(bArr3, iH5));
                                                        iH4 = iH5 + 4;
                                                    }
                                                }
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            c4 = (C0) i43;
                                            iH4 = U.h(bArr3, i53, t8);
                                            i56 = t8.f7372a + iH4;
                                            while (iH4 < i56) {
                                                c4.d(U.b(bArr3, iH4));
                                                iH4 += 4;
                                            }
                                            if (iH4 != i56) {
                                                throw L0.g();
                                            }
                                        }
                                        i47 = i54;
                                        iJ = iH4;
                                        i44 = i52;
                                        i45 = i53;
                                        c0430h3 = this;
                                        if (iJ != i45) {
                                            i46 = i35;
                                            i5 = i5;
                                            i99 = i48;
                                            c0430h4 = c0430h3;
                                            i91 = i44;
                                            i95 = i47;
                                            i96 = i46;
                                            i98 = i12;
                                            i97 = i38;
                                            unsafe9 = unsafe;
                                            i92 = 3;
                                            i94 = -1;
                                            i93 = 0;
                                            iL = iJ;
                                            t9 = t8;
                                            obj2 = obj;
                                        } else {
                                            i46 = i35;
                                            i5 = i5;
                                            i8 = i48;
                                            c0430h2 = c0430h3;
                                            t4 = t8;
                                            i11 = i47;
                                            i96 = i46;
                                            bArr2 = bArr3;
                                            i12 = i12;
                                            i97 = i38;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i52 = i4;
                                        i48 = i16 == true ? 1 : 0;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i53 = i36;
                                        i54 = i34;
                                        i46 = i35;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH4 = U.h(bArr3, i53, t8);
                                            i57 = t8.f7372a + iH4;
                                            if (iH4 >= i57) {
                                                U.k(bArr3, iH4, t8);
                                                throw null;
                                            }
                                            if (iH4 != i57) {
                                                throw L0.g();
                                            }
                                            i47 = i54;
                                            iJ = iH4;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 0) {
                                                androidx.appcompat.app.H.a(i43);
                                                U.k(bArr3, i53, t8);
                                                long j9 = t8.f7373b;
                                                throw null;
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 26:
                                        i52 = i4;
                                        i48 = i16 == true ? 1 : 0;
                                        i58 = i43;
                                        t8 = t8;
                                        unsafe = unsafe4;
                                        i53 = i36;
                                        i54 = i34;
                                        i46 = i35;
                                        if (i14 == 2) {
                                            if ((j4 & 536870912) == 0) {
                                                iJ = U.h(bArr3, i53, t8);
                                                i63 = t8.f7372a;
                                                if (i63 >= 0) {
                                                    throw L0.d();
                                                }
                                                if (i63 == 0) {
                                                    i64 = i58;
                                                    i64.add("");
                                                } else {
                                                    i64 = i58;
                                                    i64.add(new String(bArr3, iJ, i63, J0.f7334b));
                                                    iJ += i63;
                                                }
                                                while (iJ < i52) {
                                                    iH7 = U.h(bArr3, iJ, t8);
                                                    if (i48 == t8.f7372a) {
                                                        iJ = U.h(bArr3, iH7, t8);
                                                        i65 = t8.f7372a;
                                                        if (i65 >= 0) {
                                                            throw L0.d();
                                                        }
                                                        if (i65 == 0) {
                                                            i64.add("");
                                                        } else {
                                                            i64.add(new String(bArr3, iJ, i65, J0.f7334b));
                                                            iJ += i65;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iJ = U.h(bArr3, i53, t8);
                                                i59 = t8.f7372a;
                                                if (i59 >= 0) {
                                                    throw L0.d();
                                                }
                                                if (i59 == 0) {
                                                    i58.add("");
                                                } else {
                                                    i60 = iJ + i59;
                                                    if (J1.e(bArr3, iJ, i60)) {
                                                        throw L0.c();
                                                    }
                                                    i58.add(new String(bArr3, iJ, i59, J0.f7334b));
                                                    iJ = i60;
                                                }
                                                while (iJ < i52) {
                                                    iH6 = U.h(bArr3, iJ, t8);
                                                    if (i48 == t8.f7372a) {
                                                        iJ = U.h(bArr3, iH6, t8);
                                                        i61 = t8.f7372a;
                                                        if (i61 >= 0) {
                                                            throw L0.d();
                                                        }
                                                        if (i61 == 0) {
                                                            i58.add("");
                                                        } else {
                                                            i62 = iJ + i61;
                                                            if (J1.e(bArr3, iJ, i62)) {
                                                                throw L0.c();
                                                            }
                                                            i58.add(new String(bArr3, iJ, i61, J0.f7334b));
                                                            iJ = i62;
                                                        }
                                                    }
                                                }
                                            }
                                            i47 = i54;
                                            i44 = i52;
                                            i45 = i53;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        i47 = i54;
                                        i44 = i52;
                                        i45 = i53;
                                        c0430h3 = this;
                                        iJ = i45;
                                        if (iJ != i45) {
                                            i46 = i35;
                                            i5 = i5;
                                            i99 = i48;
                                            c0430h4 = c0430h3;
                                            i91 = i44;
                                            i95 = i47;
                                            i96 = i46;
                                            i98 = i12;
                                            i97 = i38;
                                            unsafe9 = unsafe;
                                            i92 = 3;
                                            i94 = -1;
                                            i93 = 0;
                                            iL = iJ;
                                            t9 = t8;
                                            obj2 = obj;
                                        } else {
                                            i46 = i35;
                                            i5 = i5;
                                            i8 = i48;
                                            c0430h2 = c0430h3;
                                            t4 = t8;
                                            i11 = i47;
                                            i96 = i46;
                                            bArr2 = bArr3;
                                            i12 = i12;
                                            i97 = i38;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 27:
                                        i66 = i36;
                                        i67 = i34;
                                        if (i14 == 2) {
                                            InterfaceC0456p1 interfaceC0456p1K4 = K(i35);
                                            i48 = i16 == true ? 1 : 0;
                                            t8 = t8;
                                            unsafe = unsafe4;
                                            i47 = i67;
                                            i45 = i66;
                                            iJ = U.e(interfaceC0456p1K4, i16 == true ? 1 : 0, bArr, i66, i4, i43, t3);
                                            c0430h3 = this;
                                            i44 = i4;
                                        } else {
                                            unsafe = unsafe4;
                                            i48 = i16 == true ? 1 : 0;
                                            i44 = i4;
                                            i45 = i66;
                                            i46 = i35;
                                            i47 = i67;
                                            c0430h3 = this;
                                            iJ = i45;
                                        }
                                        if (iJ != i45) {
                                            i46 = i35;
                                            i5 = i5;
                                            i99 = i48;
                                            c0430h4 = c0430h3;
                                            i91 = i44;
                                            i95 = i47;
                                            i96 = i46;
                                            i98 = i12;
                                            i97 = i38;
                                            unsafe9 = unsafe;
                                            i92 = 3;
                                            i94 = -1;
                                            i93 = 0;
                                            iL = iJ;
                                            t9 = t8;
                                            obj2 = obj;
                                        } else {
                                            i46 = i35;
                                            i5 = i5;
                                            i8 = i48;
                                            c0430h2 = c0430h3;
                                            t4 = t8;
                                            i11 = i47;
                                            i96 = i46;
                                            bArr2 = bArr3;
                                            i12 = i12;
                                            i97 = i38;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 28:
                                        i66 = i36;
                                        i67 = i34;
                                        if (i14 == 2) {
                                            iH8 = U.h(bArr3, i66, t8);
                                            i68 = t8.f7372a;
                                            if (i68 >= 0) {
                                                throw L0.d();
                                            }
                                            if (i68 <= bArr3.length - iH8) {
                                                throw L0.g();
                                            }
                                            if (i68 == 0) {
                                                i43.add(AbstractC0421f0.f7421b);
                                            } else {
                                                i43.add(AbstractC0421f0.t(bArr3, iH8, i68));
                                                iH8 += i68;
                                            }
                                            while (iH8 < i4) {
                                                iH9 = U.h(bArr3, iH8, t8);
                                                if (i16 == t8.f7372a) {
                                                    unsafe = unsafe4;
                                                    iJ = iH8;
                                                    i44 = i4;
                                                    i48 = i16 == true ? 1 : 0;
                                                    i45 = i66;
                                                    i46 = i35;
                                                    i47 = i67;
                                                    c0430h3 = this;
                                                    if (iJ != i45) {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i99 = i48;
                                                        c0430h4 = c0430h3;
                                                        i91 = i44;
                                                        i95 = i47;
                                                        i96 = i46;
                                                        i98 = i12;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        iL = iJ;
                                                        t9 = t8;
                                                        obj2 = obj;
                                                    } else {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i8 = i48;
                                                        c0430h2 = c0430h3;
                                                        t4 = t8;
                                                        i11 = i47;
                                                        i96 = i46;
                                                        bArr2 = bArr3;
                                                        i12 = i12;
                                                        i97 = i38;
                                                        obj2 = obj;
                                                    }
                                                    break;
                                                } else {
                                                    iH8 = U.h(bArr3, iH9, t8);
                                                    i69 = t8.f7372a;
                                                    if (i69 >= 0) {
                                                        throw L0.d();
                                                    }
                                                    if (i69 <= bArr3.length - iH8) {
                                                        throw L0.g();
                                                    }
                                                    if (i69 == 0) {
                                                        i43.add(AbstractC0421f0.f7421b);
                                                    } else {
                                                        i43.add(AbstractC0421f0.t(bArr3, iH8, i69));
                                                        iH8 += i69;
                                                    }
                                                }
                                            }
                                            unsafe = unsafe4;
                                            iJ = iH8;
                                            i44 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            i45 = i66;
                                            i46 = i35;
                                            i47 = i67;
                                            c0430h3 = this;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            unsafe = unsafe4;
                                            i44 = i4;
                                            i48 = i16 == true ? 1 : 0;
                                            i45 = i66;
                                            i46 = i35;
                                            i47 = i67;
                                            c0430h3 = this;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i70 = i4;
                                        i71 = i16 == true ? 1 : 0;
                                        i72 = i36;
                                        if (i14 == 2) {
                                            iJ2 = U.f(bArr3, i72, i43, t8);
                                        } else if (i14 == 0) {
                                            c0430h3 = this;
                                            unsafe = unsafe4;
                                            i44 = i70;
                                            i48 = i71;
                                            t8 = t8;
                                            i45 = i72;
                                            i46 = i35;
                                            i47 = i34;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            iJ2 = U.j(i71 == true ? 1 : 0, bArr, i72, i4, i43, t3);
                                        }
                                        f0J = c0430h4.J(i35);
                                        abstractC0470u1 = c0430h4.f7443k;
                                        int i116 = AbstractC0461r1.f7499d;
                                        if (f0J != null) {
                                            i73 = iJ2;
                                            i67 = i34;
                                        } else if (i43 instanceof RandomAccess) {
                                            size2 = i43.size();
                                            objU2 = null;
                                            i74 = 0;
                                            i75 = 0;
                                            while (i74 < size2) {
                                                int i117 = iJ2;
                                                num = (Integer) i43.get(i74);
                                                iIntValue2 = num.intValue();
                                                if (f0J.a(iIntValue2)) {
                                                    if (i74 != i75) {
                                                        i43.set(i75, num);
                                                    }
                                                    i75++;
                                                    i76 = i34;
                                                } else {
                                                    i76 = i34;
                                                    objU2 = AbstractC0461r1.u(obj2, i76, iIntValue2, objU2, abstractC0470u1);
                                                }
                                                i74++;
                                                i34 = i76;
                                                iJ2 = i117;
                                            }
                                            i73 = iJ2;
                                            i67 = i34;
                                            if (i75 != size2) {
                                                i43.subList(i75, size2).clear();
                                            }
                                        } else {
                                            i73 = iJ2;
                                            i67 = i34;
                                            it = i43.iterator();
                                            objU = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!f0J.a(iIntValue)) {
                                                    objU = AbstractC0461r1.u(obj2, i67, iIntValue, objU, abstractC0470u1);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        unsafe = unsafe4;
                                        i44 = i70;
                                        i48 = i71 == true ? 1 : 0;
                                        i45 = i72;
                                        iJ = i73;
                                        i46 = i35;
                                        i47 = i67;
                                        c0430h3 = this;
                                        if (iJ != i45) {
                                            i46 = i35;
                                            i5 = i5;
                                            i99 = i48;
                                            c0430h4 = c0430h3;
                                            i91 = i44;
                                            i95 = i47;
                                            i96 = i46;
                                            i98 = i12;
                                            i97 = i38;
                                            unsafe9 = unsafe;
                                            i92 = 3;
                                            i94 = -1;
                                            i93 = 0;
                                            iL = iJ;
                                            t9 = t8;
                                            obj2 = obj;
                                        } else {
                                            i46 = i35;
                                            i5 = i5;
                                            i8 = i48;
                                            c0430h2 = c0430h3;
                                            t4 = t8;
                                            i11 = i47;
                                            i96 = i46;
                                            bArr2 = bArr3;
                                            i12 = i12;
                                            i97 = i38;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i70 = i4;
                                        i71 = i16 == true ? 1 : 0;
                                        unsafe6 = unsafe4;
                                        i72 = i36;
                                        if (i14 == 2) {
                                            if (i14 == 0) {
                                                c5 = (C0) i43;
                                                iH10 = U.h(bArr3, i72, t8);
                                                c5.d(AbstractC0437j0.a(t8.f7372a));
                                                while (iH10 < i70) {
                                                    iH11 = U.h(bArr3, iH10, t8);
                                                    if (i71 == t8.f7372a) {
                                                        iH10 = U.h(bArr3, iH11, t8);
                                                        c5.d(AbstractC0437j0.a(t8.f7372a));
                                                    }
                                                }
                                            }
                                            unsafe = unsafe6;
                                            c0430h3 = c0430h4;
                                            i44 = i70;
                                            i48 = i71;
                                            t8 = t8;
                                            i45 = i72;
                                            i46 = i35;
                                            i47 = i34;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            c6 = (C0) i43;
                                            iH10 = U.h(bArr3, i72, t8);
                                            i77 = t8.f7372a + iH10;
                                            while (iH10 < i77) {
                                                iH10 = U.h(bArr3, iH10, t8);
                                                c6.d(AbstractC0437j0.a(t8.f7372a));
                                            }
                                            if (iH10 != i77) {
                                                throw L0.g();
                                            }
                                        }
                                        unsafe = unsafe6;
                                        iJ = iH10;
                                        i44 = i70;
                                        t8 = t8;
                                        i45 = i72;
                                        c0430h3 = c0430h4;
                                        i48 = i71;
                                        i46 = i35;
                                        i47 = i34;
                                        if (iJ != i45) {
                                            i46 = i35;
                                            i5 = i5;
                                            i99 = i48;
                                            c0430h4 = c0430h3;
                                            i91 = i44;
                                            i95 = i47;
                                            i96 = i46;
                                            i98 = i12;
                                            i97 = i38;
                                            unsafe9 = unsafe;
                                            i92 = 3;
                                            i94 = -1;
                                            i93 = 0;
                                            iL = iJ;
                                            t9 = t8;
                                            obj2 = obj;
                                        } else {
                                            i46 = i35;
                                            i5 = i5;
                                            i8 = i48;
                                            c0430h2 = c0430h3;
                                            t4 = t8;
                                            i11 = i47;
                                            i96 = i46;
                                            bArr2 = bArr3;
                                            i12 = i12;
                                            i97 = i38;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        i70 = i4;
                                        i71 = i16 == true ? 1 : 0;
                                        unsafe6 = unsafe4;
                                        i72 = i36;
                                        if (i14 == 2) {
                                            androidx.appcompat.app.H.a(i43);
                                            iH10 = U.h(bArr3, i72, t8);
                                            i78 = t8.f7372a + iH10;
                                            if (iH10 >= i78) {
                                                U.k(bArr3, iH10, t8);
                                                AbstractC0437j0.b(t8.f7373b);
                                                throw null;
                                            }
                                            if (iH10 != i78) {
                                                throw L0.g();
                                            }
                                            unsafe = unsafe6;
                                            iJ = iH10;
                                            i44 = i70;
                                            t8 = t8;
                                            i45 = i72;
                                            c0430h3 = c0430h4;
                                            i48 = i71;
                                            i46 = i35;
                                            i47 = i34;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            if (i14 == 0) {
                                                androidx.appcompat.app.H.a(i43);
                                                U.k(bArr3, i72, t8);
                                                AbstractC0437j0.b(t8.f7373b);
                                                throw null;
                                            }
                                            unsafe = unsafe6;
                                            c0430h3 = c0430h4;
                                            i44 = i70;
                                            i48 = i71;
                                            t8 = t8;
                                            i45 = i72;
                                            i46 = i35;
                                            i47 = i34;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    default:
                                        if (i14 == 3) {
                                            i79 = ((i16 == true ? 1 : 0) & (-8)) | 4;
                                            interfaceC0456p1K = c0430h4.K(i35);
                                            int i118 = i36;
                                            unsafe6 = unsafe4;
                                            i72 = i118;
                                            i71 = i16 == true ? 1 : 0;
                                            iH10 = U.c(interfaceC0456p1K, bArr, i118, i4, i79, t3);
                                            i43.add(t8.f7374c);
                                            i80 = i4;
                                            while (iH10 < i80) {
                                                iH12 = U.h(bArr3, iH10, t8);
                                                if (i71 == t8.f7372a) {
                                                    i70 = i80;
                                                    unsafe = unsafe6;
                                                    iJ = iH10;
                                                    i44 = i70;
                                                    t8 = t8;
                                                    i45 = i72;
                                                    c0430h3 = c0430h4;
                                                    i48 = i71;
                                                    i46 = i35;
                                                    i47 = i34;
                                                    if (iJ != i45) {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i99 = i48;
                                                        c0430h4 = c0430h3;
                                                        i91 = i44;
                                                        i95 = i47;
                                                        i96 = i46;
                                                        i98 = i12;
                                                        i97 = i38;
                                                        unsafe9 = unsafe;
                                                        i92 = 3;
                                                        i94 = -1;
                                                        i93 = 0;
                                                        iL = iJ;
                                                        t9 = t8;
                                                        obj2 = obj;
                                                    } else {
                                                        i46 = i35;
                                                        i5 = i5;
                                                        i8 = i48;
                                                        c0430h2 = c0430h3;
                                                        t4 = t8;
                                                        i11 = i47;
                                                        i96 = i46;
                                                        bArr2 = bArr3;
                                                        i12 = i12;
                                                        i97 = i38;
                                                        obj2 = obj;
                                                    }
                                                } else {
                                                    iH10 = U.c(interfaceC0456p1K, bArr, iH12, i4, i79, t3);
                                                    i43.add(t8.f7374c);
                                                    i80 = i80;
                                                    interfaceC0456p1K = interfaceC0456p1K;
                                                }
                                                break;
                                            }
                                            i70 = i80;
                                            unsafe = unsafe6;
                                            iJ = iH10;
                                            i44 = i70;
                                            t8 = t8;
                                            i45 = i72;
                                            c0430h3 = c0430h4;
                                            i48 = i71;
                                            i46 = i35;
                                            i47 = i34;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        } else {
                                            unsafe = unsafe4;
                                            i44 = i4;
                                            i46 = i35;
                                            t8 = t8;
                                            i45 = i36;
                                            i47 = i34;
                                            c0430h3 = c0430h4;
                                            i48 = i16 == true ? 1 : 0;
                                            iJ = i45;
                                            if (iJ != i45) {
                                                i46 = i35;
                                                i5 = i5;
                                                i99 = i48;
                                                c0430h4 = c0430h3;
                                                i91 = i44;
                                                i95 = i47;
                                                i96 = i46;
                                                i98 = i12;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                iL = iJ;
                                                t9 = t8;
                                                obj2 = obj;
                                            } else {
                                                i46 = i35;
                                                i5 = i5;
                                                i8 = i48;
                                                c0430h2 = c0430h3;
                                                t4 = t8;
                                                i11 = i47;
                                                i96 = i46;
                                                bArr2 = bArr3;
                                                i12 = i12;
                                                i97 = i38;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                unsafe = unsafe4;
                                i35 = i35;
                                i40 = i34;
                                c0430h2 = c0430h4;
                                i41 = i16 == true ? 1 : 0;
                                i39 = i36;
                                if (iG2 == 50) {
                                    obj2 = obj;
                                    t4 = t3;
                                    unsafe8 = f7432p;
                                    j5 = iArr[i35 + 2] & 1048575;
                                    switch (iG2) {
                                        case 51:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 1) {
                                                iJ = i83 + 8;
                                                unsafe8.putObject(obj2, j3, Double.valueOf(Double.longBitsToDouble(U.n(bArr2, i83))));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 52:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 5) {
                                                iJ = i83 + 4;
                                                unsafe8.putObject(obj2, j3, Float.valueOf(Float.intBitsToFloat(U.b(bArr2, i83))));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 0) {
                                                iJ = U.k(bArr2, i83, t4);
                                                unsafe8.putObject(obj2, j3, Long.valueOf(t4.f7373b));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 0) {
                                                iJ = U.h(bArr2, i83, t4);
                                                unsafe8.putObject(obj2, j3, Integer.valueOf(t4.f7372a));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 1) {
                                                iJ = i83 + 8;
                                                unsafe8.putObject(obj2, j3, Long.valueOf(U.n(bArr2, i83)));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 5) {
                                                iJ = i83 + 4;
                                                unsafe8.putObject(obj2, j3, Integer.valueOf(U.b(bArr2, i83)));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 58:
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 0) {
                                                iJ = U.k(bArr2, i83, t4);
                                                if (t4.f7373b != 0) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                unsafe8.putObject(obj2, j3, Boolean.valueOf(z6));
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 59:
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            i82 = i35;
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            if (i14 == 2) {
                                                iJ = U.h(bArr2, i83, t4);
                                                i84 = t4.f7372a;
                                                if (i84 == 0) {
                                                    unsafe8.putObject(obj2, j3, "");
                                                } else {
                                                    i85 = iJ + i84;
                                                    if ((i15 & 536870912) == 0) {
                                                    }
                                                    unsafe8.putObject(obj2, j3, new String(bArr2, iJ, i84, J0.f7334b));
                                                    iJ = i85;
                                                }
                                                unsafe8.putInt(obj2, j5, i11);
                                            } else {
                                                i82 = i82;
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 60:
                                            i83 = i39;
                                            bArr2 = bArr3;
                                            if (i14 == 2) {
                                                Object objN3 = c0430h2.N(obj2, i40, i35);
                                                int iM4 = U.m(objN3, c0430h2.K(i35), bArr, i83, i4, t3);
                                                c0430h2.p(obj2, i40, i35, objN3);
                                                i8 = i41 == true ? 1 : 0;
                                                iJ = iM4;
                                                i82 = i35;
                                                c0430h2 = c0430h2;
                                                t4 = t4;
                                                i11 = i40;
                                            } else {
                                                i86 = i41 == true ? 1 : 0;
                                                i11 = i40;
                                                i82 = i35;
                                                i8 = i86;
                                                iJ = i83;
                                            }
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 61:
                                            i87 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            i88 = i40;
                                            i89 = i35;
                                            bArr2 = bArr3;
                                            if (i14 == 2) {
                                                iJ = U.a(bArr2, i83, t4);
                                                unsafe8.putObject(obj2, j3, t4.f7374c);
                                                unsafe8.putInt(obj2, j5, i88);
                                                c0430h2 = c0430h2;
                                                i11 = i88;
                                                i82 = i89;
                                                t4 = t4;
                                                i8 = i87;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            } else {
                                                c0430h2 = c0430h2;
                                                i11 = i88;
                                                i82 = i89;
                                                t4 = t4;
                                                i8 = i87 == true ? 1 : 0;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            }
                                            break;
                                        case 63:
                                            i86 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            i88 = i40;
                                            i89 = i35;
                                            bArr2 = bArr3;
                                            if (i14 == 0) {
                                                iJ = U.h(bArr2, i83, t4);
                                                i90 = t4.f7372a;
                                                f0J2 = c0430h2.J(i89);
                                                if (f0J2 != null) {
                                                    i87 = i86 == true ? 1 : 0;
                                                    unsafe8.putObject(obj2, j3, Integer.valueOf(i90));
                                                    unsafe8.putInt(obj2, j5, i88);
                                                } else {
                                                    i87 = i86 == true ? 1 : 0;
                                                    unsafe8.putObject(obj2, j3, Integer.valueOf(i90));
                                                    unsafe8.putInt(obj2, j5, i88);
                                                }
                                                c0430h2 = c0430h2;
                                                i11 = i88;
                                                i82 = i89;
                                                t4 = t4;
                                                i8 = i87;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            }
                                            i11 = i88;
                                            i82 = i89;
                                            i8 = i86;
                                            iJ = i83;
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 66:
                                            i86 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            i88 = i40;
                                            i89 = i35;
                                            if (i14 == 0) {
                                                bArr2 = bArr;
                                                iJ = U.h(bArr2, i83, t4);
                                                unsafe8.putObject(obj2, j3, Integer.valueOf(AbstractC0437j0.a(t4.f7372a)));
                                                unsafe8.putInt(obj2, j5, i88);
                                                i11 = i88;
                                                i82 = i89;
                                                t4 = t4;
                                                i8 = i86;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            }
                                            bArr2 = bArr;
                                            i11 = i88;
                                            i82 = i89;
                                            i8 = i86;
                                            iJ = i83;
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 67:
                                            i86 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            i88 = i40;
                                            i89 = i35;
                                            if (i14 == 0) {
                                                iJ = U.k(bArr3, i83, t4);
                                                unsafe8.putObject(obj2, j3, Long.valueOf(AbstractC0437j0.b(t4.f7373b)));
                                                unsafe8.putInt(obj2, j5, i88);
                                                bArr2 = bArr;
                                                i11 = i88;
                                                i82 = i89;
                                                t4 = t4;
                                                i8 = i86;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            }
                                            bArr2 = bArr;
                                            i11 = i88;
                                            i82 = i89;
                                            i8 = i86;
                                            iJ = i83;
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                        case 68:
                                            if (i14 == 3) {
                                                int i119 = ((i41 == true ? 1 : 0) & (-8)) | 4;
                                                Object objN4 = c0430h2.N(obj2, i40, i35);
                                                InterfaceC0456p1 interfaceC0456p1K5 = c0430h2.K(i35);
                                                i86 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                int iL3 = U.l(objN4, interfaceC0456p1K5, bArr, i39, i4, i119, t3);
                                                c0430h2.p(obj2, i40, i35, objN4);
                                                i11 = i40;
                                                i82 = i35;
                                                iJ = iL3;
                                                bArr2 = bArr3;
                                                t4 = t4;
                                                i8 = i86;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            } else {
                                                i86 = i41 == true ? 1 : 0;
                                                i83 = i39;
                                                c0430h2 = c0430h2;
                                                i11 = i40;
                                                i82 = i35;
                                                bArr2 = bArr3;
                                                i8 = i86;
                                                iJ = i83;
                                                if (iJ != i83) {
                                                    i95 = i11;
                                                    c0430h4 = c0430h2;
                                                    bArr3 = bArr2;
                                                    i98 = i12;
                                                    i96 = i82;
                                                    i97 = i38;
                                                    unsafe9 = unsafe;
                                                    i92 = 3;
                                                    i94 = -1;
                                                    i93 = 0;
                                                    i5 = i5;
                                                    i99 = i8 == true ? 1 : 0;
                                                    iL = iJ;
                                                    t9 = t4;
                                                    i91 = i4;
                                                } else {
                                                    i96 = i82;
                                                    i97 = i38;
                                                }
                                            }
                                            break;
                                        default:
                                            c0430h2 = c0430h2;
                                            t4 = t4;
                                            i11 = i40;
                                            i82 = i35;
                                            bArr2 = bArr3;
                                            i8 = i41 == true ? 1 : 0;
                                            i83 = i39;
                                            iJ = i83;
                                            if (iJ != i83) {
                                                i95 = i11;
                                                c0430h4 = c0430h2;
                                                bArr3 = bArr2;
                                                i98 = i12;
                                                i96 = i82;
                                                i97 = i38;
                                                unsafe9 = unsafe;
                                                i92 = 3;
                                                i94 = -1;
                                                i93 = 0;
                                                i5 = i5;
                                                i99 = i8 == true ? 1 : 0;
                                                iL = iJ;
                                                t9 = t4;
                                                i91 = i4;
                                            } else {
                                                i96 = i82;
                                                i97 = i38;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i14 == 2) {
                                        unsafe7 = f7432p;
                                        Object objL2 = c0430h2.L(i35);
                                        object = unsafe7.getObject(obj, j3);
                                        if (!((Y0) object).f()) {
                                            Y0 y0B2 = Y0.a().b();
                                            Z0.a(y0B2, object);
                                            unsafe7.putObject(obj, j3, y0B2);
                                        }
                                        androidx.appcompat.app.H.a(objL2);
                                        throw null;
                                    }
                                    obj2 = obj;
                                    t7 = t3;
                                }
                            }
                        } else if (i14 == 2) {
                            i0E = (I0) unsafe4.getObject(obj2, j3);
                            if (!i0E.b()) {
                                size = i0E.size();
                                if (size == 0) {
                                    i42 = 10;
                                } else {
                                    i42 = size + size;
                                }
                                i0E = i0E.e(i42);
                                unsafe4.putObject(obj2, j3, i0E);
                            }
                            iL = U.e(c0430h4.K(i35), i16 == true ? 1 : 0, bArr, i36, i4, i0E, t3);
                            i91 = i4;
                            i5 = i5;
                            i99 = i16 == true ? 1 : 0;
                            i96 = i35;
                            unsafe9 = unsafe4;
                            t9 = t6;
                            i98 = i12;
                            i97 = i37;
                            i95 = i34;
                            i92 = 3;
                            i94 = -1;
                            i93 = 0;
                        } else {
                            i38 = i37;
                            i39 = i36;
                            t7 = t6;
                            unsafe = unsafe4;
                            i40 = i34;
                            c0430h2 = c0430h4;
                            i41 = i16 == true ? 1 : 0;
                        }
                        c0430h2 = c0430h2;
                        t4 = t7;
                        iJ = i39;
                        i11 = i40;
                        i96 = i35;
                        bArr2 = bArr3;
                        i8 = i41;
                        i97 = i38;
                    }
                }
                if (i8 == i5) {
                }
                if (c0430h2.f7438f) {
                    i13 = i8 == true ? 1 : 0;
                    iG = U.g(i13 == true ? 1 : 0, bArr, iJ, i4, z(obj), t3);
                } else {
                    i13 = i8 == true ? 1 : 0;
                    iG = U.g(i13 == true ? 1 : 0, bArr, iJ, i4, z(obj), t3);
                }
                i91 = i4;
                t9 = t3;
                i98 = i12;
                bArr3 = bArr2;
                i5 = i5;
                c0430h4 = c0430h2;
                i95 = i11;
                i99 = i13;
                unsafe9 = unsafe;
                i92 = 3;
                i94 = -1;
                i93 = 0;
                iL = iG;
            } else {
                c0430h1 = c0430h4;
                i5 = i5;
                unsafe = unsafe9;
                i6 = 1048575;
                i7 = i98;
                i8 = i99;
                i9 = i97;
            }
        }
        if (i9 != i6) {
            unsafe.putInt(obj2, i9, i7);
        }
        for (int i120 = c0430h1.f7440h; i120 < c0430h1.f7441i; i120++) {
            int[] iArr2 = c0430h1.f7439g;
            int[] iArr3 = c0430h1.f7433a;
            int i121 = iArr2[i120];
            int i122 = iArr3[i121];
            Object objK = E1.k(obj2, c0430h1.H(i121) & i6);
            if (objK != null && c0430h1.J(i121) != null) {
                androidx.appcompat.app.H.a(c0430h1.L(i121));
                throw null;
            }
        }
        if (i5 == 0) {
            if (iL != i4) {
                throw L0.e();
            }
        } else if (iL > i4 || i8 != i5) {
            throw L0.e();
        }
        return iL;
    }
}
