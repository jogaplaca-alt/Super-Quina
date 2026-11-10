package E2;

/* JADX INFO: renamed from: E2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0189e extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String[] f498A = {"11111221", "11112211", "11121121", "22111111", "11211211", "21111211", "12111121", "12112111", "12211111", "21121111", "11122111", "11221111", "21112121", "21211121", "21212111", "11212121", "11221211", "12121121", "11121221", "11122211"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final char[] f499B = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '$', ':', '/', '.', '+', 'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double f500z = 2.0d;

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[A-D]{1}[0-9:/\\$\\.\\+-]+[A-D]{1}")) {
            throw new H("Invalid characters in input");
        }
        int length = this.f413l.length();
        String str = "";
        for (int i3 = 0; i3 < length; i3++) {
            str = str + f498A[G2.a.c(this.f413l.charAt(i3), f499B)];
        }
        this.f416o = this.f413l;
        this.f417p = new String[]{str};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f500z;
    }
}
