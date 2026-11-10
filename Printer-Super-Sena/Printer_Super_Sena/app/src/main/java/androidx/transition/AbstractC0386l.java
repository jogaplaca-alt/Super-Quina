package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.transition.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0386l implements Cloneable {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final Animator[] f6642I = new Animator[0];

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int[] f6643J = {2, 1, 3, 4};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final AbstractC0381g f6644K = new a();

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static ThreadLocal f6645L = new ThreadLocal();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private e f6651F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private p046n.a f6652G;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList f6673t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList f6674u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f[] f6675v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6654a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6655b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f6656c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f6657d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f6658e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f6659f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f6660g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f6661h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f6662i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f6663j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f6664k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f6665l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList f6666m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList f6667n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList f6668o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private z f6669p = new z();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private z f6670q = new z();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    w f6671r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f6672s = f6643J;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f6676w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ArrayList f6677x = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Animator[] f6678y = f6642I;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f6679z = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f6646A = false;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    boolean f6647B = false;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private AbstractC0386l f6648C = null;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private ArrayList f6649D = null;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    ArrayList f6650E = new ArrayList();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private AbstractC0381g f6653H = f6644K;

    /* JADX INFO: renamed from: androidx.transition.l$a */
    class a extends AbstractC0381g {
        a() {
        }

        @Override // androidx.transition.AbstractC0381g
        public Path a(float f3, float f4, float f5, float f6) {
            Path path = new Path();
            path.moveTo(f3, f4);
            path.lineTo(f5, f6);
            return path;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.l$b */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p046n.a f6680a;

        b(p046n.a aVar) {
            this.f6680a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6680a.remove(animator);
            AbstractC0386l.this.f6677x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC0386l.this.f6677x.add(animator);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.l$c */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC0386l.this.q();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.l$d */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f6683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        y f6685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        WindowId f6686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        AbstractC0386l f6687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Animator f6688f;

        d(View view, String str, AbstractC0386l abstractC0386l, WindowId windowId, y yVar, Animator animator) {
            this.f6683a = view;
            this.f6684b = str;
            this.f6685c = yVar;
            this.f6686d = windowId;
            this.f6687e = abstractC0386l;
            this.f6688f = animator;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.l$e */
    public static abstract class e {
    }

    /* JADX INFO: renamed from: androidx.transition.l$f */
    public interface f {
        void a(AbstractC0386l abstractC0386l);

        void b(AbstractC0386l abstractC0386l);

        void c(AbstractC0386l abstractC0386l, boolean z3);

        void d(AbstractC0386l abstractC0386l);

        void e(AbstractC0386l abstractC0386l);

        void f(AbstractC0386l abstractC0386l);

        void g(AbstractC0386l abstractC0386l, boolean z3);
    }

    /* JADX INFO: renamed from: androidx.transition.l$g */
    interface g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6689a = new g() { // from class: androidx.transition.n
            @Override // androidx.transition.AbstractC0386l.g
            public final void a(AbstractC0386l.f fVar, AbstractC0386l abstractC0386l, boolean z3) {
                fVar.g(abstractC0386l, z3);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f6690b = new g() { // from class: androidx.transition.o
            @Override // androidx.transition.AbstractC0386l.g
            public final void a(AbstractC0386l.f fVar, AbstractC0386l abstractC0386l, boolean z3) {
                fVar.c(abstractC0386l, z3);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f6691c = new g() { // from class: androidx.transition.p
            @Override // androidx.transition.AbstractC0386l.g
            public final void a(AbstractC0386l.f fVar, AbstractC0386l abstractC0386l, boolean z3) {
                fVar.e(abstractC0386l);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f6692d = new g() { // from class: androidx.transition.q
            @Override // androidx.transition.AbstractC0386l.g
            public final void a(AbstractC0386l.f fVar, AbstractC0386l abstractC0386l, boolean z3) {
                fVar.a(abstractC0386l);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f6693e = new g() { // from class: androidx.transition.r
            @Override // androidx.transition.AbstractC0386l.g
            public final void a(AbstractC0386l.f fVar, AbstractC0386l abstractC0386l, boolean z3) {
                fVar.b(abstractC0386l);
            }
        };

        void a(f fVar, AbstractC0386l abstractC0386l, boolean z3);
    }

    private static boolean J(y yVar, y yVar2, String str) {
        Object obj = yVar.f6710a.get(str);
        Object obj2 = yVar2.f6710a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void K(p046n.a aVar, p046n.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) sparseArray.valueAt(i3);
            if (view2 != null && I(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i3))) != null && I(view)) {
                y yVar = (y) aVar.get(view2);
                y yVar2 = (y) aVar2.get(view);
                if (yVar != null && yVar2 != null) {
                    this.f6673t.add(yVar);
                    this.f6674u.add(yVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void L(p046n.a aVar, p046n.a aVar2) {
        y yVar;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.i(size);
            if (view != null && I(view) && (yVar = (y) aVar2.remove(view)) != null && I(yVar.f6711b)) {
                this.f6673t.add((y) aVar.k(size));
                this.f6674u.add(yVar);
            }
        }
    }

    private void M(p046n.a aVar, p046n.a aVar2, p046n.d dVar, p046n.d dVar2) {
        View view;
        int iO = dVar.o();
        for (int i3 = 0; i3 < iO; i3++) {
            View view2 = (View) dVar.p(i3);
            if (view2 != null && I(view2) && (view = (View) dVar2.g(dVar.k(i3))) != null && I(view)) {
                y yVar = (y) aVar.get(view2);
                y yVar2 = (y) aVar2.get(view);
                if (yVar != null && yVar2 != null) {
                    this.f6673t.add(yVar);
                    this.f6674u.add(yVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void N(p046n.a aVar, p046n.a aVar2, p046n.a aVar3, p046n.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) aVar3.m(i3);
            if (view2 != null && I(view2) && (view = (View) aVar4.get(aVar3.i(i3))) != null && I(view)) {
                y yVar = (y) aVar.get(view2);
                y yVar2 = (y) aVar2.get(view);
                if (yVar != null && yVar2 != null) {
                    this.f6673t.add(yVar);
                    this.f6674u.add(yVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void O(z zVar, z zVar2) {
        p046n.a aVar = new p046n.a(zVar.f6713a);
        p046n.a aVar2 = new p046n.a(zVar2.f6713a);
        int i3 = 0;
        while (true) {
            int[] iArr = this.f6672s;
            if (i3 >= iArr.length) {
                d(aVar, aVar2);
                return;
            }
            int i4 = iArr[i3];
            if (i4 == 1) {
                L(aVar, aVar2);
            } else if (i4 == 2) {
                N(aVar, aVar2, zVar.f6716d, zVar2.f6716d);
            } else if (i4 == 3) {
                K(aVar, aVar2, zVar.f6714b, zVar2.f6714b);
            } else if (i4 == 4) {
                M(aVar, aVar2, zVar.f6715c, zVar2.f6715c);
            }
            i3++;
        }
    }

    private void P(AbstractC0386l abstractC0386l, g gVar, boolean z3) {
        AbstractC0386l abstractC0386l2 = this.f6648C;
        if (abstractC0386l2 != null) {
            abstractC0386l2.P(abstractC0386l, gVar, z3);
        }
        ArrayList arrayList = this.f6649D;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f6649D.size();
        f[] fVarArr = this.f6675v;
        if (fVarArr == null) {
            fVarArr = new f[size];
        }
        this.f6675v = null;
        f[] fVarArr2 = (f[]) this.f6649D.toArray(fVarArr);
        for (int i3 = 0; i3 < size; i3++) {
            gVar.a(fVarArr2[i3], abstractC0386l, z3);
            fVarArr2[i3] = null;
        }
        this.f6675v = fVarArr2;
    }

    private void W(Animator animator, p046n.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    private void d(p046n.a aVar, p046n.a aVar2) {
        for (int i3 = 0; i3 < aVar.size(); i3++) {
            y yVar = (y) aVar.m(i3);
            if (I(yVar.f6711b)) {
                this.f6673t.add(yVar);
                this.f6674u.add(null);
            }
        }
        for (int i4 = 0; i4 < aVar2.size(); i4++) {
            y yVar2 = (y) aVar2.m(i4);
            if (I(yVar2.f6711b)) {
                this.f6674u.add(yVar2);
                this.f6673t.add(null);
            }
        }
    }

    private static void e(z zVar, View view, y yVar) {
        zVar.f6713a.put(view, yVar);
        int id = view.getId();
        if (id >= 0) {
            if (zVar.f6714b.indexOfKey(id) >= 0) {
                zVar.f6714b.put(id, null);
            } else {
                zVar.f6714b.put(id, view);
            }
        }
        String strL = Z.L(view);
        if (strL != null) {
            if (zVar.f6716d.containsKey(strL)) {
                zVar.f6716d.put(strL, null);
            } else {
                zVar.f6716d.put(strL, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (zVar.f6715c.i(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    zVar.f6715c.l(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) zVar.f6715c.g(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    zVar.f6715c.l(itemIdAtPosition, null);
                }
            }
        }
    }

    private void i(View view, boolean z3) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f6662i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f6663j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f6664k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (((Class) this.f6664k.get(i3)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    y yVar = new y(view);
                    if (z3) {
                        k(yVar);
                    } else {
                        h(yVar);
                    }
                    yVar.f6712c.add(this);
                    j(yVar);
                    if (z3) {
                        e(this.f6669p, view, yVar);
                    } else {
                        e(this.f6670q, view, yVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f6666m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f6667n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f6668o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    if (((Class) this.f6668o.get(i4)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                                i(viewGroup.getChildAt(i5), z3);
                            }
                        }
                    }
                }
            }
        }
    }

    private static p046n.a z() {
        p046n.a aVar = (p046n.a) f6645L.get();
        if (aVar != null) {
            return aVar;
        }
        p046n.a aVar2 = new p046n.a();
        f6645L.set(aVar2);
        return aVar2;
    }

    public long A() {
        return this.f6655b;
    }

    public List B() {
        return this.f6658e;
    }

    public List C() {
        return this.f6660g;
    }

    public List D() {
        return this.f6661h;
    }

    public List E() {
        return this.f6659f;
    }

    public String[] F() {
        return null;
    }

    public y G(View view, boolean z3) {
        w wVar = this.f6671r;
        if (wVar != null) {
            return wVar.G(view, z3);
        }
        return (y) (z3 ? this.f6669p : this.f6670q).f6713a.get(view);
    }

    public boolean H(y yVar, y yVar2) {
        if (yVar == null || yVar2 == null) {
            return false;
        }
        String[] strArrF = F();
        if (strArrF == null) {
            Iterator it = yVar.f6710a.keySet().iterator();
            while (it.hasNext()) {
                if (J(yVar, yVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrF) {
            if (!J(yVar, yVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean I(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f6662i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f6663j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f6664k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((Class) this.f6664k.get(i3)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f6665l != null && Z.L(view) != null && this.f6665l.contains(Z.L(view))) {
            return false;
        }
        if ((this.f6658e.size() == 0 && this.f6659f.size() == 0 && (((arrayList = this.f6661h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f6660g) == null || arrayList2.isEmpty()))) || this.f6658e.contains(Integer.valueOf(id)) || this.f6659f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f6660g;
        if (arrayList6 != null && arrayList6.contains(Z.L(view))) {
            return true;
        }
        if (this.f6661h != null) {
            for (int i4 = 0; i4 < this.f6661h.size(); i4++) {
                if (((Class) this.f6661h.get(i4)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    void Q(g gVar, boolean z3) {
        P(this, gVar, z3);
    }

    public void R(View view) {
        if (this.f6647B) {
            return;
        }
        int size = this.f6677x.size();
        Animator[] animatorArr = (Animator[]) this.f6677x.toArray(this.f6678y);
        this.f6678y = f6642I;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = animatorArr[i3];
            animatorArr[i3] = null;
            animator.pause();
        }
        this.f6678y = animatorArr;
        Q(g.f6692d, false);
        this.f6646A = true;
    }

    void S(ViewGroup viewGroup) {
        d dVar;
        this.f6673t = new ArrayList();
        this.f6674u = new ArrayList();
        O(this.f6669p, this.f6670q);
        p046n.a aVarZ = z();
        int size = aVarZ.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = (Animator) aVarZ.i(i3);
            if (animator != null && (dVar = (d) aVarZ.get(animator)) != null && dVar.f6683a != null && windowId.equals(dVar.f6686d)) {
                y yVar = dVar.f6685c;
                View view = dVar.f6683a;
                y yVarG = G(view, true);
                y yVarU = u(view, true);
                if (yVarG == null && yVarU == null) {
                    yVarU = (y) this.f6670q.f6713a.get(view);
                }
                if ((yVarG != null || yVarU != null) && dVar.f6687e.H(yVar, yVarU)) {
                    dVar.f6687e.y().getClass();
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        aVarZ.remove(animator);
                    }
                }
            }
        }
        p(viewGroup, this.f6669p, this.f6670q, this.f6673t, this.f6674u);
        X();
    }

    public AbstractC0386l T(f fVar) {
        AbstractC0386l abstractC0386l;
        ArrayList arrayList = this.f6649D;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(fVar) && (abstractC0386l = this.f6648C) != null) {
            abstractC0386l.T(fVar);
        }
        if (this.f6649D.size() == 0) {
            this.f6649D = null;
        }
        return this;
    }

    public AbstractC0386l U(View view) {
        this.f6659f.remove(view);
        return this;
    }

    public void V(View view) {
        if (this.f6646A) {
            if (!this.f6647B) {
                int size = this.f6677x.size();
                Animator[] animatorArr = (Animator[]) this.f6677x.toArray(this.f6678y);
                this.f6678y = f6642I;
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    Animator animator = animatorArr[i3];
                    animatorArr[i3] = null;
                    animator.resume();
                }
                this.f6678y = animatorArr;
                Q(g.f6693e, false);
            }
            this.f6646A = false;
        }
    }

    protected void X() {
        e0();
        p046n.a aVarZ = z();
        for (Animator animator : this.f6650E) {
            if (aVarZ.containsKey(animator)) {
                e0();
                W(animator, aVarZ);
            }
        }
        this.f6650E.clear();
        q();
    }

    public AbstractC0386l Y(long j3) {
        this.f6656c = j3;
        return this;
    }

    public void Z(e eVar) {
        this.f6651F = eVar;
    }

    public AbstractC0386l a(f fVar) {
        if (this.f6649D == null) {
            this.f6649D = new ArrayList();
        }
        this.f6649D.add(fVar);
        return this;
    }

    public AbstractC0386l a0(TimeInterpolator timeInterpolator) {
        this.f6657d = timeInterpolator;
        return this;
    }

    public AbstractC0386l b(View view) {
        this.f6659f.add(view);
        return this;
    }

    public void b0(AbstractC0381g abstractC0381g) {
        if (abstractC0381g == null) {
            this.f6653H = f6644K;
        } else {
            this.f6653H = abstractC0381g;
        }
    }

    public void c0(v vVar) {
    }

    public AbstractC0386l d0(long j3) {
        this.f6655b = j3;
        return this;
    }

    protected void e0() {
        if (this.f6679z == 0) {
            Q(g.f6689a, false);
            this.f6647B = false;
        }
        this.f6679z++;
    }

    protected void f(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (A() >= 0) {
            animator.setStartDelay(A() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    String f0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f6656c != -1) {
            sb.append("dur(");
            sb.append(this.f6656c);
            sb.append(") ");
        }
        if (this.f6655b != -1) {
            sb.append("dly(");
            sb.append(this.f6655b);
            sb.append(") ");
        }
        if (this.f6657d != null) {
            sb.append("interp(");
            sb.append(this.f6657d);
            sb.append(") ");
        }
        if (this.f6658e.size() > 0 || this.f6659f.size() > 0) {
            sb.append("tgts(");
            if (this.f6658e.size() > 0) {
                for (int i3 = 0; i3 < this.f6658e.size(); i3++) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f6658e.get(i3));
                }
            }
            if (this.f6659f.size() > 0) {
                for (int i4 = 0; i4 < this.f6659f.size(); i4++) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f6659f.get(i4));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    protected void g() {
        int size = this.f6677x.size();
        Animator[] animatorArr = (Animator[]) this.f6677x.toArray(this.f6678y);
        this.f6678y = f6642I;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = animatorArr[i3];
            animatorArr[i3] = null;
            animator.cancel();
        }
        this.f6678y = animatorArr;
        Q(g.f6691c, false);
    }

    public abstract void h(y yVar);

    void j(y yVar) {
    }

    public abstract void k(y yVar);

    void l(ViewGroup viewGroup, boolean z3) {
        ArrayList arrayList;
        ArrayList arrayList2;
        p046n.a aVar;
        m(z3);
        if ((this.f6658e.size() > 0 || this.f6659f.size() > 0) && (((arrayList = this.f6660g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f6661h) == null || arrayList2.isEmpty()))) {
            for (int i3 = 0; i3 < this.f6658e.size(); i3++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f6658e.get(i3)).intValue());
                if (viewFindViewById != null) {
                    y yVar = new y(viewFindViewById);
                    if (z3) {
                        k(yVar);
                    } else {
                        h(yVar);
                    }
                    yVar.f6712c.add(this);
                    j(yVar);
                    if (z3) {
                        e(this.f6669p, viewFindViewById, yVar);
                    } else {
                        e(this.f6670q, viewFindViewById, yVar);
                    }
                }
            }
            for (int i4 = 0; i4 < this.f6659f.size(); i4++) {
                View view = (View) this.f6659f.get(i4);
                y yVar2 = new y(view);
                if (z3) {
                    k(yVar2);
                } else {
                    h(yVar2);
                }
                yVar2.f6712c.add(this);
                j(yVar2);
                if (z3) {
                    e(this.f6669p, view, yVar2);
                } else {
                    e(this.f6670q, view, yVar2);
                }
            }
        } else {
            i(viewGroup, z3);
        }
        if (z3 || (aVar = this.f6652G) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList3.add((View) this.f6669p.f6716d.remove((String) this.f6652G.i(i5)));
        }
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) arrayList3.get(i6);
            if (view2 != null) {
                this.f6669p.f6716d.put((String) this.f6652G.m(i6), view2);
            }
        }
    }

    void m(boolean z3) {
        if (z3) {
            this.f6669p.f6713a.clear();
            this.f6669p.f6714b.clear();
            this.f6669p.f6715c.b();
        } else {
            this.f6670q.f6713a.clear();
            this.f6670q.f6714b.clear();
            this.f6670q.f6715c.b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: n */
    public AbstractC0386l clone() {
        try {
            AbstractC0386l abstractC0386l = (AbstractC0386l) super.clone();
            abstractC0386l.f6650E = new ArrayList();
            abstractC0386l.f6669p = new z();
            abstractC0386l.f6670q = new z();
            abstractC0386l.f6673t = null;
            abstractC0386l.f6674u = null;
            abstractC0386l.f6648C = this;
            abstractC0386l.f6649D = null;
            return abstractC0386l;
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    public Animator o(ViewGroup viewGroup, y yVar, y yVar2) {
        return null;
    }

    void p(ViewGroup viewGroup, z zVar, z zVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        y yVar;
        Animator animator2;
        y yVar2;
        p046n.a aVarZ = z();
        SparseIntArray sparseIntArray = new SparseIntArray();
        y().getClass();
        int i3 = 0;
        for (int size = arrayList.size(); i3 < size; size = size) {
            y yVar3 = (y) arrayList.get(i3);
            y yVar4 = (y) arrayList2.get(i3);
            if (yVar3 != null && !yVar3.f6712c.contains(this)) {
                yVar3 = null;
            }
            if (yVar4 != null && !yVar4.f6712c.contains(this)) {
                yVar4 = null;
            }
            if ((yVar3 != null || yVar4 != null) && (yVar3 == null || yVar4 == null || H(yVar3, yVar4))) {
                Animator animatorO = o(viewGroup, yVar3, yVar4);
                if (animatorO != null) {
                    if (yVar4 != null) {
                        View view2 = yVar4.f6711b;
                        String[] strArrF = F();
                        if (strArrF != null && strArrF.length > 0) {
                            yVar2 = new y(view2);
                            y yVar5 = (y) zVar2.f6713a.get(view2);
                            if (yVar5 != null) {
                                int i4 = 0;
                                while (i4 < strArrF.length) {
                                    Map map = yVar2.f6710a;
                                    Animator animator3 = animatorO;
                                    String str = strArrF[i4];
                                    map.put(str, yVar5.f6710a.get(str));
                                    i4++;
                                    animatorO = animator3;
                                    strArrF = strArrF;
                                }
                            }
                            Animator animator4 = animatorO;
                            int size2 = aVarZ.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) aVarZ.get((Animator) aVarZ.i(i5));
                                if (dVar.f6685c != null && dVar.f6683a == view2 && dVar.f6684b.equals(v()) && dVar.f6685c.equals(yVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            animator2 = animatorO;
                            yVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        yVar = yVar2;
                    } else {
                        view = yVar3.f6711b;
                        animator = animatorO;
                        yVar = null;
                    }
                    if (animator != null) {
                        aVarZ.put(animator, new d(view, v(), this, viewGroup.getWindowId(), yVar, animator));
                        this.f6650E.add(animator);
                    }
                }
                i3++;
            }
            i3++;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                d dVar2 = (d) aVarZ.get((Animator) this.f6650E.get(sparseIntArray.keyAt(i6)));
                dVar2.f6688f.setStartDelay((((long) sparseIntArray.valueAt(i6)) - Long.MAX_VALUE) + dVar2.f6688f.getStartDelay());
            }
        }
    }

    protected void q() {
        int i3 = this.f6679z - 1;
        this.f6679z = i3;
        if (i3 == 0) {
            Q(g.f6690b, false);
            for (int i4 = 0; i4 < this.f6669p.f6715c.o(); i4++) {
                View view = (View) this.f6669p.f6715c.p(i4);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.f6670q.f6715c.o(); i5++) {
                View view2 = (View) this.f6670q.f6715c.p(i5);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f6647B = true;
        }
    }

    public long r() {
        return this.f6656c;
    }

    public e s() {
        return this.f6651F;
    }

    public TimeInterpolator t() {
        return this.f6657d;
    }

    public String toString() {
        return f0("");
    }

    y u(View view, boolean z3) {
        w wVar = this.f6671r;
        if (wVar != null) {
            return wVar.u(view, z3);
        }
        ArrayList arrayList = z3 ? this.f6673t : this.f6674u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            }
            y yVar = (y) arrayList.get(i3);
            if (yVar == null) {
                return null;
            }
            if (yVar.f6711b == view) {
                break;
            }
            i3++;
        }
        if (i3 >= 0) {
            return (y) (z3 ? this.f6674u : this.f6673t).get(i3);
        }
        return null;
    }

    public String v() {
        return this.f6654a;
    }

    public AbstractC0381g w() {
        return this.f6653H;
    }

    public v x() {
        return null;
    }

    public final AbstractC0386l y() {
        w wVar = this.f6671r;
        return wVar != null ? wVar.y() : this;
    }
}
