package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSelectCharacterSize extends Bytes3PrinterCommand {
    CommandSelectCharacterSize() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        byte b3 = get_arg(escPosEmulator);
        escPosEmulator.heightMultiple = (b3 & 7) + 1;
        escPosEmulator.widthMultiple = ((b3 & 112) >> 4) + 1;
        escPosEmulator.commandMessage = "[*]GS! [w:" + escPosEmulator.widthMultiple + ",h:" + escPosEmulator.heightMultiple + "] - size multiply. Only works on EPSON";
    }
}
