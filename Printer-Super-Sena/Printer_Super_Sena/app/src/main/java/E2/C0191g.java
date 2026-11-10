package E2;

/* JADX INFO: renamed from: E2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0191g extends Q {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String[] f522D = {"111121", "211121", "121121", "221111", "112121", "212111", "122111", "111221", "211211", "211111", "112111"};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final char[] f523E = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-'};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private Character f525B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Character f526C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double f527z = 2.0d;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f524A = 2;

    private static int L(int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            i4 += iArr[i6] * i5;
            i5++;
            if (i5 > 10) {
                i5 = 1;
            }
        }
        return i4 % 11;
    }

    private static int M(int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            i4 += iArr[i6] * i5;
            i5++;
            if (i5 > 9) {
                i5 = 1;
            }
        }
        return i4 % 11;
    }

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9-]+")) {
            throw new H("Invalid characters in input");
        }
        String str = this.f413l;
        int length = str.length();
        int i3 = length + 1;
        int[] iArr = new int[i3];
        String str2 = "112211";
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = G2.a.c(this.f413l.charAt(i4), f523E);
            str2 = str2 + f522D[iArr[i4]];
        }
        int iL = L(iArr, length);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        String[] strArr = f522D;
        sb.append(strArr[iL]);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        char[] cArr = f523E;
        sb2.append(cArr[iL]);
        String string2 = sb2.toString();
        w("Check Digit C: " + iL);
        if (this.f524A == 2) {
            iArr[length] = iL;
            int iM = M(iArr, i3);
            string = string + strArr[iM];
            string2 = string2 + cArr[iM];
            w("Check Digit K: " + iM);
        }
        String str3 = string + "112211";
        this.f416o = string2;
        if (this.f525B != null) {
            this.f416o = this.f525B + this.f416o;
        }
        if (this.f526C != null) {
            this.f416o += this.f526C;
        }
        this.f417p = new String[]{str3};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f527z;
    }
}
