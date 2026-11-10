package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.C;

/* JADX INFO: loaded from: classes.dex */
abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f7673a = {R.attr.stateListAnimator};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(View view, float f3) {
        int integer = view.getResources().getInteger(S0.f.f1658a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j3 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, S0.a.f1500R, -S0.a.f1501S}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j3));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f3).setDuration(j3));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(View view, AttributeSet attributeSet, int i3, int i4) {
        Context context = view.getContext();
        TypedArray typedArrayI = C.i(context, attributeSet, f7673a, i3, i4, new int[0]);
        try {
            if (typedArrayI.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayI.getResourceId(0, 0)));
            }
        } finally {
            typedArrayI.recycle();
        }
    }
}
