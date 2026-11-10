package E2;

/* JADX INFO: loaded from: classes.dex */
public class L extends Q {
    @Override // E2.Q
    protected void c() {
        int length = this.f413l.length();
        C0196l c0196l = new C0196l();
        if (length > 7) {
            throw new H("Input data too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        String str = "-";
        for (int i3 = 1; i3 < 8 - length; i3++) {
            str = str + '0';
        }
        String str2 = str + this.f413l;
        int numericValue = 0;
        for (int i4 = 1; i4 < 8; i4++) {
            numericValue += Character.getNumericValue(str2.charAt(i4)) * i4;
        }
        int i5 = numericValue % 11;
        if (i5 == 11) {
            i5 = 0;
        }
        if (i5 == 10) {
            throw new H("Not a valid PZN identifier");
        }
        w("Check Digit: " + i5);
        String str3 = str2 + ((char) (i5 + 48));
        c0196l.C(str3);
        this.f416o = "PZN" + str3;
        this.f417p = new String[]{c0196l.f417p[0]};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
