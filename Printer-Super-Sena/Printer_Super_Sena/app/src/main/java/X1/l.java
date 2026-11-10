package X1;

import K1.C;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends k {
    public static final boolean b(String str, String str2, boolean z3) {
        S1.k.e(str, "<this>");
        S1.k.e(str2, "suffix");
        return !z3 ? str.endsWith(str2) : f(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean c(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return b(str, str2, z3);
    }

    public static boolean d(String str, String str2, boolean z3) {
        if (str == null) {
            return str2 == null;
        }
        return !z3 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean e(CharSequence charSequence) {
        S1.k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable iterableO = m.o(charSequence);
            if (!(iterableO instanceof Collection) || !((Collection) iterableO).isEmpty()) {
                Iterator it = iterableO.iterator();
                while (it.hasNext()) {
                    if (!a.a(charSequence.charAt(((C) it).a()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean f(String str, int i3, String str2, int i4, int i5, boolean z3) {
        S1.k.e(str, "<this>");
        S1.k.e(str2, "other");
        return !z3 ? str.regionMatches(i3, str2, i4, i5) : str.regionMatches(z3, i3, str2, i4, i5);
    }

    public static final String g(String str, char c3, char c4, boolean z3) {
        S1.k.e(str, "<this>");
        if (!z3) {
            String strReplace = str.replace(c3, c4);
            S1.k.d(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (b.b(cCharAt, c3, z3)) {
                cCharAt = c4;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        S1.k.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final String h(String str, String str2, String str3, boolean z3) {
        S1.k.e(str, "<this>");
        S1.k.e(str2, "oldValue");
        S1.k.e(str3, "newValue");
        int i3 = 0;
        int iQ = m.q(str, str2, 0, z3);
        if (iQ < 0) {
            return str;
        }
        int length = str2.length();
        int iA = V1.d.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i3, iQ);
            sb.append(str3);
            i3 = iQ + length;
            if (iQ >= str.length()) {
                break;
            }
            iQ = m.q(str, str2, iQ + iA, z3);
        } while (iQ > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        S1.k.d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String i(String str, char c3, char c4, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return g(str, c3, c4, z3);
    }

    public static /* synthetic */ String j(String str, String str2, String str3, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return h(str, str2, str3, z3);
    }

    public static final boolean k(String str, String str2, boolean z3) {
        S1.k.e(str, "<this>");
        S1.k.e(str2, "prefix");
        return !z3 ? str.startsWith(str2) : f(str, 0, str2, 0, str2.length(), z3);
    }

    public static /* synthetic */ boolean l(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return k(str, str2, z3);
    }
}
