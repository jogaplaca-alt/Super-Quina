package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
final class x extends E0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Dialog f7304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f7305b;

    x(y yVar, Dialog dialog) {
        this.f7305b = yVar;
        this.f7304a = dialog;
    }

    @Override // E0.o
    public final void a() {
        this.f7305b.f7307b.o();
        if (this.f7304a.isShowing()) {
            this.f7304a.dismiss();
        }
    }
}
