package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class FixNUL extends BytesMultiPrinterCommand {
    private int length = 0;

    FixNUL() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = escPosEmulator.input_pointer;
        if (i3 > escPosEmulator.input_length - 1) {
            escPosEmulator.commandMessage = "Reached end of file";
            this.length = 1;
            return;
        }
        while (i3 < escPosEmulator.input_length && escPosEmulator.input[i3] == 0) {
            this.length++;
            i3++;
        }
        escPosEmulator.commandMessage = "Ignored " + this.length + " NUL";
        if (this.length < 1) {
            this.length = 1;
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.length;
    }
}
