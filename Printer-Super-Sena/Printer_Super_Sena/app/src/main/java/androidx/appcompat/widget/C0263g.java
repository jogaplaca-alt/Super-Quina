package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0263g extends CheckedTextView implements androidx.core.widget.m, androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0264h f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0261e f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final E f3512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0269m f3513d;

    public C0263g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9098p);
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3513d == null) {
            this.f3513d = new C0269m(this);
        }
        return this.f3513d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        E e3 = this.f3512c;
        if (e3 != null) {
            e3.b();
        }
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            c0261e.b();
        }
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            c0264h.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.q(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            return c0264h.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            return c0264h.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3512c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3512c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC0270n.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            c0264h.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3512c;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3512c;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3511b;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            c0264h.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0264h c0264h = this.f3510a;
        if (c0264h != null) {
            c0264h.g(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3512c.w(colorStateList);
        this.f3512c.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3512c.x(mode);
        this.f3512c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        E e3 = this.f3512c;
        if (e3 != null) {
            e3.q(context, i3);
        }
    }

    public C0263g(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        f0.a(this, getContext());
        E e3 = new E(this);
        this.f3512c = e3;
        e3.m(attributeSet, i3);
        e3.b();
        C0261e c0261e = new C0261e(this);
        this.f3511b = c0261e;
        c0261e.e(attributeSet, i3);
        C0264h c0264h = new C0264h(this);
        this.f3510a = c0264h;
        c0264h.d(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(p016e.a.b(getContext(), i3));
    }
}
