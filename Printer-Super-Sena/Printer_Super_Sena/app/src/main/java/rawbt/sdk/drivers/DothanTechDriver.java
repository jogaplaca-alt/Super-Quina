package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.UUID;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.BLE;
import rawbt.sdk.transport.BlePrinterInterface;
import rawbt.sdk.utils.BytesBuffer;
import rawbt.sdk.utils.GraphLibrary;

/* JADX INFO: loaded from: classes.dex */
public class DothanTechDriver extends AbstractDriverWithTransport implements IVirtualEscPos, BlePrinterInterface {
    byte[] imageByteArray;
    final PrinterEntity printerProfile;
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;

    public DothanTechDriver(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        setContext(context);
    }

    private void encodeLine(int i3) {
        int i4;
        BytesBuffer bytesBuffer = new BytesBuffer();
        int i5 = 0;
        while (true) {
            i4 = i3 - 1;
            if (i5 >= i4 || this.imageByteArray[i5] != 0) {
                break;
            } else {
                i5++;
            }
        }
        while (i4 > 1 && this.imageByteArray[i4] == 0) {
            i4--;
        }
        if (i5 > i4) {
            this.transport.write(new byte[]{31, 42, 1, 0, 0});
            return;
        }
        if (i5 >= 1528 || i4 - i5 >= 1512) {
            bytesBuffer.add(new byte[]{31, 42, (byte) (i3 % 256), (byte) (i3 / 256)});
            bytesBuffer.add(GraphLibrary.rasterFormat(this.imageByteArray, i3, 1));
            this.transport.write(bytesBuffer.getBuffer());
            return;
        }
        int i6 = i5 / 8;
        int i7 = ((i4 + 7) / 8) - i6;
        bytesBuffer.add(new byte[]{31, 43, (byte) i6, (byte) i7});
        int i8 = i7 * 8;
        int i9 = i6 * 8;
        bytesBuffer.add(GraphLibrary.rasterFormat(Arrays.copyOfRange(this.imageByteArray, i9, i8 + i9), i8, 1));
        this.transport.write(bytesBuffer.getBuffer());
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

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("49535343-8841-43F4-A8D4-ECBE34729BB3"), UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    public void graphics(byte[] bArr, int i3, int i4) {
        this.imageByteArray = Arrays.copyOf(bArr, i3);
        int i5 = i3;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4 && !isError() && !isCancelled()) {
            int i10 = i5 + i3;
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i10);
            if (!Arrays.equals(this.imageByteArray, bArrCopyOfRange) || i7 > 191) {
                encodeLine(i3);
                if (i7 > 1) {
                    this.transport.write(new byte[]{31, 46, (byte) (i7 - 1)});
                }
                this.imageByteArray = Arrays.copyOf(bArrCopyOfRange, i3);
                int i11 = (i6 * 100) / i4;
                if (i11 > i8 + 5) {
                    stepPercent(i11);
                    i8 = i11;
                }
                if (i6 > i9 + 8) {
                    waitWhileDo();
                    i9 = i6;
                }
                i7 = 0;
            } else {
                i7++;
                i10 = i10;
            }
            i6++;
            i5 = i10;
        }
        encodeLine(i3);
        if (i7 > 1) {
            this.transport.write(new byte[]{31, 46, (byte) (i7 - 1)});
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        if (this.transport instanceof BLE) {
            if (this.printerProfile.get_lan_delay() > 99) {
                this.printerProfile.setLan_delayMS(10);
            }
            int dots_per_line = (this.printerProfile.getDots_per_line() / 8) + 4;
            if (dots_per_line < 23) {
                dots_per_line = 23;
            }
            ((BLE) this.transport).setMtu(dots_per_line);
        }
        this.transport.write(new byte[]{27, 64});
        this.transport.write(new byte[]{31, 39, 1, (byte) ((this.printerProfile.getDots_per_line() + 7) / 8), -120});
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
        while (i4 > 0) {
            int iMin = Math.min(i4, 255);
            transport_write(new byte[]{27, 74, (byte) iMin});
            i4 -= iMin;
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

    public void waitWhileDo() {
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) this.printerProfile.get_lan_delay());
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }
}
