package H0;

import C0.C0181c;
import E0.h;
import F0.AbstractC0213g;
import F0.C0210d;
import F0.C0225t;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC0213g {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final C0225t f1082I;

    public e(Context context, Looper looper, C0210d c0210d, C0225t c0225t, E0.c cVar, h hVar) {
        super(context, looper, 270, c0210d, cVar, hVar);
        this.f1082I = c0225t;
    }

    @Override // F0.AbstractC0209c
    protected final String B() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // F0.AbstractC0209c
    protected final String C() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // F0.AbstractC0209c
    protected final boolean F() {
        return true;
    }

    @Override // F0.AbstractC0209c, D0.a.f
    public final int n() {
        return 203400000;
    }

    @Override // F0.AbstractC0209c
    protected final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // F0.AbstractC0209c
    public final C0181c[] s() {
        return M0.d.f1293b;
    }

    @Override // F0.AbstractC0209c
    protected final Bundle x() {
        return this.f1082I.b();
    }
}
