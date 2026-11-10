package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
abstract class Bytes3PrinterCommand extends PrinterCommand {
    Bytes3PrinterCommand() {
    }

    byte get_arg(EscPosEmulator escPosEmulator) {
        return escPosEmulator.input[escPosEmulator.input_pointer + 2];
    }

    int get_arg_norm(EscPosEmulator escPosEmulator) {
        int i3 = get_arg(escPosEmulator) & 255;
        return i3 > 48 ? i3 - 48 : i3;
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return 3;
    }
}
