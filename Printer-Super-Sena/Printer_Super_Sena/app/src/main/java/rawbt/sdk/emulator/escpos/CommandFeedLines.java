package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandFeedLines extends Bytes3PrinterCommand {
    CommandFeedLines() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = get_arg_norm(escPosEmulator);
        escPosEmulator.lineDrawBuffer.flush_img();
        LineDrawBuffer lineDrawBuffer = escPosEmulator.lineDrawBuffer;
        lineDrawBuffer.height = escPosEmulator.lineHeight * i3;
        lineDrawBuffer.flush_img();
        escPosEmulator.commandMessage = "ESC d n:" + i3 + " - move down n lines";
    }
}
