package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandEscX2 extends BytesMultiPrinterCommand {
    CommandEscX2() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.commandMessage = "EscX2 use this command instead of EscX4 with LF";
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return 4;
    }
}
