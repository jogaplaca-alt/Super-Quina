package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f2432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class f2434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f2436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f2438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f2439h;

    static class a {
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    static void a(Resources resources) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return;
        }
        if (i3 >= 24) {
            d(resources);
        } else if (i3 >= 23) {
            c(resources);
        } else if (i3 >= 21) {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f2433b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2432a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e3);
            }
            f2433b = true;
        }
        Field field = f2432a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e4);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        Object obj;
        if (!f2433b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2432a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e3);
            }
            f2433b = true;
        }
        Field field = f2432a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e4);
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f2439h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f2438g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e3);
            }
            f2439h = true;
        }
        Field field = f2438g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e4);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f2433b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f2432a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e5);
            }
            f2433b = true;
        }
        Field field2 = f2432a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e6);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f2435d) {
            try {
                f2434c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e3) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e3);
            }
            f2435d = true;
        }
        Class cls = f2434c;
        if (cls == null) {
            return;
        }
        if (!f2437f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f2436e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e4);
            }
            f2437f = true;
        }
        Field field = f2436e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e5) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e5);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
