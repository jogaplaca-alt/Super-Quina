package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class g implements a.InterfaceC0102a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f7258a;

    g(b bVar) {
        this.f7258a = bVar;
    }

    @Override // com.google.android.gms.common.api.internal.a.InterfaceC0102a
    public final void a(boolean z3) {
        b bVar = this.f7258a;
        bVar.f7243n.sendMessage(bVar.f7243n.obtainMessage(1, Boolean.valueOf(z3)));
    }
}
