package com.google.android.material.chip;

import A.T;
import S0.i;
import S0.j;
import S0.k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.C0262f;
import androidx.core.view.Z;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import com.google.android.material.internal.InterfaceC0496j;
import java.util.List;
import p030h1.d;
import p030h1.f;
import p042l1.h;
import p042l1.n;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends C0262f implements com.google.android.material.chip.a.InterfaceC0103a, n, Checkable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f7925w = j.f1730q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Rect f7926x = new Rect();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f7927y = {R.attr.state_selected};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f7928z = {R.attr.state_checkable};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.chip.a f7929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InsetDrawable f7930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RippleDrawable f7931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View.OnClickListener f7932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f7933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f7941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final c f7942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f7944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final RectF f7945u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final f f7946v;

    class a extends f {
        a() {
        }

        @Override // p030h1.f
        public void a(int i3) {
        }

        @Override // p030h1.f
        public void b(Typeface typeface, boolean z3) {
            Chip chip = Chip.this;
            chip.setText(chip.f7929e.I2() ? Chip.this.f7929e.d1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f7929e != null) {
                Chip.this.f7929e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends G.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // G.a
        protected int B(float f3, float f4) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f3, f4)) ? 1 : 0;
        }

        @Override // G.a
        protected void C(List list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f7932h != null) {
                list.add(1);
            }
        }

        @Override // G.a
        protected boolean J(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            if (i3 == 0) {
                return Chip.this.performClick();
            }
            if (i3 == 1) {
                return Chip.this.u();
            }
            return false;
        }

        @Override // G.a
        protected void M(T t3) {
            t3.k0(Chip.this.r());
            t3.n0(Chip.this.isClickable());
            t3.m0(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                t3.L0(text);
            } else {
                t3.q0(text);
            }
        }

        @Override // G.a
        protected void N(int i3, T t3) {
            if (i3 != 1) {
                t3.q0("");
                t3.i0(Chip.f7926x);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                t3.q0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                t3.q0(Chip.this.getContext().getString(i.f1701n, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            t3.i0(Chip.this.getCloseIconTouchBoundsInt());
            t3.b(T.a.f30i);
            t3.r0(Chip.this.isEnabled());
        }

        @Override // G.a
        protected void O(int i3, boolean z3) {
            if (i3 == 1) {
                Chip.this.f7937m = z3;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1514f);
    }

    private void A() {
        this.f7931g = new RippleDrawable(p033i1.b.e(this.f7929e.b1()), getBackgroundDrawable(), null);
        this.f7929e.H2(false);
        Z.u0(this, this.f7931g);
        B();
    }

    private void B() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f7929e) == null) {
            return;
        }
        int iF0 = (int) (aVar.F0() + this.f7929e.f1() + this.f7929e.m0());
        int iK0 = (int) (this.f7929e.K0() + this.f7929e.g1() + this.f7929e.i0());
        if (this.f7930f != null) {
            Rect rect = new Rect();
            this.f7930f.getPadding(rect);
            iK0 += rect.left;
            iF0 += rect.right;
        }
        Z.E0(this, iK0, getPaddingTop(), iF0, getPaddingBottom());
    }

    private void C() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f7946v);
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f7945u.setEmpty();
        if (n() && this.f7932h != null) {
            this.f7929e.U0(this.f7945u);
        }
        return this.f7945u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f7944t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f7944t;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    private void j(com.google.android.material.chip.a aVar) {
        aVar.l2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] k() {
        ?? IsEnabled = isEnabled();
        int i3 = IsEnabled;
        if (this.f7937m) {
            i3 = IsEnabled + 1;
        }
        int i4 = i3;
        if (this.f7936l) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (this.f7935k) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (isChecked()) {
            i6 = i5 + 1;
        }
        int[] iArr = new int[i6];
        int i7 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i7 = 1;
        }
        if (this.f7937m) {
            iArr[i7] = 16842908;
            i7++;
        }
        if (this.f7936l) {
            iArr[i7] = 16843623;
            i7++;
        }
        if (this.f7935k) {
            iArr[i7] = 16842919;
            i7++;
        }
        if (isChecked()) {
            iArr[i7] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f7930f && this.f7929e.getCallback() == null) {
            this.f7929e.setCallback(this.f7930f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.f7929e;
        return (aVar == null || aVar.N0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i3) {
        TypedArray typedArrayI = C.i(context, attributeSet, k.f1788O0, i3, f7925w, new int[0]);
        this.f7938n = typedArrayI.getBoolean(k.f1909v1, false);
        this.f7940p = (int) Math.ceil(typedArrayI.getDimension(k.f1861j1, (float) Math.ceil(F.c(getContext(), 48))));
        typedArrayI.recycle();
    }

    private void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void q(int i3, int i4, int i5, int i6) {
        this.f7930f = new InsetDrawable((Drawable) this.f7929e, i3, i4, i5, i6);
    }

    private void setCloseIconHovered(boolean z3) {
        if (this.f7936l != z3) {
            this.f7936l = z3;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z3) {
        if (this.f7935k != z3) {
            this.f7935k = z3;
            refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton compoundButton, boolean z3) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f7933i;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z3);
        }
    }

    private void v() {
        if (this.f7930f != null) {
            this.f7930f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.l2(null);
        }
    }

    private void y() {
        if (n() && s() && this.f7932h != null) {
            Z.q0(this, this.f7942r);
            this.f7943s = true;
        } else {
            Z.q0(this, null);
            this.f7943s = false;
        }
    }

    private void z() {
        if (p033i1.b.f9650a) {
            A();
            return;
        }
        this.f7929e.H2(true);
        Z.u0(this, getBackgroundDrawable());
        B();
        m();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0103a
    public void a() {
        l(this.f7940p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f7943s) {
            return this.f7942r.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f7943s) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f7942r.w(keyEvent) || this.f7942r.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.C0262f, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f7929e;
        if ((aVar == null || !aVar.l1()) ? false : this.f7929e.h2(k())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f7941q)) {
            return this.f7941q;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f7930f;
        return insetDrawable == null ? this.f7929e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.B0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.D0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.E0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f7929e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.F0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.H0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.I0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f7943s && (this.f7942r.A() == 1 || this.f7942r.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public T0.c getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.a1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public p042l1.k getShapeAppearanceModel() {
        return this.f7929e.B();
    }

    public T0.c getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.c1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.f1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public boolean l(int i3) {
        this.f7940p = i3;
        if (!w()) {
            if (this.f7930f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int iMax = Math.max(0, i3 - this.f7929e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i3 - this.f7929e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f7930f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int i4 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i5 = iMax > 0 ? iMax / 2 : 0;
        if (this.f7930f != null) {
            Rect rect = new Rect();
            this.f7930f.getPadding(rect);
            if (rect.top == i5 && rect.bottom == i5 && rect.left == i4 && rect.right == i4) {
                z();
                return true;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        q(i4, i5, i4, i5);
        z();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f7929e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7927y);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7928z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (this.f7943s) {
            this.f7942r.I(z3, i3, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i3);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f7939o != i3) {
            this.f7939o = i3;
            B();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.f7935k) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z3 = true;
                }
                z3 = false;
            } else {
                if (this.f7935k) {
                    u();
                    z3 = true;
                }
                setCloseIconPressed(false);
            }
            z3 = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z3 = true;
        } else {
            z3 = false;
        }
        return z3 || super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f7929e;
        return aVar != null && aVar.k1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f7929e;
        return aVar != null && aVar.m1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f7941q = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7931g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.C0262f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7931g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.C0262f, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.t1(z3);
        }
    }

    public void setCheckableResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.u1(i3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar == null) {
            this.f7934j = z3;
        } else if (aVar.k1()) {
            super.setChecked(z3);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.v1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.w1(i3);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.x1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.y1(i3);
        }
    }

    public void setCheckedIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.z1(i3);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.B1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.C1(i3);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.D1(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.E1(i3);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f7929e;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f7929e = aVar;
            aVar.w2(false);
            j(this.f7929e);
            l(this.f7940p);
        }
    }

    public void setChipEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.F1(f3);
        }
    }

    public void setChipEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.G1(i3);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.H1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.I1(i3);
        }
    }

    public void setChipIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.J1(f3);
        }
    }

    public void setChipIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.K1(i3);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.L1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.M1(i3);
        }
    }

    public void setChipIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.N1(i3);
        }
    }

    public void setChipMinHeight(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.P1(f3);
        }
    }

    public void setChipMinHeightResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.Q1(i3);
        }
    }

    public void setChipStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.R1(f3);
        }
    }

    public void setChipStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.S1(i3);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.T1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.U1(i3);
        }
    }

    public void setChipStrokeWidth(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.V1(f3);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.W1(i3);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.Y1(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.Z1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.a2(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.b2(i3);
        }
    }

    public void setCloseIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.c2(i3);
        }
        y();
    }

    public void setCloseIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.d2(f3);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.e2(i3);
        }
    }

    public void setCloseIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.f2(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.g2(i3);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.i2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.j2(i3);
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // androidx.appcompat.widget.C0262f, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.C0262f, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.U(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f7929e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.m2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z3) {
        this.f7938n = z3;
        l(this.f7940p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(T0.c cVar) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.n2(cVar);
        }
    }

    public void setHideMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.o2(i3);
        }
    }

    public void setIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.p2(f3);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.q2(i3);
        }
    }

    public void setIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.r2(f3);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.s2(i3);
        }
    }

    public void setInternalOnCheckedChangeListener(InterfaceC0496j interfaceC0496j) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f7929e == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.t2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i3);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f7933i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f7932h = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.u2(colorStateList);
        }
        if (this.f7929e.i1()) {
            return;
        }
        A();
    }

    public void setRippleColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.v2(i3);
            if (this.f7929e.i1()) {
                return;
            }
            A();
        }
    }

    @Override // p042l1.n
    public void setShapeAppearanceModel(p042l1.k kVar) {
        this.f7929e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(T0.c cVar) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.x2(cVar);
        }
    }

    public void setShowMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.y2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        if (!z3) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z3);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.I2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f7929e;
        if (aVar2 != null) {
            aVar2.z2(charSequence);
        }
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.A2(dVar);
        }
        C();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.C2(f3);
        }
    }

    public void setTextEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.D2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        super.setTextSize(i3, f3);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.E2(TypedValue.applyDimension(i3, f3, getResources().getDisplayMetrics()));
        }
        C();
    }

    public void setTextStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.F2(f3);
        }
    }

    public void setTextStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.G2(i3);
        }
    }

    public boolean u() {
        boolean z3 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f7932h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z3 = true;
        }
        if (this.f7943s) {
            this.f7942r.U(1, 1);
        }
        return z3;
    }

    public boolean w() {
        return this.f7938n;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f7925w;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f7944t = new Rect();
        this.f7945u = new RectF();
        this.f7946v = new a();
        Context context2 = getContext();
        D(attributeSet);
        com.google.android.material.chip.a aVarR0 = com.google.android.material.chip.a.r0(context2, attributeSet, i3, i4);
        o(context2, attributeSet, i3);
        setChipDrawable(aVarR0);
        aVarR0.U(Z.w(this));
        TypedArray typedArrayI = C.i(context2, attributeSet, k.f1788O0, i3, i4, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(p030h1.c.a(context2, typedArrayI, k.f1797R0));
        }
        boolean zHasValue = typedArrayI.hasValue(k.f1740A1);
        typedArrayI.recycle();
        this.f7942r = new c(this);
        y();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f7934j);
        setText(aVarR0.d1());
        setEllipsize(aVarR0.X0());
        C();
        if (!this.f7929e.I2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        B();
        if (w()) {
            setMinHeight(this.f7940p);
        }
        this.f7939o = Z.C(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: Z0.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f2175a.t(compoundButton, z3);
            }
        });
    }

    public void setCloseIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.k2(z3);
        }
        y();
    }

    public void setCheckedIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.A1(z3);
        }
    }

    public void setChipIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.O1(z3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.B2(i3);
        }
        C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        com.google.android.material.chip.a aVar = this.f7929e;
        if (aVar != null) {
            aVar.B2(i3);
        }
        C();
    }
}
