package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0260d extends AutoCompleteTextView implements androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f3467d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f3469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0268l f3470c;

    public C0260d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9095m);
    }

    void a(C0268l c0268l) {
        KeyListener keyListener = getKeyListener();
        if (c0268l.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c0268l.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3469b;
        if (e3 != null) {
            e3.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.q(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3469b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3469b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f3470c.d(AbstractC0270n.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3469b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3469b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.r(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i3) {
        setDropDownBackgroundDrawable(p016e.a.b(getContext(), i3));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f3470c.e(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f3470c.a(keyListener));
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3468a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3469b.w(colorStateList);
        this.f3469b.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3469b.x(mode);
        this.f3469b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        E e3 = this.f3469b;
        if (e3 != null) {
            e3.q(context, i3);
        }
    }

    public C0260d(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        f0.a(this, getContext());
        j0 j0VarV = j0.v(getContext(), attributeSet, f3467d, i3, 0);
        if (j0VarV.s(0)) {
            setDropDownBackgroundDrawable(j0VarV.g(0));
        }
        j0VarV.w();
        C0261e c0261e = new C0261e(this);
        this.f3468a = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3469b = e3;
        e3.m(attributeSet, i3);
        e3.b();
        C0268l c0268l = new C0268l(this);
        this.f3470c = c0268l;
        c0268l.c(attributeSet, i3);
        a(c0268l);
    }
}
