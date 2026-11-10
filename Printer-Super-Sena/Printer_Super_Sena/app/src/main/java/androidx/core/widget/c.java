package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f4817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4818b;

    static class a {
        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b {
        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(compoundButton);
        }
        if (!f4818b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f4817a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e3);
            }
            f4818b = true;
        }
        Field field = f4817a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e4) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e4);
                f4817a = null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(compoundButton);
        }
        if (compoundButton instanceof n) {
            return ((n) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode c(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(compoundButton);
        }
        if (compoundButton instanceof n) {
            return ((n) compoundButton).getSupportButtonTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.c(compoundButton, colorStateList);
        } else if (compoundButton instanceof n) {
            ((n) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.d(compoundButton, mode);
        } else if (compoundButton instanceof n) {
            ((n) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
