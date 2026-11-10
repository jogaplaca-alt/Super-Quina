package rawbt.sdk.transport;

import android.content.Context;
import java.util.Objects;
import rawbt.sdk.R;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class USB implements Transport {
    private int _productId;
    private int _vendorId;
    private HidBridge hidBridge;
    Transport.CallBack driver = null;
    private boolean isConnect = false;

    private String _connect() {
        try {
            Context context = this.driver.getContext();
            Objects.requireNonNull(context);
            if (!context.getPackageManager().hasSystemFeature("android.hardware.usb.host")) {
                return this.driver.getContext().getString(R.string.error_no_otg);
            }
            HidBridge hidBridge = new HidBridge(this.driver.getContext(), this._productId, this._vendorId);
            this.hidBridge = hidBridge;
            if (!hidBridge.OpenDevice()) {
                return this.hidBridge.getErrMess();
            }
            this.hidBridge.injectDriver(this.driver);
            this.hidBridge.StartReadingThread();
            return RawbtConstants.OK;
        } catch (Exception e3) {
            e3.printStackTrace();
            return e3.getLocalizedMessage();
        }
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return _connect();
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        HidBridge hidBridge = this.hidBridge;
        if (hidBridge != null) {
            hidBridge.CloseTheDevice();
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

    public void setConnectParam(String str, String str2) {
        this._vendorId = Integer.parseInt(str);
        this._productId = Integer.parseInt(str2);
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        try {
            if (!this.isConnect) {
                String str_connect = _connect();
                if (!RawbtConstants.OK.equals(str_connect)) {
                    return str_connect;
                }
            }
            if (!this.hidBridge.WriteData(bArr)) {
                return this.hidBridge.getErrMess();
            }
            if (!this.isConnect) {
                disconnect();
            }
            return RawbtConstants.OK;
        } catch (Exception e3) {
            e3.printStackTrace();
            return e3.getLocalizedMessage();
        }
    }
}
