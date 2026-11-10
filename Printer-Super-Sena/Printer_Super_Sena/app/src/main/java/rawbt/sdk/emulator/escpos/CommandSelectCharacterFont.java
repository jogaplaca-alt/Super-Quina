package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSelectCharacterFont extends Bytes3PrinterCommand {
    CommandSelectCharacterFont() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        byte b3 = get_arg(escPosEmulator);
        if (b3 > 1) {
            escPosEmulator.commandMessage = "[*]Font C and MSR not support";
        } else if (b3 == 1) {
            escPosEmulator.font = 1;
            escPosEmulator.commandMessage = "ESC M 1 - Font B";
        } else {
            escPosEmulator.font = 0;
            escPosEmulator.commandMessage = "ESC M 0 - Font A";
        }
    }
}
