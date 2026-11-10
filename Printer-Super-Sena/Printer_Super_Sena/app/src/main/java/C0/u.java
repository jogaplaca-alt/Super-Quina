package C0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        long jN = -1;
        int iM = 0;
        String strD = null;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                strD = G0.b.d(parcel, iK);
            } else if (i3 == 2) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 != 3) {
                G0.b.p(parcel, iK);
            } else {
                jN = G0.b.n(parcel, iK);
            }
        }
        G0.b.h(parcel, iQ);
        return new C0181c(strD, iM, jN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0181c[i3];
    }
}
