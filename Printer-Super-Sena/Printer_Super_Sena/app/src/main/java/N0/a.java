package N0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f1366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1367d;

    protected a(IBinder iBinder, String str) {
        this.f1366c = iBinder;
        this.f1367d = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1366c;
    }

    protected final Parcel c(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f1366c.transact(i3, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e3) {
                parcelObtain.recycle();
                throw e3;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    protected final Parcel d() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1367d);
        return parcelObtain;
    }
}
