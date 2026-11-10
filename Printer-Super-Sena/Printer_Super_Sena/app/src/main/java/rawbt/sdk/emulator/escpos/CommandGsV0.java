package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class CommandGsV0 extends GraphicsPrinterCommand {
    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(3);
        int byteNormParam = readByteNormParam(escPosEmulator);
        if (byteNormParam >= 48) {
            byteNormParam -= 48;
        }
        int i3 = read32(escPosEmulator);
        int i4 = i3 * 8;
        int i5 = read32(escPosEmulator);
        int i6 = i3 * i5;
        set_length(i6 + 8);
        try {
            Bitmap bitmapDecodeRasterFormat = decodeRasterFormat(i4, i5, readBytes(escPosEmulator, i6));
            if (byteNormParam == 1) {
                i4 = i3 * 16;
                bitmapDecodeRasterFormat = Bitmap.createScaledBitmap(bitmapDecodeRasterFormat, i4, i5, false);
            } else if (byteNormParam == 2) {
                i5 *= 2;
                bitmapDecodeRasterFormat = Bitmap.createScaledBitmap(bitmapDecodeRasterFormat, i4, i5, false);
            } else if (byteNormParam == 3) {
                i4 = i3 * 16;
                i5 *= 2;
                bitmapDecodeRasterFormat = Bitmap.createScaledBitmap(bitmapDecodeRasterFormat, i4, i5, false);
            }
            escPosEmulator.commandMessage = "GSv0 w:" + i4 + " h:" + i5;
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i4, i5, bitmapDecodeRasterFormat));
            escPosEmulator.lineDrawBuffer.flush_img();
        } catch (Exception e3) {
            escPosEmulator.commandMessage = "GSv0 w:" + i4 + " h:" + i5 + " Error:" + e3.getLocalizedMessage();
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public /* bridge */ /* synthetic */ int get_length() {
        return super.get_length();
    }
}
