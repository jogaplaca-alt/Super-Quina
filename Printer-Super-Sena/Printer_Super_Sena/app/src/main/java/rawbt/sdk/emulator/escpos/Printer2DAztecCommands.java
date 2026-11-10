package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class Printer2DAztecCommands extends BytesMultiPrinterCommand {
    Printer2DAztecCommands() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        escPosEmulator.commandMessage = "[!]GS(k Aztec: not emulated";
    }
}
