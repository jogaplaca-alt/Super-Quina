package com.google.android.material.internal;

import A.T;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.W;
import androidx.appcompat.widget.o0;
import androidx.core.view.C0282a;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends AbstractC0494h implements androidx.appcompat.view.menu.n.a {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final int[] f8195G = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private FrameLayout f8196A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private androidx.appcompat.view.menu.i f8197B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private ColorStateList f8198C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private boolean f8199D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private Drawable f8200E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final C0282a f8201F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8203w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f8204x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f8205y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final CheckedTextView f8206z;

    class a extends C0282a {
        a() {
        }

        @Override // androidx.core.view.C0282a
        public void g(View view, T t3) {
            super.g(view, t3);
            t3.k0(NavigationMenuItemView.this.f8204x);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (F()) {
            this.f8206z.setVisibility(8);
            FrameLayout frameLayout = this.f8196A;
            if (frameLayout != null) {
                W.a aVar = (W.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f8196A.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f8206z.setVisibility(0);
        FrameLayout frameLayout2 = this.f8196A;
        if (frameLayout2 != null) {
            W.a aVar2 = (W.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f8196A.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(p012d.a.f9102t, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f8195G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean F() {
        return this.f8197B.getTitle() == null && this.f8197B.getIcon() == null && this.f8197B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f8196A == null) {
                this.f8196A = (FrameLayout) ((ViewStub) findViewById(S0.e.f1636e)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f8196A.removeAllViews();
            this.f8196A.addView(view);
        }
    }

    public void D(androidx.appcompat.view.menu.i iVar, boolean z3) {
        this.f8205y = z3;
        e(iVar, 0);
    }

    public void E() {
        FrameLayout frameLayout = this.f8196A;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f8206z.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(androidx.appcompat.view.menu.i iVar, int i3) {
        this.f8197B = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Z.u0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        o0.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.f8197B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        androidx.appcompat.view.menu.i iVar = this.f8197B;
        if (iVar != null && iVar.isCheckable() && this.f8197B.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8195G);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z3) {
        refreshDrawableState();
        if (this.f8204x != z3) {
            this.f8204x = z3;
            this.f8201F.l(this.f8206z, 2048);
        }
    }

    public void setChecked(boolean z3) {
        refreshDrawableState();
        this.f8206z.setChecked(z3);
        CheckedTextView checkedTextView = this.f8206z;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z3 && this.f8205y) ? 1 : 0);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f8199D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.f8198C);
            }
            int i3 = this.f8202v;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.f8203w) {
            if (this.f8200E == null) {
                Drawable drawableE = androidx.core.content.res.h.e(getResources(), S0.d.f1614l, getContext().getTheme());
                this.f8200E = drawableE;
                if (drawableE != null) {
                    int i4 = this.f8202v;
                    drawableE.setBounds(0, 0, i4, i4);
                }
            }
            drawable = this.f8200E;
        }
        androidx.core.widget.j.j(this.f8206z, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.f8206z.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(int i3) {
        this.f8202v = i3;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f8198C = colorStateList;
        this.f8199D = colorStateList != null;
        androidx.appcompat.view.menu.i iVar = this.f8197B;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i3) {
        this.f8206z.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z3) {
        this.f8203w = z3;
    }

    public void setTextAppearance(int i3) {
        androidx.core.widget.j.o(this.f8206z, i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f8206z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f8206z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8205y = true;
        a aVar = new a();
        this.f8201F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(S0.g.f1667h, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(S0.c.f1571c));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(S0.e.f1637f);
        this.f8206z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        Z.q0(checkedTextView, aVar);
    }
}
