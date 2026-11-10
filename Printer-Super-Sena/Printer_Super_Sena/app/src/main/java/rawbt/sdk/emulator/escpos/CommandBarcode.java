package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;
import java.io.UnsupportedEncodingException;
import rawbt.api.Constant;
import rawbt.sdk.barcode.BarCodeDraw;

/* JADX INFO: loaded from: classes.dex */
public class CommandBarcode extends BytesMultiPrinterCommand {
    private boolean isNullTerminated = false;
    private String payload = null;
    private int payload_length = 0;

    public static Bitmap drawCode(EscPosEmulator escPosEmulator, String str) {
        if (escPosEmulator.commandMessage == null) {
            escPosEmulator.commandMessage = "";
        }
        return BarCodeDraw.drawCode(new rawbt.api.command.CommandBarcode(str, escPosEmulator.barcode), escPosEmulator.print_width, escPosEmulator.colorPaper, escPosEmulator.colorBurn);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:33:0x00af  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        String str;
        String str2;
        super.apply(escPosEmulator);
        setParamPos(2);
        int i3 = readByte(escPosEmulator) & 255;
        if (i3 < 65) {
            this.isNullTerminated = true;
        }
        if (this.isNullTerminated) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                byte b3 = readByte(escPosEmulator);
                if (b3 == 0) {
                    break;
                }
                try {
                    sb.append(new String(new byte[]{b3}, escPosEmulator.codePageName));
                } catch (UnsupportedEncodingException unused) {
                    sb.append(" ");
                }
                this.payload_length++;
            }
            this.payload = sb.toString();
        } else {
            int i4 = readByte(escPosEmulator) & 255;
            this.payload_length = i4;
            try {
                this.payload = new String(readBytes(escPosEmulator, i4), escPosEmulator.codePageName);
            } catch (Exception e3) {
                escPosEmulator.commandMessage = "Code val. Error: " + e3.getLocalizedMessage();
            }
        }
        switch (i3) {
            case 0:
                str = "UPC-A";
                str2 = Constant.BARCODE_UPC_A;
                break;
            case 1:
                str = "UPC-E";
                str2 = Constant.BARCODE_UPC_E;
                break;
            case 2:
                str = "EAN13";
                str2 = Constant.BARCODE_EAN13;
                break;
            case 3:
                str = "EAN8";
                str2 = Constant.BARCODE_EAN8;
                break;
            case 4:
                str = "CODE39";
                str2 = Constant.BARCODE_CODE39;
                break;
            case 5:
                str = "ITF";
                str2 = Constant.BARCODE_ITF;
                break;
            case 6:
                str = "CODABAR";
                str2 = Constant.BARCODE_CODABAR;
                break;
            default:
                switch (i3) {
                    case 65:
                        str = "UPC-A";
                        str2 = Constant.BARCODE_UPC_A;
                        break;
                    case 66:
                        str = "UPC-E";
                        str2 = Constant.BARCODE_UPC_E;
                        break;
                    case 67:
                        str = "EAN13";
                        str2 = Constant.BARCODE_EAN13;
                        break;
                    case 68:
                        str = "EAN8";
                        str2 = Constant.BARCODE_EAN8;
                        break;
                    case 69:
                        str = "CODE39";
                        str2 = Constant.BARCODE_CODE39;
                        break;
                    case 70:
                        str = "ITF";
                        str2 = Constant.BARCODE_ITF;
                        break;
                    case 71:
                        str = "CODABAR";
                        str2 = Constant.BARCODE_CODABAR;
                        break;
                    case 72:
                        str = "CODE93";
                        str2 = Constant.BARCODE_CODE93;
                        break;
                    case 73:
                        str = "CODE128";
                        str2 = Constant.BARCODE_CODE128;
                        break;
                    case 74:
                        str = "GS1-128";
                        str2 = Constant.BARCODE_GS1_128;
                        break;
                    case 75:
                        str = "GS1 DataBar Omnidirectional";
                        str2 = Constant.BARCODE_GS1_DATABAR_OMNIDIRECTIONAL;
                        break;
                    case 76:
                        str = "GS1 DataBar Truncated";
                        str2 = Constant.BARCODE_GS1_DATABAR_TRUNCATED;
                        break;
                    case 77:
                        str = "GS1 DataBar Limited";
                        str2 = Constant.BARCODE_GS1_DATABAR_LIMITED;
                        break;
                    case 78:
                        str = "GS1 DataBar Expanded";
                        str2 = Constant.BARCODE_GS1_DATABAR_EXPANDED;
                        break;
                    default:
                        str2 = null;
                        str = "unknown";
                        break;
                }
                break;
        }
        if (str2 == null) {
            escPosEmulator.commandMessage = "[!]BarCode unknown mode";
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BarCode");
        sb2.append(this.isNullTerminated ? "N" : "");
        sb2.append(" ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(this.payload);
        escPosEmulator.commandMessage = sb2.toString();
        escPosEmulator.barcode.setType(str2);
        Bitmap bitmapDrawCode = drawCode(escPosEmulator, this.payload);
        if (bitmapDrawCode == null) {
            return;
        }
        escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(0, bitmapDrawCode.getWidth(), bitmapDrawCode.getHeight(), bitmapDrawCode));
        escPosEmulator.lineDrawBuffer.flush_img();
    }

    @Override // rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public int get_length() {
        return this.payload_length + 4;
    }
}
