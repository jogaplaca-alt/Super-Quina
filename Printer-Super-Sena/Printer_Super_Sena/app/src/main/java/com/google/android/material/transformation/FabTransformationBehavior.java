package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f8826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f8827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f8828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f8829e;

    public FabTransformationBehavior() {
        this.f8826b = new Rect();
        this.f8827c = new RectF();
        this.f8828d = new RectF();
        this.f8829e = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        if (fVar.f4221h == 0) {
            fVar.f4221h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8826b = new Rect();
        this.f8827c = new RectF();
        this.f8828d = new RectF();
        this.f8829e = new int[2];
    }
}
