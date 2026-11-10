package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.channels.FileChannel;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.utils.GraphLibrary;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class TsplDriver extends AbstractDriverWithTransport implements IVirtualEscPos {
    private static final byte[] LN = {13};
    final PrinterEntity printerProfile;
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;

    public TsplDriver(PrinterEntity printerEntity, Context context) {
        setContext(context);
        this.printerProfile = printerEntity;
    }

    @Override // rawbt.sdk.drivers.AbstractDriverWithTransport, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void bytes(byte[] bArr) {
        try {
            EscPosEmulator escPosEmulator = new EscPosEmulator(getContext(), bArr, this.virtual_code_page, this.virtual_width);
            while (!escPosEmulator.isEnd()) {
                escPosEmulator.commandMessage = null;
                PrinterCommand command = escPosEmulator.getCommand();
                try {
                    command.apply(escPosEmulator);
                } catch (Error | Exception unused) {
                }
                escPosEmulator.input_pointer += command.get_length();
                if (escPosEmulator.output_height > 32000) {
                    break;
                }
            }
            int i3 = escPosEmulator.output_height;
            if (i3 > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(escPosEmulator.max_dots, i3, Bitmap.Config.ARGB_8888);
                FileChannel channel = escPosEmulator.randomAccessFile.getChannel();
                bitmapCreateBitmap.copyPixelsFromBuffer(channel.map(FileChannel.MapMode.READ_WRITE, 0L, bitmapCreateBitmap.getRowBytes() * bitmapCreateBitmap.getHeight()));
                channel.close();
                printImage(bitmapCreateBitmap, new AttributesImage(0));
            }
            escPosEmulator.randomAccessFile.close();
            escPosEmulator.file.delete();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        transport_write(RawbtHelper.getBytes(this.printerProfile.getBytes_finish()));
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    protected void graphics(byte[] bArr, int i3, int i4) {
        if (isError() || isCancelled() || i4 <= 0) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        int i5 = 0;
        while (true) {
            int i6 = 1;
            if (i5 >= length) {
                break;
            }
            if (bArr[i5] == 1) {
                i6 = 0;
            }
            bArr2[i5] = (byte) i6;
            i5++;
        }
        int i7 = i3 >> 3;
        int i8 = 0;
        if (i4 > 512) {
            while (i8 < i4 - 512) {
                boolean z3 = true;
                int i9 = 512;
                while (z3 && i9 > 0) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < i3; i11++) {
                        try {
                            if (bArr2[((i8 + i9) * i3) + i11] == 1) {
                                i10++;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    if (i10 == i3) {
                        z3 = false;
                    } else {
                        i9--;
                    }
                }
                if (i9 < 24) {
                    i9 = 512;
                }
                byte[] bArr3 = new byte[i9 * i7 * 8];
                for (int i12 = 0; i12 < i9; i12++) {
                    if (i3 >= 0) {
                        System.arraycopy(bArr2, (i8 + i12) * i3, bArr3, i12 * i3, i3);
                    }
                }
                sendBandle(bArr3, i3, i9);
                i8 += i9;
            }
        }
        if (i8 < i4 - 1) {
            int i13 = i4 - i8;
            byte[] bArr4 = new byte[i7 * i13 * 8];
            for (int i14 = 0; i14 < i13; i14++) {
                for (int i15 = 0; i15 < i3; i15++) {
                    int i16 = i14 * i3;
                    bArr4[i16 + i15] = bArr2[(i8 * i3) + i16 + i15];
                }
            }
            sendBandle(bArr4, i3, i13);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        transport_write(RawbtHelper.getBytes(this.printerProfile.getBytes_init()));
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = LN;
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SET RIBBON OFF".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SET TEAR OFF".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SET PEEL OFF".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SET CUTTER OFF".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SET PARTIAL_CUTTER OFF".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("DIRECTION 1,0".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("REFERENCE 0,0".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("OFFSET 0 mm".getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("SHIFT 0".getBytes());
            byteArrayOutputStream.write(bArr);
            transport_write(byteArrayOutputStream.toByteArray());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.IVirtualEscPos
    public void injectVirtual(String str, int i3) {
        this.virtual_code_page = str;
        this.virtual_width = i3;
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.receiveFromDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        int i4 = i3 * 32;
        if (i4 > 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(("SIZE " + this.printerProfile.getDots_per_line() + " dot, " + i4 + " dot").getBytes());
                byte[] bArr = LN;
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write("CLS".getBytes());
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(("FEED " + i4).getBytes());
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write("PRINT 1,1".getBytes());
                byteArrayOutputStream.write(bArr);
                transport_write(byteArrayOutputStream.toByteArray());
            } catch (Exception unused) {
            }
        }
    }

    void sendBandle(byte[] bArr, int i3, int i4) {
        int i5 = this.printerProfile.getDensity() == 203 ? 8 : 12;
        if (isError() || isCancelled() || i4 <= 0) {
            return;
        }
        try {
            byte[] bArr2 = new byte[bArr.length];
            int length = bArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                bArr2[(length - i6) - 1] = bArr[i6];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(("SIZE " + (this.printerProfile.getDots_per_line() / i5) + " mm, " + ((i4 / i5) + 1) + " mm").getBytes());
            byte[] bArr3 = LN;
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write("GAP 0,0".getBytes());
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write("CLS".getBytes());
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(("BITMAP 0,0," + (i3 / 8) + "," + i4 + ",0,").getBytes());
            byteArrayOutputStream.write(GraphLibrary.rasterFormat(bArr2, i3, i4));
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write("PRINT 1,1".getBytes());
            byteArrayOutputStream.write(bArr3);
            transport_write(byteArrayOutputStream.toByteArray());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        text_as_image(str, attributesString);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public final void text_as_image(String str, AttributesString attributesString) {
        String strTrim = str.trim();
        if (strTrim.length() < 1) {
            return;
        }
        try {
            printImage(AbstractDriver.drawText(strTrim, attributesString, getPrinterProfile()), new AttributesImage(0));
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            setErrorMessage("out of memory");
        }
    }
}
