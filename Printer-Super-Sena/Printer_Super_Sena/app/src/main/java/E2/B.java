package E2;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class B extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String[] f290z = {"TTFF", "TDAF", "TDFA", "DTAF", "DTFA", "DDAA", "TADF", "TFTF", "TFDA", "DATF", "DADA", "DFTA", "TAFD", "TFAD", "TFFT", "DAAD", "DAFT", "DFAT", "ATDF", "ADTF", "ADDA", "FTTF", "FTDA", "FDTA", "ATFD", "ADAD", "ADFT", "FTAD", "FTFT", "FDAT", "AADD", "AFTD", "AFDT", "FATD", "FADT", "FFTT"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final char[] f289A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override // E2.Q
    protected void A() {
        int i3;
        this.f423v.clear();
        char c3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 8;
            if (i4 >= this.f417p[c3].length()) {
                this.f421t = ((this.f417p[0].length() - 1) * 2) + 1;
                this.f420s = 8;
                return;
            }
            char cCharAt = this.f417p[c3].charAt(i4);
            if (cCharAt != 'A') {
                i3 = 3;
                if (cCharAt == 'D') {
                    i6 = 5;
                } else if (cCharAt != 'F') {
                    if (cCharAt != 'T') {
                        throw new IllegalStateException("Unknown pattern character: " + cCharAt);
                    }
                    i6 = 2;
                }
                this.f423v.add(new G2.e(i5, i3, 1, i6));
                i5 += 2;
                i4++;
                c3 = 0;
            } else {
                i6 = 5;
            }
            i3 = 0;
            this.f423v.add(new G2.e(i5, i3, 1, i6));
            i5 += 2;
            i4++;
            c3 = 0;
        }
    }

    @Override // E2.Q
    protected void c() {
        String upperCase = this.f413l.toUpperCase(Locale.ENGLISH);
        this.f413l = upperCase;
        if (!upperCase.matches("[0-9A-Z]+")) {
            throw new H("Invalid characters in data");
        }
        StringBuilder sb = new StringBuilder(this.f413l.length());
        for (int i3 = 0; i3 < this.f413l.length(); i3++) {
            sb.append(f290z[G2.a.c(this.f413l.charAt(i3), f289A)]);
        }
        String string = sb.toString();
        w("Encoding: " + string);
        this.f416o = "";
        this.f417p = new String[]{string};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
