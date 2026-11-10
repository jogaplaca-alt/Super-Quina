package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends W implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.n {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    e f3038A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f3039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Context f3040q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3042s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private C0259c f3043t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private androidx.appcompat.view.menu.m.a f3044u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    androidx.appcompat.view.menu.g.a f3045v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f3046w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3047x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f3048y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3049z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements androidx.appcompat.view.menu.m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    public static class c extends W.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3054e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f3055f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f3050a = cVar.f3050a;
        }

        public c(int i3, int i4) {
            super(i3, i4);
            this.f3050a = false;
        }
    }

    private class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f3038A;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.g.a aVar = ActionMenuView.this.f3045v;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    static int L(View view, int i3, int i4, int i5, int i6) {
        int i7;
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - i6, View.MeasureSpec.getMode(i5));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z3 = false;
        boolean z4 = actionMenuItemView != null && actionMenuItemView.r();
        if (i4 > 0) {
            i7 = 2;
            if (!z4 || i4 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i4 * i3, Integer.MIN_VALUE), iMakeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i8 = measuredWidth / i3;
                if (measuredWidth % i3 != 0) {
                    i8++;
                }
                if (!z4 || i8 >= 2) {
                    i7 = i8;
                }
            } else {
                i7 = 0;
            }
        } else {
            i7 = 0;
        }
        if (!cVar.f3050a && z4) {
            z3 = true;
        }
        cVar.f3053d = z3;
        cVar.f3051b = i7;
        view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i7, 1073741824), iMakeMeasureSpec);
        return i7;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void M(int i3, int i4) {
        boolean z3;
        int i5;
        boolean z4;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
        int i6 = size - paddingLeft;
        int i7 = this.f3048y;
        int i8 = i6 / i7;
        int i9 = i6 % i7;
        if (i8 == 0) {
            setMeasuredDimension(i6, 0);
            return;
        }
        int i10 = i7 + (i9 / i8);
        int childCount = getChildCount();
        int iMax = 0;
        int i11 = 0;
        boolean z5 = false;
        int i12 = 0;
        int iMax2 = 0;
        int i13 = 0;
        long j3 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            int i14 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i15 = i12 + 1;
                if (z6) {
                    int i16 = this.f3049z;
                    r14 = 0;
                    childAt.setPadding(i16, 0, i16, 0);
                } else {
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f3055f = r14;
                cVar.f3052c = r14;
                cVar.f3051b = r14;
                cVar.f3053d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f3054e = z6 && ((ActionMenuItemView) childAt).r();
                int iL = L(childAt, i10, cVar.f3050a ? 1 : i8, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f3053d) {
                    i13++;
                }
                if (cVar.f3050a) {
                    z5 = true;
                }
                i8 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j3 |= (long) (1 << i11);
                    iMax = iMax;
                }
                i12 = i15;
            }
            i11++;
            size2 = i14;
        }
        int i17 = size2;
        boolean z7 = z5 && i12 == 2;
        boolean z8 = false;
        while (true) {
            if (i13 <= 0 || i8 <= 0) {
                z3 = z8;
                i5 = iMax;
                break;
            }
            int i18 = 0;
            int i19 = 0;
            int i20 = Integer.MAX_VALUE;
            long j4 = 0;
            while (i19 < childCount) {
                boolean z9 = z8;
                c cVar2 = (c) getChildAt(i19).getLayoutParams();
                int i21 = iMax;
                if (cVar2.f3053d) {
                    int i22 = cVar2.f3051b;
                    if (i22 < i20) {
                        j4 = 1 << i19;
                        i20 = i22;
                        i18 = 1;
                    } else if (i22 == i20) {
                        i18++;
                        j4 |= 1 << i19;
                    }
                }
                i19++;
                iMax = i21;
                z8 = z9;
            }
            z3 = z8;
            i5 = iMax;
            j3 |= j4;
            if (i18 > i8) {
                break;
            }
            int i23 = i20 + 1;
            int i24 = 0;
            while (i24 < childCount) {
                View childAt2 = getChildAt(i24);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i25 = i6;
                int i26 = mode;
                long j5 = 1 << i24;
                if ((j4 & j5) == 0) {
                    if (cVar3.f3051b == i23) {
                        j3 |= j5;
                    }
                    z7 = z7;
                } else {
                    if (z7 && cVar3.f3054e && i8 == 1) {
                        int i27 = this.f3049z;
                        childAt2.setPadding(i27 + i10, 0, i27, 0);
                    }
                    cVar3.f3051b++;
                    cVar3.f3055f = true;
                    i8--;
                }
                i24++;
                mode = i26;
                i6 = i25;
                z7 = z7;
            }
            iMax = i5;
            z8 = true;
        }
        boolean z10 = !z5 && i12 == 1;
        if (i8 <= 0 || j3 == 0 || (i8 >= i12 - 1 && !z10 && iMax2 <= 1)) {
            z4 = z3;
        } else {
            float fBitCount = Long.bitCount(j3);
            if (!z10) {
                if ((j3 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f3054e) {
                    fBitCount -= 0.5f;
                }
                int i28 = childCount - 1;
                if ((j3 & ((long) (1 << i28))) != 0 && !((c) getChildAt(i28).getLayoutParams()).f3054e) {
                    fBitCount -= 0.5f;
                }
            }
            int i29 = fBitCount > 0.0f ? (int) ((i8 * i10) / fBitCount) : 0;
            z4 = z3;
            for (int i30 = 0; i30 < childCount; i30++) {
                if ((j3 & ((long) (1 << i30))) != 0) {
                    View childAt3 = getChildAt(i30);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f3052c = i29;
                        cVar4.f3055f = true;
                        if (i30 == 0 && !cVar4.f3054e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i29) / 2;
                        }
                    } else if (cVar4.f3050a) {
                        cVar4.f3052c = i29;
                        cVar4.f3055f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i29) / 2;
                    } else {
                        if (i30 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i29 / 2;
                        }
                        if (i30 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i29 / 2;
                        }
                    }
                    z4 = true;
                }
            }
        }
        if (z4) {
            for (int i31 = 0; i31 < childCount; i31++) {
                View childAt4 = getChildAt(i31);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f3055f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f3051b * i10) + cVar5.f3052c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i6, mode != 1073741824 ? i5 : i17);
    }

    public void B() {
        C0259c c0259c = this.f3043t;
        if (c0259c != null) {
            c0259c.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.W
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.W
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.W
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f3050a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i3) {
        boolean zA = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i3 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public boolean H() {
        C0259c c0259c = this.f3043t;
        return c0259c != null && c0259c.E();
    }

    public boolean I() {
        C0259c c0259c = this.f3043t;
        return c0259c != null && c0259c.G();
    }

    public boolean J() {
        C0259c c0259c = this.f3043t;
        return c0259c != null && c0259c.H();
    }

    public boolean K() {
        return this.f3042s;
    }

    public androidx.appcompat.view.menu.g N() {
        return this.f3039p;
    }

    public void O(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.f3044u = aVar;
        this.f3045v = aVar2;
    }

    public boolean P() {
        C0259c c0259c = this.f3043t;
        return c0259c != null && c0259c.N();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.f3039p.N(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.f3039p = gVar;
    }

    @Override // androidx.appcompat.widget.W, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f3039p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.f3039p = gVar;
            gVar.V(new d());
            C0259c c0259c = new C0259c(context);
            this.f3043t = c0259c;
            c0259c.M(true);
            C0259c c0259c2 = this.f3043t;
            androidx.appcompat.view.menu.m.a bVar = this.f3044u;
            if (bVar == null) {
                bVar = new b();
            }
            c0259c2.l(bVar);
            this.f3039p.c(this.f3043t, this.f3040q);
            this.f3043t.K(this);
        }
        return this.f3039p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f3043t.D();
    }

    public int getPopupTheme() {
        return this.f3041r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0259c c0259c = this.f3043t;
        if (c0259c != null) {
            c0259c.n(false);
            if (this.f3043t.H()) {
                this.f3043t.E();
                this.f3043t.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.W, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int width;
        int paddingLeft;
        if (!this.f3046w) {
            super.onLayout(z3, i3, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i6 - i4) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i5 - i3;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zB = u0.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f3050a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    G(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int iMax = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f3050a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f3050a) {
                int i20 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft2 = i20 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.W, android.view.View
    protected void onMeasure(int i3, int i4) {
        androidx.appcompat.view.menu.g gVar;
        boolean z3 = this.f3046w;
        boolean z4 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.f3046w = z4;
        if (z3 != z4) {
            this.f3047x = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.f3046w && (gVar = this.f3039p) != null && size != this.f3047x) {
            this.f3047x = size;
            gVar.M(true);
        }
        int childCount = getChildCount();
        if (this.f3046w && childCount > 0) {
            M(i3, i4);
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            c cVar = (c) getChildAt(i5).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i3, i4);
    }

    public void setExpandedActionViewsExclusive(boolean z3) {
        this.f3043t.J(z3);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f3038A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f3043t.L(drawable);
    }

    public void setOverflowReserved(boolean z3) {
        this.f3042s = z3;
    }

    public void setPopupTheme(int i3) {
        if (this.f3041r != i3) {
            this.f3041r = i3;
            if (i3 == 0) {
                this.f3040q = getContext();
            } else {
                this.f3040q = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPresenter(C0259c c0259c) {
        this.f3043t = c0259c;
        c0259c.K(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f3048y = (int) (56.0f * f3);
        this.f3049z = (int) (f3 * 4.0f);
        this.f3040q = context;
        this.f3041r = 0;
    }
}
