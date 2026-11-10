package E2;

/* JADX INFO: renamed from: E2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0199o extends Q {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f605B = {"bU", "aA", "aB", "aC", "aD", "aE", "aF", "aG", "aH", "aI", "aJ", "aK", "aL", "aM", "aN", "aO", "aP", "aQ", "aR", "aS", "aT", "aU", "aV", "aW", "aX", "aY", "aZ", "bA", "bB", "bC", "bD", "bE", " ", "cA", "cB", "cC", "$", "%", "cF", "cG", "cH", "cI", "cJ", "+", "cL", "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "cZ", "bF", "bG", "bH", "bI", "bJ", "bV", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bK", "bL", "bM", "bN", "bO", "bW", "dA", "dB", "dC", "dD", "dE", "dF", "dG", "dH", "dI", "dJ", "dK", "dL", "dM", "dN", "dO", "dP", "dQ", "dR", "dS", "dT", "dU", "dV", "dW", "dX", "dY", "dZ", "bP", "bQ", "bR", "bS", "bT"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final char[] f606C = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$', '/', '+', '%', 'a', 'b', 'c', 'd'};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String[] f607D = {"131112", "111213", "111312", "111411", "121113", "121212", "121311", "111114", "131211", "141111", "211113", "211212", "211311", "221112", "221211", "231111", "112113", "112212", "112311", "122112", "132111", "111123", "111222", "111321", "121122", "131121", "212112", "212211", "211122", "211221", "221121", "222111", "112122", "112221", "122121", "123111", "121131", "311112", "311211", "321111", "112131", "113121", "211131", "121221", "312111", "311121", "122211"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private Character f608A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f609z = true;

    private static int L(int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            i4 += iArr[i6] * i5;
            i5++;
            if (i5 == 21) {
                i5 = 1;
            }
        }
        return i4 % 47;
    }

    private static int M(int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            i4 += iArr[i6] * i5;
            i5++;
            if (i5 == 16) {
                i5 = 1;
            }
        }
        return i4 % 47;
    }

    private static char[] N(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c3 : str.toCharArray()) {
            sb.append(f605B[c3]);
        }
        return sb.toString().toCharArray();
    }

    private static String O(int[] iArr) {
        StringBuilder sb = new StringBuilder("111141");
        for (int i3 : iArr) {
            sb.append(f607D[i3]);
        }
        sb.append("1111411");
        return sb.toString();
    }

    @Override // E2.Q
    protected void c() {
        char[] cArrN = N(this.f413l);
        int length = cArrN.length;
        if (!this.f413l.matches("[\u0000-\u007f]+")) {
            throw new H("Invalid characters in input data");
        }
        int[] iArr = new int[cArrN.length + 2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = G2.a.c(cArrN[i3], f606C);
        }
        int iL = L(iArr, length);
        iArr[length] = iL;
        int i4 = length + 1;
        int iM = M(iArr, i4);
        iArr[i4] = iM;
        this.f416o = this.f413l;
        if (this.f609z) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f416o);
            char[] cArr = f606C;
            sb.append(cArr[iL]);
            sb.append(cArr[iM]);
            this.f416o = sb.toString();
        }
        if (this.f608A != null) {
            this.f416o = this.f608A + this.f416o + this.f608A;
        }
        w("Check Digit C: " + iL);
        w("Check Digit K: " + iM);
        this.f417p = new String[]{O(iArr)};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
