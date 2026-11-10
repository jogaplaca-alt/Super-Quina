package F0;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 extends N0.b implements K {
    public k0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // N0.b
    protected final boolean c(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            L0.a aVarW = w();
            parcel2.writeNoException();
            N0.c.c(parcel2, aVarW);
        } else {
            if (i3 != 2) {
                return false;
            }
            int iB = b();
            parcel2.writeNoException();
            parcel2.writeInt(iB);
        }
        return true;
    }
}
