package rawbt.sdk.transport;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface BlePrinterInterface {
    UUID[] getNotifyUuid();

    UUID[] getWriteUuid();
}
