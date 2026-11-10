package p039k1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f9741i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f9742j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f9743k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f9744l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f9745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f9746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f9747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f9751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f9752h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i3, float f3, float f4) {
        boolean z3 = f4 < 0.0f;
        Path path = this.f9751g;
        if (z3) {
            int[] iArr = f9743k;
            iArr[0] = 0;
            iArr[1] = this.f9750f;
            iArr[2] = this.f9749e;
            iArr[3] = this.f9748d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f3, f4);
            path.close();
            float f5 = -i3;
            rectF.inset(f5, f5);
            int[] iArr2 = f9743k;
            iArr2[0] = 0;
            iArr2[1] = this.f9748d;
            iArr2[2] = this.f9749e;
            iArr2[3] = this.f9750f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f6 = 1.0f - (i3 / fWidth);
        float[] fArr = f9744l;
        fArr[1] = f6;
        fArr[2] = ((1.0f - f6) / 2.0f) + f6;
        this.f9746b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f9743k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z3) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f9752h);
        }
        canvas.drawArc(rectF, f3, f4, true, this.f9746b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i3) {
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = f9741i;
        iArr[0] = this.f9750f;
        iArr[1] = this.f9749e;
        iArr[2] = this.f9748d;
        Paint paint = this.f9747c;
        float f3 = rectF.left;
        paint.setShader(new LinearGradient(f3, rectF.top, f3, rectF.bottom, iArr, f9742j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f9747c);
        canvas.restore();
    }

    public Paint c() {
        return this.f9745a;
    }

    public void d(int i3) {
        this.f9748d = d.k(i3, 68);
        this.f9749e = d.k(i3, 20);
        this.f9750f = d.k(i3, 0);
        this.f9745a.setColor(this.f9748d);
    }

    public a(int i3) {
        this.f9751g = new Path();
        Paint paint = new Paint();
        this.f9752h = paint;
        this.f9745a = new Paint();
        d(i3);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f9746b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f9747c = new Paint(paint2);
    }
}
