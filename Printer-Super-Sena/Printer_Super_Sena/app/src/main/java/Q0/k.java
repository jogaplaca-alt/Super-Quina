package Q0;

import F0.F;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        F f3 = null;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 != 2) {
                G0.b.p(parcel, iK);
            } else {
                f3 = (F) G0.b.c(parcel, iK, F.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new j(iM, f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new j[i3];
    }
}
