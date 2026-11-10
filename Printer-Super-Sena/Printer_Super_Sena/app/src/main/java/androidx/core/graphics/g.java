package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4488b;

        a() {
        }
    }

    private static void a(ArrayList arrayList, char c3, float[] fArr) {
        arrayList.add(new b(c3, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            if (bVarArr[i3].f4489a != bVarArr2[i3].f4489a || bVarArr[i3].f4490b.length != bVarArr2[i3].f4490b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i3 < 0 || i3 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i5 = i4 - i3;
        int iMin = Math.min(i5, length - i3);
        float[] fArr2 = new float[i5];
        System.arraycopy(fArr, i3, fArr2, 0, iMin);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        int i4 = 0;
        while (i3 < str.length()) {
            int i5 = i(str, i3);
            String strTrim = str.substring(i4, i5).trim();
            if (!strTrim.isEmpty()) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i4 = i5;
            i3 = i5 + 1;
        }
        if (i3 - i4 == 1 && i4 < str.length()) {
            a(arrayList, str.charAt(i4), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.i(d(str), path);
            return path;
        } catch (RuntimeException e3) {
            throw new RuntimeException("Error in parsing " + str, e3);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            bVarArr2[i3] = new b(bVarArr[i3]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    private static void g(String str, int i3, a aVar) {
        aVar.f4488b = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 = i3; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == ' ') {
                z3 = false;
                z5 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z3 = false;
                        z5 = true;
                        break;
                    case '-':
                        if (i4 == i3 || z3) {
                            z3 = false;
                        } else {
                            aVar.f4488b = true;
                            z3 = false;
                            z5 = true;
                        }
                        break;
                    case '.':
                        if (z4) {
                            aVar.f4488b = true;
                            z3 = false;
                            z5 = true;
                        } else {
                            z3 = false;
                            z4 = true;
                        }
                        break;
                    default:
                        z3 = false;
                        break;
                }
            } else {
                z3 = true;
            }
            if (z5) {
                aVar.f4487a = i4;
            }
        }
        aVar.f4487a = i4;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i3 = 1;
            int i4 = 0;
            while (i3 < length) {
                g(str, i3, aVar);
                int i5 = aVar.f4487a;
                if (i3 < i5) {
                    fArr[i4] = Float.parseFloat(str.substring(i3, i5));
                    i4++;
                }
                i3 = aVar.f4488b ? i5 : i5 + 1;
            }
            return c(fArr, 0, i4);
        } catch (NumberFormatException e3) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e3);
        }
    }

    private static int i(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c3 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c3, bVar.f4489a, bVar.f4490b);
            c3 = bVar.f4489a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i3 = 0; i3 < bVarArr2.length; i3++) {
            bVarArr[i3].f4489a = bVarArr2[i3].f4489a;
            for (int i4 = 0; i4 < bVarArr2[i3].f4490b.length; i4++) {
                bVarArr[i3].f4490b[i4] = bVarArr2[i3].f4490b[i4];
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private char f4489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f4490b;

        b(char c3, float[] fArr) {
            this.f4489a = c3;
            this.f4490b = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c3, char c4, float[] fArr2) {
            int i3;
            int i4;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            char c5 = c4;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            switch (c5) {
                case 'A':
                case 'a':
                    i3 = 7;
                    break;
                case 'C':
                case 'c':
                    i3 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i3 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i3 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i3 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f15, f16);
                    f11 = f15;
                    f13 = f11;
                    f12 = f16;
                    f14 = f12;
                    i3 = 2;
                    break;
            }
            float f17 = f11;
            float f18 = f12;
            float f19 = f15;
            float f20 = f16;
            int i5 = 0;
            char c6 = c3;
            while (i5 < fArr2.length) {
                if (c5 != 'A') {
                    if (c5 == 'C') {
                        i4 = i5;
                        int i6 = i4 + 2;
                        int i7 = i4 + 3;
                        int i8 = i4 + 4;
                        int i9 = i4 + 5;
                        path.cubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f17 = fArr2[i8];
                        float f21 = fArr2[i9];
                        float f22 = fArr2[i6];
                        float f23 = fArr2[i7];
                        f18 = f21;
                        f14 = f23;
                        f13 = f22;
                    } else if (c5 == 'H') {
                        i4 = i5;
                        path.lineTo(fArr2[i4], f18);
                        f17 = fArr2[i4];
                    } else if (c5 == 'Q') {
                        i4 = i5;
                        int i10 = i4 + 1;
                        int i11 = i4 + 2;
                        int i12 = i4 + 3;
                        path.quadTo(fArr2[i4], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f24 = fArr2[i4];
                        float f25 = fArr2[i10];
                        f17 = fArr2[i11];
                        f18 = fArr2[i12];
                        f13 = f24;
                        f14 = f25;
                    } else if (c5 == 'V') {
                        i4 = i5;
                        path.lineTo(f17, fArr2[i4]);
                        f18 = fArr2[i4];
                    } else if (c5 != 'a') {
                        if (c5 != 'c') {
                            if (c5 == 'h') {
                                path.rLineTo(fArr2[i5], 0.0f);
                                f17 += fArr2[i5];
                            } else if (c5 != 'q') {
                                if (c5 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i5]);
                                    f6 = fArr2[i5];
                                } else if (c5 == 'L') {
                                    int i13 = i5 + 1;
                                    path.lineTo(fArr2[i5], fArr2[i13]);
                                    f17 = fArr2[i5];
                                    f18 = fArr2[i13];
                                } else if (c5 == 'M') {
                                    f17 = fArr2[i5];
                                    f18 = fArr2[i5 + 1];
                                    if (i5 > 0) {
                                        path.lineTo(f17, f18);
                                    } else {
                                        path.moveTo(f17, f18);
                                        i4 = i5;
                                        f20 = f18;
                                        f19 = f17;
                                    }
                                } else if (c5 == 'S') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        f17 = (f17 * 2.0f) - f13;
                                        f18 = (f18 * 2.0f) - f14;
                                    }
                                    float f26 = f18;
                                    float f27 = f17;
                                    int i14 = i5 + 1;
                                    int i15 = i5 + 2;
                                    int i16 = i5 + 3;
                                    path.cubicTo(f27, f26, fArr2[i5], fArr2[i14], fArr2[i15], fArr2[i16]);
                                    f3 = fArr2[i5];
                                    f4 = fArr2[i14];
                                    f17 = fArr2[i15];
                                    f18 = fArr2[i16];
                                    f13 = f3;
                                    f14 = f4;
                                } else if (c5 == 'T') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f17 = (f17 * 2.0f) - f13;
                                        f18 = (f18 * 2.0f) - f14;
                                    }
                                    int i17 = i5 + 1;
                                    path.quadTo(f17, f18, fArr2[i5], fArr2[i17]);
                                    i4 = i5;
                                    f14 = f18;
                                    f13 = f17;
                                    f17 = fArr2[i5];
                                    f18 = fArr2[i17];
                                } else if (c5 == 'l') {
                                    int i18 = i5 + 1;
                                    path.rLineTo(fArr2[i5], fArr2[i18]);
                                    f17 += fArr2[i5];
                                    f6 = fArr2[i18];
                                } else if (c5 == 'm') {
                                    float f28 = fArr2[i5];
                                    f17 += f28;
                                    float f29 = fArr2[i5 + 1];
                                    f18 += f29;
                                    if (i5 > 0) {
                                        path.rLineTo(f28, f29);
                                    } else {
                                        path.rMoveTo(f28, f29);
                                        i4 = i5;
                                        f20 = f18;
                                        f19 = f17;
                                    }
                                } else if (c5 == 's') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        float f30 = f17 - f13;
                                        f7 = f18 - f14;
                                        f8 = f30;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i19 = i5 + 1;
                                    int i20 = i5 + 2;
                                    int i21 = i5 + 3;
                                    path.rCubicTo(f8, f7, fArr2[i5], fArr2[i19], fArr2[i20], fArr2[i21]);
                                    f3 = fArr2[i5] + f17;
                                    f4 = fArr2[i19] + f18;
                                    f17 += fArr2[i20];
                                    f5 = fArr2[i21];
                                } else if (c5 == 't') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f9 = f17 - f13;
                                        f10 = f18 - f14;
                                    } else {
                                        f10 = 0.0f;
                                        f9 = 0.0f;
                                    }
                                    int i22 = i5 + 1;
                                    path.rQuadTo(f9, f10, fArr2[i5], fArr2[i22]);
                                    float f31 = f9 + f17;
                                    float f32 = f10 + f18;
                                    f17 += fArr2[i5];
                                    f18 += fArr2[i22];
                                    f14 = f32;
                                    f13 = f31;
                                }
                                f18 += f6;
                            } else {
                                int i23 = i5 + 1;
                                int i24 = i5 + 2;
                                int i25 = i5 + 3;
                                path.rQuadTo(fArr2[i5], fArr2[i23], fArr2[i24], fArr2[i25]);
                                f3 = fArr2[i5] + f17;
                                f4 = fArr2[i23] + f18;
                                f17 += fArr2[i24];
                                f5 = fArr2[i25];
                            }
                            i4 = i5;
                        } else {
                            int i26 = i5 + 2;
                            int i27 = i5 + 3;
                            int i28 = i5 + 4;
                            int i29 = i5 + 5;
                            path.rCubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i26], fArr2[i27], fArr2[i28], fArr2[i29]);
                            f3 = fArr2[i26] + f17;
                            f4 = fArr2[i27] + f18;
                            f17 += fArr2[i28];
                            f5 = fArr2[i29];
                        }
                        f18 += f5;
                        f13 = f3;
                        f14 = f4;
                        i4 = i5;
                    } else {
                        int i30 = i5 + 5;
                        int i31 = i5 + 6;
                        i4 = i5;
                        g(path, f17, f18, fArr2[i30] + f17, fArr2[i31] + f18, fArr2[i5], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                        f17 += fArr2[i30];
                        f18 += fArr2[i31];
                    }
                    i5 = i4 + i3;
                    c6 = c4;
                    c5 = c6;
                } else {
                    i4 = i5;
                    int i32 = i4 + 5;
                    int i33 = i4 + 6;
                    g(path, f17, f18, fArr2[i32], fArr2[i33], fArr2[i4], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                    f17 = fArr2[i32];
                    f18 = fArr2[i33];
                }
                f14 = f18;
                f13 = f17;
                i5 = i4 + i3;
                c6 = c4;
                c5 = c6;
            }
            fArr[0] = f17;
            fArr[1] = f18;
            fArr[2] = f13;
            fArr[3] = f14;
            fArr[4] = f19;
            fArr[5] = f20;
        }

        private static void f(Path path, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
            double d12 = d5;
            int iCeil = (int) Math.ceil(Math.abs((d11 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d9);
            double dSin = Math.sin(d9);
            double dCos2 = Math.cos(d10);
            double dSin2 = Math.sin(d10);
            double d13 = -d12;
            double d14 = d13 * dCos;
            double d15 = d6 * dSin;
            double d16 = (d14 * dSin2) - (d15 * dCos2);
            double d17 = d13 * dSin;
            double d18 = d6 * dCos;
            double d19 = (dSin2 * d17) + (dCos2 * d18);
            double d20 = iCeil;
            Double.isNaN(d20);
            double d21 = d11 / d20;
            double d22 = d10;
            double d23 = d19;
            double d24 = d16;
            int i3 = 0;
            double d25 = d7;
            double d26 = d8;
            while (i3 < iCeil) {
                double d27 = d22 + d21;
                double dSin3 = Math.sin(d27);
                double dCos3 = Math.cos(d27);
                double d28 = (d3 + ((d12 * dCos) * dCos3)) - (d15 * dSin3);
                double d29 = d4 + (d12 * dSin * dCos3) + (d18 * dSin3);
                double d30 = (d14 * dSin3) - (d15 * dCos3);
                double d31 = (dSin3 * d17) + (dCos3 * d18);
                double d32 = d27 - d22;
                double dTan = Math.tan(d32 / 2.0d);
                double dSin4 = (Math.sin(d32) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d33 = d25 + (d24 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d33, (float) (d26 + (d23 * dSin4)), (float) (d28 - (dSin4 * d30)), (float) (d29 - (dSin4 * d31)), (float) d28, (float) d29);
                i3++;
                d21 = d21;
                dSin = dSin;
                d25 = d28;
                d17 = d17;
                dCos = dCos;
                d22 = d27;
                d23 = d31;
                d24 = d30;
                iCeil = iCeil;
                d26 = d29;
                d12 = d5;
            }
        }

        private static void g(Path path, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z3, boolean z4) {
            double d3;
            double d4;
            double radians = Math.toRadians(f9);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d5 = f3;
            Double.isNaN(d5);
            double d6 = d5 * dCos;
            double d7 = f4;
            Double.isNaN(d7);
            double d8 = f7;
            Double.isNaN(d8);
            double d9 = (d6 + (d7 * dSin)) / d8;
            double d10 = -f3;
            Double.isNaN(d10);
            Double.isNaN(d7);
            double d11 = (d10 * dSin) + (d7 * dCos);
            double d12 = f8;
            Double.isNaN(d12);
            double d13 = d11 / d12;
            double d14 = f5;
            Double.isNaN(d14);
            double d15 = f6;
            Double.isNaN(d15);
            Double.isNaN(d8);
            double d16 = ((d14 * dCos) + (d15 * dSin)) / d8;
            double d17 = -f5;
            Double.isNaN(d17);
            Double.isNaN(d15);
            Double.isNaN(d12);
            double d18 = ((d17 * dSin) + (d15 * dCos)) / d12;
            double d19 = d9 - d16;
            double d20 = d13 - d18;
            double d21 = (d9 + d16) / 2.0d;
            double d22 = (d13 + d18) / 2.0d;
            double d23 = (d19 * d19) + (d20 * d20);
            if (d23 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d23);
                float fSqrt = (float) (Math.sqrt(d23) / 1.99999d);
                g(path, f3, f4, f5, f6, f7 * fSqrt, f8 * fSqrt, f9, z3, z4);
                return;
            }
            double dSqrt = Math.sqrt(d24);
            double d25 = d19 * dSqrt;
            double d26 = dSqrt * d20;
            if (z3 == z4) {
                d3 = d21 - d26;
                d4 = d22 + d25;
            } else {
                d3 = d21 + d26;
                d4 = d22 - d25;
            }
            double dAtan2 = Math.atan2(d13 - d4, d9 - d3);
            double dAtan3 = Math.atan2(d18 - d4, d16 - d3) - dAtan2;
            if (z4 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            Double.isNaN(d8);
            double d27 = d3 * d8;
            Double.isNaN(d12);
            double d28 = d4 * d12;
            f(path, (d27 * dCos) - (d28 * dSin), (d27 * dSin) + (d28 * dCos), d8, d12, d5, d7, radians, dAtan2, dAtan3);
        }

        public static void i(b[] bVarArr, Path path) {
            g.j(bVarArr, path);
        }

        public void h(b bVar, b bVar2, float f3) {
            this.f4489a = bVar.f4489a;
            int i3 = 0;
            while (true) {
                float[] fArr = bVar.f4490b;
                if (i3 >= fArr.length) {
                    return;
                }
                this.f4490b[i3] = (fArr[i3] * (1.0f - f3)) + (bVar2.f4490b[i3] * f3);
                i3++;
            }
        }

        b(b bVar) {
            this.f4489a = bVar.f4489a;
            float[] fArr = bVar.f4490b;
            this.f4490b = g.c(fArr, 0, fArr.length);
        }
    }
}
