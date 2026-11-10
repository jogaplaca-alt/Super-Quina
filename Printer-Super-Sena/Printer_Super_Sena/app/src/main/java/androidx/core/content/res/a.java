package androidx.core.content.res;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f4368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f4369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f4370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f4371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f4372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f4373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f4374i;

    a(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f4366a = f3;
        this.f4367b = f4;
        this.f4368c = f5;
        this.f4369d = f6;
        this.f4370e = f7;
        this.f4371f = f8;
        this.f4372g = f9;
        this.f4373h = f10;
        this.f4374i = f11;
    }

    private static a b(float f3, float f4, float f5) {
        float f6 = 100.0f;
        float f7 = 1000.0f;
        a aVar = null;
        float f8 = 1000.0f;
        float f9 = 0.0f;
        while (Math.abs(f9 - f6) > 0.01f) {
            float f10 = ((f6 - f9) / 2.0f) + f9;
            int iP = e(f10, f4, f3).p();
            float fB = b.b(iP);
            float fAbs = Math.abs(f5 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iP);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f3));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f7 = fAbs;
                    f8 = fA;
                }
            }
            if (f7 == 0.0f && f8 == 0.0f) {
                break;
            }
            if (fB < f5) {
                f9 = f10;
            } else {
                f6 = f10;
            }
        }
        return aVar;
    }

    static a c(int i3) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i3, l.f4411k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i3, l lVar, float[] fArr, float[] fArr2) {
        b.f(i3, fArr2);
        float[][] fArr3 = b.f4375a;
        float f3 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f4 = fArr4[0] * f3;
        float f5 = fArr2[1];
        float f6 = f4 + (fArr4[1] * f5);
        float f7 = fArr2[2];
        float f8 = f6 + (fArr4[2] * f7);
        float[] fArr5 = fArr3[1];
        float f9 = (fArr5[0] * f3) + (fArr5[1] * f5) + (fArr5[2] * f7);
        float[] fArr6 = fArr3[2];
        float f10 = (f3 * fArr6[0]) + (f5 * fArr6[1]) + (f7 * fArr6[2]);
        float f11 = lVar.i()[0] * f8;
        float f12 = lVar.i()[1] * f9;
        float f13 = lVar.i()[2] * f10;
        double dC = lVar.c() * Math.abs(f11);
        Double.isNaN(dC);
        float fPow = (float) Math.pow(dC / 100.0d, 0.42d);
        double dC2 = lVar.c() * Math.abs(f12);
        Double.isNaN(dC2);
        float fPow2 = (float) Math.pow(dC2 / 100.0d, 0.42d);
        double dC3 = lVar.c() * Math.abs(f13);
        Double.isNaN(dC3);
        float fPow3 = (float) Math.pow(dC3 / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f11) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f12) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f13) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d3 = fSignum;
        Double.isNaN(d3);
        double d4 = fSignum2;
        Double.isNaN(d4);
        double d5 = fSignum3;
        Double.isNaN(d5);
        float f14 = ((float) (((d3 * 11.0d) + (d4 * (-12.0d))) + d5)) / 11.0f;
        double d6 = fSignum + fSignum2;
        Double.isNaN(d5);
        Double.isNaN(d6);
        float f15 = ((float) (d6 - (d5 * 2.0d))) / 9.0f;
        float f16 = fSignum2 * 20.0f;
        float f17 = (((fSignum * 20.0f) + f16) + (21.0f * fSignum3)) / 20.0f;
        float f18 = (((fSignum * 40.0f) + f16) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f15, f14)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f19 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f18 * lVar.f()) / lVar.a(), lVar.b() * lVar.j())) * 100.0f;
        float fB = (4.0f / lVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (lVar.a() + 4.0f) * lVar.d();
        double d7 = ((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2;
        Double.isNaN(d7);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((d7 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.g()) * lVar.h()) * ((float) Math.sqrt((f14 * f14) + (f15 * f15)))) / (f17 + 0.305f), 0.9d));
        double d8 = fPow4;
        Double.isNaN(d8);
        float fSqrt = ((float) Math.sqrt(d8 / 100.0d)) * fPow5;
        float fD = lVar.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((fPow5 * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f20 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d9 = f19;
        float fCos = ((float) Math.cos(d9)) * fLog;
        float fSin = fLog * ((float) Math.sin(d9));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f20;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static a e(float f3, float f4, float f5) {
        return f(f3, f4, f5, l.f4411k);
    }

    private static a f(float f3, float f4, float f5, l lVar) {
        float fB = 4.0f / lVar.b();
        double d3 = f3;
        Double.isNaN(d3);
        double d4 = d3 / 100.0d;
        float fSqrt = fB * ((float) Math.sqrt(d4)) * (lVar.a() + 4.0f) * lVar.d();
        float fD = f4 * lVar.d();
        float fSqrt2 = ((float) Math.sqrt(((f4 / ((float) Math.sqrt(d4))) * lVar.b()) / (lVar.a() + 4.0f))) * 50.0f;
        float f6 = (1.7f * f3) / ((0.007f * f3) + 1.0f);
        double d5 = fD;
        Double.isNaN(d5);
        float fLog = ((float) Math.log((d5 * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (3.1415927f * f5) / 180.0f;
        return new a(f5, f4, f3, fSqrt, fD, fSqrt2, f6, fLog * ((float) Math.cos(d6)), fLog * ((float) Math.sin(d6)));
    }

    public static int m(float f3, float f4, float f5) {
        return n(f3, f4, f5, l.f4411k);
    }

    static int n(float f3, float f4, float f5, l lVar) {
        if (f4 < 1.0d || Math.round(f5) <= 0.0d || Math.round(f5) >= 100.0d) {
            return b.a(f5);
        }
        float fMin = f3 < 0.0f ? 0.0f : Math.min(360.0f, f3);
        float f6 = f4;
        a aVar = null;
        float f7 = 0.0f;
        boolean z3 = true;
        while (Math.abs(f7 - f4) >= 0.4f) {
            a aVarB = b(fMin, f6, f5);
            if (!z3) {
                if (aVarB == null) {
                    f4 = f6;
                } else {
                    f7 = f6;
                    aVar = aVarB;
                }
                f6 = ((f4 - f7) / 2.0f) + f7;
            } else {
                if (aVarB != null) {
                    return aVarB.o(lVar);
                }
                f6 = ((f4 - f7) / 2.0f) + f7;
                z3 = false;
            }
        }
        return aVar == null ? b.a(f5) : aVar.o(lVar);
    }

    float a(a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f4373h;
    }

    float h() {
        return this.f4374i;
    }

    float i() {
        return this.f4367b;
    }

    float j() {
        return this.f4366a;
    }

    float k() {
        return this.f4368c;
    }

    float l() {
        return this.f4372g;
    }

    int o(l lVar) {
        float fSqrt;
        if (i() == 0.0d || k() == 0.0d) {
            fSqrt = 0.0f;
        } else {
            float fI = i();
            double dK = k();
            Double.isNaN(dK);
            fSqrt = fI / ((float) Math.sqrt(dK / 100.0d));
        }
        double d3 = fSqrt;
        double dPow = Math.pow(1.64d - Math.pow(0.29d, lVar.e()), 0.73d);
        Double.isNaN(d3);
        float fPow = (float) Math.pow(d3 / dPow, 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        Double.isNaN(dJ);
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = lVar.a();
        double dK2 = k();
        Double.isNaN(dK2);
        double dB = lVar.b();
        Double.isNaN(dB);
        double d4 = 1.0d / dB;
        double dJ2 = lVar.j();
        Double.isNaN(dJ2);
        float fPow2 = fA * ((float) Math.pow(dK2 / 100.0d, d4 / dJ2));
        float fG = fCos * 3846.1538f * lVar.g() * lVar.h();
        float f3 = fPow2 / lVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f4 = (((0.305f + f3) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f5 = fCos2 * f4;
        float f6 = f4 * fSin;
        float f7 = f3 * 460.0f;
        float f8 = (((451.0f * f5) + f7) + (288.0f * f6)) / 1403.0f;
        float f9 = ((f7 - (891.0f * f5)) - (261.0f * f6)) / 1403.0f;
        float f10 = ((f7 - (f5 * 220.0f)) - (f6 * 6300.0f)) / 1403.0f;
        double dAbs = Math.abs(f8);
        Double.isNaN(dAbs);
        double dAbs2 = Math.abs(f8);
        Double.isNaN(dAbs2);
        float fSignum = Math.signum(f8) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs * 27.13d) / (400.0d - dAbs2)), 2.380952380952381d));
        double dAbs3 = Math.abs(f9);
        Double.isNaN(dAbs3);
        double dAbs4 = Math.abs(f9);
        Double.isNaN(dAbs4);
        float fSignum2 = Math.signum(f9) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs3 * 27.13d) / (400.0d - dAbs4)), 2.380952380952381d));
        double dAbs5 = Math.abs(f10);
        Double.isNaN(dAbs5);
        double dAbs6 = Math.abs(f10);
        Double.isNaN(dAbs6);
        float fSignum3 = Math.signum(f10) * (100.0f / lVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (dAbs5 * 27.13d) / (400.0d - dAbs6)), 2.380952380952381d));
        float f11 = fSignum / lVar.i()[0];
        float f12 = fSignum2 / lVar.i()[1];
        float f13 = fSignum3 / lVar.i()[2];
        float[][] fArr = b.f4376b;
        float[] fArr2 = fArr[0];
        float f14 = (fArr2[0] * f11) + (fArr2[1] * f12) + (fArr2[2] * f13);
        float[] fArr3 = fArr[1];
        float f15 = (fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13);
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.d.b(f14, f15, (f11 * fArr4[0]) + (f12 * fArr4[1]) + (f13 * fArr4[2]));
    }

    int p() {
        return o(l.f4411k);
    }
}
