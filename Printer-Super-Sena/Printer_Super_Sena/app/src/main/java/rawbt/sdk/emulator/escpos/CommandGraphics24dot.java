package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandGraphics24dot extends GraphicsPrinterCommand {
    private final boolean isRaster;

    CommandGraphics24dot(boolean z3) {
        this.isRaster = z3;
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(2);
        int i3 = read32(escPosEmulator);
        int i4 = (i3 / 8) * 24;
        set_length(i4 + 4);
        escPosEmulator.commandMessage = "24 dot image. w:" + i3 + " h:24";
        try {
            byte[] bytes = readBytes(escPosEmulator, i4);
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i3, 24, this.isRaster ? decodeRasterFormat(i3, 24, bytes) : decodeColumnFormat(i3, 24, bytes)));
        } catch (Exception e3) {
            escPosEmulator.commandMessage = "24 dot image. [w:" + i3 + " h:24] Error:" + e3.getLocalizedMessage();
        }
        escPosEmulator.lineDrawBuffer.flush_img();
    }
}
