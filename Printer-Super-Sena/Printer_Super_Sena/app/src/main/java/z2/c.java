package z2;

import android.content.Context;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Callable;
import rawbt.sdk.utils.File;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f13143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13144b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13145a = "file not load";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13146b = 0;
    }

    public c(Context context, Parcelable parcelable) {
        this.f13143a = parcelable;
        this.f13144b = context;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a call() {
        a aVar = new a();
        try {
            String filePath = File.getFilePath((Uri) this.f13143a, RawPrinterApp.g());
            aVar.f13145a = filePath;
            if (filePath == null || Objects.equals(filePath, "")) {
                aVar.f13145a = "NoName";
            }
            Context contextG = RawPrinterApp.g();
            Objects.requireNonNull(contextG);
            java.io.File file = new java.io.File(contextG.getCacheDir(), "to_preview.pdf");
            InputStream inputStreamOpenInputStream = this.f13144b.getContentResolver().openInputStream((Uri) this.f13143a);
            Objects.requireNonNull(inputStreamOpenInputStream);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] bArr = new byte[8192];
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 <= 0) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i3);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file, 268435456));
            aVar.f13146b = pdfRenderer.getPageCount();
            pdfRenderer.close();
        } catch (Exception e3) {
            aVar.f13145a = "wrong PDF";
            e3.printStackTrace();
        }
        return aVar;
    }
}
