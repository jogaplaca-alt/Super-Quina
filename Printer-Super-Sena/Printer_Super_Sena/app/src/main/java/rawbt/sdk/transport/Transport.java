package rawbt.sdk.transport;

import android.content.Context;
import rawbt.sdk.dao.PrinterEntity;

/* JADX INFO: loaded from: classes.dex */
public interface Transport {

    public interface CallBack {
        Context getContext();

        PrinterEntity getPrinterProfile();

        boolean isCancelled();

        boolean isError();

        void receiveFromDevice(byte[] bArr);

        void sentToDevice(byte[] bArr);

        void transportError(String str);

        void transportMessage(String str);
    }

    String connect();

    void disconnect();

    void injectDriver(CallBack callBack);

    boolean isConnected();

    String write(byte[] bArr);
}
