package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0266j;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.U;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.u0;
import androidx.core.view.AbstractC0301j0;
import androidx.core.view.AbstractC0317s;
import androidx.core.view.AbstractC0319t;
import androidx.core.view.C0297h0;
import androidx.core.view.C0332z0;
import androidx.core.view.Z;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0358p;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: androidx.appcompat.app.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class LayoutInflaterFactory2C0252h extends AbstractC0251g implements androidx.appcompat.view.menu.g.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final p046n.g f2535j0 = new p046n.g();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final boolean f2536k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int[] f2537l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final boolean f2538m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final boolean f2539n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static boolean f2540o0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f2541A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    ViewGroup f2542B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private TextView f2543C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private View f2544D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f2545E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f2546F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    boolean f2547G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    boolean f2548H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f2549I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f2550J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    boolean f2551K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private boolean f2552L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private w[] f2553M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private w f2554N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private boolean f2555O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f2556P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private boolean f2557Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    boolean f2558R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private Configuration f2559S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private int f2560T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private int f2561U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private int f2562V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private boolean f2563W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private s f2564X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private s f2565Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    boolean f2566Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    int f2567a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Runnable f2568b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f2569c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Rect f2570d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private Rect f2571e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private A f2572f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private E f2573g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private OnBackInvokedDispatcher f2574h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private OnBackInvokedCallback f2575i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Object f2576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Context f2577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window f2578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private q f2579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final InterfaceC0249e f2580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    AbstractC0245a f2581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    MenuInflater f2582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f2583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private androidx.appcompat.widget.L f2584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private j f2585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private x f2586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f2587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ActionBarContextView f2588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    PopupWindow f2589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Runnable f2590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    C0297h0 f2591y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f2592z;

    /* JADX INFO: renamed from: androidx.appcompat.app.h$a */
    class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f2593a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f2593a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f2593a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f2593a.uncaughtException(thread, notFoundException);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
            if ((layoutInflaterFactory2C0252h.f2567a0 & 1) != 0) {
                layoutInflaterFactory2C0252h.i0(0);
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h2 = LayoutInflaterFactory2C0252h.this;
            if ((layoutInflaterFactory2C0252h2.f2567a0 & 4096) != 0) {
                layoutInflaterFactory2C0252h2.i0(108);
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h3 = LayoutInflaterFactory2C0252h.this;
            layoutInflaterFactory2C0252h3.f2566Z = false;
            layoutInflaterFactory2C0252h3.f2567a0 = 0;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$c */
    class c implements androidx.core.view.I {
        c() {
        }

        @Override // androidx.core.view.I
        public C0332z0 a(View view, C0332z0 c0332z0) {
            int iL = c0332z0.l();
            int iE1 = LayoutInflaterFactory2C0252h.this.e1(c0332z0, null);
            if (iL != iE1) {
                c0332z0 = c0332z0.r(c0332z0.j(), iE1, c0332z0.k(), c0332z0.i());
            }
            return Z.c0(view, c0332z0);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$d */
    class d implements U.a {
        d() {
        }

        @Override // androidx.appcompat.widget.U.a
        public void a(Rect rect) {
            rect.top = LayoutInflaterFactory2C0252h.this.e1(null, rect);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$e */
    class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            LayoutInflaterFactory2C0252h.this.g0();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$f */
    class f implements Runnable {

        /* JADX INFO: renamed from: androidx.appcompat.app.h$f$a */
        class a extends AbstractC0301j0 {
            a() {
            }

            @Override // androidx.core.view.InterfaceC0299i0
            public void a(View view) {
                LayoutInflaterFactory2C0252h.this.f2588v.setAlpha(1.0f);
                LayoutInflaterFactory2C0252h.this.f2591y.h(null);
                LayoutInflaterFactory2C0252h.this.f2591y = null;
            }

            @Override // androidx.core.view.AbstractC0301j0, androidx.core.view.InterfaceC0299i0
            public void b(View view) {
                LayoutInflaterFactory2C0252h.this.f2588v.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
            layoutInflaterFactory2C0252h.f2589w.showAtLocation(layoutInflaterFactory2C0252h.f2588v, 55, 0, 0);
            LayoutInflaterFactory2C0252h.this.j0();
            if (!LayoutInflaterFactory2C0252h.this.U0()) {
                LayoutInflaterFactory2C0252h.this.f2588v.setAlpha(1.0f);
                LayoutInflaterFactory2C0252h.this.f2588v.setVisibility(0);
            } else {
                LayoutInflaterFactory2C0252h.this.f2588v.setAlpha(0.0f);
                LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h2 = LayoutInflaterFactory2C0252h.this;
                layoutInflaterFactory2C0252h2.f2591y = Z.e(layoutInflaterFactory2C0252h2.f2588v).b(1.0f);
                LayoutInflaterFactory2C0252h.this.f2591y.h(new a());
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$g */
    class g extends AbstractC0301j0 {
        g() {
        }

        @Override // androidx.core.view.InterfaceC0299i0
        public void a(View view) {
            LayoutInflaterFactory2C0252h.this.f2588v.setAlpha(1.0f);
            LayoutInflaterFactory2C0252h.this.f2591y.h(null);
            LayoutInflaterFactory2C0252h.this.f2591y = null;
        }

        @Override // androidx.core.view.AbstractC0301j0, androidx.core.view.InterfaceC0299i0
        public void b(View view) {
            LayoutInflaterFactory2C0252h.this.f2588v.setVisibility(0);
            if (LayoutInflaterFactory2C0252h.this.f2588v.getParent() instanceof View) {
                Z.n0((View) LayoutInflaterFactory2C0252h.this.f2588v.getParent());
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$h, reason: collision with other inner class name */
    private class C0042h implements C0246b.InterfaceC0041b {
        C0042h() {
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void a(int i3) {
            AbstractC0245a abstractC0245aS = LayoutInflaterFactory2C0252h.this.s();
            if (abstractC0245aS != null) {
                abstractC0245aS.u(i3);
            }
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public void b(Drawable drawable, int i3) {
            AbstractC0245a abstractC0245aS = LayoutInflaterFactory2C0252h.this.s();
            if (abstractC0245aS != null) {
                abstractC0245aS.v(drawable);
                abstractC0245aS.u(i3);
            }
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Context c() {
            return LayoutInflaterFactory2C0252h.this.o0();
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public boolean d() {
            AbstractC0245a abstractC0245aS = LayoutInflaterFactory2C0252h.this.s();
            return (abstractC0245aS == null || (abstractC0245aS.j() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.C0246b.InterfaceC0041b
        public Drawable e() {
            j0 j0VarU = j0.u(c(), null, new int[]{p012d.a.f9069B});
            Drawable drawableG = j0VarU.g(0);
            j0VarU.w();
            return drawableG;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$i */
    interface i {
        boolean a(int i3);

        View onCreatePanelView(int i3);
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$j */
    private final class j implements androidx.appcompat.view.menu.m.a {
        j() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
            LayoutInflaterFactory2C0252h.this.Z(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackV0 = LayoutInflaterFactory2C0252h.this.v0();
            if (callbackV0 == null) {
                return true;
            }
            callbackV0.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$k */
    class k implements androidx.appcompat.view.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.appcompat.view.b.a f2603a;

        /* JADX INFO: renamed from: androidx.appcompat.app.h$k$a */
        class a extends AbstractC0301j0 {
            a() {
            }

            @Override // androidx.core.view.InterfaceC0299i0
            public void a(View view) {
                LayoutInflaterFactory2C0252h.this.f2588v.setVisibility(8);
                LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
                PopupWindow popupWindow = layoutInflaterFactory2C0252h.f2589w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C0252h.f2588v.getParent() instanceof View) {
                    Z.n0((View) LayoutInflaterFactory2C0252h.this.f2588v.getParent());
                }
                LayoutInflaterFactory2C0252h.this.f2588v.k();
                LayoutInflaterFactory2C0252h.this.f2591y.h(null);
                LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h2 = LayoutInflaterFactory2C0252h.this;
                layoutInflaterFactory2C0252h2.f2591y = null;
                Z.n0(layoutInflaterFactory2C0252h2.f2542B);
            }
        }

        public k(androidx.appcompat.view.b.a aVar) {
            this.f2603a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            Z.n0(LayoutInflaterFactory2C0252h.this.f2542B);
            return this.f2603a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f2603a.b(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f2603a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void d(androidx.appcompat.view.b bVar) {
            this.f2603a.d(bVar);
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
            if (layoutInflaterFactory2C0252h.f2589w != null) {
                layoutInflaterFactory2C0252h.f2578l.getDecorView().removeCallbacks(LayoutInflaterFactory2C0252h.this.f2590x);
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h2 = LayoutInflaterFactory2C0252h.this;
            if (layoutInflaterFactory2C0252h2.f2588v != null) {
                layoutInflaterFactory2C0252h2.j0();
                LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h3 = LayoutInflaterFactory2C0252h.this;
                layoutInflaterFactory2C0252h3.f2591y = Z.e(layoutInflaterFactory2C0252h3.f2588v).b(0.0f);
                LayoutInflaterFactory2C0252h.this.f2591y.h(new a());
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h4 = LayoutInflaterFactory2C0252h.this;
            InterfaceC0249e interfaceC0249e = layoutInflaterFactory2C0252h4.f2580n;
            if (interfaceC0249e != null) {
                interfaceC0249e.onSupportActionModeFinished(layoutInflaterFactory2C0252h4.f2587u);
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h5 = LayoutInflaterFactory2C0252h.this;
            layoutInflaterFactory2C0252h5.f2587u = null;
            Z.n0(layoutInflaterFactory2C0252h5.f2542B);
            LayoutInflaterFactory2C0252h.this.c1();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$l */
    static class l {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.densityDpi;
            int i4 = configuration2.densityDpi;
            if (i3 != i4) {
                configuration3.densityDpi = i4;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$m */
    static class m {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$n */
    static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.j b(Configuration configuration) {
            return androidx.core.os.j.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.j jVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(jVar.h()));
        }

        static void d(Configuration configuration, androidx.core.os.j jVar) {
            configuration.setLocales(LocaleList.forLanguageTags(jVar.h()));
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$o */
    static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$p */
    static class p {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h) {
            Objects.requireNonNull(layoutInflaterFactory2C0252h);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.x
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    layoutInflaterFactory2C0252h.D0();
                }
            };
            androidx.appcompat.app.t.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            androidx.appcompat.app.t.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.s.a(obj2));
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$r */
    private class r extends s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f2611c;

        r(Context context) {
            super();
            this.f2611c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !m.a(this.f2611c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        public void d() {
            LayoutInflaterFactory2C0252h.this.T();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$s */
    abstract class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f2613a;

        /* JADX INFO: renamed from: androidx.appcompat.app.h$s$a */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                s.this.d();
            }
        }

        s() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f2613a;
            if (broadcastReceiver != null) {
                try {
                    LayoutInflaterFactory2C0252h.this.f2577k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f2613a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f2613a == null) {
                this.f2613a = new a();
            }
            LayoutInflaterFactory2C0252h.this.f2577k.registerReceiver(this.f2613a, intentFilterB);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$t */
    private class t extends s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final K f2616c;

        t(K k3) {
            super();
            this.f2616c = k3;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        public int c() {
            return this.f2616c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.LayoutInflaterFactory2C0252h.s
        public void d() {
            LayoutInflaterFactory2C0252h.this.T();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$u */
    private static class u {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$v */
    private class v extends ContentFrameLayout {
        public v(Context context) {
            super(context);
        }

        private boolean c(int i3, int i4) {
            return i3 < -5 || i4 < -5 || i3 > getWidth() + 5 || i4 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflaterFactory2C0252h.this.h0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            LayoutInflaterFactory2C0252h.this.b0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i3) {
            setBackgroundDrawable(p016e.a.b(getContext(), i3));
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$w */
    protected static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f2625g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f2626h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f2627i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.g f2628j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.e f2629k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Context f2630l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f2631m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f2632n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f2633o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f2634p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f2635q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f2636r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Bundle f2637s;

        w(int i3) {
            this.f2619a = i3;
        }

        androidx.appcompat.view.menu.n a(androidx.appcompat.view.menu.m.a aVar) {
            if (this.f2628j == null) {
                return null;
            }
            if (this.f2629k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f2630l, p012d.g.f9227j);
                this.f2629k = eVar;
                eVar.l(aVar);
                this.f2628j.b(this.f2629k);
            }
            return this.f2629k.f(this.f2625g);
        }

        public boolean b() {
            if (this.f2626h == null) {
                return false;
            }
            return this.f2627i != null || this.f2629k.b().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f2628j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.Q(this.f2629k);
            }
            this.f2628j = gVar;
            if (gVar == null || (eVar = this.f2629k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(p012d.a.f9083a, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            }
            themeNewTheme.resolveAttribute(p012d.a.f9073F, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                themeNewTheme.applyStyle(i4, true);
            } else {
                themeNewTheme.applyStyle(p012d.i.f9254c, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f2630l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(p012d.j.f9439y0);
            this.f2620b = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9262B0, 0);
            this.f2624f = typedArrayObtainStyledAttributes.getResourceId(p012d.j.f9258A0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$x */
    private final class x implements androidx.appcompat.view.menu.m.a {
        x() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z3) {
            androidx.appcompat.view.menu.g gVarF = gVar.F();
            boolean z4 = gVarF != gVar;
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
            if (z4) {
                gVar = gVarF;
            }
            w wVarM0 = layoutInflaterFactory2C0252h.m0(gVar);
            if (wVarM0 != null) {
                if (!z4) {
                    LayoutInflaterFactory2C0252h.this.c0(wVarM0, z3);
                } else {
                    LayoutInflaterFactory2C0252h.this.Y(wVarM0.f2619a, wVarM0, gVarF);
                    LayoutInflaterFactory2C0252h.this.c0(wVarM0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackV0;
            if (gVar != gVar.F()) {
                return true;
            }
            LayoutInflaterFactory2C0252h layoutInflaterFactory2C0252h = LayoutInflaterFactory2C0252h.this;
            if (!layoutInflaterFactory2C0252h.f2547G || (callbackV0 = layoutInflaterFactory2C0252h.v0()) == null || LayoutInflaterFactory2C0252h.this.f2558R) {
                return true;
            }
            callbackV0.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        boolean z3 = Build.VERSION.SDK_INT < 21;
        f2536k0 = z3;
        f2537l0 = new int[]{R.attr.windowBackground};
        f2538m0 = !"robolectric".equals(Build.FINGERPRINT);
        f2539n0 = true;
        if (!z3 || f2540o0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f2540o0 = true;
    }

    LayoutInflaterFactory2C0252h(Activity activity, InterfaceC0249e interfaceC0249e) {
        this(activity, null, interfaceC0249e, activity);
    }

    private void A0(int i3) {
        this.f2567a0 = (1 << i3) | this.f2567a0;
        if (this.f2566Z) {
            return;
        }
        Z.i0(this.f2578l.getDecorView(), this.f2568b0);
        this.f2566Z = true;
    }

    private boolean F0(int i3, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        w wVarT0 = t0(i3, true);
        if (wVarT0.f2633o) {
            return false;
        }
        return P0(wVarT0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean I0(int i3, KeyEvent keyEvent) {
        boolean zP0;
        androidx.appcompat.widget.L l3;
        if (this.f2587u != null) {
            return false;
        }
        boolean zD = true;
        w wVarT0 = t0(i3, true);
        if (i3 != 0 || (l3 = this.f2584r) == null || !l3.g() || ViewConfiguration.get(this.f2577k).hasPermanentMenuKey()) {
            boolean z3 = wVarT0.f2633o;
            if (z3 || wVarT0.f2632n) {
                c0(wVarT0, true);
                zD = z3;
            } else if (wVarT0.f2631m) {
                if (wVarT0.f2636r) {
                    wVarT0.f2631m = false;
                    zP0 = P0(wVarT0, keyEvent);
                } else {
                    zP0 = true;
                }
                if (zP0) {
                    M0(wVarT0, keyEvent);
                } else {
                    zD = false;
                }
            } else {
                zD = false;
            }
        } else if (this.f2584r.c()) {
            zD = this.f2584r.d();
        } else if (this.f2558R || !P0(wVarT0, keyEvent)) {
            zD = false;
        } else {
            zD = this.f2584r.e();
        }
        if (zD) {
            AudioManager audioManager = (AudioManager) this.f2577k.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zD;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    private void M0(w wVar, KeyEvent keyEvent) {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        if (wVar.f2633o || this.f2558R) {
            return;
        }
        if (wVar.f2619a == 0 && (this.f2577k.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callbackV0 = v0();
        if (callbackV0 != null && !callbackV0.onMenuOpened(wVar.f2619a, wVar.f2628j)) {
            c0(wVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2577k.getSystemService("window");
        if (windowManager != null && P0(wVar, keyEvent)) {
            ViewGroup viewGroup = wVar.f2625g;
            if (viewGroup != null && !wVar.f2635q) {
                View view = wVar.f2627i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i3 = -1;
                }
                wVar.f2632n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i3, -2, wVar.f2622d, wVar.f2623e, 1002, 8519680, -3);
                layoutParams2.gravity = wVar.f2621c;
                layoutParams2.windowAnimations = wVar.f2624f;
                windowManager.addView(wVar.f2625g, layoutParams2);
                wVar.f2633o = true;
                if (wVar.f2619a == 0) {
                    c1();
                }
            }
            if (viewGroup == null) {
                if (!y0(wVar) || wVar.f2625g == null) {
                    return;
                }
            } else if (wVar.f2635q && viewGroup.getChildCount() > 0) {
                wVar.f2625g.removeAllViews();
            }
            if (!x0(wVar) || !wVar.b()) {
                wVar.f2635q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = wVar.f2626h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            wVar.f2625g.setBackgroundResource(wVar.f2620b);
            ViewParent parent = wVar.f2626h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(wVar.f2626h);
            }
            wVar.f2625g.addView(wVar.f2626h, layoutParams3);
            if (!wVar.f2626h.hasFocus()) {
                wVar.f2626h.requestFocus();
            }
            i3 = -2;
            wVar.f2632n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i3, -2, wVar.f2622d, wVar.f2623e, 1002, 8519680, -3);
            layoutParams4.gravity = wVar.f2621c;
            layoutParams4.windowAnimations = wVar.f2624f;
            windowManager.addView(wVar.f2625g, layoutParams4);
            wVar.f2633o = true;
            if (wVar.f2619a == 0) {
                c1();
            }
        }
    }

    private boolean O0(w wVar, int i3, KeyEvent keyEvent, int i4) {
        androidx.appcompat.view.menu.g gVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((wVar.f2631m || P0(wVar, keyEvent)) && (gVar = wVar.f2628j) != null) {
            zPerformShortcut = gVar.performShortcut(i3, keyEvent, i4);
        }
        if (zPerformShortcut && (i4 & 1) == 0 && this.f2584r == null) {
            c0(wVar, true);
        }
        return zPerformShortcut;
    }

    private boolean P0(w wVar, KeyEvent keyEvent) {
        androidx.appcompat.widget.L l3;
        androidx.appcompat.widget.L l4;
        androidx.appcompat.widget.L l5;
        if (this.f2558R) {
            return false;
        }
        if (wVar.f2631m) {
            return true;
        }
        w wVar2 = this.f2554N;
        if (wVar2 != null && wVar2 != wVar) {
            c0(wVar2, false);
        }
        Window.Callback callbackV0 = v0();
        if (callbackV0 != null) {
            wVar.f2627i = callbackV0.onCreatePanelView(wVar.f2619a);
        }
        int i3 = wVar.f2619a;
        boolean z3 = i3 == 0 || i3 == 108;
        if (z3 && (l5 = this.f2584r) != null) {
            l5.f();
        }
        if (wVar.f2627i == null && (!z3 || !(N0() instanceof I))) {
            androidx.appcompat.view.menu.g gVar = wVar.f2628j;
            if (gVar == null || wVar.f2636r) {
                if (gVar == null && (!z0(wVar) || wVar.f2628j == null)) {
                    return false;
                }
                if (z3 && this.f2584r != null) {
                    if (this.f2585s == null) {
                        this.f2585s = new j();
                    }
                    this.f2584r.a(wVar.f2628j, this.f2585s);
                }
                wVar.f2628j.h0();
                if (!callbackV0.onCreatePanelMenu(wVar.f2619a, wVar.f2628j)) {
                    wVar.c(null);
                    if (z3 && (l3 = this.f2584r) != null) {
                        l3.a(null, this.f2585s);
                    }
                    return false;
                }
                wVar.f2636r = false;
            }
            wVar.f2628j.h0();
            Bundle bundle = wVar.f2637s;
            if (bundle != null) {
                wVar.f2628j.R(bundle);
                wVar.f2637s = null;
            }
            if (!callbackV0.onPreparePanel(0, wVar.f2627i, wVar.f2628j)) {
                if (z3 && (l4 = this.f2584r) != null) {
                    l4.a(null, this.f2585s);
                }
                wVar.f2628j.g0();
                return false;
            }
            boolean z4 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            wVar.f2634p = z4;
            wVar.f2628j.setQwertyMode(z4);
            wVar.f2628j.g0();
        }
        wVar.f2631m = true;
        wVar.f2632n = false;
        this.f2554N = wVar;
        return true;
    }

    private void Q0(boolean z3) {
        androidx.appcompat.widget.L l3 = this.f2584r;
        if (l3 == null || !l3.g() || (ViewConfiguration.get(this.f2577k).hasPermanentMenuKey() && !this.f2584r.b())) {
            w wVarT0 = t0(0, true);
            wVarT0.f2635q = true;
            c0(wVarT0, false);
            M0(wVarT0, null);
            return;
        }
        Window.Callback callbackV0 = v0();
        if (this.f2584r.c() && z3) {
            this.f2584r.d();
            if (this.f2558R) {
                return;
            }
            callbackV0.onPanelClosed(108, t0(0, true).f2628j);
            return;
        }
        if (callbackV0 == null || this.f2558R) {
            return;
        }
        if (this.f2566Z && (this.f2567a0 & 1) != 0) {
            this.f2578l.getDecorView().removeCallbacks(this.f2568b0);
            this.f2568b0.run();
        }
        w wVarT1 = t0(0, true);
        androidx.appcompat.view.menu.g gVar = wVarT1.f2628j;
        if (gVar == null || wVarT1.f2636r || !callbackV0.onPreparePanel(0, wVarT1.f2627i, gVar)) {
            return;
        }
        callbackV0.onMenuOpened(108, wVarT1.f2628j);
        this.f2584r.e();
    }

    private boolean R(boolean z3) {
        return S(z3, true);
    }

    private int R0(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i3 != 9) {
            return i3;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean S(boolean z3, boolean z4) {
        if (this.f2558R) {
            return false;
        }
        int iX = X();
        int iC0 = C0(this.f2577k, iX);
        androidx.core.os.j jVarW = Build.VERSION.SDK_INT < 33 ? W(this.f2577k) : null;
        if (!z4 && jVarW != null) {
            jVarW = s0(this.f2577k.getResources().getConfiguration());
        }
        boolean zB1 = b1(iC0, jVarW, z3);
        if (iX == 0) {
            r0(this.f2577k).e();
        } else {
            s sVar = this.f2564X;
            if (sVar != null) {
                sVar.a();
            }
        }
        if (iX == 3) {
            q0(this.f2577k).e();
        } else {
            s sVar2 = this.f2565Y;
            if (sVar2 != null) {
                sVar2.a();
            }
        }
        return zB1;
    }

    private void U() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f2542B.findViewById(R.id.content);
        View decorView = this.f2578l.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f2577k.obtainStyledAttributes(p012d.j.f9439y0);
        typedArrayObtainStyledAttributes.getValue(p012d.j.f9295K0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(p012d.j.f9298L0, contentFrameLayout.getMinWidthMinor());
        int i3 = p012d.j.f9289I0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMajor());
        }
        int i4 = p012d.j.f9292J0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedWidthMinor());
        }
        int i5 = p012d.j.f9282G0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMajor());
        }
        int i6 = p012d.j.f9286H0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            typedArrayObtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void V(Window window) {
        if (this.f2578l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof q) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        q qVar = new q(callback);
        this.f2579m = qVar;
        window.setCallback(qVar);
        j0 j0VarU = j0.u(this.f2577k, null, f2537l0);
        Drawable drawableH = j0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        j0VarU.w();
        this.f2578l = window;
        if (Build.VERSION.SDK_INT < 33 || this.f2574h0 != null) {
            return;
        }
        L(null);
    }

    private boolean V0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2578l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || Z.T((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int X() {
        int i3 = this.f2560T;
        return i3 != -100 ? i3 : AbstractC0251g.m();
    }

    private void Y0() {
        if (this.f2541A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AbstractActivityC0248d Z0() {
        for (Context baseContext = this.f2577k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AbstractActivityC0248d) {
                return (AbstractActivityC0248d) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void a0() {
        s sVar = this.f2564X;
        if (sVar != null) {
            sVar.a();
        }
        s sVar2 = this.f2565Y;
        if (sVar2 != null) {
            sVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a1(Configuration configuration) {
        Activity activity = (Activity) this.f2576j;
        if (activity instanceof InterfaceC0358p) {
            if (((InterfaceC0358p) activity).getLifecycle().b().b(AbstractC0354l.b.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f2557Q || this.f2558R) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    private boolean b1(int i3, androidx.core.os.j jVar, boolean z3) {
        boolean z4;
        Configuration configurationD0 = d0(this.f2577k, i3, jVar, null, false);
        int iP0 = p0(this.f2577k);
        Configuration configuration = this.f2559S;
        if (configuration == null) {
            configuration = this.f2577k.getResources().getConfiguration();
        }
        int i4 = configuration.uiMode & 48;
        int i5 = configurationD0.uiMode & 48;
        androidx.core.os.j jVarS0 = s0(configuration);
        androidx.core.os.j jVarS1 = jVar == null ? null : s0(configurationD0);
        int i6 = i4 != i5 ? 512 : 0;
        if (jVarS1 != null && !jVarS0.equals(jVarS1)) {
            i6 |= 8196;
        }
        boolean z5 = true;
        if (((iP0 ^ (-1)) & i6) != 0 && z3 && this.f2556P && (f2538m0 || this.f2557Q)) {
            Object obj = this.f2576j;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z4 = false;
            } else {
                androidx.core.app.b.p((Activity) this.f2576j);
                z4 = true;
            }
        } else {
            z4 = false;
        }
        if (z4 || i6 == 0) {
            z5 = z4;
        } else {
            d1(i5, jVarS1, (i6 & iP0) == i6, null);
        }
        if (z5) {
            Object obj2 = this.f2576j;
            if (obj2 instanceof AbstractActivityC0248d) {
                if ((i6 & 512) != 0) {
                    ((AbstractActivityC0248d) obj2).onNightModeChanged(i3);
                }
                if ((i6 & 4) != 0) {
                    ((AbstractActivityC0248d) this.f2576j).onLocalesChanged(jVar);
                }
            }
        }
        if (z5 && jVarS1 != null) {
            T0(s0(this.f2577k.getResources().getConfiguration()));
        }
        return z5;
    }

    private Configuration d0(Context context, int i3, androidx.core.os.j jVar, Configuration configuration, boolean z3) {
        int i4;
        if (i3 == 1) {
            i4 = 16;
        } else if (i3 != 2) {
            i4 = z3 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i4 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        if (jVar != null) {
            S0(configuration2, jVar);
        }
        return configuration2;
    }

    private void d1(int i3, androidx.core.os.j jVar, boolean z3, Configuration configuration) {
        Resources resources = this.f2577k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i3 | (resources.getConfiguration().uiMode & (-49));
        if (jVar != null) {
            S0(configuration2, jVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 26) {
            G.a(resources);
        }
        int i5 = this.f2561U;
        if (i5 != 0) {
            this.f2577k.setTheme(i5);
            if (i4 >= 23) {
                this.f2577k.getTheme().applyStyle(this.f2561U, true);
            }
        }
        if (z3 && (this.f2576j instanceof Activity)) {
            a1(configuration2);
        }
    }

    private ViewGroup e0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f2577k.obtainStyledAttributes(p012d.j.f9439y0);
        int i3 = p012d.j.f9270D0;
        if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9301M0, false)) {
            H(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i3, false)) {
            H(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9274E0, false)) {
            H(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9278F0, false)) {
            H(10);
        }
        this.f2550J = typedArrayObtainStyledAttributes.getBoolean(p012d.j.f9443z0, false);
        typedArrayObtainStyledAttributes.recycle();
        l0();
        this.f2578l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2577k);
        if (this.f2551K) {
            viewGroup = this.f2549I ? (ViewGroup) layoutInflaterFrom.inflate(p012d.g.f9232o, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(p012d.g.f9231n, (ViewGroup) null);
        } else if (this.f2550J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(p012d.g.f9223f, (ViewGroup) null);
            this.f2548H = false;
            this.f2547G = false;
        } else if (this.f2547G) {
            TypedValue typedValue = new TypedValue();
            this.f2577k.getTheme().resolveAttribute(p012d.a.f9086d, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f2577k, typedValue.resourceId) : this.f2577k).inflate(p012d.g.f9233p, (ViewGroup) null);
            androidx.appcompat.widget.L l3 = (androidx.appcompat.widget.L) viewGroup.findViewById(p012d.f.f9207p);
            this.f2584r = l3;
            l3.setWindowCallback(v0());
            if (this.f2548H) {
                this.f2584r.k(109);
            }
            if (this.f2545E) {
                this.f2584r.k(2);
            }
            if (this.f2546F) {
                this.f2584r.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f2547G + ", windowActionBarOverlay: " + this.f2548H + ", android:windowIsFloating: " + this.f2550J + ", windowActionModeOverlay: " + this.f2549I + ", windowNoTitle: " + this.f2551K + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Z.D0(viewGroup, new c());
        } else if (viewGroup instanceof U) {
            ((U) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.f2584r == null) {
            this.f2543C = (TextView) viewGroup.findViewById(p012d.f.f9188M);
        }
        u0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(p012d.f.f9193b);
        ViewGroup viewGroup2 = (ViewGroup) this.f2578l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2578l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void f1(View view) {
        view.setBackgroundColor((Z.N(view) & 8192) != 0 ? androidx.core.content.a.b(this.f2577k, p012d.c.f9111b) : androidx.core.content.a.b(this.f2577k, p012d.c.f9110a));
    }

    private void k0() {
        if (this.f2541A) {
            return;
        }
        this.f2542B = e0();
        CharSequence charSequenceU0 = u0();
        if (!TextUtils.isEmpty(charSequenceU0)) {
            androidx.appcompat.widget.L l3 = this.f2584r;
            if (l3 != null) {
                l3.setWindowTitle(charSequenceU0);
            } else if (N0() != null) {
                N0().y(charSequenceU0);
            } else {
                TextView textView = this.f2543C;
                if (textView != null) {
                    textView.setText(charSequenceU0);
                }
            }
        }
        U();
        L0(this.f2542B);
        this.f2541A = true;
        w wVarT0 = t0(0, false);
        if (this.f2558R) {
            return;
        }
        if (wVarT0 == null || wVarT0.f2628j == null) {
            A0(108);
        }
    }

    private void l0() {
        if (this.f2578l == null) {
            Object obj = this.f2576j;
            if (obj instanceof Activity) {
                V(((Activity) obj).getWindow());
            }
        }
        if (this.f2578l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration n0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f3 = configuration.fontScale;
            float f4 = configuration2.fontScale;
            if (f3 != f4) {
                configuration3.fontScale = f4;
            }
            int i3 = configuration.mcc;
            int i4 = configuration2.mcc;
            if (i3 != i4) {
                configuration3.mcc = i4;
            }
            int i5 = configuration.mnc;
            int i6 = configuration2.mnc;
            if (i5 != i6) {
                configuration3.mnc = i6;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 24) {
                n.a(configuration, configuration2, configuration3);
            } else if (!p082z.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i8 = configuration.touchscreen;
            int i9 = configuration2.touchscreen;
            if (i8 != i9) {
                configuration3.touchscreen = i9;
            }
            int i10 = configuration.keyboard;
            int i11 = configuration2.keyboard;
            if (i10 != i11) {
                configuration3.keyboard = i11;
            }
            int i12 = configuration.keyboardHidden;
            int i13 = configuration2.keyboardHidden;
            if (i12 != i13) {
                configuration3.keyboardHidden = i13;
            }
            int i14 = configuration.navigation;
            int i15 = configuration2.navigation;
            if (i14 != i15) {
                configuration3.navigation = i15;
            }
            int i16 = configuration.navigationHidden;
            int i17 = configuration2.navigationHidden;
            if (i16 != i17) {
                configuration3.navigationHidden = i17;
            }
            int i18 = configuration.orientation;
            int i19 = configuration2.orientation;
            if (i18 != i19) {
                configuration3.orientation = i19;
            }
            int i20 = configuration.screenLayout & 15;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 15)) {
                configuration3.screenLayout |= i21 & 15;
            }
            int i22 = configuration.screenLayout & 192;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 192)) {
                configuration3.screenLayout |= i23 & 192;
            }
            int i24 = configuration.screenLayout & 48;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 48)) {
                configuration3.screenLayout |= i25 & 48;
            }
            int i26 = configuration.screenLayout & 768;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 768)) {
                configuration3.screenLayout |= i27 & 768;
            }
            if (i7 >= 26) {
                o.a(configuration, configuration2, configuration3);
            }
            int i28 = configuration.uiMode & 15;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 15)) {
                configuration3.uiMode |= i29 & 15;
            }
            int i30 = configuration.uiMode & 48;
            int i31 = configuration2.uiMode;
            if (i30 != (i31 & 48)) {
                configuration3.uiMode |= i31 & 48;
            }
            int i32 = configuration.screenWidthDp;
            int i33 = configuration2.screenWidthDp;
            if (i32 != i33) {
                configuration3.screenWidthDp = i33;
            }
            int i34 = configuration.screenHeightDp;
            int i35 = configuration2.screenHeightDp;
            if (i34 != i35) {
                configuration3.screenHeightDp = i35;
            }
            int i36 = configuration.smallestScreenWidthDp;
            int i37 = configuration2.smallestScreenWidthDp;
            if (i36 != i37) {
                configuration3.smallestScreenWidthDp = i37;
            }
            l.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int p0(Context context) {
        int i3;
        if (!this.f2563W && (this.f2576j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 29) {
                    i3 = 269221888;
                } else {
                    i3 = i4 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f2576j.getClass()), i3);
                if (activityInfo != null) {
                    this.f2562V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e3);
                this.f2562V = 0;
            }
        }
        this.f2563W = true;
        return this.f2562V;
    }

    private s q0(Context context) {
        if (this.f2565Y == null) {
            this.f2565Y = new r(context);
        }
        return this.f2565Y;
    }

    private s r0(Context context) {
        if (this.f2564X == null) {
            this.f2564X = new t(K.a(context));
        }
        return this.f2564X;
    }

    private void w0() {
        k0();
        if (this.f2547G && this.f2581o == null) {
            Object obj = this.f2576j;
            if (obj instanceof Activity) {
                this.f2581o = new L((Activity) this.f2576j, this.f2548H);
            } else if (obj instanceof Dialog) {
                this.f2581o = new L((Dialog) this.f2576j);
            }
            AbstractC0245a abstractC0245a = this.f2581o;
            if (abstractC0245a != null) {
                abstractC0245a.r(this.f2569c0);
            }
        }
    }

    private boolean x0(w wVar) {
        View view = wVar.f2627i;
        if (view != null) {
            wVar.f2626h = view;
            return true;
        }
        if (wVar.f2628j == null) {
            return false;
        }
        if (this.f2586t == null) {
            this.f2586t = new x();
        }
        View view2 = (View) wVar.a(this.f2586t);
        wVar.f2626h = view2;
        return view2 != null;
    }

    private boolean y0(w wVar) {
        wVar.d(o0());
        wVar.f2625g = new v(wVar.f2630l);
        wVar.f2621c = 81;
        return true;
    }

    private boolean z0(w wVar) {
        Resources.Theme themeNewTheme;
        Context context = this.f2577k;
        int i3 = wVar.f2619a;
        if ((i3 == 0 || i3 == 108) && this.f2584r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(p012d.a.f9086d, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(p012d.a.f9087e, typedValue, true);
            } else {
                theme.resolveAttribute(p012d.a.f9087e, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.V(this);
        wVar.c(gVar);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void A(Bundle bundle) {
        k0();
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void B() {
        AbstractC0245a abstractC0245aS = s();
        if (abstractC0245aS != null) {
            abstractC0245aS.w(true);
        }
    }

    public boolean B0() {
        return this.f2592z;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void C(Bundle bundle) {
    }

    int C0(Context context, int i3) {
        if (i3 == -100) {
            return -1;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return r0(context).c();
                }
                return -1;
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    return q0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i3;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void D() {
        S(true, false);
    }

    boolean D0() {
        boolean z3 = this.f2555O;
        this.f2555O = false;
        w wVarT0 = t0(0, false);
        if (wVarT0 != null && wVarT0.f2633o) {
            if (!z3) {
                c0(wVarT0, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f2587u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        AbstractC0245a abstractC0245aS = s();
        return abstractC0245aS != null && abstractC0245aS.h();
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void E() {
        AbstractC0245a abstractC0245aS = s();
        if (abstractC0245aS != null) {
            abstractC0245aS.w(false);
        }
    }

    boolean E0(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.f2555O = (keyEvent.getFlags() & 128) != 0;
        } else if (i3 == 82) {
            F0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean G0(int i3, KeyEvent keyEvent) {
        AbstractC0245a abstractC0245aS = s();
        if (abstractC0245aS != null && abstractC0245aS.o(i3, keyEvent)) {
            return true;
        }
        w wVar = this.f2554N;
        if (wVar != null && O0(wVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            w wVar2 = this.f2554N;
            if (wVar2 != null) {
                wVar2.f2632n = true;
            }
            return true;
        }
        if (this.f2554N == null) {
            w wVarT0 = t0(0, true);
            P0(wVarT0, keyEvent);
            boolean zO0 = O0(wVarT0, keyEvent.getKeyCode(), keyEvent, 1);
            wVarT0.f2631m = false;
            if (zO0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public boolean H(int i3) {
        int iR0 = R0(i3);
        if (this.f2551K && iR0 == 108) {
            return false;
        }
        if (this.f2547G && iR0 == 1) {
            this.f2547G = false;
        }
        if (iR0 == 1) {
            Y0();
            this.f2551K = true;
            return true;
        }
        if (iR0 == 2) {
            Y0();
            this.f2545E = true;
            return true;
        }
        if (iR0 == 5) {
            Y0();
            this.f2546F = true;
            return true;
        }
        if (iR0 == 10) {
            Y0();
            this.f2549I = true;
            return true;
        }
        if (iR0 == 108) {
            Y0();
            this.f2547G = true;
            return true;
        }
        if (iR0 != 109) {
            return this.f2578l.requestFeature(iR0);
        }
        Y0();
        this.f2548H = true;
        return true;
    }

    boolean H0(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            if (i3 == 82) {
                I0(0, keyEvent);
                return true;
            }
        } else if (D0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void I(int i3) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.f2542B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2577k).inflate(i3, viewGroup);
        this.f2579m.c(this.f2578l.getCallback());
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void J(View view) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.f2542B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2579m.c(this.f2578l.getCallback());
    }

    void J0(int i3) {
        AbstractC0245a abstractC0245aS;
        if (i3 != 108 || (abstractC0245aS = s()) == null) {
            return;
        }
        abstractC0245aS.i(true);
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void K(View view, ViewGroup.LayoutParams layoutParams) {
        k0();
        ViewGroup viewGroup = (ViewGroup) this.f2542B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2579m.c(this.f2578l.getCallback());
    }

    void K0(int i3) {
        if (i3 == 108) {
            AbstractC0245a abstractC0245aS = s();
            if (abstractC0245aS != null) {
                abstractC0245aS.i(false);
                return;
            }
            return;
        }
        if (i3 == 0) {
            w wVarT0 = t0(i3, true);
            if (wVarT0.f2633o) {
                c0(wVarT0, false);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    @Override // androidx.appcompat.app.AbstractC0251g
    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.L(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f2574h0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f2575i0) != null) {
            p.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f2575i0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f2576j;
            if (!(obj instanceof Activity) || ((Activity) obj).getWindow() == null) {
                this.f2574h0 = onBackInvokedDispatcher;
            } else {
                this.f2574h0 = p.a((Activity) this.f2576j);
            }
        } else {
            this.f2574h0 = onBackInvokedDispatcher;
        }
        c1();
    }

    void L0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void M(Toolbar toolbar) {
        if (this.f2576j instanceof Activity) {
            AbstractC0245a abstractC0245aS = s();
            if (abstractC0245aS instanceof L) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f2582p = null;
            if (abstractC0245aS != null) {
                abstractC0245aS.n();
            }
            this.f2581o = null;
            if (toolbar != null) {
                I i3 = new I(toolbar, u0(), this.f2579m);
                this.f2581o = i3;
                this.f2579m.e(i3.f2442c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f2579m.e(null);
            }
            u();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void N(int i3) {
        this.f2561U = i3;
    }

    final AbstractC0245a N0() {
        return this.f2581o;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public final void O(CharSequence charSequence) {
        this.f2583q = charSequence;
        androidx.appcompat.widget.L l3 = this.f2584r;
        if (l3 != null) {
            l3.setWindowTitle(charSequence);
            return;
        }
        if (N0() != null) {
            N0().y(charSequence);
            return;
        }
        TextView textView = this.f2543C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public androidx.appcompat.view.b P(androidx.appcompat.view.b.a aVar) {
        InterfaceC0249e interfaceC0249e;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f2587u;
        if (bVar != null) {
            bVar.c();
        }
        k kVar = new k(aVar);
        AbstractC0245a abstractC0245aS = s();
        if (abstractC0245aS != null) {
            androidx.appcompat.view.b bVarZ = abstractC0245aS.z(kVar);
            this.f2587u = bVarZ;
            if (bVarZ != null && (interfaceC0249e = this.f2580n) != null) {
                interfaceC0249e.onSupportActionModeStarted(bVarZ);
            }
        }
        if (this.f2587u == null) {
            this.f2587u = X0(kVar);
        }
        c1();
        return this.f2587u;
    }

    void S0(Configuration configuration, androidx.core.os.j jVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            n.d(configuration, jVar);
        } else {
            l.d(configuration, jVar.d(0));
            l.c(configuration, jVar.d(0));
        }
    }

    public boolean T() {
        return R(true);
    }

    void T0(androidx.core.os.j jVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            n.c(jVar);
        } else {
            Locale.setDefault(jVar.d(0));
        }
    }

    final boolean U0() {
        ViewGroup viewGroup;
        return this.f2541A && (viewGroup = this.f2542B) != null && Z.U(viewGroup);
    }

    androidx.core.os.j W(Context context) {
        androidx.core.os.j jVarR;
        androidx.core.os.j jVarE;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33 || (jVarR = AbstractC0251g.r()) == null) {
            return null;
        }
        androidx.core.os.j jVarS0 = s0(context.getApplicationContext().getResources().getConfiguration());
        if (i3 >= 24) {
            jVarE = F.b(jVarR, jVarS0);
        } else {
            jVarE = jVarR.f() ? androidx.core.os.j.e() : androidx.core.os.j.c(jVarR.d(0).toString());
        }
        return jVarE.f() ? jVarS0 : jVarE;
    }

    boolean W0() {
        if (this.f2574h0 == null) {
            return false;
        }
        w wVarT0 = t0(0, false);
        return (wVarT0 != null && wVarT0.f2633o) || this.f2587u != null;
    }

    androidx.appcompat.view.b X0(androidx.appcompat.view.b.a aVar) {
        androidx.appcompat.view.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        InterfaceC0249e interfaceC0249e;
        j0();
        androidx.appcompat.view.b bVar = this.f2587u;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof k)) {
            aVar = new k(aVar);
        }
        InterfaceC0249e interfaceC0249e2 = this.f2580n;
        if (interfaceC0249e2 == null || this.f2558R) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = interfaceC0249e2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                bVarOnWindowStartingSupportActionMode = null;
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.f2587u = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.f2588v == null) {
                if (this.f2550J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f2577k.getTheme();
                    theme.resolveAttribute(p012d.a.f9086d, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f2577k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f2577k, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f2577k;
                    }
                    this.f2588v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, p012d.a.f9088f);
                    this.f2589w = popupWindow;
                    androidx.core.widget.h.b(popupWindow, 2);
                    this.f2589w.setContentView(this.f2588v);
                    this.f2589w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(p012d.a.f9084b, typedValue, true);
                    this.f2588v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f2589w.setHeight(-2);
                    this.f2590x = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2542B.findViewById(p012d.f.f9199h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(o0()));
                        this.f2588v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f2588v != null) {
                j0();
                this.f2588v.k();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.f2588v.getContext(), this.f2588v, aVar, this.f2589w == null);
                if (aVar.c(eVar, eVar.e())) {
                    eVar.k();
                    this.f2588v.h(eVar);
                    this.f2587u = eVar;
                    if (U0()) {
                        this.f2588v.setAlpha(0.0f);
                        C0297h0 c0297h0B = Z.e(this.f2588v).b(1.0f);
                        this.f2591y = c0297h0B;
                        c0297h0B.h(new g());
                    } else {
                        this.f2588v.setAlpha(1.0f);
                        this.f2588v.setVisibility(0);
                        if (this.f2588v.getParent() instanceof View) {
                            Z.n0((View) this.f2588v.getParent());
                        }
                    }
                    if (this.f2589w != null) {
                        this.f2578l.getDecorView().post(this.f2590x);
                    }
                } else {
                    this.f2587u = null;
                }
            }
        }
        androidx.appcompat.view.b bVar2 = this.f2587u;
        if (bVar2 != null && (interfaceC0249e = this.f2580n) != null) {
            interfaceC0249e.onSupportActionModeStarted(bVar2);
        }
        c1();
        return this.f2587u;
    }

    void Y(int i3, w wVar, Menu menu) {
        if (menu == null) {
            if (wVar == null && i3 >= 0) {
                w[] wVarArr = this.f2553M;
                if (i3 < wVarArr.length) {
                    wVar = wVarArr[i3];
                }
            }
            if (wVar != null) {
                menu = wVar.f2628j;
            }
        }
        if ((wVar == null || wVar.f2633o) && !this.f2558R) {
            this.f2579m.d(this.f2578l.getCallback(), i3, menu);
        }
    }

    void Z(androidx.appcompat.view.menu.g gVar) {
        if (this.f2552L) {
            return;
        }
        this.f2552L = true;
        this.f2584r.l();
        Window.Callback callbackV0 = v0();
        if (callbackV0 != null && !this.f2558R) {
            callbackV0.onPanelClosed(108, gVar);
        }
        this.f2552L = false;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        w wVarM0;
        Window.Callback callbackV0 = v0();
        if (callbackV0 == null || this.f2558R || (wVarM0 = m0(gVar.F())) == null) {
            return false;
        }
        return callbackV0.onMenuItemSelected(wVarM0.f2619a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        Q0(true);
    }

    void b0(int i3) {
        c0(t0(i3, true), true);
    }

    void c0(w wVar, boolean z3) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.L l3;
        if (z3 && wVar.f2619a == 0 && (l3 = this.f2584r) != null && l3.c()) {
            Z(wVar.f2628j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2577k.getSystemService("window");
        if (windowManager != null && wVar.f2633o && (viewGroup = wVar.f2625g) != null) {
            windowManager.removeView(viewGroup);
            if (z3) {
                Y(wVar.f2619a, wVar, null);
            }
        }
        wVar.f2631m = false;
        wVar.f2632n = false;
        wVar.f2633o = false;
        wVar.f2626h = null;
        wVar.f2635q = true;
        if (this.f2554N == wVar) {
            this.f2554N = null;
        }
        if (wVar.f2619a == 0) {
            c1();
        }
    }

    void c1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zW0 = W0();
            if (zW0 && this.f2575i0 == null) {
                this.f2575i0 = p.b(this.f2574h0, this);
            } else {
                if (zW0 || (onBackInvokedCallback = this.f2575i0) == null) {
                    return;
                }
                p.c(this.f2574h0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        k0();
        ((ViewGroup) this.f2542B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2579m.c(this.f2578l.getCallback());
    }

    final int e1(C0332z0 c0332z0, Rect rect) {
        int iL;
        boolean z3;
        boolean z4;
        if (c0332z0 != null) {
            iL = c0332z0.l();
        } else {
            iL = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f2588v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z3 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2588v.getLayoutParams();
            boolean z5 = true;
            if (this.f2588v.isShown()) {
                if (this.f2570d0 == null) {
                    this.f2570d0 = new Rect();
                    this.f2571e0 = new Rect();
                }
                Rect rect2 = this.f2570d0;
                Rect rect3 = this.f2571e0;
                if (c0332z0 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c0332z0.j(), c0332z0.l(), c0332z0.k(), c0332z0.i());
                }
                u0.a(this.f2542B, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                C0332z0 c0332z0J = Z.J(this.f2542B);
                int iJ = c0332z0J == null ? 0 : c0332z0J.j();
                int iK = c0332z0J == null ? 0 : c0332z0J.k();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z4 = true;
                }
                if (i3 <= 0 || this.f2544D != null) {
                    View view = this.f2544D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != iJ || marginLayoutParams2.rightMargin != iK) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = iJ;
                            marginLayoutParams2.rightMargin = iK;
                            this.f2544D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f2577k);
                    this.f2544D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iJ;
                    layoutParams.rightMargin = iK;
                    this.f2542B.addView(this.f2544D, -1, layoutParams);
                }
                View view3 = this.f2544D;
                z5 = view3 != null;
                if (z5 && view3.getVisibility() != 0) {
                    f1(this.f2544D);
                }
                if (!this.f2549I && z5) {
                    iL = 0;
                }
                z3 = z5;
                z5 = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = false;
            } else {
                z3 = false;
                z5 = false;
            }
            if (z5) {
                this.f2588v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f2544D;
        if (view4 != null) {
            view4.setVisibility(z3 ? 0 : 8);
        }
        return iL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View f0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z3;
        if (this.f2572f0 == null) {
            String string = this.f2577k.obtainStyledAttributes(p012d.j.f9439y0).getString(p012d.j.f9266C0);
            if (string == null) {
                this.f2572f0 = new A();
            } else {
                try {
                    this.f2572f0 = (A) this.f2577k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f2572f0 = new A();
                }
            }
        }
        boolean z4 = f2536k0;
        boolean zV0 = false;
        if (z4) {
            if (this.f2573g0 == null) {
                this.f2573g0 = new E();
            }
            if (this.f2573g0.a(attributeSet)) {
                z3 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zV0 = V0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zV0 = true;
                }
                z3 = zV0;
            }
        } else {
            z3 = false;
        }
        return this.f2572f0.r(view, str, context, attributeSet, z3, z4, true, t0.c());
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public Context g(Context context) {
        this.f2556P = true;
        int iC0 = C0(context, X());
        if (AbstractC0251g.v(context)) {
            AbstractC0251g.Q(context);
        }
        androidx.core.os.j jVarW = W(context);
        if (f2539n0 && (context instanceof ContextThemeWrapper)) {
            try {
                u.a((ContextThemeWrapper) context, d0(context, iC0, jVarW, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(d0(context, iC0, jVarW, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f2538m0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = l.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationD0 = d0(context, iC0, jVarW, !configuration2.equals(configuration3) ? n0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, p012d.i.f9255d);
        dVar.a(configurationD0);
        try {
            if (context.getTheme() != null) {
                androidx.core.content.res.h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    void g0() {
        androidx.appcompat.view.menu.g gVar;
        androidx.appcompat.widget.L l3 = this.f2584r;
        if (l3 != null) {
            l3.l();
        }
        if (this.f2589w != null) {
            this.f2578l.getDecorView().removeCallbacks(this.f2590x);
            if (this.f2589w.isShowing()) {
                try {
                    this.f2589w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f2589w = null;
        }
        j0();
        w wVarT0 = t0(0, false);
        if (wVarT0 == null || (gVar = wVarT0.f2628j) == null) {
            return;
        }
        gVar.close();
    }

    boolean h0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f2576j;
        if (((obj instanceof AbstractC0317s.a) || (obj instanceof z)) && (decorView = this.f2578l.getDecorView()) != null && AbstractC0317s.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f2579m.b(this.f2578l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? E0(keyCode, keyEvent) : H0(keyCode, keyEvent);
    }

    void i0(int i3) {
        w wVarT0;
        w wVarT1 = t0(i3, true);
        if (wVarT1.f2628j != null) {
            Bundle bundle = new Bundle();
            wVarT1.f2628j.T(bundle);
            if (bundle.size() > 0) {
                wVarT1.f2637s = bundle;
            }
            wVarT1.f2628j.h0();
            wVarT1.f2628j.clear();
        }
        wVarT1.f2636r = true;
        wVarT1.f2635q = true;
        if ((i3 != 108 && i3 != 0) || this.f2584r == null || (wVarT0 = t0(0, false)) == null) {
            return;
        }
        wVarT0.f2631m = false;
        P0(wVarT0, null);
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public View j(int i3) {
        k0();
        return this.f2578l.findViewById(i3);
    }

    void j0() {
        C0297h0 c0297h0 = this.f2591y;
        if (c0297h0 != null) {
            c0297h0.c();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public Context l() {
        return this.f2577k;
    }

    w m0(Menu menu) {
        w[] wVarArr = this.f2553M;
        int length = wVarArr != null ? wVarArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            w wVar = wVarArr[i3];
            if (wVar != null && wVar.f2628j == menu) {
                return wVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public final C0246b.InterfaceC0041b n() {
        return new C0042h();
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public int o() {
        return this.f2560T;
    }

    final Context o0() {
        AbstractC0245a abstractC0245aS = s();
        Context contextK = abstractC0245aS != null ? abstractC0245aS.k() : null;
        return contextK == null ? this.f2577k : contextK;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return f0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public MenuInflater q() {
        if (this.f2582p == null) {
            w0();
            AbstractC0245a abstractC0245a = this.f2581o;
            this.f2582p = new androidx.appcompat.view.g(abstractC0245a != null ? abstractC0245a.k() : this.f2577k);
        }
        return this.f2582p;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public AbstractC0245a s() {
        w0();
        return this.f2581o;
    }

    androidx.core.os.j s0(Configuration configuration) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            return n.b(configuration);
        }
        return i3 >= 21 ? androidx.core.os.j.c(m.b(configuration.locale)) : androidx.core.os.j.a(configuration.locale);
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void t() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2577k);
        if (layoutInflaterFrom.getFactory() == null) {
            AbstractC0319t.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof LayoutInflaterFactory2C0252h) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    protected w t0(int i3, boolean z3) {
        w[] wVarArr = this.f2553M;
        if (wVarArr == null || wVarArr.length <= i3) {
            w[] wVarArr2 = new w[i3 + 1];
            if (wVarArr != null) {
                System.arraycopy(wVarArr, 0, wVarArr2, 0, wVarArr.length);
            }
            this.f2553M = wVarArr2;
            wVarArr = wVarArr2;
        }
        w wVar = wVarArr[i3];
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(i3);
        wVarArr[i3] = wVar2;
        return wVar2;
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void u() {
        if (N0() == null || s().l()) {
            return;
        }
        A0(0);
    }

    final CharSequence u0() {
        Object obj = this.f2576j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2583q;
    }

    final Window.Callback v0() {
        return this.f2578l.getCallback();
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void x(Configuration configuration) {
        AbstractC0245a abstractC0245aS;
        if (this.f2547G && this.f2541A && (abstractC0245aS = s()) != null) {
            abstractC0245aS.m(configuration);
        }
        C0266j.b().g(this.f2577k);
        this.f2559S = new Configuration(this.f2577k.getResources().getConfiguration());
        S(false, false);
    }

    @Override // androidx.appcompat.app.AbstractC0251g
    public void y(Bundle bundle) {
        String strC;
        this.f2556P = true;
        R(false);
        l0();
        Object obj = this.f2576j;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.h.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                AbstractC0245a abstractC0245aN0 = N0();
                if (abstractC0245aN0 == null) {
                    this.f2569c0 = true;
                } else {
                    abstractC0245aN0.r(true);
                }
            }
            AbstractC0251g.d(this);
        }
        this.f2559S = new Configuration(this.f2577k.getResources().getConfiguration());
        this.f2557Q = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    @Override // androidx.appcompat.app.AbstractC0251g
    public void z() {
        if (this.f2576j instanceof Activity) {
            AbstractC0251g.F(this);
        }
        if (this.f2566Z) {
            this.f2578l.getDecorView().removeCallbacks(this.f2568b0);
        }
        this.f2558R = true;
        if (this.f2560T != -100) {
            Object obj = this.f2576j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f2535j0.put(this.f2576j.getClass().getName(), Integer.valueOf(this.f2560T));
            } else {
                f2535j0.remove(this.f2576j.getClass().getName());
            }
        } else {
            f2535j0.remove(this.f2576j.getClass().getName());
        }
        AbstractC0245a abstractC0245a = this.f2581o;
        if (abstractC0245a != null) {
            abstractC0245a.n();
        }
        a0();
    }

    LayoutInflaterFactory2C0252h(Dialog dialog, InterfaceC0249e interfaceC0249e) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0249e, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private LayoutInflaterFactory2C0252h(Context context, Window window, InterfaceC0249e interfaceC0249e, Object obj) {
        AbstractActivityC0248d abstractActivityC0248dZ0;
        this.f2591y = null;
        this.f2592z = true;
        this.f2560T = -100;
        this.f2568b0 = new b();
        this.f2577k = context;
        this.f2580n = interfaceC0249e;
        this.f2576j = obj;
        if (this.f2560T == -100 && (obj instanceof Dialog) && (abstractActivityC0248dZ0 = Z0()) != null) {
            this.f2560T = abstractActivityC0248dZ0.getDelegate().o();
        }
        if (this.f2560T == -100) {
            p046n.g gVar = f2535j0;
            Integer num = (Integer) gVar.get(obj.getClass().getName());
            if (num != null) {
                this.f2560T = num.intValue();
                gVar.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            V(window);
        }
        C0266j.h();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.h$q */
    class q extends androidx.appcompat.view.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f2606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2609e;

        q(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f2608d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f2608d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f2607c = true;
                callback.onContentChanged();
            } finally {
                this.f2607c = false;
            }
        }

        public void d(Window.Callback callback, int i3, Menu menu) {
            try {
                this.f2609e = true;
                callback.onPanelClosed(i3, menu);
            } finally {
                this.f2609e = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f2608d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return LayoutInflaterFactory2C0252h.this.h0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || LayoutInflaterFactory2C0252h.this.G0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(i iVar) {
            this.f2606b = iVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            androidx.appcompat.view.f.a aVar = new androidx.appcompat.view.f.a(LayoutInflaterFactory2C0252h.this.f2577k, callback);
            androidx.appcompat.view.b bVarP = LayoutInflaterFactory2C0252h.this.P(aVar);
            if (bVarP != null) {
                return aVar.e(bVarP);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f2607c) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i3, Menu menu) {
            if (i3 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i3, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i3) {
            View viewOnCreatePanelView;
            i iVar = this.f2606b;
            return (iVar == null || (viewOnCreatePanelView = iVar.onCreatePanelView(i3)) == null) ? super.onCreatePanelView(i3) : viewOnCreatePanelView;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i3, Menu menu) {
            super.onMenuOpened(i3, menu);
            LayoutInflaterFactory2C0252h.this.J0(i3);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i3, Menu menu) {
            if (this.f2609e) {
                a().onPanelClosed(i3, menu);
            } else {
                super.onPanelClosed(i3, menu);
                LayoutInflaterFactory2C0252h.this.K0(i3);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i3, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i3 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.e0(true);
            }
            i iVar = this.f2606b;
            boolean zOnPreparePanel = iVar != null && iVar.a(i3);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i3, view, menu);
            }
            if (gVar != null) {
                gVar.e0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
            androidx.appcompat.view.menu.g gVar;
            w wVarT0 = LayoutInflaterFactory2C0252h.this.t0(0, true);
            if (wVarT0 == null || (gVar = wVarT0.f2628j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i3);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i3);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return LayoutInflaterFactory2C0252h.this.B0() ? f(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
            if (LayoutInflaterFactory2C0252h.this.B0() && i3 == 0) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback, i3);
        }
    }
}
