package E2;

/* JADX INFO: loaded from: classes.dex */
public class J extends Q {
    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.f417p[0].length(); i6++) {
            char cCharAt = this.f417p[0].charAt(i6);
            if (cCharAt != 'A') {
                if (cCharAt == 'D') {
                    int i7 = this.f405d;
                    i5 = i7 / 2;
                    i4 = i7 / 2;
                } else if (cCharAt == 'F') {
                    i5 = this.f405d;
                }
                this.f423v.add(new G2.e(i3, i4, 1, i5));
                i3 += 2;
            } else {
                i5 = this.f405d / 2;
            }
            i4 = 0;
            this.f423v.add(new G2.e(i3, i4, 1, i5));
            i3 += 2;
        }
        this.f421t = this.f417p[0].length() * 2;
        this.f420s = this.f405d;
    }

    @Override // E2.Q
    protected void c() {
        if (this.f413l.length() > 8) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in data");
        }
        int numericValue = 0;
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            numericValue = (numericValue * 10) + Character.getNumericValue(this.f413l.charAt(i3));
        }
        if (numericValue < 4 || numericValue > 64570080) {
            throw new H("Data out of range");
        }
        String str = "";
        do {
            int i4 = numericValue % 3;
            if (i4 == 0) {
                str = str + "F";
                numericValue = (numericValue - 3) / 3;
            } else if (i4 == 1) {
                str = str + "D";
                numericValue = (numericValue - 1) / 3;
            } else if (i4 == 2) {
                str = str + "A";
                numericValue = (numericValue - 2) / 3;
            }
        } while (numericValue != 0);
        String str2 = "";
        for (int length = str.length() - 1; length >= 0; length--) {
            str2 = str2 + str.charAt(length);
        }
        w("Encoding: " + str2);
        this.f416o = "";
        this.f417p = new String[]{str2};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
