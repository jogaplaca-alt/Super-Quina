package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.UUID;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandBarcode;
import rawbt.api.command.CommandDrawLine;
import rawbt.api.command.CommandLeftRightText;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.transport.BlePrinterInterface;
import rawbt.sdk.transport.ConnectParameters;
import rawbt.sdk.transport.Transport;
import rawbt.sdk.transport.TransportFactory;

/* JADX INFO: loaded from: classes.dex */
public class RealRAW implements PosDriverInterface, BlePrinterInterface {
    Context context;
    final PrinterEntity printerProfile;
    private Transport transport = null;
    boolean errorPresent = false;
    private String errMsg = null;
    private PosDriverInterface.TaskForTransport jobTask = null;

    public RealRAW(PrinterEntity printerEntity, Context context) {
        this.printerProfile = printerEntity;
        this.context = context;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void barcode(CommandBarcode commandBarcode) {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void bytes(byte[] bArr) {
        if (this.transport == null) {
            this.errorPresent = true;
            this.errMsg = "transport is null";
        } else {
            if (isCancelled()) {
                return;
            }
            String strWrite = this.transport.write(bArr);
            if (RawbtConstants.OK.equals(strWrite)) {
                return;
            }
            this.errorPresent = true;
            this.errMsg = strWrite;
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void clearBuf() {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public String connectPrinter(ConnectParameters connectParameters) {
        try {
            Transport transport = TransportFactory.get(connectParameters);
            this.transport = transport;
            transport.injectDriver(this);
            Transport transport2 = this.transport;
            return transport2 == null ? "transport is null" : transport2.connect();
        } catch (Exception e3) {
            return e3.getLocalizedMessage();
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void cutPaper() {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void disconnectPrinter() {
        Transport transport = this.transport;
        if (transport == null) {
            return;
        }
        transport.disconnect();
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void drawCharLine(CommandDrawLine commandDrawLine) {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public Context getContext() {
        return this.context;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public String getErrorMessage() {
        return this.errMsg;
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("49535343-1E4D-4BD9-BA61-23C647249616"), UUID.fromString("D973F2E2-B19E-11E2-9E96-0800200C9A66")};
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public PrinterEntity getPrinterProfile() {
        return this.printerProfile;
    }

    @Override // rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("0000AE01-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000FF02-0000-1000-8000-00805F9B34FB"), UUID.fromString("0000AB01-0000-1000-8000-00805F9B34FB"), UUID.fromString("49535343-8841-43F4-A8D4-ECBE34729BB3"), UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb"), UUID.fromString("fec26ec4-6d71-4442-9f81-55bc21d658d6"), UUID.fromString("D973F2E1-B19E-11E2-9E96-0800200C9A66")};
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void interactiveTask(PosDriverInterface.TaskForTransport taskForTransport) {
        this.jobTask = taskForTransport;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public final boolean isCancelled() {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport == null) {
            return false;
        }
        return taskForTransport.isCancelled();
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public boolean isConnected() {
        return this.transport.isConnected();
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface, rawbt.sdk.transport.Transport.CallBack
    public boolean isError() {
        return this.errorPresent;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void leftRight(CommandLeftRightText commandLeftRightText) {
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void printImage(Bitmap bitmap, AttributesImage attributesImage) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceError("Driver is not support print image. Select another driver.");
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void qrcode(CommandQRcode commandQRcode) {
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.receiveFromDevice(bArr);
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void resetError() {
        this.errorPresent = false;
        this.errMsg = null;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void sentToDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.sentToDevice(bArr);
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void text(String str, AttributesString attributesString) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceError("Driver is not support print text. Select another driver.");
        }
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public void text_as_image(String str, AttributesString attributesString) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceError("Driver is not support print text. Select another driver.");
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void transportError(String str) {
        this.errorPresent = true;
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceError(str);
        }
    }

    @Override // rawbt.sdk.transport.Transport.CallBack
    public void transportMessage(String str) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.deviceProgress(str);
        }
    }
}
