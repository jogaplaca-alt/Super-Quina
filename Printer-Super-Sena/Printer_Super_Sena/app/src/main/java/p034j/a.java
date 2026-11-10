package p034j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f9683e = new HashMap();

    public boolean contains(Object obj) {
        return this.f9683e.containsKey(obj);
    }

    @Override // p034j.b
    protected b.c l(Object obj) {
        return (b.c) this.f9683e.get(obj);
    }

    @Override // p034j.b
    public Object p(Object obj, Object obj2) {
        b.c cVarL = l(obj);
        if (cVarL != null) {
            return cVarL.f9689b;
        }
        this.f9683e.put(obj, o(obj, obj2));
        return null;
    }

    @Override // p034j.b
    public Object q(Object obj) {
        Object objQ = super.q(obj);
        this.f9683e.remove(obj);
        return objQ;
    }

    public Map.Entry r(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f9683e.get(obj)).f9691d;
        }
        return null;
    }
}
