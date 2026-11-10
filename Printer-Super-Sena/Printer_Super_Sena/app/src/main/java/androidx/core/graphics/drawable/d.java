package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, c, b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final PorterDuff.Mode f4469g = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f4471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    m f4473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f4475f;

    d(m mVar, Resources resources) {
        this.f4473d = mVar;
        e(resources);
    }

    private m d() {
        return new m(this.f4473d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        m mVar = this.f4473d;
        if (mVar == null || (constantState = mVar.f4478b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        m mVar = this.f4473d;
        ColorStateList colorStateList = mVar.f4479c;
        PorterDuff.Mode mode = mVar.f4480d;
        if (colorStateList == null || mode == null) {
            this.f4472c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f4472c || colorForState != this.f4470a || mode != this.f4471b) {
                setColorFilter(colorForState, mode);
                this.f4470a = colorForState;
                this.f4471b = mode;
                this.f4472c = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.f4475f;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f4475f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4475f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            m mVar = this.f4473d;
            if (mVar != null) {
                mVar.f4478b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f4475f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        m mVar = this.f4473d;
        return changingConfigurations | (mVar != null ? mVar.getChangingConfigurations() : 0) | this.f4475f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        m mVar = this.f4473d;
        if (mVar == null || !mVar.a()) {
            return null;
        }
        this.f4473d.f4477a = getChangingConfigurations();
        return this.f4473d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f4475f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4475f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4475f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.f4475f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f4475f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f4475f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4475f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f4475f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f4475f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f4475f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.f4475f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        m mVar;
        ColorStateList colorStateList = (!c() || (mVar = this.f4473d) == null) ? null : mVar.f4479c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f4475f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f4475f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4474e && super.mutate() == this) {
            this.f4473d = d();
            Drawable drawable = this.f4475f;
            if (drawable != null) {
                drawable.mutate();
            }
            m mVar = this.f4473d;
            if (mVar != null) {
                Drawable drawable2 = this.f4475f;
                mVar.f4478b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f4474e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4475f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return a.m(this.f4475f, i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return this.f4475f.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f4475f.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        a.j(this.f4475f, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f4475f.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4475f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z3) {
        this.f4475f.setDither(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f4475f.setFilterBitmap(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f4475f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f4473d.f4479c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4473d.f4480d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return super.setVisible(z3, z4) || this.f4475f.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f4473d = d();
        b(drawable);
    }
}
