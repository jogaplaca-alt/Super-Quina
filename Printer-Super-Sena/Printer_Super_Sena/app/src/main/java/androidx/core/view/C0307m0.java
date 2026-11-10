package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: androidx.core.view.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0307m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f4662a;

    /* JADX INFO: renamed from: androidx.core.view.m0$b */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WindowInsets f4665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4666b;

        public b(int i3) {
            this.f4666b = i3;
        }

        public final int a() {
            return this.f4666b;
        }

        public abstract void b(C0307m0 c0307m0);

        public abstract void c(C0307m0 c0307m0);

        public abstract C0332z0 d(C0332z0 c0332z0, List list);

        public abstract a e(C0307m0 c0307m0, a aVar);
    }

    /* JADX INFO: renamed from: androidx.core.view.m0$c */
    private static class c extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Interpolator f4667e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Interpolator f4668f = new Q.a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Interpolator f4669g = new DecelerateInterpolator();

        /* JADX INFO: renamed from: androidx.core.view.m0$c$a */
        private static class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f4670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private C0332z0 f4671b;

            /* JADX INFO: renamed from: androidx.core.view.m0$c$a$a, reason: collision with other inner class name */
            class C0063a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ C0307m0 f4672a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ C0332z0 f4673b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ C0332z0 f4674c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f4675d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f4676e;

                C0063a(C0307m0 c0307m0, C0332z0 c0332z0, C0332z0 c0332z1, int i3, View view) {
                    this.f4672a = c0307m0;
                    this.f4673b = c0332z0;
                    this.f4674c = c0332z1;
                    this.f4675d = i3;
                    this.f4676e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f4672a.e(valueAnimator.getAnimatedFraction());
                    c.k(this.f4676e, c.o(this.f4673b, this.f4674c, this.f4672a.b(), this.f4675d), Collections.singletonList(this.f4672a));
                }
            }

            /* JADX INFO: renamed from: androidx.core.view.m0$c$a$b */
            class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ C0307m0 f4678a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f4679b;

                b(C0307m0 c0307m0, View view) {
                    this.f4678a = c0307m0;
                    this.f4679b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f4678a.e(1.0f);
                    c.i(this.f4679b, this.f4678a);
                }
            }

            /* JADX INFO: renamed from: androidx.core.view.m0$c$a$c, reason: collision with other inner class name */
            class RunnableC0064c implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f4681a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ C0307m0 f4682b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ a f4683c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ValueAnimator f4684d;

                RunnableC0064c(View view, C0307m0 c0307m0, a aVar, ValueAnimator valueAnimator) {
                    this.f4681a = view;
                    this.f4682b = c0307m0;
                    this.f4683c = aVar;
                    this.f4684d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.l(this.f4681a, this.f4682b, this.f4683c);
                    this.f4684d.start();
                }
            }

            a(View view, b bVar) {
                this.f4670a = bVar;
                C0332z0 c0332z0J = Z.J(view);
                this.f4671b = c0332z0J != null ? new C0332z0.b(c0332z0J).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f4671b = C0332z0.y(windowInsets, view);
                    return c.m(view, windowInsets);
                }
                C0332z0 c0332z0Y = C0332z0.y(windowInsets, view);
                if (this.f4671b == null) {
                    this.f4671b = Z.J(view);
                }
                if (this.f4671b == null) {
                    this.f4671b = c0332z0Y;
                    return c.m(view, windowInsets);
                }
                b bVarN = c.n(view);
                if (bVarN != null && Objects.equals(bVarN.f4665a, windowInsets)) {
                    return c.m(view, windowInsets);
                }
                int iE = c.e(c0332z0Y, this.f4671b);
                if (iE == 0) {
                    return c.m(view, windowInsets);
                }
                C0332z0 c0332z0 = this.f4671b;
                C0307m0 c0307m0 = new C0307m0(iE, c.g(iE, c0332z0Y, c0332z0), 160L);
                c0307m0.e(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(c0307m0.a());
                a aVarF = c.f(c0332z0Y, c0332z0, iE);
                c.j(view, c0307m0, windowInsets, false);
                duration.addUpdateListener(new C0063a(c0307m0, c0332z0Y, c0332z0, iE, view));
                duration.addListener(new b(c0307m0, view));
                L.a(view, new RunnableC0064c(view, c0307m0, aVarF, duration));
                this.f4671b = c0332z0Y;
                return c.m(view, windowInsets);
            }
        }

        c(int i3, Interpolator interpolator, long j3) {
            super(i3, interpolator, j3);
        }

        static int e(C0332z0 c0332z0, C0332z0 c0332z1) {
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if (!c0332z0.f(i4).equals(c0332z1.f(i4))) {
                    i3 |= i4;
                }
            }
            return i3;
        }

        static a f(C0332z0 c0332z0, C0332z0 c0332z1, int i3) {
            androidx.core.graphics.e eVarF = c0332z0.f(i3);
            androidx.core.graphics.e eVarF2 = c0332z1.f(i3);
            return new a(androidx.core.graphics.e.b(Math.min(eVarF.f4482a, eVarF2.f4482a), Math.min(eVarF.f4483b, eVarF2.f4483b), Math.min(eVarF.f4484c, eVarF2.f4484c), Math.min(eVarF.f4485d, eVarF2.f4485d)), androidx.core.graphics.e.b(Math.max(eVarF.f4482a, eVarF2.f4482a), Math.max(eVarF.f4483b, eVarF2.f4483b), Math.max(eVarF.f4484c, eVarF2.f4484c), Math.max(eVarF.f4485d, eVarF2.f4485d)));
        }

        static Interpolator g(int i3, C0332z0 c0332z0, C0332z0 c0332z1) {
            if ((i3 & 8) != 0) {
                return c0332z0.f(C0332z0.m.a()).f4485d > c0332z1.f(C0332z0.m.a()).f4485d ? f4667e : f4668f;
            }
            return f4669g;
        }

        private static View.OnApplyWindowInsetsListener h(View view, b bVar) {
            return new a(view, bVar);
        }

        static void i(View view, C0307m0 c0307m0) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.b(c0307m0);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    i(viewGroup.getChildAt(i3), c0307m0);
                }
            }
        }

        static void j(View view, C0307m0 c0307m0, WindowInsets windowInsets, boolean z3) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.f4665a = windowInsets;
                if (!z3) {
                    bVarN.c(c0307m0);
                    z3 = bVarN.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    j(viewGroup.getChildAt(i3), c0307m0, windowInsets, z3);
                }
            }
        }

        static void k(View view, C0332z0 c0332z0, List list) {
            b bVarN = n(view);
            if (bVarN != null) {
                c0332z0 = bVarN.d(c0332z0, list);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    k(viewGroup.getChildAt(i3), c0332z0, list);
                }
            }
        }

        static void l(View view, C0307m0 c0307m0, a aVar) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.e(c0307m0, aVar);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    l(viewGroup.getChildAt(i3), c0307m0, aVar);
                }
            }
        }

        static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(p070v.b.f12354L) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static b n(View view) {
            Object tag = view.getTag(p070v.b.f12362T);
            if (tag instanceof a) {
                return ((a) tag).f4670a;
            }
            return null;
        }

        static C0332z0 o(C0332z0 c0332z0, C0332z0 c0332z1, float f3, int i3) {
            C0332z0.b bVar = new C0332z0.b(c0332z0);
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) == 0) {
                    bVar.b(i4, c0332z0.f(i4));
                } else {
                    androidx.core.graphics.e eVarF = c0332z0.f(i4);
                    androidx.core.graphics.e eVarF2 = c0332z1.f(i4);
                    float f4 = 1.0f - f3;
                    double d3 = (eVarF.f4482a - eVarF2.f4482a) * f4;
                    Double.isNaN(d3);
                    int i5 = (int) (d3 + 0.5d);
                    double d4 = (eVarF.f4483b - eVarF2.f4483b) * f4;
                    Double.isNaN(d4);
                    double d5 = (eVarF.f4484c - eVarF2.f4484c) * f4;
                    Double.isNaN(d5);
                    int i6 = (int) (d5 + 0.5d);
                    double d6 = (eVarF.f4485d - eVarF2.f4485d) * f4;
                    Double.isNaN(d6);
                    bVar.b(i4, C0332z0.p(eVarF, i5, (int) (d4 + 0.5d), i6, (int) (d6 + 0.5d)));
                }
            }
            return bVar.a();
        }

        static void p(View view, b bVar) {
            Object tag = view.getTag(p070v.b.f12354L);
            if (bVar == null) {
                view.setTag(p070v.b.f12362T, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerH = h(view, bVar);
            view.setTag(p070v.b.f12362T, onApplyWindowInsetsListenerH);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerH);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.m0$e */
    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f4692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Interpolator f4693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f4694d;

        e(int i3, Interpolator interpolator, long j3) {
            this.f4691a = i3;
            this.f4693c = interpolator;
            this.f4694d = j3;
        }

        public long a() {
            return this.f4694d;
        }

        public float b() {
            Interpolator interpolator = this.f4693c;
            return interpolator != null ? interpolator.getInterpolation(this.f4692b) : this.f4692b;
        }

        public int c() {
            return this.f4691a;
        }

        public void d(float f3) {
            this.f4692b = f3;
        }
    }

    public C0307m0(int i3, Interpolator interpolator, long j3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            this.f4662a = new d(i3, interpolator, j3);
        } else if (i4 >= 21) {
            this.f4662a = new c(i3, interpolator, j3);
        } else {
            this.f4662a = new e(0, interpolator, j3);
        }
    }

    static void d(View view, b bVar) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            d.h(view, bVar);
        } else if (i3 >= 21) {
            c.p(view, bVar);
        }
    }

    static C0307m0 f(WindowInsetsAnimation windowInsetsAnimation) {
        return new C0307m0(windowInsetsAnimation);
    }

    public long a() {
        return this.f4662a.a();
    }

    public float b() {
        return this.f4662a.b();
    }

    public int c() {
        return this.f4662a.c();
    }

    public void e(float f3) {
        this.f4662a.d(f3);
    }

    /* JADX INFO: renamed from: androidx.core.view.m0$d */
    private static class d extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final WindowInsetsAnimation f4686e;

        /* JADX INFO: renamed from: androidx.core.view.m0$d$a */
        private static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b f4687a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List f4688b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private ArrayList f4689c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final HashMap f4690d;

            a(b bVar) {
                super(bVar.a());
                this.f4690d = new HashMap();
                this.f4687a = bVar;
            }

            private C0307m0 a(WindowInsetsAnimation windowInsetsAnimation) {
                C0307m0 c0307m0 = (C0307m0) this.f4690d.get(windowInsetsAnimation);
                if (c0307m0 != null) {
                    return c0307m0;
                }
                C0307m0 c0307m0F = C0307m0.f(windowInsetsAnimation);
                this.f4690d.put(windowInsetsAnimation, c0307m0F);
                return c0307m0F;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f4687a.b(a(windowInsetsAnimation));
                this.f4690d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f4687a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f4689c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f4689c = arrayList2;
                    this.f4688b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = AbstractC0326w0.a(list.get(size));
                    C0307m0 c0307m0A = a(windowInsetsAnimationA);
                    c0307m0A.e(windowInsetsAnimationA.getFraction());
                    this.f4689c.add(c0307m0A);
                }
                return this.f4687a.d(C0332z0.x(windowInsets), this.f4688b).w();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f4687a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f4686e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().e(), aVar.b().e());
        }

        public static androidx.core.graphics.e f(WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.e.d(bounds.getUpperBound());
        }

        public static androidx.core.graphics.e g(WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.e.d(bounds.getLowerBound());
        }

        public static void h(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // androidx.core.view.C0307m0.e
        public long a() {
            return this.f4686e.getDurationMillis();
        }

        @Override // androidx.core.view.C0307m0.e
        public float b() {
            return this.f4686e.getInterpolatedFraction();
        }

        @Override // androidx.core.view.C0307m0.e
        public int c() {
            return this.f4686e.getTypeMask();
        }

        @Override // androidx.core.view.C0307m0.e
        public void d(float f3) {
            this.f4686e.setFraction(f3);
        }

        d(int i3, Interpolator interpolator, long j3) {
            this(new WindowInsetsAnimation(i3, interpolator, j3));
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.m0$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.core.graphics.e f4663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.graphics.e f4664b;

        public a(androidx.core.graphics.e eVar, androidx.core.graphics.e eVar2) {
            this.f4663a = eVar;
            this.f4664b = eVar2;
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public androidx.core.graphics.e a() {
            return this.f4663a;
        }

        public androidx.core.graphics.e b() {
            return this.f4664b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f4663a + " upper=" + this.f4664b + "}";
        }

        private a(WindowInsetsAnimation.Bounds bounds) {
            this.f4663a = d.g(bounds);
            this.f4664b = d.f(bounds);
        }
    }

    private C0307m0(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4662a = new d(windowInsetsAnimation);
        }
    }
}
