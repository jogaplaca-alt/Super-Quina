package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandLeftMargin extends BytesMultiPrinterCommand {
    CommandLeftMargin() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        set_length(4);
        setParamPos(2);
        int i3 = read32(escPosEmulator);
        if (escPosEmulator.caret_x != 0) {
            escPosEmulator.commandMessage = "[!] enabled only when processed at the beginning of the line";
            return;
        }
        int i4 = escPosEmulator.max_dots;
        if (i3 > i4) {
            i3 = i4 - 12;
        }
        escPosEmulator.margin_left = i3;
        int i5 = i4 - i3;
        escPosEmulator.print_width = i5;
        if (i5 < 12) {
            escPosEmulator.commandMessage = "[*] print width 12px";
            escPosEmulator.print_width = 12;
        } else {
            escPosEmulator.commandMessage = "GS L - left margin:" + i3;
        }
    }
}
