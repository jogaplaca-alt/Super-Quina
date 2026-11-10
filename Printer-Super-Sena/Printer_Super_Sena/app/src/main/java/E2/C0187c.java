package E2;

/* JADX INFO: renamed from: E2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0187c extends Q {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f492z = {1, 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 29, 1, 0, 0, 0, 0, 0, 0, 0, 1, 9, 28, 1, 0, 1, 1, 1, 1, 1, 0, 1, 10, 27, 1, 0, 1, 0, 0, 0, 1, 0, 1, 11, 26, 1, 0, 1, 0, 1, 0, 1, 0, 1, 12, 25, 1, 0, 1, 0, 0, 0, 1, 0, 1, 13, 24, 1, 0, 1, 1, 1, 1, 1, 0, 1, 14, 23, 1, 0, 0, 0, 0, 0, 0, 0, 1, 15, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 22, 21, 20, 19, 18, 17, 16, 0, 0};

    @Override // E2.Q
    protected void c() {
        int iCharAt;
        int iCharAt2;
        char cCharAt;
        if (!this.f413l.matches("[0-9]+")) {
            throw new H("Invalid input data");
        }
        int length = this.f413l.length();
        if (length != 1) {
            if (length == 2) {
                iCharAt2 = (this.f413l.charAt(0) - '0') * 10;
                cCharAt = this.f413l.charAt(1);
            } else {
                if (length != 3) {
                    throw new H("Input too large");
                }
                iCharAt2 = ((this.f413l.charAt(0) - '0') * 100) + ((this.f413l.charAt(1) - '0') * 10);
                cCharAt = this.f413l.charAt(2);
            }
            iCharAt = iCharAt2 + (cCharAt - '0');
        } else {
            iCharAt = this.f413l.charAt(0) - '0';
        }
        if (iCharAt > 255) {
            throw new H("Input too large");
        }
        StringBuilder sb = new StringBuilder(28);
        for (int i3 = 128; i3 > 0; i3 >>= 1) {
            if ((iCharAt & i3) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        int[] iArr = new int[3];
        iArr[0] = 0;
        iArr[1] = 0;
        for (int i4 = 0; i4 < 2; i4++) {
            int i5 = i4 * 4;
            if (sb.charAt(i5) == '1') {
                iArr[i4] = iArr[i4] + 8;
            }
            if (sb.charAt(i5 + 1) == '1') {
                iArr[i4] = iArr[i4] + 4;
            }
            if (sb.charAt(i5 + 2) == '1') {
                iArr[i4] = iArr[i4] + 2;
            }
            if (sb.charAt(i5 + 3) == '1') {
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int[] iArr2 = new int[6];
        O o3 = new O();
        o3.d(19);
        o3.c(5, 1);
        o3.a(2, iArr);
        for (int i6 = 0; i6 < 5; i6++) {
            iArr2[i6] = o3.b(i6);
        }
        for (int i7 = 0; i7 < 5; i7++) {
            int i8 = 4 - i7;
            if ((iArr2[i8] & 8) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if ((iArr2[i8] & 4) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if ((iArr2[i8] & 2) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            if ((iArr2[i8] & 1) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        StringBuilder sb2 = new StringBuilder(28);
        for (int i9 = 0; i9 < sb.length(); i9++) {
            if ((i9 & 1) != 0) {
                sb2.append(sb.charAt(i9));
            } else if (sb.charAt(i9) == '0') {
                sb2.append('1');
            } else {
                sb2.append('0');
            }
        }
        w("Binary: " + ((Object) sb2));
        this.f416o = "";
        this.f417p = new String[11];
        this.f418q = 11;
        this.f419r = new int[11];
        for (int i10 = 0; i10 < 11; i10++) {
            StringBuilder sb3 = new StringBuilder(11);
            for (int i11 = 0; i11 < 11; i11++) {
                int[] iArr3 = f492z;
                int i12 = (i10 * 11) + i11;
                if (iArr3[i12] == 1) {
                    sb3.append('1');
                }
                if (iArr3[i12] == 0) {
                    sb3.append('0');
                }
                int i13 = iArr3[i12];
                if (i13 >= 2) {
                    sb3.append(sb2.charAt(i13 - 2));
                }
            }
            this.f417p[i10] = Q.a(sb3);
            this.f419r[i10] = 1;
        }
    }
}
