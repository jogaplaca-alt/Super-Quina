package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.H;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;
import java.util.List;
import p014d1.a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8825a;

    public ExpandableBehavior() {
        this.f8825a = 0;
    }

    protected a I(CoordinatorLayout coordinatorLayout, View view) {
        List listS = coordinatorLayout.s(view);
        int size = listS.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) listS.get(i3);
            if (i(coordinatorLayout, view, view2)) {
                H.a(view2);
                return null;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean i(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
        H.a(view2);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (Z.U(view)) {
            return false;
        }
        I(coordinatorLayout, view);
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8825a = 0;
    }
}
