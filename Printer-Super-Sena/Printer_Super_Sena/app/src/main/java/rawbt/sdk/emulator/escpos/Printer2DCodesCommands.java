package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class Printer2DCodesCommands {
    Printer2DCodesCommands() {
    }

    static PrinterCommand getCommand(EscPosEmulator escPosEmulator) {
        int i3 = escPosEmulator.input[escPosEmulator.input_pointer + 5] & 255;
        switch (i3) {
            case 48:
                return new Printer2DPdf417Commands();
            case 49:
                return new Printer2DQrCommands();
            case 50:
                return new Printer2DMaxiCodeCommands();
            case 51:
                return new Printer2DGS1DatabarCommands();
            case 52:
                return new Printer2DSymbologyCommands();
            case 53:
                return new Printer2DAztecCommands();
            case 54:
                return new Printer2DDataMatrixCommands();
            default:
                return new BytesMultiPrinterCommand(escPosEmulator, "GS(k unknown[" + i3 + "] 2D code types");
        }
    }
}
