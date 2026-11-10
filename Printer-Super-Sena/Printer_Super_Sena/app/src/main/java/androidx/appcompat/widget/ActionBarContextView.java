package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.C0297h0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0257a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f2989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f2990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f2991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f2992l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f2993m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinearLayout f2994n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f2995o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f2996p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2997q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2998r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2999s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3000t;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f3001a;

        a(androidx.appcompat.view.b bVar) {
            this.f3001a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f3001a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f2994n == null) {
            LayoutInflater.from(getContext()).inflate(p012d.g.f9218a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2994n = linearLayout;
            this.f2995o = (TextView) linearLayout.findViewById(p012d.f.f9196e);
            this.f2996p = (TextView) this.f2994n.findViewById(p012d.f.f9195d);
            if (this.f2997q != 0) {
                this.f2995o.setTextAppearance(getContext(), this.f2997q);
            }
            if (this.f2998r != 0) {
                this.f2996p.setTextAppearance(getContext(), this.f2998r);
            }
        }
        this.f2995o.setText(this.f2989i);
        this.f2996p.setText(this.f2990j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f2989i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f2990j);
        this.f2996p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f2994n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f2994n.getParent() == null) {
            addView(this.f2994n);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0257a
    public /* bridge */ /* synthetic */ C0297h0 f(int i3, long j3) {
        return super.f(i3, j3);
    }

    public void g() {
        if (this.f2991k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0257a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0257a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f2990j;
    }

    public CharSequence getTitle() {
        return this.f2989i;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f2991k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f3000t, (ViewGroup) this, false);
            this.f2991k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2991k);
        }
        View viewFindViewById = this.f2991k.findViewById(p012d.f.f9200i);
        this.f2992l = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        C0259c c0259c = this.f3409d;
        if (c0259c != null) {
            c0259c.B();
        }
        C0259c c0259c2 = new C0259c(getContext());
        this.f3409d = c0259c2;
        c0259c2.M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f3409d, this.f3407b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f3409d.r(this);
        this.f3408c = actionMenuView;
        androidx.core.view.Z.u0(actionMenuView, null);
        addView(this.f3408c, layoutParams);
    }

    public boolean j() {
        return this.f2999s;
    }

    public void k() {
        removeAllViews();
        this.f2993m = null;
        this.f3408c = null;
        this.f3409d = null;
        View view = this.f2992l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        C0259c c0259c = this.f3409d;
        if (c0259c != null) {
            return c0259c.N();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0259c c0259c = this.f3409d;
        if (c0259c != null) {
            c0259c.E();
            this.f3409d.F();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0257a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        boolean zB = u0.b(this);
        int paddingRight = zB ? (i5 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2991k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2991k.getLayoutParams();
            int i7 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC0257a.d(paddingRight, i7, zB);
            paddingRight = AbstractC0257a.d(iD + e(this.f2991k, iD, paddingTop, paddingTop2, zB), i8, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f2994n;
        if (linearLayout != null && this.f2993m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f2994n, iE, paddingTop, paddingTop2, zB);
        }
        int i9 = iE;
        View view2 = this.f2993m;
        if (view2 != null) {
            e(view2, i9, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i5 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f3408c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = this.f3410e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2991k;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2991k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f3408c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f3408c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f2994n;
        if (linearLayout != null && this.f2993m == null) {
            if (this.f2999s) {
                this.f2994n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2994n.getMeasuredWidth();
                boolean z3 = measuredWidth <= paddingLeft;
                if (z3) {
                    paddingLeft -= measuredWidth;
                }
                this.f2994n.setVisibility(z3 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f2993m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.f2993m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i8));
        }
        if (this.f3410e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    @Override // androidx.appcompat.widget.AbstractC0257a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0257a
    public void setContentHeight(int i3) {
        this.f3410e = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2993m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2993m = view;
        if (view != null && (linearLayout = this.f2994n) != null) {
            removeView(linearLayout);
            this.f2994n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2990j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2989i = charSequence;
        i();
        androidx.core.view.Z.t0(this, charSequence);
    }

    public void setTitleOptional(boolean z3) {
        if (z3 != this.f2999s) {
            requestLayout();
        }
        this.f2999s = z3;
    }

    @Override // androidx.appcompat.widget.AbstractC0257a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p012d.a.f9089g);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j0 j0VarV = j0.v(context, attributeSet, p012d.j.f9438y, i3, 0);
        androidx.core.view.Z.u0(this, j0VarV.g(p012d.j.f9442z));
        this.f2997q = j0VarV.n(p012d.j.f9269D, 0);
        this.f2998r = j0VarV.n(p012d.j.f9265C, 0);
        this.f3410e = j0VarV.m(p012d.j.f9261B, 0);
        this.f3000t = j0VarV.n(p012d.j.f9257A, p012d.g.f9221d);
        j0VarV.w();
    }
}
