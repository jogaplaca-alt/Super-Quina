package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends o {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f6076s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f6077h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f6078i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f6079j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f6080k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayList f6081l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ArrayList f6082m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ArrayList f6083n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ArrayList f6084o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f6085p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f6086q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    ArrayList f6087r = new ArrayList();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6088a;

        a(ArrayList arrayList) {
            this.f6088a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f6088a) {
                c.this.S(jVar.f6122a, jVar.f6123b, jVar.f6124c, jVar.f6125d, jVar.f6126e);
            }
            this.f6088a.clear();
            c.this.f6082m.remove(this.f6088a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6090a;

        b(ArrayList arrayList) {
            this.f6090a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f6090a.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f6090a.clear();
            c.this.f6083n.remove(this.f6090a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    class RunnableC0085c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6092a;

        RunnableC0085c(ArrayList arrayList) {
            this.f6092a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f6092a.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.D) it.next());
            }
            this.f6092a.clear();
            c.this.f6081l.remove(this.f6092a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.D f6094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6096c;

        d(RecyclerView.D d3, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6094a = d3;
            this.f6095b = viewPropertyAnimator;
            this.f6096c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6095b.setListener(null);
            this.f6096c.setAlpha(1.0f);
            c.this.G(this.f6094a);
            c.this.f6086q.remove(this.f6094a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f6094a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.D f6098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6100c;

        e(RecyclerView.D d3, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6098a = d3;
            this.f6099b = view;
            this.f6100c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6099b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6100c.setListener(null);
            c.this.A(this.f6098a);
            c.this.f6084o.remove(this.f6098a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f6098a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.D f6102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6104c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6105d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6106e;

        f(RecyclerView.D d3, int i3, View view, int i4, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6102a = d3;
            this.f6103b = i3;
            this.f6104c = view;
            this.f6105d = i4;
            this.f6106e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f6103b != 0) {
                this.f6104c.setTranslationX(0.0f);
            }
            if (this.f6105d != 0) {
                this.f6104c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6106e.setListener(null);
            c.this.E(this.f6102a);
            c.this.f6085p.remove(this.f6102a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f6102a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6110c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6108a = iVar;
            this.f6109b = viewPropertyAnimator;
            this.f6110c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6109b.setListener(null);
            this.f6110c.setAlpha(1.0f);
            this.f6110c.setTranslationX(0.0f);
            this.f6110c.setTranslationY(0.0f);
            c.this.C(this.f6108a.f6116a, true);
            c.this.f6087r.remove(this.f6108a.f6116a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f6108a.f6116a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6114c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6112a = iVar;
            this.f6113b = viewPropertyAnimator;
            this.f6114c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6113b.setListener(null);
            this.f6114c.setAlpha(1.0f);
            this.f6114c.setTranslationX(0.0f);
            this.f6114c.setTranslationY(0.0f);
            c.this.C(this.f6112a.f6117b, false);
            c.this.f6087r.remove(this.f6112a.f6117b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f6112a.f6117b, false);
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.D f6122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6126e;

        j(RecyclerView.D d3, int i3, int i4, int i5, int i6) {
            this.f6122a = d3;
            this.f6123b = i3;
            this.f6124c = i4;
            this.f6125d = i5;
            this.f6126e = i6;
        }
    }

    private void T(RecyclerView.D d3) {
        View view = d3.f5908a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6086q.add(d3);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(d3, viewPropertyAnimatorAnimate, view)).start();
    }

    private void W(List list, RecyclerView.D d3) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, d3) && iVar.f6116a == null && iVar.f6117b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.D d3 = iVar.f6116a;
        if (d3 != null) {
            Y(iVar, d3);
        }
        RecyclerView.D d4 = iVar.f6117b;
        if (d4 != null) {
            Y(iVar, d4);
        }
    }

    private boolean Y(i iVar, RecyclerView.D d3) {
        boolean z3 = false;
        if (iVar.f6117b == d3) {
            iVar.f6117b = null;
        } else {
            if (iVar.f6116a != d3) {
                return false;
            }
            iVar.f6116a = null;
            z3 = true;
        }
        d3.f5908a.setAlpha(1.0f);
        d3.f5908a.setTranslationX(0.0f);
        d3.f5908a.setTranslationY(0.0f);
        C(d3, z3);
        return true;
    }

    private void Z(RecyclerView.D d3) {
        if (f6076s == null) {
            f6076s = new ValueAnimator().getInterpolator();
        }
        d3.f5908a.animate().setInterpolator(f6076s);
        j(d3);
    }

    void Q(RecyclerView.D d3) {
        View view = d3.f5908a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6084o.add(d3);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(d3, view, viewPropertyAnimatorAnimate)).start();
    }

    void R(i iVar) {
        RecyclerView.D d3 = iVar.f6116a;
        View view = d3 == null ? null : d3.f5908a;
        RecyclerView.D d4 = iVar.f6117b;
        View view2 = d4 != null ? d4.f5908a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f6087r.add(iVar.f6116a);
            duration.translationX(iVar.f6120e - iVar.f6118c);
            duration.translationY(iVar.f6121f - iVar.f6119d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f6087r.add(iVar.f6117b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void S(RecyclerView.D d3, int i3, int i4, int i5, int i6) {
        View view = d3.f5908a;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (i7 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i8 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6085p.add(d3);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(d3, i7, view, i8, viewPropertyAnimatorAnimate)).start();
    }

    void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.D) list.get(size)).f5908a.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.D d3, List list) {
        return !list.isEmpty() || super.g(d3, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.D d3) {
        View view = d3.f5908a;
        view.animate().cancel();
        int size = this.f6079j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f6079j.get(size)).f6122a == d3) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d3);
                this.f6079j.remove(size);
            }
        }
        W(this.f6080k, d3);
        if (this.f6077h.remove(d3)) {
            view.setAlpha(1.0f);
            G(d3);
        }
        if (this.f6078i.remove(d3)) {
            view.setAlpha(1.0f);
            A(d3);
        }
        for (int size2 = this.f6083n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f6083n.get(size2);
            W(arrayList, d3);
            if (arrayList.isEmpty()) {
                this.f6083n.remove(size2);
            }
        }
        for (int size3 = this.f6082m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f6082m.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (((j) arrayList2.get(size4)).f6122a == d3) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d3);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.f6082m.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f6081l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f6081l.get(size5);
            if (arrayList3.remove(d3)) {
                view.setAlpha(1.0f);
                A(d3);
                if (arrayList3.isEmpty()) {
                    this.f6081l.remove(size5);
                }
            }
        }
        this.f6086q.remove(d3);
        this.f6084o.remove(d3);
        this.f6087r.remove(d3);
        this.f6085p.remove(d3);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f6079j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f6079j.get(size);
            View view = jVar.f6122a.f5908a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f6122a);
            this.f6079j.remove(size);
        }
        for (int size2 = this.f6077h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.D) this.f6077h.get(size2));
            this.f6077h.remove(size2);
        }
        int size3 = this.f6078i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.D d3 = (RecyclerView.D) this.f6078i.get(size3);
            d3.f5908a.setAlpha(1.0f);
            A(d3);
            this.f6078i.remove(size3);
        }
        for (int size4 = this.f6080k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f6080k.get(size4));
        }
        this.f6080k.clear();
        if (p()) {
            for (int size5 = this.f6082m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f6082m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f6122a.f5908a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f6122a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f6082m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f6081l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f6081l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.D d4 = (RecyclerView.D) arrayList2.get(size8);
                    d4.f5908a.setAlpha(1.0f);
                    A(d4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f6081l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f6083n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f6083n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f6083n.remove(arrayList3);
                    }
                }
            }
            U(this.f6086q);
            U(this.f6085p);
            U(this.f6084o);
            U(this.f6087r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f6078i.isEmpty() && this.f6080k.isEmpty() && this.f6079j.isEmpty() && this.f6077h.isEmpty() && this.f6085p.isEmpty() && this.f6086q.isEmpty() && this.f6084o.isEmpty() && this.f6087r.isEmpty() && this.f6082m.isEmpty() && this.f6081l.isEmpty() && this.f6083n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean zIsEmpty = this.f6077h.isEmpty();
        boolean zIsEmpty2 = this.f6079j.isEmpty();
        boolean zIsEmpty3 = this.f6080k.isEmpty();
        boolean zIsEmpty4 = this.f6078i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f6077h.iterator();
        while (it.hasNext()) {
            T((RecyclerView.D) it.next());
        }
        this.f6077h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f6079j);
            this.f6082m.add(arrayList);
            this.f6079j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                Z.j0(((j) arrayList.get(0)).f6122a.f5908a, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f6080k);
            this.f6083n.add(arrayList2);
            this.f6080k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                Z.j0(((i) arrayList2.get(0)).f6116a.f5908a, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f6078i);
        this.f6081l.add(arrayList3);
        this.f6078i.clear();
        RunnableC0085c runnableC0085c = new RunnableC0085c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnableC0085c.run();
        } else {
            Z.j0(((RecyclerView.D) arrayList3.get(0)).f5908a, runnableC0085c, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    @Override // androidx.recyclerview.widget.o
    public boolean w(RecyclerView.D d3) {
        Z(d3);
        d3.f5908a.setAlpha(0.0f);
        this.f6078i.add(d3);
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean x(RecyclerView.D d3, RecyclerView.D d4, int i3, int i4, int i5, int i6) {
        if (d3 == d4) {
            return y(d3, i3, i4, i5, i6);
        }
        float translationX = d3.f5908a.getTranslationX();
        float translationY = d3.f5908a.getTranslationY();
        float alpha = d3.f5908a.getAlpha();
        Z(d3);
        int i7 = (int) ((i5 - i3) - translationX);
        int i8 = (int) ((i6 - i4) - translationY);
        d3.f5908a.setTranslationX(translationX);
        d3.f5908a.setTranslationY(translationY);
        d3.f5908a.setAlpha(alpha);
        if (d4 != null) {
            Z(d4);
            d4.f5908a.setTranslationX(-i7);
            d4.f5908a.setTranslationY(-i8);
            d4.f5908a.setAlpha(0.0f);
        }
        this.f6080k.add(new i(d3, d4, i3, i4, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean y(RecyclerView.D d3, int i3, int i4, int i5, int i6) {
        View view = d3.f5908a;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) d3.f5908a.getTranslationY());
        Z(d3);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            E(d3);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        this.f6079j.add(new j(d3, translationX, translationY, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean z(RecyclerView.D d3) {
        Z(d3);
        this.f6077h.add(d3);
        return true;
    }

    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.D f6116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.D f6117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6120e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6121f;

        private i(RecyclerView.D d3, RecyclerView.D d4) {
            this.f6116a = d3;
            this.f6117b = d4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f6116a + ", newHolder=" + this.f6117b + ", fromX=" + this.f6118c + ", fromY=" + this.f6119d + ", toX=" + this.f6120e + ", toY=" + this.f6121f + '}';
        }

        i(RecyclerView.D d3, RecyclerView.D d4, int i3, int i4, int i5, int i6) {
            this(d3, d4);
            this.f6118c = i3;
            this.f6119d = i4;
            this.f6120e = i5;
            this.f6121f = i6;
        }
    }
}
