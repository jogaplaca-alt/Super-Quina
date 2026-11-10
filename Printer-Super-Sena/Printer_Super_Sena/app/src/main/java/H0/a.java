package H0;

import F0.C0223q;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class a extends M0.a implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void Q(C0223q c0223q) {
        Parcel parcelC = c();
        M0.c.c(parcelC, c0223q);
        e(1, parcelC);
    }
}
