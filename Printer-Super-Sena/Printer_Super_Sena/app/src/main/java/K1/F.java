package K1;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class F extends E {
    public static Map b(Map map) {
        S1.k.e(map, "builder");
        return ((L1.d) map).i();
    }

    public static Map c() {
        return new L1.d();
    }

    public static int d(int i3) {
        if (i3 < 0) {
            return i3;
        }
        if (i3 < 3) {
            return i3 + 1;
        }
        if (i3 < 1073741824) {
            return (int) ((i3 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map e(J1.g gVar) {
        S1.k.e(gVar, "pair");
        Map mapSingletonMap = Collections.singletonMap(gVar.c(), gVar.d());
        S1.k.d(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final Map f(Map map) {
        S1.k.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        S1.k.d(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
