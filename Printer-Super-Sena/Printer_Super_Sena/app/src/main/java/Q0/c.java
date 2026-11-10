package Q0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        Intent intent = null;
        int iM = 0;
        int iM2 = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                iM2 = G0.b.m(parcel, iK);
            } else if (i3 != 3) {
                G0.b.p(parcel, iK);
            } else {
                intent = (Intent) G0.b.c(parcel, iK, Intent.CREATOR);
            }
        }
        G0.b.h(parcel, iQ);
        return new b(iM, iM2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new b[i3];
    }
}
