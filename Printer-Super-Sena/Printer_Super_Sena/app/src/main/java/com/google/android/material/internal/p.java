package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f8334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Rect f8335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f8336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8340g;

    class a implements androidx.core.view.I {
        a() {
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            p pVar = p.this;
            if (pVar.f8335b == null) {
                pVar.f8335b = new Rect();
            }
            p.this.f8335b.set(c0332z0.j(), c0332z0.l(), c0332z0.k(), c0332z0.i());
            p.this.e(c0332z0);
            p.this.setWillNotDraw(!c0332z0.n() || p.this.f8334a == null);
            Z.h0(p.this);
            return c0332z0.c();
        }
    }

    public p(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8336c = new Rect();
        this.f8337d = true;
        this.f8338e = true;
        this.f8339f = true;
        this.f8340g = true;
        TypedArray typedArrayI = C.i(context, attributeSet, S0.k.y5, i3, S0.j.f1722i, new int[0]);
        this.f8334a = typedArrayI.getDrawable(S0.k.z5);
        typedArrayI.recycle();
        setWillNotDraw(true);
        Z.D0(this, new a());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f8335b == null || this.f8334a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f8337d) {
            this.f8336c.set(0, 0, width, this.f8335b.top);
            this.f8334a.setBounds(this.f8336c);
            this.f8334a.draw(canvas);
        }
        if (this.f8338e) {
            this.f8336c.set(0, height - this.f8335b.bottom, width, height);
            this.f8334a.setBounds(this.f8336c);
            this.f8334a.draw(canvas);
        }
        if (this.f8339f) {
            Rect rect = this.f8336c;
            Rect rect2 = this.f8335b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f8334a.setBounds(this.f8336c);
            this.f8334a.draw(canvas);
        }
        if (this.f8340g) {
            Rect rect3 = this.f8336c;
            Rect rect4 = this.f8335b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f8334a.setBounds(this.f8336c);
            this.f8334a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    protected abstract void e(C0332z0 c0332z0);

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f8334a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f8334a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z3) {
        this.f8338e = z3;
    }

    public void setDrawLeftInsetForeground(boolean z3) {
        this.f8339f = z3;
    }

    public void setDrawRightInsetForeground(boolean z3) {
        this.f8340g = z3;
    }

    public void setDrawTopInsetForeground(boolean z3) {
        this.f8337d = z3;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f8334a = drawable;
    }
}
