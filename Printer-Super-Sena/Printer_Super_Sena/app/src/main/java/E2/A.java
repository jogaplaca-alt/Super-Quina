package E2;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class A extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String[] f288z = {"FFT", "FDA", "DFA", "FAD", "FTF", "DAF", "AFD", "ADF", "TFF", "FTT", "TFT", "DAT", "DTA", "ADT", "TDA", "ATD", "TAD", "TTF", "FFF"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private static final char[] f286A = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private static final char[] f287B = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

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
        if (!upperCase.matches("[0-9A-Z\\-]+")) {
            throw new H("Invalid characters in data");
        }
        String str = "";
        for (int i3 = 0; i3 < this.f413l.length() && str.length() < 20; i3++) {
            char cCharAt = this.f413l.charAt(i3);
            if (cCharAt >= '0' && cCharAt <= '9') {
                str = str + cCharAt;
            }
            if (cCharAt == '-') {
                str = str + cCharAt;
            }
            if (cCharAt >= 'A' && cCharAt <= 'J') {
                str = (str + 'a') + f287B[cCharAt - 'A'];
            }
            if (cCharAt >= 'K' && cCharAt <= 'O') {
                str = (str + 'b') + f287B[cCharAt - 'K'];
            }
            if (cCharAt >= 'U' && cCharAt <= 'Z') {
                str = (str + 'c') + f287B[cCharAt - 'U'];
            }
        }
        for (int length = str.length(); length < 20; length++) {
            str = str + "d";
        }
        String str2 = "FD";
        int iC = 0;
        for (int i4 = 0; i4 < 20; i4++) {
            str2 = str2 + f288z[G2.a.c(str.charAt(i4), f286A)];
            iC += G2.a.c(str.charAt(i4), f287B);
        }
        int i5 = 19 - (iC % 19);
        int i6 = i5 != 19 ? i5 : 0;
        String str3 = (str2 + f288z[G2.a.c(f287B[i6], f286A)]) + "DF";
        w("Encoding: " + str3);
        w("Check Digit: " + i6);
        this.f416o = "";
        this.f417p = new String[]{str3};
        this.f418q = 1;
        this.f419r = new int[]{-1};
    }
}
