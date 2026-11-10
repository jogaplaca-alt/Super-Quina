package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandTabStop extends BytesMultiPrinterCommand {
    private int length = 0;

    CommandTabStop() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(2);
        int i3 = 0;
        boolean z3 = false;
        int i4 = 0;
        while (i3 < 32 && !z3) {
            int i5 = readByte(escPosEmulator) & 255;
            if (i5 == 0) {
                z3 = true;
            } else {
                if (i5 <= i4) {
                    break;
                }
                escPosEmulator.tabPos[i3] = (escPosEmulator.charRightSpace + (escPosEmulator.font == 0 ? 12 : 9)) * i5;
                i4 = i5;
            }
            i3++;
        }
        escPosEmulator.tabPos[i3 + 1] = 0;
        this.length = i3;
        escPosEmulator.commandMessage = "ESC D ... NUL - Set TAB pos";
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.length + 2;
    }
}
