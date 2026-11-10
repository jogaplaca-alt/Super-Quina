package p049o;

import java.util.Arrays;
import java.util.HashMap;
import p058r.e;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f10260r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f10261s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f10262t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f10263u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f10264v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f10265w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f10266x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f10267y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f10271d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    p049o.b[] f10274g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final c f10281n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f10284q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10268a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f10269b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f10270c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10272e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10273f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10275h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10276i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean[] f10277j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f10278k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f10279l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10280m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i[] f10282o = new i[f10265w];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10283p = 0;

    interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    class b extends p049o.b {
        public b(c cVar) {
            this.f10254e = new j(this, cVar);
        }
    }

    public d() {
        this.f10274g = null;
        this.f10274g = new p049o.b[32];
        C();
        c cVar = new c();
        this.f10281n = cVar;
        this.f10271d = new h(cVar);
        if (f10264v) {
            this.f10284q = new b(cVar);
        } else {
            this.f10284q = new p049o.b(cVar);
        }
    }

    private final int B(a aVar, boolean z3) {
        for (int i3 = 0; i3 < this.f10278k; i3++) {
            this.f10277j[i3] = false;
        }
        boolean z4 = false;
        int i4 = 0;
        while (!z4) {
            i4++;
            if (i4 >= this.f10278k * 2) {
                return i4;
            }
            if (aVar.getKey() != null) {
                this.f10277j[aVar.getKey().f10301c] = true;
            }
            i iVarB = aVar.b(this, this.f10277j);
            if (iVarB != null) {
                boolean[] zArr = this.f10277j;
                int i5 = iVarB.f10301c;
                if (zArr[i5]) {
                    return i4;
                }
                zArr[i5] = true;
            }
            if (iVarB != null) {
                float f3 = Float.MAX_VALUE;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f10279l; i7++) {
                    p049o.b bVar = this.f10274g[i7];
                    if (bVar.f10250a.f10308j != i.a.UNRESTRICTED && !bVar.f10255f && bVar.t(iVarB)) {
                        float f4 = bVar.f10254e.f(iVarB);
                        if (f4 < 0.0f) {
                            float f5 = (-bVar.f10251b) / f4;
                            if (f5 < f3) {
                                i6 = i7;
                                f3 = f5;
                            }
                        }
                    }
                }
                if (i6 > -1) {
                    p049o.b bVar2 = this.f10274g[i6];
                    bVar2.f10250a.f10302d = -1;
                    bVar2.x(iVarB);
                    i iVar = bVar2.f10250a;
                    iVar.f10302d = i6;
                    iVar.h(this, bVar2);
                }
            } else {
                z4 = true;
            }
        }
        return i4;
    }

    private void C() {
        int i3 = 0;
        if (f10264v) {
            while (i3 < this.f10279l) {
                p049o.b bVar = this.f10274g[i3];
                if (bVar != null) {
                    this.f10281n.f10256a.a(bVar);
                }
                this.f10274g[i3] = null;
                i3++;
            }
            return;
        }
        while (i3 < this.f10279l) {
            p049o.b bVar2 = this.f10274g[i3];
            if (bVar2 != null) {
                this.f10281n.f10257b.a(bVar2);
            }
            this.f10274g[i3] = null;
            i3++;
        }
    }

    private i a(i.a aVar, String str) {
        i iVar = (i) this.f10281n.f10258c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.g(aVar, str);
        } else {
            iVar.e();
            iVar.g(aVar, str);
        }
        int i3 = this.f10283p;
        int i4 = f10265w;
        if (i3 >= i4) {
            int i5 = i4 * 2;
            f10265w = i5;
            this.f10282o = (i[]) Arrays.copyOf(this.f10282o, i5);
        }
        i[] iVarArr = this.f10282o;
        int i6 = this.f10283p;
        this.f10283p = i6 + 1;
        iVarArr[i6] = iVar;
        return iVar;
    }

    private final void l(p049o.b bVar) {
        int i3;
        if (f10262t && bVar.f10255f) {
            bVar.f10250a.f(this, bVar.f10251b);
        } else {
            p049o.b[] bVarArr = this.f10274g;
            int i4 = this.f10279l;
            bVarArr[i4] = bVar;
            i iVar = bVar.f10250a;
            iVar.f10302d = i4;
            this.f10279l = i4 + 1;
            iVar.h(this, bVar);
        }
        if (f10262t && this.f10268a) {
            int i5 = 0;
            while (i5 < this.f10279l) {
                if (this.f10274g[i5] == null) {
                    System.out.println("WTF");
                }
                p049o.b bVar2 = this.f10274g[i5];
                if (bVar2 != null && bVar2.f10255f) {
                    bVar2.f10250a.f(this, bVar2.f10251b);
                    if (f10264v) {
                        this.f10281n.f10256a.a(bVar2);
                    } else {
                        this.f10281n.f10257b.a(bVar2);
                    }
                    this.f10274g[i5] = null;
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (true) {
                        i3 = this.f10279l;
                        if (i6 >= i3) {
                            break;
                        }
                        p049o.b[] bVarArr2 = this.f10274g;
                        int i8 = i6 - 1;
                        p049o.b bVar3 = bVarArr2[i6];
                        bVarArr2[i8] = bVar3;
                        i iVar2 = bVar3.f10250a;
                        if (iVar2.f10302d == i6) {
                            iVar2.f10302d = i8;
                        }
                        i7 = i6;
                        i6++;
                    }
                    if (i7 < i3) {
                        this.f10274g[i7] = null;
                    }
                    this.f10279l = i3 - 1;
                    i5--;
                }
                i5++;
            }
            this.f10268a = false;
        }
    }

    private void n() {
        for (int i3 = 0; i3 < this.f10279l; i3++) {
            p049o.b bVar = this.f10274g[i3];
            bVar.f10250a.f10304f = bVar.f10251b;
        }
    }

    public static p049o.b s(d dVar, i iVar, i iVar2, float f3) {
        return dVar.r().j(iVar, iVar2, f3);
    }

    private int u(a aVar) {
        for (int i3 = 0; i3 < this.f10279l; i3++) {
            p049o.b bVar = this.f10274g[i3];
            if (bVar.f10250a.f10308j != i.a.UNRESTRICTED && bVar.f10251b < 0.0f) {
                boolean z3 = false;
                int i4 = 0;
                while (!z3) {
                    i4++;
                    float f3 = Float.MAX_VALUE;
                    int i5 = 0;
                    int i6 = -1;
                    int i7 = -1;
                    int i8 = 0;
                    while (true) {
                        if (i5 >= this.f10279l) {
                            break;
                        }
                        p049o.b bVar2 = this.f10274g[i5];
                        if (bVar2.f10250a.f10308j != i.a.UNRESTRICTED && !bVar2.f10255f && bVar2.f10251b < 0.0f) {
                            int i9 = 9;
                            if (f10263u) {
                                int iK = bVar2.f10254e.k();
                                int i10 = 0;
                                while (i10 < iK) {
                                    i iVarG = bVar2.f10254e.g(i10);
                                    float f4 = bVar2.f10254e.f(iVarG);
                                    if (f4 > 0.0f) {
                                        int i11 = 0;
                                        while (i11 < i9) {
                                            float f5 = iVarG.f10306h[i11] / f4;
                                            if ((f5 < f3 && i11 == i8) || i11 > i8) {
                                                i8 = i11;
                                                i7 = iVarG.f10301c;
                                                i6 = i5;
                                                f3 = f5;
                                            }
                                            i11++;
                                            i9 = 9;
                                        }
                                    }
                                    i10++;
                                    i9 = 9;
                                }
                            } else {
                                for (int i12 = 1; i12 < this.f10278k; i12++) {
                                    i iVar = this.f10281n.f10259d[i12];
                                    float f6 = bVar2.f10254e.f(iVar);
                                    if (f6 > 0.0f) {
                                        for (int i13 = 0; i13 < 9; i13++) {
                                            float f7 = iVar.f10306h[i13] / f6;
                                            if ((f7 < f3 && i13 == i8) || i13 > i8) {
                                                i6 = i5;
                                                i7 = i12;
                                                i8 = i13;
                                                f3 = f7;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i5++;
                    }
                    if (i6 != -1) {
                        p049o.b bVar3 = this.f10274g[i6];
                        bVar3.f10250a.f10302d = -1;
                        bVar3.x(this.f10281n.f10259d[i7]);
                        i iVar2 = bVar3.f10250a;
                        iVar2.f10302d = i6;
                        iVar2.h(this, bVar3);
                    } else {
                        z3 = true;
                    }
                    if (i4 > this.f10278k / 2) {
                        z3 = true;
                    }
                }
                return i4;
            }
        }
        return 0;
    }

    public static e w() {
        return null;
    }

    private void y() {
        int i3 = this.f10272e * 2;
        this.f10272e = i3;
        this.f10274g = (p049o.b[]) Arrays.copyOf(this.f10274g, i3);
        c cVar = this.f10281n;
        cVar.f10259d = (i[]) Arrays.copyOf(cVar.f10259d, this.f10272e);
        int i4 = this.f10272e;
        this.f10277j = new boolean[i4];
        this.f10273f = i4;
        this.f10280m = i4;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i3 = 0;
        while (true) {
            cVar = this.f10281n;
            i[] iVarArr = cVar.f10259d;
            if (i3 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i3];
            if (iVar != null) {
                iVar.e();
            }
            i3++;
        }
        cVar.f10258c.c(this.f10282o, this.f10283p);
        this.f10283p = 0;
        Arrays.fill(this.f10281n.f10259d, (Object) null);
        HashMap map = this.f10270c;
        if (map != null) {
            map.clear();
        }
        this.f10269b = 0;
        this.f10271d.clear();
        this.f10278k = 1;
        for (int i4 = 0; i4 < this.f10279l; i4++) {
            p049o.b bVar = this.f10274g[i4];
            if (bVar != null) {
                bVar.f10252c = false;
            }
        }
        C();
        this.f10279l = 0;
        if (f10264v) {
            this.f10284q = new b(this.f10281n);
        } else {
            this.f10284q = new p049o.b(this.f10281n);
        }
    }

    public void b(e eVar, e eVar2, float f3, int i3) {
        r.d.b bVar = r.d.b.LEFT;
        i iVarQ = q(eVar.o(bVar));
        r.d.b bVar2 = r.d.b.TOP;
        i iVarQ2 = q(eVar.o(bVar2));
        r.d.b bVar3 = r.d.b.RIGHT;
        i iVarQ3 = q(eVar.o(bVar3));
        r.d.b bVar4 = r.d.b.BOTTOM;
        i iVarQ4 = q(eVar.o(bVar4));
        i iVarQ5 = q(eVar2.o(bVar));
        i iVarQ6 = q(eVar2.o(bVar2));
        i iVarQ7 = q(eVar2.o(bVar3));
        i iVarQ8 = q(eVar2.o(bVar4));
        p049o.b bVarR = r();
        double d3 = f3;
        double dSin = Math.sin(d3);
        double d4 = i3;
        Double.isNaN(d4);
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (dSin * d4));
        d(bVarR);
        p049o.b bVarR2 = r();
        double dCos = Math.cos(d3);
        Double.isNaN(d4);
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (dCos * d4));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i3, float f3, i iVar3, i iVar4, int i4, int i5) {
        p049o.b bVarR = r();
        bVarR.h(iVar, iVar2, i3, f3, iVar3, iVar4, i4);
        if (i5 != 8) {
            bVarR.d(this, i5);
        }
        d(bVarR);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007b  */
    public void d(p049o.b bVar) {
        i iVarV;
        if (bVar == null) {
            return;
        }
        boolean z3 = true;
        if (this.f10279l + 1 >= this.f10280m || this.f10278k + 1 >= this.f10273f) {
            y();
        }
        boolean z4 = false;
        if (!bVar.f10255f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i iVarP = p();
                bVar.f10250a = iVarP;
                int i3 = this.f10279l;
                l(bVar);
                if (this.f10279l == i3 + 1) {
                    this.f10284q.c(bVar);
                    B(this.f10284q, true);
                    if (iVarP.f10302d == -1) {
                        if (bVar.f10250a == iVarP && (iVarV = bVar.v(iVarP)) != null) {
                            bVar.x(iVarV);
                        }
                        if (!bVar.f10255f) {
                            bVar.f10250a.h(this, bVar);
                        }
                        if (f10264v) {
                            this.f10281n.f10256a.a(bVar);
                        } else {
                            this.f10281n.f10257b.a(bVar);
                        }
                        this.f10279l--;
                    }
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z4 = z3;
            }
        }
        if (z4) {
            return;
        }
        l(bVar);
    }

    public p049o.b e(i iVar, i iVar2, int i3, int i4) {
        if (f10261s && i4 == 8 && iVar2.f10305g && iVar.f10302d == -1) {
            iVar.f(this, iVar2.f10304f + i3);
            return null;
        }
        p049o.b bVarR = r();
        bVarR.n(iVar, iVar2, i3);
        if (i4 != 8) {
            bVarR.d(this, i4);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i3) {
        if (f10261s && iVar.f10302d == -1) {
            float f3 = i3;
            iVar.f(this, f3);
            for (int i4 = 0; i4 < this.f10269b + 1; i4++) {
                i iVar2 = this.f10281n.f10259d[i4];
                if (iVar2 != null && iVar2.f10312n && iVar2.f10313o == iVar.f10301c) {
                    iVar2.f(this, iVar2.f10314p + f3);
                }
            }
            return;
        }
        int i5 = iVar.f10302d;
        if (i5 == -1) {
            p049o.b bVarR = r();
            bVarR.i(iVar, i3);
            d(bVarR);
            return;
        }
        p049o.b bVar = this.f10274g[i5];
        if (bVar.f10255f) {
            bVar.f10251b = i3;
            return;
        }
        if (bVar.f10254e.k() == 0) {
            bVar.f10255f = true;
            bVar.f10251b = i3;
        } else {
            p049o.b bVarR2 = r();
            bVarR2.m(iVar, i3);
            d(bVarR2);
        }
    }

    public void g(i iVar, i iVar2, int i3, boolean z3) {
        p049o.b bVarR = r();
        i iVarT = t();
        iVarT.f10303e = 0;
        bVarR.o(iVar, iVar2, iVarT, i3);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i3, int i4) {
        p049o.b bVarR = r();
        i iVarT = t();
        iVarT.f10303e = 0;
        bVarR.o(iVar, iVar2, iVarT, i3);
        if (i4 != 8) {
            m(bVarR, (int) (bVarR.f10254e.f(iVarT) * (-1.0f)), i4);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i3, boolean z3) {
        p049o.b bVarR = r();
        i iVarT = t();
        iVarT.f10303e = 0;
        bVarR.p(iVar, iVar2, iVarT, i3);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i3, int i4) {
        p049o.b bVarR = r();
        i iVarT = t();
        iVarT.f10303e = 0;
        bVarR.p(iVar, iVar2, iVarT, i3);
        if (i4 != 8) {
            m(bVarR, (int) (bVarR.f10254e.f(iVarT) * (-1.0f)), i4);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f3, int i3) {
        p049o.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f3);
        if (i3 != 8) {
            bVarR.d(this, i3);
        }
        d(bVarR);
    }

    void m(p049o.b bVar, int i3, int i4) {
        bVar.e(o(i4, null), i3);
    }

    public i o(int i3, String str) {
        if (this.f10278k + 1 >= this.f10273f) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i4 = this.f10269b + 1;
        this.f10269b = i4;
        this.f10278k++;
        iVarA.f10301c = i4;
        iVarA.f10303e = i3;
        this.f10281n.f10259d[i4] = iVarA;
        this.f10271d.a(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f10278k + 1 >= this.f10273f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i3 = this.f10269b + 1;
        this.f10269b = i3;
        this.f10278k++;
        iVarA.f10301c = i3;
        this.f10281n.f10259d[i3] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarI = null;
        if (obj == null) {
            return null;
        }
        if (this.f10278k + 1 >= this.f10273f) {
            y();
        }
        if (obj instanceof p058r.d) {
            p058r.d dVar = (p058r.d) obj;
            iVarI = dVar.i();
            if (iVarI == null) {
                dVar.s(this.f10281n);
                iVarI = dVar.i();
            }
            int i3 = iVarI.f10301c;
            if (i3 == -1 || i3 > this.f10269b || this.f10281n.f10259d[i3] == null) {
                if (i3 != -1) {
                    iVarI.e();
                }
                int i4 = this.f10269b + 1;
                this.f10269b = i4;
                this.f10278k++;
                iVarI.f10301c = i4;
                iVarI.f10308j = i.a.UNRESTRICTED;
                this.f10281n.f10259d[i4] = iVarI;
            }
        }
        return iVarI;
    }

    public p049o.b r() {
        p049o.b bVar;
        if (f10264v) {
            bVar = (p049o.b) this.f10281n.f10256a.b();
            if (bVar == null) {
                bVar = new b(this.f10281n);
                f10267y++;
            } else {
                bVar.y();
            }
        } else {
            bVar = (p049o.b) this.f10281n.f10257b.b();
            if (bVar == null) {
                bVar = new p049o.b(this.f10281n);
                f10266x++;
            } else {
                bVar.y();
            }
        }
        i.c();
        return bVar;
    }

    public i t() {
        if (this.f10278k + 1 >= this.f10273f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i3 = this.f10269b + 1;
        this.f10269b = i3;
        this.f10278k++;
        iVarA.f10301c = i3;
        this.f10281n.f10259d[i3] = iVarA;
        return iVarA;
    }

    public c v() {
        return this.f10281n;
    }

    public int x(Object obj) {
        i iVarI = ((p058r.d) obj).i();
        if (iVarI != null) {
            return (int) (iVarI.f10304f + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.f10271d.isEmpty()) {
            n();
            return;
        }
        if (!this.f10275h && !this.f10276i) {
            A(this.f10271d);
            return;
        }
        for (int i3 = 0; i3 < this.f10279l; i3++) {
            if (!this.f10274g[i3].f10255f) {
                A(this.f10271d);
                return;
            }
        }
        n();
    }
}
