package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set f4830a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f4831b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f4832c = new CopyOnWriteArrayList();

    private boolean e() {
        boolean z3 = false;
        for (String str : this.f4832c) {
            try {
                Class<?> cls = Class.forName(str);
                if (d.class.isAssignableFrom(cls)) {
                    d((d) cls.newInstance());
                    this.f4832c.remove(str);
                    z3 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e3) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e3);
            } catch (InstantiationException e4) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e4);
            }
        }
        return z3;
    }

    @Override // androidx.databinding.d
    public h b(e eVar, View view, int i3) {
        Iterator it = this.f4831b.iterator();
        while (it.hasNext()) {
            h hVarB = ((d) it.next()).b(eVar, view, i3);
            if (hVarB != null) {
                return hVarB;
            }
        }
        if (e()) {
            return b(eVar, view, i3);
        }
        return null;
    }

    @Override // androidx.databinding.d
    public h c(e eVar, View[] viewArr, int i3) {
        Iterator it = this.f4831b.iterator();
        while (it.hasNext()) {
            h hVarC = ((d) it.next()).c(eVar, viewArr, i3);
            if (hVarC != null) {
                return hVarC;
            }
        }
        if (e()) {
            return c(eVar, viewArr, i3);
        }
        return null;
    }

    public void d(d dVar) {
        if (this.f4830a.add(dVar.getClass())) {
            this.f4831b.add(dVar);
            Iterator it = dVar.a().iterator();
            while (it.hasNext()) {
                d((d) it.next());
            }
        }
    }
}
