package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f4465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f4467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4468d;

    /* JADX INFO: renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    static class C0055a {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f3, float f4) {
            drawable.setHotspot(f3, f4);
        }

        static void f(Drawable drawable, int i3, int i4, int i5, int i6) {
            drawable.setHotspotBounds(i3, i4, i5, i6);
        }

        static void g(Drawable drawable, int i3) {
            drawable.setTint(i3);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class b {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i3) {
            return drawable.setLayoutDirection(i3);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.a(drawable, theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0055a.b(drawable);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (i3 < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof c) {
            c(((c) drawable).a());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            Drawable child = drawableContainerState.getChild(i4);
            if (child != null) {
                c(child);
            }
        }
    }

    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0055a.c(drawable);
        }
        return null;
    }

    public static int f(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(drawable);
        }
        if (!f4468d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f4467c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e3) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e3);
            }
            f4468d = true;
        }
        Method method = f4467c;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception e4) {
            Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e4);
            f4467c = null;
            return 0;
        }
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.d(drawable, resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z3) {
        drawable.setAutoMirrored(z3);
    }

    public static void k(Drawable drawable, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.e(drawable, f3, f4);
        }
    }

    public static void l(Drawable drawable, int i3, int i4, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.f(drawable, i3, i4, i5, i6);
        }
    }

    public static boolean m(Drawable drawable, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b(drawable, i3);
        }
        if (!f4466b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f4465a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e3) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e3);
            }
            f4466b = true;
        }
        Method method = f4465a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i3));
                return true;
            } catch (Exception e4) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e4);
                f4465a = null;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n(Drawable drawable, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.g(drawable, i3);
        } else if (drawable instanceof androidx.core.graphics.drawable.b) {
            ((androidx.core.graphics.drawable.b) drawable).setTint(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.h(drawable, colorStateList);
        } else if (drawable instanceof androidx.core.graphics.drawable.b) {
            ((androidx.core.graphics.drawable.b) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0055a.i(drawable, mode);
        } else if (drawable instanceof androidx.core.graphics.drawable.b) {
            ((androidx.core.graphics.drawable.b) drawable).setTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable q(Drawable drawable) {
        return drawable instanceof c ? ((c) drawable).a() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable;
        }
        if (i3 >= 21) {
            return !(drawable instanceof androidx.core.graphics.drawable.b) ? new l(drawable) : drawable;
        }
        return !(drawable instanceof androidx.core.graphics.drawable.b) ? new d(drawable) : drawable;
    }
}
