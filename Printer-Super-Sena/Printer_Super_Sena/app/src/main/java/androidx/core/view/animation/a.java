package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f4627b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = (int) (length / 0.002f);
        int i4 = i3 + 1;
        this.f4626a = new float[i4];
        this.f4627b = new float[i4];
        float[] fArr = new float[2];
        for (int i5 = 0; i5 < i4; i5++) {
            pathMeasure.getPosTan((i5 * length) / i3, fArr, null);
            this.f4626a[i5] = fArr[0];
            this.f4627b[i5] = fArr[1];
        }
    }

    private static Path a(float f3, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f3, f4, f5, f6, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f4626a.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i4 = (i3 + length) / 2;
            if (f3 < this.f4626a[i4]) {
                length = i4;
            } else {
                i3 = i4;
            }
        }
        float[] fArr = this.f4626a;
        float f4 = fArr[length];
        float f5 = fArr[i3];
        float f6 = f4 - f5;
        if (f6 == 0.0f) {
            return this.f4627b[i3];
        }
        float f7 = (f3 - f5) / f6;
        float[] fArr2 = this.f4627b;
        float f8 = fArr2[i3];
        return f8 + (f7 * (fArr2[length] - f8));
    }

    a(float f3, float f4, float f5, float f6) {
        this(a(f3, f4, f5, f6));
    }
}
