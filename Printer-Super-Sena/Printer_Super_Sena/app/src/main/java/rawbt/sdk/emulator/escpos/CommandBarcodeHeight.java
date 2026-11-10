package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandBarcodeHeight extends Bytes3PrinterCommand {
    CommandBarcodeHeight() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg(escPosEmulator) & 255;
        int i4 = i3 < 17 ? i3 * 12 : i3;
        if (i4 == 0) {
            i4 = 162;
        }
        escPosEmulator.barcode.setHeight(i4);
        escPosEmulator.commandMessage = "[*]GS h " + i3 + " - Barcode height " + i4 + ". Safe use from 24≤n≤255 (def 162)";
    }
}
