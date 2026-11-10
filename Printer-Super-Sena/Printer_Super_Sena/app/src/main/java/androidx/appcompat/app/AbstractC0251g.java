package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.appcompat.app.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0251g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static D.a f2526a = new D.a(new D.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2527b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static androidx.core.os.j f2528c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static androidx.core.os.j f2529d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f2530e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2531f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final p046n.b f2532g = new p046n.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f2533h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f2534i = new Object();

    /* JADX INFO: renamed from: androidx.appcompat.app.g$a */
    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.g$b */
    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    AbstractC0251g() {
    }

    static void F(AbstractC0251g abstractC0251g) {
        synchronized (f2533h) {
            G(abstractC0251g);
        }
    }

    private static void G(AbstractC0251g abstractC0251g) {
        synchronized (f2533h) {
            try {
                Iterator it = f2532g.iterator();
                while (it.hasNext()) {
                    AbstractC0251g abstractC0251g2 = (AbstractC0251g) ((WeakReference) it.next()).get();
                    if (abstractC0251g2 == abstractC0251g || abstractC0251g2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void Q(final Context context) {
        if (v(context)) {
            if (androidx.core.os.a.b()) {
                if (f2531f) {
                    return;
                }
                f2526a.execute(new Runnable() { // from class: androidx.appcompat.app.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC0251g.w(context);
                    }
                });
                return;
            }
            synchronized (f2534i) {
                try {
                    androidx.core.os.j jVar = f2528c;
                    if (jVar == null) {
                        if (f2529d == null) {
                            f2529d = androidx.core.os.j.c(D.b(context));
                        }
                        if (f2529d.f()) {
                        } else {
                            f2528c = f2529d;
                        }
                    } else if (!jVar.equals(f2529d)) {
                        androidx.core.os.j jVar2 = f2528c;
                        f2529d = jVar2;
                        D.a(context, jVar2.h());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void d(AbstractC0251g abstractC0251g) {
        synchronized (f2533h) {
            G(abstractC0251g);
            f2532g.add(new WeakReference(abstractC0251g));
        }
    }

    public static AbstractC0251g h(Activity activity, InterfaceC0249e interfaceC0249e) {
        return new LayoutInflaterFactory2C0252h(activity, interfaceC0249e);
    }

    public static AbstractC0251g i(Dialog dialog, InterfaceC0249e interfaceC0249e) {
        return new LayoutInflaterFactory2C0252h(dialog, interfaceC0249e);
    }

    public static androidx.core.os.j k() {
        if (androidx.core.os.a.b()) {
            Object objP = p();
            if (objP != null) {
                return androidx.core.os.j.j(b.a(objP));
            }
        } else {
            androidx.core.os.j jVar = f2528c;
            if (jVar != null) {
                return jVar;
            }
        }
        return androidx.core.os.j.e();
    }

    public static int m() {
        return f2527b;
    }

    static Object p() {
        Context contextL;
        Iterator it = f2532g.iterator();
        while (it.hasNext()) {
            AbstractC0251g abstractC0251g = (AbstractC0251g) ((WeakReference) it.next()).get();
            if (abstractC0251g != null && (contextL = abstractC0251g.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    static androidx.core.os.j r() {
        return f2528c;
    }

    static boolean v(Context context) {
        if (f2530e == null) {
            try {
                Bundle bundle = B.a(context).metaData;
                if (bundle != null) {
                    f2530e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f2530e = Boolean.FALSE;
            }
        }
        return f2530e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Context context) {
        D.c(context);
        f2531f = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i3);

    public abstract void I(int i3);

    public abstract void J(View view);

    public abstract void K(View view, ViewGroup.LayoutParams layoutParams);

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void M(Toolbar toolbar);

    public abstract void N(int i3);

    public abstract void O(CharSequence charSequence);

    public abstract androidx.appcompat.view.b P(androidx.appcompat.view.b.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i3);

    public abstract Context l();

    public abstract C0246b.InterfaceC0041b n();

    public abstract int o();

    public abstract MenuInflater q();

    public abstract AbstractC0245a s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
