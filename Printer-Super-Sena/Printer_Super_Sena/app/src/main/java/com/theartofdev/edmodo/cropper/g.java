package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f9040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f9043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f9045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f9046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f9047j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f9038a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f9039b = new RectF();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f9048k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f9049l = 1.0f;

    g() {
    }

    private boolean a() {
        return !s();
    }

    private h.b g(float f3, float f4) {
        float fWidth = this.f9038a.width() / 6.0f;
        RectF rectF = this.f9038a;
        float f5 = rectF.left;
        float f6 = f5 + fWidth;
        float f7 = f5 + (fWidth * 5.0f);
        float fHeight = rectF.height() / 6.0f;
        float f8 = this.f9038a.top;
        float f9 = f8 + fHeight;
        float f10 = f8 + (fHeight * 5.0f);
        if (f3 < f6) {
            if (f4 < f9) {
                return h.b.TOP_LEFT;
            }
            return f4 < f10 ? h.b.LEFT : h.b.BOTTOM_LEFT;
        }
        if (f3 < f7) {
            if (f4 < f9) {
                return h.b.TOP;
            }
            return f4 < f10 ? h.b.CENTER : h.b.BOTTOM;
        }
        if (f4 < f9) {
            return h.b.TOP_RIGHT;
        }
        return f4 < f10 ? h.b.RIGHT : h.b.BOTTOM_RIGHT;
    }

    private h.b i(float f3, float f4, float f5) {
        RectF rectF = this.f9038a;
        if (m(f3, f4, rectF.left, rectF.top, f5)) {
            return h.b.TOP_LEFT;
        }
        RectF rectF2 = this.f9038a;
        if (m(f3, f4, rectF2.right, rectF2.top, f5)) {
            return h.b.TOP_RIGHT;
        }
        RectF rectF3 = this.f9038a;
        if (m(f3, f4, rectF3.left, rectF3.bottom, f5)) {
            return h.b.BOTTOM_LEFT;
        }
        RectF rectF4 = this.f9038a;
        if (m(f3, f4, rectF4.right, rectF4.bottom, f5)) {
            return h.b.BOTTOM_RIGHT;
        }
        RectF rectF5 = this.f9038a;
        if (l(f3, f4, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && a()) {
            return h.b.CENTER;
        }
        RectF rectF6 = this.f9038a;
        if (n(f3, f4, rectF6.left, rectF6.right, rectF6.top, f5)) {
            return h.b.TOP;
        }
        RectF rectF7 = this.f9038a;
        if (n(f3, f4, rectF7.left, rectF7.right, rectF7.bottom, f5)) {
            return h.b.BOTTOM;
        }
        RectF rectF8 = this.f9038a;
        if (o(f3, f4, rectF8.left, rectF8.top, rectF8.bottom, f5)) {
            return h.b.LEFT;
        }
        RectF rectF9 = this.f9038a;
        if (o(f3, f4, rectF9.right, rectF9.top, rectF9.bottom, f5)) {
            return h.b.RIGHT;
        }
        RectF rectF10 = this.f9038a;
        if (!l(f3, f4, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) || a()) {
            return null;
        }
        return h.b.CENTER;
    }

    private static boolean l(float f3, float f4, float f5, float f6, float f7, float f8) {
        return f3 > f5 && f3 < f7 && f4 > f6 && f4 < f8;
    }

    private static boolean m(float f3, float f4, float f5, float f6, float f7) {
        return Math.abs(f3 - f5) <= f7 && Math.abs(f4 - f6) <= f7;
    }

    private static boolean n(float f3, float f4, float f5, float f6, float f7, float f8) {
        return f3 > f5 && f3 < f6 && Math.abs(f4 - f7) <= f8;
    }

    private static boolean o(float f3, float f4, float f5, float f6, float f7, float f8) {
        return Math.abs(f3 - f5) <= f8 && f4 > f6 && f4 < f7;
    }

    public float b() {
        return Math.min(this.f9043f, this.f9047j / this.f9049l);
    }

    public float c() {
        return Math.min(this.f9042e, this.f9046i / this.f9048k);
    }

    public float d() {
        return Math.max(this.f9041d, this.f9045h / this.f9049l);
    }

    public float e() {
        return Math.max(this.f9040c, this.f9044g / this.f9048k);
    }

    public h f(float f3, float f4, float f5, CropImageView.c cVar) {
        h.b bVarG = cVar == CropImageView.c.OVAL ? g(f3, f4) : i(f3, f4, f5);
        if (bVarG != null) {
            return new h(bVarG, this, f3, f4);
        }
        return null;
    }

    public RectF h() {
        this.f9039b.set(this.f9038a);
        return this.f9039b;
    }

    public float j() {
        return this.f9049l;
    }

    public float k() {
        return this.f9048k;
    }

    public void p(float f3, float f4, float f5, float f6) {
        this.f9042e = f3;
        this.f9043f = f4;
        this.f9048k = f5;
        this.f9049l = f6;
    }

    public void q(f fVar) {
        this.f9040c = fVar.f9035x;
        this.f9041d = fVar.f9036y;
        this.f9044g = fVar.f9037z;
        this.f9045h = fVar.f8990A;
        this.f9046i = fVar.f8991B;
        this.f9047j = fVar.f8992C;
    }

    public void r(RectF rectF) {
        this.f9038a.set(rectF);
    }

    public boolean s() {
        return this.f9038a.width() >= 100.0f && this.f9038a.height() >= 100.0f;
    }
}
