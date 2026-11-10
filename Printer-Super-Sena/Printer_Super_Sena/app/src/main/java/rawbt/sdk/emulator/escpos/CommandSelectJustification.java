package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSelectJustification extends Bytes3PrinterCommand {
    CommandSelectJustification() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg_norm(escPosEmulator);
        if (i3 == 1) {
            escPosEmulator.justification = 1;
            escPosEmulator.commandMessage = "ESC a 1 - JUSTIFY CENTER";
        } else if (i3 != 2) {
            escPosEmulator.justification = 0;
            escPosEmulator.commandMessage = "ESC a 0 - JUSTIFY LEFT";
        } else {
            escPosEmulator.justification = 2;
            escPosEmulator.commandMessage = "ESC a 2 - JUSTIFY RIGHT";
        }
    }
}
