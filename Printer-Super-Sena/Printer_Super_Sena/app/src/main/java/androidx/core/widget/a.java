package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f4787r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f4790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f4791d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4795h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f4800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f4801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f4802o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4803p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f4804q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0065a f4788a = new C0065a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Interpolator f4789b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f4792e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f4793f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f4796i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f4797j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f4798k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0065a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f4807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f4808d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f4814j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f4815k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4809e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f4813i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f4810f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f4811g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f4812h = 0;

        C0065a() {
        }

        private float e(long j3) {
            long j4 = this.f4809e;
            if (j3 < j4) {
                return 0.0f;
            }
            long j5 = this.f4813i;
            if (j5 < 0 || j3 < j5) {
                return a.e((j3 - j4) / this.f4805a, 0.0f, 1.0f) * 0.5f;
            }
            float f3 = this.f4814j;
            return (1.0f - f3) + (f3 * a.e((j3 - j5) / this.f4815k, 0.0f, 1.0f));
        }

        private float g(float f3) {
            return ((-4.0f) * f3 * f3) + (f3 * 4.0f);
        }

        public void a() {
            if (this.f4810f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j3 = jCurrentAnimationTimeMillis - this.f4810f;
            this.f4810f = jCurrentAnimationTimeMillis;
            float f3 = j3 * fG;
            this.f4811g = (int) (this.f4807c * f3);
            this.f4812h = (int) (f3 * this.f4808d);
        }

        public int b() {
            return this.f4811g;
        }

        public int c() {
            return this.f4812h;
        }

        public int d() {
            float f3 = this.f4807c;
            return (int) (f3 / Math.abs(f3));
        }

        public int f() {
            float f3 = this.f4808d;
            return (int) (f3 / Math.abs(f3));
        }

        public boolean h() {
            return this.f4813i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f4813i + ((long) this.f4815k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f4815k = a.f((int) (jCurrentAnimationTimeMillis - this.f4809e), 0, this.f4806b);
            this.f4814j = e(jCurrentAnimationTimeMillis);
            this.f4813i = jCurrentAnimationTimeMillis;
        }

        public void j(int i3) {
            this.f4806b = i3;
        }

        public void k(int i3) {
            this.f4805a = i3;
        }

        public void l(float f3, float f4) {
            this.f4807c = f3;
            this.f4808d = f4;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f4809e = jCurrentAnimationTimeMillis;
            this.f4813i = -1L;
            this.f4810f = jCurrentAnimationTimeMillis;
            this.f4814j = 0.5f;
            this.f4811g = 0;
            this.f4812h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f4802o) {
                if (aVar.f4800m) {
                    aVar.f4800m = false;
                    aVar.f4788a.m();
                }
                C0065a c0065a = a.this.f4788a;
                if (c0065a.h() || !a.this.u()) {
                    a.this.f4802o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f4801n) {
                    aVar2.f4801n = false;
                    aVar2.c();
                }
                c0065a.a();
                a.this.j(c0065a.b(), c0065a.c());
                Z.i0(a.this.f4790c, this);
            }
        }
    }

    public a(View view) {
        this.f4790c = view;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = (int) ((1575.0f * f3) + 0.5f);
        o(f4, f4);
        float f5 = (int) ((f3 * 315.0f) + 0.5f);
        p(f5, f5);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f4787r);
        r(500);
        q(500);
    }

    private float d(int i3, float f3, float f4, float f5) {
        float fH = h(this.f4792e[i3], f4, this.f4793f[i3], f3);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f6 = this.f4796i[i3];
        float f7 = this.f4797j[i3];
        float f8 = this.f4798k[i3];
        float f9 = f6 * f5;
        return fH > 0.0f ? e(fH * f9, f7, f8) : -e((-fH) * f9, f7, f8);
    }

    static float e(float f3, float f4, float f5) {
        if (f3 > f5) {
            return f5;
        }
        return f3 < f4 ? f4 : f3;
    }

    static int f(int i3, int i4, int i5) {
        if (i3 > i5) {
            return i5;
        }
        return i3 < i4 ? i4 : i3;
    }

    private float g(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.f4794g;
        if (i3 == 0 || i3 == 1) {
            if (f3 < f4) {
                if (f3 >= 0.0f) {
                    return 1.0f - (f3 / f4);
                }
                if (this.f4802o && i3 == 1) {
                    return 1.0f;
                }
            }
        } else if (i3 == 2 && f3 < 0.0f) {
            return f3 / (-f4);
        }
        return 0.0f;
    }

    private float h(float f3, float f4, float f5, float f6) {
        float interpolation;
        float fE = e(f3 * f4, 0.0f, f5);
        float fG = g(f4 - f6, fE) - g(f6, fE);
        if (fG < 0.0f) {
            interpolation = -this.f4789b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f4789b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f4800m) {
            this.f4802o = false;
        } else {
            this.f4788a.i();
        }
    }

    private void v() {
        int i3;
        if (this.f4791d == null) {
            this.f4791d = new b();
        }
        this.f4802o = true;
        this.f4800m = true;
        if (this.f4799l || (i3 = this.f4795h) <= 0) {
            this.f4791d.run();
        } else {
            Z.j0(this.f4790c, this.f4791d, i3);
        }
        this.f4799l = true;
    }

    public abstract boolean a(int i3);

    public abstract boolean b(int i3);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f4790c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i3, int i4);

    public a k(int i3) {
        this.f4795h = i3;
        return this;
    }

    public a l(int i3) {
        this.f4794g = i3;
        return this;
    }

    public a m(boolean z3) {
        if (this.f4803p && !z3) {
            i();
        }
        this.f4803p = z3;
        return this;
    }

    public a n(float f3, float f4) {
        float[] fArr = this.f4793f;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a o(float f3, float f4) {
        float[] fArr = this.f4798k;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f4803p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i();
                }
            }
            return this.f4804q && this.f4802o;
        }
        this.f4801n = true;
        this.f4799l = false;
        this.f4788a.l(d(0, motionEvent.getX(), view.getWidth(), this.f4790c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f4790c.getHeight()));
        if (!this.f4802o && u()) {
            v();
        }
        if (this.f4804q) {
            return false;
        }
    }

    public a p(float f3, float f4) {
        float[] fArr = this.f4797j;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    public a q(int i3) {
        this.f4788a.j(i3);
        return this;
    }

    public a r(int i3) {
        this.f4788a.k(i3);
        return this;
    }

    public a s(float f3, float f4) {
        float[] fArr = this.f4792e;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a t(float f3, float f4) {
        float[] fArr = this.f4796i;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    boolean u() {
        C0065a c0065a = this.f4788a;
        int iF = c0065a.f();
        int iD = c0065a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
