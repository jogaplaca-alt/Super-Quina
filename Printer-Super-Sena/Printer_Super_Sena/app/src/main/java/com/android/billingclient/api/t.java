package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7160a;

    /* synthetic */ t(p038k0.y yVar) {
    }

    public final t a() {
        this.f7160a = true;
        return this;
    }

    public final u b() {
        if (this.f7160a) {
            return new u(true, false, null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
