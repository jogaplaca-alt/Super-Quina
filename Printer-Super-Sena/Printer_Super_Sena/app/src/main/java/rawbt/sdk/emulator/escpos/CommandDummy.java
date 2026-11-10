package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
public class CommandDummy extends BytesMultiPrinterCommand {
    private final int lenght;
    private String mes;

    CommandDummy() {
        this.mes = null;
        this.lenght = 1;
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        String str = this.mes;
        if (str != null) {
            escPosEmulator.commandMessage = str;
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.lenght;
    }

    CommandDummy(int i3, String str) {
        this.lenght = i3;
        this.mes = str;
    }
}
