package rawbt.api.command;

/* JADX INFO: loaded from: classes.dex */
public class CommandBytesInBase64 implements RawbtCommand {
    public static final String TAG = "sendBytes";
    String base64;
    String command;

    public CommandBytesInBase64() {
        this.command = TAG;
        this.base64 = null;
    }

    public String getBase64() {
        return this.base64;
    }

    public void setBase64(String str) {
        this.base64 = str;
    }

    public CommandBytesInBase64(String str) {
        this.command = TAG;
        this.base64 = str;
    }
}
