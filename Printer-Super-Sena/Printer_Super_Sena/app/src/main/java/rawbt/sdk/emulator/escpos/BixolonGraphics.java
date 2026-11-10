package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class BixolonGraphics extends GraphicsPrinterCommand {
    BixolonGraphics() {
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        set_length(escPosEmulator.input_length - escPosEmulator.input_pointer);
        escPosEmulator.commandMessage = "!!!! NOt SUPPORT !!!!!! I don't know how decode bixolon compression print";
    }
}
