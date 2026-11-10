package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.view.AbstractC0305l0;

/* JADX INFO: renamed from: com.google.android.material.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0493g {
    public static void a(Window window, boolean z3, Integer num, Integer num2) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z4 = num == null || num.intValue() == 0;
        boolean z5 = num2 == null || num2.intValue() == 0;
        if (z4 || z5) {
            int iB = p002a1.a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z4) {
                num = Integer.valueOf(iB);
            }
            if (z5) {
                num2 = Integer.valueOf(iB);
            }
        }
        AbstractC0305l0.b(window, !z3);
        int iC = c(window.getContext(), z3);
        int iB2 = b(window.getContext(), z3);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, p002a1.a.i(num.intValue())));
        e(window, d(iB2, p002a1.a.i(num2.intValue())));
    }

    private static int b(Context context, boolean z3) {
        if (z3 && Build.VERSION.SDK_INT < 27) {
            return androidx.core.graphics.d.k(p002a1.a.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z3) {
            return 0;
        }
        return p002a1.a.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z3) {
        if (z3 && Build.VERSION.SDK_INT < 23) {
            return androidx.core.graphics.d.k(p002a1.a.b(context, R.attr.statusBarColor, -16777216), 128);
        }
        if (z3) {
            return 0;
        }
        return p002a1.a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i3, boolean z3) {
        return p002a1.a.i(i3) || (i3 == 0 && z3);
    }

    public static void e(Window window, boolean z3) {
        AbstractC0305l0.a(window, window.getDecorView()).a(z3);
    }

    public static void f(Window window, boolean z3) {
        AbstractC0305l0.a(window, window.getDecorView()).b(z3);
    }
}
