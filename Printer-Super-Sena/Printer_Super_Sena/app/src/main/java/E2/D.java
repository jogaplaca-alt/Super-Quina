package E2;

/* JADX INFO: loaded from: classes.dex */
public class D extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String[] f292A = {"1113313111", "3113111131", "1133111131", "3133111111", "1113311131", "3113311111", "1133311111", "1113113131", "3113113111", "1133113111", "3111131131", "1131131131", "3131131111", "1111331131", "3111331111", "1131331111", "1111133131", "3111133111", "1131133111", "1111333111", "3111111331", "1131111331", "3131111311", "1111311331", "3111311311", "1131311311", "1111113331", "3111113311", "1131113311", "1111313311", "3311111131", "1331111131", "3331111111", "1311311131", "3311311111", "1331311111", "1311113131", "3311113111", "1331113111", "1313131111", "1313111311", "1311131311", "1113131311"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final char[] f293B = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$', '/', '+', '%'};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double f294z = 3.0d;

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9A-Z\\. \\-$/+%]*")) {
            throw new H("Invalid characters in input");
        }
        int length = this.f413l.length();
        String str = "";
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iC = G2.a.c(this.f413l.charAt(i4), f293B);
            i3 += iC;
            str = str + f292A[iC];
        }
        int i5 = i3 % 43;
        char c3 = f293B[i5];
        w("Check Digit: " + c3);
        String str2 = str + f292A[i5];
        this.f416o = this.f413l + c3;
        this.f417p = new String[]{"1311313111" + str2 + "131131311"};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f294z;
    }
}
