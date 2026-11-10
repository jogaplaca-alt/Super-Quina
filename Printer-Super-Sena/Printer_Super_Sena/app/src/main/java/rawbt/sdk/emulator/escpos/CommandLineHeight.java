package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandLineHeight extends Bytes3PrinterCommand {
    CommandLineHeight() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.lineHeight = get_arg(escPosEmulator) & 255;
        escPosEmulator.commandMessage = "[*]ESC 3 Set line height:" + escPosEmulator.lineHeight;
    }
}
