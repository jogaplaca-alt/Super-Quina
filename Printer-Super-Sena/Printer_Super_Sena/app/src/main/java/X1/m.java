package X1;

import K1.AbstractC0239h;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {
    public static CharSequence A(CharSequence charSequence) {
        S1.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            boolean zA = a.a(charSequence.charAt(!z3 ? i3 : length));
            if (z3) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                i3++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    public static final boolean m(CharSequence charSequence, CharSequence charSequence2, boolean z3) {
        S1.k.e(charSequence, "<this>");
        S1.k.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (t(charSequence, (String) charSequence2, 0, z3, 2, null) < 0) {
                return false;
            }
        } else if (s(charSequence, charSequence2, 0, charSequence.length(), z3, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean n(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return m(charSequence, charSequence2, z3);
    }

    public static final V1.c o(CharSequence charSequence) {
        S1.k.e(charSequence, "<this>");
        return new V1.c(0, charSequence.length() - 1);
    }

    public static final int p(CharSequence charSequence) {
        S1.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int q(CharSequence charSequence, String str, int i3, boolean z3) {
        S1.k.e(charSequence, "<this>");
        S1.k.e(str, "string");
        return (z3 || !(charSequence instanceof String)) ? s(charSequence, str, i3, charSequence.length(), z3, false, 16, null) : ((String) charSequence).indexOf(str, i3);
    }

    private static final int r(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4) {
        V1.a cVar = !z4 ? new V1.c(V1.d.a(i3, 0), V1.d.b(i4, charSequence.length())) : V1.d.c(V1.d.b(i3, p(charSequence)), V1.d.a(i4, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iJ = cVar.j();
            int iK = cVar.k();
            int iL = cVar.l();
            if ((iL <= 0 || iJ > iK) && (iL >= 0 || iK > iJ)) {
                return -1;
            }
            while (!l.f((String) charSequence2, 0, (String) charSequence, iJ, charSequence2.length(), z3)) {
                if (iJ == iK) {
                    return -1;
                }
                iJ += iL;
            }
            return iJ;
        }
        int iJ2 = cVar.j();
        int iK2 = cVar.k();
        int iL2 = cVar.l();
        if ((iL2 <= 0 || iJ2 > iK2) && (iL2 >= 0 || iK2 > iJ2)) {
            return -1;
        }
        while (!x(charSequence2, 0, charSequence, iJ2, charSequence2.length(), z3)) {
            if (iJ2 == iK2) {
                return -1;
            }
            iJ2 += iL2;
        }
        return iJ2;
    }

    static /* synthetic */ int s(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4, int i5, Object obj) {
        return r(charSequence, charSequence2, i3, i4, z3, (i5 & 16) != 0 ? false : z4);
    }

    public static /* synthetic */ int t(CharSequence charSequence, String str, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return q(charSequence, str, i3, z3);
    }

    public static final int u(CharSequence charSequence, char c3, int i3, boolean z3) {
        S1.k.e(charSequence, "<this>");
        return (z3 || !(charSequence instanceof String)) ? w(charSequence, new char[]{c3}, i3, z3) : ((String) charSequence).lastIndexOf(c3, i3);
    }

    public static /* synthetic */ int v(CharSequence charSequence, char c3, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = p(charSequence);
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return u(charSequence, c3, i3, z3);
    }

    public static final int w(CharSequence charSequence, char[] cArr, int i3, boolean z3) {
        S1.k.e(charSequence, "<this>");
        S1.k.e(cArr, "chars");
        if (!z3 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0239h.r(cArr), i3);
        }
        for (int iB = V1.d.b(i3, p(charSequence)); -1 < iB; iB--) {
            char cCharAt = charSequence.charAt(iB);
            for (char c3 : cArr) {
                if (b.b(c3, cCharAt, z3)) {
                    return iB;
                }
            }
        }
        return -1;
    }

    public static final boolean x(CharSequence charSequence, int i3, CharSequence charSequence2, int i4, int i5, boolean z3) {
        S1.k.e(charSequence, "<this>");
        S1.k.e(charSequence2, "other");
        if (i4 < 0 || i3 < 0 || i3 > charSequence.length() - i5 || i4 > charSequence2.length() - i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!b.b(charSequence.charAt(i3 + i6), charSequence2.charAt(i4 + i6), z3)) {
                return false;
            }
        }
        return true;
    }

    public static final String y(String str, char c3, String str2) {
        S1.k.e(str, "<this>");
        S1.k.e(str2, "missingDelimiterValue");
        int iV = v(str, c3, 0, false, 6, null);
        if (iV == -1) {
            return str2;
        }
        String strSubstring = str.substring(iV + 1, str.length());
        S1.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String z(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return y(str, c3, str2);
    }
}
