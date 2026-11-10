package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.nio.channels.FileChannel;
import java.util.UUID;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.BLE;
import rawbt.sdk.transport.BlePrinterInterface;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class GSv0Driver extends AbstractDriverWithTransport implements IVirtualEscPos, BlePrinterInterface {
    static final byte ESC = 27;
    static final byte xFE = -2;
    static final byte xFF = -1;
    final PrinterEntity printerProfile;
    protected int bandleHeight = 48;
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    int status = -1;

    public GSv0Driver(PrinterEntity printerEntity, Context context) {
        setContext(context);
        this.printerProfile = printerEntity;
    }

    private void sendRow(byte[] bArr, int i3, int i4) {
        if (isError()) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 8];
        bArr2[0] = 29;
        bArr2[1] = 118;
        bArr2[2] = 48;
        bArr2[3] = 0;
        bArr2[4] = (byte) (i3 % 256);
        bArr2[5] = (byte) (i3 / 256);
        bArr2[6] = (byte) (i4 % 256);
        bArr2[7] = (byte) (i4 / 256);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        transport_write(bArr2);
        waitWhileDo();
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
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("49535343-1E4D-4BD9-BA61-23C647249616"), UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    public int getStatus() {
        return this.status;
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("49535343-8841-43F4-A8D4-ECBE34729BB3"), UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    public void graphics(byte[] bArr, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 >> 3;
        int i8 = this.bandleHeight;
        int i9 = i8 >> 3;
        if (i9 < 1) {
            i9 = 1;
        }
        try {
            byte[] bArr2 = new byte[i9 * i7 * 256];
            if (i4 > i8) {
                int i10 = 0;
                i5 = 0;
                int i11 = 0;
                while (i10 < i4 - this.bandleHeight) {
                    if (isCancelled()) {
                        return;
                    }
                    int i12 = 0;
                    while (true) {
                        i6 = this.bandleHeight;
                        if (i12 >= i6) {
                            break;
                        }
                        for (int i13 = 0; i13 < i3; i13++) {
                            int i14 = i12 * i3;
                            bArr2[i14 + i13] = bArr[(i10 * i3) + i14 + i13];
                        }
                        i12++;
                    }
                    sendRow(GraphLibrary.rasterFormat(bArr2, i3, i6), i3 / 8, this.bandleHeight);
                    i5++;
                    int i15 = (i10 * 100) / i4;
                    if (i15 > i11 + 5) {
                        stepPercent(i15);
                        i11 = i15;
                    }
                    i10 += this.bandleHeight;
                }
            } else {
                i5 = 0;
            }
            if (isCancelled()) {
                return;
            }
            int i16 = this.bandleHeight;
            if (i4 - (i16 * i5) > 0) {
                int i17 = i16 * i5;
                for (int i18 = 0; i18 < i4 - (this.bandleHeight * i5); i18++) {
                    for (int i19 = 0; i19 < i3; i19++) {
                        int i20 = i18 * i3;
                        bArr2[i20 + i19] = bArr[(i17 * i3) + i20 + i19];
                    }
                }
                int i21 = i4 - i17;
                sendRow(GraphLibrary.rasterFormat(bArr2, i3, i21), i7, i21);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        if (this.transport instanceof BLE) {
            if (this.printerProfile.get_lan_delay() > 100) {
                this.printerProfile.setLan_delayMS(25);
            }
            int dots_per_line = this.printerProfile.getDots_per_line() / 8;
            this.bandleHeight = 1;
            int i3 = dots_per_line + 11;
            if (i3 < 23) {
                i3 = 23;
            }
            ((BLE) this.transport).setMtu(i3);
        }
    }

    @Override // rawbt.sdk.drivers.IVirtualEscPos
    public void injectVirtual(String str, int i3) {
        this.virtual_code_page = str;
        this.virtual_width = i3;
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        setStatus(0);
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.receiveFromDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        if (i3 > 0) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(8, i3 * 32, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(-1);
            printImage(bitmapCreateBitmap, new AttributesImage(0).setDoScale(false));
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        text_as_image(str, attributesString);
    }

    public void waitWhileDo() {
        setStatus(-1);
        if (this.printerProfile.get_abs_mode() == 1) {
            setStatus(-2);
            this.transport.write(new byte[]{29, 114, 49});
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) this.printerProfile.get_lan_delay());
        while (System.currentTimeMillis() < jCurrentTimeMillis && getStatus() < 0) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }
}
