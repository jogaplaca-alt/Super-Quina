package rawbt.sdk.barcode;

import D2.a;
import E2.C0205v;
import E2.Q;
import E2.U;
import E2.y;
import E2.z;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Objects;
import rawbt.api.Constant;
import rawbt.api.command.CommandBarcode;

/* JADX INFO: loaded from: classes.dex */
public class BarCodeDraw {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:142:0x023e  */
    /* JADX WARN: Code duplicated, block: B:4:0x002d  */
    public static Bitmap drawCode(CommandBarcode commandBarcode, int i3, int i4, int i5) {
        Q qA;
        String data = commandBarcode.getData();
        int length = data.length();
        String type = commandBarcode.getType();
        type.hashCode();
        switch (type) {
            case "code39":
                qA = a.a(8);
                if (data.charAt(0) == '*') {
                    int i6 = length - 1;
                    if (data.charAt(i6) == '*') {
                        data = data.substring(1, i6);
                    }
                    break;
                }
                break;
            case "code93":
                qA = a.a(25);
                break;
            case "databar_expand":
                qA = a.a(31);
                break;
            case "databar_omni":
            case "databar_trunc":
                qA = a.a(29);
                break;
            case "itf":
                qA = a.a(3);
                break;
            case "ean8":
            case "jan8":
                qA = a.a(13);
                Objects.requireNonNull(qA);
                ((C0205v) qA).S(C0205v.a.EAN8);
                if (length == 8) {
                    data = data.substring(0, 7);
                    break;
                }
                break;
            case "ean13":
            case "jan13":
                qA = a.a(13);
                Objects.requireNonNull(qA);
                ((C0205v) qA).S(C0205v.a.EAN13);
                if (length == 13) {
                    data = data.substring(0, 12);
                    break;
                }
                break;
            case "upc_a":
                Q qA2 = a.a(34);
                if (length == 12) {
                    data = data.substring(0, 11);
                }
                qA = qA2;
                break;
            case "upc_e":
                qA = a.a(37);
                if (length == 8) {
                    data = data.substring(0, 7);
                    break;
                }
                break;
            case "gs1_128":
            case "code128":
                qA = a.a(20);
                break;
            case "codabar":
                qA = a.a(18);
                break;
            case "databar_limit":
                qA = a.a(30);
                break;
            default:
                qA = null;
                break;
        }
        if (qA == null) {
            return null;
        }
        int width = commandBarcode.getWidth();
        qA.H(width);
        qA.B(commandBarcode.getHeight());
        qA.F(y.CENTER);
        qA.G(z.NONE);
        String hri = commandBarcode.getHri();
        hri.hashCode();
        switch (hri) {
            case "both":
                qA.G(z.BOTH);
                break;
            case "above":
                qA.G(z.TOP);
                break;
            case "below":
                qA.G(z.BOTTOM);
                break;
        }
        if (commandBarcode.getFont() == 1) {
            qA.E(24);
        }
        if (commandBarcode.getFont() == 2) {
            qA.E(19);
        }
        boolean z3 = qA instanceof U;
        if (z3 || (qA instanceof C0205v)) {
            String hri2 = commandBarcode.getHri();
            hri2.hashCode();
            if (hri2.equals(Constant.HRI_BOTH) || hri2.equals(Constant.HRI_BELOW)) {
                qA.I(commandBarcode.getWidth() * 10);
            }
        }
        qA.C(data);
        int iR = qA.r();
        if (i3 > 0) {
            while (width > 2 && iR > i3) {
                width--;
                qA.H(width);
                if (z3 || (qA instanceof C0205v)) {
                    String hri3 = commandBarcode.getHri();
                    hri3.hashCode();
                    if (hri3.equals(Constant.HRI_BOTH) || hri3.equals(Constant.HRI_BELOW)) {
                        qA.I(width * 10);
                    }
                }
                qA.C(data);
                iR = qA.r();
            }
            if (iR > i3) {
                return null;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(qA.r(), qA.g(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(i4);
        new F2.a(new Canvas(bitmapCreateBitmap), 1.0d, i4, i5).a(qA);
        return bitmapCreateBitmap;
    }
}
