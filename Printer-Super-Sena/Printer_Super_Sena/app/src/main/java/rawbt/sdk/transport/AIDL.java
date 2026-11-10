package rawbt.sdk.transport;

import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class AIDL implements Transport {
    Transport.CallBack driver = null;
    boolean isConnect = false;

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return RawbtConstants.OK;
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isConnect = false;
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
        return null;
    }
}
