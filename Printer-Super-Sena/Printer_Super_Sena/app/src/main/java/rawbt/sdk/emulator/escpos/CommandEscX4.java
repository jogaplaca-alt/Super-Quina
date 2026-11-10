package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandEscX4 extends GraphicsPrinterCommand {
    CommandEscX4() {
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(3);
        int i3 = readByte(escPosEmulator) & 255;
        int i4 = i3 * 8;
        int i5 = readByte(escPosEmulator) & 255;
        escPosEmulator.commandMessage = "EscX4 w:" + i4 + " h:" + i5;
        int i6 = i3 * i5;
        try {
            byte[] bytes = readBytes(escPosEmulator, i6);
            set_length(i6 + 5);
            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, i4, i5, decodeRasterFormat(i4, i5, bytes)));
        } catch (Exception e3) {
            escPosEmulator.commandMessage = "EscX4 w:" + i4 + " h:" + i5 + " Error:" + e3.getLocalizedMessage();
        }
    }
}
