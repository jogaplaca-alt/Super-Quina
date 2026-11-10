package rawbt.sdk.emulator.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class PreviewTask implements Callable<Bitmap> {
    private final boolean add_frame;
    private final WeakReference<Context> context;
    private final String encode;
    private final boolean isFree;
    private final PreviewTaskCallback mA;
    private final int nWidth;
    private final Parcelable prn_parcelable;

    public PreviewTask(PreviewTaskCallback previewTaskCallback, Parcelable parcelable, int i3, String str, boolean z3, Context context, boolean z4) {
        this.context = new WeakReference<>(context);
        this.isFree = z4;
        this.mA = previewTaskCallback;
        this.nWidth = i3;
        this.prn_parcelable = parcelable;
        this.encode = str;
        this.add_frame = z3;
    }

    private static Bitmap drawText(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(-16777216);
        textPaint.setTextSize(21);
        textPaint.setAntiAlias(false);
        textPaint.setSubpixelText(false);
        textPaint.setDither(false);
        Layout.Alignment alignment = Layout.Alignment.ALIGN_OPPOSITE;
        StaticLayout staticLayoutBuild = Build.VERSION.SDK_INT >= 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, 320).setAlignment(alignment).build() : new StaticLayout(str, textPaint, 320, alignment, 1.0f, 0.0f, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(320, staticLayoutBuild.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        bitmapCreateBitmap.eraseColor(-1);
        canvas.translate(0.0f, 0.0f);
        staticLayoutBuild.draw(canvas);
        return bitmapCreateBitmap;
    }

    static byte[] readBinary(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = inputStream.read();
            while (i3 != -1) {
                byteArrayOutputStream.write(i3);
                i3 = inputStream.read();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return new byte[]{32};
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() {
        byte[] bytes;
        try {
            if (this.prn_parcelable != null) {
                InputStream inputStreamOpenInputStream = this.context.get().getContentResolver().openInputStream((Uri) this.prn_parcelable);
                Objects.requireNonNull(inputStreamOpenInputStream);
                bytes = readBinary(inputStreamOpenInputStream);
                inputStreamOpenInputStream.close();
            } else {
                bytes = null;
            }
            if (bytes == null) {
                bytes = "[!] Empty input data".getBytes();
            }
        } catch (Exception unused) {
            bytes = "[!] Exception when getting data".getBytes();
        }
        return this.context.get() == null ? drawText("Ops :( Internal error: Context is null") : new ParserPrn(this.context.get(), this.isFree).parse(this.mA, bytes, this.nWidth, this.encode, this.add_frame);
    }
}
