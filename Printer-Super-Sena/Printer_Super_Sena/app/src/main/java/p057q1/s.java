package p057q1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
final class s implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f10573a;

    /* synthetic */ s(t tVar, r rVar) {
        this.f10573a = tVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10573a.f10576b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f10573a.c().post(new p(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f10573a.f10576b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f10573a.c().post(new q(this));
    }
}
