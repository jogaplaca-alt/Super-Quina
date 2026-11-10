package rawbt.sdk.drivers;

import android.content.Context;
import java.util.UUID;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.transport.BLE;

/* JADX INFO: loaded from: classes.dex */
public class PeripageDriver extends GSv0Driver {
    public PeripageDriver(PrinterEntity printerEntity, Context context) {
        super(printerEntity, context);
    }

    @Override // rawbt.sdk.drivers.GSv0Driver, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        transport_write(new byte[]{16, -1, -2, 69});
    }

    @Override // rawbt.sdk.drivers.GSv0Driver, rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getNotifyUuid() {
        return new UUID[]{UUID.fromString("0000ff01-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.GSv0Driver, rawbt.sdk.transport.BlePrinterInterface
    public UUID[] getWriteUuid() {
        return new UUID[]{UUID.fromString("0000ff02-0000-1000-8000-00805f9b34fb")};
    }

    @Override // rawbt.sdk.drivers.GSv0Driver, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void initialize() {
        if (this.transport instanceof BLE) {
            if (this.printerProfile.get_lan_delay() > 100) {
                this.printerProfile.setLan_delayMS(25);
            }
            int dots_per_line = this.printerProfile.getDots_per_line() / 8;
            this.bandleHeight = 1;
            int i3 = dots_per_line + 11;
            if (i3 < 23) {
                i3 = 23;
            }
            ((BLE) this.transport).setMtu(i3);
        }
        transport_write(new byte[]{16, -1, -2, 1, 16, -1, 16, 0, (byte) this.printerProfile.getDarkness(), 27, 64, 0});
    }

    @Override // rawbt.sdk.drivers.GSv0Driver, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        byte[] bArr = {27, 74, -16};
        while (i3 > 10) {
            transport_write(bArr);
            i3 -= 10;
        }
        bArr[2] = (byte) (i3 * 24);
        transport_write(bArr);
    }
}
