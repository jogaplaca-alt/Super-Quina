package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4396a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f4397b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4398c = new Object();

    static class a {
        static Drawable a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getDrawable(i3, theme);
        }

        static Drawable b(Resources resources, int i3, int i4, Resources.Theme theme) {
            return resources.getDrawableForDensity(i3, i4, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColor(i3, theme);
        }

        static ColorStateList b(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColorStateList(i3, theme);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f4399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f4400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f4401c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f4399a = colorStateList;
            this.f4400b = configuration;
            this.f4401c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Resources f4402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f4403b;

        d(Resources resources, Resources.Theme theme) {
            this.f4402a = resources;
            this.f4403b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4402a.equals(dVar.f4402a) && p082z.c.a(this.f4403b, dVar.f4403b);
        }

        public int hashCode() {
            return p082z.c.b(this.f4402a, this.f4403b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i3, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4409a.f(i3);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4407a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i3);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static final class f {

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f4404a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f4405b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f4406c;

            /* JADX WARN: Code duplicated, block: B:31:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            static void a(Resources.Theme theme) {
                Method method;
                synchronized (f4404a) {
                    if (f4406c) {
                        method = f4405b;
                        if (method != null) {
                            method.invoke(theme, null);
                        }
                    } else {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            f4405b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e3) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e3);
                        }
                        f4406c = true;
                        method = f4405b;
                        if (method != null) {
                            try {
                                method.invoke(theme, null);
                            } catch (IllegalAccessException | InvocationTargetException e4) {
                                Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e4);
                                f4405b = null;
                            }
                        }
                    }
                    throw th;
                }
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                b.a(theme);
            } else if (i3 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(d dVar, int i3, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f4398c) {
            try {
                WeakHashMap weakHashMap = f4397b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i3, new c(colorStateList, dVar.f4402a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f4401c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.h.d r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.h.f4398c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = androidx.core.content.res.h.f4397b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.h$c r2 = (androidx.core.content.res.h.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f4400b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f4402a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f4403b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f4401c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f4401c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f4399a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.b(androidx.core.content.res.h$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList d(Resources resources, int i3, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i3);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListK = k(resources, i3, theme);
        if (colorStateListK == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i3, theme) : resources.getColorStateList(i3);
        }
        a(dVar, i3, colorStateListK, theme);
        return colorStateListK;
    }

    public static Drawable e(Resources resources, int i3, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? a.a(resources, i3, theme) : resources.getDrawable(i3);
    }

    public static Drawable f(Resources resources, int i3, int i4, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? a.b(resources, i3, i4, theme) : resources.getDrawableForDensity(i3, i4);
    }

    public static Typeface g(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface h(Context context, int i3, TypedValue typedValue, int i4, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i3, typedValue, i4, eVar, null, true, false);
    }

    public static void i(Context context, int i3, e eVar, Handler handler) {
        p082z.h.g(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            m(context, i3, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    private static TypedValue j() {
        ThreadLocal threadLocal = f4396a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList k(Resources resources, int i3, Resources.Theme theme) {
        if (l(resources, i3)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i3), theme);
        } catch (Exception e3) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e3);
            return null;
        }
    }

    private static boolean l(Resources resources, int i3) {
        TypedValue typedValueJ = j();
        resources.getValue(i3, typedValueJ, true);
        int i4 = typedValueJ.type;
        return i4 >= 28 && i4 <= 31;
    }

    private static Typeface m(Context context, int i3, TypedValue typedValue, int i4, e eVar, Handler handler, boolean z3, boolean z4) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface typefaceN = n(context, resources, typedValue, i3, i4, eVar, handler, z3, z4);
        if (typefaceN != null || eVar != null || z4) {
            return typefaceN;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    private static Typeface n(Context context, Resources resources, TypedValue typedValue, int i3, int i4, e eVar, Handler handler, boolean z3, boolean z4) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i3) + "\" (" + Integer.toHexString(i3) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        int i5 = 0;
        if (!string.startsWith("res/")) {
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = androidx.core.graphics.h.f(resources, i3, string, typedValue.assetCookie, i4);
        if (typefaceF != null) {
            if (eVar != null) {
                eVar.d(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z4) {
            return null;
        }
        try {
            try {
                if (!string.toLowerCase().endsWith(".xml")) {
                    Typeface typefaceD = androidx.core.graphics.h.d(context, resources, i3, string, typedValue.assetCookie, i4);
                    if (eVar != null) {
                        if (typefaceD != null) {
                            eVar.d(typefaceD, handler);
                        } else {
                            eVar.c(-3, handler);
                        }
                    }
                    return typefaceD;
                }
                androidx.core.content.res.e.b bVarB = androidx.core.content.res.e.b(resources.getXml(i3), resources);
                if (bVarB != null) {
                    return androidx.core.graphics.h.c(context, bVarB, resources, i3, string, typedValue.assetCookie, i4, eVar, handler, z3);
                }
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                if (eVar != null) {
                    eVar.c(-3, handler);
                }
                return null;
            } catch (IOException e3) {
                e = e3;
                Log.e("ResourcesCompat", "Failed to read xml resource " + string, e);
                if (eVar != null) {
                    return null;
                }
                eVar.c(i5, handler);
                return null;
            } catch (XmlPullParserException e4) {
                e = e4;
                Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e);
                if (eVar != null) {
                    return null;
                }
                eVar.c(i5, handler);
                return null;
            }
        } catch (IOException e5) {
            e = e5;
            i5 = -3;
        } catch (XmlPullParserException e6) {
            e = e6;
            i5 = -3;
        }
    }
}
