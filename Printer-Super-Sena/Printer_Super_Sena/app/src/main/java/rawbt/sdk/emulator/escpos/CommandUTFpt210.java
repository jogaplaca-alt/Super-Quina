package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUTFpt210 extends Bytes3PrinterCommand {
    CommandUTFpt210() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg(escPosEmulator) & 255;
        escPosEmulator.utfMode = false;
        escPosEmulator.commandMessage = "[!]ESC 9 n - Select Chinese code format";
        if (i3 == 0) {
            escPosEmulator.commandMessage = "[!]ESC 9 0 - GBK";
        } else {
            if (i3 != 1) {
                return;
            }
            escPosEmulator.commandMessage = "[!]ESC 9 1 - UTF-8";
        }
    }
}
