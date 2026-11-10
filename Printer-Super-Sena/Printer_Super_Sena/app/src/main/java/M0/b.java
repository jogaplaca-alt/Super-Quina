package M0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements IInterface {
    protected b(String str) {
        attachInterface(this, str);
    }

    protected abstract boolean Q(int i3, Parcel parcel, Parcel parcel2, int i4);

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i3, parcel, parcel2, i4)) {
            return true;
        }
        return Q(i3, parcel, parcel2, i4);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
