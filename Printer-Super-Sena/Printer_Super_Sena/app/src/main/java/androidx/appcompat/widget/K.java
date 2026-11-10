package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes.dex */
public class K extends ToggleButton implements androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f3121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0269m f3122c;

    public K(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3122c == null) {
            this.f3122c = new C0269m(this);
        }
        return this.f3122c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3121b;
        if (e3 != null) {
            e3.b();
        }
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3121b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3121b.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3121b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3121b;
        if (e3 != null) {
            e3.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3120a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3121b.w(colorStateList);
        this.f3121b.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3121b.x(mode);
        this.f3121b.b();
    }

    public K(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f0.a(this, getContext());
        C0261e c0261e = new C0261e(this);
        this.f3120a = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3121b = e3;
        e3.m(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }
}
