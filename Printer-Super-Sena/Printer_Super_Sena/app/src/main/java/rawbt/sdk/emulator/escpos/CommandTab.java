package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandTab extends PrinterCommand {
    CommandTab() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3;
        int i4 = 0;
        while (true) {
            int i5 = escPosEmulator.caret_x;
            i3 = escPosEmulator.tabPos[i4];
            if (i5 <= i3 || i4 >= 33) {
                break;
            } else {
                i4++;
            }
        }
        int i6 = escPosEmulator.print_width;
        if (i3 > i6) {
            escPosEmulator.caret_x = i6 + 1;
        } else {
            escPosEmulator.caret_x = i3;
        }
        escPosEmulator.commandMessage = "TAB x:" + escPosEmulator.caret_x;
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return 1;
    }
}
