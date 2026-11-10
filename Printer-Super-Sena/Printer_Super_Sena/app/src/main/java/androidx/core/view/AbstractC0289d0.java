package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.core.view.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0289d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f4647a;

    /* JADX INFO: renamed from: androidx.core.view.d0$a */
    static class a {
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d0$b */
    static class b {
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.d0$c */
    static class c {
        static int a(ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i3, i4, i5);
        }

        static int b(ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i3, i4, i5);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f4647a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private static int a(Resources resources, int i3, p082z.i iVar, int i4) {
        int dimensionPixelSize;
        if (i3 != -1) {
            return (i3 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i3)) < 0) ? i4 : dimensionPixelSize;
        }
        return ((Integer) iVar.get()).intValue();
    }

    private static float b(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f4647a) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private static int c(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int d(Resources resources, int i3, int i4) {
        if (i3 == 4194304 && i4 == 26) {
            return c(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int e(Resources resources, int i3, int i4) {
        if (i3 == 4194304 && i4 == 26) {
            return c(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float f(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : b(viewConfiguration, context);
    }

    public static int g(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int h(Context context, final ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i3, i4, i5);
        }
        if (!k(i3, i4, i5)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i5, i4);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new p082z.i() { // from class: androidx.core.view.b0
            @Override // p082z.i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int i(Context context, final ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i3, i4, i5);
        }
        if (!k(i3, i4, i5)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iE = e(resources, i5, i4);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iE, new p082z.i() { // from class: androidx.core.view.c0
            @Override // p082z.i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }

    public static float j(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : b(viewConfiguration, context);
    }

    private static boolean k(int i3, int i4, int i5) {
        InputDevice device = InputDevice.getDevice(i3);
        return (device == null || device.getMotionRange(i4, i5) == null) ? false : true;
    }

    public static boolean l(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int iC = c(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return iC != 0 && resources.getBoolean(iC);
    }
}
