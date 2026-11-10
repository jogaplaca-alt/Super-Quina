package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.AbstractC0291e0;
import androidx.core.view.L;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0335c extends H {

    /* JADX INFO: renamed from: androidx.fragment.app.c$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5093a;

        static {
            int[] iArr = new int[H.e.c.values().length];
            f5093a = iArr;
            try {
                iArr[H.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5093a[H.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5093a[H.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5093a[H.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ H.e f5095b;

        b(List list, H.e eVar) {
            this.f5094a = list;
            this.f5095b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5094a.contains(this.f5095b)) {
                this.f5094a.remove(this.f5095b);
                C0335c.this.s(this.f5095b);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    class C0070c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ H.e f5100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f5101e;

        C0070c(ViewGroup viewGroup, View view, boolean z3, H.e eVar, k kVar) {
            this.f5097a = viewGroup;
            this.f5098b = view;
            this.f5099c = z3;
            this.f5100d = eVar;
            this.f5101e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5097a.endViewTransition(this.f5098b);
            if (this.f5099c) {
                this.f5100d.e().a(this.f5098b);
            }
            this.f5101e.a();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$d */
    class d implements androidx.core.os.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f5103a;

        d(Animator animator) {
            this.f5103a = animator;
        }

        @Override // androidx.core.os.h.a
        public void onCancel() {
            this.f5103a.end();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$e */
    class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f5107c;

        /* JADX INFO: renamed from: androidx.fragment.app.c$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f5105a.endViewTransition(eVar.f5106b);
                e.this.f5107c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f5105a = viewGroup;
            this.f5106b = view;
            this.f5107c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5105a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$f */
    class f implements androidx.core.os.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f5112c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f5110a = view;
            this.f5111b = viewGroup;
            this.f5112c = kVar;
        }

        @Override // androidx.core.os.h.a
        public void onCancel() {
            this.f5110a.clearAnimation();
            this.f5111b.endViewTransition(this.f5110a);
            this.f5112c.a();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$g */
    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ H.e f5114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ H.e f5115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p046n.a f5117d;

        g(H.e eVar, H.e eVar2, boolean z3, p046n.a aVar) {
            this.f5114a = eVar;
            this.f5115b = eVar2;
            this.f5116c = z3;
            this.f5117d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.f(this.f5114a.f(), this.f5115b.f(), this.f5116c, this.f5117d, false);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$h */
    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ E f5119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f5121c;

        h(E e3, View view, Rect rect) {
            this.f5119a = e3;
            this.f5120b = view;
            this.f5121c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5119a.k(this.f5120b, this.f5121c);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$i */
    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5123a;

        i(ArrayList arrayList) {
            this.f5123a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.A(this.f5123a, 4);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$j */
    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f5125a;

        j(m mVar) {
            this.f5125a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5125a.a();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$k */
    private static class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AbstractC0339g.d f5129e;

        k(H.e eVar, androidx.core.os.h hVar, boolean z3) {
            super(eVar, hVar);
            this.f5128d = false;
            this.f5127c = z3;
        }

        AbstractC0339g.d e(Context context) {
            if (this.f5128d) {
                return this.f5129e;
            }
            AbstractC0339g.d dVarC = AbstractC0339g.c(context, b().f(), b().e() == H.e.c.VISIBLE, this.f5127c);
            this.f5129e = dVarC;
            this.f5128d = true;
            return dVarC;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$l */
    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final H.e f5130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.os.h f5131b;

        l(H.e eVar, androidx.core.os.h hVar) {
            this.f5130a = eVar;
            this.f5131b = hVar;
        }

        void a() {
            this.f5130a.d(this.f5131b);
        }

        H.e b() {
            return this.f5130a;
        }

        androidx.core.os.h c() {
            return this.f5131b;
        }

        boolean d() {
            H.e.c cVar;
            H.e.c cVarC = H.e.c.c(this.f5130a.f().f5165H);
            H.e.c cVarE = this.f5130a.e();
            return cVarC == cVarE || !(cVarC == (cVar = H.e.c.VISIBLE) || cVarE == cVar);
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$m */
    private static class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f5132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f5134e;

        m(H.e eVar, androidx.core.os.h hVar, boolean z3, boolean z4) {
            super(eVar, hVar);
            if (eVar.e() == H.e.c.VISIBLE) {
                this.f5132c = z3 ? eVar.f().L() : eVar.f().v();
                this.f5133d = z3 ? eVar.f().o() : eVar.f().n();
            } else {
                this.f5132c = z3 ? eVar.f().N() : eVar.f().y();
                this.f5133d = true;
            }
            if (!z4) {
                this.f5134e = null;
            } else if (z3) {
                this.f5134e = eVar.f().P();
            } else {
                this.f5134e = eVar.f().O();
            }
        }

        private E f(Object obj) {
            if (obj == null) {
                return null;
            }
            E e3 = x.f5417b;
            if (e3 != null && e3.e(obj)) {
                return e3;
            }
            E e4 = x.f5418c;
            if (e4 != null && e4.e(obj)) {
                return e4;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        E e() {
            E eF = f(this.f5132c);
            E eF2 = f(this.f5134e);
            if (eF == null || eF2 == null || eF == eF2) {
                return eF != null ? eF : eF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f5132c + " which uses a different Transition  type than its shared element transition " + this.f5134e);
        }

        public Object g() {
            return this.f5134e;
        }

        Object h() {
            return this.f5132c;
        }

        public boolean i() {
            return this.f5134e != null;
        }

        boolean j() {
            return this.f5133d;
        }
    }

    C0335c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z3, Map map) {
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                AbstractC0339g.d dVarE = kVar.e(context);
                if (dVarE == null) {
                    kVar.a();
                } else {
                    Animator animator = dVarE.f5264b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        H.e eVarB = kVar.b();
                        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eF = eVarB.f();
                        if (Boolean.TRUE.equals(map.get(eVarB))) {
                            if (o.C0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + abstractComponentCallbacksC0337eF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z5 = eVarB.e() == H.e.c.GONE;
                            if (z5) {
                                list2.remove(eVarB);
                            }
                            View view = abstractComponentCallbacksC0337eF.f5165H;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new C0070c(viewGroupM, view, z5, eVarB, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z4 = true;
                        }
                    }
                }
            }
        }
        for (k kVar2 : arrayList) {
            H.e eVarB2 = kVar2.b();
            AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337eF2 = eVarB2.f();
            if (z3) {
                if (o.C0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0337eF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z4) {
                if (o.C0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0337eF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = abstractComponentCallbacksC0337eF2.f5165H;
                Animation animation = (Animation) p082z.h.g(((AbstractC0339g.d) p082z.h.g(kVar2.e(context))).f5263a);
                if (eVarB2.e() != H.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    viewGroupM.startViewTransition(view2);
                    AbstractC0339g.e eVar = new AbstractC0339g.e(animation, viewGroupM, view2);
                    eVar.setAnimationListener(new e(viewGroupM, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().c(new f(view2, viewGroupM, kVar2));
            }
        }
    }

    private Map x(List list, List list2, boolean z3, H.e eVar, H.e eVar2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        H.e eVar3;
        H.e eVar4;
        View view2;
        Object objN;
        ArrayList arrayList3;
        H.e eVar5;
        H.e eVar6;
        View view3;
        H.e eVar7 = eVar;
        H.e eVar8 = eVar2;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        E e3 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                E e4 = mVar.e();
                if (e3 == null) {
                    e3 = e4;
                } else if (e4 != null && e3 != e4) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (e3 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view4 = new View(m().getContext());
        Rect rect = new Rect();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        p046n.a aVar = new p046n.a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view5 = null;
        boolean z4 = false;
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                arrayList3 = arrayList5;
                eVar5 = eVar7;
                eVar6 = eVar8;
                view5 = view5;
            } else {
                Object objB = e3.B(e3.g(mVar3.g()));
                ArrayList arrayListQ = eVar2.f().Q();
                ArrayList arrayListQ2 = eVar.f().Q();
                ArrayList arrayListR = eVar.f().R();
                View view6 = view5;
                int i3 = 0;
                while (i3 < arrayListR.size()) {
                    int iIndexOf = arrayListQ.indexOf(arrayListR.get(i3));
                    ArrayList arrayList6 = arrayListR;
                    if (iIndexOf != -1) {
                        arrayListQ.set(iIndexOf, arrayListQ2.get(i3));
                    }
                    i3++;
                    arrayListR = arrayList6;
                }
                ArrayList arrayListR2 = eVar2.f().R();
                if (z3 == 0) {
                    eVar.f().z();
                    eVar2.f().w();
                } else {
                    eVar.f().w();
                    eVar2.f().z();
                }
                int i4 = 0;
                for (int size = arrayListQ.size(); i4 < size; size = size) {
                    aVar.put((String) arrayListQ.get(i4), (String) arrayListR2.get(i4));
                    i4++;
                }
                p046n.a aVar2 = new p046n.a();
                u(aVar2, eVar.f().f5165H);
                aVar2.o(arrayListQ);
                aVar.o(aVar2.keySet());
                p046n.a aVar3 = new p046n.a();
                u(aVar3, eVar2.f().f5165H);
                aVar3.o(arrayListR2);
                aVar3.o(aVar.values());
                x.x(aVar, aVar3);
                v(aVar2, aVar.keySet());
                v(aVar3, aVar.values());
                if (aVar.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    arrayList3 = arrayList5;
                    eVar5 = eVar7;
                    view5 = view6;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    x.f(eVar2.f(), eVar.f(), z3, aVar2, true);
                    ArrayList arrayList7 = arrayList5;
                    L.a(m(), new g(eVar2, eVar, z3, aVar3));
                    arrayList4.addAll(aVar2.values());
                    if (arrayListQ.isEmpty()) {
                        view5 = view6;
                    } else {
                        view5 = (View) aVar2.get((String) arrayListQ.get(0));
                        e3.v(objB, view5);
                    }
                    arrayList3 = arrayList7;
                    arrayList3.addAll(aVar3.values());
                    if (!arrayListR2.isEmpty() && (view3 = (View) aVar3.get((String) arrayListR2.get(0))) != null) {
                        L.a(m(), new h(e3, view3, rect));
                        z4 = true;
                    }
                    e3.z(objB, view4, arrayList4);
                    e3.t(objB, null, null, null, null, objB, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    map.put(eVar5, bool);
                    eVar6 = eVar2;
                    map.put(eVar6, bool);
                    obj3 = objB;
                }
            }
            eVar7 = eVar5;
            arrayList4 = arrayList4;
            rect = rect;
            view4 = view4;
            eVar8 = eVar6;
            aVar = aVar;
            arrayList5 = arrayList3;
            e3 = e3;
        }
        View view7 = view5;
        p046n.a aVar4 = aVar;
        ArrayList arrayList8 = arrayList5;
        H.e eVar9 = eVar7;
        ArrayList arrayList9 = arrayList4;
        Rect rect2 = rect;
        View view8 = view4;
        E e5 = e3;
        H.e eVar10 = eVar8;
        ArrayList arrayList10 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj4 = null;
        Object objN2 = null;
        while (it4.hasNext()) {
            m mVar4 = (m) it4.next();
            if (mVar4.d()) {
                map.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object objG = e5.g(mVar4.h());
                H.e eVarB = mVar4.b();
                boolean z5 = obj3 != null && (eVarB == eVar9 || eVarB == eVar10);
                if (objG == null) {
                    if (!z5) {
                        map.put(eVarB, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList8;
                    arrayList = arrayList9;
                    view = view8;
                    objN = obj4;
                    eVar3 = eVar10;
                    view2 = view7;
                } else {
                    ArrayList arrayList11 = new ArrayList();
                    Object obj5 = obj4;
                    t(arrayList11, eVarB.f().f5165H);
                    if (z5) {
                        if (eVarB == eVar9) {
                            arrayList11.removeAll(arrayList9);
                        } else {
                            arrayList11.removeAll(arrayList8);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        e5.a(objG, view8);
                        arrayList2 = arrayList8;
                        arrayList = arrayList9;
                        view = view8;
                        eVar4 = eVarB;
                        obj2 = objN2;
                        eVar3 = eVar10;
                        obj = obj5;
                    } else {
                        e5.b(objG, arrayList11);
                        view = view8;
                        obj = obj5;
                        arrayList = arrayList9;
                        obj2 = objN2;
                        arrayList2 = arrayList8;
                        eVar3 = eVar10;
                        e5.t(objG, objG, arrayList11, null, null, null, null);
                        if (eVarB.e() == H.e.c.GONE) {
                            eVar4 = eVarB;
                            list2.remove(eVar4);
                            ArrayList arrayList12 = new ArrayList(arrayList11);
                            arrayList12.remove(eVar4.f().f5165H);
                            e5.r(objG, eVar4.f().f5165H, arrayList12);
                            L.a(m(), new i(arrayList11));
                        } else {
                            eVar4 = eVarB;
                        }
                    }
                    if (eVar4.e() == H.e.c.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z4) {
                            e5.u(objG, rect2);
                        }
                        view2 = view7;
                    } else {
                        view2 = view7;
                        e5.v(objG, view2);
                    }
                    map.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        objN2 = e5.n(obj2, objG, null);
                        objN = obj;
                    } else {
                        objN = e5.n(obj, objG, null);
                        objN2 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = objN;
                view7 = view2;
                view8 = view;
                arrayList9 = arrayList;
                arrayList8 = arrayList2;
            }
        }
        ArrayList arrayList13 = arrayList8;
        ArrayList arrayList14 = arrayList9;
        H.e eVar11 = eVar10;
        Object objM = e5.m(objN2, obj4, obj3);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            m mVar5 = (m) it5.next();
            if (!mVar5.d()) {
                Object objH = mVar5.h();
                H.e eVarB2 = mVar5.b();
                boolean z6 = obj3 != null && (eVarB2 == eVar9 || eVarB2 == eVar11);
                if (objH != null || z6) {
                    if (Z.U(m())) {
                        e5.w(mVar5.b().f(), objM, mVar5.c(), new j(mVar5));
                    } else {
                        if (o.C0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + eVarB2);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!Z.U(m())) {
            return map;
        }
        x.A(arrayList10, 4);
        ArrayList arrayListO = e5.o(arrayList13);
        e5.c(m(), objM);
        e5.y(m(), arrayList14, arrayList13, arrayListO, aVar4);
        x.A(arrayList10, 0);
        e5.A(obj3, arrayList14, arrayList13);
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    @Override // androidx.fragment.app.H
    void f(List list, boolean z3) {
        Iterator it = list.iterator();
        H.e eVar = null;
        H.e eVar2 = null;
        while (it.hasNext()) {
            H.e eVar3 = (H.e) it.next();
            H.e.c cVarC = H.e.c.c(eVar3.f().f5165H);
            int i3 = a.f5093a[eVar3.e().ordinal()];
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                if (cVarC == H.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i3 == 4 && cVarC != H.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            H.e eVar4 = (H.e) it2.next();
            androidx.core.os.h hVar = new androidx.core.os.h();
            eVar4.j(hVar);
            arrayList.add(new k(eVar4, hVar, z3));
            androidx.core.os.h hVar2 = new androidx.core.os.h();
            eVar4.j(hVar2);
            boolean z4 = false;
            if (z3) {
                if (eVar4 == eVar) {
                    z4 = true;
                }
            } else if (eVar4 == eVar2) {
                z4 = true;
            }
            arrayList2.add(new m(eVar4, hVar2, z3, z4));
            eVar4.a(new b(arrayList3, eVar4));
        }
        Map mapX = x(arrayList2, arrayList3, z3, eVar, eVar2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((H.e) it3.next());
        }
        arrayList3.clear();
    }

    void s(H.e eVar) {
        eVar.e().a(eVar.f().f5165H);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (AbstractC0291e0.b(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String strL = Z.L(view);
        if (strL != null) {
            map.put(strL, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(p046n.a aVar, Collection collection) {
        Iterator it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(Z.L((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }
}
