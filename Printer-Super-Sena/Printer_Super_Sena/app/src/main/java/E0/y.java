package E0;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: loaded from: classes.dex */
final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ z f243c;

    y(z zVar, LifecycleCallback lifecycleCallback, String str) {
        this.f243c = zVar;
        this.f241a = lifecycleCallback;
        this.f242b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        z zVar = this.f243c;
        if (zVar.f246b > 0) {
            LifecycleCallback lifecycleCallback = this.f241a;
            if (zVar.f247c != null) {
                bundle = zVar.f247c.getBundle(this.f242b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f243c.f246b >= 2) {
            this.f241a.j();
        }
        if (this.f243c.f246b >= 3) {
            this.f241a.h();
        }
        if (this.f243c.f246b >= 4) {
            this.f241a.k();
        }
        if (this.f243c.f246b >= 5) {
            this.f241a.g();
        }
    }
}
