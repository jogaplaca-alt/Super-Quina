package E2;

/* JADX INFO: loaded from: classes.dex */
public class M extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f358B = {"LLSSS", "SSSLL", "SSLSL", "SSLLS", "SLSSL", "SLSLS", "SLLSS", "LSSSL", "LSSLS", "LSLSS"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f359C = {"SSLLL", "LLLSS", "LLSLS", "LLSSL", "LSLLS", "LSLSL", "LSSLL", "SLLLS", "SLLSL", "SLSLL"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f361z = a.POSTNET;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private double f360A = 1.5d;

    public enum a {
        PLANET,
        POSTNET
    }

    public M() {
        this.f405d = 12;
        this.f410i = z.NONE;
    }

    private void L(String[] strArr) {
        if (this.f413l.length() > 38) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        String str = "L";
        int iCharAt = 0;
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            str = str + strArr[this.f413l.charAt(i3) - '0'];
            iCharAt += this.f413l.charAt(i3) - '0';
        }
        int i4 = (10 - (iCharAt % 10)) % 10;
        w("Check Digit: " + i4);
        String str2 = (str + strArr[i4]) + "L";
        w("Encoding: " + str2);
        this.f416o = this.f413l;
        this.f417p = new String[]{str2};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected void A() {
        double d3;
        double d4;
        this.f423v.clear();
        this.f424w.clear();
        z zVar = this.f410i;
        int iQ = zVar == z.TOP ? q() : zVar == z.BOTH ? q() / 2 : 0;
        double d5 = this.f408g;
        double d6 = this.f360A + 1.0d;
        Double.isNaN(d5);
        double d7 = d6 * d5;
        double d8 = this.f405d;
        Double.isNaN(d8);
        int i3 = (int) (d8 * 0.4d);
        double d9 = 0.0d;
        int i4 = 0;
        for (char c3 = 0; i4 < this.f417p[c3].length(); c3 = 0) {
            if (this.f417p[c3].charAt(i4) == 'L') {
                d3 = iQ;
                d4 = this.f405d;
            } else {
                d3 = (this.f405d + iQ) - i3;
                d4 = i3;
            }
            this.f423v.add(new G2.e(d9, d3, d5, d4));
            d9 += d7;
            i4++;
            iQ = iQ;
        }
        double length = this.f417p[0].length() - 1;
        Double.isNaN(length);
        Double.isNaN(d5);
        this.f421t = (int) Math.ceil((length * d7) + d5);
        this.f420s = this.f405d;
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

    public void M(a aVar) {
        this.f361z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        L(this.f361z == a.POSTNET ? f358B : f359C);
    }
}
