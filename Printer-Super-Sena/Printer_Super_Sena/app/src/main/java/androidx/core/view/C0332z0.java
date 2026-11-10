package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.core.view.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0332z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0332z0 f4720b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f4721a;

    /* JADX INFO: renamed from: androidx.core.view.z0$a */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f4722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f4723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f4724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f4725d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4722a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4723b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4724c = declaredField3;
                declaredField3.setAccessible(true);
                f4725d = true;
            } catch (ReflectiveOperationException e3) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
            }
        }

        public static C0332z0 a(View view) {
            if (f4725d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4722a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4723b.get(obj);
                        Rect rect2 = (Rect) f4724c.get(obj);
                        if (rect != null && rect2 != null) {
                            C0332z0 c0332z0A = new b().c(androidx.core.graphics.e.c(rect)).d(androidx.core.graphics.e.c(rect2)).a();
                            c0332z0A.u(c0332z0A);
                            c0332z0A.d(view.getRootView());
                            return c0332z0A;
                        }
                    }
                } catch (IllegalAccessException e3) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e3.getMessage(), e3);
                }
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$e */
    private static class e extends d {
        e() {
        }

        @Override // androidx.core.view.C0332z0.f
        void c(int i3, androidx.core.graphics.e eVar) {
            this.f4733c.setInsets(n.a(i3), eVar.e());
        }

        e(C0332z0 c0332z0) {
            super(c0332z0);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$f */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0332z0 f4734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.core.graphics.e[] f4735b;

        f() {
            this(new C0332z0((C0332z0) null));
        }

        protected final void a() {
            androidx.core.graphics.e[] eVarArr = this.f4735b;
            if (eVarArr != null) {
                androidx.core.graphics.e eVarF = eVarArr[m.b(1)];
                androidx.core.graphics.e eVarF2 = this.f4735b[m.b(2)];
                if (eVarF2 == null) {
                    eVarF2 = this.f4734a.f(2);
                }
                if (eVarF == null) {
                    eVarF = this.f4734a.f(1);
                }
                g(androidx.core.graphics.e.a(eVarF, eVarF2));
                androidx.core.graphics.e eVar = this.f4735b[m.b(16)];
                if (eVar != null) {
                    f(eVar);
                }
                androidx.core.graphics.e eVar2 = this.f4735b[m.b(32)];
                if (eVar2 != null) {
                    d(eVar2);
                }
                androidx.core.graphics.e eVar3 = this.f4735b[m.b(64)];
                if (eVar3 != null) {
                    h(eVar3);
                }
            }
        }

        C0332z0 b() {
            a();
            return this.f4734a;
        }

        void c(int i3, androidx.core.graphics.e eVar) {
            if (this.f4735b == null) {
                this.f4735b = new androidx.core.graphics.e[9];
            }
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    this.f4735b[m.b(i4)] = eVar;
                }
            }
        }

        void d(androidx.core.graphics.e eVar) {
        }

        void e(androidx.core.graphics.e eVar) {
        }

        void f(androidx.core.graphics.e eVar) {
        }

        void g(androidx.core.graphics.e eVar) {
        }

        void h(androidx.core.graphics.e eVar) {
        }

        f(C0332z0 c0332z0) {
            this.f4734a = c0332z0;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$i */
    private static class i extends h {
        i(C0332z0 c0332z0, WindowInsets windowInsets) {
            super(c0332z0, windowInsets);
        }

        @Override // androidx.core.view.C0332z0.l
        C0332z0 a() {
            return C0332z0.x(this.f4741c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.C0332z0.g, androidx.core.view.C0332z0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4741c, iVar.f4741c) && Objects.equals(this.f4745g, iVar.f4745g);
        }

        @Override // androidx.core.view.C0332z0.l
        C0314q f() {
            return C0314q.e(this.f4741c.getDisplayCutout());
        }

        @Override // androidx.core.view.C0332z0.l
        public int hashCode() {
            return this.f4741c.hashCode();
        }

        i(C0332z0 c0332z0, i iVar) {
            super(c0332z0, iVar);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$k */
    private static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final C0332z0 f4750q = C0332z0.x(WindowInsets.CONSUMED);

        k(C0332z0 c0332z0, WindowInsets windowInsets) {
            super(c0332z0, windowInsets);
        }

        @Override // androidx.core.view.C0332z0.g, androidx.core.view.C0332z0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.C0332z0.g, androidx.core.view.C0332z0.l
        public androidx.core.graphics.e g(int i3) {
            return androidx.core.graphics.e.d(this.f4741c.getInsets(n.a(i3)));
        }

        k(C0332z0 c0332z0, k kVar) {
            super(c0332z0, kVar);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$l */
    private static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final C0332z0 f4751b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0332z0 f4752a;

        l(C0332z0 c0332z0) {
            this.f4752a = c0332z0;
        }

        C0332z0 a() {
            return this.f4752a;
        }

        C0332z0 b() {
            return this.f4752a;
        }

        C0332z0 c() {
            return this.f4752a;
        }

        void d(View view) {
        }

        void e(C0332z0 c0332z0) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && p082z.c.a(k(), lVar.k()) && p082z.c.a(i(), lVar.i()) && p082z.c.a(f(), lVar.f());
        }

        C0314q f() {
            return null;
        }

        androidx.core.graphics.e g(int i3) {
            return androidx.core.graphics.e.f4481e;
        }

        androidx.core.graphics.e h() {
            return k();
        }

        public int hashCode() {
            return p082z.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.e i() {
            return androidx.core.graphics.e.f4481e;
        }

        androidx.core.graphics.e j() {
            return k();
        }

        androidx.core.graphics.e k() {
            return androidx.core.graphics.e.f4481e;
        }

        androidx.core.graphics.e l() {
            return k();
        }

        C0332z0 m(int i3, int i4, int i5, int i6) {
            return f4751b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.e[] eVarArr) {
        }

        void q(androidx.core.graphics.e eVar) {
        }

        void r(C0332z0 c0332z0) {
        }

        public void s(androidx.core.graphics.e eVar) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$m */
    public static final class m {
        public static int a() {
            return 8;
        }

        static int b(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 == 16) {
                return 4;
            }
            if (i3 == 32) {
                return 5;
            }
            if (i3 == 64) {
                return 6;
            }
            if (i3 == 128) {
                return 7;
            }
            if (i3 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i3);
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 7;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$n */
    private static final class n {
        static int a(int i3) {
            int iStatusBars;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i3 & i5) != 0) {
                    if (i5 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i4 |= iStatusBars;
                }
            }
            return i4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4720b = k.f4750q;
        } else {
            f4720b = l.f4751b;
        }
    }

    private C0332z0(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f4721a = new k(this, windowInsets);
            return;
        }
        if (i3 >= 29) {
            this.f4721a = new j(this, windowInsets);
            return;
        }
        if (i3 >= 28) {
            this.f4721a = new i(this, windowInsets);
            return;
        }
        if (i3 >= 21) {
            this.f4721a = new h(this, windowInsets);
        } else if (i3 >= 20) {
            this.f4721a = new g(this, windowInsets);
        } else {
            this.f4721a = new l(this);
        }
    }

    static androidx.core.graphics.e p(androidx.core.graphics.e eVar, int i3, int i4, int i5, int i6) {
        int iMax = Math.max(0, eVar.f4482a - i3);
        int iMax2 = Math.max(0, eVar.f4483b - i4);
        int iMax3 = Math.max(0, eVar.f4484c - i5);
        int iMax4 = Math.max(0, eVar.f4485d - i6);
        return (iMax == i3 && iMax2 == i4 && iMax3 == i5 && iMax4 == i6) ? eVar : androidx.core.graphics.e.b(iMax, iMax2, iMax3, iMax4);
    }

    public static C0332z0 x(WindowInsets windowInsets) {
        return y(windowInsets, null);
    }

    public static C0332z0 y(WindowInsets windowInsets, View view) {
        C0332z0 c0332z0 = new C0332z0(AbstractC0330y0.a(p082z.h.g(windowInsets)));
        if (view != null && view.isAttachedToWindow()) {
            c0332z0.u(Z.J(view));
            c0332z0.d(view.getRootView());
        }
        return c0332z0;
    }

    public C0332z0 a() {
        return this.f4721a.a();
    }

    public C0332z0 b() {
        return this.f4721a.b();
    }

    public C0332z0 c() {
        return this.f4721a.c();
    }

    void d(View view) {
        this.f4721a.d(view);
    }

    public C0314q e() {
        return this.f4721a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0332z0) {
            return p082z.c.a(this.f4721a, ((C0332z0) obj).f4721a);
        }
        return false;
    }

    public androidx.core.graphics.e f(int i3) {
        return this.f4721a.g(i3);
    }

    public androidx.core.graphics.e g() {
        return this.f4721a.i();
    }

    public androidx.core.graphics.e h() {
        return this.f4721a.j();
    }

    public int hashCode() {
        l lVar = this.f4721a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f4721a.k().f4485d;
    }

    public int j() {
        return this.f4721a.k().f4482a;
    }

    public int k() {
        return this.f4721a.k().f4484c;
    }

    public int l() {
        return this.f4721a.k().f4483b;
    }

    public androidx.core.graphics.e m() {
        return this.f4721a.k();
    }

    public boolean n() {
        return !this.f4721a.k().equals(androidx.core.graphics.e.f4481e);
    }

    public C0332z0 o(int i3, int i4, int i5, int i6) {
        return this.f4721a.m(i3, i4, i5, i6);
    }

    public boolean q() {
        return this.f4721a.n();
    }

    public C0332z0 r(int i3, int i4, int i5, int i6) {
        return new b(this).d(androidx.core.graphics.e.b(i3, i4, i5, i6)).a();
    }

    void s(androidx.core.graphics.e[] eVarArr) {
        this.f4721a.p(eVarArr);
    }

    void t(androidx.core.graphics.e eVar) {
        this.f4721a.q(eVar);
    }

    void u(C0332z0 c0332z0) {
        this.f4721a.r(c0332z0);
    }

    void v(androidx.core.graphics.e eVar) {
        this.f4721a.s(eVar);
    }

    public WindowInsets w() {
        l lVar = this.f4721a;
        if (lVar instanceof g) {
            return ((g) lVar).f4741c;
        }
        return null;
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$c */
    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Field f4727e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f4728f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Constructor f4729g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f4730h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsets f4731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.e f4732d;

        c() {
            this.f4731c = i();
        }

        private static WindowInsets i() {
            if (!f4728f) {
                try {
                    f4727e = B0.a().getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e3);
                }
                f4728f = true;
            }
            Field field = f4727e;
            if (field != null) {
                try {
                    WindowInsets windowInsetsA = AbstractC0330y0.a(field.get(null));
                    if (windowInsetsA != null) {
                        return new WindowInsets(windowInsetsA);
                    }
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e4);
                }
            }
            if (!f4730h) {
                try {
                    f4729g = B0.a().getConstructor(Rect.class);
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e5);
                }
                f4730h = true;
            }
            Constructor constructor = f4729g;
            if (constructor != null) {
                try {
                    return AbstractC0330y0.a(constructor.newInstance(new Rect()));
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e6);
                }
            }
            return null;
        }

        @Override // androidx.core.view.C0332z0.f
        C0332z0 b() {
            a();
            C0332z0 c0332z0X = C0332z0.x(this.f4731c);
            c0332z0X.s(this.f4735b);
            c0332z0X.v(this.f4732d);
            return c0332z0X;
        }

        @Override // androidx.core.view.C0332z0.f
        void e(androidx.core.graphics.e eVar) {
            this.f4732d = eVar;
        }

        @Override // androidx.core.view.C0332z0.f
        void g(androidx.core.graphics.e eVar) {
            WindowInsets windowInsets = this.f4731c;
            if (windowInsets != null) {
                this.f4731c = windowInsets.replaceSystemWindowInsets(eVar.f4482a, eVar.f4483b, eVar.f4484c, eVar.f4485d);
            }
        }

        c(C0332z0 c0332z0) {
            super(c0332z0);
            this.f4731c = c0332z0.w();
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$d */
    private static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f4733c;

        d() {
            this.f4733c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.C0332z0.f
        C0332z0 b() {
            a();
            C0332z0 c0332z0X = C0332z0.x(this.f4733c.build());
            c0332z0X.s(this.f4735b);
            return c0332z0X;
        }

        @Override // androidx.core.view.C0332z0.f
        void d(androidx.core.graphics.e eVar) {
            this.f4733c.setMandatorySystemGestureInsets(eVar.e());
        }

        @Override // androidx.core.view.C0332z0.f
        void e(androidx.core.graphics.e eVar) {
            this.f4733c.setStableInsets(eVar.e());
        }

        @Override // androidx.core.view.C0332z0.f
        void f(androidx.core.graphics.e eVar) {
            this.f4733c.setSystemGestureInsets(eVar.e());
        }

        @Override // androidx.core.view.C0332z0.f
        void g(androidx.core.graphics.e eVar) {
            this.f4733c.setSystemWindowInsets(eVar.e());
        }

        @Override // androidx.core.view.C0332z0.f
        void h(androidx.core.graphics.e eVar) {
            this.f4733c.setTappableElementInsets(eVar.e());
        }

        d(C0332z0 c0332z0) {
            WindowInsets.Builder builder;
            super(c0332z0);
            WindowInsets windowInsetsW = c0332z0.w();
            if (windowInsetsW != null) {
                builder = new WindowInsets.Builder(windowInsetsW);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f4733c = builder;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$h */
    private static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.e f4746m;

        h(C0332z0 c0332z0, WindowInsets windowInsets) {
            super(c0332z0, windowInsets);
            this.f4746m = null;
        }

        @Override // androidx.core.view.C0332z0.l
        C0332z0 b() {
            return C0332z0.x(this.f4741c.consumeStableInsets());
        }

        @Override // androidx.core.view.C0332z0.l
        C0332z0 c() {
            return C0332z0.x(this.f4741c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.C0332z0.l
        final androidx.core.graphics.e i() {
            if (this.f4746m == null) {
                this.f4746m = androidx.core.graphics.e.b(this.f4741c.getStableInsetLeft(), this.f4741c.getStableInsetTop(), this.f4741c.getStableInsetRight(), this.f4741c.getStableInsetBottom());
            }
            return this.f4746m;
        }

        @Override // androidx.core.view.C0332z0.l
        boolean n() {
            return this.f4741c.isConsumed();
        }

        @Override // androidx.core.view.C0332z0.l
        public void s(androidx.core.graphics.e eVar) {
            this.f4746m = eVar;
        }

        h(C0332z0 c0332z0, h hVar) {
            super(c0332z0, hVar);
            this.f4746m = null;
            this.f4746m = hVar.f4746m;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$g */
    private static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f4736h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f4737i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Class f4738j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static Field f4739k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static Field f4740l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f4741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.e[] f4742d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.e f4743e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private C0332z0 f4744f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.core.graphics.e f4745g;

        g(C0332z0 c0332z0, WindowInsets windowInsets) {
            super(c0332z0);
            this.f4743e = null;
            this.f4741c = windowInsets;
        }

        private androidx.core.graphics.e t(int i3, boolean z3) {
            androidx.core.graphics.e eVarA = androidx.core.graphics.e.f4481e;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    eVarA = androidx.core.graphics.e.a(eVarA, u(i4, z3));
                }
            }
            return eVarA;
        }

        private androidx.core.graphics.e v() {
            C0332z0 c0332z0 = this.f4744f;
            return c0332z0 != null ? c0332z0.g() : androidx.core.graphics.e.f4481e;
        }

        private androidx.core.graphics.e w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4736h) {
                x();
            }
            Method method = f4737i;
            if (method != null && f4738j != null && f4739k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f4739k.get(f4740l.get(objInvoke));
                    if (rect != null) {
                        return androidx.core.graphics.e.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e3) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
                }
            }
            return null;
        }

        private static void x() {
            try {
                f4737i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4738j = cls;
                f4739k = cls.getDeclaredField("mVisibleInsets");
                f4740l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f4739k.setAccessible(true);
                f4740l.setAccessible(true);
            } catch (ReflectiveOperationException e3) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
            }
            f4736h = true;
        }

        @Override // androidx.core.view.C0332z0.l
        void d(View view) {
            androidx.core.graphics.e eVarW = w(view);
            if (eVarW == null) {
                eVarW = androidx.core.graphics.e.f4481e;
            }
            q(eVarW);
        }

        @Override // androidx.core.view.C0332z0.l
        void e(C0332z0 c0332z0) {
            c0332z0.u(this.f4744f);
            c0332z0.t(this.f4745g);
        }

        @Override // androidx.core.view.C0332z0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f4745g, ((g) obj).f4745g);
            }
            return false;
        }

        @Override // androidx.core.view.C0332z0.l
        public androidx.core.graphics.e g(int i3) {
            return t(i3, false);
        }

        @Override // androidx.core.view.C0332z0.l
        final androidx.core.graphics.e k() {
            if (this.f4743e == null) {
                this.f4743e = androidx.core.graphics.e.b(this.f4741c.getSystemWindowInsetLeft(), this.f4741c.getSystemWindowInsetTop(), this.f4741c.getSystemWindowInsetRight(), this.f4741c.getSystemWindowInsetBottom());
            }
            return this.f4743e;
        }

        @Override // androidx.core.view.C0332z0.l
        C0332z0 m(int i3, int i4, int i5, int i6) {
            b bVar = new b(C0332z0.x(this.f4741c));
            bVar.d(C0332z0.p(k(), i3, i4, i5, i6));
            bVar.c(C0332z0.p(i(), i3, i4, i5, i6));
            return bVar.a();
        }

        @Override // androidx.core.view.C0332z0.l
        boolean o() {
            return this.f4741c.isRound();
        }

        @Override // androidx.core.view.C0332z0.l
        public void p(androidx.core.graphics.e[] eVarArr) {
            this.f4742d = eVarArr;
        }

        @Override // androidx.core.view.C0332z0.l
        void q(androidx.core.graphics.e eVar) {
            this.f4745g = eVar;
        }

        @Override // androidx.core.view.C0332z0.l
        void r(C0332z0 c0332z0) {
            this.f4744f = c0332z0;
        }

        protected androidx.core.graphics.e u(int i3, boolean z3) {
            androidx.core.graphics.e eVarG;
            int i4;
            if (i3 == 1) {
                return z3 ? androidx.core.graphics.e.b(0, Math.max(v().f4483b, k().f4483b), 0, 0) : androidx.core.graphics.e.b(0, k().f4483b, 0, 0);
            }
            if (i3 == 2) {
                if (z3) {
                    androidx.core.graphics.e eVarV = v();
                    androidx.core.graphics.e eVarI = i();
                    return androidx.core.graphics.e.b(Math.max(eVarV.f4482a, eVarI.f4482a), 0, Math.max(eVarV.f4484c, eVarI.f4484c), Math.max(eVarV.f4485d, eVarI.f4485d));
                }
                androidx.core.graphics.e eVarK = k();
                C0332z0 c0332z0 = this.f4744f;
                eVarG = c0332z0 != null ? c0332z0.g() : null;
                int iMin = eVarK.f4485d;
                if (eVarG != null) {
                    iMin = Math.min(iMin, eVarG.f4485d);
                }
                return androidx.core.graphics.e.b(eVarK.f4482a, 0, eVarK.f4484c, iMin);
            }
            if (i3 != 8) {
                if (i3 == 16) {
                    return j();
                }
                if (i3 == 32) {
                    return h();
                }
                if (i3 == 64) {
                    return l();
                }
                if (i3 != 128) {
                    return androidx.core.graphics.e.f4481e;
                }
                C0332z0 c0332z1 = this.f4744f;
                C0314q c0314qE = c0332z1 != null ? c0332z1.e() : f();
                return c0314qE != null ? androidx.core.graphics.e.b(c0314qE.b(), c0314qE.d(), c0314qE.c(), c0314qE.a()) : androidx.core.graphics.e.f4481e;
            }
            androidx.core.graphics.e[] eVarArr = this.f4742d;
            eVarG = eVarArr != null ? eVarArr[m.b(8)] : null;
            if (eVarG != null) {
                return eVarG;
            }
            androidx.core.graphics.e eVarK2 = k();
            androidx.core.graphics.e eVarV2 = v();
            int i5 = eVarK2.f4485d;
            if (i5 > eVarV2.f4485d) {
                return androidx.core.graphics.e.b(0, 0, 0, i5);
            }
            androidx.core.graphics.e eVar = this.f4745g;
            return (eVar == null || eVar.equals(androidx.core.graphics.e.f4481e) || (i4 = this.f4745g.f4485d) <= eVarV2.f4485d) ? androidx.core.graphics.e.f4481e : androidx.core.graphics.e.b(0, 0, 0, i4);
        }

        g(C0332z0 c0332z0, g gVar) {
            this(c0332z0, new WindowInsets(gVar.f4741c));
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$j */
    private static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.e f4747n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.e f4748o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.e f4749p;

        j(C0332z0 c0332z0, WindowInsets windowInsets) {
            super(c0332z0, windowInsets);
            this.f4747n = null;
            this.f4748o = null;
            this.f4749p = null;
        }

        @Override // androidx.core.view.C0332z0.l
        androidx.core.graphics.e h() {
            if (this.f4748o == null) {
                this.f4748o = androidx.core.graphics.e.d(this.f4741c.getMandatorySystemGestureInsets());
            }
            return this.f4748o;
        }

        @Override // androidx.core.view.C0332z0.l
        androidx.core.graphics.e j() {
            if (this.f4747n == null) {
                this.f4747n = androidx.core.graphics.e.d(this.f4741c.getSystemGestureInsets());
            }
            return this.f4747n;
        }

        @Override // androidx.core.view.C0332z0.l
        androidx.core.graphics.e l() {
            if (this.f4749p == null) {
                this.f4749p = androidx.core.graphics.e.d(this.f4741c.getTappableElementInsets());
            }
            return this.f4749p;
        }

        @Override // androidx.core.view.C0332z0.g, androidx.core.view.C0332z0.l
        C0332z0 m(int i3, int i4, int i5, int i6) {
            return C0332z0.x(this.f4741c.inset(i3, i4, i5, i6));
        }

        @Override // androidx.core.view.C0332z0.h, androidx.core.view.C0332z0.l
        public void s(androidx.core.graphics.e eVar) {
        }

        j(C0332z0 c0332z0, j jVar) {
            super(c0332z0, jVar);
            this.f4747n = null;
            this.f4748o = null;
            this.f4749p = null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.z0$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f4726a;

        public b() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f4726a = new e();
                return;
            }
            if (i3 >= 29) {
                this.f4726a = new d();
            } else if (i3 >= 20) {
                this.f4726a = new c();
            } else {
                this.f4726a = new f();
            }
        }

        public C0332z0 a() {
            return this.f4726a.b();
        }

        public b b(int i3, androidx.core.graphics.e eVar) {
            this.f4726a.c(i3, eVar);
            return this;
        }

        public b c(androidx.core.graphics.e eVar) {
            this.f4726a.e(eVar);
            return this;
        }

        public b d(androidx.core.graphics.e eVar) {
            this.f4726a.g(eVar);
            return this;
        }

        public b(C0332z0 c0332z0) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f4726a = new e(c0332z0);
                return;
            }
            if (i3 >= 29) {
                this.f4726a = new d(c0332z0);
            } else if (i3 >= 20) {
                this.f4726a = new c(c0332z0);
            } else {
                this.f4726a = new f(c0332z0);
            }
        }
    }

    public C0332z0(C0332z0 c0332z0) {
        if (c0332z0 != null) {
            l lVar = c0332z0.f4721a;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30 && (lVar instanceof k)) {
                this.f4721a = new k(this, (k) lVar);
            } else if (i3 >= 29 && (lVar instanceof j)) {
                this.f4721a = new j(this, (j) lVar);
            } else if (i3 >= 28 && (lVar instanceof i)) {
                this.f4721a = new i(this, (i) lVar);
            } else if (i3 >= 21 && (lVar instanceof h)) {
                this.f4721a = new h(this, (h) lVar);
            } else if (i3 >= 20 && (lVar instanceof g)) {
                this.f4721a = new g(this, (g) lVar);
            } else {
                this.f4721a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f4721a = new l(this);
    }
}
