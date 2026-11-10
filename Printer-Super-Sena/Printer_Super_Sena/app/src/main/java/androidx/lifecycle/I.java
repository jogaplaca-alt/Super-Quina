package androidx.lifecycle;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final T.a.b f5571a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final T.a.b f5572b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final T.a.b f5573c = new a();

    public static final class a implements T.a.b {
        a() {
        }
    }

    public static final class b implements T.a.b {
        b() {
        }
    }

    public static final class c implements T.a.b {
        c() {
        }
    }

    public static final class d implements P.b {
        d() {
        }

        @Override // androidx.lifecycle.P.b
        public /* synthetic */ O a(Class cls) {
            return Q.a(this, cls);
        }

        @Override // androidx.lifecycle.P.b
        public O b(Class cls, T.a aVar) {
            S1.k.e(cls, "modelClass");
            S1.k.e(aVar, "extras");
            return new K();
        }
    }

    public static final F a(T.a aVar) {
        S1.k.e(aVar, "<this>");
        Y.f fVar = (Y.f) aVar.a(f5571a);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        U u3 = (U) aVar.a(f5572b);
        if (u3 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f5573c);
        String str = (String) aVar.a(P.c.f5600c);
        if (str != null) {
            return b(fVar, u3, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final F b(Y.f fVar, U u3, String str, Bundle bundle) {
        J jD = d(fVar);
        K kE = e(u3);
        F f3 = (F) kE.f().get(str);
        if (f3 != null) {
            return f3;
        }
        F fA = F.f5560f.a(jD.b(str), bundle);
        kE.f().put(str, fA);
        return fA;
    }

    public static final void c(Y.f fVar) {
        S1.k.e(fVar, "<this>");
        AbstractC0354l.b bVarB = fVar.getLifecycle().b();
        if (bVarB != AbstractC0354l.b.INITIALIZED && bVarB != AbstractC0354l.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            J j3 = new J(fVar.getSavedStateRegistry(), (U) fVar);
            fVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", j3);
            fVar.getLifecycle().a(new G(j3));
        }
    }

    public static final J d(Y.f fVar) {
        S1.k.e(fVar, "<this>");
        Y.d.c cVarC = fVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        J j3 = cVarC instanceof J ? (J) cVarC : null;
        if (j3 != null) {
            return j3;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final K e(U u3) {
        S1.k.e(u3, "<this>");
        return (K) new P(u3, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", K.class);
    }
}
