package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
class CommandCharOutput extends BytesMultiPrinterCommand {
    CommandCharOutput() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        set_length(1);
        if (escPosEmulator.font == 1) {
            i3 = 22;
            i4 = 9;
            i5 = 9;
            i6 = 22;
            i7 = 5;
        } else {
            i3 = 32;
            i4 = 12;
            i5 = 12;
            i6 = 32;
            i7 = 4;
        }
        int i8 = escPosEmulator.charRightSpace;
        int i9 = (i4 + i8) * escPosEmulator.widthMultiple;
        int i10 = i3 * escPosEmulator.heightMultiple;
        int i11 = escPosEmulator.input[escPosEmulator.input_pointer] & 255;
        if (i11 > 31) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4 + i8, i3, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(0);
            int[] pixels = BitmapFont.getPixels(i11, escPosEmulator, escPosEmulator.font);
            if (escPosEmulator.inverseColor) {
                for (int i12 = 0; i12 < pixels.length; i12++) {
                    pixels[i12] = pixels[i12] == -1 ? escPosEmulator.colorBurn : escPosEmulator.colorPaper;
                }
            } else {
                for (int i13 = 0; i13 < pixels.length; i13++) {
                    pixels[i13] = pixels[i13] == -1 ? escPosEmulator.colorPaper : escPosEmulator.colorBurn;
                }
            }
            bitmapCreateBitmap.setPixels(pixels, 0, i5, 0, 0, i5, i6);
            if (escPosEmulator.widthMultiple > 1 || escPosEmulator.heightMultiple > 1) {
                bitmapCreateBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i9, i10, false);
            }
            if (escPosEmulator.underline) {
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                paint.setColor(-16777216);
                canvas.drawLine(0.0f, canvas.getHeight() - 1, canvas.getWidth() - 1, canvas.getHeight() - 1, paint);
            }
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i9, i10, i7 * escPosEmulator.heightMultiple, bitmapCreateBitmap));
        }
    }
}
