package E2;

/* JADX INFO: loaded from: classes.dex */
public class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f398f;

    public void a(int i3, int[] iArr) {
        int i4;
        int i5;
        this.f398f = new int[this.f394b];
        for (int i6 = 0; i6 < this.f394b; i6++) {
            this.f398f[i6] = 0;
        }
        for (int i7 = 0; i7 < i3; i7++) {
            int[] iArr2 = this.f398f;
            int i8 = this.f394b;
            int i9 = iArr2[i8 - 1] ^ iArr[i7];
            for (int i10 = i8 - 1; i10 > 0; i10--) {
                if (i9 == 0 || (i5 = this.f397e[i10]) == 0) {
                    int[] iArr3 = this.f398f;
                    iArr3[i10] = iArr3[i10 - 1];
                } else {
                    int[] iArr4 = this.f398f;
                    int i11 = iArr4[i10 - 1];
                    int[] iArr5 = this.f396d;
                    int[] iArr6 = this.f395c;
                    iArr4[i10] = iArr5[(iArr6[i9] + iArr6[i5]) % this.f393a] ^ i11;
                }
            }
            if (i9 == 0 || (i4 = this.f397e[0]) == 0) {
                this.f398f[0] = 0;
            } else {
                int[] iArr7 = this.f398f;
                int[] iArr8 = this.f396d;
                int[] iArr9 = this.f395c;
                iArr7[0] = iArr8[(iArr9[i9] + iArr9[i4]) % this.f393a];
            }
        }
    }

    public int b(int i3) {
        return this.f398f[i3];
    }

    public void c(int i3, int i4) {
        int[] iArr = new int[i3 + 1];
        this.f397e = iArr;
        this.f394b = i3;
        iArr[0] = 1;
        for (int i5 = 1; i5 <= i3; i5++) {
            this.f397e[i5] = 1;
            for (int i6 = i5 - 1; i6 > 0; i6--) {
                int[] iArr2 = this.f397e;
                int i7 = iArr2[i6];
                if (i7 != 0) {
                    iArr2[i6] = this.f396d[(this.f395c[i7] + i4) % this.f393a];
                }
                iArr2[i6] = iArr2[i6] ^ iArr2[i6 - 1];
            }
            int[] iArr3 = this.f397e;
            iArr3[0] = this.f396d[(this.f395c[iArr3[0]] + i4) % this.f393a];
            i4++;
        }
    }

    public void d(int i3) {
        int i4 = 1;
        int i5 = 0;
        while (i4 <= i3) {
            i5++;
            i4 <<= 1;
        }
        int i6 = i4 >> 1;
        int i7 = 1 << (i5 - 1);
        int i8 = i7 - 1;
        this.f393a = i8;
        this.f395c = new int[i7];
        this.f396d = new int[i8];
        int i9 = 1;
        for (int i10 = 0; i10 < this.f393a; i10++) {
            this.f396d[i10] = i9;
            this.f395c[i9] = i10;
            i9 <<= 1;
            if ((i9 & i6) != 0) {
                i9 ^= i3;
            }
        }
    }
}
