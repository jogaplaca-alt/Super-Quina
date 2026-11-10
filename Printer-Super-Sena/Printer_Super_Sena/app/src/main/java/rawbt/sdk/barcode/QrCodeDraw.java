package rawbt.sdk.barcode;

import E2.N;
import E2.z;
import F2.a;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import rawbt.api.command.CommandQRcode;

/* JADX INFO: loaded from: classes.dex */
public class QrCodeDraw {
    public static Bitmap drawQR(CommandQRcode commandQRcode, int i3, int i4, int i5) {
        int i6;
        N n3 = new N();
        n3.G(z.NONE);
        n3.I(0);
        n3.C(commandQRcode.getData());
        int multiply = commandQRcode.getMultiply();
        int iR = n3.r();
        while (true) {
            i6 = iR * multiply;
            if (i3 <= 0 || i6 <= i3) {
                break;
            }
            multiply--;
            iR = n3.r();
        }
        if (multiply < 1) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i6, n3.g() * multiply, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(i5);
        new a(new Canvas(bitmapCreateBitmap), multiply, i4, i5).a(n3);
        return bitmapCreateBitmap;
    }
}
