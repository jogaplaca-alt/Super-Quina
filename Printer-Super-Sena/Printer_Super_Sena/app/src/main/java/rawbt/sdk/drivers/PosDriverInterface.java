package rawbt.sdk.drivers;

import android.graphics.Bitmap;
import rawbt.api.attributes.AttributesImage;
import rawbt.api.attributes.AttributesString;
import rawbt.api.command.CommandBarcode;
import rawbt.api.command.CommandDrawLine;
import rawbt.api.command.CommandLeftRightText;
import rawbt.api.command.CommandQRcode;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.transport.ConnectParameters;
import rawbt.sdk.transport.Transport;

/* JADX INFO: loaded from: classes.dex */
public interface PosDriverInterface extends Transport.CallBack {

    public interface TaskForTransport {
        void deviceError(String str);

        void deviceProgress(String str);

        boolean isCancelled();

        void receiveFromDevice(byte[] bArr);

        void sentToDevice(byte[] bArr);

        void stepPercent(int i3);
    }

    void barcode(CommandBarcode commandBarcode);

    void bytes(byte[] bArr);

    void clearBuf();

    String connectPrinter(ConnectParameters connectParameters);

    void cutPaper();

    void disconnectPrinter();

    void drawCharLine(CommandDrawLine commandDrawLine);

    void finish();

    String getErrorMessage();

    @Override // rawbt.sdk.transport.Transport.CallBack
    PrinterEntity getPrinterProfile();

    void initialize();

    void interactiveTask(TaskForTransport taskForTransport);

    @Override // rawbt.sdk.transport.Transport.CallBack
    boolean isCancelled();

    boolean isConnected();

    @Override // rawbt.sdk.transport.Transport.CallBack
    boolean isError();

    void leftRight(CommandLeftRightText commandLeftRightText);

    void printImage(Bitmap bitmap, AttributesImage attributesImage);

    void qrcode(CommandQRcode commandQRcode);

    void resetError();

    void scrollPaper(int i3);

    void text(String str, AttributesString attributesString);

    void text_as_image(String str, AttributesString attributesString);
}
