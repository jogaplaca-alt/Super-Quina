package rawbt.api.command;

/* JADX INFO: loaded from: classes.dex */
public class CommandNewLine implements RawbtCommand {
    public static final String TAG = "ln";
    String command;
    int count;

    public CommandNewLine() {
        this.command = TAG;
        this.count = 1;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public CommandNewLine(int i3) {
        this.command = TAG;
        this.count = i3;
    }
}
