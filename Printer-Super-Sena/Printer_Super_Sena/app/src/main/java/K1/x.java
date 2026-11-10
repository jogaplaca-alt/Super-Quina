package K1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends w {
    public static List m(Iterable iterable) {
        S1.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listQ = q(iterable);
            t.l(listQ);
            return listQ;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return n.p(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        AbstractC0242k.i((Comparable[]) array);
        return AbstractC0242k.c(array);
    }

    public static final Collection n(Iterable iterable, Collection collection) {
        S1.k.e(iterable, "<this>");
        S1.k.e(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static int[] o(Collection collection) {
        S1.k.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = ((Number) it.next()).intValue();
            i3++;
        }
        return iArr;
    }

    public static List p(Iterable iterable) {
        S1.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return p.i(q(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return n.f();
        }
        if (size != 1) {
            return r(collection);
        }
        return n.d(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List q(Iterable iterable) {
        S1.k.e(iterable, "<this>");
        return iterable instanceof Collection ? r((Collection) iterable) : (List) n(iterable, new ArrayList());
    }

    public static final List r(Collection collection) {
        S1.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static List s(Iterable iterable, Iterable iterable2) {
        S1.k.e(iterable, "<this>");
        S1.k.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(n.k(iterable, 10), n.k(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(J1.i.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
