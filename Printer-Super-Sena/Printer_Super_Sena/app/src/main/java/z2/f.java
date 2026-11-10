package z2;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.util.concurrent.Callable;
import u2.C0660h1;

/* JADX INFO: loaded from: classes.dex */
public class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected C0660h1 f13156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Bitmap f13157b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f13158c;

    public f(C0660h1 c0660h1, int i3) {
        this.f13156a = c0660h1;
        this.f13158c = i3;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(new File(this.f13156a.r1().getCacheDir(), "to_preview.pdf"), 268435456));
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(this.f13158c);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth() * 3, pageOpenPage.getHeight() * 3, Bitmap.Config.ARGB_8888);
                this.f13157b = bitmapCreateBitmap;
                bitmapCreateBitmap.setHasAlpha(false);
                this.f13157b.eraseColor(-1);
                pageOpenPage.render(this.f13157b, null, null, 2);
                pageOpenPage.close();
                pdfRenderer.close();
            }
        } catch (Exception | OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        return this.f13157b;
    }
}
