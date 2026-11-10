package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class Printer2DPdf417Commands extends BytesMultiPrinterCommand {
    Printer2DPdf417Commands() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        escPosEmulator.commandMessage = "[!]GS(k Pdf417: not emulated";
    }
}
