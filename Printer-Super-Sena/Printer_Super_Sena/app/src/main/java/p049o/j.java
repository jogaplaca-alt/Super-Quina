package p049o;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static float f10322n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10323a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10324b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10325c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f10326d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f10327e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f10328f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float[] f10329g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f10330h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f10331i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f10332j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f10333k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f10334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final c f10335m;

    j(b bVar, c cVar) {
        this.f10334l = bVar;
        this.f10335m = cVar;
        clear();
    }

    private void l(i iVar, int i3) {
        int[] iArr;
        int i4 = iVar.f10301c % this.f10325c;
        int[] iArr2 = this.f10326d;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            iArr2[i4] = i3;
        } else {
            while (true) {
                iArr = this.f10327e;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                } else {
                    i5 = i6;
                }
            }
            iArr[i5] = i3;
        }
        this.f10327e[i3] = -1;
    }

    private void m(int i3, i iVar, float f3) {
        this.f10328f[i3] = iVar.f10301c;
        this.f10329g[i3] = f3;
        this.f10330h[i3] = -1;
        this.f10331i[i3] = -1;
        iVar.a(this.f10334l);
        iVar.f10311m++;
        this.f10332j++;
    }

    private int n() {
        for (int i3 = 0; i3 < this.f10324b; i3++) {
            if (this.f10328f[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void o() {
        int i3 = this.f10324b * 2;
        this.f10328f = Arrays.copyOf(this.f10328f, i3);
        this.f10329g = Arrays.copyOf(this.f10329g, i3);
        this.f10330h = Arrays.copyOf(this.f10330h, i3);
        this.f10331i = Arrays.copyOf(this.f10331i, i3);
        this.f10327e = Arrays.copyOf(this.f10327e, i3);
        for (int i4 = this.f10324b; i4 < i3; i4++) {
            this.f10328f[i4] = -1;
            this.f10327e[i4] = -1;
        }
        this.f10324b = i3;
    }

    private void q(int i3, i iVar, float f3) {
        int iN = n();
        m(iN, iVar, f3);
        if (i3 != -1) {
            this.f10330h[iN] = i3;
            int[] iArr = this.f10331i;
            iArr[iN] = iArr[i3];
            iArr[i3] = iN;
        } else {
            this.f10330h[iN] = -1;
            if (this.f10332j > 0) {
                this.f10331i[iN] = this.f10333k;
                this.f10333k = iN;
            } else {
                this.f10331i[iN] = -1;
            }
        }
        int i4 = this.f10331i[iN];
        if (i4 != -1) {
            this.f10330h[i4] = iN;
        }
        l(iVar, iN);
    }

    private void r(i iVar) {
        int[] iArr;
        int i3;
        int i4 = iVar.f10301c;
        int i5 = i4 % this.f10325c;
        int[] iArr2 = this.f10326d;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            return;
        }
        if (this.f10328f[i6] == i4) {
            int[] iArr3 = this.f10327e;
            iArr2[i5] = iArr3[i6];
            iArr3[i6] = -1;
            return;
        }
        while (true) {
            iArr = this.f10327e;
            i3 = iArr[i6];
            if (i3 == -1 || this.f10328f[i3] == i4) {
                break;
            } else {
                i6 = i3;
            }
        }
        if (i3 == -1 || this.f10328f[i3] != i4) {
            return;
        }
        iArr[i6] = iArr[i3];
        iArr[i3] = -1;
    }

    @Override // o.b.a
    public float a(int i3) {
        int i4 = this.f10332j;
        int i5 = this.f10333k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3) {
                return this.f10329g[i5];
            }
            i5 = this.f10331i[i5];
            if (i5 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f3, boolean z3) {
        float f4 = f10322n;
        if (f3 <= (-f4) || f3 >= f4) {
            int iP = p(iVar);
            if (iP == -1) {
                e(iVar, f3);
                return;
            }
            float[] fArr = this.f10329g;
            float f5 = fArr[iP] + f3;
            fArr[iP] = f5;
            float f6 = f10322n;
            if (f5 <= (-f6) || f5 >= f6) {
                return;
            }
            fArr[iP] = 0.0f;
            i(iVar, z3);
        }
    }

    @Override // o.b.a
    public boolean c(i iVar) {
        return p(iVar) != -1;
    }

    @Override // o.b.a
    public void clear() {
        int i3 = this.f10332j;
        for (int i4 = 0; i4 < i3; i4++) {
            i iVarG = g(i4);
            if (iVarG != null) {
                iVarG.d(this.f10334l);
            }
        }
        for (int i5 = 0; i5 < this.f10324b; i5++) {
            this.f10328f[i5] = -1;
            this.f10327e[i5] = -1;
        }
        for (int i6 = 0; i6 < this.f10325c; i6++) {
            this.f10326d[i6] = -1;
        }
        this.f10332j = 0;
        this.f10333k = -1;
    }

    @Override // o.b.a
    public float d(b bVar, boolean z3) {
        float f3 = f(bVar.f10250a);
        i(bVar.f10250a, z3);
        j jVar = (j) bVar.f10254e;
        int iK = jVar.k();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iK) {
            int i5 = jVar.f10328f[i4];
            if (i5 != -1) {
                b(this.f10335m.f10259d[i5], jVar.f10329g[i4] * f3, z3);
                i3++;
            }
            i4++;
        }
        return f3;
    }

    @Override // o.b.a
    public void e(i iVar, float f3) {
        float f4 = f10322n;
        if (f3 > (-f4) && f3 < f4) {
            i(iVar, true);
            return;
        }
        if (this.f10332j == 0) {
            m(0, iVar, f3);
            l(iVar, 0);
            this.f10333k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f10329g[iP] = f3;
            return;
        }
        if (this.f10332j + 1 >= this.f10324b) {
            o();
        }
        int i3 = this.f10332j;
        int i4 = this.f10333k;
        int i5 = -1;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = this.f10328f[i4];
            int i8 = iVar.f10301c;
            if (i7 == i8) {
                this.f10329g[i4] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i4;
            }
            i4 = this.f10331i[i4];
            if (i4 == -1) {
                break;
            }
        }
        q(i5, iVar, f3);
    }

    @Override // o.b.a
    public float f(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f10329g[iP];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i g(int i3) {
        int i4 = this.f10332j;
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f10333k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3 && i5 != -1) {
                return this.f10335m.f10259d[this.f10328f[i5]];
            }
            i5 = this.f10331i[i5];
            if (i5 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // o.b.a
    public void h(float f3) {
        int i3 = this.f10332j;
        int i4 = this.f10333k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f10329g;
            fArr[i4] = fArr[i4] / f3;
            i4 = this.f10331i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // o.b.a
    public float i(i iVar, boolean z3) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f3 = this.f10329g[iP];
        if (this.f10333k == iP) {
            this.f10333k = this.f10331i[iP];
        }
        this.f10328f[iP] = -1;
        int[] iArr = this.f10330h;
        int i3 = iArr[iP];
        if (i3 != -1) {
            int[] iArr2 = this.f10331i;
            iArr2[i3] = iArr2[iP];
        }
        int i4 = this.f10331i[iP];
        if (i4 != -1) {
            iArr[i4] = iArr[iP];
        }
        this.f10332j--;
        iVar.f10311m--;
        if (z3) {
            iVar.d(this.f10334l);
        }
        return f3;
    }

    @Override // o.b.a
    public void j() {
        int i3 = this.f10332j;
        int i4 = this.f10333k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f10329g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f10331i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // o.b.a
    public int k() {
        return this.f10332j;
    }

    public int p(i iVar) {
        if (this.f10332j != 0 && iVar != null) {
            int i3 = iVar.f10301c;
            int i4 = this.f10326d[i3 % this.f10325c];
            if (i4 == -1) {
                return -1;
            }
            if (this.f10328f[i4] == i3) {
                return i4;
            }
            do {
                i4 = this.f10327e[i4];
                if (i4 == -1) {
                    break;
                }
            } while (this.f10328f[i4] != i3);
            if (i4 != -1 && this.f10328f[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i3 = this.f10332j;
        for (int i4 = 0; i4 < i3; i4++) {
            i iVarG = g(i4);
            if (iVarG != null) {
                String str2 = str + iVarG + " = " + a(i4) + " ";
                int iP = p(iVarG);
                String str3 = str2 + "[p: ";
                String str4 = (this.f10330h[iP] != -1 ? str3 + this.f10335m.f10259d[this.f10328f[this.f10330h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f10331i[iP] != -1 ? str4 + this.f10335m.f10259d[this.f10328f[this.f10331i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
