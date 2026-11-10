package K1;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: K1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0235d extends AbstractList implements List {
    protected AbstractC0235d() {
    }

    public abstract int j();

    public abstract Object k(int i3);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i3) {
        return k(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return j();
    }
}
