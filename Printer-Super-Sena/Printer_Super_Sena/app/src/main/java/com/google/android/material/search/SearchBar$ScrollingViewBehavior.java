package com.google.android.material.search;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8388h;

    public SearchBar$ScrollingViewBehavior() {
        this.f8388h = false;
    }

    private void Y(AppBarLayout appBarLayout) {
        appBarLayout.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT == 21) {
            appBarLayout.setOutlineProvider(null);
        } else {
            appBarLayout.setTargetElevation(0.0f);
        }
    }

    @Override // com.google.android.material.appbar.k
    protected boolean T() {
        return true;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
        boolean zL = super.l(coordinatorLayout, view, view2);
        if (!this.f8388h && (view2 instanceof AppBarLayout)) {
            this.f8388h = true;
            Y((AppBarLayout) view2);
        }
        return zL;
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8388h = false;
    }
}
