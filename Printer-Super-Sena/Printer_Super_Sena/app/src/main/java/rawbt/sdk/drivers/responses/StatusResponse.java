package rawbt.sdk.drivers.responses;

/* JADX INFO: loaded from: classes.dex */
public class StatusResponse implements IResponse {
    private final int status;

    public StatusResponse(int i3) {
        this.status = i3;
    }

    public int getStatus() {
        return this.status;
    }
}
