package rawbt.sdk.drivers;

import android.os.Looper;
import android.util.Log;
import rawbt.sdk.R;
import rawbt.sdk.RawbtConstants;
import rawbt.sdk.transport.ConnectParameters;
import rawbt.sdk.transport.Transport;
import rawbt.sdk.transport.TransportFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDriverWithTransport extends AbstractDriver {
    protected Transport transport = null;

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void bytes(byte[] bArr) {
        transport_write(bArr);
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public final String connectPrinter(ConnectParameters connectParameters) {
        try {
            Transport transport = TransportFactory.get(connectParameters);
            this.transport = transport;
            transport.injectDriver(this);
            Transport transport2 = this.transport;
            return transport2 == null ? getContext().getString(R.string.transport_is_null) : transport2.connect();
        } catch (Exception e3) {
            return e3.getLocalizedMessage();
        }
    }

    @Override // rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public final void disconnectPrinter() {
        Transport transport = this.transport;
        if (transport == null) {
            return;
        }
        transport.disconnect();
    }

    @Override // rawbt.sdk.drivers.PosDriverInterface
    public boolean isConnected() {
        return this.transport.isConnected();
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public final void transport_write(byte[] bArr) {
        if (isMainThread()) {
            throw new IllegalStateException("Cannot access printer driver on the main thread since it may potentially lock the UI for a long period of time.");
        }
        if (this.transport == null) {
            setErrorMessage(getContext().getString(R.string.transport_is_null));
            return;
        }
        if (isCancelled()) {
            return;
        }
        String strWrite = this.transport.write(bArr);
        if (RawbtConstants.OK.equals(strWrite)) {
            return;
        }
        setErrorMessage(strWrite);
        Log.d("AbstractDriver Write", strWrite);
    }
}
