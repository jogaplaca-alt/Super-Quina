package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Matrix f9050g = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f9052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f9053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f9054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f9055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PointF f9056f = new PointF();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9057a;

        static {
            int[] iArr = new int[b.values().length];
            f9057a = iArr;
            try {
                iArr[b.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9057a[b.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9057a[b.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9057a[b.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9057a[b.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9057a[b.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9057a[b.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9057a[b.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9057a[b.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    public h(b bVar, g gVar, float f3, float f4) {
        this.f9055e = bVar;
        this.f9051a = gVar.e();
        this.f9052b = gVar.d();
        this.f9053c = gVar.c();
        this.f9054d = gVar.b();
        l(gVar.h(), f3, f4);
    }

    private void a(RectF rectF, float f3, RectF rectF2, int i3, float f4, float f5, boolean z3, boolean z4) {
        float f6 = i3;
        if (f3 > f6) {
            f3 = ((f3 - f6) / 1.05f) + f6;
            this.f9056f.y -= (f3 - f6) / 1.1f;
        }
        float f7 = rectF2.bottom;
        if (f3 > f7) {
            this.f9056f.y -= (f3 - f7) / 2.0f;
        }
        if (f7 - f3 < f4) {
            f3 = f7;
        }
        float f8 = rectF.top;
        float f9 = f3 - f8;
        float f10 = this.f9052b;
        if (f9 < f10) {
            f3 = f8 + f10;
        }
        float f11 = f3 - f8;
        float f12 = this.f9054d;
        if (f11 > f12) {
            f3 = f8 + f12;
        }
        if (f7 - f3 < f4) {
            f3 = f7;
        }
        if (f5 > 0.0f) {
            float f13 = (f3 - f8) * f5;
            float f14 = this.f9051a;
            if (f13 < f14) {
                f3 = Math.min(f7, f8 + (f14 / f5));
                f13 = (f3 - rectF.top) * f5;
            }
            float f15 = this.f9053c;
            if (f13 > f15) {
                f3 = Math.min(rectF2.bottom, rectF.top + (f15 / f5));
                f13 = (f3 - rectF.top) * f5;
            }
            if (z3 && z4) {
                f3 = Math.min(f3, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f5)));
            } else {
                if (z3) {
                    float f16 = rectF.right;
                    float f17 = f16 - f13;
                    float f18 = rectF2.left;
                    if (f17 < f18) {
                        f3 = Math.min(rectF2.bottom, rectF.top + ((f16 - f18) / f5));
                        f13 = (f3 - rectF.top) * f5;
                    }
                }
                if (z4) {
                    float f19 = rectF.left;
                    float f20 = f13 + f19;
                    float f21 = rectF2.right;
                    if (f20 > f21) {
                        f3 = Math.min(f3, Math.min(rectF2.bottom, rectF.top + ((f21 - f19) / f5)));
                    }
                }
            }
        }
        rectF.bottom = f3;
    }

    private void b(RectF rectF, float f3) {
        rectF.bottom = rectF.top + (rectF.width() / f3);
    }

    private void c(RectF rectF, float f3, RectF rectF2, float f4, float f5, boolean z3, boolean z4) {
        if (f3 < 0.0f) {
            f3 /= 1.05f;
            this.f9056f.x -= f3 / 1.1f;
        }
        float f6 = rectF2.left;
        if (f3 < f6) {
            this.f9056f.x -= (f3 - f6) / 2.0f;
        }
        if (f3 - f6 < f4) {
            f3 = f6;
        }
        float f7 = rectF.right;
        float f8 = f7 - f3;
        float f9 = this.f9051a;
        if (f8 < f9) {
            f3 = f7 - f9;
        }
        float f10 = f7 - f3;
        float f11 = this.f9053c;
        if (f10 > f11) {
            f3 = f7 - f11;
        }
        if (f3 - f6 < f4) {
            f3 = f6;
        }
        if (f5 > 0.0f) {
            float f12 = (f7 - f3) / f5;
            float f13 = this.f9052b;
            if (f12 < f13) {
                f3 = Math.max(f6, f7 - (f13 * f5));
                f12 = (rectF.right - f3) / f5;
            }
            float f14 = this.f9054d;
            if (f12 > f14) {
                f3 = Math.max(rectF2.left, rectF.right - (f14 * f5));
                f12 = (rectF.right - f3) / f5;
            }
            if (z3 && z4) {
                f3 = Math.max(f3, Math.max(rectF2.left, rectF.right - (rectF2.height() * f5)));
            } else {
                if (z3) {
                    float f15 = rectF.bottom;
                    float f16 = f15 - f12;
                    float f17 = rectF2.top;
                    if (f16 < f17) {
                        f3 = Math.max(rectF2.left, rectF.right - ((f15 - f17) * f5));
                        f12 = (rectF.right - f3) / f5;
                    }
                }
                if (z4) {
                    float f18 = rectF.top;
                    float f19 = f12 + f18;
                    float f20 = rectF2.bottom;
                    if (f19 > f20) {
                        f3 = Math.max(f3, Math.max(rectF2.left, rectF.right - ((f20 - f18) * f5)));
                    }
                }
            }
        }
        rectF.left = f3;
    }

    private void d(RectF rectF, float f3) {
        rectF.left = rectF.right - (rectF.height() * f3);
    }

    private void e(RectF rectF, RectF rectF2, float f3) {
        rectF.inset((rectF.width() - (rectF.height() * f3)) / 2.0f, 0.0f);
        float f4 = rectF.left;
        float f5 = rectF2.left;
        if (f4 < f5) {
            rectF.offset(f5 - f4, 0.0f);
        }
        float f6 = rectF.right;
        float f7 = rectF2.right;
        if (f6 > f7) {
            rectF.offset(f7 - f6, 0.0f);
        }
    }

    private void f(RectF rectF, float f3, RectF rectF2, int i3, float f4, float f5, boolean z3, boolean z4) {
        float f6 = i3;
        if (f3 > f6) {
            f3 = ((f3 - f6) / 1.05f) + f6;
            this.f9056f.x -= (f3 - f6) / 1.1f;
        }
        float f7 = rectF2.right;
        if (f3 > f7) {
            this.f9056f.x -= (f3 - f7) / 2.0f;
        }
        if (f7 - f3 < f4) {
            f3 = f7;
        }
        float f8 = rectF.left;
        float f9 = f3 - f8;
        float f10 = this.f9051a;
        if (f9 < f10) {
            f3 = f8 + f10;
        }
        float f11 = f3 - f8;
        float f12 = this.f9053c;
        if (f11 > f12) {
            f3 = f8 + f12;
        }
        if (f7 - f3 < f4) {
            f3 = f7;
        }
        if (f5 > 0.0f) {
            float f13 = (f3 - f8) / f5;
            float f14 = this.f9052b;
            if (f13 < f14) {
                f3 = Math.min(f7, f8 + (f14 * f5));
                f13 = (f3 - rectF.left) / f5;
            }
            float f15 = this.f9054d;
            if (f13 > f15) {
                f3 = Math.min(rectF2.right, rectF.left + (f15 * f5));
                f13 = (f3 - rectF.left) / f5;
            }
            if (z3 && z4) {
                f3 = Math.min(f3, Math.min(rectF2.right, rectF.left + (rectF2.height() * f5)));
            } else {
                if (z3) {
                    float f16 = rectF.bottom;
                    float f17 = f16 - f13;
                    float f18 = rectF2.top;
                    if (f17 < f18) {
                        f3 = Math.min(rectF2.right, rectF.left + ((f16 - f18) * f5));
                        f13 = (f3 - rectF.left) / f5;
                    }
                }
                if (z4) {
                    float f19 = rectF.top;
                    float f20 = f13 + f19;
                    float f21 = rectF2.bottom;
                    if (f20 > f21) {
                        f3 = Math.min(f3, Math.min(rectF2.right, rectF.left + ((f21 - f19) * f5)));
                    }
                }
            }
        }
        rectF.right = f3;
    }

    private void g(RectF rectF, float f3) {
        rectF.right = rectF.left + (rectF.height() * f3);
    }

    private void h(RectF rectF, float f3, RectF rectF2, float f4, float f5, boolean z3, boolean z4) {
        if (f3 < 0.0f) {
            f3 /= 1.05f;
            this.f9056f.y -= f3 / 1.1f;
        }
        float f6 = rectF2.top;
        if (f3 < f6) {
            this.f9056f.y -= (f3 - f6) / 2.0f;
        }
        if (f3 - f6 < f4) {
            f3 = f6;
        }
        float f7 = rectF.bottom;
        float f8 = f7 - f3;
        float f9 = this.f9052b;
        if (f8 < f9) {
            f3 = f7 - f9;
        }
        float f10 = f7 - f3;
        float f11 = this.f9054d;
        if (f10 > f11) {
            f3 = f7 - f11;
        }
        if (f3 - f6 < f4) {
            f3 = f6;
        }
        if (f5 > 0.0f) {
            float f12 = (f7 - f3) * f5;
            float f13 = this.f9051a;
            if (f12 < f13) {
                f3 = Math.max(f6, f7 - (f13 / f5));
                f12 = (rectF.bottom - f3) * f5;
            }
            float f14 = this.f9053c;
            if (f12 > f14) {
                f3 = Math.max(rectF2.top, rectF.bottom - (f14 / f5));
                f12 = (rectF.bottom - f3) * f5;
            }
            if (z3 && z4) {
                f3 = Math.max(f3, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f5)));
            } else {
                if (z3) {
                    float f15 = rectF.right;
                    float f16 = f15 - f12;
                    float f17 = rectF2.left;
                    if (f16 < f17) {
                        f3 = Math.max(rectF2.top, rectF.bottom - ((f15 - f17) / f5));
                        f12 = (rectF.bottom - f3) * f5;
                    }
                }
                if (z4) {
                    float f18 = rectF.left;
                    float f19 = f12 + f18;
                    float f20 = rectF2.right;
                    if (f19 > f20) {
                        f3 = Math.max(f3, Math.max(rectF2.top, rectF.bottom - ((f20 - f18) / f5)));
                    }
                }
            }
        }
        rectF.top = f3;
    }

    private void i(RectF rectF, RectF rectF2, float f3) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f3)) / 2.0f);
        float f4 = rectF.top;
        float f5 = rectF2.top;
        if (f4 < f5) {
            rectF.offset(0.0f, f5 - f4);
        }
        float f6 = rectF.bottom;
        float f7 = rectF2.bottom;
        if (f6 > f7) {
            rectF.offset(0.0f, f7 - f6);
        }
    }

    private void j(RectF rectF, float f3) {
        rectF.top = rectF.bottom - (rectF.width() / f3);
    }

    private static float k(float f3, float f4, float f5, float f6) {
        return (f5 - f3) / (f6 - f4);
    }

    private void l(RectF rectF, float f3, float f4) {
        float fCenterY;
        float f5;
        float f6;
        float fCenterX = 0.0f;
        switch (a.f9057a[this.f9055e.ordinal()]) {
            case 1:
                fCenterX = rectF.left - f3;
                fCenterY = rectF.top;
                f6 = fCenterY - f4;
                break;
            case 2:
                fCenterX = rectF.right - f3;
                fCenterY = rectF.top;
                f6 = fCenterY - f4;
                break;
            case 3:
                fCenterX = rectF.left - f3;
                fCenterY = rectF.bottom;
                f6 = fCenterY - f4;
                break;
            case 4:
                fCenterX = rectF.right - f3;
                fCenterY = rectF.bottom;
                f6 = fCenterY - f4;
                break;
            case 5:
                f5 = rectF.left;
                fCenterX = f5 - f3;
                f6 = 0.0f;
                break;
            case 6:
                fCenterY = rectF.top;
                f6 = fCenterY - f4;
                break;
            case 7:
                f5 = rectF.right;
                fCenterX = f5 - f3;
                f6 = 0.0f;
                break;
            case 8:
                fCenterY = rectF.bottom;
                f6 = fCenterY - f4;
                break;
            case 9:
                fCenterX = rectF.centerX() - f3;
                fCenterY = rectF.centerY();
                f6 = fCenterY - f4;
                break;
            default:
                f6 = 0.0f;
                break;
        }
        PointF pointF = this.f9056f;
        pointF.x = fCenterX;
        pointF.y = f6;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    private void n(RectF rectF, float f3, float f4, RectF rectF2, int i3, int i4, float f5) {
        float fCenterX = f3 - rectF.centerX();
        float fCenterY = f4 - rectF.centerY();
        float f6 = rectF.left;
        if (f6 + fCenterX >= 0.0f) {
            float f7 = rectF.right;
            if (f7 + fCenterX > i3 || f6 + fCenterX < rectF2.left || f7 + fCenterX > rectF2.right) {
                fCenterX /= 1.05f;
                this.f9056f.x -= fCenterX / 2.0f;
            }
        } else {
            fCenterX /= 1.05f;
            this.f9056f.x -= fCenterX / 2.0f;
        }
        float f8 = rectF.top;
        if (f8 + fCenterY >= 0.0f) {
            float f9 = rectF.bottom;
            if (f9 + fCenterY > i4 || f8 + fCenterY < rectF2.top || f9 + fCenterY > rectF2.bottom) {
                fCenterY /= 1.05f;
                this.f9056f.y -= fCenterY / 2.0f;
            }
        } else {
            fCenterY /= 1.05f;
            this.f9056f.y -= fCenterY / 2.0f;
        }
        rectF.offset(fCenterX, fCenterY);
        q(rectF, rectF2, f5);
    }

    private void o(RectF rectF, float f3, float f4, RectF rectF2, int i3, int i4, float f5, float f6) {
        switch (a.f9057a[this.f9055e.ordinal()]) {
            case 1:
                if (k(f3, f4, rectF.right, rectF.bottom) >= f6) {
                    c(rectF, f3, rectF2, f5, f6, true, false);
                    j(rectF, f6);
                } else {
                    h(rectF, f4, rectF2, f5, f6, true, false);
                    d(rectF, f6);
                }
                break;
            case 2:
                if (k(rectF.left, f4, f3, rectF.bottom) >= f6) {
                    f(rectF, f3, rectF2, i3, f5, f6, true, false);
                    j(rectF, f6);
                } else {
                    h(rectF, f4, rectF2, f5, f6, false, true);
                    g(rectF, f6);
                }
                break;
            case 3:
                if (k(f3, rectF.top, rectF.right, f4) >= f6) {
                    c(rectF, f3, rectF2, f5, f6, false, true);
                    b(rectF, f6);
                } else {
                    a(rectF, f4, rectF2, i4, f5, f6, true, false);
                    d(rectF, f6);
                }
                break;
            case 4:
                if (k(rectF.left, rectF.top, f3, f4) >= f6) {
                    f(rectF, f3, rectF2, i3, f5, f6, false, true);
                    b(rectF, f6);
                } else {
                    a(rectF, f4, rectF2, i4, f5, f6, false, true);
                    g(rectF, f6);
                }
                break;
            case 5:
                c(rectF, f3, rectF2, f5, f6, true, true);
                i(rectF, rectF2, f6);
                break;
            case 6:
                h(rectF, f4, rectF2, f5, f6, true, true);
                e(rectF, rectF2, f6);
                break;
            case 7:
                f(rectF, f3, rectF2, i3, f5, f6, true, true);
                i(rectF, rectF2, f6);
                break;
            case 8:
                a(rectF, f4, rectF2, i4, f5, f6, true, true);
                e(rectF, rectF2, f6);
                break;
        }
    }

    private void p(RectF rectF, float f3, float f4, RectF rectF2, int i3, int i4, float f5) {
        switch (a.f9057a[this.f9055e.ordinal()]) {
            case 1:
                h(rectF, f4, rectF2, f5, 0.0f, false, false);
                c(rectF, f3, rectF2, f5, 0.0f, false, false);
                break;
            case 2:
                h(rectF, f4, rectF2, f5, 0.0f, false, false);
                f(rectF, f3, rectF2, i3, f5, 0.0f, false, false);
                break;
            case 3:
                a(rectF, f4, rectF2, i4, f5, 0.0f, false, false);
                c(rectF, f3, rectF2, f5, 0.0f, false, false);
                break;
            case 4:
                a(rectF, f4, rectF2, i4, f5, 0.0f, false, false);
                f(rectF, f3, rectF2, i3, f5, 0.0f, false, false);
                break;
            case 5:
                c(rectF, f3, rectF2, f5, 0.0f, false, false);
                break;
            case 6:
                h(rectF, f4, rectF2, f5, 0.0f, false, false);
                break;
            case 7:
                f(rectF, f3, rectF2, i3, f5, 0.0f, false, false);
                break;
            case 8:
                a(rectF, f4, rectF2, i4, f5, 0.0f, false, false);
                break;
        }
    }

    private void q(RectF rectF, RectF rectF2, float f3) {
        float f4 = rectF.left;
        float f5 = rectF2.left;
        if (f4 < f5 + f3) {
            rectF.offset(f5 - f4, 0.0f);
        }
        float f6 = rectF.top;
        float f7 = rectF2.top;
        if (f6 < f7 + f3) {
            rectF.offset(0.0f, f7 - f6);
        }
        float f8 = rectF.right;
        float f9 = rectF2.right;
        if (f8 > f9 - f3) {
            rectF.offset(f9 - f8, 0.0f);
        }
        float f10 = rectF.bottom;
        float f11 = rectF2.bottom;
        if (f10 > f11 - f3) {
            rectF.offset(0.0f, f11 - f10);
        }
    }

    public void m(RectF rectF, float f3, float f4, RectF rectF2, int i3, int i4, float f5, boolean z3, float f6) {
        PointF pointF = this.f9056f;
        float f7 = f3 + pointF.x;
        float f8 = f4 + pointF.y;
        if (this.f9055e == b.CENTER) {
            n(rectF, f7, f8, rectF2, i3, i4, f5);
        } else if (z3) {
            o(rectF, f7, f8, rectF2, i3, i4, f5, f6);
        } else {
            p(rectF, f7, f8, rectF2, i3, i4, f5);
        }
    }
}
