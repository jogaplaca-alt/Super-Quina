package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0271o extends ImageButton implements androidx.core.view.T, androidx.core.widget.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0273q f3584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3585c;

    public C0271o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9070C);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            c0261e.b();
        }
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            c0273q.c();
        }
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    @Override // androidx.core.widget.p
    public ColorStateList getSupportImageTintList() {
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            return c0273q.d();
        }
        return null;
    }

    @Override // androidx.core.widget.p
    public PorterDuff.Mode getSupportImageTintMode() {
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            return c0273q.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f3584b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            c0273q.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0273q c0273q = this.f3584b;
        if (c0273q != null && drawable != null && !this.f3585c) {
            c0273q.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0273q c0273q2 = this.f3584b;
        if (c0273q2 != null) {
            c0273q2.c();
            if (this.f3585c) {
                return;
            }
            this.f3584b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i3) {
        super.setImageLevel(i3);
        this.f3585c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f3584b.i(i3);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            c0273q.c();
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3583a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.p
    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            c0273q.j(colorStateList);
        }
    }

    @Override // androidx.core.widget.p
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0273q c0273q = this.f3584b;
        if (c0273q != null) {
            c0273q.k(mode);
        }
    }

    public C0271o(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        this.f3585c = false;
        f0.a(this, getContext());
        C0261e c0261e = new C0261e(this);
        this.f3583a = c0261e;
        c0261e.e(attributeSet, i3);
        C0273q c0273q = new C0273q(this);
        this.f3584b = c0273q;
        c0273q.g(attributeSet, i3);
    }
}
