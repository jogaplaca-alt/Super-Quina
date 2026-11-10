package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f5602a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f5602a.values().iterator();
        while (it.hasNext()) {
            ((O) it.next()).a();
        }
        this.f5602a.clear();
    }

    public final O b(String str) {
        S1.k.e(str, "key");
        return (O) this.f5602a.get(str);
    }

    public final Set c() {
        return new HashSet(this.f5602a.keySet());
    }

    public final void d(String str, O o3) {
        S1.k.e(str, "key");
        S1.k.e(o3, "viewModel");
        O o4 = (O) this.f5602a.put(str, o3);
        if (o4 != null) {
            o4.d();
        }
    }
}
