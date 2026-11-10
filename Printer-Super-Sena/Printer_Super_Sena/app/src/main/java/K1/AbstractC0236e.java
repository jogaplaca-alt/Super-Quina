package K1;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: renamed from: K1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0236e extends AbstractSet implements Set {
    protected AbstractC0236e() {
    }

    public abstract int j();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return j();
    }
}
