package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.UUID;
import rawbt.api.RawbtResponse;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.BLE;
import rawbt.sdk.transport.BlePrinterInterface;

/* JADX INFO: loaded from: classes.dex */
public class CatPrinterDriver extends AbstractDriverWithTransport implements BlePrinterInterface, IVirtualEscPos {
    byte[] imageByteArray;
    final PrinterEntity printerProfile;
    private static final byte PRT_PRINT_WIDTH_IN_BYTES = -95;
    public static final byte[] startLattice = {81, 120, -90, 0, 11, 0, -86, 85, 23, 56, 68, 95, 95, 95, 68, 56, 44, PRT_PRINT_WIDTH_IN_BYTES, -1};
    public static final byte[] finishLattice = {81, 120, -90, 0, 11, 0, -86, 85, 23, 0, 0, 0, 0, 0, 0, 0, 23, 17, -1};
    private static final byte PRT_ENERGY = -81;
    private static final byte PRT_PAPER_FEED_SPEED = -67;
    private static final byte PRT_DRAFT = -66;
    private static final byte PRT_PRINT_DATA = -94;
    private static final byte PRT_PRINT_DATA_COMPRESS = -65;
    private static final byte PRT_GET_STATUS = -93;
    private static final byte PRT_SET_HEAT_DENSITY = -92;
    private static final byte[] CHECKSUM_TABLE = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, -32, -25, -18, -23, -4, -5, -14, -11, -40, -33, -42, -47, -60, -61, -54, -51, -112, -105, -98, -103, -116, -117, -126, -123, -88, PRT_ENERGY, -90, PRT_PRINT_WIDTH_IN_BYTES, -76, -77, -70, PRT_PAPER_FEED_SPEED, -57, -64, -55, -50, -37, -36, -43, -46, -1, -8, -15, -10, -29, -28, -19, -22, -73, -80, -71, PRT_DRAFT, -85, -84, -91, PRT_PRINT_DATA, -113, -120, -127, -122, -109, -108, -99, -102, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, -119, -114, -121, -128, -107, -110, -101, -100, -79, -74, PRT_PRINT_DATA_COMPRESS, -72, -83, -86, PRT_GET_STATUS, PRT_SET_HEAT_DENSITY, -7, -2, -9, -16, -27, -30, -21, -20, -63, -58, -49, -56, -35, -38, -45, -44, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, -82, -87, -96, -89, -78, -75, -68, -69, -106, -111, -104, -97, -118, -115, -124, -125, -34, -39, -48, -41, -62, -59, -52, -53, -26, -31, -24, -17, -6, -3, -12, -13};

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final int[] f11184p0 = {0, 128};

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int[] f11185p1 = {0, 64};

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private static final int[] f11186p2 = {0, 32};
    private static final int[] p3 = {0, 16};
    private static final int[] p4 = {0, 8};
    private static final int[] p5 = {0, 4};
    private static final int[] p6 = {0, 2};
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private boolean isShowProgress = true;
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    volatile String status = "";
    boolean xOnxOff = true;

    public CatPrinterDriver(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        setContext(context);
    }

    private static String bytesToHex(byte[] bArr, int i3) {
        char[] cArr = new char[(i3 * 3) - 1];
        Arrays.fill(cArr, ' ');
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = i4 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i5] = cArr2[(b3 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    private void checkDeviceStatus() {
        setStatus("unknown");
        Log.d("CAT", "packet PRT_GET_STATUS");
        packPerBytes(new byte[]{1}, PRT_GET_STATUS);
        if (isError()) {
            return;
        }
        for (int i3 = 0; "unknown".equals(getStatus()) && i3 < 5000; i3++) {
            SystemClock.sleep(2L);
        }
        if ("unknown".equals(getStatus()) && this.printerProfile.get_abs_mode() == 1) {
            setErrorMessage("device not response");
        }
    }

    public static byte crcPacket(byte[] bArr) {
        byte b3 = 0;
        for (byte b4 : bArr) {
            b3 = CHECKSUM_TABLE[(b3 ^ b4) & 255];
        }
        return b3;
    }

    private void lineFeed(int i3) {
        this.isShowProgress = false;
        if (i3 > 0) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.printerProfile.getDots_per_line(), i3, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(-1);
            printImage(bitmapCreateBitmap, new AttributesImage(0).setDoScale(false));
        }
        this.isShowProgress = true;
    }

    private void packPerBytes(byte[] bArr, byte b3) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length + 8];
            bArr2[0] = 81;
            bArr2[1] = 120;
            bArr2[2] = b3;
            bArr2[3] = 0;
            bArr2[4] = (byte) (length & 255);
            bArr2[5] = (byte) ((length >>> 8) & 255);
            int i3 = 6;
            for (byte b4 : bArr) {
                bArr2[i3] = b4;
                i3++;
            }
            bArr2[i3] = crcPacket(bArr);
            bArr2[i3 + 1] = -1;
            transport_write(bArr2);
        } catch (Exception e3) {
            e3.printStackTrace();
            transportError(e3.getLocalizedMessage());
        }
    }

    private void waitBeforeDo() {
        long jUptimeMillis = SystemClock.uptimeMillis() + 15000;
        while ("BUSY".equals(getStatus()) && SystemClock.uptimeMillis() < jUptimeMillis) {
            SystemClock.sleep(5L);
            checkDeviceStatus();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() + 15000;
        while ("to hot".equals(getStatus()) && SystemClock.uptimeMillis() < jUptimeMillis2) {
            SystemClock.sleep(10L);
            checkDeviceStatus();
        }
        for (int i3 = 0; !this.xOnxOff && i3 < 200; i3++) {
            SystemClock.sleep(10L);
        }
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
        checkDeviceStatus();
        long jUptimeMillis = SystemClock.uptimeMillis() + (((long) this.printerProfile.getDots_per_line()) * 14);
        while ("BUSY".equals(getStatus()) && SystemClock.uptimeMillis() < jUptimeMillis) {
            SystemClock.sleep(10L);
            checkDeviceStatus();
        }
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("0000AE02-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000FF01-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000AB02-0000-1000-8000-00805F9B34FB")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    public byte[] getRunLength() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b3 = this.imageByteArray[0];
        int i3 = 1;
        int i4 = 1;
        while (true) {
            byte[] bArr = this.imageByteArray;
            if (i3 >= bArr.length) {
                break;
            }
            byte b4 = bArr[i3];
            if (b3 == b4) {
                i4++;
            } else {
                while (i4 > 127) {
                    byteArrayOutputStream.write((b3 << 7) | 127);
                    i4 -= 127;
                }
                if (i4 > 0) {
                    byteArrayOutputStream.write((b3 << 7) | ((byte) i4));
                }
                b3 = b4;
                i4 = 1;
            }
            i3++;
        }
        while (i4 > 127) {
            byteArrayOutputStream.write((b3 << 7) | 127);
            i4 -= 127;
        }
        if (i4 > 0) {
            byteArrayOutputStream.write((b3 << 7) | ((byte) i4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public synchronized String getStatus() {
        return this.status;
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("0000AE01-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000FF02-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000AB01-0000-1000-8000-00805F9B34FB")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    protected void graphics(byte[] bArr, int i3, int i4) {
        this.imageByteArray = new byte[i3];
        int i5 = i3 / 8;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            try {
                if (!isError() && !isCancelled()) {
                    if (i8 % 32 == 0) {
                        int i9 = (i8 * 100) / i4;
                        if (this.isShowProgress && i9 > i6 + 2) {
                            stepPercent(i9);
                            i6 = i9;
                        }
                        if (this.printerProfile.get_abs_mode() == 1) {
                            checkDeviceStatus();
                            waitBeforeDo();
                        } else {
                            Thread.sleep(this.printerProfile.get_lan_delay());
                        }
                    }
                    System.arraycopy(bArr, i7, this.imageByteArray, 0, i3);
                    byte[] runLength = getRunLength();
                    if (this.printerProfile.getGraphicsCommand() != 1 || runLength.length >= i5) {
                        int i10 = 0;
                        for (int i11 = 0; i11 < i3; i11 += 8) {
                            int i12 = i7 + i11;
                            bArr2[i10] = (byte) (bArr[i12] + p6[bArr[i12 + 1]] + p5[bArr[i12 + 2]] + p4[bArr[i12 + 3]] + p3[bArr[i12 + 4]] + f11186p2[bArr[i12 + 5]] + f11185p1[bArr[i12 + 6]] + f11184p0[bArr[i12 + 7]]);
                            i10++;
                        }
                        Log.d("CAT", "packet PRT_PRINT_DATA");
                        packPerBytes(bArr2, PRT_PRINT_DATA);
                    } else {
                        Log.d("CAT", "packet PRT_PRINT_DATA_COMPRESS");
                        packPerBytes(runLength, PRT_PRINT_DATA_COMPRESS);
                    }
                    i7 += i3;
                }
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        byte b3;
        int i3;
        if (this.transport instanceof BLE) {
            int dots_per_line = (this.printerProfile.getDots_per_line() / 8) + 11;
            if (dots_per_line < 23) {
                dots_per_line = 23;
            }
            ((BLE) this.transport).setMtu(dots_per_line);
        }
        checkDeviceStatus();
        if (isError()) {
            return;
        }
        int darkness = this.printerProfile.getDarkness();
        if (darkness == 1) {
            b3 = 3;
            i3 = 12000;
        } else if (darkness != 2) {
            b3 = 1;
            i3 = 8600;
        } else {
            b3 = 5;
            i3 = 16000;
        }
        Log.d("CAT", "packet PRT_SET_HEAT_DENSITY");
        packPerBytes(new byte[]{b3}, PRT_SET_HEAT_DENSITY);
        Log.d("CAT", "packet PRT_ENERGY");
        packPerBytes(new byte[]{(byte) (i3 % 256), (byte) (i3 / 256)}, PRT_ENERGY);
        Log.d("CAT", "packet PRT_PAPER_FEED_SPEED");
        packPerBytes(new byte[]{45}, PRT_PAPER_FEED_SPEED);
    }

    @Override // rawbt.sdk.drivers.IVirtualEscPos
    public void injectVirtual(String str, int i3) {
        this.virtual_code_page = str;
        this.virtual_width = i3;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void printImage(Bitmap bitmap, AttributesImage attributesImage) {
        if (attributesImage.getGraphicFilter() == 0) {
            Log.d("CAT", "packet PRT_DRAFT 1");
            packPerBytes(new byte[]{1}, PRT_DRAFT);
        } else {
            Log.d("CAT", "packet PRT_DRAFT 0");
            packPerBytes(new byte[]{0}, PRT_DRAFT);
        }
        super.printImage(bitmap, attributesImage);
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        if (bArr.length > 7) {
            if (bArr[0] == 81 && bArr[1] == 120 && bArr[3] == 1) {
                byte b3 = bArr[2];
                if (b3 == -93) {
                    byte b4 = bArr[6];
                    if (b4 == 0) {
                        Log.d("CAT", RawbtConstants.OK);
                        setStatus(RawbtConstants.OK);
                    } else if ((b4 & 128) == 128) {
                        Log.e("CAT", "BUSY");
                        setStatus("BUSY");
                    } else if ((b4 & 1) == 1) {
                        Log.d("CAT", "no paper");
                        setStatus("no paper");
                        setErrorMessage(this.status);
                    } else if ((b4 & 2) == 2) {
                        Log.d("CAT", "cover open");
                        setStatus("cover open");
                        setErrorMessage(this.status);
                    } else if ((b4 & 4) == 4) {
                        Log.d("CAT", "to hot");
                        setStatus("to hot");
                    } else if ((b4 & 8) == 8) {
                        Log.d("CAT", "low power");
                        transportMessage("low power");
                        setStatus(RawbtConstants.OK);
                    } else {
                        Log.d("CAT", "unknown status response");
                        transportMessage("unknown status response");
                        setStatus(RawbtResponse.RESPONSE_ERROR);
                    }
                } else if (b3 == -82) {
                    this.xOnxOff = bArr[5] != 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("xON/xOFF ");
                    sb.append(this.xOnxOff ? "on" : "off");
                    Log.d("CAT", sb.toString());
                }
            }
        }
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport == null || bArr.length <= 0) {
            return;
        }
        taskForTransport.receiveFromDevice(bArr);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        lineFeed(i3 * 24);
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    public synchronized void setStatus(String str) {
        this.status = str;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        text_as_image(str, attributesString);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public final void text_as_image(String str, AttributesString attributesString) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
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
