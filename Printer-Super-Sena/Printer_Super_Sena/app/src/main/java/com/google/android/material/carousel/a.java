package com.google.android.material.carousel;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f7882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f7884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f7885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f7886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f7887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final float f7888h;

    a(int i3, float f3, float f4, float f5, int i4, float f6, int i5, float f7, int i6, float f8) {
        this.f7881a = i3;
        this.f7882b = p076x.a.a(f3, f4, f5);
        this.f7883c = i4;
        this.f7885e = f6;
        this.f7884d = i5;
        this.f7886f = f7;
        this.f7887g = i6;
        d(f8, f4, f5, f7);
        this.f7888h = b(f7);
    }

    private float a(float f3, int i3, float f4, int i4, int i5) {
        if (i3 <= 0) {
            f4 = 0.0f;
        }
        float f5 = i4 / 2.0f;
        return (f3 - ((i3 + f5) * f4)) / (i5 + f5);
    }

    private float b(float f3) {
        if (g()) {
            return Math.abs(f3 - this.f7886f) * this.f7881a;
        }
        return Float.MAX_VALUE;
    }

    static a c(float f3, float f4, float f5, float f6, int[] iArr, float f7, int[] iArr2, float f8, int[] iArr3) {
        a aVar = null;
        int i3 = 1;
        for (int i4 : iArr3) {
            int length = iArr2.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = iArr2[i5];
                int length2 = iArr.length;
                int i7 = 0;
                while (i7 < length2) {
                    int i8 = i7;
                    int i9 = length2;
                    int i10 = i5;
                    int i11 = length;
                    a aVar2 = new a(i3, f4, f5, f6, iArr[i7], f7, i6, f8, i4, f3);
                    if (aVar == null || aVar2.f7888h < aVar.f7888h) {
                        if (aVar2.f7888h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i3++;
                    i7 = i8 + 1;
                    length2 = i9;
                    i5 = i10;
                    length = i11;
                }
                i5++;
            }
        }
        return aVar;
    }

    private void d(float f3, float f4, float f5, float f6) {
        float f7 = f3 - f();
        int i3 = this.f7883c;
        if (i3 > 0 && f7 > 0.0f) {
            float f8 = this.f7882b;
            this.f7882b = f8 + Math.min(f7 / i3, f5 - f8);
        } else if (i3 > 0 && f7 < 0.0f) {
            float f9 = this.f7882b;
            this.f7882b = f9 + Math.max(f7 / i3, f4 - f9);
        }
        int i4 = this.f7883c;
        float f10 = i4 > 0 ? this.f7882b : 0.0f;
        this.f7882b = f10;
        float fA = a(f3, i4, f10, this.f7884d, this.f7887g);
        this.f7886f = fA;
        float f11 = (this.f7882b + fA) / 2.0f;
        this.f7885e = f11;
        int i5 = this.f7884d;
        if (i5 <= 0 || fA == f6) {
            return;
        }
        float f12 = (f6 - fA) * this.f7887g;
        float fMin = Math.min(Math.abs(f12), f11 * 0.1f * i5);
        if (f12 > 0.0f) {
            this.f7885e -= fMin / this.f7884d;
            this.f7886f += fMin / this.f7887g;
        } else {
            this.f7885e += fMin / this.f7884d;
            this.f7886f -= fMin / this.f7887g;
        }
    }

    private float f() {
        return (this.f7886f * this.f7887g) + (this.f7885e * this.f7884d) + (this.f7882b * this.f7883c);
    }

    private boolean g() {
        int i3 = this.f7887g;
        if (i3 <= 0 || this.f7883c <= 0 || this.f7884d <= 0) {
            return i3 <= 0 || this.f7883c <= 0 || this.f7886f > this.f7882b;
        }
        float f3 = this.f7886f;
        float f4 = this.f7885e;
        return f3 > f4 && f4 > this.f7882b;
    }

    int e() {
        return this.f7883c + this.f7884d + this.f7887g;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f7881a + ", smallCount=" + this.f7883c + ", smallSize=" + this.f7882b + ", mediumCount=" + this.f7884d + ", mediumSize=" + this.f7885e + ", largeCount=" + this.f7887g + ", largeSize=" + this.f7886f + ", cost=" + this.f7888h + "]";
    }
}
