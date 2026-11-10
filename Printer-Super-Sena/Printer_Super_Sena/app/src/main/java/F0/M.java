package F0;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
final class M implements InterfaceC0217k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f852c;

    M(IBinder iBinder) {
        this.f852c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f852c;
    }

    @Override // F0.InterfaceC0217k
    public final void o(InterfaceC0216j interfaceC0216j, C0212f c0212f) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC0216j != null ? interfaceC0216j.asBinder() : null);
            if (c0212f != null) {
                parcelObtain.writeInt(1);
                a0.a(c0212f, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f852c.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
