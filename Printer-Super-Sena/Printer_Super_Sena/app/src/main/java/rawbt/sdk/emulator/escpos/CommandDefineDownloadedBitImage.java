package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class CommandDefineDownloadedBitImage extends GraphicsPrinterCommand {
    CommandDefineDownloadedBitImage() {
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(2);
        int i3 = readByte(escPosEmulator) & 255;
        int i4 = i3 * 8;
        int i5 = (readByte(escPosEmulator) & 255) * 8;
        int i6 = i3 * i5;
        set_length(i6 + 4);
        try {
            Bitmap bitmapDecodeColumnFormat = decodeColumnFormat(i4, i5, readBytes(escPosEmulator, i6));
            escPosEmulator.commandMessage = "GS * - Define downloaded bit image. Obsolete. w:" + i4 + " h:" + i5;
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i4, i5, bitmapDecodeColumnFormat));
            escPosEmulator.lineDrawBuffer.flush_img();
        } catch (Exception e3) {
            escPosEmulator.commandMessage = "GS*  Error:" + e3.getLocalizedMessage();
        }
    }
}
