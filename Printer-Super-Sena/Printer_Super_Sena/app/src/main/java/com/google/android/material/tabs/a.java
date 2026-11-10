package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class a extends c {
    a() {
    }

    private static float e(float f3) {
        double d3 = f3;
        Double.isNaN(d3);
        return (float) (1.0d - Math.cos((d3 * 3.141592653589793d) / 2.0d));
    }

    private static float f(float f3) {
        double d3 = f3;
        Double.isNaN(d3);
        return (float) Math.sin((d3 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        float f4;
        float fE;
        RectF rectFA = c.a(tabLayout, view);
        RectF rectFA2 = c.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f4 = e(f3);
            fE = f(f3);
        } else {
            f4 = f(f3);
            fE = e(f3);
        }
        drawable.setBounds(T0.a.c((int) rectFA.left, (int) rectFA2.left, f4), drawable.getBounds().top, T0.a.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}
