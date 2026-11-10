package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n f4491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final p046n.e f4492b;

    public static class a extends y.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.core.content.res.h.e f4493a;

        public a(androidx.core.content.res.h.e eVar) {
            this.f4493a = eVar;
        }

        @Override // y.h.c
        public void a(int i3) {
            androidx.core.content.res.h.e eVar = this.f4493a;
            if (eVar != null) {
                eVar.f(i3);
            }
        }

        @Override // y.h.c
        public void b(Typeface typeface) {
            androidx.core.content.res.h.e eVar = this.f4493a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            f4491a = new m();
        } else if (i3 >= 28) {
            f4491a = new l();
        } else if (i3 >= 26) {
            f4491a = new k();
        } else if (i3 >= 24 && j.n()) {
            f4491a = new j();
        } else if (i3 >= 21) {
            f4491a = new i();
        } else {
            f4491a = new n();
        }
        f4492b = new p046n.e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i3) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i3)) == null) ? Typeface.create(typeface, i3) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, y.h.b[] bVarArr, int i3) {
        return f4491a.c(context, cancellationSignal, bVarArr, i3);
    }

    public static Typeface c(Context context, androidx.core.content.res.e.b bVar, Resources resources, int i3, String str, int i4, int i5, androidx.core.content.res.h.e eVar, Handler handler, boolean z3) {
        Typeface typefaceB;
        if (bVar instanceof androidx.core.content.res.e.C0053e) {
            androidx.core.content.res.e.C0053e c0053e = (androidx.core.content.res.e.C0053e) bVar;
            Typeface typefaceH = h(c0053e.c());
            if (typefaceH != null) {
                if (eVar != null) {
                    eVar.d(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceB = p079y.h.c(context, c0053e.b(), i5, !z3 ? eVar != null : c0053e.a() != 0, z3 ? c0053e.d() : -1, androidx.core.content.res.h.e.e(handler), new a(eVar));
        } else {
            typefaceB = f4491a.b(context, (androidx.core.content.res.e.c) bVar, resources, i5);
            if (eVar != null) {
                if (typefaceB != null) {
                    eVar.d(typefaceB, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f4492b.d(e(resources, i3, str, i4, i5), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i3, String str, int i4, int i5) {
        Typeface typefaceE = f4491a.e(context, resources, i3, str, i5);
        if (typefaceE != null) {
            f4492b.d(e(resources, i3, str, i4, i5), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i3, String str, int i4, int i5) {
        return resources.getResourcePackageName(i3) + '-' + str + '-' + i4 + '-' + i3 + '-' + i5;
    }

    public static Typeface f(Resources resources, int i3, String str, int i4, int i5) {
        return (Typeface) f4492b.c(e(resources, i3, str, i4, i5));
    }

    private static Typeface g(Context context, Typeface typeface, int i3) {
        n nVar = f4491a;
        androidx.core.content.res.e.c cVarJ = nVar.j(typeface);
        if (cVarJ == null) {
            return null;
        }
        return nVar.b(context, cVarJ, context.getResources(), i3);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
