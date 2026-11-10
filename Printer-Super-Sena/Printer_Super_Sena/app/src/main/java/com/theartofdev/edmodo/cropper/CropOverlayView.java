package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CropOverlayView extends View {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final Rect f8903A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean f8904B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScaleGestureDetector f8905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f8907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f8908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f8909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f8910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f8911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f8912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f8913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Path f8914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f8915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RectF f8916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f8919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f8920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f8921q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f8922r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f8923s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private h f8924t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8925u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f8928x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CropImageView.d f8929y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CropImageView.c f8930z;

    public interface b {
        void a(boolean z3);
    }

    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF rectFH = CropOverlayView.this.f8907c.h();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f3 = focusY - currentSpanY;
            float f4 = focusX - currentSpanX;
            float f5 = focusX + currentSpanX;
            float f6 = focusY + currentSpanY;
            if (f4 >= f5 || f3 > f6 || f4 < 0.0f || f5 > CropOverlayView.this.f8907c.c() || f3 < 0.0f || f6 > CropOverlayView.this.f8907c.b()) {
                return true;
            }
            rectFH.set(f4, f3, f5, f6);
            CropOverlayView.this.f8907c.r(rectFH);
            CropOverlayView.this.invalidate();
            return true;
        }
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8907c = new g();
        this.f8909e = new RectF();
        this.f8914j = new Path();
        this.f8915k = new float[8];
        this.f8916l = new RectF();
        this.f8928x = this.f8926v / this.f8927w;
        this.f8903A = new Rect();
    }

    private boolean b(RectF rectF) {
        float f3;
        float f4;
        float fU = com.theartofdev.edmodo.cropper.c.u(this.f8915k);
        float fW = com.theartofdev.edmodo.cropper.c.w(this.f8915k);
        float fV = com.theartofdev.edmodo.cropper.c.v(this.f8915k);
        float fP = com.theartofdev.edmodo.cropper.c.p(this.f8915k);
        if (!n()) {
            this.f8916l.set(fU, fW, fV, fP);
            return false;
        }
        float[] fArr = this.f8915k;
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        if (f10 < f6) {
            float f11 = fArr[3];
            if (f6 < f11) {
                float f12 = fArr[2];
                f6 = f8;
                f4 = f9;
                f8 = f11;
                f3 = f10;
                f7 = f12;
                f5 = f7;
            } else {
                f5 = fArr[2];
                f4 = f7;
                f7 = f5;
                f8 = f6;
                f6 = f11;
                f3 = f8;
            }
        } else {
            f3 = fArr[3];
            if (f6 > f3) {
                f4 = fArr[2];
                f7 = f9;
                f8 = f10;
            } else {
                f4 = f5;
                f3 = f6;
                f5 = f9;
                f6 = f10;
            }
        }
        float f13 = (f6 - f3) / (f5 - f4);
        float f14 = (-1.0f) / f13;
        float f15 = f3 - (f13 * f4);
        float f16 = f3 - (f4 * f14);
        float f17 = f8 - (f13 * f7);
        float f18 = f8 - (f7 * f14);
        float fCenterY = rectF.centerY() - rectF.top;
        float fCenterX = rectF.centerX();
        float f19 = rectF.left;
        float f20 = fCenterY / (fCenterX - f19);
        float f21 = -f20;
        float f22 = rectF.top;
        float f23 = f22 - (f19 * f20);
        float f24 = rectF.right;
        float f25 = f22 - (f21 * f24);
        float f26 = f13 - f20;
        float f27 = (f23 - f15) / f26;
        float fMax = Math.max(fU, f27 < f24 ? f27 : fU);
        float f28 = (f23 - f16) / (f14 - f20);
        if (f28 >= rectF.right) {
            f28 = fMax;
        }
        float fMax2 = Math.max(fMax, f28);
        float f29 = f14 - f21;
        float f30 = (f25 - f18) / f29;
        if (f30 >= rectF.right) {
            f30 = fMax2;
        }
        float fMax3 = Math.max(fMax2, f30);
        float f31 = (f25 - f16) / f29;
        if (f31 <= rectF.left) {
            f31 = fV;
        }
        float fMin = Math.min(fV, f31);
        float f32 = (f25 - f17) / (f13 - f21);
        if (f32 <= rectF.left) {
            f32 = fMin;
        }
        float fMin2 = Math.min(fMin, f32);
        float f33 = (f23 - f17) / f26;
        if (f33 <= rectF.left) {
            f33 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f33);
        float fMax4 = Math.max(fW, Math.max((f13 * fMax3) + f15, (f14 * fMin3) + f16));
        float fMin4 = Math.min(fP, Math.min((f14 * fMax3) + f18, (f13 * fMin3) + f17));
        RectF rectF2 = this.f8916l;
        rectF2.left = fMax3;
        rectF2.top = fMax4;
        rectF2.right = fMin3;
        rectF2.bottom = fMin4;
        return true;
    }

    private void c(boolean z3) {
        try {
            b bVar = this.f8908d;
            if (bVar != null) {
                bVar.a(z3);
            }
        } catch (Exception e3) {
            Log.e("AIC", "Exception in crop window changed", e3);
        }
    }

    private void d(Canvas canvas) {
        RectF rectFH = this.f8907c.h();
        float fMax = Math.max(com.theartofdev.edmodo.cropper.c.u(this.f8915k), 0.0f);
        float fMax2 = Math.max(com.theartofdev.edmodo.cropper.c.w(this.f8915k), 0.0f);
        float fMin = Math.min(com.theartofdev.edmodo.cropper.c.v(this.f8915k), getWidth());
        float fMin2 = Math.min(com.theartofdev.edmodo.cropper.c.p(this.f8915k), getHeight());
        if (this.f8930z != CropImageView.c.RECTANGLE) {
            this.f8914j.reset();
            int i3 = Build.VERSION.SDK_INT;
            this.f8909e.set(rectFH.left, rectFH.top, rectFH.right, rectFH.bottom);
            this.f8914j.addOval(this.f8909e, Path.Direction.CW);
            canvas.save();
            if (i3 >= 26) {
                canvas.clipOutPath(this.f8914j);
            } else {
                canvas.clipPath(this.f8914j, Region.Op.XOR);
            }
            canvas.drawRect(fMax, fMax2, fMin, fMin2, this.f8913i);
            canvas.restore();
            return;
        }
        if (!n()) {
            canvas.drawRect(fMax, fMax2, fMin, rectFH.top, this.f8913i);
            canvas.drawRect(fMax, rectFH.bottom, fMin, fMin2, this.f8913i);
            canvas.drawRect(fMax, rectFH.top, rectFH.left, rectFH.bottom, this.f8913i);
            canvas.drawRect(rectFH.right, rectFH.top, fMin, rectFH.bottom, this.f8913i);
            return;
        }
        int i4 = Build.VERSION.SDK_INT;
        this.f8914j.reset();
        Path path = this.f8914j;
        float[] fArr = this.f8915k;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.f8914j;
        float[] fArr2 = this.f8915k;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.f8914j;
        float[] fArr3 = this.f8915k;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.f8914j;
        float[] fArr4 = this.f8915k;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.f8914j.close();
        canvas.save();
        if (i4 >= 26) {
            canvas.clipOutPath(this.f8914j);
        } else {
            canvas.clipPath(this.f8914j, Region.Op.INTERSECT);
        }
        canvas.clipRect(rectFH, Region.Op.XOR);
        canvas.drawRect(fMax, fMax2, fMin, fMin2, this.f8913i);
        canvas.restore();
    }

    private void e(Canvas canvas) {
        Paint paint = this.f8910f;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF rectFH = this.f8907c.h();
            float f3 = strokeWidth / 2.0f;
            rectFH.inset(f3, f3);
            if (this.f8930z == CropImageView.c.RECTANGLE) {
                canvas.drawRect(rectFH, this.f8910f);
            } else {
                canvas.drawOval(rectFH, this.f8910f);
            }
        }
    }

    private void f(Canvas canvas) {
        if (this.f8911g != null) {
            Paint paint = this.f8910f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f8911g.getStrokeWidth();
            float f3 = strokeWidth2 / 2.0f;
            float f4 = (this.f8930z == CropImageView.c.RECTANGLE ? this.f8919o : 0.0f) + f3;
            RectF rectFH = this.f8907c.h();
            rectFH.inset(f4, f4);
            float f5 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f6 = f3 + f5;
            float f7 = rectFH.left;
            float f8 = rectFH.top;
            canvas.drawLine(f7 - f5, f8 - f6, f7 - f5, f8 + this.f8920p, this.f8911g);
            float f9 = rectFH.left;
            float f10 = rectFH.top;
            canvas.drawLine(f9 - f6, f10 - f5, f9 + this.f8920p, f10 - f5, this.f8911g);
            float f11 = rectFH.right;
            float f12 = rectFH.top;
            canvas.drawLine(f11 + f5, f12 - f6, f11 + f5, f12 + this.f8920p, this.f8911g);
            float f13 = rectFH.right;
            float f14 = rectFH.top;
            canvas.drawLine(f13 + f6, f14 - f5, f13 - this.f8920p, f14 - f5, this.f8911g);
            float f15 = rectFH.left;
            float f16 = rectFH.bottom;
            canvas.drawLine(f15 - f5, f16 + f6, f15 - f5, f16 - this.f8920p, this.f8911g);
            float f17 = rectFH.left;
            float f18 = rectFH.bottom;
            canvas.drawLine(f17 - f6, f18 + f5, f17 + this.f8920p, f18 + f5, this.f8911g);
            float f19 = rectFH.right;
            float f20 = rectFH.bottom;
            canvas.drawLine(f19 + f5, f20 + f6, f19 + f5, f20 - this.f8920p, this.f8911g);
            float f21 = rectFH.right;
            float f22 = rectFH.bottom;
            canvas.drawLine(f21 + f6, f22 + f5, f21 - this.f8920p, f22 + f5, this.f8911g);
        }
    }

    private void g(Canvas canvas) {
        if (this.f8912h != null) {
            Paint paint = this.f8910f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rectFH = this.f8907c.h();
            rectFH.inset(strokeWidth, strokeWidth);
            float fWidth = rectFH.width() / 3.0f;
            float fHeight = rectFH.height() / 3.0f;
            if (this.f8930z != CropImageView.c.OVAL) {
                float f3 = rectFH.left + fWidth;
                float f4 = rectFH.right - fWidth;
                canvas.drawLine(f3, rectFH.top, f3, rectFH.bottom, this.f8912h);
                canvas.drawLine(f4, rectFH.top, f4, rectFH.bottom, this.f8912h);
                float f5 = rectFH.top + fHeight;
                float f6 = rectFH.bottom - fHeight;
                canvas.drawLine(rectFH.left, f5, rectFH.right, f5, this.f8912h);
                canvas.drawLine(rectFH.left, f6, rectFH.right, f6, this.f8912h);
                return;
            }
            float fWidth2 = (rectFH.width() / 2.0f) - strokeWidth;
            float fHeight2 = (rectFH.height() / 2.0f) - strokeWidth;
            float f7 = rectFH.left + fWidth;
            float f8 = rectFH.right - fWidth;
            double d3 = fHeight2;
            double dSin = Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2));
            Double.isNaN(d3);
            float f9 = (float) (d3 * dSin);
            canvas.drawLine(f7, (rectFH.top + fHeight2) - f9, f7, (rectFH.bottom - fHeight2) + f9, this.f8912h);
            canvas.drawLine(f8, (rectFH.top + fHeight2) - f9, f8, (rectFH.bottom - fHeight2) + f9, this.f8912h);
            float f10 = rectFH.top + fHeight;
            float f11 = rectFH.bottom - fHeight;
            double d4 = fWidth2;
            double dCos = Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2));
            Double.isNaN(d4);
            float f12 = (float) (d4 * dCos);
            canvas.drawLine((rectFH.left + fWidth2) - f12, f10, (rectFH.right - fWidth2) + f12, f10, this.f8912h);
            canvas.drawLine((rectFH.left + fWidth2) - f12, f11, (rectFH.right - fWidth2) + f12, f11, this.f8912h);
        }
    }

    private void h(RectF rectF) {
        if (rectF.width() < this.f8907c.e()) {
            float fE = (this.f8907c.e() - rectF.width()) / 2.0f;
            rectF.left -= fE;
            rectF.right += fE;
        }
        if (rectF.height() < this.f8907c.d()) {
            float fD = (this.f8907c.d() - rectF.height()) / 2.0f;
            rectF.top -= fD;
            rectF.bottom += fD;
        }
        if (rectF.width() > this.f8907c.c()) {
            float fWidth = (rectF.width() - this.f8907c.c()) / 2.0f;
            rectF.left += fWidth;
            rectF.right -= fWidth;
        }
        if (rectF.height() > this.f8907c.b()) {
            float fHeight = (rectF.height() - this.f8907c.b()) / 2.0f;
            rectF.top += fHeight;
            rectF.bottom -= fHeight;
        }
        b(rectF);
        if (this.f8916l.width() > 0.0f && this.f8916l.height() > 0.0f) {
            float fMax = Math.max(this.f8916l.left, 0.0f);
            float fMax2 = Math.max(this.f8916l.top, 0.0f);
            float fMin = Math.min(this.f8916l.right, getWidth());
            float fMin2 = Math.min(this.f8916l.bottom, getHeight());
            if (rectF.left < fMax) {
                rectF.left = fMax;
            }
            if (rectF.top < fMax2) {
                rectF.top = fMax2;
            }
            if (rectF.right > fMin) {
                rectF.right = fMin;
            }
            if (rectF.bottom > fMin2) {
                rectF.bottom = fMin2;
            }
        }
        if (!this.f8925u || Math.abs(rectF.width() - (rectF.height() * this.f8928x)) <= 0.1d) {
            return;
        }
        if (rectF.width() > rectF.height() * this.f8928x) {
            float fAbs = Math.abs((rectF.height() * this.f8928x) - rectF.width()) / 2.0f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rectF.width() / this.f8928x) - rectF.height()) / 2.0f;
            rectF.top += fAbs2;
            rectF.bottom -= fAbs2;
        }
    }

    private static Paint j(int i3) {
        Paint paint = new Paint();
        paint.setColor(i3);
        return paint;
    }

    private static Paint k(float f3, int i3) {
        if (f3 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i3);
        paint.setStrokeWidth(f3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void l() {
        float fMax = Math.max(com.theartofdev.edmodo.cropper.c.u(this.f8915k), 0.0f);
        float fMax2 = Math.max(com.theartofdev.edmodo.cropper.c.w(this.f8915k), 0.0f);
        float fMin = Math.min(com.theartofdev.edmodo.cropper.c.v(this.f8915k), getWidth());
        float fMin2 = Math.min(com.theartofdev.edmodo.cropper.c.p(this.f8915k), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.f8904B = true;
        float f3 = this.f8921q;
        float f4 = fMin - fMax;
        float f5 = f3 * f4;
        float f6 = fMin2 - fMax2;
        float f7 = f3 * f6;
        if (this.f8903A.width() > 0 && this.f8903A.height() > 0) {
            rectF.left = (this.f8903A.left / this.f8907c.k()) + fMax;
            rectF.top = (this.f8903A.top / this.f8907c.j()) + fMax2;
            rectF.right = rectF.left + (this.f8903A.width() / this.f8907c.k());
            rectF.bottom = rectF.top + (this.f8903A.height() / this.f8907c.j());
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.f8925u || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f5;
            rectF.top = fMax2 + f7;
            rectF.right = fMin - f5;
            rectF.bottom = fMin2 - f7;
        } else if (f4 / f6 > this.f8928x) {
            rectF.top = fMax2 + f7;
            rectF.bottom = fMin2 - f7;
            float width = getWidth() / 2.0f;
            this.f8928x = this.f8926v / this.f8927w;
            float fMax3 = Math.max(this.f8907c.e(), rectF.height() * this.f8928x) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f5;
            rectF.right = fMin - f5;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(this.f8907c.d(), rectF.width() / this.f8928x) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        h(rectF);
        this.f8907c.r(rectF);
    }

    private boolean n() {
        float[] fArr = this.f8915k;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void o(float f3, float f4) {
        h hVarF = this.f8907c.f(f3, f4, this.f8922r, this.f8930z);
        this.f8924t = hVarF;
        if (hVarF != null) {
            invalidate();
        }
    }

    private void p(float f3, float f4) {
        if (this.f8924t != null) {
            float f5 = this.f8923s;
            RectF rectFH = this.f8907c.h();
            this.f8924t.m(rectFH, f3, f4, this.f8916l, this.f8917m, this.f8918n, b(rectFH) ? 0.0f : f5, this.f8925u, this.f8928x);
            this.f8907c.r(rectFH);
            c(true);
            invalidate();
        }
    }

    private void q() {
        if (this.f8924t != null) {
            this.f8924t = null;
            c(false);
            invalidate();
        }
    }

    public int getAspectRatioX() {
        return this.f8926v;
    }

    public int getAspectRatioY() {
        return this.f8927w;
    }

    public CropImageView.c getCropShape() {
        return this.f8930z;
    }

    public RectF getCropWindowRect() {
        return this.f8907c.h();
    }

    public CropImageView.d getGuidelines() {
        return this.f8929y;
    }

    public Rect getInitialCropWindowRect() {
        return this.f8903A;
    }

    public void i() {
        RectF cropWindowRect = getCropWindowRect();
        h(cropWindowRect);
        this.f8907c.r(cropWindowRect);
    }

    public boolean m() {
        return this.f8925u;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        if (this.f8907c.s()) {
            CropImageView.d dVar = this.f8929y;
            if (dVar == CropImageView.d.ON) {
                g(canvas);
            } else if (dVar == CropImageView.d.ON_TOUCH && this.f8924t != null) {
                g(canvas);
            }
        }
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f8906b) {
            this.f8905a.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            o(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                p(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        q();
        return true;
    }

    public void r() {
        if (this.f8904B) {
            setCropWindowRect(com.theartofdev.edmodo.cropper.c.f8967b);
            l();
            invalidate();
        }
    }

    public void s(float[] fArr, int i3, int i4) {
        if (fArr == null || !Arrays.equals(this.f8915k, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f8915k, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f8915k, 0, fArr.length);
            }
            this.f8917m = i3;
            this.f8918n = i4;
            RectF rectFH = this.f8907c.h();
            if (rectFH.width() == 0.0f || rectFH.height() == 0.0f) {
                l();
            }
        }
    }

    public void setAspectRatioX(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8926v != i3) {
            this.f8926v = i3;
            this.f8928x = i3 / this.f8927w;
            if (this.f8904B) {
                l();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8927w != i3) {
            this.f8927w = i3;
            this.f8928x = this.f8926v / i3;
            if (this.f8904B) {
                l();
                invalidate();
            }
        }
    }

    public void setCropShape(CropImageView.c cVar) {
        if (this.f8930z != cVar) {
            this.f8930z = cVar;
            invalidate();
        }
    }

    public void setCropWindowChangeListener(b bVar) {
        this.f8908d = bVar;
    }

    public void setCropWindowRect(RectF rectF) {
        this.f8907c.r(rectF);
    }

    public void setFixedAspectRatio(boolean z3) {
        if (this.f8925u != z3) {
            this.f8925u = z3;
            if (this.f8904B) {
                l();
                invalidate();
            }
        }
    }

    public void setGuidelines(CropImageView.d dVar) {
        if (this.f8929y != dVar) {
            this.f8929y = dVar;
            if (this.f8904B) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(f fVar) {
        this.f8907c.q(fVar);
        setCropShape(fVar.f9012a);
        setSnapRadius(fVar.f9013b);
        setGuidelines(fVar.f9015d);
        setFixedAspectRatio(fVar.f9023l);
        setAspectRatioX(fVar.f9024m);
        setAspectRatioY(fVar.f9025n);
        u(fVar.f9020i);
        this.f8922r = fVar.f9014c;
        this.f8921q = fVar.f9022k;
        this.f8910f = k(fVar.f9026o, fVar.f9027p);
        this.f8919o = fVar.f9029r;
        this.f8920p = fVar.f9030s;
        this.f8911g = k(fVar.f9028q, fVar.f9031t);
        this.f8912h = k(fVar.f9032u, fVar.f9033v);
        this.f8913i = j(fVar.f9034w);
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.f8903A;
        if (rect == null) {
            rect = com.theartofdev.edmodo.cropper.c.f8966a;
        }
        rect2.set(rect);
        if (this.f8904B) {
            l();
            invalidate();
            c(false);
        }
    }

    public void setSnapRadius(float f3) {
        this.f8923s = f3;
    }

    public void t(float f3, float f4, float f5, float f6) {
        this.f8907c.p(f3, f4, f5, f6);
    }

    public boolean u(boolean z3) {
        if (this.f8906b == z3) {
            return false;
        }
        this.f8906b = z3;
        if (!z3 || this.f8905a != null) {
            return true;
        }
        this.f8905a = new ScaleGestureDetector(getContext(), new c());
        return true;
    }
}
