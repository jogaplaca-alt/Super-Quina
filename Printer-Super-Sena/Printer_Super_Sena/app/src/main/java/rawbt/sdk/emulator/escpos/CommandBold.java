package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandBold extends Bytes3PrinterCommand {
    CommandBold() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.commandMessage = "BOLD ";
        try {
            escPosEmulator.bold = paramOnOff(get_arg(escPosEmulator));
            StringBuilder sb = new StringBuilder();
            sb.append("BOLD ");
            sb.append(escPosEmulator.bold ? "ON" : "OFF");
            escPosEmulator.commandMessage = sb.toString();
        } catch (Exception e3) {
            escPosEmulator.commandMessage += e3.getLocalizedMessage();
        }
    }
}
