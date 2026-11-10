package E2;

/* JADX INFO: loaded from: classes.dex */
public class K extends Q {
    @Override // E2.Q
    protected void c() {
        if (this.f413l.length() > 6) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in data");
        }
        int numericValue = 0;
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            numericValue = (numericValue * 10) + Character.getNumericValue(this.f413l.charAt(i3));
        }
        if (numericValue < 3 || numericValue > 131070) {
            throw new H("Data out of range");
        }
        String str = "";
        do {
            if ((numericValue & 1) == 0) {
                str = str + "W";
                numericValue = (numericValue - 2) / 2;
            } else {
                str = str + "N";
                numericValue = (numericValue - 1) / 2;
            }
        } while (numericValue != 0);
        String str2 = "";
        for (int length = str.length() - 1; length >= 0; length--) {
            str2 = str.charAt(length) == 'W' ? str2 + "32" : str2 + "12";
        }
        this.f416o = "";
        this.f417p = new String[]{str2};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
