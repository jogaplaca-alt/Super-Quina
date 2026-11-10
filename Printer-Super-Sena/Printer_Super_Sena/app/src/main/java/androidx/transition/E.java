package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6549a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f6550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f6552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f6553e;

    static class a {
        static float a(View view) {
            return view.getTransitionAlpha();
        }

        static void b(View view, float f3) {
            view.setTransitionAlpha(f3);
        }
    }

    E() {
    }

    private void b() {
        if (f6551c) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f6550b = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e3) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setFrame method", e3);
        }
        f6551c = true;
    }

    public void a(View view) {
    }

    public float c(View view) {
        if (f6549a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f6549a = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view) {
    }

    public void e(View view, int i3, int i4, int i5, int i6) {
        b();
        Method method = f6550b;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    public void f(View view, float f3) {
        if (f6549a) {
            try {
                a.b(view, f3);
                return;
            } catch (NoSuchMethodError unused) {
                f6549a = false;
            }
        }
        view.setAlpha(f3);
    }

    public void g(View view, int i3) {
        if (!f6553e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f6552d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f6553e = true;
        }
        Field field = f6552d;
        if (field != null) {
            try {
                f6552d.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            h(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void i(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
