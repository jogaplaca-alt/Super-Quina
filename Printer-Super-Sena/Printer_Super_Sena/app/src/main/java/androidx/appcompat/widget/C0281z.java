package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0281z extends C0276u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f3634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f3635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f3636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f3637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3639i;

    C0281z(SeekBar seekBar) {
        super(seekBar);
        this.f3636f = null;
        this.f3637g = null;
        this.f3638h = false;
        this.f3639i = false;
        this.f3634d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f3635e;
        if (drawable != null) {
            if (this.f3638h || this.f3639i) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
                this.f3635e = drawableR;
                if (this.f3638h) {
                    androidx.core.graphics.drawable.a.o(drawableR, this.f3636f);
                }
                if (this.f3639i) {
                    androidx.core.graphics.drawable.a.p(this.f3635e, this.f3637g);
                }
                if (this.f3635e.isStateful()) {
                    this.f3635e.setState(this.f3634d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0276u
    void c(AttributeSet attributeSet, int i3) {
        super.c(attributeSet, i3);
        Context context = this.f3634d.getContext();
        int[] iArr = p012d.j.f9321T;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        SeekBar seekBar = this.f3634d;
        androidx.core.view.Z.o0(seekBar, seekBar.getContext(), iArr, attributeSet, j0VarV.r(), i3, 0);
        Drawable drawableH = j0VarV.h(p012d.j.f9324U);
        if (drawableH != null) {
            this.f3634d.setThumb(drawableH);
        }
        j(j0VarV.g(p012d.j.f9327V));
        int i4 = p012d.j.f9333X;
        if (j0VarV.s(i4)) {
            this.f3637g = S.e(j0VarV.k(i4, -1), this.f3637g);
            this.f3639i = true;
        }
        int i5 = p012d.j.f9330W;
        if (j0VarV.s(i5)) {
            this.f3636f = j0VarV.c(i5);
            this.f3638h = true;
        }
        j0VarV.w();
        f();
    }

    void g(Canvas canvas) {
        if (this.f3635e != null) {
            int max = this.f3634d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f3635e.getIntrinsicWidth();
                int intrinsicHeight = this.f3635e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f3635e.setBounds(-i3, -i4, i3, i4);
                float width = ((this.f3634d.getWidth() - this.f3634d.getPaddingLeft()) - this.f3634d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f3634d.getPaddingLeft(), this.f3634d.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f3635e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f3635e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f3634d.getDrawableState())) {
            this.f3634d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f3635e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f3635e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3635e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f3634d);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.view.Z.C(this.f3634d));
            if (drawable.isStateful()) {
                drawable.setState(this.f3634d.getDrawableState());
            }
            f();
        }
        this.f3634d.invalidate();
    }
}
