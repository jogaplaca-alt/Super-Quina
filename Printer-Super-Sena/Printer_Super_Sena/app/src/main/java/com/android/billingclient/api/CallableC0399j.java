package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0439k;
import java.util.concurrent.Callable;
import p038k0.InterfaceC0516g;

/* JADX INFO: renamed from: com.android.billingclient.api.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class CallableC0399j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InterfaceC0516g f7111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0391b f7112c;

    CallableC0399j(C0391b c0391b, String str, InterfaceC0516g interfaceC0516g) {
        this.f7110a = str;
        this.f7111b = interfaceC0516g;
        this.f7112c = c0391b;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        p038k0.A aG = C0391b.G(this.f7112c, this.f7110a, 9);
        if (aG.b() != null) {
            this.f7111b.a(aG.a(), aG.b());
            return null;
        }
        this.f7111b.a(aG.a(), AbstractC0439k.s());
        return null;
    }
}
