package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUTFcitizen extends Bytes3PrinterCommand {
    CommandUTFcitizen() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg(escPosEmulator) & 255;
        if (i3 != 0) {
            if (i3 != 8) {
                if (i3 != 48) {
                    if (i3 != 56) {
                        escPosEmulator.commandMessage = "[-]FS C n - not emulated";
                        return;
                    }
                }
            }
            escPosEmulator.commandMessage = "[-]FS C 8 - UTF-8";
            return;
        }
        escPosEmulator.commandMessage = "[-]FS C 0 - ASCII";
    }
}
