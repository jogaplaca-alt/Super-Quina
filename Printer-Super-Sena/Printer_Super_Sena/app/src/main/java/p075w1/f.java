package p075w1;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f12682a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).f12682a.equals(this.f12682a));
    }

    public int hashCode() {
        return this.f12682a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f12682a.iterator();
    }

    public void q(i iVar) {
        if (iVar == null) {
            iVar = k.f12683a;
        }
        this.f12682a.add(iVar);
    }
}
