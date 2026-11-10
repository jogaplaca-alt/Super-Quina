package rawbt.sdk.drivers;

import android.content.Context;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.utils.GraphLibrary;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class ZplDriver extends AbstractDriverWithTransport {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    final PrinterEntity printerProfile;

    public ZplDriver(PrinterEntity printerEntity, Context context) {
        setContext(context);
        this.printerProfile = printerEntity;
    }

    private static String bytesToHex(byte[] bArr, int i3) {
        char[] cArr = new char[i3 * 2];
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = bArr[i4];
            int i5 = i4 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i5] = cArr2[(b3 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        bytes(RawbtHelper.getBytes(this.printerProfile.getBytes_finish()));
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    @Override // rawbt.sdk.drivers.AbstractDriver
    protected void graphics(byte[] bArr, int i3, int i4) {
        if (isError() || isCancelled()) {
            return;
        }
        try {
            int i5 = i3 / 8;
            int i6 = i5 * i4;
            bytes(("^XA^LL" + i4 + "^FO,0,0^GFA," + i6 + "," + i6 + "," + i5 + "," + bytesToHex(GraphLibrary.rasterFormat(bArr, i3, i4), i6) + "^XZ\r\n\r\n").getBytes());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        bytes(RawbtHelper.getBytes(this.printerProfile.getBytes_init()));
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
        int density = (this.printerProfile.getDensity() * 32) / 203;
        StringBuilder sb = new StringBuilder();
        sb.append("^XA^LL");
        sb.append(density);
        sb.append("^FO0,");
        sb.append(density - 1);
        sb.append("^GFA,1,1,1,00^XZ\r\n\r\n");
        bytes(sb.toString().getBytes());
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
