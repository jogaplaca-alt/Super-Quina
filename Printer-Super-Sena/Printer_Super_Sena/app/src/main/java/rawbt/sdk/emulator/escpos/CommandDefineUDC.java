package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandDefineUDC extends BytesMultiPrinterCommand {
    private int length = 1;

    CommandDefineUDC() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        setParamPos(2);
        int i3 = readByte(escPosEmulator) & 255;
        int i4 = readByte(escPosEmulator) & 255;
        this.length = 5;
        for (int i5 = readByte(escPosEmulator) & 255; i5 <= i4; i5++) {
            this.length++;
            this.length += (readByte(escPosEmulator) & 255) * i3;
        }
        escPosEmulator.commandMessage = "[-] Define UDF charset";
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.length;
    }
}
