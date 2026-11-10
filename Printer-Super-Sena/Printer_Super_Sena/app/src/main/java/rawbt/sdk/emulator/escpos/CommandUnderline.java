package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUnderline extends Bytes3PrinterCommand {
    CommandUnderline() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.underline = false;
        int i3 = get_arg_norm(escPosEmulator);
        if (i3 > 2) {
            escPosEmulator.commandMessage = "[!] Underline allow wrong arg: " + i3;
            return;
        }
        if (i3 == 2) {
            escPosEmulator.commandMessage = "[*] double underline not emulated";
            escPosEmulator.underline = true;
        } else if (i3 != 1) {
            escPosEmulator.commandMessage = "underline off";
        } else {
            escPosEmulator.commandMessage = "underline on";
            escPosEmulator.underline = true;
        }
    }
}
