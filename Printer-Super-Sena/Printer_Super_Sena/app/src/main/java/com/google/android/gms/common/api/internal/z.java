package com.google.android.gms.common.api.internal;

import C0.C0179a;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class z extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile boolean f7308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicReference f7309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f7310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final C0.h f7311e;

    z(E0.e eVar, C0.h hVar) {
        super(eVar);
        this.f7309c = new AtomicReference(null);
        this.f7310d = new M0.h(Looper.getMainLooper());
        this.f7311e = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(C0179a c0179a, int i3) {
        this.f7309c.set(null);
        m(c0179a, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.f7309c.set(null);
        n();
    }

    private static final int p(w wVar) {
        if (wVar == null) {
            return -1;
        }
        return wVar.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int i3, int i4, Intent intent) {
        w wVar = (w) this.f7309c.get();
        if (i3 != 1) {
            if (i3 == 2) {
                int iE = this.f7311e.e(b());
                if (iE == 0) {
                    o();
                    return;
                } else {
                    if (wVar == null) {
                        return;
                    }
                    if (wVar.b().c() == 18 && iE == 18) {
                        return;
                    }
                }
            }
        } else if (i4 == -1) {
            o();
            return;
        } else if (i4 == 0) {
            if (wVar != null) {
                l(new C0179a(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, wVar.b().toString()), p(wVar));
                return;
            }
            return;
        }
        if (wVar != null) {
            l(wVar.b(), wVar.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f7309c.set(bundle.getBoolean("resolving_error", false) ? new w(new C0179a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle) {
        super.i(bundle);
        w wVar = (w) this.f7309c.get();
        if (wVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", wVar.a());
        bundle.putInt("failed_status", wVar.b().c());
        bundle.putParcelable("failed_resolution", wVar.b().e());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f7308b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f7308b = false;
    }

    protected abstract void m(C0179a c0179a, int i3);

    protected abstract void n();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new C0179a(13, null), p((w) this.f7309c.get()));
    }

    public final void s(C0179a c0179a, int i3) {
        AtomicReference atomicReference;
        w wVar = new w(c0179a, i3);
        do {
            atomicReference = this.f7309c;
            if (E0.x.a(atomicReference, null, wVar)) {
                this.f7310d.post(new y(this, wVar));
                return;
            }
        } while (atomicReference.get() == null);
    }
}
