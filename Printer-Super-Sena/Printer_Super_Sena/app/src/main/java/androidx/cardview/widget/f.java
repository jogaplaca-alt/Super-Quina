package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3653a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f3655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f3656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3657e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f3660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f3661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f3662j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3658f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3659g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f3663k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f3654b = new Paint(5);

    f(ColorStateList colorStateList, float f3) {
        this.f3653a = f3;
        e(colorStateList);
        this.f3655c = new RectF();
        this.f3656d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3660h = colorStateList;
        this.f3654b.setColor(colorStateList.getColorForState(getState(), this.f3660h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3655c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f3656d.set(rect);
        if (this.f3658f) {
            this.f3656d.inset((int) Math.ceil(g.c(this.f3657e, this.f3653a, this.f3659g)), (int) Math.ceil(g.d(this.f3657e, this.f3653a, this.f3659g)));
            this.f3655c.set(this.f3656d);
        }
    }

    public ColorStateList b() {
        return this.f3660h;
    }

    float c() {
        return this.f3657e;
    }

    public float d() {
        return this.f3653a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z3;
        Paint paint = this.f3654b;
        if (this.f3661i == null || paint.getColorFilter() != null) {
            z3 = false;
        } else {
            paint.setColorFilter(this.f3661i);
            z3 = true;
        }
        RectF rectF = this.f3655c;
        float f3 = this.f3653a;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (z3) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f3, boolean z3, boolean z4) {
        if (f3 == this.f3657e && this.f3658f == z3 && this.f3659g == z4) {
            return;
        }
        this.f3657e = f3;
        this.f3658f = z3;
        this.f3659g = z4;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3656d, this.f3653a);
    }

    void h(float f3) {
        if (f3 == this.f3653a) {
            return;
        }
        this.f3653a = f3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3662j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3660h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3660h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z3 = colorForState != this.f3654b.getColor();
        if (z3) {
            this.f3654b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3662j;
        if (colorStateList2 == null || (mode = this.f3663k) == null) {
            return z3;
        }
        this.f3661i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f3654b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3654b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f3662j = colorStateList;
        this.f3661i = a(colorStateList, this.f3663k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3663k = mode;
        this.f3661i = a(this.f3662j, mode);
        invalidateSelf();
    }
}
