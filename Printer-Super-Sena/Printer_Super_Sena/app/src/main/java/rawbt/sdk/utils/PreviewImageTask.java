package rawbt.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public class PreviewImageTask implements Callable<Bitmap> {
    private Parcelable bmp_parcelable;
    private final WeakReference<Context> ctx;
    private Drawable drawable;
    private final int mode_g;
    private final int need_width;
    private int scale = 16;
    private String align = Constant.ALIGNMENT_LEFT;
    private boolean inverseColor = false;
    private boolean imgRotate = false;
    private int colorBurn = -16777216;
    private int colorPaper = -1;
    private final int mode = 2;

    public PreviewImageTask(Context context, Parcelable parcelable, int i3, int i4) {
        this.need_width = i3;
        this.mode_g = i4;
        this.bmp_parcelable = parcelable;
        this.ctx = new WeakReference<>(context);
    }

    public String getAlign() {
        return this.align;
    }

    public int getScale() {
        return this.scale;
    }

    public void imgRotate() {
        this.imgRotate = true;
    }

    public void inverseColor() {
        this.inverseColor = true;
    }

    public void setAlign(String str) {
        this.align = str;
    }

    public void setColorBurn(int i3) {
        this.colorBurn = i3;
    }

    public void setColorPaper(int i3) {
        this.colorPaper = i3;
    }

    public void setScale(int i3) {
        this.scale = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() {
        Bitmap bitmapDecodeStream;
        Bitmap grayscale;
        int i3;
        int i4;
        int scale = (this.need_width * getScale()) / 16;
        int i5 = this.need_width;
        if (this.mode == 1) {
            try {
                Context context = this.ctx.get();
                Objects.requireNonNull(context);
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream((Uri) this.bmp_parcelable);
                Objects.requireNonNull(inputStreamOpenInputStream);
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                bitmapDecodeStream = null;
            }
        } else {
            bitmapDecodeStream = null;
        }
        if (this.mode == 2) {
            bitmapDecodeStream = ((BitmapDrawable) this.drawable).getBitmap();
        }
        if (bitmapDecodeStream != null) {
            Bitmap.Config config = bitmapDecodeStream.getConfig();
            try {
                if (this.imgRotate) {
                    bitmapDecodeStream = GraphLibrary.rotateBitmap(bitmapDecodeStream);
                }
                Bitmap bitmapResizeImage = GraphLibrary.resizeImage(bitmapDecodeStream, scale, (bitmapDecodeStream.getHeight() * scale) / bitmapDecodeStream.getWidth());
                int height = bitmapResizeImage.getHeight();
                if (getScale() < 16) {
                    int[] iArr = new int[scale * height];
                    bitmapResizeImage.getPixels(iArr, 0, bitmapResizeImage.getWidth(), 0, 0, bitmapResizeImage.getWidth(), bitmapResizeImage.getHeight());
                    grayscale = Bitmap.createBitmap(i5, height, config);
                    grayscale.eraseColor(this.inverseColor ? -16777216 : -1);
                    if (Constant.ALIGNMENT_RIGHT.equals(getAlign())) {
                        i4 = i5 - scale;
                    } else {
                        if (Constant.ALIGNMENT_CENTER.equals(getAlign())) {
                            i4 = (i5 - scale) / 2;
                        } else {
                            i3 = 0;
                        }
                        grayscale.setPixels(iArr, 0, scale, i3, 0, scale, height);
                    }
                    i3 = i4;
                    grayscale.setPixels(iArr, 0, scale, i3, 0, scale, height);
                } else {
                    grayscale = bitmapResizeImage;
                }
                int[] iArr2 = new int[((height + 1) * i5) + 1];
                int i6 = this.mode_g;
                if (i6 == 8) {
                    grayscale.setDensity(200);
                    return grayscale;
                }
                if (i6 == 0) {
                    grayscale = GraphLibrary.toGrayscale(grayscale);
                }
                grayscale.getPixels(iArr2, 0, grayscale.getWidth(), 0, 0, grayscale.getWidth(), grayscale.getHeight());
                byte[] bArrDithering = GraphLibrary.dithering(iArr2, height, i5, this.mode_g, this.ctx.get());
                grayscale.recycle();
                int i7 = 0;
                for (int i8 = 0; i8 < height; i8++) {
                    for (int i9 = 0; i9 < i5; i9++) {
                        if (bArrDithering[i7] == 0) {
                            iArr2[i7] = this.inverseColor ? this.colorBurn : this.colorPaper;
                        } else {
                            iArr2[i7] = this.inverseColor ? this.colorPaper : this.colorBurn;
                        }
                        i7++;
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, height, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, height);
                bitmapCreateBitmap.setDensity(200);
                return bitmapCreateBitmap;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return null;
            } catch (OutOfMemoryError e6) {
                e = e6;
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public PreviewImageTask(Context context, Drawable drawable, int i3, int i4) {
        this.need_width = i3;
        this.mode_g = i4;
        this.drawable = drawable;
        this.ctx = new WeakReference<>(context);
    }
}
