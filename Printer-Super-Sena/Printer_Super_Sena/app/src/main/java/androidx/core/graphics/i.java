package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class i extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f4494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor f4495c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f4496d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f4497e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f4498f = false;

    i() {
    }

    private static boolean l(Object obj, String str, int i3, boolean z3) throws NoSuchMethodException {
        o();
        try {
            return ((Boolean) f4496d.invoke(obj, str, Integer.valueOf(i3), Boolean.valueOf(z3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Typeface m(Object obj) throws NoSuchMethodException {
        o();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4494b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4497e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private File n(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void o() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f4498f) {
            return;
        }
        f4498f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi21Impl", e3.getClass().getName(), e3);
            method = null;
            cls = null;
            method2 = null;
        }
        f4495c = constructor;
        f4494b = cls;
        f4496d = method2;
        f4497e = method;
    }

    private static Object p() throws NoSuchMethodException {
        o();
        try {
            return f4495c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.core.graphics.n
    public Typeface b(Context context, androidx.core.content.res.e.c cVar, Resources resources, int i3) throws NoSuchMethodException {
        Object objP = p();
        for (androidx.core.content.res.e.d dVar : cVar.a()) {
            File fileE = o.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!o.c(fileE, resources, dVar.b())) {
                    return null;
                }
                if (!l(objP, fileE.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return m(objP);
    }

    @Override // androidx.core.graphics.n
    public Typeface c(Context context, CancellationSignal cancellationSignal, y.h.b[] bVarArr, int i3) {
        if (bVarArr.length < 1) {
            return null;
        }
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
                File fileN = n(parcelFileDescriptorOpenFileDescriptor);
                if (fileN != null && fileN.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileN);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceD;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
