package E2;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class P extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String[] f400z = {"TTFF", "TDAF", "TDFA", "DTAF", "DTFA", "DDAA", "TADF", "TFTF", "TFDA", "DATF", "DADA", "DFTA", "TAFD", "TFAD", "TFFT", "DAAD", "DAFT", "DFAT", "ATDF", "ADTF", "ADDA", "FTTF", "FTDA", "FDTA", "ATFD", "ADAD", "ADFT", "FTAD", "FTFT", "FDAT", "AADD", "AFTD", "AFDT", "FATD", "FADT", "FFTT"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final char[] f399A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override // E2.Q
    protected void A() {
        this.f423v.clear();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (char c3 = 0; i3 < this.f417p[c3].length(); c3 = 0) {
            char cCharAt = this.f417p[c3].charAt(i3);
            if (cCharAt != 'A') {
                if (cCharAt == 'D') {
                    i5 = 3;
                } else if (cCharAt == 'F') {
                    i5 = 0;
                    i6 = 8;
                } else if (cCharAt == 'T') {
                    i5 = 3;
                    i6 = 2;
                }
                this.f423v.add(new G2.e(i4, i5, 1, i6));
                i4 += 2;
                i3++;
            } else {
                i5 = 0;
            }
            i6 = 5;
            this.f423v.add(new G2.e(i4, i5, 1, i6));
            i4 += 2;
            i3++;
        }
        this.f421t = this.f417p[0].length() * 3;
        this.f420s = 8;
    }

    @Override // E2.Q
    protected void c() {
        String upperCase = this.f413l.toUpperCase(Locale.ENGLISH);
        this.f413l = upperCase;
        if (!upperCase.matches("[0-9A-Z]+")) {
            throw new H("Invalid characters in data");
        }
        String str = "A";
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f413l.length(); i5++) {
            int iC = G2.a.c(this.f413l.charAt(i5), f399A);
            str = str + f400z[iC];
            i3 += (iC + 1) % 6;
            i4 += ((iC / 6) + 1) % 6;
        }
        int i6 = (i3 % 6) - 1;
        int i7 = (i4 % 6) - 1;
        if (i6 == -1) {
            i6 = 5;
        }
        if (i7 == -1) {
            i7 = 5;
        }
        int i8 = (i6 * 6) + i7;
        String str2 = str + f400z[i8];
        w("Check Digit: " + i8);
        String str3 = str2 + "F";
        w("Encoding: " + str3);
        this.f416o = "";
        this.f417p = new String[]{str3};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
