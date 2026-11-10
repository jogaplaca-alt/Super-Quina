package rawbt.api;

import java.util.List;
import rawbt.sdk.PrinterInfo;

/* JADX INFO: loaded from: classes.dex */
public class RawbtResponse {
    public static final String RESPONSE_CANCELED = "canceled";
    public static final String RESPONSE_ERROR = "error";
    public static final String RESPONSE_PRINTERS = "printers";
    public static final String RESPONSE_PROGRESS = "progress";
    public static final String RESPONSE_SUCCESS = "success";
    String errorMessage;
    String jobId;
    List<PrinterInfo> printers;
    Float progress;
    String responseType;

    public String GSON() {
        return new p075w1.d().s(this);
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getJobId() {
        return this.jobId;
    }

    public List<PrinterInfo> getPrinters() {
        return this.printers;
    }

    public Float getProgress() {
        return this.progress;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public void setPrinters(List<PrinterInfo> list) {
        this.printers = list;
    }

    public void setProgress(Float f3) {
        this.progress = f3;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }
}
