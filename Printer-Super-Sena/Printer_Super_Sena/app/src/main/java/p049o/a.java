package p049o;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static float f10238l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f10240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f10241c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10239a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10242d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f10243e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f10244f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f10245g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f10246h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10247i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10248j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10249k = false;

    a(b bVar, c cVar) {
        this.f10240b = bVar;
        this.f10241c = cVar;
    }

    @Override // o.b.a
    public float a(int i3) {
        int i4 = this.f10247i;
        for (int i5 = 0; i4 != -1 && i5 < this.f10239a; i5++) {
            if (i5 == i3) {
                return this.f10246h[i4];
            }
            i4 = this.f10245g[i4];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f3, boolean z3) {
        float f4 = f10238l;
        if (f3 <= (-f4) || f3 >= f4) {
            int i3 = this.f10247i;
            if (i3 == -1) {
                this.f10247i = 0;
                this.f10246h[0] = f3;
                this.f10244f[0] = iVar.f10301c;
                this.f10245g[0] = -1;
                iVar.f10311m++;
                iVar.a(this.f10240b);
                this.f10239a++;
                if (this.f10249k) {
                    return;
                }
                int i4 = this.f10248j + 1;
                this.f10248j = i4;
                int[] iArr = this.f10244f;
                if (i4 >= iArr.length) {
                    this.f10249k = true;
                    this.f10248j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i3 != -1 && i6 < this.f10239a; i6++) {
                int i7 = this.f10244f[i3];
                int i8 = iVar.f10301c;
                if (i7 == i8) {
                    float[] fArr = this.f10246h;
                    float f5 = fArr[i3] + f3;
                    float f6 = f10238l;
                    if (f5 > (-f6) && f5 < f6) {
                        f5 = 0.0f;
                    }
                    fArr[i3] = f5;
                    if (f5 == 0.0f) {
                        if (i3 == this.f10247i) {
                            this.f10247i = this.f10245g[i3];
                        } else {
                            int[] iArr2 = this.f10245g;
                            iArr2[i5] = iArr2[i3];
                        }
                        if (z3) {
                            iVar.d(this.f10240b);
                        }
                        if (this.f10249k) {
                            this.f10248j = i3;
                        }
                        iVar.f10311m--;
                        this.f10239a--;
                        return;
                    }
                    return;
                }
                if (i7 < i8) {
                    i5 = i3;
                }
                i3 = this.f10245g[i3];
            }
            int length = this.f10248j;
            int i9 = length + 1;
            if (this.f10249k) {
                int[] iArr3 = this.f10244f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i9;
            }
            int[] iArr4 = this.f10244f;
            if (length >= iArr4.length && this.f10239a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f10244f;
                    if (i10 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i10] == -1) {
                        length = i10;
                        break;
                    }
                    i10++;
                }
            }
            int[] iArr6 = this.f10244f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i11 = this.f10242d * 2;
                this.f10242d = i11;
                this.f10249k = false;
                this.f10248j = length - 1;
                this.f10246h = Arrays.copyOf(this.f10246h, i11);
                this.f10244f = Arrays.copyOf(this.f10244f, this.f10242d);
                this.f10245g = Arrays.copyOf(this.f10245g, this.f10242d);
            }
            this.f10244f[length] = iVar.f10301c;
            this.f10246h[length] = f3;
            if (i5 != -1) {
                int[] iArr7 = this.f10245g;
                iArr7[length] = iArr7[i5];
                iArr7[i5] = length;
            } else {
                this.f10245g[length] = this.f10247i;
                this.f10247i = length;
            }
            iVar.f10311m++;
            iVar.a(this.f10240b);
            this.f10239a++;
            if (!this.f10249k) {
                this.f10248j++;
            }
            int i12 = this.f10248j;
            int[] iArr8 = this.f10244f;
            if (i12 >= iArr8.length) {
                this.f10249k = true;
                this.f10248j = iArr8.length - 1;
            }
        }
    }

    @Override // o.b.a
    public boolean c(i iVar) {
        int i3 = this.f10247i;
        if (i3 == -1) {
            return false;
        }
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            if (this.f10244f[i3] == iVar.f10301c) {
                return true;
            }
            i3 = this.f10245g[i3];
        }
        return false;
    }

    @Override // o.b.a
    public final void clear() {
        int i3 = this.f10247i;
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            i iVar = this.f10241c.f10259d[this.f10244f[i3]];
            if (iVar != null) {
                iVar.d(this.f10240b);
            }
            i3 = this.f10245g[i3];
        }
        this.f10247i = -1;
        this.f10248j = -1;
        this.f10249k = false;
        this.f10239a = 0;
    }

    @Override // o.b.a
    public float d(b bVar, boolean z3) {
        float f3 = f(bVar.f10250a);
        i(bVar.f10250a, z3);
        b.a aVar = bVar.f10254e;
        int iK = aVar.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = aVar.g(i3);
            b(iVarG, aVar.f(iVarG) * f3, z3);
        }
        return f3;
    }

    @Override // o.b.a
    public final void e(i iVar, float f3) {
        if (f3 == 0.0f) {
            i(iVar, true);
            return;
        }
        int i3 = this.f10247i;
        if (i3 == -1) {
            this.f10247i = 0;
            this.f10246h[0] = f3;
            this.f10244f[0] = iVar.f10301c;
            this.f10245g[0] = -1;
            iVar.f10311m++;
            iVar.a(this.f10240b);
            this.f10239a++;
            if (this.f10249k) {
                return;
            }
            int i4 = this.f10248j + 1;
            this.f10248j = i4;
            int[] iArr = this.f10244f;
            if (i4 >= iArr.length) {
                this.f10249k = true;
                this.f10248j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i3 != -1 && i6 < this.f10239a; i6++) {
            int i7 = this.f10244f[i3];
            int i8 = iVar.f10301c;
            if (i7 == i8) {
                this.f10246h[i3] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i3;
            }
            i3 = this.f10245g[i3];
        }
        int length = this.f10248j;
        int i9 = length + 1;
        if (this.f10249k) {
            int[] iArr2 = this.f10244f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i9;
        }
        int[] iArr3 = this.f10244f;
        if (length >= iArr3.length && this.f10239a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f10244f;
                if (i10 >= iArr4.length) {
                    break;
                }
                if (iArr4[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr5 = this.f10244f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i11 = this.f10242d * 2;
            this.f10242d = i11;
            this.f10249k = false;
            this.f10248j = length - 1;
            this.f10246h = Arrays.copyOf(this.f10246h, i11);
            this.f10244f = Arrays.copyOf(this.f10244f, this.f10242d);
            this.f10245g = Arrays.copyOf(this.f10245g, this.f10242d);
        }
        this.f10244f[length] = iVar.f10301c;
        this.f10246h[length] = f3;
        if (i5 != -1) {
            int[] iArr6 = this.f10245g;
            iArr6[length] = iArr6[i5];
            iArr6[i5] = length;
        } else {
            this.f10245g[length] = this.f10247i;
            this.f10247i = length;
        }
        iVar.f10311m++;
        iVar.a(this.f10240b);
        int i12 = this.f10239a + 1;
        this.f10239a = i12;
        if (!this.f10249k) {
            this.f10248j++;
        }
        int[] iArr7 = this.f10244f;
        if (i12 >= iArr7.length) {
            this.f10249k = true;
        }
        if (this.f10248j >= iArr7.length) {
            this.f10249k = true;
            this.f10248j = iArr7.length - 1;
        }
    }

    @Override // o.b.a
    public final float f(i iVar) {
        int i3 = this.f10247i;
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            if (this.f10244f[i3] == iVar.f10301c) {
                return this.f10246h[i3];
            }
            i3 = this.f10245g[i3];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i g(int i3) {
        int i4 = this.f10247i;
        for (int i5 = 0; i4 != -1 && i5 < this.f10239a; i5++) {
            if (i5 == i3) {
                return this.f10241c.f10259d[this.f10244f[i4]];
            }
            i4 = this.f10245g[i4];
        }
        return null;
    }

    @Override // o.b.a
    public void h(float f3) {
        int i3 = this.f10247i;
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            float[] fArr = this.f10246h;
            fArr[i3] = fArr[i3] / f3;
            i3 = this.f10245g[i3];
        }
    }

    @Override // o.b.a
    public final float i(i iVar, boolean z3) {
        if (this.f10243e == iVar) {
            this.f10243e = null;
        }
        int i3 = this.f10247i;
        if (i3 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i3 != -1 && i4 < this.f10239a) {
            if (this.f10244f[i3] == iVar.f10301c) {
                if (i3 == this.f10247i) {
                    this.f10247i = this.f10245g[i3];
                } else {
                    int[] iArr = this.f10245g;
                    iArr[i5] = iArr[i3];
                }
                if (z3) {
                    iVar.d(this.f10240b);
                }
                iVar.f10311m--;
                this.f10239a--;
                this.f10244f[i3] = -1;
                if (this.f10249k) {
                    this.f10248j = i3;
                }
                return this.f10246h[i3];
            }
            i4++;
            i5 = i3;
            i3 = this.f10245g[i3];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void j() {
        int i3 = this.f10247i;
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            float[] fArr = this.f10246h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f10245g[i3];
        }
    }

    @Override // o.b.a
    public int k() {
        return this.f10239a;
    }

    public String toString() {
        int i3 = this.f10247i;
        String str = "";
        for (int i4 = 0; i3 != -1 && i4 < this.f10239a; i4++) {
            str = ((str + " -> ") + this.f10246h[i3] + " : ") + this.f10241c.f10259d[this.f10244f[i3]];
            i3 = this.f10245g[i3];
        }
        return str;
    }
}
