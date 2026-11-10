package E2;

/* JADX INFO: renamed from: E2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0194j extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f569B = {"113311", "311131", "131131", "331111", "113131", "313111", "133111", "111331", "311311", "131311"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f570C = {"1111313111", "3111111131", "1131111131", "3131111111", "1111311131", "3111311111", "1131311111", "1111113131", "3111113111", "1131113111"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String[] f571D = {"11331", "31113", "13113", "33111", "11313", "31311", "13311", "11133", "31131", "13131"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f573z = a.MATRIX;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private double f572A = 3.0d;

    /* JADX INFO: renamed from: E2.j$a */
    public enum a {
        MATRIX,
        INDUSTRIAL,
        IATA,
        DATA_LOGIC,
        INTERLEAVED,
        INTERLEAVED_WITH_CHECK_DIGIT,
        ITF14,
        DP_LEITCODE,
        DP_IDENTCODE
    }

    private static char L(String str, int i3, int i4) {
        int iCharAt = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            iCharAt += (length & 1) != 0 ? (str.charAt(length) - '0') * i3 : (str.charAt(length) - '0') * i4;
        }
        return (char) (((10 - (iCharAt % 10)) % 10) + 48);
    }

    private void M() {
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        String str = "1111";
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            str = str + f569B[Character.getNumericValue(this.f413l.charAt(i3))];
        }
        this.f416o = this.f413l;
        this.f417p = new String[]{str + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void N() {
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        String str = "311111";
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            str = str + f569B[Character.getNumericValue(this.f413l.charAt(i3))];
        }
        this.f416o = this.f413l;
        this.f417p = new String[]{str + "31111"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void O() {
        int length = this.f413l.length();
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        if (length > 11) {
            throw new H("Input data too long");
        }
        this.f416o = "";
        while (length < 11) {
            this.f416o += "0";
            length++;
        }
        String str = this.f416o + this.f413l;
        this.f416o = str;
        char cL = L(str, 9, 4);
        this.f416o += cL;
        w("Check Digit: " + cL);
        String str2 = "1111";
        for (int i3 = 0; i3 < this.f416o.length(); i3 += 2) {
            str2 = str2 + S(i3, i3 + 1);
        }
        this.f417p = new String[]{str2 + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void P() {
        int length = this.f413l.length();
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        if (length > 13) {
            throw new H("Input data too long");
        }
        this.f416o = "";
        while (length < 13) {
            this.f416o += "0";
            length++;
        }
        String str = this.f416o + this.f413l;
        this.f416o = str;
        char cL = L(str, 9, 4);
        this.f416o += cL;
        w("Check digit: " + cL);
        String str2 = "1111";
        for (int i3 = 0; i3 < this.f416o.length(); i3 += 2) {
            str2 = str2 + S(i3, i3 + 1);
        }
        this.f417p = new String[]{str2 + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void Q() {
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        String str = "1111";
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            str = str + f570C[Character.getNumericValue(this.f413l.charAt(i3))];
        }
        this.f416o = this.f413l;
        this.f417p = new String[]{str + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void R() {
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        String str = "313111";
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            str = str + f570C[Character.getNumericValue(this.f413l.charAt(i3))];
        }
        this.f416o = this.f413l;
        this.f417p = new String[]{str + "31113"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private String S(int i3, int i4) {
        char cCharAt = this.f416o.charAt(i3);
        char cCharAt2 = this.f416o.charAt(i4);
        String[] strArr = f571D;
        String str = strArr[Character.getNumericValue(cCharAt)];
        String str2 = strArr[Character.getNumericValue(cCharAt2)];
        StringBuilder sb = new StringBuilder(10);
        for (int i5 = 0; i5 < 5; i5++) {
            sb.append(str.charAt(i5));
            sb.append(str2.charAt(i5));
        }
        return sb.toString();
    }

    private void T(boolean z3) {
        String str = this.f413l;
        this.f416o = str;
        if (!str.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        if (z3) {
            char cL = L(this.f416o, 1, 3);
            this.f416o += cL;
            w("Check Digit: " + cL);
        }
        if ((this.f416o.length() & 1) != 0) {
            this.f416o = "0" + this.f416o;
        }
        String str2 = "1111";
        for (int i3 = 0; i3 < this.f416o.length(); i3 += 2) {
            str2 = str2 + S(i3, i3 + 1);
        }
        this.f417p = new String[]{str2 + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void U() {
        int length = this.f413l.length();
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        if (length > 13) {
            throw new H("Input data too long");
        }
        this.f416o = "";
        while (length < 13) {
            this.f416o += "0";
            length++;
        }
        String str = this.f416o + this.f413l;
        this.f416o = str;
        char cL = L(str, 1, 3);
        this.f416o += cL;
        w("Check Digit: " + cL);
        String str2 = "1111";
        for (int i3 = 0; i3 < this.f416o.length(); i3 += 2) {
            str2 = str2 + S(i3, i3 + 1);
        }
        this.f417p = new String[]{str2 + "311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected void A() {
        int iQ;
        this.f423v.clear();
        this.f424w.clear();
        z zVar = this.f410i;
        char c3 = 0;
        if (zVar == z.TOP) {
            iQ = q();
        } else {
            iQ = zVar == z.BOTH ? q() / 2 : 0;
        }
        int i3 = this.f573z == a.ITF14 ? 20 : 0;
        double d3 = 0.0d;
        boolean z3 = true;
        double d4 = 0.0d;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f417p[c3].length()) {
            double dK = k(this.f417p[c3].charAt(i4) - '0');
            double d5 = this.f408g;
            Double.isNaN(d5);
            double d6 = dK * d5;
            if (z3) {
                i5 = this.f419r[c3];
                if (i5 == -1) {
                    i5 = this.f405d;
                }
                if (d6 != d3 && i5 != 0) {
                    double d7 = i3;
                    Double.isNaN(d7);
                    this.f423v.add(new G2.e(d4 + d7, iQ, d6, i5));
                }
                double d8 = i3 * 2;
                Double.isNaN(d8);
                this.f421t = (int) Math.ceil(d4 + d6 + d8);
            }
            z3 = !z3;
            d4 += d6;
            i4++;
            c3 = 0;
            d3 = 0.0d;
        }
        this.f420s = i5;
        if (this.f573z == a.ITF14) {
            double d9 = iQ;
            G2.e eVar = new G2.e(0.0d, d9, this.f421t, 4.0d);
            G2.e eVar2 = new G2.e(0.0d, (iQ + this.f420s) - 4, this.f421t, 4.0d);
            G2.e eVar3 = new G2.e(0.0d, d9, 4.0d, this.f420s);
            G2.e eVar4 = new G2.e(this.f421t - 4, d9, 4.0d, this.f420s);
            this.f423v.add(eVar);
            this.f423v.add(eVar2);
            this.f423v.add(eVar3);
            this.f423v.add(eVar4);
        }
        if (this.f410i == z.NONE || this.f416o.isEmpty()) {
            return;
        }
        z zVar2 = this.f410i;
        if (zVar2 == z.TOP || zVar2 == z.BOTH) {
            this.f424w.add(new T(0.0d, this.f402a, this.f421t, this.f416o, this.f411j));
        }
        if (this.f410i == z.BOTTOM) {
            this.f424w.add(new T(0.0d, this.f420s + this.f402a, this.f421t, this.f416o, this.f411j));
        }
        if (this.f410i == z.BOTH) {
            double d10 = this.f420s;
            double d11 = this.f402a;
            Double.isNaN(d11);
            Double.isNaN(d10);
            this.f424w.add(new T(0.0d, d10 + (d11 * 2.2d), this.f421t, this.f416o, this.f411j));
        }
    }

    public void V(a aVar) {
        this.f573z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        switch (this.f573z) {
            case MATRIX:
                N();
                break;
            case INDUSTRIAL:
                R();
                break;
            case IATA:
                Q();
                break;
            case DATA_LOGIC:
                M();
                break;
            case INTERLEAVED:
                T(false);
                break;
            case INTERLEAVED_WITH_CHECK_DIGIT:
                T(true);
                break;
            case ITF14:
                U();
                break;
            case DP_LEITCODE:
                P();
                break;
            case DP_IDENTCODE:
                O();
                break;
        }
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f572A;
    }
}
