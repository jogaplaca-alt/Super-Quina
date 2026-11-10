package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSetCharRightSpace extends Bytes3PrinterCommand {
    CommandSetCharRightSpace() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.charRightSpace = get_arg_norm(escPosEmulator);
        escPosEmulator.commandMessage = "Set the character right space:" + escPosEmulator.charRightSpace;
    }
}
