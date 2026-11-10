package p002a1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.d;
import p030h1.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(int i3, int i4) {
        return d.k(i3, (Color.alpha(i3) * i4) / 255);
    }

    public static int b(Context context, int i3, int i4) {
        Integer numF = f(context, i3);
        return numF != null ? numF.intValue() : i4;
    }

    public static int c(Context context, int i3, String str) {
        return m(context, b.e(context, i3, str));
    }

    public static int d(View view, int i3) {
        return m(view.getContext(), b.f(view, i3));
    }

    public static int e(View view, int i3, int i4) {
        return b(view.getContext(), i3, i4);
    }

    public static Integer f(Context context, int i3) {
        TypedValue typedValueA = b.a(context, i3);
        if (typedValueA != null) {
            return Integer.valueOf(m(context, typedValueA));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i3, ColorStateList colorStateList) {
        TypedValue typedValueA = b.a(context, i3);
        ColorStateList colorStateListN = typedValueA != null ? n(context, typedValueA) : null;
        return colorStateListN == null ? colorStateList : colorStateListN;
    }

    public static ColorStateList h(Context context, int i3) {
        TypedValue typedValueA = b.a(context, i3);
        if (typedValueA == null) {
            return null;
        }
        int i4 = typedValueA.resourceId;
        if (i4 != 0) {
            return androidx.core.content.a.c(context, i4);
        }
        int i5 = typedValueA.data;
        if (i5 != 0) {
            return ColorStateList.valueOf(i5);
        }
        return null;
    }

    public static boolean i(int i3) {
        return i3 != 0 && d.d(i3) > 0.5d;
    }

    public static int j(int i3, int i4) {
        return d.g(i4, i3);
    }

    public static int k(int i3, int i4, float f3) {
        return j(i3, d.k(i4, Math.round(Color.alpha(i4) * f3)));
    }

    public static int l(View view, int i3, int i4, float f3) {
        return k(d(view, i3), d(view, i4), f3);
    }

    private static int m(Context context, TypedValue typedValue) {
        int i3 = typedValue.resourceId;
        return i3 != 0 ? androidx.core.content.a.b(context, i3) : typedValue.data;
    }

    private static ColorStateList n(Context context, TypedValue typedValue) {
        int i3 = typedValue.resourceId;
        return i3 != 0 ? androidx.core.content.a.c(context, i3) : ColorStateList.valueOf(typedValue.data);
    }
}
