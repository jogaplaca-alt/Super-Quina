package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class CommandSetGraphicsLongData extends GraphicsPrinterCommand {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11196m;

    CommandSetGraphicsLongData() {
    }

    private void fn112() {
        int i3 = readByte(this.escPosEmulator) & 255;
        if (this.f11196m != 48 || i3 != 48) {
            this.escPosEmulator.commandMessage = "[!] Multiple tone not supported";
        }
        int i4 = readByte(this.escPosEmulator) & 3;
        int i5 = readByte(this.escPosEmulator) & 3;
        int i6 = readByte(this.escPosEmulator) & 255;
        int i7 = read32(this.escPosEmulator);
        int i8 = i7 + 7;
        int i9 = i8 / 8;
        int i10 = read32(this.escPosEmulator);
        this.escPosEmulator.commandMessage = "GS8L fn112 w:" + i7 + " h:" + i10 + " color:" + (i6 - 48);
        try {
            this.escPosEmulator.graphics_image_buffer = Bitmap.createScaledBitmap(decodeRasterFormat((i8 / 8) * 8, i10, readBytes(this.escPosEmulator, i9 * i10)), i4 * i7, i5 * i10, false);
        } catch (Exception e3) {
            this.escPosEmulator.commandMessage = "GS8L fn112 w:" + i7 + " h:" + i10 + " Error:" + e3.getLocalizedMessage();
        }
    }

    private void fn50() {
        EscPosEmulator escPosEmulator = this.escPosEmulator;
        Bitmap bitmap = escPosEmulator.graphics_image_buffer;
        if (bitmap != null) {
            this.escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmap.getWidth(), this.escPosEmulator.graphics_image_buffer.getHeight(), this.escPosEmulator.graphics_image_buffer));
            this.escPosEmulator.lineDrawBuffer.flush_img();
        } else {
            escPosEmulator.commandMessage = "[!]GS8L fn50 - no data";
        }
        this.escPosEmulator.caret_x = 0;
    }

    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        setParamPos(3);
        set_length(read32(escPosEmulator) + (read32(escPosEmulator) * 65536) + 7);
        this.f11196m = readByte(escPosEmulator) & 255;
        int i3 = readByte(escPosEmulator) & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 112) {
                                fn112();
                                return;
                            }
                            if (i3 == 113) {
                                escPosEmulator.commandMessage = "[-]GS8L fn113 - Store the graphics data in the print buffer (column format)";
                                return;
                            }
                            switch (i3) {
                                case 48:
                                    break;
                                case 49:
                                    break;
                                case 50:
                                    break;
                                case 51:
                                    break;
                                case 52:
                                    break;
                                default:
                                    switch (i3) {
                                        case 64:
                                            escPosEmulator.commandMessage = "[-]GS8L fn64 - Transmit the key code list for defined NV graphics";
                                            break;
                                        case 65:
                                            escPosEmulator.commandMessage = "[-]GS8L fn65 - Delete all NV graphics data";
                                            break;
                                        case 66:
                                            escPosEmulator.commandMessage = "[-]GS8L fn66 - Delete the specified NV graphics data.";
                                            break;
                                        case 67:
                                            escPosEmulator.commandMessage = "[-]GS8L fn67 - Define the NV graphics data (raster format)";
                                            break;
                                        case 68:
                                            escPosEmulator.commandMessage = "[-]GS8L fn68 - Define the NV graphics data (column format)";
                                            break;
                                        case 69:
                                            escPosEmulator.commandMessage = "[-]GS8L fn69 - Print the specified NV graphics data";
                                            break;
                                        default:
                                            switch (i3) {
                                                case 80:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn80 - Transmit the key code list for defined download graphics";
                                                    break;
                                                case 81:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn81 - Delete all download graphics data";
                                                    break;
                                                case 82:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn82 - Delete the specified download graphics data";
                                                    break;
                                                case 83:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn83 - Define the download graphics data (raster format)";
                                                    break;
                                                case 84:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn84 - Define the download graphics data (column format)";
                                                    break;
                                                case 85:
                                                    escPosEmulator.commandMessage = "[-]GS8L fn85 - Print the specified download graphics data";
                                                    break;
                                                default:
                                                    escPosEmulator.commandMessage = "GS8L unknown fn:" + i3;
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                        escPosEmulator.commandMessage = "[-]GS8L fn52 - Transmit the remaining capacity of the download graphics memory";
                        return;
                    }
                    escPosEmulator.commandMessage = "[-]GS8L fn51 - Transmit the remaining capacity of the NV graphics memory";
                    return;
                }
                escPosEmulator.commandMessage = "GS8L fn50 - Print buffer";
                fn50();
                return;
            }
            escPosEmulator.commandMessage = "[-]GS8L fn49 - Set the reference standard dot density for graphics.";
            return;
        }
        escPosEmulator.commandMessage = "[-]GS8L fn48 - Transmit the NV graphics memory capacity.";
    }
}
