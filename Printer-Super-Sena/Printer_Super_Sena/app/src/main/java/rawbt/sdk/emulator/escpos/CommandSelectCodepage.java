package rawbt.sdk.emulator.escpos;

/* JADX INFO: loaded from: classes.dex */
class CommandSelectCodepage extends BytesMultiPrinterCommand {
    private final boolean isStar;

    CommandSelectCodepage(boolean z3) {
        this.isStar = z3;
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.utfMode = false;
        setParamPos(this.isStar ? 3 : 2);
        int i3 = readByte(escPosEmulator) & 255;
        if (this.isStar) {
            if (i3 == 1) {
                escPosEmulator.codePageName = "cp437";
            } else if (i3 == 15) {
                escPosEmulator.codePageName = "cp737";
            } else if (i3 == 32) {
                escPosEmulator.codePageName = "cp1252";
            } else if (i3 == 34) {
                escPosEmulator.codePageName = "cp1251";
            } else if (i3 == 4) {
                escPosEmulator.codePageName = "cp858";
            } else if (i3 == 5) {
                escPosEmulator.codePageName = "cp852";
            } else if (i3 != 6) {
                switch (i3) {
                    case 8:
                        escPosEmulator.codePageName = "cp863";
                        break;
                    case 9:
                        escPosEmulator.codePageName = "cp865";
                        break;
                    case 10:
                        escPosEmulator.codePageName = "cp866";
                        break;
                    default:
                        escPosEmulator.commandMessage = "[!]ESC GS t n - Code page #" + i3 + " not emulated";
                        escPosEmulator.codePageName = "cp437";
                        return;
                }
            } else {
                escPosEmulator.codePageName = "cp860";
            }
        } else if (i3 == 0) {
            escPosEmulator.codePageName = "cp437";
        } else if (i3 == 9) {
            escPosEmulator.codePageName = "cp775";
        } else if (i3 == 24) {
            escPosEmulator.codePageName = "cp737";
        } else if (i3 != 25) {
            switch (i3) {
                case 2:
                    escPosEmulator.codePageName = "cp850";
                    break;
                case 3:
                    escPosEmulator.codePageName = "cp860";
                    break;
                case 4:
                    escPosEmulator.codePageName = "cp863";
                    break;
                case 5:
                    escPosEmulator.codePageName = "cp865";
                    break;
                case 6:
                    escPosEmulator.codePageName = "cp1251";
                    break;
                case 7:
                    escPosEmulator.codePageName = "cp866";
                    break;
                default:
                    switch (i3) {
                        case 16:
                            escPosEmulator.codePageName = "cp1252";
                            break;
                        case 17:
                            escPosEmulator.codePageName = "cp1253";
                            break;
                        case 18:
                            escPosEmulator.codePageName = "cp852";
                            break;
                        case 19:
                            escPosEmulator.codePageName = "cp858";
                            break;
                        default:
                            escPosEmulator.commandMessage = "[!]ESC t n - Code page #" + i3 + " not emulated";
                            escPosEmulator.codePageName = "cp437";
                            return;
                    }
                    break;
            }
        } else {
            escPosEmulator.codePageName = "cp1257";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ESC");
        sb.append(this.isStar ? " GS" : "");
        sb.append(" t ");
        sb.append(i3);
        sb.append(" - Code page : ");
        sb.append(escPosEmulator.codePageName);
        escPosEmulator.commandMessage = sb.toString();
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.isStar ? 4 : 3;
    }
}
