package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class Printer2DSymbologyCommands extends BytesMultiPrinterCommand {
    Printer2DSymbologyCommands() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        escPosEmulator.commandMessage = "[!]GS(k Symbology: not emulated";
    }
}
