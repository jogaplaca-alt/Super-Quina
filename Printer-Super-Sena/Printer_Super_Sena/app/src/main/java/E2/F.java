package E2;

/* JADX INFO: loaded from: classes.dex */
public class F extends Q {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f316C = {"12121212", "12121221", "12122112", "12122121", "12211212", "12211221", "12212112", "12212121", "21121212", "21121221"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f319z = a.NONE;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private boolean f317A = true;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private double f318B = 2.0d;

    public enum a {
        NONE,
        MOD10,
        MOD10_MOD10,
        MOD11,
        MOD11_MOD10
    }

    private static int L(String str) {
        int length = str.length() % 2;
        int i3 = 0;
        for (int length2 = str.length() - 1; length2 >= 0; length2--) {
            int iCharAt = str.charAt(length2) - '0';
            if (length2 % 2 != length) {
                int i4 = iCharAt * 2;
                i3 += i4 % 10;
                iCharAt = i4 / 10;
            }
            i3 += iCharAt;
        }
        int i5 = 10 - (i3 % 10);
        if (i5 == 10) {
            return 0;
        }
        return i5;
    }

    private static int M(String str) {
        int iCharAt = 0;
        int i3 = 2;
        for (int length = str.length() - 1; length >= 0; length--) {
            iCharAt += (str.charAt(length) - '0') * i3;
            i3++;
            if (i3 == 8) {
                i3 = 2;
            }
        }
        int i4 = 11 - (iCharAt % 11);
        if (i4 == 11) {
            return 0;
        }
        return i4;
    }

    private static int N(a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i3 = 1;
        if (iOrdinal != 1) {
            i3 = 2;
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal == 4) {
                    return 3;
                }
                throw new IllegalStateException("Unknown check digit scheme: " + aVar);
            }
        }
        return i3;
    }

    @Override // E2.Q
    protected void c() {
        if (!this.f413l.matches("[0-9]*")) {
            throw new H("Invalid characters in input");
        }
        int length = this.f413l.length();
        StringBuilder sb = new StringBuilder(((N(this.f319z) + length) * 8) + 5);
        sb.append("21");
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(f316C[Character.getNumericValue(this.f413l.charAt(i3))]);
        }
        String str = this.f413l;
        a aVar = this.f319z;
        if (aVar == a.MOD10 || aVar == a.MOD10_MOD10) {
            int iL = L(str);
            sb.append(f316C[iL]);
            str = str + iL;
        }
        a aVar2 = this.f319z;
        if (aVar2 == a.MOD11 || aVar2 == a.MOD11_MOD10) {
            int iM = M(this.f413l);
            str = str + iM;
            if (iM == 10) {
                String[] strArr = f316C;
                sb.append(strArr[1]);
                sb.append(strArr[0]);
            } else {
                sb.append(f316C[iM]);
            }
        }
        a aVar3 = this.f319z;
        if (aVar3 == a.MOD10_MOD10 || aVar3 == a.MOD11_MOD10) {
            int iL2 = L(str);
            sb.append(f316C[iL2]);
            str = str + iL2;
        }
        sb.append("121");
        if (!this.f317A) {
            str = this.f413l;
        }
        this.f416o = str;
        this.f417p = new String[]{sb.toString()};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    @Override // E2.Q
    protected double k(int i3) {
        if (i3 == 1) {
            return 1.0d;
        }
        return this.f318B;
    }
}
