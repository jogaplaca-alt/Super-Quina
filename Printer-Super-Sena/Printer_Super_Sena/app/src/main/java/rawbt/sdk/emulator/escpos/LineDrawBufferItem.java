package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class LineDrawBufferItem {
    final int baseLine;
    final Bitmap bitmap;
    final int height;
    int offset;
    final int width;

    public LineDrawBufferItem(int i3, int i4, int i5, Bitmap bitmap) {
        this.offset = i3;
        this.width = i4;
        this.height = i5;
        this.bitmap = bitmap;
        this.baseLine = 0;
    }

    public LineDrawBufferItem(int i3, int i4, int i5, int i6, Bitmap bitmap) {
        this.offset = i3;
        this.width = i4;
        this.height = i5;
        this.bitmap = bitmap;
        this.baseLine = i6;
    }
}
