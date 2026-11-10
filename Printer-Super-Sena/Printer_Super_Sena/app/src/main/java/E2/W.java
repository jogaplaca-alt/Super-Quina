package E2;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class W extends Q {
    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        this.f424w.clear();
        boolean z3 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (char c3 = 0; i3 < this.f417p[c3].length(); c3 = 0) {
            int iCharAt = this.f417p[c3].charAt(i3) - '0';
            if (z3) {
                int i6 = this.f419r[c3];
                if (i6 == -1) {
                    i6 = this.f405d;
                }
                if (iCharAt != 0 && i6 != 0) {
                    this.f423v.add(new G2.e(i5 + 20, 15, iCharAt, i6));
                }
                this.f421t = i5 + iCharAt + 40;
                i4 = i6;
            } else {
                z3 = z3;
            }
            z3 = !z3;
            i5 += iCharAt;
            i3++;
        }
        this.f420s = i4 + 30;
        G2.e eVar = new G2.e(0.0d, 0.0d, this.f421t, 2.0d);
        G2.e eVar2 = new G2.e(0.0d, this.f420s - 2, this.f421t, 2.0d);
        this.f423v.add(eVar);
        this.f423v.add(eVar2);
        List list = this.f424w;
        double d3 = this.f420s;
        Double.isNaN(d3);
        list.add(new T(0.0d, d3 - 6.0d, this.f421t, this.f416o, this.f411j));
        this.f424w.add(new T(0.0d, 12.0d, this.f421t, "USPS TRACKING #", this.f411j));
    }

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9\\[\\]]+")) {
            throw new H("Invalid IMpb data");
        }
        if (this.f413l.length() % 2 != 0) {
            throw new H("Invalid IMpb data");
        }
        C0192h c0192h = new C0192h();
        c0192h.V();
        c0192h.D(Q.a.GS1);
        c0192h.C(this.f413l);
        boolean z3 = this.f413l.length() > 4 && this.f413l.charAt(1) == '4' && this.f413l.charAt(2) == '2' && this.f413l.charAt(3) == '0';
        String str = "";
        String str2 = "";
        int i3 = 0;
        for (int i4 = 0; i4 < this.f413l.length(); i4++) {
            if (this.f413l.charAt(i4) == '[') {
                i3++;
            }
            if ((!z3 || i3 >= 2) && this.f413l.charAt(i4) >= '0' && this.f413l.charAt(i4) <= '9') {
                str2 = str2 + this.f413l.charAt(i4);
            }
        }
        for (int i5 = 0; i5 < str2.length(); i5++) {
            String str3 = str + str2.charAt(i5);
            if (i5 % 4 == 3) {
                str3 = str3 + " ";
            }
            str = str3;
        }
        this.f422u = c0192h.f422u;
        this.f416o = str;
        this.f417p = new String[]{c0192h.f417p[0]};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
