package E2;

/* JADX INFO: renamed from: E2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0196l extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f585B = {"1112212111", "2112111121", "1122111121", "2122111111", "1112211121", "2112211111", "1122211111", "1112112121", "2112112111", "1122112111", "2111121121", "1121121121", "2121121111", "1111221121", "2111221111", "1121221111", "1111122121", "2111122111", "1121122111", "1111222111", "2111111221", "1121111221", "2121111211", "1111211221", "2111211211", "1121211211", "1111112221", "2111112211", "1121112211", "1111212211", "2211111121", "1221111121", "2221111111", "1211211121", "2211211111", "1221211111", "1211112121", "2211112111", "1221112111", "1212121111", "1212111211", "1211121211", "1112121211"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final char[] f586C = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$', '/', '+', '%'};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f588z = a.NONE;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private double f587A = 2.0d;

    /* JADX INFO: renamed from: E2.l$a */
    public enum a {
        NONE,
        MOD43
    }

    public void L(a aVar) {
        this.f588z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9A-Z\\. \\-$/+%]*")) {
            throw new H("Invalid characters in input");
        }
        StringBuilder sb = new StringBuilder(19 + (this.f413l.length() * 10) + (this.f588z != a.MOD43 ? 0 : 10));
        sb.append("1211212111");
        int i3 = 0;
        for (int i4 = 0; i4 < this.f413l.length(); i4++) {
            int iC = G2.a.c(this.f413l.charAt(i4), f586C);
            sb.append(f585B[iC]);
            i3 += iC;
        }
        a aVar = this.f588z;
        a aVar2 = a.MOD43;
        char c3 = ' ';
        if (aVar == aVar2) {
            char[] cArr = f586C;
            char c4 = cArr[i3 % 43];
            sb.append(f585B[G2.a.c(c4, cArr)]);
            c3 = c4 == ' ' ? '_' : c4;
            w("Check Digit: " + c3);
        }
        sb.append("121121211");
        if (this.f588z == aVar2) {
            this.f416o = "*" + this.f413l + c3 + "*";
        } else {
            this.f416o = "*" + this.f413l + "*";
        }
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f587A;
    }
}
