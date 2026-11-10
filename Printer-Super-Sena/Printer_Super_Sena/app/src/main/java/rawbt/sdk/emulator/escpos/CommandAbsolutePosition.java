package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandAbsolutePosition extends BytesMultiPrinterCommand {
    CommandAbsolutePosition() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        setParamPos(2);
        escPosEmulator.caret_x = read32(escPosEmulator);
        escPosEmulator.commandMessage = "ESC $ Set absolute print position :" + escPosEmulator.caret_x;
        if (escPosEmulator.caret_x > escPosEmulator.print_width) {
            escPosEmulator.caret_x = 0;
            escPosEmulator.commandMessage = "[!] position out of right! fix to 0";
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return 4;
    }
}
