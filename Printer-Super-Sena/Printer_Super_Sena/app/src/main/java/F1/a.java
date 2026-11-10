package F1;

import S1.k;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0338f;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f1006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f1008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f1009e;

    public a(c cVar, f fVar, boolean z3) {
        k.e(cVar, "formatter");
        k.e(fVar, "logger");
        this.f1008d = cVar;
        this.f1009e = fVar;
        this.f1005a = z3 ? new d(cVar, fVar) : null;
        this.f1006b = new HashMap();
    }

    private final void b(Activity activity) {
        Bundle bundle = (Bundle) this.f1006b.remove(activity);
        if (bundle != null) {
            try {
                this.f1009e.b(this.f1008d.a(activity, bundle));
            } catch (RuntimeException e3) {
                this.f1009e.a(e3);
            }
        }
    }

    public final boolean a() {
        return this.f1007c;
    }

    public final void c() {
        this.f1007c = true;
        d dVar = this.f1005a;
        if (dVar != null) {
            dVar.p();
        }
    }

    public final void d() {
        this.f1007c = false;
        this.f1006b.clear();
        d dVar = this.f1005a;
        if (dVar != null) {
            dVar.q();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        k.e(activity, "activity");
        if (!(activity instanceof AbstractActivityC0338f) || this.f1005a == null) {
            return;
        }
        ((AbstractActivityC0338f) activity).getSupportFragmentManager().Y0(this.f1005a, true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        k.e(activity, "activity");
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        k.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        k.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        k.e(activity, "activity");
        k.e(bundle, "outState");
        if (this.f1007c) {
            this.f1006b.put(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        k.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        k.e(activity, "activity");
        b(activity);
    }
}
