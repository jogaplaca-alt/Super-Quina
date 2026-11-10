package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
abstract class U {
    static int a(byte[] bArr, int i3, T t3) {
        int iH = h(bArr, i3, t3);
        int i4 = t3.f7372a;
        if (i4 < 0) {
            throw L0.d();
        }
        if (i4 > bArr.length - iH) {
            throw L0.g();
        }
        if (i4 == 0) {
            t3.f7374c = AbstractC0421f0.f7421b;
            return iH;
        }
        t3.f7374c = AbstractC0421f0.t(bArr, iH, i4);
        return iH + i4;
    }

    static int b(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int c(InterfaceC0456p1 interfaceC0456p1, byte[] bArr, int i3, int i4, int i5, T t3) {
        Object objC = interfaceC0456p1.c();
        int iL = l(objC, interfaceC0456p1, bArr, i3, i4, i5, t3);
        interfaceC0456p1.a(objC);
        t3.f7374c = objC;
        return iL;
    }

    static int d(InterfaceC0456p1 interfaceC0456p1, byte[] bArr, int i3, int i4, T t3) {
        Object objC = interfaceC0456p1.c();
        int iM = m(objC, interfaceC0456p1, bArr, i3, i4, t3);
        interfaceC0456p1.a(objC);
        t3.f7374c = objC;
        return iM;
    }

    static int e(InterfaceC0456p1 interfaceC0456p1, int i3, byte[] bArr, int i4, int i5, I0 i6, T t3) {
        int iD = d(interfaceC0456p1, bArr, i4, i5, t3);
        i6.add(t3.f7374c);
        while (iD < i5) {
            int iH = h(bArr, iD, t3);
            if (i3 != t3.f7372a) {
                break;
            }
            iD = d(interfaceC0456p1, bArr, iH, i5, t3);
            i6.add(t3.f7374c);
        }
        return iD;
    }

    static int f(byte[] bArr, int i3, I0 i4, T t3) {
        C0 c3 = (C0) i4;
        int iH = h(bArr, i3, t3);
        int i5 = t3.f7372a + iH;
        while (iH < i5) {
            iH = h(bArr, iH, t3);
            c3.d(t3.f7372a);
        }
        if (iH == i5) {
            return iH;
        }
        throw L0.g();
    }

    static int g(int i3, byte[] bArr, int i4, int i5, C0473v1 c0473v1, T t3) {
        if ((i3 >>> 3) == 0) {
            throw L0.b();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iK = k(bArr, i4, t3);
            c0473v1.j(i3, Long.valueOf(t3.f7373b));
            return iK;
        }
        if (i6 == 1) {
            c0473v1.j(i3, Long.valueOf(n(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iH = h(bArr, i4, t3);
            int i7 = t3.f7372a;
            if (i7 < 0) {
                throw L0.d();
            }
            if (i7 > bArr.length - iH) {
                throw L0.g();
            }
            if (i7 == 0) {
                c0473v1.j(i3, AbstractC0421f0.f7421b);
            } else {
                c0473v1.j(i3, AbstractC0421f0.t(bArr, iH, i7));
            }
            return iH + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw L0.b();
            }
            c0473v1.j(i3, Integer.valueOf(b(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        C0473v1 c0473v1F = C0473v1.f();
        int i9 = 0;
        while (i4 < i5) {
            int iH2 = h(bArr, i4, t3);
            int i10 = t3.f7372a;
            i9 = i10;
            if (i10 == i8) {
                i4 = iH2;
                break;
            }
            int iG = g(i9, bArr, iH2, i5, c0473v1F, t3);
            i9 = i10;
            i4 = iG;
        }
        if (i4 > i5 || i9 != i8) {
            throw L0.e();
        }
        c0473v1.j(i3, c0473v1F);
        return i4;
    }

    static int h(byte[] bArr, int i3, T t3) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return i(b3, bArr, i4, t3);
        }
        t3.f7372a = b3;
        return i4;
    }

    static int i(int i3, byte[] bArr, int i4, T t3) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            t3.f7372a = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & 127) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            t3.f7372a = i7 | (b4 << 14);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            t3.f7372a = i9 | (b5 << 21);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            t3.f7372a = i11 | (b6 << 28);
            return i12;
        }
        int i13 = i11 | ((b6 & 127) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                t3.f7372a = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int j(int i3, byte[] bArr, int i4, int i5, I0 i6, T t3) {
        C0 c3 = (C0) i6;
        int iH = h(bArr, i4, t3);
        c3.d(t3.f7372a);
        while (iH < i5) {
            int iH2 = h(bArr, iH, t3);
            if (i3 != t3.f7372a) {
                break;
            }
            iH = h(bArr, iH2, t3);
            c3.d(t3.f7372a);
        }
        return iH;
    }

    static int k(byte[] bArr, int i3, T t3) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            t3.f7373b = j3;
            return i4;
        }
        int i5 = i3 + 2;
        byte b3 = bArr[i4];
        long j4 = (j3 & 127) | (((long) (b3 & 127)) << 7);
        int i6 = 7;
        while (b3 < 0) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            i6 += 7;
            j4 |= ((long) (b4 & 127)) << i6;
            b3 = b4;
            i5 = i7;
        }
        t3.f7373b = j4;
        return i5;
    }

    static int l(Object obj, InterfaceC0456p1 interfaceC0456p1, byte[] bArr, int i3, int i4, int i5, T t3) {
        int iY = ((C0430h1) interfaceC0456p1).y(obj, bArr, i3, i4, i5, t3);
        t3.f7374c = obj;
        return iY;
    }

    static int m(Object obj, InterfaceC0456p1 interfaceC0456p1, byte[] bArr, int i3, int i4, T t3) {
        int i5 = i3 + 1;
        int i6 = bArr[i3];
        if (i6 < 0) {
            i5 = i(i6, bArr, i5, t3);
            i6 = t3.f7372a;
        }
        int i7 = i5;
        if (i6 < 0 || i6 > i4 - i7) {
            throw L0.g();
        }
        int i8 = i6 + i7;
        interfaceC0456p1.f(obj, bArr, i7, i8, t3);
        t3.f7374c = obj;
        return i8;
    }

    static long n(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }
}
