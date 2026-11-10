package rawbt.sdk.emulator.escpos;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
class TextRender {
    private final Canvas canvas;
    private final int char_h;
    private final int char_w;
    private final String encode;
    private final EscPosEmulator escPosEmulator;
    private final int font;

    TextRender(Canvas canvas, int i3, String str, EscPosEmulator escPosEmulator) {
        this.font = i3;
        this.canvas = canvas;
        this.encode = str;
        this.escPosEmulator = escPosEmulator;
        if (i3 == 0) {
            this.char_w = 12;
            this.char_h = 32;
        } else {
            this.char_w = 9;
            this.char_h = 22;
        }
    }

    void render(String str, int i3) {
        int length = str.length();
        int width = this.canvas.getWidth();
        try {
            byte[] bytes = str.getBytes(this.encode);
            int i4 = i3 - this.char_h;
            int i5 = 32575;
            for (byte b3 : bytes) {
                if (i5 > width) {
                    i4 += this.char_h;
                    int i6 = this.char_w * length;
                    i5 = i6 > width ? 0 : (width - i6) / 2;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.char_w, this.char_h, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                int[] pixels = BitmapFont.getPixels(b3, this.escPosEmulator, this.font);
                int length2 = pixels.length;
                for (int i7 = 0; i7 < length2; i7++) {
                    pixels[i7] = pixels[i7] == -1 ? this.escPosEmulator.colorPaper : this.escPosEmulator.colorBurn;
                }
                int i8 = this.char_w;
                bitmapCreateBitmap.setPixels(pixels, 0, i8, 0, 0, i8, this.char_h);
                this.canvas.drawBitmap(bitmapCreateBitmap, i5, i4, new Paint());
                i5 += this.char_w;
            }
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
    }
}
