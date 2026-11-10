package z2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.concurrent.Callable;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.barcode.QrCodeDraw;
import ru.a402d.rawbtprinter.RawPrinterApp;

/* JADX INFO: loaded from: classes.dex */
public class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CommandQRcode f13147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13148b = -16777216;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13149c = -1;

    public d(CommandQRcode commandQRcode) {
        this.f13147a = commandQRcode;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() {
        Bitmap bitmapDrawQR = QrCodeDraw.drawQR(this.f13147a, -1, -1, -16777216);
        if (bitmapDrawQR == null) {
            return null;
        }
        int width = bitmapDrawQR.getWidth();
        int height = bitmapDrawQR.getHeight();
        if (RawPrinterApp.l()) {
            height += 24;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width + 32, height + 32, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(-1);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        canvas.drawBitmap(bitmapDrawQR, 16, 16.0f, paint);
        if (RawPrinterApp.l()) {
            paint.setColor(-16776961);
            paint.setTextSize(14.0f);
            canvas.drawText("RAWBT.APP", 1.0f, bitmapCreateBitmap.getHeight() - 1, paint);
        }
        return bitmapCreateBitmap;
    }
}
