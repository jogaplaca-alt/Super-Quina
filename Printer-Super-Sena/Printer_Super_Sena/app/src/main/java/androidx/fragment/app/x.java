package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.L;
import androidx.core.view.Z;
import androidx.transition.C0379e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5416a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final E f5417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final E f5418c;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.h f5421c;

        a(g gVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
            this.f5419a = gVar;
            this.f5420b = abstractComponentCallbacksC0337e;
            this.f5421c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5419a.a(this.f5420b, this.f5421c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5422a;

        b(ArrayList arrayList) {
            this.f5422a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.A(this.f5422a, 4);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.h f5425c;

        c(g gVar, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar) {
            this.f5423a = gVar;
            this.f5424b = abstractComponentCallbacksC0337e;
            this.f5425c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5423a.a(this.f5424b, this.f5425c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f5427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f5428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5429d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5430e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f5431f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f5432g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f5433h;

        d(Object obj, E e3, View view, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f5426a = obj;
            this.f5427b = e3;
            this.f5428c = view;
            this.f5429d = abstractComponentCallbacksC0337e;
            this.f5430e = arrayList;
            this.f5431f = arrayList2;
            this.f5432g = arrayList3;
            this.f5433h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f5426a;
            if (obj != null) {
                this.f5427b.p(obj, this.f5428c);
                this.f5431f.addAll(x.k(this.f5427b, this.f5426a, this.f5429d, this.f5430e, this.f5428c));
            }
            if (this.f5432g != null) {
                if (this.f5433h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f5428c);
                    this.f5427b.q(this.f5433h, this.f5432g, arrayList);
                }
                this.f5432g.clear();
                this.f5432g.add(this.f5428c);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p046n.a f5437d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f5438e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ E f5439f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Rect f5440g;

        e(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2, boolean z3, p046n.a aVar, View view, E e3, Rect rect) {
            this.f5434a = abstractComponentCallbacksC0337e;
            this.f5435b = abstractComponentCallbacksC0337e2;
            this.f5436c = z3;
            this.f5437d = aVar;
            this.f5438e = view;
            this.f5439f = e3;
            this.f5440g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.f(this.f5434a, this.f5435b, this.f5436c, this.f5437d, false);
            View view = this.f5438e;
            if (view != null) {
                this.f5439f.k(view, this.f5440g);
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ E f5441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p046n.a f5442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f5443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f5444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f5446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AbstractComponentCallbacksC0337e f5448h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f5449i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f5450j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Object f5451k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Rect f5452l;

        f(E e3, p046n.a aVar, Object obj, h hVar, ArrayList arrayList, View view, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2, boolean z3, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f5441a = e3;
            this.f5442b = aVar;
            this.f5443c = obj;
            this.f5444d = hVar;
            this.f5445e = arrayList;
            this.f5446f = view;
            this.f5447g = abstractComponentCallbacksC0337e;
            this.f5448h = abstractComponentCallbacksC0337e2;
            this.f5449i = z3;
            this.f5450j = arrayList2;
            this.f5451k = obj2;
            this.f5452l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            p046n.a aVarH = x.h(this.f5441a, this.f5442b, this.f5443c, this.f5444d);
            if (aVarH != null) {
                this.f5445e.addAll(aVarH.values());
                this.f5445e.add(this.f5446f);
            }
            x.f(this.f5447g, this.f5448h, this.f5449i, aVarH, false);
            Object obj = this.f5443c;
            if (obj != null) {
                this.f5441a.A(obj, this.f5450j, this.f5445e);
                View viewS = x.s(aVarH, this.f5444d, this.f5451k, this.f5449i);
                if (viewS != null) {
                    this.f5441a.k(viewS, this.f5452l);
                }
            }
        }
    }

    interface g {
        void a(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar);

        void b(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, androidx.core.os.h hVar);
    }

    static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractComponentCallbacksC0337e f5453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0333a f5455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractComponentCallbacksC0337e f5456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C0333a f5458f;

        h() {
        }
    }

    static {
        f5417b = Build.VERSION.SDK_INT >= 21 ? new D() : null;
        f5418c = w();
    }

    static void A(ArrayList arrayList, int i3) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i3);
        }
    }

    static void B(Context context, AbstractC0340h abstractC0340h, ArrayList arrayList, ArrayList arrayList2, int i3, int i4, boolean z3, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i5 = i3; i5 < i4; i5++) {
            C0333a c0333a = (C0333a) arrayList.get(i5);
            if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                e(c0333a, sparseArray, z3);
            } else {
                c(c0333a, sparseArray, z3);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i6 = 0; i6 < size; i6++) {
                int iKeyAt = sparseArray.keyAt(i6);
                p046n.a aVarD = d(iKeyAt, arrayList, arrayList2, i3, i4);
                h hVar = (h) sparseArray.valueAt(i6);
                if (abstractC0340h.d() && (viewGroup = (ViewGroup) abstractC0340h.c(iKeyAt)) != null) {
                    if (z3) {
                        o(viewGroup, hVar, view, aVarD, gVar);
                    } else {
                        n(viewGroup, hVar, view, aVarD, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList arrayList, p046n.a aVar, Collection collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.m(size);
            if (collection.contains(Z.L(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x003b  */
    /* JADX WARN: Code duplicated, block: B:33:0x003d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0052  */
    /* JADX WARN: Code duplicated, block: B:44:0x0054  */
    /* JADX WARN: Code duplicated, block: B:66:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0086  */
    /* JADX WARN: Code duplicated, block: B:68:0x0089  */
    private static void b(C0333a c0333a, w.a aVar, SparseArray sparseArray, boolean z3, boolean z4) {
        int i3;
        boolean z5;
        boolean z6;
        boolean z7;
        View view;
        boolean z8;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = aVar.f5409b;
        if (abstractComponentCallbacksC0337e == null || (i3 = abstractComponentCallbacksC0337e.f5207x) == 0) {
            return;
        }
        int i4 = z3 ? f5416a[aVar.f5408a] : aVar.f5408a;
        boolean z9 = false;
        boolean z10 = true;
        if (i4 == 1) {
            if (z4) {
                z5 = abstractComponentCallbacksC0337e.f5170M;
            } else if (!abstractComponentCallbacksC0337e.f5195l || abstractComponentCallbacksC0337e.f5209z) {
                z5 = false;
            } else {
                z5 = true;
            }
            z9 = z5;
            z6 = false;
            z7 = false;
        } else if (i4 == 3) {
            if (z4 ? !abstractComponentCallbacksC0337e.f5195l || abstractComponentCallbacksC0337e.f5209z : abstractComponentCallbacksC0337e.f5195l || (view = abstractComponentCallbacksC0337e.f5165H) == null || view.getVisibility() != 0 || abstractComponentCallbacksC0337e.f5172O < 0.0f) {
                z8 = false;
            } else {
                z8 = true;
            }
            z7 = z8;
            z6 = true;
            z10 = false;
        } else if (i4 != 4) {
            if (i4 != 5) {
                if (i4 != 6) {
                    if (i4 != 7) {
                        z6 = false;
                        z10 = false;
                    } else {
                        if (z4) {
                            z5 = abstractComponentCallbacksC0337e.f5170M;
                        } else {
                            if (abstractComponentCallbacksC0337e.f5195l) {
                            }
                            z5 = false;
                        }
                        z9 = z5;
                        z6 = false;
                    }
                }
                if (z4) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                z7 = z8;
                z6 = true;
                z10 = false;
            } else {
                if (!z4) {
                    z5 = abstractComponentCallbacksC0337e.f5209z;
                } else if (abstractComponentCallbacksC0337e.f5171N && !abstractComponentCallbacksC0337e.f5209z && abstractComponentCallbacksC0337e.f5195l) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z9 = z5;
                z6 = false;
            }
            z7 = false;
        } else {
            if (!z4 ? !(!abstractComponentCallbacksC0337e.f5195l || abstractComponentCallbacksC0337e.f5209z) : abstractComponentCallbacksC0337e.f5171N && abstractComponentCallbacksC0337e.f5195l && abstractComponentCallbacksC0337e.f5209z) {
                z8 = false;
            } else {
                z8 = true;
            }
            z7 = z8;
            z6 = true;
            z10 = false;
        }
        h hVarP = (h) sparseArray.get(i3);
        if (z9) {
            hVarP = p(hVarP, sparseArray, i3);
            hVarP.f5453a = abstractComponentCallbacksC0337e;
            hVarP.f5454b = z3;
            hVarP.f5455c = c0333a;
        }
        if (!z4 && z10) {
            if (hVarP != null && hVarP.f5456d == abstractComponentCallbacksC0337e) {
                hVarP.f5456d = null;
            }
            if (!c0333a.f5406r) {
                o oVar = c0333a.f5076t;
                oVar.o0().p(oVar.s(abstractComponentCallbacksC0337e));
                oVar.N0(abstractComponentCallbacksC0337e);
            }
        }
        if (z7 && (hVarP == null || hVarP.f5456d == null)) {
            hVarP = p(hVarP, sparseArray, i3);
            hVarP.f5456d = abstractComponentCallbacksC0337e;
            hVarP.f5457e = z3;
            hVarP.f5458f = c0333a;
        }
        if (z4 || !z6 || hVarP == null || hVarP.f5453a != abstractComponentCallbacksC0337e) {
            return;
        }
        hVarP.f5453a = null;
    }

    public static void c(C0333a c0333a, SparseArray sparseArray, boolean z3) {
        int size = c0333a.f5391c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b(c0333a, (w.a) c0333a.f5391c.get(i3), sparseArray, false, z3);
        }
    }

    private static p046n.a d(int i3, ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        p046n.a aVar = new p046n.a();
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            C0333a c0333a = (C0333a) arrayList.get(i6);
            if (c0333a.z(i3)) {
                boolean zBooleanValue = ((Boolean) arrayList2.get(i6)).booleanValue();
                ArrayList arrayList5 = c0333a.f5404p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = c0333a.f5404p;
                        arrayList4 = c0333a.f5405q;
                    } else {
                        ArrayList arrayList6 = c0333a.f5404p;
                        arrayList3 = c0333a.f5405q;
                        arrayList4 = arrayList6;
                    }
                    for (int i7 = 0; i7 < size; i7++) {
                        String str = (String) arrayList4.get(i7);
                        String str2 = (String) arrayList3.get(i7);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(C0333a c0333a, SparseArray sparseArray, boolean z3) {
        if (c0333a.f5076t.k0().d()) {
            for (int size = c0333a.f5391c.size() - 1; size >= 0; size--) {
                b(c0333a, (w.a) c0333a.f5391c.get(size), sparseArray, true, z3);
            }
        }
    }

    static void f(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2, boolean z3, p046n.a aVar, boolean z4) {
        if (z3) {
            abstractComponentCallbacksC0337e2.w();
        } else {
            abstractComponentCallbacksC0337e.w();
        }
    }

    private static boolean g(E e3, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!e3.e(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    static p046n.a h(E e3, p046n.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5453a;
        View viewU = abstractComponentCallbacksC0337e.U();
        if (aVar.isEmpty() || obj == null || viewU == null) {
            aVar.clear();
            return null;
        }
        p046n.a aVar2 = new p046n.a();
        e3.j(aVar2, viewU);
        C0333a c0333a = hVar.f5455c;
        if (hVar.f5454b) {
            abstractComponentCallbacksC0337e.z();
            arrayList = c0333a.f5404p;
        } else {
            abstractComponentCallbacksC0337e.w();
            arrayList = c0333a.f5405q;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static p046n.a i(E e3, p046n.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5456d;
        p046n.a aVar2 = new p046n.a();
        e3.j(aVar2, abstractComponentCallbacksC0337e.t1());
        C0333a c0333a = hVar.f5458f;
        if (hVar.f5457e) {
            abstractComponentCallbacksC0337e.w();
            arrayList = c0333a.f5405q;
        } else {
            abstractComponentCallbacksC0337e.z();
            arrayList = c0333a.f5404p;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        aVar.o(aVar2.keySet());
        return aVar2;
    }

    private static E j(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2) {
        ArrayList arrayList = new ArrayList();
        if (abstractComponentCallbacksC0337e != null) {
            Object objY = abstractComponentCallbacksC0337e.y();
            if (objY != null) {
                arrayList.add(objY);
            }
            Object objN = abstractComponentCallbacksC0337e.N();
            if (objN != null) {
                arrayList.add(objN);
            }
            Object objP = abstractComponentCallbacksC0337e.P();
            if (objP != null) {
                arrayList.add(objP);
            }
        }
        if (abstractComponentCallbacksC0337e2 != null) {
            Object objV = abstractComponentCallbacksC0337e2.v();
            if (objV != null) {
                arrayList.add(objV);
            }
            Object objL = abstractComponentCallbacksC0337e2.L();
            if (objL != null) {
                arrayList.add(objL);
            }
            Object objO = abstractComponentCallbacksC0337e2.O();
            if (objO != null) {
                arrayList.add(objO);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        E e3 = f5417b;
        if (e3 != null && g(e3, arrayList)) {
            return e3;
        }
        E e4 = f5418c;
        if (e4 != null && g(e4, arrayList)) {
            return e4;
        }
        if (e3 == null && e4 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList k(E e3, Object obj, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View viewU = abstractComponentCallbacksC0337e.U();
        if (viewU != null) {
            e3.f(arrayList2, viewU);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        e3.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(E e3, ViewGroup viewGroup, View view, p046n.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5453a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = hVar.f5456d;
        if (abstractComponentCallbacksC0337e == null || abstractComponentCallbacksC0337e2 == null) {
            return null;
        }
        boolean z3 = hVar.f5454b;
        Object objT = aVar.isEmpty() ? null : t(e3, abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3);
        p046n.a aVarI = i(e3, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            e3.z(obj3, view, arrayList);
            z(e3, obj3, obj2, aVarI, hVar.f5457e, hVar.f5458f);
            if (obj != null) {
                e3.u(obj, rect);
            }
        } else {
            rect = null;
        }
        L.a(viewGroup, new f(e3, aVar, obj3, hVar, arrayList2, view, abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(E e3, ViewGroup viewGroup, View view, p046n.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5453a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = hVar.f5456d;
        if (abstractComponentCallbacksC0337e != null) {
            abstractComponentCallbacksC0337e.t1().setVisibility(0);
        }
        if (abstractComponentCallbacksC0337e == null || abstractComponentCallbacksC0337e2 == null) {
            return null;
        }
        boolean z3 = hVar.f5454b;
        Object objT = aVar.isEmpty() ? null : t(e3, abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3);
        p046n.a aVarI = i(e3, aVar, objT, hVar);
        p046n.a aVarH = h(e3, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            e3.z(obj3, view, arrayList);
            z(e3, obj3, obj2, aVarI, hVar.f5457e, hVar.f5458f);
            Rect rect2 = new Rect();
            View viewS = s(aVarH, hVar, obj, z3);
            if (viewS != null) {
                e3.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewS;
        } else {
            view2 = null;
            rect = null;
        }
        L.a(viewGroup, new e(abstractComponentCallbacksC0337e, abstractComponentCallbacksC0337e2, z3, aVarH, view2, e3, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, p046n.a aVar, g gVar) {
        Object obj;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5453a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = hVar.f5456d;
        E eJ = j(abstractComponentCallbacksC0337e2, abstractComponentCallbacksC0337e);
        if (eJ == null) {
            return;
        }
        boolean z3 = hVar.f5454b;
        boolean z4 = hVar.f5457e;
        Object objQ = q(eJ, abstractComponentCallbacksC0337e, z3);
        Object objR = r(eJ, abstractComponentCallbacksC0337e2, z4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object objL = l(eJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objQ, objR);
        if (objQ == null && objL == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList arrayListK = k(eJ, obj, abstractComponentCallbacksC0337e2, arrayList, view);
        if (arrayListK == null || arrayListK.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        eJ.a(objQ, view);
        Object objU = u(eJ, objQ, obj2, objL, abstractComponentCallbacksC0337e, hVar.f5454b);
        if (abstractComponentCallbacksC0337e2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.h hVar2 = new androidx.core.os.h();
            gVar.b(abstractComponentCallbacksC0337e2, hVar2);
            eJ.w(abstractComponentCallbacksC0337e2, objU, hVar2, new c(gVar, abstractComponentCallbacksC0337e2, hVar2));
        }
        if (objU != null) {
            ArrayList arrayList3 = new ArrayList();
            eJ.t(objU, objQ, arrayList3, obj2, arrayListK, objL, arrayList2);
            y(eJ, viewGroup, abstractComponentCallbacksC0337e, view, arrayList2, objQ, arrayList3, obj2, arrayListK);
            eJ.x(viewGroup, arrayList2, aVar);
            eJ.c(viewGroup, objU);
            eJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, p046n.a aVar, g gVar) {
        Object obj;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e = hVar.f5453a;
        AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2 = hVar.f5456d;
        E eJ = j(abstractComponentCallbacksC0337e2, abstractComponentCallbacksC0337e);
        if (eJ == null) {
            return;
        }
        boolean z3 = hVar.f5454b;
        boolean z4 = hVar.f5457e;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object objQ = q(eJ, abstractComponentCallbacksC0337e, z3);
        Object objR = r(eJ, abstractComponentCallbacksC0337e2, z4);
        Object objM = m(eJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objQ, objR);
        if (objQ == null && objM == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList arrayListK = k(eJ, obj, abstractComponentCallbacksC0337e2, arrayList2, view);
        ArrayList arrayListK2 = k(eJ, objQ, abstractComponentCallbacksC0337e, arrayList, view);
        A(arrayListK2, 4);
        Object objU = u(eJ, objQ, obj, objM, abstractComponentCallbacksC0337e, z3);
        if (abstractComponentCallbacksC0337e2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.h hVar2 = new androidx.core.os.h();
            gVar.b(abstractComponentCallbacksC0337e2, hVar2);
            eJ.w(abstractComponentCallbacksC0337e2, objU, hVar2, new a(gVar, abstractComponentCallbacksC0337e2, hVar2));
        }
        if (objU != null) {
            v(eJ, obj, abstractComponentCallbacksC0337e2, arrayListK);
            ArrayList arrayListO = eJ.o(arrayList);
            eJ.t(objU, objQ, arrayListK2, obj, arrayListK, objM, arrayList);
            eJ.c(viewGroup, objU);
            eJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            A(arrayListK2, 0);
            eJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray sparseArray, int i3) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i3, hVar2);
        return hVar2;
    }

    private static Object q(E e3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        if (abstractComponentCallbacksC0337e == null) {
            return null;
        }
        return e3.g(z3 ? abstractComponentCallbacksC0337e.L() : abstractComponentCallbacksC0337e.v());
    }

    private static Object r(E e3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        if (abstractComponentCallbacksC0337e == null) {
            return null;
        }
        return e3.g(z3 ? abstractComponentCallbacksC0337e.N() : abstractComponentCallbacksC0337e.y());
    }

    static View s(p046n.a aVar, h hVar, Object obj, boolean z3) {
        ArrayList arrayList;
        C0333a c0333a = hVar.f5455c;
        if (obj == null || aVar == null || (arrayList = c0333a.f5404p) == null || arrayList.isEmpty()) {
            return null;
        }
        return (View) aVar.get(z3 ? (String) c0333a.f5404p.get(0) : (String) c0333a.f5405q.get(0));
    }

    private static Object t(E e3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e2, boolean z3) {
        if (abstractComponentCallbacksC0337e == null || abstractComponentCallbacksC0337e2 == null) {
            return null;
        }
        return e3.B(e3.g(z3 ? abstractComponentCallbacksC0337e2.P() : abstractComponentCallbacksC0337e.O()));
    }

    private static Object u(E e3, Object obj, Object obj2, Object obj3, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, boolean z3) {
        boolean zO;
        if (obj == null || obj2 == null || abstractComponentCallbacksC0337e == null) {
            zO = true;
        } else {
            zO = z3 ? abstractComponentCallbacksC0337e.o() : abstractComponentCallbacksC0337e.n();
        }
        return zO ? e3.n(obj2, obj, obj3) : e3.m(obj2, obj, obj3);
    }

    private static void v(E e3, Object obj, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, ArrayList arrayList) {
        if (abstractComponentCallbacksC0337e != null && obj != null && abstractComponentCallbacksC0337e.f5195l && abstractComponentCallbacksC0337e.f5209z && abstractComponentCallbacksC0337e.f5171N) {
            abstractComponentCallbacksC0337e.D1(true);
            e3.r(obj, abstractComponentCallbacksC0337e.U(), arrayList);
            L.a(abstractComponentCallbacksC0337e.f5164G, new b(arrayList));
        }
    }

    private static E w() {
        try {
            return (E) C0379e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(p046n.a aVar, p046n.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void y(E e3, ViewGroup viewGroup, AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        L.a(viewGroup, new d(obj, e3, view, abstractComponentCallbacksC0337e, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(E e3, Object obj, Object obj2, p046n.a aVar, boolean z3, C0333a c0333a) {
        ArrayList arrayList = c0333a.f5404p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = (View) aVar.get(z3 ? (String) c0333a.f5405q.get(0) : (String) c0333a.f5404p.get(0));
        e3.v(obj, view);
        if (obj2 != null) {
            e3.v(obj2, view);
        }
    }
}
