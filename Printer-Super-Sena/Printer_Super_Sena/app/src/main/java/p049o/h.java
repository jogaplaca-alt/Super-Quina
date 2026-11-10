package p049o;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class h extends p049o.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i[] f10289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i[] f10290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    b f10292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    c f10293l;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f10301c - iVar2.f10301c;
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f10295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h f10296b;

        public b(h hVar) {
            this.f10296b = hVar;
        }

        public boolean a(i iVar, float f3) {
            boolean z3 = true;
            if (!this.f10295a.f10299a) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f4 = iVar.f10307i[i3];
                    if (f4 != 0.0f) {
                        float f5 = f4 * f3;
                        if (Math.abs(f5) < 1.0E-4f) {
                            f5 = 0.0f;
                        }
                        this.f10295a.f10307i[i3] = f5;
                    } else {
                        this.f10295a.f10307i[i3] = 0.0f;
                    }
                }
                return true;
            }
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.f10295a.f10307i;
                float f6 = fArr[i4] + (iVar.f10307i[i4] * f3);
                fArr[i4] = f6;
                if (Math.abs(f6) < 1.0E-4f) {
                    this.f10295a.f10307i[i4] = 0.0f;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                h.this.G(this.f10295a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f10295a = iVar;
        }

        public final boolean c() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = this.f10295a.f10307i[i3];
                if (f3 > 0.0f) {
                    return false;
                }
                if (f3 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = iVar.f10307i[i3];
                float f4 = this.f10295a.f10307i[i3];
                if (f4 != f3) {
                    if (f4 < f3) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f10295a.f10307i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f10295a != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    str = str + this.f10295a.f10307i[i3] + " ";
                }
            }
            return str + "] " + this.f10295a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f10288g = 128;
        this.f10289h = new i[128];
        this.f10290i = new i[128];
        this.f10291j = 0;
        this.f10292k = new b(this);
        this.f10293l = cVar;
    }

    private final void F(i iVar) {
        int i3;
        int i4 = this.f10291j + 1;
        i[] iVarArr = this.f10289h;
        if (i4 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f10289h = iVarArr2;
            this.f10290i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f10289h;
        int i5 = this.f10291j;
        iVarArr3[i5] = iVar;
        int i6 = i5 + 1;
        this.f10291j = i6;
        if (i6 > 1 && iVarArr3[i5].f10301c > iVar.f10301c) {
            int i7 = 0;
            while (true) {
                i3 = this.f10291j;
                if (i7 >= i3) {
                    break;
                }
                this.f10290i[i7] = this.f10289h[i7];
                i7++;
            }
            Arrays.sort(this.f10290i, 0, i3, new a());
            for (int i8 = 0; i8 < this.f10291j; i8++) {
                this.f10289h[i8] = this.f10290i[i8];
            }
        }
        iVar.f10299a = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i3 = 0;
        while (i3 < this.f10291j) {
            if (this.f10289h[i3] == iVar) {
                while (true) {
                    int i4 = this.f10291j;
                    if (i3 >= i4 - 1) {
                        this.f10291j = i4 - 1;
                        iVar.f10299a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f10289h;
                        int i5 = i3 + 1;
                        iVarArr[i3] = iVarArr[i5];
                        i3 = i5;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // p049o.b
    public void B(d dVar, p049o.b bVar, boolean z3) {
        i iVar = bVar.f10250a;
        if (iVar == null) {
            return;
        }
        o.b.a aVar = bVar.f10254e;
        int iK = aVar.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = aVar.g(i3);
            float fA = aVar.a(i3);
            this.f10292k.b(iVarG);
            if (this.f10292k.a(iVar, fA)) {
                F(iVarG);
            }
            this.f10251b += bVar.f10251b * fA;
        }
        G(iVar);
    }

    @Override // p049o.b, o.d.a
    public void a(i iVar) {
        this.f10292k.b(iVar);
        this.f10292k.e();
        iVar.f10307i[iVar.f10303e] = 1.0f;
        F(iVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // p049o.b, o.d.a
    public i b(d dVar, boolean[] zArr) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.f10291j; i4++) {
            i iVar = this.f10289h[i4];
            if (!zArr[iVar.f10301c]) {
                this.f10292k.b(iVar);
                if (i3 == -1) {
                    if (this.f10292k.c()) {
                        i3 = i4;
                    }
                } else if (this.f10292k.d(this.f10289h[i3])) {
                    i3 = i4;
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.f10289h[i3];
    }

    @Override // p049o.b, o.d.a
    public void clear() {
        this.f10291j = 0;
        this.f10251b = 0.0f;
    }

    @Override // p049o.b, o.d.a
    public boolean isEmpty() {
        return this.f10291j == 0;
    }

    @Override // p049o.b
    public String toString() {
        String str = " goal -> (" + this.f10251b + ") : ";
        for (int i3 = 0; i3 < this.f10291j; i3++) {
            this.f10292k.b(this.f10289h[i3]);
            str = str + this.f10292k + " ";
        }
        return str;
    }
}
