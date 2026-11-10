package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
abstract class j extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f7649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f7650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VelocityTracker f7655j;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f7656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f7657b;

        a(CoordinatorLayout coordinatorLayout, View view) {
            this.f7656a = coordinatorLayout;
            this.f7657b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f7657b == null || (overScroller = j.this.f7650e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                j.this.R(this.f7656a, this.f7657b);
                return;
            }
            j jVar = j.this;
            jVar.T(this.f7656a, this.f7657b, jVar.f7650e.getCurrY());
            Z.i0(this.f7657b, this);
        }
    }

    public j() {
        this.f7652g = -1;
        this.f7654i = -1;
    }

    private void M() {
        if (this.f7655j == null) {
            this.f7655j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z3;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f7655j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f7655j.computeCurrentVelocity(1000);
                N(coordinatorLayout, view, -P(view), 0, this.f7655j.getYVelocity(this.f7652g));
                z3 = true;
            }
            this.f7651f = false;
            this.f7652g = -1;
            velocityTracker = this.f7655j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7655j = null;
            }
            velocityTracker2 = this.f7655j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f7651f) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f7652g);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            int i3 = this.f7653h - y3;
            this.f7653h = y3;
            S(coordinatorLayout, view, i3, O(view), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i4 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f7652g = motionEvent.getPointerId(i4);
                this.f7653h = (int) (motionEvent.getY(i4) + 0.5f);
            }
        }
        z3 = false;
        velocityTracker2 = this.f7655j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f7651f || z3;
        z3 = false;
        this.f7651f = false;
        this.f7652g = -1;
        velocityTracker = this.f7655j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7655j = null;
        }
        velocityTracker2 = this.f7655j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f7651f) {
            return true;
        }
    }

    abstract boolean L(View view);

    final boolean N(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, float f3) {
        Runnable runnable = this.f7649d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f7649d = null;
        }
        if (this.f7650e == null) {
            this.f7650e = new OverScroller(view.getContext());
        }
        this.f7650e.fling(0, I(), 0, Math.round(f3), 0, 0, i3, i4);
        if (!this.f7650e.computeScrollOffset()) {
            R(coordinatorLayout, view);
            return false;
        }
        a aVar = new a(coordinatorLayout, view);
        this.f7649d = aVar;
        Z.i0(view, aVar);
        return true;
    }

    abstract int O(View view);

    abstract int P(View view);

    abstract int Q();

    abstract void R(CoordinatorLayout coordinatorLayout, View view);

    final int S(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        return U(coordinatorLayout, view, Q() - i3, i4, i5);
    }

    int T(CoordinatorLayout coordinatorLayout, View view, int i3) {
        return U(coordinatorLayout, view, i3, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int U(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f7654i < 0) {
            this.f7654i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f7651f) {
            int i3 = this.f7652g;
            if (i3 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y3 - this.f7653h) > this.f7654i) {
                this.f7653h = y3;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f7652g = -1;
            int x3 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            boolean z3 = L(view) && coordinatorLayout.C(view, x3, y4);
            this.f7651f = z3;
            if (z3) {
                this.f7653h = y4;
                this.f7652g = motionEvent.getPointerId(0);
                M();
                OverScroller overScroller = this.f7650e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f7650e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f7655j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7652g = -1;
        this.f7654i = -1;
    }
}
