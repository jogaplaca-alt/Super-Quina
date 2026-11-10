package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class BytesMultiPrinterCommand extends PrinterCommand {
    EscPosEmulator escPosEmulator;
    private boolean isStar;
    private int length;
    private final String mes;

    BytesMultiPrinterCommand() {
        this.length = -1;
        this.isStar = false;
        this.mes = null;
        this.escPosEmulator = null;
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        this.escPosEmulator = escPosEmulator;
        String str = this.mes;
        if (str != null) {
            escPosEmulator.commandMessage = str;
        }
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        int i3 = this.length;
        if (i3 > 0) {
            return i3;
        }
        if (this.escPosEmulator == null) {
            return 3;
        }
        setParamPos(this.isStar ? 4 : 3);
        return (this.isStar ? 6 : 5) + read32(this.escPosEmulator);
    }

    void set_length(int i3) {
        this.length = i3;
    }

    BytesMultiPrinterCommand(EscPosEmulator escPosEmulator, String str) {
        this.length = -1;
        this.isStar = false;
        this.mes = str;
        this.escPosEmulator = escPosEmulator;
    }

    BytesMultiPrinterCommand(EscPosEmulator escPosEmulator, String str, boolean z3) {
        this.length = -1;
        this.mes = str;
        this.escPosEmulator = escPosEmulator;
        this.isStar = z3;
    }
}
