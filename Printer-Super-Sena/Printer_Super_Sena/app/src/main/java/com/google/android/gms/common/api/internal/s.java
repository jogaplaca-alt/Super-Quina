package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class s extends E0.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final R0.e f7297b;

    public s(int i3, R0.e eVar) {
        super(i3);
        this.f7297b = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void a(Status status) {
        this.f7297b.c(new D0.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(Exception exc) {
        this.f7297b.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(l lVar) throws DeadObjectException {
        try {
            h(lVar);
        } catch (DeadObjectException e3) {
            a(v.e(e3));
            throw e3;
        } catch (RemoteException e4) {
            a(v.e(e4));
        } catch (RuntimeException e5) {
            this.f7297b.c(e5);
        }
    }

    protected abstract void h(l lVar);
}
