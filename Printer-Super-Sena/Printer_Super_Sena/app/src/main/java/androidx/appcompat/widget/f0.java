package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f3500a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f3501b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f3502c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f3503d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f3504e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f3505f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f3506g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f3507h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f3508i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f3509j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(p012d.j.f9439y0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(p012d.j.f9270D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i3) {
        ColorStateList colorStateListE = e(context, i3);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f3501b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i3, typedValueF.getFloat());
    }

    public static int c(Context context, int i3) {
        int[] iArr = f3509j;
        iArr[0] = i3;
        j0 j0VarU = j0.u(context, null, iArr);
        try {
            return j0VarU.b(0, 0);
        } finally {
            j0VarU.w();
        }
    }

    static int d(Context context, int i3, float f3) {
        int iC = c(context, i3);
        return androidx.core.graphics.d.k(iC, Math.round(Color.alpha(iC) * f3));
    }

    public static ColorStateList e(Context context, int i3) {
        int[] iArr = f3509j;
        iArr[0] = i3;
        j0 j0VarU = j0.u(context, null, iArr);
        try {
            return j0VarU.c(0);
        } finally {
            j0VarU.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f3500a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
