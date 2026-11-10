package E2;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final char[] f401y = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$', '/', '+', '%'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f404c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f413l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int[] f415n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected String[] f417p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int[] f419r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f402a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a f403b = a.ECI;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f405d = 40;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f406e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f407f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f408g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f409h = "Helvetica";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected z f410i = z.BOTTOM;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected y f411j = y.CENTER;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f412k = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f414m = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f416o = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f418q = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f420s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f421t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected StringBuilder f422u = new StringBuilder();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected List f423v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected List f424w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected final List f425x = new ArrayList();

    public enum a {
        ECI,
        GS1,
        HIBC
    }

    protected static int[] K(String str, Charset charset, int... iArr) {
        int length;
        if (!charset.newEncoder().canEncode(str)) {
            return null;
        }
        byte[] bytes = "\\<FNC1>".getBytes(charset);
        byte[] bytes2 = "\\<FNC2>".getBytes(charset);
        byte[] bytes3 = "\\<FNC3>".getBytes(charset);
        byte[] bytes4 = "\\<FNC4>".getBytes(charset);
        byte[] bytes5 = str.getBytes(charset);
        int[] iArr2 = new int[bytes5.length + iArr.length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bytes5.length) {
            if (G2.a.a(bytes5, bytes, i4)) {
                iArr2[i5] = -1;
                length = bytes.length;
            } else if (G2.a.a(bytes5, bytes2, i4)) {
                iArr2[i5] = -2;
                length = bytes.length;
            } else if (G2.a.a(bytes5, bytes3, i4)) {
                iArr2[i5] = -3;
                length = bytes.length;
            } else {
                if (G2.a.a(bytes5, bytes4, i4)) {
                    iArr2[i5] = -4;
                    length = bytes.length;
                } else {
                    iArr2[i5] = bytes5[i4] & 255;
                }
                i4++;
                i5++;
            }
            i4 += length - 1;
            i4++;
            i5++;
        }
        while (i3 < iArr.length) {
            iArr2[i5 + i3] = iArr[i3];
            i3++;
        }
        int i6 = i5 + i3;
        return i6 < i4 ? Arrays.copyOf(iArr2, i6) : iArr2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    protected static String a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        int i3 = 0;
        boolean z3 = true;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (z3) {
                if (charSequence.charAt(i4) == '1') {
                    i3++;
                } else {
                    sb.append((char) (i3 + 48));
                    i3 = 1;
                    z3 = false;
                }
            } else if (charSequence.charAt(i4) == '0') {
                i3++;
            } else {
                sb.append((char) (i3 + 48));
                i3 = 1;
                z3 = true;
            }
        }
        sb.append((char) (i3 + 48));
        return sb.toString();
    }

    private String t(String str) {
        if (str.length() > 110) {
            throw new H("Data too long for HIBC LIC");
        }
        String upperCase = str.toUpperCase();
        if (!upperCase.matches("[A-Z0-9-\\. \\$/+\\%]+?")) {
            throw new H("Invalid characters in input");
        }
        int iC = 41;
        for (int i3 = 0; i3 < upperCase.length(); i3++) {
            iC += G2.a.c(upperCase.charAt(i3), f401y);
        }
        int i4 = iC % 43;
        char c3 = f401y[i4];
        w("HIBC Check Digit Counter: " + i4);
        w("HIBC Check Digit: " + c3);
        return "+" + upperCase + c3;
    }

    protected void A() {
        this.f423v.clear();
        this.f424w.clear();
        z zVar = this.f410i;
        double dQ = zVar == z.TOP ? q() : zVar == z.BOTH ? q() / 2 : 0;
        double d3 = dQ;
        double d4 = 0.0d;
        for (int i3 = 0; i3 < this.f418q; i3++) {
            double d5 = 0.0d;
            int i4 = 0;
            boolean z3 = true;
            while (i4 < this.f417p[i3].length()) {
                double dK = k(this.f417p[i3].charAt(i4) - '0');
                double d6 = this.f408g;
                Double.isNaN(d6);
                double d7 = dK * d6;
                if (z3) {
                    int i5 = this.f419r[i3];
                    if (i5 == -1) {
                        i5 = this.f405d;
                    }
                    double d8 = i5;
                    if (d7 != 0.0d && d8 != 0.0d) {
                        this.f423v.add(new G2.e(d5, d3, d7, d8));
                    }
                    double d9 = d5 + d7;
                    if (d9 > this.f421t) {
                        this.f421t = (int) Math.ceil(d9);
                    }
                    d4 = d8;
                } else {
                    i4 = i4;
                }
                z3 = !z3;
                d5 += d7;
                i4++;
            }
            Double.isNaN(dQ);
            double d10 = (d3 - dQ) + d4;
            if (d10 > this.f420s) {
                this.f420s = (int) Math.ceil(d10);
            }
            d3 += d4;
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
            double d11 = this.f420s;
            double d12 = this.f402a;
            Double.isNaN(d12);
            Double.isNaN(d11);
            this.f424w.add(new T(0.0d, d11 + (d12 * 2.2d), this.f421t, this.f416o, this.f411j));
        }
    }

    public void B(int i3) {
        this.f405d = i3;
    }

    public void C(String str) {
        this.f420s = 0;
        this.f421t = 0;
        if (str == null) {
            str = "";
        }
        this.f422u.setLength(0);
        int iOrdinal = this.f403b.ordinal();
        if (iOrdinal == 1) {
            this.f413l = G2.d.a(str, "\\<FNC1>");
            this.f416o = str.replace('[', '(').replace(']', ')');
        } else if (iOrdinal != 2) {
            this.f413l = str;
        } else {
            this.f413l = t(str);
        }
        if (this.f413l.isEmpty() && !this.f412k) {
            throw new H("No input data");
        }
        c();
        A();
        z();
    }

    public void D(a aVar) {
        if (aVar == a.GS1 && !s()) {
            throw new IllegalArgumentException("This symbology type does not support GS1 data.");
        }
        this.f403b = aVar;
    }

    public void E(int i3) {
        this.f402a = i3;
    }

    public void F(y yVar) {
        this.f411j = yVar;
    }

    public void G(z zVar) {
        this.f410i = zVar;
    }

    public void H(int i3) {
        this.f408g = i3;
    }

    public void I(int i3) {
        this.f406e = i3;
    }

    public void J(int i3) {
        this.f407f = i3;
    }

    protected void b() {
        G2.c cVarB = G2.c.a(this.f413l, "ISO8859_1", 3).b(this.f413l, "ISO8859_2", 4).b(this.f413l, "ISO8859_3", 5).b(this.f413l, "ISO8859_4", 6).b(this.f413l, "ISO8859_5", 7).b(this.f413l, "ISO8859_6", 8).b(this.f413l, "ISO8859_7", 9).b(this.f413l, "ISO8859_8", 10).b(this.f413l, "ISO8859_9", 11).b(this.f413l, "ISO8859_10", 12).b(this.f413l, "ISO8859_11", 13).b(this.f413l, "ISO8859_13", 15).b(this.f413l, "ISO8859_14", 16).b(this.f413l, "ISO8859_15", 17).b(this.f413l, "ISO8859_16", 18).b(this.f413l, "Windows_1250", 21).b(this.f413l, "Windows_1251", 22).b(this.f413l, "Windows_1252", 23).b(this.f413l, "Windows_1256", 24).b(this.f413l, "SJIS", 20).b(this.f413l, "UTF8", 26);
        if (G2.c.f1067c.equals(cVarB)) {
            throw new H("Unable to determine ECI mode.");
        }
        this.f414m = cVarB.f1068a;
        this.f415n = K(this.f413l, cVarB.f1069b, new int[0]);
        w("ECI Mode: " + cVarB.f1068a);
        w("ECI Charset: " + cVarB.f1069b.name());
    }

    protected abstract void c();

    public int d() {
        return this.f405d;
    }

    public String e() {
        return this.f422u.toString();
    }

    public int f() {
        return this.f402a;
    }

    public int g() {
        return this.f420s + i() + (this.f407f * 2);
    }

    public y h() {
        return this.f411j;
    }

    public int i() {
        if (this.f410i == z.NONE) {
            return 0;
        }
        return q();
    }

    public z j() {
        return this.f410i;
    }

    protected double k(int i3) {
        return i3;
    }

    public int l() {
        return this.f408g;
    }

    public int m() {
        return this.f406e;
    }

    public int n() {
        return this.f407f;
    }

    public List o() {
        return this.f423v;
    }

    public List p() {
        return this.f424w;
    }

    protected int q() {
        double d3 = this.f402a;
        Double.isNaN(d3);
        int iCeil = (int) Math.ceil(d3 * 1.2d);
        return this.f410i == z.BOTH ? iCeil * 2 : iCeil;
    }

    public int r() {
        return this.f421t + (this.f406e * 2);
    }

    protected boolean s() {
        return false;
    }

    protected void u(CharSequence charSequence) {
        this.f422u.append(charSequence);
    }

    protected void v() {
        this.f422u.append('\n');
    }

    protected void w(CharSequence charSequence) {
        StringBuilder sb = this.f422u;
        sb.append(charSequence);
        sb.append('\n');
    }

    protected void x(char c3) {
        StringBuilder sb = this.f422u;
        sb.append(c3);
        sb.append(' ');
    }

    protected void y(int i3) {
        StringBuilder sb = this.f422u;
        sb.append(i3);
        sb.append(' ');
    }

    protected void z() {
        int size = this.f423v.size();
        for (int size2 = this.f423v.size() - 1; size2 >= 0; size2--) {
            G2.e eVar = (G2.e) this.f423v.get(size2);
            for (int i3 = size2 - 1; i3 >= 0; i3--) {
                G2.e eVar2 = (G2.e) this.f423v.get(i3);
                if (G2.b.a(eVar.f1072b, eVar2.f1072b + eVar2.f1074d)) {
                    if (!G2.b.a(eVar.f1071a, eVar2.f1071a) || !G2.b.a(eVar.f1073c, eVar2.f1073c)) {
                        if (eVar2.f1071a < eVar.f1071a) {
                            break;
                        }
                    } else {
                        eVar2.f1074d += eVar.f1074d;
                        this.f423v.remove(size2);
                        break;
                    }
                }
            }
        }
        int size3 = this.f423v.size();
        if (size != size3) {
            w("Blocks Merged: " + size + " -> " + size3);
        }
    }
}
