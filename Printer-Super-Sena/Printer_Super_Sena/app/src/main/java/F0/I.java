package F0;

import C0.C0179a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        IBinder iBinderL = null;
        C0179a c0179a = null;
        int iM = 0;
        boolean zJ = false;
        boolean zJ2 = false;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                iBinderL = G0.b.l(parcel, iK);
            } else if (i3 == 3) {
                c0179a = (C0179a) G0.b.c(parcel, iK, C0179a.CREATOR);
            } else if (i3 == 4) {
                zJ = G0.b.j(parcel, iK);
            } else if (i3 != 5) {
                G0.b.p(parcel, iK);
            } else {
                zJ2 = G0.b.j(parcel, iK);
            }
        }
        G0.b.h(parcel, iQ);
        return new H(iM, iBinderL, c0179a, zJ, zJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new H[i3];
    }
}
