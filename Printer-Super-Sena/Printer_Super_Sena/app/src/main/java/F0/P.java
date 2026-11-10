package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class P implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        int iM = 0;
        boolean zJ = false;
        boolean zJ2 = false;
        int iM2 = 0;
        int iM3 = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                zJ = G0.b.j(parcel, iK);
            } else if (i3 == 3) {
                zJ2 = G0.b.j(parcel, iK);
            } else if (i3 == 4) {
                iM2 = G0.b.m(parcel, iK);
            } else if (i3 != 5) {
                G0.b.p(parcel, iK);
            } else {
                iM3 = G0.b.m(parcel, iK);
            }
        }
        G0.b.h(parcel, iQ);
        return new C0222p(iM, zJ, zJ2, iM2, iM3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0222p[i3];
    }
}
