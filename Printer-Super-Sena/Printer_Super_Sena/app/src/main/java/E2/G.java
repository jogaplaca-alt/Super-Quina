package E2;

/* JADX INFO: loaded from: classes.dex */
public class G extends Q {
    @Override // E2.Q
    protected void c() {
        if (this.f413l.length() > 17) {
            throw new H("Input data too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        String str = "";
        for (int i3 = 0; i3 < 17 - this.f413l.length(); i3++) {
            str = str + "0";
        }
        String str2 = str + this.f413l;
        int i4 = 0;
        int i5 = 0;
        for (int length = str2.length() - 1; length >= 0; length--) {
            int numericValue = Character.getNumericValue(str2.charAt(length));
            if (i5 % 2 == 0) {
                numericValue *= 3;
            }
            i4 += numericValue;
            i5++;
        }
        int i6 = 10 - (i4 % 10);
        int i7 = i6 != 10 ? i6 : 0;
        w("NVE Check Digit: " + i7);
        this.f413l = "[00]" + str2 + i7;
        C0192h c0192h = new C0192h();
        c0192h.D(Q.a.GS1);
        c0192h.G(this.f410i);
        c0192h.C(this.f413l);
        this.f416o = c0192h.f416o;
        this.f417p = c0192h.f417p;
        this.f418q = c0192h.f418q;
        this.f419r = c0192h.f419r;
        this.f420s = c0192h.f420s;
        this.f421t = c0192h.f421t;
        this.f423v = c0192h.f423v;
        this.f424w = c0192h.f424w;
        u(c0192h.f422u);
    }
}
