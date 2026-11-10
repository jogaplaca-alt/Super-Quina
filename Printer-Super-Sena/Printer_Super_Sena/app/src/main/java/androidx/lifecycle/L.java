package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class L extends P.d implements P.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final P.b f5581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f5582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0354l f5583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Y.d f5584e;

    public L(Application application, Y.f fVar, Bundle bundle) {
        S1.k.e(fVar, "owner");
        this.f5584e = fVar.getSavedStateRegistry();
        this.f5583d = fVar.getLifecycle();
        this.f5582c = bundle;
        this.f5580a = application;
        this.f5581b = application != null ? P.a.f5593e.b(application) : new P.a();
    }

    @Override // androidx.lifecycle.P.b
    public O a(Class cls) {
        S1.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.P.b
    public O b(Class cls, T.a aVar) {
        S1.k.e(cls, "modelClass");
        S1.k.e(aVar, "extras");
        String str = (String) aVar.a(P.c.f5600c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (aVar.a(I.f5571a) == null || aVar.a(I.f5572b) == null) {
            if (this.f5583d != null) {
                return d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) aVar.a(P.a.f5595g);
        boolean zIsAssignableFrom = AbstractC0343a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? M.c(cls, M.f5586b) : M.c(cls, M.f5585a);
        if (constructorC == null) {
            return this.f5581b.b(cls, aVar);
        }
        return (!zIsAssignableFrom || application == null) ? M.d(cls, constructorC, I.a(aVar)) : M.d(cls, constructorC, application, I.a(aVar));
    }

    @Override // androidx.lifecycle.P.d
    public void c(O o3) {
        S1.k.e(o3, "viewModel");
        if (this.f5583d != null) {
            Y.d dVar = this.f5584e;
            S1.k.b(dVar);
            AbstractC0354l abstractC0354l = this.f5583d;
            S1.k.b(abstractC0354l);
            C0353k.a(o3, dVar, abstractC0354l);
        }
    }

    public final O d(String str, Class cls) {
        O oD;
        Application application;
        S1.k.e(str, "key");
        S1.k.e(cls, "modelClass");
        AbstractC0354l abstractC0354l = this.f5583d;
        if (abstractC0354l == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0343a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.f5580a == null) ? M.c(cls, M.f5586b) : M.c(cls, M.f5585a);
        if (constructorC == null) {
            return this.f5580a != null ? this.f5581b.a(cls) : P.c.f5598a.a().a(cls);
        }
        Y.d dVar = this.f5584e;
        S1.k.b(dVar);
        H hB = C0353k.b(dVar, abstractC0354l, str, this.f5582c);
        if (!zIsAssignableFrom || (application = this.f5580a) == null) {
            oD = M.d(cls, constructorC, hB.i());
        } else {
            S1.k.b(application);
            oD = M.d(cls, constructorC, application, hB.i());
        }
        oD.e("androidx.lifecycle.savedstate.vm.tag", hB);
        return oD;
    }
}
