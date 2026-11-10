package E2;

/* JADX INFO: renamed from: E2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0188d extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private final int[] f493A = new int[11];

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private final int[] f494B = new int[11];

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private double f495C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private double f496D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f497z;

    private void L() {
        if (this.f495C == this.f496D) {
            StringBuilder sb = new StringBuilder();
            sb.append("11110");
            for (int i3 = 0; i3 < 11; i3++) {
                sb.append((char) (this.f493A[i3] + 48));
                sb.append((char) (this.f494B[i3] + 48));
            }
            this.f417p[0] = sb.toString();
        }
    }

    private void M(int i3, int i4, int i5, int i6) {
        int[] iArr = this.f493A;
        int i7 = iArr[i4];
        int[] iArr2 = this.f494B;
        int i8 = i4 - 1;
        int i9 = ((i7 + iArr2[i8]) + iArr[i8]) + iArr2[i4 + (-2)] > 4 ? 1 : 2;
        if (i4 < i3 + 2) {
            while (i9 <= i5) {
                this.f494B[i4] = i9;
                N(i3, i4 + 1, i6, (i5 + 1) - i9);
                i9++;
            }
            return;
        }
        if (i9 <= i5) {
            iArr2[i4] = i5;
            L();
            this.f495C += 1.0d;
        }
    }

    private void N(int i3, int i4, int i5, int i6) {
        for (int i7 = i4 < i3 + 2 ? 1 : i5; i7 <= i5; i7++) {
            this.f493A[i4] = i7;
            M(i3, i4, i6, (i5 + 1) - i7);
        }
    }

    @Override // E2.Q
    protected void c() {
        if (this.f413l.length() > 7) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        int i3 = this.f497z;
        if (i3 <= 2 || i3 > 8) {
            i3 = 3;
        }
        double d3 = Integer.parseInt(this.f413l);
        this.f496D = d3;
        switch (i3) {
            case 3:
                if (d3 > 26.0d) {
                    i3++;
                    break;
                }
            case 4:
                if (d3 > 292.0d) {
                    i3++;
                    break;
                }
            case 5:
                if (d3 > 3493.0d) {
                    i3++;
                    break;
                }
            case 6:
                if (d3 > 44072.0d) {
                    i3++;
                    break;
                }
            case 7:
                if (d3 > 576688.0d) {
                    i3++;
                    break;
                }
            case 8:
                if (d3 > 7742862.0d) {
                    i3++;
                }
                break;
        }
        if (i3 == 9) {
            throw new H("Value out of range");
        }
        w("Channels Used: " + i3);
        for (int i4 = 0; i4 < 11; i4++) {
            this.f494B[i4] = 0;
            this.f493A[i4] = 0;
        }
        int[] iArr = this.f494B;
        int[] iArr2 = this.f493A;
        iArr[2] = 1;
        iArr2[2] = 1;
        iArr[1] = 1;
        iArr2[1] = 1;
        iArr[0] = 1;
        this.f495C = 0.0d;
        this.f417p = new String[1];
        N(i3, 3, i3, i3);
        int length = (i3 - 1) - this.f413l.length();
        this.f416o = "";
        for (int i5 = 0; i5 < length; i5++) {
            this.f416o += "0";
        }
        this.f416o += this.f413l;
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
