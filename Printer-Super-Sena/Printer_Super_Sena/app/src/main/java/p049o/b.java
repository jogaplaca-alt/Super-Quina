package p049o;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f10254e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i f10250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f10251b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10252c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f10253d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f10255f = false;

    public interface a {
        float a(int i3);

        void b(i iVar, float f3, boolean z3);

        boolean c(i iVar);

        void clear();

        float d(b bVar, boolean z3);

        void e(i iVar, float f3);

        float f(i iVar);

        i g(int i3);

        void h(float f3);

        float i(i iVar, boolean z3);

        void j();

        int k();
    }

    public b() {
    }

    private boolean u(i iVar, d dVar) {
        return iVar.f10311m <= 1;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int iK = this.f10254e.k();
        i iVar2 = null;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < iK; i3++) {
            float fA = this.f10254e.a(i3);
            if (fA < 0.0f) {
                i iVarG = this.f10254e.g(i3);
                if ((zArr == null || !zArr[iVarG.f10301c]) && iVarG != iVar && (((aVar = iVarG.f10308j) == i.a.SLACK || aVar == i.a.ERROR) && fA < f3)) {
                    f3 = fA;
                    iVar2 = iVarG;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z3) {
        if (iVar == null || !iVar.f10305g) {
            return;
        }
        this.f10251b += iVar.f10304f * this.f10254e.f(iVar);
        this.f10254e.i(iVar, z3);
        if (z3) {
            iVar.d(this);
        }
        if (d.f10262t && this.f10254e.k() == 0) {
            this.f10255f = true;
            dVar.f10268a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z3) {
        this.f10251b += bVar.f10251b * this.f10254e.d(bVar, z3);
        if (z3) {
            bVar.f10250a.d(this);
        }
        if (d.f10262t && this.f10250a != null && this.f10254e.k() == 0) {
            this.f10255f = true;
            dVar.f10268a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z3) {
        if (iVar == null || !iVar.f10312n) {
            return;
        }
        float f3 = this.f10254e.f(iVar);
        this.f10251b += iVar.f10314p * f3;
        this.f10254e.i(iVar, z3);
        if (z3) {
            iVar.d(this);
        }
        this.f10254e.b(dVar.f10281n.f10259d[iVar.f10313o], f3, z3);
        if (d.f10262t && this.f10254e.k() == 0) {
            this.f10255f = true;
            dVar.f10268a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f10274g.length == 0) {
            return;
        }
        boolean z3 = false;
        while (!z3) {
            int iK = this.f10254e.k();
            for (int i3 = 0; i3 < iK; i3++) {
                i iVarG = this.f10254e.g(i3);
                if (iVarG.f10302d != -1 || iVarG.f10305g || iVarG.f10312n) {
                    this.f10253d.add(iVarG);
                }
            }
            int size = this.f10253d.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    i iVar = (i) this.f10253d.get(i4);
                    if (iVar.f10305g) {
                        A(dVar, iVar, true);
                    } else if (iVar.f10312n) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f10274g[iVar.f10302d], true);
                    }
                }
                this.f10253d.clear();
            } else {
                z3 = true;
            }
        }
        if (d.f10262t && this.f10250a != null && this.f10254e.k() == 0) {
            this.f10255f = true;
            dVar.f10268a = true;
        }
    }

    @Override // o.d.a
    public void a(i iVar) {
        int i3 = iVar.f10303e;
        float f3 = 1.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f3 = 1000.0f;
            } else if (i3 == 3) {
                f3 = 1000000.0f;
            } else if (i3 == 4) {
                f3 = 1.0E9f;
            } else if (i3 == 5) {
                f3 = 1.0E12f;
            }
        }
        this.f10254e.e(iVar, f3);
    }

    @Override // o.d.a
    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // o.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f10250a = null;
            this.f10254e.clear();
            for (int i3 = 0; i3 < bVar.f10254e.k(); i3++) {
                this.f10254e.b(bVar.f10254e.g(i3), bVar.f10254e.a(i3), true);
            }
        }
    }

    @Override // o.d.a
    public void clear() {
        this.f10254e.clear();
        this.f10250a = null;
        this.f10251b = 0.0f;
    }

    public b d(d dVar, int i3) {
        this.f10254e.e(dVar.o(i3, "ep"), 1.0f);
        this.f10254e.e(dVar.o(i3, "em"), -1.0f);
        return this;
    }

    b e(i iVar, int i3) {
        this.f10254e.e(iVar, i3);
        return this;
    }

    boolean f(d dVar) {
        boolean z3;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z3 = true;
        } else {
            x(iVarG);
            z3 = false;
        }
        if (this.f10254e.k() == 0) {
            this.f10255f = true;
        }
        return z3;
    }

    i g(d dVar) {
        int iK = this.f10254e.k();
        i iVar = null;
        i iVar2 = null;
        boolean z3 = false;
        boolean z4 = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i3 = 0; i3 < iK; i3++) {
            float fA = this.f10254e.a(i3);
            i iVarG = this.f10254e.g(i3);
            if (iVarG.f10308j == i.a.UNRESTRICTED) {
                if (iVar == null || f3 > fA) {
                    boolean zU = u(iVarG, dVar);
                    z3 = zU;
                    f3 = fA;
                    iVar = iVarG;
                } else if (!z3 && u(iVarG, dVar)) {
                    f3 = fA;
                    iVar = iVarG;
                    z3 = true;
                }
            } else if (iVar == null && fA < 0.0f) {
                if (iVar2 == null || f4 > fA) {
                    boolean zU2 = u(iVarG, dVar);
                    z4 = zU2;
                    f4 = fA;
                    iVar2 = iVarG;
                } else if (!z4 && u(iVarG, dVar)) {
                    f4 = fA;
                    iVar2 = iVarG;
                    z4 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // o.d.a
    public i getKey() {
        return this.f10250a;
    }

    b h(i iVar, i iVar2, int i3, float f3, i iVar3, i iVar4, int i4) {
        if (iVar2 == iVar3) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar4, 1.0f);
            this.f10254e.e(iVar2, -2.0f);
            return this;
        }
        if (f3 == 0.5f) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
            this.f10254e.e(iVar3, -1.0f);
            this.f10254e.e(iVar4, 1.0f);
            if (i3 > 0 || i4 > 0) {
                this.f10251b = (-i3) + i4;
            }
        } else if (f3 <= 0.0f) {
            this.f10254e.e(iVar, -1.0f);
            this.f10254e.e(iVar2, 1.0f);
            this.f10251b = i3;
        } else if (f3 >= 1.0f) {
            this.f10254e.e(iVar4, -1.0f);
            this.f10254e.e(iVar3, 1.0f);
            this.f10251b = -i4;
        } else {
            float f4 = 1.0f - f3;
            this.f10254e.e(iVar, f4 * 1.0f);
            this.f10254e.e(iVar2, f4 * (-1.0f));
            this.f10254e.e(iVar3, (-1.0f) * f3);
            this.f10254e.e(iVar4, 1.0f * f3);
            if (i3 > 0 || i4 > 0) {
                this.f10251b = ((-i3) * f4) + (i4 * f3);
            }
        }
        return this;
    }

    b i(i iVar, int i3) {
        this.f10250a = iVar;
        float f3 = i3;
        iVar.f10304f = f3;
        this.f10251b = f3;
        this.f10255f = true;
        return this;
    }

    @Override // o.d.a
    public boolean isEmpty() {
        return this.f10250a == null && this.f10251b == 0.0f && this.f10254e.k() == 0;
    }

    b j(i iVar, i iVar2, float f3) {
        this.f10254e.e(iVar, -1.0f);
        this.f10254e.e(iVar2, f3);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f3) {
        this.f10254e.e(iVar, -1.0f);
        this.f10254e.e(iVar2, 1.0f);
        this.f10254e.e(iVar3, f3);
        this.f10254e.e(iVar4, -f3);
        return this;
    }

    public b l(float f3, float f4, float f5, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f10251b = 0.0f;
        if (f4 == 0.0f || f3 == f5) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
            this.f10254e.e(iVar4, 1.0f);
            this.f10254e.e(iVar3, -1.0f);
        } else if (f3 == 0.0f) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
        } else if (f5 == 0.0f) {
            this.f10254e.e(iVar3, 1.0f);
            this.f10254e.e(iVar4, -1.0f);
        } else {
            float f6 = (f3 / f4) / (f5 / f4);
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
            this.f10254e.e(iVar4, f6);
            this.f10254e.e(iVar3, -f6);
        }
        return this;
    }

    public b m(i iVar, int i3) {
        if (i3 < 0) {
            this.f10251b = i3 * (-1);
            this.f10254e.e(iVar, 1.0f);
        } else {
            this.f10251b = i3;
            this.f10254e.e(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f10251b = i3;
        }
        if (z3) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
        } else {
            this.f10254e.e(iVar, -1.0f);
            this.f10254e.e(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f10251b = i3;
        }
        if (z3) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
            this.f10254e.e(iVar3, -1.0f);
        } else {
            this.f10254e.e(iVar, -1.0f);
            this.f10254e.e(iVar2, 1.0f);
            this.f10254e.e(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f10251b = i3;
        }
        if (z3) {
            this.f10254e.e(iVar, 1.0f);
            this.f10254e.e(iVar2, -1.0f);
            this.f10254e.e(iVar3, 1.0f);
        } else {
            this.f10254e.e(iVar, -1.0f);
            this.f10254e.e(iVar2, 1.0f);
            this.f10254e.e(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f3) {
        this.f10254e.e(iVar3, 0.5f);
        this.f10254e.e(iVar4, 0.5f);
        this.f10254e.e(iVar, -0.5f);
        this.f10254e.e(iVar2, -0.5f);
        this.f10251b = -f3;
        return this;
    }

    void r() {
        float f3 = this.f10251b;
        if (f3 < 0.0f) {
            this.f10251b = f3 * (-1.0f);
            this.f10254e.j();
        }
    }

    boolean s() {
        i iVar = this.f10250a;
        return iVar != null && (iVar.f10308j == i.a.UNRESTRICTED || this.f10251b >= 0.0f);
    }

    boolean t(i iVar) {
        return this.f10254e.c(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    void x(i iVar) {
        i iVar2 = this.f10250a;
        if (iVar2 != null) {
            this.f10254e.e(iVar2, -1.0f);
            this.f10250a.f10302d = -1;
            this.f10250a = null;
        }
        float fI = this.f10254e.i(iVar, true) * (-1.0f);
        this.f10250a = iVar;
        if (fI == 1.0f) {
            return;
        }
        this.f10251b /= fI;
        this.f10254e.h(fI);
    }

    public void y() {
        this.f10250a = null;
        this.f10254e.clear();
        this.f10251b = 0.0f;
        this.f10255f = false;
    }

    String z() {
        boolean z3;
        String str = (this.f10250a == null ? "0" : "" + this.f10250a) + " = ";
        if (this.f10251b != 0.0f) {
            str = str + this.f10251b;
            z3 = true;
        } else {
            z3 = false;
        }
        int iK = this.f10254e.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = this.f10254e.g(i3);
            if (iVarG != null) {
                float fA = this.f10254e.a(i3);
                if (fA != 0.0f) {
                    String string = iVarG.toString();
                    if (z3) {
                        if (fA > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fA *= -1.0f;
                        }
                    } else if (fA < 0.0f) {
                        str = str + "- ";
                        fA *= -1.0f;
                    }
                    str = fA == 1.0f ? str + string : str + fA + " " + string;
                    z3 = true;
                }
            }
        }
        if (z3) {
            return str;
        }
        return str + "0.0";
    }

    public b(c cVar) {
        this.f10254e = new p049o.a(this, cVar);
    }
}
