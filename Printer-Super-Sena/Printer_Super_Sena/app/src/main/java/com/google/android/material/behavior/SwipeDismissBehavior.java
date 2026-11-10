package com.google.android.material.behavior;

import A.T;
import A.Y;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.Z;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    G.c f7687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7689c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7691e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7690d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f7692f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f7693g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f7694h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f7695i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final G.c.AbstractC0015c f7696j = new a();

    class a extends G.c.AbstractC0015c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7698b = -1;

        a() {
        }

        private boolean n(View view, float f3) {
            if (f3 == 0.0f) {
                return Math.abs(view.getLeft() - this.f7697a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f7693g);
            }
            boolean z3 = Z.C(view) == 1;
            int i3 = SwipeDismissBehavior.this.f7692f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z3) {
                    if (f3 >= 0.0f) {
                        return false;
                    }
                } else if (f3 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i3 != 1) {
                return false;
            }
            if (z3) {
                if (f3 <= 0.0f) {
                    return false;
                }
            } else if (f3 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // G.c.AbstractC0015c
        public int a(View view, int i3, int i4) {
            int width;
            int width2;
            int width3;
            boolean z3 = Z.C(view) == 1;
            int i5 = SwipeDismissBehavior.this.f7692f;
            if (i5 == 0) {
                if (z3) {
                    width = this.f7697a - view.getWidth();
                    width2 = this.f7697a;
                } else {
                    width = this.f7697a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i5 != 1) {
                width = this.f7697a - view.getWidth();
                width2 = view.getWidth() + this.f7697a;
            } else if (z3) {
                width = this.f7697a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f7697a - view.getWidth();
                width2 = this.f7697a;
            }
            return SwipeDismissBehavior.L(width, i3, width2);
        }

        @Override // G.c.AbstractC0015c
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // G.c.AbstractC0015c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // G.c.AbstractC0015c
        public void i(View view, int i3) {
            this.f7698b = i3;
            this.f7697a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f7689c = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f7689c = false;
            }
        }

        @Override // G.c.AbstractC0015c
        public void j(int i3) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // G.c.AbstractC0015c
        public void k(View view, int i3, int i4, int i5, int i6) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f7694h;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f7695i;
            float fAbs = Math.abs(i3 - this.f7697a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.K(0.0f, 1.0f - SwipeDismissBehavior.N(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001d  */
        @Override // G.c.AbstractC0015c
        public void l(View view, float f3, float f4) {
            int i3;
            boolean z3;
            this.f7698b = -1;
            int width = view.getWidth();
            if (n(view, f3)) {
                if (f3 >= 0.0f) {
                    int left = view.getLeft();
                    int i4 = this.f7697a;
                    if (left < i4) {
                        i3 = this.f7697a - width;
                    } else {
                        i3 = i4 + width;
                    }
                } else {
                    i3 = this.f7697a - width;
                }
                z3 = true;
            } else {
                i3 = this.f7697a;
                z3 = false;
            }
            if (SwipeDismissBehavior.this.f7687a.O(i3, view.getTop())) {
                Z.i0(view, new c(view, z3));
            } else if (z3) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // G.c.AbstractC0015c
        public boolean m(View view, int i3) {
            int i4 = this.f7698b;
            return (i4 == -1 || i4 == i3) && SwipeDismissBehavior.this.J(view);
        }
    }

    class b implements Y {
        b() {
        }

        @Override // A.Y
        public boolean a(View view, Y.a aVar) {
            if (!SwipeDismissBehavior.this.J(view)) {
                return false;
            }
            boolean z3 = Z.C(view) == 1;
            int i3 = SwipeDismissBehavior.this.f7692f;
            Z.a0(view, (!(i3 == 0 && z3) && (i3 != 1 || z3)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f7701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f7702b;

        c(View view, boolean z3) {
            this.f7701a = view;
            this.f7702b = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            G.c cVar = SwipeDismissBehavior.this.f7687a;
            if (cVar != null && cVar.m(true)) {
                Z.i0(this.f7701a, this);
            } else if (this.f7702b) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float K(float f3, float f4, float f5) {
        return Math.min(Math.max(f3, f4), f5);
    }

    static int L(int i3, int i4, int i5) {
        return Math.min(Math.max(i3, i4), i5);
    }

    private void M(ViewGroup viewGroup) {
        if (this.f7687a == null) {
            this.f7687a = this.f7691e ? G.c.n(viewGroup, this.f7690d, this.f7696j) : G.c.o(viewGroup, this.f7696j);
        }
    }

    static float N(float f3, float f4, float f5) {
        return (f5 - f3) / (f4 - f3);
    }

    private void R(View view) {
        Z.k0(view, 1048576);
        if (J(view)) {
            Z.m0(view, T.a.f46y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f7687a == null) {
            return false;
        }
        if (this.f7689c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f7687a.F(motionEvent);
        return true;
    }

    public boolean J(View view) {
        return true;
    }

    public void O(float f3) {
        this.f7695i = K(0.0f, f3, 1.0f);
    }

    public void P(float f3) {
        this.f7694h = K(0.0f, f3, 1.0f);
    }

    public void Q(int i3) {
        this.f7692f = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zC = this.f7688b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zC = coordinatorLayout.C(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f7688b = zC;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f7688b = false;
        }
        if (!zC) {
            return false;
        }
        M(coordinatorLayout);
        return !this.f7689c && this.f7687a.P(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i3) {
        boolean zP = super.p(coordinatorLayout, view, i3);
        if (Z.A(view) == 0) {
            Z.z0(view, 1);
            R(view);
        }
        return zP;
    }
}
