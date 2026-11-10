package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandEscGsS extends GraphicsPrinterCommand {
    CommandEscGsS() {
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        if (escPosEmulator.caret_x > 0) {
            escPosEmulator.lineDrawBuffer.flush_img();
        }
        setParamPos(3);
        int byteNormParam = readByteNormParam(escPosEmulator);
        int i3 = read32(escPosEmulator);
        int i4 = i3 * 8;
        int i5 = read32(escPosEmulator);
        int i6 = readByte(escPosEmulator) & 255;
        escPosEmulator.commandMessage = "ESC GS S w:" + i4 + " h:" + i5;
        int i7 = i3 * i5;
        set_length(i7 + 9);
        if (i6 != 0 || byteNormParam != 1) {
            escPosEmulator.commandMessage = "ESC GS S - Color print not emulated ";
            return;
        }
        try {
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i4, i5, decodeRasterFormat(i4, i5, readBytes(escPosEmulator, i7))));
        } catch (Exception e3) {
            escPosEmulator.commandMessage = "ESC GS S w:" + i4 + " h:" + i5 + " Error:" + e3.getLocalizedMessage();
        }
        escPosEmulator.lineDrawBuffer.flush_img();
    }
}
