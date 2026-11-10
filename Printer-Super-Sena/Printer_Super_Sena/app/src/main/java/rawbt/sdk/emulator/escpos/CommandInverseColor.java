package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandInverseColor extends BytesMultiPrinterCommand {
    CommandInverseColor() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        set_length(3);
        setParamPos(2);
        escPosEmulator.inverseColor = (readByte(escPosEmulator) & 1) == 1;
        StringBuilder sb = new StringBuilder();
        sb.append("GS B - Set inverse color ");
        sb.append(escPosEmulator.inverseColor ? "ON" : "OFF");
        escPosEmulator.commandMessage = sb.toString();
        byte[] bArr = escPosEmulator.input;
        int i3 = escPosEmulator.input_pointer;
        if (bArr[i3] == 27 && bArr[i3 + 1] == 66 && bArr[i3 + 2] == 4 && bArr[i3 + 3] == 1) {
            set_length(4);
            escPosEmulator.commandMessage = "[-] POS-58 undocumented";
        }
    }
}
