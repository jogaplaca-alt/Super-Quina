package C0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iQ = G0.b.q(parcel);
        PendingIntent pendingIntent = null;
        String strD = null;
        int iM = 0;
        int iM2 = 0;
        while (parcel.dataPosition() < iQ) {
            int iK = G0.b.k(parcel);
            int i3 = G0.b.i(iK);
            if (i3 == 1) {
                iM = G0.b.m(parcel, iK);
            } else if (i3 == 2) {
                iM2 = G0.b.m(parcel, iK);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) G0.b.c(parcel, iK, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                G0.b.p(parcel, iK);
            } else {
                strD = G0.b.d(parcel, iK);
            }
        }
        G0.b.h(parcel, iQ);
        return new C0179a(iM, iM2, pendingIntent, strD);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new C0179a[i3];
    }
}
