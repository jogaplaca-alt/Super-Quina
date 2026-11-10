package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import rawbt.api.Constant;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3123a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3124b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f3125c = new Rect();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final boolean f3126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Method f3127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Field f3128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Field f3129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Field f3130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Field f3131f;

        /* JADX WARN: Code duplicated, block: B:26:0x0056  */
        /* JADX WARN: Code duplicated, block: B:27:0x0063  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z3;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", null);
                try {
                    field = cls.getField(Constant.ALIGNMENT_LEFT);
                    try {
                        field2 = cls.getField("top");
                        try {
                            field3 = cls.getField(Constant.ALIGNMENT_RIGHT);
                            try {
                                field4 = cls.getField("bottom");
                                z3 = true;
                            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                                field4 = null;
                                z3 = false;
                            }
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                            field3 = null;
                        }
                    } catch (ClassNotFoundException unused3) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z3 = false;
                        if (z3) {
                            f3127b = method;
                            f3128c = field;
                            f3129d = field2;
                            f3130e = field3;
                            f3131f = field4;
                            f3126a = true;
                            return;
                        }
                        f3127b = null;
                        f3128c = null;
                        f3129d = null;
                        f3130e = null;
                        f3131f = null;
                        f3126a = false;
                    } catch (NoSuchFieldException unused4) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z3 = false;
                        if (z3) {
                            f3127b = method;
                            f3128c = field;
                            f3129d = field2;
                            f3130e = field3;
                            f3131f = field4;
                            f3126a = true;
                            return;
                        }
                        f3127b = null;
                        f3128c = null;
                        f3129d = null;
                        f3130e = null;
                        f3131f = null;
                        f3126a = false;
                    } catch (NoSuchMethodException unused5) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z3 = false;
                        if (z3) {
                            f3127b = method;
                            f3128c = field;
                            f3129d = field2;
                            f3130e = field3;
                            f3131f = field4;
                            f3126a = true;
                            return;
                        }
                        f3127b = null;
                        f3128c = null;
                        f3129d = null;
                        f3130e = null;
                        f3131f = null;
                        f3126a = false;
                    }
                } catch (ClassNotFoundException unused6) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z3 = false;
                    if (z3) {
                        f3127b = method;
                        f3128c = field;
                        f3129d = field2;
                        f3130e = field3;
                        f3131f = field4;
                        f3126a = true;
                        return;
                    }
                    f3127b = null;
                    f3128c = null;
                    f3129d = null;
                    f3130e = null;
                    f3131f = null;
                    f3126a = false;
                } catch (NoSuchFieldException unused7) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z3 = false;
                    if (z3) {
                        f3127b = method;
                        f3128c = field;
                        f3129d = field2;
                        f3130e = field3;
                        f3131f = field4;
                        f3126a = true;
                        return;
                    }
                    f3127b = null;
                    f3128c = null;
                    f3129d = null;
                    f3130e = null;
                    f3131f = null;
                    f3126a = false;
                } catch (NoSuchMethodException unused8) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z3 = false;
                    if (z3) {
                        f3127b = method;
                        f3128c = field;
                        f3129d = field2;
                        f3130e = field3;
                        f3131f = field4;
                        f3126a = true;
                        return;
                    }
                    f3127b = null;
                    f3128c = null;
                    f3129d = null;
                    f3130e = null;
                    f3131f = null;
                    f3126a = false;
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (z3) {
                f3127b = method;
                f3128c = field;
                f3129d = field2;
                f3130e = field3;
                f3131f = field4;
                f3126a = true;
                return;
            }
            f3127b = null;
            f3128c = null;
            f3129d = null;
            f3130e = null;
            f3131f = null;
            f3126a = false;
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f3126a) {
                try {
                    Object objInvoke = f3127b.invoke(drawable, null);
                    if (objInvoke != null) {
                        return new Rect(f3128c.getInt(objInvoke), f3129d.getInt(objInvoke), f3130e.getInt(objInvoke), f3131f.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return S.f3125c;
        }
    }

    static class b {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        return true;
    }

    static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else {
            if (i3 < 29 || i3 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
                return;
            }
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f3123a);
        } else {
            drawable.setState(f3124b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(androidx.core.graphics.drawable.a.q(drawable));
        }
        Insets insetsA = b.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode e(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
