package rawbt.sdk.drivers.responses;

/* JADX INFO: loaded from: classes.dex */
public class ModelVersionResponse implements IResponse {
    private final String modelVersion;

    public ModelVersionResponse(String str) {
        this.modelVersion = str;
    }

    public String getModelVersion() {
        return this.modelVersion;
    }
}
