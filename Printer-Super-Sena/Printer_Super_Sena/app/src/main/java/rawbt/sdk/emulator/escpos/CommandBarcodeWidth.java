package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandBarcodeWidth extends Bytes3PrinterCommand {
    CommandBarcodeWidth() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg(escPosEmulator) & 255;
        if (i3 < 1 || i3 > 16) {
            escPosEmulator.commandMessage = "[*] Barcode width. Best use value from 2-6";
            i3 = 4;
        } else {
            escPosEmulator.commandMessage = "Barcode width: " + i3;
        }
        escPosEmulator.barcode.setWidth(i3);
    }
}
