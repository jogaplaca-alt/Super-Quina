package com.google.android.gms.common.api.internal;

import C0.C0179a;
import E0.C0184b;
import F0.AbstractC0209c;
import F0.InterfaceC0215i;
import android.util.Log;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class o implements AbstractC0209c.InterfaceC0011c, E0.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0.a.f f7281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0184b f7282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0215i f7283c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set f7284d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f7285e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ b f7286f;

    public o(b bVar, D0.a.f fVar, C0184b c0184b) {
        this.f7286f = bVar;
        this.f7281a = fVar;
        this.f7282b = c0184b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        InterfaceC0215i interfaceC0215i;
        if (!this.f7285e || (interfaceC0215i = this.f7283c) == null) {
            return;
        }
        this.f7281a.m(interfaceC0215i, this.f7284d);
    }

    @Override // E0.u
    public final void a(InterfaceC0215i interfaceC0215i, Set set) {
        if (interfaceC0215i == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new C0179a(4));
        } else {
            this.f7283c = interfaceC0215i;
            this.f7284d = set;
            i();
        }
    }

    @Override // E0.u
    public final void b(C0179a c0179a) {
        l lVar = (l) this.f7286f.f7239j.get(this.f7282b);
        if (lVar != null) {
            lVar.I(c0179a);
        }
    }

    @Override // F0.AbstractC0209c.InterfaceC0011c
    public final void c(C0179a c0179a) {
        this.f7286f.f7243n.post(new n(this, c0179a));
    }

    @Override // E0.u
    public final void d(int i3) {
        l lVar = (l) this.f7286f.f7239j.get(this.f7282b);
        if (lVar != null) {
            if (lVar.f7272k) {
                lVar.I(new C0179a(17));
            } else {
                lVar.c(i3);
            }
        }
    }
}
