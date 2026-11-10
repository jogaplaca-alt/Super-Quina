package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.AbstractC0319t;
import androidx.lifecycle.AbstractC0351i;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.AbstractC0360s;
import androidx.lifecycle.C0359q;
import androidx.lifecycle.C0362u;
import androidx.lifecycle.InterfaceC0352j;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.L;
import androidx.lifecycle.P;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.V;
import androidx.lifecycle.W;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC0337e implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0358p, U, InterfaceC0352j, Y.f {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    static final Object f5157a0 = new Object();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    boolean f5158A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    boolean f5159B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    boolean f5160C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    boolean f5161D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f5163F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    ViewGroup f5164G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    View f5165H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    boolean f5166I;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    i f5168K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    boolean f5170M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    boolean f5171N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    float f5172O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    LayoutInflater f5173P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    boolean f5174Q;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    C0359q f5176S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    F f5177T;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    P.b f5179V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    Y.e f5180W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private int f5181X;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Bundle f5185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SparseArray f5186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Bundle f5187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Boolean f5188e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f5190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    AbstractComponentCallbacksC0337e f5191h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5193j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f5195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f5196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f5198o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f5199p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f5200q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f5201r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    o f5202s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    androidx.fragment.app.l f5203t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    AbstractComponentCallbacksC0337e f5205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f5206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f5207x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f5208y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f5209z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5184a = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f5189f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f5192i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f5194k = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    o f5204u = new p();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    boolean f5162E = true;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f5167J = true;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    Runnable f5169L = new a();

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    AbstractC0354l.b f5175R = AbstractC0354l.b.RESUMED;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    C0362u f5178U = new C0362u();

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private final AtomicInteger f5182Y = new AtomicInteger();

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private final ArrayList f5183Z = new ArrayList();

    /* JADX INFO: renamed from: androidx.fragment.app.e$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC0337e.this.P1();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractComponentCallbacksC0337e.this.g(false);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$c */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ H f5212a;

        c(H h3) {
            this.f5212a = h3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5212a.g();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$d */
    class d extends AbstractC0340h {
        d() {
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public View c(int i3) {
            View view = AbstractComponentCallbacksC0337e.this.f5165H;
            if (view != null) {
                return view.findViewById(i3);
            }
            throw new IllegalStateException("Fragment " + AbstractComponentCallbacksC0337e.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0340h
        public boolean d() {
            return AbstractComponentCallbacksC0337e.this.f5165H != null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    class C0072e implements InterfaceC0356n {
        C0072e() {
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            View view;
            if (aVar != AbstractC0354l.a.ON_STOP || (view = AbstractComponentCallbacksC0337e.this.f5165H) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$f */
    class f implements p037k.a {
        f() {
        }

        @Override // p037k.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p004b.d a(Void r3) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = AbstractComponentCallbacksC0337e.this;
            Object obj = abstractComponentCallbacksC0337e.f5203t;
            return obj instanceof p004b.e ? ((p004b.e) obj).getActivityResultRegistry() : abstractComponentCallbacksC0337e.r1().getActivityResultRegistry();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$g */
    class g extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p037k.a f5217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f5218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p008c.a f5219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p004b.b f5220d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(p037k.a aVar, AtomicReference atomicReference, p008c.a aVar2, p004b.b bVar) {
            super(null);
            this.f5217a = aVar;
            this.f5218b = atomicReference;
            this.f5219c = aVar2;
            this.f5220d = bVar;
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e.k
        void a() {
            String strL = AbstractComponentCallbacksC0337e.this.l();
            this.f5218b.set(((p004b.d) this.f5217a.a(null)).i(strL, AbstractComponentCallbacksC0337e.this, this.f5219c, this.f5220d));
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$h */
    class h extends p004b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f5222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p008c.a f5223b;

        h(AtomicReference atomicReference, p008c.a aVar) {
            this.f5222a = atomicReference;
            this.f5223b = aVar;
        }

        @Override // p004b.c
        public void b(Object obj, androidx.core.app.c cVar) {
            p004b.c cVar2 = (p004b.c) this.f5222a.get();
            if (cVar2 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar2.b(obj, cVar);
        }

        @Override // p004b.c
        public void c() {
            p004b.c cVar = (p004b.c) this.f5222a.getAndSet(null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$i */
    static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f5225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Animator f5226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f5227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f5231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f5232h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ArrayList f5233i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ArrayList f5234j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f5235k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f5236l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f5237m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f5238n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f5239o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f5240p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Boolean f5241q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Boolean f5242r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        float f5243s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        View f5244t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f5245u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        l f5246v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f5247w;

        i() {
            Object obj = AbstractComponentCallbacksC0337e.f5157a0;
            this.f5236l = obj;
            this.f5237m = null;
            this.f5238n = obj;
            this.f5239o = null;
            this.f5240p = obj;
            this.f5243s = 1.0f;
            this.f5244t = null;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$j */
    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$k */
    private static abstract class k {
        private k() {
        }

        abstract void a();

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$l */
    interface l {
        void a();

        void b();
    }

    public AbstractComponentCallbacksC0337e() {
        W();
    }

    private int D() {
        AbstractC0354l.b bVar = this.f5175R;
        return (bVar == AbstractC0354l.b.INITIALIZED || this.f5205v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f5205v.D());
    }

    private void W() {
        this.f5176S = new C0359q(this);
        this.f5180W = Y.e.a(this);
        this.f5179V = null;
    }

    public static AbstractComponentCallbacksC0337e Y(Context context, String str, Bundle bundle) {
        try {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) androidx.fragment.app.k.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(abstractComponentCallbacksC0337e.getClass().getClassLoader());
                abstractComponentCallbacksC0337e.A1(bundle);
            }
            return abstractComponentCallbacksC0337e;
        } catch (IllegalAccessException e3) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (InstantiationException e4) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    private i j() {
        if (this.f5168K == null) {
            this.f5168K = new i();
        }
        return this.f5168K;
    }

    private p004b.c o1(p008c.a aVar, p037k.a aVar2, p004b.b bVar) {
        if (this.f5184a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            q1(new g(aVar2, atomicReference, aVar, bVar));
            return new h(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void q1(k kVar) {
        if (this.f5184a >= 0) {
            kVar.a();
        } else {
            this.f5183Z.add(kVar);
        }
    }

    private void v1() {
        if (o.C0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f5165H != null) {
            w1(this.f5185b);
        }
        this.f5185b = null;
    }

    View A() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5244t;
    }

    public void A0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f5163F = true;
    }

    public void A1(Bundle bundle) {
        if (this.f5202s != null && h0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f5190g = bundle;
    }

    public final Object B() {
        androidx.fragment.app.l lVar = this.f5203t;
        if (lVar == null) {
            return null;
        }
        return lVar.i();
    }

    public void B0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f5163F = true;
        androidx.fragment.app.l lVar = this.f5203t;
        Activity activityE = lVar == null ? null : lVar.e();
        if (activityE != null) {
            this.f5163F = false;
            A0(activityE, attributeSet, bundle);
        }
    }

    void B1(View view) {
        j().f5244t = view;
    }

    public LayoutInflater C(Bundle bundle) {
        androidx.fragment.app.l lVar = this.f5203t;
        if (lVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterJ = lVar.j();
        AbstractC0319t.b(layoutInflaterJ, this.f5204u.r0());
        return layoutInflaterJ;
    }

    public void C0(boolean z3) {
    }

    public void C1(boolean z3) {
        if (this.f5161D != z3) {
            this.f5161D = z3;
            if (!Z() || a0()) {
                return;
            }
            this.f5203t.n();
        }
    }

    public boolean D0(MenuItem menuItem) {
        return false;
    }

    void D1(boolean z3) {
        j().f5247w = z3;
    }

    int E() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5232h;
    }

    public void E0(Menu menu) {
    }

    public void E1(m mVar) {
        Bundle bundle;
        if (this.f5202s != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (mVar == null || (bundle = mVar.f5248a) == null) {
            bundle = null;
        }
        this.f5185b = bundle;
    }

    public final AbstractComponentCallbacksC0337e F() {
        return this.f5205v;
    }

    public void F0() {
        this.f5163F = true;
    }

    public void F1(boolean z3) {
        if (this.f5162E != z3) {
            this.f5162E = z3;
            if (this.f5161D && Z() && !a0()) {
                this.f5203t.n();
            }
        }
    }

    public final o G() {
        o oVar = this.f5202s;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void G0(boolean z3) {
    }

    void G1(int i3) {
        if (this.f5168K == null && i3 == 0) {
            return;
        }
        j();
        this.f5168K.f5232h = i3;
    }

    boolean H() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return false;
        }
        return iVar.f5227c;
    }

    public void H0(Menu menu) {
    }

    void H1(l lVar) {
        j();
        i iVar = this.f5168K;
        l lVar2 = iVar.f5246v;
        if (lVar == lVar2) {
            return;
        }
        if (lVar != null && lVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (iVar.f5245u) {
            iVar.f5246v = lVar;
        }
        if (lVar != null) {
            lVar.b();
        }
    }

    int I() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5230f;
    }

    public void I0(boolean z3) {
    }

    void I1(boolean z3) {
        if (this.f5168K == null) {
            return;
        }
        j().f5227c = z3;
    }

    int J() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5231g;
    }

    public void J0(int i3, String[] strArr, int[] iArr) {
    }

    void J1(float f3) {
        j().f5243s = f3;
    }

    float K() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f5243s;
    }

    public void K0() {
        this.f5163F = true;
    }

    void K1(ArrayList arrayList, ArrayList arrayList2) {
        j();
        i iVar = this.f5168K;
        iVar.f5233i = arrayList;
        iVar.f5234j = arrayList2;
    }

    public Object L() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5238n;
        return obj == f5157a0 ? y() : obj;
    }

    public void L0(Bundle bundle) {
    }

    public void L1(Intent intent) {
        M1(intent, null);
    }

    public final Resources M() {
        return s1().getResources();
    }

    public void M0() {
        this.f5163F = true;
    }

    public void M1(Intent intent, Bundle bundle) {
        androidx.fragment.app.l lVar = this.f5203t;
        if (lVar != null) {
            lVar.l(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object N() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5236l;
        return obj == f5157a0 ? v() : obj;
    }

    public void N0() {
        this.f5163F = true;
    }

    public void N1(Intent intent, int i3, Bundle bundle) {
        if (this.f5203t != null) {
            G().I0(this, intent, i3, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object O() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5239o;
    }

    public void O0(View view, Bundle bundle) {
    }

    public void O1(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (this.f5203t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (o.C0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i3 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        G().J0(this, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public Object P() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5240p;
        return obj == f5157a0 ? O() : obj;
    }

    public void P0(Bundle bundle) {
        this.f5163F = true;
    }

    public void P1() {
        if (this.f5168K == null || !j().f5245u) {
            return;
        }
        if (this.f5203t == null) {
            j().f5245u = false;
        } else if (Looper.myLooper() != this.f5203t.g().getLooper()) {
            this.f5203t.g().postAtFrontOfQueue(new b());
        } else {
            g(true);
        }
    }

    ArrayList Q() {
        ArrayList arrayList;
        i iVar = this.f5168K;
        return (iVar == null || (arrayList = iVar.f5233i) == null) ? new ArrayList() : arrayList;
    }

    void Q0(Bundle bundle) {
        this.f5204u.P0();
        this.f5184a = 3;
        this.f5163F = false;
        j0(bundle);
        if (this.f5163F) {
            v1();
            this.f5204u.v();
        } else {
            throw new J("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    ArrayList R() {
        ArrayList arrayList;
        i iVar = this.f5168K;
        return (iVar == null || (arrayList = iVar.f5234j) == null) ? new ArrayList() : arrayList;
    }

    void R0() {
        Iterator it = this.f5183Z.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
        this.f5183Z.clear();
        this.f5204u.h(this.f5203t, h(), this);
        this.f5184a = 0;
        this.f5163F = false;
        m0(this.f5203t.f());
        if (this.f5163F) {
            this.f5202s.F(this);
            this.f5204u.w();
        } else {
            throw new J("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final String S(int i3) {
        return M().getString(i3);
    }

    void S0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f5204u.x(configuration);
    }

    public final AbstractComponentCallbacksC0337e T() {
        String str;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5191h;
        if (abstractComponentCallbacksC0337e != null) {
            return abstractComponentCallbacksC0337e;
        }
        o oVar = this.f5202s;
        if (oVar == null || (str = this.f5192i) == null) {
            return null;
        }
        return oVar.c0(str);
    }

    boolean T0(MenuItem menuItem) {
        if (this.f5209z) {
            return false;
        }
        if (o0(menuItem)) {
            return true;
        }
        return this.f5204u.y(menuItem);
    }

    public View U() {
        return this.f5165H;
    }

    void U0(Bundle bundle) {
        this.f5204u.P0();
        this.f5184a = 1;
        this.f5163F = false;
        this.f5176S.a(new C0072e());
        this.f5180W.d(bundle);
        p0(bundle);
        this.f5174Q = true;
        if (this.f5163F) {
            this.f5176S.h(AbstractC0354l.a.ON_CREATE);
            return;
        }
        throw new J("Fragment " + this + " did not call through to super.onCreate()");
    }

    public AbstractC0360s V() {
        return this.f5178U;
    }

    boolean V0(Menu menu, MenuInflater menuInflater) {
        boolean z3 = false;
        if (this.f5209z) {
            return false;
        }
        if (this.f5161D && this.f5162E) {
            s0(menu, menuInflater);
            z3 = true;
        }
        return z3 | this.f5204u.A(menu, menuInflater);
    }

    void W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5204u.P0();
        this.f5200q = true;
        this.f5177T = new F(this, getViewModelStore());
        View viewT0 = t0(layoutInflater, viewGroup, bundle);
        this.f5165H = viewT0;
        if (viewT0 == null) {
            if (this.f5177T.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f5177T = null;
        } else {
            this.f5177T.b();
            V.a(this.f5165H, this.f5177T);
            W.a(this.f5165H, this.f5177T);
            Y.g.a(this.f5165H, this.f5177T);
            this.f5178U.m(this.f5177T);
        }
    }

    void X() {
        W();
        this.f5189f = UUID.randomUUID().toString();
        this.f5195l = false;
        this.f5196m = false;
        this.f5197n = false;
        this.f5198o = false;
        this.f5199p = false;
        this.f5201r = 0;
        this.f5202s = null;
        this.f5204u = new p();
        this.f5203t = null;
        this.f5206w = 0;
        this.f5207x = 0;
        this.f5208y = null;
        this.f5209z = false;
        this.f5158A = false;
    }

    void X0() {
        this.f5204u.B();
        this.f5176S.h(AbstractC0354l.a.ON_DESTROY);
        this.f5184a = 0;
        this.f5163F = false;
        this.f5174Q = false;
        u0();
        if (this.f5163F) {
            return;
        }
        throw new J("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void Y0() {
        this.f5204u.C();
        if (this.f5165H != null && this.f5177T.getLifecycle().b().b(AbstractC0354l.b.CREATED)) {
            this.f5177T.a(AbstractC0354l.a.ON_DESTROY);
        }
        this.f5184a = 1;
        this.f5163F = false;
        w0();
        if (this.f5163F) {
            androidx.loader.app.a.b(this).c();
            this.f5200q = false;
        } else {
            throw new J("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final boolean Z() {
        return this.f5203t != null && this.f5195l;
    }

    void Z0() {
        this.f5184a = -1;
        this.f5163F = false;
        x0();
        this.f5173P = null;
        if (this.f5163F) {
            if (this.f5204u.B0()) {
                return;
            }
            this.f5204u.B();
            this.f5204u = new p();
            return;
        }
        throw new J("Fragment " + this + " did not call through to super.onDetach()");
    }

    public final boolean a0() {
        return this.f5209z;
    }

    LayoutInflater a1(Bundle bundle) {
        LayoutInflater layoutInflaterY0 = y0(bundle);
        this.f5173P = layoutInflaterY0;
        return layoutInflaterY0;
    }

    boolean b0() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return false;
        }
        return iVar.f5247w;
    }

    void b1() {
        onLowMemory();
        this.f5204u.D();
    }

    final boolean c0() {
        return this.f5201r > 0;
    }

    void c1(boolean z3) {
        C0(z3);
        this.f5204u.E(z3);
    }

    public final boolean d0() {
        o oVar;
        return this.f5162E && ((oVar = this.f5202s) == null || oVar.E0(this.f5205v));
    }

    boolean d1(MenuItem menuItem) {
        if (this.f5209z) {
            return false;
        }
        if (this.f5161D && this.f5162E && D0(menuItem)) {
            return true;
        }
        return this.f5204u.G(menuItem);
    }

    boolean e0() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return false;
        }
        return iVar.f5245u;
    }

    void e1(Menu menu) {
        if (this.f5209z) {
            return;
        }
        if (this.f5161D && this.f5162E) {
            E0(menu);
        }
        this.f5204u.H(menu);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final boolean f0() {
        return this.f5196m;
    }

    void f1() {
        this.f5204u.J();
        if (this.f5165H != null) {
            this.f5177T.a(AbstractC0354l.a.ON_PAUSE);
        }
        this.f5176S.h(AbstractC0354l.a.ON_PAUSE);
        this.f5184a = 6;
        this.f5163F = false;
        F0();
        if (this.f5163F) {
            return;
        }
        throw new J("Fragment " + this + " did not call through to super.onPause()");
    }

    void g(boolean z3) {
        ViewGroup viewGroup;
        o oVar;
        i iVar = this.f5168K;
        l lVar = null;
        if (iVar != null) {
            iVar.f5245u = false;
            l lVar2 = iVar.f5246v;
            iVar.f5246v = null;
            lVar = lVar2;
        }
        if (lVar != null) {
            lVar.a();
            return;
        }
        if (!o.f5285P || this.f5165H == null || (viewGroup = this.f5164G) == null || (oVar = this.f5202s) == null) {
            return;
        }
        H hN = H.n(viewGroup, oVar);
        hN.p();
        if (z3) {
            this.f5203t.g().post(new c(hN));
        } else {
            hN.g();
        }
    }

    final boolean g0() {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eF = F();
        return abstractComponentCallbacksC0337eF != null && (abstractComponentCallbacksC0337eF.f0() || abstractComponentCallbacksC0337eF.g0());
    }

    void g1(boolean z3) {
        G0(z3);
        this.f5204u.K(z3);
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public /* synthetic */ T.a getDefaultViewModelCreationExtras() {
        return AbstractC0351i.a(this);
    }

    @Override // androidx.lifecycle.InterfaceC0352j
    public P.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.f5202s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f5179V == null) {
            Context applicationContext = s1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && o.C0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + s1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f5179V = new L(application, this, r());
        }
        return this.f5179V;
    }

    @Override // androidx.lifecycle.InterfaceC0358p
    public AbstractC0354l getLifecycle() {
        return this.f5176S;
    }

    @Override // Y.f
    public final Y.d getSavedStateRegistry() {
        return this.f5180W.b();
    }

    @Override // androidx.lifecycle.U
    public T getViewModelStore() {
        if (this.f5202s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (D() != AbstractC0354l.b.INITIALIZED.ordinal()) {
            return this.f5202s.x0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    AbstractC0340h h() {
        return new d();
    }

    public final boolean h0() {
        o oVar = this.f5202s;
        if (oVar == null) {
            return false;
        }
        return oVar.H0();
    }

    boolean h1(Menu menu) {
        boolean z3 = false;
        if (this.f5209z) {
            return false;
        }
        if (this.f5161D && this.f5162E) {
            H0(menu);
            z3 = true;
        }
        return z3 | this.f5204u.L(menu);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f5206w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f5207x));
        printWriter.print(" mTag=");
        printWriter.println(this.f5208y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f5184a);
        printWriter.print(" mWho=");
        printWriter.print(this.f5189f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f5201r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f5195l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f5196m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f5197n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f5198o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f5209z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f5158A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f5162E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f5161D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f5159B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f5167J);
        if (this.f5202s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f5202s);
        }
        if (this.f5203t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f5203t);
        }
        if (this.f5205v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f5205v);
        }
        if (this.f5190g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f5190g);
        }
        if (this.f5185b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f5185b);
        }
        if (this.f5186c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f5186c);
        }
        if (this.f5187d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f5187d);
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eT = T();
        if (abstractComponentCallbacksC0337eT != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC0337eT);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f5193j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(H());
        if (u() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(u());
        }
        if (x() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(x());
        }
        if (I() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(I());
        }
        if (J() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(J());
        }
        if (this.f5164G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f5164G);
        }
        if (this.f5165H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f5165H);
        }
        if (p() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(p());
        }
        if (t() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f5204u + ":");
        this.f5204u.T(str + "  ", fileDescriptor, printWriter, strArr);
    }

    void i0() {
        this.f5204u.P0();
    }

    void i1() {
        boolean zF0 = this.f5202s.F0(this);
        Boolean bool = this.f5194k;
        if (bool == null || bool.booleanValue() != zF0) {
            this.f5194k = Boolean.valueOf(zF0);
            I0(zF0);
            this.f5204u.M();
        }
    }

    public void j0(Bundle bundle) {
        this.f5163F = true;
    }

    void j1() {
        this.f5204u.P0();
        this.f5204u.X(true);
        this.f5184a = 7;
        this.f5163F = false;
        K0();
        if (!this.f5163F) {
            throw new J("Fragment " + this + " did not call through to super.onResume()");
        }
        C0359q c0359q = this.f5176S;
        AbstractC0354l.a aVar = AbstractC0354l.a.ON_RESUME;
        c0359q.h(aVar);
        if (this.f5165H != null) {
            this.f5177T.a(aVar);
        }
        this.f5204u.N();
    }

    AbstractComponentCallbacksC0337e k(String str) {
        return str.equals(this.f5189f) ? this : this.f5204u.f0(str);
    }

    public void k0(int i3, int i4, Intent intent) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i3 + " resultCode: " + i4 + " data: " + intent);
        }
    }

    void k1(Bundle bundle) {
        L0(bundle);
        this.f5180W.e(bundle);
        Parcelable parcelableF1 = this.f5204u.f1();
        if (parcelableF1 != null) {
            bundle.putParcelable("android:support:fragments", parcelableF1);
        }
    }

    String l() {
        return "fragment_" + this.f5189f + "_rq#" + this.f5182Y.getAndIncrement();
    }

    public void l0(Activity activity) {
        this.f5163F = true;
    }

    void l1() {
        this.f5204u.P0();
        this.f5204u.X(true);
        this.f5184a = 5;
        this.f5163F = false;
        M0();
        if (!this.f5163F) {
            throw new J("Fragment " + this + " did not call through to super.onStart()");
        }
        C0359q c0359q = this.f5176S;
        AbstractC0354l.a aVar = AbstractC0354l.a.ON_START;
        c0359q.h(aVar);
        if (this.f5165H != null) {
            this.f5177T.a(aVar);
        }
        this.f5204u.O();
    }

    public final AbstractActivityC0338f m() {
        androidx.fragment.app.l lVar = this.f5203t;
        if (lVar == null) {
            return null;
        }
        return (AbstractActivityC0338f) lVar.e();
    }

    public void m0(Context context) {
        this.f5163F = true;
        androidx.fragment.app.l lVar = this.f5203t;
        Activity activityE = lVar == null ? null : lVar.e();
        if (activityE != null) {
            this.f5163F = false;
            l0(activityE);
        }
    }

    void m1() {
        this.f5204u.Q();
        if (this.f5165H != null) {
            this.f5177T.a(AbstractC0354l.a.ON_STOP);
        }
        this.f5176S.h(AbstractC0354l.a.ON_STOP);
        this.f5184a = 4;
        this.f5163F = false;
        N0();
        if (this.f5163F) {
            return;
        }
        throw new J("Fragment " + this + " did not call through to super.onStop()");
    }

    public boolean n() {
        Boolean bool;
        i iVar = this.f5168K;
        if (iVar == null || (bool = iVar.f5242r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void n0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
    }

    void n1() {
        O0(this.f5165H, this.f5185b);
        this.f5204u.R();
    }

    public boolean o() {
        Boolean bool;
        i iVar = this.f5168K;
        if (iVar == null || (bool = iVar.f5241q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean o0(MenuItem menuItem) {
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f5163F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        r1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f5163F = true;
    }

    View p() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5225a;
    }

    public void p0(Bundle bundle) {
        this.f5163F = true;
        u1(bundle);
        if (this.f5204u.G0(1)) {
            return;
        }
        this.f5204u.z();
    }

    public final p004b.c p1(p008c.a aVar, p004b.b bVar) {
        return o1(aVar, new f(), bVar);
    }

    Animator q() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5226b;
    }

    public Animation q0(int i3, boolean z3, int i4) {
        return null;
    }

    public final Bundle r() {
        return this.f5190g;
    }

    public Animator r0(int i3, boolean z3, int i4) {
        return null;
    }

    public final AbstractActivityC0338f r1() {
        AbstractActivityC0338f abstractActivityC0338fM = m();
        if (abstractActivityC0338fM != null) {
            return abstractActivityC0338fM;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final o s() {
        if (this.f5203t != null) {
            return this.f5204u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void s0(Menu menu, MenuInflater menuInflater) {
    }

    public final Context s1() {
        Context contextT = t();
        if (contextT != null) {
            return contextT;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void startActivityForResult(Intent intent, int i3) {
        N1(intent, i3, null);
    }

    public Context t() {
        androidx.fragment.app.l lVar = this.f5203t;
        if (lVar == null) {
            return null;
        }
        return lVar.f();
    }

    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3 = this.f5181X;
        if (i3 != 0) {
            return layoutInflater.inflate(i3, viewGroup, false);
        }
        return null;
    }

    public final View t1() {
        View viewU = U();
        if (viewU != null) {
            return viewU;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f5189f);
        if (this.f5206w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f5206w));
        }
        if (this.f5208y != null) {
            sb.append(" tag=");
            sb.append(this.f5208y);
        }
        sb.append(")");
        return sb.toString();
    }

    int u() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5228d;
    }

    public void u0() {
        this.f5163F = true;
    }

    void u1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f5204u.d1(parcelable);
        this.f5204u.z();
    }

    public Object v() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5235k;
    }

    public void v0() {
    }

    androidx.core.app.r w() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void w0() {
        this.f5163F = true;
    }

    final void w1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f5186c;
        if (sparseArray != null) {
            this.f5165H.restoreHierarchyState(sparseArray);
            this.f5186c = null;
        }
        if (this.f5165H != null) {
            this.f5177T.d(this.f5187d);
            this.f5187d = null;
        }
        this.f5163F = false;
        P0(bundle);
        if (this.f5163F) {
            if (this.f5165H != null) {
                this.f5177T.a(AbstractC0354l.a.ON_CREATE);
            }
        } else {
            throw new J("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    int x() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5229e;
    }

    public void x0() {
        this.f5163F = true;
    }

    void x1(View view) {
        j().f5225a = view;
    }

    public Object y() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        return iVar.f5237m;
    }

    public LayoutInflater y0(Bundle bundle) {
        return C(bundle);
    }

    void y1(int i3, int i4, int i5, int i6) {
        if (this.f5168K == null && i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            return;
        }
        j().f5228d = i3;
        j().f5229e = i4;
        j().f5230f = i5;
        j().f5231g = i6;
    }

    androidx.core.app.r z() {
        i iVar = this.f5168K;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void z0(boolean z3) {
    }

    void z1(Animator animator) {
        j().f5226b = animator;
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$m */
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f5248a;

        /* JADX INFO: renamed from: androidx.fragment.app.e$m$a */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i3) {
                return new m[i3];
            }
        }

        m(Bundle bundle) {
            this.f5248a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeBundle(this.f5248a);
        }

        m(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f5248a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }
}
