package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f3059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0269m f3060c;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9096n);
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3060c == null) {
            this.f3060c = new C0269m(this);
        }
        return this.f3060c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (u0.f3627b) {
            return super.getAutoSizeMaxTextSize();
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            return e3.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (u0.f3627b) {
            return super.getAutoSizeMinTextSize();
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            return e3.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (u0.f3627b) {
            return super.getAutoSizeStepGranularity();
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            return e3.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (u0.f3627b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        E e3 = this.f3059b;
        return e3 != null ? e3.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (u0.f3627b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            return e3.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.q(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3059b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3059b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.o(z3, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        E e3 = this.f3059b;
        if (e3 == null || u0.f3627b || !e3.l()) {
            return;
        }
        this.f3059b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        if (u0.f3627b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
            return;
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.t(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (u0.f3627b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
            return;
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.u(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (u0.f3627b) {
            super.setAutoSizeTextTypeWithDefaults(i3);
            return;
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.v(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z3) {
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.s(z3);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3058a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3059b.w(colorStateList);
        this.f3059b.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3059b.x(mode);
        this.f3059b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (u0.f3627b) {
            super.setTextSize(i3, f3);
            return;
        }
        E e3 = this.f3059b;
        if (e3 != null) {
            e3.A(i3, f3);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        f0.a(this, getContext());
        C0261e c0261e = new C0261e(this);
        this.f3058a = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3059b = e3;
        e3.m(attributeSet, i3);
        e3.b();
        getEmojiTextViewHelper().c(attributeSet, i3);
    }
}
