package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class CommandBitImageMode extends GraphicsPrinterCommand {
    CommandBitImageMode() {
    }

    /* JADX WARN: Code duplicated, block: B:129:0x02c0 A[PHI: r2
      0x02c0: PHI (r2v32 int) = (r2v26 int), (r2v26 int), (r2v37 int) binds: [B:118:0x0295, B:121:0x029b, B:128:0x02bf] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // rawbt.sdk.emulator.escpos.GraphicsPrinterCommand, rawbt.sdk.emulator.escpos.BytesMultiPrinterCommand, rawbt.sdk.emulator.escpos.PrinterCommand
    public void apply(EscPosEmulator escPosEmulator) {
        super.apply(escPosEmulator);
        if (escPosEmulator.caret_x > 0) {
            escPosEmulator.lineDrawBuffer.flush_img();
        }
        byte[] bArr = escPosEmulator.input;
        int i3 = escPosEmulator.input_pointer;
        int i4 = 4;
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 82) {
            escPosEmulator.commandMessage = "[-]ESC*rR - Initialize raster mode";
            set_length(4);
            return;
        }
        int i5 = 1;
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 65) {
            escPosEmulator.commandMessage = "ESC*rA - Enter raster mode";
            escPosEmulator.isStarRasterMode = true;
            set_length(4);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 97) {
            escPosEmulator.commandMessage = "[*]ESC*ra - Start block";
            escPosEmulator.isStarRasterMode = true;
            set_length(4);
            return;
        }
        int i6 = 0;
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 66) {
            escPosEmulator.commandMessage = "ESC*rB - Quit raster mode";
            escPosEmulator.isStarRasterMode = false;
            set_length(4);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 98) {
            escPosEmulator.commandMessage = "[*]ESC*rb - End block";
            escPosEmulator.isStarRasterMode = false;
            set_length(4);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 67) {
            escPosEmulator.commandMessage = "[-]ESC*rC - Clear raster date";
            set_length(4);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 68) {
            escPosEmulator.commandMessage = "[-]ESC*rD - Drive drawer: " + ((int) escPosEmulator.input[escPosEmulator.input_pointer + 4]);
            set_length(6);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 69) {
            escPosEmulator.commandMessage = "[-]ESC*rE - Set raster EOT mode:" + ((int) escPosEmulator.input[escPosEmulator.input_pointer + 4]);
            set_length(6);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 70) {
            escPosEmulator.commandMessage = "[-]ESC*rF - Set raster FF mode:" + ((int) escPosEmulator.input[escPosEmulator.input_pointer + 4]);
            set_length(6);
            return;
        }
        if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 75) {
            escPosEmulator.commandMessage = "[-]ESC*rK - Set raster print color:" + ((int) escPosEmulator.input[escPosEmulator.input_pointer + 4]);
            set_length(6);
            return;
        }
        int i7 = 48;
        if (bArr[i3 + 2] != 114 || bArr[i3 + 3] != 80) {
            if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 89) {
                while (true) {
                    byte b3 = escPosEmulator.input[escPosEmulator.input_pointer + i4];
                    if (b3 == 0) {
                        break;
                    }
                    i6 *= 10;
                    if (b3 >= 48 && b3 <= 57) {
                        i6 += b3 - 48;
                    }
                    i4++;
                }
                escPosEmulator.commandMessage = "ESC*rY - Moving position in the vertical direction :" + i6;
                set_length(i4 + 1);
                if (i6 > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, i6, Bitmap.Config.ARGB_8888);
                    escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), bitmapCreateBitmap));
                    escPosEmulator.lineDrawBuffer.flush_img();
                    return;
                }
                return;
            }
            if (bArr[i3 + 2] == 114 && bArr[i3 + 3] == 116) {
                while (true) {
                    byte b4 = escPosEmulator.input[escPosEmulator.input_pointer + i4];
                    if (b4 == 0) {
                        break;
                    }
                    i6 *= 10;
                    if (b4 >= 48 && b4 <= 57) {
                        i6 += (b4 & 255) - 48;
                    }
                    i4++;
                }
                escPosEmulator.commandMessage = "[*]ESC*rt - Set top margin of raster :" + i6;
                set_length(i4 + 1);
                if (i6 > 0) {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(1, i6, Bitmap.Config.ARGB_8888);
                    escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight(), bitmapCreateBitmap2));
                    escPosEmulator.lineDrawBuffer.flush_img();
                    return;
                }
                return;
            }
            int i8 = 2;
            if (bArr[i3 + 2] == 114) {
                escPosEmulator.commandMessage = "[-]ESC*r " + ((int) escPosEmulator.input[escPosEmulator.input_pointer + 3]) + " - Unknown star raster command";
                set_length(4);
                return;
            }
            setParamPos(2);
            int i9 = readByte(escPosEmulator) & 255;
            int i10 = read32(escPosEmulator);
            if (i9 == 0) {
                i5 = 3;
                i7 = 8;
            } else {
                if (i9 == 1) {
                    i8 = 1;
                } else if (i9 == 5) {
                    i8 = 3;
                } else if (i9 == 39) {
                    i7 = 24;
                } else {
                    if (i9 == 97) {
                        escPosEmulator.commandMessage = "ESC*a - raster graphics.h:" + i10;
                        int i11 = escPosEmulator.print_width;
                        int i12 = i11 + 7;
                        try {
                            byte[] bytes = readBytes(escPosEmulator, (i12 / 8) * i10);
                            set_length(((i12 / 8) * i10) + 5);
                            Bitmap bitmapDecodeRasterFormat = decodeRasterFormat(i11, i10, bytes);
                            escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmapDecodeRasterFormat.getWidth(), bitmapDecodeRasterFormat.getHeight(), bitmapDecodeRasterFormat));
                            escPosEmulator.lineDrawBuffer.flush_img();
                            return;
                        } catch (Exception e3) {
                            escPosEmulator.commandMessage = "[!]ESC* Error:" + e3.getLocalizedMessage();
                            return;
                        }
                    }
                    if (i9 == 32) {
                        i7 = 24;
                    } else if (i9 != 33) {
                        switch (i9) {
                            case 71:
                                break;
                            case 72:
                            case 73:
                                i8 = 1;
                                break;
                            default:
                                escPosEmulator.commandMessage = "[!]ESC * " + i9 + " - wrong arg";
                                return;
                        }
                    } else {
                        i8 = 1;
                        i7 = 24;
                    }
                }
                i5 = 3;
                i7 = 8;
            }
            escPosEmulator.commandMessage = "ESC* w:" + i10 + " h:" + i7;
            try {
                byte[] bytes2 = readBytes(escPosEmulator, (i7 / 8) * i10);
                set_length(((i7 / 8) * i10) + 5);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(decodeColumnFormat(i10, i7, bytes2), i10 * i8, i7 * i5, false);
                escPosEmulator.lineDrawBuffer.add(new LineDrawBufferItem(escPosEmulator.caret_x, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), bitmapCreateScaledBitmap));
                return;
            } catch (Exception e4) {
                escPosEmulator.commandMessage = "[!]ESC* Error:" + e4.getLocalizedMessage();
                return;
            }
        }
        escPosEmulator.commandMessage = "[-]ESC*rP - Set raster page length";
        while (true) {
            byte b5 = escPosEmulator.input[escPosEmulator.input_pointer + i4];
            if (b5 == 0) {
                set_length(i4 + 1);
                escPosEmulator.commandMessage = "[-]ESC*rP - Set raster page length: " + i6;
                return;
            }
            i6 *= 10;
            if (b5 >= 48 && b5 <= 57) {
                i6 += (b5 & 255) - 48;
            }
            i4++;
        }
    }
}
