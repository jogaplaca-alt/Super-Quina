package K1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static List a(List list) {
        S1.k.e(list, "builder");
        return ((L1.b) list).q();
    }

    public static final Object[] b(Object[] objArr, boolean z3) {
        S1.k.e(objArr, "<this>");
        if (z3 && S1.k.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        S1.k.d(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static List c() {
        return new L1.b();
    }

    public static List d(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        S1.k.d(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
