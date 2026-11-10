package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class V implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f3331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f3332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f3333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f3336i = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = V.this.f3331d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            V.this.e();
        }
    }

    public V(View view) {
        this.f3331d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f3328a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f3329b = tapTimeout;
        this.f3330c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f3333f;
        if (runnable != null) {
            this.f3331d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f3332e;
        if (runnable2 != null) {
            this.f3331d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        T t3;
        View view = this.f3331d;
        androidx.appcompat.view.menu.p pVarB = b();
        if (pVarB == null || !pVarB.b() || (t3 = (T) pVarB.k()) == null || !t3.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(t3, motionEventObtainNoHistory);
        boolean zE = t3.e(motionEventObtainNoHistory, this.f3335h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f3331d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3335h = motionEvent.getPointerId(0);
            if (this.f3332e == null) {
                this.f3332e = new a();
            }
            view.postDelayed(this.f3332e, this.f3329b);
            if (this.f3333f == null) {
                this.f3333f = new b();
            }
            view.postDelayed(this.f3333f, this.f3330c);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3335h);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f3328a)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            a();
        }
        return false;
    }

    private static boolean h(View view, float f3, float f4, float f5) {
        float f6 = -f5;
        return f3 >= f6 && f4 >= f6 && f3 < ((float) (view.getRight() - view.getLeft())) + f5 && f4 < ((float) (view.getBottom() - view.getTop())) + f5;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f3336i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f3336i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.p b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.p pVarB = b();
        if (pVarB == null || !pVarB.b()) {
            return true;
        }
        pVarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f3331d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f3334g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z3;
        boolean z4 = this.f3334g;
        if (z4) {
            z3 = f(motionEvent) || !d();
        } else {
            z3 = g(motionEvent) && c();
            if (z3) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f3331d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f3334g = z3;
        return z3 || z4;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f3334g = false;
        this.f3335h = -1;
        Runnable runnable = this.f3332e;
        if (runnable != null) {
            this.f3331d.removeCallbacks(runnable);
        }
    }
}
