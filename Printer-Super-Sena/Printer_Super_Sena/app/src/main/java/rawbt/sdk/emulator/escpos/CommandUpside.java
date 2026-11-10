package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandUpside extends Bytes3PrinterCommand {
    CommandUpside() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        if (escPosEmulator.caret_x != 0) {
            escPosEmulator.commandMessage = "[!] Upside. Must be first in line";
        } else {
            escPosEmulator.upsideDown = (get_arg(escPosEmulator) & 1) == 1;
            escPosEmulator.commandMessage = "Turn upside-down print mode on/off";
        }
    }
}
