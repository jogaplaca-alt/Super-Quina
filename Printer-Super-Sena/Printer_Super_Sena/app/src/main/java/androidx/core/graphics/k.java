package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Class f4503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Constructor f4504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Method f4505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Method f4506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Method f4507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final Method f4508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Method f4509m;

    public k() {
        Class clsZ;
        Constructor constructorA;
        Method methodW;
        Method methodX;
        Method methodB;
        Method methodV;
        Method methodY;
        try {
            clsZ = z();
            constructorA = A(clsZ);
            methodW = w(clsZ);
            methodX = x(clsZ);
            methodB = B(clsZ);
            methodV = v(clsZ);
            methodY = y(clsZ);
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e3.getClass().getName(), e3);
            clsZ = null;
            constructorA = null;
            methodW = null;
            methodX = null;
            methodB = null;
            methodV = null;
            methodY = null;
        }
        this.f4503g = clsZ;
        this.f4504h = constructorA;
        this.f4505i = methodW;
        this.f4506j = methodX;
        this.f4507k = methodB;
        this.f4508l = methodV;
        this.f4509m = methodY;
    }

    private Object p() {
        try {
            return this.f4504h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void q(Object obj) {
        try {
            this.f4508l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean r(Context context, Object obj, String str, int i3, int i4, int i5, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4505i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj, ByteBuffer byteBuffer, int i3, int i4, int i5) {
        try {
            return ((Boolean) this.f4506j.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Integer.valueOf(i5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t(Object obj) {
        try {
            return ((Boolean) this.f4507k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean u() {
        if (this.f4505i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f4505i != null;
    }

    protected Constructor A(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method B(Class cls) {
        return cls.getMethod("freeze", null);
    }

    @Override // androidx.core.graphics.i, androidx.core.graphics.n
    public Typeface b(Context context, androidx.core.content.res.e.c cVar, Resources resources, int i3) {
        if (!u()) {
            return super.b(context, cVar, resources, i3);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        for (androidx.core.content.res.e.d dVar : cVar.a()) {
            if (!r(context, objP, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                q(objP);
                return null;
            }
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    @Override // androidx.core.graphics.i, androidx.core.graphics.n
    public Typeface c(Context context, CancellationSignal cancellationSignal, y.h.b[] bVarArr, int i3) {
        Typeface typefaceM;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!u()) {
            y.h.b bVarI = i(bVarArr, i3);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarI.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarI.e()).setItalic(bVarI.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map mapH = o.h(context, bVarArr, cancellationSignal);
        Object objP = p();
        if (objP == null) {
            return null;
        }
        boolean z3 = false;
        for (y.h.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!s(objP, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    q(objP);
                    return null;
                }
                z3 = true;
            }
        }
        if (!z3) {
            q(objP);
            return null;
        }
        if (t(objP) && (typefaceM = m(objP)) != null) {
            return Typeface.create(typefaceM, i3);
        }
        return null;
    }

    @Override // androidx.core.graphics.n
    public Typeface e(Context context, Resources resources, int i3, String str, int i4) {
        if (!u()) {
            return super.e(context, resources, i3, str, i4);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        if (!r(context, objP, str, 0, -1, -1, null)) {
            q(objP);
            return null;
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    protected Typeface m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f4503g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f4509m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method v(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method w(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method x(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method y(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class z() {
        return Class.forName("android.graphics.FontFamily");
    }
}
