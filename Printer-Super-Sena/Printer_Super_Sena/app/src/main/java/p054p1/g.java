package p054p1;

import R0.e;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
final class g extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f10493a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(h hVar, Handler handler, e eVar) {
        super(handler);
        this.f10493a = eVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        this.f10493a.d(null);
    }
}
