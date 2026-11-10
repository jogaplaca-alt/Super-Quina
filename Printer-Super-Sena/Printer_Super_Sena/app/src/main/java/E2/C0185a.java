package E2;

/* JADX INFO: renamed from: E2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0185a extends Q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final char[] f458A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '#'};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final String[] f459B = {"00", "01", "02", "10", "11", "12", "20", "21", "22", "30"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private static final String[] f460C = {"222", "300", "301", "302", "310", "311", "312", "320", "321", "322", "000", "001", "002", "010", "011", "012", "020", "021", "022", "100", "101", "102", "110", "111", "112", "120", "121", "122", "200", "201", "202", "210", "211", "212", "220", "221", "023", "030", "031", "032", "033", "103", "113", "123", "130", "131", "132", "133", "203", "213", "223", "230", "231", "232", "233", "303", "313", "323", "330", "331", "332", "333", "003", "013"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final String[] f461D = {"000", "001", "002", "003", "010", "011", "012", "013", "020", "021", "022", "023", "030", "031", "032", "033", "100", "101", "102", "103", "110", "111", "112", "113", "120", "121", "122", "123", "130", "131", "132", "133", "200", "201", "202", "203", "210", "211", "212", "213", "220", "221", "222", "223", "230", "231", "232", "233", "300", "301", "302", "303", "310", "311", "312", "313", "320", "321", "322", "323", "330", "331", "332", "333"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private EnumC0009a f462z = EnumC0009a.AUSPOST;

    /* JADX INFO: renamed from: E2.a$a, reason: collision with other inner class name */
    private enum EnumC0009a {
        AUSPOST,
        AUSREPLY,
        AUSROUTE,
        AUSREDIRECT
    }

    private int L(char c3, int i3) {
        return (c3 - 48) << i3;
    }

    private String M(String str) {
        int i3;
        O o3 = new O();
        int[] iArr = new int[31];
        int i4 = 2;
        int i5 = 0;
        while (true) {
            if (i4 >= str.length()) {
                break;
            }
            iArr[i5] = L(str.charAt(i4), 4) + L(str.charAt(i4 + 1), 2) + L(str.charAt(i4 + 2), 0);
            i4 += 3;
            i5++;
        }
        o3.d(67);
        o3.c(4, 1);
        o3.a(i5, iArr);
        String str2 = "";
        for (i3 = 4; i3 > 0; i3--) {
            str2 = str2 + f461D[o3.b(i3 - 1)];
        }
        return str2;
    }

    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (char c3 = 0; i3 < this.f417p[c3].length(); c3 = 0) {
            switch (this.f417p[c3].charAt(i3)) {
                case '0':
                    i5 = 0;
                    i6 = 8;
                    continue;
                    this.f423v.add(new G2.e(i4, i5, 1, i6));
                    i4 += 2;
                    i3++;
                    break;
                case '1':
                    i5 = 0;
                    break;
                case '2':
                    i5 = 3;
                    break;
                case '3':
                    i5 = 3;
                    i6 = 2;
                    continue;
                    this.f423v.add(new G2.e(i4, i5, 1, i6));
                    i4 += 2;
                    i3++;
                    break;
                default:
                    continue;
                    this.f423v.add(new G2.e(i4, i5, 1, i6));
                    i4 += 2;
                    i3++;
                    break;
            }
            i6 = 5;
            this.f423v.add(new G2.e(i4, i5, 1, i6));
            i4 += 2;
            i3++;
        }
        this.f421t = ((this.f417p[0].length() - 1) * 2) + 1;
        this.f420s = 8;
    }

    public void N() {
        this.f462z = EnumC0009a.AUSPOST;
    }

    public void O() {
        this.f462z = EnumC0009a.AUSREDIRECT;
    }

    public void P() {
        this.f462z = EnumC0009a.AUSREPLY;
    }

    public void Q() {
        this.f462z = EnumC0009a.AUSROUTE;
    }

    /* JADX WARN: Code duplicated, block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0160 A[LOOP:4: B:68:0x015a->B:70:0x0160, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0186 A[LOOP:5: B:71:0x0180->B:73:0x0186, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x0160, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x0186, please report this as an issue */
    @Override // E2.Q
    protected void c() {
        String str;
        String str2;
        int iOrdinal = this.f462z.ordinal();
        int i3 = 8;
        if (iOrdinal == 0) {
            int length = this.f413l.length();
            if (length != 8) {
                String str3 = "59";
                if (length != 13) {
                    if (length != 16) {
                        str3 = "62";
                        if (length != 18) {
                            if (length != 23) {
                                throw new H("Auspost input is wrong length");
                            }
                            if (!this.f413l.matches("[0-9]+")) {
                                throw new H("Invalid characters in data");
                            }
                        }
                    } else if (!this.f413l.matches("[0-9]+")) {
                        throw new H("Invalid characters in data");
                    }
                }
                str = str3;
            } else {
                str = "11";
            }
        } else if (iOrdinal == 1) {
            if (this.f413l.length() > 8) {
                throw new H("Auspost input is too long");
            }
            str = "45";
        } else if (iOrdinal == 2) {
            if (this.f413l.length() > 8) {
                throw new H("Auspost input is too long");
            }
            str = "87";
        } else if (iOrdinal != 3) {
            str = "00";
        } else {
            if (this.f413l.length() > 8) {
                throw new H("Auspost input is too long");
            }
            str = "92";
        }
        w("FCC: " + str);
        if (this.f462z != EnumC0009a.AUSPOST) {
            str2 = "";
            for (int length2 = this.f413l.length(); length2 < 8; length2++) {
                str2 = str2 + "0";
            }
        } else {
            str2 = "";
        }
        String str4 = str2 + this.f413l;
        if (!this.f413l.matches("[0-9A-Za-z #]+")) {
            throw new H("Invalid characters in data");
        }
        String strSubstring = str4.substring(0, 8);
        if (!strSubstring.matches("[0-9]+")) {
            throw new H("Invalid characters in DPID");
        }
        w("DPID: " + strSubstring);
        String str5 = "13";
        int i4 = 0;
        for (int i5 = 2; i4 < i5; i5 = 2) {
            str5 = str5 + f459B[str.charAt(i4) - '0'];
            i4++;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            str5 = str5 + f459B[strSubstring.charAt(i6) - '0'];
        }
        int length3 = str4.length();
        if (length3 == 13) {
            while (i3 < str4.length()) {
                str5 = str5 + f460C[G2.a.c(str4.charAt(i3), f458A)];
                i3++;
            }
        } else if (length3 == 16) {
            while (i3 < str4.length()) {
                str5 = str5 + f459B[G2.a.c(str4.charAt(i3), f458A)];
                i3++;
            }
        } else if (length3 == 18) {
            while (i3 < str4.length()) {
                str5 = str5 + f460C[G2.a.c(str4.charAt(i3), f458A)];
                i3++;
            }
        } else if (length3 == 23) {
            while (i3 < str4.length()) {
                str5 = str5 + f459B[G2.a.c(str4.charAt(i3), f458A)];
                i3++;
            }
        }
        int length4 = str5.length();
        if (length4 == 22 || length4 == 37 || length4 == 52) {
            str5 = str5 + "3";
        }
        String str6 = (str5 + M(str5)) + "13";
        w("Total Length: " + str6.length());
        u("Encoding: ");
        for (int i7 = 0; i7 < str6.length(); i7++) {
            switch (str6.charAt(i7)) {
                case '0':
                    u("F");
                    break;
                case '1':
                    u("A");
                    break;
                case '2':
                    u("D");
                    break;
                case '3':
                    u("T");
                    break;
            }
        }
        v();
        this.f416o = "";
        this.f417p = new String[]{str6};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
