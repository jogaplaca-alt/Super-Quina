package E2;

import java.util.List;

/* JADX INFO: renamed from: E2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0205v extends Q {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String[] f784D = {"AAAAAA", "AABABB", "AABBAB", "AABBBA", "ABAABB", "ABBAAB", "ABBBAA", "ABABAB", "ABABBA", "ABBABA"};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private static final String[] f785E = {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112"};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private static final String[] f786F = {"1123", "1222", "2212", "1141", "2311", "1321", "4111", "2131", "3121", "2113"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private boolean f788B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private C0206w f789C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f790z = a.EAN13;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f787A = 5;

    /* JADX INFO: renamed from: E2.v$a */
    public enum a {
        EAN8,
        EAN13
    }

    public C0205v() {
        this.f411j = y.JUSTIFY;
    }

    protected static char L(String str) {
        int i3 = 0;
        int i4 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            int numericValue = Character.getNumericValue(str.charAt(length));
            if (i4 % 2 == 0) {
                numericValue *= 3;
            }
            i3 += numericValue;
            i4++;
        }
        int i5 = 10 - (i3 % 10);
        return (char) ((i5 != 10 ? i5 : 0) + 48);
    }

    private void M() {
        String strT = T(this.f413l, 12);
        this.f413l = strT;
        char cL = L(strT);
        w("Check Digit: " + cL);
        String str = this.f413l + cL;
        char cCharAt = str.charAt(0);
        String str2 = f784D[cCharAt - '0'];
        w("Parity Digit: " + cCharAt);
        StringBuilder sb = new StringBuilder("111");
        for (int i3 = 1; i3 < 13; i3++) {
            if (i3 == 7) {
                sb.append("11111");
            }
            if (i3 > 6) {
                sb.append(f785E[str.charAt(i3) - '0']);
            } else if (str2.charAt(i3 - 1) == 'B') {
                sb.append(f786F[str.charAt(i3) - '0']);
            } else {
                sb.append(f785E[str.charAt(i3) - '0']);
            }
        }
        sb.append("111");
        this.f416o = str;
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void N() {
        String strT = T(this.f413l, 7);
        this.f413l = strT;
        char cL = L(strT);
        w("Check Digit: " + cL);
        String str = this.f413l + cL;
        StringBuilder sb = new StringBuilder("111");
        for (int i3 = 0; i3 < 8; i3++) {
            if (i3 == 4) {
                sb.append("11111");
            }
            sb.append(f785E[str.charAt(i3) - '0']);
        }
        sb.append("111");
        this.f416o = str;
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private int O(int i3) {
        return this.f408g * i3;
    }

    private void P() {
        int iIndexOf = this.f413l.indexOf(43);
        if (iIndexOf == -1) {
            this.f789C = null;
            return;
        }
        if (iIndexOf == this.f413l.length() - 1) {
            throw new H("Invalid add-on data");
        }
        C0206w c0206w = new C0206w();
        this.f789C = c0206w;
        c0206w.f409h = this.f409h;
        c0206w.f402a = this.f402a;
        z zVar = this.f410i;
        z zVar2 = z.NONE;
        if (zVar != zVar2) {
            zVar2 = z.TOP;
        }
        c0206w.f410i = zVar2;
        c0206w.f408g = this.f408g;
        c0206w.f405d = (this.f405d + this.f787A) - 8;
        c0206w.C(this.f413l.substring(iIndexOf + 1));
        this.f413l = this.f413l.substring(0, iIndexOf);
    }

    protected static String T(String str, int i3) {
        if (!str.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        if (str.length() > i3) {
            throw new H("Input data too long");
        }
        if (str.length() < i3) {
            for (int length = str.length(); length < i3; length++) {
                str = '0' + str;
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d A[PHI: r11
      0x006d: PHI (r11v25 int) = (r11v22 int), (r11v22 int), (r11v28 int), (r11v28 int) binds: [B:44:0x0087, B:45:0x0089, B:30:0x0069, B:31:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0070 A[PHI: r11
      0x0070: PHI (r11v23 int) = (r11v22 int), (r11v22 int), (r11v28 int), (r11v28 int) binds: [B:43:0x0085, B:45:0x0089, B:29:0x0067, B:31:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // E2.Q
    protected void A() {
        char c3 = 0;
        int i3 = this.f788B ? 6 : 0;
        int iQ = this.f410i == z.TOP ? q() : 0;
        if (this.f410i == z.BOTH) {
            iQ = q() / 2;
        }
        this.f423v.clear();
        this.f424w.clear();
        int i4 = 0;
        boolean z3 = true;
        int i5 = 0;
        while (true) {
            if (i4 >= this.f417p[c3].length()) {
                break;
            }
            int iCharAt = this.f417p[c3].charAt(i4) - '0';
            if (z3) {
                int i6 = this.f405d;
                int i7 = -2;
                if (this.f790z == a.EAN13) {
                    if (i5 < 3 || i5 > 91 || (i5 > 45 && i5 < 49)) {
                        i6 += this.f787A;
                    }
                    if (this.f788B && (i5 == 0 || i5 == 94)) {
                        i6 += 2;
                    } else {
                        i7 = 0;
                    }
                } else {
                    if (i5 < 3 || i5 > 62 || (i5 > 30 && i5 < 35)) {
                        i6 += this.f787A;
                    }
                    if (this.f788B && (i5 == 0 || i5 == 66)) {
                        i6 += 2;
                    } else {
                        i7 = 0;
                    }
                }
                G2.e eVar = new G2.e(O(i5), i7 + i3 + iQ, O(iCharAt), i6);
                this.f423v.add(eVar);
                this.f421t = Math.max(this.f421t, (int) eVar.a());
                this.f420s = Math.max(this.f420s, (int) eVar.f1074d);
            }
            z3 = !z3;
            i5 += iCharAt;
            i4++;
            iQ = iQ;
            c3 = 0;
        }
        if (this.f788B) {
            if (this.f790z == a.EAN13) {
                this.f423v.add(new G2.e(O(0), 0.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(94), 0.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(-1), 2.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(95), 2.0d, O(1), 2.0d));
            } else {
                this.f423v.add(new G2.e(O(0), 0.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(66), 0.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(-1), 2.0d, O(1), 2.0d));
                this.f423v.add(new G2.e(O(67), 2.0d, O(1), 2.0d));
            }
            this.f420s += 4;
        }
        z zVar = this.f410i;
        if (zVar == z.BOTTOM || zVar == z.BOTH) {
            int i8 = this.f420s - this.f787A;
            this.f420s = i8;
            int i9 = this.f402a;
            double d3 = i8 + i9;
            if (zVar == z.BOTH) {
                double d4 = i9;
                Double.isNaN(d4);
                Double.isNaN(d3);
                d3 += d4 * 1.2d;
            }
            if (this.f790z == a.EAN13) {
                this.f424w.add(new T(O(-9), d3, O(4), this.f416o.substring(0, 1), y.RIGHT));
                double d5 = d3;
                this.f424w.add(new T(O(5), d5, O(39), this.f416o.substring(1, 7), this.f411j));
                this.f424w.add(new T(O(51), d5, O(39), this.f416o.substring(7, 13), this.f411j));
            } else {
                double d6 = d3;
                this.f424w.add(new T(O(5), d6, O(25), this.f416o.substring(0, 4), this.f411j));
                this.f424w.add(new T(O(37), d6, O(25), this.f416o.substring(4, 8), this.f411j));
            }
        }
        z zVar2 = this.f410i;
        if (zVar2 == z.TOP || zVar2 == z.BOTH) {
            this.f424w.add(new T(O(0), this.f402a, O(this.f790z == a.EAN13 ? 94 : 66), this.f416o, this.f411j));
        }
        if (this.f789C != null) {
            int iO = this.f421t + O(9);
            G2.e eVar2 = (G2.e) this.f423v.get(0);
            G2.e eVar3 = (G2.e) this.f789C.f423v.get(0);
            int i10 = (int) (((eVar2.f1072b + eVar2.f1074d) - eVar3.f1072b) - eVar3.f1074d);
            for (T t3 : this.f789C.p()) {
                List list = this.f424w;
                double d7 = iO;
                double d8 = t3.f435a;
                Double.isNaN(d7);
                double d9 = i10;
                double d10 = t3.f436b;
                Double.isNaN(d9);
                list.add(new T(d7 + d8, d9 + d10, t3.f437c, t3.f438d, t3.f439e));
            }
            for (G2.e eVar4 : this.f789C.o()) {
                List list2 = this.f423v;
                double d11 = iO;
                double d12 = eVar4.f1071a;
                Double.isNaN(d11);
                double d13 = i10;
                double d14 = eVar4.f1072b;
                Double.isNaN(d13);
                list2.add(new G2.e(d11 + d12, d13 + d14, eVar4.f1073c, eVar4.f1074d));
            }
            this.f421t += O(9) + this.f789C.f421t;
            this.f417p[0] = this.f417p[0] + 9 + this.f789C.f417p[0];
        }
    }

    public void Q(int i3) {
        this.f787A = i3;
    }

    protected void R(boolean z3) {
        this.f788B = z3;
    }

    public void S(a aVar) {
        this.f790z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        P();
        if (this.f413l.isEmpty()) {
            throw new H("Missing EAN data");
        }
        if (this.f790z == a.EAN8) {
            N();
        } else {
            M();
        }
    }
}
