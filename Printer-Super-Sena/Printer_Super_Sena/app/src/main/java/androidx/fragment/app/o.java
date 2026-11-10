package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0358p;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static boolean f5284O = false;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    static boolean f5285P = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private p004b.c f5286A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private p004b.c f5287B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private boolean f5289D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private boolean f5290E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private boolean f5291F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private boolean f5292G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private boolean f5293H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private ArrayList f5294I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ArrayList f5295J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private ArrayList f5296K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private ArrayList f5297L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private r f5298M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5301b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f5303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f5304e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.activity.r f5306g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f5311l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private androidx.fragment.app.l f5317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AbstractC0340h f5318s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AbstractComponentCallbacksC0337e f5319t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    AbstractComponentCallbacksC0337e f5320u;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private p004b.c f5325z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f5300a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f5302c = new v();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.m f5305f = new androidx.fragment.app.m(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.activity.q f5307h = new c(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f5308i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f5309j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f5310k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map f5312m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final x.g f5313n = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final androidx.fragment.app.n f5314o = new androidx.fragment.app.n(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList f5315p = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f5316q = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.k f5321v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.k f5322w = new e();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private I f5323x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private I f5324y = new f();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    ArrayDeque f5288C = new ArrayDeque();

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private Runnable f5299N = new g();

    class a implements p004b.b {
        a() {
        }

        @Override // p004b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(p004b.a aVar) {
            m mVar = (m) o.this.f5288C.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = mVar.f5340a;
            int i3 = mVar.f5341b;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eI = o.this.f5302c.i(str);
            if (abstractComponentCallbacksC0337eI != null) {
                abstractComponentCallbacksC0337eI.k0(i3, aVar.d(), aVar.c());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    class b implements p004b.b {
        b() {
        }

        @Override // p004b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
            }
            m mVar = (m) o.this.f5288C.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = mVar.f5340a;
            int i4 = mVar.f5341b;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eI = o.this.f5302c.i(str);
            if (abstractComponentCallbacksC0337eI != null) {
                abstractComponentCallbacksC0337eI.J0(i4, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class c extends androidx.activity.q {
        c(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.q
        public void d() {
            o.this.y0();
        }
    }

    class d implements x.g {
        d() {
        }

        @Override // androidx.fragment.app.x.g
        public void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
            if (hVar.b()) {
                return;
            }
            o.this.Z0(abstractComponentCallbacksC0337e, hVar);
        }

        @Override // androidx.fragment.app.x.g
        public void b(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
            o.this.d(abstractComponentCallbacksC0337e, hVar);
        }
    }

    class e extends androidx.fragment.app.k {
        e() {
        }

        @Override // androidx.fragment.app.k
        public AbstractComponentCallbacksC0337e a(ClassLoader classLoader, String str) {
            return o.this.q0().b(o.this.q0().f(), str, null);
        }
    }

    class f implements I {
        f() {
        }

        @Override // androidx.fragment.app.I
        public H a(ViewGroup viewGroup) {
            return new C0335c(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.X(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5335c;

        h(ViewGroup viewGroup, View view, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            this.f5333a = viewGroup;
            this.f5334b = view;
            this.f5335c = abstractComponentCallbacksC0337e;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5333a.endViewTransition(this.f5334b);
            animator.removeListener(this);
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5335c;
            View view = abstractComponentCallbacksC0337e.f5165H;
            if (view == null || !abstractComponentCallbacksC0337e.f5209z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class i implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5337a;

        i(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            this.f5337a = abstractComponentCallbacksC0337e;
        }

        @Override // androidx.fragment.app.s
        public void a(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
            this.f5337a.n0(abstractComponentCallbacksC0337e);
        }
    }

    class j implements p004b.b {
        j() {
        }

        @Override // p004b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(p004b.a aVar) {
            m mVar = (m) o.this.f5288C.pollFirst();
            if (mVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = mVar.f5340a;
            int i3 = mVar.f5341b;
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eI = o.this.f5302c.i(str);
            if (abstractComponentCallbacksC0337eI != null) {
                abstractComponentCallbacksC0337eI.k0(i3, aVar.d(), aVar.c());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    static class k extends p008c.a {
        k() {
        }

        @Override // p008c.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, p004b.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentC = fVar.c();
            if (intentC != null && (bundleExtra = intentC.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentC.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentC.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new b.f.a(fVar.f()).b(null).c(fVar.e(), fVar.d()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (o.C0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // p008c.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public p004b.a c(int i3, Intent intent) {
            return new p004b.a(i3, intent);
        }
    }

    public static abstract class l {
        public void a(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        }

        public void b(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Context context) {
        }

        public void c(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        }

        public void d(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void e(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void f(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void g(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Context context) {
        }

        public void h(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        }

        public void i(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void j(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Bundle bundle) {
        }

        public void k(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void l(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }

        public void m(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, View view, Bundle bundle) {
        }

        public void n(o oVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        }
    }

    interface n {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: renamed from: androidx.fragment.app.o$o, reason: collision with other inner class name */
    private class C0073o implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f5343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f5344c;

        C0073o(String str, int i3, int i4) {
            this.f5342a = str;
            this.f5343b = i3;
            this.f5344c = i4;
        }

        @Override // androidx.fragment.app.o.n
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = o.this.f5320u;
            if (abstractComponentCallbacksC0337e == null || this.f5343b >= 0 || this.f5342a != null || !abstractComponentCallbacksC0337e.s().T0()) {
                return o.this.V0(arrayList, arrayList2, this.f5342a, this.f5343b, this.f5344c);
            }
            return false;
        }
    }

    static class p implements AbstractComponentCallbacksC0337e.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f5346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C0333a f5347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5348c;

        p(C0333a c0333a, boolean z3) {
            this.f5346a = z3;
            this.f5347b = c0333a;
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e.l
        public void a() {
            int i3 = this.f5348c - 1;
            this.f5348c = i3;
            if (i3 != 0) {
                return;
            }
            this.f5347b.f5076t.h1();
        }

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0337e.l
        public void b() {
            this.f5348c++;
        }

        void c() {
            C0333a c0333a = this.f5347b;
            c0333a.f5076t.q(c0333a, this.f5346a, false, false);
        }

        void d() {
            boolean z3 = this.f5348c > 0;
            for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5347b.f5076t.p0()) {
                abstractComponentCallbacksC0337e.H1(null);
                if (z3 && abstractComponentCallbacksC0337e.e0()) {
                    abstractComponentCallbacksC0337e.P1();
                }
            }
            C0333a c0333a = this.f5347b;
            c0333a.f5076t.q(c0333a, this.f5346a, !z3, true);
        }

        public boolean e() {
            return this.f5348c == 0;
        }
    }

    static boolean C0(int i3) {
        return f5284O || Log.isLoggable("FragmentManager", i3);
    }

    private boolean D0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        return (abstractComponentCallbacksC0337e.f5161D && abstractComponentCallbacksC0337e.f5162E) || abstractComponentCallbacksC0337e.f5204u.l();
    }

    private void I(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e == null || !abstractComponentCallbacksC0337e.equals(c0(abstractComponentCallbacksC0337e.f5189f))) {
            return;
        }
        abstractComponentCallbacksC0337e.i1();
    }

    private void K0(p046n.b bVar) {
        int size = bVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) bVar.q(i3);
            if (!abstractComponentCallbacksC0337e.f5195l) {
                View viewT1 = abstractComponentCallbacksC0337e.t1();
                abstractComponentCallbacksC0337e.f5172O = viewT1.getAlpha();
                viewT1.setAlpha(0.0f);
            }
        }
    }

    private void P(int i3) {
        try {
            this.f5301b = true;
            this.f5302c.d(i3);
            M0(i3, false);
            if (f5285P) {
                Iterator it = o().iterator();
                while (it.hasNext()) {
                    ((H) it.next()).j();
                }
            }
            this.f5301b = false;
            X(true);
        } catch (Throwable th) {
            this.f5301b = false;
            throw th;
        }
    }

    private void S() {
        if (this.f5293H) {
            this.f5293H = false;
            n1();
        }
    }

    private void U() {
        if (f5285P) {
            Iterator it = o().iterator();
            while (it.hasNext()) {
                ((H) it.next()).j();
            }
        } else {
            if (this.f5312m.isEmpty()) {
                return;
            }
            for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5312m.keySet()) {
                k(abstractComponentCallbacksC0337e);
                N0(abstractComponentCallbacksC0337e);
            }
        }
    }

    private boolean U0(String str, int i3, int i4) {
        X(false);
        W(true);
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5320u;
        if (abstractComponentCallbacksC0337e != null && i3 < 0 && str == null && abstractComponentCallbacksC0337e.s().T0()) {
            return true;
        }
        boolean zV0 = V0(this.f5294I, this.f5295J, str, i3, i4);
        if (zV0) {
            this.f5301b = true;
            try {
                b1(this.f5294I, this.f5295J);
                n();
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        q1();
        S();
        this.f5302c.b();
        return zV0;
    }

    private void W(boolean z3) {
        if (this.f5301b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f5317r == null) {
            if (!this.f5292G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f5317r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z3) {
            m();
        }
        if (this.f5294I == null) {
            this.f5294I = new ArrayList();
            this.f5295J = new ArrayList();
        }
        this.f5301b = true;
        try {
            b0(null, null);
        } finally {
            this.f5301b = false;
        }
    }

    private int W0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4, p046n.b bVar) {
        int i5 = i4;
        for (int i6 = i4 - 1; i6 >= i3; i6--) {
            C0333a c0333a = (C0333a) arrayList.get(i6);
            boolean zBooleanValue = ((Boolean) arrayList2.get(i6)).booleanValue();
            if (c0333a.C() && !c0333a.A(arrayList, i6 + 1, i4)) {
                if (this.f5297L == null) {
                    this.f5297L = new ArrayList();
                }
                p pVar = new p(c0333a, zBooleanValue);
                this.f5297L.add(pVar);
                c0333a.E(pVar);
                if (zBooleanValue) {
                    c0333a.v();
                } else {
                    c0333a.w(false);
                }
                i5--;
                if (i6 != i5) {
                    arrayList.remove(i6);
                    arrayList.add(i5, c0333a);
                }
                b(bVar);
            }
        }
        return i5;
    }

    private static void Z(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        while (i3 < i4) {
            C0333a c0333a = (C0333a) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                c0333a.r(-1);
                c0333a.w(i3 == i4 + (-1));
            } else {
                c0333a.r(1);
                c0333a.v();
            }
            i3++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    private void a0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        ?? r3;
        int i5;
        int i6;
        int iW0;
        boolean z3;
        int i7;
        ArrayList arrayList3 = arrayList2;
        boolean z4 = ((C0333a) arrayList.get(i3)).f5406r;
        ArrayList arrayList4 = this.f5296K;
        if (arrayList4 == null) {
            this.f5296K = new ArrayList();
        } else {
            arrayList4.clear();
        }
        this.f5296K.addAll(this.f5302c.n());
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eU0 = u0();
        boolean z5 = false;
        for (int i8 = i3; i8 < i4; i8++) {
            C0333a c0333a = (C0333a) arrayList.get(i8);
            abstractComponentCallbacksC0337eU0 = !((Boolean) arrayList3.get(i8)).booleanValue() ? c0333a.x(this.f5296K, abstractComponentCallbacksC0337eU0) : c0333a.F(this.f5296K, abstractComponentCallbacksC0337eU0);
            z5 = z5 || c0333a.f5397i;
        }
        this.f5296K.clear();
        if (z4 || this.f5316q < 1) {
            r3 = 1;
        } else if (f5285P) {
            for (int i9 = i3; i9 < i4; i9++) {
                Iterator it = ((C0333a) arrayList.get(i9)).f5391c.iterator();
                while (it.hasNext()) {
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = ((w.a) it.next()).f5409b;
                    if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.f5202s != null) {
                        this.f5302c.p(s(abstractComponentCallbacksC0337e));
                    }
                }
            }
            r3 = 1;
        } else {
            r3 = 1;
            x.B(this.f5317r.f(), this.f5318s, arrayList, arrayList2, i3, i4, false, this.f5313n);
        }
        Z(arrayList, arrayList2, i3, i4);
        if (f5285P) {
            boolean zBooleanValue = ((Boolean) arrayList3.get(i4 - 1)).booleanValue();
            for (int i10 = i3; i10 < i4; i10++) {
                C0333a c0333a2 = (C0333a) arrayList.get(i10);
                if (zBooleanValue) {
                    int size = c0333a2.f5391c.size() - r3;
                    while (i7 >= 0) {
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = ((w.a) c0333a2.f5391c.get(i7)).f5409b;
                        if (abstractComponentCallbacksC0337e2 != null) {
                            i7 = size;
                            s(abstractComponentCallbacksC0337e2).m();
                        } else {
                            i7 = size;
                        }
                        i7--;
                    }
                    i7 = size;
                } else {
                    Iterator it2 = c0333a2.f5391c.iterator();
                    while (it2.hasNext()) {
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e3 = ((w.a) it2.next()).f5409b;
                        if (abstractComponentCallbacksC0337e3 != null) {
                            s(abstractComponentCallbacksC0337e3).m();
                        }
                    }
                }
            }
            M0(this.f5316q, r3);
            for (H h3 : p(arrayList, i3, i4)) {
                h3.r(zBooleanValue);
                h3.p();
                h3.g();
            }
            i5 = i4;
            arrayList3 = arrayList3;
        } else {
            if (z4) {
                p046n.b bVar = new p046n.b();
                b(bVar);
                i6 = 1;
                i5 = i4;
                iW0 = W0(arrayList, arrayList2, i3, i4, bVar);
                K0(bVar);
            } else {
                i5 = i4;
                i6 = 1;
                iW0 = i5;
            }
            if (iW0 == i3 || !z4) {
                arrayList3 = arrayList3;
                i5 = i5;
            } else {
                if (this.f5316q >= i6) {
                    z3 = true;
                    x.B(this.f5317r.f(), this.f5318s, arrayList, arrayList2, i3, iW0, true, this.f5313n);
                } else {
                    z3 = true;
                }
                M0(this.f5316q, z3);
            }
        }
        for (int i11 = i3; i11 < i5; i11++) {
            C0333a c0333a3 = (C0333a) arrayList.get(i11);
            if (((Boolean) arrayList3.get(i11)).booleanValue() && c0333a3.f5078v >= 0) {
                c0333a3.f5078v = -1;
            }
            c0333a3.D();
        }
        if (z5) {
            c1();
        }
    }

    private void b(p046n.b bVar) {
        int i3 = this.f5316q;
        if (i3 < 1) {
            return;
        }
        int iMin = Math.min(i3, 5);
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e.f5184a < iMin) {
                O0(abstractComponentCallbacksC0337e, iMin);
                if (abstractComponentCallbacksC0337e.f5165H != null && !abstractComponentCallbacksC0337e.f5209z && abstractComponentCallbacksC0337e.f5170M) {
                    bVar.add(abstractComponentCallbacksC0337e);
                }
            }
        }
    }

    private void b0(ArrayList arrayList, ArrayList arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList arrayList3 = this.f5297L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i3 = 0;
        while (i3 < size) {
            p pVar = (p) this.f5297L.get(i3);
            if (arrayList != null && !pVar.f5346a && (iIndexOf2 = arrayList.indexOf(pVar.f5347b)) != -1 && arrayList2 != null && ((Boolean) arrayList2.get(iIndexOf2)).booleanValue()) {
                this.f5297L.remove(i3);
                i3--;
                size--;
                pVar.c();
            } else if (pVar.e() || (arrayList != null && pVar.f5347b.A(arrayList, 0, arrayList.size()))) {
                this.f5297L.remove(i3);
                i3--;
                size--;
                if (arrayList == null || pVar.f5346a || (iIndexOf = arrayList.indexOf(pVar.f5347b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(iIndexOf)).booleanValue()) {
                    pVar.d();
                } else {
                    pVar.c();
                }
            }
            i3++;
        }
    }

    private void b1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        b0(arrayList, arrayList2);
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!((C0333a) arrayList.get(i3)).f5406r) {
                if (i4 != i3) {
                    a0(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    while (i4 < size && ((Boolean) arrayList2.get(i4)).booleanValue() && !((C0333a) arrayList.get(i4)).f5406r) {
                        i4++;
                    }
                }
                a0(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            a0(arrayList, arrayList2, i4, size);
        }
    }

    private void c1() {
        ArrayList arrayList = this.f5311l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.H.a(this.f5311l.get(0));
        throw null;
    }

    static int e1(int i3) {
        if (i3 == 4097) {
            return 8194;
        }
        if (i3 != 4099) {
            return i3 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void g0() {
        if (f5285P) {
            Iterator it = o().iterator();
            while (it.hasNext()) {
                ((H) it.next()).k();
            }
        } else if (this.f5297L != null) {
            while (!this.f5297L.isEmpty()) {
                ((p) this.f5297L.remove(0)).d();
            }
        }
    }

    private boolean h0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f5300a) {
            try {
                if (this.f5300a.isEmpty()) {
                    return false;
                }
                int size = this.f5300a.size();
                boolean zA = false;
                for (int i3 = 0; i3 < size; i3++) {
                    zA |= ((n) this.f5300a.get(i3)).a(arrayList, arrayList2);
                }
                this.f5300a.clear();
                this.f5317r.g().removeCallbacks(this.f5299N);
                return zA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private r j0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        return this.f5298M.i(abstractComponentCallbacksC0337e);
    }

    private void k(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        HashSet hashSet = (HashSet) this.f5312m.get(abstractComponentCallbacksC0337e);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((androidx.core.os.h) it.next()).a();
            }
            hashSet.clear();
            t(abstractComponentCallbacksC0337e);
            this.f5312m.remove(abstractComponentCallbacksC0337e);
        }
    }

    private void l1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        ViewGroup viewGroupM0 = m0(abstractComponentCallbacksC0337e);
        if (viewGroupM0 == null || abstractComponentCallbacksC0337e.u() + abstractComponentCallbacksC0337e.x() + abstractComponentCallbacksC0337e.I() + abstractComponentCallbacksC0337e.J() <= 0) {
            return;
        }
        int i3 = O.b.f1381c;
        if (viewGroupM0.getTag(i3) == null) {
            viewGroupM0.setTag(i3, abstractComponentCallbacksC0337e);
        }
        ((AbstractComponentCallbacksC0337e) viewGroupM0.getTag(i3)).I1(abstractComponentCallbacksC0337e.H());
    }

    private void m() {
        if (H0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup m0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC0337e.f5207x > 0 && this.f5318s.d()) {
            View viewC = this.f5318s.c(abstractComponentCallbacksC0337e.f5207x);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void n() {
        this.f5301b = false;
        this.f5295J.clear();
        this.f5294I.clear();
    }

    private void n1() {
        Iterator it = this.f5302c.k().iterator();
        while (it.hasNext()) {
            R0((u) it.next());
        }
    }

    private Set o() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f5302c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).k().f5164G;
            if (viewGroup != null) {
                hashSet.add(H.o(viewGroup, v0()));
            }
        }
        return hashSet;
    }

    private void o1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
        androidx.fragment.app.l lVar = this.f5317r;
        if (lVar != null) {
            try {
                lVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
                throw runtimeException;
            }
        }
        try {
            T("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e4) {
            Log.e("FragmentManager", "Failed dumping state", e4);
            throw runtimeException;
        }
    }

    private Set p(ArrayList arrayList, int i3, int i4) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i3 < i4) {
            Iterator it = ((C0333a) arrayList.get(i3)).f5391c.iterator();
            while (it.hasNext()) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = ((w.a) it.next()).f5409b;
                if (abstractComponentCallbacksC0337e != null && (viewGroup = abstractComponentCallbacksC0337e.f5164G) != null) {
                    hashSet.add(H.n(viewGroup, this));
                }
            }
            i3++;
        }
        return hashSet;
    }

    private void q1() {
        synchronized (this.f5300a) {
            try {
                if (this.f5300a.isEmpty()) {
                    this.f5307h.j(i0() > 0 && F0(this.f5319t));
                } else {
                    this.f5307h.j(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void r(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        Animator animator;
        if (abstractComponentCallbacksC0337e.f5165H != null) {
            AbstractC0339g.d dVarC = AbstractC0339g.c(this.f5317r.f(), abstractComponentCallbacksC0337e, !abstractComponentCallbacksC0337e.f5209z, abstractComponentCallbacksC0337e.H());
            if (dVarC == null || (animator = dVarC.f5264b) == null) {
                if (dVarC != null) {
                    abstractComponentCallbacksC0337e.f5165H.startAnimation(dVarC.f5263a);
                    dVarC.f5263a.start();
                }
                abstractComponentCallbacksC0337e.f5165H.setVisibility((!abstractComponentCallbacksC0337e.f5209z || abstractComponentCallbacksC0337e.b0()) ? 0 : 8);
                if (abstractComponentCallbacksC0337e.b0()) {
                    abstractComponentCallbacksC0337e.D1(false);
                }
            } else {
                animator.setTarget(abstractComponentCallbacksC0337e.f5165H);
                if (!abstractComponentCallbacksC0337e.f5209z) {
                    abstractComponentCallbacksC0337e.f5165H.setVisibility(0);
                } else if (abstractComponentCallbacksC0337e.b0()) {
                    abstractComponentCallbacksC0337e.D1(false);
                } else {
                    ViewGroup viewGroup = abstractComponentCallbacksC0337e.f5164G;
                    View view = abstractComponentCallbacksC0337e.f5165H;
                    viewGroup.startViewTransition(view);
                    dVarC.f5264b.addListener(new h(viewGroup, view, abstractComponentCallbacksC0337e));
                }
                dVarC.f5264b.start();
            }
        }
        A0(abstractComponentCallbacksC0337e);
        abstractComponentCallbacksC0337e.f5171N = false;
        abstractComponentCallbacksC0337e.z0(abstractComponentCallbacksC0337e.f5209z);
    }

    private void t(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        abstractComponentCallbacksC0337e.Y0();
        this.f5314o.n(abstractComponentCallbacksC0337e, false);
        abstractComponentCallbacksC0337e.f5164G = null;
        abstractComponentCallbacksC0337e.f5165H = null;
        abstractComponentCallbacksC0337e.f5177T = null;
        abstractComponentCallbacksC0337e.f5178U.m(null);
        abstractComponentCallbacksC0337e.f5198o = false;
    }

    static AbstractComponentCallbacksC0337e w0(View view) {
        Object tag = view.getTag(O.b.f1379a);
        if (tag instanceof AbstractComponentCallbacksC0337e) {
            return (AbstractComponentCallbacksC0337e) tag;
        }
        return null;
    }

    boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.f5316q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null && E0(abstractComponentCallbacksC0337e) && abstractComponentCallbacksC0337e.V0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(abstractComponentCallbacksC0337e);
                z3 = true;
            }
        }
        if (this.f5304e != null) {
            for (int i3 = 0; i3 < this.f5304e.size(); i3++) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = (AbstractComponentCallbacksC0337e) this.f5304e.get(i3);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC0337e2)) {
                    abstractComponentCallbacksC0337e2.v0();
                }
            }
        }
        this.f5304e = arrayList;
        return z3;
    }

    void A0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e.f5195l && D0(abstractComponentCallbacksC0337e)) {
            this.f5289D = true;
        }
    }

    void B() {
        this.f5292G = true;
        X(true);
        U();
        P(-1);
        this.f5317r = null;
        this.f5318s = null;
        this.f5319t = null;
        if (this.f5306g != null) {
            this.f5307h.h();
            this.f5306g = null;
        }
        p004b.c cVar = this.f5325z;
        if (cVar != null) {
            cVar.c();
            this.f5286A.c();
            this.f5287B.c();
        }
    }

    public boolean B0() {
        return this.f5292G;
    }

    void C() {
        P(1);
    }

    void D() {
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.b1();
            }
        }
    }

    void E(boolean z3) {
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.c1(z3);
            }
        }
    }

    boolean E0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e == null) {
            return true;
        }
        return abstractComponentCallbacksC0337e.d0();
    }

    void F(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        Iterator it = this.f5315p.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this, abstractComponentCallbacksC0337e);
        }
    }

    boolean F0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e == null) {
            return true;
        }
        o oVar = abstractComponentCallbacksC0337e.f5202s;
        return abstractComponentCallbacksC0337e.equals(oVar.u0()) && F0(oVar.f5319t);
    }

    boolean G(MenuItem menuItem) {
        if (this.f5316q < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.d1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean G0(int i3) {
        return this.f5316q >= i3;
    }

    void H(Menu menu) {
        if (this.f5316q < 1) {
            return;
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.e1(menu);
            }
        }
    }

    public boolean H0() {
        return this.f5290E || this.f5291F;
    }

    void I0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Intent intent, int i3, Bundle bundle) {
        if (this.f5325z == null) {
            this.f5317r.l(abstractComponentCallbacksC0337e, intent, i3, bundle);
            return;
        }
        this.f5288C.addLast(new m(abstractComponentCallbacksC0337e.f5189f, i3));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f5325z.a(intent);
    }

    void J() {
        P(5);
    }

    void J0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        Intent intent2;
        if (this.f5286A == null) {
            this.f5317r.m(abstractComponentCallbacksC0337e, intentSender, i3, intent, i4, i5, i6, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (C0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + abstractComponentCallbacksC0337e);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        p004b.f fVarA = new b.f.a(intentSender).b(intent2).c(i5, i4).a();
        this.f5288C.addLast(new m(abstractComponentCallbacksC0337e.f5189f, i3));
        if (C0(2)) {
            Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0337e + "is launching an IntentSender for result ");
        }
        this.f5286A.a(fVarA);
    }

    void K(boolean z3) {
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.g1(z3);
            }
        }
    }

    boolean L(Menu menu) {
        boolean z3 = false;
        if (this.f5316q < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null && E0(abstractComponentCallbacksC0337e) && abstractComponentCallbacksC0337e.h1(menu)) {
                z3 = true;
            }
        }
        return z3;
    }

    void L0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (!this.f5302c.c(abstractComponentCallbacksC0337e.f5189f)) {
            if (C0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + abstractComponentCallbacksC0337e + " to state " + this.f5316q + "since it is not added to " + this);
                return;
            }
            return;
        }
        N0(abstractComponentCallbacksC0337e);
        View view = abstractComponentCallbacksC0337e.f5165H;
        if (view != null && abstractComponentCallbacksC0337e.f5170M && abstractComponentCallbacksC0337e.f5164G != null) {
            float f3 = abstractComponentCallbacksC0337e.f5172O;
            if (f3 > 0.0f) {
                view.setAlpha(f3);
            }
            abstractComponentCallbacksC0337e.f5172O = 0.0f;
            abstractComponentCallbacksC0337e.f5170M = false;
            AbstractC0339g.d dVarC = AbstractC0339g.c(this.f5317r.f(), abstractComponentCallbacksC0337e, true, abstractComponentCallbacksC0337e.H());
            if (dVarC != null) {
                Animation animation = dVarC.f5263a;
                if (animation != null) {
                    abstractComponentCallbacksC0337e.f5165H.startAnimation(animation);
                } else {
                    dVarC.f5264b.setTarget(abstractComponentCallbacksC0337e.f5165H);
                    dVarC.f5264b.start();
                }
            }
        }
        if (abstractComponentCallbacksC0337e.f5171N) {
            r(abstractComponentCallbacksC0337e);
        }
    }

    void M() {
        q1();
        I(this.f5320u);
    }

    void M0(int i3, boolean z3) {
        androidx.fragment.app.l lVar;
        if (this.f5317r == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z3 || i3 != this.f5316q) {
            this.f5316q = i3;
            if (f5285P) {
                this.f5302c.r();
            } else {
                Iterator it = this.f5302c.n().iterator();
                while (it.hasNext()) {
                    L0((AbstractComponentCallbacksC0337e) it.next());
                }
                for (u uVar : this.f5302c.k()) {
                    AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                    if (!abstractComponentCallbacksC0337eK.f5170M) {
                        L0(abstractComponentCallbacksC0337eK);
                    }
                    if (abstractComponentCallbacksC0337eK.f5196m && !abstractComponentCallbacksC0337eK.c0()) {
                        this.f5302c.q(uVar);
                    }
                }
            }
            n1();
            if (this.f5289D && (lVar = this.f5317r) != null && this.f5316q == 7) {
                lVar.n();
                this.f5289D = false;
            }
        }
    }

    void N() {
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        P(7);
    }

    void N0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        O0(abstractComponentCallbacksC0337e, this.f5316q);
    }

    void O() {
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        P(5);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0161  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:98:0x015e  */
    void O0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, int i3) {
        ViewGroup viewGroup;
        u uVarM = this.f5302c.m(abstractComponentCallbacksC0337e.f5189f);
        int i4 = 1;
        if (uVarM == null) {
            uVarM = new u(this.f5314o, this.f5302c, abstractComponentCallbacksC0337e);
            uVarM.u(1);
        }
        if (abstractComponentCallbacksC0337e.f5197n && abstractComponentCallbacksC0337e.f5198o && abstractComponentCallbacksC0337e.f5184a == 2) {
            i3 = Math.max(i3, 2);
        }
        int iMin = Math.min(i3, uVarM.d());
        int i5 = abstractComponentCallbacksC0337e.f5184a;
        if (i5 <= iMin) {
            if (i5 < iMin && !this.f5312m.isEmpty()) {
                k(abstractComponentCallbacksC0337e);
            }
            int i6 = abstractComponentCallbacksC0337e.f5184a;
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 4) {
                                if (i6 == 5) {
                                }
                            }
                            if (iMin > 5) {
                                uVarM.p();
                            }
                        }
                        if (iMin > 4) {
                            uVarM.v();
                        }
                        if (iMin > 5) {
                            uVarM.p();
                        }
                    }
                    if (iMin > 2) {
                        uVarM.a();
                    }
                    if (iMin > 4) {
                        uVarM.v();
                    }
                    if (iMin > 5) {
                        uVarM.p();
                    }
                }
                if (iMin > -1) {
                    uVarM.j();
                }
                if (iMin > 1) {
                    uVarM.f();
                }
                if (iMin > 2) {
                    uVarM.a();
                }
                if (iMin > 4) {
                    uVarM.v();
                }
                if (iMin > 5) {
                    uVarM.p();
                }
            } else if (iMin > -1) {
                uVarM.c();
            }
            if (iMin > 0) {
                uVarM.e();
            }
            if (iMin > -1) {
                uVarM.j();
            }
            if (iMin > 1) {
                uVarM.f();
            }
            if (iMin > 2) {
                uVarM.a();
            }
            if (iMin > 4) {
                uVarM.v();
            }
            if (iMin > 5) {
                uVarM.p();
            }
        } else if (i5 > iMin) {
            if (i5 == 0) {
                i4 = iMin;
                if (i4 < 0) {
                    uVarM.i();
                }
                iMin = i4;
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                if (i5 == 7) {
                                    if (iMin < 7) {
                                        uVarM.n();
                                    }
                                }
                            }
                            if (iMin < 5) {
                                uVarM.w();
                            }
                        }
                        if (iMin < 4) {
                            if (C0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + abstractComponentCallbacksC0337e);
                            }
                            if (abstractComponentCallbacksC0337e.f5165H != null && this.f5317r.k(abstractComponentCallbacksC0337e) && abstractComponentCallbacksC0337e.f5186c == null) {
                                uVarM.t();
                            }
                        }
                    }
                    if (iMin < 2) {
                        View view = abstractComponentCallbacksC0337e.f5165H;
                        if (view != null && (viewGroup = abstractComponentCallbacksC0337e.f5164G) != null) {
                            viewGroup.endViewTransition(view);
                            abstractComponentCallbacksC0337e.f5165H.clearAnimation();
                            if (!abstractComponentCallbacksC0337e.g0()) {
                                AbstractC0339g.d dVarC = (this.f5316q <= -1 || this.f5292G || abstractComponentCallbacksC0337e.f5165H.getVisibility() != 0 || abstractComponentCallbacksC0337e.f5172O < 0.0f) ? null : AbstractC0339g.c(this.f5317r.f(), abstractComponentCallbacksC0337e, false, abstractComponentCallbacksC0337e.H());
                                abstractComponentCallbacksC0337e.f5172O = 0.0f;
                                ViewGroup viewGroup2 = abstractComponentCallbacksC0337e.f5164G;
                                View view2 = abstractComponentCallbacksC0337e.f5165H;
                                if (dVarC != null) {
                                    AbstractC0339g.a(abstractComponentCallbacksC0337e, dVarC, this.f5313n);
                                }
                                viewGroup2.removeView(view2);
                                if (C0(2)) {
                                    Log.v("FragmentManager", "Removing view " + view2 + " for fragment " + abstractComponentCallbacksC0337e + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != abstractComponentCallbacksC0337e.f5164G) {
                                    return;
                                }
                            }
                        }
                        if (this.f5312m.get(abstractComponentCallbacksC0337e) == null) {
                            uVarM.h();
                        }
                    }
                }
                if (iMin >= 1) {
                    i4 = iMin;
                } else if (this.f5312m.get(abstractComponentCallbacksC0337e) == null) {
                    uVarM.g();
                    i4 = iMin;
                }
                if (i4 < 0) {
                    uVarM.i();
                }
                iMin = i4;
            }
        }
        if (abstractComponentCallbacksC0337e.f5184a != iMin) {
            if (C0(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + abstractComponentCallbacksC0337e + " not updated inline; expected state " + iMin + " found " + abstractComponentCallbacksC0337e.f5184a);
            }
            abstractComponentCallbacksC0337e.f5184a = iMin;
        }
    }

    void P0() {
        if (this.f5317r == null) {
            return;
        }
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.i0();
            }
        }
    }

    void Q() {
        this.f5291F = true;
        this.f5298M.o(true);
        P(4);
    }

    void Q0(FragmentContainerView fragmentContainerView) {
        View view;
        for (u uVar : this.f5302c.k()) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
            if (abstractComponentCallbacksC0337eK.f5207x == fragmentContainerView.getId() && (view = abstractComponentCallbacksC0337eK.f5165H) != null && view.getParent() == null) {
                abstractComponentCallbacksC0337eK.f5164G = fragmentContainerView;
                uVar.b();
            }
        }
    }

    void R() {
        P(2);
    }

    void R0(u uVar) {
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
        if (abstractComponentCallbacksC0337eK.f5166I) {
            if (this.f5301b) {
                this.f5293H = true;
                return;
            }
            abstractComponentCallbacksC0337eK.f5166I = false;
            if (f5285P) {
                uVar.m();
            } else {
                N0(abstractComponentCallbacksC0337eK);
            }
        }
    }

    public void S0(int i3, int i4) {
        if (i3 >= 0) {
            V(new C0073o(null, i3, i4), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    public void T(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f5302c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f5304e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = (AbstractComponentCallbacksC0337e) this.f5304e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0337e.toString());
            }
        }
        ArrayList arrayList2 = this.f5303d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                C0333a c0333a = (C0333a) this.f5303d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0333a.toString());
                c0333a.t(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f5308i.get());
        synchronized (this.f5300a) {
            try {
                int size3 = this.f5300a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size3; i5++) {
                        n nVar = (n) this.f5300a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(nVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f5317r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f5318s);
        if (this.f5319t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f5319t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f5316q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f5290E);
        printWriter.print(" mStopped=");
        printWriter.print(this.f5291F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f5292G);
        if (this.f5289D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f5289D);
        }
    }

    public boolean T0() {
        return U0(null, -1, 0);
    }

    void V(n nVar, boolean z3) {
        if (!z3) {
            if (this.f5317r == null) {
                if (!this.f5292G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            m();
        }
        synchronized (this.f5300a) {
            try {
                if (this.f5317r == null) {
                    if (!z3) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f5300a.add(nVar);
                    h1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean V0(ArrayList arrayList, ArrayList arrayList2, String str, int i3, int i4) {
        int i5;
        ArrayList arrayList3 = this.f5303d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i3 < 0 && (i4 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f5303d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i3 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C0333a c0333a = (C0333a) this.f5303d.get(size2);
                    if ((str != null && str.equals(c0333a.y())) || (i3 >= 0 && i3 == c0333a.f5078v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0333a c0333a2 = (C0333a) this.f5303d.get(size2);
                        if (str == null || !str.equals(c0333a2.y())) {
                            if (i3 < 0 || i3 != c0333a2.f5078v) {
                                break;
                            }
                        }
                    }
                }
                i5 = size2;
            } else {
                i5 = -1;
            }
            if (i5 == this.f5303d.size() - 1) {
                return false;
            }
            for (int size3 = this.f5303d.size() - 1; size3 > i5; size3--) {
                arrayList.add(this.f5303d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    boolean X(boolean z3) {
        W(z3);
        boolean z4 = false;
        while (h0(this.f5294I, this.f5295J)) {
            z4 = true;
            this.f5301b = true;
            try {
                b1(this.f5294I, this.f5295J);
                n();
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        q1();
        S();
        this.f5302c.b();
        return z4;
    }

    public void X0(Bundle bundle, String str, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e.f5202s != this) {
            o1(new IllegalStateException("Fragment " + abstractComponentCallbacksC0337e + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, abstractComponentCallbacksC0337e.f5189f);
    }

    void Y(n nVar, boolean z3) {
        if (z3 && (this.f5317r == null || this.f5292G)) {
            return;
        }
        W(z3);
        if (nVar.a(this.f5294I, this.f5295J)) {
            this.f5301b = true;
            try {
                b1(this.f5294I, this.f5295J);
                n();
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        q1();
        S();
        this.f5302c.b();
    }

    public void Y0(l lVar, boolean z3) {
        this.f5314o.o(lVar, z3);
    }

    void Z0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
        HashSet hashSet = (HashSet) this.f5312m.get(abstractComponentCallbacksC0337e);
        if (hashSet != null && hashSet.remove(hVar) && hashSet.isEmpty()) {
            this.f5312m.remove(abstractComponentCallbacksC0337e);
            if (abstractComponentCallbacksC0337e.f5184a < 5) {
                t(abstractComponentCallbacksC0337e);
                N0(abstractComponentCallbacksC0337e);
            }
        }
    }

    void a1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC0337e + " nesting=" + abstractComponentCallbacksC0337e.f5201r);
        }
        boolean zC0 = abstractComponentCallbacksC0337e.c0();
        if (abstractComponentCallbacksC0337e.f5158A && zC0) {
            return;
        }
        this.f5302c.s(abstractComponentCallbacksC0337e);
        if (D0(abstractComponentCallbacksC0337e)) {
            this.f5289D = true;
        }
        abstractComponentCallbacksC0337e.f5196m = true;
        l1(abstractComponentCallbacksC0337e);
    }

    void c(C0333a c0333a) {
        if (this.f5303d == null) {
            this.f5303d = new ArrayList();
        }
        this.f5303d.add(c0333a);
    }

    AbstractComponentCallbacksC0337e c0(String str) {
        return this.f5302c.f(str);
    }

    void d(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
        if (this.f5312m.get(abstractComponentCallbacksC0337e) == null) {
            this.f5312m.put(abstractComponentCallbacksC0337e, new HashSet());
        }
        ((HashSet) this.f5312m.get(abstractComponentCallbacksC0337e)).add(hVar);
    }

    public AbstractComponentCallbacksC0337e d0(int i3) {
        return this.f5302c.g(i3);
    }

    void d1(Parcelable parcelable) {
        u uVar;
        if (parcelable == null) {
            return;
        }
        q qVar = (q) parcelable;
        if (qVar.f5349a == null) {
            return;
        }
        this.f5302c.t();
        for (t tVar : qVar.f5349a) {
            if (tVar != null) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eH = this.f5298M.h(tVar.f5366b);
                if (abstractComponentCallbacksC0337eH != null) {
                    if (C0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC0337eH);
                    }
                    uVar = new u(this.f5314o, this.f5302c, abstractComponentCallbacksC0337eH, tVar);
                } else {
                    uVar = new u(this.f5314o, this.f5302c, this.f5317r.f().getClassLoader(), n0(), tVar);
                }
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = uVar.k();
                abstractComponentCallbacksC0337eK.f5202s = this;
                if (C0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC0337eK.f5189f + "): " + abstractComponentCallbacksC0337eK);
                }
                uVar.o(this.f5317r.f().getClassLoader());
                this.f5302c.p(uVar);
                uVar.u(this.f5316q);
            }
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5298M.k()) {
            if (!this.f5302c.c(abstractComponentCallbacksC0337e.f5189f)) {
                if (C0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC0337e + " that was not found in the set of active Fragments " + qVar.f5349a);
                }
                this.f5298M.n(abstractComponentCallbacksC0337e);
                abstractComponentCallbacksC0337e.f5202s = this;
                u uVar2 = new u(this.f5314o, this.f5302c, abstractComponentCallbacksC0337e);
                uVar2.u(1);
                uVar2.m();
                abstractComponentCallbacksC0337e.f5196m = true;
                uVar2.m();
            }
        }
        this.f5302c.u(qVar.f5350b);
        if (qVar.f5351c != null) {
            this.f5303d = new ArrayList(qVar.f5351c.length);
            int i3 = 0;
            while (true) {
                C0334b[] c0334bArr = qVar.f5351c;
                if (i3 >= c0334bArr.length) {
                    break;
                }
                C0333a c0333aC = c0334bArr[i3].c(this);
                if (C0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + c0333aC.f5078v + "): " + c0333aC);
                    PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
                    c0333aC.u("  ", printWriter, false);
                    printWriter.close();
                }
                this.f5303d.add(c0333aC);
                i3++;
            }
        } else {
            this.f5303d = null;
        }
        this.f5308i.set(qVar.f5352d);
        String str = qVar.f5353e;
        if (str != null) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eC0 = c0(str);
            this.f5320u = abstractComponentCallbacksC0337eC0;
            I(abstractComponentCallbacksC0337eC0);
        }
        ArrayList arrayList = qVar.f5354f;
        if (arrayList != null) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Bundle bundle = (Bundle) qVar.f5355g.get(i4);
                bundle.setClassLoader(this.f5317r.f().getClassLoader());
                this.f5309j.put(arrayList.get(i4), bundle);
            }
        }
        this.f5288C = new ArrayDeque(qVar.f5356h);
    }

    u e(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC0337e);
        }
        u uVarS = s(abstractComponentCallbacksC0337e);
        abstractComponentCallbacksC0337e.f5202s = this;
        this.f5302c.p(uVarS);
        if (!abstractComponentCallbacksC0337e.f5158A) {
            this.f5302c.a(abstractComponentCallbacksC0337e);
            abstractComponentCallbacksC0337e.f5196m = false;
            if (abstractComponentCallbacksC0337e.f5165H == null) {
                abstractComponentCallbacksC0337e.f5171N = false;
            }
            if (D0(abstractComponentCallbacksC0337e)) {
                this.f5289D = true;
            }
        }
        return uVarS;
    }

    public AbstractComponentCallbacksC0337e e0(String str) {
        return this.f5302c.h(str);
    }

    public void f(s sVar) {
        this.f5315p.add(sVar);
    }

    AbstractComponentCallbacksC0337e f0(String str) {
        return this.f5302c.i(str);
    }

    Parcelable f1() {
        int size;
        g0();
        U();
        X(true);
        this.f5290E = true;
        this.f5298M.o(true);
        ArrayList arrayListV = this.f5302c.v();
        C0334b[] c0334bArr = null;
        if (arrayListV.isEmpty()) {
            if (C0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList arrayListW = this.f5302c.w();
        ArrayList arrayList = this.f5303d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            c0334bArr = new C0334b[size];
            for (int i3 = 0; i3 < size; i3++) {
                c0334bArr[i3] = new C0334b((C0333a) this.f5303d.get(i3));
                if (C0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f5303d.get(i3));
                }
            }
        }
        q qVar = new q();
        qVar.f5349a = arrayListV;
        qVar.f5350b = arrayListW;
        qVar.f5351c = c0334bArr;
        qVar.f5352d = this.f5308i.get();
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5320u;
        if (abstractComponentCallbacksC0337e != null) {
            qVar.f5353e = abstractComponentCallbacksC0337e.f5189f;
        }
        qVar.f5354f.addAll(this.f5309j.keySet());
        qVar.f5355g.addAll(this.f5309j.values());
        qVar.f5356h = new ArrayList(this.f5288C);
        return qVar;
    }

    int g() {
        return this.f5308i.getAndIncrement();
    }

    public AbstractComponentCallbacksC0337e.m g1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        u uVarM = this.f5302c.m(abstractComponentCallbacksC0337e.f5189f);
        if (uVarM == null || !uVarM.k().equals(abstractComponentCallbacksC0337e)) {
            o1(new IllegalStateException("Fragment " + abstractComponentCallbacksC0337e + " is not currently in the FragmentManager"));
        }
        return uVarM.r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void h(androidx.fragment.app.l lVar, AbstractC0340h abstractC0340h, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        String str;
        InterfaceC0358p interfaceC0358p;
        if (this.f5317r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f5317r = lVar;
        this.f5318s = abstractC0340h;
        this.f5319t = abstractComponentCallbacksC0337e;
        if (abstractComponentCallbacksC0337e != null) {
            f(new i(abstractComponentCallbacksC0337e));
        } else if (lVar instanceof s) {
            f((s) lVar);
        }
        if (this.f5319t != null) {
            q1();
        }
        if (lVar instanceof androidx.activity.t) {
            androidx.activity.t tVar = (androidx.activity.t) lVar;
            androidx.activity.r onBackPressedDispatcher = tVar.getOnBackPressedDispatcher();
            this.f5306g = onBackPressedDispatcher;
            if (abstractComponentCallbacksC0337e != null) {
                interfaceC0358p = tVar;
                interfaceC0358p = abstractComponentCallbacksC0337e;
            }
            interfaceC0358p = tVar;
            onBackPressedDispatcher.h(interfaceC0358p, this.f5307h);
        }
        if (abstractComponentCallbacksC0337e != null) {
            this.f5298M = abstractComponentCallbacksC0337e.f5202s.j0(abstractComponentCallbacksC0337e);
        } else if (lVar instanceof U) {
            this.f5298M = r.j(((U) lVar).getViewModelStore());
        } else {
            this.f5298M = new r(false);
        }
        this.f5298M.o(H0());
        this.f5302c.x(this.f5298M);
        Object obj = this.f5317r;
        if (obj instanceof p004b.e) {
            p004b.d activityResultRegistry = ((p004b.e) obj).getActivityResultRegistry();
            if (abstractComponentCallbacksC0337e != null) {
                str = abstractComponentCallbacksC0337e.f5189f + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f5325z = activityResultRegistry.j(str2 + "StartActivityForResult", new p008c.e(), new j());
            this.f5286A = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new k(), new a());
            this.f5287B = activityResultRegistry.j(str2 + "RequestPermissions", new p008c.c(), new b());
        }
    }

    void h1() {
        synchronized (this.f5300a) {
            try {
                ArrayList arrayList = this.f5297L;
                boolean z3 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                boolean z4 = this.f5300a.size() == 1;
                if (z3 || z4) {
                    this.f5317r.g().removeCallbacks(this.f5299N);
                    this.f5317r.g().post(this.f5299N);
                    q1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void i(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC0337e);
        }
        if (abstractComponentCallbacksC0337e.f5158A) {
            abstractComponentCallbacksC0337e.f5158A = false;
            if (abstractComponentCallbacksC0337e.f5195l) {
                return;
            }
            this.f5302c.a(abstractComponentCallbacksC0337e);
            if (C0(2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC0337e);
            }
            if (D0(abstractComponentCallbacksC0337e)) {
                this.f5289D = true;
            }
        }
    }

    public int i0() {
        ArrayList arrayList = this.f5303d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void i1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        ViewGroup viewGroupM0 = m0(abstractComponentCallbacksC0337e);
        if (viewGroupM0 == null || !(viewGroupM0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupM0).setDrawDisappearingViewsLast(!z3);
    }

    public w j() {
        return new C0333a(this);
    }

    void j1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractC0354l.b bVar) {
        if (abstractComponentCallbacksC0337e.equals(c0(abstractComponentCallbacksC0337e.f5189f)) && (abstractComponentCallbacksC0337e.f5203t == null || abstractComponentCallbacksC0337e.f5202s == this)) {
            abstractComponentCallbacksC0337e.f5175R = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0337e + " is not an active fragment of FragmentManager " + this);
    }

    AbstractC0340h k0() {
        return this.f5318s;
    }

    void k1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (abstractComponentCallbacksC0337e == null || (abstractComponentCallbacksC0337e.equals(c0(abstractComponentCallbacksC0337e.f5189f)) && (abstractComponentCallbacksC0337e.f5203t == null || abstractComponentCallbacksC0337e.f5202s == this))) {
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = this.f5320u;
            this.f5320u = abstractComponentCallbacksC0337e;
            I(abstractComponentCallbacksC0337e2);
            I(this.f5320u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0337e + " is not an active fragment of FragmentManager " + this);
    }

    boolean l() {
        boolean zD0 = false;
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.l()) {
            if (abstractComponentCallbacksC0337e != null) {
                zD0 = D0(abstractComponentCallbacksC0337e);
            }
            if (zD0) {
                return true;
            }
        }
        return false;
    }

    public AbstractComponentCallbacksC0337e l0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eC0 = c0(string);
        if (abstractComponentCallbacksC0337eC0 == null) {
            o1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return abstractComponentCallbacksC0337eC0;
    }

    void m1(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC0337e);
        }
        if (abstractComponentCallbacksC0337e.f5209z) {
            abstractComponentCallbacksC0337e.f5209z = false;
            abstractComponentCallbacksC0337e.f5171N = !abstractComponentCallbacksC0337e.f5171N;
        }
    }

    public androidx.fragment.app.k n0() {
        androidx.fragment.app.k kVar = this.f5321v;
        if (kVar != null) {
            return kVar;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5319t;
        return abstractComponentCallbacksC0337e != null ? abstractComponentCallbacksC0337e.f5202s.n0() : this.f5322w;
    }

    v o0() {
        return this.f5302c;
    }

    public List p0() {
        return this.f5302c.n();
    }

    public void p1(l lVar) {
        this.f5314o.p(lVar);
    }

    void q(C0333a c0333a, boolean z3, boolean z4, boolean z5) {
        if (z3) {
            c0333a.w(z5);
        } else {
            c0333a.v();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0333a);
        arrayList2.add(Boolean.valueOf(z3));
        if (z4 && this.f5316q >= 1) {
            x.B(this.f5317r.f(), this.f5318s, arrayList, arrayList2, 0, 1, true, this.f5313n);
        }
        if (z5) {
            M0(this.f5316q, true);
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.l()) {
            if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.f5165H != null && abstractComponentCallbacksC0337e.f5170M && c0333a.z(abstractComponentCallbacksC0337e.f5207x)) {
                float f3 = abstractComponentCallbacksC0337e.f5172O;
                if (f3 > 0.0f) {
                    abstractComponentCallbacksC0337e.f5165H.setAlpha(f3);
                }
                if (z5) {
                    abstractComponentCallbacksC0337e.f5172O = 0.0f;
                } else {
                    abstractComponentCallbacksC0337e.f5172O = -1.0f;
                    abstractComponentCallbacksC0337e.f5170M = false;
                }
            }
        }
    }

    androidx.fragment.app.l q0() {
        return this.f5317r;
    }

    LayoutInflater.Factory2 r0() {
        return this.f5305f;
    }

    u s(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        u uVarM = this.f5302c.m(abstractComponentCallbacksC0337e.f5189f);
        if (uVarM != null) {
            return uVarM;
        }
        u uVar = new u(this.f5314o, this.f5302c, abstractComponentCallbacksC0337e);
        uVar.o(this.f5317r.f().getClassLoader());
        uVar.u(this.f5316q);
        return uVar;
    }

    androidx.fragment.app.n s0() {
        return this.f5314o;
    }

    AbstractComponentCallbacksC0337e t0() {
        return this.f5319t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5319t;
        if (abstractComponentCallbacksC0337e != null) {
            sb.append(abstractComponentCallbacksC0337e.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f5319t)));
            sb.append("}");
        } else {
            androidx.fragment.app.l lVar = this.f5317r;
            if (lVar != null) {
                sb.append(lVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f5317r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    void u(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC0337e);
        }
        if (abstractComponentCallbacksC0337e.f5158A) {
            return;
        }
        abstractComponentCallbacksC0337e.f5158A = true;
        if (abstractComponentCallbacksC0337e.f5195l) {
            if (C0(2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC0337e);
            }
            this.f5302c.s(abstractComponentCallbacksC0337e);
            if (D0(abstractComponentCallbacksC0337e)) {
                this.f5289D = true;
            }
            l1(abstractComponentCallbacksC0337e);
        }
    }

    public AbstractComponentCallbacksC0337e u0() {
        return this.f5320u;
    }

    void v() {
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        P(4);
    }

    I v0() {
        I i3 = this.f5323x;
        if (i3 != null) {
            return i3;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = this.f5319t;
        return abstractComponentCallbacksC0337e != null ? abstractComponentCallbacksC0337e.f5202s.v0() : this.f5324y;
    }

    void w() {
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        P(0);
    }

    void x(Configuration configuration) {
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null) {
                abstractComponentCallbacksC0337e.S0(configuration);
            }
        }
    }

    T x0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        return this.f5298M.l(abstractComponentCallbacksC0337e);
    }

    boolean y(MenuItem menuItem) {
        if (this.f5316q < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e : this.f5302c.n()) {
            if (abstractComponentCallbacksC0337e != null && abstractComponentCallbacksC0337e.T0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void y0() {
        X(true);
        if (this.f5307h.g()) {
            T0();
        } else {
            this.f5306g.k();
        }
    }

    void z() {
        this.f5290E = false;
        this.f5291F = false;
        this.f5298M.o(false);
        P(1);
    }

    void z0(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        if (C0(2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC0337e);
        }
        if (abstractComponentCallbacksC0337e.f5209z) {
            return;
        }
        abstractComponentCallbacksC0337e.f5209z = true;
        abstractComponentCallbacksC0337e.f5171N = true ^ abstractComponentCallbacksC0337e.f5171N;
        l1(abstractComponentCallbacksC0337e);
    }

    static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5341b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i3) {
                return new m[i3];
            }
        }

        m(String str, int i3) {
            this.f5340a = str;
            this.f5341b = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f5340a);
            parcel.writeInt(this.f5341b);
        }

        m(Parcel parcel) {
            this.f5340a = parcel.readString();
            this.f5341b = parcel.readInt();
        }
    }
}
