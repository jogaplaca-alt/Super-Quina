package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.Z;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.U;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f5378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v f5379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AbstractComponentCallbacksC0337e f5380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5381d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5382e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5383a;

        a(View view) {
            this.f5383a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f5383a.removeOnAttachStateChangeListener(this);
            Z.n0(this.f5383a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5385a;

        static {
            int[] iArr = new int[AbstractC0354l.b.values().length];
            f5385a = iArr;
            try {
                iArr[AbstractC0354l.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5385a[AbstractC0354l.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5385a[AbstractC0354l.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5385a[AbstractC0354l.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    u(n nVar, v vVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        this.f5378a = nVar;
        this.f5379b = vVar;
        this.f5380c = abstractComponentCallbacksC0337e;
    }

    private boolean l(View view) {
        if (view == this.f5380c.f5165H) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f5380c.f5165H) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f5380c.k1(bundle);
        this.f5378a.j(this.f5380c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f5380c.f5165H != null) {
            t();
        }
        if (this.f5380c.f5186c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f5380c.f5186c);
        }
        if (this.f5380c.f5187d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f5380c.f5187d);
        }
        if (!this.f5380c.f5167J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f5380c.f5167J);
        }
        return bundle;
    }

    void a() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        abstractComponentCallbacksC0337e.Q0(abstractComponentCallbacksC0337e.f5185b);
        n nVar = this.f5378a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        nVar.a(abstractComponentCallbacksC0337e2, abstractComponentCallbacksC0337e2.f5185b, false);
    }

    void b() {
        int iJ = this.f5379b.j(this.f5380c);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        abstractComponentCallbacksC0337e.f5164G.addView(abstractComponentCallbacksC0337e.f5165H, iJ);
    }

    void c() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = abstractComponentCallbacksC0337e.f5191h;
        u uVarM = null;
        if (abstractComponentCallbacksC0337e2 != null) {
            u uVarM2 = this.f5379b.m(abstractComponentCallbacksC0337e2.f5189f);
            if (uVarM2 == null) {
                throw new IllegalStateException("Fragment " + this.f5380c + " declared target fragment " + this.f5380c.f5191h + " that does not belong to this FragmentManager!");
            }
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
            abstractComponentCallbacksC0337e3.f5192i = abstractComponentCallbacksC0337e3.f5191h.f5189f;
            abstractComponentCallbacksC0337e3.f5191h = null;
            uVarM = uVarM2;
        } else {
            String str = abstractComponentCallbacksC0337e.f5192i;
            if (str != null && (uVarM = this.f5379b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f5380c + " declared target fragment " + this.f5380c.f5192i + " that does not belong to this FragmentManager!");
            }
        }
        if (uVarM != null && (o.f5285P || uVarM.k().f5184a < 1)) {
            uVarM.m();
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
        abstractComponentCallbacksC0337e4.f5203t = abstractComponentCallbacksC0337e4.f5202s.q0();
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
        abstractComponentCallbacksC0337e5.f5205v = abstractComponentCallbacksC0337e5.f5202s.t0();
        this.f5378a.g(this.f5380c, false);
        this.f5380c.R0();
        this.f5378a.b(this.f5380c, false);
    }

    int d() {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e;
        ViewGroup viewGroup;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        if (abstractComponentCallbacksC0337e2.f5202s == null) {
            return abstractComponentCallbacksC0337e2.f5184a;
        }
        int iMin = this.f5382e;
        int i3 = b.f5385a[abstractComponentCallbacksC0337e2.f5175R.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i3 != 3) {
                iMin = i3 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
        if (abstractComponentCallbacksC0337e3.f5197n) {
            if (abstractComponentCallbacksC0337e3.f5198o) {
                iMin = Math.max(this.f5382e, 2);
                View view = this.f5380c.f5165H;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f5382e < 4 ? Math.min(iMin, abstractComponentCallbacksC0337e3.f5184a) : Math.min(iMin, 1);
            }
        }
        if (!this.f5380c.f5195l) {
            iMin = Math.min(iMin, 1);
        }
        H.e.b bVarL = (!o.f5285P || (viewGroup = (abstractComponentCallbacksC0337e = this.f5380c).f5164G) == null) ? null : H.n(viewGroup, abstractComponentCallbacksC0337e.G()).l(this);
        if (bVarL == H.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == H.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
            if (abstractComponentCallbacksC0337e4.f5196m) {
                iMin = abstractComponentCallbacksC0337e4.c0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
        if (abstractComponentCallbacksC0337e5.f5166I && abstractComponentCallbacksC0337e5.f5184a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (o.C0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f5380c);
        }
        return iMin;
    }

    void e() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        if (abstractComponentCallbacksC0337e.f5174Q) {
            abstractComponentCallbacksC0337e.u1(abstractComponentCallbacksC0337e.f5185b);
            this.f5380c.f5184a = 1;
            return;
        }
        this.f5378a.h(abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e.f5185b, false);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        abstractComponentCallbacksC0337e2.U0(abstractComponentCallbacksC0337e2.f5185b);
        n nVar = this.f5378a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
        nVar.c(abstractComponentCallbacksC0337e3, abstractComponentCallbacksC0337e3.f5185b, false);
    }

    void f() {
        String resourceName;
        if (this.f5380c.f5197n) {
            return;
        }
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        LayoutInflater layoutInflaterA1 = abstractComponentCallbacksC0337e.a1(abstractComponentCallbacksC0337e.f5185b);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        ViewGroup viewGroup = abstractComponentCallbacksC0337e2.f5164G;
        if (viewGroup == null) {
            int i3 = abstractComponentCallbacksC0337e2.f5207x;
            if (i3 == 0) {
                viewGroup = null;
            } else {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f5380c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) abstractComponentCallbacksC0337e2.f5202s.k0().c(this.f5380c.f5207x);
                if (viewGroup == null) {
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
                    if (!abstractComponentCallbacksC0337e3.f5199p) {
                        try {
                            resourceName = abstractComponentCallbacksC0337e3.M().getResourceName(this.f5380c.f5207x);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f5380c.f5207x) + " (" + resourceName + ") for fragment " + this.f5380c);
                    }
                }
            }
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
        abstractComponentCallbacksC0337e4.f5164G = viewGroup;
        abstractComponentCallbacksC0337e4.W0(layoutInflaterA1, viewGroup, abstractComponentCallbacksC0337e4.f5185b);
        View view = this.f5380c.f5165H;
        if (view != null) {
            boolean z3 = false;
            view.setSaveFromParentEnabled(false);
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
            abstractComponentCallbacksC0337e5.f5165H.setTag(O.b.f1379a, abstractComponentCallbacksC0337e5);
            if (viewGroup != null) {
                b();
            }
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e6 = this.f5380c;
            if (abstractComponentCallbacksC0337e6.f5209z) {
                abstractComponentCallbacksC0337e6.f5165H.setVisibility(8);
            }
            if (Z.T(this.f5380c.f5165H)) {
                Z.n0(this.f5380c.f5165H);
            } else {
                View view2 = this.f5380c.f5165H;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f5380c.n1();
            n nVar = this.f5378a;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e7 = this.f5380c;
            nVar.m(abstractComponentCallbacksC0337e7, abstractComponentCallbacksC0337e7.f5165H, abstractComponentCallbacksC0337e7.f5185b, false);
            int visibility = this.f5380c.f5165H.getVisibility();
            float alpha = this.f5380c.f5165H.getAlpha();
            if (o.f5285P) {
                this.f5380c.J1(alpha);
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e8 = this.f5380c;
                if (abstractComponentCallbacksC0337e8.f5164G != null && visibility == 0) {
                    View viewFindFocus = abstractComponentCallbacksC0337e8.f5165H.findFocus();
                    if (viewFindFocus != null) {
                        this.f5380c.B1(viewFindFocus);
                        if (o.C0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f5380c);
                        }
                    }
                    this.f5380c.f5165H.setAlpha(0.0f);
                }
            } else {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e9 = this.f5380c;
                if (visibility == 0 && abstractComponentCallbacksC0337e9.f5164G != null) {
                    z3 = true;
                }
                abstractComponentCallbacksC0337e9.f5170M = z3;
            }
        }
        this.f5380c.f5184a = 2;
    }

    void g() {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eF;
        if (o.C0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        boolean zIsChangingConfigurations = true;
        boolean z3 = abstractComponentCallbacksC0337e.f5196m && !abstractComponentCallbacksC0337e.c0();
        if (!z3 && !this.f5379b.o().p(this.f5380c)) {
            String str = this.f5380c.f5192i;
            if (str != null && (abstractComponentCallbacksC0337eF = this.f5379b.f(str)) != null && abstractComponentCallbacksC0337eF.f5159B) {
                this.f5380c.f5191h = abstractComponentCallbacksC0337eF;
            }
            this.f5380c.f5184a = 0;
            return;
        }
        l lVar = this.f5380c.f5203t;
        if (lVar instanceof U) {
            zIsChangingConfigurations = this.f5379b.o().m();
        } else if (lVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) lVar.f()).isChangingConfigurations();
        }
        if (z3 || zIsChangingConfigurations) {
            this.f5379b.o().g(this.f5380c);
        }
        this.f5380c.X0();
        this.f5378a.d(this.f5380c, false);
        for (u uVar : this.f5379b.k()) {
            if (uVar != null) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                if (this.f5380c.f5189f.equals(abstractComponentCallbacksC0337eK.f5192i)) {
                    abstractComponentCallbacksC0337eK.f5191h = this.f5380c;
                    abstractComponentCallbacksC0337eK.f5192i = null;
                }
            }
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        String str2 = abstractComponentCallbacksC0337e2.f5192i;
        if (str2 != null) {
            abstractComponentCallbacksC0337e2.f5191h = this.f5379b.f(str2);
        }
        this.f5379b.q(this);
    }

    void h() {
        View view;
        if (o.C0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f5380c);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
        if (viewGroup != null && (view = abstractComponentCallbacksC0337e.f5165H) != null) {
            viewGroup.removeView(view);
        }
        this.f5380c.Y0();
        this.f5378a.n(this.f5380c, false);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        abstractComponentCallbacksC0337e2.f5164G = null;
        abstractComponentCallbacksC0337e2.f5165H = null;
        abstractComponentCallbacksC0337e2.f5177T = null;
        abstractComponentCallbacksC0337e2.f5178U.m(null);
        this.f5380c.f5198o = false;
    }

    void i() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f5380c);
        }
        this.f5380c.Z0();
        this.f5378a.e(this.f5380c, false);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        abstractComponentCallbacksC0337e.f5184a = -1;
        abstractComponentCallbacksC0337e.f5203t = null;
        abstractComponentCallbacksC0337e.f5205v = null;
        abstractComponentCallbacksC0337e.f5202s = null;
        if ((!abstractComponentCallbacksC0337e.f5196m || abstractComponentCallbacksC0337e.c0()) && !this.f5379b.o().p(this.f5380c)) {
            return;
        }
        if (o.C0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f5380c);
        }
        this.f5380c.X();
    }

    void j() {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        if (abstractComponentCallbacksC0337e.f5197n && abstractComponentCallbacksC0337e.f5198o && !abstractComponentCallbacksC0337e.f5200q) {
            if (o.C0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f5380c);
            }
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
            abstractComponentCallbacksC0337e2.W0(abstractComponentCallbacksC0337e2.a1(abstractComponentCallbacksC0337e2.f5185b), null, this.f5380c.f5185b);
            View view = this.f5380c.f5165H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
                abstractComponentCallbacksC0337e3.f5165H.setTag(O.b.f1379a, abstractComponentCallbacksC0337e3);
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
                if (abstractComponentCallbacksC0337e4.f5209z) {
                    abstractComponentCallbacksC0337e4.f5165H.setVisibility(8);
                }
                this.f5380c.n1();
                n nVar = this.f5378a;
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
                nVar.m(abstractComponentCallbacksC0337e5, abstractComponentCallbacksC0337e5.f5165H, abstractComponentCallbacksC0337e5.f5185b, false);
                this.f5380c.f5184a = 2;
            }
        }
    }

    AbstractComponentCallbacksC0337e k() {
        return this.f5380c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f5381d) {
            if (o.C0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f5381d = true;
            while (true) {
                int iD = d();
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
                int i3 = abstractComponentCallbacksC0337e.f5184a;
                if (iD == i3) {
                    if (o.f5285P && abstractComponentCallbacksC0337e.f5171N) {
                        if (abstractComponentCallbacksC0337e.f5165H != null && (viewGroup = abstractComponentCallbacksC0337e.f5164G) != null) {
                            H hN = H.n(viewGroup, abstractComponentCallbacksC0337e.G());
                            if (this.f5380c.f5209z) {
                                hN.c(this);
                            } else {
                                hN.e(this);
                            }
                        }
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
                        o oVar = abstractComponentCallbacksC0337e2.f5202s;
                        if (oVar != null) {
                            oVar.A0(abstractComponentCallbacksC0337e2);
                        }
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
                        abstractComponentCallbacksC0337e3.f5171N = false;
                        abstractComponentCallbacksC0337e3.z0(abstractComponentCallbacksC0337e3.f5209z);
                    }
                    return;
                }
                if (iD <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f5380c.f5184a = 1;
                            break;
                        case 2:
                            abstractComponentCallbacksC0337e.f5198o = false;
                            abstractComponentCallbacksC0337e.f5184a = 2;
                            break;
                        case 3:
                            if (o.C0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f5380c);
                            }
                            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
                            if (abstractComponentCallbacksC0337e4.f5165H != null && abstractComponentCallbacksC0337e4.f5186c == null) {
                                t();
                            }
                            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
                            if (abstractComponentCallbacksC0337e5.f5165H != null && (viewGroup3 = abstractComponentCallbacksC0337e5.f5164G) != null) {
                                H.n(viewGroup3, abstractComponentCallbacksC0337e5.G()).d(this);
                            }
                            this.f5380c.f5184a = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            abstractComponentCallbacksC0337e.f5184a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (abstractComponentCallbacksC0337e.f5165H != null && (viewGroup2 = abstractComponentCallbacksC0337e.f5164G) != null) {
                                H.n(viewGroup2, abstractComponentCallbacksC0337e.G()).b(H.e.c.b(this.f5380c.f5165H.getVisibility()), this);
                            }
                            this.f5380c.f5184a = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            abstractComponentCallbacksC0337e.f5184a = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.f5381d = false;
        }
    }

    void n() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f5380c);
        }
        this.f5380c.f1();
        this.f5378a.f(this.f5380c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f5380c.f5185b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        abstractComponentCallbacksC0337e.f5186c = abstractComponentCallbacksC0337e.f5185b.getSparseParcelableArray("android:view_state");
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5380c;
        abstractComponentCallbacksC0337e2.f5187d = abstractComponentCallbacksC0337e2.f5185b.getBundle("android:view_registry_state");
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = this.f5380c;
        abstractComponentCallbacksC0337e3.f5192i = abstractComponentCallbacksC0337e3.f5185b.getString("android:target_state");
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e4 = this.f5380c;
        if (abstractComponentCallbacksC0337e4.f5192i != null) {
            abstractComponentCallbacksC0337e4.f5193j = abstractComponentCallbacksC0337e4.f5185b.getInt("android:target_req_state", 0);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e5 = this.f5380c;
        Boolean bool = abstractComponentCallbacksC0337e5.f5188e;
        if (bool != null) {
            abstractComponentCallbacksC0337e5.f5167J = bool.booleanValue();
            this.f5380c.f5188e = null;
        } else {
            abstractComponentCallbacksC0337e5.f5167J = abstractComponentCallbacksC0337e5.f5185b.getBoolean("android:user_visible_hint", true);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e6 = this.f5380c;
        if (abstractComponentCallbacksC0337e6.f5167J) {
            return;
        }
        abstractComponentCallbacksC0337e6.f5166I = true;
    }

    void p() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f5380c);
        }
        View viewA = this.f5380c.A();
        if (viewA != null && l(viewA)) {
            boolean zRequestFocus = viewA.requestFocus();
            if (o.C0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(viewA);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f5380c);
                sb.append(" resulting in focused view ");
                sb.append(this.f5380c.f5165H.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f5380c.B1(null);
        this.f5380c.j1();
        this.f5378a.i(this.f5380c, false);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        abstractComponentCallbacksC0337e.f5185b = null;
        abstractComponentCallbacksC0337e.f5186c = null;
        abstractComponentCallbacksC0337e.f5187d = null;
    }

    AbstractComponentCallbacksC0337e.m r() {
        Bundle bundleQ;
        if (this.f5380c.f5184a <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new AbstractComponentCallbacksC0337e.m(bundleQ);
    }

    t s() {
        t tVar = new t(this.f5380c);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5380c;
        if (abstractComponentCallbacksC0337e.f5184a <= -1 || tVar.f5377m != null) {
            tVar.f5377m = abstractComponentCallbacksC0337e.f5185b;
        } else {
            Bundle bundleQ = q();
            tVar.f5377m = bundleQ;
            if (this.f5380c.f5192i != null) {
                if (bundleQ == null) {
                    tVar.f5377m = new Bundle();
                }
                tVar.f5377m.putString("android:target_state", this.f5380c.f5192i);
                int i3 = this.f5380c.f5193j;
                if (i3 != 0) {
                    tVar.f5377m.putInt("android:target_req_state", i3);
                }
            }
        }
        return tVar;
    }

    void t() {
        if (this.f5380c.f5165H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f5380c.f5165H.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f5380c.f5186c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f5380c.f5177T.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f5380c.f5187d = bundle;
    }

    void u(int i3) {
        this.f5382e = i3;
    }

    void v() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f5380c);
        }
        this.f5380c.l1();
        this.f5378a.k(this.f5380c, false);
    }

    void w() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f5380c);
        }
        this.f5380c.m1();
        this.f5378a.l(this.f5380c, false);
    }

    u(n nVar, v vVar, ClassLoader classLoader, k kVar, t tVar) {
        this.f5378a = nVar;
        this.f5379b = vVar;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eA = kVar.a(classLoader, tVar.f5365a);
        this.f5380c = abstractComponentCallbacksC0337eA;
        Bundle bundle = tVar.f5374j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        abstractComponentCallbacksC0337eA.A1(tVar.f5374j);
        abstractComponentCallbacksC0337eA.f5189f = tVar.f5366b;
        abstractComponentCallbacksC0337eA.f5197n = tVar.f5367c;
        abstractComponentCallbacksC0337eA.f5199p = true;
        abstractComponentCallbacksC0337eA.f5206w = tVar.f5368d;
        abstractComponentCallbacksC0337eA.f5207x = tVar.f5369e;
        abstractComponentCallbacksC0337eA.f5208y = tVar.f5370f;
        abstractComponentCallbacksC0337eA.f5159B = tVar.f5371g;
        abstractComponentCallbacksC0337eA.f5196m = tVar.f5372h;
        abstractComponentCallbacksC0337eA.f5158A = tVar.f5373i;
        abstractComponentCallbacksC0337eA.f5209z = tVar.f5375k;
        abstractComponentCallbacksC0337eA.f5175R = AbstractC0354l.b.values()[tVar.f5376l];
        Bundle bundle2 = tVar.f5377m;
        if (bundle2 != null) {
            abstractComponentCallbacksC0337eA.f5185b = bundle2;
        } else {
            abstractComponentCallbacksC0337eA.f5185b = new Bundle();
        }
        if (o.C0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + abstractComponentCallbacksC0337eA);
        }
    }

    u(n nVar, v vVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, t tVar) {
        this.f5378a = nVar;
        this.f5379b = vVar;
        this.f5380c = abstractComponentCallbacksC0337e;
        abstractComponentCallbacksC0337e.f5186c = null;
        abstractComponentCallbacksC0337e.f5187d = null;
        abstractComponentCallbacksC0337e.f5201r = 0;
        abstractComponentCallbacksC0337e.f5198o = false;
        abstractComponentCallbacksC0337e.f5195l = false;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = abstractComponentCallbacksC0337e.f5191h;
        abstractComponentCallbacksC0337e.f5192i = abstractComponentCallbacksC0337e2 != null ? abstractComponentCallbacksC0337e2.f5189f : null;
        abstractComponentCallbacksC0337e.f5191h = null;
        Bundle bundle = tVar.f5377m;
        if (bundle != null) {
            abstractComponentCallbacksC0337e.f5185b = bundle;
        } else {
            abstractComponentCallbacksC0337e.f5185b = new Bundle();
        }
    }
}
