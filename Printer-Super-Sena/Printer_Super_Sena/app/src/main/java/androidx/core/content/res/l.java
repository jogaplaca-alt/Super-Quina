package androidx.core.content.res;

/* JADX INFO: loaded from: classes.dex */
final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final l f4411k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f4414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f4415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f4416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f4417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f4418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f4419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f4420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f4421j;

    static {
        float[] fArr = b.f4377c;
        double dH = b.h(50.0f);
        Double.isNaN(dH);
        f4411k = k(fArr, (float) ((dH * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    private l(float f3, float f4, float f5, float f6, float f7, float f8, float[] fArr, float f9, float f10, float f11) {
        this.f4417f = f3;
        this.f4412a = f4;
        this.f4413b = f5;
        this.f4414c = f6;
        this.f4415d = f7;
        this.f4416e = f8;
        this.f4418g = fArr;
        this.f4419h = f9;
        this.f4420i = f10;
        this.f4421j = f11;
    }

    static l k(float[] fArr, float f3, float f4, float f5, boolean z3) {
        float[][] fArr2 = b.f4375a;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr3[0] * f6;
        float f8 = fArr[1];
        float f9 = f7 + (fArr3[1] * f8);
        float f10 = fArr[2];
        float f11 = f9 + (fArr3[2] * f10);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[0] * f6) + (fArr4[1] * f8) + (fArr4[2] * f10);
        float[] fArr5 = fArr2[2];
        float f13 = (f6 * fArr5[0]) + (f8 * fArr5[1]) + (f10 * fArr5[2]);
        float f14 = (f5 / 10.0f) + 0.8f;
        float fD = ((double) f14) >= 0.9d ? b.d(0.59f, 0.69f, (f14 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        float fExp = z3 ? 1.0f : (1.0f - (((float) Math.exp(((-f3) - 42.0f) / 92.0f)) * 0.2777778f)) * f14;
        double d3 = fExp;
        if (d3 > 1.0d) {
            fExp = 1.0f;
        } else if (d3 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * fExp) + 1.0f) - fExp, (((100.0f / f12) * fExp) + 1.0f) - fExp, (((100.0f / f13) * fExp) + 1.0f) - fExp};
        float f15 = 1.0f / ((5.0f * f3) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        double d4 = f3;
        Double.isNaN(d4);
        float fCbrt = (f16 * f3) + (0.1f * f17 * f17 * ((float) Math.cbrt(d4 * 5.0d)));
        float fH = b.h(f4) / fArr[1];
        double d5 = fH;
        float fSqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d5, 0.2d));
        double d6 = fArr6[0] * fCbrt * f11;
        Double.isNaN(d6);
        float fPow2 = (float) Math.pow(d6 / 100.0d, 0.42d);
        double d7 = fArr6[1] * fCbrt * f12;
        Double.isNaN(d7);
        float fPow3 = (float) Math.pow(d7 / 100.0d, 0.42d);
        double d8 = fArr6[2] * fCbrt * f13;
        Double.isNaN(d8);
        float[] fArr7 = {fPow2, fPow3, (float) Math.pow(d8 / 100.0d, 0.42d)};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[2];
        float[] fArr8 = {f19, f21, (400.0f * f22) / (f22 + 27.13f)};
        return new l(fH, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fD, f14, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    float a() {
        return this.f4412a;
    }

    float b() {
        return this.f4415d;
    }

    float c() {
        return this.f4419h;
    }

    float d() {
        return this.f4420i;
    }

    float e() {
        return this.f4417f;
    }

    float f() {
        return this.f4413b;
    }

    float g() {
        return this.f4416e;
    }

    float h() {
        return this.f4414c;
    }

    float[] i() {
        return this.f4418g;
    }

    float j() {
        return this.f4421j;
    }
}
