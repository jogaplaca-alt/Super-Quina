package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f2980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f2983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f2984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f2985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f2986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2988j;

    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.view.Z.u0(this, new C0258b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p012d.j.f9342a);
        this.f2983e = typedArrayObtainStyledAttributes.getDrawable(p012d.j.f9346b);
        this.f2984f = typedArrayObtainStyledAttributes.getDrawable(p012d.j.f9354d);
        this.f2988j = typedArrayObtainStyledAttributes.getDimensionPixelSize(p012d.j.f9378j, -1);
        boolean z3 = true;
        if (getId() == p012d.f.f9183H) {
            this.f2986h = true;
            this.f2985g = typedArrayObtainStyledAttributes.getDrawable(p012d.j.f9350c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2986h ? this.f2983e != null || this.f2984f != null : this.f2985g != null) {
            z3 = false;
        }
        setWillNotDraw(z3);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2983e;
        if (drawable != null && drawable.isStateful()) {
            this.f2983e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2984f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2984f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2985g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2985g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2980b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2983e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2984f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2985g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2981c = findViewById(p012d.f.f9192a);
        this.f2982d = findViewById(p012d.f.f9197f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2979a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        Drawable drawable;
        super.onLayout(z3, i3, i4, i5, i6);
        View view = this.f2980b;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i7 = layoutParams.bottomMargin;
            view.layout(i3, measuredHeight2 - i7, i5, measuredHeight - i7);
        }
        if (this.f2986h) {
            Drawable drawable2 = this.f2985g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z4 = false;
            }
        } else {
            if (this.f2983e != null) {
                if (this.f2981c.getVisibility() == 0) {
                    this.f2983e.setBounds(this.f2981c.getLeft(), this.f2981c.getTop(), this.f2981c.getRight(), this.f2981c.getBottom());
                } else {
                    View view2 = this.f2982d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f2983e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2983e.setBounds(this.f2982d.getLeft(), this.f2982d.getTop(), this.f2982d.getRight(), this.f2982d.getBottom());
                    }
                }
                z5 = true;
            }
            this.f2987i = z6;
            if (!z6 || (drawable = this.f2984f) == null) {
                z4 = z5;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int iA;
        int i5;
        if (this.f2981c == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f2988j) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        if (this.f2981c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View view = this.f2980b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f2981c)) {
            iA = !b(this.f2982d) ? a(this.f2982d) : 0;
        } else {
            iA = a(this.f2981c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.f2980b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i4) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2983e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2983e);
        }
        this.f2983e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2981c;
            if (view != null) {
                this.f2983e.setBounds(view.getLeft(), this.f2981c.getTop(), this.f2981c.getRight(), this.f2981c.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f2986h ? !(this.f2983e != null || this.f2984f != null) : this.f2985g == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2985g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2985g);
        }
        this.f2985g = drawable;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2986h && (drawable2 = this.f2985g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2986h ? !(this.f2983e != null || this.f2984f != null) : this.f2985g == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2984f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2984f);
        }
        this.f2984f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2987i && (drawable2 = this.f2984f) != null) {
                drawable2.setBounds(this.f2980b.getLeft(), this.f2980b.getTop(), this.f2980b.getRight(), this.f2980b.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f2986h ? !(this.f2983e != null || this.f2984f != null) : this.f2985g == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setTabContainer(d0 d0Var) {
        View view = this.f2980b;
        if (view != null) {
            removeView(view);
        }
        this.f2980b = d0Var;
    }

    public void setTransitioning(boolean z3) {
        this.f2979a = z3;
        setDescendantFocusability(z3 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f2983e;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
        Drawable drawable2 = this.f2984f;
        if (drawable2 != null) {
            drawable2.setVisible(z3, false);
        }
        Drawable drawable3 = this.f2985g;
        if (drawable3 != null) {
            drawable3.setVisible(z3, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2983e && !this.f2986h) || (drawable == this.f2984f && this.f2987i) || ((drawable == this.f2985g && this.f2986h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }
}
