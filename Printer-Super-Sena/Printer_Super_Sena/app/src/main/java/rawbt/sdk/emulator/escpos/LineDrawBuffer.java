package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LineDrawBuffer {
    private final EscPosEmulator escPosEmulator;
    private final ArrayList<LineDrawBufferItem> items = new ArrayList<>();
    private int width = 0;
    public int height = 0;
    private int baseLine = 0;
    int last_height = 0;

    LineDrawBuffer(EscPosEmulator escPosEmulator) {
        this.escPosEmulator = escPosEmulator;
    }

    private Bitmap get_bmp() {
        int i3 = this.height;
        if (i3 < 1) {
            i3 = this.escPosEmulator.lineHeight;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.escPosEmulator.max_dots, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        bitmapCreateBitmap.eraseColor(this.escPosEmulator.colorPaper);
        Paint paint = new Paint();
        EscPosEmulator escPosEmulator = this.escPosEmulator;
        int i4 = escPosEmulator.justification;
        int i5 = i4 == 1 ? ((escPosEmulator.print_width - escPosEmulator.lineDrawBuffer.width) / 2) - 1 : 0;
        if (i4 == 2) {
            i5 = escPosEmulator.print_width - escPosEmulator.lineDrawBuffer.width;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        for (LineDrawBufferItem lineDrawBufferItem : this.items) {
            int i6 = lineDrawBufferItem.offset + i5 + this.escPosEmulator.margin_left;
            int i7 = this.height;
            int i8 = lineDrawBufferItem.height;
            int i9 = ((i7 - i8) - this.baseLine) + lineDrawBufferItem.baseLine;
            if (i9 + i8 > i3) {
                i9 = i3 - i8;
            }
            if (i9 < 0) {
                i9 = 0;
            }
            canvas.drawBitmap(lineDrawBufferItem.bitmap, i6, i9, paint);
        }
        this.height = i3;
        return bitmapCreateBitmap;
    }

    void add(LineDrawBufferItem lineDrawBufferItem) {
        EscPosEmulator escPosEmulator = this.escPosEmulator;
        int i3 = escPosEmulator.caret_x;
        int i4 = lineDrawBufferItem.width;
        int i5 = i3 + i4;
        escPosEmulator.caret_x = i5;
        int i6 = escPosEmulator.print_width;
        if (i5 > i6 && i4 < i6) {
            flush_img();
            lineDrawBufferItem.offset = 0;
            this.escPosEmulator.caret_x = lineDrawBufferItem.width;
        }
        this.items.add(lineDrawBufferItem);
        this.width = lineDrawBufferItem.offset + lineDrawBufferItem.width;
        this.height = Math.max(this.height, lineDrawBufferItem.height);
        this.baseLine = Math.max(this.baseLine, lineDrawBufferItem.baseLine);
    }

    public void clear() {
        this.items.clear();
        this.height = 0;
        this.width = 0;
    }

    public void flush_img() {
        try {
            Bitmap bitmapCreateBitmap = get_bmp();
            if (this.escPosEmulator.upsideDown) {
                Matrix matrix = new Matrix();
                matrix.postRotate(180.0f);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
            }
            bitmapCreateBitmap.copyPixelsToBuffer(this.escPosEmulator.randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, bitmapCreateBitmap.getRowBytes() * this.escPosEmulator.output_height, bitmapCreateBitmap.getRowBytes() * this.height));
            this.escPosEmulator.output_height += bitmapCreateBitmap.getHeight();
            this.last_height = bitmapCreateBitmap.getHeight();
        } catch (Exception e3) {
            EscPosEmulator escPosEmulator = this.escPosEmulator;
            if (escPosEmulator.commandMessage == null) {
                escPosEmulator.commandMessage = "";
            }
            StringBuilder sb = new StringBuilder();
            EscPosEmulator escPosEmulator2 = this.escPosEmulator;
            sb.append(escPosEmulator2.commandMessage);
            sb.append("[!] ");
            sb.append(e3.getLocalizedMessage());
            escPosEmulator2.commandMessage = sb.toString();
        }
        this.items.clear();
        this.escPosEmulator.caret_x = 0;
        this.height = 0;
        this.baseLine = 0;
        this.width = 0;
    }
}
