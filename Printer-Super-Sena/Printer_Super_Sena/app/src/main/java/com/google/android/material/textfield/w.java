package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.C0260d;
import androidx.appcompat.widget.X;
import androidx.core.view.Z;
import com.google.android.material.internal.AbstractC0495i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w extends C0260d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final X f8741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f8742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f8743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f8745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f8746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f8748l;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            w wVar = w.this;
            w.this.l(i3 < 0 ? wVar.f8741e.v() : wVar.getAdapter().getItem(i3));
            AdapterView.OnItemClickListener onItemClickListener = w.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i3 < 0) {
                    view = w.this.f8741e.y();
                    i3 = w.this.f8741e.x();
                    j3 = w.this.f8741e.w();
                }
                onItemClickListener.onItemClick(w.this.f8741e.k(), view, i3, j3);
            }
            w.this.f8741e.dismiss();
        }
    }

    private class b extends ArrayAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ColorStateList f8750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ColorStateList f8751b;

        b(Context context, int i3, String[] strArr) {
            super(context, i3, strArr);
            f();
        }

        private ColorStateList a() {
            if (!c() || !d() || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{p002a1.a.j(w.this.f8747k, w.this.f8748l.getColorForState(iArr2, 0)), p002a1.a.j(w.this.f8747k, w.this.f8748l.getColorForState(iArr, 0)), w.this.f8747k});
        }

        private Drawable b() {
            if (!c() || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(w.this.f8747k);
            if (this.f8751b == null) {
                return colorDrawable;
            }
            androidx.core.graphics.drawable.a.o(colorDrawable, this.f8750a);
            return new RippleDrawable(this.f8751b, colorDrawable, null);
        }

        private boolean c() {
            return w.this.f8747k != 0;
        }

        private boolean d() {
            return w.this.f8748l != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{w.this.f8748l.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f8751b = e();
            this.f8750a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i3, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                Z.u0(textView, w.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1510b);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        return i() || h();
    }

    private boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f8742f;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f8742f.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        AccessibilityManager accessibilityManager = this.f8742f;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutF = f();
        int i3 = 0;
        if (adapter == null || textInputLayoutF == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f8741e.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutF);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableI = this.f8741e.i();
        if (drawableI != null) {
            drawableI.getPadding(this.f8743g);
            Rect rect = this.f8743g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutF.getEndIconView().getMeasuredWidth();
    }

    private void k() {
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null) {
            textInputLayoutF.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f8741e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f8746j;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutF = f();
        return (textInputLayoutF == null || !textInputLayoutF.R()) ? super.getHint() : textInputLayoutF.getHint();
    }

    public float getPopupElevation() {
        return this.f8745i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f8747k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f8748l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null && textInputLayoutF.R() && super.getHint() == null && AbstractC0495i.b()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8741e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z3) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z3);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        super.setAdapter(t3);
        this.f8741e.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        X x3 = this.f8741e;
        if (x3 != null) {
            x3.m(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i3) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i3));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f8746j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof p042l1.g) {
            ((p042l1.g) dropDownBackground).V(this.f8746j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f8741e.M(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i3) {
        super.setRawInputType(i3);
        k();
    }

    public void setSimpleItemSelectedColor(int i3) {
        this.f8747k = i3;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f8748l = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f8741e.f();
        } else {
            super.showDropDown();
        }
    }

    public w(Context context, AttributeSet attributeSet, int i3) {
        super(p051o1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f8743g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.C.i(context2, attributeSet, S0.k.f1765G2, i3, S0.j.f1718e, new int[0]);
        int i4 = S0.k.H2;
        if (typedArrayI.hasValue(i4) && typedArrayI.getInt(i4, 0) == 0) {
            setKeyListener(null);
        }
        this.f8744h = typedArrayI.getResourceId(S0.k.K2, S0.g.f1676q);
        this.f8745i = typedArrayI.getDimensionPixelOffset(S0.k.I2, S0.c.f1570b0);
        int i5 = S0.k.J2;
        if (typedArrayI.hasValue(i5)) {
            this.f8746j = ColorStateList.valueOf(typedArrayI.getColor(i5, 0));
        }
        this.f8747k = typedArrayI.getColor(S0.k.L2, 0);
        this.f8748l = p030h1.c.a(context2, typedArrayI, S0.k.M2);
        this.f8742f = (AccessibilityManager) context2.getSystemService("accessibility");
        X x3 = new X(context2);
        this.f8741e = x3;
        x3.J(true);
        x3.D(this);
        x3.I(2);
        x3.o(getAdapter());
        x3.L(new a());
        int i6 = S0.k.N2;
        if (typedArrayI.hasValue(i6)) {
            setSimpleItems(typedArrayI.getResourceId(i6, 0));
        }
        typedArrayI.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f8744h, strArr));
    }
}
