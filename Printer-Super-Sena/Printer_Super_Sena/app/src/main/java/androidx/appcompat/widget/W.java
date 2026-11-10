package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class W extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f3349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f3351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f3352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f3353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3357o;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i3, int i4) {
            super(i3, i4);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public W(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i3, int i4, int i5, int i6) {
        view.layout(i3, i4, i5 + i3, i6 + i4);
    }

    private void k(int i3, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View viewS = s(i5);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i6 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewS.getMeasuredWidth();
                    measureChildWithMargins(viewS, i4, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i6;
                }
            }
        }
    }

    private void l(int i3, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View viewS = s(i5);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i6 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewS.getMeasuredHeight();
                    measureChildWithMargins(viewS, iMakeMeasureSpec, 0, i4, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i6;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = u0.b(this);
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View viewS = s(i4);
            if (viewS != null && viewS.getVisibility() != 8 && t(i4)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewS.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f3354l);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i3 = this.f3354l;
                    right = left - i3;
                } else {
                    right = viewS2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.f3354l;
                right = left - i3;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.f3344b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.f3344b;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f3344b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f3345c;
        if (this.f3346d == 1 && (i3 = this.f3347e & 112) != 48) {
            if (i3 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f3348f) / 2;
            } else if (i3 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f3348f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3344b;
    }

    public Drawable getDividerDrawable() {
        return this.f3353k;
    }

    public int getDividerPadding() {
        return this.f3357o;
    }

    public int getDividerWidth() {
        return this.f3354l;
    }

    public int getGravity() {
        return this.f3347e;
    }

    public int getOrientation() {
        return this.f3346d;
    }

    public int getShowDividers() {
        return this.f3356n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f3349g;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewS = s(i3);
            if (viewS != null && viewS.getVisibility() != 8 && t(i3)) {
                i(canvas, (viewS.getTop() - ((LinearLayout.LayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.f3355m);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.f3355m : viewS2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i3) {
        this.f3353k.setBounds(getPaddingLeft() + this.f3357o, i3, (getWidth() - getPaddingRight()) - this.f3357o, this.f3355m + i3);
        this.f3353k.draw(canvas);
    }

    void j(Canvas canvas, int i3) {
        this.f3353k.setBounds(i3, getPaddingTop() + this.f3357o, this.f3354l + i3, (getHeight() - getPaddingBottom()) - this.f3357o);
        this.f3353k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i3 = this.f3346d;
        if (i3 == 0) {
            return new a(-2, -2);
        }
        if (i3 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f3353k == null) {
            return;
        }
        if (this.f3346d == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        if (this.f3346d == 1) {
            v(i3, i4, i5, i6);
        } else {
            u(i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f3346d == 1) {
            z(i3, i4);
        } else {
            x(i3, i4);
        }
    }

    int p(View view, int i3) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i3) {
        return getChildAt(i3);
    }

    public void setBaselineAligned(boolean z3) {
        this.f3343a = z3;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.f3344b = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f3353k) {
            return;
        }
        this.f3353k = drawable;
        if (drawable != null) {
            this.f3354l = drawable.getIntrinsicWidth();
            this.f3355m = drawable.getIntrinsicHeight();
        } else {
            this.f3354l = 0;
            this.f3355m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.f3357o = i3;
    }

    public void setGravity(int i3) {
        if (this.f3347e != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f3347e = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i4 = i3 & 8388615;
        int i5 = this.f3347e;
        if ((8388615 & i5) != i4) {
            this.f3347e = i4 | ((-8388616) & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z3) {
        this.f3350h = z3;
    }

    public void setOrientation(int i3) {
        if (this.f3346d != i3) {
            this.f3346d = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.f3356n) {
            requestLayout();
        }
        this.f3356n = i3;
    }

    public void setVerticalGravity(int i3) {
        int i4 = i3 & 112;
        int i5 = this.f3347e;
        if ((i5 & 112) != i4) {
            this.f3347e = i4 | (i5 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.f3349g = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected boolean t(int i3) {
        if (i3 == 0) {
            return (this.f3356n & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.f3356n & 4) != 0;
        }
        if ((this.f3356n & 2) == 0) {
            return false;
        }
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100  */
    void u(int i3, int i4, int i5, int i6) {
        int paddingLeft;
        int i7;
        int i8;
        int i9;
        int baseline;
        int i10;
        int i11;
        int measuredHeight;
        boolean zB = u0.b(this);
        int paddingTop = getPaddingTop();
        int i12 = i6 - i4;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.f3347e;
        int i14 = i13 & 112;
        boolean z3 = this.f3343a;
        int[] iArr = this.f3351i;
        int[] iArr2 = this.f3352j;
        int iB = androidx.core.view.r.b(8388615 & i13, androidx.core.view.Z.C(this));
        if (iB != 1) {
            paddingLeft = iB != 5 ? getPaddingLeft() : ((getPaddingLeft() + i5) - i3) - this.f3348f;
        } else {
            paddingLeft = getPaddingLeft() + (((i5 - i3) - this.f3348f) / 2);
        }
        if (zB) {
            i7 = virtualChildCount - 1;
            i8 = -1;
        } else {
            i7 = 0;
            i8 = 1;
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            int i15 = i7 + (i8 * iP);
            View viewS = s(i15);
            if (viewS == null) {
                paddingLeft += y(i15);
            } else {
                if (viewS.getVisibility() != 8) {
                    int measuredWidth = viewS.getMeasuredWidth();
                    int measuredHeight2 = viewS.getMeasuredHeight();
                    a aVar = (a) viewS.getLayoutParams();
                    int i16 = iP;
                    if (z3) {
                        i9 = virtualChildCount;
                        baseline = ((LinearLayout.LayoutParams) aVar).height != -1 ? viewS.getBaseline() : -1;
                        i10 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i10 < 0) {
                            i10 = i14;
                        }
                        i11 = i10 & 112;
                        if (i11 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        } else if (i11 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                            }
                        }
                        if (t(i15)) {
                            paddingLeft += this.f3354l;
                        }
                        int i17 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        A(viewS, i17 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                        int iR = i17 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(viewS);
                        iP = i16 + p(viewS, i15);
                        paddingLeft = iR;
                    } else {
                        i9 = virtualChildCount;
                    }
                    i10 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i10 < 0) {
                        i10 = i14;
                    }
                    i11 = i10 & 112;
                    if (i11 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    } else if (i11 != 48) {
                        measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                        if (baseline != -1) {
                            measuredHeight += iArr[1] - baseline;
                        }
                    } else if (i11 != 80) {
                        measuredHeight = paddingTop;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                        }
                    }
                    if (t(i15)) {
                        paddingLeft += this.f3354l;
                    }
                    int i18 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    A(viewS, i18 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                    int iR2 = i18 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(viewS);
                    iP = i16 + p(viewS, i15);
                    paddingLeft = iR2;
                }
                iP++;
                virtualChildCount = i9;
                i14 = i14;
                paddingTop = paddingTop;
            }
            i9 = virtualChildCount;
            iP++;
            virtualChildCount = i9;
            i14 = i14;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    void v(int i3, int i4, int i5, int i6) {
        int paddingTop;
        int i7;
        int i8;
        int i9;
        int paddingLeft = getPaddingLeft();
        int i10 = i5 - i3;
        int paddingRight = i10 - getPaddingRight();
        int paddingRight2 = (i10 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i11 = this.f3347e;
        int i12 = i11 & 112;
        int i13 = i11 & 8388615;
        if (i12 != 16) {
            paddingTop = i12 != 80 ? getPaddingTop() : ((getPaddingTop() + i6) - i4) - this.f3348f;
        } else {
            paddingTop = getPaddingTop() + (((i6 - i4) - this.f3348f) / 2);
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            View viewS = s(iP);
            if (viewS == null) {
                paddingTop += y(iP);
            } else if (viewS.getVisibility() != 8) {
                int measuredWidth = viewS.getMeasuredWidth();
                int measuredHeight = viewS.getMeasuredHeight();
                a aVar = (a) viewS.getLayoutParams();
                int i14 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i14 < 0) {
                    i14 = i13;
                }
                int iB = androidx.core.view.r.b(i14, androidx.core.view.Z.C(this)) & 7;
                if (iB != 1) {
                    if (iB != 5) {
                        i9 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i7 = paddingRight - measuredWidth;
                        i8 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    int i15 = i9;
                    if (t(iP)) {
                        paddingTop += this.f3355m;
                    }
                    int i16 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    A(viewS, i15, i16 + q(viewS), measuredWidth, measuredHeight);
                    int iR = i16 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(viewS);
                    iP += p(viewS, iP);
                    paddingTop = iR;
                } else {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i8 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i9 = i7 - i8;
                int i17 = i9;
                if (t(iP)) {
                    paddingTop += this.f3355m;
                }
                int i18 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                A(viewS, i17, i18 + q(viewS), measuredWidth, measuredHeight);
                int iR2 = i18 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(viewS);
                iP += p(viewS, iP);
                paddingTop = iR2;
            }
            iP++;
        }
    }

    void w(View view, int i3, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* JADX WARN: Code duplicated, block: B:200:0x0455  */
    /* JADX WARN: Code duplicated, block: B:60:0x0171  */
    /* JADX WARN: Code duplicated, block: B:67:0x0193  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01dc  */
    void x(int i3, int i4) {
        int[] iArr;
        int iCombineMeasuredStates;
        int i5;
        int iMax;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z3;
        boolean z4;
        View view;
        int i12;
        boolean z5;
        int i13;
        int measuredHeight;
        int iP;
        int baseline2;
        int i14;
        this.f3348f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        if (this.f3351i == null || this.f3352j == null) {
            this.f3351i = new int[4];
            this.f3352j = new int[4];
        }
        int[] iArr2 = this.f3351i;
        int[] iArr3 = this.f3352j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z6 = this.f3343a;
        boolean z7 = this.f3350h;
        int i15 = 1073741824;
        boolean z8 = mode == 1073741824;
        float f3 = 0.0f;
        int iP2 = 0;
        int iMax2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        boolean z9 = false;
        int iCombineMeasuredStates2 = 0;
        boolean z10 = true;
        boolean z11 = false;
        while (true) {
            iArr = iArr3;
            if (iP2 >= virtualChildCount) {
                break;
            }
            View viewS = s(iP2);
            if (viewS == null) {
                this.f3348f += y(iP2);
            } else {
                if (viewS.getVisibility() == 8) {
                    iP2 += p(viewS, iP2);
                } else {
                    if (t(iP2)) {
                        this.f3348f += this.f3354l;
                    }
                    a aVar = (a) viewS.getLayoutParams();
                    float f4 = ((LinearLayout.LayoutParams) aVar).weight;
                    float f5 = f3 + f4;
                    if (mode == i15 && ((LinearLayout.LayoutParams) aVar).width == 0 && f4 > 0.0f) {
                        if (z8) {
                            this.f3348f += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                        } else {
                            int i16 = this.f3348f;
                            this.f3348f = Math.max(i16, ((LinearLayout.LayoutParams) aVar).leftMargin + i16 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                        }
                        if (z6) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewS.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i11 = iP2;
                            z3 = z7;
                            z4 = z6;
                            view = viewS;
                        } else {
                            i11 = iP2;
                            z3 = z7;
                            z4 = z6;
                            view = viewS;
                            i12 = 1073741824;
                            z9 = true;
                        }
                        if (mode2 == i12 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z5 = true;
                            z11 = true;
                        } else {
                            z5 = false;
                        }
                        i13 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i13;
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                        if (z4 && (baseline2 = view.getBaseline()) != -1) {
                            i14 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i14 < 0) {
                                i14 = this.f3347e;
                            }
                            int i17 = (((i14 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i17] = Math.max(iArr2[i17], baseline2);
                            iArr[i17] = Math.max(iArr[i17], measuredHeight - baseline2);
                        }
                        iMax3 = Math.max(iMax3, measuredHeight);
                        if (z10 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                            if (!z5) {
                                i13 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i13);
                        } else {
                            int i18 = iMax5;
                            if (!z5) {
                                i13 = measuredHeight;
                            }
                            iMax4 = Math.max(iMax4, i13);
                            iMax5 = i18;
                        }
                        int i19 = i11;
                        iP = p(view, i19) + i19;
                        f3 = f5;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar).width != 0 || f4 <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar).width = -2;
                            i10 = 0;
                        }
                        i11 = iP2;
                        int i20 = i10;
                        z3 = z7;
                        z4 = z6;
                        w(viewS, i11, i3, f5 == 0.0f ? this.f3348f : 0, i4, 0);
                        if (i20 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar).width = i20;
                        }
                        int measuredWidth = viewS.getMeasuredWidth();
                        if (z8) {
                            view = viewS;
                            this.f3348f += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(view);
                        } else {
                            view = viewS;
                            int i21 = this.f3348f;
                            this.f3348f = Math.max(i21, i21 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + r(view));
                        }
                        if (z3) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    i12 = 1073741824;
                    if (mode2 == i12) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    i13 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i13;
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                    if (z4) {
                        i14 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i14 < 0) {
                            i14 = this.f3347e;
                        }
                        int i110 = (((i14 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i110] = Math.max(iArr2[i110], baseline2);
                        iArr[i110] = Math.max(iArr[i110], measuredHeight - baseline2);
                    }
                    iMax3 = Math.max(iMax3, measuredHeight);
                    if (z10) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                        if (!z5) {
                            i13 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i13);
                    } else {
                        int i111 = iMax5;
                        if (!z5) {
                            i13 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i13);
                        iMax5 = i111;
                    }
                    int i112 = i11;
                    iP = p(view, i112) + i112;
                    f3 = f5;
                }
                iP2 = iP + 1;
                iArr3 = iArr;
                z7 = z3;
                z6 = z4;
                i15 = 1073741824;
            }
            iP = iP2;
            z3 = z7;
            z4 = z6;
            iP2 = iP + 1;
            iArr3 = iArr;
            z7 = z3;
            z6 = z4;
            i15 = 1073741824;
        }
        boolean z12 = z7;
        boolean z13 = z6;
        int i22 = iMax3;
        int i23 = iMax4;
        int i24 = iMax5;
        int i25 = iCombineMeasuredStates2;
        if (this.f3348f > 0 && t(virtualChildCount)) {
            this.f3348f += this.f3354l;
        }
        int i26 = iArr2[1];
        int iMax6 = (i26 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i22 : Math.max(i22, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i26, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z12 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f3348f = 0;
            int iP3 = 0;
            while (iP3 < virtualChildCount) {
                View viewS2 = s(iP3);
                if (viewS2 == null) {
                    this.f3348f += y(iP3);
                } else if (viewS2.getVisibility() == 8) {
                    iP3 += p(viewS2, iP3);
                } else {
                    a aVar2 = (a) viewS2.getLayoutParams();
                    if (z8) {
                        this.f3348f += ((LinearLayout.LayoutParams) aVar2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + r(viewS2);
                    } else {
                        int i27 = this.f3348f;
                        this.f3348f = Math.max(i27, i27 + iMax2 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + r(viewS2));
                    }
                    iP3++;
                    iMax6 = iMax6;
                }
                iP3++;
                iMax6 = iMax6;
            }
        }
        int iMax7 = iMax6;
        int paddingLeft = this.f3348f + getPaddingLeft() + getPaddingRight();
        this.f3348f = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, 0);
        int i28 = (16777215 & iResolveSizeAndState) - this.f3348f;
        if (z9 || (i28 != 0 && f3 > 0.0f)) {
            float f6 = this.f3349g;
            if (f6 > 0.0f) {
                f3 = f6;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f3348f = 0;
            int i29 = i23;
            iCombineMeasuredStates = i25;
            int iMax8 = -1;
            int i30 = 0;
            while (i30 < virtualChildCount) {
                View viewS3 = s(i30);
                if (viewS3 == null || viewS3.getVisibility() == 8) {
                    i6 = i28;
                    virtualChildCount = virtualChildCount;
                } else {
                    a aVar3 = (a) viewS3.getLayoutParams();
                    float f7 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f7 > 0.0f) {
                        int i31 = (int) ((i28 * f7) / f3);
                        float f8 = f3 - f7;
                        int i32 = i28 - i31;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i9 = 1073741824;
                            if (mode == 1073741824) {
                                if (i31 <= 0) {
                                    i31 = 0;
                                }
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(i31, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS3.getMeasuredState() & (-16777216));
                            f3 = f8;
                            i6 = i32;
                        } else {
                            i9 = 1073741824;
                        }
                        int measuredWidth2 = viewS3.getMeasuredWidth() + i31;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewS3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i9), childMeasureSpec);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS3.getMeasuredState() & (-16777216));
                        f3 = f8;
                        i6 = i32;
                    } else {
                        i6 = i28;
                    }
                    if (z8) {
                        this.f3348f += viewS3.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + r(viewS3);
                    } else {
                        int i33 = this.f3348f;
                        this.f3348f = Math.max(i33, viewS3.getMeasuredWidth() + i33 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + r(viewS3));
                    }
                    boolean z14 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i34 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewS3.getMeasuredHeight() + i34;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z14) {
                        i34 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i29, i34);
                    if (z10) {
                        i7 = -1;
                        boolean z15 = ((LinearLayout.LayoutParams) aVar3).height == -1;
                        if (z13 && (baseline = viewS3.getBaseline()) != i7) {
                            i8 = ((LinearLayout.LayoutParams) aVar3).gravity;
                            if (i8 < 0) {
                                i8 = this.f3347e;
                            }
                            int i35 = (((i8 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i35] = Math.max(iArr2[i35], baseline);
                            iArr[i35] = Math.max(iArr[i35], measuredHeight2 - baseline);
                        }
                        z10 = z15;
                        i29 = iMax9;
                        f3 = f3;
                    } else {
                        i7 = -1;
                    }
                    if (z13) {
                        i8 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i8 < 0) {
                            i8 = this.f3347e;
                        }
                        int i36 = (((i8 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i36] = Math.max(iArr2[i36], baseline);
                        iArr[i36] = Math.max(iArr[i36], measuredHeight2 - baseline);
                    }
                    z10 = z15;
                    i29 = iMax9;
                    f3 = f3;
                }
                i30++;
                i28 = i6;
                virtualChildCount = virtualChildCount;
            }
            i5 = virtualChildCount;
            this.f3348f += getPaddingLeft() + getPaddingRight();
            int i37 = iArr2[1];
            iMax7 = (i37 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i37, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax = i29;
        } else {
            iMax = Math.max(i23, i24);
            if (z12 && mode != 1073741824) {
                for (int i38 = 0; i38 < virtualChildCount; i38++) {
                    View viewS4 = s(i38);
                    if (viewS4 != null && viewS4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewS4.getLayoutParams())).weight > 0.0f) {
                        viewS4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(viewS4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = virtualChildCount;
            iCombineMeasuredStates = i25;
        }
        if (z10 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(Math.max(iMax + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates << 16));
        if (z11) {
            k(i5, i3);
        }
    }

    int y(int i3) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x032d  */
    void z(int i3, int i4) {
        int i5;
        int iCombineMeasuredStates;
        int iMax;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iMax2;
        int i16;
        View view;
        int iMax3;
        boolean z4;
        this.f3348f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int i17 = this.f3344b;
        boolean z5 = this.f3350h;
        float f3 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int iMax4 = 0;
        int i21 = 0;
        int iP = 0;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = false;
        while (true) {
            int i22 = 8;
            int i23 = iMax4;
            if (iP >= virtualChildCount) {
                int i24 = i18;
                int i25 = i20;
                int i26 = i21;
                int i27 = mode2;
                int iMax5 = i19;
                int i28 = virtualChildCount;
                if (this.f3348f > 0) {
                    i5 = i28;
                    if (t(i5)) {
                        this.f3348f += this.f3355m;
                    }
                } else {
                    i5 = i28;
                }
                if (z5 && (i27 == Integer.MIN_VALUE || i27 == 0)) {
                    this.f3348f = 0;
                    int iP2 = 0;
                    while (iP2 < i5) {
                        View viewS = s(iP2);
                        if (viewS == null) {
                            this.f3348f += y(iP2);
                        } else if (viewS.getVisibility() == i22) {
                            iP2 += p(viewS, iP2);
                        } else {
                            a aVar = (a) viewS.getLayoutParams();
                            int i29 = this.f3348f;
                            this.f3348f = Math.max(i29, i29 + i25 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(viewS));
                        }
                        iP2++;
                        i22 = 8;
                    }
                }
                int paddingTop = this.f3348f + getPaddingTop() + getPaddingBottom();
                this.f3348f = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, 0);
                int i30 = (16777215 & iResolveSizeAndState) - this.f3348f;
                if (z6 || (i30 != 0 && f3 > 0.0f)) {
                    float f4 = this.f3349g;
                    if (f4 > 0.0f) {
                        f3 = f4;
                    }
                    this.f3348f = 0;
                    int i31 = i30;
                    int i32 = i26;
                    iCombineMeasuredStates = i24;
                    int i33 = 0;
                    while (i33 < i5) {
                        View viewS2 = s(i33);
                        if (viewS2.getVisibility() == 8) {
                            i6 = i31;
                        } else {
                            a aVar2 = (a) viewS2.getLayoutParams();
                            float f5 = ((LinearLayout.LayoutParams) aVar2).weight;
                            if (f5 > 0.0f) {
                                int i34 = (int) ((i31 * f5) / f3);
                                float f6 = f3 - f5;
                                i6 = i31 - i34;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin, ((LinearLayout.LayoutParams) aVar2).width);
                                if (((LinearLayout.LayoutParams) aVar2).height == 0) {
                                    i9 = 1073741824;
                                    if (i27 == 1073741824) {
                                        if (i34 <= 0) {
                                            i34 = 0;
                                        }
                                        viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i34, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                    f3 = f6;
                                } else {
                                    i9 = 1073741824;
                                }
                                int measuredHeight = viewS2.getMeasuredHeight() + i34;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i9));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                f3 = f6;
                            } else {
                                i6 = i31;
                            }
                            int i35 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewS2.getMeasuredWidth() + i35;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f7 = f3;
                            if (mode != 1073741824) {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                                if (((LinearLayout.LayoutParams) aVar2).width != -1) {
                                }
                                int iMax6 = Math.max(i32, i35);
                                if (z7 || ((LinearLayout.LayoutParams) aVar2).width != i8) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                int i36 = this.f3348f;
                                this.f3348f = Math.max(i36, viewS2.getMeasuredHeight() + i36 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + r(viewS2));
                                z7 = z3;
                                iCombineMeasuredStates = i7;
                                i32 = iMax6;
                                f3 = f7;
                            } else {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                            }
                            i35 = measuredWidth;
                            int iMax7 = Math.max(i32, i35);
                            if (z7) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            int i37 = this.f3348f;
                            this.f3348f = Math.max(i37, viewS2.getMeasuredHeight() + i37 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + r(viewS2));
                            z7 = z3;
                            iCombineMeasuredStates = i7;
                            i32 = iMax7;
                            f3 = f7;
                        }
                        i33++;
                        i31 = i6;
                    }
                    this.f3348f += getPaddingTop() + getPaddingBottom();
                    iMax = i32;
                } else {
                    iMax = Math.max(i26, i23);
                    if (z5 && i27 != 1073741824) {
                        for (int i38 = 0; i38 < i5; i38++) {
                            View viewS3 = s(i38);
                            if (viewS3 != null && viewS3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewS3.getLayoutParams())).weight > 0.0f) {
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(viewS3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i25, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i24;
                }
                if (z7 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, iCombineMeasuredStates), iResolveSizeAndState);
                if (z8) {
                    l(i5, i4);
                    return;
                }
                return;
            }
            View viewS4 = s(iP);
            if (viewS4 == null) {
                this.f3348f += y(iP);
                i13 = mode2;
                iMax4 = i23;
                i15 = virtualChildCount;
            } else {
                int i39 = i18;
                if (viewS4.getVisibility() == 8) {
                    iP += p(viewS4, iP);
                    iMax4 = i23;
                    i18 = i39;
                    i15 = virtualChildCount;
                    i13 = mode2;
                } else {
                    if (t(iP)) {
                        this.f3348f += this.f3355m;
                    }
                    a aVar3 = (a) viewS4.getLayoutParams();
                    float f8 = ((LinearLayout.LayoutParams) aVar3).weight;
                    float f9 = f3 + f8;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f8 > 0.0f) {
                        int i40 = this.f3348f;
                        this.f3348f = Math.max(i40, ((LinearLayout.LayoutParams) aVar3).topMargin + i40 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        iMax3 = i20;
                        view = viewS4;
                        iMax2 = i21;
                        i11 = i39;
                        i12 = i19;
                        z6 = true;
                        i13 = mode2;
                        i14 = i23;
                        i15 = virtualChildCount;
                        i16 = iP;
                    } else {
                        int i41 = i19;
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f8 <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = -2;
                            i10 = 0;
                        }
                        i11 = i39;
                        int i42 = i10;
                        i12 = i41;
                        int i43 = i20;
                        i13 = mode2;
                        i14 = i23;
                        i15 = virtualChildCount;
                        iMax2 = i21;
                        i16 = iP;
                        w(viewS4, iP, i3, 0, i4, f9 == 0.0f ? this.f3348f : 0);
                        if (i42 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar3).height = i42;
                        }
                        int measuredHeight2 = viewS4.getMeasuredHeight();
                        int i44 = this.f3348f;
                        view = viewS4;
                        this.f3348f = Math.max(i44, i44 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + r(view));
                        iMax3 = z5 ? Math.max(measuredHeight2, i43) : i43;
                    }
                    if (i17 >= 0 && i17 == i16 + 1) {
                        this.f3345c = this.f3348f;
                    }
                    if (i16 < i17 && ((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar3).width != -1) {
                        z4 = false;
                    } else {
                        z4 = true;
                        z8 = true;
                    }
                    int i45 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i45;
                    int iMax8 = Math.max(i12, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    z7 = z7 && ((LinearLayout.LayoutParams) aVar3).width == -1;
                    if (((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        if (!z4) {
                            i45 = measuredWidth2;
                        }
                        iMax4 = Math.max(i14, i45);
                    } else {
                        if (!z4) {
                            i45 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i45);
                        iMax4 = i14;
                    }
                    int iP3 = p(view, i16) + i16;
                    i20 = iMax3;
                    i19 = iMax8;
                    f3 = f9;
                    i21 = iMax2;
                    iP = iP3;
                    i18 = iCombineMeasuredStates2;
                }
            }
            iP++;
            virtualChildCount = i15;
            mode2 = i13;
        }
    }

    public W(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3343a = true;
        this.f3344b = -1;
        this.f3345c = 0;
        this.f3347e = 8388659;
        int[] iArr = p012d.j.f9376i1;
        j0 j0VarV = j0.v(context, attributeSet, iArr, i3, 0);
        androidx.core.view.Z.o0(this, context, iArr, attributeSet, j0VarV.r(), i3, 0);
        int iK = j0VarV.k(p012d.j.f9384k1, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = j0VarV.k(p012d.j.f9380j1, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = j0VarV.a(p012d.j.f9388l1, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f3349g = j0VarV.i(p012d.j.f9396n1, -1.0f);
        this.f3344b = j0VarV.k(p012d.j.f9392m1, -1);
        this.f3350h = j0VarV.a(p012d.j.f9408q1, false);
        setDividerDrawable(j0VarV.g(p012d.j.f9400o1));
        this.f3356n = j0VarV.k(p012d.j.f9412r1, 0);
        this.f3357o = j0VarV.f(p012d.j.f9404p1, 0);
        j0VarV.w();
    }
}
