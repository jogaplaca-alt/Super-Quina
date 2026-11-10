package rawbt.sdk.profiles;

import android.content.Context;
import rawbt.sdk.PrinterEncoding;

/* JADX INFO: loaded from: classes.dex */
public class PrinterProfileGeneralEsc implements InterfacePrinterProfile {
    public static final int CUT_NOT_SUPPORTED = 0;
    public static final int FULL_CUT_ESC_D = 4;
    public static final int FULL_CUT_ESC_I = 3;
    public static final int FULL_CUT_GSV0 = 1;
    public static final int FULL_CUT_GSV65 = 2;
    public static final int GC_ESC_ASTERISK = 1;
    public static final int GC_ESC_ASTERISK_0 = 7;
    public static final int GC_ESC_ASTERISK_39 = 6;
    public static final int GC_ESC_ASTERISK_5 = 8;
    public static final int GC_ESC_ASTERISK_73 = 9;
    public static final int GC_ESC_ASTERISK_A = 14;
    public static final int GC_ESC_GS_S = 10;
    public static final int GC_ESC_K_STAR = 5;
    public static final int GC_ESC_X4_STAR = 4;
    public static final int GC_ESC_X_STAR = 3;
    public static final int GC_GS8L = 12;
    public static final int GC_GSV0_AND_ESC_J = 15;
    public static final int GC_GSV0_OLD = 11;
    public static final int GC_GS_ASTERISK = 2;
    public static final int GC_GS_L = 13;
    public static final int GC_POS_GSV0 = 0;
    public static final int PARTIAL_CUT_ESC_D = 8;
    public static final int PARTIAL_CUT_ESC_M = 7;
    public static final int PARTIAL_CUT_GSV1 = 5;
    public static final int PARTIAL_CUT_GSV66 = 6;
    private String bytes_finish;
    private String bytes_init;
    PrinterEncoding encoding;
    private int dots_per_line = 384;
    private int density = 203;
    private int sleepAfter = 0;
    private int lan_delayMS = 0;
    private int abs_mode = 0;
    private int skipLinesAfterJob = 0;
    private int escGraphicsCommand = 0;
    private int printLanguageType = 0;
    private int printerCutCommand = 0;
    private String printerName = "NoName";

    public byte[] endUtfMode() {
        if (getPrintLanguageType() == 6) {
            return new byte[]{28, 40, 67, 2, 0, 48, 1};
        }
        if (getPrintLanguageType() == 7) {
            return new byte[]{27, 29, 116, 0};
        }
        if (getPrintLanguageType() == 8) {
            return new byte[]{28, 67, 0};
        }
        return getPrintLanguageType() == 9 ? new byte[]{27, 57, 0} : new byte[0];
    }

    public String getBytes_finish() {
        return this.bytes_finish;
    }

    public String getBytes_init() {
        return this.bytes_init;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public int getDensity() {
        return this.density;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public int getDots_per_line() {
        return this.dots_per_line;
    }

    public PrinterEncoding getEncoding() {
        return this.encoding;
    }

    public int getEscGraphicsCommand() {
        return this.escGraphicsCommand;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public String getName() {
        return this.printerName;
    }

    public int getPrintLanguageType() {
        return this.printLanguageType;
    }

    public int getPrinterCutCommand() {
        return this.printerCutCommand;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public int getSkipLinesAfterJob() {
        return this.skipLinesAfterJob;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public long getSleepAfter() {
        return this.sleepAfter;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public int get_abs_mode() {
        return this.abs_mode;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public int get_lan_delay() {
        return this.lan_delayMS;
    }

    public void initEncoding(Context context, String str, String str2) {
        if (getPrintLanguageType() == 2) {
            this.encoding = PrinterEncoding.getByName(str2, context);
            return;
        }
        if (getPrintLanguageType() == 3) {
            this.encoding = PrinterEncoding.getByLanguageGoojprt(str, context);
        } else if (getPrintLanguageType() == 10) {
            this.encoding = PrinterEncoding.getByLanguageStar(str, context);
        } else {
            this.encoding = PrinterEncoding.getByLanguage(str, context);
        }
    }

    public boolean isOldInitMethod() {
        return getPrintLanguageType() == 2 || getPrintLanguageType() == 4;
    }

    @Override // rawbt.sdk.profiles.InterfacePrinterProfile
    public boolean isPrintTextAsImage() {
        return getPrintLanguageType() == 1 || "graphics".equals(getEncoding().getEncoding());
    }

    public boolean isStar() {
        return getPrintLanguageType() == 4 || getPrintLanguageType() == 10;
    }

    public boolean isUtfSupported() {
        return getPrintLanguageType() == 5 || getPrintLanguageType() == 6 || getPrintLanguageType() == 7 || getPrintLanguageType() == 8 || getPrintLanguageType() == 9;
    }

    public void setAbs_mode(int i3) {
        this.abs_mode = i3;
    }

    public void setBytes_finish(String str) {
        this.bytes_finish = str;
    }

    public void setBytes_init(String str) {
        this.bytes_init = str;
    }

    public void setDensity(int i3) {
        this.density = i3;
    }

    public void setDots_per_line(int i3) {
        this.dots_per_line = i3;
    }

    public void setEncoding(PrinterEncoding printerEncoding) {
        this.encoding = printerEncoding;
    }

    public void setEscGraphicsCommand(int i3) {
        this.escGraphicsCommand = i3;
    }

    public void setLan_delayMS(Integer num) {
        this.lan_delayMS = num.intValue();
    }

    public void setName(String str) {
        this.printerName = str;
    }

    public void setPrintLanguageType(int i3) {
        this.printLanguageType = i3;
    }

    public void setPrinterCutCommand(int i3) {
        this.printerCutCommand = i3;
    }

    public void setSkipLinesAfterJob(int i3) {
        this.skipLinesAfterJob = i3;
    }

    public void setSleepAfter(int i3) {
        this.sleepAfter = i3;
    }

    public byte[] startUtfMode() {
        if (getPrintLanguageType() == 6) {
            return new byte[]{28, 40, 67, 2, 0, 48, 2};
        }
        if (getPrintLanguageType() == 7) {
            return new byte[]{27, 29, 116, -128};
        }
        if (getPrintLanguageType() == 8) {
            return new byte[]{28, 67, 8};
        }
        return getPrintLanguageType() == 9 ? new byte[]{27, 57, 1} : new byte[0];
    }
}
