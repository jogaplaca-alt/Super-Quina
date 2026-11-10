package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0337e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: androidx.transition.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0379e extends androidx.fragment.app.E {

    /* JADX INFO: renamed from: androidx.transition.e$a */
    class a extends AbstractC0386l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f6615a;

        a(Rect rect) {
            this.f6615a = rect;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.e$b */
    class b implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f6618b;

        b(View view, ArrayList arrayList) {
            this.f6617a = view;
            this.f6618b = arrayList;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void c(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.a(this, abstractC0386l, z3);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void d(AbstractC0386l abstractC0386l) {
            abstractC0386l.T(this);
            abstractC0386l.a(this);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void e(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            abstractC0386l.T(this);
            this.f6617a.setVisibility(8);
            int size = this.f6618b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((View) this.f6618b.get(i3)).setVisibility(0);
            }
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void g(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.b(this, abstractC0386l, z3);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.e$c */
    class c extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f6621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f6623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f6624e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f6625f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f6620a = obj;
            this.f6621b = arrayList;
            this.f6622c = obj2;
            this.f6623d = arrayList2;
            this.f6624e = obj3;
            this.f6625f = arrayList3;
        }

        @Override // androidx.transition.t, androidx.transition.AbstractC0386l.f
        public void d(AbstractC0386l abstractC0386l) {
            Object obj = this.f6620a;
            if (obj != null) {
                C0379e.this.q(obj, this.f6621b, null);
            }
            Object obj2 = this.f6622c;
            if (obj2 != null) {
                C0379e.this.q(obj2, this.f6623d, null);
            }
            Object obj3 = this.f6624e;
            if (obj3 != null) {
                C0379e.this.q(obj3, this.f6625f, null);
            }
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            abstractC0386l.T(this);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.e$d */
    class d implements AbstractC0386l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f6627a;

        d(Runnable runnable) {
            this.f6627a = runnable;
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void a(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void b(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void c(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.a(this, abstractC0386l, z3);
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void d(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void e(AbstractC0386l abstractC0386l) {
        }

        @Override // androidx.transition.AbstractC0386l.f
        public void f(AbstractC0386l abstractC0386l) {
            this.f6627a.run();
        }

        @Override // androidx.transition.AbstractC0386l.f
        public /* synthetic */ void g(AbstractC0386l abstractC0386l, boolean z3) {
            AbstractC0387m.b(this, abstractC0386l, z3);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.e$e, reason: collision with other inner class name */
    class C0094e extends AbstractC0386l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f6629a;

        C0094e(Rect rect) {
            this.f6629a = rect;
        }
    }

    private static boolean D(AbstractC0386l abstractC0386l) {
        return (androidx.fragment.app.E.l(abstractC0386l.B()) && androidx.fragment.app.E.l(abstractC0386l.C()) && androidx.fragment.app.E.l(abstractC0386l.D())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Runnable runnable, AbstractC0386l abstractC0386l, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            abstractC0386l.g();
            runnable2.run();
        }
    }

    @Override // androidx.fragment.app.E
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        w wVar = (w) obj;
        if (wVar != null) {
            wVar.E().clear();
            wVar.E().addAll(arrayList2);
            q(wVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.E
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        w wVar = new w();
        wVar.i0((AbstractC0386l) obj);
        return wVar;
    }

    public void F(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Object obj, androidx.core.os.h hVar, final Runnable runnable, final Runnable runnable2) {
        final AbstractC0386l abstractC0386l = (AbstractC0386l) obj;
        hVar.c(new androidx.core.os.h.a() { // from class: androidx.transition.d
            @Override // androidx.core.os.h.a
            public final void onCancel() {
                C0379e.E(runnable, abstractC0386l, runnable2);
            }
        });
        abstractC0386l.a(new d(runnable2));
    }

    @Override // androidx.fragment.app.E
    public void a(Object obj, View view) {
        if (obj != null) {
            ((AbstractC0386l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.E
    public void b(Object obj, ArrayList arrayList) {
        AbstractC0386l abstractC0386l = (AbstractC0386l) obj;
        if (abstractC0386l == null) {
            return;
        }
        int i3 = 0;
        if (abstractC0386l instanceof w) {
            w wVar = (w) abstractC0386l;
            int iL0 = wVar.l0();
            while (i3 < iL0) {
                b(wVar.k0(i3), arrayList);
                i3++;
            }
            return;
        }
        if (D(abstractC0386l) || !androidx.fragment.app.E.l(abstractC0386l.E())) {
            return;
        }
        int size = arrayList.size();
        while (i3 < size) {
            abstractC0386l.b((View) arrayList.get(i3));
            i3++;
        }
    }

    @Override // androidx.fragment.app.E
    public void c(ViewGroup viewGroup, Object obj) {
        u.a(viewGroup, (AbstractC0386l) obj);
    }

    @Override // androidx.fragment.app.E
    public boolean e(Object obj) {
        return obj instanceof AbstractC0386l;
    }

    @Override // androidx.fragment.app.E
    public Object g(Object obj) {
        if (obj != null) {
            return ((AbstractC0386l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.E
    public Object m(Object obj, Object obj2, Object obj3) {
        AbstractC0386l abstractC0386lQ0 = (AbstractC0386l) obj;
        AbstractC0386l abstractC0386l = (AbstractC0386l) obj2;
        AbstractC0386l abstractC0386l2 = (AbstractC0386l) obj3;
        if (abstractC0386lQ0 != null && abstractC0386l != null) {
            abstractC0386lQ0 = new w().i0(abstractC0386lQ0).i0(abstractC0386l).q0(1);
        } else if (abstractC0386lQ0 == null) {
            abstractC0386lQ0 = abstractC0386l != null ? abstractC0386l : null;
        }
        if (abstractC0386l2 == null) {
            return abstractC0386lQ0;
        }
        w wVar = new w();
        if (abstractC0386lQ0 != null) {
            wVar.i0(abstractC0386lQ0);
        }
        wVar.i0(abstractC0386l2);
        return wVar;
    }

    @Override // androidx.fragment.app.E
    public Object n(Object obj, Object obj2, Object obj3) {
        w wVar = new w();
        if (obj != null) {
            wVar.i0((AbstractC0386l) obj);
        }
        if (obj2 != null) {
            wVar.i0((AbstractC0386l) obj2);
        }
        if (obj3 != null) {
            wVar.i0((AbstractC0386l) obj3);
        }
        return wVar;
    }

    @Override // androidx.fragment.app.E
    public void p(Object obj, View view) {
        if (obj != null) {
            ((AbstractC0386l) obj).U(view);
        }
    }

    @Override // androidx.fragment.app.E
    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC0386l abstractC0386l = (AbstractC0386l) obj;
        int i3 = 0;
        if (abstractC0386l instanceof w) {
            w wVar = (w) abstractC0386l;
            int iL0 = wVar.l0();
            while (i3 < iL0) {
                q(wVar.k0(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (D(abstractC0386l)) {
            return;
        }
        List listE = abstractC0386l.E();
        if (listE.size() == arrayList.size() && listE.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i3 < size) {
                abstractC0386l.b((View) arrayList2.get(i3));
                i3++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                abstractC0386l.U((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.E
    public void r(Object obj, View view, ArrayList arrayList) {
        ((AbstractC0386l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.E
    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((AbstractC0386l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.E
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((AbstractC0386l) obj).Z(new C0094e(rect));
        }
    }

    @Override // androidx.fragment.app.E
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((AbstractC0386l) obj).Z(new a(rect));
        }
    }

    @Override // androidx.fragment.app.E
    public void w(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Object obj, androidx.core.os.h hVar, Runnable runnable) {
        F(abstractComponentCallbacksC0337e, obj, hVar, null, runnable);
    }

    @Override // androidx.fragment.app.E
    public void z(Object obj, View view, ArrayList arrayList) {
        w wVar = (w) obj;
        List listE = wVar.E();
        listE.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.fragment.app.E.d(listE, (View) arrayList.get(i3));
        }
        listE.add(view);
        arrayList.add(view);
        b(wVar, arrayList);
    }
}
