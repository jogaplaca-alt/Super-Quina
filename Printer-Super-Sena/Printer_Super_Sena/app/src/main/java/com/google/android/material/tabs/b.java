package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class b extends c {
    b() {
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        if (f3 >= 0.5f) {
            view = view2;
        }
        RectF rectFA = c.a(tabLayout, view);
        float fB = f3 < 0.5f ? T0.a.b(1.0f, 0.0f, 0.0f, 0.5f, f3) : T0.a.b(0.0f, 1.0f, 0.5f, 1.0f, f3);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fB * 255.0f));
    }
}
