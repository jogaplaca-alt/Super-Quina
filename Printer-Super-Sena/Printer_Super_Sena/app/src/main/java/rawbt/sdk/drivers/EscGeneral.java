package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import rawbt.api.Constant;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.esc_commands.EscAsterisk;
import rawbt.sdk.drivers.esc_commands.EscAsterisk0;
import rawbt.sdk.drivers.esc_commands.EscAsterisk39;
import rawbt.sdk.drivers.esc_commands.EscAsterisk5;
import rawbt.sdk.drivers.esc_commands.EscAsterisk73;
import rawbt.sdk.drivers.esc_commands.EscAsteriskA;
import rawbt.sdk.drivers.esc_commands.EscGsS;
import rawbt.sdk.drivers.esc_commands.EscX4forStar;
import rawbt.sdk.drivers.esc_commands.EscXforStar;
import rawbt.sdk.drivers.esc_commands.EsckForStar;
import rawbt.sdk.drivers.esc_commands.GS8L;
import rawbt.sdk.drivers.esc_commands.GS_L;
import rawbt.sdk.drivers.esc_commands.GSv0old;
import rawbt.sdk.drivers.esc_commands.GraphCommand;
import rawbt.sdk.drivers.esc_commands.GsAsterisk;
import rawbt.sdk.drivers.esc_commands.Gsv0;
import rawbt.sdk.drivers.esc_commands.Gsv0AndEscJ;
import rawbt.sdk.transport.BLE;
import rawbt.sdk.transport.BlePrinterInterface;
import rawbt.sdk.transport.PrintToFile;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class EscGeneral extends AbstractDriverWithTransport implements BlePrinterInterface {
    static final byte ESC = 27;
    private static final int FONT_A = 0;
    private static final int FONT_B = 1;
    private static final int FONT_C = 2;
    static final byte FS = 28;
    static final byte GS = 29;
    final PrinterEntity printerProfileGeneralEsc;
    int status = -1;

    public EscGeneral(PrinterEntity printerEntity, Context context) {
        this.printerProfileGeneralEsc = printerEntity;
        setContext(context);
    }

    private void align(String str) {
        byte[] bArr = {ESC, 97, 0};
        str.hashCode();
        if (str.equals(Constant.ALIGNMENT_CENTER)) {
            bArr[2] = 1;
        } else if (str.equals(Constant.ALIGNMENT_RIGHT)) {
            bArr[2] = 2;
        }
        bytes(bArr);
    }

    private void applyStringAttr(AttributesString attributesString) {
        if (attributesString == null) {
            return;
        }
        multiAttr(attributesString);
        align(attributesString.getAlignment());
        if (attributesString.isFontB()) {
            font(1);
        } else if (attributesString.isFontA()) {
            font(0);
        } else if (attributesString.isFontC()) {
            font(2);
        }
        if (attributesString.getFontsCpi() > 0) {
            cpi(attributesString.getFontsCpi() - 1);
        }
        if (attributesString.getInternationalChars() > 0) {
            escR(attributesString.getInternationalChars() - 1);
        }
    }

    private void codePage(int i3) {
        if (isStar()) {
            bytes(new byte[]{ESC, GS, 116, (byte) i3});
        } else {
            bytes(new byte[]{ESC, 116, (byte) i3});
        }
    }

    private void cpi(int i3) {
        bytes(new byte[]{ESC, -63, (byte) i3});
    }

    private void escR(int i3) {
        bytes(new byte[]{ESC, 82, (byte) i3});
    }

    private void font(int i3) {
        bytes(new byte[]{ESC, 77, (byte) i3});
    }

    private void multiAttr(AttributesString attributesString) {
        byte[] bArr = {ESC, 33, 0};
        int i3 = attributesString.isBold() ? 8 : 0;
        if (attributesString.isDoubleHeight()) {
            i3 += 16;
        }
        if (attributesString.isDoubleWidth()) {
            i3 += 32;
        }
        if (attributesString.isUnderline()) {
            i3 += 128;
        }
        bArr[2] = (byte) i3;
        bytes(bArr);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
        switch (this.printerProfileGeneralEsc.getCutCommand()) {
            case 1:
                bytes(new byte[]{GS, 86, 48});
                break;
            case 2:
                bytes(new byte[]{GS, 86, 65, 0});
                break;
            case 3:
                bytes(new byte[]{ESC, 105});
                break;
            case 4:
                bytes(new byte[]{ESC, 100, 48});
                break;
            case 5:
                bytes(new byte[]{GS, 86, 49});
                break;
            case 6:
                bytes(new byte[]{GS, 86, 66, 0});
                break;
            case 7:
                bytes(new byte[]{ESC, 109});
                break;
            case 8:
                bytes(new byte[]{ESC, 100, 49});
                break;
        }
    }

    public byte[] endUtfMode() {
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 6) {
            return new byte[]{FS, 40, 67, 2, 0, 48, 1};
        }
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 7) {
            return new byte[]{ESC, GS, 116, 0};
        }
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 8) {
            return new byte[]{FS, 67, 0};
        }
        return this.printerProfileGeneralEsc.getPrintLanguageType() == 9 ? new byte[]{ESC, 57, 0} : new byte[0];
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        bytes(RawbtHelper.getBytes(this.printerProfileGeneralEsc.getBytes_finish()));
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("49535343-1E4D-4BD9-BA61-23C647249616"), UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfileGeneralEsc;
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
        GraphCommand escAsterisk;
        switch (this.printerProfileGeneralEsc.getGraphicsCommand()) {
            case 1:
                escAsterisk = new EscAsterisk(this);
                break;
            case 2:
                escAsterisk = new GsAsterisk(this);
                break;
            case 3:
                escAsterisk = new EscXforStar(this);
                break;
            case 4:
                escAsterisk = new EscX4forStar(this);
                break;
            case 5:
                escAsterisk = new EsckForStar(this);
                break;
            case 6:
                escAsterisk = new EscAsterisk39(this);
                break;
            case 7:
                escAsterisk = new EscAsterisk0(this);
                break;
            case 8:
                escAsterisk = new EscAsterisk5(this);
                break;
            case 9:
                escAsterisk = new EscAsterisk73(this);
                break;
            case 10:
                escAsterisk = new EscGsS(this);
                break;
            case 11:
                escAsterisk = new GSv0old(this);
                break;
            case 12:
                escAsterisk = new GS8L(this);
                break;
            case 13:
                escAsterisk = new GS_L(this);
                break;
            case 14:
                escAsterisk = new EscAsteriskA(this);
                break;
            case 15:
                escAsterisk = new Gsv0AndEscJ(this);
                break;
            default:
                escAsterisk = new Gsv0(this);
                break;
        }
        escAsterisk.graphics(bArr, i3, i4);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        if (this.transport instanceof BLE) {
            int dots_per_line = (this.printerProfileGeneralEsc.getDots_per_line() / 8) + 11;
            if (dots_per_line < 23) {
                dots_per_line = 23;
            }
            ((BLE) this.transport).setMtu(dots_per_line);
        }
        if (!(this.transport instanceof PrintToFile)) {
            transport_write(new byte[]{ESC, 64});
            waitWhileDo();
        }
        if (isOldInitMethod() && this.printerProfileGeneralEsc.getEncoding().getValue() > -1) {
            codePage(this.printerProfileGeneralEsc.getEncoding().getValue());
        }
        bytes(RawbtHelper.getBytes(this.printerProfileGeneralEsc.getBytes_init()));
    }

    public boolean isOldInitMethod() {
        return this.printerProfileGeneralEsc.getPrintLanguageType() == 2 || this.printerProfileGeneralEsc.getPrintLanguageType() == 4;
    }

    public boolean isStar() {
        return this.printerProfileGeneralEsc.getPrintLanguageType() == 4 || this.printerProfileGeneralEsc.getPrintLanguageType() == 10;
    }

    public boolean isUtfSupported() {
        return this.printerProfileGeneralEsc.getPrintLanguageType() == 5 || this.printerProfileGeneralEsc.getPrintLanguageType() == 6 || this.printerProfileGeneralEsc.getPrintLanguageType() == 7 || this.printerProfileGeneralEsc.getPrintLanguageType() == 8 || this.printerProfileGeneralEsc.getPrintLanguageType() == 9;
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
            if (getPrinterProfile().isPrintTextAsImage()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(8, i3 * 32, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(-1);
                printImage(bitmapCreateBitmap, new AttributesImage(0).setDoScale(false));
            } else {
                if (i3 > 1) {
                    bytes(new byte[]{ESC, 100, (byte) (i3 - 1)});
                }
                bytes(new byte[]{10});
            }
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

    public byte[] startUtfMode() {
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 6) {
            return new byte[]{FS, 40, 67, 2, 0, 48, 2};
        }
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 7) {
            return new byte[]{ESC, GS, 116, -128};
        }
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 8) {
            return new byte[]{FS, 67, 8};
        }
        return this.printerProfileGeneralEsc.getPrintLanguageType() == 9 ? new byte[]{ESC, 57, 1} : new byte[0];
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        if (this.printerProfileGeneralEsc.getPrintLanguageType() == 1) {
            text_as_image(str, attributesString);
            return;
        }
        if (isUtfSupported()) {
            transport_write(startUtfMode());
            applyStringAttr(attributesString);
            transport_write(str.getBytes(StandardCharsets.UTF_8));
            transport_write(endUtfMode());
            return;
        }
        if (isOldInitMethod()) {
            applyStringAttr(attributesString);
            try {
                transport_write(str.getBytes(this.printerProfileGeneralEsc.getEncoding().getEncoding()));
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (this.printerProfileGeneralEsc.getPrintLanguageType() != 10) {
            transport_write(new byte[]{FS, 46});
        }
        codePage(this.printerProfileGeneralEsc.getEncoding().getValue());
        applyStringAttr(attributesString);
        int length = str.length();
        if (length < 1) {
            return;
        }
        byte[] bArr = new byte[length];
        int i3 = 0;
        do {
            char cCharAt = str.charAt(i3);
            if (cCharAt == 1168) {
                cCharAt = 1043;
            } else if (cCharAt == 1169) {
                cCharAt = 1075;
            }
            if (cCharAt < 128) {
                bArr[i3] = (byte) cCharAt;
            } else if (cCharAt == 1030) {
                bArr[i3] = 73;
            } else if (cCharAt == 1110) {
                bArr[i3] = 105;
            } else {
                try {
                    bArr[i3] = String.valueOf(cCharAt).getBytes(this.printerProfileGeneralEsc.getEncoding().getEncoding())[0];
                } catch (UnsupportedEncodingException unused) {
                    bArr[i3] = 63;
                }
            }
            i3++;
        } while (i3 < length);
        transport_write(bArr);
    }

    public void waitWhileDo() {
        setStatus(-1);
        if (this.printerProfileGeneralEsc.get_abs_mode() == 1) {
            setStatus(-2);
            this.transport.write(new byte[]{GS, 114, 49});
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) this.printerProfileGeneralEsc.get_lan_delay());
        while (System.currentTimeMillis() < jCurrentTimeMillis && getStatus() < 0) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }
}
