package rawbt.sdk.emulator.common;

/* JADX INFO: loaded from: classes.dex */
public interface Debugger {
    void hexLog(String str);

    void infoLog(String str);

    void sendNow();

    void setParsePoint(int i3);

    void setTotalProgress(int i3);
}
