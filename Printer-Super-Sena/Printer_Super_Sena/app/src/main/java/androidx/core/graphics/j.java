package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class j extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f4499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f4500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f4501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f4502e;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi24Impl", e3.getClass().getName(), e3);
            method = null;
            cls = null;
            method2 = null;
        }
        f4500c = constructor;
        f4499b = cls;
        f4501d = method2;
        f4502e = method;
    }

    j() {
    }

    private static boolean l(Object obj, ByteBuffer byteBuffer, int i3, int i4, boolean z3) {
        try {
            return ((Boolean) f4501d.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Boolean.valueOf(z3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4499b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4502e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean n() {
        Method method = f4501d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object o() {
        try {
            return f4500c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.n
    public Typeface b(Context context, androidx.core.content.res.e.c cVar, Resources resources, int i3) {
        Object objO = o();
        if (objO == null) {
            return null;
        }
        for (androidx.core.content.res.e.d dVar : cVar.a()) {
            ByteBuffer byteBufferB = o.b(context, resources, dVar.b());
            if (byteBufferB == null || !l(objO, byteBufferB, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return m(objO);
    }

    @Override // androidx.core.graphics.n
    public Typeface c(Context context, CancellationSignal cancellationSignal, y.h.b[] bVarArr, int i3) {
        Object objO = o();
        if (objO == null) {
            return null;
        }
        p046n.g gVar = new p046n.g();
        for (y.h.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) gVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = o.f(context, cancellationSignal, uriD);
                gVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !l(objO, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceM = m(objO);
        if (typefaceM == null) {
            return null;
        }
        return Typeface.create(typefaceM, i3);
    }
}
