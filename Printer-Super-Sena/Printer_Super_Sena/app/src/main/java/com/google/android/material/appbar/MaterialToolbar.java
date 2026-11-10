package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.Z;
import com.google.android.material.internal.C;
import com.google.android.material.internal.D;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final int f7635c0 = S0.j.f1737x;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final ImageView.ScaleType[] f7636d0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private Integer f7637U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private boolean f7638V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private boolean f7639W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private ImageView.ScaleType f7640a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Boolean f7641b0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, S0.a.f1508Z);
    }

    private Pair S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i3 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i3 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i3 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void T(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : com.google.android.material.drawable.h.f(background);
        if (colorStateListValueOf != null) {
            p042l1.g gVar = new p042l1.g();
            gVar.V(colorStateListValueOf);
            gVar.K(context);
            gVar.U(Z.w(this));
            Z.u0(this, gVar);
        }
    }

    private void U(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i4 = measuredWidth2 + i3;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i4 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i3 += iMax;
            i4 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i4 - i3, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i3, view.getTop(), i4, view.getBottom());
    }

    private void V() {
        if (this.f7638V || this.f7639W) {
            TextView textViewE = D.e(this);
            TextView textViewC = D.c(this);
            if (textViewE == null && textViewC == null) {
                return;
            }
            Pair pairS = S(textViewE, textViewC);
            if (this.f7638V && textViewE != null) {
                U(textViewE, pairS);
            }
            if (!this.f7639W || textViewC == null) {
                return;
            }
            U(textViewC, pairS);
        }
    }

    private Drawable W(Drawable drawable) {
        if (drawable == null || this.f7637U == null) {
            return drawable;
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
        androidx.core.graphics.drawable.a.n(drawableR, this.f7637U.intValue());
        return drawableR;
    }

    private void X() {
        ImageView imageViewB = D.b(this);
        if (imageViewB != null) {
            Boolean bool = this.f7641b0;
            if (bool != null) {
                imageViewB.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f7640a0;
            if (scaleType != null) {
                imageViewB.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f7640a0;
    }

    public Integer getNavigationIconTint() {
        return this.f7637U;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        p042l1.h.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        V();
        X();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        p042l1.h.d(this, f3);
    }

    public void setLogoAdjustViewBounds(boolean z3) {
        Boolean bool = this.f7641b0;
        if (bool == null || bool.booleanValue() != z3) {
            this.f7641b0 = Boolean.valueOf(z3);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f7640a0 != scaleType) {
            this.f7640a0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i3) {
        this.f7637U = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z3) {
        if (this.f7639W != z3) {
            this.f7639W = z3;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z3) {
        if (this.f7638V != z3) {
            this.f7638V = z3;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i3) {
        Menu menu = getMenu();
        boolean z3 = menu instanceof androidx.appcompat.view.menu.g;
        if (z3) {
            ((androidx.appcompat.view.menu.g) menu).h0();
        }
        super.x(i3);
        if (z3) {
            ((androidx.appcompat.view.menu.g) menu).g0();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f7635c0;
        super(p051o1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayI = C.i(context2, attributeSet, S0.k.n4, i3, i4, new int[0]);
        int i5 = S0.k.q4;
        if (typedArrayI.hasValue(i5)) {
            setNavigationIconTint(typedArrayI.getColor(i5, -1));
        }
        this.f7638V = typedArrayI.getBoolean(S0.k.s4, false);
        this.f7639W = typedArrayI.getBoolean(S0.k.r4, false);
        int i6 = typedArrayI.getInt(S0.k.p4, -1);
        if (i6 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f7636d0;
            if (i6 < scaleTypeArr.length) {
                this.f7640a0 = scaleTypeArr[i6];
            }
        }
        int i7 = S0.k.o4;
        if (typedArrayI.hasValue(i7)) {
            this.f7641b0 = Boolean.valueOf(typedArrayI.getBoolean(i7, false));
        }
        typedArrayI.recycle();
        T(context2);
    }
}
