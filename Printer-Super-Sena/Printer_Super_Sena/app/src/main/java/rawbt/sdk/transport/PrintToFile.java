package rawbt.sdk.transport;

import android.content.Intent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class PrintToFile implements Transport {
    public static final String ACTION_PRN_VIEW = "rawbt.sdk.PRN_VIEW";
    private FileOutputStream fos;
    Transport.CallBack driver = null;
    boolean isConnect = false;

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        File file = new File(this.driver.getContext().getCacheDir(), "share");
        file.mkdir();
        try {
            this.fos = new FileOutputStream(new File(file.getPath(), "rawbt_temp_prn.prn"));
            this.isConnect = true;
            return RawbtConstants.OK;
        } catch (Exception e3) {
            e3.printStackTrace();
            return "fos: " + e3.getLocalizedMessage();
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isConnect = false;
        try {
            this.fos.flush();
            this.fos.close();
            if (this.driver.isCancelled() || this.driver.isError()) {
                return;
            }
            this.driver.getContext().sendBroadcast(new Intent("rawbt.sdk.emulator.new_preview"));
        } catch (Exception e3) {
            this.driver.transportMessage(e3.getLocalizedMessage());
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
        this.driver = callBack;
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        try {
            this.fos.write(bArr, 0, bArr.length);
            if (bArr.length <= 0) {
                return RawbtConstants.OK;
            }
            this.driver.sentToDevice(bArr);
            return RawbtConstants.OK;
        } catch (IOException e3) {
            e3.printStackTrace();
            return "Error write to file";
        }
    }
}
