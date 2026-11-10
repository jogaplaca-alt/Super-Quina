package Y0;

import S0.j;
import S0.k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.app.H;
import androidx.appcompat.widget.C0262f;
import androidx.appcompat.widget.j0;
import com.google.android.material.internal.C;
import com.google.android.material.internal.F;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class i extends C0262f {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final int[] f2123A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final int[][] f2124B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final int f2125C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f2126y = j.f1731r;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f2127z = {S0.a.f1499Q};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet f2128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedHashSet f2129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f2130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f2134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f2135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f2136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ColorStateList f2138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ColorStateList f2139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f2140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2141r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f2142s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CharSequence f2144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f2145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.i f2146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f2147x;

    class a extends androidx.vectordrawable.graphics.drawable.b {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = i.this.f2138o;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void c(Drawable drawable) {
            super.c(drawable);
            i iVar = i.this;
            ColorStateList colorStateList = iVar.f2138o;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a.n(drawable, colorStateList.getColorForState(iVar.f2142s, i.this.f2138o.getDefaultColor()));
            }
        }
    }

    static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2149a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        /* synthetic */ b(Parcel parcel, a aVar) {
            this(parcel);
        }

        private String c() {
            int i3 = this.f2149a;
            if (i3 != 1) {
                return i3 != 2 ? "unchecked" : "indeterminate";
            }
            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + c() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Integer.valueOf(this.f2149a));
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }

        private b(Parcel parcel) {
            super(parcel);
            this.f2149a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i3 = S0.a.f1498P;
        f2123A = new int[]{i3};
        f2124B = new int[][]{new int[]{R.attr.state_enabled, i3}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f2125C = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1513e);
    }

    private boolean d(j0 j0Var) {
        int iN = j0Var.n(k.L3, 0);
        int iN2 = j0Var.n(k.M3, 0);
        if (Build.VERSION.SDK_INT < 21) {
            return iN == S0.d.f1603a && iN2 == S0.d.f1604b;
        }
        return iN == f2125C && iN2 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f2136m.jumpToCurrentState();
    }

    private void g() {
        this.f2135l = com.google.android.material.drawable.h.c(this.f2135l, this.f2138o, androidx.core.widget.c.c(this));
        this.f2136m = com.google.android.material.drawable.h.c(this.f2136m, this.f2139p, this.f2140q);
        i();
        j();
        super.setButtonDrawable(com.google.android.material.drawable.h.a(this.f2135l, this.f2136m));
        refreshDrawableState();
    }

    private String getButtonStateDescription() {
        int i3 = this.f2141r;
        if (i3 == 1) {
            return getResources().getString(S0.i.f1698k);
        }
        return i3 == 0 ? getResources().getString(S0.i.f1700m) : getResources().getString(S0.i.f1699l);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2130g == null) {
            int[][] iArr = f2124B;
            int[] iArr2 = new int[iArr.length];
            int iD = p002a1.a.d(this, S0.a.f1515g);
            int iD2 = p002a1.a.d(this, S0.a.f1517i);
            int iD3 = p002a1.a.d(this, S0.a.f1521m);
            int iD4 = p002a1.a.d(this, S0.a.f1518j);
            iArr2[0] = p002a1.a.k(iD3, iD2, 1.0f);
            iArr2[1] = p002a1.a.k(iD3, iD, 1.0f);
            iArr2[2] = p002a1.a.k(iD3, iD4, 0.54f);
            iArr2[3] = p002a1.a.k(iD3, iD4, 0.38f);
            iArr2[4] = p002a1.a.k(iD3, iD4, 0.38f);
            this.f2130g = new ColorStateList(iArr, iArr2);
        }
        return this.f2130g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f2138o;
        if (colorStateList != null) {
            return colorStateList;
        }
        return (Build.VERSION.SDK_INT < 21 || super.getButtonTintList() == null) ? getSupportButtonTintList() : super.getButtonTintList();
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 30 || this.f2144u != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    private void i() {
        if (this.f2137n) {
            androidx.vectordrawable.graphics.drawable.i iVar = this.f2146w;
            if (iVar != null) {
                iVar.h(this.f2147x);
                this.f2146w.c(this.f2147x);
            }
            if (Build.VERSION.SDK_INT < 24 || !e.a(this.f2135l) || this.f2146w == null) {
                return;
            }
            AnimatedStateListDrawable animatedStateListDrawableA = f.a(this.f2135l);
            int i3 = S0.e.f1633b;
            int i4 = S0.e.f1631Q;
            animatedStateListDrawableA.addTransition(i3, i4, this.f2146w, false);
            f.a(this.f2135l).addTransition(S0.e.f1639h, i4, this.f2146w, false);
        }
    }

    private void j() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f2135l;
        if (drawable != null && (colorStateList2 = this.f2138o) != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f2136m;
        if (drawable2 == null || (colorStateList = this.f2139p) == null) {
            return;
        }
        androidx.core.graphics.drawable.a.o(drawable2, colorStateList);
    }

    private void k() {
        Drawable drawable;
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 21 || (drawable = this.f2136m) == null || (colorStateList = this.f2139p) == null) {
            return;
        }
        drawable.setColorFilter(com.google.android.material.drawable.h.l(drawable, colorStateList, this.f2140q));
    }

    public boolean e() {
        return this.f2133j;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f2135l;
    }

    public Drawable getButtonIconDrawable() {
        return this.f2136m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f2139p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f2140q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f2138o;
    }

    public int getCheckedState() {
        return this.f2141r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f2134k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f2141r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2131h && this.f2138o == null && this.f2139p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2127z);
        }
        if (e()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2123A);
        }
        this.f2142s = com.google.android.material.drawable.h.e(iArrOnCreateDrawableState);
        k();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f2132i || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (F.g(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            androidx.core.graphics.drawable.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && e()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f2134k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f2149a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f2149a = getCheckedState();
        return bVar;
    }

    @Override // androidx.appcompat.widget.C0262f, android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(p016e.a.b(getContext(), i3));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f2136m = drawable;
        g();
    }

    public void setButtonIconDrawableResource(int i3) {
        setButtonIconDrawable(p016e.a.b(getContext(), i3));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f2139p == colorStateList) {
            return;
        }
        this.f2139p = colorStateList;
        g();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f2140q == mode) {
            return;
        }
        this.f2140q = mode;
        g();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f2138o == colorStateList) {
            return;
        }
        this.f2138o = colorStateList;
        g();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        g();
    }

    public void setCenterIfNoTextEnabled(boolean z3) {
        this.f2132i = z3;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        setCheckedState(z3 ? 1 : 0);
    }

    public void setCheckedState(int i3) {
        AutofillManager autofillManagerA;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f2141r != i3) {
            this.f2141r = i3;
            super.setChecked(i3 == 1);
            refreshDrawableState();
            h();
            if (this.f2143t) {
                return;
            }
            this.f2143t = true;
            LinkedHashSet linkedHashSet = this.f2129f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    H.a(it.next());
                    throw null;
                }
            }
            if (this.f2141r != 2 && (onCheckedChangeListener = this.f2145v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 26 && (autofillManagerA = c.a(getContext().getSystemService(Y0.a.a()))) != null) {
                autofillManagerA.notifyValueChanged(this);
            }
            this.f2143t = false;
            if (i4 >= 21 || this.f2136m == null) {
                return;
            }
            refreshDrawableState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        k();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f2134k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i3) {
        setErrorAccessibilityLabel(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setErrorShown(boolean z3) {
        Drawable drawable;
        if (this.f2133j == z3) {
            return;
        }
        this.f2133j = z3;
        refreshDrawableState();
        if (Build.VERSION.SDK_INT < 21 && (drawable = this.f2136m) != null) {
            drawable.jumpToCurrentState();
        }
        Iterator it = this.f2128e.iterator();
        if (it.hasNext()) {
            H.a(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2145v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f2144u = charSequence;
        if (charSequence == null) {
            h();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f2131h = z3;
        if (z3) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f2126y;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f2128e = new LinkedHashSet();
        this.f2129f = new LinkedHashSet();
        this.f2146w = androidx.vectordrawable.graphics.drawable.i.a(getContext(), S0.d.f1609g);
        this.f2147x = new a();
        Context context2 = getContext();
        this.f2135l = androidx.core.widget.c.a(this);
        this.f2138o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        j0 j0VarJ = C.j(context2, attributeSet, k.K3, i3, i4, new int[0]);
        this.f2136m = j0VarJ.g(k.N3);
        if (this.f2135l != null && C.g(context2) && d(j0VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f2135l = p016e.a.b(context2, S0.d.f1608f);
            this.f2137n = true;
            if (this.f2136m == null) {
                this.f2136m = p016e.a.b(context2, S0.d.f1610h);
            }
        }
        this.f2139p = p030h1.c.b(context2, j0VarJ, k.O3);
        this.f2140q = F.i(j0VarJ.k(k.P3, -1), PorterDuff.Mode.SRC_IN);
        this.f2131h = j0VarJ.a(k.U3, false);
        this.f2132i = j0VarJ.a(k.Q3, true);
        this.f2133j = j0VarJ.a(k.T3, false);
        this.f2134k = j0VarJ.p(k.S3);
        int i5 = k.R3;
        if (j0VarJ.s(i5)) {
            setCheckedState(j0VarJ.k(i5, 0));
        }
        j0VarJ.w();
        g();
        if (Build.VERSION.SDK_INT >= 21 || this.f2136m == null) {
            return;
        }
        post(new Runnable() { // from class: Y0.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2122a.f();
            }
        });
    }

    @Override // androidx.appcompat.widget.C0262f, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f2135l = drawable;
        this.f2137n = false;
        g();
    }
}
