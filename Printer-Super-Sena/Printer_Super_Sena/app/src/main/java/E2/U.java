package E2;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class U extends Q {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String[] f440E = {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112"};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final String[] f441F = {"1123", "1222", "2212", "1141", "2311", "1321", "4111", "2131", "3121", "2113"};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private static final String[] f442G = {"BBBAAA", "BBABAA", "BBAABA", "BBAAAB", "BABBAA", "BAABBA", "BAAABB", "BABABA", "BABAAB", "BAABAB"};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static final String[] f443H = {"AAABBB", "AABABB", "AABBAB", "AABBBA", "ABAABB", "ABBAAB", "ABBBAA", "ABABAB", "ABABBA", "ABBABA"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private boolean f446C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private C0206w f447D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f448z = a.UPCA;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f444A = true;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f445B = 5;

    public enum a {
        UPCA,
        UPCE
    }

    public U() {
        this.f411j = y.JUSTIFY;
    }

    private static int M(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            return 0;
        }
        if (cCharAt == '1') {
            return 1;
        }
        throw new H("Invalid input data");
    }

    private int N(int i3) {
        return this.f408g * i3;
    }

    private void O() {
        int iIndexOf = this.f413l.indexOf(43);
        if (iIndexOf == -1) {
            this.f447D = null;
            return;
        }
        if (iIndexOf == this.f413l.length() - 1) {
            throw new H("Invalid add-on data");
        }
        C0206w c0206w = new C0206w();
        this.f447D = c0206w;
        c0206w.f409h = this.f409h;
        c0206w.f402a = this.f402a;
        z zVar = this.f410i;
        z zVar2 = z.NONE;
        if (zVar != zVar2) {
            zVar2 = z.TOP;
        }
        c0206w.f410i = zVar2;
        c0206w.f408g = this.f408g;
        c0206w.f405d = (this.f405d + this.f445B) - 8;
        c0206w.C(this.f413l.substring(iIndexOf + 1));
        this.f413l = this.f413l.substring(0, iIndexOf);
    }

    private void S() {
        String strT = C0205v.T(this.f413l, 11);
        this.f413l = strT;
        char cL = C0205v.L(strT);
        w("Check Digit: " + cL);
        String str = this.f413l + cL;
        StringBuilder sb = new StringBuilder("111");
        for (int i3 = 0; i3 < 12; i3++) {
            if (i3 == 6) {
                sb.append("11111");
            }
            sb.append(f440E[str.charAt(i3) - '0']);
        }
        sb.append("111");
        this.f416o = str;
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void T() {
        String strT = C0205v.T(this.f413l, 7);
        this.f413l = strT;
        String strL = L(strT, true);
        w("UPC-A Equivalent: " + strL);
        char cL = C0205v.L(strL);
        w("Check Digit: " + cL);
        String str = this.f413l + cL;
        String str2 = (M(this.f413l) == 1 ? f443H : f442G)[cL - '0'];
        StringBuilder sb = new StringBuilder("111");
        for (int i3 = 0; i3 < 6; i3++) {
            if (str2.charAt(i3) == 'A') {
                sb.append(f440E[this.f413l.charAt(i3 + 1) - '0']);
            } else {
                sb.append(f441F[this.f413l.charAt(i3 + 1) - '0']);
            }
        }
        sb.append("111111");
        this.f416o = str;
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0070 A[PHI: r13
      0x0070: PHI (r13v9 int) = (r13v6 int), (r13v6 int), (r13v12 int), (r13v12 int) binds: [B:39:0x0081, B:40:0x0083, B:30:0x006c, B:31:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0073 A[PHI: r13
      0x0073: PHI (r13v7 int) = (r13v6 int), (r13v6 int), (r13v12 int), (r13v12 int) binds: [B:38:0x007f, B:40:0x0083, B:29:0x006a, B:31:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // E2.Q
    protected void A() {
        int i3 = this.f446C ? 6 : 0;
        int iQ = this.f410i == z.TOP ? q() : 0;
        if (this.f410i == z.BOTH) {
            iQ = q() / 2;
        }
        this.f423v.clear();
        this.f424w.clear();
        int i4 = 0;
        boolean z3 = true;
        int i5 = 0;
        for (char c3 = 0; i4 < this.f417p[c3].length(); c3 = 0) {
            int iCharAt = this.f417p[c3].charAt(i4) - '0';
            if (z3) {
                int i6 = this.f405d;
                int i7 = -2;
                if (this.f448z == a.UPCA) {
                    if (i5 < 10 || i5 > 84 || (i5 > 45 && i5 < 49)) {
                        i6 += this.f445B;
                    }
                    if (this.f446C && (i5 == 0 || i5 == 94)) {
                        i6 += 2;
                    } else {
                        i7 = 0;
                    }
                } else {
                    if (i5 < 4 || i5 > 45) {
                        i6 += this.f445B;
                    }
                    if (this.f446C && (i5 == 0 || i5 == 50)) {
                        i6 += 2;
                    } else {
                        i7 = 0;
                    }
                }
                G2.e eVar = new G2.e(N(i5), i7 + i3 + iQ, N(iCharAt), i6);
                this.f423v.add(eVar);
                this.f421t = Math.max(this.f421t, (int) eVar.a());
                this.f420s = Math.max(this.f420s, (int) eVar.f1074d);
            }
            z3 = !z3;
            i5 += iCharAt;
            i4++;
            iQ = iQ;
        }
        if (this.f446C) {
            if (this.f448z == a.UPCA) {
                this.f423v.add(new G2.e(N(0), 0.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(94), 0.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(-1), 2.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(95), 2.0d, N(1), 2.0d));
            } else {
                this.f423v.add(new G2.e(N(0), 0.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(50), 0.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(-1), 2.0d, N(1), 2.0d));
                this.f423v.add(new G2.e(N(51), 2.0d, N(1), 2.0d));
            }
            this.f420s += 4;
        }
        z zVar = this.f410i;
        if (zVar == z.BOTTOM || zVar == z.BOTH) {
            int i8 = this.f420s - this.f445B;
            this.f420s = i8;
            int i9 = this.f402a;
            double d3 = i8 + i9;
            if (zVar == z.BOTH) {
                double d4 = i9;
                Double.isNaN(d4);
                Double.isNaN(d3);
                d3 += d4 * 1.2d;
            }
            if (this.f448z == a.UPCA) {
                double d5 = d3;
                this.f424w.add(new T(N(-9), d5, N(4), this.f416o.substring(0, 1), y.RIGHT));
                this.f424w.add(new T(N(12), d5, N(32), this.f416o.substring(1, 6), this.f411j));
                this.f424w.add(new T(N(51), d5, N(32), this.f416o.substring(6, 11), this.f411j));
                if (this.f444A) {
                    this.f424w.add(new T(N(97), d3, N(4), this.f416o.substring(11, 12), y.LEFT));
                }
            } else {
                double d6 = d3;
                this.f424w.add(new T(N(-9), d6, N(4), this.f416o.substring(0, 1), y.RIGHT));
                this.f424w.add(new T(N(5), d6, N(39), this.f416o.substring(1, 7), this.f411j));
                if (this.f444A) {
                    this.f424w.add(new T(N(53), d3, N(4), this.f416o.substring(7, 8), y.LEFT));
                }
            }
        }
        z zVar2 = this.f410i;
        if (zVar2 == z.TOP || zVar2 == z.BOTH) {
            this.f424w.add(new T(N(0), this.f402a, N(this.f448z == a.UPCA ? 94 : 50), this.f416o, this.f411j));
        }
        if (this.f447D != null) {
            int iN = this.f421t + N(9);
            G2.e eVar2 = (G2.e) this.f423v.get(0);
            G2.e eVar3 = (G2.e) this.f447D.f423v.get(0);
            int i10 = (int) (((eVar2.f1072b + eVar2.f1074d) - eVar3.f1072b) - eVar3.f1074d);
            for (T t3 : this.f447D.p()) {
                List list = this.f424w;
                double d7 = iN;
                double d8 = t3.f435a;
                Double.isNaN(d7);
                double d9 = i10;
                double d10 = t3.f436b;
                Double.isNaN(d9);
                list.add(new T(d7 + d8, d9 + d10, t3.f437c, t3.f438d, t3.f439e));
            }
            for (G2.e eVar4 : this.f447D.o()) {
                List list2 = this.f423v;
                double d11 = iN;
                double d12 = eVar4.f1071a;
                Double.isNaN(d11);
                double d13 = i10;
                double d14 = eVar4.f1072b;
                Double.isNaN(d13);
                list2.add(new G2.e(d11 + d12, d13 + d14, eVar4.f1073c, eVar4.f1074d));
            }
            this.f421t += N(9) + this.f447D.f421t;
            this.f417p[0] = this.f417p[0] + 9 + this.f447D.f417p[0];
        }
    }

    protected String L(String str, boolean z3) {
        char c3;
        char[] charArray = str.toCharArray();
        char[] cArr = new char[11];
        Arrays.fill(cArr, '0');
        cArr[0] = charArray[0];
        cArr[1] = charArray[1];
        cArr[2] = charArray[2];
        char c4 = charArray[6];
        switch (c4) {
            case '0':
            case '1':
            case '2':
                cArr[3] = c4;
                cArr[8] = charArray[3];
                cArr[9] = charArray[4];
                cArr[10] = charArray[5];
                break;
            case '3':
                cArr[3] = charArray[3];
                cArr[9] = charArray[4];
                cArr[10] = charArray[5];
                if (z3 && ((c3 = charArray[3]) == '0' || c3 == '1' || c3 == '2')) {
                    throw new H("Invalid UPC-E data");
                }
                break;
            case '4':
                cArr[3] = charArray[3];
                cArr[4] = charArray[4];
                cArr[10] = charArray[5];
                if (z3 && charArray[4] == '0') {
                    throw new H("Invalid UPC-E data");
                }
                break;
            default:
                cArr[3] = charArray[3];
                cArr[4] = charArray[4];
                cArr[5] = charArray[5];
                cArr[10] = c4;
                if (z3 && charArray[5] == '0') {
                    throw new H("Invalid UPC-E data");
                }
                break;
        }
        return new String(cArr);
    }

    public void P(int i3) {
        this.f445B = i3;
    }

    protected void Q(boolean z3) {
        this.f446C = z3;
    }

    public void R(a aVar) {
        this.f448z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        O();
        if (this.f413l.isEmpty()) {
            throw new H("Missing UPC data");
        }
        if (this.f448z == a.UPCA) {
            S();
        } else {
            T();
        }
    }
}
