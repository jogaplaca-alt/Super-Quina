package p061s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f11641d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f11643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11644g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f11638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11639b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11640c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f11642e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f11645h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    g f11646i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11647j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List f11648k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List f11649l = new ArrayList();

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f11641d = pVar;
    }

    @Override // p061s.d
    public void a(d dVar) {
        Iterator it = this.f11649l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f11647j) {
                return;
            }
        }
        this.f11640c = true;
        d dVar2 = this.f11638a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f11639b) {
            this.f11641d.a(this);
            return;
        }
        f fVar = null;
        int i3 = 0;
        for (f fVar2 : this.f11649l) {
            if (!(fVar2 instanceof g)) {
                i3++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i3 == 1 && fVar.f11647j) {
            g gVar = this.f11646i;
            if (gVar != null) {
                if (!gVar.f11647j) {
                    return;
                } else {
                    this.f11643f = this.f11645h * gVar.f11644g;
                }
            }
            d(fVar.f11644g + this.f11643f);
        }
        d dVar3 = this.f11638a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f11648k.add(dVar);
        if (this.f11647j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f11649l.clear();
        this.f11648k.clear();
        this.f11647j = false;
        this.f11644g = 0;
        this.f11640c = false;
        this.f11639b = false;
    }

    public void d(int i3) {
        if (this.f11647j) {
            return;
        }
        this.f11647j = true;
        this.f11644g = i3;
        for (d dVar : this.f11648k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11641d.f11692b.t());
        sb.append(":");
        sb.append(this.f11642e);
        sb.append("(");
        sb.append(this.f11647j ? Integer.valueOf(this.f11644g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f11649l.size());
        sb.append(":d=");
        sb.append(this.f11648k.size());
        sb.append(">");
        return sb.toString();
    }
}
