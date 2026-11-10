package L1;

import K1.AbstractC0236e;
import S1.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbstractC0236e {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return k((Map.Entry) obj);
        }
        return false;
    }

    public final boolean k(Map.Entry entry) {
        k.e(entry, "element");
        return l(entry);
    }

    public abstract boolean l(Map.Entry entry);

    public abstract /* bridge */ boolean m(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return m((Map.Entry) obj);
        }
        return false;
    }
}
