package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class CommandStarRasterData extends GraphicsPrinterCommand {
    CommandStarRasterData() {
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(1);
        int i3 = read32(escPosEmulator);
        set_length(i3 + 3);
        escPosEmulator.commandMessage = "Raster data transmit";
        try {
            Bitmap bitmapDecodeRasterFormat = decodeRasterFormat(i3 * 8, 1, readBytes(escPosEmulator, i3));
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmapDecodeRasterFormat.getWidth(), bitmapDecodeRasterFormat.getHeight(), bitmapDecodeRasterFormat));
            escPosEmulator.lineDrawBuffer.flush_img();
        } catch (Exception e3) {
            escPosEmulator.commandMessage += " Error:" + e3.getLocalizedMessage();
        }
    }
}
