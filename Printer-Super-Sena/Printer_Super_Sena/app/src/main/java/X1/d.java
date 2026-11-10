package X1;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(Appendable appendable, Object obj, R1.l lVar) throws IOException {
        S1.k.e(appendable, "<this>");
        if (lVar != null) {
            appendable.append((CharSequence) lVar.c(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}
