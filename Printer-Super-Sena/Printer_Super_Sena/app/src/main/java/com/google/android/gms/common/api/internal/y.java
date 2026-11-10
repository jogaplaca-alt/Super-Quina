package com.google.android.gms.common.api.internal;

import C0.C0179a;
import F0.AbstractC0220n;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f7306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f7307b;

    y(z zVar, w wVar) {
        this.f7307b = zVar;
        this.f7306a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7307b.f7308b) {
            C0179a c0179aB = this.f7306a.b();
            if (c0179aB.f()) {
                z zVar = this.f7307b;
                zVar.f7220a.startActivityForResult(GoogleApiActivity.a(zVar.b(), (PendingIntent) AbstractC0220n.f(c0179aB.e()), this.f7306a.a(), false), 1);
                return;
            }
            z zVar2 = this.f7307b;
            if (zVar2.f7311e.a(zVar2.b(), c0179aB.c(), null) != null) {
                z zVar3 = this.f7307b;
                zVar3.f7311e.t(zVar3.b(), zVar3.f7220a, c0179aB.c(), 2, this.f7307b);
                return;
            }
            if (c0179aB.c() != 18) {
                this.f7307b.l(c0179aB, this.f7306a.a());
                return;
            }
            z zVar4 = this.f7307b;
            Dialog dialogO = zVar4.f7311e.o(zVar4.b(), zVar4);
            z zVar5 = this.f7307b;
            zVar5.f7311e.p(zVar5.b().getApplicationContext(), new x(this, dialogO));
        }
    }
}
