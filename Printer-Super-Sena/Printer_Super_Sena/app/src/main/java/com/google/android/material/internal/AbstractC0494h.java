package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.W;

/* JADX INFO: renamed from: com.google.android.material.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0494h extends W {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f8285p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f8286q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f8287r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8288s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f8289t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f8290u;

    public AbstractC0494h(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8286q = new Rect();
        this.f8287r = new Rect();
        this.f8288s = 119;
        this.f8289t = true;
        this.f8290u = false;
        TypedArray typedArrayI = C.i(context, attributeSet, S0.k.f1866k2, i3, 0, new int[0]);
        this.f8288s = typedArrayI.getInt(S0.k.f1874m2, this.f8288s);
        Drawable drawable = typedArrayI.getDrawable(S0.k.f1870l2);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f8289t = typedArrayI.getBoolean(S0.k.f1878n2, true);
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f8285p;
        if (drawable != null) {
            if (this.f8290u) {
                this.f8290u = false;
                Rect rect = this.f8286q;
                Rect rect2 = this.f8287r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f8289t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f8288s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f8285p;
        if (drawable != null) {
            drawable.setHotspot(f3, f4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8285p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f8285p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f8285p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f8288s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8285p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.W, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f8290u = z3 | this.f8290u;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f8290u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f8285p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f8285p);
            }
            this.f8285p = drawable;
            this.f8290u = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f8288s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f8288s != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f8288s = i3;
            if (i3 == 119 && this.f8285p != null) {
                this.f8285p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8285p;
    }
}
