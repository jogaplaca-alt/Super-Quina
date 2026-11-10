package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: renamed from: androidx.appcompat.widget.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0277v extends RadioButton implements androidx.core.widget.n, androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0265i f3628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0261e f3629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final E f3630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0269m f3631d;

    public C0277v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9074G);
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3631d == null) {
            this.f3631d = new C0269m(this);
        }
        return this.f3631d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3630c;
        if (e3 != null) {
            e3.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0265i c0265i = this.f3628a;
        return c0265i != null ? c0265i.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportButtonTintList() {
        C0265i c0265i = this.f3628a;
        if (c0265i != null) {
            return c0265i.c();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportButtonTintMode() {
        C0265i c0265i = this.f3628a;
        if (c0265i != null) {
            return c0265i.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3630c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3630c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0265i c0265i = this.f3628a;
        if (c0265i != null) {
            c0265i.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3630c;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3630c;
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
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3629b;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0265i c0265i = this.f3628a;
        if (c0265i != null) {
            c0265i.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0265i c0265i = this.f3628a;
        if (c0265i != null) {
            c0265i.h(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3630c.w(colorStateList);
        this.f3630c.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3630c.x(mode);
        this.f3630c.b();
    }

    public C0277v(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        f0.a(this, getContext());
        C0265i c0265i = new C0265i(this);
        this.f3628a = c0265i;
        c0265i.e(attributeSet, i3);
        C0261e c0261e = new C0261e(this);
        this.f3629b = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3630c = e3;
        e3.m(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(p016e.a.b(getContext(), i3));
    }
}
