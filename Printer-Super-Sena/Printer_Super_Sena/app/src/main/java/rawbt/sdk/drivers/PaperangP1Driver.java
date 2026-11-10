package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.UUID;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.responses.BatteryResponse;
import rawbt.sdk.drivers.responses.IResponse;
import rawbt.sdk.drivers.responses.ModelResponse;
import rawbt.sdk.drivers.responses.ModelVersionResponse;
import rawbt.sdk.drivers.responses.SerialNumberResponse;
import rawbt.sdk.drivers.responses.StatusResponse;
import rawbt.sdk.drivers.responses.WrongResponse;
import rawbt.sdk.emulator.escpos.EscPosEmulator;
import rawbt.sdk.emulator.escpos.PrinterCommand;
import rawbt.sdk.transport.BLE;

/* JADX INFO: loaded from: classes.dex */
public class PaperangP1Driver extends AbstractDriverWithTransport implements IVirtualEscPos {
    private static final byte PRT_DISCONNECT_BT_CMD = 47;
    private static final byte PRT_FEED_LINE = 26;
    private static final byte PRT_FEED_TO_HEAD_LINE = 33;
    private static final byte PRT_FIRMWARE_DATA = 2;
    private static final byte PRT_GET_BAT_STATUS = 16;
    private static final byte PRT_GET_BOARD_VERSION = 35;
    private static final byte PRT_GET_BT_MAC = 8;
    private static final byte PRT_GET_COUNTRY_NAME = 45;
    private static final byte PRT_GET_FACTORY_STATUS = 21;
    private static final byte PRT_GET_HEAT_DENSITY = 28;
    private static final byte PRT_GET_HW_INFO = 37;
    private static final byte PRT_GET_MAX_GAP_LENGTH = 40;
    private static final byte PRT_GET_MODEL = 6;
    private static final byte PRT_GET_MODEL_VERSION = 48;
    private static final byte PRT_GET_PAPER_TYPE = 42;
    private static final byte PRT_GET_POWER_DOWN_TIME = 31;
    private static final byte PRT_GET_SN = 10;
    private static final byte PRT_GET_STATUS = 12;
    private static final byte PRT_GET_TEMP = 18;
    private static final byte PRT_GET_VERSION = 4;
    private static final byte PRT_GET_VOLTAGE = 14;
    private static final byte PRT_PRINT_DATA = 0;
    private static final byte PRT_PRINT_DATA_COMPRESS = 1;
    private static final byte PRT_PRINT_DEFAULT_PARA = 34;
    private static final byte PRT_PRINT_TEST_PAGE = 27;
    private static final byte PRT_SENT_BAT_STATUS = 17;
    private static final byte PRT_SENT_BOARD_VERSION = 36;
    private static final byte PRT_SENT_BT_MAC = 9;
    private static final byte PRT_SENT_BT_STATUS = 23;
    private static final byte PRT_SENT_COUNTRY_NAME = 46;
    private static final byte PRT_SENT_FACTORY_STATUS = 22;
    private static final byte PRT_SENT_HEAT_DENSITY = 29;
    private static final byte PRT_SENT_HW_INFO = 38;
    private static final byte PRT_SENT_MAX_GAP_LENGTH = 41;
    private static final byte PRT_SENT_MODEL = 7;
    private static final byte PRT_SENT_MODEL_VERSION = 49;
    private static final byte PRT_SENT_PAPER_TYPE = 43;
    private static final byte PRT_SENT_POWER_DOWN_TIME = 32;
    private static final byte PRT_SENT_SN = 11;
    private static final byte PRT_SENT_STATUS = 13;
    private static final byte PRT_SENT_TEMP = 19;
    private static final byte PRT_SENT_VERSION = 5;
    private static final byte PRT_SENT_VOLTAGE = 15;
    private static final byte PRT_SET_CRC_KEY = 24;
    private static final byte PRT_SET_FACTORY_STATUS = 20;
    private static final byte PRT_SET_HEAT_DENSITY = 25;
    private static final byte PRT_SET_MAX_GAP_LENGTH = 39;
    private static final byte PRT_SET_PAPER_TYPE = 44;
    private static final byte PRT_SET_POWER_DOWN_TIME = 30;
    private static final byte PRT_USB_UPDATE_FIRMWARE = 3;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected static final int[] f11187p0 = {0, 128};

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    protected static final int[] f11188p1 = {0, 64};

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    protected static final int[] f11189p2 = {0, 32};
    protected static final int[] p3 = {0, 16};
    protected static final int[] p4 = {0, 8};
    protected static final int[] p5 = {0, 4};
    protected static final int[] p6 = {0, 2};
    int bandleHeight;
    private final Long[] crc32tab;
    int nBytesPerLine;
    PrinterEntity printerProfile;
    private boolean crckeyset = false;
    private String virtual_code_page = "cp437";
    private int virtual_width = 384;
    int status = -1;

    public PaperangP1Driver(PrinterEntity printerEntity, Context context) {
        setContext(context);
        this.printerProfile = printerEntity;
        this.crc32tab = new Long[]{0L, 1996959894L, 3993919788L, 2567524794L, 124634137L, 1886057615L, 3915621685L, 2657392035L, 249268274L, 2044508324L, 3772115230L, 2547177864L, 162941995L, 2125561021L, 3887607047L, 2428444049L, 498536548L, 1789927666L, 4089016648L, 2227061214L, 450548861L, 1843258603L, 4107580753L, 2211677639L, 325883990L, 1684777152L, 4251122042L, 2321926636L, 335633487L, 1661365465L, 4195302755L, 2366115317L, 997073096L, 1281953886L, 3579855332L, 2724688242L, 1006888145L, 1258607687L, 3524101629L, 2768942443L, 901097722L, 1119000684L, 3686517206L, 2898065728L, 853044451L, 1172266101L, 3705015759L, 2882616665L, 651767980L, 1373503546L, 3369554304L, 3218104598L, 565507253L, 1454621731L, 3485111705L, 3099436303L, 671266974L, 1594198024L, 3322730930L, 2970347812L, 795835527L, 1483230225L, 3244367275L, 3060149565L, 1994146192L, 31158534L, 2563907772L, 4023717930L, 1907459465L, 112637215L, 2680153253L, 3904427059L, 2013776290L, 251722036L, 2517215374L, 3775830040L, 2137656763L, 141376813L, 2439277719L, 3865271297L, 1802195444L, 476864866L, 2238001368L, 4066508878L, 1812370925L, 453092731L, 2181625025L, 4111451223L, 1706088902L, 314042704L, 2344532202L, 4240017532L, 1658658271L, 366619977L, 2362670323L, 4224994405L, 1303535960L, 984961486L, 2747007092L, 3569037538L, 1256170817L, 1037604311L, 2765210733L, 3554079995L, 1131014506L, 879679996L, 2909243462L, 3663771856L, 1141124467L, 855842277L, 2852801631L, 3708648649L, 1342533948L, 654459306L, 3188396048L, 3373015174L, 1466479909L, 544179635L, 3110523913L, 3462522015L, 1591671054L, 702138776L, 2966460450L, 3352799412L, 1504918807L, 783551873L, 3082640443L, 3233442989L, 3988292384L, 2596254646L, 62317068L, 1957810842L, 3939845945L, 2647816111L, 81470997L, 1943803523L, 3814918930L, 2489596804L, 225274430L, 2053790376L, 3826175755L, 2466906013L, 167816743L, 2097651377L, 4027552580L, 2265490386L, 503444072L, 1762050814L, 4150417245L, 2154129355L, 426522225L, 1852507879L, 4275313526L, 2312317920L, 282753626L, 1742555852L, 4189708143L, 2394877945L, 397917763L, 1622183637L, 3604390888L, 2714866558L, 953729732L, 1340076626L, 3518719985L, 2797360999L, 1068828381L, 1219638859L, 3624741850L, 2936675148L, 906185462L, 1090812512L, 3747672003L, 2825379669L, 829329135L, 1181335161L, 3412177804L, 3160834842L, 628085408L, 1382605366L, 3423369109L, 3138078467L, 570562233L, 1426400815L, 3317316542L, 2998733608L, 733239954L, 1555261956L, 3268935591L, 3050360625L, 752459403L, 1541320221L, 2607071920L, 3965973030L, 1969922972L, 40735498L, 2617837225L, 3943577151L, 1913087877L, 83908371L, 2512341634L, 3803740692L, 2075208622L, 213261112L, 2463272603L, 3855990285L, 2094854071L, 198958881L, 2262029012L, 4057260610L, 1759359992L, 534414190L, 2176718541L, 4139329115L, 1873836001L, 414664567L, 2282248934L, 4279200368L, 1711684554L, 285281116L, 2405801727L, 4167216745L, 1634467795L, 376229701L, 2685067896L, 3608007406L, 1308918612L, 956543938L, 2808555105L, 3495958263L, 1231636301L, 1047427035L, 2932959818L, 3654703836L, 1088359270L, 936918000L, 2847714899L, 3736837829L, 1202900863L, 817233897L, 3183342108L, 3401237130L, 1404277552L, 615818150L, 3134207493L, 3453421203L, 1423857449L, 601450431L, 3009837614L, 3294710456L, 1567103746L, 711928724L, 3020668471L, 3272380065L, 1510334235L, 755167117L};
    }

    private void lineFeed(int i3) {
        packPerBytes(new byte[]{(byte) (i3 % 256), (byte) (i3 / 256)}, PRT_FEED_LINE, PRT_PRINT_DATA);
    }

    private void packPerBytes(byte[] bArr, byte b3, byte b4) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length + 10];
            bArr2[0] = PRT_FIRMWARE_DATA;
            bArr2[1] = b3;
            bArr2[2] = b4;
            bArr2[3] = (byte) (length & 255);
            bArr2[4] = (byte) ((length >>> 8) & 255);
            int i3 = 5;
            for (byte b5 : bArr) {
                bArr2[i3] = b5;
                i3++;
            }
            int iCrc32 = (int) crc32(bArr, length);
            bArr2[i3] = (byte) (iCrc32 & 255);
            bArr2[i3 + 1] = (byte) ((iCrc32 >>> 8) & 255);
            bArr2[i3 + 2] = (byte) ((iCrc32 >>> 16) & 255);
            bArr2[i3 + 3] = (byte) ((iCrc32 >>> 24) & 255);
            bArr2[i3 + 4] = PRT_USB_UPDATE_FIRMWARE;
            transport_write(bArr2);
        } catch (Exception e3) {
            e3.printStackTrace();
            transportError(e3.getLocalizedMessage());
        }
    }

    public static ArrayList<IResponse> parseResponse(byte[] bArr) {
        ArrayList<IResponse> arrayList = new ArrayList<>();
        try {
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length - 10) {
                if (bArr[i3] != 2) {
                    arrayList.add(new WrongResponse());
                    return arrayList;
                }
                byte b3 = bArr[i3 + 1];
                int i4 = bArr[i3 + 3] + (bArr[i3 + 4] * 256);
                switch (b3) {
                    case 0:
                        Log.d("PAPEPANG", "PRINT_DATA");
                        break;
                    case 1:
                        Log.d("PAPEPANG", "DATA_COMPRESS");
                        break;
                    case 2:
                        Log.d("PAPEPANG", "FIRMWARE_DATA");
                        break;
                    case 3:
                        Log.d("PAPEPANG", "UPDATE_FIRMWARE");
                        break;
                    case 4:
                        Log.d("PAPEPANG", "GET_VERSION");
                        break;
                    case 5:
                        Log.d("PAPEPANG", "SENT_VERSION");
                        break;
                    case 6:
                        Log.d("PAPEPANG", "GET_MODEL");
                        break;
                    case 7:
                        Log.d("PAPEPANG", "SENT_MODEL");
                        byte[] bArr2 = new byte[i4];
                        System.arraycopy(bArr, i3 + 5, bArr2, 0, i4);
                        arrayList.add(new ModelResponse(new String(bArr2)));
                        break;
                    case 8:
                        Log.d("PAPEPANG", "GET_BT_MAC");
                        break;
                    case 9:
                        Log.d("PAPEPANG", "SENT_BT_MAC");
                        break;
                    case 10:
                        Log.d("PAPEPANG", "GET_SN");
                        break;
                    case 11:
                        Log.d("PAPEPANG", "SENT_SN");
                        byte[] bArr3 = new byte[i4];
                        System.arraycopy(bArr, i3 + 5, bArr3, 0, i4);
                        arrayList.add(new SerialNumberResponse(new String(bArr3)));
                        break;
                    case 12:
                        Log.d("PAPEPANG", "GET_STATUS");
                        break;
                    case 13:
                        arrayList.add(new StatusResponse(bArr[i3 + 5] + (bArr[i3 + 6] * PRT_PRINT_DATA)));
                        break;
                    case 14:
                        Log.d("PAPEPANG", "GET_VOLTAGE");
                        break;
                    case 15:
                        Log.d("PAPEPANG", "SENT_VOLTAGE");
                        break;
                    case 16:
                        Log.d("PAPEPANG", "GET_BAT_STATUS");
                        break;
                    case 17:
                        Log.d("PAPEPANG", "SENT_BAT_STATUS");
                        arrayList.add(new BatteryResponse(bArr[i3 + 5]));
                        break;
                    case 18:
                        Log.d("PAPEPANG", "GET_TEMP");
                        break;
                    case 19:
                        Log.d("PAPEPANG", "SENT_TEMP");
                        break;
                    case 20:
                        Log.d("PAPEPANG", "SET_FACTORY_STATUS");
                        break;
                    case 21:
                        Log.d("PAPEPANG", "GET_FACTORY_STATUS");
                        break;
                    case 22:
                        Log.d("PAPEPANG", "SENT_FACTORY_STATUS");
                        break;
                    case 23:
                        Log.d("PAPEPANG", "SENT_BT_STATUS");
                        break;
                    case 24:
                        Log.d("PAPEPANG", "SET_CRC_KEY");
                        break;
                    case 25:
                        Log.d("PAPEPANG", "SET_HEAT_DENSITY");
                        break;
                    case 26:
                        Log.d("PAPEPANG", "FEED_LINE");
                        break;
                    case 27:
                        Log.d("PAPEPANG", "PRINT_TEST_PAGE");
                        break;
                    case 28:
                        Log.d("PAPEPANG", "GET_HEAT_DENSITY");
                        break;
                    case 29:
                        Log.d("PAPEPANG", "SENT_HEAT_DENSITY");
                        break;
                    case 30:
                        Log.d("PAPEPANG", "SET_POWER_DOWN_TIME");
                        break;
                    case 31:
                        Log.d("PAPEPANG", "GET_POWER_DOWN_TIME");
                        break;
                    case 32:
                        Log.d("PAPEPANG", "SENT_POWER_DOWN_TIME");
                        break;
                    case 33:
                        Log.d("PAPEPANG", "FEED_TO_HEAD_LINE");
                        break;
                    case 34:
                        Log.d("PAPEPANG", "PRINT_DEFAULT_PARA");
                        break;
                    case 35:
                        Log.d("PAPEPANG", "GET_BOARD_VERSION");
                        break;
                    case 36:
                        Log.d("PAPEPANG", "SENT_BOARD_VERSION");
                        break;
                    case 37:
                        Log.d("PAPEPANG", "GET_HW_INFO");
                        break;
                    case 38:
                        Log.d("PAPEPANG", "SENT_HW_INFO");
                        break;
                    case 39:
                        Log.d("PAPEPANG", "SET_MAX_GAP_LENGTH");
                        break;
                    case 40:
                        Log.d("PAPEPANG", "GET_MAX_GAP_LENGTH");
                        break;
                    case 41:
                        Log.d("PAPEPANG", "SENT_MAX_GAP_LENGTH");
                        break;
                    case 42:
                        Log.d("PAPEPANG", "PRT_GET_PAPER_TYPE");
                        break;
                    case 43:
                        Log.d("PAPEPANG", "SENT_PAPER_TYPE");
                        break;
                    case 44:
                        Log.d("PAPEPANG", "SET_PAPER_TYPE");
                        break;
                    case 45:
                        Log.d("PAPEPANG", "GET_COUNTRY_NAME");
                        break;
                    case 46:
                        Log.d("PAPEPANG", "SENT_COUNTRY_NAME");
                        break;
                    case 47:
                        Log.d("PAPEPANG", "DISCONNECT_BT_CMD");
                        break;
                    case 48:
                        Log.d("PAPEPANG", "MAX_CMD or GET_MODEL_VER");
                        break;
                    case 49:
                        Log.d("PAPERANG", "PRT_SENT_MODEL_VERSION");
                        byte[] bArr4 = new byte[i4];
                        System.arraycopy(bArr, i3 + 5, bArr4, 0, i4);
                        arrayList.add(new ModelVersionResponse(new String(bArr4)));
                        break;
                    default:
                        Log.d("PAPERANG", "WTF " + ((int) b3));
                        break;
                }
                i3 += i4 + 10;
            }
            return arrayList;
        } catch (Exception unused) {
            arrayList.add(new WrongResponse());
            return arrayList;
        }
    }

    private void waitWhileDo() throws Exception {
        if (this.transport instanceof BLE) {
            Thread.sleep(this.printerProfile.get_lan_delay());
            return;
        }
        setStatus(-1);
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_GET_STATUS, PRT_PRINT_DATA);
        long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < jCurrentTimeMillis && getStatus() == -1) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (getStatus() != -1) {
            return;
        }
        setErrorMessage("Printer not response");
        throw new Exception("Printer not response");
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

    protected long crc32(long j3, byte[] bArr, int i3) {
        long jLongValue = j3 ^ 4294967295L;
        for (int i4 = 0; i4 < i3; i4++) {
            jLongValue = this.crc32tab[(int) ((jLongValue ^ ((long) bArr[i4])) & 255)].longValue() ^ (jLongValue >>> 8);
        }
        return jLongValue ^ 4294967295L;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        lineFeed(275);
    }

    public void getBattery() {
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_GET_BAT_STATUS, PRT_PRINT_DATA);
    }

    public void getHardwareModel() {
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_GET_MODEL, PRT_PRINT_DATA);
    }

    public void getHardwareVersion() {
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_GET_MODEL_VERSION, PRT_PRINT_DATA);
    }

    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("49535343-1E4D-4BD9-BA61-23C647249616")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    public void getSerialNumber() {
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_GET_SN, PRT_PRINT_DATA);
    }

    public int getStatus() {
        return this.status;
    }

    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("49535343-8841-43F4-A8D4-ECBE34729BB3")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    public void graphics(byte[] bArr, int i3, int i4) throws Exception {
        int i5;
        int i6;
        int i7 = this.bandleHeight;
        byte[] bArr2 = new byte[this.nBytesPerLine * i7];
        if (i4 <= i7 || isError() || isCancelled()) {
            i5 = 0;
            i6 = 0;
        } else {
            int i8 = 0;
            i5 = 0;
            i6 = 0;
            int i9 = 0;
            while (i8 < i4 - this.bandleHeight) {
                int i10 = 0;
                for (int i11 = 0; i11 < this.bandleHeight; i11++) {
                    for (int i12 = 0; i12 < i3; i12 += 8) {
                        int i13 = i6 + i12;
                        bArr2[i10] = (byte) (f11187p0[bArr[i13]] + f11188p1[bArr[i13 + 1]] + f11189p2[bArr[i13 + 2]] + p3[bArr[i13 + 3]] + p4[bArr[i13 + 4]] + p5[bArr[i13 + 5]] + p6[bArr[i13 + 6]] + bArr[i13 + 7]);
                        i10++;
                    }
                    i6 += i3;
                }
                packPerBytes(bArr2, PRT_PRINT_DATA, (byte) (i5 & 255));
                i5++;
                int i14 = (i8 * 100) / i4;
                if (i14 > i9 + 5) {
                    stepPercent(i14);
                    i9 = i14;
                }
                waitWhileDo();
                i8 += this.bandleHeight;
            }
        }
        int i15 = i4 - (this.bandleHeight * i5);
        if (i15 <= 0 || isError() || isCancelled()) {
            return;
        }
        byte[] bArr3 = new byte[this.nBytesPerLine * i15];
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            for (int i18 = 0; i18 < i3; i18 += 8) {
                int i19 = i6 + i18;
                bArr3[i16] = (byte) (f11187p0[bArr[i19]] + f11188p1[bArr[i19 + 1]] + f11189p2[bArr[i19 + 2]] + p3[bArr[i19 + 3]] + p4[bArr[i19 + 4]] + p5[bArr[i19 + 5]] + p6[bArr[i19 + 6]] + bArr[i19 + 7]);
                i16++;
            }
            i6 += i3;
        }
        packPerBytes(bArr3, PRT_PRINT_DATA, (byte) (i5 & 255));
        waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        byte b3;
        int dots_per_line = this.printerProfile.getDots_per_line() / 8;
        this.nBytesPerLine = dots_per_line;
        this.bandleHeight = 1000 / dots_per_line;
        if (this.transport instanceof BLE) {
            this.printerProfile.setLan_delayMS(1);
        }
        registerCrcKey();
        int darkness = this.printerProfile.getDarkness();
        if (darkness != 1) {
            b3 = darkness != 2 ? (byte) 55 : (byte) 95;
        } else {
            b3 = 75;
        }
        setDensity(b3);
        setPaperType(PRT_PRINT_DATA);
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
        for (IResponse iResponse : parseResponse(bArr)) {
            if (iResponse instanceof StatusResponse) {
                int status = ((StatusResponse) iResponse).getStatus();
                setStatus(status);
                if (status <= 0) {
                    continue;
                } else if ((status & 16) == 16) {
                    setErrorMessage("cover open");
                    return;
                } else {
                    if ((status & 1) == 1) {
                        setErrorMessage("paper off");
                        return;
                    }
                    setErrorMessage("unknown error");
                }
            }
        }
    }

    public void registerCrcKey() {
        packPerBytes(new byte[]{120, 122, -50, 51}, PRT_SET_CRC_KEY, PRT_PRINT_DATA);
        this.crckeyset = true;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        lineFeed(i3 * 32);
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    public void setDensity(byte b3) {
        packPerBytes(new byte[]{b3}, PRT_SET_HEAT_DENSITY, PRT_PRINT_DATA);
    }

    public void setPaperType(byte b3) {
        packPerBytes(new byte[]{b3}, PRT_SET_PAPER_TYPE, PRT_PRINT_DATA);
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void testPage() {
        packPerBytes(new byte[]{PRT_SENT_MODEL_VERSION}, PRT_PRINT_TEST_PAGE, PRT_PRINT_DATA);
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

    private long crc32(byte[] bArr, int i3) {
        return crc32(this.crckeyset ? 112783193 : 896963873, bArr, i3);
    }
}
