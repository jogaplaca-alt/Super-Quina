package Y;

import S1.k;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0356n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2107b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f2108a;

    public static final class a {
        public /* synthetic */ a(S1.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: Y.b$b, reason: collision with other inner class name */
    public static final class C0031b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f2109a;

        public C0031b(d dVar) {
            k.e(dVar, "registry");
            this.f2109a = new LinkedHashSet();
            dVar.h("androidx.savedstate.Restarter", this);
        }

        @Override // Y.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f2109a));
            return bundle;
        }

        public final void b(String str) {
            k.e(str, "className");
            this.f2109a.add(str);
        }
    }

    public b(f fVar) {
        k.e(fVar, "owner");
        this.f2108a = fVar;
    }

    private final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(d.a.class);
            k.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    k.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) objNewInstance).a(this.f2108a);
                } catch (Exception e3) {
                    throw new RuntimeException("Failed to instantiate " + str, e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Class " + str + " wasn't found", e5);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0356n
    public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        k.e(interfaceC0358p, "source");
        k.e(aVar, "event");
        if (aVar != AbstractC0354l.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0358p.getLifecycle().c(this);
        Bundle bundleB = this.f2108a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }
}
