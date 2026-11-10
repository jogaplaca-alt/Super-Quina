package com.google.android.gms.common.api.internal;

import C0.C0179a;
import E0.C0184b;
import F0.AbstractC0220n;
import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public final class f extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p046n.b f7256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f7257g;

    f(E0.e eVar, b bVar, C0.h hVar) {
        super(eVar, hVar);
        this.f7256f = new p046n.b();
        this.f7257g = bVar;
        this.f7220a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, b bVar, C0184b c0184b) {
        E0.e eVarD = LifecycleCallback.d(activity);
        f fVar = (f) eVarD.c("ConnectionlessLifecycleHelper", f.class);
        if (fVar == null) {
            fVar = new f(eVarD, bVar, C0.h.k());
        }
        AbstractC0220n.g(c0184b, "ApiKey cannot be null");
        fVar.f7256f.add(c0184b);
        bVar.a(fVar);
    }

    private final void v() {
        if (this.f7256f.isEmpty()) {
            return;
        }
        this.f7257g.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.z, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.z, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        this.f7257g.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.z
    protected final void m(C0179a c0179a, int i3) {
        this.f7257g.B(c0179a, i3);
    }

    @Override // com.google.android.gms.common.api.internal.z
    protected final void n() {
        this.f7257g.C();
    }

    final p046n.b t() {
        return this.f7256f;
    }
}
