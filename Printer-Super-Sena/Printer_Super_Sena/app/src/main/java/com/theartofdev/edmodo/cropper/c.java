package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Rect f8966a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final RectF f8967b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final RectF f8968c = new RectF();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final float[] f8969d = new float[6];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final float[] f8970e = new float[6];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f8971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Pair f8972g;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f8973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f8974b;

        a(Bitmap bitmap, int i3) {
            this.f8973a = bitmap;
            this.f8974b = i3;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f8975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f8976b;

        b(Bitmap bitmap, int i3) {
            this.f8975a = bitmap;
            this.f8976b = i3;
        }
    }

    static b A(Bitmap bitmap, N.a aVar) {
        int i3;
        int iD = aVar.d("Orientation", 1);
        if (iD == 3) {
            i3 = 180;
        } else if (iD != 6) {
            i3 = iD != 8 ? 0 : 270;
        } else {
            i3 = 90;
        }
        return new b(bitmap, i3);
    }

    static b B(Bitmap bitmap, Context context, Uri uri) {
        N.a aVar = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                N.a aVar2 = new N.a(inputStreamOpenInputStream);
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception unused) {
                }
                aVar = aVar2;
            }
        } catch (Exception unused2) {
        }
        return aVar != null ? A(bitmap, aVar) : new b(bitmap, 0);
    }

    static void C(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i3) {
        OutputStream outputStreamOpenOutputStream = null;
        try {
            outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i3, outputStreamOpenOutputStream);
        } finally {
            c(outputStreamOpenOutputStream);
        }
    }

    static Uri D(Context context, Bitmap bitmap, Uri uri) {
        boolean z3 = true;
        try {
            if (uri == null) {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } else if (new File(uri.getPath()).exists()) {
                z3 = false;
            }
            if (z3) {
                C(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
            }
            return uri;
        } catch (Exception e3) {
            Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e3);
            return null;
        }
    }

    private static int a(int i3, int i4) {
        if (f8971f == 0) {
            f8971f = o();
        }
        int i5 = 1;
        if (f8971f > 0) {
            while (true) {
                int i6 = i4 / i5;
                int i7 = f8971f;
                if (i6 <= i7 && i3 / i5 <= i7) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    private static int b(int i3, int i4, int i5, int i6) {
        int i7 = 1;
        if (i4 > i6 || i3 > i5) {
            while ((i4 / 2) / i7 > i6 && (i3 / 2) / i7 > i5) {
                i7 *= 2;
            }
        }
        return i7;
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static a d(Context context, Uri uri, float[] fArr, int i3, int i4, int i5, boolean z3, int i6, int i7, int i8, int i9, boolean z4, boolean z5) {
        int i10 = 1;
        do {
            try {
                return e(context, uri, fArr, i3, i4, i5, z3, i6, i7, i8, i9, z4, z5, i10);
            } catch (OutOfMemoryError e3) {
                i10 *= 2;
            }
        } while (i10 <= 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i10 + "): " + uri + "\r\n" + e3.getMessage(), e3);
    }

    private static a e(Context context, Uri uri, float[] fArr, int i3, int i4, int i5, boolean z3, int i6, int i7, int i8, int i9, boolean z4, boolean z5, int i10) throws Throwable {
        int i11;
        Rect rectS = s(fArr, i4, i5, z3, i6, i7);
        int iWidth = i8 > 0 ? i8 : rectS.width();
        int iHeight = i9 > 0 ? i9 : rectS.height();
        Bitmap bitmap = null;
        try {
            a aVarM = m(context, uri, rectS, iWidth, iHeight, i10);
            bitmap = aVarM.f8973a;
            i11 = aVarM.f8974b;
        } catch (Exception unused) {
            i11 = 1;
        }
        if (bitmap == null) {
            return f(context, uri, fArr, i3, z3, i6, i7, i10, rectS, iWidth, iHeight, z4, z5);
        }
        try {
            Bitmap bitmapZ = z(bitmap, i3, z4, z5);
            try {
                if (i3 % 90 != 0) {
                    bitmapZ = i(bitmapZ, fArr, rectS, i3, z3, i6, i7);
                }
                return new a(bitmapZ, i11);
            } catch (OutOfMemoryError e3) {
                e = e3;
                bitmap = bitmapZ;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw e;
            }
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    private static a f(Context context, Uri uri, float[] fArr, int i3, boolean z3, int i4, int i5, int i6, Rect rect, int i7, int i8, boolean z4, boolean z5) {
        Bitmap bitmapH = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int iB = b(rect.width(), rect.height(), i7, i8) * i6;
            options.inSampleSize = iB;
            Bitmap bitmapJ = j(context.getContentResolver(), uri, options);
            if (bitmapJ != null) {
                try {
                    int length = fArr.length;
                    float[] fArr2 = new float[length];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    for (int i9 = 0; i9 < length; i9++) {
                        fArr2[i9] = fArr2[i9] / options.inSampleSize;
                    }
                    bitmapH = h(bitmapJ, fArr2, i3, z3, i4, i5, 1.0f, z4, z5);
                    if (bitmapH != bitmapJ) {
                        bitmapJ.recycle();
                    }
                } catch (Throwable th) {
                    bitmapJ.recycle();
                    throw th;
                }
            }
            return new a(bitmapH, iB);
        } catch (Exception e3) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e3.getMessage(), e3);
        } catch (OutOfMemoryError e4) {
            if (0 != 0) {
                bitmapH.recycle();
            }
            throw e4;
        }
    }

    static a g(Bitmap bitmap, float[] fArr, int i3, boolean z3, int i4, int i5, boolean z4, boolean z5) {
        int i6 = 1;
        do {
            try {
                return new a(h(bitmap, fArr, i3, z3, i4, i5, 1.0f / i6, z4, z5), i6);
            } catch (OutOfMemoryError e3) {
                i6 *= 2;
            }
        } while (i6 <= 8);
        throw e3;
    }

    private static Bitmap h(Bitmap bitmap, float[] fArr, int i3, boolean z3, int i4, int i5, float f3, boolean z4, boolean z5) {
        float f4 = f3;
        Rect rectS = s(fArr, bitmap.getWidth(), bitmap.getHeight(), z3, i4, i5);
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        float f5 = z4 ? -f4 : f4;
        if (z5) {
            f4 = -f4;
        }
        matrix.postScale(f5, f4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rectS.left, rectS.top, rectS.width(), rectS.height(), matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            bitmapCreateBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i3 % 90 != 0 ? i(bitmapCreateBitmap, fArr, rectS, i3, z3, i4, i5) : bitmapCreateBitmap;
    }

    private static Bitmap i(Bitmap bitmap, float[] fArr, Rect rect, int i3, boolean z3, int i4, int i5) {
        int iAbs;
        int iAbs2;
        int iAbs3;
        if (i3 % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians(i3);
        int i6 = (i3 < 90 || (i3 > 180 && i3 < 270)) ? rect.left : rect.right;
        int iAbs4 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= fArr.length) {
                iAbs = 0;
                iAbs2 = 0;
                iAbs3 = 0;
                break;
            }
            float f3 = fArr[i7];
            if (f3 >= i6 - 1 && f3 <= i6 + 1) {
                double dSin = Math.sin(radians);
                int i8 = i7 + 1;
                double d3 = rect.bottom - fArr[i8];
                Double.isNaN(d3);
                iAbs4 = (int) Math.abs(dSin * d3);
                double dCos = Math.cos(radians);
                double d4 = fArr[i8] - rect.top;
                Double.isNaN(d4);
                iAbs2 = (int) Math.abs(dCos * d4);
                double d5 = fArr[i8] - rect.top;
                double dSin2 = Math.sin(radians);
                Double.isNaN(d5);
                iAbs3 = (int) Math.abs(d5 / dSin2);
                double d6 = rect.bottom - fArr[i8];
                double dCos2 = Math.cos(radians);
                Double.isNaN(d6);
                iAbs = (int) Math.abs(d6 / dCos2);
                break;
            }
            i7 += 2;
        }
        rect.set(iAbs4, iAbs2, iAbs3 + iAbs4, iAbs + iAbs2);
        if (z3) {
            n(rect, i4, i5);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private static Bitmap j(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) {
        do {
            InputStream inputStreamOpenInputStream = null;
            try {
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, f8966a, options);
                    c(inputStreamOpenInputStream);
                    return bitmapDecodeStream;
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    c(inputStreamOpenInputStream);
                }
            } catch (Throwable th) {
                c(inputStreamOpenInputStream);
                throw th;
            }
        } while (options.inSampleSize <= 512);
        throw new RuntimeException("Failed to decode image: " + uri);
    }

    private static BitmapFactory.Options k(ContentResolver contentResolver, Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        try {
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, f8966a, options);
                options.inJustDecodeBounds = false;
                c(inputStreamOpenInputStream);
                return options;
            } catch (Throwable th) {
                th = th;
                c(inputStreamOpenInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
    }

    static a l(Context context, Uri uri, int i3, int i4) throws Throwable {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options optionsK = k(contentResolver, uri);
            int i5 = optionsK.outWidth;
            if (i5 == -1 && optionsK.outHeight == -1) {
                throw new RuntimeException("File is not a picture");
            }
            optionsK.inSampleSize = Math.max(b(i5, optionsK.outHeight, i3, i4), a(optionsK.outWidth, optionsK.outHeight));
            return new a(j(contentResolver, uri, optionsK), optionsK.inSampleSize);
        } catch (Exception e3) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e3.getMessage(), e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    private static a m(Context context, Uri uri, Rect rect, int i3, int i4, int i5) throws Throwable {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        int i6;
        InputStream inputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i5 * b(rect.width(), rect.height(), i3, i4);
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                do {
                    try {
                        try {
                            a aVar = new a(bitmapRegionDecoderNewInstance.decodeRegion(rect, options), options.inSampleSize);
                            c(inputStreamOpenInputStream);
                            bitmapRegionDecoderNewInstance.recycle();
                            return aVar;
                        } catch (OutOfMemoryError unused) {
                            i6 = options.inSampleSize * 2;
                            options.inSampleSize = i6;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = inputStreamOpenInputStream;
                        try {
                            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
                        } catch (Throwable th) {
                            th = th;
                            c(inputStream);
                            if (bitmapRegionDecoderNewInstance != null) {
                                bitmapRegionDecoderNewInstance.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpenInputStream;
                        c(inputStream);
                        if (bitmapRegionDecoderNewInstance != null) {
                            bitmapRegionDecoderNewInstance.recycle();
                        }
                        throw th;
                    }
                } while (i6 <= 512);
                c(inputStreamOpenInputStream);
                if (bitmapRegionDecoderNewInstance != null) {
                    bitmapRegionDecoderNewInstance.recycle();
                }
                return new a(null, 1);
            } catch (Exception e4) {
                e = e4;
                bitmapRegionDecoderNewInstance = null;
            } catch (Throwable th3) {
                th = th3;
                bitmapRegionDecoderNewInstance = null;
            }
        } catch (Exception e5) {
            e = e5;
            bitmapRegionDecoderNewInstance = null;
        } catch (Throwable th4) {
            th = th4;
            bitmapRegionDecoderNewInstance = null;
        }
    }

    private static void n(Rect rect, int i3, int i4) {
        if (i3 != i4 || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    private static int o() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, null, 0, iArr);
            int i3 = iArr[0];
            EGLConfig[] eGLConfigArr = new EGLConfig[i3];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, i3, iArr);
            int[] iArr2 = new int[1];
            int i4 = 0;
            for (int i5 = 0; i5 < iArr[0]; i5++) {
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i5], 12332, iArr2);
                int i6 = iArr2[0];
                if (i4 < i6) {
                    i4 = i6;
                }
            }
            egl10.eglTerminate(eGLDisplayEglGetDisplay);
            return Math.max(i4, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float q(float[] fArr) {
        return (v(fArr) + u(fArr)) / 2.0f;
    }

    static float r(float[] fArr) {
        return (p(fArr) + w(fArr)) / 2.0f;
    }

    static Rect s(float[] fArr, int i3, int i4, boolean z3, int i5, int i6) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, u(fArr))), Math.round(Math.max(0.0f, w(fArr))), Math.round(Math.min(i3, v(fArr))), Math.round(Math.min(i4, p(fArr))));
        if (z3) {
            n(rect, i5, i6);
        }
        return rect;
    }

    static float t(float[] fArr) {
        return p(fArr) - w(fArr);
    }

    static float u(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float v(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float w(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float x(float[] fArr) {
        return v(fArr) - u(fArr);
    }

    static Bitmap y(Bitmap bitmap, int i3, int i4, CropImageView.j jVar) {
        Bitmap bitmapCreateScaledBitmap;
        if (i3 > 0 && i4 > 0) {
            try {
                CropImageView.j jVar2 = CropImageView.j.RESIZE_FIT;
                if (jVar == jVar2 || jVar == CropImageView.j.RESIZE_INSIDE || jVar == CropImageView.j.RESIZE_EXACT) {
                    if (jVar == CropImageView.j.RESIZE_EXACT) {
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, false);
                    } else {
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float fMax = Math.max(width / i3, height / i4);
                        bitmapCreateScaledBitmap = (fMax > 1.0f || jVar == jVar2) ? Bitmap.createScaledBitmap(bitmap, (int) (width / fMax), (int) (height / fMax), false) : null;
                    }
                    if (bitmapCreateScaledBitmap != null) {
                        if (bitmapCreateScaledBitmap != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }
            } catch (Exception e3) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e3);
            }
        }
        return bitmap;
    }

    private static Bitmap z(Bitmap bitmap, int i3, boolean z3, boolean z4) {
        if (i3 <= 0 && !z3 && !z4) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3);
        matrix.postScale(z3 ? -1.0f : 1.0f, z4 ? -1.0f : 1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }
}
