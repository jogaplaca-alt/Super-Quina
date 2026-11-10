package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class g extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double f3664q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static a f3665r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3666a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f3668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f3669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f3670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f3672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f3676k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f3678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f3679n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3677l = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3680o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f3681p = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f3667b = new Paint(5);

    interface a {
        void a(Canvas canvas, RectF rectF, float f3, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f3, float f4, float f5) {
        this.f3678m = resources.getColor(p040l.b.f9776d);
        this.f3679n = resources.getColor(p040l.b.f9775c);
        this.f3666a = resources.getDimensionPixelSize(p040l.c.f9777a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f3668c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3671f = (int) (f3 + 0.5f);
        this.f3670e = new RectF();
        Paint paint2 = new Paint(this.f3668c);
        this.f3669d = paint2;
        paint2.setAntiAlias(false);
        s(f4, f5);
    }

    private void a(Rect rect) {
        float f3 = this.f3673h;
        float f4 = 1.5f * f3;
        this.f3670e.set(rect.left + f3, rect.top + f4, rect.right - f3, rect.bottom - f4);
        b();
    }

    private void b() {
        float f3 = this.f3671f;
        RectF rectF = new RectF(-f3, -f3, f3, f3);
        RectF rectF2 = new RectF(rectF);
        float f4 = this.f3674i;
        rectF2.inset(-f4, -f4);
        Path path = this.f3672g;
        if (path == null) {
            this.f3672g = new Path();
        } else {
            path.reset();
        }
        this.f3672g.setFillType(Path.FillType.EVEN_ODD);
        this.f3672g.moveTo(-this.f3671f, 0.0f);
        this.f3672g.rLineTo(-this.f3674i, 0.0f);
        this.f3672g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f3672g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f3672g.close();
        float f5 = this.f3671f;
        float f6 = f5 / (this.f3674i + f5);
        Paint paint = this.f3668c;
        float f7 = this.f3671f + this.f3674i;
        int i3 = this.f3678m;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{i3, i3, this.f3679n}, new float[]{0.0f, f6, 1.0f}, tileMode));
        Paint paint2 = this.f3669d;
        float f8 = this.f3671f;
        float f9 = this.f3674i;
        float f10 = (-f8) + f9;
        float f11 = (-f8) - f9;
        int i4 = this.f3678m;
        paint2.setShader(new LinearGradient(0.0f, f10, 0.0f, f11, new int[]{i4, i4, this.f3679n}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.f3669d.setAntiAlias(false);
    }

    static float c(float f3, float f4, boolean z3) {
        if (!z3) {
            return f3;
        }
        double d3 = f3;
        double d4 = 1.0d - f3664q;
        double d5 = f4;
        Double.isNaN(d5);
        Double.isNaN(d3);
        return (float) (d3 + (d4 * d5));
    }

    static float d(float f3, float f4, boolean z3) {
        if (!z3) {
            return f3 * 1.5f;
        }
        double d3 = f3 * 1.5f;
        double d4 = 1.0d - f3664q;
        double d5 = f4;
        Double.isNaN(d5);
        Double.isNaN(d3);
        return (float) (d3 + (d4 * d5));
    }

    private void e(Canvas canvas) {
        float f3 = this.f3671f;
        float f4 = (-f3) - this.f3674i;
        float f5 = f3 + this.f3666a + (this.f3675j / 2.0f);
        float f6 = f5 * 2.0f;
        boolean z3 = this.f3670e.width() - f6 > 0.0f;
        boolean z4 = this.f3670e.height() - f6 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f3670e;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.drawPath(this.f3672g, this.f3668c);
        if (z3) {
            canvas.drawRect(0.0f, f4, this.f3670e.width() - f6, -this.f3671f, this.f3669d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f3670e;
        canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f3672g, this.f3668c);
        if (z3) {
            canvas.drawRect(0.0f, f4, this.f3670e.width() - f6, (-this.f3671f) + this.f3674i, this.f3669d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f3670e;
        canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f3672g, this.f3668c);
        if (z4) {
            canvas.drawRect(0.0f, f4, this.f3670e.height() - f6, -this.f3671f, this.f3669d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f3670e;
        canvas.translate(rectF4.right - f5, rectF4.top + f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f3672g, this.f3668c);
        if (z4) {
            canvas.drawRect(0.0f, f4, this.f3670e.height() - f6, -this.f3671f, this.f3669d);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3676k = colorStateList;
        this.f3667b.setColor(colorStateList.getColorForState(getState(), this.f3676k.getDefaultColor()));
    }

    private void s(float f3, float f4) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f3 + ". Must be >= 0");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f4 + ". Must be >= 0");
        }
        float fT = t(f3);
        float fT2 = t(f4);
        if (fT > fT2) {
            if (!this.f3681p) {
                this.f3681p = true;
            }
            fT = fT2;
        }
        if (this.f3675j == fT && this.f3673h == fT2) {
            return;
        }
        this.f3675j = fT;
        this.f3673h = fT2;
        this.f3674i = (int) ((fT * 1.5f) + this.f3666a + 0.5f);
        this.f3677l = true;
        invalidateSelf();
    }

    private int t(float f3) {
        int i3 = (int) (f3 + 0.5f);
        return i3 % 2 == 1 ? i3 - 1 : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3677l) {
            a(getBounds());
            this.f3677l = false;
        }
        canvas.translate(0.0f, this.f3675j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f3675j) / 2.0f);
        f3665r.a(canvas, this.f3670e, this.f3671f, this.f3667b);
    }

    ColorStateList f() {
        return this.f3676k;
    }

    float g() {
        return this.f3671f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f3673h, this.f3671f, this.f3680o));
        int iCeil2 = (int) Math.ceil(c(this.f3673h, this.f3671f, this.f3680o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f3673h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f3676k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f3 = this.f3673h;
        return (Math.max(f3, this.f3671f + this.f3666a + ((f3 * 1.5f) / 2.0f)) * 2.0f) + (((this.f3673h * 1.5f) + this.f3666a) * 2.0f);
    }

    float k() {
        float f3 = this.f3673h;
        return (Math.max(f3, this.f3671f + this.f3666a + (f3 / 2.0f)) * 2.0f) + ((this.f3673h + this.f3666a) * 2.0f);
    }

    float l() {
        return this.f3675j;
    }

    void m(boolean z3) {
        this.f3680o = z3;
        invalidateSelf();
    }

    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3677l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f3676k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f3667b.getColor() == colorForState) {
            return false;
        }
        this.f3667b.setColor(colorForState);
        this.f3677l = true;
        invalidateSelf();
        return true;
    }

    void p(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f3 + ". Must be >= 0");
        }
        float f4 = (int) (f3 + 0.5f);
        if (this.f3671f == f4) {
            return;
        }
        this.f3671f = f4;
        this.f3677l = true;
        invalidateSelf();
    }

    void q(float f3) {
        s(this.f3675j, f3);
    }

    void r(float f3) {
        s(f3, this.f3673h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f3667b.setAlpha(i3);
        this.f3668c.setAlpha(i3);
        this.f3669d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3667b.setColorFilter(colorFilter);
    }
}
