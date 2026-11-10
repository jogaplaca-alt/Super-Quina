package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUTFstar extends BytesMultiPrinterCommand {
    CommandUTFstar() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(6);
        int i3 = readByte(escPosEmulator) & 255;
        if (i3 != 48) {
            if (i3 == 64) {
                escPosEmulator.commandMessage = "[-]EscGs)U fn64 - Set 1byte priority or 2byte priority";
                return;
            } else if (i3 == 65) {
                escPosEmulator.commandMessage = "[-]EscGs)U fn65 - Set the UTF8 CJK Unified Ideograph font";
                return;
            } else {
                escPosEmulator.commandMessage = "[-]EscGs)U  unknown fn";
                return;
            }
        }
        int i4 = readByte(escPosEmulator) & 255;
        if (i4 == 0) {
            escPosEmulator.commandMessage = "[!]EscGs)U - ascii";
        } else if (i4 != 1) {
            escPosEmulator.commandMessage = "EscGs)U fn48 - unknown arg";
        } else {
            escPosEmulator.commandMessage = "[!]EscGs)U - UTF-8";
        }
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        if (this.escPosEmulator == null) {
            return 4;
        }
        setParamPos(4);
        return read32(this.escPosEmulator) + 5;
    }
}
