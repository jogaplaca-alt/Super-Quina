package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
final class e extends Animation implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f8979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CropOverlayView f8980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f8981c = new float[8];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f8982d = new float[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f8983e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f8984f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f8985g = new float[9];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f8986h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f8987i = new RectF();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f8988j = new float[8];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f8989k = new float[9];

    public e(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f8979a = imageView;
        this.f8980b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void a(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f8982d, 0, 8);
        this.f8984f.set(this.f8980b.getCropWindowRect());
        matrix.getValues(this.f8986h);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f3, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.f8987i;
        RectF rectF2 = this.f8983e;
        float f4 = rectF2.left;
        RectF rectF3 = this.f8984f;
        rectF.left = f4 + ((rectF3.left - f4) * f3);
        float f5 = rectF2.top;
        rectF.top = f5 + ((rectF3.top - f5) * f3);
        float f6 = rectF2.right;
        rectF.right = f6 + ((rectF3.right - f6) * f3);
        float f7 = rectF2.bottom;
        rectF.bottom = f7 + ((rectF3.bottom - f7) * f3);
        this.f8980b.setCropWindowRect(rectF);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            fArr = this.f8988j;
            if (i4 >= fArr.length) {
                break;
            }
            float f8 = this.f8981c[i4];
            fArr[i4] = f8 + ((this.f8982d[i4] - f8) * f3);
            i4++;
        }
        this.f8980b.s(fArr, this.f8979a.getWidth(), this.f8979a.getHeight());
        while (true) {
            float[] fArr2 = this.f8989k;
            if (i3 >= fArr2.length) {
                Matrix imageMatrix = this.f8979a.getImageMatrix();
                imageMatrix.setValues(this.f8989k);
                this.f8979a.setImageMatrix(imageMatrix);
                this.f8979a.invalidate();
                this.f8980b.invalidate();
                return;
            }
            float f9 = this.f8985g[i3];
            fArr2[i3] = f9 + ((this.f8986h[i3] - f9) * f3);
            i3++;
        }
    }

    public void b(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f8981c, 0, 8);
        this.f8983e.set(this.f8980b.getCropWindowRect());
        matrix.getValues(this.f8985g);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f8979a.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
