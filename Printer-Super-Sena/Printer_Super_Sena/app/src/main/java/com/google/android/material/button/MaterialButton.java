package com.google.android.material.button;

import S0.j;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.app.H;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.Z;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p042l1.h;
import p042l1.k;
import p042l1.n;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, n {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f7798r = {R.attr.state_checkable};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f7799s = {R.attr.state_checked};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f7800t = j.f1729p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f7801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet f7802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f7803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f7804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f7805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f7806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7814q;

    interface a {
        void a(MaterialButton materialButton, boolean z3);
    }

    static class b extends F.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7815c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void d(Parcel parcel) {
            this.f7815c = parcel.readInt() == 1;
        }

        @Override // F.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f7815c ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            d(parcel);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1528t);
    }

    private boolean b() {
        int i3 = this.f7814q;
        return i3 == 3 || i3 == 4;
    }

    private boolean c() {
        int i3 = this.f7814q;
        return i3 == 1 || i3 == 2;
    }

    private boolean d() {
        int i3 = this.f7814q;
        return i3 == 16 || i3 == 32;
    }

    private boolean e() {
        return Z.C(this) == 1;
    }

    private boolean f() {
        c cVar = this.f7801d;
        return (cVar == null || cVar.o()) ? false : true;
    }

    private void g() {
        if (c()) {
            androidx.core.widget.j.j(this, this.f7806i, null, null, null);
        } else if (b()) {
            androidx.core.widget.j.j(this, null, null, this.f7806i, null);
        } else if (d()) {
            androidx.core.widget.j.j(this, null, this.f7806i, null, null);
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            return (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < lineCount; i3++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i3));
        }
        return (int) Math.ceil(fMax);
    }

    private void h(boolean z3) {
        Drawable drawable = this.f7806i;
        if (drawable != null) {
            Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f7806i = drawableMutate;
            androidx.core.graphics.drawable.a.o(drawableMutate, this.f7805h);
            PorterDuff.Mode mode = this.f7804g;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f7806i, mode);
            }
            int intrinsicWidth = this.f7808k;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f7806i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f7808k;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f7806i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f7806i;
            int i3 = this.f7809l;
            int i4 = this.f7810m;
            drawable2.setBounds(i3, i4, intrinsicWidth + i3, intrinsicHeight + i4);
            this.f7806i.setVisible(true, z3);
        }
        if (z3) {
            g();
            return;
        }
        Drawable[] drawableArrA = androidx.core.widget.j.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[1];
        Drawable drawable5 = drawableArrA[2];
        if ((!c() || drawable3 == this.f7806i) && ((!b() || drawable5 == this.f7806i) && (!d() || drawable4 == this.f7806i))) {
            return;
        }
        g();
    }

    private void i(int i3, int i4) {
        if (this.f7806i == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f7809l = 0;
                if (this.f7814q == 16) {
                    this.f7810m = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f7808k;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f7806i.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i4 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f7811n) - getPaddingBottom()) / 2);
                if (this.f7810m != iMax) {
                    this.f7810m = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f7810m = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.f7814q;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f7809l = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f7808k;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f7806i.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i3 - getTextLayoutWidth()) - Z.G(this)) - intrinsicWidth) - this.f7811n) - Z.H(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (e() != (this.f7814q == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f7809l != textLayoutWidth) {
            this.f7809l = textLayoutWidth;
            h(false);
        }
    }

    public boolean a() {
        c cVar = this.f7801d;
        return cVar != null && cVar.p();
    }

    String getA11yClassName() {
        if (TextUtils.isEmpty(this.f7807j)) {
            return (a() ? CompoundButton.class : Button.class).getName();
        }
        return this.f7807j;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f7801d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f7806i;
    }

    public int getIconGravity() {
        return this.f7814q;
    }

    public int getIconPadding() {
        return this.f7811n;
    }

    public int getIconSize() {
        return this.f7808k;
    }

    public ColorStateList getIconTint() {
        return this.f7805h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f7804g;
    }

    public int getInsetBottom() {
        return this.f7801d.c();
    }

    public int getInsetTop() {
        return this.f7801d.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f7801d.h();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        if (f()) {
            return this.f7801d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f7801d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f7801d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.T
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f7801d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.T
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f7801d.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f7812o;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.f(this, this.f7801d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7798r);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7799s);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        c cVar;
        super.onLayout(z3, i3, i4, i5, i6);
        if (Build.VERSION.SDK_INT == 21 && (cVar = this.f7801d) != null) {
            cVar.J(i6 - i4, i5 - i3);
        }
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.c());
        setChecked(bVar.f7815c);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f7815c = this.f7812o;
        return bVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f7801d.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f7806i != null) {
            if (this.f7806i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    void setA11yClassName(String str) {
        this.f7807j = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (f()) {
            this.f7801d.s(i3);
        } else {
            super.setBackgroundColor(i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f7801d.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z3) {
        if (f()) {
            this.f7801d.u(z3);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (a() && isEnabled() && this.f7812o != z3) {
            this.f7812o = z3;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f7812o);
            }
            if (this.f7813p) {
                return;
            }
            this.f7813p = true;
            Iterator it = this.f7802e.iterator();
            if (it.hasNext()) {
                H.a(it.next());
                throw null;
            }
            this.f7813p = false;
        }
    }

    public void setCornerRadius(int i3) {
        if (f()) {
            this.f7801d.v(i3);
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (f()) {
            this.f7801d.f().U(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f7806i != drawable) {
            this.f7806i = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f7814q != i3) {
            this.f7814q = i3;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f7811n != i3) {
            this.f7811n = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? p016e.a.b(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f7808k != i3) {
            this.f7808k = i3;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f7805h != colorStateList) {
            this.f7805h = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f7804g != mode) {
            this.f7804g = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(p016e.a.a(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        this.f7801d.w(i3);
    }

    public void setInsetTop(int i3) {
        this.f7801d.x(i3);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(a aVar) {
        this.f7803f = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        a aVar = this.f7803f;
        if (aVar != null) {
            aVar.a(this, z3);
        }
        super.setPressed(z3);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f7801d.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i3) {
        if (f()) {
            setRippleColor(p016e.a.a(getContext(), i3));
        }
    }

    @Override // p042l1.n
    public void setShapeAppearanceModel(k kVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f7801d.z(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z3) {
        if (f()) {
            this.f7801d.A(z3);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f7801d.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i3) {
        if (f()) {
            setStrokeColor(p016e.a.a(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (f()) {
            this.f7801d.C(i3);
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.T
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f7801d.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.T
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f7801d.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z3) {
        this.f7801d.F(z3);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f7812o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f7800t;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f7802e = new LinkedHashSet();
        this.f7812o = false;
        this.f7813p = false;
        Context context2 = getContext();
        TypedArray typedArrayI = C.i(context2, attributeSet, S0.k.O2, i3, i4, new int[0]);
        this.f7811n = typedArrayI.getDimensionPixelSize(S0.k.b3, 0);
        this.f7804g = F.i(typedArrayI.getInt(S0.k.e3, -1), PorterDuff.Mode.SRC_IN);
        this.f7805h = p030h1.c.a(getContext(), typedArrayI, S0.k.d3);
        this.f7806i = p030h1.c.d(getContext(), typedArrayI, S0.k.Z2);
        this.f7814q = typedArrayI.getInteger(S0.k.a3, 1);
        this.f7808k = typedArrayI.getDimensionPixelSize(S0.k.c3, 0);
        c cVar = new c(this, k.e(context2, attributeSet, i3, i4).m());
        this.f7801d = cVar;
        cVar.r(typedArrayI);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f7811n);
        h(this.f7806i != null);
    }
}
