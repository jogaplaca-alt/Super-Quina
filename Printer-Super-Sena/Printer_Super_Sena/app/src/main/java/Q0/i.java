package Q0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        ArrayList arrayListE = null;
        String strD = null;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                arrayListE = G0.b.e(parcel, iK);
            } else if (i3 != 2) {
                G0.b.p(parcel, iK);
            } else {
                strD = G0.b.d(parcel, iK);
            }
        }
        G0.b.h(parcel, iQ);
        return new h(arrayListE, strD);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new h[i3];
    }
}
