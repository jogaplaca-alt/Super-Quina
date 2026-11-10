package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f4820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f4822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4823d;

    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z3) {
            popupWindow.setOverlapAnchor(z3);
        }

        static void d(PopupWindow popupWindow, int i3) {
            popupWindow.setWindowLayoutType(i3);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z3) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            a.c(popupWindow, z3);
            return;
        }
        if (i3 >= 21) {
            if (!f4823d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f4822c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e3);
                }
                f4823d = true;
            }
            Field field = f4822c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z3));
                } catch (IllegalAccessException e4) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e4);
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i3);
            return;
        }
        if (!f4821b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f4820a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f4821b = true;
        }
        Method method = f4820a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i3));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i3, int i4, int i5) {
        popupWindow.showAsDropDown(view, i3, i4, i5);
    }
}
