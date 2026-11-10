package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
abstract class GraphicsPrinterCommand extends BytesMultiPrinterCommand {
    GraphicsPrinterCommand() {
    }

    private Bitmap bitmapFromPixels(int i3, int i4, int[] iArr) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i4);
        return bitmapCreateBitmap;
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
    }

    Bitmap decodeColumnFormat(int i3, int i4, byte[] bArr) {
        int[] iArr = new int[i4 * i3];
        int i5 = i4 / 8;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < 8; i8++) {
                for (int i9 = 0; i9 < i3; i9++) {
                    iArr[i6] = (((byte) (bArr[(i5 * i9) + i7] << i8)) & 128) == 128 ? this.escPosEmulator.colorBurn : this.escPosEmulator.colorPaper;
                    i6++;
                }
            }
        }
        return bitmapFromPixels(i3, i4, iArr);
    }

    Bitmap decodeRasterFormat(int i3, int i4, byte[] bArr) {
        int[] iArr = new int[i4 * i3];
        int length = bArr.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            byte b3 = bArr[i6];
            for (int i7 = 0; i7 < 8; i7++) {
                iArr[i5] = (b3 & 128) == 128 ? this.escPosEmulator.colorBurn : this.escPosEmulator.colorPaper;
                b3 = (byte) (b3 << 1);
                i5++;
            }
        }
        return bitmapFromPixels(i3, i4, iArr);
    }
}
