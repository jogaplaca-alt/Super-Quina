package rawbt.sdk.emulator.common;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface Emulator {
    ArrayList<Integer> getCut_pos();

    int getOutput_height();

    Bitmap getPreview();

    boolean isEnd();

    void parse(Debugger debugger);
}
