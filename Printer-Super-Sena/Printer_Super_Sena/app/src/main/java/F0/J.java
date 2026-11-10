package F0;

import C0.C0179a;
import android.app.PendingIntent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
abstract class J extends S {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractC0209c f851f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected J(AbstractC0209c abstractC0209c, int i3, Bundle bundle) {
        super(abstractC0209c, Boolean.TRUE);
        this.f851f = abstractC0209c;
        this.f849d = i3;
        this.f850e = bundle;
    }

    @Override // F0.S
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f849d != 0) {
            this.f851f.e0(1, null);
            Bundle bundle = this.f850e;
            f(new C0179a(this.f849d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f851f.e0(1, null);
            f(new C0179a(8, null));
        }
    }

    protected abstract void f(C0179a c0179a);

    protected abstract boolean g();

    @Override // F0.S
    protected final void b() {
    }
}
