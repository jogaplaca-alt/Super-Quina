package p020f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p012d.a;
import p012d.i;
import p012d.j;

/* JADX INFO: loaded from: classes.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f9523m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f9524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f9526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f9530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f9533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f9534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9535l;

    public d(Context context) {
        Paint paint = new Paint();
        this.f9524a = paint;
        this.f9530g = new Path();
        this.f9532i = false;
        this.f9535l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, j.f9340Z0, a.f9107y, i.f9253b);
        c(typedArrayObtainStyledAttributes.getColor(j.f9356d1, 0));
        b(typedArrayObtainStyledAttributes.getDimension(j.f9372h1, 0.0f));
        f(typedArrayObtainStyledAttributes.getBoolean(j.f9368g1, true));
        d(Math.round(typedArrayObtainStyledAttributes.getDimension(j.f9364f1, 0.0f)));
        this.f9531h = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f9360e1, 0);
        this.f9526c = Math.round(typedArrayObtainStyledAttributes.getDimension(j.f9352c1, 0.0f));
        this.f9525b = Math.round(typedArrayObtainStyledAttributes.getDimension(j.f9344a1, 0.0f));
        this.f9527d = typedArrayObtainStyledAttributes.getDimension(j.f9348b1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float a(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public void b(float f3) {
        if (this.f9524a.getStrokeWidth() != f3) {
            this.f9524a.setStrokeWidth(f3);
            double d3 = f3 / 2.0f;
            double dCos = Math.cos(f9523m);
            Double.isNaN(d3);
            this.f9534k = (float) (d3 * dCos);
            invalidateSelf();
        }
    }

    public void c(int i3) {
        if (i3 != this.f9524a.getColor()) {
            this.f9524a.setColor(i3);
            invalidateSelf();
        }
    }

    public void d(float f3) {
        if (f3 != this.f9528e) {
            this.f9528e = f3;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i3 = this.f9535l;
        boolean z3 = false;
        if (i3 != 0 && (i3 == 1 || (i3 == 3 ? androidx.core.graphics.drawable.a.f(this) == 0 : androidx.core.graphics.drawable.a.f(this) == 1))) {
            z3 = true;
        }
        float f3 = this.f9525b;
        float fA = a(this.f9526c, (float) Math.sqrt(f3 * f3 * 2.0f), this.f9533j);
        float fA2 = a(this.f9526c, this.f9527d, this.f9533j);
        float fRound = Math.round(a(0.0f, this.f9534k, this.f9533j));
        float fA3 = a(0.0f, f9523m, this.f9533j);
        float fA4 = a(z3 ? 0.0f : -180.0f, z3 ? 180.0f : 0.0f, this.f9533j);
        double d3 = fA;
        double d4 = fA3;
        double dCos = Math.cos(d4);
        Double.isNaN(d3);
        boolean z4 = z3;
        float fRound2 = Math.round(dCos * d3);
        double dSin = Math.sin(d4);
        Double.isNaN(d3);
        float fRound3 = Math.round(d3 * dSin);
        this.f9530g.rewind();
        float fA5 = a(this.f9528e + this.f9524a.getStrokeWidth(), -this.f9534k, this.f9533j);
        float f4 = (-fA2) / 2.0f;
        this.f9530g.moveTo(f4 + fRound, 0.0f);
        this.f9530g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f9530g.moveTo(f4, fA5);
        this.f9530g.rLineTo(fRound2, fRound3);
        this.f9530g.moveTo(f4, -fA5);
        this.f9530g.rLineTo(fRound2, -fRound3);
        this.f9530g.close();
        canvas.save();
        float strokeWidth = this.f9524a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        float f5 = this.f9528e;
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * f5))) / 4) * 2) + (strokeWidth * 1.5f) + f5);
        if (this.f9529f) {
            canvas.rotate(fA4 * (this.f9532i ^ z4 ? -1 : 1));
        } else if (z4) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f9530g, this.f9524a);
        canvas.restore();
    }

    public void e(float f3) {
        if (this.f9533j != f3) {
            this.f9533j = f3;
            invalidateSelf();
        }
    }

    public void f(boolean z3) {
        if (this.f9529f != z3) {
            this.f9529f = z3;
            invalidateSelf();
        }
    }

    public void g(boolean z3) {
        if (this.f9532i != z3) {
            this.f9532i = z3;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f9531h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f9531h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f9524a.getAlpha()) {
            this.f9524a.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9524a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
