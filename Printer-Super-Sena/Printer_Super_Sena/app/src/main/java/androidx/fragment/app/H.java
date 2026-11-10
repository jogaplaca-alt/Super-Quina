package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f5047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f5048b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f5049c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f5050d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f5051e = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5052a;

        a(d dVar) {
            this.f5052a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (H.this.f5048b.contains(this.f5052a)) {
                this.f5052a.e().a(this.f5052a.f().f5165H);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5054a;

        b(d dVar) {
            this.f5054a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            H.this.f5048b.remove(this.f5054a);
            H.this.f5049c.remove(this.f5054a);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5057b;

        static {
            int[] iArr = new int[e.b.values().length];
            f5057b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5057b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5057b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f5056a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5056a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5056a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5056a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final u f5058h;

        d(e.c cVar, e.b bVar, u uVar, androidx.core.os.h hVar) {
            super(cVar, bVar, uVar.k(), hVar);
            this.f5058h = uVar;
        }

        @Override // androidx.fragment.app.H.e
        public void c() {
            super.c();
            this.f5058h.m();
        }

        @Override // androidx.fragment.app.H.e
        void l() {
            if (g() == e.b.ADDING) {
                AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eK = this.f5058h.k();
                View viewFindFocus = abstractComponentCallbacksC0337eK.f5165H.findFocus();
                if (viewFindFocus != null) {
                    abstractComponentCallbacksC0337eK.B1(viewFindFocus);
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0337eK);
                    }
                }
                View viewT1 = f().t1();
                if (viewT1.getParent() == null) {
                    this.f5058h.b();
                    viewT1.setAlpha(0.0f);
                }
                if (viewT1.getAlpha() == 0.0f && viewT1.getVisibility() == 0) {
                    viewT1.setVisibility(4);
                }
                viewT1.setAlpha(abstractComponentCallbacksC0337eK.K());
            }
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f5059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f5060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AbstractComponentCallbacksC0337e f5061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f5062d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final HashSet f5063e = new HashSet();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5064f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f5065g = false;

        class a implements androidx.core.os.h.a {
            a() {
            }

            @Override // androidx.core.os.h.a
            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i3) {
                if (i3 == 0) {
                    return VISIBLE;
                }
                if (i3 == 4) {
                    return INVISIBLE;
                }
                if (i3 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i3);
            }

            static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(View view) {
                int i3 = c.f5056a[ordinal()];
                if (i3 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (o.C0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i3 == 3) {
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                if (o.C0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
            this.f5059a = cVar;
            this.f5060b = bVar;
            this.f5061c = abstractComponentCallbacksC0337e;
            hVar.c(new a());
        }

        final void a(Runnable runnable) {
            this.f5062d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f5064f = true;
            if (this.f5063e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f5063e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.h) it.next()).a();
            }
        }

        public void c() {
            if (this.f5065g) {
                return;
            }
            if (o.C0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f5065g = true;
            Iterator it = this.f5062d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(androidx.core.os.h hVar) {
            if (this.f5063e.remove(hVar) && this.f5063e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f5059a;
        }

        public final AbstractComponentCallbacksC0337e f() {
            return this.f5061c;
        }

        b g() {
            return this.f5060b;
        }

        final boolean h() {
            return this.f5064f;
        }

        final boolean i() {
            return this.f5065g;
        }

        public final void j(androidx.core.os.h hVar) {
            l();
            this.f5063e.add(hVar);
        }

        final void k(c cVar, b bVar) {
            int i3 = c.f5057b[bVar.ordinal()];
            if (i3 == 1) {
                if (this.f5059a == c.REMOVED) {
                    if (o.C0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5061c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f5060b + " to ADDING.");
                    }
                    this.f5059a = c.VISIBLE;
                    this.f5060b = b.ADDING;
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (o.C0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5061c + " mFinalState = " + this.f5059a + " -> REMOVED. mLifecycleImpact  = " + this.f5060b + " to REMOVING.");
                }
                this.f5059a = c.REMOVED;
                this.f5060b = b.REMOVING;
                return;
            }
            if (i3 == 3 && this.f5059a != c.REMOVED) {
                if (o.C0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5061c + " mFinalState = " + this.f5059a + " -> " + cVar + ". ");
                }
                this.f5059a = cVar;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f5059a + "} {mLifecycleImpact = " + this.f5060b + "} {mFragment = " + this.f5061c + "}";
        }
    }

    H(ViewGroup viewGroup) {
        this.f5047a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, u uVar) {
        synchronized (this.f5048b) {
            try {
                androidx.core.os.h hVar = new androidx.core.os.h();
                e eVarH = h(uVar.k());
                if (eVarH != null) {
                    eVarH.k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, uVar, hVar);
                this.f5048b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        for (e eVar : this.f5048b) {
            if (eVar.f().equals(abstractComponentCallbacksC0337e) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e) {
        for (e eVar : this.f5049c) {
            if (eVar.f().equals(abstractComponentCallbacksC0337e) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static H n(ViewGroup viewGroup, o oVar) {
        return o(viewGroup, oVar.v0());
    }

    static H o(ViewGroup viewGroup, I i3) {
        int i4 = O.b.f1380b;
        Object tag = viewGroup.getTag(i4);
        if (tag instanceof H) {
            return (H) tag;
        }
        H hA = i3.a(viewGroup);
        viewGroup.setTag(i4, hA);
        return hA;
    }

    private void q() {
        for (e eVar : this.f5048b) {
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().t1().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, u uVar) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + uVar.k());
        }
        a(cVar, e.b.ADDING, uVar);
    }

    void c(u uVar) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + uVar.k());
        }
        a(e.c.GONE, e.b.NONE, uVar);
    }

    void d(u uVar) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + uVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, uVar);
    }

    void e(u uVar) {
        if (o.C0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + uVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, uVar);
    }

    abstract void f(List list, boolean z3);

    void g() {
        if (this.f5051e) {
            return;
        }
        if (!Z.T(this.f5047a)) {
            j();
            this.f5050d = false;
            return;
        }
        synchronized (this.f5048b) {
            try {
                if (!this.f5048b.isEmpty()) {
                    ArrayList<e> arrayList = new ArrayList(this.f5049c);
                    this.f5049c.clear();
                    for (e eVar : arrayList) {
                        if (o.C0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f5049c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f5048b);
                    this.f5048b.clear();
                    this.f5049c.addAll(arrayList2);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).l();
                    }
                    f(arrayList2, this.f5050d);
                    this.f5050d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        boolean zT = Z.T(this.f5047a);
        synchronized (this.f5048b) {
            try {
                q();
                Iterator it = this.f5048b.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                for (e eVar : new ArrayList(this.f5049c)) {
                    if (o.C0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zT ? "" : "Container " + this.f5047a + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(eVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    eVar.b();
                }
                for (e eVar2 : new ArrayList(this.f5048b)) {
                    if (o.C0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zT ? "" : "Container " + this.f5047a + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(eVar2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.f5051e) {
            this.f5051e = false;
            g();
        }
    }

    e.b l(u uVar) {
        e eVarH = h(uVar.k());
        e.b bVarG = eVarH != null ? eVarH.g() : null;
        e eVarI = i(uVar.k());
        return (eVarI == null || !(bVarG == null || bVarG == e.b.NONE)) ? bVarG : eVarI.g();
    }

    public ViewGroup m() {
        return this.f5047a;
    }

    void p() {
        synchronized (this.f5048b) {
            try {
                q();
                this.f5051e = false;
                for (int size = this.f5048b.size() - 1; size >= 0; size--) {
                    e eVar = (e) this.f5048b.get(size);
                    e.c cVarC = e.c.c(eVar.f().f5165H);
                    e.c cVarE = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (cVarE == cVar && cVarC != cVar) {
                        this.f5051e = eVar.f().e0();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z3) {
        this.f5050d = z3;
    }
}
