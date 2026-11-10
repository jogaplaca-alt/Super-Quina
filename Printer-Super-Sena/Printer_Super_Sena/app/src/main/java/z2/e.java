package z2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.concurrent.Callable;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesQRcode;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.barcode.QrCodeDraw;

/* JADX INFO: loaded from: classes.dex */
public class e implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CommandQRcode f13152c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13150a = -16777216;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13151b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13153d = 9999;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f13154a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13155b = null;
    }

    public e(String str, AttributesQRcode attributesQRcode) {
        this.f13152c = new CommandQRcode(str, attributesQRcode);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a call() {
        int width;
        a aVar = new a();
        Bitmap bitmapDrawQR = QrCodeDraw.drawQR(this.f13152c, this.f13153d, this.f13151b, this.f13150a);
        if (bitmapDrawQR == null) {
            aVar.f13155b = "wrong data";
            return aVar;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f13153d + 32, bitmapDrawQR.getHeight() + 32, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(this.f13151b);
        if (Constant.ALIGNMENT_RIGHT.equals(this.f13152c.getAlignment())) {
            width = this.f13153d - bitmapDrawQR.getWidth();
        } else {
            width = Constant.ALIGNMENT_CENTER.equals(this.f13152c.getAlignment()) ? (this.f13153d - bitmapDrawQR.getWidth()) / 2 : 0;
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(this.f13150a);
        canvas.drawBitmap(bitmapDrawQR, width + 16, 16.0f, paint);
        aVar.f13154a = bitmapCreateBitmap;
        return aVar;
    }

    public void b(int i3) {
        this.f13150a = i3;
    }

    public void c(int i3) {
        this.f13151b = i3;
    }

    public void d(int i3) {
        this.f13153d = i3;
    }
}
