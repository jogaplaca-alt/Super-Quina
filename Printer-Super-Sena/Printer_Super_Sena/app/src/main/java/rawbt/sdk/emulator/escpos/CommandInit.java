package rawbt.sdk.emulator.escpos;

import rawbt.api.attributes.AttributesBarcode;
import rawbt.api.attributes.AttributesQRcode;

/* JADX INFO: loaded from: classes.dex */
class CommandInit extends Bytes2PrinterCommand {
    CommandInit() {
    }

    @Override // rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        escPosEmulator.commandMessage = "ESC @ - Init printer";
        escPosEmulator.bold = false;
        escPosEmulator.widthMultiple = 1;
        escPosEmulator.heightMultiple = 1;
        escPosEmulator.justification = 0;
        escPosEmulator.underline = false;
        escPosEmulator.invert = false;
        escPosEmulator.font = 0;
        escPosEmulator.upsideDown = false;
        escPosEmulator.lineDrawBuffer.clear();
        escPosEmulator.caret_x = 0;
        escPosEmulator.lineHeight = 32;
        escPosEmulator.charRightSpace = 0;
        escPosEmulator.barcode = new AttributesBarcode();
        escPosEmulator.qrCode = new AttributesQRcode();
        escPosEmulator.qrCode_value = "";
        escPosEmulator.tabPos = new int[]{96, 192, 288, 384, 480, 576, 672, 768, 864, 960, 1056, 1152, 1248, 1344, 1440, 1536, 1632, 1728, 1824, 1920, 2016, 2112, 2208, 2304, 2400, 2496, 2592, 2688, 2784, 2880, 2976, 3072, 0};
    }
}
