package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f5041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f5042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f5043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5044d;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(View view) {
        ArrayList arrayList = this.f5042b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f5041a == null) {
            this.f5041a = new ArrayList();
        }
        this.f5041a.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (o.w0(view) != null) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        if (o.w0(view) != null) {
            return super.addViewInLayout(view, i3, layoutParams, z3);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C0332z0 c0332z0X = C0332z0.x(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f5043c;
        C0332z0 c0332z0X2 = onApplyWindowInsetsListener != null ? C0332z0.x(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : Z.c0(this, c0332z0X);
        if (!c0332z0X2.q()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Z.i(getChildAt(i3), c0332z0X2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f5044d && this.f5041a != null) {
            for (int i3 = 0; i3 < this.f5041a.size(); i3++) {
                super.drawChild(canvas, (View) this.f5041a.get(i3), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        ArrayList arrayList;
        if (!this.f5044d || (arrayList = this.f5041a) == null || arrayList.size() <= 0 || !this.f5041a.contains(view)) {
            return super.drawChild(canvas, view, j3);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList arrayList = this.f5042b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f5041a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f5044d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z3) {
        if (z3) {
            a(view);
        }
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        a(getChildAt(i3));
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViewsInLayout(i3, i4);
    }

    void setDrawDisappearingViewsLast(boolean z3) {
        this.f5044d = z3;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f5043c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f5042b == null) {
                this.f5042b = new ArrayList();
            }
            this.f5042b.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i3) {
        String str;
        super(context, attributeSet, i3);
        this.f5044d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O.c.f1389h);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(O.c.f1390i);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, o oVar) {
        String str;
        super(context, attributeSet);
        this.f5044d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O.c.f1389h);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(O.c.f1390i) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(O.c.f1391j);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eD0 = oVar.d0(id);
        if (classAttribute != null && abstractComponentCallbacksC0337eD0 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eA = oVar.n0().a(context.getClassLoader(), classAttribute);
            abstractComponentCallbacksC0337eA.B0(context, attributeSet, null);
            oVar.j().q(true).c(this, abstractComponentCallbacksC0337eA, string).i();
        }
        oVar.Q0(this);
    }
}
