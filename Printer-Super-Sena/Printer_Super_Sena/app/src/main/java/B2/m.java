package B2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static Bitmap a(View view, float f3, float f4) {
        try {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) f3, (int) f4, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(-1);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                int left = view.getLeft();
                int top = view.getTop();
                int iSave = canvas.save();
                canvas.translate(-left, -top);
                float width = f3 / view.getWidth();
                canvas.scale(width, width, left, top);
                view.draw(canvas);
                canvas.restoreToCount(iSave);
                Paint paint = new Paint();
                paint.setColor(0);
                canvas.drawRect(0.0f, 0.0f, 1.0f, f4, paint);
                canvas.drawRect(f3 - 1.0f, 0.0f, f3, f4, paint);
                canvas.drawRect(0.0f, 0.0f, f3, 1.0f, paint);
                canvas.drawRect(0.0f, f4 - 1.0f, f3, f4, paint);
                canvas.setBitmap(null);
                return bitmapCreateBitmap;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static float b(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
