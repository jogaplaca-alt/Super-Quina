package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class a extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f8932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap f8933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f8934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f8935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f8936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f8940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f8945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f8946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CropImageView.j f8947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Uri f8948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Bitmap.CompressFormat f8949r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8950s;

    a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i3, boolean z3, int i4, int i5, int i6, int i7, boolean z4, boolean z5, CropImageView.j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i8) {
        this.f8932a = new WeakReference(cropImageView);
        this.f8935d = cropImageView.getContext();
        this.f8933b = bitmap;
        this.f8936e = fArr;
        this.f8934c = null;
        this.f8937f = i3;
        this.f8940i = z3;
        this.f8941j = i4;
        this.f8942k = i5;
        this.f8943l = i6;
        this.f8944m = i7;
        this.f8945n = z4;
        this.f8946o = z5;
        this.f8947p = jVar;
        this.f8948q = uri;
        this.f8949r = compressFormat;
        this.f8950s = i8;
        this.f8938g = 0;
        this.f8939h = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0112a doInBackground(Void... voidArr) {
        c.a aVarG;
        try {
            if (isCancelled()) {
                return null;
            }
            Uri uri = this.f8934c;
            if (uri != null) {
                aVarG = c.d(this.f8935d, uri, this.f8936e, this.f8937f, this.f8938g, this.f8939h, this.f8940i, this.f8941j, this.f8942k, this.f8943l, this.f8944m, this.f8945n, this.f8946o);
            } else {
                Bitmap bitmap = this.f8933b;
                if (bitmap == null) {
                    return new C0112a((Bitmap) null, 1);
                }
                aVarG = c.g(bitmap, this.f8936e, this.f8937f, this.f8940i, this.f8941j, this.f8942k, this.f8945n, this.f8946o);
            }
            Bitmap bitmapY = c.y(aVarG.f8973a, this.f8943l, this.f8944m, this.f8947p);
            Uri uri2 = this.f8948q;
            if (uri2 == null) {
                return new C0112a(bitmapY, aVarG.f8974b);
            }
            c.C(this.f8935d, bitmapY, uri2, this.f8949r, this.f8950s);
            if (bitmapY != null) {
                bitmapY.recycle();
            }
            return new C0112a(this.f8948q, aVarG.f8974b);
        } catch (Exception e3) {
            return new C0112a(e3, this.f8948q != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(C0112a c0112a) {
        CropImageView cropImageView;
        if (c0112a != null) {
            if (!isCancelled() && (cropImageView = (CropImageView) this.f8932a.get()) != null) {
                cropImageView.m(c0112a);
                return;
            }
            Bitmap bitmap = c0112a.f8951a;
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: com.theartofdev.edmodo.cropper.a$a, reason: collision with other inner class name */
    static final class C0112a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f8951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f8952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Exception f8953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f8954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f8955e;

        C0112a(Bitmap bitmap, int i3) {
            this.f8951a = bitmap;
            this.f8952b = null;
            this.f8953c = null;
            this.f8954d = false;
            this.f8955e = i3;
        }

        C0112a(Uri uri, int i3) {
            this.f8951a = null;
            this.f8952b = uri;
            this.f8953c = null;
            this.f8954d = true;
            this.f8955e = i3;
        }

        C0112a(Exception exc, boolean z3) {
            this.f8951a = null;
            this.f8952b = null;
            this.f8953c = exc;
            this.f8954d = z3;
            this.f8955e = 1;
        }
    }

    a(CropImageView cropImageView, Uri uri, float[] fArr, int i3, int i4, int i5, boolean z3, int i6, int i7, int i8, int i9, boolean z4, boolean z5, CropImageView.j jVar, Uri uri2, Bitmap.CompressFormat compressFormat, int i10) {
        this.f8932a = new WeakReference(cropImageView);
        this.f8935d = cropImageView.getContext();
        this.f8934c = uri;
        this.f8936e = fArr;
        this.f8937f = i3;
        this.f8940i = z3;
        this.f8941j = i6;
        this.f8942k = i7;
        this.f8938g = i4;
        this.f8939h = i5;
        this.f8943l = i8;
        this.f8944m = i9;
        this.f8945n = z4;
        this.f8946o = z5;
        this.f8947p = jVar;
        this.f8948q = uri2;
        this.f8949r = compressFormat;
        this.f8950s = i10;
        this.f8933b = null;
    }
}
