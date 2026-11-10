package E2;

/* JADX INFO: renamed from: E2.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0206w extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String[] f797z = {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String[] f794A = {"1123", "1222", "2212", "1141", "2311", "1321", "4111", "2131", "3121", "2113"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f795B = {"AA", "AB", "BA", "BB"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f796C = {"BBAAA", "BABAA", "BAABA", "BAAAB", "ABBAA", "AABBA", "AAABB", "ABABA", "ABAAB", "AABAB"};

    private static String L(String str) {
        String str2 = f795B[(((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0')) % 4];
        StringBuilder sb = new StringBuilder();
        sb.append("112");
        for (int i3 = 0; i3 < 2; i3++) {
            int iCharAt = str.charAt(i3) - '0';
            if (str2.charAt(i3) == 'B') {
                sb.append(f794A[iCharAt]);
            } else {
                sb.append(f797z[iCharAt]);
            }
            if (i3 != 1) {
                sb.append("11");
            }
        }
        return sb.toString();
    }

    private static String M(String str) {
        int iCharAt = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            iCharAt += i3 % 2 == 0 ? (str.charAt(i3) - '0') * 3 : (str.charAt(i3) - '0') * 9;
        }
        String str2 = f796C[iCharAt % 10];
        StringBuilder sb = new StringBuilder();
        sb.append("112");
        for (int i4 = 0; i4 < 5; i4++) {
            int iCharAt2 = str.charAt(i4) - '0';
            if (str2.charAt(i4) == 'B') {
                sb.append(f794A[iCharAt2]);
            } else {
                sb.append(f797z[iCharAt2]);
            }
            if (i4 != 4) {
                sb.append("11");
            }
        }
        return sb.toString();
    }

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid characters in input");
        }
        if (this.f413l.length() > 5) {
            throw new H("Input data too long");
        }
        int i3 = this.f413l.length() <= 2 ? 2 : 5;
        if (this.f413l.length() < i3) {
            for (int length = this.f413l.length(); length < i3; length++) {
                this.f413l = '0' + this.f413l;
            }
        }
        String str = this.f413l;
        String strL = i3 == 2 ? L(str) : M(str);
        this.f416o = this.f413l;
        this.f417p = new String[]{strL};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
