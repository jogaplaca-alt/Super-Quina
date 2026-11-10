package K1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: K1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0243l extends AbstractC0242k {
    public static final boolean j(Object[] objArr, Object obj) {
        S1.k.e(objArr, "<this>");
        return n(objArr, obj) >= 0;
    }

    public static List k(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        return (List) l(objArr, new ArrayList());
    }

    public static final Collection l(Object[] objArr, Collection collection) {
        S1.k.e(objArr, "<this>");
        S1.k.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static final int m(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final int n(Object[] objArr, Object obj) {
        S1.k.e(objArr, "<this>");
        int i3 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i3 < length) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i3 < length2) {
            if (S1.k.a(obj, objArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final Appendable o(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, R1.l lVar) throws IOException {
        S1.k.e(objArr, "<this>");
        S1.k.e(appendable, "buffer");
        S1.k.e(charSequence, "separator");
        S1.k.e(charSequence2, "prefix");
        S1.k.e(charSequence3, "postfix");
        S1.k.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i4 = 0;
        for (Object obj : objArr) {
            i4++;
            if (i4 > 1) {
                appendable.append(charSequence);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            X1.c.a(appendable, obj, lVar);
        }
        if (i3 >= 0 && i4 > i3) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String p(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, R1.l lVar) {
        S1.k.e(objArr, "<this>");
        S1.k.e(charSequence, "separator");
        S1.k.e(charSequence2, "prefix");
        S1.k.e(charSequence3, "postfix");
        S1.k.e(charSequence4, "truncated");
        String string = ((StringBuilder) o(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i3, charSequence4, lVar)).toString();
        S1.k.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String q(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, R1.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i4 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i4 & 4) == 0 ? charSequence3 : "";
        int i5 = (i4 & 8) != 0 ? -1 : i3;
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i4 & 32) != 0) {
            lVar = null;
        }
        return p(objArr, charSequence, charSequence5, charSequence6, i5, charSequence7, lVar);
    }

    public static char r(char[] cArr) {
        S1.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object s(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List t(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? u(objArr) : n.d(objArr[0]);
        }
        return n.f();
    }

    public static final List u(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        return new ArrayList(p.e(objArr));
    }
}
