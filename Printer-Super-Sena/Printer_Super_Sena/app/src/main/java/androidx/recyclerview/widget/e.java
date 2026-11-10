package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
class e extends RecyclerView.n implements RecyclerView.s {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final int[] f6131D = {R.attr.state_pressed};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final int[] f6132E = new int[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    int f6133A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final Runnable f6134B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private final RecyclerView.t f6135C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final StateListDrawable f6138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Drawable f6139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateListDrawable f6142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable f6143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f6144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f6145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f6146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f6147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f6148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f6149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f6150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f6151p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f6154s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final ValueAnimator f6161z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6152q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6153r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6155t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6156u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f6157v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6158w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int[] f6159x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int[] f6160y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q(500);
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            e.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6164a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6164a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f6164a) {
                this.f6164a = false;
                return;
            }
            if (((Float) e.this.f6161z.getAnimatedValue()).floatValue() == 0.0f) {
                e eVar = e.this;
                eVar.f6133A = 0;
                eVar.y(0);
            } else {
                e eVar2 = e.this;
                eVar2.f6133A = 2;
                eVar2.v();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            e.this.f6138c.setAlpha(iFloatValue);
            e.this.f6139d.setAlpha(iFloatValue);
            e.this.v();
        }
    }

    e(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i4, int i5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6161z = valueAnimatorOfFloat;
        this.f6133A = 0;
        this.f6134B = new a();
        this.f6135C = new b();
        this.f6138c = stateListDrawable;
        this.f6139d = drawable;
        this.f6142g = stateListDrawable2;
        this.f6143h = drawable2;
        this.f6140e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f6141f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f6144i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f6145j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f6136a = i4;
        this.f6137b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        j(recyclerView);
    }

    private void C(float f3) {
        int[] iArrP = p();
        float fMax = Math.max(iArrP[0], Math.min(iArrP[1], f3));
        if (Math.abs(this.f6147l - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f6148m, fMax, iArrP, this.f6154s.computeVerticalScrollRange(), this.f6154s.computeVerticalScrollOffset(), this.f6153r);
        if (iX != 0) {
            this.f6154s.scrollBy(0, iX);
        }
        this.f6148m = fMax;
    }

    private void k() {
        this.f6154s.removeCallbacks(this.f6134B);
    }

    private void l() {
        this.f6154s.X0(this);
        this.f6154s.Y0(this);
        this.f6154s.Z0(this.f6135C);
        k();
    }

    private void m(Canvas canvas) {
        int i3 = this.f6153r;
        int i4 = this.f6144i;
        int i5 = i3 - i4;
        int i6 = this.f6150o;
        int i7 = this.f6149n;
        int i8 = i6 - (i7 / 2);
        this.f6142g.setBounds(0, 0, i7, i4);
        this.f6143h.setBounds(0, 0, this.f6152q, this.f6145j);
        canvas.translate(0.0f, i5);
        this.f6143h.draw(canvas);
        canvas.translate(i8, 0.0f);
        this.f6142g.draw(canvas);
        canvas.translate(-i8, -i5);
    }

    private void n(Canvas canvas) {
        int i3 = this.f6152q;
        int i4 = this.f6140e;
        int i5 = i3 - i4;
        int i6 = this.f6147l;
        int i7 = this.f6146k;
        int i8 = i6 - (i7 / 2);
        this.f6138c.setBounds(0, 0, i4, i7);
        this.f6139d.setBounds(0, 0, this.f6141f, this.f6153r);
        if (!s()) {
            canvas.translate(i5, 0.0f);
            this.f6139d.draw(canvas);
            canvas.translate(0.0f, i8);
            this.f6138c.draw(canvas);
            canvas.translate(-i5, -i8);
            return;
        }
        this.f6139d.draw(canvas);
        canvas.translate(this.f6140e, i8);
        canvas.scale(-1.0f, 1.0f);
        this.f6138c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f6140e, -i8);
    }

    private int[] o() {
        int[] iArr = this.f6160y;
        int i3 = this.f6137b;
        iArr[0] = i3;
        iArr[1] = this.f6152q - i3;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f6159x;
        int i3 = this.f6137b;
        iArr[0] = i3;
        iArr[1] = this.f6153r - i3;
        return iArr;
    }

    private void r(float f3) {
        int[] iArrO = o();
        float fMax = Math.max(iArrO[0], Math.min(iArrO[1], f3));
        if (Math.abs(this.f6150o - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f6151p, fMax, iArrO, this.f6154s.computeHorizontalScrollRange(), this.f6154s.computeHorizontalScrollOffset(), this.f6152q);
        if (iX != 0) {
            this.f6154s.scrollBy(iX, 0);
        }
        this.f6151p = fMax;
    }

    private boolean s() {
        return Z.C(this.f6154s) == 1;
    }

    private void w(int i3) {
        k();
        this.f6154s.postDelayed(this.f6134B, i3);
    }

    private int x(float f3, float f4, int[] iArr, int i3, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i3 - i5;
        int i8 = (int) (((f4 - f3) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    private void z() {
        this.f6154s.h(this);
        this.f6154s.k(this);
        this.f6154s.l(this.f6135C);
    }

    public void A() {
        int i3 = this.f6133A;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                this.f6161z.cancel();
            }
        }
        this.f6133A = 1;
        ValueAnimator valueAnimator = this.f6161z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f6161z.setDuration(500L);
        this.f6161z.setStartDelay(0L);
        this.f6161z.start();
    }

    void B(int i3, int i4) {
        int iComputeVerticalScrollRange = this.f6154s.computeVerticalScrollRange();
        int i5 = this.f6153r;
        this.f6155t = iComputeVerticalScrollRange - i5 > 0 && i5 >= this.f6136a;
        int iComputeHorizontalScrollRange = this.f6154s.computeHorizontalScrollRange();
        int i6 = this.f6152q;
        boolean z3 = iComputeHorizontalScrollRange - i6 > 0 && i6 >= this.f6136a;
        this.f6156u = z3;
        boolean z4 = this.f6155t;
        if (!z4 && !z3) {
            if (this.f6157v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z4) {
            float f3 = i5;
            this.f6147l = (int) ((f3 * (i4 + (f3 / 2.0f))) / iComputeVerticalScrollRange);
            this.f6146k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
        }
        if (this.f6156u) {
            float f4 = i6;
            this.f6150o = (int) ((f4 * (i3 + (f4 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f6149n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
        }
        int i7 = this.f6157v;
        if (i7 == 0 || i7 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i3 = this.f6157v;
        if (i3 == 1) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zU && !zT) {
                return false;
            }
            if (zT) {
                this.f6158w = 1;
                this.f6151p = (int) motionEvent.getX();
            } else if (zU) {
                this.f6158w = 2;
                this.f6148m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i3 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f6157v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (zU || zT) {
                if (zT) {
                    this.f6158w = 1;
                    this.f6151p = (int) motionEvent.getX();
                } else if (zU) {
                    this.f6158w = 2;
                    this.f6148m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f6157v == 2) {
            this.f6148m = 0.0f;
            this.f6151p = 0.0f;
            y(1);
            this.f6158w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f6157v == 2) {
            A();
            if (this.f6158w == 1) {
                r(motionEvent.getX());
            }
            if (this.f6158w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.A a3) {
        if (this.f6152q != this.f6154s.getWidth() || this.f6153r != this.f6154s.getHeight()) {
            this.f6152q = this.f6154s.getWidth();
            this.f6153r = this.f6154s.getHeight();
            y(0);
        } else if (this.f6133A != 0) {
            if (this.f6155t) {
                n(canvas);
            }
            if (this.f6156u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6154s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f6154s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i3) {
        int i4 = this.f6133A;
        if (i4 == 1) {
            this.f6161z.cancel();
        } else if (i4 != 2) {
            return;
        }
        this.f6133A = 3;
        ValueAnimator valueAnimator = this.f6161z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f6161z.setDuration(i3);
        this.f6161z.start();
    }

    boolean t(float f3, float f4) {
        if (f4 >= this.f6153r - this.f6144i) {
            int i3 = this.f6150o;
            int i4 = this.f6149n;
            if (f3 >= i3 - (i4 / 2) && f3 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f3, float f4) {
        if (!s() ? f3 >= this.f6152q - this.f6140e : f3 <= this.f6140e / 2) {
            int i3 = this.f6147l;
            int i4 = this.f6146k;
            if (f4 >= i3 - (i4 / 2) && f4 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f6154s.invalidate();
    }

    void y(int i3) {
        if (i3 == 2 && this.f6157v != 2) {
            this.f6138c.setState(f6131D);
            k();
        }
        if (i3 == 0) {
            v();
        } else {
            A();
        }
        if (this.f6157v == 2 && i3 != 2) {
            this.f6138c.setState(f6132E);
            w(1200);
        } else if (i3 == 1) {
            w(1500);
        }
        this.f6157v = i3;
    }
}
