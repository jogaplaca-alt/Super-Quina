package p033i1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f9652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f9653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f9655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f9656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f9657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f9658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f9659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f9660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f9661l;

    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable b(Context context, int i3) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(p002a1.a.g(context, S0.a.f1516h, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i3, i3, i3, i3));
        }
    }

    static {
        f9650a = Build.VERSION.SDK_INT >= 21;
        f9651b = new int[]{R.attr.state_pressed};
        f9652c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f9653d = new int[]{R.attr.state_focused};
        f9654e = new int[]{R.attr.state_hovered};
        f9655f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f9656g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f9657h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f9658i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f9659j = new int[]{R.attr.state_selected};
        f9660k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f9661l = b.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f9650a) {
            int[] iArr = f9653d;
            return new ColorStateList(new int[][]{f9659j, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f9655f), d(colorStateList, iArr), d(colorStateList, f9651b)});
        }
        int[] iArr2 = f9655f;
        int[] iArr3 = f9656g;
        int[] iArr4 = f9657h;
        int[] iArr5 = f9658i;
        int[] iArr6 = f9651b;
        int[] iArr7 = f9652c;
        int[] iArr8 = f9653d;
        int[] iArr9 = f9654e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f9659j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{d(colorStateList, iArr2), d(colorStateList, iArr3), d(colorStateList, iArr4), d(colorStateList, iArr5), 0, d(colorStateList, iArr6), d(colorStateList, iArr7), d(colorStateList, iArr8), d(colorStateList, iArr9), 0});
    }

    public static Drawable b(Context context, int i3) {
        return a.b(context, i3);
    }

    private static int c(int i3) {
        return d.k(i3, Math.min(Color.alpha(i3) * 2, 255));
    }

    private static int d(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f9650a ? c(colorForState) : colorForState;
    }

    public static ColorStateList e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 22 && i3 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f9660k, 0)) != 0) {
            Log.w(f9661l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean f(int[] iArr) {
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z3 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z4 = true;
            }
        }
        return z3 && z4;
    }
}
