package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUTFepson extends BytesMultiPrinterCommand {
    CommandUTFepson() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(5);
        if ((readByte(escPosEmulator) & 255) != 48) {
            escPosEmulator.commandMessage = "[-]FS(C unknown fn";
            return;
        }
        int i3 = readByte(escPosEmulator) & 255;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 49) {
                    if (i3 != 50) {
                        escPosEmulator.commandMessage = "FS(C fn48 - unknown arg";
                        return;
                    }
                }
            }
            escPosEmulator.commandMessage = "[!]FS(C fn48 - UTF-8";
            return;
        }
        escPosEmulator.commandMessage = "[!]FS(C fn48 - ASCII(ISCII)";
    }
}
