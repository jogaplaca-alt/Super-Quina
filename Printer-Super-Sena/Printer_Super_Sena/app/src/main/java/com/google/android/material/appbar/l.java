package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
abstract class l extends CoordinatorLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7665c;

    public l() {
        this.f7664b = 0;
        this.f7665c = 0;
    }

    public int I() {
        m mVar = this.f7663a;
        if (mVar != null) {
            return mVar.b();
        }
        return 0;
    }

    protected void J(CoordinatorLayout coordinatorLayout, View view, int i3) {
        coordinatorLayout.K(view, i3);
    }

    public boolean K(int i3) {
        m mVar = this.f7663a;
        if (mVar != null) {
            return mVar.e(i3);
        }
        this.f7664b = i3;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        J(coordinatorLayout, view, i3);
        if (this.f7663a == null) {
            this.f7663a = new m(view);
        }
        this.f7663a.c();
        this.f7663a.a();
        int i4 = this.f7664b;
        if (i4 != 0) {
            this.f7663a.e(i4);
            this.f7664b = 0;
        }
        int i5 = this.f7665c;
        if (i5 == 0) {
            return true;
        }
        this.f7663a.d(i5);
        this.f7665c = 0;
        return true;
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7664b = 0;
        this.f7665c = 0;
    }
}
