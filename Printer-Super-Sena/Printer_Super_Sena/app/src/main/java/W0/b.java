package W0;

import android.graphics.Canvas;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public interface a {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f3, float f4, float f5, float f6, int i3) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f3, f4, f5, f6, i3) : canvas.saveLayerAlpha(f3, f4, f5, f6, i3, 31);
    }
}
