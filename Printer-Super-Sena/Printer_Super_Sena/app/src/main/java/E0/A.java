package E0;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: loaded from: classes.dex */
final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ B f212c;

    A(B b3, LifecycleCallback lifecycleCallback, String str) {
        this.f212c = b3;
        this.f210a = lifecycleCallback;
        this.f211b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        B b3 = this.f212c;
        if (b3.f215c0 > 0) {
            LifecycleCallback lifecycleCallback = this.f210a;
            if (b3.f216d0 != null) {
                bundle = b3.f216d0.getBundle(this.f211b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f212c.f215c0 >= 2) {
            this.f210a.j();
        }
        if (this.f212c.f215c0 >= 3) {
            this.f210a.h();
        }
        if (this.f212c.f215c0 >= 4) {
            this.f210a.k();
        }
        if (this.f212c.f215c0 >= 5) {
            this.f210a.g();
        }
    }
}
