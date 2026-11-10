package Q0;

import C0.C0179a;
import F0.H;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        C0179a c0179a = null;
        H h3 = null;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                c0179a = (C0179a) G0.b.c(parcel, iK, C0179a.CREATOR);
            } else if (i3 != 3) {
                G0.b.p(parcel, iK);
            } else {
                h3 = (H) G0.b.c(parcel, iK, H.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new l(iM, c0179a, h3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new l[i3];
    }
}
