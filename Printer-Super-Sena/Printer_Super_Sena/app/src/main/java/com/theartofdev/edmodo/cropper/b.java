package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class b extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f8956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f8957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8960e;

    public b(CropImageView cropImageView, Uri uri) {
        this.f8957b = uri;
        this.f8956a = new WeakReference(cropImageView);
        this.f8958c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f3 = displayMetrics.density;
        double d3 = f3 > 1.0f ? 1.0f / f3 : 1.0d;
        double d4 = displayMetrics.widthPixels;
        Double.isNaN(d4);
        this.f8959d = (int) (d4 * d3);
        double d5 = displayMetrics.heightPixels;
        Double.isNaN(d5);
        this.f8960e = (int) (d5 * d3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) throws Throwable {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a aVarL = c.l(this.f8958c, this.f8957b, this.f8959d, this.f8960e);
            if (isCancelled()) {
                return null;
            }
            c.b bVarB = c.B(aVarL.f8973a, this.f8958c, this.f8957b);
            return new a(this.f8957b, bVarB.f8975a, aVarL.f8974b, bVarB.f8976b);
        } catch (Exception e3) {
            return new a(this.f8957b, e3);
        }
    }

    public Uri b() {
        return this.f8957b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        CropImageView cropImageView;
        if (aVar != null) {
            if (!isCancelled() && (cropImageView = (CropImageView) this.f8956a.get()) != null) {
                cropImageView.n(aVar);
                return;
            }
            Bitmap bitmap = aVar.f8962b;
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f8961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f8962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Exception f8965e;

        a(Uri uri, Bitmap bitmap, int i3, int i4) {
            this.f8961a = uri;
            this.f8962b = bitmap;
            this.f8963c = i3;
            this.f8964d = i4;
            this.f8965e = null;
        }

        a(Uri uri, Exception exc) {
            this.f8961a = uri;
            this.f8962b = null;
            this.f8963c = 0;
            this.f8964d = 0;
            this.f8965e = exc;
        }
    }
}
