package rawbt.api.command;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CommandEmulate implements RawbtCommand {
    public static final String TAG = "emulate";
    String command = TAG;
    String mode;
    String parcelable;

    public CommandEmulate(Parcelable parcelable, String str) {
        this.parcelable = parcelable.toString();
        this.mode = str;
    }

    public String getMode() {
        return this.mode;
    }

    public String getParcelable() {
        return this.parcelable;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setParcelable(String str) {
        this.parcelable = str;
    }
}
