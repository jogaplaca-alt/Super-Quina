package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0353k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0353k f5614a = new C0353k();

    /* JADX INFO: renamed from: androidx.lifecycle.k$a */
    public static final class a implements Y.d.a {
        @Override // Y.d.a
        public void a(Y.f fVar) {
            S1.k.e(fVar, "owner");
            if (!(fVar instanceof U)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            T viewModelStore = ((U) fVar).getViewModelStore();
            Y.d savedStateRegistry = fVar.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                O oB = viewModelStore.b((String) it.next());
                S1.k.b(oB);
                C0353k.a(oB, savedStateRegistry, fVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.k$b */
    public static final class b implements InterfaceC0356n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0354l f5615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y.d f5616b;

        b(AbstractC0354l abstractC0354l, Y.d dVar) {
            this.f5615a = abstractC0354l;
            this.f5616b = dVar;
        }

        @Override // androidx.lifecycle.InterfaceC0356n
        public void d(InterfaceC0358p interfaceC0358p, AbstractC0354l.a aVar) {
            S1.k.e(interfaceC0358p, "source");
            S1.k.e(aVar, "event");
            if (aVar == AbstractC0354l.a.ON_START) {
                this.f5615a.c(this);
                this.f5616b.i(a.class);
            }
        }
    }

    private C0353k() {
    }

    public static final void a(O o3, Y.d dVar, AbstractC0354l abstractC0354l) {
        S1.k.e(o3, "viewModel");
        S1.k.e(dVar, "registry");
        S1.k.e(abstractC0354l, "lifecycle");
        H h3 = (H) o3.c("androidx.lifecycle.savedstate.vm.tag");
        if (h3 == null || h3.j()) {
            return;
        }
        h3.h(dVar, abstractC0354l);
        f5614a.c(dVar, abstractC0354l);
    }

    public static final H b(Y.d dVar, AbstractC0354l abstractC0354l, String str, Bundle bundle) {
        S1.k.e(dVar, "registry");
        S1.k.e(abstractC0354l, "lifecycle");
        S1.k.b(str);
        H h3 = new H(str, F.f5560f.a(dVar.b(str), bundle));
        h3.h(dVar, abstractC0354l);
        f5614a.c(dVar, abstractC0354l);
        return h3;
    }

    private final void c(Y.d dVar, AbstractC0354l abstractC0354l) {
        AbstractC0354l.b bVarB = abstractC0354l.b();
        if (bVarB == AbstractC0354l.b.INITIALIZED || bVarB.b(AbstractC0354l.b.STARTED)) {
            dVar.i(a.class);
        } else {
            abstractC0354l.a(new b(abstractC0354l, dVar));
        }
    }
}
