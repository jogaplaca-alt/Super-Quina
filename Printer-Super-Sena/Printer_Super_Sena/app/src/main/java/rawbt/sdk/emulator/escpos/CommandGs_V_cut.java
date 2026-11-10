package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandGs_V_cut extends BytesMultiPrinterCommand {
    CommandGs_V_cut() {
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae  */
    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        CommandPrinterCut commandPrinterCut;
        CommandPrinterCut commandPrinterCut2;
        super.apply(escPosEmulator);
        setParamPos(2);
        byte b3 = readByte(escPosEmulator);
        if (b3 == 0) {
            set_length(3);
            commandPrinterCut = new CommandPrinterCut(3, true, 1, 0);
        } else if (b3 == 1) {
            set_length(3);
            commandPrinterCut = new CommandPrinterCut(3, false, 1, 0);
        } else if (b3 == 48) {
            set_length(3);
            commandPrinterCut = new CommandPrinterCut(3, true, 1, 0);
        } else if (b3 != 49) {
            if (b3 == 65) {
                set_length(4);
                commandPrinterCut2 = new CommandPrinterCut(4, true, 2, readByte(escPosEmulator) & 255);
            } else if (b3 == 66) {
                set_length(4);
                commandPrinterCut2 = new CommandPrinterCut(4, false, 2, readByte(escPosEmulator) & 255);
            } else if (b3 == 97) {
                set_length(4);
                commandPrinterCut = new CommandPrinterCut(4, true, 3, readByte(escPosEmulator) & 255);
            } else if (b3 == 98) {
                set_length(4);
                commandPrinterCut = new CommandPrinterCut(4, false, 3, readByte(escPosEmulator) & 255);
            } else if (b3 == 103) {
                set_length(4);
                commandPrinterCut = new CommandPrinterCut(4, true, 4, readByte(escPosEmulator) & 255);
            } else {
                if (b3 != 104) {
                    escPosEmulator.commandMessage = "[!]GS V unknown fn:" + ((int) b3);
                    set_length(2);
                    return;
                }
                set_length(4);
                commandPrinterCut = new CommandPrinterCut(4, false, 4, readByte(escPosEmulator) & 255);
            }
            commandPrinterCut = commandPrinterCut2;
        } else {
            set_length(3);
            commandPrinterCut = new CommandPrinterCut(3, false, 1, 0);
        }
        commandPrinterCut.apply(escPosEmulator);
    }
}
