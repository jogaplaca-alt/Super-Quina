package E0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class p extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f226b;

    public p(o oVar) {
        this.f226b = oVar;
    }

    public final void a(Context context) {
        this.f225a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f225a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f225a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f226b.a();
            b();
        }
    }
}
