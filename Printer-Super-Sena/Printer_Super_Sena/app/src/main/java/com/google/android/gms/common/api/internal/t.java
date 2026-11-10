package com.google.android.gms.common.api.internal;

import C0.C0181c;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class t extends E0.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f7298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final R0.e f7299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final E0.j f7300d;

    public t(int i3, c cVar, R0.e eVar, E0.j jVar) {
        super(i3);
        this.f7299c = eVar;
        this.f7298b = cVar;
        this.f7300d = jVar;
        if (i3 == 2 && cVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void a(Status status) {
        this.f7299c.c(this.f7300d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(Exception exc) {
        this.f7299c.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(l lVar) throws DeadObjectException {
        try {
            this.f7298b.b(lVar.v(), this.f7299c);
        } catch (DeadObjectException e3) {
            throw e3;
        } catch (RemoteException e4) {
            a(v.e(e4));
        } catch (RuntimeException e5) {
            this.f7299c.c(e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void d(e eVar, boolean z3) {
        eVar.b(this.f7299c, z3);
    }

    @Override // E0.q
    public final boolean f(l lVar) {
        return this.f7298b.c();
    }

    @Override // E0.q
    public final C0181c[] g(l lVar) {
        return this.f7298b.e();
    }
}
