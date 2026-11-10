package E2;

/* JADX INFO: renamed from: E2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0195k extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final char[] f584z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override // E2.Q
    protected void c() {
        int[] iArr = new int[6];
        C0196l c0196l = new C0196l();
        if (this.f413l.length() > 8) {
            throw new H("Input too long");
        }
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        String str = "";
        String str2 = "";
        for (int length = this.f413l.length(); length < 8; length++) {
            str2 = str2 + "0";
        }
        String str3 = str2 + this.f413l;
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i4 * 2;
            int numericValue = i3 + Character.getNumericValue(str3.charAt(i5));
            int numericValue2 = Character.getNumericValue(str3.charAt(i5 + 1)) * 2;
            if (numericValue2 >= 10) {
                numericValue2 -= 9;
            }
            i3 = numericValue + numericValue2;
        }
        char c3 = (char) ((i3 % 10) + 48);
        String str4 = str3 + c3;
        w("Check Digit: " + c3);
        int numericValue3 = 0;
        for (int i6 = 0; i6 < str4.length(); i6++) {
            numericValue3 = (numericValue3 * 10) + Character.getNumericValue(str4.charAt(i6));
        }
        int i7 = 33554432;
        for (int i8 = 5; i8 >= 0; i8--) {
            iArr[i8] = numericValue3 / i7;
            numericValue3 %= i7;
            i7 /= 32;
        }
        for (int i9 = 5; i9 >= 0; i9--) {
            str = str + f584z[iArr[i9]];
        }
        this.f416o = "A" + str4;
        this.f417p = new String[1];
        this.f418q = 1;
        this.f419r = new int[]{-1};
        w("Code 39 Equivalent: " + str);
        c0196l.C(str);
        this.f417p[0] = c0196l.f417p[0];
    }
}
