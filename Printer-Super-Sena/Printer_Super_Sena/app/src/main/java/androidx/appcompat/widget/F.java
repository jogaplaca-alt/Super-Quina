package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class F extends TextView implements androidx.core.view.T, androidx.core.widget.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0261e f3095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E f3096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D f3097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0269m f3098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f3100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Future f3101g;

    private interface a {
        void a(int[] iArr, int i3);

        void b(TextClassifier textClassifier);

        int c();

        int[] d();

        void e(int i3);

        void f(int i3);

        TextClassifier g();

        int h();

        int i();

        void j(int i3);

        void k(int i3, int i4, int i5, int i6);

        int l();
    }

    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.F.a
        public void a(int[] iArr, int i3) {
            F.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }

        @Override // androidx.appcompat.widget.F.a
        public void b(TextClassifier textClassifier) {
            F.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.F.a
        public int c() {
            return F.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.F.a
        public int[] d() {
            return F.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.F.a
        public void e(int i3) {
        }

        @Override // androidx.appcompat.widget.F.a
        public void f(int i3) {
        }

        @Override // androidx.appcompat.widget.F.a
        public TextClassifier g() {
            return F.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.F.a
        public int h() {
            return F.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.F.a
        public int i() {
            return F.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.F.a
        public void j(int i3) {
            F.super.setAutoSizeTextTypeWithDefaults(i3);
        }

        @Override // androidx.appcompat.widget.F.a
        public void k(int i3, int i4, int i5, int i6) {
            F.super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.F.a
        public int l() {
            return F.super.getAutoSizeTextType();
        }
    }

    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.a
        public void e(int i3) {
            F.super.setLastBaselineToBottomHeight(i3);
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.a
        public void f(int i3) {
            F.super.setFirstBaselineToTopHeight(i3);
        }
    }

    public F(Context context) {
        this(context, null);
    }

    private C0269m getEmojiTextViewHelper() {
        if (this.f3098d == null) {
            this.f3098d = new C0269m(this);
        }
        return this.f3098d;
    }

    private void q() {
        Future future = this.f3101g;
        if (future != null) {
            try {
                this.f3101g = null;
                androidx.appcompat.app.H.a(future.get());
                androidx.core.widget.j.n(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            c0261e.b();
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (u0.f3627b) {
            return getSuperCaller().i();
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            return e3.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (u0.f3627b) {
            return getSuperCaller().c();
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            return e3.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (u0.f3627b) {
            return getSuperCaller().h();
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            return e3.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (u0.f3627b) {
            return getSuperCaller().d();
        }
        E e3 = this.f3096b;
        return e3 != null ? e3.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (u0.f3627b) {
            return getSuperCaller().l() == 1 ? 1 : 0;
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            return e3.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.q(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.j.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.j.c(this);
    }

    a getSuperCaller() {
        if (this.f3100f == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                this.f3100f = new c();
            } else if (i3 >= 26) {
                this.f3100f = new b();
            }
        }
        return this.f3100f;
    }

    @Override // androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            return c0261e.c();
        }
        return null;
    }

    @Override // androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            return c0261e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3096b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3096b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        D d3;
        return (Build.VERSION.SDK_INT >= 28 || (d3 = this.f3097c) == null) ? getSuperCaller().g() : d3.a();
    }

    public androidx.core.text.p.a getTextMetricsParamsCompat() {
        return androidx.core.widget.j.g(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f3096b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC0270n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.o(z3, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        q();
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        E e3 = this.f3096b;
        if (e3 == null || u0.f3627b || !e3.l()) {
            return;
        }
        this.f3096b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        if (u0.f3627b) {
            getSuperCaller().k(i3, i4, i5, i6);
            return;
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.t(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (u0.f3627b) {
            getSuperCaller().a(iArr, i3);
            return;
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.u(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (u0.f3627b) {
            getSuperCaller().j(i3);
            return;
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.v(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            c0261e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            c0261e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        E e3 = this.f3096b;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i3);
        } else {
            androidx.core.widget.j.k(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().e(i3);
        } else {
            androidx.core.widget.j.l(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i3) {
        androidx.core.widget.j.m(this, i3);
    }

    public void setPrecomputedText(androidx.core.text.p pVar) {
        androidx.core.widget.j.n(this, pVar);
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            c0261e.i(colorStateList);
        }
    }

    @Override // androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0261e c0261e = this.f3095a;
        if (c0261e != null) {
            c0261e.j(mode);
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3096b.w(colorStateList);
        this.f3096b.b();
    }

    @Override // androidx.core.widget.o
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3096b.x(mode);
        this.f3096b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        D d3;
        if (Build.VERSION.SDK_INT >= 28 || (d3 = this.f3097c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            d3.b(textClassifier);
        }
    }

    public void setTextFuture(Future<androidx.core.text.p> future) {
        this.f3101g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(androidx.core.text.p.a aVar) {
        androidx.core.widget.j.p(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (u0.f3627b) {
            super.setTextSize(i3, f3);
            return;
        }
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.A(i3, f3);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i3) {
        if (this.f3099e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i3 <= 0) ? null : androidx.core.graphics.h.a(getContext(), typeface, i3);
        this.f3099e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i3);
        } finally {
            this.f3099e = false;
        }
    }

    public F(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public F(Context context, AttributeSet attributeSet, int i3) {
        super(g0.b(context), attributeSet, i3);
        this.f3099e = false;
        this.f3100f = null;
        f0.a(this, getContext());
        C0261e c0261e = new C0261e(this);
        this.f3095a = c0261e;
        c0261e.e(attributeSet, i3);
        E e3 = new E(this);
        this.f3096b = e3;
        e3.m(attributeSet, i3);
        e3.b();
        this.f3097c = new D(this);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i3 != 0 ? p016e.a.b(context, i3) : null, i4 != 0 ? p016e.a.b(context, i4) : null, i5 != 0 ? p016e.a.b(context, i5) : null, i6 != 0 ? p016e.a.b(context, i6) : null);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? p016e.a.b(context, i3) : null, i4 != 0 ? p016e.a.b(context, i4) : null, i5 != 0 ? p016e.a.b(context, i5) : null, i6 != 0 ? p016e.a.b(context, i6) : null);
        E e3 = this.f3096b;
        if (e3 != null) {
            e3.p();
        }
    }
}
