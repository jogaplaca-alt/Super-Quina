package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3063c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3063c = -1;
        int[] iArr = p012d.j.f9304N0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        androidx.core.view.Z.o0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f3061a = typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9307O0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f3061a);
        }
    }

    private int a(int i3) {
        int childCount = getChildCount();
        while (i3 < childCount) {
            if (getChildAt(i3).getVisibility() == 0) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private boolean b() {
        return this.f3062b;
    }

    private void setStacked(boolean z3) {
        if (this.f3062b != z3) {
            if (!z3 || this.f3061a) {
                this.f3062b = z3;
                setOrientation(z3 ? 1 : 0);
                setGravity(z3 ? 8388613 : 80);
                View viewFindViewById = findViewById(p012d.f.f9182G);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z3 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int iMakeMeasureSpec;
        boolean z3;
        int size = View.MeasureSpec.getSize(i3);
        int paddingBottom = 0;
        if (this.f3061a) {
            if (size > this.f3063c && b()) {
                setStacked(false);
            }
            this.f3063c = size;
        }
        if (b() || View.MeasureSpec.getMode(i3) != 1073741824) {
            iMakeMeasureSpec = i3;
            z3 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z3 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i4);
        if (this.f3061a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z3 = true;
        }
        if (z3) {
            super.onMeasure(i3, i4);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (androidx.core.view.Z.D(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i4 == 0) {
                super.onMeasure(i3, i4);
            }
        }
    }

    public void setAllowStacking(boolean z3) {
        if (this.f3061a != z3) {
            this.f3061a = z3;
            if (!z3 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
