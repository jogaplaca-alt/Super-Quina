package rawbt.sdk.drivers;

import android.content.Context;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.sdk.R;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.utils.GraphLibrary;
import rawbt.sdk.utils.RawbtHelper;

/* JADX INFO: loaded from: classes.dex */
public class CpclDriver extends AbstractDriverWithTransport {
    final PrinterEntity printerProfile;

    public CpclDriver(PrinterEntity printerEntity, Context context) {
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
        int density = (this.printerProfile.getDensity() / 100) * 100;
        try {
            int i5 = i3 / 8;
            bytes(("! 0 " + density + " " + density + " " + i4 + " 1\r\nEG " + i5 + " " + i4 + " 0 0 " + RawbtHelper.bytesToHex(GraphLibrary.rasterFormat(bArr, i3, i4), i5 * i4) + "\r\nPRINT\r\n").getBytes());
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
        int density2 = (this.printerProfile.getDensity() / 100) * 100;
        StringBuilder sb = new StringBuilder();
        sb.append("! 0 ");
        sb.append(density2);
        sb.append(" ");
        sb.append(density2);
        sb.append(" ");
        sb.append(density);
        sb.append(" 1\r\nEG 1 1 0 ");
        sb.append(density - 1);
        sb.append(" 00\r\nPRINT\r\n");
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
            setErrorMessage(getContext().getString(R.string.out_of_memory));
        }
    }
}
