package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends FrameLayout {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private float f8839A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private float f8840B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private float f8841C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private RectF f8842D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f8843E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f8844F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private Uri f8845G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private WeakReference f8846H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private WeakReference f8847I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f8848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CropOverlayView f8849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f8850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f8851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProgressBar f8852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f8853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f8854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.theartofdev.edmodo.cropper.e f8855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f8856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8861n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8862o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8863p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k f8864q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f8865r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8866s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f8867t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8868u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8869v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private i f8870w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private e f8871x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Uri f8872y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8873z;

    class a implements CropOverlayView.b {
        a() {
        }

        @Override // com.theartofdev.edmodo.cropper.CropOverlayView.b
        public void a(boolean z3) {
            CropImageView.this.k(z3, true);
            CropImageView.b(CropImageView.this);
            CropImageView.c(CropImageView.this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f8875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f8876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bitmap f8877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f8878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Exception f8879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f8880f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Rect f8881g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Rect f8882h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f8883i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f8884j;

        b(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i3, int i4) {
            this.f8875a = bitmap;
            this.f8876b = uri;
            this.f8877c = bitmap2;
            this.f8878d = uri2;
            this.f8879e = exc;
            this.f8880f = fArr;
            this.f8881g = rect;
            this.f8882h = rect2;
            this.f8883i = i3;
            this.f8884j = i4;
        }

        public float[] c() {
            return this.f8880f;
        }

        public Rect d() {
            return this.f8881g;
        }

        public Exception e() {
            return this.f8879e;
        }

        public Uri f() {
            return this.f8876b;
        }

        public int g() {
            return this.f8883i;
        }

        public int h() {
            return this.f8884j;
        }

        public Uri i() {
            return this.f8878d;
        }

        public Rect j() {
            return this.f8882h;
        }
    }

    public enum c {
        RECTANGLE,
        OVAL
    }

    public enum d {
        OFF,
        ON_TOUCH,
        ON
    }

    public interface e {
        void a(CropImageView cropImageView, b bVar);
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
        void e(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public enum j {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    public enum k {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        Bundle bundleExtra;
        super(context, attributeSet);
        this.f8850c = new Matrix();
        this.f8851d = new Matrix();
        this.f8853f = new float[8];
        this.f8854g = new float[8];
        this.f8865r = false;
        this.f8866s = true;
        this.f8867t = true;
        this.f8868u = true;
        this.f8873z = 1;
        this.f8839A = 1.0f;
        com.theartofdev.edmodo.cropper.f fVar = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (intent != null && (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) != null) {
            fVar = (com.theartofdev.edmodo.cropper.f) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (fVar == null) {
            fVar = new com.theartofdev.edmodo.cropper.f();
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.g.f1165u, 0, 0);
                try {
                    int i3 = H1.g.f1104F;
                    fVar.f9023l = typedArrayObtainStyledAttributes.getBoolean(i3, fVar.f9023l);
                    int i4 = H1.g.f1167v;
                    fVar.f9024m = typedArrayObtainStyledAttributes.getInteger(i4, fVar.f9024m);
                    fVar.f9025n = typedArrayObtainStyledAttributes.getInteger(H1.g.f1169w, fVar.f9025n);
                    fVar.f9016e = k.values()[typedArrayObtainStyledAttributes.getInt(H1.g.f1119U, fVar.f9016e.ordinal())];
                    fVar.f9019h = typedArrayObtainStyledAttributes.getBoolean(H1.g.f1171x, fVar.f9019h);
                    fVar.f9020i = typedArrayObtainStyledAttributes.getBoolean(H1.g.f1117S, fVar.f9020i);
                    fVar.f9021j = typedArrayObtainStyledAttributes.getInteger(H1.g.f1112N, fVar.f9021j);
                    fVar.f9012a = c.values()[typedArrayObtainStyledAttributes.getInt(H1.g.f1120V, fVar.f9012a.ordinal())];
                    fVar.f9015d = d.values()[typedArrayObtainStyledAttributes.getInt(H1.g.f1106H, fVar.f9015d.ordinal())];
                    fVar.f9013b = typedArrayObtainStyledAttributes.getDimension(H1.g.f1123Y, fVar.f9013b);
                    fVar.f9014c = typedArrayObtainStyledAttributes.getDimension(H1.g.f1124Z, fVar.f9014c);
                    fVar.f9022k = typedArrayObtainStyledAttributes.getFloat(H1.g.f1109K, fVar.f9022k);
                    fVar.f9026o = typedArrayObtainStyledAttributes.getDimension(H1.g.f1103E, fVar.f9026o);
                    fVar.f9027p = typedArrayObtainStyledAttributes.getInteger(H1.g.f1102D, fVar.f9027p);
                    int i5 = H1.g.f1101C;
                    fVar.f9028q = typedArrayObtainStyledAttributes.getDimension(i5, fVar.f9028q);
                    fVar.f9029r = typedArrayObtainStyledAttributes.getDimension(H1.g.f1100B, fVar.f9029r);
                    fVar.f9030s = typedArrayObtainStyledAttributes.getDimension(H1.g.f1099A, fVar.f9030s);
                    fVar.f9031t = typedArrayObtainStyledAttributes.getInteger(H1.g.f1174z, fVar.f9031t);
                    fVar.f9032u = typedArrayObtainStyledAttributes.getDimension(H1.g.f1108J, fVar.f9032u);
                    fVar.f9033v = typedArrayObtainStyledAttributes.getInteger(H1.g.f1107I, fVar.f9033v);
                    fVar.f9034w = typedArrayObtainStyledAttributes.getInteger(H1.g.f1173y, fVar.f9034w);
                    fVar.f9017f = typedArrayObtainStyledAttributes.getBoolean(H1.g.f1121W, this.f8866s);
                    fVar.f9018g = typedArrayObtainStyledAttributes.getBoolean(H1.g.f1122X, this.f8867t);
                    fVar.f9028q = typedArrayObtainStyledAttributes.getDimension(i5, fVar.f9028q);
                    fVar.f9035x = (int) typedArrayObtainStyledAttributes.getDimension(H1.g.f1116R, fVar.f9035x);
                    fVar.f9036y = (int) typedArrayObtainStyledAttributes.getDimension(H1.g.f1115Q, fVar.f9036y);
                    fVar.f9037z = (int) typedArrayObtainStyledAttributes.getFloat(H1.g.f1114P, fVar.f9037z);
                    fVar.f8990A = (int) typedArrayObtainStyledAttributes.getFloat(H1.g.f1113O, fVar.f8990A);
                    fVar.f8991B = (int) typedArrayObtainStyledAttributes.getFloat(H1.g.f1111M, fVar.f8991B);
                    fVar.f8992C = (int) typedArrayObtainStyledAttributes.getFloat(H1.g.f1110L, fVar.f8992C);
                    int i6 = H1.g.f1105G;
                    fVar.f9008S = typedArrayObtainStyledAttributes.getBoolean(i6, fVar.f9008S);
                    fVar.f9009T = typedArrayObtainStyledAttributes.getBoolean(i6, fVar.f9009T);
                    this.f8865r = typedArrayObtainStyledAttributes.getBoolean(H1.g.f1118T, this.f8865r);
                    if (typedArrayObtainStyledAttributes.hasValue(i4) && typedArrayObtainStyledAttributes.hasValue(i4) && !typedArrayObtainStyledAttributes.hasValue(i3)) {
                        fVar.f9023l = true;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
        }
        fVar.c();
        this.f8864q = fVar.f9016e;
        this.f8868u = fVar.f9019h;
        this.f8869v = fVar.f9021j;
        this.f8866s = fVar.f9017f;
        this.f8867t = fVar.f9018g;
        this.f8859l = fVar.f9008S;
        this.f8860m = fVar.f9009T;
        View viewInflate = LayoutInflater.from(context).inflate(H1.d.f1094b, (ViewGroup) this, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(H1.c.f1085c);
        this.f8848a = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) viewInflate.findViewById(H1.c.f1083a);
        this.f8849b = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new a());
        cropOverlayView.setInitialAttributeValues(fVar);
        this.f8852e = (ProgressBar) viewInflate.findViewById(H1.c.f1084b);
        s();
    }

    static /* synthetic */ g b(CropImageView cropImageView) {
        cropImageView.getClass();
        return null;
    }

    static /* synthetic */ f c(CropImageView cropImageView) {
        cropImageView.getClass();
        return null;
    }

    private void d(float f3, float f4, boolean z3, boolean z4) {
        if (this.f8856i != null) {
            if (f3 <= 0.0f || f4 <= 0.0f) {
                return;
            }
            this.f8850c.invert(this.f8851d);
            RectF cropWindowRect = this.f8849b.getCropWindowRect();
            this.f8851d.mapRect(cropWindowRect);
            this.f8850c.reset();
            this.f8850c.postTranslate((f3 - this.f8856i.getWidth()) / 2.0f, (f4 - this.f8856i.getHeight()) / 2.0f);
            l();
            int i3 = this.f8858k;
            if (i3 > 0) {
                this.f8850c.postRotate(i3, com.theartofdev.edmodo.cropper.c.q(this.f8853f), com.theartofdev.edmodo.cropper.c.r(this.f8853f));
                l();
            }
            float fMin = Math.min(f3 / com.theartofdev.edmodo.cropper.c.x(this.f8853f), f4 / com.theartofdev.edmodo.cropper.c.t(this.f8853f));
            k kVar = this.f8864q;
            if (kVar == k.FIT_CENTER || ((kVar == k.CENTER_INSIDE && fMin < 1.0f) || (fMin > 1.0f && this.f8868u))) {
                this.f8850c.postScale(fMin, fMin, com.theartofdev.edmodo.cropper.c.q(this.f8853f), com.theartofdev.edmodo.cropper.c.r(this.f8853f));
                l();
            }
            float f5 = this.f8859l ? -this.f8839A : this.f8839A;
            float f6 = this.f8860m ? -this.f8839A : this.f8839A;
            this.f8850c.postScale(f5, f6, com.theartofdev.edmodo.cropper.c.q(this.f8853f), com.theartofdev.edmodo.cropper.c.r(this.f8853f));
            l();
            this.f8850c.mapRect(cropWindowRect);
            if (z3) {
                this.f8840B = f3 > com.theartofdev.edmodo.cropper.c.x(this.f8853f) ? 0.0f : Math.max(Math.min((f3 / 2.0f) - cropWindowRect.centerX(), -com.theartofdev.edmodo.cropper.c.u(this.f8853f)), getWidth() - com.theartofdev.edmodo.cropper.c.v(this.f8853f)) / f5;
                this.f8841C = f4 <= com.theartofdev.edmodo.cropper.c.t(this.f8853f) ? Math.max(Math.min((f4 / 2.0f) - cropWindowRect.centerY(), -com.theartofdev.edmodo.cropper.c.w(this.f8853f)), getHeight() - com.theartofdev.edmodo.cropper.c.p(this.f8853f)) / f6 : 0.0f;
            } else {
                this.f8840B = Math.min(Math.max(this.f8840B * f5, -cropWindowRect.left), (-cropWindowRect.right) + f3) / f5;
                this.f8841C = Math.min(Math.max(this.f8841C * f6, -cropWindowRect.top), (-cropWindowRect.bottom) + f4) / f6;
            }
            this.f8850c.postTranslate(this.f8840B * f5, this.f8841C * f6);
            cropWindowRect.offset(this.f8840B * f5, this.f8841C * f6);
            this.f8849b.setCropWindowRect(cropWindowRect);
            l();
            this.f8849b.invalidate();
            if (z4) {
                this.f8855h.a(this.f8853f, this.f8850c);
                this.f8848a.startAnimation(this.f8855h);
            } else {
                this.f8848a.setImageMatrix(this.f8850c);
            }
            u(false);
        }
    }

    private void e() {
        Bitmap bitmap = this.f8856i;
        if (bitmap != null && (this.f8863p > 0 || this.f8872y != null)) {
            bitmap.recycle();
        }
        this.f8856i = null;
        this.f8863p = 0;
        this.f8872y = null;
        this.f8873z = 1;
        this.f8858k = 0;
        this.f8839A = 1.0f;
        this.f8840B = 0.0f;
        this.f8841C = 0.0f;
        this.f8850c.reset();
        this.f8845G = null;
        this.f8848a.setImageBitmap(null);
        r();
    }

    private static int j(int i3, int i4, int i5) {
        if (i3 == 1073741824) {
            return i4;
        }
        return i3 == Integer.MIN_VALUE ? Math.min(i5, i4) : i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    public void k(boolean z3, boolean z4) {
        float fMax;
        int width = getWidth();
        int height = getHeight();
        if (this.f8856i == null || width <= 0 || height <= 0) {
            return;
        }
        RectF cropWindowRect = this.f8849b.getCropWindowRect();
        if (z3) {
            if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                d(width, height, false, false);
                return;
            }
            return;
        }
        if (this.f8868u || this.f8839A > 1.0f) {
            if (this.f8839A < this.f8869v) {
                float f3 = width;
                if (cropWindowRect.width() < f3 * 0.5f) {
                    float f4 = height;
                    if (cropWindowRect.height() < 0.5f * f4) {
                        fMax = Math.min(this.f8869v, Math.min(f3 / ((cropWindowRect.width() / this.f8839A) / 0.64f), f4 / ((cropWindowRect.height() / this.f8839A) / 0.64f)));
                    } else {
                        fMax = 0.0f;
                    }
                } else {
                    fMax = 0.0f;
                }
            } else {
                fMax = 0.0f;
            }
            if (this.f8839A > 1.0f) {
                float f5 = width;
                if (cropWindowRect.width() > f5 * 0.65f || cropWindowRect.height() > height * 0.65f) {
                    fMax = Math.max(1.0f, Math.min(f5 / ((cropWindowRect.width() / this.f8839A) / 0.51f), height / ((cropWindowRect.height() / this.f8839A) / 0.51f)));
                }
            }
            float f6 = this.f8868u ? fMax : 1.0f;
            if (f6 <= 0.0f || f6 == this.f8839A) {
                return;
            }
            if (z4) {
                if (this.f8855h == null) {
                    this.f8855h = new com.theartofdev.edmodo.cropper.e(this.f8848a, this.f8849b);
                }
                this.f8855h.b(this.f8853f, this.f8850c);
            }
            this.f8839A = f6;
            d(width, height, true, z4);
        }
    }

    private void l() {
        float[] fArr = this.f8853f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.f8856i.getWidth();
        float[] fArr2 = this.f8853f;
        fArr2[3] = 0.0f;
        fArr2[4] = this.f8856i.getWidth();
        this.f8853f[5] = this.f8856i.getHeight();
        float[] fArr3 = this.f8853f;
        fArr3[6] = 0.0f;
        fArr3[7] = this.f8856i.getHeight();
        this.f8850c.mapPoints(this.f8853f);
        float[] fArr4 = this.f8854g;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.f8850c.mapPoints(fArr4);
    }

    private void q(Bitmap bitmap, int i3, Uri uri, int i4, int i5) {
        Bitmap bitmap2 = this.f8856i;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.f8848a.clearAnimation();
            e();
            this.f8856i = bitmap;
            this.f8848a.setImageBitmap(bitmap);
            this.f8872y = uri;
            this.f8863p = i3;
            this.f8873z = i4;
            this.f8858k = i5;
            d(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.f8849b;
            if (cropOverlayView != null) {
                cropOverlayView.r();
                r();
            }
        }
    }

    private void r() {
        CropOverlayView cropOverlayView = this.f8849b;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.f8866s || this.f8856i == null) ? 4 : 0);
        }
    }

    private void s() {
        this.f8852e.setVisibility(this.f8867t && ((this.f8856i == null && this.f8846H != null) || this.f8847I != null) ? 0 : 4);
    }

    private void u(boolean z3) {
        if (this.f8856i != null && !z3) {
            this.f8849b.t(getWidth(), getHeight(), (this.f8873z * 100.0f) / com.theartofdev.edmodo.cropper.c.x(this.f8854g), (this.f8873z * 100.0f) / com.theartofdev.edmodo.cropper.c.t(this.f8854g));
        }
        this.f8849b.s(z3 ? null : this.f8853f, getWidth(), getHeight());
    }

    public void f() {
        this.f8859l = !this.f8859l;
        d(getWidth(), getHeight(), true, false);
    }

    public void g() {
        this.f8860m = !this.f8860m;
        d(getWidth(), getHeight(), true, false);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.f8849b.getAspectRatioX()), Integer.valueOf(this.f8849b.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f8849b.getCropWindowRect();
        float[] fArr = new float[8];
        float f3 = cropWindowRect.left;
        fArr[0] = f3;
        float f4 = cropWindowRect.top;
        fArr[1] = f4;
        float f5 = cropWindowRect.right;
        fArr[2] = f5;
        fArr[3] = f4;
        fArr[4] = f5;
        float f6 = cropWindowRect.bottom;
        fArr[5] = f6;
        fArr[6] = f3;
        fArr[7] = f6;
        this.f8850c.invert(this.f8851d);
        this.f8851d.mapPoints(fArr);
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = fArr[i3] * this.f8873z;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i3 = this.f8873z;
        Bitmap bitmap = this.f8856i;
        if (bitmap == null) {
            return null;
        }
        return com.theartofdev.edmodo.cropper.c.s(getCropPoints(), bitmap.getWidth() * i3, i3 * bitmap.getHeight(), this.f8849b.m(), this.f8849b.getAspectRatioX(), this.f8849b.getAspectRatioY());
    }

    public c getCropShape() {
        return this.f8849b.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.f8849b;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        return h(0, 0, j.NONE);
    }

    public void getCroppedImageAsync() {
        i(0, 0, j.NONE);
    }

    public d getGuidelines() {
        return this.f8849b.getGuidelines();
    }

    public int getImageResource() {
        return this.f8863p;
    }

    public Uri getImageUri() {
        return this.f8872y;
    }

    public int getMaxZoom() {
        return this.f8869v;
    }

    public int getRotatedDegrees() {
        return this.f8858k;
    }

    public k getScaleType() {
        return this.f8864q;
    }

    public Rect getWholeImageRect() {
        int i3 = this.f8873z;
        Bitmap bitmap = this.f8856i;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i3, bitmap.getHeight() * i3);
    }

    public Bitmap h(int i3, int i4, j jVar) {
        if (this.f8856i == null) {
            return null;
        }
        this.f8848a.clearAnimation();
        j jVar2 = j.NONE;
        int i5 = jVar != jVar2 ? i3 : 0;
        int i6 = jVar != jVar2 ? i4 : 0;
        return com.theartofdev.edmodo.cropper.c.y((this.f8872y == null || (this.f8873z <= 1 && jVar != j.SAMPLING)) ? com.theartofdev.edmodo.cropper.c.g(this.f8856i, getCropPoints(), this.f8858k, this.f8849b.m(), this.f8849b.getAspectRatioX(), this.f8849b.getAspectRatioY(), this.f8859l, this.f8860m).f8973a : com.theartofdev.edmodo.cropper.c.d(getContext(), this.f8872y, getCropPoints(), this.f8858k, this.f8856i.getWidth() * this.f8873z, this.f8856i.getHeight() * this.f8873z, this.f8849b.m(), this.f8849b.getAspectRatioX(), this.f8849b.getAspectRatioY(), i5, i6, this.f8859l, this.f8860m).f8973a, i5, i6, jVar);
    }

    public void i(int i3, int i4, j jVar) {
        if (this.f8871x == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        t(i3, i4, jVar, null, null, 0);
    }

    void m(com.theartofdev.edmodo.cropper.a.C0112a c0112a) {
        this.f8847I = null;
        s();
        e eVar = this.f8871x;
        if (eVar != null) {
            eVar.a(this, new b(this.f8856i, this.f8872y, c0112a.f8951a, c0112a.f8952b, c0112a.f8953c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), c0112a.f8955e));
        }
    }

    void n(com.theartofdev.edmodo.cropper.b.a aVar) {
        this.f8846H = null;
        s();
        if (aVar.f8965e == null) {
            int i3 = aVar.f8964d;
            this.f8857j = i3;
            q(aVar.f8962b, 0, aVar.f8961a, aVar.f8963c, i3);
        }
        i iVar = this.f8870w;
        if (iVar != null) {
            iVar.e(this, aVar.f8961a, aVar.f8965e);
        }
    }

    public void o(int i3) {
        if (this.f8856i != null) {
            int i4 = i3 < 0 ? (i3 % 360) + 360 : i3 % 360;
            boolean z3 = !this.f8849b.m() && ((i4 > 45 && i4 < 135) || (i4 > 215 && i4 < 305));
            RectF rectF = com.theartofdev.edmodo.cropper.c.f8968c;
            rectF.set(this.f8849b.getCropWindowRect());
            float fHeight = (z3 ? rectF.height() : rectF.width()) / 2.0f;
            float fWidth = (z3 ? rectF.width() : rectF.height()) / 2.0f;
            if (z3) {
                boolean z4 = this.f8859l;
                this.f8859l = this.f8860m;
                this.f8860m = z4;
            }
            this.f8850c.invert(this.f8851d);
            float[] fArr = com.theartofdev.edmodo.cropper.c.f8969d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            this.f8851d.mapPoints(fArr);
            this.f8858k = (this.f8858k + i4) % 360;
            d(getWidth(), getHeight(), true, false);
            Matrix matrix = this.f8850c;
            float[] fArr2 = com.theartofdev.edmodo.cropper.c.f8970e;
            matrix.mapPoints(fArr2, fArr);
            double d3 = this.f8839A;
            double dSqrt = Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d));
            Double.isNaN(d3);
            float f3 = (float) (d3 / dSqrt);
            this.f8839A = f3;
            this.f8839A = Math.max(f3, 1.0f);
            d(getWidth(), getHeight(), true, false);
            this.f8850c.mapPoints(fArr2, fArr);
            double dSqrt2 = Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d));
            double d4 = fHeight;
            Double.isNaN(d4);
            float f4 = (float) (d4 * dSqrt2);
            double d5 = fWidth;
            Double.isNaN(d5);
            float f5 = (float) (d5 * dSqrt2);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            rectF.set(f6 - f4, f7 - f5, f6 + f4, f7 + f5);
            this.f8849b.r();
            this.f8849b.setCropWindowRect(rectF);
            d(getWidth(), getHeight(), true, false);
            k(false, false);
            this.f8849b.i();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (this.f8861n <= 0 || this.f8862o <= 0) {
            u(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f8861n;
        layoutParams.height = this.f8862o;
        setLayoutParams(layoutParams);
        if (this.f8856i == null) {
            u(true);
            return;
        }
        float f3 = i5 - i3;
        float f4 = i6 - i4;
        d(f3, f4, true, false);
        if (this.f8842D == null) {
            if (this.f8844F) {
                this.f8844F = false;
                k(false, false);
                return;
            }
            return;
        }
        int i7 = this.f8843E;
        if (i7 != this.f8857j) {
            this.f8858k = i7;
            d(f3, f4, true, false);
        }
        this.f8850c.mapRect(this.f8842D);
        this.f8849b.setCropWindowRect(this.f8842D);
        k(false, false);
        this.f8849b.i();
        this.f8842D = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        double d3;
        double d4;
        int width;
        int height;
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        Bitmap bitmap = this.f8856i;
        if (bitmap == null) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            size2 = bitmap.getHeight();
        }
        if (size < this.f8856i.getWidth()) {
            double d5 = size;
            double width2 = this.f8856i.getWidth();
            Double.isNaN(d5);
            Double.isNaN(width2);
            d3 = d5 / width2;
        } else {
            d3 = Double.POSITIVE_INFINITY;
        }
        if (size2 < this.f8856i.getHeight()) {
            double d6 = size2;
            double height2 = this.f8856i.getHeight();
            Double.isNaN(d6);
            Double.isNaN(height2);
            d4 = d6 / height2;
        } else {
            d4 = Double.POSITIVE_INFINITY;
        }
        if (d3 == Double.POSITIVE_INFINITY && d4 == Double.POSITIVE_INFINITY) {
            width = this.f8856i.getWidth();
            height = this.f8856i.getHeight();
        } else if (d3 <= d4) {
            double height3 = this.f8856i.getHeight();
            Double.isNaN(height3);
            height = (int) (height3 * d3);
            width = size;
        } else {
            double width3 = this.f8856i.getWidth();
            Double.isNaN(width3);
            width = (int) (width3 * d4);
            height = size2;
        }
        int iJ = j(mode, size, width);
        int iJ2 = j(mode2, size2, height);
        this.f8861n = iJ;
        this.f8862o = iJ2;
        setMeasuredDimension(iJ, iJ2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        if (this.f8846H == null && this.f8872y == null && this.f8856i == null && this.f8863p == 0) {
            Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
            if (uri != null) {
                String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                if (string != null) {
                    Pair pair = com.theartofdev.edmodo.cropper.c.f8972g;
                    Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) com.theartofdev.edmodo.cropper.c.f8972g.second).get();
                    com.theartofdev.edmodo.cropper.c.f8972g = null;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        q(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                    }
                }
                if (this.f8872y == null) {
                    setImageUriAsync(uri);
                }
            } else {
                int i3 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                if (i3 > 0) {
                    setImageResource(i3);
                } else {
                    Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                    if (uri2 != null) {
                        setImageUriAsync(uri2);
                    }
                }
            }
            int i4 = bundle.getInt("DEGREES_ROTATED");
            this.f8843E = i4;
            this.f8858k = i4;
            Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
            if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                this.f8849b.setInitialCropWindowRect(rect);
            }
            RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
            if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                this.f8842D = rectF;
            }
            this.f8849b.setCropShape(c.valueOf(bundle.getString("CROP_SHAPE")));
            this.f8868u = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
            this.f8869v = bundle.getInt("CROP_MAX_ZOOM");
            this.f8859l = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
            this.f8860m = bundle.getBoolean("CROP_FLIP_VERTICALLY");
        }
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.theartofdev.edmodo.cropper.b bVar;
        if (this.f8872y == null && this.f8856i == null && this.f8863p < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uriD = this.f8872y;
        if (this.f8865r && uriD == null && this.f8863p < 1) {
            uriD = com.theartofdev.edmodo.cropper.c.D(getContext(), this.f8856i, this.f8845G);
            this.f8845G = uriD;
        }
        if (uriD != null && this.f8856i != null) {
            String string = UUID.randomUUID().toString();
            com.theartofdev.edmodo.cropper.c.f8972g = new Pair(string, new WeakReference(this.f8856i));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference weakReference = this.f8846H;
        if (weakReference != null && (bVar = (com.theartofdev.edmodo.cropper.b) weakReference.get()) != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.b());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uriD);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f8863p);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.f8873z);
        bundle.putInt("DEGREES_ROTATED", this.f8858k);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f8849b.getInitialCropWindowRect());
        RectF rectF = com.theartofdev.edmodo.cropper.c.f8968c;
        rectF.set(this.f8849b.getCropWindowRect());
        this.f8850c.invert(this.f8851d);
        this.f8851d.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.f8849b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f8868u);
        bundle.putInt("CROP_MAX_ZOOM", this.f8869v);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f8859l);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f8860m);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f8844F = i5 > 0 && i6 > 0;
    }

    public void p(Uri uri, Bitmap.CompressFormat compressFormat, int i3, int i4, int i5, j jVar) {
        if (this.f8871x == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        t(i4, i5, jVar, uri, compressFormat, i3);
    }

    public void setAutoZoomEnabled(boolean z3) {
        if (this.f8868u != z3) {
            this.f8868u = z3;
            k(false, false);
            this.f8849b.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.f8849b.setInitialCropWindowRect(rect);
    }

    public void setCropShape(c cVar) {
        this.f8849b.setCropShape(cVar);
    }

    public void setFixedAspectRatio(boolean z3) {
        this.f8849b.setFixedAspectRatio(z3);
    }

    public void setFlippedHorizontally(boolean z3) {
        if (this.f8859l != z3) {
            this.f8859l = z3;
            d(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z3) {
        if (this.f8860m != z3) {
            this.f8860m = z3;
            d(getWidth(), getHeight(), true, false);
        }
    }

    public void setGuidelines(d dVar) {
        this.f8849b.setGuidelines(dVar);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f8849b.setInitialCropWindowRect(null);
        q(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i3) {
        if (i3 != 0) {
            this.f8849b.setInitialCropWindowRect(null);
            q(BitmapFactory.decodeResource(getResources(), i3), i3, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference weakReference = this.f8846H;
            com.theartofdev.edmodo.cropper.b bVar = weakReference != null ? (com.theartofdev.edmodo.cropper.b) weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            e();
            this.f8842D = null;
            this.f8843E = 0;
            this.f8849b.setInitialCropWindowRect(null);
            WeakReference weakReference2 = new WeakReference(new com.theartofdev.edmodo.cropper.b(this, uri));
            this.f8846H = weakReference2;
            ((com.theartofdev.edmodo.cropper.b) weakReference2.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        }
    }

    public void setMaxZoom(int i3) {
        if (this.f8869v == i3 || i3 <= 0) {
            return;
        }
        this.f8869v = i3;
        k(false, false);
        this.f8849b.invalidate();
    }

    public void setMultiTouchEnabled(boolean z3) {
        if (this.f8849b.u(z3)) {
            k(false, false);
            this.f8849b.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(e eVar) {
        this.f8871x = eVar;
    }

    public void setOnCropWindowChangedListener(h hVar) {
    }

    public void setOnSetCropOverlayMovedListener(f fVar) {
    }

    public void setOnSetCropOverlayReleasedListener(g gVar) {
    }

    public void setOnSetImageUriCompleteListener(i iVar) {
        this.f8870w = iVar;
    }

    public void setRotatedDegrees(int i3) {
        int i4 = this.f8858k;
        if (i4 != i3) {
            o(i3 - i4);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z3) {
        this.f8865r = z3;
    }

    public void setScaleType(k kVar) {
        if (kVar != this.f8864q) {
            this.f8864q = kVar;
            this.f8839A = 1.0f;
            this.f8841C = 0.0f;
            this.f8840B = 0.0f;
            this.f8849b.r();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z3) {
        if (this.f8866s != z3) {
            this.f8866s = z3;
            r();
        }
    }

    public void setShowProgressBar(boolean z3) {
        if (this.f8867t != z3) {
            this.f8867t = z3;
            s();
        }
    }

    public void setSnapRadius(float f3) {
        if (f3 >= 0.0f) {
            this.f8849b.setSnapRadius(f3);
        }
    }

    public void t(int i3, int i4, j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i5) {
        CropImageView cropImageView;
        Bitmap bitmap = this.f8856i;
        if (bitmap != null) {
            this.f8848a.clearAnimation();
            WeakReference weakReference = this.f8847I;
            com.theartofdev.edmodo.cropper.a aVar = weakReference != null ? (com.theartofdev.edmodo.cropper.a) weakReference.get() : null;
            if (aVar != null) {
                aVar.cancel(true);
            }
            j jVar2 = j.NONE;
            int i6 = jVar != jVar2 ? i3 : 0;
            int i7 = jVar != jVar2 ? i4 : 0;
            int width = bitmap.getWidth() * this.f8873z;
            int height = bitmap.getHeight();
            int i8 = this.f8873z;
            int i9 = height * i8;
            if (this.f8872y == null || (i8 <= 1 && jVar != j.SAMPLING)) {
                cropImageView = this;
                cropImageView.f8847I = new WeakReference(new com.theartofdev.edmodo.cropper.a(this, bitmap, getCropPoints(), this.f8858k, this.f8849b.m(), this.f8849b.getAspectRatioX(), this.f8849b.getAspectRatioY(), i6, i7, this.f8859l, this.f8860m, jVar, uri, compressFormat, i5));
            } else {
                this.f8847I = new WeakReference(new com.theartofdev.edmodo.cropper.a(this, this.f8872y, getCropPoints(), this.f8858k, width, i9, this.f8849b.m(), this.f8849b.getAspectRatioX(), this.f8849b.getAspectRatioY(), i6, i7, this.f8859l, this.f8860m, jVar, uri, compressFormat, i5));
                cropImageView = this;
            }
            ((com.theartofdev.edmodo.cropper.a) cropImageView.f8847I.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        }
    }
}
