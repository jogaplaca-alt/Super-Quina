package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class BixolonGarbage extends BytesMultiPrinterCommand {
    BixolonGarbage() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(2);
        int i3 = readByte(escPosEmulator) & 255;
        setParamPos(5);
        int i4 = i3 % (readByte(escPosEmulator) & 255);
        int i5 = (i4 / 5) + (i4 % 5);
        if (i5 < 10) {
            i5 = 20 - i5;
        }
        int i6 = i5 + 6;
        set_length(i6);
        escPosEmulator.commandMessage = "Garbage: " + i6 + " bytes";
    }
}
