package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;
import rawbt.api.attributes.AttributesQRcode;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.barcode.QrCodeDraw;

/* JADX INFO: loaded from: classes.dex */
class Printer2DQrCommands extends BytesMultiPrinterCommand {
    Printer2DQrCommands() {
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(3);
        int i3 = read32(escPosEmulator);
        int i4 = readByte(escPosEmulator) & 255;
        int i5 = readByte(escPosEmulator) & 255;
        if (i4 < 48 || i4 > 54) {
            escPosEmulator.commandMessage = "[!]GS(k Unknown symbol type";
            return;
        }
        if (i5 == 65) {
            escPosEmulator.commandMessage = "[*]GS(k QrCode:fn=165 - Not Emulated. Always model 2";
        }
        if (i5 == 67) {
            setParamPos(7);
            int i6 = readByte(escPosEmulator) & 255;
            if (i6 < 1) {
                i6 = 1;
            }
            if (i6 > 16) {
                i6 = 16;
            }
            escPosEmulator.commandMessage = "GS(k QrCode:fn=167 - Set the size of module [1-16]:" + i6;
            escPosEmulator.qrCode.setMultiply(i6);
            return;
        }
        if (i5 == 69) {
            setParamPos(7);
            switch (readByte(escPosEmulator) & 255) {
                case 48:
                    escPosEmulator.commandMessage = "GS(k QrCode:fn=169 - EccLevel.L";
                    break;
                case 49:
                    escPosEmulator.commandMessage = "GS(k QrCode:fn=169 - EccLevel.M";
                    break;
                case 50:
                    escPosEmulator.commandMessage = "GS(k QrCode:fn=169 - EccLevel.Q";
                    break;
                case 51:
                    escPosEmulator.commandMessage = "GS(k QrCode:fn=169 - EccLevel.HQ";
                    break;
                default:
                    escPosEmulator.commandMessage = "GS(k QrCode:fn=169 - wrong EccLevel";
                    break;
            }
        }
        switch (i5) {
            case 80:
                escPosEmulator.commandMessage = "GS(k QrCode:fn=180-Set data";
                try {
                    setParamPos(8);
                    String str = new String(readBytes(escPosEmulator, i3 - 3), escPosEmulator.codePageName);
                    escPosEmulator.qrCode_value = str;
                    escPosEmulator.commandMessage += ":" + str;
                } catch (Exception e3) {
                    escPosEmulator.commandMessage = "[!]" + escPosEmulator.commandMessage + ".Error: " + e3.getLocalizedMessage();
                    e3.printStackTrace();
                    return;
                }
                break;
            case 81:
                escPosEmulator.commandMessage = "GS(k QrCode:fn=181-Print ";
                Bitmap bitmapDrawQR = QrCodeDraw.drawQR(new CommandQRcode(escPosEmulator.qrCode_value, escPosEmulator.qrCode), escPosEmulator.print_width, escPosEmulator.colorPaper, escPosEmulator.colorBurn);
                if (bitmapDrawQR == null) {
                    escPosEmulator.commandMessage = "[!]" + escPosEmulator.commandMessage + " Error: Image is null";
                } else if (bitmapDrawQR.getWidth() <= escPosEmulator.print_width) {
                    escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(0, bitmapDrawQR.getWidth(), bitmapDrawQR.getHeight(), bitmapDrawQR));
                    escPosEmulator.lineDrawBuffer.flush_img();
                    escPosEmulator.qrCode = new AttributesQRcode();
                    escPosEmulator.qrCode_value = "";
                } else {
                    escPosEmulator.commandMessage = "[!]" + escPosEmulator.commandMessage + " Error: too width";
                }
                break;
            case 82:
                escPosEmulator.commandMessage = "[-]GS(k QrCode:fn=182-Transmit the size information of the symbol data";
                break;
            default:
                escPosEmulator.commandMessage = "[!]GS(k QrCode: unknown function " + i5;
                break;
        }
    }
}
