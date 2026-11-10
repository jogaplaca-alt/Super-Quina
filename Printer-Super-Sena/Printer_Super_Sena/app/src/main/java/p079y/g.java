package p079y;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.core.graphics.h;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p046n.e f12788a = new p046n.e(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f12789b = i.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f12790c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final p046n.g f12791d = new p046n.g();

    class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f12793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f12794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f12795d;

        a(String str, Context context, f fVar, int i3) {
            this.f12792a = str;
            this.f12793b = context;
            this.f12794c = fVar;
            this.f12795d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return g.c(this.f12792a, this.f12793b, this.f12794c, this.f12795d);
        }
    }

    class b implements p082z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p079y.a f12796a;

        b(p079y.a aVar) {
            this.f12796a = aVar;
        }

        @Override // p082z.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f12796a.b(eVar);
        }
    }

    class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f12798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f12799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f12800d;

        c(String str, Context context, f fVar, int i3) {
            this.f12797a = str;
            this.f12798b = context;
            this.f12799c = fVar;
            this.f12800d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return g.c(this.f12797a, this.f12798b, this.f12799c, this.f12800d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements p082z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12801a;

        d(String str) {
            this.f12801a = str;
        }

        @Override // p082z.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            synchronized (g.f12790c) {
                try {
                    p046n.g gVar = g.f12791d;
                    ArrayList arrayList = (ArrayList) gVar.get(this.f12801a);
                    if (arrayList == null) {
                        return;
                    }
                    gVar.remove(this.f12801a);
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        ((p082z.a) arrayList.get(i3)).a(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(f fVar, int i3) {
        return fVar.d() + "-" + i3;
    }

    private static int b(h.a aVar) {
        int i3 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        h.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i3 = 0;
            for (h.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i3;
    }

    static e c(String str, Context context, f fVar, int i3) {
        p046n.e eVar = f12788a;
        Typeface typeface = (Typeface) eVar.c(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            h.a aVarE = p079y.e.e(context, fVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = h.b(context, null, aVarE.b(), i3);
            if (typefaceB == null) {
                return new e(-3);
            }
            eVar.d(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, f fVar, int i3, Executor executor, p079y.a aVar) {
        String strA = a(fVar, i3);
        Typeface typeface = (Typeface) f12788a.c(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f12790c) {
            try {
                p046n.g gVar = f12791d;
                ArrayList arrayList = (ArrayList) gVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                gVar.put(strA, arrayList2);
                c cVar = new c(strA, context, fVar, i3);
                if (executor == null) {
                    executor = f12789b;
                }
                i.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, f fVar, p079y.a aVar, int i3, int i4) {
        String strA = a(fVar, i3);
        Typeface typeface = (Typeface) f12788a.c(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i4 == -1) {
            e eVarC = c(strA, context, fVar, i3);
            aVar.b(eVarC);
            return eVarC.f12802a;
        }
        try {
            e eVar = (e) i.c(f12789b, new a(strA, context, fVar, i3), i4);
            aVar.b(eVar);
            return eVar.f12802a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f12802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f12803b;

        e(int i3) {
            this.f12802a = null;
            this.f12803b = i3;
        }

        boolean a() {
            return this.f12803b == 0;
        }

        e(Typeface typeface) {
            this.f12802a = typeface;
            this.f12803b = 0;
        }
    }
}
