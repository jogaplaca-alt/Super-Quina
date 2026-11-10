package F0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        C0222p c0222p = null;
        int[] iArrB = null;
        int[] iArrB2 = null;
        boolean zJ = false;
        boolean zJ2 = false;
        int iM = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            switch (G0.b.i(iK)) {
                case 1:
                    c0222p = (C0222p) G0.b.c(parcel, iK, C0222p.CREATOR);
                    break;
                case 2:
                    zJ = G0.b.j(parcel, iK);
                    break;
                case 3:
                    zJ2 = G0.b.j(parcel, iK);
                    break;
                case 4:
                    iArrB = G0.b.b(parcel, iK);
                    break;
                case 5:
                    iM = G0.b.m(parcel, iK);
                    break;
                case 6:
                    iArrB2 = G0.b.b(parcel, iK);
                    break;
                default:
                    G0.b.p(parcel, iK);
                    break;
            }
        }
        G0.b.h(parcel, iQ);
        return new C0211e(c0222p, zJ, zJ2, iArrB, iM, iArrB2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0211e[i3];
    }
}
