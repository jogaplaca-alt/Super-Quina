package z2;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import java.io.File;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesPdf;
import rawbt.sdk.utils.GraphLibrary;
import u2.C0660h1;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f13161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AttributesPdf f13162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AttributesImage f13163h;

    public g(C0660h1 c0660h1, int i3) {
        super(c0660h1, i3);
        this.f13159d = -16777216;
        this.f13160e = -1;
        this.f13161f = 384;
        this.f13162g = new AttributesPdf();
        this.f13163h = new AttributesImage();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005c  */
    /* JADX WARN: Instruction removed from duplicated block: B:13:0x005c, please report this as an issue */
    @Override // z2.f, java.util.concurrent.Callable
    /* JADX INFO: renamed from: a */
    public Bitmap call() {
        String localizedMessage;
        try {
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(new File(this.f13156a.r1().getCacheDir(), "to_preview.pdf"), 268435456));
            PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(this.f13158c);
            Bitmap bitmapMyRenderPdfPage = GraphLibrary.myRenderPdfPage(this.f13156a.r1(), pageOpenPage, this.f13162g, this.f13163h, this.f13161f, c(), b(), null);
            this.f13157b = bitmapMyRenderPdfPage;
            if (bitmapMyRenderPdfPage == null) {
                this.f13157b = GraphLibrary.messageBmp(" Page is empty ", this.f13161f);
            }
            pageOpenPage.close();
            pdfRenderer.close();
        } catch (Exception e3) {
            e = e3;
            localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error " + e.getClass().getSimpleName();
            }
            this.f13157b = GraphLibrary.messageBmp(localizedMessage, this.f13161f);
            e.printStackTrace();
        } catch (OutOfMemoryError e4) {
            e = e4;
            localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error " + e.getClass().getSimpleName();
            }
            this.f13157b = GraphLibrary.messageBmp(localizedMessage, this.f13161f);
            e.printStackTrace();
        }
        return this.f13157b;
    }

    public int b() {
        return this.f13159d;
    }

    public int c() {
        return this.f13160e;
    }

    public void d(AttributesImage attributesImage) {
        this.f13163h = attributesImage;
    }

    public void e(AttributesPdf attributesPdf) {
        this.f13162g = attributesPdf;
    }

    public void f(int i3) {
        this.f13159d = i3;
    }

    public void g(int i3) {
        this.f13160e = i3;
    }

    public void h(int i3) {
        this.f13161f = i3;
    }
}
