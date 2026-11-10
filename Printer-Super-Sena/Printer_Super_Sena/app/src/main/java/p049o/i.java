package p049o;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f10298r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10300b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f10304f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    a f10308j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10301c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f10302d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10303e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10305g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float[] f10306h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f10307i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    b[] f10309k = new b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f10310l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10311m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f10312n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f10313o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f10314p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    HashSet f10315q = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f10308j = aVar;
    }

    static void c() {
        f10298r++;
    }

    public final void a(b bVar) {
        int i3 = 0;
        while (true) {
            int i4 = this.f10310l;
            if (i3 >= i4) {
                b[] bVarArr = this.f10309k;
                if (i4 >= bVarArr.length) {
                    this.f10309k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f10309k;
                int i5 = this.f10310l;
                bVarArr2[i5] = bVar;
                this.f10310l = i5 + 1;
                return;
            }
            if (this.f10309k[i3] == bVar) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f10301c - iVar.f10301c;
    }

    public final void d(b bVar) {
        int i3 = this.f10310l;
        int i4 = 0;
        while (i4 < i3) {
            if (this.f10309k[i4] == bVar) {
                while (i4 < i3 - 1) {
                    b[] bVarArr = this.f10309k;
                    int i5 = i4 + 1;
                    bVarArr[i4] = bVarArr[i5];
                    i4 = i5;
                }
                this.f10310l--;
                return;
            }
            i4++;
        }
    }

    public void e() {
        this.f10300b = null;
        this.f10308j = a.UNKNOWN;
        this.f10303e = 0;
        this.f10301c = -1;
        this.f10302d = -1;
        this.f10304f = 0.0f;
        this.f10305g = false;
        this.f10312n = false;
        this.f10313o = -1;
        this.f10314p = 0.0f;
        int i3 = this.f10310l;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f10309k[i4] = null;
        }
        this.f10310l = 0;
        this.f10311m = 0;
        this.f10299a = false;
        Arrays.fill(this.f10307i, 0.0f);
    }

    public void f(d dVar, float f3) {
        this.f10304f = f3;
        this.f10305g = true;
        this.f10312n = false;
        this.f10313o = -1;
        this.f10314p = 0.0f;
        int i3 = this.f10310l;
        this.f10302d = -1;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f10309k[i4].A(dVar, this, false);
        }
        this.f10310l = 0;
    }

    public void g(a aVar, String str) {
        this.f10308j = aVar;
    }

    public final void h(d dVar, b bVar) {
        int i3 = this.f10310l;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f10309k[i4].B(dVar, bVar, false);
        }
        this.f10310l = 0;
    }

    public String toString() {
        if (this.f10300b != null) {
            return "" + this.f10300b;
        }
        return "" + this.f10301c;
    }
}
