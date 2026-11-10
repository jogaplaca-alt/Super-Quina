package E2;

/* JADX INFO: loaded from: classes.dex */
public class C extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String[] f291z = {"1313150613", "0713131313", "0417131313", "1506131313", "0413171313", "17171313", "1315061313", "0413131713", "17131713", "13171713"};

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        if (this.f413l.length() > 6) {
            throw new H("Input data too long");
        }
        String str = "";
        String str2 = "";
        for (int i3 = 0; i3 < 6 - this.f413l.length(); i3++) {
            str2 = str2 + "0";
        }
        String str3 = str2 + this.f413l;
        int i4 = 0;
        for (int i5 = 0; i5 < str3.length(); i5++) {
            int numericValue = Character.getNumericValue(str3.charAt(i5));
            str = str + f291z[numericValue];
            i4 += numericValue;
        }
        int i6 = 10 - (i4 % 10);
        int i7 = i6 != 10 ? i6 : 0;
        w("Check Digit: " + i7);
        String str4 = str + f291z[i7];
        this.f416o = str3 + i7;
        this.f417p = new String[]{str4};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
