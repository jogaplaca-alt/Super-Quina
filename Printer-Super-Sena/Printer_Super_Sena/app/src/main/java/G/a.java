package G;

import A.T;
import A.W;
import A.X;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C0282a;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.List;
import p046n.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends C0282a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Rect f1024n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final G.b.a f1025o = new C0013a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final G.b.InterfaceC0014b f1026p = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f1031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f1032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f1033j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f1027d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f1028e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f1029f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f1030g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f1034k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f1035l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1036m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: G.a$a, reason: collision with other inner class name */
    class C0013a implements G.b.a {
        C0013a() {
        }

        @Override // G.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(T t3, Rect rect) {
            t3.m(rect);
        }
    }

    class b implements G.b.InterfaceC0014b {
        b() {
        }

        @Override // G.b.InterfaceC0014b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public T b(h hVar, int i3) {
            return (T) hVar.l(i3);
        }

        @Override // G.b.InterfaceC0014b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h hVar) {
            return hVar.k();
        }
    }

    private class c extends W {
        c() {
        }

        @Override // A.W
        public T b(int i3) {
            return T.a0(a.this.H(i3));
        }

        @Override // A.W
        public T d(int i3) {
            int i4 = i3 == 2 ? a.this.f1034k : a.this.f1035l;
            if (i4 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i4);
        }

        @Override // A.W
        public boolean f(int i3, int i4, Bundle bundle) {
            return a.this.P(i3, i4, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1032i = view;
        this.f1031h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (Z.A(view) == 0) {
            Z.z0(view, 1);
        }
    }

    private static Rect D(View view, int i3, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i3 == 17) {
            rect.set(width, 0, width, height);
        } else if (i3 == 33) {
            rect.set(0, height, width, height);
        } else if (i3 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f1032i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f1032i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int F(int i3) {
        if (i3 == 19) {
            return 33;
        }
        if (i3 != 21) {
            return i3 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i3, Rect rect) {
        T t3;
        h hVarY = y();
        int i4 = this.f1035l;
        T t4 = i4 == Integer.MIN_VALUE ? null : (T) hVarY.f(i4);
        if (i3 == 1 || i3 == 2) {
            t3 = (T) G.b.d(hVarY, f1026p, f1025o, t4, i3, Z.C(this.f1032i) == 1, false);
        } else {
            if (i3 != 17 && i3 != 33 && i3 != 66 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i5 = this.f1035l;
            if (i5 != Integer.MIN_VALUE) {
                z(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f1032i, i3, rect2);
            }
            t3 = (T) G.b.c(hVarY, f1026p, f1025o, t4, rect2, i3);
        }
        return T(t3 != null ? hVarY.i(hVarY.h(t3)) : Integer.MIN_VALUE);
    }

    private boolean Q(int i3, int i4, Bundle bundle) {
        if (i4 == 1) {
            return T(i3);
        }
        if (i4 == 2) {
            return o(i3);
        }
        if (i4 != 64) {
            return i4 != 128 ? J(i3, i4, bundle) : n(i3);
        }
        return S(i3);
    }

    private boolean R(int i3, Bundle bundle) {
        return Z.f0(this.f1032i, i3, bundle);
    }

    private boolean S(int i3) {
        int i4;
        if (!this.f1031h.isEnabled() || !this.f1031h.isTouchExplorationEnabled() || (i4 = this.f1034k) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            n(i4);
        }
        this.f1034k = i3;
        this.f1032i.invalidate();
        U(i3, 32768);
        return true;
    }

    private void V(int i3) {
        int i4 = this.f1036m;
        if (i4 == i3) {
            return;
        }
        this.f1036m = i3;
        U(i3, 128);
        U(i4, 256);
    }

    private boolean n(int i3) {
        if (this.f1034k != i3) {
            return false;
        }
        this.f1034k = Integer.MIN_VALUE;
        this.f1032i.invalidate();
        U(i3, 65536);
        return true;
    }

    private boolean p() {
        int i3 = this.f1035l;
        return i3 != Integer.MIN_VALUE && J(i3, 16, null);
    }

    private AccessibilityEvent q(int i3, int i4) {
        return i3 != -1 ? r(i3, i4) : s(i4);
    }

    private AccessibilityEvent r(int i3, int i4) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i4);
        T tH = H(i3);
        accessibilityEventObtain.getText().add(tH.B());
        accessibilityEventObtain.setContentDescription(tH.t());
        accessibilityEventObtain.setScrollable(tH.U());
        accessibilityEventObtain.setPassword(tH.T());
        accessibilityEventObtain.setEnabled(tH.N());
        accessibilityEventObtain.setChecked(tH.K());
        L(i3, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(tH.q());
        X.c(accessibilityEventObtain, this.f1032i, i3);
        accessibilityEventObtain.setPackageName(this.f1032i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i3) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        this.f1032i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private T t(int i3) {
        T tZ = T.Z();
        tZ.r0(true);
        tZ.t0(true);
        tZ.m0("android.view.View");
        Rect rect = f1024n;
        tZ.i0(rect);
        tZ.j0(rect);
        tZ.B0(this.f1032i);
        N(i3, tZ);
        if (tZ.B() == null && tZ.t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        tZ.m(this.f1028e);
        if (this.f1028e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iK = tZ.k();
        if ((iK & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iK & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        tZ.z0(this.f1032i.getContext().getPackageName());
        tZ.J0(this.f1032i, i3);
        if (this.f1034k == i3) {
            tZ.g0(true);
            tZ.a(128);
        } else {
            tZ.g0(false);
            tZ.a(64);
        }
        boolean z3 = this.f1035l == i3;
        if (z3) {
            tZ.a(2);
        } else if (tZ.O()) {
            tZ.a(1);
        }
        tZ.u0(z3);
        this.f1032i.getLocationOnScreen(this.f1030g);
        tZ.n(this.f1027d);
        if (this.f1027d.equals(rect)) {
            tZ.m(this.f1027d);
            if (tZ.f2b != -1) {
                T tZ2 = T.Z();
                for (int i4 = tZ.f2b; i4 != -1; i4 = tZ2.f2b) {
                    tZ2.C0(this.f1032i, -1);
                    tZ2.i0(f1024n);
                    N(i4, tZ2);
                    tZ2.m(this.f1028e);
                    Rect rect2 = this.f1027d;
                    Rect rect3 = this.f1028e;
                    rect2.offset(rect3.left, rect3.top);
                }
                tZ2.d0();
            }
            this.f1027d.offset(this.f1030g[0] - this.f1032i.getScrollX(), this.f1030g[1] - this.f1032i.getScrollY());
        }
        if (this.f1032i.getLocalVisibleRect(this.f1029f)) {
            this.f1029f.offset(this.f1030g[0] - this.f1032i.getScrollX(), this.f1030g[1] - this.f1032i.getScrollY());
            if (this.f1027d.intersect(this.f1029f)) {
                tZ.j0(this.f1027d);
                if (E(this.f1027d)) {
                    tZ.N0(true);
                }
            }
        }
        return tZ;
    }

    private T u() {
        T tB0 = T.b0(this.f1032i);
        Z.d0(this.f1032i, tB0);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (tB0.p() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            tB0.d(this.f1032i, ((Integer) arrayList.get(i3)).intValue());
        }
        return tB0;
    }

    private h y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h hVar = new h();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            hVar.j(((Integer) arrayList.get(i3)).intValue(), t(((Integer) arrayList.get(i3)).intValue()));
        }
        return hVar;
    }

    private void z(int i3, Rect rect) {
        H(i3).m(rect);
    }

    public final int A() {
        return this.f1035l;
    }

    protected abstract int B(float f3, float f4);

    protected abstract void C(List list);

    T H(int i3) {
        return i3 == -1 ? u() : t(i3);
    }

    public final void I(boolean z3, int i3, Rect rect) {
        int i4 = this.f1035l;
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (z3) {
            G(i3, rect);
        }
    }

    protected abstract boolean J(int i3, int i4, Bundle bundle);

    protected abstract void M(T t3);

    protected abstract void N(int i3, T t3);

    protected abstract void O(int i3, boolean z3);

    boolean P(int i3, int i4, Bundle bundle) {
        return i3 != -1 ? Q(i3, i4, bundle) : R(i4, bundle);
    }

    public final boolean T(int i3) {
        int i4;
        if ((!this.f1032i.isFocused() && !this.f1032i.requestFocus()) || (i4 = this.f1035l) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f1035l = i3;
        O(i3, true);
        U(i3, 8);
        return true;
    }

    public final boolean U(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f1031h.isEnabled() || (parent = this.f1032i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f1032i, q(i3, i4));
    }

    @Override // androidx.core.view.C0282a
    public W b(View view) {
        if (this.f1033j == null) {
            this.f1033j = new c();
        }
        return this.f1033j;
    }

    @Override // androidx.core.view.C0282a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // androidx.core.view.C0282a
    public void g(View view, T t3) {
        super.g(view, t3);
        M(t3);
    }

    public final boolean o(int i3) {
        if (this.f1035l != i3) {
            return false;
        }
        this.f1035l = Integer.MIN_VALUE;
        O(i3, false);
        U(i3, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f1031h.isEnabled() || !this.f1031h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f1036m == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i3 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z3 = false;
                    while (i3 < repeatCount && G(iF, null)) {
                        i3++;
                        z3 = true;
                    }
                    return z3;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f1034k;
    }

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i3, AccessibilityEvent accessibilityEvent) {
    }
}
