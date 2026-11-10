package rawbt.sdk.drivers.responses;

/* JADX INFO: loaded from: classes.dex */
public class BatteryResponse implements IResponse {
    private final int percent;

    public BatteryResponse(int i3) {
        this.percent = i3;
    }

    public int getPercent() {
        return this.percent;
    }
}
