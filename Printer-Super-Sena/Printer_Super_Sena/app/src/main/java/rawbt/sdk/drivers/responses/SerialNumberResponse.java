package rawbt.sdk.drivers.responses;

/* JADX INFO: loaded from: classes.dex */
public class SerialNumberResponse implements IResponse {
    private final String sn;

    public SerialNumberResponse(String str) {
        this.sn = str;
    }

    public String getSn() {
        return this.sn;
    }
}
