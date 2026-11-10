package rawbt.sdk.emulator.escpos;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import rawbt.api.attributes.AttributesBarcode;
import rawbt.api.attributes.AttributesQRcode;
import rawbt.sdk.emulator.common.Debugger;
import rawbt.sdk.emulator.common.Emulator;

/* JADX INFO: loaded from: classes.dex */
public class EscPosEmulator implements Emulator {
    private static final byte CAN = 24;
    private static final byte CR = 13;
    private static final byte DLE = 16;
    private static final byte EOT = 4;
    private static final byte ESC = 27;
    private static final byte ETX = 3;
    private static final byte FF = 12;
    public static final int FONT_A = 0;
    public static final int FONT_B = 1;
    private static final byte FS = 28;
    private static final byte GS = 29;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static final int HRI_ABOVE = 1;
    public static final int HRI_BELOW = 2;
    public static final int HRI_BOTH = 3;
    public static final int HRI_NONE = 0;
    private static final byte HT = 9;
    public static final int JUSTIFY_CENTER = 1;
    public static final int JUSTIFY_LEFT = 0;
    public static final int JUSTIFY_RIGHT = 2;
    private static final byte LF = 10;
    static final byte NUL = 0;
    private static final byte US = 31;
    String codePageName;
    final Context context;
    public final File file;
    final byte[] input;
    public final int input_length;
    public final LineDrawBuffer lineDrawBuffer;
    public final int max_dots;
    int print_width;
    public RandomAccessFile randomAccessFile;
    Bitmap graphics_image_buffer = null;
    public int colorBurn = -16777216;
    public int colorPaper = -1;
    public int input_pointer = 0;
    public String commandMessage = null;
    boolean bold = false;
    int widthMultiple = 1;
    int heightMultiple = 1;
    int justification = 0;
    boolean underline = false;
    boolean invert = false;
    public int font = 0;
    boolean upsideDown = false;
    boolean inverseColor = false;
    boolean utfMode = false;
    int margin_left = 0;
    final int margin_right = 0;
    public int caret_x = 0;
    int charRightSpace = 0;
    int lineHeight = 32;
    public int output_height = 0;
    AttributesBarcode barcode = new AttributesBarcode();
    AttributesQRcode qrCode = new AttributesQRcode();
    String qrCode_value = "";
    int[] tabPos = {96, 192, 288, 384, 480, 576, 672, 768, 864, 960, 1056, 1152, 1248, 1344, 1440, 1536, 1632, 1728, 1824, 1920, 2016, 2112, 2208, 2304, 2400, 2496, 2592, 2688, 2784, 2880, 2976, 3072, 0};
    public final ArrayList<Integer> cut_pos = new ArrayList<>();
    boolean isStarRasterMode = false;

    public EscPosEmulator(Context context, byte[] bArr, String str, int i3) {
        this.context = context;
        Objects.requireNonNull(context);
        File file = new File(context.getCacheDir(), "emulator.out");
        this.file = file;
        this.input = bArr;
        this.input_length = bArr.length;
        this.codePageName = str;
        this.max_dots = i3;
        this.print_width = i3;
        this.lineDrawBuffer = new LineDrawBuffer(this);
        this.randomAccessFile = new RandomAccessFile(file, "rw");
    }

    private PrinterCommand ESC_Bracket_Factory() {
        try {
            byte b3 = this.input[this.input_pointer + 2];
            if (b3 != 65) {
                return b3 != 89 ? new CommandDummy(2, "[!] ESC ( - Not recognize") : new BytesMultiPrinterCommand(this, "[-]Esc(Y - Specify batch print");
            }
            return new BytesMultiPrinterCommand(this, "[-]Esc(A Control beeper tones");
        } catch (Exception unused) {
        }
    }

    private PrinterCommand ESC_GS_Factory() {
        try {
            int i3 = this.input_pointer;
            if (i3 + 20 < this.input_length) {
                byte[] bArr = this.input;
                if (bArr[i3 + 3] == 28 && bArr[i3 + 4] == 122) {
                    return new BixolonGarbage();
                }
            }
            byte[] bArr2 = this.input;
            byte b3 = bArr2[i3 + 2];
            if (b3 == 3) {
                return new CommandDummy(6, "[-]ESC GS ETX - STAR. Send print-end counter, initialize");
            }
            if (b3 == 25) {
                return new CommandDummy(7, "[-]ESC GS EM - buzzer");
            }
            if (b3 == 35) {
                return new CommandDummy(11, "[-] Memory Switch Settings ");
            }
            if (b3 == 41) {
                byte b4 = bArr2[i3 + 3];
                if (b4 == 73) {
                    return new BytesMultiPrinterCommand(this, "[-]ESC GS ) I - Transmit printer information", true);
                }
                if (b4 == 78) {
                    return new BytesMultiPrinterCommand(this, "[-]ESC GS ) N - Star network commands", true);
                }
                if (b4 == 85) {
                    return new CommandUTFstar();
                }
            } else {
                if (b3 == 52) {
                    return new CommandDummy(4, "[-] Select red/black substitute function");
                }
                if (b3 == 61) {
                    return new CommandDummy(5, "[-!-] Write data to a blank code page ");
                }
                if (b3 == 83) {
                    return new CommandEscGsS();
                }
                if (b3 == 99) {
                    return new CommandDummy(5, "[-] Select reduced printing");
                }
                if (b3 == 116) {
                    return new CommandSelectCodepage(true);
                }
            }
            return new CommandDummy(2, "[!] ESC GS [" + ((int) this.input[this.input_pointer + 2]) + "] - Unknown");
        } catch (Exception unused) {
            return new CommandDummy(2, "[!] ESC GS  - Unknown");
        }
    }

    private PrinterCommand FS_Bracket_Factory() {
        try {
            byte b3 = this.input[this.input_pointer + 2];
            if (b3 == 65) {
                return new BytesMultiPrinterCommand(this, "[-] Select Kanji character style(s)");
            }
            if (b3 == 67) {
                return new CommandUTFepson();
            }
            if (b3 == 69) {
                return new BytesMultiPrinterCommand(this, "[-] Group of commands for receipt enhancement control");
            }
            if (b3 != 76) {
                return b3 != 101 ? new CommandDummy(2, "[!] FS ( - Not recognize") : new BytesMultiPrinterCommand(this, "[-] Enable/disable ASB");
            }
            return new BytesMultiPrinterCommand(this, "[-] Select label and black mark control function(s)");
        } catch (Exception unused) {
            return new CommandDummy(2, "[!] ESC FS  - Unknown");
        }
    }

    private PrinterCommand GS_Bracket_Factory() {
        try {
            byte b3 = this.input[this.input_pointer + 2];
            if (b3 == 65) {
                return new BytesMultiPrinterCommand(this, "[-] Execute test print");
            }
            if (b3 == 72) {
                return new BytesMultiPrinterCommand(this, "[-] Request transmission of response or status");
            }
            if (b3 == 107) {
                return Printer2DCodesCommands.getCommand(this);
            }
            if (b3 == 80) {
                return new BytesMultiPrinterCommand(this, "[-] Page mode control");
            }
            if (b3 == 81) {
                return new BytesMultiPrinterCommand(this, "[-] Commands for drawing graphics");
            }
            switch (b3) {
                case 67:
                    return new BytesMultiPrinterCommand(this, "[-] Edit NV user memory");
                case 68:
                    return new BytesMultiPrinterCommand(this, "[-] Enable/disable real-time command");
                case 69:
                    return new BytesMultiPrinterCommand(this, "[-] Set user setup commands");
                default:
                    switch (b3) {
                        case 74:
                            return new BytesMultiPrinterCommand(this, "[-] GS ( J - undocumented, what do they do?");
                        case 75:
                            return new BytesMultiPrinterCommand(this, "[-] Select print control method(s)");
                        case 76:
                            return new CommandSetGraphicsData();
                        case 77:
                            return new BytesMultiPrinterCommand(this, "[-] Customize printer control value(s)");
                        case 78:
                            return new BytesMultiPrinterCommand(this, "[-] Select character effects");
                    }
            }
            return new CommandDummy(2, "[!] GS ( - Not recognize");
        } catch (Exception unused) {
        }
    }

    public static String bytesToHexWithAscii(byte[] bArr, int i3) {
        char[] cArr = new char[38];
        Arrays.fill(cArr, ' ');
        cArr[24] = '|';
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = b3 & 255;
            int i6 = i4 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[b3 & 15];
            if (i5 > 31 && i5 < 127) {
                cArr[i4 + 25] = (char) b3;
            } else if (i5 == 27) {
                cArr[i4 + 25] = 8592;
            } else if (i5 == 28) {
                cArr[i4 + 25] = 8735;
            } else if (i5 == 29) {
                cArr[i4 + 25] = 8596;
            } else {
                cArr[i4 + 25] = '.';
            }
        }
        return new String(cArr);
    }

    public PrinterCommand getCommand() {
        byte[] bArr = this.input;
        int i3 = this.input_pointer;
        byte b3 = bArr[i3];
        byte b4 = i3 + 1 < this.input_length ? bArr[i3 + 1] : NUL;
        if (b3 == 0) {
            return new FixNUL();
        }
        if (b3 == 4) {
            return new CommandDummy(3, "[-] Transmit status");
        }
        if (b3 == 16) {
            if (b4 == 4) {
                return new CommandDummy(3, "[-]DLE EOT n - Transmit real-time status.");
            }
            if (b4 == 5) {
                return new CommandDummy(3, "[-]DLE ENQ n - Send real-time request to printer");
            }
            if (b4 != 20) {
                return new CommandDummy(1, "[-] Set real-time command mode");
            }
            return bArr[i3 + 2] == 8 ? new CommandDummy(10, "[-]DLE DC4 fn.8 - clear buffers") : new CommandDummy(5, "[-]DLE DC4 fn - Realtime function");
        }
        if (b3 == 24) {
            this.lineDrawBuffer.flush_img();
            return new CommandDummy(1, "[-] Cancel the print data in page mode");
        }
        if (b3 == 31) {
            if (b4 != 3) {
                if (b4 == 116) {
                    return new CommandDummy(2, "[-]US t - print test page");
                }
                return new CommandDummy(2, "[!] US unknown command: " + ((int) b4));
            }
            if (bArr[i3 + 2] == 78) {
                return new CommandDummy(5, "[-]US ETX N  - port idle timeout");
            }
            if (bArr[i3 + 2] == 91) {
                return new CommandDummy(4, "[-]US ETX [  - what is do ?");
            }
            if (bArr[i3 + 2] == 112) {
                return new CommandDummy(4, "[-]US ETX 0x70  - what is do ?");
            }
            return new CommandDummy(2, "[!]US ETX unknown command: " + ((int) this.input[this.input_pointer + 2]));
        }
        if (b3 != 98 && b3 != 107) {
            if (b3 == 12) {
                this.lineDrawBuffer.flush_img();
                return new CommandDummy(1, "[-] Form feed");
            }
            if (b3 == 13) {
                this.caret_x = 0;
                return new CommandDummy();
            }
            switch (b3) {
                case 8:
                    if (b4 == 67 && bArr[i3 + 2] == 82) {
                        return new BixolonGraphics();
                    }
                    return new CommandDummy(2, "[!] BS unknown:" + ((int) b4));
                case 9:
                    return new CommandTab();
                case 10:
                    this.lineDrawBuffer.flush_img();
                    return new CommandDummy();
                default:
                    switch (b3) {
                        case 27:
                            if (b4 == 29) {
                                return ESC_GS_Factory();
                            }
                            if (b4 == 30) {
                                if (bArr[i3 + 2] == 65) {
                                    return new CommandDummy(4, "[-]ESC RS A n - Set print area: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 67) {
                                    return new CommandDummy(4, "[-]ESC RS C n - Two-color print mode: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 69) {
                                    return new CommandDummy(4, "[-]ESC RS E n - Initialize ASB ETB counter, and ETB status. ");
                                }
                                if (bArr[i3 + 2] == 70) {
                                    return new CommandDummy(4, "[-]ESC RS F n - Select Font: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 76) {
                                    return new CommandDummy(4, "[-]ESC RS L n - Batch Control Logo: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 83) {
                                    return new CommandDummy(4, "[-]ESC RS S n - Startup setting [0-Page/1-Line]:  " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 97) {
                                    return new CommandDummy(4, "[-]ESC RS a n - Set ABS: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 100) {
                                    return new CommandDummy(4, "[-]ESC RS d n - STAR. Set print density: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 109) {
                                    return new CommandDummy(4, "[-]ESC RS m n - STAR. Enable, disable black mark detection: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 114) {
                                    return new CommandDummy(4, "[-]ESC RS r n - STAR. Set print speed: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                if (bArr[i3 + 2] == 116) {
                                    return new CommandDummy(4, "[-]ESC RS t n - STAR. Undocumented. What is do ? Val: " + ((int) this.input[this.input_pointer + 3]));
                                }
                                return new CommandDummy(2, "[-] ESC RS unknown command. Next byte: " + ((int) this.input[this.input_pointer + 2]));
                            }
                            if (b4 == 32) {
                                return new CommandSetCharRightSpace();
                            }
                            if (b4 == 33) {
                                return new CommandSelectPrintMode();
                            }
                            if (b4 == 60) {
                                return new CommandReturnHome();
                            }
                            if (b4 == 61) {
                                return new CommandDummy(3, "[-]ESC = n - Select device");
                            }
                            if (b4 == 63) {
                                return new CommandDummy(3, "[-]ESC ? n - Cancel user-defined characters");
                            }
                            if (b4 == 64) {
                                return new CommandInit();
                            }
                            if (b4 == 68) {
                                return new CommandTabStop();
                            }
                            if (b4 != 69) {
                                switch (b4) {
                                    case 7:
                                        return new CommandDummy(4, "[-]ESC BEL - Set external device 1 pulse width");
                                    case 12:
                                        if (bArr[i3 + 2] == 0) {
                                            new CommandPrinterCut(0, false, 2, 0).apply(this);
                                            return new CommandDummy(3, "[-]ESC FF NUL -  Execute FF mode");
                                        }
                                        if (bArr[i3 + 2] != 4) {
                                            return new CommandDummy(bArr[i3 + 2] != 10 ? 2 : 3, "[-] Print data in Page mode");
                                        }
                                        new CommandPrinterCut(0, false, 2, 0).apply(this);
                                        return new CommandDummy(3, "[-]ESC FF EOT - Execute EOT mode");
                                    case 14:
                                        this.widthMultiple = 2;
                                        return new CommandDummy(2, "ESC S0 - Select double width [POS58]");
                                    case 20:
                                        this.widthMultiple = 1;
                                        return new CommandDummy(2, "ESC DC4 - Disable double width [POS58]");
                                    case 22:
                                        return new CommandDummy(4, "[-]ESC SYNC fn m - STAR Original Presenter Control Commands");
                                    case 40:
                                        return ESC_Bracket_Factory();
                                    case 42:
                                        return new CommandBitImageMode();
                                    case 45:
                                        return new CommandUnderline();
                                    case 48:
                                        return new CommandDummy(2, "[-]ESC 0 - Specify line spacing to 3mm");
                                    case 57:
                                        return new CommandUTFpt210();
                                    case 66:
                                        return new CommandInverseColor();
                                    case 71:
                                        break;
                                    case 82:
                                        return new CommandDummy(3, "[-]Specify an international char");
                                    case 83:
                                        return new CommandDummy(2, "[-]Select standard mode");
                                    case 84:
                                        return new CommandDummy(3, "[-]Select print direction in Page mode");
                                    case 85:
                                        return new CommandDummy(3, "[-]Turn unidirectional print mode on/off");
                                    case 86:
                                        return new CommandDummy(3, "[-]Turn 90° clockwise rotation mode on/off");
                                    case 87:
                                        return new CommandDummy(3, "[-]Set print area in Page mode");
                                    case 88:
                                        if (bArr[i3 + 2] == 52) {
                                            return new CommandEscX4();
                                        }
                                        return bArr[i3 + 2] == 50 ? new CommandEscX2() : new CommandGraphics24dot(false);
                                    case 92:
                                        return new CommandDummy(4, "[-]Set relative print position X");
                                    case 97:
                                        return new CommandSelectJustification();
                                    case 105:
                                    case 109:
                                        return new CommandPrinterCut(2, false, 1, 0);
                                    case 107:
                                        return new CommandGraphics24dot(true);
                                    case 112:
                                        return new CommandOpenCashDriver();
                                    case 113:
                                        return new CommandDummy(5, "[-]ESC q  - Rongta . WTF ???");
                                    case 114:
                                        return new CommandDummy(3, "[-]ESC r n - Select print color");
                                    case 116:
                                        return new CommandSelectCodepage(false);
                                    case 117:
                                        return new CommandDummy(3, "[-]ESC u n - Transmits the peripheral device status. Obsolete");
                                    case 118:
                                        return new CommandDummy(2, "[-]ESC v - Transmit paper sensor status. Obsolete");
                                    case 123:
                                        return new CommandUpside();
                                    default:
                                        switch (b4) {
                                            case 36:
                                                return new CommandAbsolutePosition();
                                            case 37:
                                                return new CommandDummy(3, "[-] Select/cancel UDF charset");
                                            case 38:
                                                return new CommandDefineUDC();
                                            default:
                                                switch (b4) {
                                                    case 50:
                                                        this.lineHeight = 32;
                                                        return new CommandDummy(2, "ESC 2 - Select default line spacing");
                                                    case 51:
                                                        return new CommandLineHeight();
                                                    case 52:
                                                        this.inverseColor = true;
                                                        return new CommandDummy(2, "ESC 4 - Star Inverse color ON");
                                                    case 53:
                                                        this.inverseColor = false;
                                                        return new CommandDummy(2, "ESC 5 - Star Inverse color OFF");
                                                    default:
                                                        switch (b4) {
                                                            case 73:
                                                            case 74:
                                                                return new CommandMoveDown();
                                                            case 75:
                                                                this.lineDrawBuffer.flush_img();
                                                                return new CommandDummy(3, "[-]ESC K n - Reverse feed");
                                                            case 76:
                                                                this.lineDrawBuffer.flush_img();
                                                                return new CommandDummy(2, "[-]ESC L - Select page mode");
                                                            case 77:
                                                                return new CommandSelectCharacterFont();
                                                            default:
                                                                switch (b4) {
                                                                    case 99:
                                                                        return new CommandSensors();
                                                                    case 100:
                                                                        return new CommandFeedLines();
                                                                    case 101:
                                                                        this.lineDrawBuffer.flush_img();
                                                                        return new CommandDummy(3, "[-]Feed reverse");
                                                                    default:
                                                                        return new CommandDummy(2, "[!] Unknown ESC " + ((int) b4) + " [" + ((int) b4) + "] command");
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return new CommandBold();
                        case 28:
                            if (b4 == 33) {
                                return new CommandDummy(3, "[-]FS ! n - Select print mode for Kanji");
                            }
                            if (b4 == 38) {
                                return new CommandDummy(2, "[-]FS & - Select Kanji");
                            }
                            if (b4 == 40) {
                                return FS_Bracket_Factory();
                            }
                            if (b4 == 50) {
                                return new CommandDummy(2, "[-!-]FS 2 - Define user-defined Kanji characters.");
                            }
                            if (b4 == 63) {
                                return new CommandDummy(2, "[-]FS ? n n - Cancel user-defined Kanji characters");
                            }
                            if (b4 == 67) {
                                return new CommandUTFcitizen();
                            }
                            if (b4 == 83) {
                                return new CommandDummy(4, "[-]FS S - Set Kanji character spacing");
                            }
                            if (b4 == 87) {
                                return new CommandDummy(3, "[-]FS W n - Turn quadruple-size mode on/off for Kanji");
                            }
                            if (b4 == 103) {
                                return new CommandDummy(2, "[-!-]FS g - NV RAM. Obsolete");
                            }
                            if (b4 == 45) {
                                return new CommandDummy(3, "[-]FS - n - Turn underline mode on/off for Kanji");
                            }
                            if (b4 == 46) {
                                return new CommandDummy(2, "[-]FS . - Cancel Kanji");
                            }
                            if (b4 == 112) {
                                return new CommandDummy(4, "[-]FS p - Print NV bit image. Obsolete");
                            }
                            if (b4 == 113) {
                                return new CommandDummy(2, "[-!-]FS q - Define NV bit image. Obsolete");
                            }
                            return new CommandDummy(2, "[!] Unknown FS " + ((int) b4) + " [" + ((int) b4) + "] command");
                        case 29:
                            switch (b4) {
                                case 33:
                                    return new CommandSelectCharacterSize();
                                case 36:
                                    return new CommandDummy(4, "[-]GS $ - Set absolute vertical print position in Page mode");
                                case 40:
                                    return GS_Bracket_Factory();
                                case 42:
                                    return new CommandDefineDownloadedBitImage();
                                case 47:
                                    Bitmap bitmap = this.graphics_image_buffer;
                                    if (bitmap != null) {
                                        this.lineDrawBuffer.add(new LineDrawBufferItem(this.caret_x, bitmap.getWidth(), this.graphics_image_buffer.getHeight(), this.graphics_image_buffer));
                                        this.lineDrawBuffer.flush_img();
                                    }
                                    this.caret_x = 0;
                                    return new CommandDummy(2, "GS / - Print downloaded bit image. Obsolete");
                                case 56:
                                    if (bArr[i3 + 2] == 76) {
                                        return new CommandSetGraphicsLongData();
                                    }
                                    break;
                                case 58:
                                    return new CommandDummy(3, "[-!-]GS : n - Start/end macro definition");
                                case 66:
                                    return new CommandInverseColor();
                                case 67:
                                    return new CommandDummy(2, "[-!-]GS C - counter function");
                                case 68:
                                    return new CommandDummy(2, "[-!-]GS D - BMP & RAM");
                                case 72:
                                    return new CommandBarcodeHRI();
                                case 73:
                                    return new CommandDummy(3, "[-]GS I - Transmit printer ID");
                                case 76:
                                    return new CommandLeftMargin();
                                case 80:
                                    return new CommandDummy(4, "[-!-]GS P - Set horizontal and vertical motion units");
                                case 81:
                                    return new CommandDummy(4, "[-!-]GS Q <fn.0 ?> - Print variable vertical size bit image");
                                case 84:
                                    return new CommandDummy(3, "[-]GS T n - Set print position to the beginning of print line");
                                case 86:
                                    return new CommandGs_V_cut();
                                case 87:
                                    return new CommandPrintWidth();
                                case 92:
                                    return new CommandDummy(4, "[-]GS \\ Set relative vertical print position in Page mode ");
                                case 94:
                                    return new CommandDummy(5, "[-] Execute macro");
                                case 97:
                                    return new CommandDummy(3, "[-]GS a - Enable/disable ASB");
                                case 98:
                                    return new CommandDummy(3, "[-]GS b - smoothing mode");
                                case 99:
                                    return new CommandDummy(2, "[-]GS c - print counter");
                                case 102:
                                    return new CommandBarcodeFont();
                                case 103:
                                    return new CommandDummy(6, "[-]GS g - maintenance counter");
                                case 104:
                                    return new CommandBarcodeHeight();
                                case 107:
                                    return new CommandBarcode();
                                case 114:
                                    return new CommandDummy(3, "[-]GS r n - Transmit status");
                                case 118:
                                    if (bArr[i3 + 2] == 48) {
                                        return new CommandGsV0();
                                    }
                                    break;
                                case 119:
                                    return new CommandBarcodeWidth();
                                case 122:
                                    return new CommandDummy(5, "[-]GS z - Set online recovery wait time");
                            }
                            return new CommandDummy(2, "[!] Unknown GS " + ((int) b4) + " [" + ((int) b4) + "] command");
                    }
            }
        }
        if (this.isStarRasterMode) {
            return new CommandStarRasterData();
        }
        return new CommandCharOutput();
    }

    public Context getContext() {
        return this.context;
    }

    @Override // rawbt.sdk.emulator.common.Emulator
    public ArrayList<Integer> getCut_pos() {
        return this.cut_pos;
    }

    @Override // rawbt.sdk.emulator.common.Emulator
    public int getOutput_height() {
        return this.output_height;
    }

    @Override // rawbt.sdk.emulator.common.Emulator
    public Bitmap getPreview() {
        Bitmap bitmapCreateBitmap;
        try {
            int i3 = this.output_height;
            if (i3 > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(this.max_dots, i3, Bitmap.Config.ARGB_8888);
                FileChannel channel = this.randomAccessFile.getChannel();
                bitmapCreateBitmap.copyPixelsFromBuffer(channel.map(FileChannel.MapMode.READ_WRITE, 0L, bitmapCreateBitmap.getRowBytes() * bitmapCreateBitmap.getHeight()));
                channel.close();
            } else {
                bitmapCreateBitmap = null;
            }
            this.randomAccessFile.close();
            this.file.delete();
            return bitmapCreateBitmap;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // rawbt.sdk.emulator.common.Emulator
    public boolean isEnd() {
        return this.input_pointer >= this.input_length;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:27:0x0092  */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0078, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0092, please report this as an issue */
    @Override // rawbt.sdk.emulator.common.Emulator
    public void parse(Debugger debugger) {
        debugger.setTotalProgress(this.input.length);
        int i3 = -1;
        while (!isEnd()) {
            if (i3 == -1 || this.input_pointer - i3 > 7) {
                int i4 = this.input_pointer;
                i3 = i4 - (i4 % 8);
                String strBytesToHexWithAscii = bytesToHexWithAscii(Arrays.copyOfRange(this.input, i3, i3 + 8), 8);
                debugger.setParsePoint(i3);
                debugger.hexLog(strBytesToHexWithAscii);
            }
            if (this.output_height > 32000) {
                debugger.sendNow();
                debugger.setParsePoint(this.input_pointer);
                debugger.infoLog("The height of the preview has exceeded 32,000. The parsing is stopped.");
                break;
            }
            PrinterCommand command = null;
            this.commandMessage = null;
            try {
                command = getCommand();
                command.apply(this);
                if (this.commandMessage != null) {
                    debugger.setParsePoint(this.input_pointer);
                    debugger.infoLog(this.commandMessage);
                }
                this.input_pointer += command.get_length();
            } catch (Error e3) {
                e = e3;
                if (this.commandMessage == null) {
                    this.commandMessage += "\n";
                } else if (command == null) {
                    this.commandMessage = "";
                } else {
                    this.commandMessage = command.getClass().getSimpleName() + "\n";
                }
                debugger.setParsePoint(this.input_pointer);
                debugger.infoLog(this.commandMessage + " <span style='color:red'>" + e.getLocalizedMessage() + "</span>");
                if (command != null || command.get_length() < 1) {
                    this.input_pointer++;
                } else {
                    this.input_pointer += command.get_length();
                }
            } catch (Exception e4) {
                e = e4;
                if (this.commandMessage == null) {
                    this.commandMessage += "\n";
                } else if (command == null) {
                    this.commandMessage = "";
                } else {
                    this.commandMessage = command.getClass().getSimpleName() + "\n";
                }
                debugger.setParsePoint(this.input_pointer);
                debugger.infoLog(this.commandMessage + " <span style='color:red'>" + e.getLocalizedMessage() + "</span>");
                if (command != null) {
                }
                this.input_pointer++;
            }
        }
        byte[] bArr = this.input;
        if (bArr.length - i3 > 7) {
            int length = bArr.length % 8;
            int length2 = bArr.length - length;
            String strBytesToHexWithAscii2 = bytesToHexWithAscii(Arrays.copyOfRange(bArr, length2, length2 + length), length);
            debugger.sendNow();
            debugger.setParsePoint(length2);
            debugger.hexLog(strBytesToHexWithAscii2);
        }
    }
}
