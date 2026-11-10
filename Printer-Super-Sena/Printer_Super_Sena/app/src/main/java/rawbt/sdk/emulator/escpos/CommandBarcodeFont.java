package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandBarcodeFont extends Bytes3PrinterCommand {
    CommandBarcodeFont() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg_norm(escPosEmulator);
        if (i3 >= 2) {
            escPosEmulator.commandMessage = "[!]GS f " + i3 + " . Emulated only A & B";
            return;
        }
        escPosEmulator.commandMessage = "GS f " + i3 + " - Select HRI font";
        escPosEmulator.barcode.setFont(i3 + 1);
    }
}
