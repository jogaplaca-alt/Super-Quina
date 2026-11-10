package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AbstractC0291e0;
import androidx.core.view.L;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f5025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f5026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f5027d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5028e;

        a(int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f5024a = i3;
            this.f5025b = arrayList;
            this.f5026c = arrayList2;
            this.f5027d = arrayList3;
            this.f5028e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < this.f5024a; i3++) {
                Z.J0((View) this.f5025b.get(i3), (String) this.f5026c.get(i3));
                Z.J0((View) this.f5027d.get(i3), (String) this.f5028e.get(i3));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f5031b;

        b(ArrayList arrayList, Map map) {
            this.f5030a = arrayList;
            this.f5031b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5030a.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f5030a.get(i3);
                String strL = Z.L(view);
                if (strL != null) {
                    Z.J0(view, E.i(this.f5031b, strL));
                }
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f5034b;

        c(ArrayList arrayList, Map map) {
            this.f5033a = arrayList;
            this.f5034b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5033a.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f5033a.get(i3);
                Z.J0(view, (String) this.f5034b.get(Z.L(view)));
            }
        }
    }

    protected static void d(List list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (Z.L(view) != null) {
            list.add(view);
        }
        for (int i3 = size; i3 < list.size(); i3++) {
            View view2 = (View) list.get(i3);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (!h(list, childAt, size) && Z.L(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List list, View view, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (list.get(i4) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (AbstractC0291e0.b(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                f(arrayList, viewGroup.getChildAt(i3));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String strL = Z.L(view);
            if (strL != null) {
                map.put(strL, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    j(map, viewGroup.getChildAt(i3));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        if (Z.T(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            arrayList2.add(Z.L(view));
            Z.J0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        L.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public abstract void w(AbstractComponentCallbacksC0337e abstractComponentCallbacksC0337e, Object obj, androidx.core.os.h hVar, Runnable runnable);

    void x(View view, ArrayList arrayList, Map map) {
        L.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) arrayList.get(i3);
            String strL = Z.L(view2);
            arrayList4.add(strL);
            if (strL != null) {
                Z.J0(view2, null);
                String str = (String) map.get(strL);
                for (int i4 = 0; i4 < size; i4++) {
                    if (str.equals(arrayList3.get(i4))) {
                        Z.J0((View) arrayList2.get(i4), strL);
                        break;
                    }
                }
            }
        }
        L.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);
}
