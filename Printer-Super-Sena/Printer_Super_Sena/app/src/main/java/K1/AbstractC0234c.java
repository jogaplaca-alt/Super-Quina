package K1;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: renamed from: K1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0234c extends AbstractCollection implements Collection {
    protected AbstractC0234c() {
    }

    public abstract int j();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return j();
    }
}
