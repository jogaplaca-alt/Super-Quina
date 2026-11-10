package Y;

import S1.k;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0354l;
import androidx.lifecycle.InterfaceC0356n;
import androidx.lifecycle.InterfaceC0358p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f2111g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f2114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Y.b.C0031b f2116e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p034j.b f2112a = new p034j.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2117f = true;

    public interface a {
        void a(f fVar);
    }

    private static final class b {
        public /* synthetic */ b(S1.g gVar) {
            this();
        }

        private b() {
        }
    }

    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d dVar, InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
        k.e(dVar, "this$0");
        k.e(interfaceC0358p, "<anonymous parameter 0>");
        k.e(aVar, "event");
        if (aVar == AbstractC0354l.a.ON_START) {
            dVar.f2117f = true;
        } else if (aVar == AbstractC0354l.a.ON_STOP) {
            dVar.f2117f = false;
        }
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (!this.f2115d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2114c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f2114c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f2114c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f2114c = null;
        }
        return bundle2;
    }

    public final c c(String str) {
        k.e(str, "key");
        for (Map.Entry entry : this.f2112a) {
            k.d(entry, "components");
            String str2 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            if (k.a(str2, str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC0354l abstractC0354l) {
        k.e(abstractC0354l, "lifecycle");
        if (this.f2113b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        abstractC0354l.a(new InterfaceC0356n() { // from class: Y.c
            @Override // androidx.lifecycle.InterfaceC0356n
            public final void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
                d.d(this.f2110a, interfaceC0358p, aVar);
            }
        });
        this.f2113b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f2113b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f2115d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f2114c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f2115d = true;
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2114c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        j.b.d dVarM = this.f2112a.m();
        k.d(dVarM, "this.components.iteratorWithAdditions()");
        while (dVarM.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarM.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        k.e(str, "key");
        k.e(cVar, "provider");
        if (((c) this.f2112a.p(str, cVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class cls) {
        k.e(cls, "clazz");
        if (!this.f2117f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Y.b.C0031b c0031b = this.f2116e;
        if (c0031b == null) {
            c0031b = new Y.b.C0031b(this);
        }
        this.f2116e = c0031b;
        try {
            cls.getDeclaredConstructor(null);
            Y.b.C0031b c0031b2 = this.f2116e;
            if (c0031b2 != null) {
                String name = cls.getName();
                k.d(name, "clazz.name");
                c0031b2.b(name);
            }
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }
}
