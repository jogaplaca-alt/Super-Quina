package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSelectPrintMode extends Bytes3PrinterCommand {
    CommandSelectPrintMode() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        byte b3 = get_arg(escPosEmulator);
        escPosEmulator.commandMessage = "ESC ! [";
        escPosEmulator.font = 0;
        if ((b3 & 1) == 1) {
            escPosEmulator.font = 1;
            escPosEmulator.commandMessage += "FontB ";
        }
        boolean z3 = (b3 & 8) == 8;
        escPosEmulator.bold = z3;
        if (z3) {
            escPosEmulator.commandMessage += "B ";
        }
        if ((b3 & 16) == 16) {
            escPosEmulator.heightMultiple = 2;
            escPosEmulator.commandMessage += "H2 ";
        } else {
            escPosEmulator.heightMultiple = 1;
        }
        if ((b3 & 32) == 32) {
            escPosEmulator.widthMultiple = 2;
            escPosEmulator.commandMessage += "W2 ";
        } else {
            escPosEmulator.widthMultiple = 1;
        }
        boolean z4 = (b3 & 128) == 128;
        escPosEmulator.underline = z4;
        if (z4) {
            escPosEmulator.commandMessage += "U";
        }
        escPosEmulator.commandMessage += "]";
    }
}
