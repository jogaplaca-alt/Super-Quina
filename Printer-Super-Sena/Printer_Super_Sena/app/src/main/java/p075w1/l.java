package p075w1;

import java.util.Set;
import p081y1.h;

/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f12684a = new h(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f12684a.equals(this.f12684a));
    }

    public int hashCode() {
        return this.f12684a.hashCode();
    }

    public void q(String str, i iVar) {
        h hVar = this.f12684a;
        if (iVar == null) {
            iVar = k.f12683a;
        }
        hVar.put(str, iVar);
    }

    public Set r() {
        return this.f12684a.entrySet();
    }

    public i s(String str) {
        return (i) this.f12684a.get(str);
    }
}
