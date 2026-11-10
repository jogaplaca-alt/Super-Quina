package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.F;

/* JADX INFO: loaded from: classes.dex */
class c {
    c() {
    }

    static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        return (tabLayout.C() || !(view instanceof TabLayout.f)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.f) view, 24);
    }

    static RectF b(TabLayout.f fVar, int i3) {
        int contentWidth = fVar.getContentWidth();
        int contentHeight = fVar.getContentHeight();
        int iC = (int) F.c(fVar.getContext(), i3);
        if (contentWidth < iC) {
            contentWidth = iC;
        }
        int left = (fVar.getLeft() + fVar.getRight()) / 2;
        int top = (fVar.getTop() + fVar.getBottom()) / 2;
        int i4 = contentWidth / 2;
        return new RectF(left - i4, top - (contentHeight / 2), i4 + left, top + (left / 2));
    }

    void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(T0.a.c((int) rectFA.left, (int) rectFA2.left, f3), drawable.getBounds().top, T0.a.c((int) rectFA.right, (int) rectFA2.right, f3), drawable.getBounds().bottom);
    }
}
