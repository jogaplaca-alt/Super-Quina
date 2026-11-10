package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSensors extends BytesMultiPrinterCommand {
    private int length = 3;

    CommandSensors() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        byte b3 = readByte(escPosEmulator);
        switch (b3) {
            case 51:
                this.length = 4;
                escPosEmulator.commandMessage = "[*]ESC c 3 n - Select paper sensor(s) to output paper-end signals";
                break;
            case 52:
                this.length = 4;
                escPosEmulator.commandMessage = "[*]ESC c 4 n - Select paper sensor(s) to stop printing";
                break;
            case 53:
                this.length = 4;
                escPosEmulator.commandMessage = "[*]ESC c 5 n - Enable/disable panel buttons";
                break;
            default:
                escPosEmulator.commandMessage = "[!]ESC c n - unknown arg:" + ((int) b3);
                break;
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.length;
    }
}
