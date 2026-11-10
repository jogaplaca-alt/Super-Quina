package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandMoveDown extends Bytes3PrinterCommand {
    CommandMoveDown() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        int i3 = escPosEmulator.lineDrawBuffer.height;
        int i4 = get_arg(escPosEmulator) & 255;
        StringBuilder sb = new StringBuilder();
        sb.append("[*]ESC ");
        sb.append(escPosEmulator.input[escPosEmulator.input_pointer + 1] == 74 ? "J" : "I");
        sb.append(" n - Move down:");
        sb.append(i4);
        escPosEmulator.commandMessage = sb.toString();
        if (escPosEmulator.caret_x > 0 && i3 > 0) {
            escPosEmulator.lineDrawBuffer.flush_img();
        }
        LineDrawBuffer lineDrawBuffer = escPosEmulator.lineDrawBuffer;
        int i5 = lineDrawBuffer.last_height;
        if (i4 > i5) {
            lineDrawBuffer.height = i4 - i5;
            lineDrawBuffer.flush_img();
        }
        escPosEmulator.caret_x = 0;
    }
}
