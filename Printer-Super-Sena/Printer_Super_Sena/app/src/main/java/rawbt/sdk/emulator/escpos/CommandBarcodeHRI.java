package rawbt.sdk.emulator.escpos;

import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
class CommandBarcodeHRI extends Bytes3PrinterCommand {
    CommandBarcodeHRI() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        String str;
        int i3 = get_arg_norm(escPosEmulator);
        if (i3 >= 4) {
            escPosEmulator.commandMessage = "[!] GS H " + i3 + " / Invalid value";
            return;
        }
        escPosEmulator.commandMessage = "GS H " + i3 + " - Select print position of HRI characters";
        if (i3 == 1) {
            str = Constant.HRI_ABOVE;
        } else if (i3 != 2) {
            str = i3 != 3 ? "none" : Constant.HRI_BOTH;
        } else {
            str = Constant.HRI_BELOW;
        }
        escPosEmulator.barcode.setHri(str);
    }
}
