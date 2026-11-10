package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class J implements Y.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Y.d f5574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f5576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final J1.c f5577d;

    static final class a extends S1.l implements R1.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ U f5578b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(U u3) {
            super(0);
            this.f5578b = u3;
        }

        @Override // R1.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final K a() {
            return I.e(this.f5578b);
        }
    }

    public J(Y.d dVar, U u3) {
        S1.k.e(dVar, "savedStateRegistry");
        S1.k.e(u3, "viewModelStoreOwner");
        this.f5574a = dVar;
        this.f5577d = J1.d.a(new a(u3));
    }

    private final K c() {
        return (K) this.f5577d.getValue();
    }

    @Override // Y.d.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f5576c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((F) entry.getValue()).c().a();
            if (!S1.k.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f5575b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        S1.k.e(str, "key");
        d();
        Bundle bundle = this.f5576c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f5576c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f5576c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f5576c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f5575b) {
            return;
        }
        Bundle bundleB = this.f5574a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f5576c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f5576c = bundle;
        this.f5575b = true;
        c();
    }
}
