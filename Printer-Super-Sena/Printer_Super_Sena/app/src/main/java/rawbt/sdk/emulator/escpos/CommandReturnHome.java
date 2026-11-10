package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandReturnHome extends Bytes2PrinterCommand {
    CommandReturnHome() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.caret_x = 0;
        escPosEmulator.commandMessage = "ESC 0x3C - Return home";
    }
}
