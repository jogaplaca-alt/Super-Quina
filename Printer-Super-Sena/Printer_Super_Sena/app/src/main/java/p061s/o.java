package p061s;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p049o.d;
import p058r.b;
import p058r.e;
import p058r.f;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f11676g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f11678b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f11680d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f11677a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f11679c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f11681e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11682f = -1;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference f11683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f11685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f11686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f11687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f11689g;

        public a(e eVar, d dVar, int i3) {
            this.f11683a = new WeakReference(eVar);
            this.f11684b = dVar.x(eVar.f10662O);
            this.f11685c = dVar.x(eVar.f10663P);
            this.f11686d = dVar.x(eVar.f10664Q);
            this.f11687e = dVar.x(eVar.f10665R);
            this.f11688f = dVar.x(eVar.f10666S);
            this.f11689g = i3;
        }
    }

    public o(int i3) {
        int i4 = f11676g;
        f11676g = i4 + 1;
        this.f11678b = i4;
        this.f11680d = i3;
    }

    private String e() {
        int i3 = this.f11680d;
        if (i3 == 0) {
            return "Horizontal";
        }
        if (i3 == 1) {
            return "Vertical";
        }
        return i3 == 2 ? "Both" : "Unknown";
    }

    private int j(d dVar, ArrayList arrayList, int i3) {
        int iX;
        int iX2;
        f fVar = (f) ((e) arrayList.get(0)).K();
        dVar.D();
        fVar.g(dVar, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((e) arrayList.get(i4)).g(dVar, false);
        }
        if (i3 == 0 && fVar.f10743W0 > 0) {
            b.b(fVar, dVar, arrayList, 0);
        }
        if (i3 == 1 && fVar.f10744X0 > 0) {
            b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f11681e = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f11681e.add(new a((e) arrayList.get(i5), dVar, i3));
        }
        if (i3 == 0) {
            iX = dVar.x(fVar.f10662O);
            iX2 = dVar.x(fVar.f10664Q);
            dVar.D();
        } else {
            iX = dVar.x(fVar.f10663P);
            iX2 = dVar.x(fVar.f10665R);
            dVar.D();
        }
        return iX2 - iX;
    }

    public boolean a(e eVar) {
        if (this.f11677a.contains(eVar)) {
            return false;
        }
        this.f11677a.add(eVar);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f11677a.size();
        if (this.f11682f != -1 && size > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                o oVar = (o) arrayList.get(i3);
                if (this.f11682f == oVar.f11678b) {
                    g(this.f11680d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f11678b;
    }

    public int d() {
        return this.f11680d;
    }

    public int f(d dVar, int i3) {
        if (this.f11677a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f11677a, i3);
    }

    public void g(int i3, o oVar) {
        for (e eVar : this.f11677a) {
            oVar.a(eVar);
            if (i3 == 0) {
                eVar.f10655I0 = oVar.c();
            } else {
                eVar.f10657J0 = oVar.c();
            }
        }
        this.f11682f = oVar.f11678b;
    }

    public void h(boolean z3) {
        this.f11679c = z3;
    }

    public void i(int i3) {
        this.f11680d = i3;
    }

    public String toString() {
        String str = e() + " [" + this.f11678b + "] <";
        Iterator it = this.f11677a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((e) it.next()).t();
        }
        return str + " >";
    }
}
