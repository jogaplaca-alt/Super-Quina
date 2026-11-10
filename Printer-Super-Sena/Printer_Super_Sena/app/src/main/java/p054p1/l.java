package p054p1;

import R0.e;
import android.app.PendingIntent;
import android.os.Bundle;
import p057q1.i;

/* JADX INFO: loaded from: classes.dex */
final class l extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f10502f;

    l(m mVar, e eVar, String str) {
        super(mVar, new i("OnRequestInstallCallback"), eVar);
        this.f10502f = str;
    }

    @Override // p054p1.k, p057q1.h
    public final void D(Bundle bundle) {
        super.D(bundle);
        this.f10500d.d(new e((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
