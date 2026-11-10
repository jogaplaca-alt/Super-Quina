package rawbt.sdk.drivers.responses;

/* JADX INFO: loaded from: classes.dex */
public class ModelResponse implements IResponse {
    private final String model;

    public ModelResponse(String str) {
        this.model = str;
    }

    public String getModel() {
        return this.model;
    }
}
