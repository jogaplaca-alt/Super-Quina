package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f4510a = new ConcurrentHashMap();

    class a implements c {
        a() {
        }

        @Override // androidx.core.graphics.n.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(y.h.b bVar) {
            return bVar.e();
        }

        @Override // androidx.core.graphics.n.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(y.h.b bVar) {
            return bVar.f();
        }
    }

    class b implements c {
        b() {
        }

        @Override // androidx.core.graphics.n.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(androidx.core.content.res.e.d dVar) {
            return dVar.e();
        }

        @Override // androidx.core.graphics.n.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(androidx.core.content.res.e.d dVar) {
            return dVar.f();
        }
    }

    private interface c {
        int a(Object obj);

        boolean b(Object obj);
    }

    n() {
    }

    private void a(Typeface typeface, androidx.core.content.res.e.c cVar) {
        long jK = k(typeface);
        if (jK != 0) {
            this.f4510a.put(Long.valueOf(jK), cVar);
        }
    }

    private androidx.core.content.res.e.d f(androidx.core.content.res.e.c cVar, int i3) {
        return (androidx.core.content.res.e.d) g(cVar.a(), i3, new b());
    }

    private static Object g(Object[] objArr, int i3, c cVar) {
        return h(objArr, (i3 & 1) == 0 ? 400 : 700, (i3 & 2) != 0, cVar);
    }

    private static Object h(Object[] objArr, int i3, boolean z3, c cVar) {
        Object obj = null;
        int i4 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(cVar.a(obj2) - i3) * 2) + (cVar.b(obj2) == z3 ? 0 : 1);
            if (obj == null || i4 > iAbs) {
                obj = obj2;
                i4 = iAbs;
            }
        }
        return obj;
    }

    private static long k(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        } catch (NoSuchFieldException e4) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e4);
            return 0L;
        }
    }

    public Typeface b(Context context, androidx.core.content.res.e.c cVar, Resources resources, int i3) {
        androidx.core.content.res.e.d dVarF = f(cVar, i3);
        if (dVarF == null) {
            return null;
        }
        Typeface typefaceD = h.d(context, resources, dVarF.b(), dVarF.a(), 0, i3);
        a(typefaceD, cVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, y.h.b[] bVarArr, int i3) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(i(bVarArr, i3).d());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                o.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                o.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                o.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = o.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (o.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i3, String str, int i4) {
        File fileE = o.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (o.c(fileE, resources, i3)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected y.h.b i(y.h.b[] bVarArr, int i3) {
        return (y.h.b) g(bVarArr, i3, new a());
    }

    androidx.core.content.res.e.c j(Typeface typeface) {
        long jK = k(typeface);
        if (jK == 0) {
            return null;
        }
        return (androidx.core.content.res.e.c) this.f4510a.get(Long.valueOf(jK));
    }
}
