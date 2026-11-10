package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        String strD = null;
        String strD2 = null;
        long jN = 0;
        long jN2 = 0;
        int iM = 0;
        int iM2 = 0;
        int iM3 = 0;
        int iM4 = 0;
        int iM5 = -1;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            switch (G0.b.i(iK)) {
                case 1:
                    iM = G0.b.m(parcel, iK);
                    break;
                case 2:
                    iM2 = G0.b.m(parcel, iK);
                    break;
                case 3:
                    iM3 = G0.b.m(parcel, iK);
                    break;
                case 4:
                    jN = G0.b.n(parcel, iK);
                    break;
                case 5:
                    jN2 = G0.b.n(parcel, iK);
                    break;
                case 6:
                    strD = G0.b.d(parcel, iK);
                    break;
                case 7:
                    strD2 = G0.b.d(parcel, iK);
                    break;
                case 8:
                    iM4 = G0.b.m(parcel, iK);
                    break;
                case 9:
                    iM5 = G0.b.m(parcel, iK);
                    break;
                default:
                    G0.b.p(parcel, iK);
                    break;
            }
        }
        G0.b.h(parcel, iQ);
        return new C0218l(iM, iM2, iM3, jN, jN2, strD, strD2, iM4, iM5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0218l[i3];
    }
}
