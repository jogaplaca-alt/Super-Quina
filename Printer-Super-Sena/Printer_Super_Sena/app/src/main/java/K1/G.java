package K1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class G extends F {
    public static Map g() {
        A a3 = A.f1210a;
        S1.k.c(a3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return a3;
    }

    public static Object h(Map map, Object obj) {
        S1.k.e(map, "<this>");
        return E.a(map, obj);
    }

    public static final Map i(Map map) {
        S1.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : F.f(map);
        }
        return D.g();
    }

    public static final void j(Map map, Iterable iterable) {
        S1.k.e(map, "<this>");
        S1.k.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            J1.g gVar = (J1.g) it.next();
            map.put(gVar.a(), gVar.b());
        }
    }

    public static Map k(Iterable iterable) {
        S1.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i(l(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return D.g();
        }
        if (size != 1) {
            return l(iterable, new LinkedHashMap(D.d(collection.size())));
        }
        return F.e((J1.g) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map l(Iterable iterable, Map map) {
        S1.k.e(iterable, "<this>");
        S1.k.e(map, "destination");
        j(map, iterable);
        return map;
    }

    public static Map m(Map map) {
        S1.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? n(map) : F.f(map);
        }
        return D.g();
    }

    public static final Map n(Map map) {
        S1.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
