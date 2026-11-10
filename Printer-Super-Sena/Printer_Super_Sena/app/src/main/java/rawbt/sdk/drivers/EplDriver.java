package rawbt.sdk.drivers;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.utils.GraphLibrary;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class EplDriver extends AbstractDriverWithTransport {
    private static final byte[] LN = {10};
    final PrinterEntity printerProfile;

    public EplDriver(PrinterEntity printerEntity, Context context) {
        setContext(context);
        this.printerProfile = printerEntity;
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
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = LN;
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(78);
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write("Q0,0".getBytes());
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(("q" + i3).getBytes());
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(("GW0,0," + (i3 / 8) + "," + i4 + ",").getBytes());
            byteArrayOutputStream.write(GraphLibrary.rasterFormat(bArr, i3, i4));
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(80);
            byteArrayOutputStream.write(bArr2);
            bytes(byteArrayOutputStream.toByteArray());
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
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = LN;
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(78);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write("Q0,0".getBytes());
            byteArrayOutputStream.write(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append("GW0,");
            sb.append(density - 1);
            sb.append(",1,1,");
            byteArrayOutputStream.write(sb.toString().getBytes());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(80);
            byteArrayOutputStream.write(bArr);
            bytes(byteArrayOutputStream.toByteArray());
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
