package M0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f1289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1290d;

    protected a(IBinder iBinder, String str) {
        this.f1289c = iBinder;
        this.f1290d = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1289c;
    }

    protected final Parcel c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1290d);
        return parcelObtain;
    }

    protected final void d(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f1289c.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void e(int i3, Parcel parcel) {
        try {
            this.f1289c.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
