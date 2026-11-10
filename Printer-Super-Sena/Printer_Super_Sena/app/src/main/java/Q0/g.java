package Q0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class g extends M0.a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void Q(j jVar, f fVar) {
        Parcel parcelC = c();
        M0.c.c(parcelC, jVar);
        M0.c.d(parcelC, fVar);
        d(12, parcelC);
    }
}
