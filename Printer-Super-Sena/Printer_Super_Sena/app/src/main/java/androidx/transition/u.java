package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AbstractC0386l f6694a = new C0375a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal f6695b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList f6696c = new ArrayList();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AbstractC0386l f6697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f6698b;

        /* JADX INFO: renamed from: androidx.transition.u$a$a, reason: collision with other inner class name */
        class C0095a extends t {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p046n.a f6699a;

            C0095a(p046n.a aVar) {
                this.f6699a = aVar;
            }

            @Override // androidx.transition.AbstractC0386l.f
            public void f(AbstractC0386l abstractC0386l) {
                ((ArrayList) this.f6699a.get(a.this.f6698b)).remove(abstractC0386l);
                abstractC0386l.T(this);
            }
        }

        a(AbstractC0386l abstractC0386l, ViewGroup viewGroup) {
            this.f6697a = abstractC0386l;
            this.f6698b = viewGroup;
        }

        private void a() {
            this.f6698b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f6698b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!u.f6696c.remove(this.f6698b)) {
                return true;
            }
            p046n.a aVarB = u.b();
            ArrayList arrayList = (ArrayList) aVarB.get(this.f6698b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                aVarB.put(this.f6698b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f6697a);
            this.f6697a.a(new C0095a(aVarB));
            this.f6697a.l(this.f6698b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC0386l) it.next()).V(this.f6698b);
                }
            }
            this.f6697a.S(this.f6698b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            u.f6696c.remove(this.f6698b);
            ArrayList arrayList = (ArrayList) u.b().get(this.f6698b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC0386l) it.next()).V(this.f6698b);
                }
            }
            this.f6697a.m(true);
        }
    }

    public static void a(ViewGroup viewGroup, AbstractC0386l abstractC0386l) {
        if (f6696c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f6696c.add(viewGroup);
        if (abstractC0386l == null) {
            abstractC0386l = f6694a;
        }
        AbstractC0386l abstractC0386lClone = abstractC0386l.clone();
        d(viewGroup, abstractC0386lClone);
        AbstractC0385k.b(viewGroup, null);
        c(viewGroup, abstractC0386lClone);
    }

    static p046n.a b() {
        p046n.a aVar;
        WeakReference weakReference = (WeakReference) f6695b.get();
        if (weakReference != null && (aVar = (p046n.a) weakReference.get()) != null) {
            return aVar;
        }
        p046n.a aVar2 = new p046n.a();
        f6695b.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, AbstractC0386l abstractC0386l) {
        if (abstractC0386l == null || viewGroup == null) {
            return;
        }
        a aVar = new a(abstractC0386l, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, AbstractC0386l abstractC0386l) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC0386l) it.next()).R(viewGroup);
            }
        }
        if (abstractC0386l != null) {
            abstractC0386l.l(viewGroup, true);
        }
        AbstractC0385k.a(viewGroup);
    }
}
