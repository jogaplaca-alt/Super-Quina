package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class k extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f7659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f7660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7662g;

    public k() {
        this.f7659d = new Rect();
        this.f7660e = new Rect();
        this.f7661f = 0;
    }

    private static int R(int i3) {
        if (i3 == 0) {
            return 8388659;
        }
        return i3;
    }

    @Override // com.google.android.material.appbar.l
    protected void J(CoordinatorLayout coordinatorLayout, View view, int i3) {
        View viewL = L(coordinatorLayout.s(view));
        if (viewL == null) {
            super.J(coordinatorLayout, view, i3);
            this.f7661f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f7659d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewL.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewL.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        C0332z0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && Z.z(coordinatorLayout) && !Z.z(view)) {
            rect.left += lastWindowInsets.j();
            rect.right -= lastWindowInsets.k();
        }
        Rect rect2 = this.f7660e;
        androidx.core.view.r.a(R(fVar.f4216c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i3);
        int iM = M(viewL);
        view.layout(rect2.left, rect2.top - iM, rect2.right, rect2.bottom - iM);
        this.f7661f = rect2.top - viewL.getBottom();
    }

    abstract View L(List list);

    final int M(View view) {
        if (this.f7662g == 0) {
            return 0;
        }
        float fN = N(view);
        int i3 = this.f7662g;
        return p076x.a.b((int) (fN * i3), 0, i3);
    }

    abstract float N(View view);

    public final int O() {
        return this.f7662g;
    }

    int P(View view) {
        return view.getMeasuredHeight();
    }

    final int Q() {
        return this.f7661f;
    }

    public final void S(int i3) {
        this.f7662g = i3;
    }

    protected boolean T() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        View viewL;
        C0332z0 lastWindowInsets;
        int i7 = view.getLayoutParams().height;
        if ((i7 != -1 && i7 != -2) || (viewL = L(coordinatorLayout.s(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (Z.z(viewL) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.l() + lastWindowInsets.i();
        }
        int iP = size + P(viewL);
        int measuredHeight = viewL.getMeasuredHeight();
        if (T()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iP -= measuredHeight;
        }
        coordinatorLayout.L(view, i3, i4, View.MeasureSpec.makeMeasureSpec(iP, i7 == -1 ? 1073741824 : Integer.MIN_VALUE), i6);
        return true;
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7659d = new Rect();
        this.f7660e = new Rect();
        this.f7661f = 0;
    }
}
