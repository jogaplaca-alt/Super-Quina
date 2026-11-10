package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.AbstractC0289d0;

/* JADX INFO: loaded from: classes.dex */
class r0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static r0 f3596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static r0 f3597l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f3599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f3601d = new Runnable() { // from class: androidx.appcompat.widget.p0
        @Override // java.lang.Runnable
        public final void run() {
            this.f3586a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f3602e = new Runnable() { // from class: androidx.appcompat.widget.q0
        @Override // java.lang.Runnable
        public final void run() {
            this.f3592a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private s0 f3605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3607j;

    private r0(View view, CharSequence charSequence) {
        this.f3598a = view;
        this.f3599b = charSequence;
        this.f3600c = AbstractC0289d0.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f3598a.removeCallbacks(this.f3601d);
    }

    private void c() {
        this.f3607j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f3598a.postDelayed(this.f3601d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(r0 r0Var) {
        r0 r0Var2 = f3596k;
        if (r0Var2 != null) {
            r0Var2.b();
        }
        f3596k = r0Var;
        if (r0Var != null) {
            r0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        r0 r0Var = f3596k;
        if (r0Var != null && r0Var.f3598a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new r0(view, charSequence);
            return;
        }
        r0 r0Var2 = f3597l;
        if (r0Var2 != null && r0Var2.f3598a == view) {
            r0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        if (!this.f3607j && Math.abs(x3 - this.f3603f) <= this.f3600c && Math.abs(y3 - this.f3604g) <= this.f3600c) {
            return false;
        }
        this.f3603f = x3;
        this.f3604g = y3;
        this.f3607j = false;
        return true;
    }

    void d() {
        if (f3597l == this) {
            f3597l = null;
            s0 s0Var = this.f3605h;
            if (s0Var != null) {
                s0Var.c();
                this.f3605h = null;
                c();
                this.f3598a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f3596k == this) {
            g(null);
        }
        this.f3598a.removeCallbacks(this.f3602e);
    }

    void i(boolean z3) {
        long longPressTimeout;
        long j3;
        long j4;
        if (androidx.core.view.Z.T(this.f3598a)) {
            g(null);
            r0 r0Var = f3597l;
            if (r0Var != null) {
                r0Var.d();
            }
            f3597l = this;
            this.f3606i = z3;
            s0 s0Var = new s0(this.f3598a.getContext());
            this.f3605h = s0Var;
            s0Var.e(this.f3598a, this.f3603f, this.f3604g, this.f3606i, this.f3599b);
            this.f3598a.addOnAttachStateChangeListener(this);
            if (this.f3606i) {
                j4 = 2500;
            } else {
                if ((androidx.core.view.Z.N(this.f3598a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j3 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j3 = 15000;
                }
                j4 = j3 - longPressTimeout;
            }
            this.f3598a.removeCallbacks(this.f3602e);
            this.f3598a.postDelayed(this.f3602e, j4);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f3605h != null && this.f3606i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f3598a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f3598a.isEnabled() && this.f3605h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f3603f = view.getWidth() / 2;
        this.f3604g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
