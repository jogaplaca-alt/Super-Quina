package F0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class L extends N0.b implements InterfaceC0216j {
    public L() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // N0.b
    protected final boolean c(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            int i5 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) N0.c.a(parcel, Bundle.CREATOR);
            N0.c.b(parcel);
            P(i5, strongBinder, bundle);
        } else if (i3 == 2) {
            int i6 = parcel.readInt();
            Bundle bundle2 = (Bundle) N0.c.a(parcel, Bundle.CREATOR);
            N0.c.b(parcel);
            m(i6, bundle2);
        } else {
            if (i3 != 3) {
                return false;
            }
            int i7 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            X x3 = (X) N0.c.a(parcel, X.CREATOR);
            N0.c.b(parcel);
            O(i7, strongBinder2, x3);
        }
        parcel2.writeNoException();
        return true;
    }
}
