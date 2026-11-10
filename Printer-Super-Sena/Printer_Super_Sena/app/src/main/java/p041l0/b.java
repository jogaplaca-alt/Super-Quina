package p041l0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9793a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9794b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f9795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f9796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f9798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f9800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f9801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f9802j;

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f9801i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9800h = viewConfiguration.getScaledTouchSlop();
        this.f9802j = cVar;
        this.f9795c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f9794b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f9794b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f9793a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f9796d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f9798f = b(motionEvent);
            this.f9799g = c(motionEvent);
            this.f9797e = false;
        } else if (action == 1) {
            this.f9793a = -1;
            if (this.f9797e && this.f9796d != null) {
                this.f9798f = b(motionEvent);
                this.f9799g = c(motionEvent);
                this.f9796d.addMovement(motionEvent);
                this.f9796d.computeCurrentVelocity(1000);
                float xVelocity = this.f9796d.getXVelocity();
                float yVelocity = this.f9796d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f9801i) {
                    this.f9802j.c(this.f9798f, this.f9799g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f9796d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f9796d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f3 = fB - this.f9798f;
            float f4 = fC - this.f9799g;
            if (!this.f9797e) {
                this.f9797e = Math.sqrt((double) ((f3 * f3) + (f4 * f4))) >= ((double) this.f9800h);
            }
            if (this.f9797e) {
                this.f9802j.b(f3, f4);
                this.f9798f = fB;
                this.f9799g = fC;
                VelocityTracker velocityTracker2 = this.f9796d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f9793a = -1;
            VelocityTracker velocityTracker3 = this.f9796d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f9796d = null;
            }
        } else if (action == 6) {
            int iB = l.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.f9793a) {
                int i3 = iB == 0 ? 1 : 0;
                this.f9793a = motionEvent.getPointerId(i3);
                this.f9798f = motionEvent.getX(i3);
                this.f9799g = motionEvent.getY(i3);
            }
        }
        int i4 = this.f9793a;
        this.f9794b = motionEvent.findPointerIndex(i4 != -1 ? i4 : 0);
        return true;
    }

    public boolean d() {
        return this.f9797e;
    }

    public boolean e() {
        return this.f9795c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f9795c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.f9802j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }
}
