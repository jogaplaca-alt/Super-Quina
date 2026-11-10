package K1;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class K {
    public static Set a(Set set) {
        S1.k.e(set, "builder");
        return ((L1.h) set).k();
    }

    public static Set b() {
        return new L1.h();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        S1.k.d(setSingleton, "singleton(element)");
        return setSingleton;
    }
}
