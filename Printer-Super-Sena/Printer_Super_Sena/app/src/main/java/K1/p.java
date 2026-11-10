package K1;

import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends o {
    public static final Collection e(Object[] objArr) {
        S1.k.e(objArr, "<this>");
        return new C0237f(objArr, false);
    }

    public static List f() {
        return z.f1221a;
    }

    public static final int g(List list) {
        S1.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static List h(Object... objArr) {
        S1.k.e(objArr, "elements");
        return objArr.length > 0 ? AbstractC0242k.c(objArr) : n.f();
    }

    public static final List i(List list) {
        S1.k.e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : n.d(list.get(0));
        }
        return n.f();
    }

    public static void j() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
