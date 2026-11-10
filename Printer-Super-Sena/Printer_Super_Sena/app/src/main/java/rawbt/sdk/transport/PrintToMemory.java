package rawbt.sdk.transport;

import java.util.ArrayList;
import java.util.Iterator;
import rawbt.sdk.RawbtConstants;

/* JADX INFO: loaded from: classes.dex */
public class PrintToMemory implements Transport {
    private final ArrayList<byte[]> buf = new ArrayList<>();
    boolean isConnect = false;

    public void clear() {
        this.buf.clear();
    }

    @Override // rawbt.sdk.transport.Transport
    public String connect() {
        this.isConnect = true;
        return RawbtConstants.OK;
    }

    @Override // rawbt.sdk.transport.Transport
    public void disconnect() {
        this.isConnect = false;
    }

    public byte[] getBuffer() {
        Iterator<byte[]> it = this.buf.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArr = new byte[length];
        int i3 = 0;
        for (byte[] bArr2 : this.buf) {
            for (byte b3 : bArr2) {
                bArr[i3] = b3;
                i3++;
            }
        }
        clear();
        return bArr;
    }

    @Override // rawbt.sdk.transport.Transport
    public void injectDriver(Transport.CallBack callBack) {
    }

    @Override // rawbt.sdk.transport.Transport
    public boolean isConnected() {
        return this.isConnect;
    }

    @Override // rawbt.sdk.transport.Transport
    public String write(byte[] bArr) {
        this.buf.add(bArr);
        return RawbtConstants.OK;
    }
}
