package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.C0288d;

/* JADX INFO: renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0267k extends EditText implements androidx.core.view.T, androidx.core.view.K, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f3548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D f3549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.widget.l f3550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0268l f3551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f3552f;

    /* JADX INFO: renamed from: androidx.appcompat.widget.k$a */
    class a {
        a() {
        }

        public TextClassifier a() {
            return C0267k.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            C0267k.super.setTextClassifier(textClassifier);
        }
    }

    public C0267k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9068A);
    }

    private a getSuperCaller() {
        if (this.f3552f == null) {
            this.f3552f = new a();
        }
        return this.f3552f;
    }

    @Override // androidx.core.view.K
    public C0288d a(C0288d c0288d) {
        return this.f3550d.a(this, c0288d);
    }

    void d(C0268l c0268l) {
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
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3548b;
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
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3548b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3548b.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        D d3;
        return (Build.VERSION.SDK_INT >= 28 || (d3 = this.f3549c) == null) ? getSuperCaller().a() : d3.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrF;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f3548b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AbstractC0270n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrF = androidx.core.view.Z.F(this)) != null) {
            D.c.d(editorInfo, strArrF);
            inputConnectionA = D.e.c(this, inputConnectionA, editorInfo);
        }
        return this.f3551e.d(inputConnectionA, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC0279x.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (AbstractC0279x.b(this, i3)) {
            return true;
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3548b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3548b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f3551e.e(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f3551e.a(keyListener));
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3547a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3548b.w(colorStateList);
        this.f3548b.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3548b.x(mode);
        this.f3548b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        E e3 = this.f3548b;
        if (e3 != null) {
            e3.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        D d3;
        if (Build.VERSION.SDK_INT >= 28 || (d3 = this.f3549c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            d3.b(textClassifier);
        }
    }

    public C0267k(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        f0.a(this, getContext());
        C0261e c0261e = new C0261e(this);
        this.f3547a = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3548b = e3;
        e3.m(attributeSet, i3);
        e3.b();
        this.f3549c = new D(this);
        this.f3550d = new androidx.core.widget.l();
        C0268l c0268l = new C0268l(this);
        this.f3551e = c0268l;
        c0268l.c(attributeSet, i3);
        d(c0268l);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
