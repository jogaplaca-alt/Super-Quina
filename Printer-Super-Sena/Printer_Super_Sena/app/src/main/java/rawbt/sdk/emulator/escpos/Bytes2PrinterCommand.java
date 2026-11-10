package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
abstract class Bytes2PrinterCommand extends PrinterCommand {
    Bytes2PrinterCommand() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return 2;
    }
}
