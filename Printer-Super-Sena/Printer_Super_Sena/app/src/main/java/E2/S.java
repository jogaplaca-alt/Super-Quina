package E2;

/* JADX INFO: loaded from: classes.dex */
public class S extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final String[] f430A = {"1111111111111111", "1131313111", "33313111", "1111313131", "3111313111", "11333131", "13133131", "111111313111", "31333111", "1131113131", "33113131", "1111333111", "3111113131", "1113133111", "1311133111", "111111113131", "3131113111", "11313331", "333331", "111131113111", "31113331", "1133113111", "1313113111", "1111113331", "31131331", "113111113111", "3311113111", "1111131331", "311111113111", "1113111331", "1311111331", "11111111113111", "31313311", "1131311131", "33311131", "1111313311", "3111311131", "11333311", "13133311", "111111311131", "31331131", "1131113311", "33113311", "1111331131", "3111113311", "1113131131", "1311131131", "111111113311", "3131111131", "1131131311", "33131311", "111131111131", "3111131311", "1133111131", "1313111131", "111111131311", "3113111311", "113111111131", "3311111131", "111113111311", "311111111131", "111311111311", "131111111311", "11111111111131", "3131311111", "11313133", "333133", "111131311111", "31113133", "1133311111", "1313311111", "1111113133", "313333", "113111311111", "3311311111", "11113333", "311111311111", "11131333", "13111333", "11111111311111", "31311133", "1131331111", "33331111", "1111311133", "3111331111", "11331133", "13131133", "111111331111", "3113131111", "1131111133", "33111133", "111113131111", "3111111133", "111311131111", "131111131111", "111111111133", "31311313", "113131111111", "3331111111", "1111311313", "311131111111", "11331313", "13131313", "11111131111111", "3133111111", "1131111313", "33111313", "111133111111", "3111111313", "111313111111", "131113111111", "111111111313", "313111111111", "1131131113", "33131113", "11113111111111", "3111131113", "113311111111", "131311111111", "111111131113", "3113111113", "11311111111111", "331111111111", "111113111113", "31111111111111", "111311111113", "131111111113"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f431z = a.NORMAL;

    public enum a {
        NORMAL,
        NUMERIC
    }

    private void L() {
        int length = this.f413l.length();
        if (!this.f413l.matches("[\u0000-\u007f]+")) {
            throw new H("Invalid characters in input data");
        }
        String str = f430A[95];
        String str2 = "";
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = this.f413l.charAt(i4);
            str2 = str2 + f430A[cCharAt];
            i3 += cCharAt;
        }
        int i5 = 127 - (i3 % 127);
        if (i5 == 127) {
            i5 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        String[] strArr = f430A;
        sb.append(strArr[i5]);
        String string = sb.toString();
        w("Check Digit: " + i5);
        String str3 = (str + string) + strArr[122];
        this.f416o = this.f413l;
        this.f417p = new String[]{str3};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    private void M() {
        String str;
        int length = this.f413l.length();
        if (!this.f413l.matches("[0-9X]+")) {
            throw new H("Invalid characters in input");
        }
        if ((length & 1) == 1) {
            str = "0" + this.f413l;
            length++;
        } else {
            str = this.f413l;
        }
        String str2 = f430A[95];
        String str3 = "";
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 2) {
            char cCharAt = str.charAt(i4);
            char cCharAt2 = str.charAt(i4 + 1);
            if (cCharAt == 'X') {
                throw new H("Invalid position of X in data");
            }
            int i5 = cCharAt2 == 'X' ? cCharAt - 31 : ((cCharAt - '0') * 10) + (cCharAt2 - '0') + 27;
            i3 += i5;
            str3 = str3 + f430A[i5];
        }
        int i6 = 127 - (i3 % 127);
        if (i6 == 127) {
            i6 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String[] strArr = f430A;
        sb.append(strArr[i6]);
        String string = sb.toString();
        w("Check Digit: " + i6);
        String str4 = (str2 + string) + strArr[122];
        this.f416o = this.f413l;
        this.f417p = new String[]{str4};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }

    public void N(a aVar) {
        this.f431z = aVar;
    }

    @Override // E2.Q
    protected void c() {
        if (this.f431z == a.NORMAL) {
            L();
        } else {
            M();
        }
    }
}
