package z2;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.concurrent.Callable;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesBarcode;
import rawbt.api.command.CommandBarcode;
import rawbt.sdk.barcode.BarCodeDraw;

/* JADX INFO: loaded from: classes.dex */
public class b implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CommandBarcode f13139c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13137a = -16777216;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13138b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13140d = 9999;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f13141a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13142b = null;
    }

    public b(String str, AttributesBarcode attributesBarcode, Context context) {
        this.f13139c = new CommandBarcode(str, attributesBarcode);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a call() {
        int i3;
        a aVar = new a();
        try {
            Bitmap bitmapDrawCode = BarCodeDraw.drawCode(this.f13139c, this.f13140d, this.f13138b, this.f13137a);
            if (bitmapDrawCode == null) {
                aVar.f13142b = "Barcode is null";
                return aVar;
            }
            int width = bitmapDrawCode.getWidth();
            int height = bitmapDrawCode.getHeight();
            int i4 = this.f13140d;
            int i5 = i4 + 32;
            int i6 = height + 32;
            if (width <= i4) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, bitmapDrawCode.getConfig());
                aVar.f13141a = bitmapCreateBitmap;
                bitmapCreateBitmap.eraseColor(this.f13138b);
                int[] iArr = new int[height * width];
                bitmapDrawCode.getPixels(iArr, 0, bitmapDrawCode.getWidth(), 0, 0, bitmapDrawCode.getWidth(), bitmapDrawCode.getHeight());
                if (Constant.ALIGNMENT_RIGHT.equals(this.f13139c.getAlignment())) {
                    i3 = this.f13140d - width;
                } else {
                    i3 = Constant.ALIGNMENT_CENTER.equals(this.f13139c.getAlignment()) ? (this.f13140d - width) / 2 : 0;
                }
                aVar.f13141a.setPixels(iArr, 0, width, i3 + 16, 16, width, height);
            } else {
                aVar.f13141a = null;
                aVar.f13142b = "width overflow";
            }
            return aVar;
        } catch (Exception e3) {
            e3.printStackTrace();
            aVar.f13142b = e3.getLocalizedMessage();
        }
    }

    public void b(int i3) {
        this.f13137a = i3;
    }

    public void c(int i3) {
        this.f13138b = i3;
    }

    public void d(int i3) {
        this.f13140d = i3;
    }
}
